package cooperation.vip.ad;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.splashad.SplashADUtil;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.vassplash.common.VasSplashCacheManager;
import com.tencent.mobileqq.vassplash.common.VasSplashUtil;
import com.tencent.mobileqq.vassplash.model.SplashItem;
import com.tencent.mobileqq.vassplash.model.SplashItem.Builder;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import cooperation.vip.qqbanner.info.VasADBannerConfigInfo;
import cooperation.vip.qqbanner.manager.VasADBannerResDownloadManager;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TianshuSplashManager
{
  private QQAppInterface a;
  
  public TianshuSplashManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public static SplashItem a(TianShuAccess.AdItem paramAdItem, QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramAdItem != null) && (paramQQAppInterface != null))
    {
      SplashADUtil.a(paramQQAppInterface.getApp(), VasSplashUtil.a(paramString));
      Object localObject2 = new HashMap();
      paramQQAppInterface = paramAdItem.argList.get().iterator();
      while (paramQQAppInterface.hasNext())
      {
        localObject1 = (TianShuAccess.MapEntry)paramQQAppInterface.next();
        ((HashMap)localObject2).put(((TianShuAccess.MapEntry)localObject1).key.get(), ((TianShuAccess.MapEntry)localObject1).value.get());
      }
      SplashItem.Builder localBuilder = new SplashItem.Builder();
      String str1 = (String)((HashMap)localObject2).get("showStartTime");
      String str2 = (String)((HashMap)localObject2).get("showEndTime");
      paramQQAppInterface = (String)((HashMap)localObject2).get("resourceType");
      String str3 = paramAdItem.traceinfo.get();
      int i = -1;
      if (paramQQAppInterface != null)
      {
        i = Integer.parseInt(paramQQAppInterface);
        if (i != 0)
        {
          if (i != 1)
          {
            if (i == 2)
            {
              paramQQAppInterface = (String)((HashMap)localObject2).get("videoURL");
              break label215;
            }
          }
          else
          {
            paramQQAppInterface = (String)((HashMap)localObject2).get("gifURL");
            break label215;
          }
        }
        else
        {
          paramQQAppInterface = (String)((HashMap)localObject2).get("imageURL");
          break label215;
        }
      }
      paramQQAppInterface = "";
      label215:
      int k = VasSplashUtil.a((String)((HashMap)localObject2).get("androidMinimumMemorySize"));
      int m = VasSplashUtil.a((String)((HashMap)localObject2).get("androidMinimumOSVersion"));
      int n = VasSplashUtil.a((String)((HashMap)localObject2).get("linkType"));
      int i1 = VasSplashUtil.a((String)((HashMap)localObject2).get("thirdPartyReportPlatform"));
      int i2 = VasSplashUtil.a((String)((HashMap)localObject2).get("showPriority"));
      String str4 = (String)((HashMap)localObject2).get("thirdPartyReportURLForExposure");
      String str5 = (String)((HashMap)localObject2).get("bannertype");
      int i3 = VasSplashUtil.a((String)((HashMap)localObject2).get("shouldShowAdMark"));
      int j;
      if ((m == 0) && (k == 0)) {
        j = 0;
      } else {
        j = 1;
      }
      Object localObject1 = (String)((HashMap)localObject2).get("linkURL");
      if ((n == 1) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).startsWith("http")))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("https://");
        ((StringBuilder)localObject3).append((String)localObject1);
        localObject1 = ((StringBuilder)localObject3).toString();
      }
      Object localObject3 = (String)((HashMap)localObject2).get("entryText");
      String str6 = (String)((HashMap)localObject2).get("entryColor");
      localObject2 = (String)((HashMap)localObject2).get("entryBgColor");
      boolean bool = VasSplashUtil.a(j, k, m);
      paramString = localBuilder.h(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAdItem.iAdId.get());
      localStringBuilder.append("");
      paramString.b(localStringBuilder.toString()).c(str1).d(str2).c(i).e(paramQQAppInterface).d(n).f((String)localObject1).b(bool).g(str4).b(i2).e(i1).i(str3).j("").a(i3).a(str5).k((String)localObject3).l(str6).m((String)localObject2);
      return localBuilder.a();
    }
    return null;
  }
  
  private HashMap<String, String> a(TianShuAccess.AdItem paramAdItem)
  {
    HashMap localHashMap = new HashMap();
    Object localObject = paramAdItem.argList.get().iterator();
    while (((Iterator)localObject).hasNext())
    {
      TianShuAccess.MapEntry localMapEntry = (TianShuAccess.MapEntry)((Iterator)localObject).next();
      localHashMap.put(localMapEntry.key.get(), localMapEntry.value.get());
    }
    localHashMap.put("traceinfo", paramAdItem.traceinfo.get());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramAdItem.iAdId.get());
    ((StringBuilder)localObject).append("");
    localHashMap.put("adId", ((StringBuilder)localObject).toString());
    return localHashMap;
  }
  
  public static List<TianShuAdPosItemData> a()
  {
    ArrayList localArrayList = new ArrayList();
    TianShuAdPosItemData localTianShuAdPosItemData;
    if (TianShuManager.isRequestEnable(510))
    {
      localTianShuAdPosItemData = new TianShuAdPosItemData();
      localTianShuAdPosItemData.b = 5;
      localTianShuAdPosItemData.a = 510;
      localArrayList.add(localTianShuAdPosItemData);
    }
    if (TianShuManager.isRequestEnable(716))
    {
      localTianShuAdPosItemData = new TianShuAdPosItemData();
      localTianShuAdPosItemData.b = 5;
      localTianShuAdPosItemData.a = 716;
      localArrayList.add(localTianShuAdPosItemData);
    }
    return localArrayList;
  }
  
  private void a(TianShuAccess.GetAdsRsp paramGetAdsRsp, String paramString)
  {
    if (this.a == null) {
      return;
    }
    if (paramGetAdsRsp.mapAds.has()) {
      paramGetAdsRsp = paramGetAdsRsp.mapAds.get();
    } else {
      paramGetAdsRsp = null;
    }
    if (paramGetAdsRsp == null) {
      return;
    }
    paramString = new HashMap();
    paramGetAdsRsp = paramGetAdsRsp.iterator();
    while (paramGetAdsRsp.hasNext())
    {
      TianShuAccess.RspEntry localRspEntry = (TianShuAccess.RspEntry)paramGetAdsRsp.next();
      if ((localRspEntry != null) && (localRspEntry.key.has()))
      {
        paramString.put(Integer.valueOf(localRspEntry.key.get()), localRspEntry);
        TianShuManager.saveNextRequestTime(localRspEntry);
      }
    }
    paramGetAdsRsp = (TianShuAccess.RspEntry)paramString.get(Integer.valueOf(510));
    if ((paramGetAdsRsp != null) && (paramGetAdsRsp.value != null) && (paramGetAdsRsp.value.lst.size() > 0)) {
      a(paramGetAdsRsp.value.lst.get());
    }
    paramGetAdsRsp = (TianShuAccess.RspEntry)paramString.get(Integer.valueOf(716));
    if ((paramGetAdsRsp != null) && (paramGetAdsRsp.value != null) && (paramGetAdsRsp.value.lst.size() > 0)) {
      b(paramGetAdsRsp.value.lst.get());
    }
  }
  
  private void a(List<TianShuAccess.AdItem> paramList)
  {
    if (this.a == null) {
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject1 = (TianShuAccess.AdItem)paramList.next();
        Object localObject2 = this.a;
        localObject2 = a((TianShuAccess.AdItem)localObject1, (QQAppInterface)localObject2, ((QQAppInterface)localObject2).getCurrentUin());
        if (localObject2 != null)
        {
          localArrayList.add(localObject2);
          localObject1 = VasADBannerConfigInfo.a(a((TianShuAccess.AdItem)localObject1), ((SplashItem)localObject2).l);
          VasADBannerResDownloadManager.a().c(this.a, (VasADBannerConfigInfo)localObject1);
          ((VasADBannerConfigInfo)localObject1).a(this.a.getCurrentUin());
        }
      }
      paramList = this.a;
      VasSplashCacheManager.a(paramList, paramList.getCurrentUin(), localArrayList);
      return;
    }
    VasSplashUtil.a(BaseApplicationImpl.getContext(), VasSplashUtil.a(this.a.getCurrentUin()), false);
  }
  
  private void b(List<TianShuAccess.AdItem> paramList)
  {
    if (this.a == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (TianShuAccess.AdItem)paramList.next();
      QQAppInterface localQQAppInterface = this.a;
      localObject = a((TianShuAccess.AdItem)localObject, localQQAppInterface, localQQAppInterface.getCurrentUin());
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    paramList = this.a;
    VasSplashCacheManager.a(paramList, paramList.getCurrentUin(), localArrayList);
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a(String paramString)
  {
    if (AppSetting.d) {
      return;
    }
    TianShuManager.getInstance().requestAdv(a(), new TianshuSplashManager.TianShuGetSplashCallback(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.ad.TianshuSplashManager
 * JD-Core Version:    0.7.0.1
 */