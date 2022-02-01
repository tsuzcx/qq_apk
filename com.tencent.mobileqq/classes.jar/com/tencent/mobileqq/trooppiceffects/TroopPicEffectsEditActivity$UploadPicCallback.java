package com.tencent.mobileqq.trooppiceffects;

import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import java.lang.ref.WeakReference;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.RichText;

public class TroopPicEffectsEditActivity$UploadPicCallback
  implements UpCallBack
{
  protected WeakReference<TroopPicEffectsEditActivity> a;
  
  public TroopPicEffectsEditActivity$UploadPicCallback(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity)
  {
    this.a = new WeakReference(paramTroopPicEffectsEditActivity);
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    TroopPicEffectsEditActivity localTroopPicEffectsEditActivity = (TroopPicEffectsEditActivity)this.a.get();
    if (localTroopPicEffectsEditActivity == null) {
      return;
    }
    localTroopPicEffectsEditActivity.c();
    Intent localIntent = new Intent(localTroopPicEffectsEditActivity, SplashActivity.class);
    localIntent.putExtra("uin", localTroopPicEffectsEditActivity.getIntent().getStringExtra("friendUin"));
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("troop_uin", localTroopPicEffectsEditActivity.getIntent().getStringExtra("troopUin"));
    localIntent.putExtra("isFromTroopEffectPic", true);
    localTroopPicEffectsEditActivity.startActivity(AIOUtils.a(localIntent, new int[] { 1 }));
    localTroopPicEffectsEditActivity.finish();
    localTroopPicEffectsEditActivity.a(localTroopPicEffectsEditActivity.a, (im_msg_body.CustomFace)paramSendResult.a, new TroopPicEffectsEditActivity.UploadPicCallback.1(this, localTroopPicEffectsEditActivity));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity.UploadPicCallback
 * JD-Core Version:    0.7.0.1
 */