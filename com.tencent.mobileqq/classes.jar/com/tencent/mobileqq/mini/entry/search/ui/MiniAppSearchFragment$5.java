package com.tencent.mobileqq.mini.entry.search.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;

class MiniAppSearchFragment$5
  implements View.OnClickListener
{
  MiniAppSearchFragment$5(MiniAppSearchFragment paramMiniAppSearchFragment, TextView paramTextView, MiniAppSearchDataManager paramMiniAppSearchDataManager) {}
  
  public void onClick(View paramView)
  {
    String str = this.val$tv.getText().toString();
    MiniAppSearchFragment.access$200(this.this$0).setText(this.val$tv.getText());
    MiniAppSearchFragment.access$200(this.this$0).setSelection(this.val$tv.getText().length());
    this.val$searchDataManager.updateHistorySearchList(str);
    ((InputMethodManager)paramView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    MiniProgramLpReportDC04239.reportAsync("desktop", "search", "history_click", str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment.5
 * JD-Core Version:    0.7.0.1
 */