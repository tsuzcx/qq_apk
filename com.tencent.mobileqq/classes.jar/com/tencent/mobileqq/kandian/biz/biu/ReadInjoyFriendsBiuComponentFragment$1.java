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
    this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.doOnBackPressed();
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
      if (i < this.a.jdField_a_of_type_JavaUtilArrayList.size()) {
        localObject1 = (MultiBiuSameContent)this.a.jdField_a_of_type_JavaUtilArrayList.get(i);
      }
    }
    i = paramView.getId();
    if (i != 2131364910)
    {
      if ((i != 2131368064) && (i != 2131371862)) {
        return;
      }
      if (localObject1 != null)
      {
        paramView = ReadInjoyFriendsBiuComponentFragment.a(this.a, ((MultiBiuSameContent)localObject1).a);
        ReadInjoyFriendsBiuComponentFragment.a(this.a, paramView);
        ReadInjoyFriendsBiuComponentFragment.a(this.a, ((MultiBiuSameContent)localObject1).a, ((MultiBiuSameContent)localObject1).b, "0X800953D", ((MultiBiuSameContent)localObject1).c);
      }
    }
    else if (localObject1 != null)
    {
      paramView = ReadInjoyFriendsBiuComponentFragment.a(this.a, ((MultiBiuSameContent)localObject1).a, ((MultiBiuSameContent)localObject1).c, ((MultiBiuSameContent)localObject1).b);
      ReadInjoyFriendsBiuComponentFragment.a(this.a, paramView);
      ReadInjoyFriendsBiuComponentFragment.a(this.a, ((MultiBiuSameContent)localObject1).a, ((MultiBiuSameContent)localObject1).b, "0X800953C", ((MultiBiuSameContent)localObject1).c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.ReadInjoyFriendsBiuComponentFragment.1
 * JD-Core Version:    0.7.0.1
 */