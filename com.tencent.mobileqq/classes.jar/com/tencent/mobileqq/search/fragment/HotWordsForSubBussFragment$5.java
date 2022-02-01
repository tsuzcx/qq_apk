package com.tencent.mobileqq.search.fragment;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.search.api.OnTipClickListener;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.util.SearchUtils;

class HotWordsForSubBussFragment$5
  implements OnTipClickListener
{
  HotWordsForSubBussFragment$5(HotWordsForSubBussFragment paramHotWordsForSubBussFragment) {}
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      BaseActivity localBaseActivity = this.a.getBaseActivity();
      if ((localBaseActivity instanceof ActiveEntitySearchActivity))
      {
        ((ActiveEntitySearchActivity)localBaseActivity).b(paramString);
        if (this.a.a != null) {
          SearchUtils.a("sub_result", "clk_hot", new String[] { paramString, SearchUtils.a(this.a.a) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment.5
 * JD-Core Version:    0.7.0.1
 */