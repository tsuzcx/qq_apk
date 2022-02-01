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
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, List<Object> paramList1, List<Object> paramList2, String paramString1, int paramInt3, int paramInt4, String paramString2)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1 = true;
    if (!paramBoolean)
    {
      if (ChooseInterestTagActivity.access$900(this.a).getVisibility() == 0)
      {
        paramList1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramList1 = HardCodeUtil.a(2131900012);
        }
        ChooseInterestTagActivity.access$1700(this.a).setText(paramList1);
        ChooseInterestTagActivity.access$1700(this.a).setOnClickListener(ChooseInterestTagActivity.access$1800(this.a));
        return;
      }
      if (ChooseInterestTagActivity.access$1900(this.a).getVisibility() == 0)
      {
        paramList1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramList1 = HardCodeUtil.a(2131900030);
        }
        ChooseInterestTagActivity.access$2000(this.a).setText(paramList1);
        ChooseInterestTagActivity.access$2100(this.a).setVisibility(8);
        return;
      }
      paramList1 = this.a;
      if (paramInt3 != -1) {
        paramBoolean = bool1;
      } else {
        paramBoolean = false;
      }
      ChooseInterestTagActivity.access$1400(paramList1, false, paramBoolean);
      return;
    }
    if (paramInt1 != ChooseInterestTagActivity.access$000(this.a))
    {
      if (ChooseInterestTagActivity.access$900(this.a).getVisibility() == 0)
      {
        ChooseInterestTagActivity.access$1700(this.a).setText(HardCodeUtil.a(2131900038));
        ChooseInterestTagActivity.access$1700(this.a).setOnClickListener(null);
        return;
      }
      if (ChooseInterestTagActivity.access$1900(this.a).getVisibility() == 0)
      {
        ChooseInterestTagActivity.access$2000(this.a).setText(HardCodeUtil.a(2131900003));
        ChooseInterestTagActivity.access$2100(this.a).setVisibility(8);
      }
      return;
    }
    if ((paramList1 != null) && (!paramList1.isEmpty()))
    {
      if (paramInt4 == 1)
      {
        if (paramList2 == null) {
          ChooseInterestTagActivity.access$2200(this.a).clear();
        } else {
          ChooseInterestTagActivity.access$2202(this.a, (ArrayList)paramList2);
        }
        ChooseInterestTagActivity.access$2300(this.a);
      }
      if (TextUtils.isEmpty(paramString1))
      {
        if (ChooseInterestTagActivity.access$900(this.a).getVisibility() == 0) {
          ChooseInterestTagActivity.access$900(this.a).setVisibility(8);
        }
        if (paramInt3 == 0) {
          ChooseInterestTagActivity.access$1000(this.a).clear();
        } else {
          ChooseInterestTagActivity.access$1000(this.a).removeAll(paramList1);
        }
        ChooseInterestTagActivity.access$1000(this.a).addAll(paramList1);
        if (ChooseInterestTagActivity.access$1100(this.a) == null)
        {
          paramList1 = this.a;
          ChooseInterestTagActivity.access$1102(paramList1, new InterestTagAdapter(paramList1, ChooseInterestTagActivity.access$000(paramList1), ChooseInterestTagActivity.access$1000(this.a), ChooseInterestTagActivity.access$1200(this.a)));
          ChooseInterestTagActivity.access$1300(this.a).setAdapter(ChooseInterestTagActivity.access$1100(this.a));
        }
        else
        {
          ChooseInterestTagActivity.access$1100(this.a).a(ChooseInterestTagActivity.access$1000(this.a), true);
        }
        ChooseInterestTagActivity.access$202(this.a, paramInt2);
        paramList1 = this.a;
        if (paramInt2 != -1) {
          paramBoolean = bool2;
        } else {
          paramBoolean = false;
        }
        ChooseInterestTagActivity.access$1400(paramList1, false, paramBoolean);
        return;
      }
      if ((!TextUtils.isEmpty(ChooseInterestTagActivity.access$700(this.a))) && (ChooseInterestTagActivity.access$700(this.a).equals(paramString1)))
      {
        if (ChooseInterestTagActivity.access$1900(this.a).getVisibility() == 0) {
          ChooseInterestTagActivity.access$1900(this.a).setVisibility(8);
        }
        if (paramInt3 == 0) {
          ChooseInterestTagActivity.access$2400(this.a).clear();
        } else {
          ChooseInterestTagActivity.access$2400(this.a).removeAll(paramList1);
        }
        ChooseInterestTagActivity.access$2400(this.a).addAll(paramList1);
        if (ChooseInterestTagActivity.access$1100(this.a) == null)
        {
          paramList1 = this.a;
          ChooseInterestTagActivity.access$1102(paramList1, new InterestTagAdapter(paramList1, ChooseInterestTagActivity.access$000(paramList1), ChooseInterestTagActivity.access$2400(this.a), ChooseInterestTagActivity.access$1200(this.a)));
          ChooseInterestTagActivity.access$1300(this.a).setAdapter(ChooseInterestTagActivity.access$1100(this.a));
        }
        else
        {
          ChooseInterestTagActivity.access$1100(this.a).a(ChooseInterestTagActivity.access$2400(this.a), true);
        }
        ChooseInterestTagActivity.access$802(this.a, paramInt2);
        paramList1 = this.a;
        if (paramInt2 != -1) {
          paramBoolean = bool3;
        } else {
          paramBoolean = false;
        }
        ChooseInterestTagActivity.access$1400(paramList1, false, paramBoolean);
      }
      return;
    }
    if (ChooseInterestTagActivity.access$900(this.a).getVisibility() == 0)
    {
      ChooseInterestTagActivity.access$1700(this.a).setText(HardCodeUtil.a(2131900017));
      ChooseInterestTagActivity.access$1700(this.a).setOnClickListener(null);
      return;
    }
    if (ChooseInterestTagActivity.access$1900(this.a).getVisibility() == 0)
    {
      ChooseInterestTagActivity.access$2000(this.a).setText(HardCodeUtil.a(2131900024));
      ChooseInterestTagActivity.access$2100(this.a).setVisibility(0);
      return;
    }
    paramList1 = this.a;
    if (paramInt2 != -1) {
      paramBoolean = bool4;
    } else {
      paramBoolean = false;
    }
    ChooseInterestTagActivity.access$1400(paramList1, false, paramBoolean);
  }
  
  public void a(boolean paramBoolean, String paramString1, List<Object> paramList, String paramString2, int paramInt1, int paramInt2)
  {
    if (!paramBoolean)
    {
      if (TextUtils.isEmpty(paramString2))
      {
        ChooseInterestTagActivity.access$2500(this.a, 2, HardCodeUtil.a(2131900028), 500);
        return;
      }
      paramString1 = this.a;
      paramList = new StringBuilder();
      paramList.append(HardCodeUtil.a(2131900002));
      paramList.append(paramString2);
      ChooseInterestTagActivity.access$2500(paramString1, 0, paramList.toString(), 500);
      return;
    }
    if ((paramInt2 == 1) && (!TextUtils.isEmpty(paramString1)))
    {
      ChooseInterestTagActivity.access$2600(this.a);
      paramList = new Intent(this.a, QQBrowserActivity.class);
      paramList.putExtra("isShowAd", false);
      paramList.putExtra("url", paramString1);
      paramList.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131901576));
      paramList.putExtra("title", HardCodeUtil.a(2131900039));
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("url = ");
        paramString2.append(paramString1);
        QLog.d("choose_interest_tag", 2, paramString2.toString());
      }
      this.a.startActivity(paramList);
      this.a.finish();
      return;
    }
    ChooseInterestTagActivity.access$2500(this.a, 1, HardCodeUtil.a(2131900018), 500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity.6
 * JD-Core Version:    0.7.0.1
 */