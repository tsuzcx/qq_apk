package com.tencent.ttpic.filament;

import com.google.android.filament.gltfio.CMShowLoader;
import java.util.Map;

public class CMShowUserLoader
  extends CMShowLoader
{
  private Runnable animationCallback = null;
  private Runnable firstRenderCallback = null;
  private int mUserIndex = 0;
  private boolean needUpdate = false;
  
  public CMShowUserLoader() {}
  
  public CMShowUserLoader(int paramInt)
  {
    this();
    this.mUserIndex = paramInt;
  }
  
  public void animationEnd()
  {
    if (this.animationCallback != null)
    {
      this.animationCallback.run();
      this.animationCallback = null;
    }
  }
  
  public void firstRenderEnd()
  {
    if (this.firstRenderCallback != null)
    {
      this.firstRenderCallback.run();
      this.firstRenderCallback = null;
    }
  }
  
  public boolean getNeedUpdate()
  {
    return this.needUpdate;
  }
  
  public int getUserIndex()
  {
    return this.mUserIndex;
  }
  
  public void setAnimationPath(String paramString, Runnable paramRunnable)
  {
    setAnimationPath(paramString);
    if (this.animationCallback == null)
    {
      this.animationCallback = paramRunnable;
      this.needUpdate = true;
    }
  }
  
  public CMShowUserLoader setCmShowAssetsData(CmShowAssetsData paramCmShowAssetsData)
  {
    return setCmShowAssetsData(paramCmShowAssetsData, null);
  }
  
  public CMShowUserLoader setCmShowAssetsData(CmShowAssetsData paramCmShowAssetsData, Runnable paramRunnable)
  {
    if (paramCmShowAssetsData == null) {
      return this;
    }
    if (paramCmShowAssetsData.roleResDir != null) {
      paramCmShowAssetsData.dressResMap.put("role", paramCmShowAssetsData.roleResDir);
    }
    FilaBenchUtil.benchStart(FilamentUtil.BenchTag.KAPU_DECODE_DATA.tag);
    setKapuModels(paramCmShowAssetsData.dressResMap);
    setFaceStr(paramCmShowAssetsData.faceDataJsonStr);
    FilaBenchUtil.benchEnd(FilamentUtil.BenchTag.KAPU_DECODE_DATA.tag);
    this.firstRenderCallback = paramRunnable;
    this.needUpdate = true;
    return this;
  }
  
  public void setNeedUpdate(boolean paramBoolean)
  {
    this.needUpdate = paramBoolean;
  }
  
  public CMShowUserLoader setUserIndex(int paramInt)
  {
    this.mUserIndex = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filament.CMShowUserLoader
 * JD-Core Version:    0.7.0.1
 */