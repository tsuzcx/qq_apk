package com.tencent.mobileqq.qqgift.mvvm.business;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftServiceModule;
import com.tencent.mobileqq.qqgift.business.dt.QQGiftDtReportHelper;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qqgift.mvvm.business.adapter.QQGiftPanelEventListenerAdapter;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView.OnPanelEventListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QQGiftPanelViewModel
  extends QQGiftPanelBaseViewModel
  implements IQQGiftPanelView.OnPanelEventListener
{
  public static ViewModelProvider.Factory a = new QQGiftPanelViewModel.5();
  private IQQGiftSDK b;
  private final MutableLiveData<SingleEventWrapper<List<List<GiftServiceData>>>> c = new MutableLiveData();
  private final MutableLiveData<String> d = new MutableLiveData();
  private volatile long e;
  private int f = -1;
  private boolean g = false;
  private IQQGiftPanelView.OnPanelEventListener h = new QQGiftPanelEventListenerAdapter(this, null);
  private List<GiftServiceData> i;
  private Map<String, String> j;
  
  public QQGiftPanelViewModel(QQGiftPanelRepository paramQQGiftPanelRepository)
  {
    super(paramQQGiftPanelRepository);
  }
  
  private void a(GiftServiceData paramGiftServiceData)
  {
    if (this.f == paramGiftServiceData.a)
    {
      paramGiftServiceData.i = true;
      this.g = true;
      return;
    }
    paramGiftServiceData.i = false;
  }
  
  private void a(List<GiftServiceData> paramList, List<List<GiftServiceData>> paramList1)
  {
    int k = 0;
    this.g = false;
    ArrayList localArrayList = null;
    while (k < paramList.size())
    {
      if (k % 8 == 0)
      {
        localArrayList = new ArrayList();
        paramList1.add(localArrayList);
      }
      GiftServiceData localGiftServiceData = (GiftServiceData)paramList.get(k);
      localArrayList.add(localGiftServiceData);
      a(localGiftServiceData);
      k += 1;
    }
    c(paramList);
  }
  
  private boolean a(long paramLong)
  {
    if (this.e > paramLong)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isBalanceSeqValid] mRefreshBalanceSeq");
      localStringBuilder.append(this.e);
      localStringBuilder.append(",seq:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",just abort");
      QLog.i("QQGiftPanelViewModel", 2, localStringBuilder.toString());
      return false;
    }
    this.e = paramLong;
    return true;
  }
  
  private void b(long paramLong)
  {
    MutableLiveData localMutableLiveData = this.d;
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
  }
  
  private void c(List<GiftServiceData> paramList)
  {
    if ((!this.g) && (d(paramList)))
    {
      paramList = (GiftServiceData)paramList.get(0);
      paramList.i = true;
      this.f = paramList.a;
    }
  }
  
  private boolean d(List<GiftServiceData> paramList)
  {
    return (paramList != null) && (!paramList.isEmpty());
  }
  
  private void e(List<List<GiftServiceData>> paramList)
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
  
  private void j()
  {
    if (!h()) {
      return;
    }
    List localList = this.i;
    if ((localList != null) && (localList.size() > 0))
    {
      a(this.i);
      if (QLog.isColorLevel()) {
        QLog.i("QQGiftPanelViewModel", 2, "[refreshGiftList] use cacheList");
      }
      return;
    }
    long l = System.currentTimeMillis();
    ((QQGiftPanelRepository)this.z).a(this.b, new QQGiftPanelViewModel.1(this, l));
  }
  
  private void k()
  {
    if (!h()) {
      return;
    }
    this.b.d().a(new QQGiftPanelViewModel.4(this));
  }
  
  public void a(IQQGiftSDK paramIQQGiftSDK)
  {
    this.b = paramIQQGiftSDK;
  }
  
  public void a(IQQGiftPanelView.OnPanelEventListener paramOnPanelEventListener)
  {
    this.h = paramOnPanelEventListener;
  }
  
  public void a(List<GiftServiceData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0)) {
      a(paramList, localArrayList);
    }
    this.c.postValue(new SingleEventWrapper(localArrayList));
  }
  
  public void a(Map<String, String> paramMap)
  {
    this.j = paramMap;
  }
  
  public boolean a()
  {
    IQQGiftPanelView.OnPanelEventListener localOnPanelEventListener = this.h;
    if (localOnPanelEventListener != null) {
      localOnPanelEventListener.a();
    }
    return false;
  }
  
  public boolean a(GiftServiceData paramGiftServiceData, int paramInt)
  {
    IQQGiftPanelView.OnPanelEventListener localOnPanelEventListener = this.h;
    if (localOnPanelEventListener != null) {
      localOnPanelEventListener.a(paramGiftServiceData, paramInt);
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean, GiftServiceData paramGiftServiceData, int paramInt)
  {
    IQQGiftPanelView.OnPanelEventListener localOnPanelEventListener = this.h;
    if (localOnPanelEventListener != null) {
      localOnPanelEventListener.a(paramBoolean, paramGiftServiceData, paramInt);
    }
    return false;
  }
  
  public IQQGiftPanelView.OnPanelEventListener b(IQQGiftPanelView.OnPanelEventListener paramOnPanelEventListener)
  {
    return new QQGiftPanelEventListenerAdapter(this, paramOnPanelEventListener);
  }
  
  public void b(GiftServiceData paramGiftServiceData, View paramView)
  {
    QQGiftDtReportHelper.b(paramGiftServiceData, paramView);
  }
  
  public void b(List<GiftServiceData> paramList)
  {
    this.i = paramList;
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
    k();
    if (!paramBoolean)
    {
      if (paramInt == -11008)
      {
        p();
        QQToast.makeText(BaseApplication.getContext(), 1, BaseApplication.getContext().getString(2131897850), 0).show();
        return;
      }
      QQToast.makeText(BaseApplication.getContext(), 1, BaseApplication.getContext().getString(2131897851), 0).show();
    }
  }
  
  public boolean b()
  {
    IQQGiftPanelView.OnPanelEventListener localOnPanelEventListener = this.h;
    if (localOnPanelEventListener != null) {
      localOnPanelEventListener.b();
    }
    return false;
  }
  
  public boolean b(GiftServiceData paramGiftServiceData, int paramInt)
  {
    IQQGiftPanelView.OnPanelEventListener localOnPanelEventListener = this.h;
    if (localOnPanelEventListener != null) {
      localOnPanelEventListener.b(paramGiftServiceData, paramInt);
    }
    return false;
  }
  
  public boolean c()
  {
    IQQGiftPanelView.OnPanelEventListener localOnPanelEventListener = this.h;
    if (localOnPanelEventListener != null) {
      localOnPanelEventListener.c();
    }
    return false;
  }
  
  public boolean c(GiftServiceData paramGiftServiceData, int paramInt)
  {
    IQQGiftPanelView.OnPanelEventListener localOnPanelEventListener = this.h;
    if (localOnPanelEventListener != null) {
      localOnPanelEventListener.c(paramGiftServiceData, paramInt);
    }
    return false;
  }
  
  public MutableLiveData<SingleEventWrapper<List<List<GiftServiceData>>>> d()
  {
    return this.c;
  }
  
  public void d(GiftServiceData paramGiftServiceData, int paramInt)
  {
    if (!h()) {
      return;
    }
    if (paramGiftServiceData != null)
    {
      this.f = paramGiftServiceData.a;
      this.b.d().a(paramGiftServiceData.a, 1, new QQGiftPanelViewModel.2(this, paramGiftServiceData));
    }
    if (QLog.isColorLevel())
    {
      paramGiftServiceData = new StringBuilder();
      paramGiftServiceData.append("[onSendGiftClick] mSelectedGiftID:");
      paramGiftServiceData.append(this.f);
      QLog.i("QQGiftPanelViewModel", 2, paramGiftServiceData.toString());
    }
  }
  
  public MutableLiveData<String> e()
  {
    return this.d;
  }
  
  public IQQGiftSDK f()
  {
    return this.b;
  }
  
  public void f(GiftServiceData paramGiftServiceData, int paramInt)
  {
    if (paramGiftServiceData.i)
    {
      c(paramGiftServiceData, paramInt);
      return;
    }
    if ((this.c.getValue() != null) && (((SingleEventWrapper)this.c.getValue()).b() != null))
    {
      List localList = (List)((SingleEventWrapper)this.c.getValue()).b();
      e(localList);
      paramGiftServiceData.i = true;
      this.c.setValue(new SingleEventWrapper(localList));
    }
  }
  
  public void g()
  {
    j();
    k();
  }
  
  public boolean h()
  {
    return this.b != null;
  }
  
  public Map<String, String> i()
  {
    return this.j;
  }
  
  public void n()
  {
    g();
  }
  
  public void p()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQGiftPanelViewModel", 2, "[onRechargeClick] ");
    }
    if (!h()) {
      return;
    }
    this.b.f().a(1, new QQGiftPanelViewModel.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.QQGiftPanelViewModel
 * JD-Core Version:    0.7.0.1
 */