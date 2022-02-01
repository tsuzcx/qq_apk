package com.tencent.mobileqq.intervideo.now;

import Override;
import agej;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import anyu;
import aohi;
import auxu;
import awca;
import awcb;
import axad;
import bdwq;
import bhbx;
import bhhz;
import bhlg;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import win;

public class ShareToQQActivity
  extends BaseActivity
{
  static boolean jdField_a_of_type_Boolean;
  anyu jdField_a_of_type_Anyu = new awca(this);
  aohi jdField_a_of_type_Aohi = new awcb(this);
  public ProfileActivity.AllInOne a;
  public String a;
  String b;
  private String c = "";
  
  public ShareToQQActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = null;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public String a()
  {
    Object localObject = null;
    try
    {
      String str = bhlg.e(this.app, this.b);
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.profilecard.FrdProfileCard", 2, localException.toString());
    }
    return localObject;
    return null;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = getIntent().getStringExtra("storyid");
    String str = getIntent().getStringExtra("sourceFrom");
    if ((TextUtils.equals(this.c, "share_from_troop_member_card")) && (paramInt2 == -1))
    {
      paramIntent.putExtra("selfSet_leftViewText", getString(2131718523));
      new Intent(this, SplashActivity.class);
      localObject = agej.a(paramIntent, null);
      ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
      paramIntent = ForwardUtils.a((Intent)localObject);
      ForwardUtils.a(this.app, this, paramIntent, (Intent)localObject);
    }
    for (;;)
    {
      jdField_a_of_type_Boolean = false;
      finish();
      return;
      if (TextUtils.equals(str, "OD")) {
        bhbx.c(this.app, this, paramInt2, paramIntent);
      } else if ((TextUtils.equals(str, "StudyRoom")) || (TextUtils.equals(str, "now_qqlive")) || (TextUtils.equals(str, "StudyRoomQzone"))) {
        bdwq.a(this.app, this, paramInt2, paramIntent, str);
      } else if (!TextUtils.isEmpty((CharSequence)localObject)) {
        bhbx.a(this.app, this, paramInt2, paramIntent);
      } else {
        bhbx.b(this.app, this, paramInt2, paramIntent);
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (jdField_a_of_type_Boolean) {
      finish();
    }
    jdField_a_of_type_Boolean = true;
    Object localObject = paramBundle.getStringExtra("storyid");
    this.c = paramBundle.getStringExtra("sourceFrom");
    if (paramBundle.getBooleanExtra("isLandscape", false)) {
      setRequestedOrientation(0);
    }
    boolean bool;
    long l;
    if ("shiel_uin".equals(this.c))
    {
      addObserver(this.jdField_a_of_type_Anyu);
      bool = paramBundle.getBooleanExtra("isCancelShield", false);
      this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("uin");
      paramBundle = (FriendListHandler)this.app.a(1);
      for (;;)
      {
        try
        {
          l = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
          if (bool) {
            continue;
          }
          bool = true;
          paramBundle.a(l, bool);
        }
        catch (NumberFormatException paramBundle)
        {
          QLog.d("qqBaseActivity", 1, "changeFriendShieldFlag, NumberFormatException:shielTagetUin=" + this.jdField_a_of_type_JavaLangString);
          continue;
        }
        return false;
        bool = false;
      }
    }
    if ("source_from_operate_shiel_uin_list".equals(this.c))
    {
      addObserver(this.jdField_a_of_type_Aohi);
      bool = paramBundle.getBooleanExtra("isCancelShield", false);
      this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("uin");
      this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)paramBundle.getParcelableExtra("allinone"));
      localObject = (axad)this.app.getManager(16);
      if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null))
      {
        try
        {
          paramBundle = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          if (ProfileActivity.AllInOne.i(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
            paramBundle = a();
          }
          l = Long.parseLong(paramBundle);
          paramBundle = new ArrayList();
          paramBundle.add(Long.valueOf(l));
          int i = bhhz.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          if (bool) {
            ((axad)localObject).b(i, paramBundle);
          } else {
            ((axad)localObject).a(i, paramBundle);
          }
        }
        catch (NumberFormatException paramBundle)
        {
          if (!QLog.isColorLevel()) {
            break label680;
          }
        }
        QLog.e("Q.profilecard.FrdProfileCard", 2, "shieldMsg() " + paramBundle.toString());
      }
      else
      {
        paramBundle = new Intent();
        paramBundle.putExtra("isSuccess", false);
        paramBundle.putExtra("isCancelShield", bool);
        setResult(-1, paramBundle);
      }
    }
    else
    {
      if ("share_from_troop_member_card".equals(this.c))
      {
        auxu.a(this, paramBundle, 21);
        return true;
      }
      if (TextUtils.equals(this.c, "OD"))
      {
        bhbx.b(this, paramBundle.getExtras(), 1001);
        return true;
      }
      if ((TextUtils.equals(this.c, "StudyRoom")) || (TextUtils.equals(this.c, "now_qqlive")))
      {
        bdwq.a(this, paramBundle.getExtras(), 1001);
        return true;
      }
      if (TextUtils.equals(this.c, "StudyRoomQzone"))
      {
        bdwq.a(this, this.app.getCurrentAccountUin(), paramBundle.getExtras(), 1001);
        return true;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new MessageForQQStory();
        ((MessageForQQStory)localObject).coverImgUrl = paramBundle.getStringExtra("imageUrl");
        ((MessageForQQStory)localObject).brief = paramBundle.getStringExtra("summary");
        ((MessageForQQStory)localObject).srcName = win.jdField_a_of_type_JavaLangString;
        ((MessageForQQStory)localObject).srcAction = "mqqapi://qstory/opendiscovery?src_type=internal&version=1";
        ((MessageForQQStory)localObject).msgAction = String.format("nowmqqapi://now/openroom?src_type=app&version=1&roomid=%s&first=%d&bid=1&contentType=2&unionid=%s", new Object[] { Long.valueOf(paramBundle.getLongExtra("roomid", 0L)), Integer.valueOf(2), paramBundle.getStringExtra("unionid") });
        ((MessageForQQStory)localObject).authorName = paramBundle.getStringExtra("anchorname");
        ((MessageForQQStory)localObject).logoImgUrl = "https://p.qpic.cn/qqstory_pic/hb4ycQ6NORNib7icgbswTvTCmkTyROl41Rcw9UeasFKzLwevbfJVhMRA/";
        ((MessageForQQStory)localObject).briefBgColor = -16395392;
        ((MessageForQQStory)localObject).type = 0;
        bhbx.a(this, (MessageForQQStory)localObject, 1001);
      }
      for (;;)
      {
        return true;
        bhbx.a(this, paramBundle.getExtras(), 1001);
      }
    }
    label680:
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    jdField_a_of_type_Boolean = false;
    if ("shiel_uin".equals(this.c)) {
      removeObserver(this.jdField_a_of_type_Anyu);
    }
    while (!"source_from_operate_shiel_uin_list".equals(this.c)) {
      return;
    }
    removeObserver(this.jdField_a_of_type_Aohi);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.ShareToQQActivity
 * JD-Core Version:    0.7.0.1
 */