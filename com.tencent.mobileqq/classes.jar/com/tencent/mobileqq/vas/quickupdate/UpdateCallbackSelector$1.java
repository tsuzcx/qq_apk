package com.tencent.mobileqq.vas.quickupdate;

import bhbw;
import bhbz;
import bhca;
import bhcb;
import bhcc;
import bhcd;
import bhce;
import bhch;
import java.util.HashMap;

public final class UpdateCallbackSelector$1
  extends HashMap<Long, bhbw>
{
  public UpdateCallbackSelector$1()
  {
    bhbw[] arrayOfbhbw = new bhbw[7];
    arrayOfbhbw[0] = bhce.a;
    arrayOfbhbw[1] = bhcd.a;
    arrayOfbhbw[2] = bhcb.a;
    arrayOfbhbw[3] = bhbz.a;
    arrayOfbhbw[4] = bhca.a;
    arrayOfbhbw[5] = bhcc.a;
    arrayOfbhbw[6] = bhch.a;
    int j = arrayOfbhbw.length;
    while (i < j)
    {
      bhbw localbhbw = arrayOfbhbw[i];
      put(Long.valueOf(localbhbw.getBID()), localbhbw);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector.1
 * JD-Core Version:    0.7.0.1
 */