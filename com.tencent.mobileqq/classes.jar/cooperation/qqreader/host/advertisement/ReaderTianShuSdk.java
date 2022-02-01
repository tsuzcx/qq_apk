package cooperation.qqreader.host.advertisement;

import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.List;

public class ReaderTianShuSdk
{
  public static void requestAd(int paramInt1, int paramInt2, ReaderTianShuSdk.RequestListener paramRequestListener)
  {
    ArrayList localArrayList = new ArrayList();
    TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.a = paramInt1;
    localTianShuAdPosItemData.b = paramInt2;
    localArrayList.add(localTianShuAdPosItemData);
    TianShuManager.getInstance().requestAdv(localArrayList, new ReaderTianShuSdk.ReaderTianShuGetAdvCallback(paramInt1, paramRequestListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.host.advertisement.ReaderTianShuSdk
 * JD-Core Version:    0.7.0.1
 */