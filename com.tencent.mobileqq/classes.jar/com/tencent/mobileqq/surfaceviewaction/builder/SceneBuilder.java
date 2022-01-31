package com.tencent.mobileqq.surfaceviewaction.builder;

import aiky;
import aila;
import ailb;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.DelayAction;
import com.tencent.mobileqq.surfaceviewaction.action.MoveToAction;
import com.tencent.mobileqq.surfaceviewaction.action.OpacityAction;
import com.tencent.mobileqq.surfaceviewaction.action.RotateAction;
import com.tencent.mobileqq.surfaceviewaction.action.ScaleAction;
import com.tencent.mobileqq.surfaceviewaction.action.SequenceAction;
import com.tencent.mobileqq.surfaceviewaction.gl.Frame;
import com.tencent.mobileqq.surfaceviewaction.gl.Frame.FrameData;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.ImageButton;
import com.tencent.mobileqq.surfaceviewaction.gl.Layer;
import com.tencent.mobileqq.surfaceviewaction.gl.Node;
import com.tencent.mobileqq.surfaceviewaction.gl.Point;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONArray;
import org.json.JSONObject;

public class SceneBuilder
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private SceneBuilder.IActionPositionHandler jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$IActionPositionHandler;
  private SceneBuilder.IButtonHandle jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$IButtonHandle;
  private SceneBuilder.IImageBitmapHandle jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$IImageBitmapHandle;
  private SceneBuilder.ILabelTextHandle jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$ILabelTextHandle;
  private SceneBuilder.ILayoutSizeHandler jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$ILayoutSizeHandler;
  private FrameSprite.OnFrameEndListener jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  private Action a(JSONObject paramJSONObject)
  {
    Object localObject1 = null;
    JSONObject localJSONObject = null;
    Object localObject2 = paramJSONObject.optString("type");
    String str = paramJSONObject.optString("timeType");
    int j = paramJSONObject.optInt("duration");
    if (((String)localObject2).equals("sequence")) {
      localObject1 = new SequenceAction(a(paramJSONObject.optJSONArray("actions")));
    }
    label95:
    label484:
    label487:
    for (;;)
    {
      if (localObject1 != null)
      {
        ((Action)localObject1).jdField_a_of_type_Boolean = paramJSONObject.optBoolean("isRepeat");
        if (str != null)
        {
          if (!str.equals("linear")) {
            break label446;
          }
          ((Action)localObject1).e = 0;
        }
        if ((paramJSONObject.optBoolean("autoClose", false)) && (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener != null)) {
          ((Action)localObject1).a(new ailb(this));
        }
      }
      return localObject1;
      if (((String)localObject2).equals("delay"))
      {
        localObject1 = new DelayAction(j);
      }
      else
      {
        if (((String)localObject2).equals("position"))
        {
          localJSONObject = paramJSONObject.optJSONObject("from");
          localObject2 = paramJSONObject.optJSONObject("to");
          if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$IActionPositionHandler == null) || (!"$POSITIONX$".equals(((JSONObject)localObject2).optString("x")))) {
            break label484;
          }
          Point[] arrayOfPoint = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$IActionPositionHandler.a(localJSONObject, (JSONObject)localObject2, this.jdField_a_of_type_Float);
          if ((arrayOfPoint == null) || (arrayOfPoint.length != 2)) {
            break label484;
          }
          localObject1 = new MoveToAction(j, arrayOfPoint[0].jdField_a_of_type_Float, arrayOfPoint[0].b, arrayOfPoint[1].jdField_a_of_type_Float, arrayOfPoint[1].b);
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label487;
          }
          localObject1 = new MoveToAction(j, (float)localJSONObject.optDouble("x"), (float)localJSONObject.optDouble("y"), (float)((JSONObject)localObject2).optDouble("x"), (float)((JSONObject)localObject2).optDouble("y"));
          break;
          if (((String)localObject2).equals("scale"))
          {
            localObject1 = new ScaleAction(j, (float)paramJSONObject.optDouble("from", 1.0D), (float)paramJSONObject.optDouble("to", 1.0D));
            break;
          }
          if (((String)localObject2).equals("alpha"))
          {
            localObject1 = new OpacityAction(j, (int)(paramJSONObject.optDouble("from", 1.0D) * 255.0D), (int)(paramJSONObject.optDouble("to", 1.0D) * 255.0D));
            break;
          }
          localObject1 = localJSONObject;
          if (!((String)localObject2).equals("rotate")) {
            break;
          }
          localObject1 = new RotateAction(j, paramJSONObject.optInt("from", 0), paramJSONObject.optInt("to", 0));
          break;
          if (str.equals("easeIn"))
          {
            ((Action)localObject1).e = 1;
            break label95;
          }
          if (!str.equals("easeOut")) {
            break label95;
          }
          ((Action)localObject1).e = 2;
          break label95;
        }
      }
    }
  }
  
  private Layer a(SpriteGLView paramSpriteGLView, String paramString)
  {
    Layer localLayer = new Layer(paramSpriteGLView);
    if (paramString == null) {
      return localLayer;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        Object localObject = paramString.optJSONObject("size");
        i = ((JSONObject)localObject).optInt("width");
        int j = ((JSONObject)localObject).optInt("height");
        this.jdField_a_of_type_Float = (this.jdField_a_of_type_Int / i);
        paramString = paramString.optJSONArray("scene");
        if (paramString != null)
        {
          int k = paramString.length();
          i = 0;
          if (i < k)
          {
            localObject = a(paramSpriteGLView, paramString.getJSONObject(i), localLayer);
            if (localObject == null) {
              break label229;
            }
            localLayer.a((Node)localObject);
            break label229;
          }
        }
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        paramString = paramSpriteGLView.getLayoutParams();
        paramString.width = this.jdField_a_of_type_Int;
        paramString.height = ((int)(j * this.jdField_a_of_type_Float));
        paramSpriteGLView.setLayoutParams(paramString);
        localLayer.e = this.jdField_a_of_type_Float;
        if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$ILayoutSizeHandler == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$ILayoutSizeHandler.a(paramString.width, paramString.height);
        return localLayer;
      }
      catch (Exception paramSpriteGLView) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SceneBuilder", 2, "buildFromJson" + QLog.getStackTraceString(paramSpriteGLView));
      return localLayer;
      label229:
      i += 1;
    }
  }
  
  private Node a(SpriteGLView paramSpriteGLView, JSONObject paramJSONObject, Layer paramLayer)
  {
    Object localObject1 = null;
    Object localObject2 = paramJSONObject.optString("type");
    label40:
    Object localObject3;
    Object localObject5;
    if ("layer".equals(localObject2))
    {
      localObject1 = new Layer(paramSpriteGLView);
      if (localObject1 == null)
      {
        localObject2 = null;
        return localObject2;
      }
    }
    else if ("image".equals(localObject2))
    {
      localObject1 = null;
      localObject3 = paramJSONObject.optString("path");
      localObject5 = paramJSONObject.optString("event");
      if (TextUtils.isEmpty((CharSequence)localObject5))
      {
        localObject2 = new Sprite(paramSpriteGLView);
        label93:
        if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$IImageBitmapHandle != null) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$IImageBitmapHandle.a((Sprite)localObject2, this.jdField_a_of_type_JavaLangString, (String)localObject3);
        }
        if (localObject1 != null) {
          break label294;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = ImageUtil.a(this.jdField_a_of_type_JavaLangString + "/" + (String)localObject3, null);
        localObject1 = localObject2;
        if (localObject3 == null) {
          break;
        }
        localObject1 = paramJSONObject.optJSONObject("size");
        if (localObject1 == null) {
          break label795;
        }
        localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject3, ((JSONObject)localObject1).optInt("width"), ((JSONObject)localObject1).optInt("height"), true);
        ((Sprite)localObject2).a(paramSpriteGLView, (Bitmap)localObject1);
        localObject1 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (!QLog.isColorLevel()) {
          break label294;
        }
        QLog.e("SceneBuilder", 2, "buildNode" + QLog.getStackTraceString(localOutOfMemoryError));
      }
      localObject2 = new ImageButton(paramSpriteGLView, true);
      ((ImageButton)localObject2).a(new aila(this, paramLayer, (String)localObject5));
      break label93;
      label294:
      Object localObject4 = localObject1;
      continue;
      if ("video".equals(localObject2))
      {
        localObject1 = new VideoSprite(paramSpriteGLView, paramSpriteGLView.getContext(), true);
        ((VideoSprite)localObject1).b(this.jdField_a_of_type_JavaLangString + "/" + paramJSONObject.optString("path"));
        if (paramJSONObject.optBoolean("isKey", false)) {
          paramSpriteGLView.setVideoTimeGetter((VideoSprite)localObject1);
        }
        if (paramJSONObject.optBoolean("autoClose", false)) {
          ((VideoSprite)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener);
        }
        ((VideoSprite)localObject1).a(paramJSONObject.optBoolean("isLooping", false));
        break;
      }
      if (!"label".equals(localObject2)) {
        break;
      }
      localObject1 = a(paramSpriteGLView, paramJSONObject);
      break;
      ((Node)localObject1).jdField_a_of_type_JavaLangString = paramJSONObject.optString("name");
      ((Node)localObject1).c = ((float)paramJSONObject.optDouble("x", 0.0D));
      ((Node)localObject1).d = ((float)paramJSONObject.optDouble("y", 0.0D));
      ((Node)localObject1).b = ((int)(paramJSONObject.optDouble("alpha", 1.0D) * 255.0D));
      ((Node)localObject1).e *= (float)paramJSONObject.optDouble("scale", 1.0D);
      ((Node)localObject1).f = ((float)paramJSONObject.optDouble("rotate", 0.0D));
      localObject2 = paramJSONObject.optJSONArray("actions");
      if (localObject2 != null) {
        ((Node)localObject1).a(a((JSONArray)localObject2));
      }
      localObject4 = paramJSONObject.optJSONObject("frames");
      if (localObject4 != null)
      {
        localObject2 = new Frame();
        ((Frame)localObject2).jdField_a_of_type_Int = ((JSONObject)localObject4).optInt("fps");
        localObject4 = ((JSONObject)localObject4).optJSONArray("datas");
        j = ((JSONArray)localObject4).length();
        ((Frame)localObject2).jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlFrame$FrameData = new Frame.FrameData[j];
        i = 0;
        while (i < j)
        {
          ((Frame)localObject2).jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlFrame$FrameData[i] = new Frame.FrameData();
          localObject5 = ((JSONArray)localObject4).optJSONObject(i);
          localObject2.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlFrame$FrameData[i].jdField_a_of_type_Float = ((JSONObject)localObject5).optInt("x");
          localObject2.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlFrame$FrameData[i].b = ((JSONObject)localObject5).optInt("y");
          i += 1;
        }
        ((Node)localObject1).jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrame = ((Frame)localObject2);
      }
      localObject2 = localObject1;
      if (!(localObject1 instanceof Layer)) {
        break label40;
      }
      localObject4 = (Layer)localObject1;
      paramJSONObject = paramJSONObject.optJSONArray("children");
      int j = paramJSONObject.length();
      int i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= j) {
          break;
        }
        localObject2 = a(paramSpriteGLView, paramJSONObject.getJSONObject(i), paramLayer);
        if (localObject2 != null) {
          ((Layer)localObject4).a((Node)localObject2);
        }
        i += 1;
      }
      label795:
      localObject1 = localObject4;
    }
  }
  
  private Sprite a(SpriteGLView paramSpriteGLView, JSONObject paramJSONObject)
  {
    Object localObject1 = paramJSONObject.optString("text");
    Sprite localSprite = new Sprite(paramSpriteGLView);
    localSprite.e = 0.25F;
    Object localObject2 = localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$ILabelTextHandle != null) {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$ILabelTextHandle.a(localSprite, (String)localObject1);
    }
    int n = paramJSONObject.optInt("textSize", 20) * 4;
    int i = Color.parseColor(paramJSONObject.optString("textColor"));
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setColor(i);
    localPaint.setTextSize(n);
    Object localObject4 = paramJSONObject.optJSONObject("size");
    int m = (int)localPaint.measureText((String)localObject2);
    Object localObject3 = paramJSONObject.optString("imageRight");
    int i1 = paramJSONObject.optInt("imagePadding") * 4;
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$IImageBitmapHandle != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$IImageBitmapHandle.a(localSprite, this.jdField_a_of_type_JavaLangString, (String)localObject3);
        if (localObject1 != null) {}
      }
    }
    for (;;)
    {
      int j;
      int k;
      float f6;
      float f2;
      float f5;
      float f3;
      try
      {
        localObject3 = ImageUtil.a(this.jdField_a_of_type_JavaLangString + "/" + (String)localObject3, null);
        localObject1 = localObject3;
        if (localObject1 == null) {
          break label746;
        }
        i = ((Bitmap)localObject1).getWidth();
        j = ((Bitmap)localObject1).getHeight();
        j *= 4;
        i *= 4;
        if (localObject4 == null) {
          break label739;
        }
        m = ((JSONObject)localObject4).optInt("width") * 4;
        k = ((JSONObject)localObject4).optInt("height");
        localObject2 = a(m - i - i1, (String)localObject2, localPaint);
        k *= 4;
        int i2 = (int)localPaint.measureText((String)localObject2);
        i = i + i2 + i1;
        float f7;
        float f4;
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        try
        {
          localObject3 = Bitmap.createBitmap(m, k, Bitmap.Config.ARGB_8888);
          localObject4 = new Canvas((Bitmap)localObject3);
          ((Canvas)localObject4).drawColor(-16777216, PorterDuff.Mode.CLEAR);
          f7 = n;
          f4 = 0.0F;
          f6 = 0.0F;
          f2 = 0.0F;
          f5 = 0.0F;
          f1 = 0.0F;
          f3 = 0.0F;
          paramJSONObject = paramJSONObject.optString("gravity");
          if (paramJSONObject != null)
          {
            if (!paramJSONObject.contains("left")) {
              break label683;
            }
            f1 = 0.0F;
            if (!paramJSONObject.contains("top")) {
              break label706;
            }
            f2 = 0.0F;
            f4 = f1;
            f1 = f3;
            if (paramJSONObject.equals("center"))
            {
              f4 = (m - i) / 2;
              f2 = (k - n) / 2;
              f1 = (k - j) / 2;
            }
            f3 = f4;
            if (paramJSONObject.contains("center_horizontal")) {
              f3 = (m - i) / 2;
            }
            f4 = f3;
            if (paramJSONObject.contains("center_vertical"))
            {
              f2 = (k - n) / 2;
              f1 = (k - j) / 2;
              f4 = f3;
            }
          }
          ((Canvas)localObject4).drawText((String)localObject2, f4, f2 + f7 * 0.8F, localPaint);
          if (localObject1 != null)
          {
            paramJSONObject = new Matrix();
            paramJSONObject.postScale(4.0F, 4.0F);
            paramJSONObject.postTranslate(i1 + f4 + i2, f1);
            ((Canvas)localObject4).drawBitmap((Bitmap)localObject1, paramJSONObject, localPaint);
          }
          localSprite.a(paramSpriteGLView, (Bitmap)localObject3);
          return localSprite;
        }
        catch (OutOfMemoryError paramSpriteGLView)
        {
          if (!QLog.isColorLevel()) {
            break label680;
          }
          QLog.e("SceneBuilder", 2, "buildLabel" + QLog.getStackTraceString(paramSpriteGLView));
          return localSprite;
        }
        localOutOfMemoryError = localOutOfMemoryError;
        if (QLog.isColorLevel()) {
          QLog.e("SceneBuilder", 2, "buildLabel" + QLog.getStackTraceString(localOutOfMemoryError));
        }
      }
      label680:
      label683:
      float f1 = f6;
      if (paramJSONObject.contains("right"))
      {
        f1 = m - i;
        continue;
        label706:
        f2 = f5;
        if (paramJSONObject.contains("bottom"))
        {
          f2 = k - n;
          f3 = k - j;
          continue;
          label739:
          k = n;
          continue;
          label746:
          j = 0;
          i = 0;
          continue;
          localObject1 = null;
          break;
          localObject1 = null;
          j = 0;
          i = 0;
        }
      }
    }
  }
  
  private String a(int paramInt, String paramString, Paint paramPaint)
  {
    String str2 = "";
    if (paramInt <= 0) {}
    float f;
    do
    {
      return paramString;
      f = paramPaint.measureText("...");
    } while ((int)Math.ceil(paramPaint.measureText(paramString)) <= paramInt);
    int i = paramString.length() - 1;
    for (;;)
    {
      String str1 = str2;
      if (i > 0)
      {
        if ((int)Math.ceil(paramPaint.measureText(paramString, 0, i) + f) <= paramInt) {
          str1 = paramString.substring(0, i) + "...";
        }
      }
      else {
        return str1;
      }
      i -= 1;
    }
  }
  
  public static boolean a(File paramFile)
  {
    StringBuffer localStringBuffer;
    Object localObject;
    if (paramFile.exists())
    {
      localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramFile.getAbsolutePath()).append(File.separator).append("check.ini");
      localObject = new File(localStringBuffer.toString());
      if (((File)localObject).exists()) {}
    }
    else
    {
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        localObject = FileUtils.b((File)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        localObject = ((String)localObject).split("&");
        if (localObject == null) {
          break;
        }
        i = 0;
        if (i >= localObject.length) {
          break label225;
        }
        if (localObject[i].startsWith("﻿")) {
          localObject[i] = localObject[i].replace("﻿", "");
        }
        localStringBuffer.setLength(0);
        localStringBuffer.append(paramFile.getAbsolutePath()).append(File.separator).append(localObject[i]);
        File localFile = new File(localStringBuffer.toString());
        if (localFile.exists()) {
          break label218;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("SceneBuilder", 2, "isAnimationPackageValid File not exist:" + localFile.getName());
        return false;
      }
      catch (IOException paramFile) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SceneBuilder", 2, "isAnimationPackageValid IOException");
      return false;
      label218:
      i += 1;
    }
    label225:
    return true;
  }
  
  private Action[] a(JSONArray paramJSONArray)
  {
    int j = paramJSONArray.length();
    Action[] arrayOfAction = new Action[j];
    int i = 0;
    while (i < j)
    {
      arrayOfAction[i] = a(paramJSONArray.optJSONObject(i));
      i += 1;
    }
    return arrayOfAction;
  }
  
  private static String b(String paramString)
  {
    try
    {
      localInputStreamReader = new InputStreamReader(new FileInputStream(new File(paramString)));
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        label66:
        localBufferedReader = null;
        InputStreamReader localInputStreamReader = null;
      }
    }
    try
    {
      localBufferedReader = new BufferedReader(localInputStreamReader);
      try
      {
        paramString = new StringBuilder();
        for (;;)
        {
          String str = localBufferedReader.readLine();
          if (str == null) {
            break;
          }
          paramString.append(str);
          paramString.append('\n');
        }
        paramString.printStackTrace();
      }
      catch (Exception paramString) {}
    }
    catch (Exception paramString)
    {
      localBufferedReader = null;
      break label66;
    }
    if (localBufferedReader != null) {}
    try
    {
      localBufferedReader.close();
      if (localInputStreamReader != null) {}
      try
      {
        localInputStreamReader.close();
        return null;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      localBufferedReader.close();
      localInputStreamReader.close();
      paramString = paramString.toString();
      return paramString;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public SceneBuilder a(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public SceneBuilder a(SceneBuilder.IActionPositionHandler paramIActionPositionHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$IActionPositionHandler = paramIActionPositionHandler;
    return this;
  }
  
  public SceneBuilder a(SceneBuilder.IButtonHandle paramIButtonHandle)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$IButtonHandle = paramIButtonHandle;
    return this;
  }
  
  public SceneBuilder a(SceneBuilder.IImageBitmapHandle paramIImageBitmapHandle)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$IImageBitmapHandle = paramIImageBitmapHandle;
    return this;
  }
  
  public SceneBuilder a(SceneBuilder.ILabelTextHandle paramILabelTextHandle)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$ILabelTextHandle = paramILabelTextHandle;
    return this;
  }
  
  public SceneBuilder a(SceneBuilder.ILayoutSizeHandler paramILayoutSizeHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$ILayoutSizeHandler = paramILayoutSizeHandler;
    return this;
  }
  
  public SceneBuilder a(FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener = paramOnFrameEndListener;
    return this;
  }
  
  public SceneBuilder a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public void a(SpriteGLView paramSpriteGLView, SceneBuilder.OnBuiltListener paramOnBuiltListener)
  {
    ThreadManager.post(new aiky(this, paramSpriteGLView, paramOnBuiltListener), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder
 * JD-Core Version:    0.7.0.1
 */