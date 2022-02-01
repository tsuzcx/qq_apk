package com.tencent.mobileqq.vas.ipc.remote;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.URLUtil;
import bekc;
import bheh;
import bhey;
import bhoy;
import bhpu;
import bhzd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.mobilereport.MobileReportManager.ActionInfoBuilder;
import cooperation.qzone.mobilereport.MobileReportManager.ItemInfoBuilder;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import cooperation.vip.tianshu.TianShuAdPosItemData;
import cooperation.vip.tianshu.TianShuManager;
import cooperation.vip.tianshu.TianShuReportData;
import eipc.EIPCModule;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import uuc;

public class LiveDelivery
  implements ILiveDelivery
{
  private static final String TAG = "LiveDelivery";
  
  public void followUin(String paramString, EIPCModule paramEIPCModule, int paramInt, EIPCResultCallback paramEIPCResultCallback)
  {
    paramEIPCResultCallback = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    uuc.a(paramEIPCResultCallback, BaseApplicationImpl.getContext(), paramString, new LiveDelivery.3(this, paramEIPCModule, paramInt, paramEIPCResultCallback), false, 0, true);
  }
  
  public long getAccount()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
  }
  
  public bekc getAdsInfo(TianShuAccess.GetAdsRsp paramGetAdsRsp, int paramInt)
  {
    if (paramGetAdsRsp == null) {
      return null;
    }
    if (paramGetAdsRsp.mapAds.has()) {}
    for (paramGetAdsRsp = paramGetAdsRsp.mapAds.get(); paramGetAdsRsp == null; paramGetAdsRsp = null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramGetAdsRsp = paramGetAdsRsp.iterator();
    Object localObject1;
    while (paramGetAdsRsp.hasNext())
    {
      localObject1 = (TianShuAccess.RspEntry)paramGetAdsRsp.next();
      if ((localObject1 != null) && (((TianShuAccess.RspEntry)localObject1).key.has())) {
        localHashMap.put(Integer.valueOf(((TianShuAccess.RspEntry)localObject1).key.get()), localObject1);
      }
    }
    paramGetAdsRsp = (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(paramInt));
    if ((paramGetAdsRsp == null) || (paramGetAdsRsp.value == null) || (paramGetAdsRsp.value.lst.size() == 0) || (paramGetAdsRsp.value.lst.get(0) == null) || (((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0)).argList == null) || (((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0)).argList.get() == null)) {
      return null;
    }
    if (paramGetAdsRsp.value.lst.size() < 0)
    {
      localObject1 = ((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0)).argList.get();
      localHashMap = new HashMap();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (TianShuAccess.MapEntry)((Iterator)localObject1).next();
        String str = ((TianShuAccess.MapEntry)localObject2).key.get();
        localObject2 = ((TianShuAccess.MapEntry)localObject2).value.get();
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
          localHashMap.put(str, localObject2);
        }
      }
      localObject1 = new bekc();
      ((bekc)localObject1).jdField_a_of_type_JavaLangString = ((String)localHashMap.get("type"));
      ((bekc)localObject1).c = ((String)localHashMap.get("pic"));
      ((bekc)localObject1).b = ((String)localHashMap.get("url"));
      ((bekc)localObject1).jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem = ((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0));
      if (!TextUtils.isEmpty(((bekc)localObject1).c)) {}
    }
    else
    {
      return null;
    }
    return localObject1;
  }
  
  public boolean isFollowUin(String paramString)
  {
    return uuc.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString);
  }
  
  public boolean isWxInstall()
  {
    return WXShareHelper.a().a();
  }
  
  public void openChargePage()
  {
    QLog.e("LiveDelivery", 1, "openChargePage");
    bhoy.a(BaseApplicationImpl.getApplication(), "https://h5.qzone.qq.com/live/chargedialog?_wv=17301507&from=ugc&_proxy=1&aid=zhiboczban");
  }
  
  public void openQQBrowser(String paramString)
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  public void openSchema(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.d("LiveDelivery", 2, "openSchema empty");
    }
    do
    {
      return;
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (URLUtil.isNetworkUrl(paramString))
      {
        localObject = new Intent(BaseApplicationImpl.getApplication().getApplicationContext(), QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramString);
        ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_jc_vip");
        ((Intent)localObject).addFlags(268435456);
        BaseApplicationImpl.getApplication().getApplicationContext().startActivity((Intent)localObject);
        return;
      }
      paramString = bhey.a((QQAppInterface)localObject, BaseApplicationImpl.getApplication().getApplicationContext(), paramString);
      if (paramString != null)
      {
        paramString.a();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LiveDelivery", 2, "onEditorAction jumpUrl is illegal");
  }
  
  public void reportAction(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt1, int paramInt2)
  {
    paramString3 = new MobileReportManager.ItemInfoBuilder().setItemId(paramString3).setBusiInfo(paramString7).setModuleId(paramString4).setItemType(paramString8).addActionInfo(new MobileReportManager.ActionInfoBuilder(System.currentTimeMillis(), paramInt1, paramInt2).build()).build();
    MobileReportManager.getInstance().reportActionLive(paramString1, paramString2, paramString3);
  }
  
  public void reportStatistic(String paramString, HashMap<String, String> paramHashMap, long paramLong)
  {
    bhpu.a(paramString, paramHashMap, paramLong);
  }
  
  public void reportTianshu(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    TianShuReportData localTianShuReportData = new TianShuReportData();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localTianShuReportData.mTraceId = (str + "_" + l);
    localTianShuReportData.mTraceNum = paramInt2;
    localTianShuReportData.mAppId = paramString1;
    localTianShuReportData.mPageId = paramString2;
    localTianShuReportData.mItemId = paramString3;
    localTianShuReportData.mActionId = paramInt1;
    localTianShuReportData.mActionValue = 1;
    localTianShuReportData.mOperTime = l;
    TianShuManager.getInstance().report(localTianShuReportData);
  }
  
  public void reqPendantInfo(int paramInt1, int paramInt2, Serializable paramSerializable, EIPCModule paramEIPCModule, int paramInt3, EIPCResultCallback paramEIPCResultCallback)
  {
    paramEIPCResultCallback = new ArrayList();
    TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.mPosId = paramInt1;
    localTianShuAdPosItemData.mNeedCnt = paramInt2;
    localTianShuAdPosItemData.mExtraData = ((HashMap)paramSerializable);
    paramEIPCResultCallback.add(localTianShuAdPosItemData);
    TianShuManager.getInstance().requestAdv(paramEIPCResultCallback, new LiveDelivery.5(this, paramInt1, paramEIPCModule, paramInt3));
  }
  
  public void requestPbMsfSSO(String paramString1, String paramString2, EIPCModule paramEIPCModule, int paramInt, EIPCResultCallback paramEIPCResultCallback)
  {
    bhzd.a(paramString1, paramString2, new LiveDelivery.1(this, paramEIPCModule, paramInt));
  }
  
  public void requestPbVSBase(String paramString1, String paramString2, EIPCModule paramEIPCModule, int paramInt, EIPCResultCallback paramEIPCResultCallback)
  {
    try
    {
      bhzd.a(paramString1, bhzd.a(paramString2.getBytes("ISO8859_1")).toByteArray(), new LiveDelivery.2(this, paramEIPCModule, paramInt));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void setAnchorIsLive(boolean paramBoolean)
  {
    blvm.a = paramBoolean;
  }
  
  public void setAudienceIsLive(boolean paramBoolean)
  {
    blvm.b = paramBoolean;
  }
  
  public void unfollowUin(String paramString, EIPCModule paramEIPCModule, int paramInt, EIPCResultCallback paramEIPCResultCallback)
  {
    uuc.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), BaseApplicationImpl.getContext(), paramString, false, new LiveDelivery.4(this, paramEIPCModule, paramInt), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.remote.LiveDelivery
 * JD-Core Version:    0.7.0.1
 */