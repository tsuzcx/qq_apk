package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class FileOperaterUtils
{
  public static Intent a(Intent paramIntent)
  {
    return AIOUtils.a(paramIntent, null);
  }
  
  public static View.OnClickListener a(Activity paramActivity, Bundle paramBundle, FileManagerEntity paramFileManagerEntity)
  {
    return new FileOperaterUtils.11(paramActivity, paramBundle, paramFileManagerEntity);
  }
  
  public static View.OnClickListener a(Activity paramActivity, FileManagerEntity paramFileManagerEntity, String paramString)
  {
    return new FileOperaterUtils.12(paramActivity, paramFileManagerEntity, paramString);
  }
  
  public static View.OnClickListener a(Activity paramActivity, String paramString)
  {
    return new FileOperaterUtils.7(paramActivity, paramString);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return a(paramFileManagerEntity, paramActivity, false);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity, boolean paramBoolean)
  {
    return new FileOperaterUtils.10(paramFileManagerEntity, paramActivity, paramBoolean);
  }
  
  public static View.OnClickListener a(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity)
  {
    return new FileOperaterUtils.2(paramFileManagerEntity, paramIFileBrowser);
  }
  
  public static View.OnClickListener a(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return new FileOperaterUtils.3(paramFileManagerEntity, paramActivity, paramIFileBrowser);
  }
  
  public static View.OnClickListener a(IFileBrowser paramIFileBrowser, String paramString)
  {
    return new FileOperaterUtils.1(paramString, paramIFileBrowser);
  }
  
  public static QQMessageFacade a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getMessageFacade();
  }
  
  public static QQAppInterface a()
  {
    return (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
  }
  
  public static MessageRecord a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    MessageRecord localMessageRecord2 = null;
    QQAppInterface localQQAppInterface = a();
    if (paramLong != 0L) {
      localMessageRecord2 = a(localQQAppInterface).b(paramString1, paramInt, paramLong);
    }
    MessageRecord localMessageRecord1 = localMessageRecord2;
    String str = paramString2;
    if (localMessageRecord2 == null)
    {
      localMessageRecord1 = localMessageRecord2;
      str = paramString2;
      if (paramString2 != null)
      {
        if (paramInt != 1) {
          break label203;
        }
        localMessageRecord2 = a(a(localQQAppInterface), paramString1, paramInt, paramString2);
        localMessageRecord1 = localMessageRecord2;
        str = paramString2;
        if (localMessageRecord2 == null)
        {
          if (!paramString2.contains("/")) {
            break label178;
          }
          paramString2 = paramString2.substring(1);
          localMessageRecord1 = a(a(localQQAppInterface), paramString1, paramInt, paramString2);
        }
      }
    }
    for (str = paramString2;; str = paramString2)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("FileOperaterUtils", 2, "8.4.10-FileLocation --- [strFilePath]= " + str + " [uniseq]= " + paramLong);
        if (localMessageRecord1 != null) {
          break label221;
        }
        QLog.d("FileOperaterUtils", 2, "8.4.10-FileLocation --- MessageRecord is Null");
      }
      return localMessageRecord1;
      label178:
      paramString2 = "/" + paramString2;
      break;
      label203:
      localMessageRecord1 = a(localQQAppInterface, paramString1, paramInt, paramString2);
    }
    label221:
    QLog.d("FileOperaterUtils", 2, "8.4.10-FileLocation --- MessageRecord 【msg】" + localMessageRecord1.msg + "；【shmsgseq】" + localMessageRecord1.shmsgseq + "； [time] = " + localMessageRecord1.time);
    return localMessageRecord1;
  }
  
  public static MessageRecord a(QQMessageFacade paramQQMessageFacade, String paramString1, int paramInt, String paramString2)
  {
    if ((paramString2 == null) || (paramString1 == null) || (paramString1.length() == 0)) {
      return null;
    }
    paramQQMessageFacade = paramQQMessageFacade.b(paramString1, paramInt);
    if (paramQQMessageFacade == null) {
      return null;
    }
    paramQQMessageFacade = paramQQMessageFacade.iterator();
    while (paramQQMessageFacade.hasNext())
    {
      paramString1 = (MessageRecord)paramQQMessageFacade.next();
      if (((paramString1 instanceof MessageForTroopFile)) && (paramString2.equals(((MessageForTroopFile)paramString1).url))) {
        return paramString1;
      }
    }
    return null;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    paramQQAppInterface = a(paramQQAppInterface).b(paramString1, paramInt);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.iterator();
      while (paramQQAppInterface.hasNext())
      {
        paramString1 = (MessageRecord)paramQQAppInterface.next();
        if ((!TextUtils.isEmpty(paramString1.msg)) && (paramString1.msg.contains("|")) && (paramString2.equals(paramString1.msg.substring(0, paramString1.msg.indexOf("|")).trim()))) {
          return paramString1;
        }
      }
    }
    return null;
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, FileManagerEntity paramFileManagerEntity)
  {
    String str = paramFileManagerEntity.peerUin;
    int i;
    int j;
    if (paramFileManagerEntity.TroopUin != 0L)
    {
      i = 1;
      if (i == 0) {
        break label81;
      }
      j = 1;
      label24:
      if (j != 1) {
        break label87;
      }
    }
    label81:
    label87:
    for (Object localObject = paramFileManagerEntity.strTroopFilePath;; localObject = paramFileManagerEntity.strFilePath)
    {
      if ((paramFileManagerEntity.uniseq != -1L) || (paramFileManagerEntity.fileName != null) || (paramFileManagerEntity.fileSize != 0L)) {
        break label96;
      }
      QQToast.a(paramActivity, 1, 2131698208, 0).a();
      return;
      i = 0;
      break;
      j = 0;
      break label24;
    }
    label96:
    MessageRecord localMessageRecord = a(paramFileManagerEntity.uniseq, str, j, (String)localObject);
    if (localMessageRecord == null)
    {
      if (localObject == null)
      {
        QQToast.a(paramActivity, 1, 2131698208, 0).a();
        return;
      }
      QQToast.a(paramActivity, 1, 2131698207, 0).a();
      return;
    }
    int k = paramBundle.getInt("file_location_pos_entrance_type", 0);
    ReportController.b(null, "dc00898", "", "", "0X800B451", "0X800B451", k, 0, "", "", "", "");
    if (k == 3)
    {
      ChatHistoryActivity.a(paramActivity, str, j, "", localMessageRecord.time, localMessageRecord.shmsgseq, 0);
      return;
    }
    paramBundle.putBoolean("need_jump_to_msg", true);
    long l = localMessageRecord.shmsgseq;
    if (k == 1) {
      l = localMessageRecord.time;
    }
    paramBundle.putLong("searched_timeorseq", l);
    paramBundle.putLong("searched_time", localMessageRecord.time);
    paramBundle.putLong("target_shmsgseq", localMessageRecord.shmsgseq);
    paramBundle.putBoolean("searched_update_session", true);
    paramBundle.putBoolean("jump_from_shmsgseq", true);
    localObject = new Intent();
    if ((k == 1) || (k == 4))
    {
      if (i != 0) {}
      for (paramFileManagerEntity = String.valueOf(paramFileManagerEntity.TroopUin);; paramFileManagerEntity = str)
      {
        ((Intent)localObject).setClass(paramActivity, SplashActivity.class);
        localObject = a((Intent)localObject);
        ((Intent)localObject).putExtras(paramBundle);
        ((Intent)localObject).putExtra("uin", str);
        ((Intent)localObject).putExtra("uintype", j);
        ((Intent)localObject).putExtra("troop_uin", paramFileManagerEntity);
        ((Intent)localObject).putExtra("file_location_pos_chatpie_sign", 0);
        ((Intent)localObject).addFlags(603979776);
        ((Intent)localObject).putExtra("entrance", 1);
        paramActivity.startActivity((Intent)localObject);
        return;
      }
    }
    ((Intent)localObject).setClass(paramActivity, ChatHistoryActivity.class);
    ((Intent)localObject).putExtras(paramBundle);
    paramActivity.setResult(-1, (Intent)localObject);
    paramActivity.finish();
  }
  
  public static View.OnClickListener b(Activity paramActivity, FileManagerEntity paramFileManagerEntity, String paramString)
  {
    return new FileOperaterUtils.13(paramActivity, paramFileManagerEntity, paramString);
  }
  
  public static View.OnClickListener b(Activity paramActivity, String paramString)
  {
    return new FileOperaterUtils.14(paramActivity, paramString);
  }
  
  public static View.OnClickListener b(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity)
  {
    return new FileOperaterUtils.4(paramFileManagerEntity, paramIFileBrowser);
  }
  
  public static View.OnClickListener b(IFileBrowser paramIFileBrowser, String paramString)
  {
    return new FileOperaterUtils.6(paramString, paramIFileBrowser);
  }
  
  public static View.OnClickListener c(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity)
  {
    return new FileOperaterUtils.5(paramFileManagerEntity, paramIFileBrowser);
  }
  
  public static View.OnClickListener d(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity)
  {
    return new FileOperaterUtils.8(paramIFileBrowser, paramFileManagerEntity);
  }
  
  public static View.OnClickListener e(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity)
  {
    return new FileOperaterUtils.9(paramIFileBrowser, paramFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils
 * JD-Core Version:    0.7.0.1
 */