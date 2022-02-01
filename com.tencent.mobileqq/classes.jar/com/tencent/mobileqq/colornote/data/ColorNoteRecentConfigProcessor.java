package com.tencent.mobileqq.colornote.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;

public class ColorNoteRecentConfigProcessor
  extends IQConfigProcessor<ColorNoteRecentConfBean>
{
  public static ColorNoteRecentConfBean a()
  {
    return (ColorNoteRecentConfBean)QConfigManager.a().a(586);
  }
  
  @NonNull
  public ColorNoteRecentConfBean a(int paramInt)
  {
    return new ColorNoteRecentConfBean();
  }
  
  @Nullable
  public ColorNoteRecentConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return ColorNoteRecentConfBean.a(paramArrayOfQConfItem[0].a);
    }
    return null;
  }
  
  public void a(ColorNoteRecentConfBean paramColorNoteRecentConfBean) {}
  
  public Class<ColorNoteRecentConfBean> clazz()
  {
    return ColorNoteRecentConfBean.class;
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
    return 586;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.data.ColorNoteRecentConfigProcessor
 * JD-Core Version:    0.7.0.1
 */