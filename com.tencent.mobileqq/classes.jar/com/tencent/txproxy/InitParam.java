package com.tencent.txproxy;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class InitParam
  implements Serializable
{
  public boolean isDataReportInHost = false;
  public boolean isDownloadInHost = false;
  public boolean isLogInHost = false;
  public String mChannelId;
  public Map<String, String> mComponentMap = new HashMap();
  public String mDefaultContainerActivity;
  public String mDefaultContainerService;
  public String mDefaultLoadApkActivity;
  public int mDownloadEngine;
  public Class mLoadApkActivityClazz;
  public boolean mMoveSoFileInHost = false;
  public boolean mNeedSilentUpdate = true;
  public String mPluginName;
  public XEventListener mSink = null;
  public String mSoFileFormat = "zip";
  public String mSourceId = "";
  public String mSourceVersion;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.txproxy.InitParam
 * JD-Core Version:    0.7.0.1
 */