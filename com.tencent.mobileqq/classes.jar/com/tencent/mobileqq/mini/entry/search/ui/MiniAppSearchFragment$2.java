package com.tencent.mobileqq.mini.entry.search.ui;

import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.app.BaseActivity;

class MiniAppSearchFragment$2
  implements Runnable
{
  MiniAppSearchFragment$2(MiniAppSearchFragment paramMiniAppSearchFragment) {}
  
  public void run()
  {
    if ((this.this$0.getBaseActivity() != null) && (MiniAppSearchFragment.access$100(this.this$0) != 1005)) {
      ((InputMethodManager)this.this$0.getBaseActivity().getSystemService("input_method")).showSoftInput(MiniAppSearchFragment.access$200(this.this$0), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment.2
 * JD-Core Version:    0.7.0.1
 */