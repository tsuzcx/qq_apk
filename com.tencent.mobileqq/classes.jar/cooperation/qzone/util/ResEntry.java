package cooperation.qzone.util;

import java.lang.ref.WeakReference;

public class ResEntry
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static int jdField_b_of_type_Int;
  private static ResEntry jdField_b_of_type_CooperationQzoneUtilResEntry;
  public int a;
  private ResEntry jdField_a_of_type_CooperationQzoneUtilResEntry;
  public String a;
  public WeakReference a;
  public String b;
  public String c;
  public String d;
  
  public ResEntry(int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = (paramInt + " " + paramString);
  }
  
  public static ResEntry a(int paramInt, String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_CooperationQzoneUtilResEntry != null)
      {
        ResEntry localResEntry = jdField_b_of_type_CooperationQzoneUtilResEntry;
        jdField_b_of_type_CooperationQzoneUtilResEntry = localResEntry.jdField_a_of_type_CooperationQzoneUtilResEntry;
        localResEntry.jdField_a_of_type_CooperationQzoneUtilResEntry = null;
        localResEntry.jdField_a_of_type_JavaLangString = (paramInt + " " + paramString);
        localResEntry.jdField_a_of_type_Int = paramInt;
        jdField_b_of_type_Int -= 1;
        return localResEntry;
      }
      return new ResEntry(paramInt, paramString);
    }
  }
  
  private void b()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.c = null;
    this.d = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public void a()
  {
    b();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Int < 100)
      {
        this.jdField_a_of_type_CooperationQzoneUtilResEntry = jdField_b_of_type_CooperationQzoneUtilResEntry;
        jdField_b_of_type_CooperationQzoneUtilResEntry = this;
        jdField_b_of_type_Int += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.ResEntry
 * JD-Core Version:    0.7.0.1
 */