import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.articlesummary.articlesummary.HotWordItem;

public class rpi
{
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  
  public static rpi a(articlesummary.HotWordItem paramHotWordItem)
  {
    rpi localrpi = new rpi();
    if (paramHotWordItem.hot_word.has()) {
      localrpi.a = paramHotWordItem.hot_word.get().toStringUtf8();
    }
    if (paramHotWordItem.jump_url.has()) {
      localrpi.b = paramHotWordItem.jump_url.get().toStringUtf8();
    }
    if (paramHotWordItem.index_word_color.has()) {
      localrpi.c = paramHotWordItem.index_word_color.get().toStringUtf8();
    }
    if (paramHotWordItem.index_bg_color.has()) {
      localrpi.d = paramHotWordItem.index_bg_color.get().toStringUtf8();
    }
    return localrpi;
  }
  
  public articlesummary.HotWordItem a()
  {
    articlesummary.HotWordItem localHotWordItem = new articlesummary.HotWordItem();
    if (!TextUtils.isEmpty(this.a)) {
      localHotWordItem.hot_word.set(ByteStringMicro.copyFromUtf8(this.a));
    }
    if (!TextUtils.isEmpty(this.d)) {
      localHotWordItem.index_bg_color.set(ByteStringMicro.copyFromUtf8(this.d));
    }
    if (!TextUtils.isEmpty(this.c)) {
      localHotWordItem.index_word_color.set(ByteStringMicro.copyFromUtf8(this.c));
    }
    if (!TextUtils.isEmpty(this.b)) {
      localHotWordItem.jump_url.set(ByteStringMicro.copyFromUtf8(this.b));
    }
    return localHotWordItem;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof rpi)) {
      return (!TextUtils.isEmpty(this.a)) && (this.a.equals(((rpi)paramObject).a)) && (!TextUtils.isEmpty(this.b)) && (this.b.equals(((rpi)paramObject).b));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rpi
 * JD-Core Version:    0.7.0.1
 */