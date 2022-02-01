package com.tencent.mobileqq.tianshu.data;

import com.tencent.mobileqq.tianshu.pb.NumRedMsg.NumMsgBusi;
import java.util.List;

public abstract class NumRedGetMsgCallback
{
  private static int b;
  public int a;
  
  public NumRedGetMsgCallback()
  {
    int i = b;
    b = i + 1;
    this.a = i;
  }
  
  public abstract void a(String paramString, List<NumRedMsg.NumMsgBusi> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.data.NumRedGetMsgCallback
 * JD-Core Version:    0.7.0.1
 */