package com.tencent.mobileqq.magicface.view;

import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;

class MagicfaceViewController$3
  implements Runnable
{
  MagicfaceViewController$3(MagicfaceViewController paramMagicfaceViewController) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func run, magicValue:");
      ((StringBuilder)localObject).append(this.this$0.B.magicValue);
      QLog.d("MagicfaceViewController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.this$0;
    ((MagicfaceViewController)localObject).a(((MagicfaceViewController)localObject).B, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceViewController.3
 * JD-Core Version:    0.7.0.1
 */