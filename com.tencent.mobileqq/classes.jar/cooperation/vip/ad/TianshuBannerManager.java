package cooperation.vip.ad;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.bannerprocessor.VasADBannerProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import cooperation.vip.qqbanner.data.CountDownImmersionData;
import cooperation.vip.qqbanner.data.VasADBannerData;
import cooperation.vip.qqbanner.info.VasADBannerConfigInfo;
import cooperation.vip.qqbanner.info.VasADBannerCountDownImmersionInfo;
import cooperation.vip.qqbanner.manager.VasADBannerResDownloadManager;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TianshuBannerManager
{
  private QQAppInterface a;
  
  public TianshuBannerManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
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
  
  private static List<TianShuAdPosItemData> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (TianShuManager.isRequestEnable(715))
    {
      TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
      localTianShuAdPosItemData.b = 5;
      localTianShuAdPosItemData.a = 715;
      localArrayList.add(localTianShuAdPosItemData);
    }
    return localArrayList;
  }
  
  private void a(TianShuAccess.GetAdsRsp paramGetAdsRsp, String paramString)
  {
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
    paramGetAdsRsp = (TianShuAccess.RspEntry)paramString.get(Integer.valueOf(715));
    if ((paramGetAdsRsp != null) && (paramGetAdsRsp.value != null) && (paramGetAdsRsp.value.lst.size() > 0)) {
      a(paramGetAdsRsp.value.lst.get());
    }
  }
  
  private void a(List<TianShuAccess.AdItem> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = a((TianShuAccess.AdItem)paramList.get(0));
      paramList = VasADBannerConfigInfo.a(paramList, (String)paramList.get("bannertype"));
      a(paramList);
      VasADBannerResDownloadManager.a().a(this.a, paramList);
      return;
    }
    BannerManager.a().b(VasADBannerProcessor.a, 3001);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = VasADBannerResDownloadManager.a().a(paramQQAppInterface.getAccount());
      if ((paramQQAppInterface instanceof VasADBannerCountDownImmersionInfo))
      {
        paramQQAppInterface = ((VasADBannerCountDownImmersionInfo)paramQQAppInterface).a();
        if (paramQQAppInterface != null) {
          return paramQQAppInterface.a;
        }
      }
    }
    return false;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a(VasADBannerConfigInfo paramVasADBannerConfigInfo)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = VasADBannerResDownloadManager.a().a(((QQAppInterface)localObject).getAccount());
    if (paramVasADBannerConfigInfo != null)
    {
      if (localObject == null) {
        return;
      }
      int j = 0;
      int i = j;
      if (paramVasADBannerConfigInfo.a() != null)
      {
        i = j;
        if (((VasADBannerConfigInfo)localObject).a() != null)
        {
          paramVasADBannerConfigInfo = paramVasADBannerConfigInfo.a().d;
          localObject = ((VasADBannerConfigInfo)localObject).a().d;
          i = j;
          if (!TextUtils.isEmpty(paramVasADBannerConfigInfo))
          {
            i = j;
            if (!paramVasADBannerConfigInfo.equals(localObject)) {
              i = 1;
            }
          }
        }
      }
      if (i != 0) {
        BannerManager.a().b(VasADBannerProcessor.a, 3001);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (("vas_banner_pull_refresh".equals(paramString)) && (this.a != null) && (VasADBannerResDownloadManager.a().a(this.a.getAccount()) != null) && (!a(this.a))) {
      BannerManager.a().b(VasADBannerProcessor.a, 3001);
    }
    TianShuManager.getInstance().requestAdv(a(), new TianshuBannerManager.TianShuGetSplashCallback(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.ad.TianshuBannerManager
 * JD-Core Version:    0.7.0.1
 */