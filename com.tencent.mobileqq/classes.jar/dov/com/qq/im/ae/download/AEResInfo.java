package dov.com.qq.im.ae.download;

import android.support.annotation.NonNull;
import java.util.LinkedList;
import java.util.List;

public class AEResInfo
{
  public static final AEResInfo a;
  public static final AEResInfo[] a;
  public static final AEResInfo b;
  public static final AEResInfo[] b;
  public static final AEResInfo c;
  public static final AEResInfo d;
  public static final AEResInfo e;
  public static final AEResInfo f;
  public static final AEResInfo g;
  public static final AEResInfo h;
  public static final AEResInfo i;
  public static final AEResInfo j;
  public static final AEResInfo k;
  public static final AEResInfo l;
  @Deprecated
  public static final AEResInfo m;
  public final int a;
  public final String a;
  public final boolean a;
  public final int b;
  public final String b;
  public boolean b;
  public final int c;
  public String c;
  
  static
  {
    jdField_a_of_type_DovComQqImAeDownloadAEResInfo = new AEResInfo(-1, "718Config");
    jdField_b_of_type_DovComQqImAeDownloadAEResInfo = new AEResInfo(0, "AEBasePackage", "new_qq_android_native_short_filter_", "");
    jdField_c_of_type_DovComQqImAeDownloadAEResInfo = new AEResInfo(1, "LightBasePackage", "new_qq_android_native_light_base_", "");
    d = new AEResInfo(2, "LightBundleHand", "new_qq_android_native_light_bundle_hand_", "HAND_AGENT");
    e = new AEResInfo(3, "LightBundleGender", "new_qq_android_native_light_bundle_gender_", "GENDER_AGENT");
    f = new AEResInfo(4, "LightBundleCat", "new_qq_android_native_light_bundle_cat_", "CAT_AGENT");
    g = new AEResInfo(5, "LightBundleDepth", "new_qq_android_native_light_bundle_depth_", "DEPTH_AGENT");
    h = new AEResInfo(6, "LightBundleSegHair", "new_qq_android_native_light_bundle_seg_hair_", "HAIR_SEG_AGENT");
    i = new AEResInfo(7, "LightBundleSegSky", "new_qq_android_native_light_bundle_seg_sky_", "SKY_SEG_AGENT");
    j = new AEResInfo(8, "LightBundleAce3D", "new_qq_android_native_light_bundle_ace3d_", "Ace_3d_Engine");
    k = new AEResInfo(9, "LightBundle3DMM", "new_qq_android_native_light_bundle_3dmm_", "k3D_MM_AGENT");
    l = new AEResInfo(10, "LightBundleSegHead", "new_qq_android_native_light_bundle_seg_head_", "HEAD_SEG_AGENT");
    m = new AEResInfo(-999, "AEAdditionalPackage", "new_qq_android_native_ptu_res_", "");
    jdField_a_of_type_ArrayOfDovComQqImAeDownloadAEResInfo = new AEResInfo[] { jdField_a_of_type_DovComQqImAeDownloadAEResInfo, jdField_b_of_type_DovComQqImAeDownloadAEResInfo, jdField_c_of_type_DovComQqImAeDownloadAEResInfo, d, e, f, g, h, i, j, k, l };
    jdField_b_of_type_ArrayOfDovComQqImAeDownloadAEResInfo = a();
  }
  
  private AEResInfo(int paramInt, String paramString)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private AEResInfo(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_b_of_type_Int = 855014;
    this.jdField_c_of_type_Int = 8550;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static AEResInfo a(String paramString)
  {
    AEResInfo[] arrayOfAEResInfo = jdField_b_of_type_ArrayOfDovComQqImAeDownloadAEResInfo;
    int i1 = arrayOfAEResInfo.length;
    int n = 0;
    while (n < i1)
    {
      AEResInfo localAEResInfo = arrayOfAEResInfo[n];
      if (paramString.equalsIgnoreCase(localAEResInfo.jdField_b_of_type_JavaLangString)) {
        return localAEResInfo;
      }
      n += 1;
    }
    return null;
  }
  
  public static boolean a(AEResInfo paramAEResInfo)
  {
    return (paramAEResInfo != null) && (paramAEResInfo.jdField_a_of_type_Int > 1);
  }
  
  private static AEResInfo[] a()
  {
    LinkedList localLinkedList = new LinkedList();
    AEResInfo[] arrayOfAEResInfo = jdField_a_of_type_ArrayOfDovComQqImAeDownloadAEResInfo;
    int i1 = arrayOfAEResInfo.length;
    int n = 0;
    while (n < i1)
    {
      AEResInfo localAEResInfo = arrayOfAEResInfo[n];
      if (localAEResInfo.jdField_a_of_type_Boolean) {
        localLinkedList.add(localAEResInfo);
      }
      n += 1;
    }
    return (AEResInfo[])localLinkedList.toArray(new AEResInfo[0]);
  }
  
  @NonNull
  public String toString()
  {
    return "{index:" + this.jdField_a_of_type_Int + ", description:" + this.jdField_a_of_type_JavaLangString + ", resPrefix:" + this.jdField_b_of_type_JavaLangString + ", resVersionLimit:" + this.jdField_b_of_type_Int + ", resVersion:" + this.jdField_c_of_type_Int + ", isPackage:" + this.jdField_a_of_type_Boolean + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.AEResInfo
 * JD-Core Version:    0.7.0.1
 */