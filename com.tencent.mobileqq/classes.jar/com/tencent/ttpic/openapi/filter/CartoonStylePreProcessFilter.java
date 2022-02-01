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
    float f5 = paramInt1;
    float f3 = 0.0039063F * f5;
    this.thickness = 2.0F;
    this.thickness *= f3;
    paramInt1 = this.face;
    Object localObject;
    if (paramInt1 == 0)
    {
      paramInt1 = 1;
      while (paramInt1 < 17)
      {
        localObject = (PointF)paramList.get(paramInt1);
        paramInt1 += 1;
        drawLineToListFromP1AndP2((PointF)localObject, (PointF)paramList.get(paramInt1));
      }
    }
    if (paramInt1 == 1)
    {
      paramInt1 = 0;
      while (paramInt1 < 18)
      {
        localObject = (PointF)paramList.get(paramInt1);
        paramInt1 += 1;
        drawLineToListFromP1AndP2((PointF)localObject, (PointF)paramList.get(paramInt1));
      }
    }
    if (this.eyebrow == 0)
    {
      localObject = new PointF[3];
      paramInt1 = 20;
      while (paramInt1 < 23)
      {
        localObject[(paramInt1 - 20)] = getMiddleByP1AndP2((PointF)paramList.get(paramInt1), (PointF)paramList.get(46 - paramInt1));
        paramInt1 += 1;
      }
      drawLineToListFromP1AndP2(localObject[0], localObject[1]);
      drawLineToListFromP1AndP2(localObject[1], localObject[2]);
      drawLineToListFromP1AndP2(localObject[2], (PointF)paramList.get(23));
      paramInt1 = 28;
      while (paramInt1 < 31)
      {
        localObject[(paramInt1 - 28)] = getMiddleByP1AndP2((PointF)paramList.get(paramInt1), (PointF)paramList.get(62 - paramInt1));
        paramInt1 += 1;
      }
      drawLineToListFromP1AndP2(localObject[0], localObject[1]);
      drawLineToListFromP1AndP2(localObject[1], localObject[2]);
      drawLineToListFromP1AndP2(localObject[2], (PointF)paramList.get(31));
    }
    float f1 = this.lastFaceYaw;
    if ((f1 * paramFloat <= 0.0F) && (Math.abs(paramFloat - f1) <= 2.2F)) {
      f1 = this.lastFaceYaw;
    } else {
      f1 = paramFloat;
    }
    paramInt1 = this.nose;
    if (paramInt1 == 1)
    {
      if (f1 > 0.0F) {
        drawLineToListFromP1AndP2((PointF)paramList.get(62), (PointF)paramList.get(63));
      } else {
        drawLineToListFromP1AndP2((PointF)paramList.get(55), (PointF)paramList.get(56));
      }
    }
    else if (paramInt1 == 0) {
      drawLineToListFromP1AndP2(getMiddleByP1AndP2((PointF)paramList.get(56), (PointF)paramList.get(62)), (PointF)paramList.get(64));
    }
    PointF localPointF;
    if (this.nostril == 1) {
      if (f1 > 0.0F)
      {
        new PointF();
        localObject = new PointF();
        localPointF = getMiddleByP1AndP2((PointF)paramList.get(59), (PointF)paramList.get(60));
        ((PointF)localObject).x = (((PointF)paramList.get(62)).x * 0.3F + ((PointF)paramList.get(60)).x * 0.7F);
        ((PointF)localObject).y = (((PointF)paramList.get(62)).y * 0.3F + ((PointF)paramList.get(60)).y * 0.7F);
        drawLineToListFromP1AndP2((PointF)localObject, localPointF);
        localPointF.x = (((PointF)paramList.get(59)).x * 0.3F + ((PointF)paramList.get(58)).x * 0.7F);
        localPointF.y = (((PointF)paramList.get(59)).y * 0.3F + ((PointF)paramList.get(58)).y * 0.7F);
        ((PointF)localObject).x = (((PointF)paramList.get(57)).x * 0.3F + ((PointF)paramList.get(58)).x * 0.7F);
        ((PointF)localObject).y = (0.3F * ((PointF)paramList.get(57)).y + ((PointF)paramList.get(58)).y * 0.7F);
        drawLineToListFromP1AndP2((PointF)localObject, localPointF);
      }
      else
      {
        new PointF();
        localObject = new PointF();
        localPointF = getMiddleByP1AndP2((PointF)paramList.get(59), (PointF)paramList.get(58));
        ((PointF)localObject).x = (((PointF)paramList.get(56)).x * 0.3F + ((PointF)paramList.get(58)).x * 0.7F);
        ((PointF)localObject).y = (((PointF)paramList.get(56)).y * 0.3F + ((PointF)paramList.get(58)).y * 0.7F);
        drawLineToListFromP1AndP2((PointF)localObject, localPointF);
        localPointF.x = (((PointF)paramList.get(59)).x * 0.3F + ((PointF)paramList.get(60)).x * 0.7F);
        localPointF.y = (((PointF)paramList.get(59)).y * 0.3F + ((PointF)paramList.get(60)).y * 0.7F);
        ((PointF)localObject).x = (((PointF)paramList.get(61)).x * 0.3F + ((PointF)paramList.get(60)).x * 0.7F);
        ((PointF)localObject).y = (0.3F * ((PointF)paramList.get(61)).y + ((PointF)paramList.get(60)).y * 0.7F);
        drawLineToListFromP1AndP2((PointF)localObject, localPointF);
      }
    }
    this.lastFaceYaw = f1;
    if (this.mouth != -1)
    {
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
      paramInt1 = 0;
      while (paramInt1 < localArrayList.size() - 1)
      {
        localObject = (PointF)localArrayList.get(paramInt1);
        paramInt1 += 1;
        drawLineToListFromP1AndP2((PointF)localObject, (PointF)localArrayList.get(paramInt1));
      }
    }
    paramInt1 = this.eye;
    if ((paramInt1 != 1) && (paramInt1 != 2)) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    int i;
    if ((this.eyeBorder != 1) && (this.eye != 2)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((paramInt1 == 0) && (i == 0))
    {
      if (this.eye == 0)
      {
        this.pointsVertexFloats.add(Float.valueOf(((PointF)paramList.get(43)).x * 2.0F / f5 - 1.0F));
        localObject = this.pointsVertexFloats;
        paramFloat = ((PointF)paramList.get(43)).y;
        f1 = paramInt2;
        ((List)localObject).add(Float.valueOf(paramFloat * 2.0F / f1 - 1.0F));
        this.pointsSizeFloats.add(Float.valueOf((float)DistanceFromPoint2fToPoint2f((PointF)paramList.get(37), (PointF)paramList.get(41)) * 0.75F));
        this.pointsVertexFloats.add(Float.valueOf(((PointF)paramList.get(53)).x * 2.0F / f5 - 1.0F));
        this.pointsVertexFloats.add(Float.valueOf(((PointF)paramList.get(53)).y * 2.0F / f1 - 1.0F));
        this.pointsSizeFloats.add(Float.valueOf((float)DistanceFromPoint2fToPoint2f((PointF)paramList.get(47), (PointF)paramList.get(51)) * 0.75F));
      }
    }
    else
    {
      float f6 = ((((PointF)paramList.get(51)).y + ((PointF)paramList.get(47)).y) / 2.0F - (((PointF)paramList.get(41)).y + ((PointF)paramList.get(37)).y) / 2.0F) / (((PointF)paramList.get(54)).x - ((PointF)paramList.get(44)).x);
      localObject = (PointF)paramList.get(41);
      localPointF = (PointF)paramList.get(37);
      float f7 = 3.0F * f3;
      float f2 = 7.0F * f3;
      f3 *= 12.0F;
      float f4 = Math.max(f7, (float)DistanceFromPoint2fToPoint2f((PointF)localObject, localPointF));
      if (f4 <= f7)
      {
        f1 = 0.0F;
      }
      else if (f4 > f3)
      {
        f1 = f2;
      }
      else
      {
        f1 = f4;
        if (f4 <= f7) {
          f1 = f3;
        }
      }
      f4 = Math.max(f7, (float)DistanceFromPoint2fToPoint2f((PointF)paramList.get(51), (PointF)paramList.get(47)));
      if (f4 <= f7) {
        f2 = 0.0F;
      } else if (f4 <= f3) {
        if (f4 <= f7) {
          f2 = f3;
        } else {
          f2 = f4;
        }
      }
      if ((f2 != 0.0F) && (f1 != 0.0F))
      {
        f3 = (f1 + f2) / 2.0F;
        f4 = f3;
      }
      else
      {
        f3 = f1;
        f4 = f2;
      }
      localObject = this.eyeNeedDrawBk;
      int k;
      if (f1 > 0.0F) {
        k = 1;
      } else {
        k = 0;
      }
      localObject[0] = k;
      localObject = this.eyeNeedDrawBk;
      if (f2 > 0.0F) {
        k = 1;
      } else {
        k = 0;
      }
      localObject[1] = k;
      paramFloat = -paramFloat;
      int j;
      if (f1 > 0.0F)
      {
        if (this.eyelash == 1)
        {
          new PointF();
          localObject = new PointF();
          if ((Math.abs(paramFloat) >= 10.0F) && (paramFloat <= 10.0F))
          {
            localPointF = (PointF)paramList.get(40);
            ((PointF)localObject).x = (((PointF)paramList.get(23)).x * 0.2F + localPointF.x * 0.8F);
            ((PointF)localObject).y = (((PointF)paramList.get(23)).y * 0.2F + 0.8F * localPointF.y);
            drawLineToListFromP1AndP2(localPointF, (PointF)localObject);
          }
          else
          {
            localPointF = getMiddleByP1AndP2((PointF)paramList.get(42), (PointF)paramList.get(35));
            ((PointF)localObject).x = (((PointF)paramList.get(19)).x * 0.2F + localPointF.x * 0.8F);
            ((PointF)localObject).y = (((PointF)paramList.get(19)).y * 0.2F + 0.8F * localPointF.y);
            drawLineToListFromP1AndP2(localPointF, (PointF)localObject);
          }
        }
        if (paramInt1 != 0)
        {
          localObject = getMiddleByP1AndP2((PointF)paramList.get(37), (PointF)paramList.get(41));
          ((PointF)localObject).x = ((PointF)paramList.get(44)).x;
          localObject = new PointF(((PointF)localObject).x - this.eye_center_shift_l, ((PointF)localObject).y - this.eye_center_shift_l * f6);
          this.pointsVertexFloats.add(Float.valueOf(((PointF)localObject).x * 2.0F / f5 - 1.0F));
          this.pointsVertexFloats.add(Float.valueOf(((PointF)localObject).y * 2.0F / paramInt2 - 1.0F));
          this.pointsSizeFloats.add(Float.valueOf(f3));
        }
        if (i != 0)
        {
          j = 35;
          while (j < 42)
          {
            localObject = (PointF)paramList.get(j);
            j += 1;
            drawLineToListFromP1AndP2((PointF)localObject, (PointF)paramList.get(j));
          }
          drawLineToListFromP1AndP2((PointF)paramList.get(42), (PointF)paramList.get(35));
        }
      }
      else if (this.eyeCloseLine != 0)
      {
        localObject = new PointF[3];
        j = 36;
        while (j < 39)
        {
          localObject[(j - 36)] = getMiddleByP1AndP2((PointF)paramList.get(j), (PointF)paramList.get(78 - j));
          j += 1;
        }
        drawLineToListFromP1AndP2((PointF)paramList.get(35), localObject[0]);
        j = 0;
        while (j < 2)
        {
          localPointF = localObject[j];
          j += 1;
          drawLineToListFromP1AndP2(localPointF, localObject[j]);
        }
      }
      if (f2 > 0.0F)
      {
        if (this.eyelash == 1)
        {
          new PointF();
          localObject = new PointF();
          if ((Math.abs(paramFloat) >= 10.0F) && (paramFloat >= -10.0F))
          {
            localPointF = (PointF)paramList.get(50);
            ((PointF)localObject).x = (((PointF)paramList.get(31)).x * 0.2F + localPointF.x * 0.8F);
            ((PointF)localObject).y = (0.2F * ((PointF)paramList.get(31)).y + 0.8F * localPointF.y);
            drawLineToListFromP1AndP2(localPointF, (PointF)localObject);
          }
          else
          {
            localPointF = getMiddleByP1AndP2((PointF)paramList.get(52), (PointF)paramList.get(45));
            ((PointF)localObject).x = (((PointF)paramList.get(27)).x * 0.2F + localPointF.x * 0.8F);
            ((PointF)localObject).y = (0.2F * ((PointF)paramList.get(27)).y + 0.8F * localPointF.y);
            drawLineToListFromP1AndP2(localPointF, (PointF)localObject);
          }
        }
        if (paramInt1 != 0)
        {
          localObject = getMiddleByP1AndP2((PointF)paramList.get(51), (PointF)paramList.get(47));
          ((PointF)localObject).x = ((PointF)paramList.get(54)).x;
          localObject = new PointF(((PointF)localObject).x + this.eye_center_shift_r, ((PointF)localObject).y + this.eye_center_shift_r * f6);
          this.pointsVertexFloats.add(Float.valueOf(((PointF)localObject).x * 2.0F / f5 - 1.0F));
          this.pointsVertexFloats.add(Float.valueOf(((PointF)localObject).y * 2.0F / paramInt2 - 1.0F));
          this.pointsSizeFloats.add(Float.valueOf(f4));
        }
        if (i != 0)
        {
          paramInt1 = 45;
          while (paramInt1 < 52)
          {
            localObject = (PointF)paramList.get(paramInt1);
            paramInt1 += 1;
            drawLineToListFromP1AndP2((PointF)localObject, (PointF)paramList.get(paramInt1));
          }
          drawLineToListFromP1AndP2((PointF)paramList.get(52), (PointF)paramList.get(45));
        }
      }
      else if (this.eyeCloseLine != 0)
      {
        localObject = new PointF[3];
        paramInt1 = 46;
        while (paramInt1 < 49)
        {
          localObject[(paramInt1 - 46)] = getMiddleByP1AndP2((PointF)paramList.get(paramInt1), (PointF)paramList.get(98 - paramInt1));
          paramInt1 += 1;
        }
        drawLineToListFromP1AndP2((PointF)paramList.get(45), localObject[0]);
        paramInt1 = 0;
        while (paramInt1 < 2)
        {
          localPointF = localObject[paramInt1];
          paramInt1 += 1;
          drawLineToListFromP1AndP2(localPointF, localObject[paramInt1]);
        }
      }
    }
    if (this.needFillMouth)
    {
      localObject = new int[8];
      Object tmp3277_3275 = localObject;
      tmp3277_3275[0] = 65;
      Object tmp3282_3277 = tmp3277_3275;
      tmp3282_3277[1] = 74;
      Object tmp3287_3282 = tmp3282_3277;
      tmp3287_3282[2] = 82;
      Object tmp3292_3287 = tmp3287_3282;
      tmp3292_3287[3] = 73;
      Object tmp3297_3292 = tmp3292_3287;
      tmp3297_3292[4] = 81;
      Object tmp3302_3297 = tmp3297_3292;
      tmp3302_3297[5] = 72;
      Object tmp3307_3302 = tmp3302_3297;
      tmp3307_3302[6] = 80;
      Object tmp3313_3307 = tmp3307_3302;
      tmp3313_3307[7] = 66;
      tmp3313_3307;
      paramInt1 = 0;
      while (paramInt1 < localObject.length)
      {
        this.triangleVertexFloats.add(Float.valueOf(((PointF)paramList.get(localObject[paramInt1])).x * 2.0F / f5 - 1.0F));
        this.triangleVertexFloats.add(Float.valueOf(((PointF)paramList.get(localObject[paramInt1])).y * 2.0F / paramInt2 - 1.0F));
        paramInt1 += 1;
      }
    }
    if (this.eye == 2)
    {
      localObject = this.eyeNeedDrawBk;
      i = 0;
      if (localObject[0] != 0)
      {
        localObject = new int[8];
        Object tmp3440_3438 = localObject;
        tmp3440_3438[0] = 39;
        Object tmp3445_3440 = tmp3440_3438;
        tmp3445_3440[1] = 40;
        Object tmp3450_3445 = tmp3445_3440;
        tmp3450_3445[2] = 38;
        Object tmp3455_3450 = tmp3450_3445;
        tmp3455_3450[3] = 41;
        Object tmp3460_3455 = tmp3455_3450;
        tmp3460_3455[4] = 37;
        Object tmp3465_3460 = tmp3460_3455;
        tmp3465_3460[5] = 42;
        Object tmp3470_3465 = tmp3465_3460;
        tmp3470_3465[6] = 36;
        Object tmp3476_3470 = tmp3470_3465;
        tmp3476_3470[7] = 35;
        tmp3476_3470;
        paramInt1 = 0;
        while (paramInt1 < localObject.length)
        {
          this.triangleVertexLeftEyeFloats.add(Float.valueOf(((PointF)paramList.get(localObject[paramInt1])).x * 2.0F / f5 - 1.0F));
          this.triangleVertexLeftEyeFloats.add(Float.valueOf(((PointF)paramList.get(localObject[paramInt1])).y * 2.0F / paramInt2 - 1.0F));
          paramInt1 += 1;
        }
      }
      if (this.eyeNeedDrawBk[1] != 0)
      {
        localObject = new int[8];
        Object tmp3588_3586 = localObject;
        tmp3588_3586[0] = 49;
        Object tmp3593_3588 = tmp3588_3586;
        tmp3593_3588[1] = 50;
        Object tmp3598_3593 = tmp3593_3588;
        tmp3598_3593[2] = 48;
        Object tmp3603_3598 = tmp3598_3593;
        tmp3603_3598[3] = 51;
        Object tmp3608_3603 = tmp3603_3598;
        tmp3608_3603[4] = 47;
        Object tmp3613_3608 = tmp3608_3603;
        tmp3613_3608[5] = 52;
        Object tmp3618_3613 = tmp3613_3608;
        tmp3618_3613[6] = 46;
        Object tmp3624_3618 = tmp3618_3613;
        tmp3624_3618[7] = 45;
        tmp3624_3618;
        paramInt1 = i;
        while (paramInt1 < localObject.length)
        {
          this.triangleVertexRightEyeFloats.add(Float.valueOf(((PointF)paramList.get(localObject[paramInt1])).x * 2.0F / f5 - 1.0F));
          this.triangleVertexRightEyeFloats.add(Float.valueOf(((PointF)paramList.get(localObject[paramInt1])).y * 2.0F / paramInt2 - 1.0F));
          paramInt1 += 1;
        }
      }
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
    boolean bool;
    float f;
    for (;;)
    {
      bool = ((Iterator)localObject1).hasNext();
      f = 0.0F;
      if (!bool) {
        break;
      }
      localObject2 = (Float)((Iterator)localObject1).next();
      if (localObject2 != null) {
        f = ((Float)localObject2).floatValue();
      }
      arrayOfFloat[i] = f;
      i += 1;
    }
    localObject1 = new float[this.pointsVertexFloats.size()];
    Object localObject2 = this.pointsVertexFloats.iterator();
    i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Float)((Iterator)localObject2).next();
      if (localObject3 != null) {
        f = ((Float)localObject3).floatValue();
      } else {
        f = 0.0F;
      }
      localObject1[i] = f;
      i += 1;
    }
    localObject2 = new float[this.pointsSizeFloats.size()];
    Object localObject3 = this.pointsSizeFloats.iterator();
    i = 0;
    for (;;)
    {
      bool = ((Iterator)localObject3).hasNext();
      f = 1.0F;
      if (!bool) {
        break;
      }
      localObject4 = (Float)((Iterator)localObject3).next();
      if (localObject4 != null) {
        f = ((Float)localObject4).floatValue();
      }
      localObject2[i] = f;
      i += 1;
    }
    localObject3 = new float[this.triangleVertexFloats.size()];
    Object localObject4 = this.triangleVertexFloats.iterator();
    i = 0;
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (Float)((Iterator)localObject4).next();
      if (localObject5 != null) {
        f = ((Float)localObject5).floatValue();
      } else {
        f = 1.0F;
      }
      localObject3[i] = f;
      i += 1;
    }
    localObject4 = new float[this.triangleVertexLeftEyeFloats.size()];
    Object localObject5 = this.triangleVertexLeftEyeFloats.iterator();
    i = 0;
    while (((Iterator)localObject5).hasNext())
    {
      localObject6 = (Float)((Iterator)localObject5).next();
      if (localObject6 != null) {
        f = ((Float)localObject6).floatValue();
      } else {
        f = 1.0F;
      }
      localObject4[i] = f;
      i += 1;
    }
    localObject5 = new float[this.triangleVertexRightEyeFloats.size()];
    Object localObject6 = this.triangleVertexRightEyeFloats.iterator();
    i = 0;
    while (((Iterator)localObject6).hasNext())
    {
      Float localFloat = (Float)((Iterator)localObject6).next();
      if (localFloat != null) {
        f = localFloat.floatValue();
      } else {
        f = 1.0F;
      }
      localObject5[i] = f;
      i += 1;
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
        localObject4 = this.mouthFillColorRGBA;
        addParam(new UniformParam.Float4fParam("drawColor", localObject4[0], localObject4[1], localObject4[2], localObject4[3]));
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
      this.eye_center_shift_l = paramCartoonFaceLine.eyeCenterShiftL;
      this.eye_center_shift_r = paramCartoonFaceLine.eyeCenterShiftR;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.CartoonStylePreProcessFilter
 * JD-Core Version:    0.7.0.1
 */