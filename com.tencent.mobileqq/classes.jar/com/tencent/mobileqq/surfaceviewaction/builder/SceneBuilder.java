package com.tencent.mobileqq.surfaceviewaction.builder;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.surfaceviewaction.BaseNode;
import com.tencent.mobileqq.surfaceviewaction.Frame;
import com.tencent.mobileqq.surfaceviewaction.Frame.FrameData;
import com.tencent.mobileqq.surfaceviewaction.ILayer;
import com.tencent.mobileqq.surfaceviewaction.ISprite;
import com.tencent.mobileqq.surfaceviewaction.ISpriteView;
import com.tencent.mobileqq.surfaceviewaction.Point;
import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.DelayAction;
import com.tencent.mobileqq.surfaceviewaction.action.MoveToAction;
import com.tencent.mobileqq.surfaceviewaction.action.OpacityAction;
import com.tencent.mobileqq.surfaceviewaction.action.RotateAction;
import com.tencent.mobileqq.surfaceviewaction.action.ScaleAction;
import com.tencent.mobileqq.surfaceviewaction.action.SequenceAction;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView.IVideoTimeGetter;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
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
  
  private BaseNode a(ISpriteView paramISpriteView, JSONObject paramJSONObject)
  {
    boolean bool = paramISpriteView instanceof SpriteGLView;
    int j;
    if (bool) {
      j = 4;
    } else {
      j = 1;
    }
    Object localObject1 = paramJSONObject.optString("text");
    if (bool) {
      localObject3 = new com.tencent.mobileqq.surfaceviewaction.gl.Sprite((SpriteGLView)paramISpriteView);
    } else {
      localObject3 = new com.tencent.mobileqq.surfaceviewaction.nv.Sprite((SpriteNativeView)paramISpriteView);
    }
    float f4 = j;
    ((BaseNode)localObject3).c(1.0F / f4);
    Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$ILabelTextHandle;
    Object localObject2 = localObject1;
    if (localObject4 != null) {
      localObject2 = ((SceneBuilder.ILabelTextHandle)localObject4).a((ISprite)localObject3, (String)localObject1);
    }
    int k = paramJSONObject.optInt("textSize", 20) * j;
    int i = Color.parseColor(paramJSONObject.optString("textColor"));
    Object localObject5 = new Paint();
    ((Paint)localObject5).setAntiAlias(true);
    ((Paint)localObject5).setColor(i);
    float f1 = k;
    ((Paint)localObject5).setTextSize(f1);
    Object localObject6 = paramJSONObject.optJSONObject("size");
    i = (int)((Paint)localObject5).measureText((String)localObject2);
    String str = paramJSONObject.optString("imageRight");
    int i2 = paramJSONObject.optInt("imagePadding") * j;
    bool = TextUtils.isEmpty(str);
    int i3 = 0;
    if (!bool)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$IImageBitmapHandle;
      if (localObject1 != null) {
        localObject1 = ((SceneBuilder.IImageBitmapHandle)localObject1).a((ISprite)localObject3, this.jdField_a_of_type_JavaLangString, str);
      } else {
        localObject1 = null;
      }
      localObject4 = localObject1;
      if (localObject1 == null) {}
      try
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject4).append("/");
        ((StringBuilder)localObject4).append(str);
        localObject4 = ImageUtil.a(((StringBuilder)localObject4).toString(), null);
        localObject1 = localObject4;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        do
        {
          localObject4 = localObject1;
        } while (!QLog.isColorLevel());
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("buildLabel");
        ((StringBuilder)localObject4).append(QLog.getStackTraceString(localOutOfMemoryError));
        QLog.e("SceneBuilder", 2, ((StringBuilder)localObject4).toString());
      }
      localObject4 = localObject1;
      if (localObject1 != null)
      {
        n = ((Bitmap)localObject1).getWidth() * j;
        m = ((Bitmap)localObject1).getHeight() * j;
        break label410;
      }
    }
    else
    {
      localObject4 = null;
    }
    int n = 0;
    int m = 0;
    localObject1 = localObject4;
    label410:
    localObject4 = localObject3;
    int i1;
    if (localObject6 != null)
    {
      if (((JSONObject)localObject6).optInt("width") != 0) {
        i = ((JSONObject)localObject6).optInt("width") * j;
      }
      if (((JSONObject)localObject6).optInt("height") != 0) {
        j = ((JSONObject)localObject6).optInt("height") * j;
      } else {
        j = k;
      }
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$ILabelTextHandle;
      if (localObject3 != null) {
        ((SceneBuilder.ILabelTextHandle)localObject3).a(i - n - i2, (String)localObject2, (Paint)localObject5);
      }
      localObject2 = a(i - n - i2, (String)localObject2, (Paint)localObject5);
      i1 = i;
    }
    else
    {
      j = k;
      i1 = i;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$ILabelTextHandle;
    if (localObject3 != null) {
      i = ((SceneBuilder.ILabelTextHandle)localObject3).a(i1, n, i2, (String)localObject2, (Paint)localObject5);
    } else {
      i = i3;
    }
    localObject3 = localObject5;
    localObject5 = localObject1;
    if (i == 0) {
      i = (int)((Paint)localObject3).measureText((String)localObject2);
    }
    localObject1 = localObject3;
    n = n + i + i2;
    try
    {
      localObject3 = Bitmap.createBitmap(i1, j, Bitmap.Config.ARGB_8888);
      localObject6 = new Canvas((Bitmap)localObject3);
      ((Canvas)localObject6).drawColor(-16777216, PorterDuff.Mode.CLEAR);
      float f5 = f1 * 0.8F;
      paramJSONObject = paramJSONObject.optString("gravity");
      float f2;
      float f3;
      if (paramJSONObject != null)
      {
        if ((!paramJSONObject.contains("left")) && (paramJSONObject.contains("right"))) {
          f1 = i1 - n;
        } else {
          f1 = 0.0F;
        }
        if ((!paramJSONObject.contains("top")) && (paramJSONObject.contains("bottom")))
        {
          f2 = j - k;
          f3 = j - m;
        }
        else
        {
          f3 = 0.0F;
          f2 = 0.0F;
        }
        if (paramJSONObject.equals("center"))
        {
          f1 = (i1 - n) / 2;
          f2 = (j - k) / 2;
          f3 = (j - m) / 2;
        }
        if (paramJSONObject.contains("center_horizontal")) {
          f1 = (i1 - n) / 2;
        }
        if (paramJSONObject.contains("center_vertical"))
        {
          f2 = (j - k) / 2;
          f3 = (j - m) / 2;
        }
      }
      else
      {
        f1 = 0.0F;
        f2 = 0.0F;
        f3 = 0.0F;
      }
      SceneBuilder.ILabelTextHandle localILabelTextHandle = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$ILabelTextHandle;
      if (localILabelTextHandle != null)
      {
        paramJSONObject = (JSONObject)localObject1;
        if (localILabelTextHandle.a((Canvas)localObject6, (String)localObject2, f1, f2, f5, i1, j, paramJSONObject))
        {
          localObject1 = paramJSONObject;
          break label902;
        }
      }
      ((Canvas)localObject6).drawText((String)localObject2, f1, f2 + f5, (Paint)localObject1);
      label902:
      if (localObject5 != null)
      {
        paramJSONObject = new Matrix();
        paramJSONObject.postScale(f4, f4);
        paramJSONObject.postTranslate(f1 + i2 + i, f3);
        ((Canvas)localObject6).drawBitmap((Bitmap)localObject5, paramJSONObject, (Paint)localObject1);
      }
      ((ISprite)localObject4).a(paramISpriteView, (Bitmap)localObject3);
      return localObject4;
    }
    catch (OutOfMemoryError paramISpriteView)
    {
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("buildLabel");
        paramJSONObject.append(QLog.getStackTraceString(paramISpriteView));
        QLog.e("SceneBuilder", 2, paramJSONObject.toString());
      }
    }
    return localObject4;
  }
  
  private BaseNode a(ISpriteView paramISpriteView, JSONObject paramJSONObject, ILayer paramILayer)
  {
    Object localObject1 = paramJSONObject.optString("type");
    boolean bool = "layer".equals(localObject1);
    int j = 0;
    label194:
    label228:
    int i;
    int k;
    Object localObject4;
    if (bool)
    {
      if ((paramISpriteView instanceof SpriteGLView)) {
        localObject1 = new com.tencent.mobileqq.surfaceviewaction.gl.Layer((SpriteGLView)paramISpriteView);
      } else {
        localObject1 = new com.tencent.mobileqq.surfaceviewaction.nv.Layer((SpriteNativeView)paramISpriteView);
      }
    }
    else
    {
      if ("image".equals(localObject1))
      {
        String str = paramJSONObject.optString("path");
        localObject2 = paramJSONObject.optString("event");
        if ((paramISpriteView instanceof SpriteGLView))
        {
          localObject1 = (SpriteGLView)paramISpriteView;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = new com.tencent.mobileqq.surfaceviewaction.gl.Sprite((SpriteGLView)localObject1);
          }
          else
          {
            localObject1 = new com.tencent.mobileqq.surfaceviewaction.gl.ImageButton((SpriteGLView)localObject1, true, (String)localObject2);
            ((com.tencent.mobileqq.surfaceviewaction.gl.ImageButton)localObject1).a(new SceneBuilder.2(this, paramILayer, (String)localObject2));
            break label228;
          }
        }
        else
        {
          localObject1 = (SpriteNativeView)paramISpriteView;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label194;
          }
          localObject1 = new com.tencent.mobileqq.surfaceviewaction.nv.Sprite((SpriteNativeView)localObject1);
        }
        break label228;
        localObject1 = new com.tencent.mobileqq.surfaceviewaction.nv.ImageButton((SpriteNativeView)localObject1, (String)localObject2);
        ((com.tencent.mobileqq.surfaceviewaction.nv.ImageButton)localObject1).a(new SceneBuilder.3(this, paramILayer, (BaseNode)localObject1, (String)localObject2));
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$IImageBitmapHandle;
        if (localObject2 != null) {
          localObject3 = ((SceneBuilder.IImageBitmapHandle)localObject2).a((ISprite)localObject1, this.jdField_a_of_type_JavaLangString, str);
        } else {
          localObject3 = null;
        }
        localObject2 = localObject3;
        if (localObject3 == null) {
          try
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject2).append("/");
            ((StringBuilder)localObject2).append(str);
            localObject2 = ImageUtil.a(((StringBuilder)localObject2).toString(), null);
          }
          catch (OutOfMemoryError localOutOfMemoryError1)
          {
            localObject2 = localObject3;
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("buildNode");
              ((StringBuilder)localObject2).append(QLog.getStackTraceString(localOutOfMemoryError1));
              QLog.e("SceneBuilder", 2, ((StringBuilder)localObject2).toString());
              localObject2 = localObject3;
            }
          }
        }
        localObject3 = localObject1;
        if (localObject2 != null)
        {
          JSONObject localJSONObject = paramJSONObject.optJSONObject("size");
          localObject3 = localObject2;
          if (localJSONObject != null)
          {
            i = localJSONObject.optInt("width");
            k = localJSONObject.optInt("height");
            try
            {
              localObject3 = Bitmap.createScaledBitmap((Bitmap)localObject2, i, k, true);
            }
            catch (OutOfMemoryError localOutOfMemoryError2)
            {
              localObject3 = localObject2;
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("buildNode");
                ((StringBuilder)localObject3).append(QLog.getStackTraceString(localOutOfMemoryError2));
                QLog.e("SceneBuilder", 2, ((StringBuilder)localObject3).toString());
                localObject3 = localObject2;
              }
            }
          }
          ((ISprite)localObject1).a(paramISpriteView, (Bitmap)localObject3);
          localObject3 = localObject1;
        }
      }
      else
      {
        if (!"video".equals(localObject1)) {
          break label757;
        }
        if (!(paramISpriteView instanceof SpriteGLView)) {
          break label670;
        }
        localObject1 = (SpriteGLView)paramISpriteView;
        localObject3 = new com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite((SpriteGLView)localObject1, ((SpriteGLView)localObject1).getContext(), true);
        localObject2 = (com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite)localObject3;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject4).append("/");
        ((StringBuilder)localObject4).append(paramJSONObject.optString("path"));
        ((com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite)localObject2).c(((StringBuilder)localObject4).toString());
        if (paramJSONObject.optBoolean("isKey", false)) {
          ((SpriteGLView)localObject1).setVideoTimeGetter((SpriteGLView.IVideoTimeGetter)localObject2);
        }
        if (paramJSONObject.optBoolean("autoClose", false)) {
          ((com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener);
        }
        ((com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite)localObject2).a(paramJSONObject.optBoolean("isLooping", false));
      }
      localObject1 = localObject3;
      break label782;
      label670:
      localObject1 = (SpriteNativeView)paramISpriteView;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("/");
      ((StringBuilder)localObject2).append(paramJSONObject.optString("path"));
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = new com.tencent.mobileqq.surfaceviewaction.nv.VideoSprite((SpriteNativeView)localObject1, (String)localObject2);
      ((com.tencent.mobileqq.surfaceviewaction.nv.VideoSprite)localObject1).a((String)localObject2, paramJSONObject.optBoolean("isLooping", false));
      break label782;
      label757:
      if ("label".equals(localObject1)) {
        localObject1 = a(paramISpriteView, paramJSONObject);
      } else {
        localObject1 = null;
      }
    }
    label782:
    if (localObject1 == null) {
      return null;
    }
    ((BaseNode)localObject1).a(paramJSONObject.optString("name"));
    ((BaseNode)localObject1).a(paramJSONObject.optInt("tag"));
    ((BaseNode)localObject1).a((float)paramJSONObject.optDouble("x", 0.0D));
    ((BaseNode)localObject1).b((float)paramJSONObject.optDouble("y", 0.0D));
    ((BaseNode)localObject1).b((int)(paramJSONObject.optDouble("alpha", 1.0D) * 255.0D));
    ((BaseNode)localObject1).c(((BaseNode)localObject1).a() * (float)paramJSONObject.optDouble("scale", 1.0D));
    ((BaseNode)localObject1).d((float)paramJSONObject.optDouble("rotate", 0.0D));
    ((BaseNode)localObject1).e(((BaseNode)paramILayer).a());
    Object localObject2 = paramJSONObject.optJSONArray("actions");
    if (localObject2 != null) {
      ((BaseNode)localObject1).a(a((JSONArray)localObject2));
    }
    Object localObject3 = paramJSONObject.optJSONObject("frames");
    if (localObject3 != null)
    {
      localObject2 = new Frame();
      ((Frame)localObject2).jdField_a_of_type_Int = ((JSONObject)localObject3).optInt("fps");
      localObject3 = ((JSONObject)localObject3).optJSONArray("datas");
      k = ((JSONArray)localObject3).length();
      ((Frame)localObject2).jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionFrame$FrameData = new Frame.FrameData[k];
      i = 0;
      while (i < k)
      {
        ((Frame)localObject2).jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionFrame$FrameData[i] = new Frame.FrameData();
        localObject4 = ((JSONArray)localObject3).optJSONObject(i);
        localObject2.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionFrame$FrameData[i].jdField_a_of_type_Float = ((JSONObject)localObject4).optInt("x");
        localObject2.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionFrame$FrameData[i].b = ((JSONObject)localObject4).optInt("y");
        i += 1;
      }
      ((BaseNode)localObject1).a((Frame)localObject2);
    }
    localObject2 = paramJSONObject.optString("horizontal_align");
    if (localObject2 != null) {
      if (((String)localObject2).equals("left")) {
        ((BaseNode)localObject1).c(0);
      } else if (((String)localObject2).equals("right")) {
        ((BaseNode)localObject1).c(1);
      } else if (((String)localObject2).equals("center")) {
        ((BaseNode)localObject1).c(2);
      }
    }
    localObject2 = paramJSONObject.optString("vertical_align");
    if (localObject2 != null) {
      if (((String)localObject2).equals("top")) {
        ((BaseNode)localObject1).d(0);
      } else if (((String)localObject2).equals("bottom")) {
        ((BaseNode)localObject1).d(1);
      } else if (((String)localObject2).equals("center")) {
        ((BaseNode)localObject1).d(2);
      }
    }
    if ((localObject1 instanceof ILayer))
    {
      localObject2 = (ILayer)localObject1;
      paramJSONObject = paramJSONObject.optJSONArray("children");
      k = paramJSONObject.length();
      i = j;
      while (i < k)
      {
        localObject3 = a(paramISpriteView, paramJSONObject.getJSONObject(i), paramILayer);
        if (localObject3 != null) {
          ((ILayer)localObject2).a((BaseNode)localObject3);
        }
        i += 1;
      }
    }
    return localObject1;
  }
  
  private ILayer a(ISpriteView paramISpriteView, String paramString)
  {
    if ((paramISpriteView instanceof SpriteGLView)) {
      localObject1 = new com.tencent.mobileqq.surfaceviewaction.gl.Layer((SpriteGLView)paramISpriteView);
    } else {
      localObject1 = new com.tencent.mobileqq.surfaceviewaction.nv.Layer((SpriteNativeView)paramISpriteView);
    }
    if (paramString == null) {
      return localObject1;
    }
    try
    {
      paramString = new JSONObject(paramString);
      Object localObject2 = paramString.optJSONObject("size");
      int i = ((JSONObject)localObject2).optInt("width");
      int j = ((JSONObject)localObject2).optInt("height");
      this.jdField_a_of_type_Float = (this.jdField_a_of_type_Int / i);
      if (this.jdField_a_of_type_Boolean)
      {
        localObject2 = ((ViewGroup)paramISpriteView).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = this.jdField_a_of_type_Int;
        ((ViewGroup.LayoutParams)localObject2).height = ((int)(j * this.jdField_a_of_type_Float));
        ((ViewGroup)paramISpriteView).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((BaseNode)localObject1).c(this.jdField_a_of_type_Float);
        if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$ILayoutSizeHandler != null) {
          this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$ILayoutSizeHandler.a(((ViewGroup.LayoutParams)localObject2).width, ((ViewGroup.LayoutParams)localObject2).height);
        }
      }
      paramString = paramString.optJSONArray("scene");
      if (paramString != null)
      {
        j = paramString.length();
        i = 0;
        while (i < j)
        {
          localObject2 = a(paramISpriteView, paramString.getJSONObject(i), (ILayer)localObject1);
          if (localObject2 != null) {
            ((ILayer)localObject1).a((BaseNode)localObject2);
          }
          i += 1;
        }
      }
      return localObject1;
    }
    catch (Exception paramISpriteView)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("buildFromJson");
        paramString.append(QLog.getStackTraceString(paramISpriteView));
        QLog.e("SceneBuilder", 2, paramString.toString());
      }
    }
  }
  
  private Action a(JSONObject paramJSONObject)
  {
    Object localObject2 = paramJSONObject.optString("type");
    String str = paramJSONObject.optString("timeType");
    int j = paramJSONObject.optInt("duration");
    boolean bool = ((String)localObject2).equals("sequence");
    Object localObject1 = null;
    if (bool)
    {
      localObject1 = new SequenceAction(a(paramJSONObject.optJSONArray("actions")));
    }
    else if (((String)localObject2).equals("delay"))
    {
      localObject1 = new DelayAction(j);
    }
    else if (((String)localObject2).equals("position"))
    {
      localObject2 = paramJSONObject.optJSONObject("from");
      JSONObject localJSONObject = paramJSONObject.optJSONObject("to");
      if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$IActionPositionHandler != null) && ("$POSITIONX$".equals(localJSONObject.optString("x"))))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionBuilderSceneBuilder$IActionPositionHandler.a((JSONObject)localObject2, localJSONObject, this.jdField_a_of_type_Float);
        if ((localObject1 != null) && (localObject1.length == 2))
        {
          localObject1 = new MoveToAction(j, localObject1[0].jdField_a_of_type_Float, localObject1[0].b, localObject1[1].jdField_a_of_type_Float, localObject1[1].b);
          i = 1;
          break label223;
        }
      }
      localObject1 = null;
      int i = 0;
      label223:
      if (i == 0) {
        localObject1 = new MoveToAction(j, (float)((JSONObject)localObject2).optDouble("x"), (float)((JSONObject)localObject2).optDouble("y"), (float)localJSONObject.optDouble("x"), (float)localJSONObject.optDouble("y"));
      }
    }
    else if (((String)localObject2).equals("scale"))
    {
      localObject1 = new ScaleAction(j, (float)paramJSONObject.optDouble("from", 1.0D), (float)paramJSONObject.optDouble("to", 1.0D));
    }
    else if (((String)localObject2).equals("alpha"))
    {
      localObject1 = new OpacityAction(j, (int)(paramJSONObject.optDouble("from", 1.0D) * 255.0D), (int)(paramJSONObject.optDouble("to", 1.0D) * 255.0D));
    }
    else if (((String)localObject2).equals("rotate"))
    {
      localObject1 = new RotateAction(j, paramJSONObject.optInt("from", 0), paramJSONObject.optInt("to", 0));
    }
    if (localObject1 != null)
    {
      ((Action)localObject1).jdField_a_of_type_Boolean = paramJSONObject.optBoolean("isRepeat");
      if (str != null) {
        if (str.equals("linear")) {
          ((Action)localObject1).e = 0;
        } else if (str.equals("easeIn")) {
          ((Action)localObject1).e = 1;
        } else if (str.equals("easeOut")) {
          ((Action)localObject1).e = 2;
        }
      }
      if ((paramJSONObject.optBoolean("autoClose", false)) && (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener != null)) {
        ((Action)localObject1).a(new SceneBuilder.4(this));
      }
    }
    return localObject1;
  }
  
  public static String a(int paramInt, String paramString, Paint paramPaint)
  {
    if (paramInt <= 0) {
      return paramString;
    }
    float f = paramPaint.measureText("...");
    if ((int)Math.ceil(paramPaint.measureText(paramString)) <= paramInt) {
      return paramString;
    }
    int i = paramString.length() - 1;
    while (i > 0)
    {
      if ((int)Math.ceil(paramPaint.measureText(paramString, 0, i) + f) <= paramInt)
      {
        paramPaint = new StringBuilder();
        paramPaint.append(paramString.substring(0, i));
        paramPaint.append("...");
        return paramPaint.toString();
      }
      i -= 1;
    }
    return "";
  }
  
  public static boolean a(File paramFile)
  {
    if (paramFile.exists())
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramFile.getAbsolutePath());
      localStringBuffer.append(File.separator);
      localStringBuffer.append("check.ini");
      Object localObject = new File(localStringBuffer.toString());
      if (!((File)localObject).exists()) {
        return false;
      }
      for (;;)
      {
        try
        {
          localObject = FileUtils.readFileToString((File)localObject);
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            return false;
          }
          arrayOfString = ((String)localObject).split("&");
          if (arrayOfString != null) {
            continue;
          }
          return false;
        }
        catch (IOException paramFile)
        {
          String[] arrayOfString;
          continue;
          int i = 0;
          continue;
        }
        if (i >= arrayOfString.length) {
          continue;
        }
        if (arrayOfString[i].startsWith("﻿")) {
          arrayOfString[i] = arrayOfString[i].replace("﻿", "");
        }
        localStringBuffer.setLength(0);
        localStringBuffer.append(paramFile.getAbsolutePath());
        localStringBuffer.append(File.separator);
        localStringBuffer.append(arrayOfString[i]);
        localObject = new File(localStringBuffer.toString());
        if (!((File)localObject).exists())
        {
          if (QLog.isColorLevel())
          {
            paramFile = new StringBuilder();
            paramFile.append("isAnimationPackageValid File not exist:");
            paramFile.append(((File)localObject).getName());
            QLog.e("SceneBuilder", 2, paramFile.toString());
          }
          return false;
        }
        i += 1;
      }
      return true;
      if (QLog.isColorLevel()) {
        QLog.e("SceneBuilder", 2, "isAnimationPackageValid IOException");
      }
    }
    return false;
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
  
  /* Error */
  private static String b(String paramString)
  {
    // Byte code:
    //   0: new 654	java/io/InputStreamReader
    //   3: dup
    //   4: new 656	java/io/FileInputStream
    //   7: dup
    //   8: new 600	java/io/File
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 619	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: invokespecial 659	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: invokespecial 662	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   22: astore_2
    //   23: new 664	java/io/BufferedReader
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 667	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_1
    //   32: new 123	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   39: astore_0
    //   40: aload_1
    //   41: invokevirtual 670	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: astore_3
    //   45: aload_3
    //   46: ifnull +19 -> 65
    //   49: aload_0
    //   50: aload_3
    //   51: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_0
    //   56: bipush 10
    //   58: invokevirtual 673	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: goto -22 -> 40
    //   65: aload_1
    //   66: invokevirtual 676	java/io/BufferedReader:close	()V
    //   69: aload_2
    //   70: invokevirtual 677	java/io/InputStreamReader:close	()V
    //   73: aload_0
    //   74: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: astore_0
    //   78: aload_0
    //   79: areturn
    //   80: astore_0
    //   81: goto +14 -> 95
    //   84: astore_0
    //   85: aconst_null
    //   86: astore_1
    //   87: goto +8 -> 95
    //   90: astore_0
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: astore_2
    //   95: aload_0
    //   96: invokevirtual 680	java/lang/Exception:printStackTrace	()V
    //   99: aload_1
    //   100: ifnull +15 -> 115
    //   103: aload_1
    //   104: invokevirtual 676	java/io/BufferedReader:close	()V
    //   107: goto +8 -> 115
    //   110: astore_0
    //   111: aload_0
    //   112: invokevirtual 681	java/io/IOException:printStackTrace	()V
    //   115: aload_2
    //   116: ifnull +14 -> 130
    //   119: aload_2
    //   120: invokevirtual 677	java/io/InputStreamReader:close	()V
    //   123: aconst_null
    //   124: areturn
    //   125: astore_0
    //   126: aload_0
    //   127: invokevirtual 681	java/io/IOException:printStackTrace	()V
    //   130: aconst_null
    //   131: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramString	String
    //   31	73	1	localBufferedReader	java.io.BufferedReader
    //   22	98	2	localObject	Object
    //   44	7	3	str	String
    // Exception table:
    //   from	to	target	type
    //   32	40	80	java/lang/Exception
    //   40	45	80	java/lang/Exception
    //   49	62	80	java/lang/Exception
    //   65	78	80	java/lang/Exception
    //   23	32	84	java/lang/Exception
    //   0	23	90	java/lang/Exception
    //   103	107	110	java/io/IOException
    //   119	123	125	java/io/IOException
  }
  
  public SceneBuilder a(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
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
  
  public void a(ISpriteView paramISpriteView, SceneBuilder.OnBuiltListener paramOnBuiltListener)
  {
    ThreadManager.post(new SceneBuilder.1(this, paramISpriteView, paramOnBuiltListener), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder
 * JD-Core Version:    0.7.0.1
 */