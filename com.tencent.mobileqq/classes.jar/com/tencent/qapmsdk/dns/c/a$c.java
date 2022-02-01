package com.tencent.qapmsdk.dns.c;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class a$c
  extends a
{
  public List<String> a(String paramString, List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return paramList;
    }
    int j = new Random().nextInt(paramList.size());
    paramString = new ArrayList();
    paramString.add(paramList.get(j));
    int i = 0;
    if (i < paramList.size())
    {
      if (i == j) {}
      for (;;)
      {
        i += 1;
        break;
        paramString.add(paramList.get(i));
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.c.a.c
 * JD-Core Version:    0.7.0.1
 */