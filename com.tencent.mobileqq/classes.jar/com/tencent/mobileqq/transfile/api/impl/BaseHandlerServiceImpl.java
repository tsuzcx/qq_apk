package com.tencent.mobileqq.transfile.api.impl;

import com.tencent.mobileqq.transfile.api.IBaseHandlerService;
import com.tencent.mobileqq.transfile.protohandler.BaseHandler;

public class BaseHandlerServiceImpl
  implements IBaseHandlerService
{
  public int getHandlerNetType()
  {
    return BaseHandler.getHandlerNetType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.api.impl.BaseHandlerServiceImpl
 * JD-Core Version:    0.7.0.1
 */