package com.tencent.mobileqq.config.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QQComicConfBean$BoodoHippyConfig
  implements Serializable
{
  public static final int HIPPY_STATUS_CLOSE = 0;
  public static final int HIPPY_STATUS_OPEN = 1;
  public final List<String> mAllModules = new ArrayList();
  public int mHippyStatus;
  public String mMainModuleName;
  public final List<String> mPreloadModules = new ArrayList();
  
  public String toString()
  {
    return "BoodoHippyConfig{mHippyStatus=" + this.mHippyStatus + ", mMainModuleName='" + this.mMainModuleName + '\'' + ", mPreloadModules=" + this.mPreloadModules + ", mAllModules=" + this.mAllModules + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQComicConfBean.BoodoHippyConfig
 * JD-Core Version:    0.7.0.1
 */