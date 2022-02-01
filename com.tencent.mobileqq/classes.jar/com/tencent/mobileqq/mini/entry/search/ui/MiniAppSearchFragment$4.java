package com.tencent.mobileqq.mini.entry.search.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qphone.base.util.QLog;

class MiniAppSearchFragment$4
  implements TextView.OnEditorActionListener
{
  MiniAppSearchFragment$4(MiniAppSearchFragment paramMiniAppSearchFragment, MiniAppSearchDataManager paramMiniAppSearchDataManager) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    paramKeyEvent = paramTextView.getText().toString();
    if (paramInt == 3)
    {
      if (!TextUtils.isEmpty(paramKeyEvent))
      {
        this.val$searchDataManager.updateHistorySearchList(paramKeyEvent);
        QLog.d("MiniAppSearchFragment", 2, "initHistorySearch, record search content: " + paramKeyEvent);
        MiniProgramLpReportDC04239.reportAsync("desktop", "search", "search_button", paramKeyEvent);
      }
      for (;;)
      {
        ((InputMethodManager)paramTextView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramTextView.getWindowToken(), 0);
        return true;
        if (!TextUtils.isEmpty(MiniAppSearchFragment.access$400(this.this$0)))
        {
          MiniAppSearchFragment.access$200(this.this$0).setText(MiniAppSearchFragment.access$400(this.this$0));
          MiniAppSearchFragment.access$200(this.this$0).setSelection(MiniAppSearchFragment.access$400(this.this$0).length());
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment.4
 * JD-Core Version:    0.7.0.1
 */