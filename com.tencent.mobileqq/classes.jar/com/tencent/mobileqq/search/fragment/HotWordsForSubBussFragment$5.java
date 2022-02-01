package com.tencent.mobileqq.search.fragment;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySearchTipsContainer.OnTipClickListener;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.util.SearchUtils;

class HotWordsForSubBussFragment$5
  implements ReadInJoySearchTipsContainer.OnTipClickListener
{
  HotWordsForSubBussFragment$5(HotWordsForSubBussFragment paramHotWordsForSubBussFragment) {}
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      FragmentActivity localFragmentActivity = this.a.getActivity();
      if ((localFragmentActivity instanceof ActiveEntitySearchActivity))
      {
        ((ActiveEntitySearchActivity)localFragmentActivity).b(paramString);
        if (this.a.a != null) {
          SearchUtils.a("sub_result", "clk_hot", new String[] { paramString, SearchUtils.a(this.a.a) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment.5
 * JD-Core Version:    0.7.0.1
 */