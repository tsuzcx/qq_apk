import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/srtUtils/longcontentinfoupdater/LongContentInfoUpdaterVideoBigPic;", "Lcom/tencent/biz/pubaccount/readinjoy/srtUtils/longcontentinfoupdater/LongContentInfoUpdater;", "()V", "process", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rem
  extends reh
{
  protected void a()
  {
    Object localObject = a();
    if (localObject != null) {
      ((SocializeFeedsInfo)localObject).a = 6;
    }
    localObject = a();
    if (localObject != null) {
      ((rhn)localObject).a = true;
    }
    localObject = a();
    if (localObject != null)
    {
      localObject = ((rhg)localObject).a;
      if (localObject != null)
      {
        a().mTitle = ((rhp)localObject).g;
        a().mVideoVid = ((rhp)localObject).e;
      }
    }
    try
    {
      localObject = a();
      if (localObject != null)
      {
        localObject = ((rhg)localObject).a;
        if (localObject != null)
        {
          localObject = ((rhp)localObject).d;
          if (localObject != null) {
            a().mVideoCoverUrl = new URL((String)localObject);
          }
        }
      }
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rem
 * JD-Core Version:    0.7.0.1
 */