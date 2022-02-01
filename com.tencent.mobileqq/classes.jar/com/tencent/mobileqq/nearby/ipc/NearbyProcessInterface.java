package com.tencent.mobileqq.nearby.ipc;

import android.os.IInterface;
import android.os.Message;

public abstract interface NearbyProcessInterface
  extends IInterface
{
  public abstract Message a(Message paramMessage);
  
  public abstract BasicTypeDataParcel a(BasicTypeDataParcel paramBasicTypeDataParcel);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface
 * JD-Core Version:    0.7.0.1
 */