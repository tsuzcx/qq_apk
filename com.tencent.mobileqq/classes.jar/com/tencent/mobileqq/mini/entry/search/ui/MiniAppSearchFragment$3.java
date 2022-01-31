package com.tencent.mobileqq.mini.entry.search.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.qphone.base.util.QLog;

class MiniAppSearchFragment$3
  implements TextView.OnEditorActionListener
{
  MiniAppSearchFragment$3(MiniAppSearchFragment paramMiniAppSearchFragment, MiniAppSearchDataManager paramMiniAppSearchDataManager) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    paramKeyEvent = paramTextView.getText().toString();
    if (paramInt == 3)
    {
      if (!TextUtils.isEmpty(paramKeyEvent))
      {
        this.val$searchDataManager.updateHistorySearchList(paramKeyEvent);
        QLog.d("MiniAppSearchFragment", 2, "initHistorySearch, record search content: " + paramKeyEvent);
      }
      for (;;)
      {
        ((InputMethodManager)paramTextView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramTextView.getWindowToken(), 0);
        return true;
        if (!TextUtils.isEmpty(MiniAppSearchFragment.access$200(this.this$0)))
        {
          MiniAppSearchFragment.access$000(this.this$0).setText(MiniAppSearchFragment.access$200(this.this$0));
          MiniAppSearchFragment.access$000(this.this$0).setSelection(MiniAppSearchFragment.access$200(this.this$0).length());
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment.3
 * JD-Core Version:    0.7.0.1
 */