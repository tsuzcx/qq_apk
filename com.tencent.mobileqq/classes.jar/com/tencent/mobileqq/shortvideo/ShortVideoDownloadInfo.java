package com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;

public class ShortVideoDownloadInfo
  extends ShortVideoBaseInfo
{
  public long b;
  public boolean b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public String h;
  public String i;
  
  public ShortVideoDownloadInfo()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nShortVideoDownloadInfo");
    localStringBuilder.append("\n |-");
    localStringBuilder.append("md5:");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("uuid:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fileType:");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("format:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("mRequestType:");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("mSceneType:");
    localStringBuilder.append(this.g);
    return localStringBuilder.toString();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      if ((paramInt1 != 0) && (paramInt1 != 1008))
      {
        if (paramInt1 == 3000)
        {
          this.jdField_e_of_type_Int = 1005;
          return;
        }
        if (paramInt1 == 1) {
          this.jdField_e_of_type_Int = 1003;
        }
      }
      else
      {
        this.jdField_e_of_type_Int = 1001;
      }
    }
    else if (1 == paramInt2) {
      if ((paramInt1 != 0) && (paramInt1 != 1008))
      {
        if (paramInt1 == 3000)
        {
          this.jdField_e_of_type_Int = 1006;
          return;
        }
        if (paramInt1 == 1) {
          this.jdField_e_of_type_Int = 1004;
        }
      }
      else
      {
        this.jdField_e_of_type_Int = 1002;
      }
    }
  }
  
  public boolean a()
  {
    StringBuilder localStringBuilder;
    if (TextUtils.isEmpty(this.a))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("uuid invaid:");
      localStringBuilder.append(this.a);
      a("ShortVideoDownloadInfo.check", localStringBuilder.toString());
      return false;
    }
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("selfUin invalid,selfUin:");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      a("ShortVideoDownloadInfo", localStringBuilder.toString());
      return false;
    }
    return super.a();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo
 * JD-Core Version:    0.7.0.1
 */