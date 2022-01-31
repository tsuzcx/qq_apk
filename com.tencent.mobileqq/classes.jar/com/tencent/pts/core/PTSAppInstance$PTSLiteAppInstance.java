package com.tencent.pts.core;

import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.jni.PTSLiteJniHandler;
import com.tencent.pts.core.lite.PTSLiteBridge;
import com.tencent.pts.core.lite.PTSLiteItemViewManager;

public class PTSAppInstance$PTSLiteAppInstance
  extends PTSAppInstance
{
  private PTSLiteItemViewManager liteItemViewManager;
  private PTSLiteBridge ptsLiteBridge = new PTSLiteBridge();
  
  private PTSAppInstance$PTSLiteAppInstance()
  {
    super(null);
  }
  
  private void setLiteItemViewManager(PTSLiteItemViewManager paramPTSLiteItemViewManager)
  {
    this.liteItemViewManager = paramPTSLiteItemViewManager;
  }
  
  public PTSLiteBridge getLiteBridge()
  {
    return this.ptsLiteBridge;
  }
  
  public PTSLiteItemViewManager getLiteItemViewManager()
  {
    return this.liteItemViewManager;
  }
  
  void initPTSAppInstance(String paramString1, String paramString2)
  {
    this.ptsLiteBridge.initAppLiteBundle(paramString1, this);
    this.ptsLiteBridge.setData(getItemData(), this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    PTSLiteJniHandler.destroy(this);
  }
  
  public void setItemData(PTSItemData paramPTSItemData)
  {
    super.setItemData(paramPTSItemData);
    this.ptsLiteBridge.setData(getItemData(), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pts.core.PTSAppInstance.PTSLiteAppInstance
 * JD-Core Version:    0.7.0.1
 */