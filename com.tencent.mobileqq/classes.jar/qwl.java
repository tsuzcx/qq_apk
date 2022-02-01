import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.articlesummary.articlesummary.LocalInfo;

public class qwl
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public qwl() {}
  
  public qwl(articlesummary.LocalInfo paramLocalInfo)
  {
    if (paramLocalInfo == null) {
      return;
    }
    this.a = paramLocalInfo.bytes_store_url.get().toStringUtf8();
    this.b = paramLocalInfo.bytes_store_url.get().toStringUtf8();
    this.c = paramLocalInfo.bytes_store_address.get().toStringUtf8();
    this.d = paramLocalInfo.bytes_store_longitude.get().toStringUtf8();
    this.e = paramLocalInfo.bytes_store_latitude.get().toStringUtf8();
    this.f = paramLocalInfo.bytes_distance_description.get().toStringUtf8();
    this.g = paramLocalInfo.bytes_corporate_image_name.get().toStringUtf8();
    this.h = paramLocalInfo.bytes_distance_limit.get().toStringUtf8();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qwl
 * JD-Core Version:    0.7.0.1
 */