package com.tencent.mobileqq.colornote.data;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class ColorNoteConfigProcessor
  extends IQConfigProcessor<ColorNoteConfBean>
{
  public static ColorNoteConfBean a()
  {
    return (ColorNoteConfBean)QConfigManager.a().a(549);
  }
  
  public ColorNoteConfBean a(int paramInt)
  {
    return new ColorNoteConfBean();
  }
  
  public ColorNoteConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      ColorNoteConfBean localColorNoteConfBean = ColorNoteConfBean.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].a);
        QLog.d("ColorNoteConfigProcessor", 2, localStringBuilder.toString());
      }
      return localColorNoteConfBean;
    }
    return null;
  }
  
  public void a(ColorNoteConfBean paramColorNoteConfBean) {}
  
  public Class clazz()
  {
    return ColorNoteConfBean.class;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed ");
      localStringBuilder.append(paramInt);
      QLog.d("ColorNoteConfigProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 549;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.data.ColorNoteConfigProcessor
 * JD-Core Version:    0.7.0.1
 */