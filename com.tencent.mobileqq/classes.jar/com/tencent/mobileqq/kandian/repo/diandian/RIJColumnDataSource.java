package com.tencent.mobileqq.kandian.repo.diandian;

import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.EntranceDownloadInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.UrlJumpInfo;

public class RIJColumnDataSource
  implements IEntranceButtonDataSource
{
  public static int b = 1;
  public static int c = 2;
  public static String f = "bytes_entrance_cookie_column";
  public static String g = "https://qqpublic.qpic.cn/qq_public/0/0-2283487770-A0052D97C9C360192F1BE92BCD8ADD16/0";
  public static String h = "https://qqpublic.qpic.cn/qq_public/0/0-2261262125-4438F0FD2808B0A8EA5C1AA0FD97295A/0";
  public int a;
  public UrlJumpInfo a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  private String a(PBBytesField paramPBBytesField)
  {
    if ((paramPBBytesField.has()) && (paramPBBytesField.get() != null)) {
      return paramPBBytesField.get().toStringUtf8();
    }
    return null;
  }
  
  public UrlJumpInfo a(oidb_0x6cf.UrlJumpInfo paramUrlJumpInfo)
  {
    if ((paramUrlJumpInfo != null) && (paramUrlJumpInfo.has()) && (paramUrlJumpInfo.get() != null))
    {
      UrlJumpInfo localUrlJumpInfo = new UrlJumpInfo();
      int i;
      if (paramUrlJumpInfo.uint32_jump_type.has()) {
        i = paramUrlJumpInfo.uint32_jump_type.get();
      } else {
        i = 0;
      }
      localUrlJumpInfo.jdField_a_of_type_Int = i;
      localUrlJumpInfo.c = a(paramUrlJumpInfo.bytes_jump_schema);
      localUrlJumpInfo.b = a(paramUrlJumpInfo.bytes_jump_bundle);
      localUrlJumpInfo.jdField_a_of_type_JavaLangString = a(paramUrlJumpInfo.bytes_jump_url);
      localUrlJumpInfo.d = a(paramUrlJumpInfo.bytes_clipboard_info);
      localUrlJumpInfo.e = a(paramUrlJumpInfo.bytes_common_data);
      return localUrlJumpInfo;
    }
    return null;
  }
  
  public String a()
  {
    return "";
  }
  
  public void a(String paramString) {}
  
  public void a(oidb_0x6cf.EntranceDownloadInfo paramEntranceDownloadInfo)
  {
    if (paramEntranceDownloadInfo == null) {
      return;
    }
    if (paramEntranceDownloadInfo.bytes_column_name.has()) {
      this.jdField_a_of_type_JavaLangString = paramEntranceDownloadInfo.bytes_column_name.get().toStringUtf8();
    }
    if (paramEntranceDownloadInfo.bytes_sub_text.has()) {
      this.b = paramEntranceDownloadInfo.bytes_sub_text.get().toStringUtf8();
    }
    if (paramEntranceDownloadInfo.bytes_icon_url.has()) {
      this.c = paramEntranceDownloadInfo.bytes_icon_url.get().toStringUtf8();
    }
    if (paramEntranceDownloadInfo.msg_url_jump_info.has()) {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = a(paramEntranceDownloadInfo.msg_url_jump_info);
    }
    if (paramEntranceDownloadInfo.uint32_column_id.has()) {
      this.jdField_a_of_type_Int = paramEntranceDownloadInfo.uint32_column_id.get();
    }
    if (paramEntranceDownloadInfo.bytes_entrance_cookie.has()) {
      RIJSPUtils.a(f, paramEntranceDownloadInfo.bytes_entrance_cookie.get().toStringUtf8());
    }
    if (paramEntranceDownloadInfo.bytes_rowkey.has()) {
      this.d = paramEntranceDownloadInfo.bytes_rowkey.get().toStringUtf8();
    }
    paramEntranceDownloadInfo = new StringBuilder();
    paramEntranceDownloadInfo.append("parseRsp data=");
    paramEntranceDownloadInfo.append(toString());
    QLog.d("RIJColumnDataSource", 1, paramEntranceDownloadInfo.toString());
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public String c()
  {
    return null;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RIJColumnDataSource{title='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", subTitle='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", coverURL='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo);
    localStringBuilder.append(", columnID=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", rowkey='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", reportInfo='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.diandian.RIJColumnDataSource
 * JD-Core Version:    0.7.0.1
 */