import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/srtUtils/longcontentinfoupdater/LongContentInfoUpdaterVideoSmallPic;", "Lcom/tencent/biz/pubaccount/readinjoy/srtUtils/longcontentinfoupdater/LongContentInfoUpdater;", "()V", "process", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rce
  extends rby
{
  protected void a()
  {
    rex localrex1 = null;
    Object localObject1 = a();
    if (localObject1 != null) {
      ((SocializeFeedsInfo)localObject1).a = 1;
    }
    Object localObject2 = a();
    localObject1 = a();
    if (localObject1 != null)
    {
      localObject1 = ((rex)localObject1).a;
      if (localObject1 == null) {}
    }
    for (localObject1 = ((rfg)localObject1).g;; localObject1 = null)
    {
      ((BaseArticleInfo)localObject2).mTitle = ((String)localObject1);
      localObject2 = a();
      if (localObject2 != null)
      {
        ((rfe)localObject2).a = true;
        rex localrex2 = a();
        localObject1 = localrex1;
        if (localrex2 != null) {
          localObject1 = localrex2.a;
        }
        ((rfe)localObject2).b = new ArrayList();
        ((rfe)localObject2).b.add(localObject1);
      }
      try
      {
        localObject1 = a();
        localrex1 = a();
        if (localrex1 == null) {
          Intrinsics.throwNpe();
        }
        ((BaseArticleInfo)localObject1).mSinglePicture = new URL(localrex1.a.d);
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
 * Qualified Name:     rce
 * JD-Core Version:    0.7.0.1
 */