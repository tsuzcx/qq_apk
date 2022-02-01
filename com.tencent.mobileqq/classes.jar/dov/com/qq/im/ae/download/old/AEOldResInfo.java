package dov.com.qq.im.ae.download.old;

import android.support.annotation.NonNull;
import java.util.LinkedList;
import java.util.List;

public class AEOldResInfo
{
  public static final AEOldResInfo a;
  public static final AEOldResInfo[] a;
  public static final AEOldResInfo b;
  public static final AEOldResInfo[] b;
  public final int a;
  public final String a;
  public final boolean a;
  public final int b;
  public final String b;
  public boolean b;
  public final int c;
  
  static
  {
    jdField_a_of_type_DovComQqImAeDownloadOldAEOldResInfo = new AEOldResInfo(-1, "215Config");
    jdField_b_of_type_DovComQqImAeDownloadOldAEOldResInfo = new AEOldResInfo(0, "AEBasePackage", "old_qq_android_native_short_filter_", 850003, 8500);
    jdField_a_of_type_ArrayOfDovComQqImAeDownloadOldAEOldResInfo = new AEOldResInfo[] { jdField_a_of_type_DovComQqImAeDownloadOldAEOldResInfo, jdField_b_of_type_DovComQqImAeDownloadOldAEOldResInfo };
    jdField_b_of_type_ArrayOfDovComQqImAeDownloadOldAEOldResInfo = a();
  }
  
  private AEOldResInfo(int paramInt, String paramString)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = -1;
    this.c = -1;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private AEOldResInfo(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private static AEOldResInfo[] a()
  {
    LinkedList localLinkedList = new LinkedList();
    AEOldResInfo[] arrayOfAEOldResInfo = jdField_a_of_type_ArrayOfDovComQqImAeDownloadOldAEOldResInfo;
    int j = arrayOfAEOldResInfo.length;
    int i = 0;
    while (i < j)
    {
      AEOldResInfo localAEOldResInfo = arrayOfAEOldResInfo[i];
      if (localAEOldResInfo.jdField_a_of_type_Boolean) {
        localLinkedList.add(localAEOldResInfo);
      }
      i += 1;
    }
    return (AEOldResInfo[])localLinkedList.toArray(new AEOldResInfo[0]);
  }
  
  @NonNull
  public String toString()
  {
    return "{index:" + this.jdField_a_of_type_Int + ", description:" + this.jdField_a_of_type_JavaLangString + ", resPrefix:" + this.jdField_b_of_type_JavaLangString + ", resVersionLimit:" + this.jdField_b_of_type_Int + ", resVersion:" + this.c + ", isPackage:" + this.jdField_a_of_type_Boolean + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldResInfo
 * JD-Core Version:    0.7.0.1
 */