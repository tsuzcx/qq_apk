package com.tencent.mobileqq.magicface.view;

import asdy;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;

public class MagicfaceViewController$3
  implements Runnable
{
  public MagicfaceViewController$3(asdy paramasdy) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "func run, magicValue:" + this.this$0.a.magicValue);
    }
    this.this$0.a(this.this$0.a, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceViewController.3
 * JD-Core Version:    0.7.0.1
 */