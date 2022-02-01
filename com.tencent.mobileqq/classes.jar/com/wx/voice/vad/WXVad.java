package com.wx.voice.vad;

public class WXVad
{
  private WXVadNative gmmvad_inst = new WXVadNative();
  private long handle = 0L;
  
  public WXVadData GetOnlineProcessDataSize()
  {
    long l = this.handle;
    if (l == 0L)
    {
      WXVadData localWXVadData = new WXVadData();
      localWXVadData.RET_STATE = 1;
      return localWXVadData;
    }
    return this.gmmvad_inst.GetOnlineProcessDataSize(l);
  }
  
  public int Init(WXVadParam paramWXVadParam)
  {
    this.handle = this.gmmvad_inst.InitUserParam(paramWXVadParam);
    if (this.handle == 0L) {
      return 1;
    }
    return 0;
  }
  
  public int Init(String paramString1, String paramString2)
  {
    this.handle = this.gmmvad_inst.Init(paramString1, paramString2);
    if (this.handle == 0L) {
      return 1;
    }
    return 0;
  }
  
  public WXVadData OfflineProcess(short[] paramArrayOfShort, long paramLong)
  {
    long l = this.handle;
    if (l == 0L)
    {
      paramArrayOfShort = new WXVadData();
      paramArrayOfShort.RET_STATE = 1;
      return paramArrayOfShort;
    }
    return this.gmmvad_inst.OfflineProcess(l, paramArrayOfShort, paramLong);
  }
  
  public WXVadData OnlineProcess(short[] paramArrayOfShort, long paramLong, int paramInt)
  {
    long l = this.handle;
    if (l == 0L)
    {
      paramArrayOfShort = new WXVadData();
      paramArrayOfShort.RET_STATE = 1;
      return paramArrayOfShort;
    }
    return this.gmmvad_inst.OnlineProcess(l, paramArrayOfShort, paramLong, paramInt);
  }
  
  public int Release()
  {
    long l = this.handle;
    if (l == 0L) {
      return 1;
    }
    return this.gmmvad_inst.Release(l);
  }
  
  public int Reset()
  {
    long l = this.handle;
    if (l == 0L) {
      return 1;
    }
    return this.gmmvad_inst.Reset(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.wx.voice.vad.WXVad
 * JD-Core Version:    0.7.0.1
 */