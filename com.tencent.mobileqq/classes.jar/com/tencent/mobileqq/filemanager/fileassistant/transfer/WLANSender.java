package com.tencent.mobileqq.filemanager.fileassistant.transfer;

import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.FileExecutor;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.IThumbResult;
import java.util.concurrent.Executor;

public class WLANSender
  implements QQFileManagerUtil.IThumbResult
{
  FileManagerEntity a;
  QQAppInterface b;
  Session c = null;
  boolean d = false;
  
  public void a()
  {
    ((DataLineHandler)this.b.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(this.a.dlGroupId, this.a.nSessionId, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    this.a = paramFileManagerEntity;
    this.b = paramQQAppInterface;
    this.d = paramBoolean;
    FileManagerUtil.a(paramFileManagerEntity.getFilePath(), 384, 384, this);
  }
  
  public void a(String paramString)
  {
    paramString = (DataLineHandler)this.b.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    QQFileManagerUtil.FileExecutor.a().execute(new WLANSender.1(this, paramString));
  }
  
  public boolean a(long paramLong)
  {
    Session localSession = this.c;
    boolean bool = false;
    if (localSession == null) {
      return false;
    }
    if (localSession.uSessionID == paramLong) {
      bool = true;
    }
    return bool;
  }
  
  public void b()
  {
    ((DataLineHandler)this.b.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).k(32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.transfer.WLANSender
 * JD-Core Version:    0.7.0.1
 */