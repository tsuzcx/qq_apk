package dov.com.tencent.mobileqq.activity.richmedia;

import android.os.Bundle;
import baub;
import baue;
import bngx;
import bnkr;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import lel;

public class VideoFilterListDownloader$1
  implements Runnable
{
  public VideoFilterListDownloader$1(bngx parambngx, FilterDesc paramFilterDesc) {}
  
  public void run()
  {
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_Baug = this.this$0.a;
    localbaub.jdField_a_of_type_JavaLangString = this.a.resurl;
    localbaub.jdField_a_of_type_Int = 0;
    localbaub.c = (bnkr.b + this.a.name + ".zip");
    localbaub.a(this.a);
    localbaub.jdField_a_of_type_Bauh = this.this$0;
    if (this.a.bundle == null) {
      this.a.bundle = new Bundle();
    }
    this.a.bundle.putLong("requestStartTime", System.currentTimeMillis());
    lel.a().a(localbaub);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.VideoFilterListDownloader.1
 * JD-Core Version:    0.7.0.1
 */