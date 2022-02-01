package com.tencent.mobileqq.webview.swift;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.colornote.api.IColorNoteController;

public class ReadInJoyColorNoteController
  extends WebColorNoteController
{
  public ReadInJoyColorNoteController(@NonNull QQBrowserActivity paramQQBrowserActivity)
  {
    super(paramQQBrowserActivity);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle = super.a();
    if (paramBundle != null)
    {
      paramBundle.disableSwipe();
      paramBundle.setShareEntr(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.ReadInJoyColorNoteController
 * JD-Core Version:    0.7.0.1
 */