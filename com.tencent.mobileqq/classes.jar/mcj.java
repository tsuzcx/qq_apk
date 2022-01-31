import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsIPCClient;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsIPCClient.Observer;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.util.Iterator;
import java.util.List;

public class mcj
  extends QIPCModule
{
  public mcj(VideoFeedsIPCClient paramVideoFeedsIPCClient, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    synchronized (VideoFeedsIPCClient.a(this.a))
    {
      Iterator localIterator = VideoFeedsIPCClient.a(this.a).iterator();
      if (localIterator.hasNext()) {
        ((VideoFeedsIPCClient.Observer)localIterator.next()).a(paramString, paramBundle);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mcj
 * JD-Core Version:    0.7.0.1
 */