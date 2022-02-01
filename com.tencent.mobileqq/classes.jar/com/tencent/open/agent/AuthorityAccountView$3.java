package com.tencent.open.agent;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AuthorityAccountView$3
  implements View.OnClickListener
{
  AuthorityAccountView$3(AuthorityAccountView paramAuthorityAccountView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof String))) {
      this.a.b((String)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityAccountView.3
 * JD-Core Version:    0.7.0.1
 */