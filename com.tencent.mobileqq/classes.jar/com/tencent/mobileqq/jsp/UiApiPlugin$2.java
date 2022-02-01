package com.tencent.mobileqq.jsp;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;

class UiApiPlugin$2
  implements DialogInterface.OnClickListener
{
  UiApiPlugin$2(UiApiPlugin paramUiApiPlugin, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (paramInt == 0)
    {
      if (!TextUtils.isEmpty(this.a))
      {
        paramDialogInterface = this.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.a);
        localStringBuilder.append("({button: 1})");
        paramDialogInterface.callJs(localStringBuilder.toString());
        return;
      }
      this.b.callJs4OpenApiIfNeeded("showDialog", 0, "({button: 1})");
      return;
    }
    if (paramInt == 1)
    {
      if (!TextUtils.isEmpty(this.a))
      {
        paramDialogInterface = this.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.a);
        localStringBuilder.append("({button: 0})");
        paramDialogInterface.callJs(localStringBuilder.toString());
        return;
      }
      this.b.callJs4OpenApiIfNeeded("showDialog", 0, "({button: 0})");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.2
 * JD-Core Version:    0.7.0.1
 */