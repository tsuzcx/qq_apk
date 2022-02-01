package com.tencent.mobileqq.utils.fts;

import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.WVPreloadPskeyConfBean;
import com.tencent.mobileqq.fts.interfaces.IFTSConfig;
import com.tencent.mobileqq.search.util.SearchConfigUtils;

final class SQLiteFTSUtils$2
  implements IFTSConfig
{
  public int a()
  {
    WVPreloadPskeyConfBean localWVPreloadPskeyConfBean = (WVPreloadPskeyConfBean)QConfigManager.b().b(585);
    if (localWVPreloadPskeyConfBean != null) {
      return localWVPreloadPskeyConfBean.b;
    }
    return 0;
  }
  
  public boolean b()
  {
    return SearchConfigUtils.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.2
 * JD-Core Version:    0.7.0.1
 */