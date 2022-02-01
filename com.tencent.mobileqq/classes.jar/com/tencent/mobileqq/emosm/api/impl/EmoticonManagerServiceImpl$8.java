package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class EmoticonManagerServiceImpl$8
  implements Runnable
{
  EmoticonManagerServiceImpl$8(EmoticonManagerServiceImpl paramEmoticonManagerServiceImpl, EmoticonPackage paramEmoticonPackage) {}
  
  public void run()
  {
    if (!EmoticonManagerServiceImpl.access$100(this.this$0, this.a))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveEmoticonPackage fail epId = ");
      localStringBuilder.append(this.a.epId);
      QLog.e("EmoticonManager", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.8
 * JD-Core Version:    0.7.0.1
 */