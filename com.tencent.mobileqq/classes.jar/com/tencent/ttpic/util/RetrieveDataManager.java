package com.tencent.ttpic.util;

public enum RetrieveDataManager
{
  INSTANCE;
  
  private final TexSaveProcess mRGBATexSaveProcess = new RGBATexSaveProcess();
  private final TexSaveProcess mYUVTexSaveProcess = new YUVTexSaveProcess();
  
  private RetrieveDataManager() {}
  
  private boolean checkBufSize(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    if (paramInt1 == DATA_TYPE.RGBA.value) {
      if (paramArrayOfByte.length != paramInt2 * paramInt3 * 4) {}
    }
    do
    {
      return true;
      return false;
      if (paramInt1 != DATA_TYPE.YUV.value) {
        break;
      }
    } while (paramArrayOfByte.length == paramInt2 * paramInt3 * 3 / 2);
    return false;
    return false;
  }
  
  private TexSaveProcess createTexSaveProcess(int paramInt)
  {
    if (paramInt == DATA_TYPE.RGBA.value) {
      return this.mRGBATexSaveProcess;
    }
    if (paramInt == DATA_TYPE.YUV.value) {
      return this.mYUVTexSaveProcess;
    }
    return null;
  }
  
  public static RetrieveDataManager getInstance()
  {
    return INSTANCE;
  }
  
  public void clear()
  {
    this.mRGBATexSaveProcess.clear();
    this.mYUVTexSaveProcess.clear();
  }
  
  public boolean isValid(int paramInt)
  {
    boolean bool2 = false;
    DATA_TYPE[] arrayOfDATA_TYPE = DATA_TYPE.values();
    int j = arrayOfDATA_TYPE.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfDATA_TYPE[i].value == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean retrieveData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    if (!checkBufSize(paramInt1, paramInt3, paramInt4, paramArrayOfByte)) {}
    TexSaveProcess localTexSaveProcess;
    do
    {
      return false;
      localTexSaveProcess = createTexSaveProcess(paramInt1);
    } while (localTexSaveProcess == null);
    return localTexSaveProcess.retrieveData(paramInt2, paramInt3, paramInt4, paramArrayOfByte);
  }
  
  public byte[] retrieveData(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TexSaveProcess localTexSaveProcess = createTexSaveProcess(paramInt1);
    if (localTexSaveProcess != null) {
      return localTexSaveProcess.retrieveData(paramInt2, paramInt3, paramInt4);
    }
    return new byte[0];
  }
  
  public static enum DATA_TYPE
  {
    RGBA(0),  YUV(1);
    
    public int value;
    
    private DATA_TYPE(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.RetrieveDataManager
 * JD-Core Version:    0.7.0.1
 */