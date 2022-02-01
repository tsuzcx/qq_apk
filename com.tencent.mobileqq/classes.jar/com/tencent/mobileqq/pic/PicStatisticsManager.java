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
  private static final int jdField_a_of_type_Int;
  private static final List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private static final String[][] jdField_a_of_type_Array2dOfJavaLangString;
  private static final List<String> jdField_b_of_type_JavaUtilList;
  private static final String[][] jdField_b_of_type_Array2dOfJavaLangString;
  private static final List<String> jdField_c_of_type_JavaUtilList;
  private static final String[][] jdField_c_of_type_Array2dOfJavaLangString;
  private static final List<String> jdField_d_of_type_JavaUtilList;
  private static final String[][] jdField_d_of_type_Array2dOfJavaLangString;
  private static final List<String> e;
  private static final List<String> f;
  private static final List<String> g;
  private static final List<String> h;
  private static final List<String> i;
  private static final List<String> j;
  private static final List<String> k;
  private static final List<String> l;
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private Set<String> jdField_b_of_type_JavaUtilSet;
  
  static
  {
    jdField_a_of_type_JavaUtilList.add("PicStatisticsManagerSendPicTotalSize");
    jdField_a_of_type_JavaUtilList.add("PicStatisticsManagerForwardPicTotalSize");
    jdField_a_of_type_JavaUtilList.add("PicStatisticsManagerSendPicCount");
    jdField_a_of_type_JavaUtilList.add("PicStatisticsManagerForwardPicCount");
    jdField_b_of_type_JavaUtilList = new ArrayList();
    jdField_b_of_type_JavaUtilList.add("PicStatisticsManagerThumbPicTotalSize");
    jdField_b_of_type_JavaUtilList.add("PicStatisticsManagerBigPicTotalSize");
    jdField_b_of_type_JavaUtilList.add("PicStatisticsManagerDownloadThumbPicCount");
    jdField_b_of_type_JavaUtilList.add("PicStatisticsManagerDownloadBigPicCount");
    jdField_c_of_type_JavaUtilList = new ArrayList();
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeSmallC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeMiddleC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeLargeC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeExtraLargeC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeLongC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeSmallC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeMiddleC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeLargeC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicPreivewSizeExtraLargeC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeLongC2C");
    jdField_d_of_type_JavaUtilList = new ArrayList();
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeSmallGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeMiddleGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeLargeGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeExtraLargeGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeLongGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeSmallGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeMiddleGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeLargeGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicPreivewSizeExtraLargeGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeLongGroup");
    e = new ArrayList();
    e.add("PicStatisticsManagerPicDownloadSizeSmallC2CDynamic");
    e.add("PicStatisticsManagerPicDownloadSizeMiddleC2CDynamic");
    e.add("PicStatisticsManagerPicDownloadSizeLargeC2CDynamic");
    e.add("PicStatisticsManagerPicDownloadSizeExtraLargeC2CDynamic");
    e.add("PicStatisticsManagerPicDownloadSizeLongC2CDynamic");
    e.add("PicStatisticsManagerPicPreviewSizeSmallC2CDynamic");
    e.add("PicStatisticsManagerPicPreviewSizeMiddleC2CDynamic");
    e.add("PicStatisticsManagerPicPreviewSizeLargeC2CDynamic");
    e.add("PicStatisticsManagerPicPreivewSizeExtraLargeC2CDynamic");
    e.add("PicStatisticsManagerPicPreviewSizeLongC2CDynamic");
    f = new ArrayList();
    f.add("PicStatisticsManagerPicDownloadSizeSmallGroupDynamic");
    f.add("PicStatisticsManagerPicDownloadSizeMiddleGroupDynamic");
    f.add("PicStatisticsManagerPicDownloadSizeLargeGroupDynamic");
    f.add("PicStatisticsManagerPicDownloadSizeExtraLargeGroupDynamic");
    f.add("PicStatisticsManagerPicDownloadSizeLongGroupDynamic");
    f.add("PicStatisticsManagerPicPreviewSizeSmallGroupDynamic");
    f.add("PicStatisticsManagerPicPreviewSizeMiddleGroupDynamic");
    f.add("PicStatisticsManagerPicPreviewSizeLargeGroupDynamic");
    f.add("PicStatisticsManagerPicPreivewSizeExtraLargeGroupDynamic");
    f.add("PicStatisticsManagerPicPreviewSizeLongGroupDynamic");
    g = new ArrayList();
    g.add("PicStatisticsManagerMissPriorityHandlingWifi");
    g.add("PicStatisticsManagerMissPriorityAIOWifi");
    g.add("PicStatisticsManagerMissPriorityC2CWifi");
    g.add("PicStatisticsManagerMissPriorityDiscussionWifi");
    g.add("PicStatisticsManagerMissPriorityGroupWifi");
    g.add("PicStatisticsManagerMissPriorityWaitingWifi");
    g.add("PicStatisticsManagerMissPriorityUnknownWifi");
    h = new ArrayList();
    h.add("PicStatisticsManagerMissPriorityHandlingXG");
    h.add("PicStatisticsManagerMissPriorityAIOXG");
    h.add("PicStatisticsManagerMissPriorityC2CXG");
    h.add("PicStatisticsManagerMissPriorityDiscussionXG");
    h.add("PicStatisticsManagerMissPriorityGroupXG");
    h.add("PicStatisticsManagerMissPriorityWaitingXG");
    h.add("PicStatisticsManagerMissPriorityUnknownXG");
    jdField_a_of_type_Array2dOfJavaLangString = new String[][] { { "WifiC2CBigPicCount", "WifiDiscussionBigPicCount", "WifiGroupBigPicCount", "WifiDigitalGroupBigPicCount" }, { "4GC2CBigPicCount", "4GDiscussionBigPicCount", "4GGroupBigPicCount", "4GDigitalGroupBigPicCount" }, { "XGC2CBigPicCount", "XGDiscussionBigPicCount", "XGGroupBigPicCount", "XGDigitalGroupBigPicCount" } };
    jdField_b_of_type_Array2dOfJavaLangString = new String[][] { { "WifiC2CBigPicHitCount", "WifiDiscussionBigPicHitCount", "WifiGroupBigPicHitCount", "WifiDigitalGroupBigPicHitCount" }, { "4GC2CBigPicHitCount", "4GDiscussionBigPicHitCount", "4GGroupBigPicHitCount", "4GDigitalGroupBigPicHitCount" }, { "XGC2CBigPicHitCount", "XGDiscussionBigPicHitCount", "XGGroupBigPicHitCount", "XGDigitalGroupBigPicHitCount" } };
    String[] arrayOfString1 = { "WifiC2CBigPicMissCount", "WifiDiscussionBigPicMissCount", "WifiGroupBigPicMissCount", "WifiDigitalGroupBigPicMissCount" };
    String[] arrayOfString2 = { "XGC2CBigPicMissCount", "XGDiscussionBigPicMissCount", "XGGroupBigPicMissCount", "XGDigitalGroupBigPicMissCount" };
    jdField_c_of_type_Array2dOfJavaLangString = new String[][] { arrayOfString1, { "4GC2CBigPicMissCount", "4GDiscussionBigPicMissCount", "4GGroupBigPicMissCount", "4GDigitalGroupBigPicMissCount" }, arrayOfString2 };
    jdField_d_of_type_Array2dOfJavaLangString = new String[][] { { "WifiC2CBigPicNotSupportCount", "WifiDiscussionBigPicNotSupportCount", "WifiGroupBigPicNotSupportCount", "WifiDigitalGroupBigPicNotSupportCount" }, { "4GC2CBigPicNotSupportCount", "4GDiscussionBigPicNotSupportCount", "4GGroupBigPicNotSupportCount", "4GDigitalGroupBigPicNotSupportCount" }, { "XGC2CBigPicNotSupportCount", "XGDiscussionBigPicNotSupportCount", "XGGroupBigPicNotSupportCount", "XGDigitalGroupBigPicNotSupportCount" } };
    jdField_a_of_type_Int = jdField_a_of_type_Array2dOfJavaLangString[0].length;
    i = new ArrayList();
    j = new ArrayList();
    k = new ArrayList();
    int m = 0;
    while (m < jdField_a_of_type_Int)
    {
      i.add(jdField_a_of_type_Array2dOfJavaLangString[0][m]);
      i.add(jdField_b_of_type_Array2dOfJavaLangString[0][m]);
      i.add(jdField_c_of_type_Array2dOfJavaLangString[0][m]);
      i.add(jdField_d_of_type_Array2dOfJavaLangString[0][m]);
      j.add(jdField_a_of_type_Array2dOfJavaLangString[1][m]);
      j.add(jdField_b_of_type_Array2dOfJavaLangString[1][m]);
      j.add(jdField_c_of_type_Array2dOfJavaLangString[1][m]);
      j.add(jdField_d_of_type_Array2dOfJavaLangString[1][m]);
      k.add(jdField_a_of_type_Array2dOfJavaLangString[2][m]);
      k.add(jdField_b_of_type_Array2dOfJavaLangString[2][m]);
      k.add(jdField_c_of_type_Array2dOfJavaLangString[2][m]);
      k.add(jdField_d_of_type_Array2dOfJavaLangString[2][m]);
      m += 1;
    }
    j.add("4G_C2C_FLOAT_HIT_COUNT");
    k.add("XG_C2C_FLOAT_HIT_COUNT");
    l = new ArrayList();
    l.add("PicStatisticsManagerPreDownloadThumbPicCount");
    l.add("PicStatisticsManagerPreDownloadThumbPicHitCount");
    l.add("PicStatisticsManagerPreDownloadThumbPicMissCount");
  }
  
  @TargetApi(9)
  public PicStatisticsManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_AndroidContentSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    Logger.a("PIC_TAG_PRELOAD_PicStatisticsManager", "onInit", "Finished");
  }
  
  private String a(int paramInt)
  {
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if (paramInt != 6) {
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
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
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
    int n = 0;
    String str2;
    int m;
    if (paramInt1 == 0)
    {
      if (paramBoolean)
      {
        l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPredownloadCountWifi", 0L);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPredownloadCountWifi", l1 + 1L);
      }
      else
      {
        l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCountWifi", 0L);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreviewCountWifi", l1 + 1L);
      }
      str2 = "WIFI";
      m = 0;
    }
    else if (paramInt1 == 0)
    {
      if (paramBoolean)
      {
        l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPredownloadCount4G", 0L);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPredownloadCount4G", l1 + 1L);
      }
      else
      {
        l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCount4G", 0L);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreviewCount4G", l1 + 1L);
      }
      str2 = "4G";
      m = 1;
    }
    else
    {
      if (paramBoolean)
      {
        l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPredownloadCountXG", 0L);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPredownloadCountXG", l1 + 1L);
      }
      else
      {
        l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCountXG", 0L);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreviewCountXG", l1 + 1L);
      }
      str2 = "XG";
      m = 2;
    }
    String str1;
    if (paramInt2 == 3)
    {
      str1 = "C2C";
      paramInt1 = n;
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
    paramArrayOfString = paramArrayOfString[m][paramInt1];
    long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(paramArrayOfString, 0L) + 1L;
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(paramArrayOfString, l1).apply();
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(paramArrayOfString, l1).commit();
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
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if (paramInt != 6) {
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
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    localIterator = jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    localIterator = g.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    localIterator = h.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    localIterator = i.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    localIterator = k.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    localIterator = l.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  @TargetApi(9)
  public void a()
  {
    if (!this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("PicStatisticsManagerFirstUsed", false))
    {
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putBoolean("PicStatisticsManagerFirstUsed", true).apply();
      } else {
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putBoolean("PicStatisticsManagerFirstUsed", true).commit();
      }
      if (QLog.isColorLevel()) {
        QLog.i("PicStatisticsManager", 2, "dataReport(): Not need to data report!");
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localObject != null) {
      localObject = ((AppInterface)localObject).getCurrentAccountUin();
    } else {
      localObject = null;
    }
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreDownloadThumbPicCount", 0L) > 0L)
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "PicStatisticsManagerPredownloadThumbPic", false, 0L, 0L, a(l), "");
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPredownloadCountWifi", 0L);
      l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPredownloadCountXG", 0L);
      long l3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPredownloadCount4G", 0L);
      long l4 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCountWifi", 0L);
      long l5 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCountXG", 0L);
      long l6 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCount4G", 0L);
      if (l1 + l4 > 0L) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "PicStatisticsManagerPredownloadDataWifi", false, 0L, 0L, a(i), "");
      }
      if (l3 + l6 > 0L) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "PicStatisticsManagerPredownloadData4g", false, 0L, 0L, a(j), "");
      }
      if (l2 + l5 > 0L) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "PicStatisticsManagerPredownloadDataXg", false, 0L, 0L, a(k), "");
      }
      if (l4 + l5 > 0L)
      {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "PicStatisticsManagerDiffSizePicPreviewC2C", false, 0L, 0L, a(jdField_c_of_type_JavaUtilList), "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "PicStatisticsManagerDiffSizePicPreviewGroup", false, 0L, 0L, a(jdField_d_of_type_JavaUtilList), "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "PicStatisticsManagerDiffSizePicPreviewC2CDynamic", false, 0L, 0L, a(e), "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "PicStatisticsManagerDiffSizePicPreviewGroupDynamic", false, 0L, 0L, a(f), "");
      }
      if (l4 > 0L) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "PicStatisticsManagerPredownloadMissPriorityWifi", false, 0L, 0L, a(g), "");
      }
      if (l5 > 0L) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "PicStatisticsManagerPredownloadMissPriorityXG", false, 0L, 0L, a(h), "");
      }
    }
    long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerSendPicCount", 0L);
    long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerForwardPicCount", 0L);
    HashMap localHashMap1 = a(jdField_a_of_type_JavaUtilList);
    if (l1 + l2 <= 0L) {
      localHashMap1.put("PicStatisticsManagerIsUploadPicActive", "FALSE");
    } else {
      localHashMap1.put("PicStatisticsManagerIsUploadPicActive", "TRUE");
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "PicStatisticsManagerUploadPic", false, 0L, 0L, localHashMap1, "");
    l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerDownloadThumbPicCount", 0L);
    l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerDownloadBigPicCount", 0L);
    HashMap localHashMap2 = a(jdField_b_of_type_JavaUtilList);
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
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
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
        l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("XG_C2C_FLOAT_HIT_COUNT", 0L);
        l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCountXG", 0L);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreviewCountXG", l2 + 1L);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("XG_C2C_FLOAT_HIT_COUNT", l1 + 1L);
      }
      else
      {
        if (paramInt1 != 1) {
          break label250;
        }
        l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("4G_C2C_FLOAT_HIT_COUNT", 0L);
        l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCount4G", 0L);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreviewCount4G", l2 + 1L);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("4G_C2C_FLOAT_HIT_COUNT", l1 + 1L);
      }
      if (Build.VERSION.SDK_INT >= 9)
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
        return;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
      return;
      label250:
      if (QLog.isColorLevel()) {
        QLog.d("PicStatisticsManager", 2, "addPreDownloadBigPicHitCount(): Error, not 3G or 4G, Float hit");
      }
      return;
    }
    a(paramInt1, paramInt2, jdField_b_of_type_Array2dOfJavaLangString, false);
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
    long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str1, 0L) + paramLong;
    long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str2, 0L) + 1L;
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
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str1, l1).putLong(str2, l2).apply();
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str1, l1).putLong(str2, l2).commit();
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
      boolean bool = this.jdField_a_of_type_JavaUtilSet.contains(str);
      if (bool) {
        return;
      }
      this.jdField_a_of_type_JavaUtilSet.add(paramMessageForPic.md5);
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreDownloadThumbPicCount", 0L) + 1L;
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreDownloadThumbPicCount", l1).apply();
      } else {
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreDownloadThumbPicCount", l1).commit();
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
    a(paramInt1, paramInt2, jdField_a_of_type_Array2dOfJavaLangString, true);
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
      int m;
      if (PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramMessageForPic.istroop, paramMessageForPic.frienduin) == 3) {
        m = 1;
      } else {
        m = 0;
      }
      int n = PhotoUtils.a(l1, l2);
      String str1;
      if (n == 0)
      {
        if (m != 0) {
          str1 = "PicStatisticsManagerPicDownloadSizeLongC2C";
        } else {
          str1 = "PicStatisticsManagerPicDownloadSizeLongGroup";
        }
      }
      else if (n == 1)
      {
        if (m != 0) {
          str1 = "PicStatisticsManagerPicDownloadSizeSmallC2C";
        } else {
          str1 = "PicStatisticsManagerPicDownloadSizeSmallGroup";
        }
      }
      else if (n == 2)
      {
        if (m != 0) {
          str1 = "PicStatisticsManagerPicDownloadSizeMiddleC2C";
        } else {
          str1 = "PicStatisticsManagerPicDownloadSizeMiddleGroup";
        }
      }
      else if (n == 3)
      {
        if (m != 0) {
          str1 = "PicStatisticsManagerPicDownloadSizeLargeC2C";
        } else {
          str1 = "PicStatisticsManagerPicDownloadSizeLargeGroup";
        }
      }
      else if (m != 0) {
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
      long l3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str2, 0L) + 1L;
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
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str2, l3).apply();
        return;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str2, l3).commit();
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
    a(paramInt1, paramInt2, jdField_c_of_type_Array2dOfJavaLangString, false);
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
      int m;
      if (PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramMessageForPic.istroop, paramMessageForPic.frienduin) == 3) {
        m = 1;
      } else {
        m = 0;
      }
      int n = PhotoUtils.a(l1, l2);
      String str1;
      if (n == 0)
      {
        if (m != 0) {
          str1 = "PicStatisticsManagerPicPreviewSizeLongC2C";
        } else {
          str1 = "PicStatisticsManagerPicPreviewSizeLongGroup";
        }
      }
      else if (n == 1)
      {
        if (m != 0) {
          str1 = "PicStatisticsManagerPicPreviewSizeSmallC2C";
        } else {
          str1 = "PicStatisticsManagerPicPreviewSizeSmallGroup";
        }
      }
      else if (n == 2)
      {
        if (m != 0) {
          str1 = "PicStatisticsManagerPicPreviewSizeMiddleC2C";
        } else {
          str1 = "PicStatisticsManagerPicPreviewSizeMiddleGroup";
        }
      }
      else if (n == 3)
      {
        if (m != 0) {
          str1 = "PicStatisticsManagerPicPreviewSizeLargeC2C";
        } else {
          str1 = "PicStatisticsManagerPicPreviewSizeLargeGroup";
        }
      }
      else if (m != 0) {
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
      long l3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str2, 0L) + 1L;
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
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str2, l3).apply();
        return;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str2, l3).commit();
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
    a(paramInt1, paramInt2, jdField_d_of_type_Array2dOfJavaLangString, false);
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
    long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str, 0L) + 1L;
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
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, l1).apply();
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, l1).commit();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicStatisticsManager
 * JD-Core Version:    0.7.0.1
 */