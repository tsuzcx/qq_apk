package com.tencent.mobileqq.leba.business;

import android.content.Context;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.leba.business.mgr.LebaDiyIconTableMgTitle;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class LebaTableMgrTitleBizProxy
{
  @ConfigInject(configPath="Business/qqleba-impl/src/main/resources/Inject_LebaBusiness.yml", version=1)
  public static ArrayList<Class<? extends ILebaTableMgrTitleBiz>> a;
  public List<ILebaTableMgrTitleBiz> a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(LebaDiyIconTableMgTitle.class);
  }
  
  public LebaTableMgrTitleBizProxy()
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
          QLog.e("LebaTableMgrTitleBizProxy", 1, localException, new Object[0]);
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initBizList size = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.i("LebaTableMgrTitleBizProxy", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(Context paramContext, AppRuntime paramAppRuntime, RelativeLayout paramRelativeLayout)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ILebaTableMgrTitleBiz)localIterator.next()).a(paramContext, paramAppRuntime, paramRelativeLayout);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.LebaTableMgrTitleBizProxy
 * JD-Core Version:    0.7.0.1
 */