package com.tencent.mobileqq.weiyun.model;

public final class WeiyunDownloadStatusInfo
  implements Cloneable
{
  public volatile int a;
  public long a;
  public DownloadJobContext a;
  public String a;
  public int b;
  public long b;
  public String b;
  public String c = "";
  public String d = "";
  
  public WeiyunDownloadStatusInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public WeiyunDownloadStatusInfo a()
  {
    try
    {
      WeiyunDownloadStatusInfo localWeiyunDownloadStatusInfo = (WeiyunDownloadStatusInfo)super.clone();
      return localWeiyunDownloadStatusInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label10:
      break label10;
    }
    return null;
  }
  
  public boolean a()
  {
    int i = this.jdField_a_of_type_Int;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Int != 5)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Int != 3)
        {
          if (this.jdField_a_of_type_Int == 1)
          {
            i = this.jdField_b_of_type_Int;
            bool1 = bool2;
            if (i == 1810003) {
              return bool1;
            }
            if (i == 1810004) {
              return true;
            }
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  public boolean b()
  {
    int i = this.jdField_a_of_type_Int;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Int != 1)
      {
        if (this.jdField_a_of_type_Int == 2) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      int i = this.jdField_b_of_type_Int;
      if ((i != 1810003) && (i != 1810004)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean d()
  {
    int i = this.jdField_a_of_type_Int;
    boolean bool = true;
    if (i == 1)
    {
      i = this.jdField_b_of_type_Int;
      if (i == 1810003) {
        return bool;
      }
      if (i == 1810004) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.model.WeiyunDownloadStatusInfo
 * JD-Core Version:    0.7.0.1
 */