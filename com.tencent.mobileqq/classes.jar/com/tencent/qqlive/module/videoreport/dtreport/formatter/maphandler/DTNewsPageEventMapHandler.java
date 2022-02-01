package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DTNewsPageEventMapHandler
  extends DTPageEventMapHandler
{
  private DTNewsPageParamsFlattenHelper mFlattenHelper = new DTNewsPageParamsFlattenHelper();
  
  private void flatten(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    if ((paramMap1 == null) || (paramMap2 == null)) {}
    Object localObject4;
    do
    {
      return;
      Map localMap1 = this.mFlattenHelper.removeMapParams(paramMap2, "ref_pg");
      Object localObject1 = this.mFlattenHelper.remove(paramMap2, "pg_path");
      Object localObject2 = this.mFlattenHelper.remove(localMap1, "pg_path");
      Object localObject3 = this.mFlattenHelper.remove(paramMap2, "dt_is_interactive_flag");
      localObject4 = this.mFlattenHelper.remove(paramMap2, "dt_pg_isreturn");
      Map localMap2 = getCurPagePrivateParams(paramMap2);
      this.mFlattenHelper.putAllPageParams(paramMap2, localMap2, "pg_");
      this.mFlattenHelper.putAllPageParams(paramMap2, localMap1, "refpg_");
      paramMap1.put("dt_pg_path", localObject1);
      paramMap1.put("dt_refpg_path", localObject2);
      if ("pgout".equals(paramString))
      {
        paramMap1.put("dt_is_interactive_flag", localObject3);
        return;
      }
    } while (!"pgin".equals(paramString));
    paramMap1.put("dt_pg_isreturn", localObject4);
  }
  
  private Map<String, Object> getCurPagePrivateParams(Map<String, Object> paramMap)
  {
    ArrayMap localArrayMap = new ArrayMap();
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        String str = (String)localEntry.getKey();
        paramMap.remove();
        localArrayMap.put(str, localEntry.getValue());
      }
    }
    return localArrayMap;
  }
  
  public void formatCustomParams(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    super.formatCustomParams(paramString, paramMap1, paramMap2);
    flatten(paramString, paramMap1, paramMap2);
  }
  
  Object getOrRemove(@NonNull Map<?, ?> paramMap, String paramString)
  {
    return this.mFlattenHelper.getOrRemove(paramMap, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTNewsPageEventMapHandler
 * JD-Core Version:    0.7.0.1
 */