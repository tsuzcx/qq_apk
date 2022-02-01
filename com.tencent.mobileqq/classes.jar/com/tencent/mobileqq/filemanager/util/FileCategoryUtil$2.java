package com.tencent.mobileqq.filemanager.util;

import java.util.Comparator;
import java.util.Map.Entry;

final class FileCategoryUtil$2
  implements Comparator<Map.Entry<String, Integer>>
{
  public int a(Map.Entry<String, Integer> paramEntry1, Map.Entry<String, Integer> paramEntry2)
  {
    return ((Integer)paramEntry2.getValue()).intValue() - ((Integer)paramEntry1.getValue()).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileCategoryUtil.2
 * JD-Core Version:    0.7.0.1
 */