package com.tencent.mobileqq.transfile.quic.internal;

import android.os.Bundle;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

public abstract class AbTransportRunnable
  implements ITaskHandler, QuicNative.QuicCallback
{
  static final int CLIENT_FAILED = 5;
  static final String CODE = "CODE";
  static final int COMPLETED_MANUAL = 3;
  static final int CONNECTED = 1;
  static final String DATA = "DATA";
  static final String DESC = "DESC";
  static final int ENQUEUE_TASK = 9;
  static final String ID = "ID";
  static final String LEN = "LEN";
  static final int RECEIVING = 2;
  static final int SERVER_CLOSED = 4;
  static final int TASK_FAIL = 8;
  static final int TASK_FINISH = 7;
  static final int TASK_SUCC = 6;
  protected Bundle bundle;
  protected Message message = new Message();
  
  public abstract void enqueue(QuicDownloadTask paramQuicDownloadTask);
  
  public abstract void handleMessage(Message paramMessage);
  
  public void onClose(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("quic", 4, new Object[] { Integer.valueOf(paramInt1), " onClose code -> ", Integer.valueOf(paramInt2), " desc -> ", paramString });
    }
    this.message.what = 4;
    Bundle localBundle = new Bundle();
    localBundle.putInt("ID", paramInt1);
    localBundle.putInt("CODE", paramInt2);
    localBundle.putString("DESC", paramString);
    this.message.obj = localBundle;
    handleMessage(this.message);
  }
  
  public void onCompleted(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("quic", 4, "[" + paramInt + "] onCompleted");
    }
  }
  
  public void onConnect(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("quic", 4, "[" + paramInt1 + "] onConnect");
    }
    this.message.what = 1;
    Bundle localBundle = new Bundle();
    localBundle.putInt("ID", paramInt1);
    this.message.obj = localBundle;
    handleMessage(this.message);
  }
  
  public void onDataReceive(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    this.message.what = 2;
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("DATA", paramArrayOfByte);
    localBundle.putInt("LEN", paramInt2);
    localBundle.putInt("ID", paramInt1);
    this.message.obj = localBundle;
    handleMessage(this.message);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.internal.AbTransportRunnable
 * JD-Core Version:    0.7.0.1
 */