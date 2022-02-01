package com.tencent.mobileqq.filemanager.fileviewer.open;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileInfo.FileStatus;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.QLog;

public class TroopFileBrowserParams
  extends BaseFileBrowserParams
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopFileStatusInfo jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo;
  private String jdField_a_of_type_JavaLangString;
  private long b;
  
  public TroopFileBrowserParams(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, TroopFileStatusInfo paramTroopFileStatusInfo, int paramInt)
  {
    super(paramQQAppInterface, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo = paramTroopFileStatusInfo;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo;
    if (localObject == null) {
      return;
    }
    if ((!TextUtils.isEmpty(((TroopFileStatusInfo)localObject).g)) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.g.endsWith(".mp4")))
    {
      localObject = this.jdField_a_of_type_AndroidContentContext;
      if ((localObject != null) && ((localObject instanceof SplashActivity))) {
        localObject = "1";
      } else {
        localObject = "3";
      }
      ShortVideoUtils.reportVideoPlay(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(this.jdField_a_of_type_Long), String.valueOf(0), 1, "3", (String)localObject);
    }
  }
  
  protected int a()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo;
    if ((localTroopFileStatusInfo != null) && ((localTroopFileStatusInfo.jdField_b_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int == 8) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int == 0))) {
      return 2;
    }
    return -1;
  }
  
  protected long a()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo;
    if (localTroopFileStatusInfo != null) {
      return localTroopFileStatusInfo.jdField_c_of_type_Long;
    }
    return 0L;
  }
  
  public Intent a()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = a();
    if (localTroopFileStatusInfo == null) {
      return null;
    }
    return a(localTroopFileStatusInfo);
  }
  
  public Intent a(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    Object localObject = FileManagerUtil.a(paramTroopFileStatusInfo);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      ((FileManagerEntity)localObject).selfUin = this.jdField_a_of_type_JavaLangString;
    }
    long l = this.jdField_b_of_type_Long;
    if (l != 0L) {
      ((FileManagerEntity)localObject).lastTime = l;
    }
    ((FileManagerEntity)localObject).bSend = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equals(((FileManagerEntity)localObject).selfUin);
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(((FileManagerEntity)localObject).nSessionId);
    localForwardFileInfo.d(4);
    localForwardFileInfo.b(10006);
    localForwardFileInfo.a(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString);
    localForwardFileInfo.d(paramTroopFileStatusInfo.g);
    localForwardFileInfo.d(paramTroopFileStatusInfo.jdField_c_of_type_Long);
    localForwardFileInfo.a(this.jdField_a_of_type_Long);
    localForwardFileInfo.c(paramTroopFileStatusInfo.jdField_a_of_type_Long);
    paramTroopFileStatusInfo = new Intent();
    if (this.jdField_a_of_type_Int == 1)
    {
      localObject = TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_i_of_type_JavaLangString);
      if (localObject != null) {
        paramTroopFileStatusInfo.putExtra("leftViewText", ((TroopFileInfo)localObject).jdField_c_of_type_JavaLangString);
      }
    }
    paramTroopFileStatusInfo.putExtra("fileinfo", localForwardFileInfo);
    paramTroopFileStatusInfo.putExtra("removemementity", true);
    paramTroopFileStatusInfo.putExtra("forward_from_troop_file", true);
    paramTroopFileStatusInfo.putExtra("not_forward", true);
    paramTroopFileStatusInfo.putExtra("file_browser_extra_params_uin", String.valueOf(this.jdField_a_of_type_Long));
    l = this.jdField_b_of_type_Long;
    if (l != 0L) {
      paramTroopFileStatusInfo.putExtra("last_time", l);
    }
    paramTroopFileStatusInfo.putExtra("from_type_troop", this.jdField_a_of_type_Int);
    a();
    return paramTroopFileStatusInfo;
  }
  
  public FileManagerEntity a()
  {
    Object localObject = a();
    if (localObject == null) {
      return null;
    }
    localObject = FileManagerUtil.a((TroopFileStatusInfo)localObject);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      ((FileManagerEntity)localObject).selfUin = this.jdField_a_of_type_JavaLangString;
    }
    long l = this.jdField_b_of_type_Long;
    if (l != 0L) {
      ((FileManagerEntity)localObject).lastTime = l;
    }
    ((FileManagerEntity)localObject).bSend = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equals(((FileManagerEntity)localObject).selfUin);
    return localObject;
  }
  
  TroopFileStatusInfo a()
  {
    boolean bool = FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaLangString);
    String str = "";
    if (!bool)
    {
      TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).b();
      int i = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int;
      if ((i == 2) || (i == 3))
      {
        i = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaLangString.lastIndexOf("/") + 1;
        if (i < this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaLangString.length()) {
          str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaLangString.substring(i, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaLangString.length() - 1);
        }
        str = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131697315), new Object[] { TroopFileUtils.a(str) });
        TroopFileError.a(this.jdField_a_of_type_AndroidContentContext, str);
        return null;
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.g)) {
      str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.g;
    }
    TroopFileStatusInfo localTroopFileStatusInfo = new TroopFileStatusInfo();
    localTroopFileStatusInfo.g = str;
    localTroopFileStatusInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaLangString;
    localTroopFileStatusInfo.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_c_of_type_Long;
    localTroopFileStatusInfo.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_d_of_type_Long;
    localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID;
    localTroopFileStatusInfo.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_Long;
    localTroopFileStatusInfo.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
    localTroopFileStatusInfo.h = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.h;
    localTroopFileStatusInfo.e = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.e;
    localTroopFileStatusInfo.f = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.f;
    localTroopFileStatusInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_JavaLangString;
    localTroopFileStatusInfo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_c_of_type_JavaLangString;
    localTroopFileStatusInfo.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_d_of_type_JavaLangString;
    localTroopFileStatusInfo.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int;
    localTroopFileStatusInfo.k = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.k;
    localTroopFileStatusInfo.l = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.l;
    localTroopFileStatusInfo.m = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.m;
    localTroopFileStatusInfo.jdField_i_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_i_of_type_Int;
    localTroopFileStatusInfo.n = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.n;
    localTroopFileStatusInfo.o = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.o;
    TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
    return localTroopFileStatusInfo;
  }
  
  protected String a()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo;
    if ((localTroopFileStatusInfo != null) && (!TextUtils.isEmpty(localTroopFileStatusInfo.g))) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.g;
    }
    return "";
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected String b()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo;
    if (localTroopFileStatusInfo != null) {
      return localTroopFileStatusInfo.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public void b(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      paramBundle.putLong("troopfile_shmsgseq", this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.shmsgseq);
      paramBundle.putBoolean("is_multi_aio_msg", this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isMultiMsg);
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("FromChatHistoryTab")) {
        paramBundle.putInt("FromChatHistoryTab", this.jdField_a_of_type_AndroidOsBundle.getInt("FromChatHistoryTab", 0));
      }
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("file_location_pos_entrance_multiseq")) {
        paramBundle.putBoolean("file_location_pos_entrance_multiseq", this.jdField_a_of_type_AndroidOsBundle.getBoolean("file_location_pos_entrance_multiseq", false));
      }
    }
  }
  
  public boolean b()
  {
    return super.b();
  }
  
  boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int != 10) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int != 9)) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("id:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
      localStringBuilder.append(" status:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int);
      localStringBuilder.append(" resume");
      QLog.i("FileVideo", 1, localStringBuilder.toString());
    }
    TroopFileTransferManager.a(this.jdField_a_of_type_Long).c(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
    return true;
  }
  
  boolean d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileVideo", 1, "mTroopFileInfo is null, return false,(check why is here!)");
      }
      return false;
    }
    int i = FileManagerUtil.a(a());
    StringBuilder localStringBuilder;
    if (i != 2)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("id:");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
        localStringBuilder.append(" type is:");
        localStringBuilder.append(i);
        localStringBuilder.append(" use old filebrowser:");
        QLog.i("FileVideo", 1, localStringBuilder.toString());
      }
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int == 12)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("id:");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
        localStringBuilder.append(" is deleted, return false,(check why is here!)");
        QLog.w("FileVideo", 1, localStringBuilder.toString());
      }
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int != 4) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int != 5))
    {
      if (TroopFileInfo.FileStatus.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int))
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("id:");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
          localStringBuilder.append(" status:");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int);
          localStringBuilder.append(" use old browser!");
          QLog.i("FileVideo", 1, localStringBuilder.toString());
        }
        return false;
      }
      if ((!FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) && (!QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileVideo", 1, "use new filevideo browser switch is off!");
        }
        return false;
      }
      return true;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("id:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
      localStringBuilder.append(" is forwarding, return false,(check why is here!)");
      QLog.w("FileVideo", 1, localStringBuilder.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.open.TroopFileBrowserParams
 * JD-Core Version:    0.7.0.1
 */