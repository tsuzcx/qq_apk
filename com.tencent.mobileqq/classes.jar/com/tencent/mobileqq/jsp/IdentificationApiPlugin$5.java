package com.tencent.mobileqq.jsp;

import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class IdentificationApiPlugin$5
  implements QQPermissionCallback
{
  IdentificationApiPlugin$5(IdentificationApiPlugin paramIdentificationApiPlugin) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(IdentificationApiPlugin.a(this.a), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = this.a;
    IdentificationApiPlugin.a(paramArrayOfString, paramArrayOfString.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.IdentificationApiPlugin.5
 * JD-Core Version:    0.7.0.1
 */