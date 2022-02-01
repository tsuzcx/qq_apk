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
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils.GetTeamWorkImportInfoListener;
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
  
  public static View.OnClickListener a(long paramLong, IFileBrowser paramIFileBrowser, String paramString)
  {
    return new FileOperaterUtils.1(paramString, paramIFileBrowser, paramLong);
  }
  
  public static View.OnClickListener a(Activity paramActivity, Bundle paramBundle, FileManagerEntity paramFileManagerEntity)
  {
    return new FileOperaterUtils.10(paramActivity, paramBundle, paramFileManagerEntity);
  }
  
  public static View.OnClickListener a(Activity paramActivity, FileManagerEntity paramFileManagerEntity, String paramString)
  {
    return new FileOperaterUtils.11(paramActivity, paramFileManagerEntity, paramString);
  }
  
  public static View.OnClickListener a(Activity paramActivity, String paramString)
  {
    return new FileOperaterUtils.6(paramActivity, paramString);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return a(paramFileManagerEntity, paramActivity, false, null);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity, boolean paramBoolean, TeamWorkConvertUtils.GetTeamWorkImportInfoListener paramGetTeamWorkImportInfoListener)
  {
    return new FileOperaterUtils.9(paramFileManagerEntity, paramActivity, paramBoolean, paramGetTeamWorkImportInfoListener);
  }
  
  public static View.OnClickListener a(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity)
  {
    return new FileOperaterUtils.2(paramFileManagerEntity, paramIFileBrowser);
  }
  
  public static View.OnClickListener a(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return new FileOperaterUtils.3(paramFileManagerEntity, paramActivity);
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
    QQAppInterface localQQAppInterface = a();
    MessageRecord localMessageRecord;
    if (paramLong != 0L) {
      localMessageRecord = a(localQQAppInterface).b(paramString1, paramInt, paramLong);
    } else {
      localMessageRecord = null;
    }
    Object localObject = localMessageRecord;
    String str = paramString2;
    if (localMessageRecord == null)
    {
      localObject = localMessageRecord;
      str = paramString2;
      if (paramString2 != null) {
        if (paramInt == 1)
        {
          localObject = a(a(localQQAppInterface), paramString1, paramInt, paramString2);
          if (localObject == null)
          {
            if (paramString2.contains("/"))
            {
              paramString2 = paramString2.substring(1);
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("/");
              ((StringBuilder)localObject).append(paramString2);
              paramString2 = ((StringBuilder)localObject).toString();
            }
            localObject = a(a(localQQAppInterface), paramString1, paramInt, paramString2);
            str = paramString2;
          }
          else
          {
            str = paramString2;
          }
        }
        else
        {
          localObject = a(localQQAppInterface, paramString1, paramInt, paramString2);
          str = paramString2;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("8.4.10-FileLocation --- [strFilePath]= ");
      paramString1.append(str);
      paramString1.append(" [uniseq]= ");
      paramString1.append(paramLong);
      QLog.d("FileOperaterUtils", 2, paramString1.toString());
      if (localObject == null)
      {
        QLog.d("FileOperaterUtils", 2, "8.4.10-FileLocation --- MessageRecord is Null");
        return localObject;
      }
      paramString1 = new StringBuilder();
      paramString1.append("8.4.10-FileLocation --- ；【shmsgseq】");
      paramString1.append(((MessageRecord)localObject).shmsgseq);
      paramString1.append("； [time] = ");
      paramString1.append(((MessageRecord)localObject).time);
      QLog.d("FileOperaterUtils", 2, paramString1.toString());
    }
    return localObject;
  }
  
  public static MessageRecord a(QQMessageFacade paramQQMessageFacade, String paramString1, int paramInt, String paramString2)
  {
    if ((paramString2 != null) && (paramString1 != null))
    {
      if (paramString1.length() == 0) {
        return null;
      }
      paramQQMessageFacade = paramQQMessageFacade.h(paramString1, paramInt);
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
    }
    return null;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    paramQQAppInterface = a(paramQQAppInterface).h(paramString1, paramInt);
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
  
  public static View.OnClickListener b(long paramLong, IFileBrowser paramIFileBrowser, String paramString)
  {
    return new FileOperaterUtils.5(paramString, paramIFileBrowser, paramLong);
  }
  
  public static View.OnClickListener b(Activity paramActivity, FileManagerEntity paramFileManagerEntity, String paramString)
  {
    return new FileOperaterUtils.12(paramActivity, paramFileManagerEntity, paramString);
  }
  
  public static View.OnClickListener b(Activity paramActivity, String paramString)
  {
    return new FileOperaterUtils.13(paramActivity, paramString);
  }
  
  public static View.OnClickListener b(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity)
  {
    return new FileOperaterUtils.4(paramFileManagerEntity, paramIFileBrowser);
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, FileManagerEntity paramFileManagerEntity)
  {
    String str = paramFileManagerEntity.peerUin;
    int i;
    if (paramFileManagerEntity.TroopUin != 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 1) {
      localObject = paramFileManagerEntity.strTroopFilePath;
    } else {
      localObject = paramFileManagerEntity.strFilePath;
    }
    if ((paramFileManagerEntity.uniseq == -1L) && (paramFileManagerEntity.fileName == null) && (paramFileManagerEntity.fileSize == 0L))
    {
      QQToast.makeText(paramActivity, 1, 2131896173, 0).show();
      return;
    }
    MessageRecord localMessageRecord = a(paramFileManagerEntity.uniseq, str, i, (String)localObject);
    if (localMessageRecord == null)
    {
      if (localObject == null)
      {
        QQToast.makeText(paramActivity, 1, 2131896173, 0).show();
        return;
      }
      QQToast.makeText(paramActivity, 1, 2131896172, 0).show();
      return;
    }
    int j = paramBundle.getInt("file_location_pos_entrance_type", 0);
    ReportController.b(null, "dc00898", "", "", "0X800B451", "0X800B451", j, 0, "", "", "", "");
    if (j == 3)
    {
      ChatHistoryActivity.a(paramActivity, str, i, "", localMessageRecord.time, localMessageRecord.shmsgseq, 0);
      return;
    }
    paramBundle.putBoolean("need_jump_to_msg", true);
    long l = localMessageRecord.shmsgseq;
    if (j == 1) {
      l = localMessageRecord.time;
    }
    paramBundle.putLong("searched_timeorseq", l);
    paramBundle.putLong("searched_time", localMessageRecord.time);
    paramBundle.putLong("target_shmsgseq", localMessageRecord.shmsgseq);
    paramBundle.putBoolean("searched_update_session", true);
    paramBundle.putBoolean("jump_from_shmsgseq", true);
    Object localObject = new Intent();
    if ((j != 1) && (j != 4))
    {
      ((Intent)localObject).setClass(paramActivity, ChatHistoryActivity.class);
      ((Intent)localObject).putExtras(paramBundle);
      paramActivity.setResult(-1, (Intent)localObject);
      paramActivity.finish();
      return;
    }
    if (i != 0) {
      paramFileManagerEntity = String.valueOf(paramFileManagerEntity.TroopUin);
    } else {
      paramFileManagerEntity = str;
    }
    ((Intent)localObject).setClass(paramActivity, SplashActivity.class);
    localObject = a((Intent)localObject);
    ((Intent)localObject).putExtras(paramBundle);
    ((Intent)localObject).putExtra("uin", str);
    ((Intent)localObject).putExtra("uintype", i);
    ((Intent)localObject).putExtra("troop_uin", paramFileManagerEntity);
    ((Intent)localObject).putExtra("file_location_pos_chatpie_sign", 0);
    ((Intent)localObject).addFlags(603979776);
    ((Intent)localObject).putExtra("entrance", 1);
    paramActivity.startActivity((Intent)localObject);
  }
  
  public static View.OnClickListener c(Activity paramActivity, String paramString)
  {
    return new FileOperaterUtils.14(paramActivity, paramString);
  }
  
  public static View.OnClickListener c(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity)
  {
    return new FileOperaterUtils.7(paramIFileBrowser, paramFileManagerEntity);
  }
  
  public static View.OnClickListener d(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity)
  {
    return new FileOperaterUtils.8(paramFileManagerEntity, paramIFileBrowser);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils
 * JD-Core Version:    0.7.0.1
 */