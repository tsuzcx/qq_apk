package com.tencent.mobileqq.facetoface;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.statistics.ReportController;
import java.io.UnsupportedEncodingException;

class Face2FaceAddFriendActivity$2
  implements TextWatcher
{
  Face2FaceAddFriendActivity$2(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  private int a(String paramString)
  {
    byte[] arrayOfByte = new byte[0];
    try
    {
      paramString = paramString.getBytes("utf-8");
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
      paramString = arrayOfByte;
    }
    if (paramString.length % 3 == 0) {
      return paramString.length / 3;
    }
    return paramString.length / 3 + 1;
  }
  
  private String a(String paramString)
  {
    while (a(paramString) > 32)
    {
      int i = paramString.length();
      if (i >= 2)
      {
        int j = i - 2;
        if (Character.isHighSurrogate(paramString.charAt(j)))
        {
          paramString = paramString.substring(0, j);
          continue;
        }
      }
      paramString = paramString.substring(0, i - 1);
    }
    return paramString;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.a.getText().toString();
    if (a(paramEditable) > 32)
    {
      int i = this.a.a.getSelectionStart();
      paramEditable = a(paramEditable);
      this.a.a.setText(paramEditable);
      if (i >= paramEditable.length()) {
        this.a.a.setSelection(paramEditable.length());
      }
    }
    if (this.a.h)
    {
      ReportController.b(null, "CliOper", "", "", "0X80050F0", "0X80050F0", 0, 0, "", "", "", "");
      this.a.h = false;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.2
 * JD-Core Version:    0.7.0.1
 */