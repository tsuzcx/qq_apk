package com.tencent.tbs.reader;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

public class TbsReaderCore
{
  public static final String TAG = "TbsReaderCore";
  protected ITbsReader.IReaderCore mReaderCore = null;
  
  public TbsReaderCore(Context paramContext, ITbsReader paramITbsReader)
  {
    if (paramITbsReader != null) {
      this.mReaderCore = paramITbsReader.getReaderCore();
    }
  }
  
  public void closeFile()
  {
    ITbsReader.IReaderCore localIReaderCore = this.mReaderCore;
    if (localIReaderCore != null) {
      localIReaderCore.closeFile();
    }
  }
  
  public void destroy()
  {
    closeFile();
    ITbsReader.IReaderCore localIReaderCore = this.mReaderCore;
    if (localIReaderCore != null) {
      localIReaderCore.destroy();
    }
    this.mReaderCore = null;
  }
  
  public boolean init(Context paramContext)
  {
    ITbsReader.IReaderCore localIReaderCore = this.mReaderCore;
    if (localIReaderCore != null) {
      return localIReaderCore.init(paramContext);
    }
    return false;
  }
  
  public void onSizeChanged(Integer paramInteger1, Integer paramInteger2)
  {
    ITbsReader.IReaderCore localIReaderCore = this.mReaderCore;
    if (localIReaderCore != null) {
      localIReaderCore.onSizeChanged(paramInteger1, paramInteger2);
    }
  }
  
  public int openFile(Context paramContext, Bundle paramBundle, FrameLayout paramFrameLayout, View paramView)
  {
    ITbsReader.IReaderCore localIReaderCore = this.mReaderCore;
    if ((localIReaderCore != null) && (paramBundle != null))
    {
      int j = localIReaderCore.openFile(paramContext, paramBundle, paramFrameLayout, paramView);
      int i = 1100;
      if (j != 0)
      {
        Log.e("TbsReaderCore", "OpenFile failed!");
        i = 1101;
      }
      paramContext = ReaderEngine.getInstance();
      paramBundle = new StringBuilder();
      paramBundle.append("ViewOpenFile:");
      paramBundle.append(j);
      paramContext.report(i, paramBundle.toString(), null);
      return j;
    }
    Log.e("TbsReaderCore", "init failed!");
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.reader.TbsReaderCore
 * JD-Core Version:    0.7.0.1
 */