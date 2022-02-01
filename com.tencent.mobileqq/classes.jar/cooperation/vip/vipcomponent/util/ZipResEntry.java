package cooperation.vip.vipcomponent.util;

import java.lang.ref.WeakReference;

public class ZipResEntry
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static int jdField_b_of_type_Int = 0;
  private static ZipResEntry jdField_b_of_type_CooperationVipVipcomponentUtilZipResEntry;
  public int a;
  private ZipResEntry jdField_a_of_type_CooperationVipVipcomponentUtilZipResEntry;
  public String a;
  public WeakReference<ZipResLoadListener> a;
  public String b;
  public String c;
  public String d;
  
  public ZipResEntry(String paramString1, int paramInt, String paramString2, WeakReference<ZipResLoadListener> paramWeakReference)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    paramString1 = new StringBuilder();
    paramString1.append(this.jdField_b_of_type_JavaLangString);
    paramString1.append(" ");
    paramString1.append(paramString2);
    this.jdField_a_of_type_JavaLangString = paramString1.toString();
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  public static ZipResEntry a(String paramString1, int paramInt, String paramString2, WeakReference<ZipResLoadListener> paramWeakReference)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_CooperationVipVipcomponentUtilZipResEntry != null)
      {
        ZipResEntry localZipResEntry = jdField_b_of_type_CooperationVipVipcomponentUtilZipResEntry;
        jdField_b_of_type_CooperationVipVipcomponentUtilZipResEntry = localZipResEntry.jdField_a_of_type_CooperationVipVipcomponentUtilZipResEntry;
        localZipResEntry.jdField_a_of_type_CooperationVipVipcomponentUtilZipResEntry = null;
        localZipResEntry.jdField_b_of_type_JavaLangString = paramString1;
        localZipResEntry.d = paramString2;
        localZipResEntry.jdField_a_of_type_Int = paramInt;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramString2);
        localZipResEntry.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
        localZipResEntry.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
        jdField_b_of_type_Int -= 1;
        return localZipResEntry;
      }
      return new ZipResEntry(paramString1, paramInt, paramString2, paramWeakReference);
    }
  }
  
  private void b()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.c = null;
    this.d = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public void a()
  {
    b();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Int < 100)
      {
        this.jdField_a_of_type_CooperationVipVipcomponentUtilZipResEntry = jdField_b_of_type_CooperationVipVipcomponentUtilZipResEntry;
        jdField_b_of_type_CooperationVipVipcomponentUtilZipResEntry = this;
        jdField_b_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.vipcomponent.util.ZipResEntry
 * JD-Core Version:    0.7.0.1
 */