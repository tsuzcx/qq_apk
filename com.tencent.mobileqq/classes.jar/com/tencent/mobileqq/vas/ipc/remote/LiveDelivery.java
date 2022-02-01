package com.tencent.mobileqq.vas.ipc.remote;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.together.TogetherControlManager.EntryBannerInfo;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.mobileqq.vip.PbProtocol;
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
import cooperation.vip.tianshu.TianShuManager;
import eipc.EIPCModule;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

public class LiveDelivery
  implements ILiveDelivery
{
  private static final String TAG = "LiveDelivery";
  
  @Nullable
  private TogetherControlManager.EntryBannerInfo getEntryBannerInfo(TianShuAccess.RspEntry paramRspEntry)
  {
    if (paramRspEntry.value.lst.size() > 0)
    {
      Object localObject1 = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(0)).argList.get();
      HashMap localHashMap = new HashMap();
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
      localObject1 = new TogetherControlManager.EntryBannerInfo();
      ((TogetherControlManager.EntryBannerInfo)localObject1).jdField_a_of_type_JavaLangString = ((String)localHashMap.get("type"));
      ((TogetherControlManager.EntryBannerInfo)localObject1).c = ((String)localHashMap.get("pic"));
      ((TogetherControlManager.EntryBannerInfo)localObject1).b = ((String)localHashMap.get("url"));
      ((TogetherControlManager.EntryBannerInfo)localObject1).jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem = ((TianShuAccess.AdItem)paramRspEntry.value.lst.get(0));
      if (!TextUtils.isEmpty(((TogetherControlManager.EntryBannerInfo)localObject1).c)) {
        return localObject1;
      }
    }
    return null;
  }
  
  private boolean isResEntrylst(TianShuAccess.RspEntry paramRspEntry)
  {
    return (paramRspEntry == null) || (paramRspEntry.value == null) || (paramRspEntry.value.lst.size() == 0) || (paramRspEntry.value.lst.get(0) == null) || (((TianShuAccess.AdItem)paramRspEntry.value.lst.get(0)).argList == null) || (((TianShuAccess.AdItem)paramRspEntry.value.lst.get(0)).argList.get() == null);
  }
  
  public void followUin(String paramString, EIPCModule paramEIPCModule, int paramInt, EIPCResultCallback paramEIPCResultCallback)
  {
    paramEIPCResultCallback = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    IPublicAccountObserver localIPublicAccountObserver = (IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class);
    localIPublicAccountObserver.setOnCallback(new LiveDelivery.3(this, paramEIPCModule, paramInt, paramEIPCResultCallback));
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).followUin(paramEIPCResultCallback, BaseApplicationImpl.getContext(), paramString, localIPublicAccountObserver, false, 0, true);
  }
  
  public long getAccount()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
  }
  
  public TogetherControlManager.EntryBannerInfo getAdsInfo(TianShuAccess.GetAdsRsp paramGetAdsRsp, int paramInt)
  {
    if (paramGetAdsRsp == null) {
      return null;
    }
    if (paramGetAdsRsp.mapAds.has()) {
      paramGetAdsRsp = paramGetAdsRsp.mapAds.get();
    } else {
      paramGetAdsRsp = null;
    }
    if (paramGetAdsRsp == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramGetAdsRsp = paramGetAdsRsp.iterator();
    while (paramGetAdsRsp.hasNext())
    {
      TianShuAccess.RspEntry localRspEntry = (TianShuAccess.RspEntry)paramGetAdsRsp.next();
      if ((localRspEntry != null) && (localRspEntry.key.has())) {
        localHashMap.put(Integer.valueOf(localRspEntry.key.get()), localRspEntry);
      }
    }
    paramGetAdsRsp = (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(paramInt));
    if (isResEntrylst(paramGetAdsRsp)) {
      return null;
    }
    return getEntryBannerInfo(paramGetAdsRsp);
  }
  
  public boolean isFollowUin(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isFollowUin(localQQAppInterface, paramString);
  }
  
  public boolean isWxInstall()
  {
    return WXShareHelper.a().a();
  }
  
  public void openChargePage()
  {
    QLog.e("LiveDelivery", 1, "openChargePage");
    VasH5PayUtil.a(BaseApplicationImpl.getApplication(), "https://h5.qzone.qq.com/live/chargedialog?_wv=17301507&from=ugc&_proxy=1&aid=zhiboczban");
  }
  
  public void openQQBrowser(String paramString)
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  public void openSchema(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("LiveDelivery", 2, "openSchema empty");
      return;
    }
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
    paramString = JumpParser.a((BaseQQAppInterface)localObject, BaseApplicationImpl.getApplication().getApplicationContext(), paramString);
    if (paramString != null)
    {
      paramString.a();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LiveDelivery", 2, "onEditorAction jumpUrl is illegal");
    }
  }
  
  public void reportAction(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt1, int paramInt2)
  {
    paramString3 = new MobileReportManager.ItemInfoBuilder().setItemId(paramString3).setBusiInfo(paramString7).setModuleId(paramString4).setItemType(paramString8).addActionInfo(new MobileReportManager.ActionInfoBuilder(System.currentTimeMillis(), paramInt1, paramInt2).build()).build();
    MobileReportManager.getInstance().reportActionLive(paramString1, paramString2, paramString3);
  }
  
  public void reportStatistic(String paramString, HashMap<String, String> paramHashMap, long paramLong)
  {
    VasStatisticCollector.a(paramString, paramHashMap, paramLong);
  }
  
  public void reportTianshu(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    TianShuReportData localTianShuReportData = new TianShuReportData();
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getAccount();
    } else {
      localObject = "";
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_");
    localStringBuilder.append(l);
    localTianShuReportData.b = localStringBuilder.toString();
    localTianShuReportData.jdField_a_of_type_Int = paramInt2;
    localTianShuReportData.jdField_e_of_type_JavaLangString = paramString1;
    localTianShuReportData.f = paramString2;
    localTianShuReportData.g = paramString3;
    localTianShuReportData.d = paramInt1;
    localTianShuReportData.jdField_e_of_type_Int = 1;
    localTianShuReportData.jdField_a_of_type_Long = l;
    TianShuManager.getInstance().report(localTianShuReportData);
  }
  
  public void reqPendantInfo(int paramInt1, int paramInt2, Serializable paramSerializable, EIPCModule paramEIPCModule, int paramInt3, EIPCResultCallback paramEIPCResultCallback)
  {
    paramEIPCResultCallback = new ArrayList();
    TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.jdField_a_of_type_Int = paramInt1;
    localTianShuAdPosItemData.b = paramInt2;
    localTianShuAdPosItemData.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramSerializable);
    paramEIPCResultCallback.add(localTianShuAdPosItemData);
    TianShuManager.getInstance().requestAdv(paramEIPCResultCallback, new LiveDelivery.5(this, paramInt1, paramEIPCModule, paramInt3));
  }
  
  public void requestPbMsfSSO(String paramString1, String paramString2, EIPCModule paramEIPCModule, int paramInt, EIPCResultCallback paramEIPCResultCallback)
  {
    PbProtocol.a(paramString1, paramString2, new LiveDelivery.1(this, paramEIPCModule, paramInt));
  }
  
  public void requestPbVSBase(String paramString1, String paramString2, EIPCModule paramEIPCModule, int paramInt, EIPCResultCallback paramEIPCResultCallback)
  {
    try
    {
      PbProtocol.a(paramString1, PbProtocol.a(paramString2.getBytes("ISO8859_1")).toByteArray(), new LiveDelivery.2(this, paramEIPCModule, paramInt));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void setAnchorIsLive(boolean paramBoolean)
  {
    cooperation.ilive.util.IliveEntranceUtil.a = paramBoolean;
  }
  
  public void setAudienceIsLive(boolean paramBoolean)
  {
    cooperation.ilive.util.IliveEntranceUtil.b = paramBoolean;
  }
  
  public void unfollowUin(String paramString, EIPCModule paramEIPCModule, int paramInt, EIPCResultCallback paramEIPCResultCallback)
  {
    paramEIPCResultCallback = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    IPublicAccountObserver localIPublicAccountObserver = (IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class);
    localIPublicAccountObserver.setOnCallback(new LiveDelivery.4(this, paramEIPCModule, paramInt));
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).unfollowUin(paramEIPCResultCallback, BaseApplicationImpl.getContext(), paramString, false, localIPublicAccountObserver, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.remote.LiveDelivery
 * JD-Core Version:    0.7.0.1
 */