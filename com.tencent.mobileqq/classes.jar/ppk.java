import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.articlesummary.articlesummary.HotWordItem;

public class ppk
{
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  
  public static ppk a(articlesummary.HotWordItem paramHotWordItem)
  {
    ppk localppk = new ppk();
    if (paramHotWordItem.hot_word.has()) {
      localppk.a = paramHotWordItem.hot_word.get().toStringUtf8();
    }
    if (paramHotWordItem.jump_url.has()) {
      localppk.b = paramHotWordItem.jump_url.get().toStringUtf8();
    }
    if (paramHotWordItem.index_word_color.has()) {
      localppk.c = paramHotWordItem.index_word_color.get().toStringUtf8();
    }
    if (paramHotWordItem.index_bg_color.has()) {
      localppk.d = paramHotWordItem.index_bg_color.get().toStringUtf8();
    }
    return localppk;
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
    return ((paramObject instanceof ppk)) && (!TextUtils.isEmpty(this.a)) && (this.a.equals(((ppk)paramObject).a)) && (!TextUtils.isEmpty(this.b)) && (this.b.equals(((ppk)paramObject).b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ppk
 * JD-Core Version:    0.7.0.1
 */