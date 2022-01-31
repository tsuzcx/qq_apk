import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.articlesummary.articlesummary.OutsideLinkInfo;

public class qcu
{
  public String a;
  public String b;
  public String c;
  
  public qcu(articlesummary.OutsideLinkInfo paramOutsideLinkInfo)
  {
    if (paramOutsideLinkInfo.title.has()) {
      this.a = paramOutsideLinkInfo.title.get();
    }
    if (paramOutsideLinkInfo.bring_goods_url.has()) {
      this.b = paramOutsideLinkInfo.bring_goods_url.get();
    }
    if (paramOutsideLinkInfo.icon_url.has()) {
      this.c = paramOutsideLinkInfo.icon_url.get();
    }
  }
  
  public articlesummary.OutsideLinkInfo a()
  {
    articlesummary.OutsideLinkInfo localOutsideLinkInfo = new articlesummary.OutsideLinkInfo();
    if (!TextUtils.isEmpty(this.c)) {
      localOutsideLinkInfo.icon_url.set(this.c);
    }
    if (!TextUtils.isEmpty(this.b)) {
      localOutsideLinkInfo.bring_goods_url.set(this.b);
    }
    if (!TextUtils.isEmpty(this.a)) {
      localOutsideLinkInfo.title.set(this.a);
    }
    return localOutsideLinkInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qcu
 * JD-Core Version:    0.7.0.1
 */