package com.tencent.mobileqq.emoticonview;

import awyr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
    awyr localawyr = (awyr)this.this$0.app.getManager(QQManagerFactory.EMOTICON_MANAGER);
    EmoticonPackage localEmoticonPackage = localawyr.a(this.val$item.epId);
    if (localEmoticonPackage != null)
    {
      localEmoticonPackage.status = 0;
      localawyr.a(localEmoticonPackage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonTabAdapter.1
 * JD-Core Version:    0.7.0.1
 */