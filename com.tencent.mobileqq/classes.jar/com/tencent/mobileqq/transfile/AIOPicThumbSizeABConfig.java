package com.tencent.mobileqq.transfile;

import acmz;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.abtest.ABTestController;
import com.tencent.mobileqq.abtest.ABTestController.EvtType;

public class AIOPicThumbSizeABConfig
{
  private static final String TAG = "AIOPicThumbSizeABConfig";
  public static String layerName = "PhotoMessage";
  private static AIOPicThumbSizeABConfig mInstance;
  private acmz experimentInfo;
  
  public AIOPicThumbSizeABConfig()
  {
    init();
  }
  
  public static AIOPicThumbSizeABConfig getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new AIOPicThumbSizeABConfig();
      }
      return mInstance;
    }
    finally {}
  }
  
  @Nullable
  public acmz experimentInfo()
  {
    if (this.experimentInfo != null) {
      ABTestController.a("AIOPicThumbSizeABConfig", this.experimentInfo.a());
    }
    return this.experimentInfo;
  }
  
  public void init()
  {
    if (this.experimentInfo == null) {
      this.experimentInfo = ABTestController.a().a(layerName, "171819", "171818");
    }
  }
  
  public void reportClickEvent(String paramString)
  {
    acmz localacmz = experimentInfo();
    if (localacmz != null)
    {
      localacmz.a(ABTestController.EvtType.CLICK, layerName + "_" + paramString);
      ABTestController.a("AIOPicThumbSizeABConfig", localacmz.a());
    }
  }
  
  public void reportExposeEvent(String paramString)
  {
    acmz localacmz = experimentInfo();
    if (localacmz != null)
    {
      localacmz.a(layerName + "_" + paramString);
      ABTestController.a("AIOPicThumbSizeABConfig", localacmz.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AIOPicThumbSizeABConfig
 * JD-Core Version:    0.7.0.1
 */