package com.tencent.pts.core.lite;

import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.jni.PTSLiteJniHandler;

public class PTSLiteBridge
{
  private final String TAG = "PTSLiteBridge";
  
  public void initAppLiteBundle(String paramString, PTSAppInstance paramPTSAppInstance)
  {
    PTSLiteJniHandler.create(paramPTSAppInstance, paramString);
  }
  
  public void setData(PTSItemData paramPTSItemData, PTSAppInstance paramPTSAppInstance)
  {
    if ((paramPTSItemData == null) || (paramPTSAppInstance == null)) {
      return;
    }
    PTSLiteJniHandler.setData(paramPTSAppInstance, paramPTSItemData.getJSONData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pts.core.lite.PTSLiteBridge
 * JD-Core Version:    0.7.0.1
 */