package cooperation.qqcircle.picload;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtil;
import cooperation.qqcircle.report.QCircleQualityReporter;
import java.io.File;
import java.util.List;
import mqq.app.MobileQQ;

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
    int i = 1;
    int k = 1;
    int j = k;
    if (paramInt1 > 0)
    {
      if (paramInt2 > 0) {
        break label25;
      }
      j = k;
    }
    label25:
    int n;
    do
    {
      return j;
      n = paramOptions.outHeight;
      m = paramOptions.outWidth;
      if (n > paramInt2) {
        break;
      }
      j = k;
    } while (m <= paramInt1);
    k = (int)(n / 1.4F);
    int m = (int)(m / 1.4F);
    for (;;)
    {
      if (k / i <= paramInt2)
      {
        j = i;
        if (m / i <= paramInt1) {
          break;
        }
      }
      i *= 2;
    }
  }
  
  private Bitmap decodeBitMap(String paramString, BitmapFactory.Options paramOptions, Option paramOption)
  {
    localObject = null;
    if (SharpPUtil.isSharpPFile(new File(paramString))) {
      paramOptions = decodeShareP(paramString, paramOption);
    }
    for (;;)
    {
      if ((paramOptions == null) && (paramString.contains(QCircleFeedPicLoader.DOWNLOAD_ROOT_PATH)))
      {
        FileUtils.e(paramString);
        RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + this.mOption.getSeq() + " cacheKey = " + this.mOption.getCacheKey() + " decode bitmap failed delete ifFromPreload:" + this.mOption.isFromPreload());
      }
      return paramOptions;
      try
      {
        Bitmap localBitmap = SafeBitmapFactory.decodeFile(paramString, paramOptions);
        paramOptions = localBitmap;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
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
            QLog.d("QCircleFeedPicLoader", 1, "decode out of memory:" + paramOptions);
            paramOptions = localObject;
          }
        }
      }
      paramOption.setPicType(0);
    }
  }
  
  private Bitmap decodeShareP(String paramString, Option paramOption)
  {
    Object localObject = null;
    if ((QCircleServiceImpl.getQQService().isFunctionAvaliable(MobileQQ.sMobileQQ.getApplicationContext())) && (QCircleServiceImpl.getQQService().isDeviceSupport()))
    {
      paramString = SharpPUtil.decodeSharpPByFilePath(paramString);
      if (paramString != null) {
        RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + this.mOption.getSeq() + " cacheKey = " + this.mOption.getCacheKey() + " decode sharp success  ifFromPreload:" + this.mOption.isFromPreload());
      }
    }
    for (;;)
    {
      paramOption.setPicType(1);
      return paramString;
      RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + this.mOption.getSeq() + " cacheKey = " + this.mOption.getCacheKey() + " decode sharp failed  ifFromPreload:" + this.mOption.isFromPreload());
      continue;
      RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + this.mOption.getSeq() + " cacheKey = " + this.mOption.getCacheKey() + " decode sharp not support  ifFromPreload:" + this.mOption.isFromPreload());
      paramString = localObject;
    }
  }
  
  public void cancel()
  {
    super.cancel();
  }
  
  protected void reportDecodeResult(Option paramOption, int paramInt)
  {
    if (paramOption != null) {
      if (paramOption.mDecodeStartTime == null) {
        break label54;
      }
    }
    label54:
    for (double d = (float)(System.currentTimeMillis() - paramOption.mDecodeStartTime.longValue()) / 1000.0F;; d = -1.0D)
    {
      QCircleQualityReporter.reportImageQualityEvent("image_decode_ret", String.valueOf(d), String.valueOf(paramInt), paramOption.getUrl(), paramOption.getPicType(), new List[0]);
      return;
    }
  }
  
  public void run()
  {
    if (this.mStatus == 4) {}
    for (;;)
    {
      return;
      long l = System.currentTimeMillis();
      RFLog.i("QCircleFeedPicLoader", RFLog.DEV, "seq = " + this.mOption.getSeq() + " cacheKey = " + this.mOption.getCacheKey() + " , decode start cost in queue: " + (l - this.mOption.mDecodeStartTime.longValue()) + " ifFromPreload:" + this.mOption.isFromPreload());
      if (this.mListener != null) {
        this.mListener.onStateChang(5, this.mOption);
      }
      Object localObject = this.mOption.getLocalPath();
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      Bitmap localBitmap;
      if ((this.mOption.getRequestWidth() > 0) && (this.mOption.getRequestHeight() > 0))
      {
        localOptions.inJustDecodeBounds = true;
        SafeBitmapFactory.decodeFile((String)localObject, localOptions);
        localOptions.inSampleSize = calculateInSampleSize(localOptions, this.mOption.getRequestWidth(), this.mOption.getRequestHeight());
        int i = localOptions.outWidth;
        int j = localOptions.outHeight;
        localOptions.inJustDecodeBounds = false;
        localBitmap = decodeBitMap((String)localObject, localOptions, this.mOption);
        localObject = localBitmap;
        if (localBitmap != null)
        {
          RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + this.mOption.getSeq() + " cacheKey = " + this.mOption.getCacheKey() + " decode cost : " + (System.currentTimeMillis() - l) + " sampleSize:" + localOptions.inSampleSize + " origin:" + i + " " + j + " request:" + this.mOption.getRequestWidth() + " " + this.mOption.getRequestHeight() + " result:" + localBitmap.getWidth() + " " + localBitmap.getHeight() + " ifFromPreload:" + this.mOption.isFromPreload());
          localObject = localBitmap;
        }
      }
      while (this.mStatus != 4)
      {
        afterDecode((Bitmap)localObject);
        return;
        localOptions.inSampleSize = 1;
        localOptions.inJustDecodeBounds = false;
        localBitmap = decodeBitMap((String)localObject, localOptions, this.mOption);
        localObject = localBitmap;
        if (localBitmap != null)
        {
          RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + this.mOption.getSeq() + " cacheKey = " + this.mOption.getCacheKey() + " ,decode origin cost: " + (System.currentTimeMillis() - l) + " ifFromPreload:" + this.mOption.isFromPreload());
          localObject = localBitmap;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.picload.PicDecodeTask
 * JD-Core Version:    0.7.0.1
 */