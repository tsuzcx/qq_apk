package com.tencent.mobileqq.search.fragment;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssociateSearchWordsFragment$1
  implements View.OnClickListener
{
  AssociateSearchWordsFragment$1(AssociateSearchWordsFragment paramAssociateSearchWordsFragment) {}
  
  public void onClick(View paramView)
  {
    FragmentActivity localFragmentActivity;
    Object localObject1;
    Object localObject2;
    if (paramView.getTag() != null)
    {
      localFragmentActivity = this.a.getActivity();
      localObject1 = (Integer)paramView.getTag(2131381652);
      localObject2 = (AssociateSearchWordsFragment.AssociateItem)paramView.getTag(2131381651);
      switch (((AssociateSearchWordsFragment.AssociateItem)localObject2).jdField_a_of_type_Int)
      {
      }
    }
    label224:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localFragmentActivity instanceof AssociateSearchWordsFragment.AssociateWordClickCallback))
      {
        Intent localIntent = new Intent(localFragmentActivity, QQBrowserActivity.class);
        localObject2 = ((AssociateSearchWordsFragment.AssociateItem)localObject2).e;
        localObject1 = localObject2;
        if (!((String)localObject2).startsWith("http")) {
          localObject1 = "http://" + (String)localObject2;
        }
        localIntent.putExtra("url", (String)localObject1);
        localFragmentActivity.startActivity(localIntent);
        localFragmentActivity.finish();
        continue;
        if ((localFragmentActivity instanceof AssociateSearchWordsFragment.AssociateWordClickCallback)) {
          localObject1 = (AssociateSearchWordsFragment.AssociateWordClickCallback)localFragmentActivity;
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label224;
          }
          ((AssociateSearchWordsFragment.AssociateWordClickCallback)localObject1).a(((AssociateSearchWordsFragment.AssociateItem)localObject2).jdField_a_of_type_JavaLangString, ((AssociateSearchWordsFragment.AssociateItem)localObject2).d);
          break;
          if (AssociateSearchWordsFragment.a(this.a) != null) {
            localObject1 = AssociateSearchWordsFragment.a(this.a);
          } else {
            localObject1 = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.1
 * JD-Core Version:    0.7.0.1
 */