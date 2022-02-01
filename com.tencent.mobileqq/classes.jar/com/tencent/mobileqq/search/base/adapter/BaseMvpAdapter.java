package com.tencent.mobileqq.search.base.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.search.base.presenter.IPresenter;
import com.tencent.mobileqq.search.base.view.IView;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseMvpAdapter<M extends IModel, V extends IView>
  extends BaseAdapter
{
  private List<M> a = new ArrayList();
  
  protected abstract IPresenter<M, V> a(int paramInt);
  
  protected abstract IView a(int paramInt, ViewGroup paramViewGroup);
  
  public void a(List<M> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "setDataList");
    }
    this.a.clear();
    if (paramList != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setDataList， size:");
        localStringBuilder.append(paramList.size());
        QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, localStringBuilder.toString());
      }
      this.a.addAll(paramList);
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "setDataList， null");
    }
    paramList = this.a.iterator();
    while (paramList.hasNext()) {
      if (paramList.next() == null) {
        paramList.remove();
      }
    }
    super.notifyDataSetChanged();
  }
  
  public M c(int paramInt)
  {
    if (paramInt >= this.a.size()) {
      return null;
    }
    return (IModel)this.a.get(paramInt);
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
    IModel localIModel = c(paramInt);
    Object localObject;
    IPresenter localIPresenter;
    if (localIModel == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getView model is null. position=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" list size = ");
      ((StringBuilder)localObject).append(this.a.size());
      QLog.e("Q.uniteSearch.BaseMvpAdapter", 1, ((StringBuilder)localObject).toString());
      localIPresenter = null;
      localObject = paramView;
      paramView = localIPresenter;
    }
    else
    {
      if (paramView == null)
      {
        localObject = a(paramInt, paramViewGroup);
        paramView = ((IView)localObject).h();
        localIPresenter = a(paramInt);
        paramView.setTag(2131449869, localIPresenter);
        paramView.setTag(2131449873, localObject);
      }
      else
      {
        localObject = (IView)paramView.getTag(2131449873);
        localIPresenter = (IPresenter)paramView.getTag(2131449869);
      }
      paramView.setTag(2131449867, localIModel);
      if (((IView)localObject).h() != null)
      {
        ((IView)localObject).h().setTag(2131449868, Integer.valueOf(paramInt));
        ((IView)localObject).h().setTag(2131449866, Integer.valueOf(getCount()));
      }
      localIPresenter.a(localIModel, (IView)localObject);
      localObject = paramView;
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter
 * JD-Core Version:    0.7.0.1
 */