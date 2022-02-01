package com.tencent.mobileqq.flutter.vistaimage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Surface;
import com.qflutter.vistaimage.IRenderer;
import com.qflutter.vistaimage.RendererParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.flutter.qqface.DecodeRequest;
import com.tencent.mobileqq.flutter.qqface.QFlutterFaceLoader;
import com.tencent.mobileqq.flutter.qqface.QFlutterFaceLoader.FaceObserver;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

class QQAvatarRenderer
  implements IRenderer
{
  String a;
  int b;
  int c;
  Surface d;
  Drawable e;
  Rect f;
  private QFlutterFaceLoader.FaceObserver g = new -..Lambda.QQAvatarRenderer.2qZWViidslW8T96y2yVsqnBEFiU(this);
  
  public QQAvatarRenderer(String paramString, int paramInt1, int paramInt2)
  {
    this.a = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
    if (this.c == 0) {
      this.c = 3;
    }
    QFlutterFaceLoader.a().a(this.g);
  }
  
  public Bitmap a()
  {
    return ImageUtil.k();
  }
  
  public void clean()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAvatarRenderer", 2, "[clean]");
    }
    QFlutterFaceLoader.a().b(this.g);
    Surface localSurface = this.d;
    if (localSurface != null)
    {
      if (localSurface.isValid()) {
        this.d.release();
      }
      this.d = null;
    }
  }
  
  public void init(RendererParams paramRendererParams)
  {
    this.d = paramRendererParams.getSurface();
    this.f = new Rect(0, 0, paramRendererParams.getViewWidth(), paramRendererParams.getViewHeight());
    paramRendererParams = new DecodeRequest(this.b, this.a, this.c);
    paramRendererParams = QFlutterFaceLoader.a().a(paramRendererParams);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[init] result.second=");
      localStringBuilder.append(paramRendererParams.second);
      QLog.d("QQAvatarRenderer", 2, localStringBuilder.toString());
    }
    paramRendererParams = new BitmapDrawable(BaseApplicationImpl.getContext().getResources(), (Bitmap)paramRendererParams.first);
    paramRendererParams.setBounds(this.f);
    this.e = paramRendererParams;
  }
  
  public void render()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      if (this.e == null) {
        return;
      }
      localObject = ((Surface)localObject).lockCanvas(this.f);
      this.e.draw((Canvas)localObject);
      this.d.unlockCanvasAndPost((Canvas)localObject);
    }
  }
  
  public void updateDrawable(Drawable paramDrawable)
  {
    this.e = paramDrawable;
    paramDrawable = this.f;
    if (paramDrawable != null) {
      this.e.setBounds(paramDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.vistaimage.QQAvatarRenderer
 * JD-Core Version:    0.7.0.1
 */