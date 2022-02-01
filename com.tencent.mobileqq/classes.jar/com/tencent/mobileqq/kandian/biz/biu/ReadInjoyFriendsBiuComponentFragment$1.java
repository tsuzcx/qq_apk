package com.tencent.mobileqq.kandian.biz.biu;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.repo.biu.MultiBiuSameContent;
import java.util.ArrayList;

class ReadInjoyFriendsBiuComponentFragment$1
  implements View.OnClickListener
{
  ReadInjoyFriendsBiuComponentFragment$1(ReadInjoyFriendsBiuComponentFragment paramReadInjoyFriendsBiuComponentFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.b.doOnBackPressed();
    Object localObject1 = paramView.getTag();
    try
    {
      i = Integer.valueOf(localObject1.toString()).intValue();
    }
    catch (Exception localException)
    {
      int i;
      label29:
      Object localObject2;
      break label29;
    }
    i = -1;
    localObject2 = null;
    localObject1 = localObject2;
    if (i >= 0)
    {
      localObject1 = localObject2;
      if (i < this.a.e.size()) {
        localObject1 = (MultiBiuSameContent)this.a.e.get(i);
      }
    }
    i = paramView.getId();
    if (i != 2131431033)
    {
      if ((i != 2131434914) && (i != 2131439303)) {
        return;
      }
      if (localObject1 != null)
      {
        paramView = ReadInjoyFriendsBiuComponentFragment.a(this.a, ((MultiBiuSameContent)localObject1).a);
        ReadInjoyFriendsBiuComponentFragment.a(this.a, paramView);
        ReadInjoyFriendsBiuComponentFragment.a(this.a, ((MultiBiuSameContent)localObject1).a, ((MultiBiuSameContent)localObject1).e, "0X800953D", ((MultiBiuSameContent)localObject1).f);
      }
    }
    else if (localObject1 != null)
    {
      paramView = ReadInjoyFriendsBiuComponentFragment.a(this.a, ((MultiBiuSameContent)localObject1).a, ((MultiBiuSameContent)localObject1).f, ((MultiBiuSameContent)localObject1).e);
      ReadInjoyFriendsBiuComponentFragment.a(this.a, paramView);
      ReadInjoyFriendsBiuComponentFragment.a(this.a, ((MultiBiuSameContent)localObject1).a, ((MultiBiuSameContent)localObject1).e, "0X800953C", ((MultiBiuSameContent)localObject1).f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.ReadInjoyFriendsBiuComponentFragment.1
 * JD-Core Version:    0.7.0.1
 */