package com.tencent.mobileqq.colornote;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
  
  @NonNull
  public ColorNoteConfBean a(int paramInt)
  {
    return new ColorNoteConfBean();
  }
  
  @Nullable
  public ColorNoteConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      ColorNoteConfBean localColorNoteConfBean = ColorNoteConfBean.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteConfigProcessor", 2, "onParsed " + paramArrayOfQConfItem[0].a);
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
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteConfigProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 549;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.ColorNoteConfigProcessor
 * JD-Core Version:    0.7.0.1
 */