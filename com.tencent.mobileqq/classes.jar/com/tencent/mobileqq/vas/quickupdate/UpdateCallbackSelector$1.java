package com.tencent.mobileqq.vas.quickupdate;

import bgit;
import bgiw;
import bgix;
import bgiy;
import bgiz;
import bgja;
import bgjb;
import bgje;
import java.util.HashMap;

public final class UpdateCallbackSelector$1
  extends HashMap<Long, bgit>
{
  public UpdateCallbackSelector$1()
  {
    bgit[] arrayOfbgit = new bgit[7];
    arrayOfbgit[0] = bgjb.a;
    arrayOfbgit[1] = bgja.a;
    arrayOfbgit[2] = bgiy.a;
    arrayOfbgit[3] = bgiw.a;
    arrayOfbgit[4] = bgix.a;
    arrayOfbgit[5] = bgiz.a;
    arrayOfbgit[6] = bgje.a;
    int j = arrayOfbgit.length;
    while (i < j)
    {
      bgit localbgit = arrayOfbgit[i];
      put(Long.valueOf(localbgit.getBID()), localbgit);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector.1
 * JD-Core Version:    0.7.0.1
 */