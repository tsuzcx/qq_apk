package dov.com.qq.im.ae.download;

import android.support.annotation.NonNull;
import java.util.LinkedList;
import java.util.List;

public class AEResInfo
{
  public static final AEResInfo AE_RES_ADDITIONAL_PACKAGE;
  public static final AEResInfo AE_RES_BASE_PACKAGE;
  public static final AEResInfo AE_RES_CONFIG = new AEResInfo(-1, "215Config");
  private static final String SHORT_VIDEO_FILTER_RES_PREFIX = "new_qq_android_native_short_filter_";
  private static final String SHORT_VIDEO_PTU_RES_PREFIX = "new_qq_android_native_ptu_res_";
  public static final AEResInfo[] packageValues = initPackageValues();
  public static final AEResInfo[] values;
  public final String description;
  public final int index;
  public final boolean isPackage;
  public boolean isPredownload = true;
  public final String resPrefix;
  public final int resVersion;
  public final int resVersionLimit;
  
  static
  {
    AE_RES_BASE_PACKAGE = new AEResInfo(0, "AEBasePackage", "new_qq_android_native_short_filter_", 84801, 848);
    AE_RES_ADDITIONAL_PACKAGE = new AEResInfo(1, "AEAdditionalPackage", "new_qq_android_native_ptu_res_", 84801, 848);
    values = new AEResInfo[] { AE_RES_CONFIG, AE_RES_BASE_PACKAGE, AE_RES_ADDITIONAL_PACKAGE };
  }
  
  private AEResInfo(int paramInt, String paramString)
  {
    this.index = paramInt;
    this.description = paramString;
    this.resPrefix = null;
    this.resVersionLimit = -1;
    this.resVersion = -1;
    this.isPackage = false;
  }
  
  private AEResInfo(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    this.index = paramInt1;
    this.description = paramString1;
    this.resPrefix = paramString2;
    this.resVersionLimit = paramInt2;
    this.resVersion = paramInt3;
    this.isPackage = true;
  }
  
  private static AEResInfo[] initPackageValues()
  {
    LinkedList localLinkedList = new LinkedList();
    AEResInfo[] arrayOfAEResInfo = values;
    int j = arrayOfAEResInfo.length;
    int i = 0;
    while (i < j)
    {
      AEResInfo localAEResInfo = arrayOfAEResInfo[i];
      if (localAEResInfo.isPackage) {
        localLinkedList.add(localAEResInfo);
      }
      i += 1;
    }
    return (AEResInfo[])localLinkedList.toArray(new AEResInfo[0]);
  }
  
  @NonNull
  public String toString()
  {
    return "{index:" + this.index + ", description:" + this.description + ", resPrefix:" + this.resPrefix + ", resVersionLimit:" + this.resVersionLimit + ", resVersion:" + this.resVersion + ", isPackage:" + this.isPackage + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.download.AEResInfo
 * JD-Core Version:    0.7.0.1
 */