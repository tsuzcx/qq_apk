package com.tencent.mobileqq.tofumsg;

import com.tencent.mobileqq.app.BusinessObserver;
import java.util.List;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfoResult;

public class TofuObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, String paramString1, String paramString2, List<oidb_0xe61.BeancurdCubeInfoResult> paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 0)
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], (String)paramObject[1], (List)paramObject[2]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.TofuObserver
 * JD-Core Version:    0.7.0.1
 */