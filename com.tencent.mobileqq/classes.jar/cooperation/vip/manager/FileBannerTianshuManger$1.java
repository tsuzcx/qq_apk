package cooperation.vip.manager;

import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import cooperation.qzone.util.QZLog;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.List;

class FileBannerTianshuManger$1
  implements Runnable
{
  FileBannerTianshuManger$1(FileBannerTianshuManger paramFileBannerTianshuManger) {}
  
  public void run()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("FileBannerTianshuManger", "getTianShuAd");
    }
    ArrayList localArrayList = new ArrayList();
    TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.jdField_a_of_type_Int = FileBannerTianshuManger.jdField_a_of_type_Int;
    localTianShuAdPosItemData.b = 1;
    localArrayList.add(localTianShuAdPosItemData);
    TianShuManager.getInstance().requestAdv(localArrayList, this.this$0.jdField_a_of_type_ComTencentMobileqqTianshuDataTianShuGetAdvCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.manager.FileBannerTianshuManger.1
 * JD-Core Version:    0.7.0.1
 */