package com.tencent.mobileqq.transfile;

import ConfigPush.FileStorageServerListInfo;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class FMTSrvAddrProvider$PttIpList
{
  public String a;
  public ArrayList a;
  public int[] a;
  public String b;
  public ArrayList b;
  public int[] b;
  
  public FMTSrvAddrProvider$PttIpList()
  {
    this.jdField_a_of_type_ArrayOfInt = new int[6];
    this.jdField_b_of_type_ArrayOfInt = new int[6];
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public ArrayList a(String paramString)
  {
    if ((paramString != null) && (paramString.equals(this.jdField_a_of_type_JavaLangString))) {
      return this.jdField_a_of_type_JavaUtilArrayList;
    }
    if ((paramString != null) && (paramString.equals(this.jdField_b_of_type_JavaLangString))) {
      return this.jdField_b_of_type_JavaUtilArrayList;
    }
    return null;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_JavaUtilArrayList.size()];
    }
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)) {
      this.jdField_b_of_type_ArrayOfInt = new int[this.jdField_b_of_type_JavaUtilArrayList.size()];
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (paramString1 != null) {}
    for (;;)
    {
      try
      {
        int i;
        if (paramString1.equals(this.jdField_a_of_type_JavaLangString))
        {
          localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
          paramString1 = this.jdField_a_of_type_ArrayOfInt;
          if ((localArrayList == null) || (localArrayList.size() <= 0) || (paramString1 == null) || (paramString1.length <= 0)) {
            break;
          }
          paramString2 = new URL(paramString2).getHost();
          if ((paramString2 == null) || (paramString2.length() <= 0)) {
            break;
          }
          i = 0;
          if (i >= localArrayList.size()) {
            break;
          }
          String str = ((FileStorageServerListInfo)localArrayList.get(i)).sIP;
          if ((str != null) && (str.equalsIgnoreCase(paramString2)))
          {
            if (paramString1.length <= i) {
              break;
            }
            paramString1[i] += 1;
          }
        }
        else
        {
          if ((paramString1 == null) || (!paramString1.equals(this.jdField_b_of_type_JavaLangString))) {
            break label163;
          }
          localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
          paramString1 = this.jdField_b_of_type_ArrayOfInt;
          continue;
        }
        i += 1;
        continue;
        paramString1 = null;
      }
      catch (MalformedURLException paramString1)
      {
        return;
      }
      label163:
      ArrayList localArrayList = null;
    }
  }
  
  public int[] a(String paramString)
  {
    if ((paramString != null) && (paramString.equals(this.jdField_a_of_type_JavaLangString))) {
      return this.jdField_a_of_type_ArrayOfInt;
    }
    if ((paramString != null) && (paramString.equals(this.jdField_b_of_type_JavaLangString))) {
      return this.jdField_b_of_type_ArrayOfInt;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FMTSrvAddrProvider.PttIpList
 * JD-Core Version:    0.7.0.1
 */