package com.tencent.mobileqq.filemanager.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import aoze;
import apue;
import apug;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

public final class FileManagerUtil$17
  implements Runnable
{
  public FileManagerUtil$17(String paramString1, QQAppInterface paramQQAppInterface, int paramInt, String paramString2) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    SharedPreferences localSharedPreferences;
    String str2;
    long l1;
    long l2;
    Object localObject1;
    int i;
    Object localObject2;
    int j;
    label262:
    MessageRecord localMessageRecord;
    do
    {
      for (;;)
      {
        return;
        try
        {
          Thread.sleep(500L);
          String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "BatProcessTips";
          localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(str1, 0);
          str2 = this.jdField_a_of_type_JavaLangString + "_" + this.jdField_a_of_type_Int + "_LastShowTime";
          l1 = localSharedPreferences.getLong(str2, 0L);
          l2 = System.currentTimeMillis();
          if (l2 - l1 < 86400000L)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("updateBatProcessTips<FileAssistant>", 4, "lastShowTime[" + l1 + "],today has notify user!return!");
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
          if ((localObject1 == null) || (((List)localObject1).size() == 0))
          {
            if (QLog.isColorLevel()) {
              QLog.i("updateBatProcessTips<FileAssistant>", 4, "lastShowTime[" + l1 + "],msgRecd null,return");
            }
          }
          else
          {
            i = 1;
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            j = ((List)localObject1).size() - 1;
          }
        }
      }
      if (j < 0) {
        break;
      }
      localMessageRecord = (MessageRecord)((List)localObject1).get(j);
    } while ((localMessageRecord.msgtype != -2005) || (localMessageRecord.isSend()) || (localMessageRecord.senderuin.equalsIgnoreCase((String)localObject2) == true));
    if (QLog.isDevelopLevel()) {
      QLog.d("FileManagerUtil<FileAssistant>", 4, "updateBatProcessTips count[" + i + "]");
    }
    if (i >= 4)
    {
      localObject1 = (MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1);
      switch (apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject1).nFileType)
      {
      case 1: 
      case 4: 
      case 5: 
      case 8: 
      default: 
        localObject1 = "3";
      }
      for (;;)
      {
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("bat_process_tips_last_file_type", localObject1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int, -3013, (Map)localObject2, BaseApplicationImpl.getContext().getString(2131692662), -1L, -1L, -1L);
        localSharedPreferences.edit().putLong(str2, l2);
        if (QLog.isColorLevel()) {
          QLog.i("updateBatProcessTips<FileAssistant>", 4, "lastShowTime[" + l1 + "],[" + apug.e(this.jdField_a_of_type_JavaLangString) + "]add new grayTips!");
        }
        apue.a("0X800506B");
        return;
        localObject1 = "0";
        continue;
        localObject1 = "1";
      }
    }
    long l3 = localMessageRecord.time * 1000L;
    if (QLog.isColorLevel()) {
      QLog.i("updateBatProcessTips<FileAssistant>", 4, "lastShowTime[" + l1 + "],time[" + l3 + "]");
    }
    if (l3 > l1) {
      i += 1;
    }
    for (;;)
    {
      j -= 1;
      break label262;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.17
 * JD-Core Version:    0.7.0.1
 */