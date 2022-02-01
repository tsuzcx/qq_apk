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
    RetrieveDataManager.DATA_TYPE[] arrayOfDATA_TYPE = RetrieveDataManager.DATA_TYPE.values();
    int j = arrayOfDATA_TYPE.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfDATA_TYPE[i].value == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.RetrieveDataManager
 * JD-Core Version:    0.7.0.1
 */