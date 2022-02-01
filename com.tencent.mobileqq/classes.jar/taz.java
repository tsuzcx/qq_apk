import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.EntranceDownloadInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.UrlJumpInfo;

public class taz
  implements tay
{
  public static int b;
  public static int c;
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
  
  static
  {
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
  }
  
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
      if (paramUrlJumpInfo.uint32_jump_type.has()) {}
      for (int i = paramUrlJumpInfo.uint32_jump_type.get();; i = 0)
      {
        localUrlJumpInfo.jdField_a_of_type_Int = i;
        localUrlJumpInfo.jdField_c_of_type_JavaLangString = a(paramUrlJumpInfo.bytes_jump_schema);
        localUrlJumpInfo.jdField_b_of_type_JavaLangString = a(paramUrlJumpInfo.bytes_jump_bundle);
        localUrlJumpInfo.jdField_a_of_type_JavaLangString = a(paramUrlJumpInfo.bytes_jump_url);
        localUrlJumpInfo.d = a(paramUrlJumpInfo.bytes_clipboard_info);
        localUrlJumpInfo.e = a(paramUrlJumpInfo.bytes_common_data);
        return localUrlJumpInfo;
      }
    }
    return null;
  }
  
  public void a(oidb_0x6cf.EntranceDownloadInfo paramEntranceDownloadInfo)
  {
    if (paramEntranceDownloadInfo == null) {
      return;
    }
    if (paramEntranceDownloadInfo.bytes_column_name.has()) {
      this.jdField_a_of_type_JavaLangString = paramEntranceDownloadInfo.bytes_column_name.get().toStringUtf8();
    }
    if (paramEntranceDownloadInfo.bytes_sub_text.has()) {
      this.jdField_b_of_type_JavaLangString = paramEntranceDownloadInfo.bytes_sub_text.get().toStringUtf8();
    }
    if (paramEntranceDownloadInfo.bytes_icon_url.has()) {
      this.jdField_c_of_type_JavaLangString = paramEntranceDownloadInfo.bytes_icon_url.get().toStringUtf8();
    }
    if (paramEntranceDownloadInfo.msg_url_jump_info.has()) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = a(paramEntranceDownloadInfo.msg_url_jump_info);
    }
    if (paramEntranceDownloadInfo.uint32_column_id.has()) {
      this.jdField_a_of_type_Int = paramEntranceDownloadInfo.uint32_column_id.get();
    }
    if (paramEntranceDownloadInfo.bytes_entrance_cookie.has()) {
      bnrf.a(f, paramEntranceDownloadInfo.bytes_entrance_cookie.get().toStringUtf8());
    }
    if (paramEntranceDownloadInfo.bytes_rowkey.has()) {
      this.d = paramEntranceDownloadInfo.bytes_rowkey.get().toStringUtf8();
    }
    QLog.d("RIJColumnDataSource", 1, "parseRsp data=" + toString());
  }
  
  public void b(String paramString) {}
  
  public boolean b()
  {
    return false;
  }
  
  public String c()
  {
    return "";
  }
  
  public boolean c()
  {
    return true;
  }
  
  public String d()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public boolean d()
  {
    return false;
  }
  
  public String e()
  {
    return null;
  }
  
  public String toString()
  {
    return "RIJColumnDataSource{title='" + this.jdField_a_of_type_JavaLangString + '\'' + ", subTitle='" + this.jdField_b_of_type_JavaLangString + '\'' + ", coverURL='" + this.jdField_c_of_type_JavaLangString + '\'' + ", jumpInfo=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo + ", columnID=" + this.jdField_a_of_type_Int + ", rowkey='" + this.d + '\'' + ", reportInfo='" + this.e + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     taz
 * JD-Core Version:    0.7.0.1
 */