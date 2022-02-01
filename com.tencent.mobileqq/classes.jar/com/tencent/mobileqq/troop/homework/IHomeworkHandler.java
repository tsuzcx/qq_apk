package com.tencent.mobileqq.troop.homework;

import android.support.annotation.NonNull;
import tencent.im.troop.homework.ReqSend1V1Msg;

public abstract interface IHomeworkHandler
{
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(@NonNull homework.ReqSend1V1Msg paramReqSend1V1Msg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.IHomeworkHandler
 * JD-Core Version:    0.7.0.1
 */