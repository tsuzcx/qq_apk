package com.tencent.mobileqq.kandian.biz.framework;

import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.utils.ReadinjoySensorUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.util.WeakReference;

public class UserActionCollector
{
  public static double a = 0.5D;
  public static int a = 5;
  private static volatile UserActionCollector jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector;
  public static String a = "sp_mix_feature_click_info";
  public static int b = 20;
  public static String b = "sp_mix_feature_scroll_info";
  public static int c = 10;
  public static int d = 1;
  public static int e = 2;
  public static int f = 3;
  public static int g = 4;
  public long a;
  public UserActionCollector.OnScrollChangeListenerWrapper a;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public HashMap<String, Long> a;
  public List<UserActionCollector.FeedExpInfo> a;
  private WeakReference<AbsListView> jdField_a_of_type_MqqUtilWeakReference;
  public boolean a;
  public int[] a;
  public long b;
  private HashMap<String, Integer> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  public List<UserActionCollector.GestureEvent> b;
  private boolean jdField_b_of_type_Boolean = false;
  private int[] jdField_b_of_type_ArrayOfInt;
  public long c;
  private String c;
  private long d = 0L;
  private long e;
  private long f;
  private long g = -1L;
  public int h;
  public int i = 0;
  private int j = 0;
  
  private UserActionCollector()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector$OnScrollChangeListenerWrapper = new UserActionCollector.OnScrollChangeListenerWrapper(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    this.jdField_a_of_type_Boolean = false;
    boolean bool;
    if (Aladdin.getConfig(234).getIntegerFromString("fbs_enable", 0) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_b_of_type_Boolean = bool;
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    try
    {
      String str = (String)RIJSPUtils.a(jdField_a_of_type_JavaLangString, "");
      bool = TextUtils.isEmpty(str);
      if (!bool)
      {
        localObject1 = str.split("_");
        int m = localObject1.length;
        int k = 0;
        while (k < m)
        {
          localObject2 = localObject1[k];
          this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf((String)localObject2));
          k += 1;
        }
      }
      Object localObject1 = (String)RIJSPUtils.a(jdField_b_of_type_JavaLangString, "");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).split("_").length == 4))
      {
        localObject2 = ((String)localObject1).split("_");
        this.jdField_b_of_type_ArrayOfInt = new int[4];
        this.jdField_b_of_type_ArrayOfInt[0] = Integer.valueOf(localObject2[0]).intValue();
        this.jdField_b_of_type_ArrayOfInt[1] = Integer.valueOf(localObject2[1]).intValue();
        this.jdField_b_of_type_ArrayOfInt[2] = Integer.valueOf(localObject2[2]).intValue();
        this.jdField_b_of_type_ArrayOfInt[3] = Integer.valueOf(localObject2[3]).intValue();
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("clickStr : ");
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append(", scrollStr : ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("UserActionCollector", 1, ((StringBuilder)localObject2).toString());
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      RIJSPUtils.a(jdField_a_of_type_JavaLangString, "");
      RIJSPUtils.a(jdField_b_of_type_JavaLangString, "");
    }
  }
  
  private int a(View paramView, int paramInt)
  {
    int k = paramView.getHeight();
    double d1 = paramView.getTop();
    double d2 = k;
    double d3 = jdField_a_of_type_Double;
    Double.isNaN(d2);
    Double.isNaN(d1);
    k = (int)(d1 + d2 * d3);
    if (k <= paramInt)
    {
      paramInt = k;
      if (k > 0) {}
    }
    else
    {
      paramInt = -1;
    }
    return paramInt;
  }
  
  private UserActionCollector.FeedExpInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = (Integer)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() <= paramString.intValue()) {
        return null;
      }
      try
      {
        paramString = (UserActionCollector.FeedExpInfo)this.jdField_a_of_type_JavaUtilList.get(paramString.intValue());
        return paramString;
      }
      catch (IndexOutOfBoundsException paramString)
      {
        QLog.e("UserActionCollector", 1, paramString, new Object[0]);
      }
    }
    return null;
  }
  
  public static UserActionCollector a()
  {
    if (jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector == null) {
          jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector = new UserActionCollector();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector;
  }
  
  private Object a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramAbsListView != null) && (paramInt >= 0))
    {
      if (paramAbsListView.getAdapter() == null) {
        return null;
      }
      paramAbsListView = paramAbsListView.getAdapter();
      if (paramInt >= paramAbsListView.getCount()) {
        return null;
      }
      try
      {
        paramAbsListView = paramAbsListView.getItem(paramInt);
        return paramAbsListView;
      }
      catch (Exception paramAbsListView)
      {
        paramAbsListView.printStackTrace();
      }
    }
    return null;
  }
  
  private String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    String str = paramAbsBaseArticleInfo.innerUniqueID;
    Object localObject = str;
    if (TextUtils.isEmpty(str))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AD_");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mTitle);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  private void a(AbsListView paramAbsListView, boolean paramBoolean)
  {
    if (paramAbsListView == null) {
      return;
    }
    int n = paramAbsListView.getFirstVisiblePosition();
    long l1;
    if (this.g != -1L)
    {
      l1 = System.currentTimeMillis();
      l2 = this.g;
    }
    else
    {
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
    }
    long l2 = l1 - l2;
    int k = 0;
    while (k < paramAbsListView.getChildCount())
    {
      Object localObject1 = a(paramAbsListView, n + k);
      View localView = paramAbsListView.getChildAt(k);
      if (((localObject1 instanceof BaseArticleInfo)) && (localView != null))
      {
        int i1 = a(localView, paramAbsListView.getHeight());
        Object localObject2 = (AbsBaseArticleInfo)localObject1;
        String str = a((AbsBaseArticleInfo)localObject2);
        localObject1 = a(str);
        if (localObject1 == null)
        {
          localObject1 = new UserActionCollector.FeedExpInfo(this);
          ((UserActionCollector.FeedExpInfo)localObject1).jdField_a_of_type_JavaLangString = str;
          ((UserActionCollector.FeedExpInfo)localObject1).jdField_a_of_type_Int = RIJFeedsType.a((AbsBaseArticleInfo)localObject2);
          if (TextUtils.isEmpty(((AbsBaseArticleInfo)localObject2).mTitle)) {
            m = 0;
          } else {
            m = ((AbsBaseArticleInfo)localObject2).mTitle.length();
          }
          ((UserActionCollector.FeedExpInfo)localObject1).jdField_b_of_type_Int = m;
          boolean bool;
          if (this.g == -1L) {
            bool = true;
          } else {
            bool = false;
          }
          ((UserActionCollector.FeedExpInfo)localObject1).jdField_a_of_type_Boolean = bool;
          ((UserActionCollector.FeedExpInfo)localObject1).jdField_c_of_type_Int = localView.getHeight();
          ((UserActionCollector.FeedExpInfo)localObject1).jdField_b_of_type_JavaLangString = ((AbsBaseArticleInfo)localObject2).mRecommentdReason;
          int m = this.j;
          this.j = (m + 1);
          ((UserActionCollector.FeedExpInfo)localObject1).d = m;
          localObject2 = ReadinjoySensorUtils.a().a();
          if ((localObject2 != null) && (localObject2.length == 4))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(localObject2[0]);
            localStringBuilder.append("_");
            localStringBuilder.append(localObject2[1]);
            localStringBuilder.append("_");
            localStringBuilder.append(localObject2[2]);
            localStringBuilder.append("_");
            localStringBuilder.append(localObject2[3]);
            ((UserActionCollector.FeedExpInfo)localObject1).jdField_c_of_type_JavaLangString = localStringBuilder.toString();
          }
          else
          {
            ((UserActionCollector.FeedExpInfo)localObject1).jdField_c_of_type_JavaLangString = "NULL";
          }
          this.jdField_a_of_type_JavaUtilList.add(localObject1);
          this.jdField_b_of_type_JavaUtilHashMap.put(str, Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size() - 1));
        }
        long l3 = ((UserActionCollector.FeedExpInfo)localObject1).jdField_b_of_type_Long;
        if (i1 > 0) {
          l1 = l2;
        } else {
          l1 = 0L;
        }
        ((UserActionCollector.FeedExpInfo)localObject1).jdField_b_of_type_Long = (l3 + l1);
        localObject2 = a(localView);
        if (localObject2 != null)
        {
          double d1 = localObject2[1] - localObject2[0];
          double d2 = localView.getHeight();
          double d3 = jdField_a_of_type_Double;
          Double.isNaN(d2);
          if (d1 >= d2 * d3) {
            ((UserActionCollector.FeedExpInfo)localObject1).jdField_c_of_type_Long += l2;
          }
        }
        ((UserActionCollector.FeedExpInfo)localObject1).jdField_c_of_type_Boolean = this.jdField_a_of_type_JavaUtilHashMap.containsKey(str);
        if (paramBoolean) {
          ((UserActionCollector.FeedExpInfo)localObject1).jdField_b_of_type_Boolean = true;
        }
      }
      k += 1;
    }
    this.g = System.currentTimeMillis();
  }
  
  private int[] a(View paramView)
  {
    int[] arrayOfInt = a();
    int k;
    if (paramView.getTop() < 0) {
      k = 0;
    } else {
      k = paramView.getTop();
    }
    int n = paramView.getBottom();
    int m = this.i;
    if (n <= m) {
      m = paramView.getBottom();
    }
    if ((m > arrayOfInt[0]) && (arrayOfInt[1] > k)) {
      return new int[] { Math.max(k, arrayOfInt[0]), Math.min(m, arrayOfInt[1]) };
    }
    return null;
  }
  
  private void e()
  {
    Object localObject = this.jdField_b_of_type_ArrayOfInt;
    int k = 0;
    if (localObject != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ArrayOfInt[0]);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ArrayOfInt[1]);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ArrayOfInt[2]);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ArrayOfInt[3]);
      localObject = ((StringBuilder)localObject).toString();
      RIJSPUtils.a(jdField_b_of_type_JavaLangString, localObject);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > jdField_b_of_type_Int) {
        k = this.jdField_a_of_type_JavaUtilArrayList.size() - jdField_b_of_type_Int;
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList;
      localObject = TextUtils.join("_", ((ArrayList)localObject).subList(k, ((ArrayList)localObject).size()));
      RIJSPUtils.a(jdField_a_of_type_JavaLangString, localObject);
    }
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector$OnScrollChangeListenerWrapper.jdField_a_of_type_Long == 0L) {
      return this.e;
    }
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector$OnScrollChangeListenerWrapper.jdField_a_of_type_Long - this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Long != 0L) && (this.f != 0L))
    {
      if (!this.jdField_b_of_type_Boolean) {
        return;
      }
      long l = System.currentTimeMillis() - this.f;
      this.e += l;
      if (this.d != 0L)
      {
        UserActionCollector.FeedExpInfo localFeedExpInfo = a(this.jdField_c_of_type_JavaLangString);
        if (localFeedExpInfo != null) {
          localFeedExpInfo.jdField_a_of_type_Long += l;
        }
        this.d = 0L;
        this.jdField_c_of_type_JavaLangString = null;
      }
      this.f = 0L;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterBusiness, from : ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", scene : ");
    localStringBuilder.append(paramInt2);
    QLog.d("UserActionCollector", 1, localStringBuilder.toString());
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.h = paramInt1;
    this.jdField_b_of_type_Long = paramInt2;
    ReadinjoySensorUtils.a().a();
  }
  
  public void a(View paramView, AbsListView paramAbsListView, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((this.jdField_a_of_type_Long != 0L) && (paramAbsBaseArticleInfo != null))
    {
      if (!this.jdField_b_of_type_Boolean) {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      paramView = a(paramAbsBaseArticleInfo);
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramView)) {
        this.jdField_a_of_type_JavaUtilHashMap.put(paramView, Long.valueOf(0L));
      }
      paramAbsBaseArticleInfo = new float[2];
      Object localObject = (ReadInJoyXListView)paramAbsListView;
      paramAbsBaseArticleInfo[0] = localObject.b[0];
      paramAbsBaseArticleInfo[1] = (localObject.b[1] - paramAbsListView.getPaddingTop());
      paramAbsListView = new UserActionCollector.GestureEvent(this);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((int)paramAbsBaseArticleInfo[0]);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append((int)paramAbsBaseArticleInfo[1]);
      paramAbsListView.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      this.jdField_b_of_type_JavaUtilList.add(paramAbsListView);
      if (paramAbsBaseArticleInfo[1] > 0.0F) {
        this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf((int)paramAbsBaseArticleInfo[1]));
      }
      this.jdField_c_of_type_JavaLangString = paramView;
      this.d = System.currentTimeMillis();
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView != null)
    {
      Object localObject = this.jdField_a_of_type_MqqUtilWeakReference;
      if ((localObject == null) || (paramAbsListView != ((WeakReference)localObject).get()))
      {
        if (!this.jdField_b_of_type_Boolean) {
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("register listview : ");
        ((StringBuilder)localObject).append(paramAbsListView);
        QLog.d("UserActionCollector", 1, ((StringBuilder)localObject).toString());
        this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAbsListView);
        this.i = ScreenUtil.getInstantScreenHeight(paramAbsListView.getContext());
        ((ReadInJoyXListView)paramAbsListView).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector$OnScrollChangeListenerWrapper);
        paramAbsListView.post(new UserActionCollector.1(this, paramInt, paramAbsListView));
      }
    }
  }
  
  public int[] a()
  {
    if (this.g != 0L)
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      if (arrayOfInt != null) {
        return arrayOfInt;
      }
    }
    return new int[] { 0, (int)(this.i * 2 / 3.0F) };
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector$OnScrollChangeListenerWrapper.jdField_b_of_type_Long == 0L) {
      return this.e;
    }
    return this.jdField_c_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector$OnScrollChangeListenerWrapper.jdField_b_of_type_Long;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Long != 0L)
    {
      if (!this.jdField_b_of_type_Boolean) {
        return;
      }
      this.f = System.currentTimeMillis();
      Object localObject = this.jdField_a_of_type_MqqUtilWeakReference;
      if (localObject != null) {
        localObject = (AbsListView)((WeakReference)localObject).get();
      } else {
        localObject = null;
      }
      a((AbsListView)localObject, false);
    }
  }
  
  public long c()
  {
    return this.e;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_MqqUtilWeakReference != null))
    {
      if (!this.jdField_b_of_type_Boolean) {
        return;
      }
      QLog.d("UserActionCollector", 1, "exitBusiness !");
      ReadinjoySensorUtils.a().b();
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      this.e = (this.jdField_c_of_type_Long - this.jdField_a_of_type_Long - this.e);
      a((AbsListView)this.jdField_a_of_type_MqqUtilWeakReference.get(), true);
      new UserOperationModule().reportMixFeatureUserActionData(this, BaseApplication.getContext());
      e();
      this.jdField_a_of_type_MqqUtilWeakReference = null;
      jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkUserActionCollector = null;
    }
  }
  
  public void d()
  {
    int i4 = 2;
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    int k;
    int m;
    int n;
    int i1;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < jdField_a_of_type_Int)
    {
      localObject = this.jdField_b_of_type_ArrayOfInt;
      if (localObject == null)
      {
        localObject = this.jdField_a_of_type_ArrayOfInt;
        localObject[0] = 0;
        localObject[1] = ((int)(this.i * 2 / 3.0F));
        k = 0;
      }
      else
      {
        k = (int)(Math.min(localObject[1], localObject[3]) - this.i / 8.0F);
        localObject = this.jdField_b_of_type_ArrayOfInt;
        float f1 = Math.max(localObject[1], localObject[3]);
        m = this.i;
        n = (int)(f1 + m / 8.0F);
        i1 = (k + n) / 2;
        if (n - k > m / 2.0F)
        {
          localObject = this.jdField_a_of_type_ArrayOfInt;
          float f2 = i1;
          float f3 = m / 4.0F;
          f1 = 0.0F;
          if (f2 - f3 >= 0.0F) {
            f1 = f2 - m / 4.0F;
          }
          localObject[0] = ((int)f1);
          localObject = this.jdField_a_of_type_ArrayOfInt;
          k = this.i;
          if (k / 4.0F + f2 > k) {
            f1 = k;
          } else {
            f1 = f2 + k / 4.0F;
          }
          localObject[1] = ((int)f1);
        }
        else
        {
          localObject = this.jdField_a_of_type_ArrayOfInt;
          localObject[0] = k;
          localObject[1] = n;
        }
        k = 1;
      }
    }
    else
    {
      m = this.jdField_a_of_type_JavaUtilArrayList.size();
      k = jdField_b_of_type_Int;
      if (m <= k) {
        k = this.jdField_a_of_type_JavaUtilArrayList.size();
      }
      m = jdField_c_of_type_Int;
      localObject = new int[m];
      n = (int)(this.i * 1.0F / m + 0.5F);
      m = n;
      if (n <= 0) {
        m = 1;
      }
      int i7 = this.jdField_a_of_type_JavaUtilArrayList.size();
      n = 0;
      int i3 = 0;
      int i2;
      for (i1 = 0; n < k; i1 = i2)
      {
        int i6 = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(i7 - 1 - n)).intValue() / m % jdField_c_of_type_Int;
        int i5 = localObject[i6] + 1;
        localObject[i6] = i5;
        i2 = i1;
        if (i5 > i1)
        {
          i3 = i6;
          i2 = i5;
        }
        n += 1;
      }
      k = (i3 + 1) * m + m / 2;
      localObject = this.jdField_a_of_type_ArrayOfInt;
      localObject[0] = (k - this.i / 4);
      if (localObject[0] < 0) {
        localObject[0] = 0;
      }
      localObject = this.jdField_a_of_type_ArrayOfInt;
      m = this.i;
      localObject[1] = (m / 4 + k);
      if (localObject[1] > m) {
        localObject[1] = m;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("calculate az, centerY : ");
      ((StringBuilder)localObject).append(k);
      QLog.d("UserActionCollector", 1, ((StringBuilder)localObject).toString());
      k = i4;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("listViewHeight : ");
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append(", az[0] : ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfInt[0]);
    ((StringBuilder)localObject).append(", az[1] : ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfInt[1]);
    ((StringBuilder)localObject).append(", rule : ");
    ((StringBuilder)localObject).append(k);
    QLog.d("UserActionCollector", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.UserActionCollector
 * JD-Core Version:    0.7.0.1
 */