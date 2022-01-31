package com.tencent.mobileqq.troop.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class TroopUploadingTask
  extends UploadingTask
{
  public void a(Class paramClass, ArrayList paramArrayList, HashMap paramHashMap, String paramString)
  {
    if ((this.a == null) || (this.a.getState() == Thread.State.TERMINATED))
    {
      this.a = ((TroopUploadingThread)UploadingFactory.a(paramClass));
      this.a.a(paramArrayList, paramHashMap, paramString, this);
      this.a.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopUploadingTask
 * JD-Core Version:    0.7.0.1
 */