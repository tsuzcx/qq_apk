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
  private String a = "";
  private boolean b;
  private int c;
  private float d;
  private FrameSprite.OnFrameEndListener e;
  private SceneBuilder.ILabelTextHandle f;
  private SceneBuilder.IImageBitmapHandle g;
  private SceneBuilder.ILayoutSizeHandler h;
  private SceneBuilder.IActionPositionHandler i;
  private SceneBuilder.IButtonHandle j;
  
  private BaseNode a(ISpriteView paramISpriteView, JSONObject paramJSONObject)
  {
    boolean bool = paramISpriteView instanceof SpriteGLView;
    int m;
    if (bool) {
      m = 4;
    } else {
      m = 1;
    }
    Object localObject1 = paramJSONObject.optString("text");
    if (bool) {
      localObject3 = new com.tencent.mobileqq.surfaceviewaction.gl.Sprite((SpriteGLView)paramISpriteView);
    } else {
      localObject3 = new com.tencent.mobileqq.surfaceviewaction.nv.Sprite((SpriteNativeView)paramISpriteView);
    }
    float f4 = m;
    ((BaseNode)localObject3).c(1.0F / f4);
    Object localObject4 = this.f;
    Object localObject2 = localObject1;
    if (localObject4 != null) {
      localObject2 = ((SceneBuilder.ILabelTextHandle)localObject4).a((ISprite)localObject3, (String)localObject1);
    }
    int n = paramJSONObject.optInt("textSize", 20) * m;
    int k = Color.parseColor(paramJSONObject.optString("textColor"));
    Object localObject5 = new Paint();
    ((Paint)localObject5).setAntiAlias(true);
    ((Paint)localObject5).setColor(k);
    float f1 = n;
    ((Paint)localObject5).setTextSize(f1);
    Object localObject6 = paramJSONObject.optJSONObject("size");
    k = (int)((Paint)localObject5).measureText((String)localObject2);
    String str = paramJSONObject.optString("imageRight");
    int i4 = paramJSONObject.optInt("imagePadding") * m;
    bool = TextUtils.isEmpty(str);
    int i5 = 0;
    if (!bool)
    {
      localObject1 = this.g;
      if (localObject1 != null) {
        localObject1 = ((SceneBuilder.IImageBitmapHandle)localObject1).a((ISprite)localObject3, this.a, str);
      } else {
        localObject1 = null;
      }
      localObject4 = localObject1;
      if (localObject1 == null) {}
      try
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(this.a);
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
        i2 = ((Bitmap)localObject1).getWidth() * m;
        i1 = ((Bitmap)localObject1).getHeight() * m;
        break label410;
      }
    }
    else
    {
      localObject4 = null;
    }
    int i2 = 0;
    int i1 = 0;
    localObject1 = localObject4;
    label410:
    localObject4 = localObject3;
    int i3;
    if (localObject6 != null)
    {
      if (((JSONObject)localObject6).optInt("width") != 0) {
        k = ((JSONObject)localObject6).optInt("width") * m;
      }
      if (((JSONObject)localObject6).optInt("height") != 0) {
        m = ((JSONObject)localObject6).optInt("height") * m;
      } else {
        m = n;
      }
      localObject3 = this.f;
      if (localObject3 != null) {
        ((SceneBuilder.ILabelTextHandle)localObject3).a(k - i2 - i4, (String)localObject2, (Paint)localObject5);
      }
      localObject2 = a(k - i2 - i4, (String)localObject2, (Paint)localObject5);
      i3 = k;
    }
    else
    {
      m = n;
      i3 = k;
    }
    Object localObject3 = this.f;
    if (localObject3 != null) {
      k = ((SceneBuilder.ILabelTextHandle)localObject3).a(i3, i2, i4, (String)localObject2, (Paint)localObject5);
    } else {
      k = i5;
    }
    localObject3 = localObject5;
    localObject5 = localObject1;
    if (k == 0) {
      k = (int)((Paint)localObject3).measureText((String)localObject2);
    }
    localObject1 = localObject3;
    i2 = i2 + k + i4;
    try
    {
      localObject3 = Bitmap.createBitmap(i3, m, Bitmap.Config.ARGB_8888);
      localObject6 = new Canvas((Bitmap)localObject3);
      ((Canvas)localObject6).drawColor(-16777216, PorterDuff.Mode.CLEAR);
      float f5 = f1 * 0.8F;
      paramJSONObject = paramJSONObject.optString("gravity");
      float f2;
      float f3;
      if (paramJSONObject != null)
      {
        if ((!paramJSONObject.contains("left")) && (paramJSONObject.contains("right"))) {
          f1 = i3 - i2;
        } else {
          f1 = 0.0F;
        }
        if ((!paramJSONObject.contains("top")) && (paramJSONObject.contains("bottom")))
        {
          f2 = m - n;
          f3 = m - i1;
        }
        else
        {
          f3 = 0.0F;
          f2 = 0.0F;
        }
        if (paramJSONObject.equals("center"))
        {
          f1 = (i3 - i2) / 2;
          f2 = (m - n) / 2;
          f3 = (m - i1) / 2;
        }
        if (paramJSONObject.contains("center_horizontal")) {
          f1 = (i3 - i2) / 2;
        }
        if (paramJSONObject.contains("center_vertical"))
        {
          f2 = (m - n) / 2;
          f3 = (m - i1) / 2;
        }
      }
      else
      {
        f1 = 0.0F;
        f2 = 0.0F;
        f3 = 0.0F;
      }
      SceneBuilder.ILabelTextHandle localILabelTextHandle = this.f;
      if (localILabelTextHandle != null)
      {
        paramJSONObject = (JSONObject)localObject1;
        if (localILabelTextHandle.a((Canvas)localObject6, (String)localObject2, f1, f2, f5, i3, m, paramJSONObject))
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
        paramJSONObject.postTranslate(f1 + i4 + k, f3);
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
    int m = 0;
    label194:
    label228:
    int k;
    int n;
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
        localObject2 = this.g;
        if (localObject2 != null) {
          localObject3 = ((SceneBuilder.IImageBitmapHandle)localObject2).a((ISprite)localObject1, this.a, str);
        } else {
          localObject3 = null;
        }
        localObject2 = localObject3;
        if (localObject3 == null) {
          try
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(this.a);
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
            k = localJSONObject.optInt("width");
            n = localJSONObject.optInt("height");
            try
            {
              localObject3 = Bitmap.createScaledBitmap((Bitmap)localObject2, k, n, true);
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
        ((StringBuilder)localObject4).append(this.a);
        ((StringBuilder)localObject4).append("/");
        ((StringBuilder)localObject4).append(paramJSONObject.optString("path"));
        ((com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite)localObject2).c(((StringBuilder)localObject4).toString());
        if (paramJSONObject.optBoolean("isKey", false)) {
          ((SpriteGLView)localObject1).setVideoTimeGetter((SpriteGLView.IVideoTimeGetter)localObject2);
        }
        if (paramJSONObject.optBoolean("autoClose", false)) {
          ((com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite)localObject2).a(this.e);
        }
        ((com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite)localObject2).a(paramJSONObject.optBoolean("isLooping", false));
      }
      localObject1 = localObject3;
      break label782;
      label670:
      localObject1 = (SpriteNativeView)paramISpriteView;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.a);
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
    ((BaseNode)localObject1).p_(paramJSONObject.optString("name"));
    ((BaseNode)localObject1).a(paramJSONObject.optInt("tag"));
    ((BaseNode)localObject1).a((float)paramJSONObject.optDouble("x", 0.0D));
    ((BaseNode)localObject1).b((float)paramJSONObject.optDouble("y", 0.0D));
    ((BaseNode)localObject1).b((int)(paramJSONObject.optDouble("alpha", 1.0D) * 255.0D));
    ((BaseNode)localObject1).c(((BaseNode)localObject1).b() * (float)paramJSONObject.optDouble("scale", 1.0D));
    ((BaseNode)localObject1).d((float)paramJSONObject.optDouble("rotate", 0.0D));
    ((BaseNode)localObject1).e(((BaseNode)paramILayer).b());
    Object localObject2 = paramJSONObject.optJSONArray("actions");
    if (localObject2 != null) {
      ((BaseNode)localObject1).a(a((JSONArray)localObject2));
    }
    Object localObject3 = paramJSONObject.optJSONObject("frames");
    if (localObject3 != null)
    {
      localObject2 = new Frame();
      ((Frame)localObject2).a = ((JSONObject)localObject3).optInt("fps");
      localObject3 = ((JSONObject)localObject3).optJSONArray("datas");
      n = ((JSONArray)localObject3).length();
      ((Frame)localObject2).b = new Frame.FrameData[n];
      k = 0;
      while (k < n)
      {
        ((Frame)localObject2).b[k] = new Frame.FrameData();
        localObject4 = ((JSONArray)localObject3).optJSONObject(k);
        localObject2.b[k].a = ((JSONObject)localObject4).optInt("x");
        localObject2.b[k].b = ((JSONObject)localObject4).optInt("y");
        k += 1;
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
      n = paramJSONObject.length();
      k = m;
      while (k < n)
      {
        localObject3 = a(paramISpriteView, paramJSONObject.getJSONObject(k), paramILayer);
        if (localObject3 != null) {
          ((ILayer)localObject2).a((BaseNode)localObject3);
        }
        k += 1;
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
      int k = ((JSONObject)localObject2).optInt("width");
      int m = ((JSONObject)localObject2).optInt("height");
      this.d = (this.c / k);
      if (this.b)
      {
        localObject2 = ((ViewGroup)paramISpriteView).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = this.c;
        ((ViewGroup.LayoutParams)localObject2).height = ((int)(m * this.d));
        ((ViewGroup)paramISpriteView).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((BaseNode)localObject1).c(this.d);
        if (this.h != null) {
          this.h.a(((ViewGroup.LayoutParams)localObject2).width, ((ViewGroup.LayoutParams)localObject2).height);
        }
      }
      paramString = paramString.optJSONArray("scene");
      if (paramString != null)
      {
        m = paramString.length();
        k = 0;
        while (k < m)
        {
          localObject2 = a(paramISpriteView, paramString.getJSONObject(k), (ILayer)localObject1);
          if (localObject2 != null) {
            ((ILayer)localObject1).a((BaseNode)localObject2);
          }
          k += 1;
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
    int m = paramJSONObject.optInt("duration");
    boolean bool = ((String)localObject2).equals("sequence");
    Object localObject1 = null;
    if (bool)
    {
      localObject1 = new SequenceAction(a(paramJSONObject.optJSONArray("actions")));
    }
    else if (((String)localObject2).equals("delay"))
    {
      localObject1 = new DelayAction(m);
    }
    else if (((String)localObject2).equals("position"))
    {
      localObject2 = paramJSONObject.optJSONObject("from");
      JSONObject localJSONObject = paramJSONObject.optJSONObject("to");
      if ((this.i != null) && ("$POSITIONX$".equals(localJSONObject.optString("x"))))
      {
        localObject1 = this.i.a((JSONObject)localObject2, localJSONObject, this.d);
        if ((localObject1 != null) && (localObject1.length == 2))
        {
          localObject1 = new MoveToAction(m, localObject1[0].a, localObject1[0].b, localObject1[1].a, localObject1[1].b);
          k = 1;
          break label223;
        }
      }
      localObject1 = null;
      int k = 0;
      label223:
      if (k == 0) {
        localObject1 = new MoveToAction(m, (float)((JSONObject)localObject2).optDouble("x"), (float)((JSONObject)localObject2).optDouble("y"), (float)localJSONObject.optDouble("x"), (float)localJSONObject.optDouble("y"));
      }
    }
    else if (((String)localObject2).equals("scale"))
    {
      localObject1 = new ScaleAction(m, (float)paramJSONObject.optDouble("from", 1.0D), (float)paramJSONObject.optDouble("to", 1.0D));
    }
    else if (((String)localObject2).equals("alpha"))
    {
      localObject1 = new OpacityAction(m, (int)(paramJSONObject.optDouble("from", 1.0D) * 255.0D), (int)(paramJSONObject.optDouble("to", 1.0D) * 255.0D));
    }
    else if (((String)localObject2).equals("rotate"))
    {
      localObject1 = new RotateAction(m, paramJSONObject.optInt("from", 0), paramJSONObject.optInt("to", 0));
    }
    if (localObject1 != null)
    {
      ((Action)localObject1).i = paramJSONObject.optBoolean("isRepeat");
      if (str != null) {
        if (str.equals("linear")) {
          ((Action)localObject1).h = 0;
        } else if (str.equals("easeIn")) {
          ((Action)localObject1).h = 1;
        } else if (str.equals("easeOut")) {
          ((Action)localObject1).h = 2;
        }
      }
      if ((paramJSONObject.optBoolean("autoClose", false)) && (this.e != null)) {
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
    float f1 = paramPaint.measureText("...");
    if ((int)Math.ceil(paramPaint.measureText(paramString)) <= paramInt) {
      return paramString;
    }
    int k = paramString.length() - 1;
    while (k > 0)
    {
      if ((int)Math.ceil(paramPaint.measureText(paramString, 0, k) + f1) <= paramInt)
      {
        paramPaint = new StringBuilder();
        paramPaint.append(paramString.substring(0, k));
        paramPaint.append("...");
        return paramPaint.toString();
      }
      k -= 1;
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
          int k = 0;
          continue;
        }
        if (k >= arrayOfString.length) {
          continue;
        }
        if (arrayOfString[k].startsWith("﻿")) {
          arrayOfString[k] = arrayOfString[k].replace("﻿", "");
        }
        localStringBuffer.setLength(0);
        localStringBuffer.append(paramFile.getAbsolutePath());
        localStringBuffer.append(File.separator);
        localStringBuffer.append(arrayOfString[k]);
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
        k += 1;
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
    int m = paramJSONArray.length();
    Action[] arrayOfAction = new Action[m];
    int k = 0;
    while (k < m)
    {
      arrayOfAction[k] = a(paramJSONArray.optJSONObject(k));
      k += 1;
    }
    return arrayOfAction;
  }
  
  /* Error */
  private static String c(String paramString)
  {
    // Byte code:
    //   0: new 663	java/io/InputStreamReader
    //   3: dup
    //   4: new 665	java/io/FileInputStream
    //   7: dup
    //   8: new 603	java/io/File
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 622	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: invokespecial 668	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: invokespecial 671	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   22: astore_2
    //   23: new 673	java/io/BufferedReader
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 676	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_1
    //   32: new 131	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   39: astore_0
    //   40: aload_1
    //   41: invokevirtual 679	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: astore_3
    //   45: aload_3
    //   46: ifnull +19 -> 65
    //   49: aload_0
    //   50: aload_3
    //   51: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_0
    //   56: bipush 10
    //   58: invokevirtual 682	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: goto -22 -> 40
    //   65: aload_1
    //   66: invokevirtual 685	java/io/BufferedReader:close	()V
    //   69: aload_2
    //   70: invokevirtual 686	java/io/InputStreamReader:close	()V
    //   73: aload_0
    //   74: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    //   96: invokevirtual 689	java/lang/Exception:printStackTrace	()V
    //   99: aload_1
    //   100: ifnull +15 -> 115
    //   103: aload_1
    //   104: invokevirtual 685	java/io/BufferedReader:close	()V
    //   107: goto +8 -> 115
    //   110: astore_0
    //   111: aload_0
    //   112: invokevirtual 690	java/io/IOException:printStackTrace	()V
    //   115: aload_2
    //   116: ifnull +14 -> 130
    //   119: aload_2
    //   120: invokevirtual 686	java/io/InputStreamReader:close	()V
    //   123: aconst_null
    //   124: areturn
    //   125: astore_0
    //   126: aload_0
    //   127: invokevirtual 690	java/io/IOException:printStackTrace	()V
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
    this.b = true;
    this.c = paramInt;
    return this;
  }
  
  public SceneBuilder a(SceneBuilder.IButtonHandle paramIButtonHandle)
  {
    this.j = paramIButtonHandle;
    return this;
  }
  
  public SceneBuilder a(SceneBuilder.IImageBitmapHandle paramIImageBitmapHandle)
  {
    this.g = paramIImageBitmapHandle;
    return this;
  }
  
  public SceneBuilder a(SceneBuilder.ILabelTextHandle paramILabelTextHandle)
  {
    this.f = paramILabelTextHandle;
    return this;
  }
  
  public SceneBuilder a(SceneBuilder.ILayoutSizeHandler paramILayoutSizeHandler)
  {
    this.h = paramILayoutSizeHandler;
    return this;
  }
  
  public SceneBuilder a(FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    this.e = paramOnFrameEndListener;
    return this;
  }
  
  public SceneBuilder a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public void a(ISpriteView paramISpriteView, SceneBuilder.OnBuiltListener paramOnBuiltListener)
  {
    ThreadManager.post(new SceneBuilder.1(this, paramISpriteView, paramOnBuiltListener), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder
 * JD-Core Version:    0.7.0.1
 */