package com.tencent.qapmsdk.socket.handler;

import android.text.TextUtils;

class PathResolver$DefaultPathResolver
  implements IPathResolver
{
  public String resolve(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.PathResolver.DefaultPathResolver
 * JD-Core Version:    0.7.0.1
 */