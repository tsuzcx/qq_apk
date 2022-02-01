package com.tencent.mobileqq.profilecommon.processor;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileassistant.top.FileAssistTopHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class FileAssistProcessor
  extends AbsProfileCommonProcessor
{
  public FileAssistProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  public String getProcessorKey()
  {
    return "FileAssistProcessor";
  }
  
  public boolean interceptProfileModifyPush(int paramInt)
  {
    return paramInt == 42489;
  }
  
  public void onProcessProfileModifyPush(int paramInt, ByteStringMicro paramByteStringMicro)
  {
    if (paramInt != 42489) {
      return;
    }
    if ((this.appRuntime instanceof QQAppInterface))
    {
      FileAssistTopHandler localFileAssistTopHandler = (FileAssistTopHandler)((QQAppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.FILE_ASSIST_TOP);
      boolean bool;
      if (ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asShortBuffer().get() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      localFileAssistTopHandler.b(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecommon.processor.FileAssistProcessor
 * JD-Core Version:    0.7.0.1
 */