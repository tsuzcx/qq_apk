package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class RichTitleConfProcessor
  extends IQConfigProcessor<RichTitleConfProcessor.RichTitleConfBean>
{
  public static RichTitleConfProcessor.RichTitleConfBean a()
  {
    return (RichTitleConfProcessor.RichTitleConfBean)QConfigManager.a().a(564);
  }
  
  @NonNull
  public RichTitleConfProcessor.RichTitleConfBean a(int paramInt)
  {
    return new RichTitleConfProcessor.RichTitleConfBean();
  }
  
  @Nullable
  public RichTitleConfProcessor.RichTitleConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length != 0))
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("RichTitleConfProcessor onParsed, content:");
        localStringBuilder.append(paramArrayOfQConfItem);
        QLog.d("RichTitleConfProcessor", 2, localStringBuilder.toString());
      }
      return RichTitleConfProcessor.RichTitleConfBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(RichTitleConfProcessor.RichTitleConfBean paramRichTitleConfBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichTitleConfProcessor", 2, "RichTitleConfProcessor update.");
    }
    if (paramRichTitleConfBean != null) {
      com.tencent.mobileqq.richstatus.AioFriendTitleHelper.a = (int)(paramRichTitleConfBean.a * 60.0D * 60.0D);
    }
  }
  
  public Class<RichTitleConfProcessor.RichTitleConfBean> clazz()
  {
    return RichTitleConfProcessor.RichTitleConfBean.class;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 564;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.RichTitleConfProcessor
 * JD-Core Version:    0.7.0.1
 */