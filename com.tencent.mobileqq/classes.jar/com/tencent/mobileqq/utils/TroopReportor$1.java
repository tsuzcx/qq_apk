package com.tencent.mobileqq.utils;

import mqq.app.AppRuntime;

final class TroopReportor$1
  implements Runnable
{
  TroopReportor$1(String paramString1, String paramString2, int paramInt1, int paramInt2, String[] paramArrayOfString, AppRuntime paramAppRuntime, String paramString3) {}
  
  public void run()
  {
    String str1 = this.a;
    String str2 = this.b;
    int i = this.c;
    int j = this.d;
    String str3 = this.e[0];
    Object localObject = this.f;
    localObject = TroopReportor.a((AppRuntime)localObject, this.g, ((AppRuntime)localObject).getCurrentAccountUin());
    String[] arrayOfString = this.e;
    TroopReportor.a("Grp_edu", str1, str2, i, j, new String[] { str3, localObject, arrayOfString[2], arrayOfString[3] });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.TroopReportor.1
 * JD-Core Version:    0.7.0.1
 */