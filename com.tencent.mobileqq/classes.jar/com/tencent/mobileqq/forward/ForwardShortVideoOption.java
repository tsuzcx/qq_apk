package com.tencent.mobileqq.forward;

import admj;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DevLittleVideoOperator;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.shortvideo.AioShortVideoOperator;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.RegionalThumbDownloader;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ForwardShortVideoOption
  extends ForwardBaseOption
{
  public ForwardShortVideoOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
    paramList = paramList.iterator();
    label233:
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (((!Utils.a(localRecentUser.uin)) && (localRecentUser.type != 1025) && (localRecentUser.type != 1029) && (localRecentUser.type != 10004) && (localRecentUser.type != 1024) && ((localRecentUser.type != 0) || (!CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.type))) && ((localRecentUser.type == 0) || (localRecentUser.type == 1) || (localRecentUser.type == 3000))) || (((localRecentUser.type == 1004) || (localRecentUser.type == 1000)) && (this.jdField_b_of_type_Boolean))))
      {
        if ((localHotChatManager != null) && (localHotChatManager.b(localRecentUser.uin))) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label233;
          }
          localArrayList.add(localRecentUser);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if (h()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (i()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (j()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_smartdevice", true);
    if ((l()) && (bool)) {
      this.jdField_a_of_type_JavaUtilSet.add(j);
    }
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_qzone", false)) {
      this.jdField_a_of_type_JavaUtilSet.add(e);
    }
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_qqstory", false)) {
      this.jdField_a_of_type_JavaUtilSet.add(m);
    }
  }
  
  protected void a(String paramString)
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
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800780F", "0X800780F", 0, 0, "", "", "", "");
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    String str1 = null;
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_forward_ptv", false))
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
      try
      {
        paramQQCustomDialog.setPreviewImage(ForwardOptionUtils.a(SkinUtils.a(new BitmapDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources(), this.jdField_b_of_type_JavaLangString))), true, 1);
        return false;
      }
      catch (OutOfMemoryError paramQQCustomDialog)
      {
        for (;;)
        {
          QLog.e("ForwardOption.ForwardShortVideoOption", 2, "get ptv drawable omm!", paramQQCustomDialog);
        }
      }
    }
    Object localObject;
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromFavorite", false))
    {
      localObject = AppConstants.aW + "pic/" + this.jdField_a_of_type_AndroidContentIntent.getStringExtra("thumbfile_md5") + "_0";
      String str2 = this.jdField_b_of_type_JavaLangString;
      if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (!new File(str2).exists()) && (new File((String)localObject).exists())) {
        FileUtils.d((String)localObject, str2);
      }
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      try
      {
        localObject = RegionalThumbDownloader.a(this.jdField_b_of_type_JavaLangString, ScreenUtil.a(100.0F), ScreenUtil.a(300.0F));
        if (localObject != null) {
          str1 = ((URL)localObject).toString();
        }
        ThreadManager.post(new admj(this, URLDrawable.getDrawable(str1), paramQQCustomDialog, this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_is_long_video", false), this.jdField_a_of_type_AndroidContentIntent.getIntExtra("file_send_size", 0), this.jdField_a_of_type_AndroidContentIntent.getIntExtra("file_send_duration", 0)), 8, null, false);
        return false;
      }
      catch (OutOfMemoryError paramQQCustomDialog)
      {
        QLog.e("ForwardOption.ForwardShortVideoOption", 2, "get shortvideo drawable omm!", paramQQCustomDialog);
        return true;
      }
    }
    return true;
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    int j = paramArrayOfDeviceInfo.length;
    int i = 0;
    while (i < j)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[i];
      if (localDeviceInfo != null)
      {
        ProductInfo localProductInfo = localSmartDeviceProxyMgr.a(localDeviceInfo.productId);
        if ((localProductInfo != null) && (localProductInfo.isSupportFuncMsgType(2)) && (a(j))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      i += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  protected int c()
  {
    int j = 0;
    int k = this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type");
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_ability_entrence_show_in_share", false);
    int i = j;
    if (k == e.intValue())
    {
      i = j;
      if (bool) {
        i = 2;
      }
    }
    return i;
  }
  
  protected boolean c()
  {
    boolean bool1 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromFavorite", false);
    boolean bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_need_sendmsg", false);
    boolean bool3 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
    boolean bool4 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_pre_guide", false);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "forwardShortvideo realForwardTo isNeedSendMsg=" + bool2 + "isFromFavorite=" + bool1);
    }
    Intent localIntent;
    Object localObject;
    if (bool1)
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      localObject = ShortVideoBusiManager.a(localIntent, ShortVideoBusiManager.a(0, 2));
      ((ShortVideoUploadInfo)localObject).c = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      ((ShortVideoUploadInfo)localObject).d = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
      ((ShortVideoUploadInfo)localObject).b = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
      ((ShortVideoUploadInfo)localObject).jdField_a_of_type_Int = 2;
      new AioShortVideoOperator(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((ShortVideoUploadInfo)localObject);
      localObject = localIntent;
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromFavoriteDetail", false))
      {
        localObject = AIOUtils.a(localIntent, null);
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
      }
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return true;
    }
    int j;
    int i;
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("param_key_redbag_type", 0) == LocalMediaInfo.REDBAG_TYPE_GET)
    {
      j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype", -1);
      i = 3;
      if (j == 1)
      {
        i = 1;
        FlowCameraMqqAction.a("", "0X80088E4", String.valueOf(i));
      }
    }
    else
    {
      localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
      ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      localIntent = AIOUtils.a((Intent)localObject, null);
      localIntent.putExtra("isBack2Root", true);
      if (!bool2) {
        break label404;
      }
      ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return true;
      if (j != 3000) {
        break;
      }
      i = 2;
      break;
      label404:
      if ((bool3) || (bool4))
      {
        SessionInfo localSessionInfo = new SessionInfo();
        localSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
        localSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
        localSessionInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
        localIntent.putExtra("PhotoConst.SEND_SESSION_INFO", localSessionInfo);
        localObject = "";
        if (localSessionInfo.jdField_a_of_type_Int == 0) {
          localObject = "0X800780C";
        }
        for (;;)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
          break;
          if (localSessionInfo.jdField_a_of_type_Int == 1) {
            localObject = "0X800780D";
          } else if (localSessionInfo.jdField_a_of_type_Int == 3000) {
            localObject = "0X800780E";
          }
        }
      }
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    }
  }
  
  protected void m()
  {
    super.m();
    int i;
    String str;
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("NeedReportForwardShortVideo", false))
    {
      i = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), this.jdField_a_of_type_AndroidOsBundle.getString("uin"));
      if (i != 3) {
        break label84;
      }
      str = "1";
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005622", "0X8005622", 0, 0, str, "", "", "");
      return;
      label84:
      if (i == 2) {
        str = "2";
      } else if (i == 0) {
        str = "3";
      } else {
        str = "4";
      }
    }
  }
  
  protected void n()
  {
    super.n();
    int i = a().getInt("key_forward_ability_type");
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardShortVideoOption", 2, "-->getCancelListener--onClick--type = " + i);
    }
    if (i == m.intValue()) {
      StoryReportor.a("plus_shoot", "nosend_tip", 0, 0, new String[] { "", "", "", "" });
    }
  }
  
  protected void u()
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
    Object localObject1 = ShortVideoBusiManager.a(0, 4);
    localObject2 = ShortVideoBusiManager.a(localObject2, (ShortVideoReq)localObject1);
    ((ShortVideoReq)localObject1).a((ShortVideoUploadInfo)localObject2);
    DevLittleVideoOperator localDevLittleVideoOperator = new DevLittleVideoOperator(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    MessageRecord localMessageRecord = localDevLittleVideoOperator.a((ShortVideoUploadInfo)localObject2);
    localDevLittleVideoOperator.a(localMessageRecord);
    ((ShortVideoUploadInfo)localObject2).jdField_a_of_type_JavaLangObject = localMessageRecord;
    ((ShortVideoReq)localObject1).a((ShortVideoUploadInfo)localObject2);
    ShortVideoBusiManager.a((ShortVideoReq)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
    ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
    localObject1 = AIOUtils.a((Intent)localObject1, null);
    ((Intent)localObject1).putExtra("isBack2Root", true);
    this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject1);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  protected void v()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_to_someplace_from_shoot_quick", 1003);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007810", "0X8007810", 0, 0, "", "", "", "");
    StoryReportor.a("plus_shoot", "send_tip", 0, 0, new String[] { "", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShortVideoOption
 * JD-Core Version:    0.7.0.1
 */