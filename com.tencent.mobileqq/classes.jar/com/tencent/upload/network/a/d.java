package com.tencent.upload.network.a;

import com.tencent.upload.network.route.UploadRoute;
import com.tencent.upload.uinterface.Utility.TestServerCategory;

public class d
{
  private static Utility.TestServerCategory a = Utility.TestServerCategory.NORMAL;
  
  public static void a(Utility.TestServerCategory paramTestServerCategory)
  {
    if (paramTestServerCategory == null)
    {
      a = Utility.TestServerCategory.NORMAL;
      return;
    }
    a = paramTestServerCategory;
  }
  
  public static boolean a()
  {
    return a.getType() != Utility.TestServerCategory.NORMAL.getType();
  }
  
  public static UploadRoute b()
  {
    if (a == null) {
      return null;
    }
    return a.getUploadRoute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.network.a.d
 * JD-Core Version:    0.7.0.1
 */