package cooperation.qqcircle.picload;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqsharpP.QQSharpPUtil;
import com.tencent.sharpP.SharpPUtil;
import cooperation.qqcircle.report.QCircleQualityReporter;
import java.io.File;
import java.util.List;

public class PicDecodeTask
  extends PicDownLoadTask
{
  public PicDecodeTask(Option paramOption)
  {
    super(paramOption);
    this.mStatus = 5;
  }
  
  private void afterDecode(Bitmap paramBitmap)
  {
    QCircleFeedPicLoader.g().addToCache(this.mOption.getCacheKey(), paramBitmap);
    if (paramBitmap == null)
    {
      if (this.mListener != null) {
        this.mListener.onStateChang(8, this.mOption);
      }
      reportDecodeResult(this.mOption, 1);
      QCircleFeedPicLoader.g().reportLoadResult(this.mOption, 1);
      QCircleFeedPicLoader.g().showDrawable(this.mOption, this.mOption.getFailDrawable());
      return;
    }
    if (this.mListener != null)
    {
      this.mOption.setResultBitMap(paramBitmap);
      this.mListener.onStateChang(6, this.mOption);
    }
    QCircleFeedPicLoader.g().showPic(this.mOption, paramBitmap);
    reportDecodeResult(this.mOption, 0);
  }
  
  private int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = 1;
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        return 1;
      }
      int k = paramOptions.outHeight;
      int m = paramOptions.outWidth;
      if ((k > paramInt2) || (m > paramInt1))
      {
        k = (int)(k / 1.4F);
        m = (int)(m / 1.4F);
      }
      for (;;)
      {
        if (k / i <= paramInt2)
        {
          j = i;
          if (m / i <= paramInt1) {
            return j;
          }
        }
        i *= 2;
      }
    }
    return 1;
  }
  
  private Bitmap decodeBitMap(String paramString, BitmapFactory.Options paramOptions, Option paramOption)
  {
    if (SharpPUtil.isSharpPFile(new File(paramString)))
    {
      paramOptions = decodeShareP(paramString, paramOption);
    }
    else
    {
      try
      {
        Bitmap localBitmap = SafeBitmapFactory.decodeFile(paramString, paramOptions);
        paramOptions = localBitmap;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        System.gc();
        localOutOfMemoryError.printStackTrace();
        try
        {
          paramOptions.inSampleSize *= 2;
          paramOptions = SafeBitmapFactory.decodeFile(paramString, paramOptions);
        }
        catch (OutOfMemoryError paramOptions)
        {
          System.gc();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("decode out of memory:");
          localStringBuilder.append(paramOptions);
          QLog.d("QCircleFeedPicLoader", 1, localStringBuilder.toString());
          paramOptions = null;
        }
      }
      paramOption.setPicType(0);
    }
    if ((paramOptions == null) && (paramString.contains(QCircleFeedPicLoader.DOWNLOAD_ROOT_PATH)))
    {
      FileUtils.deleteFile(paramString);
      int i = RFLog.USR;
      paramString = new StringBuilder();
      paramString.append("seq = ");
      paramString.append(this.mOption.getSeq());
      paramString.append(" cacheKey = ");
      paramString.append(this.mOption.getCacheKey());
      paramString.append(" decode bitmap failed delete ifFromPreload:");
      paramString.append(this.mOption.isFromPreload());
      RFLog.i("QCircleFeedPicLoader", i, paramString.toString());
    }
    return paramOptions;
  }
  
  private Bitmap decodeShareP(String paramString, Option paramOption)
  {
    int i;
    if ((QQSharpPUtil.a(RFApplication.getApplication())) && (QQSharpPUtil.b()))
    {
      paramString = SharpPUtil.decodeSharpPByFilePath(paramString);
      StringBuilder localStringBuilder;
      if (paramString != null)
      {
        i = RFLog.USR;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("seq = ");
        localStringBuilder.append(this.mOption.getSeq());
        localStringBuilder.append(" cacheKey = ");
        localStringBuilder.append(this.mOption.getCacheKey());
        localStringBuilder.append(" decode sharp success  ifFromPreload:");
        localStringBuilder.append(this.mOption.isFromPreload());
        RFLog.i("QCircleFeedPicLoader", i, localStringBuilder.toString());
      }
      else
      {
        i = RFLog.USR;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("seq = ");
        localStringBuilder.append(this.mOption.getSeq());
        localStringBuilder.append(" cacheKey = ");
        localStringBuilder.append(this.mOption.getCacheKey());
        localStringBuilder.append(" decode sharp failed  ifFromPreload:");
        localStringBuilder.append(this.mOption.isFromPreload());
        RFLog.i("QCircleFeedPicLoader", i, localStringBuilder.toString());
      }
    }
    else
    {
      i = RFLog.USR;
      paramString = new StringBuilder();
      paramString.append("seq = ");
      paramString.append(this.mOption.getSeq());
      paramString.append(" cacheKey = ");
      paramString.append(this.mOption.getCacheKey());
      paramString.append(" decode sharp not support  ifFromPreload:");
      paramString.append(this.mOption.isFromPreload());
      RFLog.i("QCircleFeedPicLoader", i, paramString.toString());
      paramString = null;
    }
    paramOption.setPicType(1);
    return paramString;
  }
  
  public void cancel()
  {
    super.cancel();
  }
  
  protected void reportDecodeResult(Option paramOption, int paramInt)
  {
    if (paramOption != null)
    {
      double d = -1.0D;
      if (paramOption.mDecodeStartTime != null) {
        d = (float)(System.currentTimeMillis() - paramOption.mDecodeStartTime.longValue()) / 1000.0F;
      }
      QCircleQualityReporter.reportImageQualityEvent("image_decode_ret", String.valueOf(d), String.valueOf(paramInt), paramOption.getUrl(), paramOption.getPicType(), new List[0]);
    }
  }
  
  public void run()
  {
    if (this.mStatus == 4) {
      return;
    }
    long l = System.currentTimeMillis();
    int i = RFLog.DEV;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("seq = ");
    ((StringBuilder)localObject).append(this.mOption.getSeq());
    ((StringBuilder)localObject).append(" cacheKey = ");
    ((StringBuilder)localObject).append(this.mOption.getCacheKey());
    ((StringBuilder)localObject).append(" , decode start cost in queue: ");
    ((StringBuilder)localObject).append(l - this.mOption.mDecodeStartTime.longValue());
    ((StringBuilder)localObject).append(" ifFromPreload:");
    ((StringBuilder)localObject).append(this.mOption.isFromPreload());
    RFLog.i("QCircleFeedPicLoader", i, ((StringBuilder)localObject).toString());
    if (this.mListener != null) {
      this.mListener.onStateChang(5, this.mOption);
    }
    localObject = this.mOption.getLocalPath();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    Bitmap localBitmap;
    if ((this.mOption.getRequestWidth() > 0) && (this.mOption.getRequestHeight() > 0))
    {
      localOptions.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile((String)localObject, localOptions);
      localOptions.inSampleSize = calculateInSampleSize(localOptions, this.mOption.getRequestWidth(), this.mOption.getRequestHeight());
      i = localOptions.outWidth;
      int j = localOptions.outHeight;
      localOptions.inJustDecodeBounds = false;
      localBitmap = decodeBitMap((String)localObject, localOptions, this.mOption);
      localObject = localBitmap;
      if (localBitmap != null)
      {
        int k = RFLog.USR;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("seq = ");
        ((StringBuilder)localObject).append(this.mOption.getSeq());
        ((StringBuilder)localObject).append(" cacheKey = ");
        ((StringBuilder)localObject).append(this.mOption.getCacheKey());
        ((StringBuilder)localObject).append(" decode cost : ");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
        ((StringBuilder)localObject).append(" sampleSize:");
        ((StringBuilder)localObject).append(localOptions.inSampleSize);
        ((StringBuilder)localObject).append(" origin:");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" request:");
        ((StringBuilder)localObject).append(this.mOption.getRequestWidth());
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.mOption.getRequestHeight());
        ((StringBuilder)localObject).append(" result:");
        ((StringBuilder)localObject).append(localBitmap.getWidth());
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(localBitmap.getHeight());
        ((StringBuilder)localObject).append(" ifFromPreload:");
        ((StringBuilder)localObject).append(this.mOption.isFromPreload());
        RFLog.i("QCircleFeedPicLoader", k, ((StringBuilder)localObject).toString());
        localObject = localBitmap;
      }
    }
    else
    {
      localOptions.inSampleSize = 1;
      localOptions.inJustDecodeBounds = false;
      localBitmap = decodeBitMap((String)localObject, localOptions, this.mOption);
      localObject = localBitmap;
      if (localBitmap != null)
      {
        i = RFLog.USR;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("seq = ");
        ((StringBuilder)localObject).append(this.mOption.getSeq());
        ((StringBuilder)localObject).append(" cacheKey = ");
        ((StringBuilder)localObject).append(this.mOption.getCacheKey());
        ((StringBuilder)localObject).append(" ,decode origin cost: ");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
        ((StringBuilder)localObject).append(" ifFromPreload:");
        ((StringBuilder)localObject).append(this.mOption.isFromPreload());
        RFLog.i("QCircleFeedPicLoader", i, ((StringBuilder)localObject).toString());
        localObject = localBitmap;
      }
    }
    if (this.mStatus == 4) {
      return;
    }
    afterDecode((Bitmap)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.picload.PicDecodeTask
 * JD-Core Version:    0.7.0.1
 */