package com.tencent.mobileqq.nearby.interestTag;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class ChooseInterestTagActivity$6
  extends NearbyCardObserver
{
  ChooseInterestTagActivity$6(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, List<InterestTagInfo> paramList1, List<InterestTagInfo> paramList2, String paramString1, int paramInt3, int paramInt4, String paramString2)
  {
    if (!paramBoolean) {
      if (ChooseInterestTagActivity.a(this.a).getVisibility() == 0)
      {
        paramList1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramList1 = HardCodeUtil.a(2131701859);
        }
        ChooseInterestTagActivity.a(this.a).setText(paramList1);
        ChooseInterestTagActivity.a(this.a).setOnClickListener(ChooseInterestTagActivity.a(this.a));
      }
    }
    label441:
    label587:
    label608:
    do
    {
      do
      {
        return;
        if (ChooseInterestTagActivity.b(this.a).getVisibility() == 0)
        {
          paramList1 = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            paramList1 = HardCodeUtil.a(2131701878);
          }
          ChooseInterestTagActivity.b(this.a).setText(paramList1);
          ChooseInterestTagActivity.c(this.a).setVisibility(8);
          return;
        }
        paramList1 = this.a;
        if (paramInt3 != -1) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          ChooseInterestTagActivity.a(paramList1, false, paramBoolean);
          return;
        }
        if (paramInt1 == ChooseInterestTagActivity.a(this.a)) {
          break;
        }
        if (ChooseInterestTagActivity.a(this.a).getVisibility() == 0)
        {
          ChooseInterestTagActivity.a(this.a).setText(HardCodeUtil.a(2131701886));
          ChooseInterestTagActivity.a(this.a).setOnClickListener(null);
          return;
        }
      } while (ChooseInterestTagActivity.b(this.a).getVisibility() != 0);
      ChooseInterestTagActivity.b(this.a).setText(HardCodeUtil.a(2131701850));
      ChooseInterestTagActivity.c(this.a).setVisibility(8);
      return;
      if ((paramList1 == null) || (paramList1.isEmpty()))
      {
        if (ChooseInterestTagActivity.a(this.a).getVisibility() == 0)
        {
          ChooseInterestTagActivity.a(this.a).setText(HardCodeUtil.a(2131701864));
          ChooseInterestTagActivity.a(this.a).setOnClickListener(null);
          return;
        }
        if (ChooseInterestTagActivity.b(this.a).getVisibility() == 0)
        {
          ChooseInterestTagActivity.b(this.a).setText(HardCodeUtil.a(2131701872));
          ChooseInterestTagActivity.c(this.a).setVisibility(0);
          return;
        }
        paramList1 = this.a;
        if (paramInt2 != -1) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          ChooseInterestTagActivity.a(paramList1, false, paramBoolean);
          return;
        }
      }
      if (paramInt4 == 1)
      {
        if (paramList2 == null)
        {
          ChooseInterestTagActivity.a(this.a).clear();
          ChooseInterestTagActivity.a(this.a);
        }
      }
      else
      {
        if (!TextUtils.isEmpty(paramString1)) {
          continue;
        }
        if (ChooseInterestTagActivity.a(this.a).getVisibility() == 0) {
          ChooseInterestTagActivity.a(this.a).setVisibility(8);
        }
        if (paramInt3 != 0) {
          break label569;
        }
        ChooseInterestTagActivity.a(this.a).clear();
        ChooseInterestTagActivity.a(this.a).addAll(paramList1);
        if (ChooseInterestTagActivity.a(this.a) != null) {
          break label587;
        }
        ChooseInterestTagActivity.a(this.a, new InterestTagAdapter(this.a, ChooseInterestTagActivity.a(this.a), ChooseInterestTagActivity.a(this.a), ChooseInterestTagActivity.a(this.a)));
        ChooseInterestTagActivity.a(this.a).setAdapter(ChooseInterestTagActivity.a(this.a));
        ChooseInterestTagActivity.a(this.a, paramInt2);
        paramList1 = this.a;
        if (paramInt2 == -1) {
          break label608;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        ChooseInterestTagActivity.a(paramList1, false, paramBoolean);
        return;
        ChooseInterestTagActivity.a(this.a, (ArrayList)paramList2);
        break;
        ChooseInterestTagActivity.a(this.a).removeAll(paramList1);
        break label441;
        ChooseInterestTagActivity.a(this.a).a(ChooseInterestTagActivity.a(this.a), true);
        break label523;
      }
    } while ((TextUtils.isEmpty(ChooseInterestTagActivity.a(this.a))) || (!ChooseInterestTagActivity.a(this.a).equals(paramString1)));
    label523:
    label569:
    if (ChooseInterestTagActivity.b(this.a).getVisibility() == 0) {
      ChooseInterestTagActivity.b(this.a).setVisibility(8);
    }
    if (paramInt3 == 0)
    {
      ChooseInterestTagActivity.b(this.a).clear();
      ChooseInterestTagActivity.b(this.a).addAll(paramList1);
      if (ChooseInterestTagActivity.a(this.a) != null) {
        break label813;
      }
      ChooseInterestTagActivity.a(this.a, new InterestTagAdapter(this.a, ChooseInterestTagActivity.a(this.a), ChooseInterestTagActivity.b(this.a), ChooseInterestTagActivity.a(this.a)));
      ChooseInterestTagActivity.a(this.a).setAdapter(ChooseInterestTagActivity.a(this.a));
      label765:
      ChooseInterestTagActivity.b(this.a, paramInt2);
      paramList1 = this.a;
      if (paramInt2 == -1) {
        break label834;
      }
    }
    label813:
    label834:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ChooseInterestTagActivity.a(paramList1, false, paramBoolean);
      return;
      ChooseInterestTagActivity.b(this.a).removeAll(paramList1);
      break;
      ChooseInterestTagActivity.a(this.a).a(ChooseInterestTagActivity.b(this.a), true);
      break label765;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, List<InterestTag> paramList, String paramString2, int paramInt1, int paramInt2)
  {
    if (!paramBoolean)
    {
      if (TextUtils.isEmpty(paramString2))
      {
        ChooseInterestTagActivity.a(this.a, 2, HardCodeUtil.a(2131701876), 500);
        return;
      }
      ChooseInterestTagActivity.a(this.a, 0, HardCodeUtil.a(2131701849) + paramString2, 500);
      return;
    }
    if ((paramInt2 == 1) && (!TextUtils.isEmpty(paramString1)))
    {
      ChooseInterestTagActivity.b(this.a);
      paramList = new Intent(this.a, QQBrowserActivity.class);
      paramList.putExtra("isShowAd", false);
      paramList.putExtra("url", paramString1);
      paramList.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131701865));
      paramList.putExtra("title", HardCodeUtil.a(2131701887));
      if (QLog.isColorLevel()) {
        QLog.d("choose_interest_tag", 2, "url = " + paramString1);
      }
      this.a.startActivity(paramList);
      this.a.finish();
      return;
    }
    ChooseInterestTagActivity.a(this.a, 1, HardCodeUtil.a(2131701866), 500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity.6
 * JD-Core Version:    0.7.0.1
 */