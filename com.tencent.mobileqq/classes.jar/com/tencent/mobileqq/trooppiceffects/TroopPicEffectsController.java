package com.tencent.mobileqq.trooppiceffects;

import ajwv;
import ajww;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.trooppiceffects.view.IPicView;
import com.tencent.mobileqq.trooppiceffects.view.NormalPicView;
import com.tencent.mobileqq.trooppiceffects.view.PhantomPicView;
import com.tencent.mobileqq.trooppiceffects.view.ShakePicView;
import com.tencent.mobileqq.trooppiceffects.view.VideoPicView;
import com.tencent.qphone.base.util.QLog;

public class TroopPicEffectsController
{
  protected Handler a;
  protected ViewGroup a;
  protected IPicView a;
  
  public TroopPicEffectsController(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public static void a(String paramString1, String paramString2)
  {
    ReportController.b(null, "dc00899", "show_pic", "", paramString1, paramString2, 0, 0, "", "", "", "");
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView != null) && (this.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView.b();
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView.a());
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(int paramInt1, Bitmap paramBitmap, int paramInt2, TroopPicEffectsController.OnAnimationEndListener paramOnAnimationEndListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopPicEffectsController", 2, "showPicEffect");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView == null) && (this.jdField_a_of_type_AndroidViewViewGroup != null)) {
      switch (paramInt1)
      {
      default: 
        this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView = new NormalPicView(this.jdField_a_of_type_AndroidViewViewGroup.getContext());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView.a(), -1, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView.setBitmap(paramBitmap);
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView.a();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ajww(this, paramOnAnimationEndListener), 6000L);
      return;
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView = new PhantomPicView(this.jdField_a_of_type_AndroidViewViewGroup.getContext());
      continue;
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView = new ShakePicView(this.jdField_a_of_type_AndroidViewViewGroup.getContext());
      continue;
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsViewIPicView = new VideoPicView(this.jdField_a_of_type_AndroidViewViewGroup.getContext(), paramInt1);
    }
  }
  
  public void a(TroopChatPie paramTroopChatPie, MessageForTroopEffectPic paramMessageForTroopEffectPic, boolean paramBoolean)
  {
    PicReq localPicReq = PicBusiManager.a(6, 1536, 1);
    PicDownloadInfo localPicDownloadInfo = paramMessageForTroopEffectPic.getPicDownloadInfo();
    localPicReq.a(paramMessageForTroopEffectPic, localPicDownloadInfo);
    localPicReq.a(new ajwv(this, localPicDownloadInfo, paramTroopChatPie, paramMessageForTroopEffectPic, paramBoolean));
    PicBusiManager.a(localPicReq, paramTroopChatPie.a);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsController
 * JD-Core Version:    0.7.0.1
 */