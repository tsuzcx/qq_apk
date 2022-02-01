package com.tencent.mobileqq.pic;

import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class PicUploadInfo
  extends PicBaseInfo
{
  public PhotoSendParams a;
  public PicUploadExtra a;
  public PicUploadInfo.RetryInfo a;
  public ArrayList<Integer> a;
  public long b;
  public Object b;
  public boolean b;
  public long c;
  public boolean c;
  public long d;
  public boolean d;
  public int e;
  public long e;
  public boolean e;
  public int f;
  public long f;
  public boolean f;
  public int g;
  public long g;
  public String g;
  public boolean g;
  public int h;
  public String h;
  public boolean h;
  public int i;
  public String i;
  public boolean i;
  public int j;
  public String j;
  public int k;
  public String k;
  public int l;
  public String l;
  public int m;
  public String m;
  public int n = 0;
  public String n;
  public int o;
  public int p = 0;
  public int q;
  public int r;
  public int s;
  
  public PicUploadInfo()
  {
    this.jdField_g_of_type_Int = -1;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_i_of_type_Int = 0;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
  }
  
  public int a()
  {
    int i1 = this.jdField_g_of_type_Int;
    if (i1 != -1) {
      return i1;
    }
    String str = this.jdField_g_of_type_JavaLangString;
    if (str != null)
    {
      if (GifDrawable.isGifFile(new File(str)))
      {
        this.jdField_g_of_type_Int = 0;
        return this.jdField_g_of_type_Int;
      }
    }
    else {
      Logger.b("PIC_TAG_ERROR", "PicUploadInfo.getProtocolType", "localPath == null");
    }
    if (this.jdField_h_of_type_Int == 2) {
      this.jdField_g_of_type_Int = 1;
    } else {
      this.jdField_g_of_type_Int = 0;
    }
    return this.jdField_g_of_type_Int;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicUploadInfo");
    localStringBuilder.append("\n |-");
    localStringBuilder.append("localPath:");
    localStringBuilder.append(this.jdField_g_of_type_JavaLangString);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("protocolType:");
    localStringBuilder.append(this.jdField_g_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("md5:");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("sendSizeSpec:");
    localStringBuilder.append(this.jdField_h_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("thumbPath:");
    localStringBuilder.append(this.jdField_h_of_type_JavaLangString);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("thumbWidth:");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("thumbHeight:");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("source_image_width:");
    localStringBuilder.append(this.j);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("source_image_height:");
    localStringBuilder.append(this.k);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("source_image_filesize:");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("source_image_filesizeflag:");
    localStringBuilder.append(this.l);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("source_image_type:");
    localStringBuilder.append(this.m);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("entrance:");
    localStringBuilder.append(this.n);
    return localStringBuilder.toString();
  }
  
  public boolean a()
  {
    StringBuilder localStringBuilder;
    if (!FileUtils.fileExistsAndNotEmpty(this.jdField_g_of_type_JavaLangString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("path invalid,localPath:");
      localStringBuilder.append(this.jdField_g_of_type_JavaLangString);
      a("checkPicInfo", localStringBuilder.toString());
      return false;
    }
    if (((this.jdField_b_of_type_Int == 1000) || (this.jdField_b_of_type_Int == 1020) || (this.jdField_b_of_type_Int == 1004)) && (this.jdField_d_of_type_JavaLangString == null))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("secondId invalid,uinType:");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append(",secondId:");
      localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
      a("checkPicInfo", localStringBuilder.toString());
      return false;
    }
    if (a() == -1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("protocolType invalid,protocolType:");
      localStringBuilder.append(this.jdField_g_of_type_Int);
      a("PicBaseInfo.check", localStringBuilder.toString());
      return false;
    }
    return super.a();
  }
  
  String b()
  {
    if (this.jdField_e_of_type_JavaLangString == null)
    {
      Logger.b("PIC_TAG_ERROR", "PicUploadInfo.getUrlString", "protocol == null");
      return null;
    }
    boolean bool = "chatthumb".equals(this.jdField_e_of_type_JavaLangString);
    int i1 = 65537;
    if (!bool) {
      if ("chatimg".equals(this.jdField_e_of_type_JavaLangString)) {
        i1 = 1;
      } else if ("chatraw".equals(this.jdField_e_of_type_JavaLangString)) {
        i1 = 131075;
      }
    }
    URL localURL = ((IPicHelper)QRoute.api(IPicHelper.class)).getURL(this, i1, null);
    if (localURL != null) {
      return localURL.toString();
    }
    return null;
  }
  
  public boolean c()
  {
    PicUploadExtra localPicUploadExtra = this.a;
    return (localPicUploadExtra != null) && (localPicUploadExtra.a);
  }
  
  public boolean d()
  {
    PicUploadExtra localPicUploadExtra = this.a;
    return (localPicUploadExtra != null) && (localPicUploadExtra.jdField_b_of_type_Boolean);
  }
  
  public boolean e()
  {
    PicUploadExtra localPicUploadExtra = this.a;
    return (localPicUploadExtra != null) && (localPicUploadExtra.jdField_c_of_type_Boolean);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicUploadInfo
 * JD-Core Version:    0.7.0.1
 */