package com.tencent.qapmsdk.socket.a;

import android.text.TextUtils;

class h$a
  implements c
{
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    int i;
    if (paramString.startsWith("/cgi-bin/"))
    {
      i = paramString.indexOf("?");
      if (i != -1) {
        paramString = paramString.substring("/cgi-bin/".length(), i);
      }
    }
    for (;;)
    {
      return paramString;
      paramString = paramString.substring("/cgi-bin/".length());
      continue;
      if (paramString.startsWith("/"))
      {
        i = paramString.indexOf("?");
        if (i != -1) {
          paramString = paramString.substring(1, i);
        } else {
          paramString = paramString.substring(1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.a.h.a
 * JD-Core Version:    0.7.0.1
 */