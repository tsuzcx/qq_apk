package com.tencent.mobileqq.pic;

import android.text.TextUtils;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import java.net.URL;

public class PicDownloadInfo
  extends PicBaseInfo
{
  public ReportInfo a;
  public long b;
  public boolean b;
  public long c;
  public boolean c;
  public long d;
  public boolean d;
  public int e;
  public long e;
  public int f;
  public int g;
  public String g;
  public int h;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  
  public PicDownloadInfo()
  {
    this.jdField_d_of_type_Boolean = false;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicDownloadInfo");
    localStringBuilder.append("\n |-");
    localStringBuilder.append("md5:");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("uuid:");
    localStringBuilder.append(this.jdField_g_of_type_JavaLangString);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("groupFileID:");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("uinType:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("subMsgId:");
    localStringBuilder.append(this.jdField_g_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("subVersion:");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("protocol:");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fileSizeFlag:");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("thumbMsgUrl:");
    localStringBuilder.append(this.h);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("bigthumbMsgUrl:");
    localStringBuilder.append(this.k);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("bigMsgUrl:");
    localStringBuilder.append(this.i);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("rawMsgUrl:");
    localStringBuilder.append(this.j);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("isMixed:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("shareAppID:");
    localStringBuilder.append(this.jdField_e_of_type_Long);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("action:");
    localStringBuilder.append(this.l);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("actMsgContentValue:");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("picExtraFlag:");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("picExtraObject:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangObject);
    return localStringBuilder.toString();
  }
  
  public boolean a()
  {
    StringBuilder localStringBuilder;
    if (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("uuid invaid:");
      localStringBuilder.append(this.jdField_g_of_type_JavaLangString);
      a("PicDownloadInfo.check", localStringBuilder.toString());
      return false;
    }
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("selfUin invalid,selfUin:");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      a("checkPicInfo", localStringBuilder.toString());
      return false;
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_e_of_type_Long == 0L))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("groupFileID invaid:");
      localStringBuilder.append(this.jdField_e_of_type_Long);
      a("PicDownloadInfo.check", localStringBuilder.toString());
      return false;
    }
    return super.a();
  }
  
  String b()
  {
    boolean bool = "chatthumb".equals(this.jdField_e_of_type_JavaLangString);
    int n = 65537;
    if (!bool) {
      if ("chatimg".equals(this.jdField_e_of_type_JavaLangString)) {
        n = 1;
      } else if ("chatraw".equals(this.jdField_e_of_type_JavaLangString)) {
        n = 131075;
      }
    }
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = new PicUploadInfo();
      ((PicUploadInfo)localObject).jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      ((PicUploadInfo)localObject).jdField_d_of_type_Int = this.jdField_d_of_type_Int;
      ((PicUploadInfo)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((PicUploadInfo)localObject).f = this.f;
      localObject = ((IPicHelper)QRoute.api(IPicHelper.class)).getURL((PicUploadInfo)localObject, n, null);
      if (localObject != null) {
        return ((URL)localObject).toString();
      }
    }
    else
    {
      localObject = ((IPicHelper)QRoute.api(IPicHelper.class)).getURL(this, n, null);
      if (localObject != null) {
        return ((URL)localObject).toString();
      }
    }
    return null;
  }
  
  public String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append("_dp");
    return localStringBuilder.toString();
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
 * Qualified Name:     com.tencent.mobileqq.pic.PicDownloadInfo
 * JD-Core Version:    0.7.0.1
 */