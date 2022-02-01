package com.tencent.mobileqq.uniformdownload.core;

import android.os.Bundle;

public class DownloadInfoBuilder
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  
  public static DownloadInfoBuilder a(Bundle paramBundle, String paramString)
  {
    Bundle localBundle2 = paramBundle.getBundle("_user_data");
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null)
    {
      localBundle2 = new Bundle();
      localBundle1 = localBundle2;
      if (paramBundle.containsKey("big_brother_source_key"))
      {
        localBundle2.putString("big_brother_source_key", paramBundle.getString("big_brother_source_key"));
        localBundle1 = localBundle2;
      }
    }
    return new DownloadInfoBuilder().a(paramString).b(paramBundle.getString("_filename_from_dlg")).a(paramBundle.getLong("_filesize_from_dlg")).c(paramBundle.getString("_notify_name_dialog", "")).a(localBundle1).a(-1).a(false);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public DownloadInfoBuilder a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public DownloadInfoBuilder a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public DownloadInfoBuilder a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    return this;
  }
  
  public DownloadInfoBuilder a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public DownloadInfoBuilder a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public DownloadInfoBuilder b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public DownloadInfoBuilder c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public String c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.DownloadInfoBuilder
 * JD-Core Version:    0.7.0.1
 */