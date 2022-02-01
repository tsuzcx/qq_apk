package com.tencent.mobileqq.leba.business;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.qcircle.mgr.LebaQCircleListMgrItem;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LebaListMgrItemBizProxy
{
  @ConfigInject(configPath="Business/qqleba-impl/src/main/resources/Inject_LebaBusiness.yml", version=1)
  public static ArrayList<Class<? extends ILebaListMgrItemBiz>> a;
  public List<ILebaListMgrItemBiz> a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(LebaQCircleListMgrItem.class);
  }
  
  public LebaListMgrItemBizProxy()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        try
        {
          this.jdField_a_of_type_JavaUtilList.add(localClass.newInstance());
        }
        catch (Exception localException)
        {
          QLog.e("LebaListMgrItemBizProxy", 1, localException, new Object[0]);
        }
      }
      QLog.i("LebaListMgrItemBizProxy", 1, "initBizList size = " + this.jdField_a_of_type_JavaUtilList.size());
    }
  }
  
  public void a(ArrayList<LebaViewItem> paramArrayList)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ILebaListMgrItemBiz)localIterator.next()).a(paramArrayList);
    }
  }
  
  public boolean a(RedTouch paramRedTouch, @NonNull LebaViewItem paramLebaViewItem, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((ILebaListMgrItemBiz)localIterator.next()).a(paramRedTouch, paramLebaViewItem, paramBoolean)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.LebaListMgrItemBizProxy
 * JD-Core Version:    0.7.0.1
 */