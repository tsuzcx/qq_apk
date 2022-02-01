package com.tencent.ttpic.videoshelf.ui;

import java.util.Comparator;
import java.util.Map.Entry;

class HttpRequestUtils$1
  implements Comparator<Map.Entry<String, String>>
{
  HttpRequestUtils$1(HttpRequestUtils paramHttpRequestUtils) {}
  
  public int compare(Map.Entry<String, String> paramEntry1, Map.Entry<String, String> paramEntry2)
  {
    return ((String)paramEntry1.getKey()).compareTo((String)paramEntry2.getKey());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.ui.HttpRequestUtils.1
 * JD-Core Version:    0.7.0.1
 */