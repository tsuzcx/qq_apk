package cooperation.vip.manager;

import bmni;
import cooperation.qzone.util.QZLog;
import cooperation.vip.tianshu.TianShuAdPosItemData;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.List;

public class FileBannerTianshuManger$1
  implements Runnable
{
  public FileBannerTianshuManger$1(bmni parambmni) {}
  
  public void run()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("FileBannerTianshuManger", "getTianShuAd");
    }
    ArrayList localArrayList = new ArrayList();
    TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.mPosId = bmni.jdField_a_of_type_Int;
    localTianShuAdPosItemData.mNeedCnt = 1;
    localArrayList.add(localTianShuAdPosItemData);
    TianShuManager.getInstance().requestAdv(localArrayList, this.this$0.jdField_a_of_type_CooperationVipTianshuTianShuGetAdvCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.manager.FileBannerTianshuManger.1
 * JD-Core Version:    0.7.0.1
 */