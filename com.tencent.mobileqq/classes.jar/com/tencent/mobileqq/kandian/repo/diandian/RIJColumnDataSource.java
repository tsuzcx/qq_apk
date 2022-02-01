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
  public static String h = "bytes_entrance_cookie_column";
  public static String i = "https://qqpublic.qpic.cn/qq_public/0/0-2283487770-A0052D97C9C360192F1BE92BCD8ADD16/0";
  public static String j = "https://qqpublic.qpic.cn/qq_public/0/0-2261262125-4438F0FD2808B0A8EA5C1AA0FD97295A/0";
  public static int k = 1;
  public static int l = 2;
  public String a;
  public String b;
  public String c;
  public UrlJumpInfo d;
  public int e;
  public String f;
  public String g;
  
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
      int m;
      if (paramUrlJumpInfo.uint32_jump_type.has()) {
        m = paramUrlJumpInfo.uint32_jump_type.get();
      } else {
        m = 0;
      }
      localUrlJumpInfo.a = m;
      localUrlJumpInfo.d = a(paramUrlJumpInfo.bytes_jump_schema);
      localUrlJumpInfo.c = a(paramUrlJumpInfo.bytes_jump_bundle);
      localUrlJumpInfo.b = a(paramUrlJumpInfo.bytes_jump_url);
      localUrlJumpInfo.e = a(paramUrlJumpInfo.bytes_clipboard_info);
      localUrlJumpInfo.f = a(paramUrlJumpInfo.bytes_common_data);
      return localUrlJumpInfo;
    }
    return null;
  }
  
  public void a(String paramString) {}
  
  public void a(oidb_0x6cf.EntranceDownloadInfo paramEntranceDownloadInfo)
  {
    if (paramEntranceDownloadInfo == null) {
      return;
    }
    if (paramEntranceDownloadInfo.bytes_column_name.has()) {
      this.a = paramEntranceDownloadInfo.bytes_column_name.get().toStringUtf8();
    }
    if (paramEntranceDownloadInfo.bytes_sub_text.has()) {
      this.b = paramEntranceDownloadInfo.bytes_sub_text.get().toStringUtf8();
    }
    if (paramEntranceDownloadInfo.bytes_icon_url.has()) {
      this.c = paramEntranceDownloadInfo.bytes_icon_url.get().toStringUtf8();
    }
    if (paramEntranceDownloadInfo.msg_url_jump_info.has()) {
      this.d = a(paramEntranceDownloadInfo.msg_url_jump_info);
    }
    if (paramEntranceDownloadInfo.uint32_column_id.has()) {
      this.e = paramEntranceDownloadInfo.uint32_column_id.get();
    }
    if (paramEntranceDownloadInfo.bytes_entrance_cookie.has()) {
      RIJSPUtils.a(h, paramEntranceDownloadInfo.bytes_entrance_cookie.get().toStringUtf8());
    }
    if (paramEntranceDownloadInfo.bytes_rowkey.has()) {
      this.f = paramEntranceDownloadInfo.bytes_rowkey.get().toStringUtf8();
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
    return "";
  }
  
  public boolean c()
  {
    return true;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public boolean e()
  {
    return false;
  }
  
  public String f()
  {
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RIJColumnDataSource{title='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", subTitle='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", coverURL='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpInfo=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", columnID=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", rowkey='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", reportInfo='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.diandian.RIJColumnDataSource
 * JD-Core Version:    0.7.0.1
 */