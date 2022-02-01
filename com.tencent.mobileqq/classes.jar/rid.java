import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.ContentBannerItem;

public class rid
  extends rib
{
  public String f;
  
  public rid(int paramInt)
  {
    super(paramInt);
  }
  
  public static rib b(oidb_cmd0xbc9.BannerItem paramBannerItem)
  {
    if (!paramBannerItem.msg_article_content_item.has()) {
      return null;
    }
    oidb_cmd0xbc9.ContentBannerItem localContentBannerItem = paramBannerItem.msg_article_content_item;
    if (paramBannerItem.uint32_banner_type.has()) {}
    for (rid localrid = new rid(paramBannerItem.uint32_banner_type.get());; localrid = new rid(4))
    {
      if (localContentBannerItem.bytes_image_url.has()) {
        localrid.c = localContentBannerItem.bytes_image_url.get().toStringUtf8();
      }
      if (localContentBannerItem.bytes_link_url.has()) {
        localrid.f = localContentBannerItem.bytes_link_url.get().toStringUtf8();
      }
      if (localContentBannerItem.bytes_rowkey.has()) {
        localrid.e = localContentBannerItem.bytes_rowkey.get().toStringUtf8();
      }
      a(localrid, paramBannerItem);
      a(paramBannerItem, localrid);
      return localrid;
    }
  }
  
  public oidb_cmd0xbc9.BannerItem a()
  {
    oidb_cmd0xbc9.BannerItem localBannerItem = super.a();
    oidb_cmd0xbc9.ContentBannerItem localContentBannerItem = new oidb_cmd0xbc9.ContentBannerItem();
    if (!TextUtils.isEmpty(this.c)) {
      localContentBannerItem.bytes_image_url.set(ByteStringMicro.copyFromUtf8(this.c));
    }
    if (!TextUtils.isEmpty(this.f)) {
      localContentBannerItem.bytes_link_url.set(ByteStringMicro.copyFromUtf8(this.f));
    }
    if (!TextUtils.isEmpty(this.e)) {
      localContentBannerItem.bytes_rowkey.set(ByteStringMicro.copyFromUtf8(this.e));
    }
    localBannerItem.msg_article_content_item.set(localContentBannerItem);
    return localBannerItem;
  }
  
  public String toString()
  {
    return " jump: " + this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rid
 * JD-Core Version:    0.7.0.1
 */