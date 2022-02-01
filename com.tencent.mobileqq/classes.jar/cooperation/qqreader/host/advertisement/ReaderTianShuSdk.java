package cooperation.qqreader.host.advertisement;

import bnwo;
import bnwq;
import java.util.ArrayList;
import java.util.List;

public class ReaderTianShuSdk
{
  public static void requestAd(int paramInt1, int paramInt2, ReaderTianShuSdk.RequestListener paramRequestListener)
  {
    ArrayList localArrayList = new ArrayList();
    bnwo localbnwo = new bnwo();
    localbnwo.a = paramInt1;
    localbnwo.b = paramInt2;
    localArrayList.add(localbnwo);
    bnwq.a().a(localArrayList, new ReaderTianShuSdk.ReaderTianShuGetAdvCallback(paramInt1, paramRequestListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.host.advertisement.ReaderTianShuSdk
 * JD-Core Version:    0.7.0.1
 */