package com.tencent.mobileqq.onlinestatus.olympic.helper;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.onlinestatus.OlympicStatusResDownloader;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.config.olympic.OlympicConfBean;
import com.tencent.mobileqq.onlinestatus.config.olympic.OlympicConfBean.OlympicConfig;
import com.tencent.mobileqq.onlinestatus.config.olympic.OlympicConfBean.OlympicShareConfig;
import com.tencent.mobileqq.onlinestatus.config.olympic.OlympicConfProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class OlympicShareHelper$1
  implements Runnable
{
  OlympicShareHelper$1(long paramLong, AppInterface paramAppInterface, Activity paramActivity, OlympicShareHelper.IShareFinishCallback paramIShareFinishCallback) {}
  
  public void run()
  {
    if (!OlympicStatusResDownloader.d())
    {
      QLog.e("OlympicShareHelper", 1, "getOlympicShareBitmap resource not ready");
      return;
    }
    Object localObject1 = OlympicConfProcessor.b().b();
    OlympicConfBean.OlympicShareConfig localOlympicShareConfig = (OlympicConfBean.OlympicShareConfig)((OlympicConfBean.OlympicConfig)localObject1).c.get(Integer.valueOf(OlympicShareHelper.a(this.a)));
    if (localOlympicShareConfig == null)
    {
      QLog.e("OlympicShareHelper", 1, "getOlympicShareBitmap config not ready");
      return;
    }
    CountDownLatch localCountDownLatch = new CountDownLatch(3);
    Bitmap localBitmap1 = ((IQQAvatarService)this.b.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.b).getBitmapFromCache(1, this.b.getCurrentAccountUin());
    URLDrawable localURLDrawable1 = OlympicShareHelper.a(this.a, localCountDownLatch);
    if (localURLDrawable1 == null) {
      return;
    }
    Bitmap localBitmap2 = OlympicShareHelper.a((OlympicConfBean.OlympicConfig)localObject1);
    localObject1 = this.b;
    String str = OlympicShareHelper.a((AppInterface)localObject1, ((AppInterface)localObject1).getCurrentAccountUin());
    int i = Color.parseColor(localOlympicShareConfig.b);
    Drawable localDrawable = OlympicShareHelper.a(localCountDownLatch);
    localObject1 = OnLineStatusHelper.a().f();
    if (TextUtils.isEmpty(((OnlineStatusItem)localObject1).c)) {
      localObject1 = HardCodeUtil.a(2131896390);
    } else {
      localObject1 = ((OnlineStatusItem)localObject1).c;
    }
    int j = Color.parseColor(localOlympicShareConfig.b);
    URLDrawable localURLDrawable2 = OlympicShareHelper.b(this.a, localCountDownLatch);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("NO.");
    ((StringBuilder)localObject2).append(this.a);
    localObject2 = ((StringBuilder)localObject2).toString();
    int k = Color.parseColor(localOlympicShareConfig.c);
    try
    {
      localCountDownLatch.await(3000L, TimeUnit.MILLISECONDS);
      if (localCountDownLatch.getCount() == 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.i("OlympicShareHelper", 2, "shareOlympicRank latch count to zero");
        }
        localObject1 = OlympicShareHelper.a(OlympicShareHelper.a(localURLDrawable1), localBitmap1, localBitmap2, i, str, OlympicShareHelper.a(localDrawable), j, (String)localObject1, OlympicShareHelper.a(localURLDrawable2), k, (String)localObject2);
        ThreadManagerV2.getUIHandlerV2().post(new OlympicShareHelper.1.1(this, (Bitmap)localObject1));
      }
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicShareHelper.1
 * JD-Core Version:    0.7.0.1
 */