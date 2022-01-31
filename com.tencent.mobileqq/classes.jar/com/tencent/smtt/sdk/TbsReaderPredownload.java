package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.LinkedList;

public class TbsReaderPredownload
{
  private static final String LOGTAG = "TbsReaderPredownload";
  public static final int READER_SO_SUCCESS = 2;
  public static final int READER_WAIT_IN_QUEUE = 3;
  static final int sDelayed = 100;
  static final String[] sSupportedReaderTypeList = { "docx", "pptx", "xlsx", "pdf", "epub", "txt" };
  TbsReaderPredownload.ReaderPreDownloadCallback mCallback = null;
  Context mContext = null;
  boolean mDownloadPaused = false;
  LinkedList<String> mFileDownloads = new LinkedList();
  String mPluginExt = "";
  TbsReaderView.ReaderCallback mReaderCallback = null;
  Object mTbsReader = null;
  Handler mUiHandle = null;
  ReaderWizard mWizard = null;
  
  public TbsReaderPredownload(TbsReaderPredownload.ReaderPreDownloadCallback paramReaderPreDownloadCallback)
  {
    this.mCallback = paramReaderPreDownloadCallback;
    paramReaderPreDownloadCallback = sSupportedReaderTypeList;
    int j = paramReaderPreDownloadCallback.length;
    while (i < j)
    {
      Object localObject = paramReaderPreDownloadCallback[i];
      this.mFileDownloads.add(localObject);
      i += 1;
    }
    createMessageEvent();
  }
  
  private void cancelAllMessage()
  {
    cancel(3);
  }
  
  void cancel(int paramInt)
  {
    this.mUiHandle.removeMessages(paramInt);
  }
  
  void createMessageEvent()
  {
    this.mUiHandle = new TbsReaderPredownload.2(this, Looper.getMainLooper());
  }
  
  boolean haseMessage(int paramInt)
  {
    return this.mUiHandle.hasMessages(paramInt);
  }
  
  public boolean init(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    this.mContext = paramContext.getApplicationContext();
    bool = TbsReaderView.initSDK(paramContext.getApplicationContext());
    this.mReaderCallback = new TbsReaderPredownload.1(this);
    try
    {
      if (this.mWizard == null) {
        this.mWizard = new ReaderWizard(this.mReaderCallback);
      }
      if (this.mTbsReader == null) {
        this.mTbsReader = this.mWizard.getTbsReader();
      }
      if (this.mTbsReader != null) {
        bool = this.mWizard.initTbsReader(this.mTbsReader, paramContext.getApplicationContext());
      }
    }
    catch (NullPointerException paramContext)
    {
      for (;;)
      {
        Log.e("TbsReaderPredownload", "Unexpect null object!");
        bool = false;
      }
    }
    return bool;
  }
  
  void notifyCallback(int paramInt)
  {
    if (this.mCallback != null)
    {
      boolean bool = this.mFileDownloads.isEmpty();
      this.mCallback.onEvent(this.mPluginExt, paramInt, bool);
    }
  }
  
  public void pause()
  {
    this.mDownloadPaused = true;
  }
  
  boolean requestPlugin(String paramString)
  {
    if ((this.mTbsReader == null) || (this.mWizard == null)) {}
    while (!ReaderWizard.isSupportExt(paramString)) {
      return false;
    }
    return this.mWizard.checkPlugin(this.mTbsReader, this.mContext, paramString, true);
  }
  
  void sendDelayed(int paramInt1, int paramInt2)
  {
    Message localMessage = this.mUiHandle.obtainMessage(paramInt1);
    this.mUiHandle.sendMessageDelayed(localMessage, paramInt2);
  }
  
  public void shutdown()
  {
    this.mCallback = null;
    this.mDownloadPaused = false;
    this.mFileDownloads.clear();
    cancelAllMessage();
    if (this.mWizard != null)
    {
      this.mWizard.destroy(this.mTbsReader);
      this.mTbsReader = null;
    }
    this.mContext = null;
  }
  
  public void start(String paramString)
  {
    this.mDownloadPaused = false;
    cancel(3);
    this.mFileDownloads.add(paramString);
    sendDelayed(3, 100);
  }
  
  public void startAll()
  {
    this.mDownloadPaused = false;
    if (!(haseMessage(3) | false)) {
      sendDelayed(3, 100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsReaderPredownload
 * JD-Core Version:    0.7.0.1
 */