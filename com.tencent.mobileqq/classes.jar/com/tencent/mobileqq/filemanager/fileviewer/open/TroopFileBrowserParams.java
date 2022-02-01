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
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo == null) {}
    while ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.g)) || (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.g.endsWith(".mp4"))) {
      return;
    }
    String str2 = "3";
    String str1 = str2;
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      str1 = str2;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)) {
        str1 = "1";
      }
    }
    ShortVideoUtils.reportVideoPlay(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(this.jdField_a_of_type_Long), String.valueOf(0), 1, "3", str1);
  }
  
  protected int a()
  {
    int j = -1;
    int i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo != null) {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int != 8))
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int != 0) {}
      }
      else
      {
        i = 2;
      }
    }
    return i;
  }
  
  protected long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_c_of_type_Long;
    }
    return 0L;
  }
  
  public Intent a()
  {
    if (!FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) {
      TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).b();
    }
    switch (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int)
    {
    default: 
      str = "";
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
      return a(localTroopFileStatusInfo);
    }
    String str = "";
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaLangString.lastIndexOf("/") + 1;
    if (i < this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaLangString.length()) {
      str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaLangString.substring(i, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaLangString.length() - 1);
    }
    str = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131697296), new Object[] { TroopFileUtils.a(str) });
    TroopFileError.a(this.jdField_a_of_type_AndroidContentContext, str);
    return null;
  }
  
  public Intent a(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    Object localObject = FileManagerUtil.a(paramTroopFileStatusInfo);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      ((FileManagerEntity)localObject).selfUin = this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_b_of_type_Long != 0L) {
      ((FileManagerEntity)localObject).lastTime = this.jdField_b_of_type_Long;
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
    if (this.jdField_b_of_type_Long != 0L) {
      paramTroopFileStatusInfo.putExtra("last_time", this.jdField_b_of_type_Long);
    }
    paramTroopFileStatusInfo.putExtra("from_type_troop", this.jdField_a_of_type_Int);
    a();
    return paramTroopFileStatusInfo;
  }
  
  protected String a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.g))) {
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
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaLangString;
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
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int == 10) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int == 9))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideo", 1, "id:" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID + " status:" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int + " resume");
      }
      TroopFileTransferManager.a(this.jdField_a_of_type_Long).c(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
      return true;
    }
    return false;
  }
  
  boolean d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.e("FileVideo", 1, "mTroopFileInfo is null, return false,(check why is here!)");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            int i;
            do
            {
              return false;
              i = FileManagerUtil.a(a());
              if (i == 2) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.i("FileVideo", 1, "id:" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID + " type is:" + i + " use old filebrowser:");
            return false;
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int != 12) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.w("FileVideo", 1, "id:" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID + " is deleted, return false,(check why is here!)");
          return false;
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int != 4) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int != 5)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("FileVideo", 1, "id:" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID + " is forwarding, return false,(check why is here!)");
        return false;
        if (!TroopFileInfo.FileStatus.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("FileVideo", 1, "id:" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID + " status:" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_b_of_type_Int + " use old browser!");
      return false;
      if ((FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) || (QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("FileVideo", 1, "use new filevideo browser switch is off!");
    return false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.open.TroopFileBrowserParams
 * JD-Core Version:    0.7.0.1
 */