package cooperation.qqcircle.picload;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.mobileqq.utils.FileUtils;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class PicDownLoadTask
  implements Runnable
{
  protected QCirclePicStateListener mListener;
  protected Option mOption;
  protected volatile int mStatus;
  
  public PicDownLoadTask(@NotNull Option paramOption)
  {
    this.mOption = paramOption;
    this.mStatus = 1;
  }
  
  private void doRealDownLoad(long paramLong)
  {
    QCirclePicDownLoader.g().downLoad(this.mOption, new PicDownLoadTask.1(this, this.mOption, paramLong));
  }
  
  private List<FeedCloudCommon.Entry> getDownLoadSpeed(Option paramOption, double paramDouble, int paramInt)
  {
    double d2 = -1.0D;
    double d1 = d2;
    if (paramInt == 0)
    {
      d1 = d2;
      if (paramDouble > -1.0D)
      {
        d1 = d2;
        if (FileUtils.a(paramOption.getLocalPath()))
        {
          d1 = d2;
          if (paramOption.getPicType() != 3)
          {
            long l = FileUtils.a(paramOption.getLocalPath()) / 1024L;
            d1 = new BigDecimal(l / paramDouble).setScale(2, 4).doubleValue();
            RFLog.d("QCircleFeedPicLoader", RFLog.USR, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + " timeCost:" + paramDouble + " fileSize:" + l + " qCirclePic download speed: " + d1 + "kb/s");
          }
        }
      }
    }
    paramOption = new ArrayList();
    paramOption.add(QCircleReportHelper.newEntry("rate", String.valueOf(d1)));
    return paramOption;
  }
  
  public void cancel()
  {
    if (this.mStatus != 6)
    {
      this.mStatus = 4;
      if (this.mListener != null) {
        this.mListener.onStateChang(4, this.mOption);
      }
    }
  }
  
  public Option getOption()
  {
    return this.mOption;
  }
  
  protected void reportDownloadResult(Option paramOption, int paramInt)
  {
    if (paramOption != null) {
      if (paramOption.mDownLoadStartTime == null) {
        break label93;
      }
    }
    label93:
    for (double d = (float)(System.currentTimeMillis() - paramOption.mDownLoadStartTime.longValue()) / 1000.0F;; d = -1.0D)
    {
      List localList = getDownLoadSpeed(paramOption, d, paramInt);
      QCircleQualityReporter.reportImageQualityEvent("image_download_ret", String.valueOf(d), String.valueOf(paramInt), paramOption.getUrl() + "  iP:" + paramOption.getIP(), paramOption.getPicType(), new List[] { localList });
      return;
    }
  }
  
  public void run()
  {
    if (this.mStatus == 4) {
      return;
    }
    long l = System.currentTimeMillis();
    RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + this.mOption.getSeq() + " cacheKey = " + this.mOption.getCacheKey() + " download start cost in queue: " + (l - this.mOption.mDownLoadStartTime.longValue()) + " ifFromPreload:" + this.mOption.isFromPreload());
    if (FileUtils.a(QCircleFeedPicLoader.g().getPicLocalPath(this.mOption)))
    {
      if (this.mOption.isPreDecode()) {
        QCircleFeedPicLoader.g().decodeFile(this.mOption, this.mListener);
      }
      RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + this.mOption.getSeq() + " cacheKey = " + this.mOption.getCacheKey() + " return in downLoad file exist " + (l - this.mOption.mDownLoadStartTime.longValue()) + " ifFromPreload:" + this.mOption.isFromPreload());
      return;
    }
    this.mStatus = 2;
    if (this.mListener != null) {
      this.mListener.onStateChang(this.mStatus, this.mOption);
    }
    doRealDownLoad(l);
  }
  
  public void setStatusListener(QCirclePicStateListener paramQCirclePicStateListener)
  {
    this.mListener = paramQCirclePicStateListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.picload.PicDownLoadTask
 * JD-Core Version:    0.7.0.1
 */