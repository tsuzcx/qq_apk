package com.tencent.mobileqq.filemanager.activity.fileassistant;

import alud;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

class FileAssistantActivity$1$2
  implements Runnable
{
  FileAssistantActivity$1$2(FileAssistantActivity.1 param1) {}
  
  public void run()
  {
    this.a.this$0.a = ((ViewStub)this.a.this$0.findViewById(2131380111));
    View localView = this.a.this$0.a.inflate();
    this.a.this$0.a.setVisibility(0);
    ((TextView)localView.findViewById(2131379040)).setText(alud.a(2131704878));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity.1.2
 * JD-Core Version:    0.7.0.1
 */