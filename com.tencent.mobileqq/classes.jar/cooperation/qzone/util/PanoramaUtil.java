package cooperation.qzone.util;

import android.graphics.Bitmap.Config;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.ArrayList;

public class PanoramaUtil
{
  public static final int CYLINDER_PIECE = 36;
  private static final int DEFAULT_PANORAMA_BLACKLIST_LEVEL_VALUE = 20;
  private static final String DEFAULT_PANORAMA_BLACKLIST_VALUE = "MI 3";
  private static final String DEFAULT_PANORAMA_ROTATION_BLACKLIST_VALUE = "KNT-AL20";
  private static final int DEFAULT_PANORAMA_SWITCH_VALUE = 1;
  public static final String MTA_EVENT_KEY_ALBUM_DLNA = "qzone_panorama";
  public static final String MTA_SUB_KEY_COVER_PANORAMA = "qzone_cover_panorama";
  public static final String MTA_SUB_KEY_FEED_PANORAMA = "qzone_feed_panorama";
  public static final String MTA_SUB_KEY_GALLERY = "qzone_gallery";
  public static final String MTA_SUB_KEY_GALLERY_PANORAMA = "qzone_gallery_panorama";
  public static final String MTA_SUB_KEY_UPLOAD_ALL_COUNT = "upload_all_count";
  public static final String MTA_SUB_KEY_UPLOAD_PANORAMA_CYLINDER = "upload_panorama_cylinder";
  public static final String MTA_SUB_KEY_UPLOAD_PANORAMA_SPHERE = "upload_panorama_sphere";
  public static final String MTA_VALUE_PANORAMA_CLICK = "click";
  public static final String MTA_VALUE_PANORAMA_EXPOSE = "expose";
  private static final String QZONE_CONFIG_SECONDARY_KEY_PANORAMA_BLACKLIST_LEVEL_VALUE = "panoramaBlackListLevelValue";
  private static final String QZONE_CONFIG_SECONDARY_KEY_PANORAMA_BLACKLIST_VALUE = "panoramaBlackListValue";
  private static final String QZONE_CONFIG_SECONDARY_KEY_PANORAMA_SWITCH_VALUE = "panoramaSwitch";
  private static final String QZONE_CONFIG_SECONDARY_KEY_PANORAMA__ROTATION_BLACKLIST_VALUE = "panoramaRotationBlackListValue";
  public static final String SVR_PANORAMA_BALL = "2";
  public static final String SVR_PANORAMA_CYLINDER = "1";
  public static final String SVR_PANORAMA_NORMAL = "0";
  private static final String TAG = "PanoramaUtil";
  public static final int TYPE_PANORAMA_BALL = 2;
  public static final int TYPE_PANORAMA_CYLINDER = 1;
  public static final String TYPE_PANORAMA_NAME = "panorama_type";
  public static final int TYPE_PANORAMA_NORMAL = 3;
  private static PanoramaUtil instance;
  private static final int mPanoramaBlackLevel = QzoneConfig.getInstance().getConfig("QZoneSetting", "panoramaBlackListLevelValue", 20);
  private static final String mPanoramaBlackList = QzoneConfig.getInstance().getConfig("QZoneSetting", "panoramaBlackListValue", "MI 3");
  private static final String mPanoramaRotationBlackList = QzoneConfig.getInstance().getConfig("QZoneSetting", "panoramaRotationBlackListValue", "KNT-AL20");
  private static int mPanoramaSwitch = QzoneConfig.getInstance().getConfig("QZoneSetting", "panoramaSwitch", 1);
  private volatile boolean g_isInPanoramaBlacklist = false;
  private volatile boolean g_isInPanoramaRotationBlacklist = false;
  private volatile String g_panoramaBlacklist = null;
  private volatile String g_panoramaRotationBlacklist = null;
  private ArrayList<float[]> sphereList;
  
  public static PanoramaUtil getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new PanoramaUtil();
        }
      }
      finally {}
    }
    return instance;
  }
  
  private boolean isBuildModelInList(String paramString)
  {
    try
    {
      String str = Build.MODEL;
      if ((str != null) && (str.length() != 0))
      {
        StringBuilder localStringBuilder;
        if (QZLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("buildModel is '");
          localStringBuilder.append(str);
          localStringBuilder.append("'");
          QZLog.d("PanoramaUtil", 2, localStringBuilder.toString());
        }
        if (paramString != null)
        {
          if (paramString.length() == 0) {
            return false;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(",");
          localStringBuilder.append(str);
          localStringBuilder.append(",");
          str = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(",");
          localStringBuilder.append(paramString);
          localStringBuilder.append(",");
          if (localStringBuilder.toString().contains(str))
          {
            QZLog.i("PanoramaUtil", 1, "命中禁止全景黑名单策略");
            return true;
          }
        }
      }
      else
      {
        QZLog.i("PanoramaUtil", 1, "buildModel is empty,not show panorama items.命中禁止全景策略");
        return true;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    return false;
  }
  
  public static boolean isPanoramaPhoto(int paramInt)
  {
    if (!getInstance().isNeedShowPanorama())
    {
      QZLog.i("PanoramaUtil", "isPanoramaPhoto NoNeedShowPanorama");
      return false;
    }
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt == 3)
      {
        QZLog.i("PanoramaUtil", "isPanoramaPhoto IsNormal");
        return false;
      }
      QZLog.i("PanoramaUtil", "isPanoramaPhoto Return");
      return false;
    }
    QZLog.i("PanoramaUtil", "isPanoramaPhoto ReallyPanorama");
    return true;
  }
  
  private ArrayList<float[]> setCylinderList(ArrayList<float[]> paramArrayList, float paramFloat, boolean paramBoolean)
  {
    float f3 = paramFloat;
    if (paramArrayList == null) {
      paramArrayList = new ArrayList();
    }
    QZLog.i("PanoramaUtil", 4, new Object[] { "cylinderList size = ", Integer.valueOf(paramArrayList.size()) });
    if ((paramArrayList.size() == 2) && (paramArrayList.get(0) != null) && (((float[])paramArrayList.get(0)).length > 0) && (paramArrayList.get(1) != null) && (((float[])paramArrayList.get(1)).length > 0)) {
      return paramArrayList;
    }
    paramArrayList.clear();
    float f2 = 360.0F / 36;
    float f1 = f3 / 10.0F;
    int i = (int)f1 * 6;
    float[] arrayOfFloat2 = new float[i * 3];
    float[] arrayOfFloat1 = new float[i * 2];
    if (!paramBoolean) {
      f1 = 1.0F;
    }
    float f5 = 360.0F / f3;
    float f4 = 0.0F;
    int j = 0;
    i = 0;
    f3 = f1;
    f1 = f5;
    for (;;)
    {
      double d1 = f4;
      if (Math.ceil(d1) >= paramFloat) {
        break;
      }
      double d3 = Math.toRadians(d1);
      f4 += f2;
      double d2 = Math.toRadians(f4);
      double d4 = f1;
      Double.isNaN(d4);
      Double.isNaN(d4);
      int k = j + 1;
      d1 = -100.0F;
      double d5 = Math.sin(d3);
      Double.isNaN(d1);
      arrayOfFloat2[j] = ((float)(d1 * d5));
      int m = k + 1;
      f5 = 55;
      arrayOfFloat2[k] = f5;
      j = m + 1;
      d5 = Math.cos(d3);
      Double.isNaN(d1);
      arrayOfFloat2[m] = ((float)(d1 * d5));
      k = i + 1;
      float f6 = -(float)(d3 * d4 / 6.283185307179586D) * f3;
      arrayOfFloat1[i] = f6;
      i = k + 1;
      float f7 = 0;
      arrayOfFloat1[k] = f7;
      k = j + 1;
      d5 = Math.sin(d2);
      Double.isNaN(d1);
      arrayOfFloat2[j] = ((float)(d1 * d5));
      m = k + 1;
      float f8 = -55;
      arrayOfFloat2[k] = f8;
      j = m + 1;
      d5 = Math.cos(d2);
      Double.isNaN(d1);
      arrayOfFloat2[m] = ((float)(d5 * d1));
      k = i + 1;
      float f9 = -(float)(d4 * d2 / 6.283185307179586D) * f3;
      arrayOfFloat1[i] = f9;
      i = k + 1;
      float f10 = 1;
      arrayOfFloat1[k] = f10;
      k = j + 1;
      d4 = Math.sin(d3);
      Double.isNaN(d1);
      arrayOfFloat2[j] = ((float)(d1 * d4));
      m = k + 1;
      arrayOfFloat2[k] = f8;
      j = m + 1;
      d4 = Math.cos(d3);
      Double.isNaN(d1);
      arrayOfFloat2[m] = ((float)(d4 * d1));
      k = i + 1;
      arrayOfFloat1[i] = f6;
      i = k + 1;
      arrayOfFloat1[k] = f10;
      k = j + 1;
      d4 = Math.sin(d3);
      Double.isNaN(d1);
      arrayOfFloat2[j] = ((float)(d4 * d1));
      m = k + 1;
      arrayOfFloat2[k] = f5;
      j = m + 1;
      d3 = Math.cos(d3);
      Double.isNaN(d1);
      arrayOfFloat2[m] = ((float)(d3 * d1));
      k = i + 1;
      arrayOfFloat1[i] = f6;
      i = k + 1;
      arrayOfFloat1[k] = f7;
      k = j + 1;
      d3 = Math.sin(d2);
      Double.isNaN(d1);
      arrayOfFloat2[j] = ((float)(d3 * d1));
      m = k + 1;
      arrayOfFloat2[k] = f5;
      j = m + 1;
      d3 = Math.cos(d2);
      Double.isNaN(d1);
      arrayOfFloat2[m] = ((float)(d3 * d1));
      k = i + 1;
      arrayOfFloat1[i] = f9;
      i = k + 1;
      arrayOfFloat1[k] = f7;
      k = j + 1;
      d3 = Math.sin(d2);
      Double.isNaN(d1);
      arrayOfFloat2[j] = ((float)(d3 * d1));
      j = k + 1;
      arrayOfFloat2[k] = f8;
      d2 = Math.cos(d2);
      Double.isNaN(d1);
      arrayOfFloat2[j] = ((float)(d1 * d2));
      k = i + 1;
      arrayOfFloat1[i] = f9;
      i = k + 1;
      arrayOfFloat1[k] = f10;
      j += 1;
    }
    paramArrayList.add(arrayOfFloat2);
    paramArrayList.add(arrayOfFloat1);
    return paramArrayList;
  }
  
  public static void setPanoramaType(LocalMediaInfo paramLocalMediaInfo)
  {
    if ((paramLocalMediaInfo.panoramaPhotoType == 0) && (getInstance().isNeedShowPanorama()))
    {
      if ((paramLocalMediaInfo.mediaWidth != 0) && (paramLocalMediaInfo.mediaHeight != 0))
      {
        if ((paramLocalMediaInfo.mediaHeight >= 1000) && (paramLocalMediaInfo.mediaWidth / paramLocalMediaInfo.mediaHeight == 2.0F))
        {
          boolean bool = XMPCoreUtil.getInstance().isPanorama(paramLocalMediaInfo.path);
          QZLog.i("PanoramaUtil", "setPanoramaType GetIsPanorama");
          if (bool)
          {
            paramLocalMediaInfo.panoramaPhotoType = 2;
            QZLog.i("PanoramaUtil", "setPanoramaType IsPanorama");
            return;
          }
          paramLocalMediaInfo.panoramaPhotoType = 3;
          QZLog.i("PanoramaUtil", "setPanoramaType IsNotPanorama");
          return;
        }
        if ((paramLocalMediaInfo.mediaHeight >= 512) && (paramLocalMediaInfo.mediaWidth / paramLocalMediaInfo.mediaHeight >= 4.0F))
        {
          paramLocalMediaInfo.panoramaPhotoType = 1;
          QZLog.i("PanoramaUtil", "setPanoramaType IsPanoramaCylinder");
          return;
        }
        QZLog.i("PanoramaUtil", "setPanoramaType NormalType");
        paramLocalMediaInfo.panoramaPhotoType = 3;
        return;
      }
      QZLog.i("PanoramaUtil", "setPanoramaType LocalMediaInfoFalse");
      return;
    }
    QZLog.i("PanoramaUtil", "setPanoramaType NoPanoramaPhoto");
  }
  
  public int computeSampleSize(ImageLoader.Options paramOptions, int paramInt1, int paramInt2)
  {
    int j = 4;
    int i = 1;
    int k = 1;
    QZLog.i("PanoramaUtil", 4, new Object[] { "computeSampleSize width = ", Integer.valueOf(paramInt1), " height = ", Integer.valueOf(paramInt2) });
    if (paramInt1 / paramInt2 == 2)
    {
      if (paramInt1 > 4096) {
        paramOptions.imageConfig = Bitmap.Config.RGB_565;
      }
      i = j;
      j = k;
      if (paramOptions.imageConfig == Bitmap.Config.RGB_565)
      {
        i = 2;
        j = k;
      }
      while (paramInt1 / j * (paramInt2 / j) * i / 1024 / 1024 > 32) {
        j <<= 1;
      }
      return j;
    }
    if (paramInt1 < paramInt2)
    {
      paramInt2 = i;
    }
    else
    {
      paramInt1 = paramInt2;
      paramInt2 = i;
    }
    while (paramInt1 / paramInt2 > 320) {
      paramInt2 <<= 1;
    }
    return paramInt2;
  }
  
  public ArrayList<float[]> getCylinderCoordinate(float paramFloat, boolean paramBoolean)
  {
    return setCylinderList(new ArrayList(), paramFloat, paramBoolean);
  }
  
  public ArrayList<float[]> getSphereCoordinate()
  {
    if (this.sphereList == null) {
      this.sphereList = new ArrayList();
    }
    int i = this.sphereList.size();
    String str = "PanoramaUtil";
    QZLog.i("PanoramaUtil", 4, new Object[] { "sphereList size = ", Integer.valueOf(i) });
    if ((this.sphereList.size() == 2) && (this.sphereList.get(0) != null) && (((float[])this.sphereList.get(0)).length > 0) && (this.sphereList.get(1) != null) && (((float[])this.sphereList.get(1)).length > 0)) {
      return this.sphereList;
    }
    this.sphereList.clear();
    float f1 = 72;
    double d1 = f1;
    Double.isNaN(d1);
    d1 = 6.283185307179586D / d1;
    double d2 = 1.0F / f1;
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    long l = System.currentTimeMillis();
    i = 0;
    while (i < 72)
    {
      j = 0;
      while (j < 72)
      {
        f1 = 4;
        double d3 = i;
        Double.isNaN(d3);
        double d4 = d3 * d1 / 2.0D;
        double d6 = Math.sin(d4);
        double d5 = j;
        Double.isNaN(d5);
        double d8 = d5 * d1;
        float f2 = (float)(d6 * Math.cos(d8)) * f1;
        float f3 = (float)(Math.sin(d4) * Math.sin(d8)) * f1;
        float f4 = (float)Math.cos(d4) * f1;
        d6 = i + 1;
        Double.isNaN(d6);
        double d7 = d6 * d1 / 2.0D;
        float f5 = (float)(Math.sin(d7) * Math.cos(d8));
        float f6 = (float)(Math.sin(d7) * Math.sin(d8));
        float f7 = (float)Math.cos(d7);
        d8 = Math.sin(d7);
        j += 1;
        double d9 = j;
        Double.isNaN(d9);
        double d10 = d9 * d1;
        float f8 = f1 * (float)(d8 * Math.cos(d10));
        float f9 = (float)(Math.sin(d7) * Math.sin(d10)) * f1;
        float f10 = (float)Math.cos(d7) * f1;
        float f11 = (float)(Math.sin(d4) * Math.cos(d10));
        float f12 = (float)(Math.sin(d4) * Math.sin(d10));
        float f13 = (float)Math.cos(d4);
        ((ArrayList)localObject).add(Float.valueOf(f2));
        ((ArrayList)localObject).add(Float.valueOf(f4));
        ((ArrayList)localObject).add(Float.valueOf(f3));
        ((ArrayList)localObject).add(Float.valueOf(f5 * f1));
        ((ArrayList)localObject).add(Float.valueOf(f7 * f1));
        ((ArrayList)localObject).add(Float.valueOf(f6 * f1));
        ((ArrayList)localObject).add(Float.valueOf(f8));
        ((ArrayList)localObject).add(Float.valueOf(f10));
        ((ArrayList)localObject).add(Float.valueOf(f9));
        ((ArrayList)localObject).add(Float.valueOf(f8));
        ((ArrayList)localObject).add(Float.valueOf(f10));
        ((ArrayList)localObject).add(Float.valueOf(f9));
        ((ArrayList)localObject).add(Float.valueOf(f11 * f1));
        ((ArrayList)localObject).add(Float.valueOf(f13 * f1));
        ((ArrayList)localObject).add(Float.valueOf(f12 * f1));
        ((ArrayList)localObject).add(Float.valueOf(f2));
        ((ArrayList)localObject).add(Float.valueOf(f4));
        ((ArrayList)localObject).add(Float.valueOf(f3));
        Double.isNaN(d3);
        Double.isNaN(d2);
        f1 = (float)(d3 * d2);
        Double.isNaN(d5);
        Double.isNaN(d2);
        f2 = (float)(d5 * d2);
        Double.isNaN(d6);
        Double.isNaN(d2);
        f3 = (float)(d6 * d2);
        Double.isNaN(d9);
        Double.isNaN(d2);
        f4 = (float)(d9 * d2);
        localArrayList.add(Float.valueOf(f2));
        localArrayList.add(Float.valueOf(f1));
        localArrayList.add(Float.valueOf(f2));
        localArrayList.add(Float.valueOf(f3));
        localArrayList.add(Float.valueOf(f4));
        localArrayList.add(Float.valueOf(f3));
        localArrayList.add(Float.valueOf(f4));
        localArrayList.add(Float.valueOf(f3));
        localArrayList.add(Float.valueOf(f4));
        localArrayList.add(Float.valueOf(f1));
        localArrayList.add(Float.valueOf(f2));
        localArrayList.add(Float.valueOf(f1));
      }
      i += 1;
    }
    int j = ((ArrayList)localObject).size() / 3;
    float[] arrayOfFloat = new float[j * 3];
    i = 0;
    while (i < arrayOfFloat.length)
    {
      arrayOfFloat[i] = ((Float)((ArrayList)localObject).get(i)).floatValue();
      i += 1;
    }
    this.sphereList.add(arrayOfFloat);
    localObject = new float[j * 2];
    i = 0;
    while (i < localObject.length)
    {
      localObject[i] = ((Float)localArrayList.get(i)).floatValue();
      i += 1;
    }
    this.sphereList.add(localObject);
    QZLog.i(str, 4, new Object[] { "currentTime getSphereCoordinate = ", Long.valueOf(System.currentTimeMillis() - l) });
    return this.sphereList;
  }
  
  public boolean isClosePanoramaRotation()
  {
    if ((mPanoramaRotationBlackList != null) && (Build.VERSION.SDK_INT >= 24))
    {
      if (!mPanoramaRotationBlackList.equals(this.g_panoramaRotationBlacklist))
      {
        this.g_isInPanoramaRotationBlacklist = isBuildModelInList(mPanoramaRotationBlackList);
        this.g_panoramaRotationBlacklist = mPanoramaRotationBlackList;
      }
      return this.g_isInPanoramaRotationBlacklist;
    }
    return false;
  }
  
  public boolean isHighDevice()
  {
    return ((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).getCurrentMemLevel() == 3;
  }
  
  public boolean isNeedShowPanorama()
  {
    if (mPanoramaSwitch == 0) {
      return false;
    }
    if (Build.VERSION.SDK_INT <= mPanoramaBlackLevel) {
      return false;
    }
    String str = mPanoramaBlackList;
    if (str == null) {
      return true;
    }
    if (!str.equals(this.g_panoramaBlacklist))
    {
      this.g_isInPanoramaBlacklist = isBuildModelInList(mPanoramaBlackList);
      this.g_panoramaBlacklist = mPanoramaBlackList;
    }
    return this.g_isInPanoramaBlacklist ^ true;
  }
  
  public void reportMta(String paramString1, String paramString2, int paramInt)
  {
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new PanoramaUtil.1(this, paramString2, paramString1, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.util.PanoramaUtil
 * JD-Core Version:    0.7.0.1
 */