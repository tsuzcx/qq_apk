package com.tencent.mobileqq.filemanager.activity.fileassistant;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;

class FileAssistantActivity$1$2
  implements Runnable
{
  FileAssistantActivity$1$2(FileAssistantActivity.1 param1) {}
  
  public void run()
  {
    this.a.this$0.W = ((ViewStub)this.a.this$0.findViewById(2131450017));
    View localView = this.a.this$0.W.inflate();
    this.a.this$0.W.setVisibility(0);
    ((TextView)localView.findViewById(2131448810)).setText(HardCodeUtil.a(2131896115));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity.1.2
 * JD-Core Version:    0.7.0.1
 */