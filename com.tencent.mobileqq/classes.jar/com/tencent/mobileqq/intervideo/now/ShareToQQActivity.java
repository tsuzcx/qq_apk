package com.tencent.mobileqq.intervideo.now;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

@RoutePage(desc="分享到QQ", path="/share/toqq/activity")
public class ShareToQQActivity
  extends BaseActivity
{
  static boolean isSharing;
  AllInOne allinone = null;
  FriendListObserver mFriendListObserver = new ShareToQQActivity.1(this);
  private String mSourceFrom = "";
  String phoneNumWithNationCode;
  String shielTagetUin = "";
  ShieldListObserver shieldListObserver = new ShareToQQActivity.2(this);
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = getIntent().getStringExtra("storyid");
    String str = getIntent().getStringExtra("sourceFrom");
    if ((TextUtils.equals(this.mSourceFrom, "share_from_troop_member_card")) && (paramInt2 == -1))
    {
      paramIntent.putExtra("selfSet_leftViewText", getString(2131917002));
      new Intent(this, SplashActivity.class);
      localObject = AIOUtils.a(paramIntent, null);
      ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
      paramIntent = ForwardUtils.a((Intent)localObject);
      ForwardUtils.a(this.app, this, paramIntent, (Intent)localObject);
    }
    else if (TextUtils.equals(str, "OD"))
    {
      TroopShareUtility.c(this.app, this, paramInt2, paramIntent);
    }
    else if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      TroopShareUtility.a(this.app, this, paramInt2, paramIntent);
    }
    else
    {
      TroopShareUtility.b(this.app, this, paramInt2, paramIntent);
    }
    isSharing = false;
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (isSharing) {
      finish();
    }
    isSharing = true;
    Object localObject = paramBundle.getStringExtra("storyid");
    this.mSourceFrom = paramBundle.getStringExtra("sourceFrom");
    if (paramBundle.getBooleanExtra("isLandscape", false)) {
      setRequestedOrientation(0);
    }
    if ("shiel_uin".equals(this.mSourceFrom))
    {
      addObserver(this.mFriendListObserver);
      bool = paramBundle.getBooleanExtra("isCancelShield", false);
      this.shielTagetUin = paramBundle.getStringExtra("uin");
      paramBundle = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    }
    try
    {
      l = Long.valueOf(this.shielTagetUin).longValue();
      if (bool) {
        break label625;
      }
      bool = true;
    }
    catch (NumberFormatException paramBundle)
    {
      for (;;)
      {
        long l;
        continue;
        bool = false;
      }
    }
    paramBundle.changeFriendShieldFlag(l, bool);
    return false;
    paramBundle = new StringBuilder();
    paramBundle.append("changeFriendShieldFlag, NumberFormatException:shielTagetUin=");
    paramBundle.append(this.shielTagetUin);
    QLog.d("qqBaseActivity", 1, paramBundle.toString());
    return false;
    if ("source_from_operate_shiel_uin_list".equals(this.mSourceFrom))
    {
      addObserver(this.shieldListObserver);
      bool = paramBundle.getBooleanExtra("isCancelShield", false);
      this.shielTagetUin = paramBundle.getStringExtra("uin");
      this.allinone = ((AllInOne)paramBundle.getParcelableExtra("allinone"));
      localObject = (ShieldMsgManger)this.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
      if (localObject != null)
      {
        paramBundle = this.allinone;
        if (paramBundle != null)
        {
          try
          {
            paramBundle = paramBundle.uin;
            if (ProfilePAUtils.isPaTypeStrangerInContact(this.allinone)) {
              paramBundle = getContactStrangerUin();
            }
            l = Long.parseLong(paramBundle);
            paramBundle = new ArrayList();
            paramBundle.add(Long.valueOf(l));
            int i = ProfileCardUtil.b(this.allinone);
            if (bool)
            {
              ((ShieldMsgManger)localObject).b(i, paramBundle);
              return false;
            }
            ((ShieldMsgManger)localObject).a(i, paramBundle);
            return false;
          }
          catch (NumberFormatException paramBundle)
          {
            if (!QLog.isColorLevel()) {
              break label412;
            }
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("shieldMsg() ");
          ((StringBuilder)localObject).append(paramBundle.toString());
          QLog.e("Q.profilecard.FrdProfileCard", 2, ((StringBuilder)localObject).toString());
          return false;
        }
      }
      paramBundle = new Intent();
      paramBundle.putExtra("isSuccess", false);
      paramBundle.putExtra("isCancelShield", bool);
      setResult(-1, paramBundle);
      label412:
      return false;
    }
    if ("share_from_troop_member_card".equals(this.mSourceFrom))
    {
      ForwardBaseOption.a(this, paramBundle, 21);
      return true;
    }
    if (TextUtils.equals(this.mSourceFrom, "OD"))
    {
      TroopShareUtility.b(this, paramBundle.getExtras(), 1001);
      return true;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new MessageForQQStory();
      ((MessageForQQStory)localObject).coverImgUrl = paramBundle.getStringExtra("imageUrl");
      ((MessageForQQStory)localObject).brief = paramBundle.getStringExtra("summary");
      ((MessageForQQStory)localObject).srcName = QQStoryConstant.a;
      ((MessageForQQStory)localObject).srcAction = "mqqapi://qstory/opendiscovery?src_type=internal&version=1";
      ((MessageForQQStory)localObject).msgAction = String.format("nowmqqapi://now/openroom?src_type=app&version=1&roomid=%s&first=%d&bid=1&contentType=2&unionid=%s", new Object[] { Long.valueOf(paramBundle.getLongExtra("roomid", 0L)), Integer.valueOf(2), paramBundle.getStringExtra("unionid") });
      ((MessageForQQStory)localObject).authorName = paramBundle.getStringExtra("anchorname");
      ((MessageForQQStory)localObject).logoImgUrl = "https://p.qpic.cn/qqstory_pic/hb4ycQ6NORNib7icgbswTvTCmkTyROl41Rcw9UeasFKzLwevbfJVhMRA/";
      ((MessageForQQStory)localObject).briefBgColor = -16395392;
      ((MessageForQQStory)localObject).type = 0;
      TroopShareUtility.a(this, (MessageForQQStory)localObject, 1001);
      return true;
    }
    TroopShareUtility.a(this, paramBundle.getExtras(), 1001);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    isSharing = false;
    if ("shiel_uin".equals(this.mSourceFrom))
    {
      removeObserver(this.mFriendListObserver);
      return;
    }
    if ("source_from_operate_shiel_uin_list".equals(this.mSourceFrom)) {
      removeObserver(this.shieldListObserver);
    }
  }
  
  String getContactStrangerUin()
  {
    try
    {
      String str = ContactUtils.b(this.app, this.phoneNumWithNationCode);
      return str;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.profilecard.FrdProfileCard", 2, localException.toString());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.ShareToQQActivity
 * JD-Core Version:    0.7.0.1
 */