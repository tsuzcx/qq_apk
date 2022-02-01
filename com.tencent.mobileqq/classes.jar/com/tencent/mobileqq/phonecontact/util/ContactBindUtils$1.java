package com.tencent.mobileqq.phonecontact.util;

import java.util.Comparator;

final class ContactBindUtils$1
  implements Comparator<String>
{
  public int a(String paramString1, String paramString2)
  {
    if ("★".equals(paramString2)) {
      return 1;
    }
    if ("★".equals(paramString1)) {
      return -1;
    }
    if ("#".equals(paramString2)) {
      return -1;
    }
    if ("#".equals(paramString1)) {
      return 1;
    }
    return paramString1.compareTo(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.util.ContactBindUtils.1
 * JD-Core Version:    0.7.0.1
 */