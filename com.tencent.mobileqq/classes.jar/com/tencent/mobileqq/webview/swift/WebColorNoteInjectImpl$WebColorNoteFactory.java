package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class WebColorNoteInjectImpl$WebColorNoteFactory
{
  public static WebColorNoteController a(QQBrowserActivity paramQQBrowserActivity)
  {
    int i = paramQQBrowserActivity.getIntent().getIntExtra("web_color_note_type", 0);
    paramQQBrowserActivity.getIntent().removeExtra("web_color_note_type");
    if (i == 1) {
      return new ReadInJoyColorNoteController(paramQQBrowserActivity);
    }
    if (i == 2) {
      return new PublicAccountColorNoteController(paramQQBrowserActivity);
    }
    return new WebColorNoteController(paramQQBrowserActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebColorNoteInjectImpl.WebColorNoteFactory
 * JD-Core Version:    0.7.0.1
 */