package com.tencent.mobileqq.leba.business;

import com.tencent.mobileqq.leba.business.itemfilter.LebaSpecificPluginFilter;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LebaItemFilterProxy
{
  @ConfigInject(configPath="Business/qqleba-impl/src/main/resources/Inject_LebaBusiness.yml", version=1)
  public static ArrayList<Class<? extends ILebaItemFilter>> a = new ArrayList();
  public List<ILebaItemFilter> b = new ArrayList();
  
  static
  {
    a.add(LebaSpecificPluginFilter.class);
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
          QLog.e("LebaItemFilterProxy", 1, localException, new Object[0]);
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initFilterList size = ");
      ((StringBuilder)localObject).append(this.b.size());
      QLog.i("LebaItemFilterProxy", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean a(LebaViewItem paramLebaViewItem)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (((ILebaItemFilter)localIterator.next()).a(paramLebaViewItem)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.LebaItemFilterProxy
 * JD-Core Version:    0.7.0.1
 */