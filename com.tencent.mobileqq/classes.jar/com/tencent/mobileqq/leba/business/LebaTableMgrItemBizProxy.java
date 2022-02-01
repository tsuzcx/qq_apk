package com.tencent.mobileqq.leba.business;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.mobileqq.leba.entity.LebaMgrViewItem;
import com.tencent.mobileqq.leba.qcircle.mgr.LebaQCircleTableMgrItem;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LebaTableMgrItemBizProxy
{
  @ConfigInject(configPath="Business/qqleba-impl/src/main/resources/Inject_LebaBusiness.yml", version=1)
  public static ArrayList<Class<? extends ILebaTableMgrItemBiz>> a;
  public List<ILebaTableMgrItemBiz> a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(LebaQCircleTableMgrItem.class);
  }
  
  public LebaTableMgrItemBizProxy()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public RecyclerView.ViewHolder a(Context paramContext, ViewGroup paramViewGroup, int paramInt, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      RecyclerView.ViewHolder localViewHolder = ((ILebaTableMgrItemBiz)localIterator.next()).a(paramContext, paramViewGroup, paramInt, paramBoolean);
      if (localViewHolder != null) {
        return localViewHolder;
      }
    }
    return null;
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
          QLog.e("LebaTableMgrItemBizProxy", 1, localException, new Object[0]);
        }
      }
      QLog.i("LebaTableMgrItemBizProxy", 1, "initBizList size = " + this.jdField_a_of_type_JavaUtilList.size());
    }
  }
  
  public void a(Context paramContext, List<LebaMgrViewItem> paramList)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ILebaTableMgrItemBiz)localIterator.next()).a(paramContext, paramList);
    }
  }
  
  public boolean a(RecyclerView.ViewHolder paramViewHolder, LebaMgrViewItem paramLebaMgrViewItem, Context paramContext, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((ILebaTableMgrItemBiz)localIterator.next()).a(paramViewHolder, paramLebaMgrViewItem, paramContext, paramBoolean)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.LebaTableMgrItemBizProxy
 * JD-Core Version:    0.7.0.1
 */