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
import com.tencent.mobileqq.filemanager.api.util.QStorage;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.qphone.base.util.QLog;

public class QfileFileAssistantTipsConfigProcessor
  extends IQConfigProcessor<QfileFileAssistantTipsConfigBean>
{
  final String a = "QfileFileAssistantTipsConfigProcessor<FileAssistant>";
  
  @NonNull
  public QfileFileAssistantTipsConfigBean a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent: type[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, localStringBuilder.toString());
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
    if (paramQfileFileAssistantTipsConfigBean == null)
    {
      QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "onUpdate: newConf is null.");
      return;
    }
    QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "QfileFileAssistantTipsConfigProcessor onUpdate");
    BaseQQAppInterface localBaseQQAppInterface = QQFileManagerUtilImpl.a();
    if (localBaseQQAppInterface == null)
    {
      QLog.e("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "app is null!!!");
      return;
    }
    if (paramQfileFileAssistantTipsConfigBean != null)
    {
      if (TextUtils.isEmpty(paramQfileFileAssistantTipsConfigBean.a)) {
        paramQfileFileAssistantTipsConfigBean.a = "{}";
      }
      Object localObject = localBaseQQAppInterface.getApplicationContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qfile_file_assistant_tips");
      localStringBuilder.append(localBaseQQAppInterface.getCurrentUin());
      localObject = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
      ((SharedPreferences.Editor)localObject).putString("qfile_file_assistant_tips", paramQfileFileAssistantTipsConfigBean.a);
      ((SharedPreferences.Editor)localObject).apply();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("save FileAssistantTips config [");
      ((StringBuilder)localObject).append(paramQfileFileAssistantTipsConfigBean.a);
      ((StringBuilder)localObject).append("]");
      QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      QFileConfigManager.a(localBaseQQAppInterface).a(paramQfileFileAssistantTipsConfigBean);
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReqFailed: failCode[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 606;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QfileFileAssistantTipsConfigProcessor
 * JD-Core Version:    0.7.0.1
 */