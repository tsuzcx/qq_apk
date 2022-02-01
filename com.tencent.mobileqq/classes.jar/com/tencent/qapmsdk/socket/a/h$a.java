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
        return paramString.substring(9, i);
      }
      return paramString.substring(9);
    }
    String str = paramString;
    if (paramString.startsWith("/"))
    {
      i = paramString.indexOf("?");
      if (i != -1) {
        return paramString.substring(1, i);
      }
      str = paramString.substring(1);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.a.h.a
 * JD-Core Version:    0.7.0.1
 */