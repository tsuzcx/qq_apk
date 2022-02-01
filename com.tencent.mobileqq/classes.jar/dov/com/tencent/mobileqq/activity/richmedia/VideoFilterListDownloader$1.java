package dov.com.tencent.mobileqq.activity.richmedia;

import android.os.Bundle;
import bdvs;
import bdvu;
import bpya;
import bqbq;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import lbd;

public class VideoFilterListDownloader$1
  implements Runnable
{
  public VideoFilterListDownloader$1(bpya parambpya, FilterDesc paramFilterDesc) {}
  
  public void run()
  {
    bdvs localbdvs = new bdvs();
    localbdvs.jdField_a_of_type_Bdvw = this.this$0.a;
    localbdvs.jdField_a_of_type_JavaLangString = this.a.resurl;
    localbdvs.jdField_a_of_type_Int = 0;
    localbdvs.c = (bqbq.b + this.a.name + ".zip");
    localbdvs.a(this.a);
    localbdvs.jdField_a_of_type_Bdvx = this.this$0;
    if (this.a.bundle == null) {
      this.a.bundle = new Bundle();
    }
    this.a.bundle.putLong("requestStartTime", System.currentTimeMillis());
    lbd.a().a(localbdvs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.VideoFilterListDownloader.1
 * JD-Core Version:    0.7.0.1
 */