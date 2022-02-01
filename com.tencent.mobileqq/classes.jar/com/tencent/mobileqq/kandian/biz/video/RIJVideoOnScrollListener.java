package com.tencent.mobileqq.kandian.biz.video;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class RIJVideoOnScrollListener
  implements AbsListView.OnScrollListener
{
  public static boolean a;
  private static boolean h;
  boolean b;
  long c = 0L;
  double d = 0.0D;
  long e = 0L;
  long f = 0L;
  final double g = 200.0D;
  private final VideoHandler i;
  private View j;
  private View k;
  private int l;
  private int m;
  private boolean n = true;
  private AbsListView o;
  
  public RIJVideoOnScrollListener(VideoHandler paramVideoHandler)
  {
    this.i = paramVideoHandler;
    this.o = paramVideoHandler.e();
  }
  
  public static boolean a()
  {
    if (!a)
    {
      Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.KDCfg.name(), null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length >= 2) {
          h = localObject[1].equals("1");
        }
        a = true;
      }
    }
    return h;
  }
  
  private boolean a(AbsListView paramAbsListView)
  {
    double d1 = this.d;
    return (d1 > 0.0D) && (d1 < 200.0D) && (!this.i.g().H()) && (!a()) && (paramAbsListView.getVisibility() == 0);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramAbsListView = this.i.A();
    if ((paramAbsListView != null) && (paramAbsListView.B())) {
      return;
    }
    paramAbsListView = this.o.getChildAt(0);
    if (paramAbsListView != null)
    {
      if (this.c == 0L)
      {
        this.c = System.currentTimeMillis();
        return;
      }
      this.e = (paramAbsListView.getHeight() * paramInt1 - paramAbsListView.getTop());
      long l1 = this.e;
      long l2 = this.f;
      long l3 = System.currentTimeMillis();
      long l4 = this.c;
      if (l3 == l4) {
        return;
      }
      this.d = ((l1 - l2) * 1000L / (l3 - l4));
      this.c = l3;
      this.f = this.e;
      if (a(this.o))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "低速滚动触发自动播放检测");
        }
        this.i.b(this.o, ReadInJoyBaseAdapter.a);
      }
    }
    else
    {
      this.c = 0L;
      this.e = 0L;
      this.f = 0L;
    }
    paramInt3 = this.l;
    if (paramInt1 > paramInt3) {
      this.b = true;
    } else if (paramInt1 < paramInt3) {
      this.b = false;
    }
    this.l = paramInt1;
    this.m = (paramInt1 + paramInt2 - 1);
    this.j = this.o.getChildAt(0);
    this.k = this.o.getChildAt(paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        this.i.G();
      }
      this.i.N();
      return;
    }
    this.n = this.b;
    paramAbsListView = this.i.b(this.o);
    if (paramAbsListView == null) {
      paramInt = this.o.getFirstVisiblePosition();
    } else {
      paramInt = paramAbsListView.b();
    }
    this.i.a(paramInt, this.n);
    if (QLog.isColorLevel())
    {
      paramAbsListView = new StringBuilder();
      paramAbsListView.append("predownload position: ");
      paramAbsListView.append(paramInt);
      paramAbsListView.append(" when scroll state idle");
      QLog.d("ReadInJoyBaseAdapter", 2, paramAbsListView.toString());
    }
    this.i.b(this.o, ReadInJoyBaseAdapter.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.RIJVideoOnScrollListener
 * JD-Core Version:    0.7.0.1
 */