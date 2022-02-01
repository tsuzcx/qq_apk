package com.tencent.mobileqq.nearby.interestTag;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;

class ChooseInterestTagActivity$14
  implements InterestTagItemView.IInterestTagItemViewCallback
{
  ChooseInterestTagActivity$14(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void a(InterestTagInfo paramInterestTagInfo)
  {
    ChooseInterestTagActivity.access$2900(this.a, 0);
    InputMethodUtil.b(ChooseInterestTagActivity.access$2700(this.a));
    if (!TextUtils.isEmpty(ChooseInterestTagActivity.access$700(this.a)))
    {
      ChooseInterestTagActivity.access$1100(this.a).a(ChooseInterestTagActivity.access$1000(this.a), true);
      ChooseInterestTagActivity localChooseInterestTagActivity = this.a;
      boolean bool;
      if (ChooseInterestTagActivity.access$200(localChooseInterestTagActivity) != -1) {
        bool = true;
      } else {
        bool = false;
      }
      ChooseInterestTagActivity.access$1400(localChooseInterestTagActivity, false, bool);
      ChooseInterestTagActivity.access$2700(this.a).setText("");
      ChooseInterestTagActivity.access$702(this.a, "");
    }
    if (ChooseInterestTagActivity.access$3700(this.a, paramInterestTagInfo))
    {
      ChooseInterestTagActivity.access$2200(this.a).remove(paramInterestTagInfo);
      ChooseInterestTagActivity.access$3400(this.a, paramInterestTagInfo);
      return;
    }
    if (ChooseInterestTagActivity.access$2200(this.a).size() >= 8)
    {
      if (!ChooseInterestTagActivity.access$3800(this.a))
      {
        ChooseInterestTagActivity.access$1600(this.a, "最多只能添加8个标签哦");
        ChooseInterestTagActivity.access$3802(this.a, true);
        ChooseInterestTagActivity.access$400(this.a).postDelayed(new ChooseInterestTagActivity.14.1(this), 2800L);
      }
    }
    else
    {
      ChooseInterestTagActivity.access$2200(this.a).add(paramInterestTagInfo);
      ChooseInterestTagActivity.access$3900(this.a, paramInterestTagInfo);
    }
  }
  
  public boolean a(InterestTagInfo paramInterestTagInfo)
  {
    return ChooseInterestTagActivity.access$3700(this.a, paramInterestTagInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity.14
 * JD-Core Version:    0.7.0.1
 */