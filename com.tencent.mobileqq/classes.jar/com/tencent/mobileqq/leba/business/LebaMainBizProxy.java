package com.tencent.mobileqq.leba.business;

import android.view.View;
import com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart;
import com.tencent.mobileqq.leba.business.mainbiz.LebaSearchPart;
import com.tencent.mobileqq.leba.entity.LeabOnPauseInfo;
import com.tencent.mobileqq.leba.entity.LebaClickReportInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.proxy.ILebaProxy;
import com.tencent.mobileqq.leba.qcircle.mainbiz.LebaQCirclePart;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LebaMainBizProxy
{
  @ConfigInject(configPath="Business/qqleba-impl/src/main/resources/Inject_LebaBusiness.yml", version=1)
  public static ArrayList<Class<? extends BaseLebaMainBiz>> a = new ArrayList();
  public List<BaseLebaMainBiz> b = new ArrayList();
  
  static
  {
    a.add(LebaQCirclePart.class);
    a.add(LebaQzoneAndPluginPart.class);
    a.add(LebaSearchPart.class);
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
          QLog.e("LebaMainBizProxy", 1, localException, new Object[0]);
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initBizList size = ");
      ((StringBuilder)localObject).append(this.b.size());
      QLog.i("LebaMainBizProxy", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(View paramView)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((BaseLebaMainBiz)localIterator.next()).a(paramView);
    }
  }
  
  public void a(View paramView, LebaViewItem paramLebaViewItem, LebaClickReportInfo paramLebaClickReportInfo)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((BaseLebaMainBiz)localIterator.next()).a(paramView, paramLebaViewItem, paramLebaClickReportInfo);
    }
  }
  
  public void a(LeabOnPauseInfo paramLeabOnPauseInfo)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((BaseLebaMainBiz)localIterator.next()).a(paramLeabOnPauseInfo);
    }
  }
  
  public void a(ILebaProxy paramILebaProxy)
  {
    a();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      BaseLebaMainBiz localBaseLebaMainBiz = (BaseLebaMainBiz)localIterator.next();
      localBaseLebaMainBiz.a(paramILebaProxy);
      localBaseLebaMainBiz.n();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((BaseLebaMainBiz)localIterator.next()).a(paramBoolean);
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((BaseLebaMainBiz)localIterator.next()).l();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((BaseLebaMainBiz)localIterator.next()).b(paramBoolean);
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((BaseLebaMainBiz)localIterator.next()).m();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((BaseLebaMainBiz)localIterator.next()).c(paramBoolean);
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((BaseLebaMainBiz)localIterator.next()).o();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((BaseLebaMainBiz)localIterator.next()).p();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((BaseLebaMainBiz)localIterator.next()).q();
    }
  }
  
  public void g()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((BaseLebaMainBiz)localIterator.next()).r();
    }
  }
  
  public void h()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((BaseLebaMainBiz)localIterator.next()).s();
    }
  }
  
  public void i()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((BaseLebaMainBiz)localIterator.next()).t();
    }
  }
  
  public void j()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((BaseLebaMainBiz)localIterator.next()).u();
    }
  }
  
  public void k()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((BaseLebaMainBiz)localIterator.next()).v();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.LebaMainBizProxy
 * JD-Core Version:    0.7.0.1
 */