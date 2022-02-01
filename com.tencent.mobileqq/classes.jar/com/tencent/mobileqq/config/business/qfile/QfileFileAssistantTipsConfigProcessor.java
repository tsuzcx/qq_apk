package com.tencent.mobileqq.config.business.qfile;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.api.util.QStorage;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class QfileFileAssistantTipsConfigProcessor
  extends IQConfigProcessor<QfileFileAssistantTipsConfigBean>
{
  final String a = "QfileFileAssistantTipsConfigProcessor<FileAssistant>";
  
  @NonNull
  public QfileFileAssistantTipsConfigBean a(int paramInt)
  {
    QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new QfileFileAssistantTipsConfigBean();
  }
  
  @Nullable
  public QfileFileAssistantTipsConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "onParsed");
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return (QfileFileAssistantTipsConfigBean)QStorage.a(paramArrayOfQConfItem[0].a, QfileFileAssistantTipsConfigBean.class);
    }
    return null;
  }
  
  public void a(QfileFileAssistantTipsConfigBean paramQfileFileAssistantTipsConfigBean)
  {
    if (paramQfileFileAssistantTipsConfigBean == null) {
      QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "onUpdate: newConf is null.");
    }
    do
    {
      return;
      QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "QfileFileAssistantTipsConfigProcessor onUpdate");
      localObject = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getApp();
      if (localObject == null)
      {
        QLog.e("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "app is null!!!");
        return;
      }
    } while (paramQfileFileAssistantTipsConfigBean == null);
    if (TextUtils.isEmpty(paramQfileFileAssistantTipsConfigBean.a)) {
      paramQfileFileAssistantTipsConfigBean.a = "{}";
    }
    Object localObject = ((BaseQQAppInterface)localObject).getApplicationContext().getSharedPreferences("qfile_file_assistant_tips" + ((BaseQQAppInterface)localObject).getCurrentUin(), 0).edit();
    ((SharedPreferences.Editor)localObject).putString("qfile_file_assistant_tips", paramQfileFileAssistantTipsConfigBean.a);
    ((SharedPreferences.Editor)localObject).apply();
    QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "save FileAssistantTips config [" + paramQfileFileAssistantTipsConfigBean.a + "]");
    QFileConfigManager.a().a(paramQfileFileAssistantTipsConfigBean);
  }
  
  public Class<QfileFileAssistantTipsConfigBean> clazz()
  {
    return QfileFileAssistantTipsConfigBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public int type()
  {
    return 606;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QfileFileAssistantTipsConfigProcessor
 * JD-Core Version:    0.7.0.1
 */