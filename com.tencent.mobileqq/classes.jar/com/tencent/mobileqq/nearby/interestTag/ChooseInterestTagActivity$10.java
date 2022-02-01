package com.tencent.mobileqq.nearby.interestTag;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ChooseInterestTagActivity$10
  implements View.OnClickListener
{
  ChooseInterestTagActivity$10(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView == ChooseInterestTagActivity.b(this.a)) {
      if (TextUtils.isEmpty(ChooseInterestTagActivity.a(this.a)))
      {
        ChooseInterestTagActivity.a(this.a).a(ChooseInterestTagActivity.a(this.a), ChooseInterestTagActivity.a(this.a), ChooseInterestTagActivity.b(this.a), 30, 0, 0);
        ChooseInterestTagActivity.a(this.a, true, true);
      }
    }
    label394:
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        ChooseInterestTagActivity.a(this.a).a(ChooseInterestTagActivity.a(this.a), ChooseInterestTagActivity.a(this.a), ChooseInterestTagActivity.c(this.a), 30, 0, 0);
        break;
        Object localObject2;
        if (paramView == this.a.leftView)
        {
          InputMethodUtil.b(ChooseInterestTagActivity.a(this.a));
          if (ChooseInterestTagActivity.a(this.a))
          {
            this.a.finish();
          }
          else
          {
            localObject2 = this.a.getIntent();
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = new Intent();
            }
            Collections.reverse(ChooseInterestTagActivity.a(this.a));
            ((Intent)localObject1).putParcelableArrayListExtra("choosed_interest_tags", ChooseInterestTagActivity.a(this.a));
            ((Intent)localObject1).putExtra("interest_tag_type", ChooseInterestTagActivity.a(this.a));
            this.a.setResult(-1, (Intent)localObject1);
            this.a.finish();
          }
        }
        else
        {
          if (paramView != this.a.rightViewText) {
            break label394;
          }
          InputMethodUtil.b(ChooseInterestTagActivity.a(this.a));
          if (ChooseInterestTagActivity.a(this.a)) {
            if (ChooseInterestTagActivity.a(this.a).isEmpty())
            {
              ChooseInterestTagActivity.a(this.a, HardCodeUtil.a(2131701877));
            }
            else
            {
              ChooseInterestTagActivity.a(this.a, 0, HardCodeUtil.a(2131701871), 0);
              Collections.reverse(ChooseInterestTagActivity.a(this.a));
              localObject1 = new InterestTag(ChooseInterestTagActivity.a(this.a));
              ((InterestTag)localObject1).a.addAll(ChooseInterestTagActivity.a(this.a));
              localObject2 = new ArrayList(1);
              ((List)localObject2).add(localObject1);
              ChooseInterestTagActivity.a(this.a).a((List)localObject2, 0, 1);
            }
          }
        }
      }
    } while (paramView != ChooseInterestTagActivity.a(this.a));
    ChooseInterestTagActivity.a(this.a).setText(HardCodeUtil.a(2131701894));
    Object localObject1 = ChooseInterestTagActivity.a(this.a);
    int j = ChooseInterestTagActivity.a(this.a);
    int k = ChooseInterestTagActivity.b(this.a);
    if (ChooseInterestTagActivity.a(this.a)) {}
    for (int i = 1;; i = 0)
    {
      ((NearbyCardHandler)localObject1).a("", j, k, 30, 0, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity.10
 * JD-Core Version:    0.7.0.1
 */