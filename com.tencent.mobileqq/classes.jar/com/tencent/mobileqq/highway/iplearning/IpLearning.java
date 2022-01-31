package com.tencent.mobileqq.highway.iplearning;

import com.tencent.mobileqq.highway.utils.EndPoint;
import java.util.ArrayList;

public abstract interface IpLearning
{
  public static final String TAG = "IpLearning";
  
  public abstract ArrayList<EndPoint> adjustNewIpList(ArrayList<EndPoint> paramArrayList);
  
  public abstract void onIpConnFail(String paramString, int paramInt);
  
  public abstract void onIpConnSucc(String paramString, int paramInt, boolean paramBoolean);
  
  public abstract void onRecvClearCMD();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.iplearning.IpLearning
 * JD-Core Version:    0.7.0.1
 */