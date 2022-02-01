package com.tencent.mobileqq.kandian.biz.ugc;

import android.database.DataSetObserver;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

class ReadInJoyVideoTagSelectionFragment$1
  extends DataSetObserver
{
  ReadInJoyVideoTagSelectionFragment$1(ReadInJoyVideoTagSelectionFragment paramReadInJoyVideoTagSelectionFragment) {}
  
  public void onChanged()
  {
    if (ReadInJoyVideoTagSelectionFragment.a(this.a).getCount() > 0)
    {
      ReadInJoyVideoTagSelectionFragment.a(this.a).setVisibility(0);
      Object localObject = this.a;
      localObject = ((ReadInJoyVideoTagSelectionFragment)localObject).getString(2131718058, new Object[] { Integer.valueOf(ReadInJoyVideoTagSelectionFragment.a((ReadInJoyVideoTagSelectionFragment)localObject).getCount()), Integer.valueOf(5) });
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-4473925), 5, ((String)localObject).length(), 0);
      ReadInJoyVideoTagSelectionFragment.a(this.a).setText(localSpannableStringBuilder);
      return;
    }
    ReadInJoyVideoTagSelectionFragment.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyVideoTagSelectionFragment.1
 * JD-Core Version:    0.7.0.1
 */