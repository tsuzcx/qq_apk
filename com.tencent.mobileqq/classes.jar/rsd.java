import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.MoreChannelItem;

public class rsd
{
  public String a;
  public String b;
  
  public static rsd a(oidb_cmd0xbc9.MoreChannelItem paramMoreChannelItem)
  {
    rsd localrsd = new rsd();
    localrsd.a = paramMoreChannelItem.bytes_title.get().toStringUtf8();
    localrsd.b = paramMoreChannelItem.bytes_link_url.get().toStringUtf8();
    return localrsd;
  }
  
  public oidb_cmd0xbc9.MoreChannelItem a()
  {
    oidb_cmd0xbc9.MoreChannelItem localMoreChannelItem = new oidb_cmd0xbc9.MoreChannelItem();
    if (!TextUtils.isEmpty(this.a))
    {
      localMoreChannelItem.bytes_title.set(ByteStringMicro.copyFromUtf8(this.a));
      localMoreChannelItem.bytes_link_url.set(ByteStringMicro.copyFromUtf8(this.b));
    }
    return localMoreChannelItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rsd
 * JD-Core Version:    0.7.0.1
 */