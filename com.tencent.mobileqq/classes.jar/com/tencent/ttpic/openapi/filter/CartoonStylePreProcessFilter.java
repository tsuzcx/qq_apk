package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.UniformParam.Float4fParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.openapi.model.FaceStyleItem.CartoonFaceLine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CartoonStylePreProcessFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER = " precision highp float;\n varying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform int drawOrigin;\n uniform int drawMode;\n uniform lowp vec4 drawColor;\n void main(void) {\n    if (drawOrigin == 1) {\n        gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n    } else {\n        if (drawMode == 1) { // point\n            if (length(gl_PointCoord - vec2(0.5)) > 0.5) {\n                discard;\n            } else {\n                gl_FragColor = vec4(0.0, 0.0, 1.0, 1.0);\n            }\n        } else if (drawMode == 2) { // line\n            gl_FragColor = vec4(0.0, 0.0, 1.0, 1.0);\n        } else if (drawMode == 3) { // triangle\n            gl_FragColor = drawColor;\n        }\n    }\n }";
  public static final String VERTEX_SHADER = " attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n attribute float preferPointSize;\n varying vec2 textureCoordinate;\n void main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    gl_PointSize = preferPointSize;// 9.375 = 15*0.625\n }";
  int eye = 0;
  int eyeBorder = 0;
  int eyeCloseLine = 0;
  boolean[] eyeNeedDrawBk = { 0, 0 };
  float eye_center_shift_l = 0.0F;
  float eye_center_shift_r = 0.0F;
  int eyebrow = 0;
  int eyelash = 0;
  int face = 0;
  float lastFaceYaw = 0.0F;
  List<Float> lineVertexFloats = new ArrayList();
  private boolean mNoPoints = true;
  int mouth;
  float[] mouthFillColorRGBA;
  boolean needFillMouth = true;
  int nose = 0;
  int nostril = 0;
  List<Float> pointsSizeFloats = new ArrayList();
  List<Float> pointsVertexFloats = new ArrayList();
  float thickness = 2.0F;
  List<Float> triangleVertexFloats = new ArrayList();
  List<Float> triangleVertexLeftEyeFloats = new ArrayList();
  List<Float> triangleVertexRightEyeFloats = new ArrayList();
  
  public CartoonStylePreProcessFilter()
  {
    super(" attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n attribute float preferPointSize;\n varying vec2 textureCoordinate;\n void main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    gl_PointSize = preferPointSize;// 9.375 = 15*0.625\n }", " precision highp float;\n varying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform int drawOrigin;\n uniform int drawMode;\n uniform lowp vec4 drawColor;\n void main(void) {\n    if (drawOrigin == 1) {\n        gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n    } else {\n        if (drawMode == 1) { // point\n            if (length(gl_PointCoord - vec2(0.5)) > 0.5) {\n                discard;\n            } else {\n                gl_FragColor = vec4(0.0, 0.0, 1.0, 1.0);\n            }\n        } else if (drawMode == 2) { // line\n            gl_FragColor = vec4(0.0, 0.0, 1.0, 1.0);\n        } else if (drawMode == 3) { // triangle\n            gl_FragColor = drawColor;\n        }\n    }\n }");
  }
  
  private double DistanceFromPoint2fToPoint2f(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF1.x - paramPointF2.x;
    float f2 = paramPointF1.y - paramPointF2.y;
    return Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private void drawLineToListFromP1AndP2(PointF paramPointF1, PointF paramPointF2)
  {
    this.lineVertexFloats.add(Float.valueOf(paramPointF1.x * 2.0F / this.width - 1.0F));
    this.lineVertexFloats.add(Float.valueOf(paramPointF1.y * 2.0F / this.height - 1.0F));
    this.lineVertexFloats.add(Float.valueOf(paramPointF2.x * 2.0F / this.width - 1.0F));
    this.lineVertexFloats.add(Float.valueOf(paramPointF2.y * 2.0F / this.height - 1.0F));
  }
  
  private void getCartoonFacePoints2(List<PointF> paramList, int paramInt1, int paramInt2, float paramFloat)
  {
    float f3 = 0.0039063F * paramInt1;
    this.thickness = 2.0F;
    this.thickness *= f3;
    int i;
    if (this.face == 0)
    {
      i = 1;
      while (i < 17)
      {
        drawLineToListFromP1AndP2((PointF)paramList.get(i), (PointF)paramList.get(i + 1));
        i += 1;
      }
    }
    if (this.face == 1)
    {
      i = 0;
      while (i < 18)
      {
        drawLineToListFromP1AndP2((PointF)paramList.get(i), (PointF)paramList.get(i + 1));
        i += 1;
      }
    }
    Object localObject;
    if (this.eyebrow == 0)
    {
      localObject = new PointF[3];
      i = 20;
      while (i < 23)
      {
        localObject[(i - 20)] = getMiddleByP1AndP2((PointF)paramList.get(i), (PointF)paramList.get(46 - i));
        i += 1;
      }
      drawLineToListFromP1AndP2(localObject[0], localObject[1]);
      drawLineToListFromP1AndP2(localObject[1], localObject[2]);
      drawLineToListFromP1AndP2(localObject[2], (PointF)paramList.get(23));
      i = 28;
      while (i < 31)
      {
        localObject[(i - 28)] = getMiddleByP1AndP2((PointF)paramList.get(i), (PointF)paramList.get(62 - i));
        i += 1;
      }
      drawLineToListFromP1AndP2(localObject[0], localObject[1]);
      drawLineToListFromP1AndP2(localObject[1], localObject[2]);
      drawLineToListFromP1AndP2(localObject[2], (PointF)paramList.get(31));
    }
    float f1;
    if (this.lastFaceYaw * paramFloat <= 0.0F) {
      if (Math.abs(paramFloat - this.lastFaceYaw) > 2.2F) {
        f1 = paramFloat;
      }
    }
    for (;;)
    {
      label418:
      PointF localPointF;
      float f2;
      if (this.nose == 1) {
        if (f1 > 0.0F)
        {
          drawLineToListFromP1AndP2((PointF)paramList.get(62), (PointF)paramList.get(63));
          if (this.nostril == 1)
          {
            if (f1 <= 0.0F) {
              break label1153;
            }
            new PointF();
            localObject = new PointF();
            localPointF = getMiddleByP1AndP2((PointF)paramList.get(59), (PointF)paramList.get(60));
            f2 = ((PointF)paramList.get(62)).x;
            ((PointF)localObject).x = (((PointF)paramList.get(60)).x * 0.7F + (1.0F - 0.7F) * f2);
            f2 = ((PointF)paramList.get(62)).y;
            ((PointF)localObject).y = (((PointF)paramList.get(60)).y * 0.7F + (1.0F - 0.7F) * f2);
            drawLineToListFromP1AndP2((PointF)localObject, localPointF);
            f2 = ((PointF)paramList.get(59)).x;
            localPointF.x = (((PointF)paramList.get(58)).x * 0.7F + (1.0F - 0.7F) * f2);
            f2 = ((PointF)paramList.get(59)).y;
            localPointF.y = (((PointF)paramList.get(58)).y * 0.7F + (1.0F - 0.7F) * f2);
            f2 = ((PointF)paramList.get(57)).x;
            ((PointF)localObject).x = (((PointF)paramList.get(58)).x * 0.7F + (1.0F - 0.7F) * f2);
            f2 = ((PointF)paramList.get(57)).y;
            ((PointF)localObject).y = (((PointF)paramList.get(58)).y * 0.7F + (1.0F - 0.7F) * f2);
            drawLineToListFromP1AndP2((PointF)localObject, localPointF);
          }
        }
      }
      for (;;)
      {
        this.lastFaceYaw = f1;
        if (this.mouth == -1) {
          break label1493;
        }
        localObject = (PointF)paramList.get(65);
        localPointF = (PointF)paramList.get(66);
        if (this.mouth == 0)
        {
          localObject = getMiddleByP1AndP2((PointF)paramList.get(65), (PointF)paramList.get(82));
          localPointF = getMiddleByP1AndP2((PointF)paramList.get(66), (PointF)paramList.get(80));
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localObject);
        localArrayList.add(paramList.get(82));
        localArrayList.add(paramList.get(81));
        localArrayList.add(paramList.get(80));
        localArrayList.add(localPointF);
        localArrayList.add(paramList.get(72));
        localArrayList.add(paramList.get(73));
        localArrayList.add(paramList.get(74));
        localArrayList.add(localObject);
        i = 0;
        while (i < localArrayList.size() - 1)
        {
          drawLineToListFromP1AndP2((PointF)localArrayList.get(i), (PointF)localArrayList.get(i + 1));
          i += 1;
        }
        f1 = this.lastFaceYaw;
        break;
        drawLineToListFromP1AndP2((PointF)paramList.get(55), (PointF)paramList.get(56));
        break label418;
        if (this.nose != 0) {
          break label418;
        }
        drawLineToListFromP1AndP2(getMiddleByP1AndP2((PointF)paramList.get(56), (PointF)paramList.get(62)), (PointF)paramList.get(64));
        break label418;
        label1153:
        new PointF();
        localObject = new PointF();
        localPointF = getMiddleByP1AndP2((PointF)paramList.get(59), (PointF)paramList.get(58));
        f2 = ((PointF)paramList.get(56)).x;
        ((PointF)localObject).x = (((PointF)paramList.get(58)).x * 0.7F + (1.0F - 0.7F) * f2);
        f2 = ((PointF)paramList.get(56)).y;
        ((PointF)localObject).y = (((PointF)paramList.get(58)).y * 0.7F + (1.0F - 0.7F) * f2);
        drawLineToListFromP1AndP2((PointF)localObject, localPointF);
        f2 = ((PointF)paramList.get(59)).x;
        localPointF.x = (((PointF)paramList.get(60)).x * 0.7F + (1.0F - 0.7F) * f2);
        f2 = ((PointF)paramList.get(59)).y;
        localPointF.y = (((PointF)paramList.get(60)).y * 0.7F + (1.0F - 0.7F) * f2);
        f2 = ((PointF)paramList.get(61)).x;
        ((PointF)localObject).x = (((PointF)paramList.get(60)).x * 0.7F + (1.0F - 0.7F) * f2);
        f2 = ((PointF)paramList.get(61)).y;
        ((PointF)localObject).y = (((PointF)paramList.get(60)).y * 0.7F + (1.0F - 0.7F) * f2);
        drawLineToListFromP1AndP2((PointF)localObject, localPointF);
      }
      label1493:
      int j;
      label1531:
      float f5;
      float f6;
      if ((this.eye == 1) || (this.eye == 2))
      {
        i = 1;
        if ((this.eyeBorder != 1) && (this.eye != 2)) {
          break label2224;
        }
        j = 1;
        if ((i == 0) && (j == 0)) {
          break label3299;
        }
        f1 = ((PointF)paramList.get(51)).y;
        f1 = (((PointF)paramList.get(47)).y + f1) / 2.0F;
        f2 = ((PointF)paramList.get(41)).y;
        f5 = (f1 - (((PointF)paramList.get(37)).y + f2) / 2.0F) / (((PointF)paramList.get(54)).x - ((PointF)paramList.get(44)).x);
        localObject = (PointF)paramList.get(41);
        localPointF = (PointF)paramList.get(37);
        f6 = 3.0F * f3;
        f2 = 7.0F * f3;
        f3 = 12.0F * f3;
        f1 = Math.max(f6, (float)DistanceFromPoint2fToPoint2f((PointF)localObject, localPointF));
        if (f1 > f6) {
          break label2230;
        }
        f1 = 0.0F;
      }
      label2307:
      label3848:
      for (;;)
      {
        label1722:
        int k = (int)(f1 * 0.0F);
        float f4 = Math.max(f6, (float)DistanceFromPoint2fToPoint2f((PointF)paramList.get(51), (PointF)paramList.get(47)));
        label1774:
        int m;
        if (f4 <= f6)
        {
          f2 = 0.0F;
          if ((f2 == 0.0F) || (f1 == 0.0F)) {
            break label2290;
          }
          f4 = (f1 + f2) / 2.0F;
          f3 = (f1 + f2) / 2.0F;
          label1806:
          f6 = (int)(f2 * 0.0F);
          localObject = this.eyeNeedDrawBk;
          if (f1 <= 0.0F) {
            break label2301;
          }
          m = 1;
          label1830:
          localObject[0] = m;
          localObject = this.eyeNeedDrawBk;
          if (f2 <= 0.0F) {
            break label2307;
          }
          m = 1;
          label1852:
          localObject[1] = m;
          paramFloat = -paramFloat;
          if (f1 <= 0.0F) {
            break label2785;
          }
          if (this.eyelash == 1)
          {
            new PointF();
            localObject = new PointF();
            if ((Math.abs(paramFloat) >= 10.0F) && (paramFloat <= 10.0F)) {
              break label2313;
            }
            localPointF = getMiddleByP1AndP2((PointF)paramList.get(42), (PointF)paramList.get(35));
            ((PointF)localObject).x = (((PointF)paramList.get(19)).x * 0.2F + (1.0F - 0.2F) * localPointF.x);
            ((PointF)localObject).y = (((PointF)paramList.get(19)).y * 0.2F + (1.0F - 0.2F) * localPointF.y);
            drawLineToListFromP1AndP2(localPointF, (PointF)localObject);
          }
        }
        for (;;)
        {
          if (i != 0)
          {
            localObject = getMiddleByP1AndP2((PointF)paramList.get(37), (PointF)paramList.get(41));
            ((PointF)localObject).x = ((PointF)paramList.get(44)).x;
            localObject = new PointF(((PointF)localObject).x - this.eye_center_shift_l, ((PointF)localObject).y - this.eye_center_shift_l * f5);
            this.pointsVertexFloats.add(Float.valueOf(2.0F * ((PointF)localObject).x / paramInt1 - 1.0F));
            this.pointsVertexFloats.add(Float.valueOf(((PointF)localObject).y * 2.0F / paramInt2 - 1.0F));
            this.pointsSizeFloats.add(Float.valueOf(f3));
          }
          if (j == 0) {
            break label2429;
          }
          k = 35;
          while (k < 42)
          {
            drawLineToListFromP1AndP2((PointF)paramList.get(k), (PointF)paramList.get(k + 1));
            k += 1;
          }
          i = 0;
          break;
          label2224:
          j = 0;
          break label1531;
          label2230:
          if (f1 > f3)
          {
            f1 = f2;
            break label1722;
          }
          if (f1 > f6) {
            break label3848;
          }
          f1 = f3;
          break label1722;
          if (f4 > f3) {
            break label1774;
          }
          f2 = f4;
          if (f4 > f6) {
            break label1774;
          }
          f2 = f3;
          break label1774;
          label2290:
          f3 = f1;
          f4 = f2;
          break label1806;
          label2301:
          m = 0;
          break label1830;
          m = 0;
          break label1852;
          label2313:
          localPointF = (PointF)paramList.get(40);
          ((PointF)localObject).x = (((PointF)paramList.get(23)).x * 0.2F + (1.0F - 0.2F) * localPointF.x);
          ((PointF)localObject).y = (((PointF)paramList.get(23)).y * 0.2F + (1.0F - 0.2F) * localPointF.y);
          drawLineToListFromP1AndP2(localPointF, (PointF)localObject);
        }
        drawLineToListFromP1AndP2((PointF)paramList.get(42), (PointF)paramList.get(35));
        label2429:
        if (f2 > 0.0F)
        {
          if (this.eyelash == 1)
          {
            new PointF();
            localObject = new PointF();
            if ((Math.abs(paramFloat) >= 10.0F) && (paramFloat >= -10.0F)) {
              break label2908;
            }
            localPointF = getMiddleByP1AndP2((PointF)paramList.get(52), (PointF)paramList.get(45));
            ((PointF)localObject).x = (((PointF)paramList.get(27)).x * 0.2F + (1.0F - 0.2F) * localPointF.x);
            ((PointF)localObject).y = (((PointF)paramList.get(27)).y * 0.2F + (1.0F - 0.2F) * localPointF.y);
            drawLineToListFromP1AndP2(localPointF, (PointF)localObject);
          }
          for (;;)
          {
            if (i != 0)
            {
              localObject = getMiddleByP1AndP2((PointF)paramList.get(51), (PointF)paramList.get(47));
              ((PointF)localObject).x = ((PointF)paramList.get(54)).x;
              localObject = new PointF(((PointF)localObject).x + this.eye_center_shift_r, ((PointF)localObject).y + this.eye_center_shift_r * f5);
              this.pointsVertexFloats.add(Float.valueOf(2.0F * ((PointF)localObject).x / paramInt1 - 1.0F));
              this.pointsVertexFloats.add(Float.valueOf(((PointF)localObject).y * 2.0F / paramInt2 - 1.0F));
              this.pointsSizeFloats.add(Float.valueOf(f4));
            }
            if (j == 0) {
              break label3024;
            }
            i = 45;
            while (i < 52)
            {
              drawLineToListFromP1AndP2((PointF)paramList.get(i), (PointF)paramList.get(i + 1));
              i += 1;
            }
            if (this.eyeCloseLine == 0) {
              break;
            }
            localObject = new PointF[3];
            k = 36;
            while (k < 39)
            {
              localObject[(k - 36)] = getMiddleByP1AndP2((PointF)paramList.get(k), (PointF)paramList.get(78 - k));
              k += 1;
            }
            drawLineToListFromP1AndP2((PointF)paramList.get(35), localObject[0]);
            k = 0;
            while (k < 2)
            {
              drawLineToListFromP1AndP2(localObject[k], localObject[(k + 1)]);
              k += 1;
            }
            break;
            localPointF = (PointF)paramList.get(50);
            ((PointF)localObject).x = (((PointF)paramList.get(31)).x * 0.2F + (1.0F - 0.2F) * localPointF.x);
            ((PointF)localObject).y = (((PointF)paramList.get(31)).y * 0.2F + (1.0F - 0.2F) * localPointF.y);
            drawLineToListFromP1AndP2(localPointF, (PointF)localObject);
          }
          drawLineToListFromP1AndP2((PointF)paramList.get(52), (PointF)paramList.get(45));
        }
        label2785:
        while (this.needFillMouth)
        {
          localObject = new int[8];
          tmp3039_3037 = localObject;
          tmp3039_3037[0] = 65;
          tmp3044_3039 = tmp3039_3037;
          tmp3044_3039[1] = 74;
          tmp3049_3044 = tmp3044_3039;
          tmp3049_3044[2] = 82;
          tmp3054_3049 = tmp3049_3044;
          tmp3054_3049[3] = 73;
          tmp3059_3054 = tmp3054_3049;
          tmp3059_3054[4] = 81;
          tmp3064_3059 = tmp3059_3054;
          tmp3064_3059[5] = 72;
          tmp3069_3064 = tmp3064_3059;
          tmp3069_3064[6] = 80;
          tmp3075_3069 = tmp3069_3064;
          tmp3075_3069[7] = 66;
          tmp3075_3069;
          i = 0;
          while (i < localObject.length)
          {
            this.triangleVertexFloats.add(Float.valueOf(((PointF)paramList.get(localObject[i])).x * 2.0F / paramInt1 - 1.0F));
            this.triangleVertexFloats.add(Float.valueOf(((PointF)paramList.get(localObject[i])).y * 2.0F / paramInt2 - 1.0F));
            i += 1;
          }
          if (this.eyeCloseLine != 0)
          {
            localObject = new PointF[3];
            i = 46;
            while (i < 49)
            {
              localObject[(i - 46)] = getMiddleByP1AndP2((PointF)paramList.get(i), (PointF)paramList.get(98 - i));
              i += 1;
            }
            drawLineToListFromP1AndP2((PointF)paramList.get(45), localObject[0]);
            i = 0;
            while (i < 2)
            {
              drawLineToListFromP1AndP2(localObject[i], localObject[(i + 1)]);
              i += 1;
            }
            continue;
            label3299:
            if (this.eye == 0)
            {
              this.pointsVertexFloats.add(Float.valueOf(((PointF)paramList.get(43)).x * 2.0F / paramInt1 - 1.0F));
              this.pointsVertexFloats.add(Float.valueOf(((PointF)paramList.get(43)).y * 2.0F / paramInt2 - 1.0F));
              this.pointsSizeFloats.add(Float.valueOf((float)DistanceFromPoint2fToPoint2f((PointF)paramList.get(37), (PointF)paramList.get(41)) * 0.75F));
              this.pointsVertexFloats.add(Float.valueOf(((PointF)paramList.get(53)).x * 2.0F / paramInt1 - 1.0F));
              this.pointsVertexFloats.add(Float.valueOf(((PointF)paramList.get(53)).y * 2.0F / paramInt2 - 1.0F));
              this.pointsSizeFloats.add(Float.valueOf((float)DistanceFromPoint2fToPoint2f((PointF)paramList.get(47), (PointF)paramList.get(51)) * 0.75F));
            }
          }
        }
        label2908:
        if (this.eye == 2)
        {
          if (this.eyeNeedDrawBk[0] != 0)
          {
            localObject = new int[8];
            tmp3556_3554 = localObject;
            tmp3556_3554[0] = 39;
            tmp3561_3556 = tmp3556_3554;
            tmp3561_3556[1] = 40;
            tmp3566_3561 = tmp3561_3556;
            tmp3566_3561[2] = 38;
            tmp3571_3566 = tmp3566_3561;
            tmp3571_3566[3] = 41;
            tmp3576_3571 = tmp3571_3566;
            tmp3576_3571[4] = 37;
            tmp3581_3576 = tmp3576_3571;
            tmp3581_3576[5] = 42;
            tmp3586_3581 = tmp3581_3576;
            tmp3586_3581[6] = 36;
            tmp3592_3586 = tmp3586_3581;
            tmp3592_3586[7] = 35;
            tmp3592_3586;
            i = 0;
            while (i < localObject.length)
            {
              this.triangleVertexLeftEyeFloats.add(Float.valueOf(((PointF)paramList.get(localObject[i])).x * 2.0F / paramInt1 - 1.0F));
              this.triangleVertexLeftEyeFloats.add(Float.valueOf(((PointF)paramList.get(localObject[i])).y * 2.0F / paramInt2 - 1.0F));
              i += 1;
            }
          }
          if (this.eyeNeedDrawBk[1] != 0)
          {
            localObject = new int[8];
            tmp3710_3708 = localObject;
            tmp3710_3708[0] = 49;
            tmp3715_3710 = tmp3710_3708;
            tmp3715_3710[1] = 50;
            tmp3720_3715 = tmp3715_3710;
            tmp3720_3715[2] = 48;
            tmp3725_3720 = tmp3720_3715;
            tmp3725_3720[3] = 51;
            tmp3730_3725 = tmp3725_3720;
            tmp3730_3725[4] = 47;
            tmp3735_3730 = tmp3730_3725;
            tmp3735_3730[5] = 52;
            tmp3740_3735 = tmp3735_3730;
            tmp3740_3735[6] = 46;
            tmp3746_3740 = tmp3740_3735;
            tmp3746_3740[7] = 45;
            tmp3746_3740;
            i = 0;
            while (i < localObject.length)
            {
              this.triangleVertexRightEyeFloats.add(Float.valueOf(((PointF)paramList.get(localObject[i])).x * 2.0F / paramInt1 - 1.0F));
              this.triangleVertexRightEyeFloats.add(Float.valueOf(((PointF)paramList.get(localObject[i])).y * 2.0F / paramInt2 - 1.0F));
              i += 1;
            }
          }
        }
        label3024:
        return;
      }
      f1 = paramFloat;
    }
  }
  
  private PointF getMiddleByP1AndP2(PointF paramPointF1, PointF paramPointF2)
  {
    PointF localPointF = new PointF(paramPointF1.x, paramPointF1.y);
    localPointF.x = ((paramPointF1.x + paramPointF2.x) * 0.5F);
    localPointF.y = ((paramPointF1.y + paramPointF2.y) * 0.5F);
    return localPointF;
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    addAttribParam(new AttributeParam("preferPointSize", new float[] { 1.0F, 1.0F, 1.0F, 1.0F }, 1));
  }
  
  public void initParams() {}
  
  public void render(int paramInt1, int paramInt2, int paramInt3)
  {
    float[] arrayOfFloat = new float[this.lineVertexFloats.size()];
    Object localObject1 = this.lineVertexFloats.iterator();
    int i = 0;
    float f;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Float)((Iterator)localObject1).next();
      if (localObject2 != null) {}
      for (f = ((Float)localObject2).floatValue();; f = 0.0F)
      {
        arrayOfFloat[i] = f;
        i += 1;
        break;
      }
    }
    localObject1 = new float[this.pointsVertexFloats.size()];
    Object localObject2 = this.pointsVertexFloats.iterator();
    i = 0;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Float)((Iterator)localObject2).next();
      if (localObject3 != null) {}
      for (f = ((Float)localObject3).floatValue();; f = 0.0F)
      {
        localObject1[i] = f;
        i += 1;
        break;
      }
    }
    localObject2 = new float[this.pointsSizeFloats.size()];
    Object localObject3 = this.pointsSizeFloats.iterator();
    i = 0;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Float)((Iterator)localObject3).next();
      if (localObject4 != null) {}
      for (f = ((Float)localObject4).floatValue();; f = 1.0F)
      {
        localObject2[i] = f;
        i += 1;
        break;
      }
    }
    localObject3 = new float[this.triangleVertexFloats.size()];
    Object localObject4 = this.triangleVertexFloats.iterator();
    i = 0;
    if (((Iterator)localObject4).hasNext())
    {
      localObject5 = (Float)((Iterator)localObject4).next();
      if (localObject5 != null) {}
      for (f = ((Float)localObject5).floatValue();; f = 1.0F)
      {
        localObject3[i] = f;
        i += 1;
        break;
      }
    }
    localObject4 = new float[this.triangleVertexLeftEyeFloats.size()];
    Object localObject5 = this.triangleVertexLeftEyeFloats.iterator();
    i = 0;
    if (((Iterator)localObject5).hasNext())
    {
      localObject6 = (Float)((Iterator)localObject5).next();
      if (localObject6 != null) {}
      for (f = ((Float)localObject6).floatValue();; f = 1.0F)
      {
        localObject4[i] = f;
        i += 1;
        break;
      }
    }
    localObject5 = new float[this.triangleVertexRightEyeFloats.size()];
    Object localObject6 = this.triangleVertexRightEyeFloats.iterator();
    i = 0;
    if (((Iterator)localObject6).hasNext())
    {
      Float localFloat = (Float)((Iterator)localObject6).next();
      if (localFloat != null) {}
      for (f = localFloat.floatValue();; f = 1.0F)
      {
        localObject5[i] = f;
        i += 1;
        break;
      }
    }
    if (!this.mNoPoints)
    {
      if (localObject4.length > 0)
      {
        addParam(new UniformParam.IntParam("drawOrigin", 0));
        addParam(new UniformParam.IntParam("drawMode", 3));
        addParam(new UniformParam.Float4fParam("drawColor", 1.0F, 1.0F, 1.0F, 1.0F));
        setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLE_STRIP);
        setCoordNum(localObject4.length / 2);
        setPositions((float[])localObject4);
        GlUtil.setBlendMode(true);
        OnDrawFrameGLSL();
        renderTexture(paramInt1, paramInt2, paramInt3);
        GlUtil.setBlendMode(false);
        this.triangleVertexLeftEyeFloats.clear();
      }
      if (localObject5.length > 0)
      {
        addParam(new UniformParam.IntParam("drawOrigin", 0));
        addParam(new UniformParam.IntParam("drawMode", 3));
        addParam(new UniformParam.Float4fParam("drawColor", 1.0F, 1.0F, 1.0F, 1.0F));
        setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLE_STRIP);
        setCoordNum(localObject5.length / 2);
        setPositions((float[])localObject5);
        GlUtil.setBlendMode(true);
        OnDrawFrameGLSL();
        renderTexture(paramInt1, paramInt2, paramInt3);
        GlUtil.setBlendMode(false);
        this.triangleVertexRightEyeFloats.clear();
      }
      if ((localObject3.length > 0) && (this.mouthFillColorRGBA != null))
      {
        addParam(new UniformParam.IntParam("drawOrigin", 0));
        addParam(new UniformParam.IntParam("drawMode", 3));
        addParam(new UniformParam.Float4fParam("drawColor", this.mouthFillColorRGBA[0], this.mouthFillColorRGBA[1], this.mouthFillColorRGBA[2], this.mouthFillColorRGBA[3]));
        setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLE_STRIP);
        setCoordNum(localObject3.length / 2);
        setPositions((float[])localObject3);
        GlUtil.setBlendMode(true);
        OnDrawFrameGLSL();
        renderTexture(paramInt1, paramInt2, paramInt3);
        GlUtil.setBlendMode(false);
        this.triangleVertexFloats.clear();
      }
      GLES20.glLineWidth(this.thickness);
      addAttribParam(new AttributeParam("preferPointSize", new float[arrayOfFloat.length], 1));
      addParam(new UniformParam.IntParam("drawOrigin", 0));
      addParam(new UniformParam.IntParam("drawMode", 2));
      setDrawMode(AEOpenRenderConfig.DRAW_MODE.LINES);
      setCoordNum(arrayOfFloat.length / 2);
      setPositions(arrayOfFloat);
      GlUtil.setBlendMode(true);
      OnDrawFrameGLSL();
      renderTexture(paramInt1, paramInt2, paramInt3);
      GlUtil.setBlendMode(false);
      this.lineVertexFloats.clear();
      addAttribParam(new AttributeParam("preferPointSize", (float[])localObject2, 1));
      addParam(new UniformParam.IntParam("drawOrigin", 0));
      addParam(new UniformParam.IntParam("drawMode", 1));
      setDrawMode(AEOpenRenderConfig.DRAW_MODE.POINTS);
      setCoordNum(this.pointsVertexFloats.size() / 2);
      setPositions((float[])localObject1);
      GlUtil.setBlendMode(true);
      OnDrawFrameGLSL();
      renderTexture(paramInt1, paramInt2, paramInt3);
      GlUtil.setBlendMode(false);
      this.pointsVertexFloats.clear();
      this.pointsSizeFloats.clear();
    }
  }
  
  public void updatePoints(List<PointF> paramList, int paramInt1, int paramInt2, float paramFloat, FaceStyleItem.CartoonFaceLine paramCartoonFaceLine)
  {
    if (paramCartoonFaceLine != null)
    {
      this.face = paramCartoonFaceLine.face;
      this.eyebrow = paramCartoonFaceLine.eyebrow;
      this.eye = paramCartoonFaceLine.eye;
      this.eyeCloseLine = paramCartoonFaceLine.eyeCloseLine;
      this.nose = paramCartoonFaceLine.nose;
      this.mouthFillColorRGBA = paramCartoonFaceLine.mouthFillColorRGBA;
      this.mouth = paramCartoonFaceLine.mouth;
      this.eyelash = paramCartoonFaceLine.eyelash;
      this.nostril = paramCartoonFaceLine.nostril;
      this.eyeBorder = paramCartoonFaceLine.eyeBorder;
      this.eye_center_shift_l = paramCartoonFaceLine.eye_center_shift_l;
      this.eye_center_shift_r = paramCartoonFaceLine.eye_center_shift_r;
    }
    if (paramList == null)
    {
      this.mNoPoints = true;
      return;
    }
    this.mNoPoints = false;
    this.width = paramInt1;
    this.height = paramInt2;
    getCartoonFacePoints2(paramList, paramInt1, paramInt2, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.CartoonStylePreProcessFilter
 * JD-Core Version:    0.7.0.1
 */