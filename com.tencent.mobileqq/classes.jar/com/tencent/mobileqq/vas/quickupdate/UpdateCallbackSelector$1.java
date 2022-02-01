package com.tencent.mobileqq.vas.quickupdate;

import bici;
import bicl;
import bicm;
import bicn;
import bico;
import bicp;
import bicq;
import bict;
import java.util.HashMap;

public final class UpdateCallbackSelector$1
  extends HashMap<Long, bici>
{
  public UpdateCallbackSelector$1()
  {
    bici[] arrayOfbici = new bici[7];
    arrayOfbici[0] = bicq.a;
    arrayOfbici[1] = bicp.a;
    arrayOfbici[2] = bicn.a;
    arrayOfbici[3] = bicl.a;
    arrayOfbici[4] = bicm.a;
    arrayOfbici[5] = bico.a;
    arrayOfbici[6] = bict.a;
    int j = arrayOfbici.length;
    while (i < j)
    {
      bici localbici = arrayOfbici[i];
      put(Long.valueOf(localbici.getBID()), localbici);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector.1
 * JD-Core Version:    0.7.0.1
 */