import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.articlesummary.articlesummary.HotWordItem;

public class qwe
{
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  
  public static qwe a(articlesummary.HotWordItem paramHotWordItem)
  {
    qwe localqwe = new qwe();
    if (paramHotWordItem.hot_word.has()) {
      localqwe.a = paramHotWordItem.hot_word.get().toStringUtf8();
    }
    if (paramHotWordItem.jump_url.has()) {
      localqwe.b = paramHotWordItem.jump_url.get().toStringUtf8();
    }
    if (paramHotWordItem.index_word_color.has()) {
      localqwe.c = paramHotWordItem.index_word_color.get().toStringUtf8();
    }
    if (paramHotWordItem.index_bg_color.has()) {
      localqwe.d = paramHotWordItem.index_bg_color.get().toStringUtf8();
    }
    return localqwe;
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
    if ((paramObject instanceof qwe)) {
      return (!TextUtils.isEmpty(this.a)) && (this.a.equals(((qwe)paramObject).a)) && (!TextUtils.isEmpty(this.b)) && (this.b.equals(((qwe)paramObject).b));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qwe
 * JD-Core Version:    0.7.0.1
 */