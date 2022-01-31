import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetFilterList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class tea
  extends sys<teb>
{
  @NonNull
  public final String a;
  public final int c;
  
  public tea(@NonNull String paramString)
  {
    this(paramString, 20);
  }
  
  public tea(@NonNull String paramString, int paramInt)
  {
    this.a = paramString;
    this.c = paramInt;
  }
  
  public String a()
  {
    return sxm.a("StorySvc.video_filter_list");
  }
  
  public syn a(byte[] paramArrayOfByte)
  {
    return new teb(paramArrayOfByte);
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetFilterList localReqGetFilterList = new qqstory_service.ReqGetFilterList();
    localReqGetFilterList.count.set(this.c);
    localReqGetFilterList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.a));
    return localReqGetFilterList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tea
 * JD-Core Version:    0.7.0.1
 */