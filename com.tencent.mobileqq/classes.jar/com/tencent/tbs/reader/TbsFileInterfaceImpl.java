package com.tencent.tbs.reader;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.tbs.reader.external.ITbsReaderAtom;
import java.util.LinkedHashMap;
import java.util.Map;

public class TbsFileInterfaceImpl
{
  public static int FILE_READER_WINDOW_TYPE_DEFAULT = 0;
  public static int FILE_READER_WINDOW_TYPE_VIEW = 2;
  static TbsFileInterfaceImpl stbsFileImpl;
  TbsReaderManager mReaderManager = null;
  
  @Deprecated
  public static boolean canOpenFile(String paramString)
  {
    if (ReaderEngine.getInstance().isSupportCurrentPlatform()) {
      return ReaderEngine.getInstance().isSupportExt(3, paramString);
    }
    return false;
  }
  
  public static boolean canOpenFileExt(String paramString)
  {
    if (ReaderEngine.getInstance().isSupportCurrentPlatform()) {
      return ReaderEngine.getInstance().isSupportExt(3, paramString);
    }
    return false;
  }
  
  public static TbsFileInterfaceImpl getInstance()
  {
    if (stbsFileImpl == null) {
      stbsFileImpl = new TbsFileInterfaceImpl();
    }
    return stbsFileImpl;
  }
  
  public static boolean initEngine(Context paramContext)
  {
    ReaderEngine.getInstance().initReaderEntry(paramContext);
    return ReaderEngine.getInstance().isSupportCurrentPlatform();
  }
  
  public static void initEngineAsync(Context paramContext, ITbsReaderCallback paramITbsReaderCallback)
  {
    ReaderEngine.getInstance().initReaderEntryAsync(paramContext, paramITbsReaderCallback);
  }
  
  public static void setProviderSetting(String paramString)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("provider_classname", paramString);
    ReaderEngine.getInstance().setConfigSetting(localLinkedHashMap);
  }
  
  public void closeFileReader()
  {
    TbsReaderManager localTbsReaderManager = this.mReaderManager;
    if (localTbsReaderManager != null) {
      localTbsReaderManager.destroy();
    }
  }
  
  public ITbsReaderAtom createAtom(int paramInt)
  {
    if (this.mReaderManager.getTbsReader() != null) {
      return (ITbsReaderAtom)this.mReaderManager.getTbsReader().createAtom(paramInt);
    }
    return null;
  }
  
  public TbsReaderManager getReaderManager()
  {
    return this.mReaderManager;
  }
  
  public boolean initReader(Context paramContext, ITbsReaderCallback paramITbsReaderCallback)
  {
    return this.mReaderManager.initReader(paramContext, paramITbsReaderCallback);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2)
  {
    TbsReaderManager localTbsReaderManager = this.mReaderManager;
    if (localTbsReaderManager != null) {
      localTbsReaderManager.onSizeChanged(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    }
  }
  
  public int openFileReader(Context paramContext, Bundle paramBundle, FrameLayout paramFrameLayout)
  {
    return this.mReaderManager.openFileReader(paramContext, paramBundle, null, paramFrameLayout);
  }
  
  public int openFileReader(Context paramContext, Bundle paramBundle, ITbsReaderCallback paramITbsReaderCallback, FrameLayout paramFrameLayout)
  {
    closeFileReader();
    if (initReader(paramContext, paramITbsReaderCallback)) {
      return this.mReaderManager.openFileReader(paramContext, paramBundle, paramITbsReaderCallback, paramFrameLayout);
    }
    return -1;
  }
  
  public void pluginPreLoad(Context paramContext, String paramString)
  {
    this.mReaderManager.getPluginPre(paramContext).downloadPlugin(paramContext, paramString);
  }
  
  public void setReaderManager(TbsReaderManager paramTbsReaderManager)
  {
    this.mReaderManager = paramTbsReaderManager;
    if (this.mReaderManager == null) {
      this.mReaderManager = new TbsReaderManager();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.reader.TbsFileInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */