package com.tencent.mobileqq.doutu;

import android.content.Intent;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.apollo.aio.api.IApolloAIOHelper;
import com.tencent.mobileqq.apollo.aio.ui.IChatPieApolloViewController;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AIODoutuListenerImpl
  implements IDoutuListener
{
  private QQAppInterface a;
  private BaseChatPie b;
  
  AIODoutuListenerImpl(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie)
  {
    this.a = paramQQAppInterface;
    this.b = paramBaseChatPie;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, DoutuData paramDoutuData, QBaseActivity paramQBaseActivity)
  {
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1044);
    localIntent.putExtra("uin", paramString2);
    try
    {
      localIntent.putExtra("uintype", Integer.valueOf(paramString3));
    }
    catch (NumberFormatException paramString1)
    {
      QLog.e("AIODoutuListenerImpl", 1, "onDoutuEmoClicked error", paramString1);
    }
    localIntent.putExtra("troop_uin", paramString4);
    localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    localIntent.putExtra("send_in_background", true);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
    localIntent.putExtra("quick_send_original_size", paramDoutuData.picSize);
    localIntent.putExtra("quick_send_original_md5", paramDoutuData.picMd5);
    localIntent.putExtra("quick_send_thumb_md5", paramDoutuData.thumbMd5);
    localIntent.putExtra("PicContants.NEED_COMPRESS", false);
    ThreadManager.post(new SendPhotoTask((BaseActivity)paramQBaseActivity, localIntent, null), 8, null, false);
    DoutuConfigReporter.c();
  }
  
  public boolean a()
  {
    if ((this.b.aU != null) && (this.b.aU.c())) {
      return false;
    }
    return !((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).isSpriteActive(this.a, "combo");
  }
  
  public boolean b()
  {
    if (this.b.aZ())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIODoutuListenerImpl", 2, "shouldShowCombo, isMsgBoxShown");
      }
      return false;
    }
    Object localObject = this.b.J();
    if ((localObject != null) && (((TipsManager)localObject).b() != -1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIODoutuListenerImpl", 2, "shouldShowCombo, isTipsShown");
      }
      return false;
    }
    localObject = (TroopAioTips)this.b.au;
    if (localObject != null)
    {
      if (((TroopAioTips)localObject).q())
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIODoutuListenerImpl", 2, "shouldShowCombo, isTroopAioTipsShown");
        }
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIODoutuListenerImpl", 2, "shouldShowCombo, troopAioTips.hasTips() == false");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("AIODoutuListenerImpl", 2, "shouldShowCombo, troopAioTips is null");
    }
    return true;
  }
  
  public void c()
  {
    IApolloAIOHelper localIApolloAIOHelper = (IApolloAIOHelper)this.b.q(8);
    if (localIApolloAIOHelper != null) {
      localIApolloAIOHelper.showApolloView(false);
    }
  }
  
  public void d()
  {
    IApolloAIOHelper localIApolloAIOHelper = (IApolloAIOHelper)this.b.q(8);
    if (localIApolloAIOHelper != null) {
      localIApolloAIOHelper.getChatPieApolloViewController().b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.AIODoutuListenerImpl
 * JD-Core Version:    0.7.0.1
 */