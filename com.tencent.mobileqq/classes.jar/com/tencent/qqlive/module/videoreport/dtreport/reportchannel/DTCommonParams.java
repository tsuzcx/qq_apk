package com.tencent.qqlive.module.videoreport.dtreport.reportchannel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import java.util.HashMap;
import java.util.Map;

class DTCommonParams
{
  @NonNull
  static Map<String, String> getCommParams(@NonNull IDTParamProvider paramIDTParamProvider)
  {
    HashMap localHashMap = new HashMap();
    put(localHashMap, "dt_qq", paramIDTParamProvider.getQQ());
    put(localHashMap, "dt_qqopenid", paramIDTParamProvider.getQQOpenID());
    put(localHashMap, "dt_wxopenid", paramIDTParamProvider.getWxOpenID());
    put(localHashMap, "dt_wxuionid", paramIDTParamProvider.getWxUnionID());
    put(localHashMap, "dt_wbopenid", paramIDTParamProvider.getWbOpenID());
    put(localHashMap, "dt_mainlogin", paramIDTParamProvider.getMainLogin());
    put(localHashMap, "dt_starttype", String.valueOf(paramIDTParamProvider.getStartType()));
    put(localHashMap, "dt_callfrom", paramIDTParamProvider.getCallFrom());
    put(localHashMap, "dt_callschema", paramIDTParamProvider.getCallScheme());
    put(localHashMap, "dt_omgbzid", paramIDTParamProvider.getOmgbzid());
    put(localHashMap, "dt_fchlid", paramIDTParamProvider.getFactoryChannelId());
    put(localHashMap, "dt_mchlid", paramIDTParamProvider.getModifyChannelId());
    put(localHashMap, "dt_simtype", paramIDTParamProvider.getSIMType());
    put(localHashMap, "dt_adcode", paramIDTParamProvider.getAdCode());
    put(localHashMap, "dt_tid", paramIDTParamProvider.getTid());
    put(localHashMap, "dt_oaid", paramIDTParamProvider.getOaid());
    put(localHashMap, "dt_guid", paramIDTParamProvider.getGuid());
    put(localHashMap, "dt_sdkversion", String.valueOf(1540));
    return localHashMap;
  }
  
  private static void put(@NonNull Map<String, String> paramMap, @NonNull String paramString1, @Nullable String paramString2)
  {
    paramMap.put(paramString1, BaseUtils.nullAs(paramString2, ""));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTCommonParams
 * JD-Core Version:    0.7.0.1
 */