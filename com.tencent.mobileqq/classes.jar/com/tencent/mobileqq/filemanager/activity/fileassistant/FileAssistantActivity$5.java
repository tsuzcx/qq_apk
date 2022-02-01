package com.tencent.mobileqq.filemanager.activity.fileassistant;

import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;

class FileAssistantActivity$5
  extends FMObserver
{
  FileAssistantActivity$5(FileAssistantActivity paramFileAssistantActivity) {}
  
  protected void a(boolean paramBoolean)
  {
    if (FileAssistantActivity.a(this.a)) {
      return;
    }
    this.a.runOnUiThread(new FileAssistantActivity.5.1(this, paramBoolean));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.a.a();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.a.a.a();
  }
  
  protected void b(int paramInt, String paramString)
  {
    if (!FileAssistantActivity.a(this.a)) {
      FMToastUtil.a(paramString);
    }
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    super.b(paramLong1, paramLong2, paramString, paramInt);
    this.a.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity.5
 * JD-Core Version:    0.7.0.1
 */