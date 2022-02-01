package com.tencent.mobileqq.filemanager.activity.localfile;

import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import java.util.LinkedHashMap;
import java.util.Map;

class QfileLocalFilePicTabView$1$1
  implements Runnable
{
  QfileLocalFilePicTabView$1$1(QfileLocalFilePicTabView.1 param1, Map paramMap, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.d.this$0.l.clear();
    this.d.this$0.l.putAll(this.a);
    this.d.this$0.i();
    if ((this.b != -1) && (this.c != -1))
    {
      if ((!this.d.this$0.C.F()) && (!this.d.this$0.C.G()))
      {
        this.d.this$0.setSelect(0);
        return;
      }
      this.d.this$0.setPos(this.b, this.c);
      return;
    }
    this.d.this$0.setSelect(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView.1.1
 * JD-Core Version:    0.7.0.1
 */