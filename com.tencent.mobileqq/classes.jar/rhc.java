import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.articlesummary.GameLiveInfo;

public class rhc
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
  
  private static rhc b(articlesummary.GameLiveInfo paramGameLiveInfo)
  {
    rhc localrhc = new rhc();
    if (paramGameLiveInfo.bytes_play_bill_id.has()) {
      localrhc.jdField_a_of_type_JavaLangString = paramGameLiveInfo.bytes_play_bill_id.get().toStringUtf8();
    }
    if (paramGameLiveInfo.uint32_status.has()) {
      localrhc.jdField_a_of_type_Int = paramGameLiveInfo.uint32_status.get();
    }
    if (paramGameLiveInfo.uint32_audience_count.has()) {
      localrhc.jdField_b_of_type_Int = paramGameLiveInfo.uint32_audience_count.get();
    }
    if (paramGameLiveInfo.bytes_game_name.has()) {
      localrhc.d = paramGameLiveInfo.bytes_game_name.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_play_url.has()) {
      localrhc.c = paramGameLiveInfo.bytes_play_url.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_tips_wording.has()) {
      localrhc.e = paramGameLiveInfo.bytes_tips_wording.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_status.has()) {
      localrhc.f = paramGameLiveInfo.bytes_status.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_status_icon_url.has()) {
      localrhc.g = paramGameLiveInfo.bytes_status_icon_url.get().toStringUtf8();
    }
    return localrhc;
  }
  
  private static articlesummary.GameLiveInfo b(rhc paramrhc)
  {
    articlesummary.GameLiveInfo localGameLiveInfo = new articlesummary.GameLiveInfo();
    if (!TextUtils.isEmpty(paramrhc.jdField_a_of_type_JavaLangString)) {
      localGameLiveInfo.bytes_play_bill_id.set(ByteStringMicro.copyFromUtf8(paramrhc.jdField_a_of_type_JavaLangString));
    }
    localGameLiveInfo.uint32_status.set(paramrhc.jdField_a_of_type_Int);
    localGameLiveInfo.uint32_audience_count.set(paramrhc.jdField_b_of_type_Int);
    if (!TextUtils.isEmpty(paramrhc.d)) {
      localGameLiveInfo.bytes_game_name.set(ByteStringMicro.copyFromUtf8(paramrhc.d));
    }
    if (!TextUtils.isEmpty(paramrhc.c)) {
      localGameLiveInfo.bytes_play_url.set(ByteStringMicro.copyFromUtf8(paramrhc.c));
    }
    if (!TextUtils.isEmpty(paramrhc.e)) {
      localGameLiveInfo.bytes_tips_wording.set(ByteStringMicro.copyFromUtf8(paramrhc.e));
    }
    if (!TextUtils.isEmpty(paramrhc.f)) {
      localGameLiveInfo.bytes_status.set(ByteStringMicro.copyFromUtf8(paramrhc.f));
    }
    if (!TextUtils.isEmpty(paramrhc.g)) {
      localGameLiveInfo.bytes_status_icon_url.set(ByteStringMicro.copyFromUtf8(paramrhc.g));
    }
    return localGameLiveInfo;
  }
  
  public String toString()
  {
    return "GameLiveInfo{playBillId=" + this.jdField_a_of_type_JavaLangString + ", status=" + this.jdField_a_of_type_Int + ", audienceCount=" + this.jdField_b_of_type_Int + ", audiences=" + this.jdField_b_of_type_JavaLangString + ", playUrl=" + this.c + ", gameName=" + this.d + ", tipsWording=" + this.e + ", liveStatus=" + this.f + ", statusIconUrl=" + this.g + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rhc
 * JD-Core Version:    0.7.0.1
 */