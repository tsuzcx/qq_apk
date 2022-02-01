package com.tencent.mobileqq.filemanager.core;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileIPv6StrateyController$IPListInfo
{
  public int a;
  public List<FileIPv6StrateyController.IPInfo> a;
  
  public FileIPv6StrateyController$IPListInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0);
  }
  
  public String toString()
  {
    if (a()) {
      localObject = "TPType:" + this.jdField_a_of_type_Int + "IPList:";
    }
    String str;
    Iterator localIterator;
    do
    {
      return localObject;
      str = "TPType:" + this.jdField_a_of_type_Int + "IPList:";
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      localObject = str;
    } while (!localIterator.hasNext());
    Object localObject = (FileIPv6StrateyController.IPInfo)localIterator.next();
    if (localObject != null) {
      if (!TextUtils.isEmpty(((FileIPv6StrateyController.IPInfo)localObject).jdField_a_of_type_JavaLangString))
      {
        localObject = ((FileIPv6StrateyController.IPInfo)localObject).jdField_a_of_type_JavaLangString + ":" + ((FileIPv6StrateyController.IPInfo)localObject).jdField_a_of_type_Int + " ";
        label145:
        str = str + (String)localObject;
      }
    }
    for (;;)
    {
      break;
      localObject = ":" + ((FileIPv6StrateyController.IPInfo)localObject).jdField_a_of_type_Int + " ";
      break label145;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.IPListInfo
 * JD-Core Version:    0.7.0.1
 */