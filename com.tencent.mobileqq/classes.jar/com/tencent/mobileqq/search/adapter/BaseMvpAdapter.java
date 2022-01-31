package com.tencent.mobileqq.search.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseMvpAdapter
  extends BaseAdapter
{
  private List a = new ArrayList();
  
  public IModel a(int paramInt)
  {
    if (paramInt >= this.a.size()) {
      return null;
    }
    return (IModel)this.a.get(paramInt);
  }
  
  public abstract IPresenter a(int paramInt);
  
  public abstract IView a(int paramInt, ViewGroup paramViewGroup);
  
  public void a(List paramList)
  {
    this.a.clear();
    if (paramList != null) {
      this.a.addAll(paramList);
    }
    paramList = this.a.iterator();
    while (paramList.hasNext()) {
      if (paramList.next() == null) {
        paramList.remove();
      }
    }
    super.notifyDataSetChanged();
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    a(paramList);
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    IModel localIModel = a(paramInt);
    if (localIModel == null)
    {
      QLog.e("Q.uniteSearch.BaseMvpAdapter", 1, "getView model is null. position=" + paramInt + " list size = " + this.a.size());
      return null;
    }
    IPresenter localIPresenter;
    if (paramView == null)
    {
      paramViewGroup = a(paramInt, paramViewGroup);
      paramView = paramViewGroup.a();
      localIPresenter = a(paramInt);
      paramView.setTag(2131362077, localIPresenter);
      paramView.setTag(2131362078, paramViewGroup);
    }
    for (;;)
    {
      paramView.setTag(2131362079, localIModel);
      if (paramViewGroup.a() != null)
      {
        paramViewGroup.a().setTag(2131362080, Integer.valueOf(paramInt));
        paramViewGroup.a().setTag(2131362081, Integer.valueOf(getCount()));
      }
      localIPresenter.a(localIModel, paramViewGroup);
      return paramView;
      paramViewGroup = (IView)paramView.getTag(2131362078);
      localIPresenter = (IPresenter)paramView.getTag(2131362077);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.adapter.BaseMvpAdapter
 * JD-Core Version:    0.7.0.1
 */