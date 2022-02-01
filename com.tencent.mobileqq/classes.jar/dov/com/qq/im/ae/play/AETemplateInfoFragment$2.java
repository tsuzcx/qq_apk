package dov.com.qq.im.ae.play;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class AETemplateInfoFragment$2
  implements Runnable
{
  AETemplateInfoFragment$2(AETemplateInfoFragment paramAETemplateInfoFragment) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    FileUtils.deleteDirectory(AETemplateInfoFragment.CACHE_DIR);
    if (QLog.isDebugVersion()) {
      QLog.d("AETemplateInfoFragment", 4, new Object[] { "clear temp files finish, cost=", Long.valueOf(System.currentTimeMillis() - l) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AETemplateInfoFragment.2
 * JD-Core Version:    0.7.0.1
 */