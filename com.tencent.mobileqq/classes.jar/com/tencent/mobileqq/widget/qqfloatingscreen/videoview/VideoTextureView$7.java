package com.tencent.mobileqq.widget.qqfloatingscreen.videoview;

import android.content.Context;
import com.tencent.mobileqq.qqfloatingwindow.listener.IWindowClickListener;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

class VideoTextureView$7
  implements IWindowClickListener
{
  public boolean a()
  {
    QQToast.a((Context)VideoTextureView.a(this.a).get(), "关闭浮窗", 0).a();
    VideoTextureView.a(this.a);
    return false;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    QQToast.a((Context)VideoTextureView.a(this.a).get(), "点击浮窗进入全屏", 0).a();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.videoview.VideoTextureView.7
 * JD-Core Version:    0.7.0.1
 */