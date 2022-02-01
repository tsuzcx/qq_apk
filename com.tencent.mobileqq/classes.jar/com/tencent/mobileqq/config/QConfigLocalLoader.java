package com.tencent.mobileqq.config;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.business.QConfLogBean;
import com.tencent.mobileqq.config.business.QConfLogProcessor;
import java.util.Iterator;
import java.util.Set;

public class QConfigLocalLoader
{
  private static SharedPreferences a(long paramLong, BaseApplicationImpl paramBaseApplicationImpl)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("conf_");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("_sharepref");
    return paramBaseApplicationImpl.getSystemSharedPreferences(localStringBuilder.toString(), 4);
  }
  
  public static QConfLogBean a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    QConfigJourney.a().a(419, 0L, false);
    QConfLogProcessor localQConfLogProcessor = new QConfLogProcessor();
    paramBaseApplicationImpl = a(419, paramBaseApplicationImpl);
    if (paramBaseApplicationImpl != null) {}
    try
    {
      paramBaseApplicationImpl = localQConfLogProcessor.a(paramBaseApplicationImpl);
      if (paramBaseApplicationImpl != null) {
        return paramBaseApplicationImpl;
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      label43:
      break label43;
    }
    return new QConfLogBean();
  }
  
  private static QConfItem[] a(int paramInt, BaseApplicationImpl paramBaseApplicationImpl)
  {
    Object localObject1 = a(0L, paramBaseApplicationImpl);
    paramBaseApplicationImpl = b(0L, paramBaseApplicationImpl);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append("_ids");
    localObject2 = ((SharedPreferences)localObject1).getStringSet(((StringBuilder)localObject2).toString(), null);
    if (localObject2 != null)
    {
      if (((Set)localObject2).isEmpty()) {
        return null;
      }
      localObject1 = new QConfItem[((Set)localObject2).size()];
      int i = 0;
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        int j = Integer.valueOf(str).intValue();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt);
        localStringBuilder.append("_");
        localStringBuilder.append(str);
        localObject1[i] = new QConfItem(j, paramBaseApplicationImpl.getString(localStringBuilder.toString(), null));
        i += 1;
      }
      return localObject1;
    }
    return null;
  }
  
  private static SharedPreferences b(long paramLong, BaseApplicationImpl paramBaseApplicationImpl)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("conf_");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("_content_sharepref");
    return paramBaseApplicationImpl.getSystemSharedPreferences(localStringBuilder.toString(), 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.QConfigLocalLoader
 * JD-Core Version:    0.7.0.1
 */