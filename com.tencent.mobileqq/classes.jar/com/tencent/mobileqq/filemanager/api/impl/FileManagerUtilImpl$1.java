package com.tencent.mobileqq.filemanager.api.impl;

import java.util.Comparator;
import java.util.Map.Entry;

class FileManagerUtilImpl$1
  implements Comparator<Map.Entry<String, Integer>>
{
  FileManagerUtilImpl$1(FileManagerUtilImpl paramFileManagerUtilImpl) {}
  
  public int a(Map.Entry<String, Integer> paramEntry1, Map.Entry<String, Integer> paramEntry2)
  {
    return ((Integer)paramEntry2.getValue()).intValue() - ((Integer)paramEntry1.getValue()).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.FileManagerUtilImpl.1
 * JD-Core Version:    0.7.0.1
 */