package com.tencent.tbs.reader;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;

public class TbsReaderManager
{
  public static final String TAG = "TbsReaderManager";
  protected ITbsReader mReader = null;
  protected TbsReaderCore mReaderCore = null;
  
  private boolean isDebugFile(Bundle paramBundle)
  {
    boolean bool = false;
    if (paramBundle == null) {
      return false;
    }
    paramBundle = paramBundle.getString("filePath");
    if (TextUtils.isEmpty(paramBundle)) {
      return false;
    }
    if (paramBundle.lastIndexOf("65b46dc5-21ad-4098-bf53-9b2fc9edf259.xlsx") > 0) {
      bool = true;
    }
    return bool;
  }
  
  protected TbsReaderCore createReaderCore(Context paramContext, ITbsReaderCallback paramITbsReaderCallback, int paramInt)
  {
    this.mReader = ReaderEngine.getInstance().createTbsReader(paramContext.getApplicationContext(), Integer.valueOf(paramInt), paramITbsReaderCallback);
    return new TbsReaderCore(paramContext, this.mReader);
  }
  
  public void destroy()
  {
    Object localObject = this.mReaderCore;
    if (localObject != null) {
      ((TbsReaderCore)localObject).destroy();
    }
    this.mReaderCore = null;
    localObject = this.mReader;
    if (localObject != null) {
      ((ITbsReader)localObject).destroy();
    }
    this.mReader = null;
  }
  
  public void doAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    ITbsReader localITbsReader = this.mReader;
    if (localITbsReader != null) {
      localITbsReader.doCommand(paramInteger, paramObject1, paramObject2);
    }
  }
  
  public ReaderPluginPreLoad getPluginPre(Context paramContext)
  {
    return new ReaderPluginPreLoad(paramContext, this.mReader);
  }
  
  public ITbsReader getTbsReader()
  {
    return this.mReader;
  }
  
  public boolean initReader(Context paramContext, ITbsReaderCallback paramITbsReaderCallback)
  {
    this.mReaderCore = createReaderCore(paramContext, paramITbsReaderCallback, 3);
    paramITbsReaderCallback = this.mReaderCore;
    if (paramITbsReaderCallback != null) {
      return paramITbsReaderCallback.init(paramContext);
    }
    return false;
  }
  
  public void onSizeChanged(Integer paramInteger1, Integer paramInteger2)
  {
    TbsReaderCore localTbsReaderCore = this.mReaderCore;
    if (localTbsReaderCore != null) {
      localTbsReaderCore.onSizeChanged(paramInteger1, paramInteger2);
    }
  }
  
  public int openFileReader(Context paramContext, Bundle paramBundle, ITbsReaderCallback paramITbsReaderCallback, FrameLayout paramFrameLayout)
  {
    if (isDebugFile(paramBundle)) {
      paramITbsReaderCallback = ReaderEngine.getInstance().createDebugView(paramContext);
    } else {
      paramITbsReaderCallback = null;
    }
    return this.mReaderCore.openFile(paramContext, paramBundle, paramFrameLayout, paramITbsReaderCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.reader.TbsReaderManager
 * JD-Core Version:    0.7.0.1
 */