package com.tencent.mobileqq.teamwork.qipc;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;

class TDFileQIPCModule$1
  implements Runnable
{
  TDFileQIPCModule$1(TDFileQIPCModule paramTDFileQIPCModule, String paramString) {}
  
  public void run()
  {
    ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).processTDDocFileUrl(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.qipc.TDFileQIPCModule.1
 * JD-Core Version:    0.7.0.1
 */