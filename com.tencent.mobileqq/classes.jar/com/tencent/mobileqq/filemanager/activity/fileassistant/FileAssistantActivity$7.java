package com.tencent.mobileqq.filemanager.activity.fileassistant;

import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;

class FileAssistantActivity$7
  extends FMObserver
{
  FileAssistantActivity$7(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void a(boolean paramBoolean)
  {
    if (FileAssistantActivity.a(this.a)) {
      return;
    }
    this.a.runOnUiThread(new FileAssistantActivity.7.1(this, paramBoolean));
  }
  
  public void b(int paramInt, String paramString)
  {
    if (!FileAssistantActivity.a(this.a)) {
      FMToastUtil.a(paramString);
    }
  }
  
  public void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    super.b(paramLong1, paramLong2, paramString, paramInt);
    this.a.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity.7
 * JD-Core Version:    0.7.0.1
 */