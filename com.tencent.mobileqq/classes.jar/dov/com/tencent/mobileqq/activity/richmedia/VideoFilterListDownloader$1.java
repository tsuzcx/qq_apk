package dov.com.tencent.mobileqq.activity.richmedia;

import android.os.Bundle;
import ayrx;
import aysa;
import bkrb;
import bkuv;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import lch;

public class VideoFilterListDownloader$1
  implements Runnable
{
  public VideoFilterListDownloader$1(bkrb parambkrb, FilterDesc paramFilterDesc) {}
  
  public void run()
  {
    ayrx localayrx = new ayrx();
    localayrx.jdField_a_of_type_Aysc = this.this$0.a;
    localayrx.jdField_a_of_type_JavaLangString = this.a.resurl;
    localayrx.jdField_a_of_type_Int = 0;
    localayrx.c = (bkuv.b + this.a.name + ".zip");
    localayrx.a(this.a);
    localayrx.jdField_a_of_type_Aysd = this.this$0;
    if (this.a.bundle == null) {
      this.a.bundle = new Bundle();
    }
    this.a.bundle.putLong("requestStartTime", System.currentTimeMillis());
    lch.a().a(localayrx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.VideoFilterListDownloader.1
 * JD-Core Version:    0.7.0.1
 */