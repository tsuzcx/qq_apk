package com.tencent.tbs.reader;

import android.content.Context;

public class ReaderPluginPreLoad
{
  public static final String TAG = "ReaderPluginPreLoad";
  protected ITbsReader.IReaderPlugin mReaderPlugin = null;
  
  public ReaderPluginPreLoad(Context paramContext, ITbsReader paramITbsReader)
  {
    if (paramITbsReader != null) {
      this.mReaderPlugin = paramITbsReader.getReaderPlugin();
    }
    paramITbsReader = this.mReaderPlugin;
    if (paramITbsReader != null) {
      paramITbsReader.initPlugin(paramContext);
    }
  }
  
  public void destroy()
  {
    ITbsReader.IReaderPlugin localIReaderPlugin = this.mReaderPlugin;
    if (localIReaderPlugin != null) {
      localIReaderPlugin.destroy();
    }
  }
  
  public int downloadPlugin(Context paramContext, String paramString)
  {
    ITbsReader.IReaderPlugin localIReaderPlugin = this.mReaderPlugin;
    if (localIReaderPlugin != null) {
      return localIReaderPlugin.downloadPlugin(paramContext, paramString);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.reader.ReaderPluginPreLoad
 * JD-Core Version:    0.7.0.1
 */