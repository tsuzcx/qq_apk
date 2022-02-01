package com.tencent.mobileqq.fragment;

import android.view.View;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class NearbyHybridFragment$19
  implements ActionSheet.OnButtonClickListener
{
  NearbyHybridFragment$19(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        if (this.a.k.getMyTabCardCache() == null) {
          this.a.k.getMyTabCard();
        }
        if ((NetworkUtil.isNetSupport(BaseApplication.getContext())) && (!this.a.ag.isFinishing()))
        {
          MineFragment.a(this.a.k);
          this.a.ag.finish();
        }
        else
        {
          QQToast.makeText(BaseApplication.getContext(), 1, this.a.getString(2131892102), 0).show(this.a.ag.getTitleBarHeight());
        }
      }
    }
    else {
      this.a.x();
    }
    if (this.a.ad != null) {
      this.a.ad.dismiss();
    }
    this.a.w();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.19
 * JD-Core Version:    0.7.0.1
 */