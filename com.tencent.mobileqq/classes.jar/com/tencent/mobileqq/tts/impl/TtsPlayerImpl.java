package com.tencent.mobileqq.tts.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.tts.ITtsPlayer;
import com.tencent.mobileqq.tts.silk.IPlayerCallback;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

public class TtsPlayerImpl
  implements ITtsPlayer
{
  private static final String SILK_HEADER = "02232153494C4B5F5633";
  private static final int SILK_HEADER_LENGTH = 10;
  private static final String TAG = "TtsPlayer";
  private IPlayerCallback callback;
  private InputStream inputStream;
  private TtsPlayerImpl.PlayerThread playerThread;
  private TtsPlayerImpl.State state = TtsPlayerImpl.State.IDLE;
  
  private static boolean hasSilkHeader(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = HexUtil.hexStr2Bytes("02232153494C4B5F5633");
    int i = 1;
    while (i < 10)
    {
      if (arrayOfByte[i] != paramArrayOfByte[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static byte[] subBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public boolean isPlaying()
  {
    TtsPlayerImpl.PlayerThread localPlayerThread = this.playerThread;
    return (localPlayerThread != null) && (TtsPlayerImpl.PlayerThread.a(localPlayerThread));
  }
  
  public void release()
  {
    TtsPlayerImpl.PlayerThread localPlayerThread = this.playerThread;
    if (localPlayerThread != null)
    {
      TtsPlayerImpl.PlayerThread.a(localPlayerThread, false);
      this.playerThread = null;
    }
  }
  
  public void setDataStream(InputStream paramInputStream)
  {
    this.inputStream = paramInputStream;
  }
  
  public void setPlayerCallback(IPlayerCallback paramIPlayerCallback)
  {
    this.callback = paramIPlayerCallback;
  }
  
  public void start()
  {
    start(0);
  }
  
  public void start(int paramInt)
  {
    QLog.d("TtsPlayer", 1, new Object[] { "[start] start play, session: ", Integer.valueOf(paramInt) });
    if (this.playerThread == null) {
      this.playerThread = new TtsPlayerImpl.PlayerThread(this, null);
    }
    TtsPlayerImpl.PlayerThread.a(this.playerThread, paramInt);
    if (this.inputStream == null)
    {
      QLog.d("TtsPlayer", 1, "[start] start play but inputStream is null.");
      return;
    }
    ThreadManagerV2.executeOnSubThread(this.playerThread);
  }
  
  public void stop()
  {
    QLog.d("TtsPlayer", 1, "[stop] stop play.");
    TtsPlayerImpl.PlayerThread localPlayerThread = this.playerThread;
    if (localPlayerThread != null) {
      TtsPlayerImpl.PlayerThread.a(localPlayerThread, false);
    }
    if (this.inputStream == null)
    {
      QLog.d("TtsPlayer", 1, "[stop] stop play but inputStream is null.");
      return;
    }
    ThreadManagerV2.executeOnNetWorkThread(new TtsPlayerImpl.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tts.impl.TtsPlayerImpl
 * JD-Core Version:    0.7.0.1
 */