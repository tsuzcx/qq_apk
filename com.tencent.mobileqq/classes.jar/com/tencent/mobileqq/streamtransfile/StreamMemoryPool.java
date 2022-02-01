package com.tencent.mobileqq.streamtransfile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StreamMemoryPool
{
  private static HashMap<String, StreamFileInfo> a = new HashMap();
  private static List<String> b = new ArrayList();
  
  public static HashMap<String, StreamFileInfo> a()
  {
    return a;
  }
  
  public static List<String> b()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.streamtransfile.StreamMemoryPool
 * JD-Core Version:    0.7.0.1
 */