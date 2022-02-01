package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;

public class QVipSimpleThemeProocessor
  extends BaseQVipConfigProcessor<QVipSimpleThemeConfig>
{
  @NonNull
  public QVipSimpleThemeConfig a()
  {
    return new QVipSimpleThemeConfig();
  }
  
  @NonNull
  public QVipSimpleThemeConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    return QVipSimpleThemeConfig.a(paramArrayOfQConfItem[0].b);
  }
  
  @NonNull
  public QVipSimpleThemeConfig b()
  {
    return new QVipSimpleThemeConfig();
  }
  
  public Class<QVipSimpleThemeConfig> clazz()
  {
    return QVipSimpleThemeConfig.class;
  }
  
  public int type()
  {
    return 662;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipSimpleThemeProocessor
 * JD-Core Version:    0.7.0.1
 */