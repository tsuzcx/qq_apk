package cooperation.qzone.util;

import amkj;
import amkk;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.ExifInterface;
import android.util.LruCache;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.vision.PhotoUtil;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GifAntishakeModule
{
  private static int jdField_a_of_type_Int;
  public static GifAntishakeModule a;
  private static ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(DeviceInfoUtil.b(), DeviceInfoUtil.b() + 5, 200L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
  private static boolean jdField_a_of_type_Boolean;
  private float jdField_a_of_type_Float = Float.parseFloat(QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeMinSimilarity", "0.6"));
  private long jdField_a_of_type_Long = Long.parseLong(QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeMaxGroupShootTime", "60000"));
  private GifAntishakeModule.postProgressListener jdField_a_of_type_CooperationQzoneUtilGifAntishakeModule$postProgressListener;
  private String jdField_a_of_type_JavaLangString = AppConstants.aI + "/tencent/Qzone/AntishakeGif/";
  private long jdField_b_of_type_Long = Long.parseLong(QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeMaxFrameShootTime", "3000"));
  private String jdField_b_of_type_JavaLangString = ".nomedia";
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  static
  {
    a();
  }
  
  public GifAntishakeModule()
  {
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeNeedToCheckShootTime", 0) == 1)
    {
      bool1 = true;
      this.c = bool1;
      if (QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeNeedToCheckSimilarity", 1) != 1) {
        break label144;
      }
    }
    label144:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.d = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public static long a(String paramString)
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
  
  public static GifAntishakeModule a()
  {
    try
    {
      if (jdField_a_of_type_CooperationQzoneUtilGifAntishakeModule == null) {
        jdField_a_of_type_CooperationQzoneUtilGifAntishakeModule = new GifAntishakeModule();
      }
      GifAntishakeModule localGifAntishakeModule = jdField_a_of_type_CooperationQzoneUtilGifAntishakeModule;
      return localGifAntishakeModule;
    }
    finally {}
  }
  
  private String a()
  {
    File localFile;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localFile = new File(this.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString);
      if (localFile.exists()) {}
    }
    try
    {
      localFile.createNewFile();
      return this.jdField_a_of_type_JavaLangString;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QLog.e("QzoneVision", 1, "getAntishakeGifFilePath: create .nomedia file fail");
      }
    }
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      if ((PhotoUtil.b()) && (a().a())) {
        jdField_a_of_type_Boolean = PhotoUtil.a();
      }
    }
    else {
      return;
    }
    jdField_a_of_type_Boolean = false;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_CooperationQzoneUtilGifAntishakeModule$postProgressListener != null) {
      this.jdField_a_of_type_CooperationQzoneUtilGifAntishakeModule$postProgressListener.a(paramInt);
    }
  }
  
  public int a()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeMaxFrameNum", 5);
  }
  
  public Boolean a(ArrayList paramArrayList)
  {
    if (!jdField_a_of_type_Boolean)
    {
      a();
      if (!jdField_a_of_type_Boolean) {
        return Boolean.valueOf(false);
      }
    }
    if ((paramArrayList == null) || (paramArrayList.size() < 2) || (paramArrayList.get(0) == null)) {
      return Boolean.valueOf(false);
    }
    CountDownLatch localCountDownLatch = new CountDownLatch(paramArrayList.size() - 1);
    boolean[] arrayOfBoolean = new boolean[paramArrayList.size()];
    arrayOfBoolean[0] = true;
    Bitmap localBitmap = (Bitmap)paramArrayList.get(0);
    int i = 1;
    while (i < paramArrayList.size())
    {
      jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(new amkk(this, paramArrayList, i, localCountDownLatch, localBitmap, arrayOfBoolean));
      i += 1;
    }
    try
    {
      localCountDownLatch.await();
      i = 0;
      if (i < paramArrayList.size()) {
        if (arrayOfBoolean[i] == 0) {
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
    }
    return Boolean.valueOf(true);
  }
  
  public ArrayList a(ArrayList paramArrayList)
  {
    if (!jdField_a_of_type_Boolean)
    {
      a();
      if (!jdField_a_of_type_Boolean) {
        return null;
      }
    }
    if ((paramArrayList == null) || ((paramArrayList != null) && (paramArrayList.size() < 2))) {
      return null;
    }
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
    Object localObject = PhotoUtils.a(a(), ".IMG0", ".jpg");
    File localFile = new File((String)localObject);
    try
    {
      ImageUtil.a(localBitmap2, localFile);
      arrayOfString[0] = localObject;
      jdField_a_of_type_Int = 1;
      a(jdField_a_of_type_Int);
      localObject = new CountDownLatch(j - 1);
      i = 1;
      while (i < j)
      {
        jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(new amkj(this, i, k, m, paramArrayList, localBitmap1, n, i1, arrayOfString, (CountDownLatch)localObject));
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
        jdField_a_of_type_Int = 0;
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("QzoneVision", 2, "endantishake at " + l2 + ", cost " + (l2 - l1) / 1000L + "s");
        }
        System.gc();
        this.jdField_a_of_type_CooperationQzoneUtilGifAntishakeModule$postProgressListener = null;
      }
    }
    return localArrayList;
  }
  
  public void a(GifAntishakeModule.postProgressListener parampostProgressListener)
  {
    this.jdField_a_of_type_CooperationQzoneUtilGifAntishakeModule$postProgressListener = parampostProgressListener;
  }
  
  public boolean a()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "GifAntishakeSwitch", 1) == 1;
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    String str = AppConstants.aI + "/tencent/Qzone/AlbumAutoVConvGif/";
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
  
  public boolean a(ArrayList paramArrayList, LruCache paramLruCache)
  {
    boolean bool1 = true;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2;
    if (!jdField_a_of_type_Boolean)
    {
      a();
      if (!jdField_a_of_type_Boolean) {
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
                    return bool2;
                    bool2 = bool3;
                  } while (paramArrayList == null);
                  bool2 = bool3;
                } while (paramArrayList.size() < 2);
                bool2 = bool3;
              } while (paramLruCache == null);
              bool2 = bool3;
            } while (paramLruCache.size() < 2);
            bool2 = bool3;
          } while (!a());
          bool2 = bool3;
        } while (paramArrayList.size() > a());
        bool2 = bool3;
      } while (!QZoneHelper.d());
      bool2 = bool3;
    } while (!a(paramArrayList));
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVision", 2, "DeviceInfoUtil.getMemoryClass() = " + DeviceInfoUtil.g() / 1048576L + "M, DeviceInfoUtil.getSystemAvaialbeMemory() = " + DeviceInfoUtil.f() / 1048576L + "M");
    }
    if ((this.c) && (this.d))
    {
      bool1 = bool4;
      if (b(paramArrayList))
      {
        paramArrayList = new ArrayList();
        if (paramLruCache == null) {
          break label539;
        }
      }
    }
    label387:
    label534:
    label539:
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
      if (a(paramArrayList).booleanValue()) {
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
        if ((!this.c) || (this.d)) {
          break label387;
        }
        bool1 = bool4;
        if (b(paramArrayList)) {
          bool1 = true;
        }
      }
      if ((!this.c) && (this.d))
      {
        paramArrayList = new ArrayList();
        if (paramLruCache == null) {
          break label534;
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
        if (a(paramArrayList).booleanValue()) {}
        for (;;)
        {
          break;
          bool1 = bool4;
          if (this.c) {
            break;
          }
          bool1 = bool4;
          if (this.d) {
            break;
          }
          bool1 = true;
          break;
          bool1 = false;
        }
      }
    }
  }
  
  public boolean b(ArrayList paramArrayList)
  {
    if (!jdField_a_of_type_Boolean)
    {
      a();
      if (!jdField_a_of_type_Boolean) {
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
    long l = a((String)paramArrayList.get(0));
    if (l == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVision", 2, "checkShootTimeForAntishake false:firstFrameTime == 0");
      }
      return false;
    }
    if ((a((String)paramArrayList.get(j - 1)) - l > this.jdField_a_of_type_Long) || (a((String)paramArrayList.get(j - 1)) - a((String)paramArrayList.get(0)) < 0L)) {
      return false;
    }
    int i = 1;
    while (i < j) {
      if (a((String)paramArrayList.get(i)) - l < this.jdField_b_of_type_Long)
      {
        l = a((String)paramArrayList.get(i));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.GifAntishakeModule
 * JD-Core Version:    0.7.0.1
 */