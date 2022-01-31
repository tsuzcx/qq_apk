package dov.com.tencent.mobileqq.activity.richmedia;

import android.os.Bundle;
import ayrv;
import ayry;
import bkqk;
import bkue;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import lcm;

public class VideoFilterListDownloader$1
  implements Runnable
{
  public VideoFilterListDownloader$1(bkqk parambkqk, FilterDesc paramFilterDesc) {}
  
  public void run()
  {
    ayrv localayrv = new ayrv();
    localayrv.jdField_a_of_type_Aysa = this.this$0.a;
    localayrv.jdField_a_of_type_JavaLangString = this.a.resurl;
    localayrv.jdField_a_of_type_Int = 0;
    localayrv.c = (bkue.b + this.a.name + ".zip");
    localayrv.a(this.a);
    localayrv.jdField_a_of_type_Aysb = this.this$0;
    if (this.a.bundle == null) {
      this.a.bundle = new Bundle();
    }
    this.a.bundle.putLong("requestStartTime", System.currentTimeMillis());
    lcm.a().a(localayrv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.VideoFilterListDownloader.1
 * JD-Core Version:    0.7.0.1
 */