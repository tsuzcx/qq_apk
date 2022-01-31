package dov.com.tencent.mobileqq.richmedia;

import android.os.Bundle;
import android.os.IInterface;
import com.tencent.mobileqq.pic.CompressInfo;

public abstract interface ICallBack
  extends IInterface
{
  public abstract Bundle a(int paramInt, Bundle paramBundle);
  
  public abstract void a(int paramInt, Bundle paramBundle);
  
  public abstract void a(CompressInfo paramCompressInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.ICallBack
 * JD-Core Version:    0.7.0.1
 */