package com.tencent.mobileqq.trooppiceffects;

import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UiCallBack.DownAdapter;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class TroopPicEffectsController$1
  extends UiCallBack.DownAdapter
{
  TroopPicEffectsController$1(TroopPicEffectsController paramTroopPicEffectsController, PicDownloadInfo paramPicDownloadInfo, TroopChatPie paramTroopChatPie, MessageForTroopEffectPic paramMessageForTroopEffectPic, boolean paramBoolean) {}
  
  public void a(int paramInt, PicResult paramPicResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopPicEffectsController", 2, "2g diy gif onDownload");
    }
    paramPicResult = new File(this.a.f());
    AIOAnimationControlManager localAIOAnimationControlManager = (AIOAnimationControlManager)this.b.d.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    if ((paramPicResult.exists()) && (localAIOAnimationControlManager != null))
    {
      localAIOAnimationControlManager.a = 1;
      localAIOAnimationControlManager.a(this.b);
      localAIOAnimationControlManager.a(this.c, this.d);
      localAIOAnimationControlManager.j();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopPicEffectsController", 2, "[EffectPic] file not exist or isplaying.");
    }
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopPicEffectsController", 2, "2g diy gif onUpdateProgress");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsController.1
 * JD-Core Version:    0.7.0.1
 */