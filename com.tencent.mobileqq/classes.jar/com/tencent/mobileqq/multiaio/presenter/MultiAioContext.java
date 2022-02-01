package com.tencent.mobileqq.multiaio.presenter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.miniaio.MiniPie;
import com.tencent.mobileqq.activity.miniaio.MiniPieFactory;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.multiaio.MultiAIOHelper;
import com.tencent.mobileqq.multiaio.MultiAIOItemFragment;
import com.tencent.mobileqq.multiaio.model.MultiAIOManager;
import com.tencent.mobileqq.multiaio.view.MultiAioCaller;
import com.tencent.mobileqq.multiaio.view.MultiAioContainer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiAioContext
{
  private MultiAioCaller a;
  private MultiAioContainer b;
  private int c;
  private boolean d;
  private long e;
  private int f;
  private List<MiniPie> g = new ArrayList();
  private ArrayList<View> h = new ArrayList();
  private Bitmap i;
  private int j;
  private volatile Bitmap k;
  private volatile Bitmap l;
  private MultiAIOManager m;
  private volatile List<RecentBaseData> n;
  private Handler o;
  
  public MultiAioContext(MultiAIOManager paramMultiAIOManager)
  {
    this.m = paramMultiAIOManager;
  }
  
  public static MultiAioContext a(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("create() called with: app = [");
      ((StringBuilder)localObject).append(paramAppInterface);
      ((StringBuilder)localObject).append("]");
      QLog.d("MultiAioContext", 2, ((StringBuilder)localObject).toString());
    }
    paramAppInterface = (MultiAIOManager)paramAppInterface.getManager(QQManagerFactory.AIO_MULTI_WINDOW_MANAGER);
    Object localObject = new MultiAioContext(paramAppInterface);
    ((MultiAioContext)localObject).d(paramAppInterface.a((MultiAioContext)localObject));
    return localObject;
  }
  
  private void a(List<RecentBaseData> paramList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setRecentUserList() called with: recentUserList = [");
      localStringBuilder.append(paramList);
      localStringBuilder.append("]");
      QLog.d("MultiAioContext", 2, localStringBuilder.toString());
    }
    this.n = paramList;
  }
  
  private void d(int paramInt)
  {
    this.c = paramInt;
  }
  
  public View a(int paramInt)
  {
    View localView1;
    if (this.h.isEmpty()) {
      localView1 = null;
    } else {
      localView1 = (View)this.h.remove(0);
    }
    Object localObject;
    if (localView1 != null)
    {
      localObject = localView1.getParent();
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(localView1);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getCacheViewFor() called with: position = [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], v = ");
      ((StringBuilder)localObject).append(localView1);
      QLog.d("MultiAioContext", 2, ((StringBuilder)localObject).toString());
      localObject = this.h.iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView2 = (View)((Iterator)localObject).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCacheViewFor() cached v = [");
        localStringBuilder.append(localView2);
        localStringBuilder.append("]");
        QLog.d("MultiAioContext", 2, localStringBuilder.toString());
      }
    }
    return localView1;
  }
  
  public MiniPie a(MultiAIOItemFragment paramMultiAIOItemFragment)
  {
    int i1 = paramMultiAIOItemFragment.b();
    MiniPie localMiniPie1;
    if ((i1 >= 0) && (i1 < this.g.size())) {
      localMiniPie1 = (MiniPie)this.g.get(i1);
    } else {
      localMiniPie1 = null;
    }
    MiniPie localMiniPie2 = localMiniPie1;
    if (localMiniPie1 == null)
    {
      localMiniPie2 = MiniPieFactory.a(paramMultiAIOItemFragment.getBaseActivity(), paramMultiAIOItemFragment.a(), paramMultiAIOItemFragment.getBaseActivity().app);
      a(i1, localMiniPie2);
    }
    return localMiniPie2;
  }
  
  public MultiAioContainer a()
  {
    return this.b;
  }
  
  public void a(int paramInt, MiniPie paramMiniPie)
  {
    while (this.g.size() <= paramInt) {
      this.g.add(null);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMiniPie() called with: position = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], miniPie = [");
      localStringBuilder.append(paramMiniPie);
      localStringBuilder.append("]");
      QLog.d("MultiAioContext", 2, localStringBuilder.toString());
    }
    this.g.set(paramInt, paramMiniPie);
  }
  
  public void a(Intent paramIntent)
  {
    MultiAioCaller localMultiAioCaller = this.a;
    if (localMultiAioCaller != null) {
      localMultiAioCaller.a(paramIntent);
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDecorViewBitmap() called with: decorViewBitmap = [");
      localStringBuilder.append(paramBitmap);
      localStringBuilder.append("]");
      QLog.d("MultiAioContext", 2, localStringBuilder.toString());
    }
    this.i = paramBitmap;
  }
  
  public void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, int paramInt)
  {
    while (paramInt > 0)
    {
      a(paramLayoutInflater.inflate(2131624459, paramViewGroup, false));
      paramInt -= 1;
    }
  }
  
  public void a(View paramView)
  {
    this.h.add(paramView);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("putCacheView() called size = ");
      localStringBuilder.append(this.h.size());
      localStringBuilder.append(" with: v = [");
      localStringBuilder.append(paramView);
      localStringBuilder.append("]");
      QLog.d("MultiAioContext", 2, localStringBuilder.toString());
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (this.o == null) {
      this.o = new Handler(ThreadManager.getRecentThreadLooper());
    }
    this.o.removeCallbacksAndMessages(this);
    this.o.postAtTime(new MultiAioContext.1(this, paramBaseActivity, paramQQAppInterface, paramString1, paramInt, paramString2, paramString3), this, 0L);
  }
  
  public void a(MultiAioCaller paramMultiAioCaller)
  {
    this.a = paramMultiAioCaller;
  }
  
  public void a(MultiAioContainer paramMultiAioContainer)
  {
    this.b = paramMultiAioContainer;
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if (paramBoolean) {
      this.e = SystemClock.uptimeMillis();
    }
  }
  
  public List<RecentBaseData> b(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getRecentUserList() called with: app = [");
      ((StringBuilder)localObject).append(paramQQAppInterface);
      ((StringBuilder)localObject).append("], activity = [");
      ((StringBuilder)localObject).append(paramBaseActivity);
      ((StringBuilder)localObject).append("], openedFrom = [");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("], enteranceType = [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], enteranceUin = [");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("], enterNickName = [");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append("], mRecentUserList = ");
      ((StringBuilder)localObject).append(this.n);
      QLog.d("MultiAioContext", 2, ((StringBuilder)localObject).toString());
    }
    List localList = this.n;
    Object localObject = localList;
    if (localList == null)
    {
      localObject = MultiAIOHelper.a(paramBaseActivity, paramQQAppInterface, paramString1, paramInt, paramString2, paramString3);
      a((List)localObject);
    }
    return localObject;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioContext", 2, "destroy() called");
    }
    Handler localHandler = this.o;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(this);
    }
    this.g.clear();
    this.h.clear();
    if (this.n != null) {
      this.n = null;
    }
    this.d = false;
    this.i = null;
    this.j = 0;
    this.k = null;
    this.l = null;
  }
  
  public void b(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void b(Bitmap paramBitmap)
  {
    this.k = paramBitmap;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public void c(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void c(Bitmap paramBitmap)
  {
    this.l = paramBitmap;
  }
  
  public Bitmap d()
  {
    return this.i;
  }
  
  public int e()
  {
    return this.j;
  }
  
  public Bitmap f()
  {
    return this.k;
  }
  
  public Bitmap g()
  {
    return this.l;
  }
  
  public void h()
  {
    MultiAioContainer localMultiAioContainer = this.b;
    if (localMultiAioContainer != null) {
      localMultiAioContainer.e();
    }
  }
  
  public boolean i()
  {
    return this.d;
  }
  
  public int j()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.presenter.MultiAioContext
 * JD-Core Version:    0.7.0.1
 */