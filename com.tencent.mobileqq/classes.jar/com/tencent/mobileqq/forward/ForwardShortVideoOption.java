package com.tencent.mobileqq.forward;

import aciy;
import ahhk;
import ajed;
import ajjy;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aphp;
import apjy;
import apmr;
import apms;
import atps;
import awdq;
import aweg;
import awey;
import awfo;
import awmc;
import awqx;
import axts;
import azzg;
import azzz;
import bace;
import bafb;
import bajq;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqb;
import urp;
import xrh;
import xsm;

public class ForwardShortVideoOption
  extends aphp
{
  private apms a;
  
  public ForwardShortVideoOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 7;
  }
  
  private void G()
  {
    Object localObject1;
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromFavorite", false))
    {
      localObject1 = ajed.bi + "pic/" + this.jdField_a_of_type_AndroidContentIntent.getStringExtra("thumbfile_md5") + "_0";
      String str = this.jdField_b_of_type_JavaLangString;
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!new File(str).exists()) && (new File((String)localObject1).exists())) {
        bace.d((String)localObject1, str);
      }
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShortVideoOption", 2, "initPreviewImage " + this.jdField_b_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = axts.a(this.jdField_b_of_type_JavaLangString, awmc.a(100.0F), awmc.a(300.0F));
        if (localObject1 == null) {
          break label275;
        }
        localObject1 = ((URL)localObject1).toString();
        localObject1 = URLDrawable.getDrawable((String)localObject1);
        ((URLDrawable)localObject1).setBounds(0, 0, awmc.a(248.0F), awmc.a(248.0F));
        this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_is_long_video", false);
        this.jdField_a_of_type_AndroidContentIntent.getIntExtra("file_send_size", 0);
        this.jdField_a_of_type_AndroidContentIntent.getIntExtra("file_send_duration", 0);
        ThreadManager.excute(new ForwardShortVideoOption.3(this, (URLDrawable)localObject1), 16, null, false);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("ForwardOption.ForwardShortVideoOption", 2, "initPreviewImage omm!", localOutOfMemoryError);
        this.jdField_a_of_type_Apms.a(null);
        return;
      }
      this.jdField_a_of_type_Apms.a(null);
      return;
      label275:
      Object localObject2 = null;
    }
  }
  
  private void e()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ShortVideoPlayActivity.class);
    Object localObject;
    if (this.jdField_a_of_type_AndroidOsBundle.getParcelable("key_message_for_shortvideo") != null)
    {
      localObject = (MessageForShortVideo)this.jdField_a_of_type_AndroidOsBundle.getParcelable("key_message_for_shortvideo");
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShortVideoOption", 2, "enterVideoPreview msg " + ((MessageForShortVideo)localObject).videoFileName);
      }
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      localIntent.putExtra("video_play_caller", 5);
      localIntent.putExtra("message_click_start", System.currentTimeMillis());
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      D();
    }
    do
    {
      return;
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("file_send_path");
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShortVideoOption", 2, "enterVideoPreview file " + (String)localObject);
      }
      if (bace.a((String)localObject))
      {
        localIntent.putExtra("file_send_path", (String)localObject);
        localIntent.putExtra("video_play_caller", 6);
        localIntent.putExtra("message_click_start", System.currentTimeMillis());
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ForwardOption.ForwardShortVideoOption", 2, "enterVideoPreview file not exit ");
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131493341, null);
    int i = bajq.a(15.0F);
    localView.setPadding(0, i, 0, i);
    this.jdField_a_of_type_Apms = new apms(null);
    this.jdField_a_of_type_Apms.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131301079));
    ((ChatThumbView)this.jdField_a_of_type_Apms.jdField_a_of_type_AndroidWidgetImageView).jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Apms.jdField_a_of_type_ComTencentMobileqqForwardForwardShortVideoOption$PressDarkImageView = new ForwardShortVideoOption.PressDarkImageView(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Apms.jdField_a_of_type_ComTencentMobileqqForwardForwardShortVideoOption$PressDarkImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130839565));
    this.jdField_a_of_type_Apms.jdField_a_of_type_ComTencentMobileqqForwardForwardShortVideoOption$PressDarkImageView.jdField_a_of_type_AndroidWidgetImageView = this.jdField_a_of_type_Apms.jdField_a_of_type_AndroidWidgetImageView;
    RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131301078);
    i = bajq.a(40.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(13);
    localRelativeLayout.addView(this.jdField_a_of_type_Apms.jdField_a_of_type_ComTencentMobileqqForwardForwardShortVideoOption$PressDarkImageView, localLayoutParams);
    localView.findViewById(2131301078).setVisibility(0);
    G();
    this.jdField_a_of_type_Apms.jdField_a_of_type_ComTencentMobileqqForwardForwardShortVideoOption$PressDarkImageView.setContentDescription(ajjy.a(2131639040));
    this.jdField_a_of_type_Apms.jdField_a_of_type_ComTencentMobileqqForwardForwardShortVideoOption$PressDarkImageView.setOnClickListener(new apmr(this));
    return localView;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
    paramList = paramList.iterator();
    label171:
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!azzz.a(localRecentUser.uin)) && (localRecentUser.getType() != 10004) && ((localRecentUser.getType() != 0) || (!mqb.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType()))) && ((localRecentUser.getType() == 0) || (localRecentUser.getType() == 1) || (localRecentUser.getType() == 3000)))
      {
        if ((localHotChatManager != null) && (localHotChatManager.b(localRecentUser.uin))) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label171;
          }
          localArrayList.add(localRecentUser);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (k()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (l()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (m()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_smartdevice", true);
    if ((o()) && (bool)) {
      this.jdField_a_of_type_JavaUtilSet.add(j);
    }
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_qzone", false)) {
      this.jdField_a_of_type_JavaUtilSet.add(e);
    }
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_qqstory", false)) {
      this.jdField_a_of_type_JavaUtilSet.add(m);
    }
  }
  
  public boolean a(bafb parambafb)
  {
    String str1 = null;
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_forward_ptv", false))
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
      try
      {
        parambafb.setPreviewImage(apjy.a(azzg.a(new BitmapDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources(), this.jdField_b_of_type_JavaLangString))), true, 1);
        return false;
      }
      catch (OutOfMemoryError parambafb)
      {
        for (;;)
        {
          QLog.e("ForwardOption.ForwardShortVideoOption", 2, "get ptv drawable omm!", parambafb);
        }
      }
    }
    Object localObject;
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromFavorite", false))
    {
      localObject = ajed.bi + "pic/" + this.jdField_a_of_type_AndroidContentIntent.getStringExtra("thumbfile_md5") + "_0";
      String str2 = this.jdField_b_of_type_JavaLangString;
      if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (!new File(str2).exists()) && (new File((String)localObject).exists())) {
        bace.d((String)localObject, str2);
      }
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      try
      {
        localObject = axts.a(this.jdField_b_of_type_JavaLangString, awmc.a(100.0F), awmc.a(300.0F));
        if (localObject != null) {
          str1 = ((URL)localObject).toString();
        }
        ThreadManager.post(new ForwardShortVideoOption.1(this, URLDrawable.getDrawable(str1), parambafb, this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_is_long_video", false), this.jdField_a_of_type_AndroidContentIntent.getIntExtra("file_send_size", 0), this.jdField_a_of_type_AndroidContentIntent.getIntExtra("file_send_duration", 0)), 8, null, false);
        return false;
      }
      catch (OutOfMemoryError parambafb)
      {
        QLog.e("ForwardOption.ForwardShortVideoOption", 2, "get shortvideo drawable omm!", parambafb);
        return true;
      }
    }
    return true;
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    xrh localxrh = (xrh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    int j = paramArrayOfDeviceInfo.length;
    int i = 0;
    while (i < j)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[i];
      if (localDeviceInfo != null)
      {
        ProductInfo localProductInfo = localxrh.a(localDeviceInfo.productId);
        if ((localProductInfo != null) && (localProductInfo.isSupportFuncMsgType(2)) && (a(j))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      i += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  public void b(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    localIntent.putExtra("set_user_callback", "cooperation.qzone.video.VideoComponentCallback");
    localIntent.putExtra("forward_to_qzone_to_enable_edit", true);
    localIntent.putExtra("forward_source_to_qzone", "source_from_quick_shoot");
    localIntent.putExtra("key_content", paramString);
    localIntent.setFlags(67108864);
    localIntent.putExtra("main_tab_id", 4);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("switch_anim", true);
    localIntent.putExtra("forward_to_someplace_from_shoot_quick", 1002);
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800780F", "0X800780F", 0, 0, "", "", "", "");
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public boolean b()
  {
    return true;
  }
  
  public int c()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type");
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_ability_entrence_show_in_share", false);
    if ((i == e.intValue()) && (bool)) {
      return 2;
    }
    return super.c();
  }
  
  public boolean c()
  {
    int i = 2;
    boolean bool1 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromFavorite", false);
    boolean bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_need_sendmsg", false);
    boolean bool3 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
    boolean bool4 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_pre_guide", false);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "forwardShortvideo realForwardTo isNeedSendMsg=" + bool2 + "isFromFavorite=" + bool1);
    }
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (f())
    {
      localObject2 = b();
      if (bool1)
      {
        localObject1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
        ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ResultRecord)((Iterator)localObject2).next();
          ((Intent)localObject1).putExtra("uin", ((ResultRecord)localObject3).jdField_a_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("uintype", ((ResultRecord)localObject3).a());
          ((Intent)localObject1).putExtra("uinname", ((ResultRecord)localObject3).jdField_b_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("troop_uin", ((ResultRecord)localObject3).c);
          localObject3 = aweg.a(localObject1, aweg.a(0, 2));
          ((awfo)localObject3).c = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
          ((awfo)localObject3).d = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
          ((awfo)localObject3).jdField_b_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
          ((awfo)localObject3).jdField_a_of_type_Int = 2;
          ((awfo)localObject3).i = true;
          new awdq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((awfo)localObject3);
        }
        if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromFavoriteDetail", false)) {
          break label1161;
        }
        localObject1 = aciy.a((Intent)localObject1, null);
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject1);
      }
    }
    label1161:
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject1);
      return true;
      int j;
      if (this.jdField_a_of_type_AndroidOsBundle.getInt("param_key_redbag_type", 0) == LocalMediaInfo.REDBAG_TYPE_GET)
      {
        j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype", -1);
        i = 3;
        if (j == 1)
        {
          i = 1;
          ahhk.a("", "0X80088E4", String.valueOf(i));
        }
      }
      else
      {
        localObject1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
        ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        localObject2 = aciy.a((Intent)localObject1, null);
        ((Intent)localObject2).putExtra("isBack2Root", true);
        if (!bool2) {
          break label500;
        }
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject2, null);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject2);
        return true;
        if (j != 3000) {
          break;
        }
        i = 2;
        break;
        label500:
        if ((bool3) || (bool4))
        {
          localObject3 = new SessionInfo();
          ((SessionInfo)localObject3).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
          ((SessionInfo)localObject3).jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
          ((SessionInfo)localObject3).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
          ((Intent)localObject2).putExtra("PhotoConst.SEND_SESSION_INFO", (Parcelable)localObject3);
          localObject1 = "";
          if (((SessionInfo)localObject3).jdField_a_of_type_Int == 0) {
            localObject1 = "0X800780C";
          }
          for (;;)
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
            break;
            if (((SessionInfo)localObject3).jdField_a_of_type_Int == 1) {
              localObject1 = "0X800780D";
            } else if (((SessionInfo)localObject3).jdField_a_of_type_Int == 3000) {
              localObject1 = "0X800780E";
            }
          }
        }
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
      }
      if (bool1)
      {
        localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
        ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        localObject1 = aweg.a(localObject2, aweg.a(0, 2));
        ((awfo)localObject1).c = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
        ((awfo)localObject1).d = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
        ((awfo)localObject1).jdField_b_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
        ((awfo)localObject1).jdField_a_of_type_Int = 2;
        ((awfo)localObject1).i = true;
        new awdq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((awfo)localObject1);
        localObject1 = localObject2;
        if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromFavoriteDetail", false))
        {
          localObject1 = aciy.a((Intent)localObject2, null);
          this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject1);
        }
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject1);
        this.jdField_a_of_type_AndroidAppActivity.finish();
        return true;
      }
      if (this.jdField_a_of_type_AndroidOsBundle.getInt("param_key_redbag_type", 0) == LocalMediaInfo.REDBAG_TYPE_GET)
      {
        j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype", -1);
        if (j == 1)
        {
          i = 1;
          ahhk.a("", "0X80088E4", String.valueOf(i));
        }
      }
      else
      {
        localObject1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
        ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        localObject2 = aciy.a((Intent)localObject1, null);
        ((Intent)localObject2).putExtra("isBack2Root", true);
        if (!bool2) {
          break label995;
        }
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject2, null);
      }
      label995:
      while ((!bool3) && (!bool4))
      {
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject2);
        this.jdField_a_of_type_AndroidAppActivity.finish();
        return true;
        if (j == 3000) {
          break;
        }
        i = 3;
        break;
      }
      localObject3 = new SessionInfo();
      ((SessionInfo)localObject3).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      ((SessionInfo)localObject3).jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
      ((SessionInfo)localObject3).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
      ((Intent)localObject2).putExtra("PhotoConst.SEND_SESSION_INFO", (Parcelable)localObject3);
      localObject1 = "";
      if (((SessionInfo)localObject3).jdField_a_of_type_Int == 0) {
        localObject1 = "0X800780C";
      }
      for (;;)
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
        break;
        if (((SessionInfo)localObject3).jdField_a_of_type_Int == 1) {
          localObject1 = "0X800780D";
        } else if (((SessionInfo)localObject3).jdField_a_of_type_Int == 3000) {
          localObject1 = "0X800780E";
        }
      }
    }
  }
  
  public void d()
  {
    super.d();
    int i;
    String str;
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("NeedReportForwardShortVideo", false))
    {
      i = atps.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), this.jdField_a_of_type_AndroidOsBundle.getString("uin"));
      if (i != 3) {
        break label90;
      }
      str = "1";
    }
    for (;;)
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005622", "0X8005622", 0, 0, str, "", "", "");
      return;
      label90:
      if (i == 2) {
        str = "2";
      } else if (i == 0) {
        str = "3";
      } else {
        str = "4";
      }
    }
  }
  
  public boolean h()
  {
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_forward_ptv", false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShortVideoOption", 2, "isFromPtv use old");
      }
      return false;
    }
    return true;
  }
  
  public void r()
  {
    super.r();
    int i = a().getInt("key_forward_ability_type");
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardShortVideoOption", 2, "-->getCancelListener--onClick--type = " + i);
    }
    if (i == m.intValue()) {
      urp.a("plus_shoot", "nosend_tip", 0, 0, new String[] { "", "", "", "" });
    }
  }
  
  public void y()
  {
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_AndroidOsBundle.getString("uin"));
    ((Intent)localObject2).putExtra("troop_uin", this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin"));
    ((Intent)localObject2).putExtra("uintype", this.jdField_a_of_type_AndroidOsBundle.getInt("uintype", 9501));
    ((Intent)localObject2).putExtra("file_send_size", this.jdField_a_of_type_AndroidOsBundle.getInt("file_send_size", 0));
    ((Intent)localObject2).putExtra("file_send_business_type", this.jdField_a_of_type_AndroidOsBundle.getInt("file_send_business_type", -1));
    ((Intent)localObject2).putExtra("file_send_duration", this.jdField_a_of_type_AndroidOsBundle.getInt("file_send_duration", -1));
    ((Intent)localObject2).putExtra("file_send_path", this.jdField_a_of_type_AndroidOsBundle.getString("file_send_path"));
    ((Intent)localObject2).putExtra("thumbfile_send_path", this.jdField_a_of_type_AndroidOsBundle.getString("thumbfile_send_path"));
    ((Intent)localObject2).putExtra("file_shortvideo_md5", this.jdField_a_of_type_AndroidOsBundle.getString("file_shortvideo_md5"));
    ((Intent)localObject2).putExtra("thumbfile_send_width", this.jdField_a_of_type_AndroidOsBundle.getInt("thumbfile_send_width", 0));
    ((Intent)localObject2).putExtra("thumbfile_send_height", this.jdField_a_of_type_AndroidOsBundle.getInt("thumbfile_send_height", 0));
    ((Intent)localObject2).putExtra("thumbfile_md5", this.jdField_a_of_type_AndroidOsBundle.getString("thumbfile_md5"));
    ((Intent)localObject2).putExtra("file_source", this.jdField_a_of_type_AndroidOsBundle.getString("file_source"));
    ((Intent)localObject2).putExtra("file_video_source_dir", this.jdField_a_of_type_AndroidOsBundle.getString("file_video_source_dir"));
    Object localObject1 = aweg.a(0, 4);
    localObject2 = aweg.a(localObject2, (awey)localObject1);
    ((awey)localObject1).a((awfo)localObject2);
    xsm localxsm = new xsm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    MessageRecord localMessageRecord = localxsm.a((awfo)localObject2);
    localxsm.a(localMessageRecord);
    ((awfo)localObject2).jdField_a_of_type_JavaLangObject = localMessageRecord;
    ((awey)localObject1).a((awfo)localObject2);
    aweg.a((awey)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
    ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
    localObject1 = aciy.a((Intent)localObject1, null);
    ((Intent)localObject1).putExtra("isBack2Root", true);
    this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject1);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public void z()
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(a());
    localIntent.putExtra("forward_to_someplace_from_shoot_quick", 1003);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007810", "0X8007810", 0, 0, "", "", "", "");
    urp.a("plus_shoot", "send_tip", 0, 0, new String[] { "", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShortVideoOption
 * JD-Core Version:    0.7.0.1
 */