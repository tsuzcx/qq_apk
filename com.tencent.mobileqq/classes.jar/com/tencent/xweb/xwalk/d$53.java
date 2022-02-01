package com.tencent.xweb.xwalk;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import org.xwalk.core.XWalkEnvironment;

class d$53
  implements TextWatcher
{
  d$53(d paramd, EditText paramEditText) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.getText().toString();
    try
    {
      i = Integer.parseInt(paramEditable);
    }
    catch (Exception paramEditable)
    {
      int i;
      label19:
      break label19;
    }
    i = 0;
    XWalkEnvironment.setGrayValueForTest(i);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.53
 * JD-Core Version:    0.7.0.1
 */