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
    QCirclePicDownLoader localQCirclePicDownLoader = QCirclePicDownLoader.g();
    Option localOption = this.mOption;
    localQCirclePicDownLoader.downLoad(localOption, new PicDownLoadTask.1(this, localOption, paramLong));
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
        if (FileUtils.fileExists(paramOption.getLocalPath()))
        {
          d1 = d2;
          if (paramOption.getPicType() != 3)
          {
            long l = FileUtils.getFileSizes(paramOption.getLocalPath()) / 1024L;
            d1 = l;
            Double.isNaN(d1);
            d1 = new BigDecimal(d1 / paramDouble).setScale(2, 4).doubleValue();
            paramInt = RFLog.USR;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("seq = ");
            localStringBuilder.append(paramOption.getSeq());
            localStringBuilder.append(" cacheKey = ");
            localStringBuilder.append(paramOption.getCacheKey());
            localStringBuilder.append(" timeCost:");
            localStringBuilder.append(paramDouble);
            localStringBuilder.append(" fileSize:");
            localStringBuilder.append(l);
            localStringBuilder.append(" qCirclePic download speed: ");
            localStringBuilder.append(d1);
            localStringBuilder.append("kb/s");
            RFLog.d("QCircleFeedPicLoader", paramInt, localStringBuilder.toString());
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
      QCirclePicStateListener localQCirclePicStateListener = this.mListener;
      if (localQCirclePicStateListener != null) {
        localQCirclePicStateListener.onStateChang(4, this.mOption);
      }
    }
  }
  
  public Option getOption()
  {
    return this.mOption;
  }
  
  protected void reportDownloadResult(Option paramOption, int paramInt)
  {
    if (paramOption != null)
    {
      double d = -1.0D;
      if (paramOption.mDownLoadStartTime != null) {
        d = (float)(System.currentTimeMillis() - paramOption.mDownLoadStartTime.longValue()) / 1000.0F;
      }
      List localList = getDownLoadSpeed(paramOption, d, paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramOption.getUrl());
      localStringBuilder.append("  iP:");
      localStringBuilder.append(paramOption.getIP());
      QCircleQualityReporter.reportImageQualityEvent("image_download_ret", String.valueOf(d), String.valueOf(paramInt), localStringBuilder.toString(), paramOption.getPicType(), new List[] { localList });
    }
  }
  
  public void run()
  {
    if (this.mStatus == 4) {
      return;
    }
    long l = System.currentTimeMillis();
    int i = RFLog.USR;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("seq = ");
    ((StringBuilder)localObject).append(this.mOption.getSeq());
    ((StringBuilder)localObject).append(" cacheKey = ");
    ((StringBuilder)localObject).append(this.mOption.getCacheKey());
    ((StringBuilder)localObject).append(" download start cost in queue: ");
    ((StringBuilder)localObject).append(l - this.mOption.mDownLoadStartTime.longValue());
    ((StringBuilder)localObject).append(" ifFromPreload:");
    ((StringBuilder)localObject).append(this.mOption.isFromPreload());
    RFLog.i("QCircleFeedPicLoader", i, ((StringBuilder)localObject).toString());
    if (FileUtils.fileExists(QCircleFeedPicLoader.g().getPicLocalPath(this.mOption)))
    {
      if (this.mOption.isPreDecode()) {
        QCircleFeedPicLoader.g().decodeFile(this.mOption, this.mListener);
      }
      i = RFLog.USR;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("seq = ");
      ((StringBuilder)localObject).append(this.mOption.getSeq());
      ((StringBuilder)localObject).append(" cacheKey = ");
      ((StringBuilder)localObject).append(this.mOption.getCacheKey());
      ((StringBuilder)localObject).append(" return in downLoad file exist ");
      ((StringBuilder)localObject).append(l - this.mOption.mDownLoadStartTime.longValue());
      ((StringBuilder)localObject).append(" ifFromPreload:");
      ((StringBuilder)localObject).append(this.mOption.isFromPreload());
      RFLog.i("QCircleFeedPicLoader", i, ((StringBuilder)localObject).toString());
      return;
    }
    this.mStatus = 2;
    localObject = this.mListener;
    if (localObject != null) {
      ((QCirclePicStateListener)localObject).onStateChang(this.mStatus, this.mOption);
    }
    doRealDownLoad(l);
  }
  
  public void setStatusListener(QCirclePicStateListener paramQCirclePicStateListener)
  {
    this.mListener = paramQCirclePicStateListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.picload.PicDownLoadTask
 * JD-Core Version:    0.7.0.1
 */