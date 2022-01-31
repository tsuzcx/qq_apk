package cooperation.qqreader.host.advertisement;

import bhzt;
import bhzv;
import java.util.ArrayList;
import java.util.List;

public class ReaderTianShuSdk
{
  public static void requestAd(int paramInt1, int paramInt2, ReaderTianShuSdk.RequestListener paramRequestListener)
  {
    ArrayList localArrayList = new ArrayList();
    bhzt localbhzt = new bhzt();
    localbhzt.a = paramInt1;
    localbhzt.b = paramInt2;
    localArrayList.add(localbhzt);
    bhzv.a().a(localArrayList, new ReaderTianShuSdk.ReaderTianShuGetAdvCallback(paramInt1, paramRequestListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.host.advertisement.ReaderTianShuSdk
 * JD-Core Version:    0.7.0.1
 */