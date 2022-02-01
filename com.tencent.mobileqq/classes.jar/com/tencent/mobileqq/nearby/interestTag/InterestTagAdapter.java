package com.tencent.mobileqq.nearby.interestTag;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public class InterestTagAdapter
  extends BaseAdapter
{
  private Context a;
  private int b;
  private List<InterestTagInfo> c;
  private InterestTagItemView.IInterestTagItemViewCallback d;
  
  public InterestTagAdapter(Context paramContext, int paramInt, List<InterestTagInfo> paramList, InterestTagItemView.IInterestTagItemViewCallback paramIInterestTagItemViewCallback)
  {
    this.a = paramContext;
    this.b = paramInt;
    this.c = paramList;
    this.d = paramIInterestTagItemViewCallback;
  }
  
  public InterestTagInfo a(int paramInt)
  {
    List localList = this.c;
    if ((localList != null) && (localList.size() > paramInt)) {
      return (InterestTagInfo)this.c.get(paramInt);
    }
    return null;
  }
  
  public void a(List<InterestTagInfo> paramList, boolean paramBoolean)
  {
    this.c = paramList;
    if (paramBoolean) {
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    List localList = this.c;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new InterestTagItemView(this.a);
      paramView.a(this.b);
      paramView.setCallback(this.d);
    }
    else
    {
      paramView = (InterestTagItemView)paramView;
    }
    paramView.a(a(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.InterestTagAdapter
 * JD-Core Version:    0.7.0.1
 */