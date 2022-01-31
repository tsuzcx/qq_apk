package com.tencent.mobileqq.vas.quickupdate;

import bdwi;
import bdwl;
import bdwm;
import bdwn;
import bdwo;
import bdwp;
import bdwq;
import bdwt;
import java.util.HashMap;

public final class UpdateCallbackSelector$1
  extends HashMap<Long, bdwi>
{
  public UpdateCallbackSelector$1()
  {
    bdwi[] arrayOfbdwi = new bdwi[7];
    arrayOfbdwi[0] = bdwq.a;
    arrayOfbdwi[1] = bdwp.a;
    arrayOfbdwi[2] = bdwn.a;
    arrayOfbdwi[3] = bdwl.a;
    arrayOfbdwi[4] = bdwm.a;
    arrayOfbdwi[5] = bdwo.a;
    arrayOfbdwi[6] = bdwt.a;
    int j = arrayOfbdwi.length;
    while (i < j)
    {
      bdwi localbdwi = arrayOfbdwi[i];
      put(Long.valueOf(localbdwi.getBID()), localbdwi);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector.1
 * JD-Core Version:    0.7.0.1
 */