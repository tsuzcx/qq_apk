package com.tencent.ttpic.openapi.util;

import com.tencent.ttpic.util.TexSaveProcess;

public class RetrieveDataManager
{
  private static final ThreadLocal<RetrieveDataManager> INSTANCE = new RetrieveDataManager.1();
  private final TexSaveProcess mRGBATexSaveProcess = new RGBATexSaveProcess();
  
  private TexSaveProcess createTexSaveProcess(int paramInt)
  {
    if (paramInt == RetrieveDataManager.DATA_TYPE.RGBA.value) {
      return this.mRGBATexSaveProcess;
    }
    return null;
  }
  
  public static RetrieveDataManager getInstance()
  {
    return (RetrieveDataManager)INSTANCE.get();
  }
  
  public void clear()
  {
    this.mRGBATexSaveProcess.clear();
  }
  
  public boolean isValid(int paramInt)
  {
    boolean bool2 = false;
    RetrieveDataManager.DATA_TYPE[] arrayOfDATA_TYPE = RetrieveDataManager.DATA_TYPE.values();
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
  
  public byte[] retrieveData(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TexSaveProcess localTexSaveProcess = createTexSaveProcess(paramInt1);
    if (localTexSaveProcess != null) {
      return localTexSaveProcess.retrieveData(paramInt2, paramInt3, paramInt4);
    }
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.RetrieveDataManager
 * JD-Core Version:    0.7.0.1
 */