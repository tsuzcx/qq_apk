package com.tencent.mobileqq.kandian.biz.ugc.selectmember;

import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.ugc.databinding.ObservableArrayList;
import com.tencent.mobileqq.kandian.biz.ugc.databinding.ObservableList.OnListChangedCallback;
import com.tencent.mobileqq.kandian.repo.ugc.ResultRecord;

public class SelectedMemberListViewAdapter
  extends BaseAdapter
  implements ObservableList.OnListChangedCallback<ObservableArrayList<ResultRecord>>
{
  private ObservableArrayList<ResultRecord> a = new ObservableArrayList();
  private PorterDuffColorFilter b = new PorterDuffColorFilter(-1711276033, PorterDuff.Mode.SRC_ATOP);
  private boolean c = false;
  
  SelectedMemberListViewAdapter(@NonNull ObservableArrayList<ResultRecord> paramObservableArrayList)
  {
    this.a = paramObservableArrayList;
    this.a.addOnListChangedCallback(this);
  }
  
  public void a()
  {
    int i = this.a.size();
    if (i > 0)
    {
      if (this.c)
      {
        this.a.remove(i - 1);
        return;
      }
      this.c = true;
      notifyDataSetChanged();
    }
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList)
  {
    notifyDataSetChanged();
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2) {}
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    this.c = false;
    notifyDataSetChanged();
  }
  
  public void c(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    this.c = false;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      paramViewGroup = (ReadInJoyHeadImageView)paramView.getTag();
    }
    else
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626327, paramViewGroup, false);
      paramViewGroup = (ReadInJoyHeadImageView)paramView.findViewById(2131435491);
      paramView.setTag(paramViewGroup);
    }
    Object localObject = getItem(paramInt);
    if ((localObject != null) && ((localObject instanceof ResultRecord))) {
      paramViewGroup.setHeadImgByUin(((ResultRecord)localObject).a());
    }
    int i = getCount();
    paramViewGroup = paramView.findViewById(2131435492);
    if ((this.c) && (paramInt == i - 1))
    {
      paramViewGroup.setVisibility(0);
      return paramView;
    }
    paramViewGroup.setVisibility(4);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.SelectedMemberListViewAdapter
 * JD-Core Version:    0.7.0.1
 */