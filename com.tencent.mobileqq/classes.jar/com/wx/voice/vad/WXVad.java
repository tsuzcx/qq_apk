package com.wx.voice.vad;

public class WXVad
{
  private WXVadNative gmmvad_inst = new WXVadNative();
  private long handle;
  
  public WXVadData GetOnlineProcessDataSize()
  {
    if (this.handle == 0L)
    {
      WXVadData localWXVadData = new WXVadData();
      localWXVadData.RET_STATE = 1;
      return localWXVadData;
    }
    return this.gmmvad_inst.GetOnlineProcessDataSize(this.handle);
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
    if (this.handle == 0L)
    {
      paramArrayOfShort = new WXVadData();
      paramArrayOfShort.RET_STATE = 1;
      return paramArrayOfShort;
    }
    return this.gmmvad_inst.OfflineProcess(this.handle, paramArrayOfShort, paramLong);
  }
  
  public WXVadData OnlineProcess(short[] paramArrayOfShort, long paramLong, int paramInt)
  {
    if (this.handle == 0L)
    {
      paramArrayOfShort = new WXVadData();
      paramArrayOfShort.RET_STATE = 1;
      return paramArrayOfShort;
    }
    return this.gmmvad_inst.OnlineProcess(this.handle, paramArrayOfShort, paramLong, paramInt);
  }
  
  public int Release()
  {
    if (this.handle == 0L) {
      return 1;
    }
    return this.gmmvad_inst.Release(this.handle);
  }
  
  public int Reset()
  {
    if (this.handle == 0L) {
      return 1;
    }
    return this.gmmvad_inst.Reset(this.handle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.wx.voice.vad.WXVad
 * JD-Core Version:    0.7.0.1
 */