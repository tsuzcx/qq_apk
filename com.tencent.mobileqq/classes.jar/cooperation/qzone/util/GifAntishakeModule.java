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
import bheg;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
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
  public static int ANTISHAKE_END_DOING_OR_FAILED = 0;
  public static int ANTISHAKE_END_NORMALLY = 0;
  public static String ANTISHAKE_STATUS;
  private static final int HASH_SIZE = 8;
  private static int SIMILARITY_DHASH_ERROR_CODE = 16;
  private static final String TAG = "QzoneVision";
  private static int doneAntishakeFrameNum;
  public static GifAntishakeModule mInstance;
  private static boolean mNativeLibLoaded;
  private static int pathCount;
  private static ThreadPoolExecutor threadPoolExecutor;
  private String NO_MEDIA_FILE_NAME = ".nomedia";
  private String SDCARD_ANTISHAKEGIF_SAVE = AppConstants.SDCARD_ROOT + "/tencent/Qzone/AntishakeGif/";
  private long antishakeMaxFrameGapTime = Long.parseLong(QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeMaxFrameShootTime", "3000"));
  private long antishakeMaxTotalGapTime = Long.parseLong(QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeMaxGroupShootTime", "60000"));
  private boolean isFirstTimeEqualsTen;
  private boolean mHasDetectDir;
  private float mMinSimilarityForAntishake = Float.parseFloat(QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeMinSimilarity", "0.6"));
  private GifAntishakeModule.postProgressListener mProgressListener;
  private boolean needToCheckShootTime;
  private boolean needToCheckSimilarity;
  private boolean useDHash;
  
  static
  {
    ANTISHAKE_STATUS = "GIFANTISHAKEMODULE_STATUS";
    ANTISHAKE_END_NORMALLY = 1;
    ANTISHAKE_END_DOING_OR_FAILED = 2;
    threadPoolExecutor = new ThreadPoolExecutor(DeviceInfoUtil.getCpuNumber(), DeviceInfoUtil.getCpuNumber() + 5, 200L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    tryToLoadLibrary();
  }
  
  public GifAntishakeModule()
  {
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeNeedToCheckShootTime", 0) == 1)
    {
      bool1 = true;
      this.needToCheckShootTime = bool1;
      if (QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeNeedToCheckSimilarity", 1) != 1) {
        break label173;
      }
    }
    label173:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.needToCheckSimilarity = bool1;
      bool1 = bool2;
      if (QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeUseDHash", 1) == 1) {
        bool1 = true;
      }
      this.useDHash = bool1;
      this.isFirstTimeEqualsTen = true;
      return;
      bool1 = false;
      break;
    }
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
    File localFile;
    if (!this.mHasDetectDir)
    {
      this.mHasDetectDir = true;
      localFile = new File(VFSAssistantUtils.getSDKPrivatePath(this.SDCARD_ANTISHAKEGIF_SAVE));
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localFile = new File(VFSAssistantUtils.getSDKPrivatePath(this.SDCARD_ANTISHAKEGIF_SAVE + this.NO_MEDIA_FILE_NAME));
      if (localFile.exists()) {}
    }
    try
    {
      localFile.createNewFile();
      return this.SDCARD_ANTISHAKEGIF_SAVE;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QLog.e("QzoneVision", 1, "getAntishakeGifFilePath: create .nomedia file fail");
      }
    }
  }
  
  public static String getDhash(Bitmap paramBitmap)
  {
    Object localObject = "";
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
        label57:
        localObject = "";
        QLog.e("QzoneVision", 1, "getDhash failed t:", paramBitmap);
      }
      if (j >= 8) {
        break label233;
      }
      if (paramBitmap.getPixel(j, i) <= paramBitmap.getPixel(j + 1, i)) {
        break label227;
      }
      bool = true;
      localArrayList.add(Boolean.valueOf(bool));
      j += 1;
    }
    label211:
    label227:
    label233:
    label238:
    for (;;)
    {
      System.gc();
      int m = localArrayList.size();
      int k = 0;
      i = 0;
      paramBitmap = (Bitmap)localObject;
      localObject = paramBitmap;
      if (k < m) {
        if (!((Boolean)localArrayList.get(k)).booleanValue()) {
          break label211;
        }
      }
      for (j = (k % 8 ^ 0x2) + i;; j = i)
      {
        i = j;
        localObject = paramBitmap;
        if (k % 8 == 7)
        {
          localObject = String.format("%s%s", new Object[] { paramBitmap, String.format("%02x", new Object[] { Integer.valueOf(j) }) });
          i = 0;
        }
        k += 1;
        paramBitmap = (Bitmap)localObject;
        break;
        return localObject;
      }
      for (;;)
      {
        if (i >= 8) {
          break label238;
        }
        j = 0;
        break;
        bool = false;
        break label57;
        i += 1;
      }
    }
  }
  
  public static int getDistance(String paramString1, String paramString2)
  {
    int j = 0;
    int k;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramString1.length() != paramString2.length()))
    {
      k = SIMILARITY_DHASH_ERROR_CODE;
      return k;
    }
    for (int i = 0;; i = k)
    {
      k = i;
      if (j >= paramString1.length()) {
        break;
      }
      k = i;
      if (paramString1.charAt(j) != paramString2.charAt(j)) {
        k = i + 1;
      }
      j += 1;
    }
  }
  
  public static long getExifShootTime(String paramString)
  {
    Object localObject = null;
    try
    {
      paramString = new ExifInterface(paramString);
      l2 = 0L;
      l1 = l2;
      if (paramString != null)
      {
        paramString.getAttribute("DateTime");
        paramString = paramString.getAttribute("DateTime");
        l1 = l2;
        if (paramString != null) {
          localSimpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        }
      }
    }
    catch (IOException paramString)
    {
      try
      {
        long l2;
        SimpleDateFormat localSimpleDateFormat;
        paramString = localSimpleDateFormat.parse(paramString);
        long l1 = l2;
        if (paramString != null) {
          l1 = paramString.getTime();
        }
        return l1;
        paramString = paramString;
        paramString.printStackTrace();
        paramString = null;
      }
      catch (ParseException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = localObject;
        }
      }
    }
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
    if (this.mProgressListener != null) {
      this.mProgressListener.postAntishakeProgress(paramInt);
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
      if ((QzoneVision.isLibDownloaded()) && (getInstance().getIsGifAntishakeOn())) {
        mNativeLibLoaded = QzoneVision.loadNativeLib();
      }
    }
    else {
      return;
    }
    mNativeLibLoaded = false;
  }
  
  public boolean checkFolder(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return false;
    }
    String str = AppConstants.SDCARD_ROOT + "/tencent/Qzone/AlbumAutoVConvGif/";
    if (((String)paramArrayList.get(0)).startsWith(str))
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
  
  public Boolean checkImageSimlarityByBitmap(ArrayList<Bitmap> paramArrayList)
  {
    long l = System.currentTimeMillis();
    if (!mNativeLibLoaded)
    {
      tryToLoadLibrary();
      if (!mNativeLibLoaded) {
        return Boolean.valueOf(false);
      }
    }
    if ((paramArrayList == null) || (paramArrayList.size() < 2) || (paramArrayList.get(0) == null)) {
      return Boolean.valueOf(false);
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
      i = 0;
      if (i < paramArrayList.size()) {
        if (arrayOfBoolean[i] == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QzoneVision", 2, "总共用时:" + (System.currentTimeMillis() - l));
          }
          return Boolean.valueOf(false);
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
        continue;
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVision", 2, "总共用时:" + (System.currentTimeMillis() - l));
      }
    }
    return Boolean.valueOf(true);
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
    if ((paramArrayList == null) || (paramArrayList.size() < 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVision", 2, "checkShootTimeForAntishake false:filePath == null || filePath.size() < 2 || !mNativeLibLoaded");
      }
      return false;
    }
    int j = paramArrayList.size();
    long l = getExifShootTime((String)paramArrayList.get(0));
    if (l == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVision", 2, "checkShootTimeForAntishake false:firstFrameTime == 0");
      }
      return false;
    }
    if ((getExifShootTime((String)paramArrayList.get(j - 1)) - l > this.antishakeMaxTotalGapTime) || (getExifShootTime((String)paramArrayList.get(j - 1)) - getExifShootTime((String)paramArrayList.get(0)) < 0L)) {
      return false;
    }
    int i = 1;
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
  
  public ArrayList<String> getAntiShakeBitmapList(ArrayList<Bitmap> paramArrayList)
  {
    if (!mNativeLibLoaded)
    {
      tryToLoadLibrary();
      if (!mNativeLibLoaded) {
        return null;
      }
    }
    if ((paramArrayList == null) || ((paramArrayList != null) && (paramArrayList.size() < 2))) {
      return null;
    }
    LocalMultiProcConfig.putInt(ANTISHAKE_STATUS, ANTISHAKE_END_DOING_OR_FAILED);
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVision", 2, "startantishake at " + l1);
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayList.size();
    if (j < 2) {
      return null;
    }
    Bitmap localBitmap1 = (Bitmap)paramArrayList.get(0);
    int k = localBitmap1.getWidth();
    int m = localBitmap1.getHeight();
    String[] arrayOfString = new String[j];
    int n = k / 10;
    int i1 = m / 10;
    Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1, n, i1, localBitmap1.getWidth() - n * 2, localBitmap1.getHeight() - i1 * 2);
    Object localObject = PhotoUtils.getCameraPath(getAntishakePath(), ".IMG0", ".jpg");
    File localFile = new File((String)localObject);
    try
    {
      bheg.a(localBitmap2, localFile);
      arrayOfString[0] = localObject;
      doneAntishakeFrameNum = 1;
      postProgress(doneAntishakeFrameNum);
      localObject = new CountDownLatch(j - 1);
      i = 1;
      while (i < j)
      {
        threadPoolExecutor.execute(new GifAntishakeModule.1(this, i, k, m, paramArrayList, localBitmap1, n, i1, arrayOfString, (CountDownLatch)localObject));
        i += 1;
      }
    }
    catch (IOException localIOException)
    {
      int i;
      for (;;)
      {
        localIOException.printStackTrace();
      }
      try
      {
        ((CountDownLatch)localObject).await();
        i = 0;
        while (i < j)
        {
          if (arrayOfString[i] != null) {
            localArrayList.add(arrayOfString[i]);
          }
          i += 1;
        }
      }
      catch (InterruptedException paramArrayList)
      {
        for (;;)
        {
          paramArrayList.printStackTrace();
        }
        doneAntishakeFrameNum = 0;
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("QzoneVision", 2, "endantishake at " + l2 + ", cost " + (l2 - l1) / 1000L + "s");
        }
        System.gc();
        this.mProgressListener = null;
        LocalMultiProcConfig.putInt(ANTISHAKE_STATUS, ANTISHAKE_END_NORMALLY);
      }
    }
    return localArrayList;
  }
  
  public boolean getIsGifAntishakeOn()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeSwitch", 1) == 1;
  }
  
  public int getMaxGifAntishakeFrameNum()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeMaxFrameNum", 5);
  }
  
  public void setAntishakeProgressListener(GifAntishakeModule.postProgressListener parampostProgressListener)
  {
    this.mProgressListener = parampostProgressListener;
  }
  
  public boolean suitableForAntishake(ArrayList<String> paramArrayList, LruCache<Integer, BitmapDrawable> paramLruCache)
  {
    boolean bool1 = true;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2;
    if (!mNativeLibLoaded)
    {
      tryToLoadLibrary();
      if (!mNativeLibLoaded) {
        bool2 = bool3;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return bool2;
                      if (LocalMultiProcConfig.getInt(ANTISHAKE_STATUS, ANTISHAKE_END_NORMALLY) != ANTISHAKE_END_DOING_OR_FAILED) {
                        break;
                      }
                      bool2 = bool3;
                    } while (!QLog.isColorLevel());
                    QLog.d("QzoneVision", 2, "本地记录防抖正在进行或者没有正常结束 以后就不防抖了");
                    return false;
                    bool2 = bool3;
                  } while (paramArrayList == null);
                  bool2 = bool3;
                } while (paramArrayList.size() < 2);
                bool2 = bool3;
              } while (paramLruCache == null);
              bool2 = bool3;
            } while (paramLruCache.size() < 2);
            bool2 = bool3;
          } while (!getIsGifAntishakeOn());
          bool2 = bool3;
        } while (paramArrayList.size() > getMaxGifAntishakeFrameNum());
        bool2 = bool3;
      } while (!QZoneHelper.isBestPerformanceDevice());
      bool2 = bool3;
    } while (!checkFolder(paramArrayList));
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVision", 2, "DeviceInfoUtil.getMemoryClass() = " + DeviceInfoUtil.getMemoryClass() / 1048576L + "M, DeviceInfoUtil.getSystemAvaialbeMemory() = " + DeviceInfoUtil.getSystemAvaialbeMemory() / 1048576L + "M");
    }
    if ((this.needToCheckShootTime) && (this.needToCheckSimilarity))
    {
      bool1 = bool4;
      if (checkShootTimeForAntishake(paramArrayList))
      {
        paramArrayList = new ArrayList();
        if (paramLruCache == null) {
          break label575;
        }
      }
    }
    label423:
    label570:
    label575:
    for (int i = paramLruCache.size();; i = 0)
    {
      int j = 0;
      for (;;)
      {
        if (j < i) {
          if ((paramLruCache != null) && (paramLruCache.get(Integer.valueOf(j)) != null))
          {
            paramArrayList.add(((BitmapDrawable)paramLruCache.get(Integer.valueOf(j))).getBitmap());
            j += 1;
          }
          else
          {
            bool2 = bool3;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("QzoneVision", 2, "suitableForAntishake false:mMemoryCache == null || mMemoryCache.get(i) == null");
            return false;
          }
        }
      }
      bool1 = bool4;
      if (checkImageSimlarityByBitmap(paramArrayList).booleanValue()) {
        bool1 = true;
      }
      for (;;)
      {
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QzoneVision", 2, "suitableForAntishake " + bool1);
        return bool1;
        if ((!this.needToCheckShootTime) || (this.needToCheckSimilarity)) {
          break label423;
        }
        bool1 = bool4;
        if (checkShootTimeForAntishake(paramArrayList)) {
          bool1 = true;
        }
      }
      if ((!this.needToCheckShootTime) && (this.needToCheckSimilarity))
      {
        paramArrayList = new ArrayList();
        if (paramLruCache == null) {
          break label570;
        }
      }
      for (i = paramLruCache.size();; i = 0)
      {
        j = 0;
        for (;;)
        {
          if (j < i)
          {
            BitmapDrawable localBitmapDrawable = (BitmapDrawable)paramLruCache.get(Integer.valueOf(j));
            if (localBitmapDrawable != null)
            {
              paramArrayList.add(localBitmapDrawable.getBitmap());
              j += 1;
            }
            else
            {
              bool2 = bool3;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("QzoneVision", 2, "suitableForAntishake false:mMemoryCache == null || mMemoryCache.get(i) == null");
              return false;
            }
          }
        }
        if (checkImageSimlarityByBitmap(paramArrayList).booleanValue()) {}
        for (;;)
        {
          break;
          bool1 = bool4;
          if (this.needToCheckShootTime) {
            break;
          }
          bool1 = bool4;
          if (this.needToCheckSimilarity) {
            break;
          }
          bool1 = true;
          break;
          bool1 = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.GifAntishakeModule
 * JD-Core Version:    0.7.0.1
 */