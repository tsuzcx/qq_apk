package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IProtocolManager;

public class FileForwardManager
{
  private QQAppInterface a;
  
  public FileForwardManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong, String paramString5, FileForwardManager.ForwarResult paramForwarResult)
  {
    IProtocolManager localIProtocolManager = (IProtocolManager)this.a.getRuntimeService(IProtocolManager.class);
    ProtocolFileInfo localProtocolFileInfo = new ProtocolFileInfo();
    localProtocolFileInfo.jdField_a_of_type_JavaLangString = paramString4;
    localProtocolFileInfo.jdField_a_of_type_Long = paramLong;
    localProtocolFileInfo.c = paramString5;
    localProtocolFileInfo.b = paramString3;
    if (paramInt1 != 3000)
    {
      localIProtocolManager.forwardDiscToOther(paramString1, paramInt1, paramString2, paramInt2, localProtocolFileInfo, 5000, 5, new FileForwardManager.3(this, paramForwarResult));
      return;
    }
    localIProtocolManager.forwardDisc2Disc(paramString1, paramString2, localProtocolFileInfo, new FileForwardManager.4(this, paramForwarResult));
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt2, FileForwardManager.ForwarResult paramForwarResult)
  {
    IProtocolManager localIProtocolManager = (IProtocolManager)this.a.getRuntimeService(IProtocolManager.class);
    ProtocolFileInfo localProtocolFileInfo = new ProtocolFileInfo();
    localProtocolFileInfo.jdField_a_of_type_JavaLangString = paramString4;
    localProtocolFileInfo.jdField_a_of_type_Long = paramLong;
    if ((paramInt1 != 3000) && (paramInt1 != 1))
    {
      localIProtocolManager.forwardOfflineFileToBuddy(paramString1, paramInt1, paramString2, paramString3, 5000, 3, new FileForwardManager.2(this, paramForwarResult));
      return;
    }
    localIProtocolManager.forwardOfflineFileToOther(paramString2, paramString1, localProtocolFileInfo, paramInt2, 5000, 3, new FileForwardManager.1(this, paramForwarResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileForwardManager
 * JD-Core Version:    0.7.0.1
 */