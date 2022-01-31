package cooperation.qqreader.host.advertisement;

import bkgn;
import bkgp;
import java.util.ArrayList;
import java.util.List;

public class ReaderTianShuSdk
{
  public static void requestAd(int paramInt1, int paramInt2, ReaderTianShuSdk.RequestListener paramRequestListener)
  {
    ArrayList localArrayList = new ArrayList();
    bkgn localbkgn = new bkgn();
    localbkgn.a = paramInt1;
    localbkgn.b = paramInt2;
    localArrayList.add(localbkgn);
    bkgp.a().a(localArrayList, new ReaderTianShuSdk.ReaderTianShuGetAdvCallback(paramInt1, paramRequestListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.host.advertisement.ReaderTianShuSdk
 * JD-Core Version:    0.7.0.1
 */