package com.tencent.mobileqq.qqgift.business.qqlive;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftServiceModule;
import com.tencent.mobileqq.qqgift.business.dt.QQGiftDtReportHelper;
import com.tencent.mobileqq.qqgift.countdown.CountDownController;
import com.tencent.mobileqq.qqgift.data.service.GiftListData;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData.FreeInfo;
import com.tencent.mobileqq.qqgift.manager.QQGiftCountDownManager;
import com.tencent.mobileqq.qqgift.mvvm.business.QQGiftPanelBaseViewModel;
import com.tencent.mobileqq.qqgift.mvvm.business.QQGiftPanelRepository;
import com.tencent.mobileqq.qqgift.mvvm.business.SingleEventWrapper;
import com.tencent.mobileqq.qqgift.mvvm.business.data.QQGiftDtParams;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView.OnPanelEventListener;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView.OnQQLivePanelEventListener;
import com.tencent.mobileqq.qqgift.sdk.config.QQGiftSDKConfig;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QQGiftPanelViewModelForLive
  extends QQGiftPanelBaseViewModel
  implements IQQGiftPanelView.OnQQLivePanelEventListener
{
  public static ViewModelProvider.Factory c = new QQGiftPanelViewModelForLive.4();
  public final MutableLiveData<Long> a = new MutableLiveData();
  public GiftServiceData b;
  private IQQGiftSDK d;
  private final MutableLiveData<SingleEventWrapper<List<List<GiftServiceData>>>> e = new MutableLiveData();
  private final MutableLiveData<String> f = new MutableLiveData();
  private final MutableLiveData<String> g = new MutableLiveData();
  private final MutableLiveData<Integer> h = new MutableLiveData();
  private final MutableLiveData<SingleEventWrapper<Boolean>> i = new MutableLiveData();
  private volatile long j;
  private int k = -1;
  private int l;
  private boolean m = false;
  private IQQGiftPanelView.OnPanelEventListener n = new QQGiftPanelStrategyForLive(this, null);
  private List<GiftServiceData> o;
  private long p;
  private long q;
  private int r = 0;
  private GiftListData s;
  private QQGiftDtReportHelper t;
  private QQGiftDtParams u;
  private Map<String, String> v;
  private boolean w;
  
  public QQGiftPanelViewModelForLive(QQGiftPanelRepository paramQQGiftPanelRepository)
  {
    super(paramQQGiftPanelRepository);
  }
  
  private void a(GiftServiceData paramGiftServiceData)
  {
    if (this.k == paramGiftServiceData.a)
    {
      paramGiftServiceData.i = true;
      this.m = true;
      return;
    }
    paramGiftServiceData.i = false;
  }
  
  private void a(List<GiftServiceData> paramList, List<List<GiftServiceData>> paramList1)
  {
    int i1 = 0;
    this.m = false;
    ArrayList localArrayList = null;
    while (i1 < paramList.size())
    {
      if (i1 % 8 == 0)
      {
        localArrayList = new ArrayList();
        paramList1.add(localArrayList);
      }
      GiftServiceData localGiftServiceData = (GiftServiceData)paramList.get(i1);
      localArrayList.add(localGiftServiceData);
      a(localGiftServiceData);
      i1 += 1;
    }
    d(paramList);
  }
  
  private boolean a(long paramLong)
  {
    if (this.j > paramLong)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isBalanceSeqValid] mRefreshBalanceSeq");
      localStringBuilder.append(this.j);
      localStringBuilder.append(",seq:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",just abort");
      QLog.i("QQGiftPanelViewModel", 2, localStringBuilder.toString());
      return false;
    }
    this.j = paramLong;
    return true;
  }
  
  private void b(long paramLong)
  {
    this.p = paramLong;
    MutableLiveData localMutableLiveData = this.f;
    Object localObject;
    if (paramLong <= 0L)
    {
      localObject = BaseApplication.getContext().getString(2131897852);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
    }
    localMutableLiveData.postValue(localObject);
    this.a.postValue(Long.valueOf(paramLong));
  }
  
  private void b(GiftServiceData paramGiftServiceData)
  {
    if ((l()) && (this.d.c() != null) && (QQGiftCountDownManager.a(paramGiftServiceData)))
    {
      Object localObject = QQGiftCountDownManager.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d.c().a);
      localStringBuilder.append("");
      localObject = ((QQGiftCountDownManager)localObject).a(localStringBuilder.toString());
      if (localObject != null)
      {
        ((CountDownController)localObject).a(paramGiftServiceData.a, paramGiftServiceData.l.a);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[processFreeGift] ");
          ((StringBuilder)localObject).append(paramGiftServiceData);
          QLog.i("QQGiftPanelViewModel", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  private void c(List<GiftServiceData> paramList)
  {
    Iterator localIterator = paramList.iterator();
    ArrayList localArrayList = new ArrayList();
    while (localIterator.hasNext())
    {
      GiftServiceData localGiftServiceData = (GiftServiceData)localIterator.next();
      if (((localGiftServiceData.d == 1) || (localGiftServiceData.d == 0)) && ((localGiftServiceData.j == 0) || (localGiftServiceData.j == 1)) && ((localGiftServiceData.j != 0) || (localGiftServiceData.c > 0)) && ((localGiftServiceData.j != 1) || (localGiftServiceData.c == 0)) && ((localGiftServiceData.j != 1) || ((localGiftServiceData.l != null) && (localGiftServiceData.l.a > 0L)))) {
        localArrayList.add(localGiftServiceData);
      }
    }
    if (localArrayList.size() != paramList.size())
    {
      paramList.clear();
      paramList.addAll(localArrayList);
    }
  }
  
  private boolean c(GiftServiceData paramGiftServiceData)
  {
    return (paramGiftServiceData.d == 1) && (paramGiftServiceData.j == 0) && (paramGiftServiceData.e == 0);
  }
  
  private void d(List<GiftServiceData> paramList)
  {
    if ((!this.m) && (e(paramList)))
    {
      GiftServiceData localGiftServiceData2 = (GiftServiceData)paramList.get(0);
      GiftServiceData localGiftServiceData1 = localGiftServiceData2;
      if (localGiftServiceData2.j == 1)
      {
        int i1 = 1;
        for (;;)
        {
          localGiftServiceData1 = localGiftServiceData2;
          if (i1 >= paramList.size()) {
            break;
          }
          localGiftServiceData1 = (GiftServiceData)paramList.get(i1);
          if (localGiftServiceData1.j != 1) {
            break;
          }
          i1 += 1;
        }
      }
      this.k = localGiftServiceData1.a;
      localGiftServiceData1.i = true;
    }
  }
  
  private boolean e(List<GiftServiceData> paramList)
  {
    return (paramList != null) && (!paramList.isEmpty());
  }
  
  private void f(List<List<GiftServiceData>> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Iterator localIterator = ((List)paramList.next()).iterator();
      while (localIterator.hasNext()) {
        ((GiftServiceData)localIterator.next()).i = false;
      }
    }
  }
  
  private void w()
  {
    if (!l()) {
      return;
    }
    List localList = this.o;
    if ((localList != null) && (localList.size() > 0))
    {
      a(this.o);
      if (QLog.isColorLevel()) {
        QLog.i("QQGiftPanelViewModel", 2, "[refreshGiftList] use cacheList");
      }
      return;
    }
    long l1 = System.currentTimeMillis();
    ((QQGiftPanelRepository)this.z).a(this.d, this.s, new QQGiftPanelViewModelForLive.1(this, l1));
  }
  
  private void x()
  {
    p();
    QQToast.makeText(BaseApplication.getContext(), 1, BaseApplication.getContext().getString(2131897850), 0).show();
  }
  
  private void y()
  {
    if (!l()) {
      return;
    }
    this.d.d().a(new QQGiftPanelViewModelForLive.3(this));
  }
  
  private void z()
  {
    if (this.q == 0L) {
      this.q = System.currentTimeMillis();
    }
    this.q += 1L;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    GiftServiceData localGiftServiceData = this.b;
    if (localGiftServiceData != null)
    {
      localGiftServiceData.m = this.q;
      localGiftServiceData.n = paramInt2;
      localGiftServiceData.h = 1;
      this.d.d().a(localGiftServiceData.a, localGiftServiceData.h, this.q, paramInt1, paramInt2, localGiftServiceData.j, new QQGiftPanelViewModelForLive.5(this, paramInt1, localGiftServiceData));
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.r = 0;
    this.d.d().a(paramInt1, 1, this.q, paramInt2, paramInt3);
  }
  
  public void a(IQQGiftSDK paramIQQGiftSDK)
  {
    this.d = paramIQQGiftSDK;
  }
  
  public void a(QQGiftDtReportHelper paramQQGiftDtReportHelper)
  {
    this.t = paramQQGiftDtReportHelper;
  }
  
  public void a(GiftListData paramGiftListData)
  {
    this.s = paramGiftListData;
  }
  
  public void a(GiftServiceData paramGiftServiceData, View paramView)
  {
    QQGiftDtReportHelper localQQGiftDtReportHelper = this.t;
    if (localQQGiftDtReportHelper != null) {
      localQQGiftDtReportHelper.a(paramGiftServiceData, paramView);
    }
  }
  
  public void a(QQGiftDtParams paramQQGiftDtParams)
  {
    this.u = paramQQGiftDtParams;
  }
  
  public void a(IQQGiftPanelView.OnPanelEventListener paramOnPanelEventListener)
  {
    this.n = paramOnPanelEventListener;
  }
  
  public void a(List<GiftServiceData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      c(paramList);
      a(paramList, localArrayList);
    }
    this.e.postValue(new SingleEventWrapper(localArrayList));
  }
  
  public void a(Map<String, String> paramMap)
  {
    this.v = paramMap;
  }
  
  public void a(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  public boolean a()
  {
    IQQGiftPanelView.OnPanelEventListener localOnPanelEventListener = this.n;
    if (localOnPanelEventListener != null) {
      localOnPanelEventListener.a();
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    GiftServiceData localGiftServiceData = this.b;
    if (localGiftServiceData != null)
    {
      localGiftServiceData.m = this.q;
      localGiftServiceData.n = paramInt;
      return c(localGiftServiceData, this.l);
    }
    return false;
  }
  
  public boolean a(GiftServiceData paramGiftServiceData, int paramInt)
  {
    IQQGiftPanelView.OnPanelEventListener localOnPanelEventListener = this.n;
    if (localOnPanelEventListener != null) {
      localOnPanelEventListener.a(paramGiftServiceData, paramInt);
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean, GiftServiceData paramGiftServiceData, int paramInt)
  {
    Object localObject = this.n;
    if (localObject != null) {
      ((IQQGiftPanelView.OnPanelEventListener)localObject).a(paramBoolean, paramGiftServiceData, paramInt);
    }
    localObject = this.t;
    if (localObject != null) {
      ((QQGiftDtReportHelper)localObject).a(paramBoolean, paramGiftServiceData, paramInt);
    }
    return false;
  }
  
  public IQQGiftPanelView.OnPanelEventListener b(IQQGiftPanelView.OnPanelEventListener paramOnPanelEventListener)
  {
    return new QQGiftPanelStrategyForLive(this, paramOnPanelEventListener);
  }
  
  public void b(List<GiftServiceData> paramList)
  {
    this.o = paramList;
  }
  
  public void b(boolean paramBoolean, GiftServiceData paramGiftServiceData, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[doOnSendGiftCallback] isSuccess:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",data:");
      localStringBuilder.append(paramGiftServiceData);
      localStringBuilder.append(",errCode:");
      localStringBuilder.append(paramInt);
      QLog.i("QQGiftPanelViewModel", 2, localStringBuilder.toString());
    }
    y();
    if (!paramBoolean)
    {
      if (paramInt == -11008)
      {
        x();
        return;
      }
      QQToast.makeText(BaseApplication.getContext(), 1, BaseApplication.getContext().getString(2131897851), 0).show();
    }
  }
  
  public boolean b()
  {
    IQQGiftPanelView.OnPanelEventListener localOnPanelEventListener = this.n;
    if (localOnPanelEventListener != null) {
      localOnPanelEventListener.b();
    }
    return false;
  }
  
  public boolean b(GiftServiceData paramGiftServiceData, int paramInt)
  {
    Object localObject = this.n;
    if (localObject != null) {
      ((IQQGiftPanelView.OnPanelEventListener)localObject).b(paramGiftServiceData, paramInt);
    }
    localObject = this.t;
    if (localObject != null) {
      ((QQGiftDtReportHelper)localObject).a(paramGiftServiceData);
    }
    return false;
  }
  
  public boolean c()
  {
    IQQGiftPanelView.OnPanelEventListener localOnPanelEventListener = this.n;
    if (localOnPanelEventListener != null) {
      localOnPanelEventListener.c();
    }
    return false;
  }
  
  public boolean c(GiftServiceData paramGiftServiceData, int paramInt)
  {
    IQQGiftPanelView.OnPanelEventListener localOnPanelEventListener = this.n;
    if (localOnPanelEventListener != null) {
      return localOnPanelEventListener.c(paramGiftServiceData, paramInt);
    }
    return false;
  }
  
  public MutableLiveData<SingleEventWrapper<List<List<GiftServiceData>>>> d()
  {
    return this.e;
  }
  
  public void d(GiftServiceData paramGiftServiceData, int paramInt)
  {
    this.k = paramGiftServiceData.a;
    this.t.a(paramGiftServiceData);
    if (QLog.isColorLevel())
    {
      paramGiftServiceData = new StringBuilder();
      paramGiftServiceData.append("[onSendGiftClick] mSelectedGiftID:");
      paramGiftServiceData.append(this.k);
      QLog.i("QQGiftPanelViewModel", 2, paramGiftServiceData.toString());
    }
  }
  
  public MutableLiveData<String> e()
  {
    return this.f;
  }
  
  public void e(GiftServiceData paramGiftServiceData, int paramInt)
  {
    this.b = paramGiftServiceData;
    this.k = paramGiftServiceData.a;
    this.l = paramInt;
  }
  
  public MutableLiveData<String> f()
  {
    return this.g;
  }
  
  public void f(GiftServiceData paramGiftServiceData, int paramInt)
  {
    if ((!paramGiftServiceData.i) && (this.e.getValue() != null) && (((SingleEventWrapper)this.e.getValue()).b() != null))
    {
      List localList = (List)((SingleEventWrapper)this.e.getValue()).b();
      f(localList);
      paramGiftServiceData.i = true;
      this.e.setValue(new SingleEventWrapper(localList));
    }
  }
  
  public MutableLiveData<Integer> g()
  {
    return this.h;
  }
  
  public MutableLiveData<SingleEventWrapper<Boolean>> h()
  {
    return this.i;
  }
  
  public IQQGiftSDK i()
  {
    return this.d;
  }
  
  public int j()
  {
    GiftServiceData localGiftServiceData = this.b;
    if ((localGiftServiceData != null) && (localGiftServiceData.c != 0)) {
      return (int)(this.p / this.b.c);
    }
    return 2147483647;
  }
  
  public void k()
  {
    w();
    y();
  }
  
  public boolean l()
  {
    return this.d != null;
  }
  
  public GiftServiceData m()
  {
    return this.b;
  }
  
  public void n()
  {
    k();
  }
  
  public void o() {}
  
  public void p()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQGiftPanelViewModel", 2, "[onRechargeClick] ");
    }
    if (!l()) {
      return;
    }
    this.d.f().a(1, new QQGiftPanelViewModelForLive.2(this));
  }
  
  public boolean q()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean r()
  {
    return this.w;
  }
  
  public QQGiftDtParams s()
  {
    return this.u;
  }
  
  public Map<String, String> t()
  {
    return this.v;
  }
  
  public int u()
  {
    return this.r;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.business.qqlive.QQGiftPanelViewModelForLive
 * JD-Core Version:    0.7.0.1
 */