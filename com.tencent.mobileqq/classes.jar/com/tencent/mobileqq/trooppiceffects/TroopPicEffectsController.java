package com.tencent.mobileqq.trooppiceffects;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.trooppiceffects.view.IPicView;
import com.tencent.mobileqq.trooppiceffects.view.NormalPicView;
import com.tencent.mobileqq.trooppiceffects.view.PhantomPicView;
import com.tencent.mobileqq.trooppiceffects.view.ShakePicView;
import com.tencent.mobileqq.trooppiceffects.view.VideoPicView;
import com.tencent.qphone.base.util.QLog;

public class TroopPicEffectsController
{
  protected ViewGroup a;
  protected IPicView b;
  protected Handler c;
  
  public TroopPicEffectsController(ViewGroup paramViewGroup)
  {
    this.a = paramViewGroup;
    this.c = new Handler(Looper.getMainLooper());
  }
  
  public static void a(String paramString1, String paramString2)
  {
    ReportController.b(null, "dc00899", "show_pic", "", paramString1, paramString2, 0, 0, "", "", "", "");
  }
  
  public void a()
  {
    IPicView localIPicView = this.b;
    if ((localIPicView != null) && (this.a != null))
    {
      localIPicView.b();
      this.a.removeView(this.b.getView());
      this.b = null;
    }
    this.c.removeCallbacksAndMessages(null);
  }
  
  public void a(int paramInt1, Bitmap paramBitmap, int paramInt2, TroopPicEffectsController.OnAnimationEndListener paramOnAnimationEndListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopPicEffectsController", 2, "showPicEffect");
    }
    if (this.b == null)
    {
      ViewGroup localViewGroup = this.a;
      if (localViewGroup != null)
      {
        switch (paramInt1)
        {
        default: 
          this.b = new NormalPicView(localViewGroup.getContext());
          break;
        case 40003: 
        case 40004: 
        case 40005: 
          this.b = new VideoPicView(localViewGroup.getContext(), paramInt1);
          break;
        case 40002: 
          this.b = new ShakePicView(localViewGroup.getContext());
          break;
        case 40001: 
          this.b = new PhantomPicView(localViewGroup.getContext());
        }
        this.a.removeAllViews();
        this.a.addView(this.b.getView(), -1, paramInt2);
        this.b.setBitmap(paramBitmap);
        this.b.a();
        this.c.postDelayed(new TroopPicEffectsController.2(this, paramOnAnimationEndListener), 6000L);
      }
    }
  }
  
  public void a(TroopChatPie paramTroopChatPie, MessageForTroopEffectPic paramMessageForTroopEffectPic, boolean paramBoolean)
  {
    PicReq localPicReq = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(6, 1536, 1);
    PicDownloadInfo localPicDownloadInfo = paramMessageForTroopEffectPic.getPicDownloadInfo();
    localPicReq.a(paramMessageForTroopEffectPic, localPicDownloadInfo);
    localPicReq.a(new TroopPicEffectsController.1(this, localPicDownloadInfo, paramTroopChatPie, paramMessageForTroopEffectPic, paramBoolean));
    ((IPicBus)QRoute.api(IPicBus.class)).launch(localPicReq);
  }
  
  public void b()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsController
 * JD-Core Version:    0.7.0.1
 */