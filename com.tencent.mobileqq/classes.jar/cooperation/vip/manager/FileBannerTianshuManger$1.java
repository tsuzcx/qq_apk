package cooperation.vip.manager;

import blax;
import blbu;
import blbw;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;

public class FileBannerTianshuManger$1
  implements Runnable
{
  public FileBannerTianshuManger$1(blax paramblax) {}
  
  public void run()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("FileBannerTianshuManger", "getTianShuAd");
    }
    ArrayList localArrayList = new ArrayList();
    blbu localblbu = new blbu();
    localblbu.jdField_a_of_type_Int = blax.jdField_a_of_type_Int;
    localblbu.b = 1;
    localArrayList.add(localblbu);
    blbw.a().a(localArrayList, this.this$0.jdField_a_of_type_Blbv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.manager.FileBannerTianshuManger.1
 * JD-Core Version:    0.7.0.1
 */