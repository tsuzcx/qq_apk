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
    if (this.mReaderPlugin != null) {
      this.mReaderPlugin.initPlugin(paramContext);
    }
  }
  
  public void destroy()
  {
    if (this.mReaderPlugin != null) {
      this.mReaderPlugin.destroy();
    }
  }
  
  public int downloadPlugin(Context paramContext, String paramString)
  {
    int i = 0;
    if (this.mReaderPlugin != null) {
      i = this.mReaderPlugin.downloadPlugin(paramContext, paramString);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.reader.ReaderPluginPreLoad
 * JD-Core Version:    0.7.0.1
 */