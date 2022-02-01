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
  private static volatile UserActionCollector G;
  public static double a = 0.5D;
  public static int b = 5;
  public static int c = 20;
  public static int d = 10;
  public static String e = "sp_mix_feature_click_info";
  public static String f = "sp_mix_feature_scroll_info";
  public static int g = 1;
  public static int h = 2;
  public static int i = 3;
  public static int j = 4;
  private long A;
  private long B;
  private long C = -1L;
  private ArrayList<Integer> D = new ArrayList();
  private int[] E;
  private boolean F = false;
  public UserActionCollector.OnScrollChangeListenerWrapper k = new UserActionCollector.OnScrollChangeListenerWrapper(this);
  public List<UserActionCollector.FeedExpInfo> l = new ArrayList();
  public HashMap<String, Long> m = new HashMap();
  public List<UserActionCollector.GestureEvent> n = new ArrayList();
  public long o;
  public int p;
  public long q;
  public long r;
  public int s = 0;
  public int[] t = new int[2];
  public boolean u = false;
  private WeakReference<AbsListView> v;
  private HashMap<String, Integer> w = new HashMap();
  private String x;
  private long y = 0L;
  private int z = 0;
  
  private UserActionCollector()
  {
    boolean bool;
    if (Aladdin.getConfig(234).getIntegerFromString("fbs_enable", 0) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.F = bool;
    if (!this.F) {
      return;
    }
    try
    {
      String str = (String)RIJSPUtils.b(e, "");
      bool = TextUtils.isEmpty(str);
      if (!bool)
      {
        localObject1 = str.split("_");
        int i2 = localObject1.length;
        int i1 = 0;
        while (i1 < i2)
        {
          localObject2 = localObject1[i1];
          this.D.add(Integer.valueOf((String)localObject2));
          i1 += 1;
        }
      }
      Object localObject1 = (String)RIJSPUtils.b(f, "");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).split("_").length == 4))
      {
        localObject2 = ((String)localObject1).split("_");
        this.E = new int[4];
        this.E[0] = Integer.valueOf(localObject2[0]).intValue();
        this.E[1] = Integer.valueOf(localObject2[1]).intValue();
        this.E[2] = Integer.valueOf(localObject2[2]).intValue();
        this.E[3] = Integer.valueOf(localObject2[3]).intValue();
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
      RIJSPUtils.a(e, "");
      RIJSPUtils.a(f, "");
    }
  }
  
  private int a(View paramView, int paramInt)
  {
    int i1 = paramView.getHeight();
    double d1 = paramView.getTop();
    double d2 = i1;
    double d3 = a;
    Double.isNaN(d2);
    Double.isNaN(d1);
    i1 = (int)(d1 + d2 * d3);
    if (i1 <= paramInt)
    {
      paramInt = i1;
      if (i1 > 0) {}
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
    paramString = (Integer)this.w.get(paramString);
    if (paramString != null)
    {
      if (this.l.size() <= paramString.intValue()) {
        return null;
      }
      try
      {
        paramString = (UserActionCollector.FeedExpInfo)this.l.get(paramString.intValue());
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
    if (G == null) {
      try
      {
        if (G == null) {
          G = new UserActionCollector();
        }
      }
      finally {}
    }
    return G;
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
    int i3 = paramAbsListView.getFirstVisiblePosition();
    long l1;
    if (this.C != -1L)
    {
      l1 = System.currentTimeMillis();
      l2 = this.C;
    }
    else
    {
      l1 = System.currentTimeMillis();
      l2 = this.o;
    }
    long l2 = l1 - l2;
    int i1 = 0;
    while (i1 < paramAbsListView.getChildCount())
    {
      Object localObject1 = b(paramAbsListView, i3 + i1);
      View localView = paramAbsListView.getChildAt(i1);
      if (((localObject1 instanceof BaseArticleInfo)) && (localView != null))
      {
        int i4 = a(localView, paramAbsListView.getHeight());
        Object localObject2 = (AbsBaseArticleInfo)localObject1;
        String str = a((AbsBaseArticleInfo)localObject2);
        localObject1 = a(str);
        if (localObject1 == null)
        {
          localObject1 = new UserActionCollector.FeedExpInfo(this);
          ((UserActionCollector.FeedExpInfo)localObject1).a = str;
          ((UserActionCollector.FeedExpInfo)localObject1).c = RIJFeedsType.g((AbsBaseArticleInfo)localObject2);
          if (TextUtils.isEmpty(((AbsBaseArticleInfo)localObject2).mTitle)) {
            i2 = 0;
          } else {
            i2 = ((AbsBaseArticleInfo)localObject2).mTitle.length();
          }
          ((UserActionCollector.FeedExpInfo)localObject1).d = i2;
          boolean bool;
          if (this.C == -1L) {
            bool = true;
          } else {
            bool = false;
          }
          ((UserActionCollector.FeedExpInfo)localObject1).f = bool;
          ((UserActionCollector.FeedExpInfo)localObject1).e = localView.getHeight();
          ((UserActionCollector.FeedExpInfo)localObject1).b = ((AbsBaseArticleInfo)localObject2).mRecommentdReason;
          int i2 = this.z;
          this.z = (i2 + 1);
          ((UserActionCollector.FeedExpInfo)localObject1).h = i2;
          localObject2 = ReadinjoySensorUtils.a().d();
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
            ((UserActionCollector.FeedExpInfo)localObject1).m = localStringBuilder.toString();
          }
          else
          {
            ((UserActionCollector.FeedExpInfo)localObject1).m = "NULL";
          }
          this.l.add(localObject1);
          this.w.put(str, Integer.valueOf(this.l.size() - 1));
        }
        long l3 = ((UserActionCollector.FeedExpInfo)localObject1).k;
        if (i4 > 0) {
          l1 = l2;
        } else {
          l1 = 0L;
        }
        ((UserActionCollector.FeedExpInfo)localObject1).k = (l3 + l1);
        localObject2 = a(localView);
        if (localObject2 != null)
        {
          double d1 = localObject2[1] - localObject2[0];
          double d2 = localView.getHeight();
          double d3 = a;
          Double.isNaN(d2);
          if (d1 >= d2 * d3) {
            ((UserActionCollector.FeedExpInfo)localObject1).l += l2;
          }
        }
        ((UserActionCollector.FeedExpInfo)localObject1).i = this.m.containsKey(str);
        if (paramBoolean) {
          ((UserActionCollector.FeedExpInfo)localObject1).g = true;
        }
      }
      i1 += 1;
    }
    this.C = System.currentTimeMillis();
  }
  
  private int[] a(View paramView)
  {
    int[] arrayOfInt = e();
    int i1;
    if (paramView.getTop() < 0) {
      i1 = 0;
    } else {
      i1 = paramView.getTop();
    }
    int i3 = paramView.getBottom();
    int i2 = this.s;
    if (i3 <= i2) {
      i2 = paramView.getBottom();
    }
    if ((i2 > arrayOfInt[0]) && (arrayOfInt[1] > i1)) {
      return new int[] { Math.max(i1, arrayOfInt[0]), Math.min(i2, arrayOfInt[1]) };
    }
    return null;
  }
  
  private Object b(AbsListView paramAbsListView, int paramInt)
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
  
  private void j()
  {
    Object localObject = this.E;
    int i1 = 0;
    if (localObject != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.E[0]);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(this.E[1]);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(this.E[2]);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(this.E[3]);
      localObject = ((StringBuilder)localObject).toString();
      RIJSPUtils.a(f, localObject);
    }
    if (this.D.size() > 0)
    {
      if (this.D.size() > c) {
        i1 = this.D.size() - c;
      }
      localObject = this.D;
      localObject = TextUtils.join("_", ((ArrayList)localObject).subList(i1, ((ArrayList)localObject).size()));
      RIJSPUtils.a(e, localObject);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!this.F) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterBusiness, from : ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", scene : ");
    localStringBuilder.append(paramInt2);
    QLog.d("UserActionCollector", 1, localStringBuilder.toString());
    this.o = System.currentTimeMillis();
    this.p = paramInt1;
    this.q = paramInt2;
    ReadinjoySensorUtils.a().b();
  }
  
  public void a(View paramView, AbsListView paramAbsListView, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((this.o != 0L) && (paramAbsBaseArticleInfo != null))
    {
      if (!this.F) {
        return;
      }
      this.u = true;
      paramView = a(paramAbsBaseArticleInfo);
      if (!this.m.containsKey(paramView)) {
        this.m.put(paramView, Long.valueOf(0L));
      }
      paramAbsBaseArticleInfo = new float[2];
      Object localObject = (ReadInJoyXListView)paramAbsListView;
      paramAbsBaseArticleInfo[0] = localObject.s[0];
      paramAbsBaseArticleInfo[1] = (localObject.s[1] - paramAbsListView.getPaddingTop());
      paramAbsListView = new UserActionCollector.GestureEvent(this);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((int)paramAbsBaseArticleInfo[0]);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append((int)paramAbsBaseArticleInfo[1]);
      paramAbsListView.g = ((StringBuilder)localObject).toString();
      this.n.add(paramAbsListView);
      if (paramAbsBaseArticleInfo[1] > 0.0F) {
        this.D.add(Integer.valueOf((int)paramAbsBaseArticleInfo[1]));
      }
      this.x = paramView;
      this.y = System.currentTimeMillis();
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView != null)
    {
      Object localObject = this.v;
      if ((localObject == null) || (paramAbsListView != ((WeakReference)localObject).get()))
      {
        if (!this.F) {
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("register listview : ");
        ((StringBuilder)localObject).append(paramAbsListView);
        QLog.d("UserActionCollector", 1, ((StringBuilder)localObject).toString());
        this.v = new WeakReference(paramAbsListView);
        this.s = ScreenUtil.getInstantScreenHeight(paramAbsListView.getContext());
        ((ReadInJoyXListView)paramAbsListView).a(this.k);
        paramAbsListView.post(new UserActionCollector.1(this, paramInt, paramAbsListView));
      }
    }
  }
  
  public void b()
  {
    if ((this.o != 0L) && (this.B != 0L))
    {
      if (!this.F) {
        return;
      }
      long l1 = System.currentTimeMillis() - this.B;
      this.A += l1;
      if (this.y != 0L)
      {
        UserActionCollector.FeedExpInfo localFeedExpInfo = a(this.x);
        if (localFeedExpInfo != null) {
          localFeedExpInfo.j += l1;
        }
        this.y = 0L;
        this.x = null;
      }
      this.B = 0L;
    }
  }
  
  public void c()
  {
    if (this.o != 0L)
    {
      if (!this.F) {
        return;
      }
      this.B = System.currentTimeMillis();
      Object localObject = this.v;
      if (localObject != null) {
        localObject = (AbsListView)((WeakReference)localObject).get();
      } else {
        localObject = null;
      }
      a((AbsListView)localObject, false);
    }
  }
  
  public void d()
  {
    if ((this.o != 0L) && (this.v != null))
    {
      if (!this.F) {
        return;
      }
      QLog.d("UserActionCollector", 1, "exitBusiness !");
      ReadinjoySensorUtils.a().c();
      this.r = System.currentTimeMillis();
      this.A = (this.r - this.o - this.A);
      a((AbsListView)this.v.get(), true);
      UserOperationModule.getInstance().reportMixFeatureUserActionData(this, BaseApplication.getContext());
      j();
      this.v = null;
      G = null;
    }
  }
  
  public int[] e()
  {
    if (this.C != 0L)
    {
      int[] arrayOfInt = this.t;
      if (arrayOfInt != null) {
        return arrayOfInt;
      }
    }
    return new int[] { 0, (int)(this.s * 2 / 3.0F) };
  }
  
  public long f()
  {
    if (this.k.a == 0L) {
      return this.A;
    }
    return this.k.a - this.o;
  }
  
  public long g()
  {
    if (this.k.b == 0L) {
      return this.A;
    }
    return this.r - this.k.b;
  }
  
  public long h()
  {
    return this.A;
  }
  
  public void i()
  {
    int i7 = 2;
    this.t = new int[2];
    int i1;
    int i2;
    int i3;
    int i4;
    if (this.D.size() < b)
    {
      localObject = this.E;
      if (localObject == null)
      {
        localObject = this.t;
        localObject[0] = 0;
        localObject[1] = ((int)(this.s * 2 / 3.0F));
        i1 = 0;
      }
      else
      {
        i1 = (int)(Math.min(localObject[1], localObject[3]) - this.s / 8.0F);
        localObject = this.E;
        float f1 = Math.max(localObject[1], localObject[3]);
        i2 = this.s;
        i3 = (int)(f1 + i2 / 8.0F);
        i4 = (i1 + i3) / 2;
        if (i3 - i1 > i2 / 2.0F)
        {
          localObject = this.t;
          float f2 = i4;
          float f3 = i2 / 4.0F;
          f1 = 0.0F;
          if (f2 - f3 >= 0.0F) {
            f1 = f2 - i2 / 4.0F;
          }
          localObject[0] = ((int)f1);
          localObject = this.t;
          i1 = this.s;
          if (i1 / 4.0F + f2 > i1) {
            f1 = i1;
          } else {
            f1 = f2 + i1 / 4.0F;
          }
          localObject[1] = ((int)f1);
        }
        else
        {
          localObject = this.t;
          localObject[0] = i1;
          localObject[1] = i3;
        }
        i1 = 1;
      }
    }
    else
    {
      i2 = this.D.size();
      i1 = c;
      if (i2 <= i1) {
        i1 = this.D.size();
      }
      i2 = d;
      localObject = new int[i2];
      i3 = (int)(this.s * 1.0F / i2 + 0.5F);
      i2 = i3;
      if (i3 <= 0) {
        i2 = 1;
      }
      int i10 = this.D.size();
      i3 = 0;
      int i6 = 0;
      int i5;
      for (i4 = 0; i3 < i1; i4 = i5)
      {
        int i9 = ((Integer)this.D.get(i10 - 1 - i3)).intValue() / i2 % d;
        int i8 = localObject[i9] + 1;
        localObject[i9] = i8;
        i5 = i4;
        if (i8 > i4)
        {
          i6 = i9;
          i5 = i8;
        }
        i3 += 1;
      }
      i1 = (i6 + 1) * i2 + i2 / 2;
      localObject = this.t;
      localObject[0] = (i1 - this.s / 4);
      if (localObject[0] < 0) {
        localObject[0] = 0;
      }
      localObject = this.t;
      i2 = this.s;
      localObject[1] = (i2 / 4 + i1);
      if (localObject[1] > i2) {
        localObject[1] = i2;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("calculate az, centerY : ");
      ((StringBuilder)localObject).append(i1);
      QLog.d("UserActionCollector", 1, ((StringBuilder)localObject).toString());
      i1 = i7;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("listViewHeight : ");
    ((StringBuilder)localObject).append(this.s);
    ((StringBuilder)localObject).append(", az[0] : ");
    ((StringBuilder)localObject).append(this.t[0]);
    ((StringBuilder)localObject).append(", az[1] : ");
    ((StringBuilder)localObject).append(this.t[1]);
    ((StringBuilder)localObject).append(", rule : ");
    ((StringBuilder)localObject).append(i1);
    QLog.d("UserActionCollector", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.UserActionCollector
 * JD-Core Version:    0.7.0.1
 */