package com.tencent.mobileqq.nearby.now.send.uploader;

import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class VideoFeedsUploader$UploadInfo
{
  public int a;
  public long a;
  public LocationInfo a;
  public String a;
  public List a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public int d;
  public long d;
  public String d;
  public int e;
  public long e;
  public String e;
  public int f;
  public long f;
  public String f;
  public int g;
  public long g;
  public String g;
  public int h;
  public long h;
  public String h;
  public long i;
  public String i;
  public long j;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  
  public VideoFeedsUploader$UploadInfo()
  {
    this.jdField_b_of_type_Int = 2;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_e_of_type_Int = 3;
    a();
  }
  
  public VideoFeedsUploader$UploadInfo(UploadInfo paramUploadInfo)
  {
    this.jdField_b_of_type_Int = 2;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_e_of_type_Int = 3;
    if (paramUploadInfo == null) {
      a();
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilList = paramUploadInfo.jdField_a_of_type_JavaUtilList;
      this.jdField_c_of_type_Long = paramUploadInfo.jdField_c_of_type_Long;
      this.jdField_j_of_type_Long = paramUploadInfo.jdField_j_of_type_Long;
      String str;
      if (paramUploadInfo.jdField_c_of_type_JavaLangString == null)
      {
        str = "";
        label74:
        this.jdField_c_of_type_JavaLangString = new String(str);
        this.jdField_f_of_type_Long = paramUploadInfo.jdField_f_of_type_Long;
        this.jdField_b_of_type_Long = paramUploadInfo.jdField_b_of_type_Long;
        this.jdField_g_of_type_Long = paramUploadInfo.jdField_g_of_type_Long;
        this.jdField_h_of_type_Long = paramUploadInfo.jdField_h_of_type_Long;
        if (paramUploadInfo.jdField_d_of_type_JavaLangString != null) {
          break label584;
        }
        str = "";
        label128:
        this.jdField_d_of_type_JavaLangString = new String(str);
        if (paramUploadInfo.jdField_e_of_type_JavaLangString != null) {
          break label592;
        }
        str = "";
        label150:
        this.jdField_e_of_type_JavaLangString = new String(str);
        if (paramUploadInfo.jdField_f_of_type_JavaLangString != null) {
          break label600;
        }
        str = "";
        label172:
        this.jdField_f_of_type_JavaLangString = new String(str);
        if (paramUploadInfo.o != null) {
          break label608;
        }
        str = "";
        label194:
        this.o = new String(str);
        if (paramUploadInfo.jdField_g_of_type_JavaLangString != null) {
          break label616;
        }
        str = "";
        label216:
        this.jdField_g_of_type_JavaLangString = new String(str);
        this.jdField_g_of_type_Int = paramUploadInfo.jdField_g_of_type_Int;
        this.jdField_i_of_type_Long = paramUploadInfo.jdField_i_of_type_Long;
        if (paramUploadInfo.k != null) {
          break label624;
        }
        str = "";
        label254:
        this.k = new String(str);
        if (paramUploadInfo.l != null) {
          break label632;
        }
        str = "";
        label276:
        this.l = new String(str);
        if (paramUploadInfo.n != null) {
          break label640;
        }
        str = "";
        label298:
        this.n = new String(str);
        if (paramUploadInfo.m != null) {
          break label648;
        }
        str = "";
        label320:
        this.m = new String(str);
        this.jdField_a_of_type_Long = paramUploadInfo.jdField_a_of_type_Long;
        if (paramUploadInfo.jdField_a_of_type_JavaLangString != null) {
          break label656;
        }
        str = "";
        this.jdField_a_of_type_JavaLangString = new String(str);
        this.jdField_e_of_type_Int = paramUploadInfo.jdField_e_of_type_Int;
        this.jdField_b_of_type_Int = paramUploadInfo.jdField_b_of_type_Int;
        this.jdField_c_of_type_Int = paramUploadInfo.jdField_c_of_type_Int;
        this.jdField_f_of_type_Int = paramUploadInfo.jdField_f_of_type_Int;
        this.jdField_h_of_type_JavaLangString = new String(paramUploadInfo.jdField_h_of_type_JavaLangString);
        this.jdField_i_of_type_JavaLangString = new String(paramUploadInfo.jdField_i_of_type_JavaLangString);
        this.jdField_j_of_type_JavaLangString = new String(paramUploadInfo.jdField_j_of_type_JavaLangString);
      }
      try
      {
        if (paramUploadInfo.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo != null) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = paramUploadInfo.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.clone();
        }
        this.jdField_h_of_type_Int = paramUploadInfo.jdField_h_of_type_Int;
        this.jdField_a_of_type_Int = paramUploadInfo.jdField_a_of_type_Int;
        this.jdField_d_of_type_Long = paramUploadInfo.jdField_d_of_type_Long;
        this.jdField_e_of_type_Long = paramUploadInfo.jdField_e_of_type_Long;
        this.jdField_d_of_type_Int = paramUploadInfo.jdField_d_of_type_Int;
        this.jdField_b_of_type_JavaLangString = paramUploadInfo.jdField_b_of_type_JavaLangString;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("VideoFeedsUploader", 2, "UploadInfo --- lng: " + this.jdField_h_of_type_JavaLangString + ", lat: " + this.jdField_i_of_type_JavaLangString + ", city: " + this.jdField_j_of_type_JavaLangString + ", isLocalVideo: " + this.jdField_f_of_type_Int);
        return;
        str = paramUploadInfo.jdField_c_of_type_JavaLangString;
        break label74;
        label584:
        str = paramUploadInfo.jdField_d_of_type_JavaLangString;
        break label128;
        label592:
        str = paramUploadInfo.jdField_e_of_type_JavaLangString;
        break label150;
        label600:
        str = paramUploadInfo.jdField_f_of_type_JavaLangString;
        break label172;
        label608:
        str = paramUploadInfo.o;
        break label194;
        label616:
        str = paramUploadInfo.jdField_g_of_type_JavaLangString;
        break label216;
        label624:
        str = paramUploadInfo.k;
        break label254;
        label632:
        str = paramUploadInfo.l;
        break label276;
        label640:
        str = paramUploadInfo.n;
        break label298;
        label648:
        str = paramUploadInfo.m;
        break label320;
        label656:
        str = paramUploadInfo.jdField_a_of_type_JavaLangString;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        for (;;)
        {
          localCloneNotSupportedException.printStackTrace();
        }
      }
    }
  }
  
  public String a()
  {
    if (b()) {}
    for (String str = "Retry upload：";; str = "First upload：")
    {
      str = str + "md5=" + this.jdField_c_of_type_JavaLangString;
      str = str + ";mineUin=" + this.jdField_c_of_type_Long;
      str = str + ";anchorUin=" + this.jdField_j_of_type_Long;
      str = str + ";anchorName=" + this.o;
      str = str + ";videoPlayTime=" + this.jdField_f_of_type_Long;
      str = str + ";videoCreatedSeq=" + this.jdField_b_of_type_Long;
      str = str + ";videoWidth=" + this.jdField_g_of_type_Long;
      str = str + ";videoHeight=" + this.jdField_h_of_type_Long;
      str = str + ";videoPath=" + this.jdField_d_of_type_JavaLangString;
      str = str + ";logoPath=" + this.jdField_e_of_type_JavaLangString;
      str = str + ";doodlePicPath=" + this.jdField_f_of_type_JavaLangString;
      str = str + ";mask=" + this.jdField_g_of_type_JavaLangString;
      str = str + ";preStep=" + this.jdField_g_of_type_Int;
      str = str + ";preUploadedLen=" + this.jdField_i_of_type_Long;
      str = str + ";preUploadedFileId=" + this.k;
      str = str + ";preUploadedCoverUrl=" + this.l;
      str = str + ";preUploadedVideoUrl=" + this.n;
      str = str + ";preUploadedDoodleUrl=" + this.m;
      str = str + ";videoStartTime=" + this.jdField_a_of_type_Long;
      str = str + ";videoVid=" + this.jdField_a_of_type_JavaLangString;
      str = str + ";feedType=" + this.jdField_e_of_type_Int;
      str = str + ";isHavePendant=" + this.jdField_b_of_type_Int;
      str = str + ";filterMode=" + this.jdField_c_of_type_Int;
      str = str + ";videoLongitude=" + this.jdField_h_of_type_JavaLangString;
      str = str + ";videoLatitude=" + this.jdField_i_of_type_JavaLangString;
      str = str + ";videoCity=" + this.jdField_j_of_type_JavaLangString;
      str = str + ";videoFacesCount=" + this.jdField_d_of_type_Int;
      return str + ";isLocalVideo=" + this.jdField_f_of_type_Int;
    }
  }
  
  public void a()
  {
    this.jdField_c_of_type_Long = 0L;
    this.jdField_j_of_type_Long = 0L;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.o = "";
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_g_of_type_Int = 0;
    this.jdField_i_of_type_Long = 0L;
    this.jdField_c_of_type_JavaLangString = "";
    this.k = "";
    this.l = "";
    this.n = "";
    this.m = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_e_of_type_Int = 3;
    this.jdField_b_of_type_Int = 2;
    this.jdField_c_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_d_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
  }
  
  public boolean a()
  {
    return (0L == this.jdField_c_of_type_Long) || (0L == this.jdField_j_of_type_Long) || (this.jdField_d_of_type_JavaLangString.isEmpty());
  }
  
  public boolean a(PublishParam paramPublishParam)
  {
    if (paramPublishParam == null) {
      return false;
    }
    a();
    this.jdField_f_of_type_Long = paramPublishParam.jdField_a_of_type_Long;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_g_of_type_Long = paramPublishParam.jdField_a_of_type_Int;
    this.jdField_h_of_type_Long = paramPublishParam.jdField_b_of_type_Int;
    if (this.jdField_g_of_type_Long > this.jdField_h_of_type_Long)
    {
      this.jdField_g_of_type_Long = paramPublishParam.jdField_b_of_type_Int;
      this.jdField_h_of_type_Long = paramPublishParam.jdField_a_of_type_Int;
    }
    this.jdField_f_of_type_Int = paramPublishParam.l;
    this.jdField_d_of_type_JavaLangString = paramPublishParam.jdField_j_of_type_JavaLangString;
    this.jdField_e_of_type_JavaLangString = paramPublishParam.jdField_c_of_type_JavaLangString;
    this.jdField_f_of_type_JavaLangString = paramPublishParam.jdField_d_of_type_JavaLangString;
    this.jdField_e_of_type_Int = 3;
    this.jdField_h_of_type_Int = 0;
    return true;
  }
  
  public boolean b()
  {
    return this.jdField_i_of_type_Long > 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadInfo
 * JD-Core Version:    0.7.0.1
 */