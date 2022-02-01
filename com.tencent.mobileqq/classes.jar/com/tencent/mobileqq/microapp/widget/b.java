package com.tencent.mobileqq.microapp.widget;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.smtt.sdk.TbsReaderView;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.io.File;

public final class b
  implements TbsReaderView.ReaderCallback
{
  private TbsReaderView a = new TbsReaderView(paramContext, this);
  private Context b;
  
  public b(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private String a(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return "";
    }
    int i = paramString.lastIndexOf('.');
    if (i <= -1) {
      return "";
    }
    return paramString.substring(i + 1);
  }
  
  public TbsReaderView a(Context paramContext)
  {
    return new TbsReaderView(paramContext, this);
  }
  
  public void a()
  {
    TbsReaderView localTbsReaderView = this.a;
    if (localTbsReaderView != null) {
      localTbsReaderView.onStop();
    }
  }
  
  public void a(FrameLayout paramFrameLayout)
  {
    if (paramFrameLayout == null) {
      return;
    }
    paramFrameLayout.removeView(this.a);
  }
  
  public void a(FrameLayout paramFrameLayout, FrameLayout.LayoutParams paramLayoutParams)
  {
    if (paramFrameLayout == null) {
      return;
    }
    paramFrameLayout.addView(this.a, paramLayoutParams);
  }
  
  public void a(File paramFile)
  {
    if ((paramFile != null) && (!StringUtil.isEmpty(paramFile.toString())))
    {
      File localFile = new File(com.tencent.mobileqq.microapp.appbrand.b.b.a().a(""));
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("filePath", paramFile.toString());
      localBundle.putString("tempPath", localFile.getAbsolutePath());
      if (this.a == null) {
        this.a = a(this.b);
      }
      if (this.a.preOpen(a(paramFile.toString()), false)) {
        this.a.openFile(localBundle);
      }
    }
  }
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.b
 * JD-Core Version:    0.7.0.1
 */