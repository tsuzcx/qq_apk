package dov.com.tencent.mobileqq.shortvideo.util.videoconverter;

import android.annotation.TargetApi;
import bntf;
import bnth;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.io.File;

@TargetApi(18)
public class JBMR2VideoConverterImpl
  implements bnth
{
  boolean a = false;
  boolean b = false;
  
  public boolean a(File paramFile, bntf parambntf, boolean paramBoolean)
  {
    if (!this.a)
    {
      this.a = true;
      paramFile = new JBMR2VideoConverterImpl.Converter(this, paramFile, parambntf);
      if (!paramBoolean)
      {
        ThreadManagerV2.excute(paramFile, 16, null, false);
        return true;
      }
      paramFile.run();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.videoconverter.JBMR2VideoConverterImpl
 * JD-Core Version:    0.7.0.1
 */