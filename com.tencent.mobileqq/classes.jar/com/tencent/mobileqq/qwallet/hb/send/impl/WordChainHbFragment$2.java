package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.res.Resources;
import android.graphics.Color;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.ArrayList;
import java.util.Iterator;

class WordChainHbFragment$2
  implements Runnable
{
  WordChainHbFragment$2(WordChainHbFragment paramWordChainHbFragment) {}
  
  public void run()
  {
    if ((WordChainHbFragment.a(this.this$0) != null) && (WordChainHbFragment.a(this.this$0).size() > 0) && (WordChainHbFragment.a(this.this$0) != null))
    {
      Iterator localIterator = WordChainHbFragment.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        WordChainHbFragment.WordChainTypeLabel localWordChainTypeLabel = (WordChainHbFragment.WordChainTypeLabel)localIterator.next();
        TextView localTextView = new TextView(this.this$0.a);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        localMarginLayoutParams.leftMargin = ScreenUtil.dip2px(5.0F);
        localMarginLayoutParams.rightMargin = ScreenUtil.dip2px(5.0F);
        localMarginLayoutParams.bottomMargin = ScreenUtil.dip2px(10.0F);
        WordChainHbFragment.a(this.this$0).addView(localTextView, localMarginLayoutParams);
        localTextView.setText(localWordChainTypeLabel.a);
        localTextView.setPadding(ScreenUtil.dip2px(16.0F), ScreenUtil.dip2px(5.0F), ScreenUtil.dip2px(16.0F), ScreenUtil.dip2px(5.0F));
        localTextView.setTextColor(Color.parseColor("#03081A"));
        localTextView.setTag(localWordChainTypeLabel);
        localTextView.setBackgroundDrawable(this.this$0.getResources().getDrawable(R.drawable.W));
        localTextView.setOnClickListener(new WordChainHbFragment.2.1(this, localTextView, localWordChainTypeLabel));
      }
      WordChainHbFragment.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.WordChainHbFragment.2
 * JD-Core Version:    0.7.0.1
 */