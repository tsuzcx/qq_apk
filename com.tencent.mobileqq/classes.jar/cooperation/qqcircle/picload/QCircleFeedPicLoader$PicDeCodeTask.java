package cooperation.qqcircle.picload;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import bjkq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtil;
import java.io.File;

public class QCircleFeedPicLoader$PicDeCodeTask
  extends QCircleFeedPicLoader.PicDownLoadTask
{
  public QCircleFeedPicLoader$PicDeCodeTask(QCircleFeedPicLoader paramQCircleFeedPicLoader, Option paramOption)
  {
    super(paramQCircleFeedPicLoader, paramOption);
    this.mStatus = QCircleFeedPicLoader.STATE_DECODE;
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
    Bitmap localBitmap = null;
    if (SharpPUtil.isSharpPFile(new File(paramString))) {
      if ((bjkq.a(BaseApplicationImpl.getContext())) && (bjkq.b()))
      {
        paramOptions = SharpPUtil.decodeSharpPByFilePath(paramString);
        if (paramOptions != null) {
          QLog.i(QCircleFeedPicLoader.TAG, 1, "seq = " + this.mOption.getSeq() + " cacheKey = " + this.mOption.getCacheKey() + " decode sharp success  ifFromPreload:" + this.mOption.isFromPreload());
        }
      }
    }
    for (paramOption.mPicType = 1;; paramOption.mPicType = 0)
    {
      if ((paramOptions == null) && (paramString.contains(QCircleFeedPicLoader.access$000())))
      {
        FileUtil.deleteFile(paramString);
        QLog.i(QCircleFeedPicLoader.TAG, 1, "seq = " + this.mOption.getSeq() + " cacheKey = " + this.mOption.getCacheKey() + " decode bitmap failed delete ifFromPreload:" + this.mOption.isFromPreload());
      }
      return paramOptions;
      QLog.i(QCircleFeedPicLoader.TAG, 1, "seq = " + this.mOption.getSeq() + " cacheKey = " + this.mOption.getCacheKey() + " decode sharp failed  ifFromPreload:" + this.mOption.isFromPreload());
      break;
      QLog.i(QCircleFeedPicLoader.TAG, 1, "seq = " + this.mOption.getSeq() + " cacheKey = " + this.mOption.getCacheKey() + " decode sharp not support  ifFromPreload:" + this.mOption.isFromPreload());
      paramOptions = localBitmap;
      break;
      try
      {
        localBitmap = SafeBitmapFactory.decodeFile(paramString, paramOptions);
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
            localOutOfMemoryError.printStackTrace();
            paramOptions = localObject;
          }
        }
      }
    }
  }
  
  public void cancel()
  {
    super.cancel();
  }
  
  public void run()
  {
    if (this.mStatus == QCircleFeedPicLoader.STATE_CANCEL) {}
    Object localObject;
    for (;;)
    {
      return;
      long l = System.currentTimeMillis();
      QLog.i(QCircleFeedPicLoader.TAG, 4, "seq = " + this.mOption.getSeq() + " cacheKey = " + this.mOption.getCacheKey() + " , decode start cost in queue: " + (l - this.mOption.mDecodeStartTime.longValue()) + " ifFromPreload:" + this.mOption.isFromPreload());
      if (this.mListener != null) {
        this.mListener.onStateChang(QCircleFeedPicLoader.STATE_DECODE, this.mOption);
      }
      localObject = this.mOption.getLocalPath();
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
          QLog.i(QCircleFeedPicLoader.TAG, 1, "seq = " + this.mOption.getSeq() + " cacheKey = " + this.mOption.getCacheKey() + " , decode cost : " + (System.currentTimeMillis() - l) + " ,sampleSize:" + localOptions.inSampleSize + " origin:" + i + " " + j + "  request:" + this.mOption.getRequestWidth() + "  " + this.mOption.getRequestHeight() + " result:" + localBitmap.getWidth() + "  " + localBitmap.getHeight() + " ifFromPreload:" + this.mOption.isFromPreload());
          localObject = localBitmap;
        }
      }
      while (this.mStatus != QCircleFeedPicLoader.STATE_CANCEL)
      {
        QCircleFeedPicLoader.access$1100(this.this$0, this.mOption.getCacheKey(), (Bitmap)localObject);
        if (localObject != null) {
          break label615;
        }
        if (this.mListener != null) {
          this.mListener.onStateChang(QCircleFeedPicLoader.STATE_DECODE_FAILED, this.mOption);
        }
        QCircleFeedPicLoader.access$1200(this.this$0, this.mOption, 1);
        QCircleFeedPicLoader.access$600(this.this$0, this.mOption, 1);
        QCircleFeedPicLoader.access$100(this.this$0, this.mOption, this.mOption.getFailDrawable());
        return;
        localOptions.inSampleSize = 1;
        localOptions.inJustDecodeBounds = false;
        localBitmap = decodeBitMap((String)localObject, localOptions, this.mOption);
        localObject = localBitmap;
        if (localBitmap != null)
        {
          QLog.i(QCircleFeedPicLoader.TAG, 1, "seq = " + this.mOption.getSeq() + " cacheKey = " + this.mOption.getCacheKey() + " ,decode origin cost: " + (System.currentTimeMillis() - l) + " ifFromPreload:" + this.mOption.isFromPreload());
          localObject = localBitmap;
        }
      }
    }
    label615:
    if (this.mListener != null)
    {
      this.mOption.setResultBitMap((Bitmap)localObject);
      this.mListener.onStateChang(QCircleFeedPicLoader.STATE_SUCCESS, this.mOption);
    }
    QCircleFeedPicLoader.access$1300(this.this$0, this.mOption, (Bitmap)localObject);
    QCircleFeedPicLoader.access$1200(this.this$0, this.mOption, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleFeedPicLoader.PicDeCodeTask
 * JD-Core Version:    0.7.0.1
 */