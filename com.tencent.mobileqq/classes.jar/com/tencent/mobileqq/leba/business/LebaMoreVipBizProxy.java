package com.tencent.mobileqq.leba.business;

import android.app.Activity;
import com.tencent.mobileqq.leba.business.more.LebaMoreQzoneBiz;
import com.tencent.mobileqq.leba.entity.LebaMoreViewItem;
import com.tencent.mobileqq.leba.qcircle.more.LebaMoreQCircleBiz;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class LebaMoreVipBizProxy
{
  @ConfigInject(configPath="Business/qqleba-impl/src/main/resources/Inject_LebaBusiness.yml", version=1)
  public static ArrayList<Class<? extends ILabaMoreVipBiz>> a = new ArrayList();
  public List<ILabaMoreVipBiz> b = new ArrayList();
  
  static
  {
    a.add(LebaMoreQzoneBiz.class);
    a.add(LebaMoreQCircleBiz.class);
  }
  
  public void a()
  {
    if (this.b.isEmpty())
    {
      Object localObject = a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Class localClass = (Class)((Iterator)localObject).next();
        try
        {
          this.b.add(localClass.newInstance());
        }
        catch (Exception localException)
        {
          QLog.e("LebaMoreVipBizProxy", 1, localException, new Object[0]);
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initBizList size = ");
      ((StringBuilder)localObject).append(this.b.size());
      QLog.i("LebaMoreVipBizProxy", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, List<LebaMoreViewItem> paramList1, List<LebaMoreViewItem> paramList2)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((ILabaMoreVipBiz)localIterator.next()).a(paramInt, paramBoolean, paramList1, paramList2);
    }
  }
  
  public void a(Activity paramActivity)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((ILabaMoreVipBiz)localIterator.next()).a(paramActivity);
    }
  }
  
  public void a(LebaMoreViewItem paramLebaMoreViewItem)
  {
    Iterator localIterator = this.b.iterator();
    while ((localIterator.hasNext()) && (!((ILabaMoreVipBiz)localIterator.next()).a(paramLebaMoreViewItem))) {}
  }
  
  public void a(AppRuntime paramAppRuntime, boolean paramBoolean, LebaMoreViewItem paramLebaMoreViewItem)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((ILabaMoreVipBiz)localIterator.next()).a(paramAppRuntime, paramBoolean, paramLebaMoreViewItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.LebaMoreVipBizProxy
 * JD-Core Version:    0.7.0.1
 */