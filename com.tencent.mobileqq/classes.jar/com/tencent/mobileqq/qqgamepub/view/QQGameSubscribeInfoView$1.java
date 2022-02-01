package com.tencent.mobileqq.qqgamepub.view;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgamepub.utils.QQGameImageLoader.ImageLoadListener;
import com.tencent.mobileqq.qqgamepub.utils.UIUtils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;

class QQGameSubscribeInfoView$1
  implements QQGameImageLoader.ImageLoadListener
{
  QQGameSubscribeInfoView$1(QQGameSubscribeInfoView paramQQGameSubscribeInfoView, int paramInt) {}
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("onImageLoaded...url:");
      paramString2.append(paramString1);
      paramString2.append(",image:");
      paramString2.append(paramBitmap);
      paramString2.append(",isMainTread:");
      boolean bool;
      if (Looper.myLooper() == Looper.getMainLooper()) {
        bool = true;
      } else {
        bool = false;
      }
      paramString2.append(bool);
      QLog.i("QQGamePub_QQGameSubscribeInfoView", 1, paramString2.toString());
    }
    float f = UIUtils.a(12.0F, QQGameSubscribeInfoView.a(this.b).getResources());
    int i = this.a;
    paramString1 = BaseImageUtil.a(paramBitmap, f, true, i, i);
    ThreadManagerV2.getUIHandlerV2().post(new QQGameSubscribeInfoView.1.1(this, paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.QQGameSubscribeInfoView.1
 * JD-Core Version:    0.7.0.1
 */