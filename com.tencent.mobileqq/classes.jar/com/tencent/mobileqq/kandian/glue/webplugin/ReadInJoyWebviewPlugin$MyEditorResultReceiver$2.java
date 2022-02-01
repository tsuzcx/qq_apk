package com.tencent.mobileqq.kandian.glue.webplugin;

import android.content.Intent;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.CustomDialogClickListener;
import com.tencent.mobileqq.kandian.biz.comment.WebCommentEditorHandler;
import com.tencent.mobileqq.kandian.biz.comment.base.ReadInJoyCommentEntrance;
import mqq.util.WeakReference;

class ReadInJoyWebviewPlugin$MyEditorResultReceiver$2
  implements ReadInJoyCommentUtils.CustomDialogClickListener
{
  ReadInJoyWebviewPlugin$MyEditorResultReceiver$2(ReadInJoyWebviewPlugin.MyEditorResultReceiver paramMyEditorResultReceiver, Intent paramIntent, String paramString) {}
  
  public void a()
  {
    if ((ReadInJoyWebviewPlugin)ReadInJoyWebviewPlugin.MyEditorResultReceiver.a(this.c).get() == null) {
      return;
    }
    WebCommentEditorHandler.a(-1, this.a, this.c);
  }
  
  public void b()
  {
    ReadInJoyCommentEntrance.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.ReadInJoyWebviewPlugin.MyEditorResultReceiver.2
 * JD-Core Version:    0.7.0.1
 */