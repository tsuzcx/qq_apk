package com.tencent.mobileqq.kandian.biz.biu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.kandian.repo.biu.MultiBiuSameContent;
import java.util.ArrayList;

public class ReadInjoyFriendsBiuComponentFragment$FriensBiuAdapter
  extends BaseAdapter
{
  Context a;
  ArrayList<MultiBiuSameContent> b = new ArrayList();
  
  public ReadInjoyFriendsBiuComponentFragment$FriensBiuAdapter(Context paramContext, ArrayList<MultiBiuSameContent> paramArrayList)
  {
    this.a = paramArrayList;
    Object localObject;
    this.b = localObject;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = new ReadInjoyFriendsBiuComponentFragment.ViewHolder(this.c, this.a);
    } else {
      paramView = (ReadInjoyFriendsBiuComponentFragment.ViewHolder)paramView.getTag();
    }
    paramView.a((MultiBiuSameContent)this.b.get(paramInt), paramInt);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.ReadInjoyFriendsBiuComponentFragment.FriensBiuAdapter
 * JD-Core Version:    0.7.0.1
 */