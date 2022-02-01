package com.tencent.mobileqq.teamwork.api.impl;

import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import java.util.List;

class TeamWorkUtilsImpl$2
  implements Runnable
{
  TeamWorkUtilsImpl$2(TeamWorkUtilsImpl paramTeamWorkUtilsImpl, String paramString1, String paramString2, int paramInt, List paramList) {}
  
  public void run()
  {
    Object localObject = this.a.split("\\$");
    if (localObject.length == 2)
    {
      String str1 = this.b;
      String str2 = localObject[0];
      String str3 = localObject[1];
      if (this.c == 0) {
        localObject = this.d;
      } else {
        localObject = null;
      }
      List localList1;
      if (this.c == 1) {
        localList1 = this.d;
      } else {
        localList1 = null;
      }
      List localList2;
      if (this.c == 3000) {
        localList2 = this.d;
      } else {
        localList2 = null;
      }
      TeamWorkHandlerUtils.a(str1, str2, str3, false, false, 1, (List)localObject, localList1, localList2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkUtilsImpl.2
 * JD-Core Version:    0.7.0.1
 */