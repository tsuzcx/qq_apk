package com.tencent.mobileqq.pic;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.PicBusUtil;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.richmedia.dc.PhotoUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;

public class PicStatisticsManager
  implements Manager
{
  private static final List<String> f = new ArrayList();
  private static final List<String> g;
  private static final List<String> h;
  private static final List<String> i;
  private static final List<String> j;
  private static final List<String> k;
  private static final List<String> l;
  private static final List<String> m;
  private static final String[][] n;
  private static final String[][] o;
  private static final String[][] p;
  private static final String[][] q;
  private static final int r;
  private static final List<String> s;
  private static final List<String> t;
  private static final List<String> u;
  private static final List<String> v;
  private AppInterface a;
  private Set<String> b;
  private Set<String> c;
  private SharedPreferences d;
  private SharedPreferences.Editor e;
  
  static
  {
    f.add("PicStatisticsManagerSendPicTotalSize");
    f.add("PicStatisticsManagerForwardPicTotalSize");
    f.add("PicStatisticsManagerSendPicCount");
    f.add("PicStatisticsManagerForwardPicCount");
    g = new ArrayList();
    g.add("PicStatisticsManagerThumbPicTotalSize");
    g.add("PicStatisticsManagerBigPicTotalSize");
    g.add("PicStatisticsManagerDownloadThumbPicCount");
    g.add("PicStatisticsManagerDownloadBigPicCount");
    h = new ArrayList();
    h.add("PicStatisticsManagerPicDownloadSizeSmallC2C");
    h.add("PicStatisticsManagerPicDownloadSizeMiddleC2C");
    h.add("PicStatisticsManagerPicDownloadSizeLargeC2C");
    h.add("PicStatisticsManagerPicDownloadSizeExtraLargeC2C");
    h.add("PicStatisticsManagerPicDownloadSizeLongC2C");
    h.add("PicStatisticsManagerPicPreviewSizeSmallC2C");
    h.add("PicStatisticsManagerPicPreviewSizeMiddleC2C");
    h.add("PicStatisticsManagerPicPreviewSizeLargeC2C");
    h.add("PicStatisticsManagerPicPreivewSizeExtraLargeC2C");
    h.add("PicStatisticsManagerPicPreviewSizeLongC2C");
    i = new ArrayList();
    i.add("PicStatisticsManagerPicDownloadSizeSmallGroup");
    i.add("PicStatisticsManagerPicDownloadSizeMiddleGroup");
    i.add("PicStatisticsManagerPicDownloadSizeLargeGroup");
    i.add("PicStatisticsManagerPicDownloadSizeExtraLargeGroup");
    i.add("PicStatisticsManagerPicDownloadSizeLongGroup");
    i.add("PicStatisticsManagerPicPreviewSizeSmallGroup");
    i.add("PicStatisticsManagerPicPreviewSizeMiddleGroup");
    i.add("PicStatisticsManagerPicPreviewSizeLargeGroup");
    i.add("PicStatisticsManagerPicPreivewSizeExtraLargeGroup");
    i.add("PicStatisticsManagerPicPreviewSizeLongGroup");
    j = new ArrayList();
    j.add("PicStatisticsManagerPicDownloadSizeSmallC2CDynamic");
    j.add("PicStatisticsManagerPicDownloadSizeMiddleC2CDynamic");
    j.add("PicStatisticsManagerPicDownloadSizeLargeC2CDynamic");
    j.add("PicStatisticsManagerPicDownloadSizeExtraLargeC2CDynamic");
    j.add("PicStatisticsManagerPicDownloadSizeLongC2CDynamic");
    j.add("PicStatisticsManagerPicPreviewSizeSmallC2CDynamic");
    j.add("PicStatisticsManagerPicPreviewSizeMiddleC2CDynamic");
    j.add("PicStatisticsManagerPicPreviewSizeLargeC2CDynamic");
    j.add("PicStatisticsManagerPicPreivewSizeExtraLargeC2CDynamic");
    j.add("PicStatisticsManagerPicPreviewSizeLongC2CDynamic");
    k = new ArrayList();
    k.add("PicStatisticsManagerPicDownloadSizeSmallGroupDynamic");
    k.add("PicStatisticsManagerPicDownloadSizeMiddleGroupDynamic");
    k.add("PicStatisticsManagerPicDownloadSizeLargeGroupDynamic");
    k.add("PicStatisticsManagerPicDownloadSizeExtraLargeGroupDynamic");
    k.add("PicStatisticsManagerPicDownloadSizeLongGroupDynamic");
    k.add("PicStatisticsManagerPicPreviewSizeSmallGroupDynamic");
    k.add("PicStatisticsManagerPicPreviewSizeMiddleGroupDynamic");
    k.add("PicStatisticsManagerPicPreviewSizeLargeGroupDynamic");
    k.add("PicStatisticsManagerPicPreivewSizeExtraLargeGroupDynamic");
    k.add("PicStatisticsManagerPicPreviewSizeLongGroupDynamic");
    l = new ArrayList();
    l.add("PicStatisticsManagerMissPriorityHandlingWifi");
    l.add("PicStatisticsManagerMissPriorityAIOWifi");
    l.add("PicStatisticsManagerMissPriorityC2CWifi");
    l.add("PicStatisticsManagerMissPriorityDiscussionWifi");
    l.add("PicStatisticsManagerMissPriorityGroupWifi");
    l.add("PicStatisticsManagerMissPriorityWaitingWifi");
    l.add("PicStatisticsManagerMissPriorityUnknownWifi");
    m = new ArrayList();
    m.add("PicStatisticsManagerMissPriorityHandlingXG");
    m.add("PicStatisticsManagerMissPriorityAIOXG");
    m.add("PicStatisticsManagerMissPriorityC2CXG");
    m.add("PicStatisticsManagerMissPriorityDiscussionXG");
    m.add("PicStatisticsManagerMissPriorityGroupXG");
    m.add("PicStatisticsManagerMissPriorityWaitingXG");
    m.add("PicStatisticsManagerMissPriorityUnknownXG");
    n = new String[][] { { "WifiC2CBigPicCount", "WifiDiscussionBigPicCount", "WifiGroupBigPicCount", "WifiDigitalGroupBigPicCount" }, { "4GC2CBigPicCount", "4GDiscussionBigPicCount", "4GGroupBigPicCount", "4GDigitalGroupBigPicCount" }, { "XGC2CBigPicCount", "XGDiscussionBigPicCount", "XGGroupBigPicCount", "XGDigitalGroupBigPicCount" } };
    o = new String[][] { { "WifiC2CBigPicHitCount", "WifiDiscussionBigPicHitCount", "WifiGroupBigPicHitCount", "WifiDigitalGroupBigPicHitCount" }, { "4GC2CBigPicHitCount", "4GDiscussionBigPicHitCount", "4GGroupBigPicHitCount", "4GDigitalGroupBigPicHitCount" }, { "XGC2CBigPicHitCount", "XGDiscussionBigPicHitCount", "XGGroupBigPicHitCount", "XGDigitalGroupBigPicHitCount" } };
    String[] arrayOfString = { "4GC2CBigPicMissCount", "4GDiscussionBigPicMissCount", "4GGroupBigPicMissCount", "4GDigitalGroupBigPicMissCount" };
    p = new String[][] { { "WifiC2CBigPicMissCount", "WifiDiscussionBigPicMissCount", "WifiGroupBigPicMissCount", "WifiDigitalGroupBigPicMissCount" }, arrayOfString, { "XGC2CBigPicMissCount", "XGDiscussionBigPicMissCount", "XGGroupBigPicMissCount", "XGDigitalGroupBigPicMissCount" } };
    q = new String[][] { { "WifiC2CBigPicNotSupportCount", "WifiDiscussionBigPicNotSupportCount", "WifiGroupBigPicNotSupportCount", "WifiDigitalGroupBigPicNotSupportCount" }, { "4GC2CBigPicNotSupportCount", "4GDiscussionBigPicNotSupportCount", "4GGroupBigPicNotSupportCount", "4GDigitalGroupBigPicNotSupportCount" }, { "XGC2CBigPicNotSupportCount", "XGDiscussionBigPicNotSupportCount", "XGGroupBigPicNotSupportCount", "XGDigitalGroupBigPicNotSupportCount" } };
    r = n[0].length;
    s = new ArrayList();
    t = new ArrayList();
    u = new ArrayList();
    int i1 = 0;
    while (i1 < r)
    {
      s.add(n[0][i1]);
      s.add(o[0][i1]);
      s.add(p[0][i1]);
      s.add(q[0][i1]);
      t.add(n[1][i1]);
      t.add(o[1][i1]);
      t.add(p[1][i1]);
      t.add(q[1][i1]);
      u.add(n[2][i1]);
      u.add(o[2][i1]);
      u.add(p[2][i1]);
      u.add(q[2][i1]);
      i1 += 1;
    }
    t.add("4G_C2C_FLOAT_HIT_COUNT");
    u.add("XG_C2C_FLOAT_HIT_COUNT");
    v = new ArrayList();
    v.add("PicStatisticsManagerPreDownloadThumbPicCount");
    v.add("PicStatisticsManagerPreDownloadThumbPicHitCount");
    v.add("PicStatisticsManagerPreDownloadThumbPicMissCount");
  }
  
  @TargetApi(9)
  public PicStatisticsManager(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
    this.b = new HashSet();
    this.c = new HashSet();
    this.d = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    this.e = this.d.edit();
    Logger.a("PIC_TAG_PRELOAD_PicStatisticsManager", "onInit", "Finished");
  }
  
  private String a(int paramInt)
  {
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 5)
        {
          if (paramInt != 6)
          {
            if (paramInt != 7) {
              return "PicStatisticsManagerMissPriorityUnknownWifi";
            }
            return "PicStatisticsManagerMissPriorityHandlingWifi";
          }
          return "PicStatisticsManagerMissPriorityAIOWifi";
        }
        return "PicStatisticsManagerMissPriorityC2CWifi";
      }
      return "PicStatisticsManagerMissPriorityDiscussionWifi";
    }
    return "PicStatisticsManagerMissPriorityGroupWifi";
  }
  
  private HashMap<String, String> a(List<String> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      SharedPreferences localSharedPreferences = this.d;
      long l2 = 0L;
      long l3 = localSharedPreferences.getLong(str, 0L);
      long l1 = l2;
      if (l3 >= 0L) {
        if (l3 > 10000L) {
          l1 = l2;
        } else {
          l1 = l3;
        }
      }
      localHashMap.put(str, String.valueOf(l1));
    }
    return localHashMap;
  }
  
  @TargetApi(9)
  private void a(int paramInt1, int paramInt2, String[][] paramArrayOfString, boolean paramBoolean)
  {
    int i2 = 0;
    String str2;
    int i1;
    if (paramInt1 == 0)
    {
      if (paramBoolean)
      {
        l1 = this.d.getLong("PicStatisticsManagerPredownloadCountWifi", 0L);
        this.e.putLong("PicStatisticsManagerPredownloadCountWifi", l1 + 1L);
      }
      else
      {
        l1 = this.d.getLong("PicStatisticsManagerPreviewCountWifi", 0L);
        this.e.putLong("PicStatisticsManagerPreviewCountWifi", l1 + 1L);
      }
      str2 = "WIFI";
      i1 = 0;
    }
    else if (paramInt1 == 0)
    {
      if (paramBoolean)
      {
        l1 = this.d.getLong("PicStatisticsManagerPredownloadCount4G", 0L);
        this.e.putLong("PicStatisticsManagerPredownloadCount4G", l1 + 1L);
      }
      else
      {
        l1 = this.d.getLong("PicStatisticsManagerPreviewCount4G", 0L);
        this.e.putLong("PicStatisticsManagerPreviewCount4G", l1 + 1L);
      }
      str2 = "4G";
      i1 = 1;
    }
    else
    {
      if (paramBoolean)
      {
        l1 = this.d.getLong("PicStatisticsManagerPredownloadCountXG", 0L);
        this.e.putLong("PicStatisticsManagerPredownloadCountXG", l1 + 1L);
      }
      else
      {
        l1 = this.d.getLong("PicStatisticsManagerPreviewCountXG", 0L);
        this.e.putLong("PicStatisticsManagerPreviewCountXG", l1 + 1L);
      }
      str2 = "XG";
      i1 = 2;
    }
    String str1;
    if (paramInt2 == 3)
    {
      str1 = "C2C";
      paramInt1 = i2;
    }
    else if (paramInt2 == 2)
    {
      str1 = "Discussion";
      paramInt1 = 1;
    }
    else if (paramInt2 == 0)
    {
      str1 = "Group";
      paramInt1 = 2;
    }
    else
    {
      if (paramInt2 != 1) {
        break label442;
      }
      str1 = "Digital Group";
      paramInt1 = 3;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addCount(): networkType=");
      localStringBuilder.append(str2);
      localStringBuilder.append(" uin=");
      localStringBuilder.append(str1);
      QLog.d("PicStatisticsManager", 2, localStringBuilder.toString());
    }
    paramArrayOfString = paramArrayOfString[i1][paramInt1];
    long l1 = this.d.getLong(paramArrayOfString, 0L) + 1L;
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.e.putLong(paramArrayOfString, l1).apply();
      return;
    }
    this.e.putLong(paramArrayOfString, l1).commit();
    return;
    label442:
    if (QLog.isColorLevel()) {
      QLog.e("PicStatisticsManager", 2, "addCount(): Error! Unknown uin type");
    }
  }
  
  private String b(int paramInt)
  {
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 5)
        {
          if (paramInt != 6)
          {
            if (paramInt != 7) {
              return "PicStatisticsManagerMissPriorityUnknownXG";
            }
            return "PicStatisticsManagerMissPriorityHandlingXG";
          }
          return "PicStatisticsManagerMissPriorityAIOXG";
        }
        return "PicStatisticsManagerMissPriorityC2CXG";
      }
      return "PicStatisticsManagerMissPriorityDiscussionXG";
    }
    return "PicStatisticsManagerMissPriorityGroupXG";
  }
  
  @TargetApi(9)
  private void b()
  {
    Iterator localIterator = f.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.e.putLong(str, 0L);
    }
    localIterator = g.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.e.putLong(str, 0L);
    }
    localIterator = l.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.e.putLong(str, 0L);
    }
    localIterator = m.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.e.putLong(str, 0L);
    }
    localIterator = s.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.e.putLong(str, 0L);
    }
    localIterator = u.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.e.putLong(str, 0L);
    }
    localIterator = v.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.e.putLong(str, 0L);
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.e.apply();
      return;
    }
    this.e.commit();
  }
  
  @TargetApi(9)
  public void a()
  {
    if (!this.d.getBoolean("PicStatisticsManagerFirstUsed", false))
    {
      if (Build.VERSION.SDK_INT >= 9) {
        this.e.putBoolean("PicStatisticsManagerFirstUsed", true).apply();
      } else {
        this.e.putBoolean("PicStatisticsManagerFirstUsed", true).commit();
      }
      if (QLog.isColorLevel()) {
        QLog.i("PicStatisticsManager", 2, "dataReport(): Not need to data report!");
      }
      return;
    }
    Object localObject = this.a;
    if (localObject != null) {
      localObject = ((AppInterface)localObject).getCurrentAccountUin();
    } else {
      localObject = null;
    }
    if (this.d.getLong("PicStatisticsManagerPreDownloadThumbPicCount", 0L) > 0L)
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "PicStatisticsManagerPredownloadThumbPic", false, 0L, 0L, a(v), "");
      l1 = this.d.getLong("PicStatisticsManagerPredownloadCountWifi", 0L);
      l2 = this.d.getLong("PicStatisticsManagerPredownloadCountXG", 0L);
      long l3 = this.d.getLong("PicStatisticsManagerPredownloadCount4G", 0L);
      long l4 = this.d.getLong("PicStatisticsManagerPreviewCountWifi", 0L);
      long l5 = this.d.getLong("PicStatisticsManagerPreviewCountXG", 0L);
      long l6 = this.d.getLong("PicStatisticsManagerPreviewCount4G", 0L);
      if (l1 + l4 > 0L) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "PicStatisticsManagerPredownloadDataWifi", false, 0L, 0L, a(s), "");
      }
      if (l3 + l6 > 0L) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "PicStatisticsManagerPredownloadData4g", false, 0L, 0L, a(t), "");
      }
      if (l2 + l5 > 0L) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "PicStatisticsManagerPredownloadDataXg", false, 0L, 0L, a(u), "");
      }
      if (l4 + l5 > 0L)
      {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "PicStatisticsManagerDiffSizePicPreviewC2C", false, 0L, 0L, a(h), "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "PicStatisticsManagerDiffSizePicPreviewGroup", false, 0L, 0L, a(i), "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "PicStatisticsManagerDiffSizePicPreviewC2CDynamic", false, 0L, 0L, a(j), "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "PicStatisticsManagerDiffSizePicPreviewGroupDynamic", false, 0L, 0L, a(k), "");
      }
      if (l4 > 0L) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "PicStatisticsManagerPredownloadMissPriorityWifi", false, 0L, 0L, a(l), "");
      }
      if (l5 > 0L) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "PicStatisticsManagerPredownloadMissPriorityXG", false, 0L, 0L, a(m), "");
      }
    }
    long l1 = this.d.getLong("PicStatisticsManagerSendPicCount", 0L);
    long l2 = this.d.getLong("PicStatisticsManagerForwardPicCount", 0L);
    HashMap localHashMap1 = a(f);
    if (l1 + l2 <= 0L) {
      localHashMap1.put("PicStatisticsManagerIsUploadPicActive", "FALSE");
    } else {
      localHashMap1.put("PicStatisticsManagerIsUploadPicActive", "TRUE");
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "PicStatisticsManagerUploadPic", false, 0L, 0L, localHashMap1, "");
    l1 = this.d.getLong("PicStatisticsManagerDownloadThumbPicCount", 0L);
    l2 = this.d.getLong("PicStatisticsManagerDownloadBigPicCount", 0L);
    HashMap localHashMap2 = a(g);
    if (l1 + l2 <= 0L) {
      localHashMap1.put("PicStatisticsManagerIsDownloadPicActive", "FALSE");
    } else {
      localHashMap1.put("PicStatisticsManagerIsDownloadPicActive", "TRUE");
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "PicStatisticsManagerDownloadPic", false, 0L, 0L, localHashMap2, "");
    b();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = ((AppInterface)localObject).getCurrentAccountUin();
    } else {
      localObject = null;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PredownloadMissReason", String.valueOf(paramInt2));
    if (paramInt1 == 0)
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "PicStatisticsManagerPredownloadMissReasonGrayForWifi", false, 0L, 0L, localHashMap, "");
      return;
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "PicStatisticsManagerPredownloadMissReasonGrayForXG", false, 0L, 0L, localHashMap, "");
  }
  
  @TargetApi(9)
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addPreDownloadBigPicHitCount(): networkType=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" uin=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" preDownloadState=");
      localStringBuilder.append(paramInt3);
      QLog.d("PicStatisticsManager", 2, localStringBuilder.toString());
    }
    if (paramInt3 == 1)
    {
      long l1;
      long l2;
      if (paramInt1 == 2)
      {
        l1 = this.d.getLong("XG_C2C_FLOAT_HIT_COUNT", 0L);
        l2 = this.d.getLong("PicStatisticsManagerPreviewCountXG", 0L);
        this.e.putLong("PicStatisticsManagerPreviewCountXG", l2 + 1L);
        this.e.putLong("XG_C2C_FLOAT_HIT_COUNT", l1 + 1L);
      }
      else
      {
        if (paramInt1 != 1) {
          break label250;
        }
        l1 = this.d.getLong("4G_C2C_FLOAT_HIT_COUNT", 0L);
        l2 = this.d.getLong("PicStatisticsManagerPreviewCount4G", 0L);
        this.e.putLong("PicStatisticsManagerPreviewCount4G", l2 + 1L);
        this.e.putLong("4G_C2C_FLOAT_HIT_COUNT", l1 + 1L);
      }
      if (Build.VERSION.SDK_INT >= 9)
      {
        this.e.apply();
        return;
      }
      this.e.commit();
      return;
      label250:
      if (QLog.isColorLevel()) {
        QLog.d("PicStatisticsManager", 2, "addPreDownloadBigPicHitCount(): Error, not 3G or 4G, Float hit");
      }
      return;
    }
    a(paramInt1, paramInt2, o, false);
  }
  
  @TargetApi(9)
  public void a(int paramInt, long paramLong)
  {
    String str3;
    String str1;
    String str2;
    switch (paramInt)
    {
    default: 
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.e("PicStatisticsManager", 2, "addPicData(): Unknown picture type!");
      return;
    case 13060: 
      str3 = "DownloadBigPic";
      str1 = "PicStatisticsManagerBigPicTotalSize";
      str2 = "PicStatisticsManagerDownloadBigPicCount";
      break;
    case 13059: 
      str3 = "DownloadThumbPic";
      str1 = "PicStatisticsManagerThumbPicTotalSize";
      str2 = "PicStatisticsManagerDownloadThumbPicCount";
      break;
    case 13058: 
      str3 = "ForwardPic";
      str1 = "PicStatisticsManagerForwardPicTotalSize";
      str2 = "PicStatisticsManagerForwardPicCount";
      break;
    case 13057: 
      str3 = "SendPic";
      str1 = "PicStatisticsManagerSendPicTotalSize";
      str2 = "PicStatisticsManagerSendPicCount";
    }
    long l1 = this.d.getLong(str1, 0L) + paramLong;
    long l2 = this.d.getLong(str2, 0L) + 1L;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addPictureData(): type=");
      localStringBuilder.append(str3);
      localStringBuilder.append(" Adding Size=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" Total Size=");
      localStringBuilder.append(l1);
      localStringBuilder.append(" Count=");
      localStringBuilder.append(l2);
      QLog.i("PicStatisticsManager", 2, localStringBuilder.toString());
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.e.putLong(str1, l1).putLong(str2, l2).apply();
      return;
    }
    this.e.putLong(str1, l1).putLong(str2, l2).commit();
  }
  
  @TargetApi(9)
  public void a(MessageForPic paramMessageForPic)
  {
    try
    {
      String str = paramMessageForPic.md5;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addPreDownloadThumbPic(): Uniseq=");
        localStringBuilder.append(paramMessageForPic.uniseq);
        localStringBuilder.append(" MD5=");
        localStringBuilder.append(paramMessageForPic.md5);
        QLog.d("PicStatisticsManager", 2, localStringBuilder.toString());
      }
      boolean bool = this.b.contains(str);
      if (bool) {
        return;
      }
      this.b.add(paramMessageForPic.md5);
      long l1 = this.d.getLong("PicStatisticsManagerPreDownloadThumbPicCount", 0L) + 1L;
      if (Build.VERSION.SDK_INT >= 9) {
        this.e.putLong("PicStatisticsManagerPreDownloadThumbPicCount", l1).apply();
      } else {
        this.e.putLong("PicStatisticsManagerPreDownloadThumbPicCount", l1).commit();
      }
      if (QLog.isColorLevel())
      {
        paramMessageForPic = new StringBuilder();
        paramMessageForPic.append("addPreDownloadThumbPic(): PreDownloadThumbPicCount=");
        paramMessageForPic.append(l1);
        QLog.i("PicStatisticsManager", 2, paramMessageForPic.toString());
      }
      return;
    }
    finally {}
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addPreDownloadBigPicCount(): networkType=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" uin=");
      localStringBuilder.append(paramInt2);
      QLog.d("PicStatisticsManager", 2, localStringBuilder.toString());
    }
    a(paramInt1, paramInt2, n, true);
  }
  
  @TargetApi(9)
  public void b(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PicStatisticsManager", 2, "addDownloadBigPicSize(): pic is null");
      }
      return;
    }
    long l1 = paramMessageForPic.width;
    long l2 = paramMessageForPic.height;
    if ((l1 > 0L) && (l2 > 0L))
    {
      int i1;
      if (PicPreDownloadUtils.a(this.a, paramMessageForPic.istroop, paramMessageForPic.frienduin) == 3) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      int i2 = PhotoUtils.b(l1, l2);
      String str1;
      if (i2 == 0)
      {
        if (i1 != 0) {
          str1 = "PicStatisticsManagerPicDownloadSizeLongC2C";
        } else {
          str1 = "PicStatisticsManagerPicDownloadSizeLongGroup";
        }
      }
      else if (i2 == 1)
      {
        if (i1 != 0) {
          str1 = "PicStatisticsManagerPicDownloadSizeSmallC2C";
        } else {
          str1 = "PicStatisticsManagerPicDownloadSizeSmallGroup";
        }
      }
      else if (i2 == 2)
      {
        if (i1 != 0) {
          str1 = "PicStatisticsManagerPicDownloadSizeMiddleC2C";
        } else {
          str1 = "PicStatisticsManagerPicDownloadSizeMiddleGroup";
        }
      }
      else if (i2 == 3)
      {
        if (i1 != 0) {
          str1 = "PicStatisticsManagerPicDownloadSizeLargeC2C";
        } else {
          str1 = "PicStatisticsManagerPicDownloadSizeLargeGroup";
        }
      }
      else if (i1 != 0) {
        str1 = "PicStatisticsManagerPicDownloadSizeExtraLargeC2C";
      } else {
        str1 = "PicStatisticsManagerPicDownloadSizeExtraLargeGroup";
      }
      String str2 = str1;
      if (PicBusUtil.a(paramMessageForPic.imageType))
      {
        paramMessageForPic = new StringBuilder();
        paramMessageForPic.append(str1);
        paramMessageForPic.append("Dynamic");
        str2 = paramMessageForPic.toString();
      }
      long l3 = this.d.getLong(str2, 0L) + 1L;
      if (QLog.isColorLevel())
      {
        paramMessageForPic = new StringBuilder();
        paramMessageForPic.append("addDownloadBigPicSize(): ");
        paramMessageForPic.append(str2);
        paramMessageForPic.append(", Width=");
        paramMessageForPic.append(l1);
        paramMessageForPic.append(" Height=");
        paramMessageForPic.append(l2);
        paramMessageForPic.append(" Count=");
        paramMessageForPic.append(l3);
        QLog.d("PicStatisticsManager", 2, paramMessageForPic.toString());
      }
      if (Build.VERSION.SDK_INT >= 9)
      {
        this.e.putLong(str2, l3).apply();
        return;
      }
      this.e.putLong(str2, l3).commit();
      return;
    }
    if (QLog.isColorLevel())
    {
      paramMessageForPic = new StringBuilder();
      paramMessageForPic.append("addDownloadBigPicSize(): Width=");
      paramMessageForPic.append(l1);
      paramMessageForPic.append(" Height=");
      paramMessageForPic.append(l2);
      paramMessageForPic.append(", invalid!");
      QLog.d("PicStatisticsManager", 2, paramMessageForPic.toString());
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addPreDownloadBigPicMissCount(): networkType=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" uin=");
      localStringBuilder.append(paramInt2);
      QLog.d("PicStatisticsManager", 2, localStringBuilder.toString());
    }
    a(paramInt1, paramInt2, p, false);
  }
  
  @TargetApi(9)
  public void c(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PicStatisticsManager", 2, "addPreviewBigPicSize(): pic is null");
      }
      return;
    }
    long l1 = paramMessageForPic.width;
    long l2 = paramMessageForPic.height;
    if ((l1 > 0L) && (l2 > 0L))
    {
      int i1;
      if (PicPreDownloadUtils.a(this.a, paramMessageForPic.istroop, paramMessageForPic.frienduin) == 3) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      int i2 = PhotoUtils.b(l1, l2);
      String str1;
      if (i2 == 0)
      {
        if (i1 != 0) {
          str1 = "PicStatisticsManagerPicPreviewSizeLongC2C";
        } else {
          str1 = "PicStatisticsManagerPicPreviewSizeLongGroup";
        }
      }
      else if (i2 == 1)
      {
        if (i1 != 0) {
          str1 = "PicStatisticsManagerPicPreviewSizeSmallC2C";
        } else {
          str1 = "PicStatisticsManagerPicPreviewSizeSmallGroup";
        }
      }
      else if (i2 == 2)
      {
        if (i1 != 0) {
          str1 = "PicStatisticsManagerPicPreviewSizeMiddleC2C";
        } else {
          str1 = "PicStatisticsManagerPicPreviewSizeMiddleGroup";
        }
      }
      else if (i2 == 3)
      {
        if (i1 != 0) {
          str1 = "PicStatisticsManagerPicPreviewSizeLargeC2C";
        } else {
          str1 = "PicStatisticsManagerPicPreviewSizeLargeGroup";
        }
      }
      else if (i1 != 0) {
        str1 = "PicStatisticsManagerPicPreivewSizeExtraLargeC2C";
      } else {
        str1 = "PicStatisticsManagerPicPreivewSizeExtraLargeGroup";
      }
      String str2 = str1;
      if (PicBusUtil.a(paramMessageForPic.imageType))
      {
        paramMessageForPic = new StringBuilder();
        paramMessageForPic.append(str1);
        paramMessageForPic.append("Dynamic");
        str2 = paramMessageForPic.toString();
      }
      long l3 = this.d.getLong(str2, 0L) + 1L;
      if (QLog.isColorLevel())
      {
        paramMessageForPic = new StringBuilder();
        paramMessageForPic.append("addPreviewBigPicSize(): ");
        paramMessageForPic.append(str2);
        paramMessageForPic.append(", Width=");
        paramMessageForPic.append(l1);
        paramMessageForPic.append(" Height=");
        paramMessageForPic.append(l2);
        paramMessageForPic.append(" Count=");
        paramMessageForPic.append(l3);
        QLog.d("PicStatisticsManager", 2, paramMessageForPic.toString());
      }
      if (Build.VERSION.SDK_INT >= 9)
      {
        this.e.putLong(str2, l3).apply();
        return;
      }
      this.e.putLong(str2, l3).commit();
      return;
    }
    if (QLog.isColorLevel())
    {
      paramMessageForPic = new StringBuilder();
      paramMessageForPic.append("addPreviewBigPicSize(): Width=");
      paramMessageForPic.append(l1);
      paramMessageForPic.append(" Height=");
      paramMessageForPic.append(l2);
      paramMessageForPic.append(", invalid!");
      QLog.d("PicStatisticsManager", 2, paramMessageForPic.toString());
    }
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addPreDownloadNotSupportCount(): networkType=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" uin=");
      localStringBuilder.append(paramInt2);
      QLog.d("PicStatisticsManager", 2, localStringBuilder.toString());
    }
    a(paramInt1, paramInt2, q, false);
  }
  
  @TargetApi(9)
  public void e(int paramInt1, int paramInt2)
  {
    String str;
    if (paramInt1 == 0) {
      str = a(paramInt2);
    } else {
      str = b(paramInt2);
    }
    long l1 = this.d.getLong(str, 0L) + 1L;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addPredownloadMissPriority(): ");
      localStringBuilder.append(str);
      localStringBuilder.append(", Count=");
      localStringBuilder.append(l1);
      QLog.d("PicStatisticsManager", 2, localStringBuilder.toString());
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.e.putLong(str, l1).apply();
      return;
    }
    this.e.putLong(str, l1).commit();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicStatisticsManager
 * JD-Core Version:    0.7.0.1
 */