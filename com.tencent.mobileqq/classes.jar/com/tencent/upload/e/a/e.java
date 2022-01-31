package com.tencent.upload.e.a;

import java.util.concurrent.ThreadPoolExecutor;

public class e
{
  private static volatile e a;
  private c b = new c(4, 8, "UploadThread");
  private c c = new c(8, 16, "DataThread");
  
  public static e a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new e();
      }
      return a;
    }
    finally {}
  }
  
  private String a(ThreadPoolExecutor paramThreadPoolExecutor, String paramString)
  {
    int i = paramThreadPoolExecutor.getActiveCount();
    int j = paramThreadPoolExecutor.getMaximumPoolSize();
    int k = paramThreadPoolExecutor.getPoolSize();
    paramThreadPoolExecutor = new StringBuilder(" Thread pool " + paramString);
    paramThreadPoolExecutor.append(" activeNum: " + i).append(" maxNum: " + j).append(" curNum: " + k);
    return paramThreadPoolExecutor.toString();
  }
  
  public c b()
  {
    return this.b;
  }
  
  public c c()
  {
    return this.c;
  }
  
  public String toString()
  {
    String str1 = a(this.b.a(), "UploadThread");
    String str2 = a(this.c.a(), "DataThread");
    return str1 + str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.e.a.e
 * JD-Core Version:    0.7.0.1
 */