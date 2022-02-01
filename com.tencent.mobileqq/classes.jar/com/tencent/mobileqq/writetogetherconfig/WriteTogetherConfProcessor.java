package com.tencent.mobileqq.writetogetherconfig;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class WriteTogetherConfProcessor
  extends IQConfigProcessor<WriteTogetherConfBean>
{
  @NonNull
  public WriteTogetherConfBean a(int paramInt)
  {
    return new WriteTogetherConfBean();
  }
  
  @Nullable
  public WriteTogetherConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      WriteTogetherConfBean localWriteTogetherConfBean2 = WriteTogetherConfBean.a(paramArrayOfQConfItem[0].a);
      WriteTogetherConfBean localWriteTogetherConfBean1 = localWriteTogetherConfBean2;
      if (localWriteTogetherConfBean2 == null) {
        localWriteTogetherConfBean1 = new WriteTogetherConfBean();
      }
      if (QLog.isColorLevel()) {
        QLog.d("WriteTogetherConfProcessor", 2, "onParsed " + paramArrayOfQConfItem[0].a);
      }
      return localWriteTogetherConfBean1;
    }
    return new WriteTogetherConfBean();
  }
  
  public void a(WriteTogetherConfBean paramWriteTogetherConfBean) {}
  
  public Class<WriteTogetherConfBean> clazz()
  {
    return WriteTogetherConfBean.class;
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
    return 653;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherconfig.WriteTogetherConfProcessor
 * JD-Core Version:    0.7.0.1
 */