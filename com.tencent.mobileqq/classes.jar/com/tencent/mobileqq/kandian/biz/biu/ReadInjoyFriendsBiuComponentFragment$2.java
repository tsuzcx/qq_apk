package com.tencent.mobileqq.kandian.biz.biu;

import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class ReadInjoyFriendsBiuComponentFragment$2
  implements AdapterView.OnItemClickListener
{
  ReadInjoyFriendsBiuComponentFragment$2(ReadInjoyFriendsBiuComponentFragment paramReadInjoyFriendsBiuComponentFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.b.doOnBackPressed();
    paramAdapterView = paramView.getTag();
    if ((paramAdapterView instanceof ReadInjoyFriendsBiuComponentFragment.ViewHolder))
    {
      paramAdapterView = (ReadInjoyFriendsBiuComponentFragment.ViewHolder)paramAdapterView;
      ReadInjoyFriendsBiuComponentFragment.a(this.a, paramAdapterView.g);
      ReadInjoyFriendsBiuComponentFragment.a(this.a, paramAdapterView.h, paramAdapterView.i, "0X800953C", paramAdapterView.j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.ReadInjoyFriendsBiuComponentFragment.2
 * JD-Core Version:    0.7.0.1
 */