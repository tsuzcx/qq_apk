package com.tencent.mobileqq.together;

import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TogetherControlManager$EntryBannerInfo
{
  public String a;
  public String b;
  public String c;
  public TianShuAccess.AdItem d;
  
  public static EntryBannerInfo a(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    if (paramBoolean)
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
      Object localObject1;
      while (paramGetAdsRsp.hasNext())
      {
        localObject1 = (TianShuAccess.RspEntry)paramGetAdsRsp.next();
        if ((localObject1 != null) && (((TianShuAccess.RspEntry)localObject1).key.has())) {
          localHashMap.put(Integer.valueOf(((TianShuAccess.RspEntry)localObject1).key.get()), localObject1);
        }
      }
      paramGetAdsRsp = (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(236));
      if ((paramGetAdsRsp != null) && (paramGetAdsRsp.value != null) && (paramGetAdsRsp.value.lst.size() != 0) && (paramGetAdsRsp.value.lst.get(0) != null) && (((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0)).argList != null))
      {
        if (((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0)).argList.get() == null) {
          return null;
        }
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
        localObject1 = new EntryBannerInfo();
        ((EntryBannerInfo)localObject1).a = ((String)localHashMap.get("type"));
        ((EntryBannerInfo)localObject1).c = ((String)localHashMap.get("pic"));
        ((EntryBannerInfo)localObject1).b = ((String)localHashMap.get("url"));
        ((EntryBannerInfo)localObject1).d = ((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0));
        if (TextUtils.isEmpty(((EntryBannerInfo)localObject1).c)) {
          return null;
        }
        return localObject1;
      }
    }
    return null;
  }
  
  public static List<EntryBannerInfo> a(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp, int paramInt)
  {
    paramGetAdsRsp = TogetherControlManager.a(paramBoolean, paramGetAdsRsp, paramInt);
    if (paramGetAdsRsp == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramInt = 0;
    while (paramInt < paramGetAdsRsp.value.lst.size())
    {
      Object localObject2 = ((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(paramInt)).argList.get();
      Object localObject1 = new HashMap();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (TianShuAccess.MapEntry)((Iterator)localObject2).next();
        String str = ((TianShuAccess.MapEntry)localObject3).key.get();
        localObject3 = ((TianShuAccess.MapEntry)localObject3).value.get();
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject3))) {
          ((Map)localObject1).put(str, localObject3);
        }
      }
      localObject2 = new EntryBannerInfo();
      ((EntryBannerInfo)localObject2).a = ((String)((Map)localObject1).get("type"));
      ((EntryBannerInfo)localObject2).c = ((String)((Map)localObject1).get("pic"));
      ((EntryBannerInfo)localObject2).b = ((String)((Map)localObject1).get("url"));
      ((EntryBannerInfo)localObject2).d = ((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(paramInt));
      if (TextUtils.isEmpty(((EntryBannerInfo)localObject2).c)) {
        return localArrayList;
      }
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      URLDrawable.getDrawable(((EntryBannerInfo)localObject2).c, (URLDrawable.URLDrawableOptions)localObject1).startDownload();
      localArrayList.add(localObject2);
      paramInt += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherControlManager.EntryBannerInfo
 * JD-Core Version:    0.7.0.1
 */