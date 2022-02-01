package com.tencent.mobileqq.pic.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.HashMap;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IPicPreDownload
  extends IRuntimeService
{
  public static final String KEY_ACC_FLOW_PRE_TOTAL = "accFlowPreTotal";
  public static final String KEY_WIFI_HIT_COUNT = "wifiHitCount";
  public static final String KEY_WIFI_MANUL_CLICK_COUNT = "wifiManualClickCount";
  public static final String KEY_WIFI_MISS_COUNT = "wifiMissCount";
  public static final String KEY_WIFI_PRE_DOWN_COUT = "wifiPreDownCount";
  public static final String KEY_XG_FLOW_PRE = "xgFlowPre";
  public static final String KEY_XG_FLOW_WASTE = "xgFlowWaste";
  public static final String KEY_XG_FLOW_WASTE_BALANCE = "xgFlowWasteBalance";
  public static final String KEY_XG_HIT_COUNT = "xgHitCount";
  public static final String KEY_XG_MANUL_CLICK_COUNT = "xgManualClickCount";
  public static final String KEY_XG_MISS_COUNT = "xgMissCount";
  public static final String KEY_XG_PRE_DOWN_COUNT = "xgPreDownCount";
  public static final int TYPE_ALL = 3;
  public static final int TYPE_BIG = 2;
  public static final int TYPE_THUMB = 1;
  
  public abstract int calcUinType(AppInterface paramAppInterface, int paramInt, String paramString);
  
  public abstract void clearAIORequests();
  
  public abstract void commitTrafficPref();
  
  public abstract IPicPreDownload.ConfigInfo getConfigs();
  
  public abstract HashMap<String, String> getDebugPreDownloadReportInfo();
  
  public abstract boolean getPreDownSwitch();
  
  public abstract void increaseTroopCountWhenEnterAIO(String paramString);
  
  public abstract boolean isScreenOn();
  
  public abstract void payPicFlow(MessageForPic paramMessageForPic);
  
  public abstract void productFromAIO(MessageForPic paramMessageForPic, int paramInt);
  
  public abstract void productFromAIODynamicPic(MessageForPic paramMessageForPic);
  
  public abstract void productFromMsg(MessageRecord paramMessageRecord, int paramInt);
  
  public abstract void switchOff();
  
  public abstract void switchOn();
  
  public abstract void updateConfigs(IPicPreDownload.ConfigInfo paramConfigInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.api.IPicPreDownload
 * JD-Core Version:    0.7.0.1
 */