package com.tencent.mobileqq.streamtransfile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StreamMemoryPool
{
  private static HashMap<String, StreamFileInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static HashMap<String, StreamFileInfo> a()
  {
    return jdField_a_of_type_JavaUtilHashMap;
  }
  
  public static List<String> a()
  {
    return jdField_a_of_type_JavaUtilList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.streamtransfile.StreamMemoryPool
 * JD-Core Version:    0.7.0.1
 */