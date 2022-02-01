package dov.com.tencent.mobileqq.activity.richmedia;

import android.os.Bundle;
import beum;
import beuo;
import bqzv;
import brdl;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import lbk;

public class VideoFilterListDownloader$1
  implements Runnable
{
  public VideoFilterListDownloader$1(bqzv parambqzv, FilterDesc paramFilterDesc) {}
  
  public void run()
  {
    beum localbeum = new beum();
    localbeum.jdField_a_of_type_Beuq = this.this$0.a;
    localbeum.jdField_a_of_type_JavaLangString = this.a.resurl;
    localbeum.jdField_a_of_type_Int = 0;
    localbeum.c = (brdl.b + this.a.name + ".zip");
    localbeum.a(this.a);
    localbeum.jdField_a_of_type_Beur = this.this$0;
    if (this.a.bundle == null) {
      this.a.bundle = new Bundle();
    }
    this.a.bundle.putLong("requestStartTime", System.currentTimeMillis());
    lbk.a().a(localbeum);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.VideoFilterListDownloader.1
 * JD-Core Version:    0.7.0.1
 */