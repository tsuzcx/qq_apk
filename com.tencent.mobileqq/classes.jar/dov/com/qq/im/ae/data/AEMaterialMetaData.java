package dov.com.qq.im.ae.data;

import android.support.annotation.Nullable;
import dov.com.qq.im.ae.AEPath.CAMERA.FILES;
import java.io.File;

public class AEMaterialMetaData
{
  public static final AEMaterialMetaData a;
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b = false;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public boolean e;
  public int f;
  public String f;
  public boolean f;
  public int g = 0;
  public String g;
  public boolean g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l = "";
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  
  static
  {
    jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData = a();
  }
  
  public AEMaterialMetaData()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
  }
  
  private static AEMaterialMetaData a()
  {
    AEMaterialMetaData localAEMaterialMetaData = new AEMaterialMetaData();
    localAEMaterialMetaData.jdField_a_of_type_JavaLangString = "0";
    localAEMaterialMetaData.jdField_a_of_type_Int = 0;
    return localAEMaterialMetaData;
  }
  
  public static boolean a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData == null) {}
    while ((paramAEMaterialMetaData.jdField_a_of_type_JavaLangString != null) && (!paramAEMaterialMetaData.jdField_a_of_type_JavaLangString.equals("0"))) {
      return false;
    }
    return true;
  }
  
  public static boolean b(@Nullable AEMaterialMetaData paramAEMaterialMetaData)
  {
    return (paramAEMaterialMetaData != null) && ((paramAEMaterialMetaData.g == 0) || (paramAEMaterialMetaData.g == 4) || (paramAEMaterialMetaData.g == 5) || (paramAEMaterialMetaData.g == 6) || (paramAEMaterialMetaData.g == 7));
  }
  
  public int a()
  {
    switch (this.jdField_d_of_type_Int)
    {
    default: 
      return -1;
    case 1: 
      return 2130844717;
    case 2: 
      return 2130844718;
    case 3: 
      return 2130844720;
    }
    return 2130844719;
  }
  
  public String a()
  {
    File localFile = new File(AEPath.CAMERA.FILES.i);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile.getPath(), this.jdField_a_of_type_JavaLangString).getPath() + File.separator;
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (!equals(jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData))
    {
      this.e = paramAEMaterialMetaData.e;
      this.f = paramAEMaterialMetaData.f;
      this.jdField_a_of_type_Boolean = paramAEMaterialMetaData.jdField_a_of_type_Boolean;
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Int == 12;
  }
  
  public String b()
  {
    File localFile = new File(AEPath.CAMERA.FILES.i);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getPath() + File.separator;
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Int != 0;
  }
  
  public String c()
  {
    return new File(AEMaterialManager.c(), this.jdField_a_of_type_JavaLangString).getPath();
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.equals("0"));
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while (!(paramObject instanceof AEMaterialMetaData));
      paramObject = (AEMaterialMetaData)paramObject;
      if ((paramObject.jdField_a_of_type_JavaLangString == null) && (this.jdField_a_of_type_JavaLangString == null)) {
        return true;
      }
    } while (((paramObject.jdField_a_of_type_JavaLangString == null) && (this.jdField_a_of_type_JavaLangString != null)) || ((paramObject.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString == null)));
    return paramObject.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString);
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {}
    for (int i1 = 0;; i1 = this.jdField_a_of_type_JavaLangString.hashCode()) {
      return i1 + 31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.data.AEMaterialMetaData
 * JD-Core Version:    0.7.0.1
 */