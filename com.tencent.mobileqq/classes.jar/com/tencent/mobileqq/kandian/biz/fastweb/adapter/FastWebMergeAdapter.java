package com.tencent.mobileqq.kandian.biz.fastweb.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FastWebMergeAdapter
  extends BaseAdapter
{
  private FastWebMergeAdapter.OnDataSetChangeListener jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterFastWebMergeAdapter$OnDataSetChangeListener;
  private FastWebMergeAdapter.OnGetViewListener jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterFastWebMergeAdapter$OnGetViewListener;
  private List<BaseAdapter> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private View a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      paramViewGroup = new View(paramViewGroup.getContext());
      paramViewGroup.setVisibility(8);
      return paramViewGroup;
    }
    return null;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return getView(paramInt, paramView, paramViewGroup);
  }
  
  public List<BaseAdapter> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a() {}
  
  public void a(BaseAdapter paramBaseAdapter)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null)
    {
      if (paramBaseAdapter == null) {
        return;
      }
      localList.add(paramBaseAdapter);
      paramBaseAdapter.registerDataSetObserver(new FastWebMergeAdapter.1(this));
    }
  }
  
  public void a(FastWebMergeAdapter.OnDataSetChangeListener paramOnDataSetChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterFastWebMergeAdapter$OnDataSetChangeListener = paramOnDataSetChangeListener;
  }
  
  public void a(FastWebMergeAdapter.OnGetViewListener paramOnGetViewListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterFastWebMergeAdapter$OnGetViewListener = paramOnGetViewListener;
  }
  
  public void b(BaseAdapter paramBaseAdapter)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null)
    {
      if (paramBaseAdapter == null) {
        return;
      }
      localList.remove(paramBaseAdapter);
    }
  }
  
  public int getCount()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      i += ((BaseAdapter)localIterator.next()).getCount();
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      BaseAdapter localBaseAdapter = (BaseAdapter)localIterator.next();
      int i = localBaseAdapter.getCount();
      if (paramInt < i) {
        return localBaseAdapter.getItem(paramInt);
      }
      paramInt -= i;
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      BaseAdapter localBaseAdapter = (BaseAdapter)localIterator.next();
      int i = localBaseAdapter.getCount();
      if (paramInt < i) {
        return localBaseAdapter.getItemId(paramInt);
      }
      paramInt -= i;
    }
    return -1L;
  }
  
  public int getItemViewType(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (localIterator.hasNext())
    {
      BaseAdapter localBaseAdapter = (BaseAdapter)localIterator.next();
      j = localBaseAdapter.getCount();
      if (i < j)
      {
        i = localBaseAdapter.getItemViewType(i);
        break label77;
      }
      i -= j;
      paramInt += localBaseAdapter.getViewTypeCount();
    }
    i = -1;
    label77:
    return i + paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      int i = paramInt;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (BaseAdapter)((Iterator)localObject1).next();
        int j = ((BaseAdapter)localObject2).getCount();
        if (i < j)
        {
          localObject2 = ((BaseAdapter)localObject2).getView(i, paramView, paramViewGroup);
          if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterFastWebMergeAdapter$OnGetViewListener != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterFastWebMergeAdapter$OnGetViewListener.a(paramInt, (View)localObject2);
            return localObject2;
          }
        }
        i -= j;
      }
      return null;
    }
    catch (Exception paramView)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getView error! msg=");
      ((StringBuilder)localObject1).append(paramView);
      QLog.e("FastWebMergeAdapter", 1, ((StringBuilder)localObject1).toString());
    }
    return a(paramViewGroup);
  }
  
  public int getViewTypeCount()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      i += ((BaseAdapter)localIterator.next()).getViewTypeCount();
    }
    return Math.max(i, 1);
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    FastWebMergeAdapter.OnDataSetChangeListener localOnDataSetChangeListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebAdapterFastWebMergeAdapter$OnDataSetChangeListener;
    if (localOnDataSetChangeListener != null) {
      localOnDataSetChangeListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.adapter.FastWebMergeAdapter
 * JD-Core Version:    0.7.0.1
 */