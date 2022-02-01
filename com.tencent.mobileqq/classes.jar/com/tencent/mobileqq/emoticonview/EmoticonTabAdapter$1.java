package com.tencent.mobileqq.emoticonview;

import avsq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class EmoticonTabAdapter$1
  implements Runnable
{
  EmoticonTabAdapter$1(EmoticonTabAdapter paramEmoticonTabAdapter, EmoticonTabAdapter.EmoticonTabItem paramEmoticonTabItem) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.w("EmoticonTabAdapter", 2, "package lossY");
    }
    avsq localavsq = (avsq)this.this$0.app.getManager(14);
    EmoticonPackage localEmoticonPackage = localavsq.a(this.val$item.epId);
    if (localEmoticonPackage != null)
    {
      localEmoticonPackage.status = 0;
      localavsq.a(localEmoticonPackage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonTabAdapter.1
 * JD-Core Version:    0.7.0.1
 */