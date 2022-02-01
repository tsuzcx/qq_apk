package cooperation.vip.manager;

import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;

class FileBannerTianshuManger$2
  implements TianShuGetAdvCallback
{
  FileBannerTianshuManger$2(FileBannerTianshuManger paramFileBannerTianshuManger) {}
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    this.a.a(paramBoolean, paramGetAdsRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.manager.FileBannerTianshuManger.2
 * JD-Core Version:    0.7.0.1
 */