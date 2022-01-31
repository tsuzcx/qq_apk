package com.tencent.mobileqq.mini.widget;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import bdje;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsReaderView;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.io.File;

public class MiniAppFileView
  implements TbsReaderView.ReaderCallback
{
  private static String TAG = "MiniAppFileView";
  private Context context;
  private boolean isFileShow;
  private TbsReaderView mTbsReaderView = new TbsReaderView(paramContext, this);
  
  public MiniAppFileView(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private String getFileType(String paramString)
  {
    if (bdje.a(paramString)) {}
    int i;
    do
    {
      return "";
      i = paramString.lastIndexOf('.');
    } while (i <= -1);
    return paramString.substring(i + 1);
  }
  
  public void addView(FrameLayout paramFrameLayout, FrameLayout.LayoutParams paramLayoutParams)
  {
    if (paramFrameLayout == null) {
      return;
    }
    paramFrameLayout.addView(this.mTbsReaderView, paramLayoutParams);
  }
  
  public boolean displayFile(File paramFile)
  {
    if ((paramFile != null) && (!bdje.a(paramFile.toString())) && (!this.isFileShow))
    {
      File localFile = new File(MiniAppFileManager.getInstance().getTmpPath(""));
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("filePath", paramFile.toString());
      localBundle.putString("tempPath", localFile.getAbsolutePath());
      if (this.mTbsReaderView == null) {
        this.mTbsReaderView = getTbsReaderView(this.context);
      }
      if (this.mTbsReaderView.preOpen(getFileType(paramFile.toString()), false))
      {
        this.isFileShow = true;
        this.mTbsReaderView.openFile(localBundle);
        return true;
      }
    }
    return false;
  }
  
  public TbsReaderView getTbsReaderView(Context paramContext)
  {
    return new TbsReaderView(paramContext, this);
  }
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    Object localObject = null;
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("TbsReaderView callback actionType : ").append(paramInteger).append("; args : ");
    if (paramObject1 != null) {}
    for (paramInteger = paramObject1.toString();; paramInteger = null)
    {
      paramObject1 = localStringBuilder.append(paramInteger).append(" result : ");
      paramInteger = localObject;
      if (paramObject2 != null) {
        paramInteger = paramObject2.toString();
      }
      QLog.d(str, 1, paramInteger);
      return;
    }
  }
  
  public void onStopDisplay()
  {
    if (this.mTbsReaderView != null) {
      this.mTbsReaderView.onStop();
    }
  }
  
  public void removeView(FrameLayout paramFrameLayout)
  {
    if (paramFrameLayout == null) {
      return;
    }
    paramFrameLayout.removeView(this.mTbsReaderView);
    this.isFileShow = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniAppFileView
 * JD-Core Version:    0.7.0.1
 */