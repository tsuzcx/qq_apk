package com.tencent.mobileqq.kandian.biz.fastweb.event;

import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdSwitchService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ItemShowDispatcher
{
  private static String jdField_a_of_type_JavaLangString = "ItemShowDispatcher";
  private SparseArray<ItemShowDispatcher.ItemShowCallback> jdField_a_of_type_AndroidUtilSparseArray;
  private ItemHeightHelper jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper;
  private ItemShowDispatcher.OneSecondCallbackLoop jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher$OneSecondCallbackLoop;
  private Pair<Integer, Integer> jdField_a_of_type_ComTencentUtilPair;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ItemShowDispatcher.1(this);
  private ArrayList<ItemShowDispatcher.AdPostionReportManager> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public HashSet<Integer> a;
  private SparseArray<ItemShowDispatcher.ItemShowCallback> jdField_b_of_type_AndroidUtilSparseArray;
  private Pair<Integer, Integer> jdField_b_of_type_ComTencentUtilPair;
  private ArrayList<ItemShowDispatcher.AdPostionReportManager> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public HashSet<String> b;
  private SparseArray<ItemShowDispatcher.ItemShowCallback> c;
  private SparseArray<ItemShowDispatcher.ItemShowCallback> d;
  
  public ItemShowDispatcher()
  {
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
  }
  
  private float a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt4 >= paramInt1)
    {
      if (paramInt4 > paramInt2 + paramInt1) {
        return 0.0F;
      }
      Object localObject = paramAbsListView.getChildAt(paramInt4 - paramInt1);
      if (localObject == null) {
        return 0.0F;
      }
      try
      {
        paramInt1 = Math.abs(paramAbsListView.getBottom() - ((View)localObject).getTop() - paramAbsListView.getTop());
        paramInt2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper.a(paramInt4);
        if (paramInt1 > 0)
        {
          if (paramInt2 <= 0) {
            return 0.0F;
          }
          return paramInt1 / paramInt2;
        }
        return 0.0F;
      }
      catch (RuntimeException paramAbsListView)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("adPos:");
        ((StringBuilder)localObject).append(paramInt4);
        AIOUtils.a("FastWebActivityCheckAdOutOfBounds", ((StringBuilder)localObject).toString(), paramAbsListView);
      }
    }
    return 0.0F;
  }
  
  private int a(SparseArray<ItemShowDispatcher.ItemShowCallback> paramSparseArray, BaseData paramBaseData)
  {
    if (paramSparseArray == null) {
      return -1;
    }
    int i = 0;
    while (i < paramSparseArray.size())
    {
      if (((ItemShowDispatcher.ItemShowCallback)paramSparseArray.valueAt(i)).a() == paramBaseData) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private ItemShowDispatcher.ItemShowCallback a(int paramInt)
  {
    SparseArray localSparseArray = this.jdField_b_of_type_AndroidUtilSparseArray;
    if ((localSparseArray != null) && (localSparseArray.size() != 0)) {
      return (ItemShowDispatcher.ItemShowCallback)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    }
    return null;
  }
  
  private Pair<Integer, Integer> a(Pair<Integer, Integer> paramPair1, Pair<Integer, Integer> paramPair2)
  {
    if (paramPair1 != null)
    {
      if (paramPair2 == null) {
        return null;
      }
      if (((Integer)paramPair1.second).intValue() >= ((Integer)paramPair2.first).intValue())
      {
        if (((Integer)paramPair1.first).intValue() > ((Integer)paramPair2.second).intValue()) {
          return null;
        }
        Object localObject;
        if (((Integer)paramPair1.first).intValue() > ((Integer)paramPair2.first).intValue()) {
          localObject = paramPair1.first;
        } else {
          localObject = paramPair2.first;
        }
        int i = ((Integer)localObject).intValue();
        if (((Integer)paramPair1.second).intValue() < ((Integer)paramPair2.second).intValue()) {
          paramPair1 = paramPair1.second;
        } else {
          paramPair1 = paramPair2.second;
        }
        return new Pair(Integer.valueOf(i), Integer.valueOf(((Integer)paramPair1).intValue()));
      }
    }
    return null;
  }
  
  private Pair<Integer, Integer> a(AbsListView paramAbsListView)
  {
    int i = paramAbsListView.getFirstVisiblePosition();
    n = paramAbsListView.getLastVisiblePosition();
    int m = n - i;
    k = 0;
    try
    {
      localObject = paramAbsListView.getChildAt(0);
      View localView = paramAbsListView.getChildAt(m);
      i2 = paramAbsListView.getHeight();
      for (j = ((View)localObject).getBottom(); !a(j, this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper.a(i), 50); j = paramAbsListView.getChildAt(k).getBottom())
      {
        k += 1;
        i += 1;
      }
      int i1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper.a(n) - (localView.getBottom() - i2);
      k = n;
      n = i1;
    }
    catch (Exception paramAbsListView)
    {
      for (;;)
      {
        Object localObject;
        int i2;
        int j;
        continue;
        if (n <= 0) {
          if (k >= 0) {}
        }
      }
    }
    if (!a(n, this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper.a(k), 50))
    {
      k -= 1;
      m -= 1;
      localObject = paramAbsListView.getChildAt(m);
      n = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper.a(k) - (((View)localObject).getBottom() - i2);
    }
    else
    {
      paramAbsListView = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" - ");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append("         ");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper.a(i));
      ((StringBuilder)localObject).append("   ");
      ((StringBuilder)localObject).append(n);
      ((StringBuilder)localObject).append("   ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper.a(k));
      QLog.d(paramAbsListView, 2, ((StringBuilder)localObject).toString());
      return new Pair(Integer.valueOf(i), Integer.valueOf(k));
      return null;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnSubThread(new ItemShowDispatcher.CheckAndStartWebProcessRunnable(paramQQAppInterface));
  }
  
  private void a(Pair<Integer, Integer> paramPair)
  {
    if (paramPair != null)
    {
      Object localObject = this.d;
      if (localObject != null)
      {
        if (((SparseArray)localObject).size() == 0) {
          return;
        }
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("show : ");
        localStringBuilder.append(paramPair.first);
        localStringBuilder.append(" ---  ");
        localStringBuilder.append(paramPair.second);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
        localObject = new ArrayList();
        int i = 0;
        while (i < this.d.size())
        {
          int j = this.d.keyAt(i);
          if ((j >= ((Integer)paramPair.first).intValue()) && (j <= ((Integer)paramPair.second).intValue()))
          {
            ((ItemShowDispatcher.ItemShowCallback)this.d.valueAt(i)).a();
            ((List)localObject).add(Integer.valueOf(j));
          }
          i += 1;
        }
        paramPair = ((List)localObject).iterator();
        while (paramPair.hasNext())
        {
          i = ((Integer)paramPair.next()).intValue();
          this.d.remove(i);
        }
        d();
      }
    }
  }
  
  private boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentUtilPair;
    boolean bool2 = false;
    if ((localObject == null) && (this.jdField_b_of_type_ComTencentUtilPair == null)) {
      return false;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      if (((ItemHeightHelper)localObject).a() == 0) {
        return false;
      }
      localObject = this.jdField_a_of_type_AndroidUtilSparseArray;
      if ((localObject == null) || (((SparseArray)localObject).size() == 0))
      {
        localObject = this.d;
        if ((localObject == null) || (((SparseArray)localObject).size() == 0))
        {
          localObject = this.jdField_b_of_type_AndroidUtilSparseArray;
          if ((localObject == null) || (((SparseArray)localObject).size() == 0))
          {
            localObject = this.c;
            bool1 = bool2;
            if (localObject == null) {
              return bool1;
            }
            bool1 = bool2;
            if (((SparseArray)localObject).size() == 0) {
              return bool1;
            }
          }
        }
      }
      bool1 = true;
    }
    return bool1;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        return false;
      }
      bool1 = bool2;
      if (paramInt1 / paramInt2 >= paramInt3 / 100.0F) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean a(BaseData paramBaseData)
  {
    if (paramBaseData == null) {
      return false;
    }
    if (AdData.a(paramBaseData))
    {
      paramBaseData = (AdData)paramBaseData;
      return ((IRIJAdSwitchService)QRoute.api(IRIJAdSwitchService.class)).enableCheckWebProcess(paramBaseData);
    }
    return false;
  }
  
  private ItemShowDispatcher.ItemShowCallback b(int paramInt)
  {
    SparseArray localSparseArray = this.c;
    if ((localSparseArray != null) && (localSparseArray.size() != 0)) {
      return (ItemShowDispatcher.ItemShowCallback)this.c.get(paramInt);
    }
    return null;
  }
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidUtilSparseArray;
    if (localObject != null)
    {
      if (((SparseArray)localObject).size() == 0) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "doAdCallback(all) ");
      }
      localObject = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ItemShowDispatcher.AdPostionReportManager localAdPostionReportManager = (ItemShowDispatcher.AdPostionReportManager)localIterator.next();
        if ((localAdPostionReportManager.jdField_a_of_type_JavaLangLong.longValue() != 0L) && (System.currentTimeMillis() - localAdPostionReportManager.jdField_a_of_type_JavaLangLong.longValue() >= 1000L))
        {
          localAdPostionReportManager.jdField_a_of_type_Long = (System.currentTimeMillis() - localAdPostionReportManager.jdField_a_of_type_JavaLangLong.longValue());
          ((ArrayList)localObject).add(Integer.valueOf(localAdPostionReportManager.jdField_a_of_type_Int));
          if (QLog.isColorLevel())
          {
            String str = jdField_a_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("time is out , need report ,ad pos is =");
            localStringBuilder.append(localAdPostionReportManager.jdField_a_of_type_Int);
            localStringBuilder.append("  show time=");
            localStringBuilder.append(localAdPostionReportManager.jdField_a_of_type_JavaLangLong);
            QLog.d(str, 2, localStringBuilder.toString());
          }
        }
      }
      if (((ArrayList)localObject).size() > 0) {
        b((ArrayList)localObject);
      }
    }
  }
  
  private void b(AbsListView paramAbsListView, int paramInt)
  {
    a(a(a(paramAbsListView), this.jdField_b_of_type_ComTencentUtilPair));
  }
  
  private void b(ArrayList<Integer> paramArrayList)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidUtilSparseArray;
    if (localObject1 != null)
    {
      if (((SparseArray)localObject1).size() == 0) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, " (ArrayList<Integer> adPositionlist) ");
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (Integer)paramArrayList.next();
        Object localObject2 = (ItemShowDispatcher.ItemShowCallback)this.jdField_a_of_type_AndroidUtilSparseArray.get(((Integer)localObject1).intValue());
        if (localObject2 != null)
        {
          Object localObject3;
          if (QLog.isColorLevel())
          {
            localObject3 = jdField_a_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("doAdCallback(ArrayList<Integer> adPositionlist) pos=");
            localStringBuilder.append(localObject1);
            QLog.d((String)localObject3, 2, localStringBuilder.toString());
          }
          ((ItemShowDispatcher.ItemShowCallback)localObject2).a();
          this.jdField_a_of_type_AndroidUtilSparseArray.remove(((Integer)localObject1).intValue());
          localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (ItemShowDispatcher.AdPostionReportManager)((Iterator)localObject2).next();
            if ((localObject3 != null) && (((ItemShowDispatcher.AdPostionReportManager)localObject3).jdField_a_of_type_Int == ((Integer)localObject1).intValue())) {
              this.jdField_a_of_type_JavaUtilArrayList.remove(localObject3);
            }
          }
          if (this.jdField_a_of_type_JavaUtilHashSet.contains(localObject1))
          {
            this.jdField_a_of_type_JavaUtilHashSet.remove(localObject1);
            if (QLog.isColorLevel())
            {
              localObject2 = jdField_a_of_type_JavaLangString;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("invalidADExposurePos remove ");
              ((StringBuilder)localObject3).append(localObject1);
              QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
            }
          }
        }
      }
    }
  }
  
  private void c()
  {
    SparseArray localSparseArray = this.jdField_a_of_type_AndroidUtilSparseArray;
    int j = 2147483647;
    int i = -1;
    int m = j;
    int n = i;
    if (localSparseArray != null)
    {
      int k = 0;
      for (;;)
      {
        m = j;
        n = i;
        if (k >= this.jdField_a_of_type_AndroidUtilSparseArray.size()) {
          break;
        }
        n = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(k);
        m = j;
        if (n < j) {
          m = n;
        }
        int i1 = i;
        if (n > i) {
          i1 = n;
        }
        k += 1;
        j = m;
        i = i1;
      }
    }
    this.jdField_a_of_type_ComTencentUtilPair = new Pair(Integer.valueOf(m), Integer.valueOf(n));
  }
  
  private void d()
  {
    SparseArray localSparseArray = this.d;
    int j = 2147483647;
    int i = -1;
    int m = j;
    int n = i;
    if (localSparseArray != null)
    {
      int k = 0;
      for (;;)
      {
        m = j;
        n = i;
        if (k >= this.d.size()) {
          break;
        }
        n = this.d.keyAt(k);
        m = j;
        if (n < j) {
          m = n;
        }
        int i1 = i;
        if (n > i) {
          i1 = n;
        }
        k += 1;
        j = m;
        i = i1;
      }
    }
    this.jdField_b_of_type_ComTencentUtilPair = new Pair(Integer.valueOf(m), Integer.valueOf(n));
  }
  
  public ItemShowDispatcher.AdPostionReportManager a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
    Object localObject2 = null;
    if (localObject1 == null) {
      return null;
    }
    Iterator localIterator = ((ArrayList)localObject1).iterator();
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (ItemShowDispatcher.AdPostionReportManager)localIterator.next();
    } while (((ItemShowDispatcher.AdPostionReportManager)localObject1).jdField_a_of_type_Int != paramInt);
    return localObject1;
  }
  
  public void a()
  {
    SparseArray localSparseArray = this.jdField_a_of_type_AndroidUtilSparseArray;
    if (localSparseArray != null) {
      localSparseArray.clear();
    }
    localSparseArray = this.d;
    if (localSparseArray != null) {
      localSparseArray.clear();
    }
    localSparseArray = this.jdField_b_of_type_AndroidUtilSparseArray;
    if (localSparseArray != null) {
      localSparseArray.clear();
    }
    localSparseArray = this.c;
    if (localSparseArray != null) {
      localSparseArray.clear();
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher$OneSecondCallbackLoop != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher$OneSecondCallbackLoop);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      Object localObject = this.d;
      int i;
      if (localObject != null)
      {
        ((SparseArray)localObject).remove(paramInt1);
        i = paramInt1 + 1;
        while (i < paramInt2)
        {
          localObject = (ItemShowDispatcher.ItemShowCallback)this.d.get(i);
          if (localObject != null)
          {
            this.d.delete(i);
            this.d.put(i - 1, localObject);
          }
          i += 1;
        }
      }
      localObject = this.jdField_a_of_type_AndroidUtilSparseArray;
      if (localObject != null)
      {
        ((SparseArray)localObject).remove(paramInt1);
        i = paramInt1 + 1;
        while (i < paramInt2)
        {
          localObject = (ItemShowDispatcher.ItemShowCallback)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
          if (localObject != null)
          {
            this.jdField_a_of_type_AndroidUtilSparseArray.delete(i);
            this.jdField_a_of_type_AndroidUtilSparseArray.put(i - 1, localObject);
          }
          i += 1;
        }
      }
      localObject = this.jdField_b_of_type_AndroidUtilSparseArray;
      if (localObject != null)
      {
        ((SparseArray)localObject).remove(paramInt1);
        i = paramInt1 + 1;
        while (i < paramInt2)
        {
          localObject = (ItemShowDispatcher.ItemShowCallback)this.jdField_b_of_type_AndroidUtilSparseArray.get(i);
          if (localObject != null)
          {
            this.jdField_b_of_type_AndroidUtilSparseArray.delete(i);
            this.jdField_b_of_type_AndroidUtilSparseArray.put(i - 1, localObject);
          }
          i += 1;
        }
      }
      localObject = this.c;
      if (localObject != null)
      {
        ((SparseArray)localObject).remove(paramInt1);
        i = paramInt1 + 1;
        while (i < paramInt2)
        {
          localObject = (ItemShowDispatcher.ItemShowCallback)this.c.get(i);
          if (localObject != null)
          {
            this.c.delete(i);
            this.c.put(i - 1, localObject);
          }
          i += 1;
        }
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList;
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ItemShowDispatcher.AdPostionReportManager localAdPostionReportManager = (ItemShowDispatcher.AdPostionReportManager)((Iterator)localObject).next();
          if (localAdPostionReportManager.jdField_a_of_type_Int == paramInt1) {
            ((Iterator)localObject).remove();
          } else if (localAdPostionReportManager.jdField_a_of_type_Int > paramInt1) {
            localAdPostionReportManager.jdField_a_of_type_Int -= 1;
          }
        }
      }
    }
  }
  
  public void a(int paramInt, ItemShowDispatcher.ItemShowCallback paramItemShowCallback)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    if (this.jdField_b_of_type_AndroidUtilSparseArray == null) {
      this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    if (this.c == null) {
      this.c = new SparseArray();
    }
    int i = a(this.jdField_a_of_type_AndroidUtilSparseArray, paramItemShowCallback.a());
    if (i >= 0)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(i);
      this.jdField_b_of_type_AndroidUtilSparseArray.remove(i);
      this.c.remove(i);
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramItemShowCallback);
    this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt, paramItemShowCallback);
    this.c.put(paramInt, paramItemShowCallback);
    c();
  }
  
  public void a(QQAppInterface paramQQAppInterface, AbsListView paramAbsListView, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ItemShowDispatcher.AdPostionReportManager)localIterator.next();
      AdData localAdData = (AdData)((ItemShowDispatcher.AdPostionReportManager)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData;
      if ((localAdData != null) && (a(((ItemShowDispatcher.AdPostionReportManager)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData)) && (!this.jdField_b_of_type_JavaUtilHashSet.contains(localAdData.u)) && (a(paramAbsListView, paramInt1, paramInt2, ((ItemShowDispatcher.AdPostionReportManager)localObject).jdField_a_of_type_Int)))
      {
        StringBuilder localStringBuilder;
        if (((ItemShowDispatcher.AdPostionReportManager)localObject).b == 0L)
        {
          ((ItemShowDispatcher.AdPostionReportManager)localObject).b = System.currentTimeMillis();
          if (QLog.isColorLevel())
          {
            localObject = jdField_a_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkWebProcess set start time=, traceId=");
            localStringBuilder.append(localAdData.u);
            QLog.d((String)localObject, 2, localStringBuilder.toString());
          }
        }
        else if (System.currentTimeMillis() - ((ItemShowDispatcher.AdPostionReportManager)localObject).b >= 500L)
        {
          this.jdField_b_of_type_JavaUtilHashSet.add(localAdData.u);
          a(paramQQAppInterface);
          if (QLog.isColorLevel())
          {
            localObject = jdField_a_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkWebProcess CHECK WebViwe! traceId=");
            localStringBuilder.append(localAdData.u);
            QLog.d((String)localObject, 2, localStringBuilder.toString());
          }
        }
      }
    }
  }
  
  public void a(ItemHeightHelper paramItemHeightHelper)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper = paramItemHeightHelper;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    QLog.d(str, 2, localStringBuilder.toString());
    if (!a()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher$OneSecondCallbackLoop == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemShowDispatcher$OneSecondCallbackLoop = new ItemShowDispatcher.OneSecondCallbackLoop(this, paramAbsListView, paramInt);
    }
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      b(paramAbsListView, paramInt);
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    b(paramAbsListView, paramInt);
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!a()) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ItemShowDispatcher.AdPostionReportManager localAdPostionReportManager = (ItemShowDispatcher.AdPostionReportManager)localIterator.next();
      Object localObject = a(localAdPostionReportManager.jdField_a_of_type_Int);
      if ((localObject != null) && (a(paramAbsListView, paramInt1, paramInt2, paramInt3, localAdPostionReportManager.jdField_a_of_type_Int, ((ItemShowDispatcher.ItemShowCallback)localObject).a())))
      {
        ((ItemShowDispatcher.ItemShowCallback)localObject).c();
        this.jdField_b_of_type_AndroidUtilSparseArray.remove(localAdPostionReportManager.jdField_a_of_type_Int);
      }
      localObject = b(localAdPostionReportManager.jdField_a_of_type_Int);
      if ((localObject != null) && (a(paramAbsListView, paramInt1, paramInt2, paramInt3, localAdPostionReportManager.jdField_a_of_type_Int, 1)))
      {
        ((ItemShowDispatcher.ItemShowCallback)localObject).b();
        this.c.remove(localAdPostionReportManager.jdField_a_of_type_Int);
      }
      if (a(paramAbsListView, paramInt1, paramInt2, paramInt3, localAdPostionReportManager.jdField_a_of_type_Int, 50))
      {
        if ((localAdPostionReportManager.jdField_a_of_type_JavaLangLong.longValue() != 0L) && (System.currentTimeMillis() - localAdPostionReportManager.jdField_a_of_type_JavaLangLong.longValue() >= 1000L))
        {
          localArrayList.add(Integer.valueOf(localAdPostionReportManager.jdField_a_of_type_Int));
          localAdPostionReportManager.jdField_a_of_type_Long = (System.currentTimeMillis() - localAdPostionReportManager.jdField_a_of_type_JavaLangLong.longValue());
          localAdPostionReportManager.jdField_a_of_type_Float = a(paramAbsListView, paramInt1, paramInt2, paramInt3, localAdPostionReportManager.jdField_a_of_type_Int);
          if (QLog.isColorLevel())
          {
            localObject = jdField_a_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("need report ,ad pos is =");
            localStringBuilder.append(localAdPostionReportManager.jdField_a_of_type_Int);
            localStringBuilder.append("  show time=");
            localStringBuilder.append(localAdPostionReportManager.jdField_a_of_type_JavaLangLong);
            localStringBuilder.append(" exposureTime = ");
            localStringBuilder.append(localAdPostionReportManager.jdField_a_of_type_Long);
            localStringBuilder.append(" exposureArea = ");
            localStringBuilder.append(localAdPostionReportManager.jdField_a_of_type_Float);
            QLog.d((String)localObject, 2, localStringBuilder.toString());
          }
        }
        else if (localAdPostionReportManager.jdField_a_of_type_JavaLangLong.longValue() == 0L)
        {
          localAdPostionReportManager.jdField_a_of_type_Float = a(paramAbsListView, paramInt1, paramInt2, paramInt3, localAdPostionReportManager.jdField_a_of_type_Int);
          localAdPostionReportManager.jdField_a_of_type_JavaLangLong = Long.valueOf(System.currentTimeMillis());
        }
      }
      else {
        localAdPostionReportManager.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
      }
    }
    if (localArrayList.size() > 0) {
      b(localArrayList);
    }
  }
  
  public void a(ArrayList<ItemShowDispatcher.AdPostionReportManager> paramArrayList)
  {
    Iterator localIterator1 = paramArrayList.iterator();
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        break label125;
      }
      ItemShowDispatcher.AdPostionReportManager localAdPostionReportManager1 = (ItemShowDispatcher.AdPostionReportManager)localIterator1.next();
      Iterator localIterator2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      ItemShowDispatcher.AdPostionReportManager localAdPostionReportManager2;
      while (localIterator2.hasNext())
      {
        localAdPostionReportManager2 = (ItemShowDispatcher.AdPostionReportManager)localIterator2.next();
        if (localAdPostionReportManager1.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData == localAdPostionReportManager2.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData) {
          localAdPostionReportManager1.a(localAdPostionReportManager2);
        }
      }
      localIterator2 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      if (localIterator2.hasNext())
      {
        localAdPostionReportManager2 = (ItemShowDispatcher.AdPostionReportManager)localIterator2.next();
        if (localAdPostionReportManager1.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData != localAdPostionReportManager2.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData) {
          break;
        }
        localAdPostionReportManager1.a(localAdPostionReportManager2);
      }
    }
    label125:
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.addAll(paramArrayList);
  }
  
  public boolean a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    if (paramInt3 >= paramInt1)
    {
      if (paramInt3 > paramInt2 + paramInt1) {
        return false;
      }
      Object localObject = paramAbsListView.getChildAt(paramInt3 - paramInt1);
      if (localObject == null) {
        return false;
      }
      try
      {
        paramInt1 = Math.abs(paramAbsListView.getBottom() - ((View)localObject).getTop() - paramAbsListView.getTop());
        if (paramInt1 > 0) {
          bool = true;
        }
        return bool;
      }
      catch (RuntimeException paramAbsListView)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("adPos:");
        ((StringBuilder)localObject).append(paramInt3);
        AIOUtils.a("FastWebActivityCheckAdOutOfBounds", ((StringBuilder)localObject).toString(), paramAbsListView);
      }
    }
    return false;
  }
  
  public boolean a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt4 >= paramInt1)
    {
      if (paramInt4 > paramInt2 + paramInt1) {
        return false;
      }
      Object localObject = paramAbsListView.getChildAt(paramInt4 - paramInt1);
      if (localObject == null) {
        return false;
      }
      try
      {
        paramInt1 = Math.abs(paramAbsListView.getBottom() - ((View)localObject).getTop() - paramAbsListView.getTop());
        if ((paramInt1 > 0) && (!this.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramInt4))))
        {
          this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(paramInt4));
          if (QLog.isColorLevel())
          {
            String str = jdField_a_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("invalidADExposurePos add ");
            localStringBuilder.append(paramInt4);
            localStringBuilder.append(" showHeight = ");
            localStringBuilder.append(paramInt1);
            localStringBuilder.append(" viewHeight = ");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper.a(paramInt4));
            QLog.d(str, 2, localStringBuilder.toString());
          }
        }
        boolean bool = a(Math.abs(paramAbsListView.getBottom() - ((View)localObject).getTop() - paramAbsListView.getTop()), this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEventItemHeightHelper.a(paramInt4), paramInt5);
        return bool;
      }
      catch (RuntimeException paramAbsListView)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("adPos:");
        ((StringBuilder)localObject).append(paramInt4);
        AIOUtils.a("FastWebActivityCheckAdOutOfBounds", ((StringBuilder)localObject).toString(), paramAbsListView);
      }
    }
    return false;
  }
  
  public void b(int paramInt, ItemShowDispatcher.ItemShowCallback paramItemShowCallback)
  {
    if (this.d == null) {
      this.d = new SparseArray();
    }
    int i = a(this.d, paramItemShowCallback.a());
    if (i >= 0) {
      this.d.remove(i);
    }
    this.d.put(paramInt, paramItemShowCallback);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.event.ItemShowDispatcher
 * JD-Core Version:    0.7.0.1
 */