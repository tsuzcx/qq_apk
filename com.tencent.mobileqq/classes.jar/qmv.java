import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.feeds_info.ShareWebPageInfo;

public class qmv
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public static qmv a(feeds_info.ShareWebPageInfo paramShareWebPageInfo)
  {
    if (paramShareWebPageInfo == null) {
      return null;
    }
    qmv localqmv = new qmv();
    if (paramShareWebPageInfo.bytes_desc.has()) {
      localqmv.e = paramShareWebPageInfo.bytes_desc.get().toStringUtf8();
    }
    if (paramShareWebPageInfo.bytes_pic_url.has()) {
      localqmv.c = paramShareWebPageInfo.bytes_pic_url.get().toStringUtf8();
    }
    if (paramShareWebPageInfo.bytes_title.has()) {
      localqmv.b = paramShareWebPageInfo.bytes_title.get().toStringUtf8();
    }
    if (paramShareWebPageInfo.bytes_source.has()) {
      localqmv.d = paramShareWebPageInfo.bytes_source.get().toStringUtf8();
    }
    if (paramShareWebPageInfo.bytes_web_url.has()) {
      localqmv.a = paramShareWebPageInfo.bytes_web_url.get().toStringUtf8();
    }
    if ((TextUtils.isEmpty(localqmv.d)) || (TextUtils.isEmpty(localqmv.a)))
    {
      QLog.d("SocializeFeedsInfo", 1, "WebSharePageInfo core info is empty!");
      return null;
    }
    return localqmv;
  }
  
  public feeds_info.ShareWebPageInfo a()
  {
    feeds_info.ShareWebPageInfo localShareWebPageInfo = new feeds_info.ShareWebPageInfo();
    if (!TextUtils.isEmpty(this.a)) {
      localShareWebPageInfo.bytes_web_url.set(ByteStringMicro.copyFromUtf8(this.a));
    }
    if (!TextUtils.isEmpty(this.c)) {
      localShareWebPageInfo.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(this.c));
    }
    if (!TextUtils.isEmpty(this.b)) {
      localShareWebPageInfo.bytes_title.set(ByteStringMicro.copyFromUtf8(this.b));
    }
    if (!TextUtils.isEmpty(this.d)) {
      localShareWebPageInfo.bytes_source.set(ByteStringMicro.copyFromUtf8(this.d));
    }
    if (!TextUtils.isEmpty(this.e)) {
      localShareWebPageInfo.bytes_desc.set(ByteStringMicro.copyFromUtf8(this.e));
    }
    return localShareWebPageInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qmv
 * JD-Core Version:    0.7.0.1
 */