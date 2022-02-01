package com.tencent.smtt.utils;

import android.widget.TextView;

class TbsLogClient$a
  implements Runnable
{
  String a = null;
  
  TbsLogClient$a(TbsLogClient paramTbsLogClient, String paramString)
  {
    this.a = paramString;
  }
  
  public void run()
  {
    if (this.b.b != null)
    {
      TextView localTextView = this.b.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append("\n");
      localTextView.append(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.utils.TbsLogClient.a
 * JD-Core Version:    0.7.0.1
 */