package cooperation.vip.manager;

import bnvs;
import bnwo;
import bnwq;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;

public class FileBannerTianshuManger$1
  implements Runnable
{
  public FileBannerTianshuManger$1(bnvs parambnvs) {}
  
  public void run()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("FileBannerTianshuManger", "getTianShuAd");
    }
    ArrayList localArrayList = new ArrayList();
    bnwo localbnwo = new bnwo();
    localbnwo.jdField_a_of_type_Int = bnvs.jdField_a_of_type_Int;
    localbnwo.b = 1;
    localArrayList.add(localbnwo);
    bnwq.a().a(localArrayList, this.this$0.jdField_a_of_type_Bnwp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.manager.FileBannerTianshuManger.1
 * JD-Core Version:    0.7.0.1
 */