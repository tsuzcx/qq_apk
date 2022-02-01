package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;

class EmoticonManagerServiceImpl$9
  implements Runnable
{
  EmoticonManagerServiceImpl$9(EmoticonManagerServiceImpl paramEmoticonManagerServiceImpl, Emoticon paramEmoticon) {}
  
  public void run()
  {
    EmoticonManagerServiceImpl.access$200(this.this$0, this.a);
    if (!EmoticonManagerServiceImpl.access$100(this.this$0, this.a))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveEmoticon fail epId = ");
      localStringBuilder.append(this.a.epId);
      localStringBuilder.append(", eId = ");
      localStringBuilder.append(this.a.eId);
      QLog.e("EmoticonManager", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.9
 * JD-Core Version:    0.7.0.1
 */