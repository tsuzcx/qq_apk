package com.tencent.qqcamerakit.permission;

import java.util.ArrayList;
import java.util.List;

public class CameraPermission
{
  CameraPermission.PermissionCallback a;
  
  public void a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length == 0) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[i] != 0) {
        localArrayList1.add(paramArrayOfString[i]);
      } else {
        localArrayList2.add(paramArrayOfString[i]);
      }
      i += 1;
    }
    if (localArrayList1.size() > 0)
    {
      this.a.b(paramInt, localArrayList1);
      return;
    }
    this.a.a(paramInt, localArrayList2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.permission.CameraPermission
 * JD-Core Version:    0.7.0.1
 */