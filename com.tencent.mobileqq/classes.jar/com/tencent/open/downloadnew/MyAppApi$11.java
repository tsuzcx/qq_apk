package com.tencent.open.downloadnew;

import android.content.Context;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import java.util.ArrayList;

class MyAppApi$11
  implements Runnable
{
  MyAppApi$11(MyAppApi paramMyAppApi, Context paramContext, ArrayList paramArrayList, int paramInt, String paramString) {}
  
  public void run()
  {
    TMAssistantCallYYB_V2.getInstance().startBatchOperation(this.a, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.11
 * JD-Core Version:    0.7.0.1
 */