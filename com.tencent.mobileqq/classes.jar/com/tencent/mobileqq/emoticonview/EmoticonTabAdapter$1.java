package com.tencent.mobileqq.emoticonview;

import aprl;
import aprm;
import aube;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

public class EmoticonTabAdapter$1
  implements Runnable
{
  public EmoticonTabAdapter$1(aprl paramaprl, aprm paramaprm) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.w("EmoticonTabAdapter", 2, "package lossY");
    }
    aube localaube = (aube)this.this$0.a.getManager(14);
    EmoticonPackage localEmoticonPackage = localaube.a(this.a.a);
    if (localEmoticonPackage != null)
    {
      localEmoticonPackage.status = 0;
      localaube.a(localEmoticonPackage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonTabAdapter.1
 * JD-Core Version:    0.7.0.1
 */