package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.app.QQAppInterface;

public class FileForwardManager
{
  private QQAppInterface a;
  
  public FileForwardManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong, String paramString5, FileForwardManager.ForwarResult paramForwarResult)
  {
    ProtocolManager localProtocolManager = this.a.getFileManagerEngine().a();
    ProtocolManager.FileInfo localFileInfo = new ProtocolManager.FileInfo();
    localFileInfo.jdField_a_of_type_JavaLangString = paramString4;
    localFileInfo.jdField_a_of_type_Long = paramLong;
    localFileInfo.c = paramString5;
    localFileInfo.b = paramString3;
    if (paramInt1 != 3000)
    {
      localProtocolManager.a(paramString1, paramInt1, paramString2, paramInt2, localFileInfo, 5000, 5, new FileForwardManager.3(this, paramForwarResult));
      return;
    }
    localProtocolManager.a(paramString1, paramString2, localFileInfo, new FileForwardManager.4(this, paramForwarResult));
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt2, FileForwardManager.ForwarResult paramForwarResult)
  {
    ProtocolManager localProtocolManager = this.a.getFileManagerEngine().a();
    ProtocolManager.FileInfo localFileInfo = new ProtocolManager.FileInfo();
    localFileInfo.jdField_a_of_type_JavaLangString = paramString4;
    localFileInfo.jdField_a_of_type_Long = paramLong;
    if ((paramInt1 == 3000) || (paramInt1 == 1))
    {
      localProtocolManager.a(paramString2, paramString1, localFileInfo, paramInt2, 5000, 3, new FileForwardManager.1(this, paramForwarResult));
      return;
    }
    localProtocolManager.a(paramString1, paramInt1, paramString2, paramString3, 5000, 3, new FileForwardManager.2(this, paramForwarResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileForwardManager
 * JD-Core Version:    0.7.0.1
 */