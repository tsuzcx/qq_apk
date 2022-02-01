import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.articlesummary.GameLiveInfo;

public class rra
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
  
  private static rra b(articlesummary.GameLiveInfo paramGameLiveInfo)
  {
    rra localrra = new rra();
    if (paramGameLiveInfo.bytes_play_bill_id.has()) {
      localrra.jdField_a_of_type_JavaLangString = paramGameLiveInfo.bytes_play_bill_id.get().toStringUtf8();
    }
    if (paramGameLiveInfo.uint32_status.has()) {
      localrra.jdField_a_of_type_Int = paramGameLiveInfo.uint32_status.get();
    }
    if (paramGameLiveInfo.uint32_audience_count.has()) {
      localrra.jdField_b_of_type_Int = paramGameLiveInfo.uint32_audience_count.get();
    }
    if (paramGameLiveInfo.bytes_game_name.has()) {
      localrra.d = paramGameLiveInfo.bytes_game_name.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_play_url.has()) {
      localrra.c = paramGameLiveInfo.bytes_play_url.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_tips_wording.has()) {
      localrra.e = paramGameLiveInfo.bytes_tips_wording.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_status.has()) {
      localrra.f = paramGameLiveInfo.bytes_status.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_status_icon_url.has()) {
      localrra.g = paramGameLiveInfo.bytes_status_icon_url.get().toStringUtf8();
    }
    return localrra;
  }
  
  private static articlesummary.GameLiveInfo b(rra paramrra)
  {
    articlesummary.GameLiveInfo localGameLiveInfo = new articlesummary.GameLiveInfo();
    if (!TextUtils.isEmpty(paramrra.jdField_a_of_type_JavaLangString)) {
      localGameLiveInfo.bytes_play_bill_id.set(ByteStringMicro.copyFromUtf8(paramrra.jdField_a_of_type_JavaLangString));
    }
    localGameLiveInfo.uint32_status.set(paramrra.jdField_a_of_type_Int);
    localGameLiveInfo.uint32_audience_count.set(paramrra.jdField_b_of_type_Int);
    if (!TextUtils.isEmpty(paramrra.d)) {
      localGameLiveInfo.bytes_game_name.set(ByteStringMicro.copyFromUtf8(paramrra.d));
    }
    if (!TextUtils.isEmpty(paramrra.c)) {
      localGameLiveInfo.bytes_play_url.set(ByteStringMicro.copyFromUtf8(paramrra.c));
    }
    if (!TextUtils.isEmpty(paramrra.e)) {
      localGameLiveInfo.bytes_tips_wording.set(ByteStringMicro.copyFromUtf8(paramrra.e));
    }
    if (!TextUtils.isEmpty(paramrra.f)) {
      localGameLiveInfo.bytes_status.set(ByteStringMicro.copyFromUtf8(paramrra.f));
    }
    if (!TextUtils.isEmpty(paramrra.g)) {
      localGameLiveInfo.bytes_status_icon_url.set(ByteStringMicro.copyFromUtf8(paramrra.g));
    }
    return localGameLiveInfo;
  }
  
  public String toString()
  {
    return "GameLiveInfo{playBillId=" + this.jdField_a_of_type_JavaLangString + ", status=" + this.jdField_a_of_type_Int + ", audienceCount=" + this.jdField_b_of_type_Int + ", audiences=" + this.jdField_b_of_type_JavaLangString + ", playUrl=" + this.c + ", gameName=" + this.d + ", tipsWording=" + this.e + ", liveStatus=" + this.f + ", statusIconUrl=" + this.g + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rra
 * JD-Core Version:    0.7.0.1
 */