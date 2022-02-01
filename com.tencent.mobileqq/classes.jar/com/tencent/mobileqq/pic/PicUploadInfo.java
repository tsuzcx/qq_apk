package com.tencent.mobileqq.pic;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.incompatiblephoto.PhotoIncompatibleBase;
import com.tencent.mobileqq.activity.photo.incompatiblephoto.PhotoIncompatibleBaseDecorator;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pic.operator.AioQuickSendPicOperator.QuickSendObject;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
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
  public AioQuickSendPicOperator.QuickSendObject a;
  public ArrayList<Integer> a;
  public long b;
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
    if (this.jdField_g_of_type_Int != -1) {
      return this.jdField_g_of_type_Int;
    }
    if (this.jdField_g_of_type_JavaLangString != null)
    {
      if (GifDrawable.isGifFile(new File(this.jdField_g_of_type_JavaLangString)))
      {
        this.jdField_g_of_type_Int = 0;
        return this.jdField_g_of_type_Int;
      }
    }
    else {
      Logger.b("PIC_TAG_ERROR", "PicUploadInfo.getProtocolType", "localPath == null");
    }
    if (this.jdField_h_of_type_Int == 2) {}
    for (this.jdField_g_of_type_Int = 1;; this.jdField_g_of_type_Int = 0) {
      return this.jdField_g_of_type_Int;
    }
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicUploadInfo");
    localStringBuilder.append("\n |-").append("localPath:").append(this.jdField_g_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("protocolType:").append(this.jdField_g_of_type_Int);
    localStringBuilder.append("\n |-").append("md5:").append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("sendSizeSpec:").append(this.jdField_h_of_type_Int);
    localStringBuilder.append("\n |-").append("thumbPath:").append(this.jdField_h_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("thumbWidth:").append(this.jdField_e_of_type_Int);
    localStringBuilder.append("\n |-").append("thumbHeight:").append(this.jdField_f_of_type_Int);
    localStringBuilder.append("\n |-").append("source_image_width:").append(this.j);
    localStringBuilder.append("\n |-").append("source_image_height:").append(this.k);
    localStringBuilder.append("\n |-").append("source_image_filesize:").append(this.jdField_c_of_type_Long);
    localStringBuilder.append("\n |-").append("source_image_filesizeflag:").append(this.l);
    localStringBuilder.append("\n |-").append("source_image_type:").append(this.m);
    localStringBuilder.append("\n |-").append("entrance:").append(this.n);
    return localStringBuilder.toString();
  }
  
  public boolean a()
  {
    int i1 = 1;
    if (this.jdField_h_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5)) || (!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.thumbPath)))
      {
        StringBuilder localStringBuilder = new StringBuilder().append("qzone md5 invalid, md5:");
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams != null) {}
        for (localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5;; localObject = "")
        {
          a("checkPicInfo", (String)localObject);
          return false;
        }
      }
      if (((this.jdField_b_of_type_Int == 1000) || (this.jdField_b_of_type_Int == 1020) || (this.jdField_b_of_type_Int == 1004)) && (this.jdField_d_of_type_JavaLangString == null))
      {
        a("checkPicInfo", "secondId invalid,uinType:" + this.jdField_b_of_type_Int + ",secondId:" + this.jdField_d_of_type_JavaLangString);
        return false;
      }
      if (a() == -1)
      {
        a("PicBaseInfo.check", "protocolType invalid,protocolType:" + this.jdField_g_of_type_Int);
        return false;
      }
      return super.a();
    }
    if (!FileUtils.b(this.jdField_g_of_type_JavaLangString))
    {
      a("checkPicInfo", "path invalid,localPath:" + this.jdField_g_of_type_JavaLangString);
      return false;
    }
    if (((this.jdField_b_of_type_Int == 1000) || (this.jdField_b_of_type_Int == 1020) || (this.jdField_b_of_type_Int == 1004)) && (this.jdField_d_of_type_JavaLangString == null))
    {
      a("checkPicInfo", "secondId invalid,uinType:" + this.jdField_b_of_type_Int + ",secondId:" + this.jdField_d_of_type_JavaLangString);
      return false;
    }
    if (a() == -1)
    {
      a("PicBaseInfo.check", "protocolType invalid,protocolType:" + this.jdField_g_of_type_Int);
      return false;
    }
    Object localObject = PhotoIncompatibleBase.a(this.jdField_g_of_type_JavaLangString);
    if (localObject != null)
    {
      localObject = new PhotoIncompatibleBaseDecorator((PhotoIncompatibleBase)localObject);
      if (this.jdField_g_of_type_Int == 1)
      {
        localObject = ((PhotoIncompatibleBaseDecorator)localObject).a();
        if (localObject != null) {
          this.jdField_g_of_type_JavaLangString = ((String)localObject);
        }
      }
      while (i1 == 0)
      {
        ThreadManagerV2.getUIHandlerV2().post(new PicUploadInfo.1(this));
        return false;
        a("PicBaseInfo.check", "incompatible photo generate jpg fail");
        for (;;)
        {
          i1 = 0;
          break;
          if (this.jdField_a_of_type_Int != 1006) {
            break label486;
          }
          localObject = ((PhotoIncompatibleBaseDecorator)localObject).a();
          if (localObject != null)
          {
            this.jdField_g_of_type_JavaLangString = ((String)localObject);
            break;
          }
          a("PicBaseInfo.check", "incompatible photo generate jpg fail");
        }
        label486:
        a("PicBaseInfo.check", "incompatible file,and not PROTOCOL_RAW_PIC:" + this.jdField_g_of_type_Int);
        i1 = 0;
      }
    }
    return super.a();
  }
  
  String b()
  {
    int i1 = 65537;
    if (this.jdField_e_of_type_JavaLangString == null)
    {
      Logger.b("PIC_TAG_ERROR", "PicUploadInfo.getUrlString", "protocol == null");
      return null;
    }
    if ("chatthumb".equals(this.jdField_e_of_type_JavaLangString)) {}
    for (;;)
    {
      URL localURL = URLDrawableHelper.getURL(this, i1, null);
      if (localURL == null) {
        break;
      }
      return localURL.toString();
      if ("chatimg".equals(this.jdField_e_of_type_JavaLangString)) {
        i1 = 1;
      } else if ("chatraw".equals(this.jdField_e_of_type_JavaLangString)) {
        i1 = 131075;
      }
    }
    return null;
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra != null) && (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra.a);
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra != null) && (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra.jdField_b_of_type_Boolean);
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra != null) && (this.jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra.jdField_c_of_type_Boolean);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicUploadInfo
 * JD-Core Version:    0.7.0.1
 */