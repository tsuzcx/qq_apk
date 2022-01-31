import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.ad.manager.ReadInjoyADExposureManager.1;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONObject;

public class ocq
  implements Manager
{
  public static HashMap<String, Long> a;
  public static HashSet<String> a;
  public static ConcurrentHashMap<String, AdvertisementInfo> a;
  public static HashMap<String, Long> b;
  public static HashSet<String> b;
  private int jdField_a_of_type_Int = -1;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public ocq(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  private void a()
  {
    jdField_a_of_type_JavaUtilHashMap.clear();
    jdField_a_of_type_JavaUtilHashSet.clear();
    ocr.a();
  }
  
  private void a(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3, rqj paramrqj)
  {
    if ((paramrqj == null) || (paramAdvertisementInfo == null)) {}
    do
    {
      return;
      if (!jdField_b_of_type_JavaUtilHashSet.contains(paramAdvertisementInfo.mAdTraceId)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReadInjoyADExposureManager", 2, "checkWebProcess : has already checked!, traceId=" + paramAdvertisementInfo.mAdTraceId);
    return;
    Object localObject = (ReadInJoyXListView)paramrqj.a();
    boolean bool;
    if ((paramInt3 > paramInt1) && (paramInt3 < paramInt2)) {
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoyADExposureManager", 2, "checkWebProcess adVisible=" + bool + ", traceId=" + paramAdvertisementInfo.mAdTraceId);
      }
      if (!bool) {
        break;
      }
      if (!jdField_b_of_type_JavaUtilHashMap.containsKey(paramAdvertisementInfo.mAdTraceId))
      {
        jdField_b_of_type_JavaUtilHashMap.put(paramAdvertisementInfo.mAdTraceId, Long.valueOf(paramrqj.jdField_b_of_type_Long));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadInjoyADExposureManager", 2, "checkWebProcess adVisible startTime");
        return;
        localObject = ((ReadInJoyXListView)localObject).getChildAt(paramInt3 - paramInt1);
        Rect localRect = new Rect();
        ((View)localObject).getGlobalVisibleRect(localRect);
        if (localRect.height() <= 0) {
          break label324;
        }
        bool = true;
        continue;
      }
      if ((!jdField_b_of_type_JavaUtilHashMap.containsKey(paramAdvertisementInfo.mAdTraceId)) || (paramrqj.jdField_b_of_type_Long - ((Long)jdField_b_of_type_JavaUtilHashMap.get(paramAdvertisementInfo.mAdTraceId)).longValue() < 500L)) {
        break;
      }
      beec.b(1);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoyADExposureManager", 2, "checkWebProcess : preloadWebview ! traceId=" + paramAdvertisementInfo.mAdTraceId);
      }
      jdField_b_of_type_JavaUtilHashSet.add(paramAdvertisementInfo.mAdTraceId);
      jdField_b_of_type_JavaUtilHashMap.remove(paramAdvertisementInfo.mAdTraceId);
      return;
      label324:
      bool = false;
    }
  }
  
  private void b()
  {
    jdField_b_of_type_JavaUtilHashMap.clear();
    jdField_b_of_type_JavaUtilHashSet.clear();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Activity paramActivity)
  {
    if ((jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0))
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        if ((localAdvertisementInfo != null) && (oee.a((int)localAdvertisementInfo.mChannelID)))
        {
          int i;
          if (localAdvertisementInfo.mChannelID == 56L) {
            i = noy.M;
          }
          for (;;)
          {
            noy.a(new obk().a(paramActivity).a(noy.l).b(i).a(localAdvertisementInfo).a());
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure invalidADExposureReport report " + str);
            break;
            if (ors.a(localAdvertisementInfo)) {
              i = noy.Q;
            } else {
              i = noy.L;
            }
          }
        }
      }
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  public void a(Context paramContext, int paramInt)
  {
    if ((jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0))
    {
      Object localObject = new HashSet();
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        if ((localAdvertisementInfo != null) && (localAdvertisementInfo.mChannelID == paramInt) && (oee.a((int)localAdvertisementInfo.mChannelID)))
        {
          int i;
          if (localAdvertisementInfo.mChannelID == 56L) {
            i = noy.M;
          }
          for (;;)
          {
            noy.a(new obk().a(paramContext).a(noy.l).b(i).a(localAdvertisementInfo).a());
            if (QLog.isColorLevel()) {
              QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure invalidADExposureReport report " + str + " mChannelID = " + paramInt);
            }
            ((HashSet)localObject).add(str);
            break;
            if (ors.a(localAdvertisementInfo)) {
              i = noy.Q;
            } else {
              i = noy.L;
            }
          }
        }
      }
      paramContext = ((HashSet)localObject).iterator();
      while (paramContext.hasNext())
      {
        localObject = (String)paramContext.next();
        if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject)) {
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject);
        }
      }
    }
  }
  
  public void a(rqj paramrqj, Activity paramActivity, boolean paramBoolean)
  {
    if ((paramrqj == null) || (paramActivity == null)) {}
    List localList;
    do
    {
      return;
      paramActivity = (ReadInJoyXListView)paramrqj.a();
      localList = paramrqj.a();
    } while ((paramActivity == null) || (localList == null));
    int i = paramrqj.a();
    for (;;)
    {
      try
      {
        if ((!oee.a(i)) || (i == 56)) {
          break;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder().append("checkADPullRefreshAction 向下滑动=");
          if (paramBoolean) {
            break label522;
          }
          paramBoolean = true;
          QLog.d("ReadInjoyADExposureManager", 2, paramBoolean);
        }
        int i1 = paramActivity.getHeaderViewsCount();
        int n = paramActivity.getFirstVisiblePosition();
        i = paramActivity.getLastVisiblePosition();
        if (i < n) {
          break;
        }
        if ((i < i1) || (i - i1 >= localList.size())) {
          break label513;
        }
        int i2 = i - i1;
        Object localObject1 = (BaseArticleInfo)localList.get(i2);
        if (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject1)) {
          break label513;
        }
        Object localObject2 = (AdvertisementInfo)localObject1;
        int j = rqj.a((ArticleInfo)localObject2, 0);
        localObject1 = paramrqj.a().getChildAt(i - n);
        if (!(localObject1 instanceof ProteusItemView)) {
          break label513;
        }
        localObject1 = ((ProteusItemView)localObject1).a().getVirtualView();
        paramBoolean = oee.j((AdvertisementInfo)localObject2);
        if ((!paramBoolean) || (j != 117)) {
          break label513;
        }
        int k = n;
        j = 0;
        if (k < i) {
          try
          {
            localObject2 = paramrqj.a().getChildAt(k);
            localObject3 = ((View)localObject2).getLayoutParams();
            if (localObject3 != null)
            {
              m = ((ViewGroup.LayoutParams)localObject3).width;
              ((View)localObject2).measure(ViewGroup.getChildMeasureSpec(paramActivity.getMeasuredWidthAndState(), paramActivity.getPaddingLeft() + paramActivity.getPaddingRight(), m), 0);
              m = ((View)localObject2).getMeasuredHeight();
              k += 1;
              j += m;
              continue;
            }
            int m = -1;
            continue;
            localObject1 = ((ViewBase)localObject1).findViewBaseByName("id_article_triple_image_interact");
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadInjoyADExposureManager", 2, "checkADPullRefreshAction 出现异常:" + localException.getMessage());
            }
          }
        }
        if ((localObject1 == null) || (!(localObject1 instanceof ogw))) {
          break label513;
        }
        ogw localogw = (ogw)localObject1;
        if (((ViewBase)localObject1).getNativeView() == null) {
          break label513;
        }
        Object localObject3 = new Rect();
        ((ViewBase)localObject1).getNativeView().getGlobalVisibleRect((Rect)localObject3);
        paramBoolean = false;
        if (i2 < 4) {
          paramBoolean = true;
        }
        k = ((ViewBase)localObject1).getNativeView().getTop();
        localogw.a(((ViewBase)localObject1).getNativeView().getWidth(), j + k, paramBoolean);
      }
      catch (Exception paramrqj) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInjoyADExposureManager", 2, "checkADPullRefreshAction 出现异常:" + paramrqj.getMessage());
      return;
      label513:
      i -= 1;
      continue;
      label522:
      paramBoolean = false;
    }
  }
  
  public void a(rqj paramrqj, Activity paramActivity, boolean paramBoolean, double paramDouble)
  {
    if ((paramrqj == null) || (paramActivity == null)) {}
    label292:
    label426:
    label1338:
    label1347:
    label1354:
    for (;;)
    {
      return;
      Object localObject1 = (ReadInJoyXListView)paramrqj.a();
      List localList = paramrqj.a();
      int i1 = paramrqj.a();
      if ((localObject1 != null) && (localList != null))
      {
        Object localObject2;
        boolean bool1;
        label83:
        int i2;
        int i3;
        int n;
        int j;
        label124:
        int i4;
        Object localObject4;
        int i;
        Object localObject5;
        Object localObject3;
        int k;
        int m;
        try
        {
          if ((!oee.a(i1)) || (i1 == 56)) {
            continue;
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder().append("checkADScrollAction 向下滑动=");
            if (paramBoolean) {
              break label1296;
            }
            bool1 = true;
            QLog.d("ReadInjoyADExposureManager", 2, bool1);
          }
          i2 = ((ReadInJoyXListView)localObject1).getHeaderViewsCount();
          i3 = ((ReadInJoyXListView)localObject1).getFirstVisiblePosition();
          n = ((ReadInJoyXListView)localObject1).getLastVisiblePosition();
          j = n;
          if (j < i3) {
            break label1314;
          }
          if ((j < i2) || (j - i2 >= localList.size())) {
            break label1287;
          }
          i4 = j - i2;
          localObject2 = (BaseArticleInfo)localList.get(i4);
          if (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) {
            break label1287;
          }
          localObject4 = (AdvertisementInfo)localObject2;
          i = rqj.a((ArticleInfo)localObject4, 0);
          localObject2 = paramrqj.a().getChildAt(j - i3);
          if (((i != 39) && (i != 122)) || (!(localObject2 instanceof ProteusItemView))) {
            break label551;
          }
          localObject5 = ((ProteusItemView)localObject2).a().getVirtualView().findViewBaseByName("id_article_double_image");
          if ((localObject5 == null) || (!(localObject5 instanceof ogr))) {
            break label1287;
          }
          localObject3 = (ogr)localObject5;
          if (!oee.f((AdvertisementInfo)localObject4)) {
            break label426;
          }
          if (i4 >= 4) {
            break label1281;
          }
          bool1 = true;
          i = paramrqj.a().getPaddingTop();
          k = ((View)localObject2).getTop() + ((ViewBase)localObject5).getNativeView().getTop();
          m = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().heightPixels;
          i4 = ((ViewBase)localObject5).getNativeView().getHeight();
          int i5 = aepi.a(50.0F, paramActivity.getResources());
          ((ogr)localObject3).a(((ViewBase)localObject5).getNativeView().getHeight(), m, m - k - i4 - i5, k - i, bool1);
        }
        catch (Exception paramrqj) {}
        if (QLog.isColorLevel())
        {
          QLog.d("ReadInjoyADExposureManager", 2, "checkADScrollAction 出现异常:" + paramrqj.getMessage());
          return;
          if (oee.i((AdvertisementInfo)localObject4))
          {
            i = ((View)localObject2).getTop();
            i4 = ((ViewBase)localObject5).getNativeView().getTop();
            k = ((View)localObject2).getLeft();
            m = ((ViewBase)localObject5).getNativeView().getLeft();
            localObject4 = new int[2];
            ((View)localObject2).getLocationOnScreen((int[])localObject4);
            if (localObject4[1] != 0)
            {
              i = localObject4[1];
              label493:
              ((ogr)localObject3).a(k + m, i, this.jdField_a_of_type_Int, paramDouble);
              break label1287;
            }
          }
          else
          {
            if (oee.l((AdvertisementInfo)localObject4))
            {
              if (i4 - n != 0) {
                break label1302;
              }
              bool1 = true;
              ((ogr)localObject3).a(bool1);
              break label1287;
            }
            ((ogr)localObject3).a();
            break label1287;
            if ((oee.j((AdvertisementInfo)localObject4)) && ((localObject2 instanceof ProteusItemView)))
            {
              localObject3 = ((ProteusItemView)localObject2).a().getVirtualView().findViewBaseByName("id_article_triple_image_interact");
              if ((localObject3 == null) || (!(localObject3 instanceof ogw))) {
                break label1287;
              }
              localObject4 = (ogw)localObject3;
              if (((ViewBase)localObject3).getNativeView() == null) {
                break label1287;
              }
              localObject5 = new Rect();
              ((ViewBase)localObject3).getNativeView().getGlobalVisibleRect((Rect)localObject5);
              bool1 = false;
              if (i4 < 4) {
                bool1 = true;
              }
              k = -1;
              i = k;
              if (bool1)
              {
                boolean bool2 = ((ogw)localObject4).a();
                i = k;
                if (bool2)
                {
                  m = 0;
                  i = k;
                }
              }
              for (;;)
              {
                k = i;
                if (m < i4) {}
                try
                {
                  localObject5 = paramrqj.a().getChildAt(m);
                  ViewGroup.LayoutParams localLayoutParams = ((View)localObject5).getLayoutParams();
                  if (localLayoutParams == null) {
                    break label1308;
                  }
                  i = localLayoutParams.width;
                  label722:
                  ((View)localObject5).measure(ViewGroup.getChildMeasureSpec(((ReadInJoyXListView)localObject1).getMeasuredWidthAndState(), ((ReadInJoyXListView)localObject1).getPaddingLeft() + ((ReadInJoyXListView)localObject1).getPaddingRight(), i), 0);
                  i = k + ((View)localObject5).getMeasuredHeight();
                  m += 1;
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    i = k;
                    if (QLog.isColorLevel())
                    {
                      QLog.d("ReadInjoyADExposureManager", 2, "checkADPullRefreshAction 出现异常:" + localException.getMessage());
                      i = k;
                    }
                  }
                }
              }
              i = ((ViewBase)localObject3).getNativeView().getTop();
              i = k + i;
              k = ((View)localObject2).getTop();
              m = ((ViewBase)localObject3).getNativeView().getTop();
              ((ogw)localObject4).a(((ViewBase)localObject3).getNativeView().getWidth(), ((ViewBase)localObject3).getNativeView().getHeight(), k + m, bool1, i4, i);
              break label1287;
            }
            if ((!oee.k((AdvertisementInfo)localObject4)) || (!(localObject2 instanceof ProteusItemView))) {
              break label1287;
            }
            localObject3 = ((ProteusItemView)localObject2).a().getVirtualView().findViewBaseByName("id_article_brand_optimization");
            if ((localObject3 == null) || (!(localObject3 instanceof ofn))) {
              break label1287;
            }
            localObject4 = (ofn)localObject3;
            if (((ViewBase)localObject3).getNativeView() == null) {
              break label1287;
            }
            i = ((View)localObject2).getTop();
            if (((ViewBase)localObject3).getNativeView().getTop() + i > aepi.a(120.0F, ((View)localObject2).getResources()) + paramrqj.a().getPaddingTop()) {
              break label1287;
            }
            ((ofn)localObject4).b();
            break label1287;
          }
          for (;;)
          {
            if (j <= i) {
              break label1354;
            }
            if ((j >= i2) && (j - i2 < localList.size()))
            {
              paramrqj = (BaseArticleInfo)localList.get(j - i2);
              if (AdvertisementInfo.isAdvertisementInfo(paramrqj))
              {
                paramrqj = (AdvertisementInfo)paramrqj;
                paramActivity = paramrqj.mAdvertisementExtInfo;
                k = i3 - j;
                double d = Math.abs(paramDouble) * 100.0D;
                if ((paramActivity != null) && (paramActivity.a()) && (k == paramActivity.c) && (!paramActivity.jdField_a_of_type_Boolean) && (d < paramActivity.jdField_a_of_type_Int) && (paramrqj.hasAddExposure) && (oee.g(paramrqj)))
                {
                  paramActivity.jdField_a_of_type_Boolean = true;
                  localObject1 = new nnv();
                  ((nnv)localObject1).jdField_a_of_type_Int = paramrqj.mAdMaterialId;
                  ((nnv)localObject1).b = 1;
                  ((nnv)localObject1).c = paramrqj.mAdKdPos;
                  ((nnv)localObject1).jdField_a_of_type_Long = paramrqj.mAdPosID;
                  if (QLog.isColorLevel()) {
                    QLog.d("ReadInjoyADExposureManager", 2, "checkADScrollAction 符合规则触发请求 distance=" + k + ",scrollspeed=" + d + ",adExtInfo=" + paramActivity.toString() + "|" + ((nnv)localObject1).toString());
                  }
                  ThreadManager.executeOnSubThread(new ReadInjoyADExposureManager.1(this, i1, (nnv)localObject1));
                  break label1347;
                  for (;;)
                  {
                    break label1338;
                    i = i4 + i;
                    break label493;
                    bool1 = false;
                    break label292;
                    j -= 1;
                    break label124;
                    bool1 = false;
                    break label83;
                    bool1 = false;
                    break label533;
                    i = -1;
                    break label722;
                    if ((paramBoolean) || (i3 <= 0)) {
                      break;
                    }
                    i = i3 - 10;
                    if (i < 0) {
                      i = 0;
                    }
                  }
                  j = i3 - 1;
                  continue;
                }
              }
            }
            j -= 1;
          }
        }
      }
    }
  }
  
  public void a(rqj paramrqj, Activity paramActivity, boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    if ((paramrqj == null) || (paramActivity == null)) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (ReadInJoyXListView)paramrqj.a();
      paramActivity = paramrqj.a();
    } while ((localObject1 == null) || (paramActivity == null));
    int i = paramrqj.a();
    for (;;)
    {
      int i2;
      try
      {
        if ((!oee.a(i)) || (i == 56)) {
          break;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("checkADPullRefreshAction 向下滑动=");
          if (paramBoolean) {
            break label407;
          }
          paramBoolean = bool;
          QLog.d("ReadInjoyADExposureManager", 2, paramBoolean);
        }
        int k = ((ReadInJoyXListView)localObject1).getHeaderViewsCount();
        int m = ((ReadInJoyXListView)localObject1).getFirstVisiblePosition();
        i = ((ReadInJoyXListView)localObject1).getLastVisiblePosition();
        if (i < m) {
          break;
        }
        if ((i < k) || (i - k >= paramActivity.size())) {
          break label398;
        }
        Object localObject2 = (BaseArticleInfo)paramActivity.get(i - k);
        if (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) {
          break label398;
        }
        j = rqj.a((AdvertisementInfo)localObject2, 0);
        localObject1 = paramrqj.a().getChildAt(i - m);
        if (!(localObject1 instanceof ProteusItemView)) {
          break label398;
        }
        Object localObject3 = ((ProteusItemView)localObject1).a().getVirtualView();
        if ((!oee.i((AdvertisementInfo)localObject2)) || (j != 39)) {
          break label398;
        }
        localObject3 = ((ViewBase)localObject3).findViewBaseByName("id_article_double_image");
        if ((localObject3 == null) || (!(localObject3 instanceof ogr))) {
          break label398;
        }
        localObject2 = (ogr)localObject3;
        j = ((View)localObject1).getTop();
        i2 = ((ViewBase)localObject3).getNativeView().getTop();
        int n = ((View)localObject1).getLeft();
        int i1 = ((ViewBase)localObject3).getNativeView().getLeft();
        localObject3 = new int[2];
        ((View)localObject1).getLocationOnScreen((int[])localObject3);
        if (localObject3[1] == 0) {
          break label385;
        }
        j = localObject3[1];
        ((ogr)localObject2).a(i1 + n, j, this.jdField_a_of_type_Int, 1.0D);
      }
      catch (Exception paramrqj) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInjoyADExposureManager", 2, "checkADPullRefreshAction 出现异常:" + paramrqj.getMessage());
      return;
      label385:
      int j = j + i2 + paramInt;
      continue;
      label398:
      i -= 1;
      continue;
      label407:
      paramBoolean = false;
    }
  }
  
  public boolean a(rqj paramrqj, Activity paramActivity)
  {
    if ((paramrqj == null) || (paramActivity == null)) {
      return false;
    }
    Object localObject1 = (ReadInJoyXListView)paramrqj.a();
    List localList = paramrqj.a();
    int i = paramrqj.a();
    if ((localObject1 == null) || (localList == null)) {
      return false;
    }
    if ((oee.a(i)) && (System.currentTimeMillis() - paramrqj.jdField_b_of_type_Long > bkbq.M(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      paramrqj.jdField_b_of_type_Long = System.currentTimeMillis();
      paramrqj.jdField_a_of_type_JavaUtilHashSet.clear();
      paramrqj.jdField_b_of_type_JavaUtilHashSet.clear();
      int n = ((ReadInJoyXListView)localObject1).getHeaderViewsCount();
      int m = ((ReadInJoyXListView)localObject1).getFirstVisiblePosition();
      int i1 = ((ReadInJoyXListView)localObject1).getLastVisiblePosition();
      int j = m;
      if (j <= i1)
      {
        if ((j < n) || (j - n >= localList.size())) {}
        Object localObject2;
        do
        {
          j += 1;
          break;
          localObject2 = (BaseArticleInfo)localList.get(j - n);
        } while (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2));
        AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localObject2;
        if (oed.f(localAdvertisementInfo)) {
          a(localAdvertisementInfo, m, i1, j, paramrqj);
        }
        for (;;)
        {
          if (!jdField_a_of_type_JavaUtilHashSet.contains(localAdvertisementInfo.mAdTraceId)) {
            break label247;
          }
          localAdvertisementInfo.hasAddExposure = true;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("ReadInjoyADExposureManager", 2, "checkWebProcess enableCheckWebProcess : false.");
          }
        }
        label247:
        i = 0;
        int k;
        if ((j > m) && (j < i1))
        {
          i = 1;
          k = i;
          if (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localAdvertisementInfo.mAdTraceId))
          {
            jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localAdvertisementInfo.mAdTraceId, localAdvertisementInfo);
            k = i;
            if (QLog.isColorLevel())
            {
              QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure invalidADExposureReport add " + localAdvertisementInfo.mAdTraceId);
              k = i;
            }
          }
          label338:
          if (k == 0) {
            break label539;
          }
          if (jdField_a_of_type_JavaUtilHashMap.containsKey(localAdvertisementInfo.mAdTraceId)) {
            break label541;
          }
          jdField_a_of_type_JavaUtilHashMap.put(localAdvertisementInfo.mAdTraceId, Long.valueOf(paramrqj.jdField_b_of_type_Long));
        }
        label539:
        label541:
        while (paramrqj.jdField_b_of_type_Long - ((Long)jdField_a_of_type_JavaUtilHashMap.get(localAdvertisementInfo.mAdTraceId)).longValue() <= 1000L)
        {
          paramrqj.jdField_a_of_type_JavaUtilHashSet.add(localAdvertisementInfo.mAdTraceId);
          break;
          View localView = ((ReadInJoyXListView)localObject1).getChildAt(j - m);
          k = localView.getHeight();
          Rect localRect = new Rect();
          localView.getGlobalVisibleRect(localRect);
          int i2 = localRect.height();
          if (i2 > k >> 1) {
            i = 1;
          }
          k = i;
          if (i2 <= 0) {
            break label338;
          }
          k = i;
          if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localAdvertisementInfo.mAdTraceId)) {
            break label338;
          }
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localAdvertisementInfo.mAdTraceId, localAdvertisementInfo);
          k = i;
          if (!QLog.isColorLevel()) {
            break label338;
          }
          QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure invalidADExposureReport add " + localAdvertisementInfo.mAdTraceId + " visibleHeight = " + i2);
          k = i;
          break label338;
          break;
        }
        if (oee.a((int)localAdvertisementInfo.mChannelID))
        {
          if (localAdvertisementInfo.mChannelID != 56L) {
            break label849;
          }
          i = noy.M;
        }
        for (;;)
        {
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("ad_strategy_type", Integer.valueOf(localAdvertisementInfo.adStrategyType));
          noy.a(new obk().a(paramActivity).a(noy.b).b(i).a(localAdvertisementInfo).e(new JSONObject()).d(noy.a((HashMap)localObject2)).a());
          if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localAdvertisementInfo.mAdTraceId))
          {
            jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localAdvertisementInfo.mAdTraceId);
            if (QLog.isColorLevel()) {
              QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure invalidADExposureReport remove " + localAdvertisementInfo.mAdTraceId);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInjoyADExposureManager", 2, "checkAndReportAdExposure i = " + j + " headerCount = " + n + " firstPos = " + m + " lastPos = " + i1 + " adInfo = " + localAdvertisementInfo.toSString());
          }
          localAdvertisementInfo.hasAddExposure = true;
          jdField_a_of_type_JavaUtilHashSet.add(localAdvertisementInfo.mAdTraceId);
          jdField_a_of_type_JavaUtilHashMap.remove(localAdvertisementInfo.mAdTraceId);
          break;
          label849:
          if (ors.a((BaseArticleInfo)localObject2)) {
            i = noy.Q;
          } else if ((oee.m(localAdvertisementInfo)) && (oek.a().a() == 3)) {
            i = noy.an;
          } else {
            i = noy.L;
          }
        }
      }
      paramActivity = jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (paramActivity.hasNext())
      {
        localObject1 = (String)paramActivity.next();
        if (!paramrqj.jdField_a_of_type_JavaUtilHashSet.contains(localObject1)) {
          paramrqj.jdField_b_of_type_JavaUtilHashSet.add(localObject1);
        }
      }
      paramrqj = paramrqj.jdField_b_of_type_JavaUtilHashSet.iterator();
      while (paramrqj.hasNext())
      {
        paramActivity = (String)paramrqj.next();
        jdField_a_of_type_JavaUtilHashMap.remove(paramActivity);
      }
      return true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    a();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ocq
 * JD-Core Version:    0.7.0.1
 */