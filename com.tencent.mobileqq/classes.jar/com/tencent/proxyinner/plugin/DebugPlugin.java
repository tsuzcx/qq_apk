package com.tencent.proxyinner.plugin;

import android.content.Context;
import android.os.Environment;
import com.tencent.proxyinner.utility.UtilMisc;
import java.io.File;

public class DebugPlugin
{
  private static final String DEBUG_SDCARD_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/xplatform/zips";
  private static final String TAG = "TXProxy | DebugPlugin";
  String mLocalPath;
  String mPluginId;
  
  private void initDebugPluginPath()
  {
    this.mLocalPath = UtilMisc.getTestPluginPath(this.mPluginId);
    if (this.mLocalPath == null) {}
    File localFile;
    do
    {
      return;
      localFile = new File(this.mLocalPath);
    } while ((localFile == null) || (localFile.exists()));
    this.mLocalPath = "";
  }
  
  public String getPath()
  {
    return this.mLocalPath;
  }
  
  public void init(Context paramContext, String paramString)
  {
    this.mPluginId = paramString;
    initDebugPluginPath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.plugin.DebugPlugin
 * JD-Core Version:    0.7.0.1
 */