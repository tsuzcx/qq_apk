import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/srtUtils/longcontentinfoupdater/LongContentInfoUpdaterVideoSmallPic;", "Lcom/tencent/biz/pubaccount/readinjoy/srtUtils/longcontentinfoupdater/LongContentInfoUpdater;", "()V", "process", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ren
  extends reh
{
  protected void a()
  {
    rhg localrhg1 = null;
    Object localObject1 = a();
    if (localObject1 != null) {
      ((SocializeFeedsInfo)localObject1).a = 1;
    }
    Object localObject2 = a();
    localObject1 = a();
    if (localObject1 != null)
    {
      localObject1 = ((rhg)localObject1).a;
      if (localObject1 == null) {}
    }
    for (localObject1 = ((rhp)localObject1).g;; localObject1 = null)
    {
      ((BaseArticleInfo)localObject2).mTitle = ((String)localObject1);
      localObject2 = a();
      if (localObject2 != null)
      {
        ((rhn)localObject2).a = true;
        rhg localrhg2 = a();
        localObject1 = localrhg1;
        if (localrhg2 != null) {
          localObject1 = localrhg2.a;
        }
        ((rhn)localObject2).b = new ArrayList();
        ((rhn)localObject2).b.add(localObject1);
      }
      try
      {
        localObject1 = a();
        localrhg1 = a();
        if (localrhg1 == null) {
          Intrinsics.throwNpe();
        }
        ((BaseArticleInfo)localObject1).mSinglePicture = new URL(localrhg1.a.d);
        return;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          localMalformedURLException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ren
 * JD-Core Version:    0.7.0.1
 */