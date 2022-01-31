package com.tencent.mobileqq.forward;

import adkv;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ForwardFileOption
  extends ForwardFileBaseOption
{
  private static ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  private static FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  boolean g = false;
  protected boolean h;
  boolean i;
  private boolean j;
  
  public ForwardFileOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_i_of_type_Boolean = false;
  }
  
  public static int a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity != null) {}
    switch (paramFileManagerEntity.getCloudType())
    {
    case 4: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("dataline", 2, "FileManagerEntity->cloudType 转 ForwardFileInfo->type， 未识别的cloudType[" + paramFileManagerEntity.getCloudType());
      }
    case 3: 
    case 5: 
    case 6: 
    case 7: 
      do
      {
        return 10000;
      } while (FileUtil.b(paramFileManagerEntity.getFilePath()));
      return 10009;
    case 1: 
      return 10002;
    case 2: 
      return 10003;
    }
    return 10011;
  }
  
  public static ForwardFileInfo a(FileManagerEntity paramFileManagerEntity)
  {
    return a(paramFileManagerEntity, null);
  }
  
  public static ForwardFileInfo a(FileManagerEntity paramFileManagerEntity, ChatMessage paramChatMessage)
  {
    jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    paramChatMessage = new ForwardFileInfo();
    paramChatMessage.b(a(paramFileManagerEntity));
    paramChatMessage.d(paramFileManagerEntity.getCloudType());
    paramChatMessage.b(paramFileManagerEntity.nSessionId);
    paramChatMessage.c(paramFileManagerEntity.uniseq);
    paramChatMessage.d(paramFileManagerEntity.fileName);
    paramChatMessage.d(paramFileManagerEntity.fileSize);
    paramChatMessage.a(paramFileManagerEntity.getFilePath());
    paramChatMessage.c(paramFileManagerEntity.WeiYunFileId);
    if ((paramFileManagerEntity.strLargeThumPath != null) && (paramFileManagerEntity.strLargeThumPath.length() > 0)) {
      paramChatMessage.f(paramFileManagerEntity.strLargeThumPath);
    }
    for (;;)
    {
      if (paramFileManagerEntity.Uuid != null) {
        paramChatMessage.b(paramFileManagerEntity.Uuid);
      }
      if (paramFileManagerEntity.TroopUin != 0L) {
        paramChatMessage.a(paramFileManagerEntity.TroopUin);
      }
      if (paramFileManagerEntity.strTroopFileID != null) {
        paramChatMessage.e(paramFileManagerEntity.strTroopFileID);
      }
      return paramChatMessage;
      paramChatMessage.f(paramFileManagerEntity.strThumbPath);
    }
  }
  
  private String a(String paramString)
  {
    String str = AppConstants.aJ + "photo/" + String.valueOf(System.currentTimeMillis()) + ".jpg";
    try
    {
      ImageUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), paramString, str, 600, 800);
      return str;
    }
    catch (Exception paramString) {}
    return str;
  }
  
  private String e()
  {
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null)
    {
      localObject2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_filepath");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label75;
      }
      localObject2 = null;
    }
    label75:
    int k;
    do
    {
      return localObject2;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a();
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.f();
      break;
      k = FileManagerUtil.a((String)localObject1);
      if (k == -1) {
        break label93;
      }
      localObject2 = localObject1;
    } while (k != 11);
    label93:
    return a((String)localObject1);
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
      if ((localRecentUser != null) && (localRecentUser.type != 9501) && ((localRecentUser.type != 1006) || (a(ForwardAbility.ForwardAbilityType.jdField_h_of_type_JavaLangInteger))) && (localRecentUser.type != 6004) && (localRecentUser.type != 7000)) {
        if (this.jdField_h_of_type_Boolean)
        {
          if (((localRecentUser.type == 1) && (!a(localRecentUser.uin))) || ((localRecentUser.type == 0) && (!CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.type))) || (localRecentUser.type == 3000) || (-1L != FileManagerUtil.a(localRecentUser.type))) {
            localArrayList.add(localRecentUser);
          }
        }
        else if (this.jdField_j_of_type_Boolean)
        {
          if (((localRecentUser.type == 0) && (!CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.type))) || (localRecentUser.type == 1) || (localRecentUser.type == 3000) || (localRecentUser.type == 1006) || (localRecentUser.type == 1004) || (localRecentUser.type == 1000)) {
            localArrayList.add(localRecentUser);
          }
        }
        else if (this.jdField_i_of_type_Boolean)
        {
          if (localRecentUser.type == 1) {
            localArrayList.add(localRecentUser);
          }
        }
        else if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (((localRecentUser.type == 0) && (!CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.type))) || (localRecentUser.type == 3000) || ((localRecentUser.type == 1) && (a(c)) && (!a(localRecentUser.uin))) || (-1L != FileManagerUtil.a(localRecentUser.type)))) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if ((!this.jdField_i_of_type_Boolean) && (j()))
    {
      this.jdField_a_of_type_JavaUtilSet.add(b);
      this.jdField_a_of_type_JavaUtilSet.add(jdField_i_of_type_JavaLangInteger);
      this.jdField_a_of_type_JavaUtilSet.add(jdField_h_of_type_JavaLangInteger);
    }
    if ((!this.jdField_i_of_type_Boolean) && (h())) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10006) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10003) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10002) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() != 10009)) || (i())) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null) {
      if (DataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b())))
      {
        this.jdField_a_of_type_JavaUtilSet.add(jdField_f_of_type_JavaLangInteger);
        this.jdField_a_of_type_JavaUtilSet.add(k);
        break label352;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidContentIntent != null) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromFavorites", false))) {
        this.jdField_a_of_type_JavaUtilSet.add(jdField_f_of_type_JavaLangInteger);
      }
      if ((this.jdField_a_of_type_AndroidContentIntent != null) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_smartdevice", true)) && (l()))
      {
        int k = FileManagerUtil.a(e());
        if ((k == 2) || (k == 3) || (k == 0) || (k == 7) || (k == 6) || (k == 10) || (k == 9)) {
          this.jdField_a_of_type_JavaUtilSet.add(jdField_j_of_type_JavaLangInteger);
        }
      }
      return;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        label352:
        if (!localIterator.hasNext()) {
          continue;
        }
        ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)localIterator.next();
        if ((localForwardFileInfo == null) || (!DataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localForwardFileInfo.b())))) {
          break;
        }
        this.jdField_a_of_type_JavaUtilSet.add(jdField_f_of_type_JavaLangInteger);
        this.jdField_a_of_type_JavaUtilSet.add(k);
        continue;
      }
      this.jdField_a_of_type_JavaUtilSet.add(jdField_f_of_type_JavaLangInteger);
      this.jdField_a_of_type_JavaUtilSet.add(k);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((this.jdField_h_of_type_Boolean) && (!this.g) && (-1L != FileManagerUtil.a(paramBundle.getInt("uintype"))))
    {
      DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getString(2131429725), this.jdField_a_of_type_AndroidAppActivity.getString(2131429726), null, this.jdField_a_of_type_AndroidAppActivity.getString(2131435196), new adkv(this), null).show();
      return;
    }
    super.a(paramInt, paramBundle);
  }
  
  protected void a(Intent paramIntent)
  {
    ArrayList localArrayList2 = null;
    ArrayList localArrayList1 = this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("fileinfo_array");
    if (localArrayList1 != null) {}
    for (;;)
    {
      try
      {
        localArrayList1 = (ArrayList)localArrayList1;
        ArrayList localArrayList3 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
        if (localArrayList1 == null)
        {
          localArrayList2 = new ArrayList();
          int k = 0;
          if (k < localArrayList3.size())
          {
            Uri localUri = (Uri)localArrayList3.get(k);
            localArrayList2.add(a(this.jdField_a_of_type_AndroidAppActivity, localUri));
            k += 1;
            continue;
          }
        }
      }
      catch (ClassCastException localClassCastException)
      {
        localObject = null;
        continue;
        paramIntent.putExtra("dataline_forward_type", 100);
        paramIntent.putExtra("sendMultiple", true);
        if (localObject == null) {
          paramIntent.putStringArrayListExtra("dataline_forward_pathlist", localArrayList2);
        }
        return;
      }
      Object localObject = null;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    super.a();
    this.e = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward _key_nojump", false);
    Object localObject;
    int k;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null)
    {
      int m = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.d();
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        k = 1;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() != 10006) {
          break label166;
        }
        bool1 = true;
        label72:
        this.jdField_h_of_type_Boolean = bool1;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() != 10009) {
          break label171;
        }
        bool1 = true;
        label92:
        this.jdField_i_of_type_Boolean = bool1;
        if (m != 2) {
          break label176;
        }
        bool1 = true;
        label104:
        this.jdField_j_of_type_Boolean = bool1;
        bool1 = bool2;
        if (k != 0) {
          if (m != 3)
          {
            bool1 = bool2;
            if (!FileUtils.a((String)localObject)) {}
          }
          else
          {
            bool1 = true;
          }
        }
        this.g = bool1;
        label138:
        break label202;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", this.jdField_a_of_type_AndroidAppActivity.getString(2131433297));
      return true;
      k = 0;
      break;
      label166:
      bool1 = false;
      break label72;
      label171:
      bool1 = false;
      break label92;
      label176:
      bool1 = false;
      break label104;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        this.jdField_i_of_type_Boolean = true;
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        label202:
        if (!((Iterator)localObject).hasNext()) {
          continue;
        }
        ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)((Iterator)localObject).next();
        if ((localForwardFileInfo == null) || (localForwardFileInfo.d() == 6)) {
          break label138;
        }
        this.jdField_i_of_type_Boolean = false;
        continue;
      }
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false)) {
        this.g = true;
      }
    }
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    int m = paramArrayOfDeviceInfo.length;
    int k = 0;
    if (k < m)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[k];
      ProductInfo localProductInfo;
      if (localDeviceInfo != null)
      {
        int n = FileManagerUtil.a(e());
        localProductInfo = localSmartDeviceProxyMgr.a(localDeviceInfo.productId);
        if ((n != 2) || (!localSmartDeviceProxyMgr.c(localDeviceInfo.din)) || (!localSmartDeviceProxyMgr.a(localDeviceInfo.din, 17))) {
          break label105;
        }
      }
      for (;;)
      {
        k += 1;
        break;
        label105:
        if ((localProductInfo != null) && (localProductInfo.isSupportMainMsgType(8)) && (a(jdField_j_of_type_JavaLangInteger))) {
          localArrayList.add(localDeviceInfo);
        }
      }
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  protected void b(Intent paramIntent)
  {
    paramIntent.putExtra("dataline_forward_type", 100);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null)
    {
      String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_filepath");
      String str1 = str2;
      if (str2 == null) {
        str1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
      }
      paramIntent.putExtra("dataline_forward_path", str1);
      return;
    }
    paramIntent.putExtra("dataline_forward_path", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a());
  }
  
  protected boolean c()
  {
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false);
    int k = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    Intent localIntent;
    if (k == 1008)
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
      localIntent.putExtra("chat_subType", PublicAccountManager.a(str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "fileoption realForwardTo isfromshare=" + bool);
      }
      if (!bool) {
        break label244;
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", "消息");
      localIntent.addFlags(268435456);
      localIntent.addFlags(67108864);
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      bool = a(localIntent);
      if (!this.jdField_f_of_type_Boolean) {
        break label219;
      }
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    }
    for (;;)
    {
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return false;
      localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
      break;
      label219:
      if (!bool)
      {
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
        continue;
        label244:
        if (!this.e)
        {
          localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
        }
      }
    }
  }
  
  protected int d()
  {
    int k;
    if (jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
    {
      if (!new QfavBuilder(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, jdField_a_of_type_ComTencentMobileqqDataChatMessage, true)) {
        break label131;
      }
      jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
      k = 0;
    }
    for (;;)
    {
      if (k == 0) {
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", -1, 0, 69, 0, "", "");
      }
      return k;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null)
      {
        FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b());
        if ((localFileManagerEntity != null) && (new QfavBuilder(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, null, true)))
        {
          jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
          k = 0;
          continue;
        }
      }
      label131:
      k = -1;
    }
  }
  
  protected String d()
  {
    return this.jdField_a_of_type_AndroidContentContext.getString(2131436286);
  }
  
  protected void u()
  {
    String str1 = e();
    String str2;
    int k;
    Object localObject;
    if (!TextUtils.isEmpty(str1))
    {
      str2 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      k = FileManagerUtil.a(str1);
      if (k != 2) {
        break label92;
      }
      localObject = DeviceMsgHandle.b;
    }
    for (;;)
    {
      DeviceMsgHandle localDeviceMsgHandle = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(str1);
      localDeviceMsgHandle.a().a((String)localObject, str2, localArrayList, null);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
      label92:
      localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      if ((localObject != null) && (((SmartDeviceProxyMgr)localObject).a(Long.parseLong(this.jdField_a_of_type_AndroidOsBundle.getString("uin")), 17)))
      {
        ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(str2), "", "", "", 0, null);
        if (k == 0)
        {
          super.a(str1, str2, "pic");
          return;
        }
        super.a(str1, str2, "file");
        return;
      }
      if (k == 0) {
        localObject = DeviceMsgHandle.d;
      } else {
        localObject = DeviceMsgHandle.b;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardFileOption
 * JD-Core Version:    0.7.0.1
 */