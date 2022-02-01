package cooperation.qzone.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IGifAntishakeApi.postProgressListener;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.pfc.opencv.QzoneVision;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GifAntishakeModule
{
  public static int ANTISHAKE_END_DOING_OR_FAILED = 2;
  public static int ANTISHAKE_END_NORMALLY = 1;
  public static String ANTISHAKE_STATUS = "GIFANTISHAKEMODULE_STATUS";
  private static final int HASH_SIZE = 8;
  private static int SIMILARITY_DHASH_ERROR_CODE = 16;
  private static final String TAG = "QzoneVision";
  private static int doneAntishakeFrameNum = 0;
  public static GifAntishakeModule mInstance;
  private static boolean mNativeLibLoaded = false;
  private static int pathCount;
  private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(DeviceInfoUtil.h(), DeviceInfoUtil.h() + 5, 200L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
  private String NO_MEDIA_FILE_NAME;
  private String SDCARD_ANTISHAKEGIF_SAVE;
  private long antishakeMaxFrameGapTime;
  private long antishakeMaxTotalGapTime;
  private boolean isFirstTimeEqualsTen;
  private boolean mHasDetectDir;
  private float mMinSimilarityForAntishake;
  private IGifAntishakeApi.postProgressListener mProgressListener = null;
  private boolean needToCheckShootTime;
  private boolean needToCheckSimilarity;
  private boolean useDHash;
  
  static
  {
    tryToLoadLibrary();
  }
  
  public GifAntishakeModule()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append("/tencent/Qzone/AntishakeGif/");
    this.SDCARD_ANTISHAKEGIF_SAVE = localStringBuilder.toString();
    this.NO_MEDIA_FILE_NAME = ".nomedia";
    boolean bool2 = false;
    this.mHasDetectDir = false;
    this.mMinSimilarityForAntishake = Float.parseFloat(QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeMinSimilarity", "0.6"));
    this.antishakeMaxTotalGapTime = Long.parseLong(QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeMaxGroupShootTime", "60000"));
    this.antishakeMaxFrameGapTime = Long.parseLong(QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeMaxFrameShootTime", "3000"));
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeNeedToCheckShootTime", 0) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.needToCheckShootTime = bool1;
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeNeedToCheckSimilarity", 1) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.needToCheckSimilarity = bool1;
    boolean bool1 = bool2;
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeUseDHash", 1) == 1) {
      bool1 = true;
    }
    this.useDHash = bool1;
    this.isFirstTimeEqualsTen = true;
  }
  
  private boolean checkDhashQualify(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 10) {
      return true;
    }
    if ((paramInt2 == 10) && (this.isFirstTimeEqualsTen) && (paramInt1 > 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVision", 2, "用掉了唯一一次10的机会");
      }
      this.isFirstTimeEqualsTen = false;
      return true;
    }
    return false;
  }
  
  private String getAntishakePath()
  {
    Object localObject;
    if (!this.mHasDetectDir)
    {
      this.mHasDetectDir = true;
      localObject = new File(VFSAssistantUtils.getSDKPrivatePath(this.SDCARD_ANTISHAKEGIF_SAVE));
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.SDCARD_ANTISHAKEGIF_SAVE);
      ((StringBuilder)localObject).append(this.NO_MEDIA_FILE_NAME);
      localObject = new File(VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject).toString()));
      if (((File)localObject).exists()) {}
    }
    try
    {
      ((File)localObject).createNewFile();
    }
    catch (IOException localIOException)
    {
      label95:
      break label95;
    }
    QLog.e("QzoneVision", 1, "getAntishakeGifFilePath: create .nomedia file fail");
    return this.SDCARD_ANTISHAKEGIF_SAVE;
  }
  
  public static String getDhash(Bitmap paramBitmap)
  {
    int i;
    int j;
    boolean bool;
    for (;;)
    {
      try
      {
        paramBitmap = toGrayscale(Bitmap.createScaledBitmap(paramBitmap, 9, 8, true));
        localArrayList = new ArrayList();
        i = 0;
      }
      catch (Throwable paramBitmap)
      {
        ArrayList localArrayList;
        int k;
        label60:
        QLog.e("QzoneVision", 1, "getDhash failed t:", paramBitmap);
        return "";
      }
      if (j >= 8) {
        break label226;
      }
      k = paramBitmap.getPixel(j, i);
      j += 1;
      if (k <= paramBitmap.getPixel(j, i)) {
        break label220;
      }
      bool = true;
      localArrayList.add(Boolean.valueOf(bool));
    }
    label220:
    label226:
    label231:
    for (;;)
    {
      System.gc();
      int m = localArrayList.size();
      paramBitmap = "";
      k = 0;
      i = 0;
      while (k < m)
      {
        j = i;
        if (((Boolean)localArrayList.get(k)).booleanValue()) {
          j = i + (k % 8 ^ 0x2);
        }
        Object localObject = paramBitmap;
        i = j;
        if (k % 8 == 7)
        {
          localObject = String.format("%s%s", new Object[] { paramBitmap, String.format("%02x", new Object[] { Integer.valueOf(j) }) });
          i = 0;
        }
        k += 1;
        paramBitmap = (Bitmap)localObject;
      }
      return paramBitmap;
      for (;;)
      {
        if (i >= 8) {
          break label231;
        }
        j = 0;
        break;
        bool = false;
        break label60;
        i += 1;
      }
    }
  }
  
  public static int getDistance(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString1.length() == paramString2.length()))
    {
      int i = 0;
      int k;
      for (int j = 0; i < paramString1.length(); j = k)
      {
        k = j;
        if (paramString1.charAt(i) != paramString2.charAt(i)) {
          k = j + 1;
        }
        i += 1;
      }
      return j;
    }
    return SIMILARITY_DHASH_ERROR_CODE;
  }
  
  public static long getExifShootTime(String paramString)
  {
    Object localObject = null;
    try
    {
      paramString = new ExifInterface(paramString);
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
    long l2 = 0L;
    long l1 = l2;
    if (paramString != null)
    {
      paramString.getAttribute("DateTime");
      paramString = paramString.getAttribute("DateTime");
      l1 = l2;
      if (paramString != null)
      {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        try
        {
          paramString = localSimpleDateFormat.parse(paramString);
        }
        catch (ParseException paramString)
        {
          paramString.printStackTrace();
          paramString = localObject;
        }
        l1 = l2;
        if (paramString != null) {
          l1 = paramString.getTime();
        }
      }
    }
    return l1;
  }
  
  public static GifAntishakeModule getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new GifAntishakeModule();
      }
      GifAntishakeModule localGifAntishakeModule = mInstance;
      return localGifAntishakeModule;
    }
    finally {}
  }
  
  private void postProgress(int paramInt)
  {
    IGifAntishakeApi.postProgressListener localpostProgressListener = this.mProgressListener;
    if (localpostProgressListener != null) {
      localpostProgressListener.postAntishakeProgress(paramInt);
    }
  }
  
  public static Bitmap toGrayscale(Bitmap paramBitmap)
  {
    paramBitmap.getHeight();
    paramBitmap.getWidth();
    Bitmap localBitmap = Bitmap.createBitmap(9, 8, Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.setSaturation(0.0F);
    localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    return localBitmap;
  }
  
  public static void tryToLoadLibrary()
  {
    if (!mNativeLibLoaded)
    {
      if ((QzoneVision.isLibDownloaded()) && (getInstance().getIsGifAntishakeOn()))
      {
        mNativeLibLoaded = QzoneVision.loadNativeLib();
        return;
      }
      mNativeLibLoaded = false;
    }
  }
  
  public boolean checkFolder(ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() <= 0) {
        return false;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(AppConstants.SDCARD_ROOT);
      ((StringBuilder)localObject).append("/tencent/Qzone/AlbumAutoVConvGif/");
      localObject = ((StringBuilder)localObject).toString();
      if (((String)paramArrayList.get(0)).startsWith((String)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QzoneVision", 2, "checkFolder false:来自视频转GIF文件夹");
        }
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVision", 2, "checkFolder true");
      }
      return true;
    }
    return false;
  }
  
  public Boolean checkImageSimlarityByBitmap(ArrayList<Bitmap> paramArrayList)
  {
    long l = System.currentTimeMillis();
    boolean bool = mNativeLibLoaded;
    Boolean localBoolean = Boolean.valueOf(false);
    if (!bool)
    {
      tryToLoadLibrary();
      if (!mNativeLibLoaded) {
        return localBoolean;
      }
    }
    if ((paramArrayList != null) && (paramArrayList.size() >= 2))
    {
      if (paramArrayList.get(0) == null) {
        return localBoolean;
      }
      int j = paramArrayList.size() - 1;
      CountDownLatch localCountDownLatch = new CountDownLatch(j);
      boolean[] arrayOfBoolean = new boolean[paramArrayList.size()];
      arrayOfBoolean[0] = true;
      Bitmap localBitmap = (Bitmap)paramArrayList.get(0);
      this.isFirstTimeEqualsTen = true;
      int i = 1;
      while (i < paramArrayList.size())
      {
        threadPoolExecutor.execute(new GifAntishakeModule.2(this, paramArrayList, i, localCountDownLatch, localBitmap, j + 1, arrayOfBoolean));
        i += 1;
      }
      try
      {
        localCountDownLatch.await();
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      i = 0;
      while (i < paramArrayList.size())
      {
        if (arrayOfBoolean[i] == 0)
        {
          if (QLog.isColorLevel())
          {
            paramArrayList = new StringBuilder();
            paramArrayList.append("总共用时:");
            paramArrayList.append(System.currentTimeMillis() - l);
            QLog.d("QzoneVision", 2, paramArrayList.toString());
          }
          return localBoolean;
        }
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("总共用时:");
        paramArrayList.append(System.currentTimeMillis() - l);
        QLog.d("QzoneVision", 2, paramArrayList.toString());
      }
      return Boolean.valueOf(true);
    }
    return localBoolean;
  }
  
  public boolean checkShootTimeForAntishake(ArrayList<String> paramArrayList)
  {
    if (!mNativeLibLoaded)
    {
      tryToLoadLibrary();
      if (!mNativeLibLoaded) {
        return false;
      }
    }
    if ((paramArrayList != null) && (paramArrayList.size() >= 2))
    {
      int j = paramArrayList.size();
      long l = getExifShootTime((String)paramArrayList.get(0));
      if (l == 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QzoneVision", 2, "checkShootTimeForAntishake false:firstFrameTime == 0");
        }
        return false;
      }
      int i = j - 1;
      if (getExifShootTime((String)paramArrayList.get(i)) - l <= this.antishakeMaxTotalGapTime)
      {
        if (getExifShootTime((String)paramArrayList.get(i)) - getExifShootTime((String)paramArrayList.get(0)) < 0L) {
          return false;
        }
        i = 1;
        while (i < j) {
          if (getExifShootTime((String)paramArrayList.get(i)) - l < this.antishakeMaxFrameGapTime)
          {
            l = getExifShootTime((String)paramArrayList.get(i));
            i += 1;
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("QzoneVision", 2, "checkShootTimeForAntishake false:getExifShootTime(filePath.get(i)) - last >= antishakeMaxFrameGapTime");
            }
            return false;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("QzoneVision", 2, "checkShootTimeForAntishake true");
        }
        return true;
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVision", 2, "checkShootTimeForAntishake false:filePath == null || filePath.size() < 2 || !mNativeLibLoaded");
    }
    return false;
  }
  
  public ArrayList<String> getAntiShakeBitmapList(ArrayList<Bitmap> paramArrayList)
  {
    if (!mNativeLibLoaded)
    {
      tryToLoadLibrary();
      if (!mNativeLibLoaded) {
        return null;
      }
    }
    if ((paramArrayList != null) && ((paramArrayList == null) || (paramArrayList.size() >= 2)))
    {
      LocalMultiProcConfig.putInt(ANTISHAKE_STATUS, ANTISHAKE_END_DOING_OR_FAILED);
      long l1 = System.currentTimeMillis();
      boolean bool = QLog.isColorLevel();
      String str = "QzoneVision";
      if (bool)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("startantishake at ");
        ((StringBuilder)localObject1).append(l1);
        QLog.d("QzoneVision", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = new ArrayList();
      int i = paramArrayList.size();
      if (i < 2) {
        return null;
      }
      Bitmap localBitmap1 = (Bitmap)paramArrayList.get(0);
      int n = localBitmap1.getWidth();
      int i1 = localBitmap1.getHeight();
      String[] arrayOfString = new String[i];
      int j = n / 10;
      int k = i1 / 10;
      Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1, j, k, localBitmap1.getWidth() - j * 2, localBitmap1.getHeight() - k * 2);
      Object localObject2 = PhotoUtils.getCameraPath(getAntishakePath(), ".IMG0", ".jpg");
      File localFile = new File((String)localObject2);
      try
      {
        ImageUtil.a(localBitmap2, localFile);
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
      arrayOfString[0] = localObject2;
      int m = 1;
      doneAntishakeFrameNum = 1;
      postProgress(doneAntishakeFrameNum);
      localObject2 = new CountDownLatch(i - 1);
      while (m < i)
      {
        threadPoolExecutor.execute(new GifAntishakeModule.1(this, m, n, i1, paramArrayList, localBitmap1, j, k, arrayOfString, (CountDownLatch)localObject2));
        m += 1;
      }
      try
      {
        ((CountDownLatch)localObject2).await();
      }
      catch (InterruptedException paramArrayList)
      {
        paramArrayList.printStackTrace();
      }
      j = 0;
      while (j < i)
      {
        if (arrayOfString[j] != null) {
          ((ArrayList)localObject1).add(arrayOfString[j]);
        }
        j += 1;
      }
      doneAntishakeFrameNum = 0;
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("endantishake at ");
        paramArrayList.append(l2);
        paramArrayList.append(", cost ");
        paramArrayList.append((l2 - l1) / 1000L);
        paramArrayList.append("s");
        QLog.d(str, 2, paramArrayList.toString());
      }
      System.gc();
      this.mProgressListener = null;
      LocalMultiProcConfig.putInt(ANTISHAKE_STATUS, ANTISHAKE_END_NORMALLY);
      return localObject1;
    }
    return null;
  }
  
  public boolean getIsGifAntishakeOn()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeSwitch", 1) == 1;
  }
  
  public int getMaxGifAntishakeFrameNum()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeMaxFrameNum", 5);
  }
  
  public void setAntishakeProgressListener(IGifAntishakeApi.postProgressListener parampostProgressListener)
  {
    this.mProgressListener = parampostProgressListener;
  }
  
  public boolean suitableForAntishake(ArrayList<String> paramArrayList, LruCache<Integer, BitmapDrawable> paramLruCache)
  {
    boolean bool2 = mNativeLibLoaded;
    boolean bool1 = false;
    boolean bool3 = false;
    if (!bool2)
    {
      tryToLoadLibrary();
      if (!mNativeLibLoaded) {
        return false;
      }
    }
    if (LocalMultiProcConfig.getInt(ANTISHAKE_STATUS, ANTISHAKE_END_NORMALLY) == ANTISHAKE_END_DOING_OR_FAILED)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVision", 2, "本地记录防抖正在进行或者没有正常结束 以后就不防抖了");
      }
      return false;
    }
    bool2 = bool1;
    if (paramArrayList != null)
    {
      bool2 = bool1;
      if (paramArrayList.size() >= 2)
      {
        bool2 = bool1;
        if (paramLruCache != null)
        {
          bool2 = bool1;
          if (paramLruCache.size() >= 2)
          {
            bool2 = bool1;
            if (getIsGifAntishakeOn())
            {
              bool2 = bool1;
              if (paramArrayList.size() <= getMaxGifAntishakeFrameNum())
              {
                bool2 = bool1;
                if (QZoneHelper.isBestPerformanceDevice())
                {
                  if (!checkFolder(paramArrayList)) {
                    return false;
                  }
                  Object localObject;
                  if (QLog.isColorLevel())
                  {
                    localObject = new StringBuilder();
                    ((StringBuilder)localObject).append("DeviceInfoUtil.getMemoryClass() = ");
                    ((StringBuilder)localObject).append(DeviceInfoUtil.s() / 1048576L);
                    ((StringBuilder)localObject).append("M, DeviceInfoUtil.getSystemAvaialbeMemory() = ");
                    ((StringBuilder)localObject).append(DeviceInfoUtil.r() / 1048576L);
                    ((StringBuilder)localObject).append("M");
                    QLog.d("QzoneVision", 2, ((StringBuilder)localObject).toString());
                  }
                  int i;
                  int j;
                  if ((this.needToCheckShootTime) && (this.needToCheckSimilarity))
                  {
                    bool1 = bool3;
                    if (checkShootTimeForAntishake(paramArrayList))
                    {
                      paramArrayList = new ArrayList();
                      if (paramLruCache != null) {
                        i = paramLruCache.size();
                      } else {
                        i = 0;
                      }
                      j = 0;
                      while (j < i) {
                        if ((paramLruCache != null) && (paramLruCache.get(Integer.valueOf(j)) != null))
                        {
                          paramArrayList.add(((BitmapDrawable)paramLruCache.get(Integer.valueOf(j))).getBitmap());
                          j += 1;
                        }
                        else
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d("QzoneVision", 2, "suitableForAntishake false:mMemoryCache == null || mMemoryCache.get(i) == null");
                          }
                          return false;
                        }
                      }
                      bool1 = checkImageSimlarityByBitmap(paramArrayList).booleanValue();
                    }
                  }
                  else if ((this.needToCheckShootTime) && (!this.needToCheckSimilarity))
                  {
                    bool1 = bool3;
                    if (!checkShootTimeForAntishake(paramArrayList)) {}
                  }
                  else
                  {
                    do
                    {
                      bool1 = true;
                      break;
                      if ((!this.needToCheckShootTime) && (this.needToCheckSimilarity))
                      {
                        paramArrayList = new ArrayList();
                        if (paramLruCache != null) {
                          i = paramLruCache.size();
                        } else {
                          i = 0;
                        }
                        j = 0;
                        while (j < i)
                        {
                          localObject = (BitmapDrawable)paramLruCache.get(Integer.valueOf(j));
                          if (localObject != null)
                          {
                            paramArrayList.add(((BitmapDrawable)localObject).getBitmap());
                            j += 1;
                          }
                          else
                          {
                            if (QLog.isColorLevel()) {
                              QLog.d("QzoneVision", 2, "suitableForAntishake false:mMemoryCache == null || mMemoryCache.get(i) == null");
                            }
                            return false;
                          }
                        }
                        bool1 = checkImageSimlarityByBitmap(paramArrayList).booleanValue();
                        break;
                      }
                      bool1 = bool3;
                      if (this.needToCheckShootTime) {
                        break;
                      }
                      bool1 = bool3;
                    } while (!this.needToCheckSimilarity);
                  }
                  bool2 = bool1;
                  if (QLog.isColorLevel())
                  {
                    paramArrayList = new StringBuilder();
                    paramArrayList.append("suitableForAntishake ");
                    paramArrayList.append(bool1);
                    QLog.d("QzoneVision", 2, paramArrayList.toString());
                    bool2 = bool1;
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.util.GifAntishakeModule
 * JD-Core Version:    0.7.0.1
 */