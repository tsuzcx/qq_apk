package com.tencent.mobileqq.microapp.widget;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import bbkk;
import com.tencent.mobileqq.microapp.appbrand.utils.b;
import com.tencent.smtt.sdk.TbsReaderView;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.io.File;

public final class d
  implements TbsReaderView.ReaderCallback
{
  private TbsReaderView a = new TbsReaderView(paramContext, this);
  private Context b;
  
  public d(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private String a(String paramString)
  {
    if (bbkk.a(paramString)) {}
    int i;
    do
    {
      return "";
      i = paramString.lastIndexOf('.');
    } while (i <= -1);
    return paramString.substring(i + 1);
  }
  
  public TbsReaderView a(Context paramContext)
  {
    return new TbsReaderView(paramContext, this);
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.onStop();
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
    if ((paramFile != null) && (!bbkk.a(paramFile.toString())))
    {
      File localFile = new File(b.a().a(""));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.d
 * JD-Core Version:    0.7.0.1
 */