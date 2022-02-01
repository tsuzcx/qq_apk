package com.tencent.mobileqq.qqlive.listener.heart;

import com.tencent.mobileqq.qqlive.data.heart.FreeLove;
import com.tencent.mobileqq.qqlive.data.heart.QLBroadCastFreeLove;
import java.util.ArrayList;

public abstract interface OnReceiveFloatHeartListener
{
  public abstract void a(QLBroadCastFreeLove paramQLBroadCastFreeLove);
  
  public abstract void a(ArrayList<FreeLove> paramArrayList, Boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.listener.heart.OnReceiveFloatHeartListener
 * JD-Core Version:    0.7.0.1
 */