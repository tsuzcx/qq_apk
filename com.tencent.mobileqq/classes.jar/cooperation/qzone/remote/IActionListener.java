package cooperation.qzone.remote;

import android.os.IInterface;

public abstract interface IActionListener
  extends IInterface
{
  public abstract void onRecvFromMsg(RecvMsg paramRecvMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.remote.IActionListener
 * JD-Core Version:    0.7.0.1
 */