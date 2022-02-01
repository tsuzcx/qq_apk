package com.tencent.mobileqq.vas.quickupdate;

import bhro;
import bhrr;
import bhrs;
import bhrt;
import bhru;
import bhrv;
import bhrw;
import bhrz;
import java.util.HashMap;

public final class UpdateCallbackSelector$1
  extends HashMap<Long, bhro>
{
  public UpdateCallbackSelector$1()
  {
    bhro[] arrayOfbhro = new bhro[7];
    arrayOfbhro[0] = bhrw.a;
    arrayOfbhro[1] = bhrv.a;
    arrayOfbhro[2] = bhrt.a;
    arrayOfbhro[3] = bhrr.a;
    arrayOfbhro[4] = bhrs.a;
    arrayOfbhro[5] = bhru.a;
    arrayOfbhro[6] = bhrz.a;
    int j = arrayOfbhro.length;
    while (i < j)
    {
      bhro localbhro = arrayOfbhro[i];
      put(Long.valueOf(localbhro.getBID()), localbhro);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector.1
 * JD-Core Version:    0.7.0.1
 */