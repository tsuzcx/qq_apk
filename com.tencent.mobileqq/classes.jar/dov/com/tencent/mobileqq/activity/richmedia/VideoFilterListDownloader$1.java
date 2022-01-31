package dov.com.tencent.mobileqq.activity.richmedia;

import android.os.Bundle;
import axro;
import axrr;
import bizy;
import bjds;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import kry;

public class VideoFilterListDownloader$1
  implements Runnable
{
  public VideoFilterListDownloader$1(bizy parambizy, FilterDesc paramFilterDesc) {}
  
  public void run()
  {
    axro localaxro = new axro();
    localaxro.jdField_a_of_type_Axrt = this.this$0.a;
    localaxro.jdField_a_of_type_JavaLangString = this.a.resurl;
    localaxro.jdField_a_of_type_Int = 0;
    localaxro.c = (bjds.b + this.a.name + ".zip");
    localaxro.a(this.a);
    localaxro.jdField_a_of_type_Axru = this.this$0;
    if (this.a.bundle == null) {
      this.a.bundle = new Bundle();
    }
    this.a.bundle.putLong("requestStartTime", System.currentTimeMillis());
    kry.a().a(localaxro);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.VideoFilterListDownloader.1
 * JD-Core Version:    0.7.0.1
 */