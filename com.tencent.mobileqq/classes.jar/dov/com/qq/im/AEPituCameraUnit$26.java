package dov.com.qq.im;

import bgxx;
import bhcw;
import bhfm;
import com.tencent.qphone.base.util.QLog;
import wsh;
import wwj;

public class AEPituCameraUnit$26
  implements Runnable
{
  public AEPituCameraUnit$26(bhcw parambhcw) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(bhcw.a(), 2, "onResourceDownload update filterpager begin");
    }
    Object localObject = bhcw.a(this.this$0);
    if (bhcw.a(this.this$0) == wsh.a) {}
    for (boolean bool = true;; bool = false)
    {
      ((wwj)localObject).c(bool);
      localObject = (bgxx)bhfm.a(18);
      bhfv.c = 0;
      if (QLog.isColorLevel()) {
        QLog.d(bhcw.a(), 2, "onResourceDownload update filterpager end");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AEPituCameraUnit.26
 * JD-Core Version:    0.7.0.1
 */