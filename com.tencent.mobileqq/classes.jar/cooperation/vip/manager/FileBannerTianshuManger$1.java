package cooperation.vip.manager;

import bmuk;
import bmvg;
import bmvi;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;

public class FileBannerTianshuManger$1
  implements Runnable
{
  public FileBannerTianshuManger$1(bmuk parambmuk) {}
  
  public void run()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("FileBannerTianshuManger", "getTianShuAd");
    }
    ArrayList localArrayList = new ArrayList();
    bmvg localbmvg = new bmvg();
    localbmvg.jdField_a_of_type_Int = bmuk.jdField_a_of_type_Int;
    localbmvg.b = 1;
    localArrayList.add(localbmvg);
    bmvi.a().a(localArrayList, this.this$0.jdField_a_of_type_Bmvh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.manager.FileBannerTianshuManger.1
 * JD-Core Version:    0.7.0.1
 */