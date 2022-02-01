import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.articlesummary.GameLiveInfo;

public class ret
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  private static ret b(articlesummary.GameLiveInfo paramGameLiveInfo)
  {
    ret localret = new ret();
    if (paramGameLiveInfo.bytes_play_bill_id.has()) {
      localret.jdField_a_of_type_JavaLangString = paramGameLiveInfo.bytes_play_bill_id.get().toStringUtf8();
    }
    if (paramGameLiveInfo.uint32_status.has()) {
      localret.jdField_a_of_type_Int = paramGameLiveInfo.uint32_status.get();
    }
    if (paramGameLiveInfo.uint32_audience_count.has()) {
      localret.jdField_b_of_type_Int = paramGameLiveInfo.uint32_audience_count.get();
    }
    if (paramGameLiveInfo.bytes_game_name.has()) {
      localret.d = paramGameLiveInfo.bytes_game_name.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_play_url.has()) {
      localret.c = paramGameLiveInfo.bytes_play_url.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_tips_wording.has()) {
      localret.e = paramGameLiveInfo.bytes_tips_wording.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_status.has()) {
      localret.f = paramGameLiveInfo.bytes_status.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_status_icon_url.has()) {
      localret.g = paramGameLiveInfo.bytes_status_icon_url.get().toStringUtf8();
    }
    return localret;
  }
  
  private static articlesummary.GameLiveInfo b(ret paramret)
  {
    articlesummary.GameLiveInfo localGameLiveInfo = new articlesummary.GameLiveInfo();
    if (!TextUtils.isEmpty(paramret.jdField_a_of_type_JavaLangString)) {
      localGameLiveInfo.bytes_play_bill_id.set(ByteStringMicro.copyFromUtf8(paramret.jdField_a_of_type_JavaLangString));
    }
    localGameLiveInfo.uint32_status.set(paramret.jdField_a_of_type_Int);
    localGameLiveInfo.uint32_audience_count.set(paramret.jdField_b_of_type_Int);
    if (!TextUtils.isEmpty(paramret.d)) {
      localGameLiveInfo.bytes_game_name.set(ByteStringMicro.copyFromUtf8(paramret.d));
    }
    if (!TextUtils.isEmpty(paramret.c)) {
      localGameLiveInfo.bytes_play_url.set(ByteStringMicro.copyFromUtf8(paramret.c));
    }
    if (!TextUtils.isEmpty(paramret.e)) {
      localGameLiveInfo.bytes_tips_wording.set(ByteStringMicro.copyFromUtf8(paramret.e));
    }
    if (!TextUtils.isEmpty(paramret.f)) {
      localGameLiveInfo.bytes_status.set(ByteStringMicro.copyFromUtf8(paramret.f));
    }
    if (!TextUtils.isEmpty(paramret.g)) {
      localGameLiveInfo.bytes_status_icon_url.set(ByteStringMicro.copyFromUtf8(paramret.g));
    }
    return localGameLiveInfo;
  }
  
  public String toString()
  {
    return "GameLiveInfo{playBillId=" + this.jdField_a_of_type_JavaLangString + ", status=" + this.jdField_a_of_type_Int + ", audienceCount=" + this.jdField_b_of_type_Int + ", audiences=" + this.jdField_b_of_type_JavaLangString + ", playUrl=" + this.c + ", gameName=" + this.d + ", tipsWording=" + this.e + ", liveStatus=" + this.f + ", statusIconUrl=" + this.g + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ret
 * JD-Core Version:    0.7.0.1
 */