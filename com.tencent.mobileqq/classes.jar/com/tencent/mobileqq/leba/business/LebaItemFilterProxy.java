package com.tencent.mobileqq.leba.business;

import com.tencent.mobileqq.leba.business.itemfilter.LebaSpecificPluginFilter;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class LebaItemFilterProxy
{
  @ConfigInject(configPath="Business/qqleba-impl/src/main/resources/Inject_LebaBusiness.yml", version=1)
  public static ArrayList<Class<? extends ILebaItemFilter>> a;
  public List<ILebaItemFilter> a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(LebaSpecificPluginFilter.class);
  }
  
  public LebaItemFilterProxy()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      Object localObject = jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Class localClass = (Class)((Iterator)localObject).next();
        try
        {
          this.jdField_a_of_type_JavaUtilList.add(localClass.newInstance());
        }
        catch (Exception localException)
        {
          QLog.e("LebaItemFilterProxy", 1, localException, new Object[0]);
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initFilterList size = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.i("LebaItemFilterProxy", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean a(LebaViewItem paramLebaViewItem)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((ILebaItemFilter)localIterator.next()).a(paramLebaViewItem)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(AppRuntime paramAppRuntime, StringBuffer paramStringBuffer, LebaViewItem paramLebaViewItem)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((ILebaItemFilter)localIterator.next()).a(paramAppRuntime, paramStringBuffer, paramLebaViewItem)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.LebaItemFilterProxy
 * JD-Core Version:    0.7.0.1
 */