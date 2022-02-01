package com.tencent.mobileqq.search.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssociateSearchWordsFragment$1
  implements View.OnClickListener
{
  AssociateSearchWordsFragment$1(AssociateSearchWordsFragment paramAssociateSearchWordsFragment) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() != null)
    {
      BaseActivity localBaseActivity = this.a.getBaseActivity();
      Object localObject1 = (Integer)paramView.getTag(2131449868);
      Object localObject2 = (AssociateSearchWordsFragment.AssociateItem)paramView.getTag(2131449867);
      int i = ((AssociateSearchWordsFragment.AssociateItem)localObject2).a;
      if (i != 2)
      {
        if ((i == 3) || ((i != 4) && (i == 6)))
        {
          localObject1 = null;
          if ((localBaseActivity instanceof AssociateSearchWordsFragment.AssociateWordClickCallback)) {
            localObject1 = (AssociateSearchWordsFragment.AssociateWordClickCallback)localBaseActivity;
          } else if (AssociateSearchWordsFragment.a(this.a) != null) {
            localObject1 = AssociateSearchWordsFragment.a(this.a);
          }
          if (localObject1 != null) {
            ((AssociateSearchWordsFragment.AssociateWordClickCallback)localObject1).a(((AssociateSearchWordsFragment.AssociateItem)localObject2).b, ((AssociateSearchWordsFragment.AssociateItem)localObject2).i);
          }
        }
      }
      else if ((localBaseActivity instanceof AssociateSearchWordsFragment.AssociateWordClickCallback))
      {
        Intent localIntent = new Intent(localBaseActivity, QQBrowserActivity.class);
        localObject2 = ((AssociateSearchWordsFragment.AssociateItem)localObject2).h;
        localObject1 = localObject2;
        if (!((String)localObject2).startsWith("http"))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("http://");
          ((StringBuilder)localObject1).append((String)localObject2);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localIntent.putExtra("url", (String)localObject1);
        localBaseActivity.startActivity(localIntent);
        localBaseActivity.finish();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.1
 * JD-Core Version:    0.7.0.1
 */