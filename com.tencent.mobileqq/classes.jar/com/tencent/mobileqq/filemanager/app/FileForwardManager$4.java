package com.tencent.mobileqq.filemanager.app;

class FileForwardManager$4
  extends ProtocolFileCallback.OnForwardOfflineResult
{
  FileForwardManager$4(FileForwardManager paramFileForwardManager, FileForwardManager.ForwarResult paramForwarResult) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    if (paramBoolean)
    {
      this.a.a(paramString2, paramString3);
      return;
    }
    this.a.a(paramInt, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileForwardManager.4
 * JD-Core Version:    0.7.0.1
 */