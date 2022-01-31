package dov.com.tencent.mobileqq.activity.richmedia;

import android.os.Bundle;
import baps;
import bapv;
import bncl;
import bngf;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import lel;

public class VideoFilterListDownloader$1
  implements Runnable
{
  public VideoFilterListDownloader$1(bncl parambncl, FilterDesc paramFilterDesc) {}
  
  public void run()
  {
    baps localbaps = new baps();
    localbaps.jdField_a_of_type_Bapx = this.this$0.a;
    localbaps.jdField_a_of_type_JavaLangString = this.a.resurl;
    localbaps.jdField_a_of_type_Int = 0;
    localbaps.c = (bngf.b + this.a.name + ".zip");
    localbaps.a(this.a);
    localbaps.jdField_a_of_type_Bapy = this.this$0;
    if (this.a.bundle == null) {
      this.a.bundle = new Bundle();
    }
    this.a.bundle.putLong("requestStartTime", System.currentTimeMillis());
    lel.a().a(localbaps);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.VideoFilterListDownloader.1
 * JD-Core Version:    0.7.0.1
 */