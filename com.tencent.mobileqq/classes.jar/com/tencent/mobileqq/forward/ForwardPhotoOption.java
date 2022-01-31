package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SendMultiPictureHelper;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ForwardSendPicUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ForwardPhotoOption
  extends ForwardFileBaseOption
{
  SendMultiPictureHelper a;
  
  public ForwardPhotoOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_b_of_type_Boolean = true;
  }
  
  private String c(Uri paramUri)
  {
    String str = paramUri.getScheme();
    if ((str == null) || (str.equals("file"))) {
      return new File(paramUri.getPath()).getAbsolutePath();
    }
    if (str.equals("content")) {
      try
      {
        paramUri = this.jdField_a_of_type_AndroidAppActivity.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
        int i = paramUri.getColumnIndexOrThrow("_data");
        paramUri.moveToFirst();
        str = paramUri.getString(i);
        paramUri.close();
        return str;
      }
      catch (Exception paramUri)
      {
        paramUri.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  public List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("forward_source_uin_type", 0) == 9501) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (localRecentUser.type != 1003) && (localRecentUser.type != 1025) && (localRecentUser.type != 1024) && (localRecentUser.type != 1008) && (localRecentUser.type != 1021) && (localRecentUser.type != 1029) && (localRecentUser.type != 10004) && ((localRecentUser.type != 1) || (!a(localRecentUser.uin))) && ((localRecentUser.type != 1006) || (a(ForwardAbility.ForwardAbilityType.h))) && (localRecentUser.type != 7000) && (localRecentUser.type != 6004) && (localRecentUser.type != 9501) && ((localRecentUser.type != 0) || (!CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.type))) && (((localRecentUser.type != 1004) && (localRecentUser.type != 1000)) || (this.jdField_b_of_type_Boolean))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if (j()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if (h()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_d_of_type_JavaLangInteger);
    }
    if (i()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    this.jdField_a_of_type_JavaUtilSet.add(i);
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_phonecontacts", true);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10006)) {}
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_dataline", true))
      {
        this.jdField_a_of_type_JavaUtilSet.add(jdField_f_of_type_JavaLangInteger);
        this.jdField_a_of_type_JavaUtilSet.add(k);
      }
      if ((this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_smartdevice", true)) && (l())) {
        this.jdField_a_of_type_JavaUtilSet.add(j);
      }
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_qzone", false)) {
        this.jdField_a_of_type_JavaUtilSet.add(e);
      }
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_qqstory", false)) {
        this.jdField_a_of_type_JavaUtilSet.add(m);
      }
      return;
      if ((g()) && (bool)) {
        this.jdField_a_of_type_JavaUtilSet.add(h);
      }
    }
  }
  
  protected void a(Intent paramIntent)
  {
    ArrayList localArrayList3 = null;
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("fileinfo_array");
    ArrayList localArrayList1 = localArrayList3;
    if (localObject != null) {}
    try
    {
      localArrayList1 = (ArrayList)localObject;
      localArrayList3 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      if (localArrayList1 == null)
      {
        localArrayList1 = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("foward_key_m_p_l");
        if ((localArrayList1 == null) || (localArrayList1.isEmpty()))
        {
          localArrayList1 = new ArrayList();
          int i = 0;
          while (i < localArrayList3.size())
          {
            localObject = (Uri)localArrayList3.get(i);
            localArrayList1.add(a(this.jdField_a_of_type_AndroidAppActivity, (Uri)localObject));
            i += 1;
          }
          paramIntent.putStringArrayListExtra("dataline_forward_pathlist", localArrayList1);
        }
      }
      else
      {
        paramIntent.putExtra("dataline_forward_type", 101);
        paramIntent.putExtra("sendMultiple", true);
        return;
      }
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;)
      {
        ArrayList localArrayList2 = localArrayList3;
      }
    }
  }
  
  protected void a(String paramString)
  {
    ArrayList localArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007815", "0X8007815", 0, 0, "", "", "", "");
      QZoneHelper.a(paramString, localArrayList, "source_from_quick_shoot");
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardPhotoOption", 2, "content:" + paramString + "path:" + localArrayList);
    }
    paramString = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
    paramString.setFlags(67108864);
    paramString.putExtra("main_tab_id", 4);
    paramString.putExtra("fragment_id", 1);
    paramString.putExtra("switch_anim", true);
    paramString.putExtra("forward_to_someplace_from_shoot_quick", 1002);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, paramString);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public boolean a()
  {
    super.a();
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
    }
    if ((this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false)) && (this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("foward_key_m_p_l") == null))
    {
      Object localObject = this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      if ((localObject != null) && ((localObject instanceof ArrayList)))
      {
        localObject = (ArrayList)localObject;
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < ((ArrayList)localObject).size())
        {
          String str = a((Uri)((ArrayList)localObject).get(i));
          if (!TextUtils.isEmpty(str)) {
            localArrayList.add(str);
          }
          i += 1;
        }
        this.jdField_a_of_type_AndroidOsBundle.putStringArrayList("foward_key_m_p_l", localArrayList);
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
        if ((localProductInfo != null) && (localProductInfo.isSupportFuncMsgType(1)) && (a(j))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      i += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  protected void b()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(null);
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_flag_from_plugin", false))
    {
      LiteActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    super.b(paramInt);
  }
  
  protected void b(Intent paramIntent)
  {
    paramIntent.putExtra("dataline_forward_type", 101);
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_extra");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_extra");
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_filepath");
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
    }
    QLog.d("ForwardOption.ForwardPhotoOption", 1, "sendDatalineSingle filePath: " + (String)localObject2);
    paramIntent.putExtra("dataline_forward_path", (String)localObject2);
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
  
  protected void c(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  protected boolean c()
  {
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
    int j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("uinname");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
    Object localObject1 = Boolean.valueOf(this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false));
    boolean bool4 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false);
    boolean bool1 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isJumpAIO", false);
    boolean bool2 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
    boolean bool3 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_pre_guide", false);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ForwardPhotoOption realForwardTo isSendMultiple=" + localObject1 + "isFromShare=" + bool4);
    }
    Object localObject2;
    if (((Boolean)localObject1).booleanValue())
    {
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false)) {
        this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", "消息");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper = new SendMultiPictureHelper((BaseActivity)this.jdField_a_of_type_AndroidAppActivity);
      }
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("foward_key_m_p_l");
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        Object localObject3 = this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if ((localObject3 instanceof ArrayList))
          {
            localObject2 = (ArrayList)localObject3;
            localObject1 = new ArrayList();
            int i = 0;
            while (i < ((ArrayList)localObject2).size())
            {
              localObject3 = a((Uri)((ArrayList)localObject2).get(i));
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                ((ArrayList)localObject1).add(localObject3);
              }
              i += 1;
            }
          }
        }
      }
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper.a(str3, str1, j, str2, this.jdField_a_of_type_AndroidOsBundle, (ArrayList)localObject1);
      }
      for (;;)
      {
        return true;
        QQToast.a(BaseApplication.getContext(), 1, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131434480), 0).a();
      }
    }
    if (j == 1008)
    {
      localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
      ((Intent)localObject2).putExtra("chat_subType", PublicAccountManager.a(str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() != 10011)) {
        break label542;
      }
      ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject2, null);
    }
    label542:
    label612:
    do
    {
      for (;;)
      {
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject2);
        this.jdField_a_of_type_AndroidAppActivity.finish();
        return false;
        localObject2 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
        break;
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() != 10012)) {
          break label612;
        }
        ((Intent)localObject2).addFlags(268435456);
        ((Intent)localObject2).addFlags(67108864);
        ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject2, null);
      }
      if (bool4)
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", "消息");
        ((Intent)localObject2).addFlags(268435456);
        ((Intent)localObject2).addFlags(67108864);
        ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        bool4 = a((Intent)localObject2);
        boolean bool5 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromFavorites");
        if (QLog.isColorLevel()) {
          QLog.d("forward", 2, "ForwardPhotoOption realForwardTo isFromFav=" + bool5 + "isFromAIOFav=" + bool4);
        }
        if (!this.jdField_f_of_type_Boolean) {
          break label857;
        }
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
      }
      this.jdField_a_of_type_AndroidOsBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
      ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
    } while ((!bool2) && (!bool3));
    label739:
    localObject1 = "";
    if (j == 0) {
      localObject1 = "0X8007812";
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
      ((Intent)localObject2).removeExtra("forward_filepath");
      ((Intent)localObject2).removeExtra("forward_extra");
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
      break;
      label857:
      if (bool1) {
        break label739;
      }
      ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject2, null);
      break label739;
      if (j == 1) {
        localObject1 = "0X8007813";
      } else if (j == 3000) {
        localObject1 = "0X8007814";
      }
    }
  }
  
  protected int d()
  {
    Object localObject1;
    int i;
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("sendMultiple", false))
    {
      localObject1 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      QLog.i("Qfav", 1, "shareToQfav sendMultiple . size = " + ((ArrayList)localObject1).size());
      i = 0;
      if (i >= ((ArrayList)localObject1).size()) {
        break label366;
      }
      if (!QfavBuilder.b(c((Uri)((ArrayList)localObject1).get(i))).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
        i = -1;
      }
    }
    for (;;)
    {
      if (i == 0) {
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", -1, 0, 69, 0, "", "");
      }
      return i;
      i += 1;
      break;
      QLog.i("Qfav", 1, "shareToQfav single pic");
      Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a();
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
      }
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.jdField_b_of_type_JavaLangString;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        if (new File((String)localObject1).exists())
        {
          if (QfavBuilder.b((String)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
            i = 0;
          }
        }
        else if (QfavBuilder.a(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_photo_md5"), -1, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_download_image_server_path"), this.jdField_a_of_type_AndroidContentIntent.getLongExtra("forward_photo_group_fileid", 0L), this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_extra"), this.jdField_a_of_type_AndroidContentIntent.getLongExtra("forward_file_size", 0L)).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null))
        {
          i = 0;
          continue;
        }
      }
      i = -1;
      continue;
      label366:
      i = 0;
    }
  }
  
  protected String d()
  {
    if (jdField_f_of_type_JavaLangString == null) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131436305);
    }
    return jdField_f_of_type_JavaLangString;
  }
  
  protected void m()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
      this.jdField_d_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_flag_from_plugin", false))
    {
      if (ForwardSendPicUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle.getString("uin"), this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin"), true, this.jdField_a_of_type_AndroidAppActivity)) {
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1);
      }
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    r();
  }
  
  protected void n()
  {
    super.n();
    int i = a().getInt("key_forward_ability_type");
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardPhotoOption", 2, "-->getCancelListener--onClick--type = " + i);
    }
    if (i == m.intValue()) {
      StoryReportor.a("plus_shoot", "nosend_tip", 0, 0, new String[] { "", "", "", "" });
    }
  }
  
  protected void o()
  {
    p();
  }
  
  public void s()
  {
    super.s();
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper.d();
    }
  }
  
  protected void u()
  {
    Object localObject1;
    String str;
    Object localObject2;
    label94:
    ArrayList localArrayList;
    SmartDeviceProxyMgr localSmartDeviceProxyMgr;
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_flag_from_plugin", false))
    {
      localObject1 = this.jdField_b_of_type_JavaLangString;
      str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (!TextUtils.isEmpty(FileUtil.a((String)localObject1))) {
          break label295;
        }
        localObject2 = AppConstants.aK + "photo/" + String.valueOf(System.currentTimeMillis()) + ".jpg";
        FileUtils.d((String)localObject1, (String)localObject2);
        localObject1 = localObject2;
        localObject2 = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
        localArrayList = new ArrayList();
        localArrayList.add(localObject1);
        localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
        if ((!localSmartDeviceProxyMgr.c(Long.parseLong(str))) || (!localSmartDeviceProxyMgr.a(Long.parseLong(str), 17))) {
          break label298;
        }
      }
    }
    label295:
    label298:
    for (boolean bool = true;; bool = false)
    {
      if (Boolean.valueOf(bool).booleanValue()) {
        break label303;
      }
      ((DeviceMsgHandle)localObject2).a().a(DeviceMsgHandle.d, str, localArrayList);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_extra");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_extra");
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_filepath");
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("forward_filepath", (String)localObject2);
      localObject1 = localObject2;
      break;
      break label94;
    }
    label303:
    localSmartDeviceProxyMgr.a(Long.parseLong(str), "", "", "", 0, null);
    super.a((String)localObject1, str, "pic");
  }
  
  protected void v()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_to_someplace_from_shoot_quick", 1003);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007816", "0X8007816", 0, 0, "", "", "", "");
    StoryReportor.a("plus_shoot", "send_tip", 0, 0, new String[] { "", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPhotoOption
 * JD-Core Version:    0.7.0.1
 */