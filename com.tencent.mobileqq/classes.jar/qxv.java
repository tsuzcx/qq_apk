import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.articlesummary.GameLiveInfo;

public class qxv
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
  
  private static qxv b(articlesummary.GameLiveInfo paramGameLiveInfo)
  {
    qxv localqxv = new qxv();
    if (paramGameLiveInfo.bytes_play_bill_id.has()) {
      localqxv.jdField_a_of_type_JavaLangString = paramGameLiveInfo.bytes_play_bill_id.get().toStringUtf8();
    }
    if (paramGameLiveInfo.uint32_status.has()) {
      localqxv.jdField_a_of_type_Int = paramGameLiveInfo.uint32_status.get();
    }
    if (paramGameLiveInfo.uint32_audience_count.has()) {
      localqxv.jdField_b_of_type_Int = paramGameLiveInfo.uint32_audience_count.get();
    }
    if (paramGameLiveInfo.bytes_game_name.has()) {
      localqxv.d = paramGameLiveInfo.bytes_game_name.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_play_url.has()) {
      localqxv.c = paramGameLiveInfo.bytes_play_url.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_tips_wording.has()) {
      localqxv.e = paramGameLiveInfo.bytes_tips_wording.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_status.has()) {
      localqxv.f = paramGameLiveInfo.bytes_status.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_status_icon_url.has()) {
      localqxv.g = paramGameLiveInfo.bytes_status_icon_url.get().toStringUtf8();
    }
    return localqxv;
  }
  
  private static articlesummary.GameLiveInfo b(qxv paramqxv)
  {
    articlesummary.GameLiveInfo localGameLiveInfo = new articlesummary.GameLiveInfo();
    if (!TextUtils.isEmpty(paramqxv.jdField_a_of_type_JavaLangString)) {
      localGameLiveInfo.bytes_play_bill_id.set(ByteStringMicro.copyFromUtf8(paramqxv.jdField_a_of_type_JavaLangString));
    }
    localGameLiveInfo.uint32_status.set(paramqxv.jdField_a_of_type_Int);
    localGameLiveInfo.uint32_audience_count.set(paramqxv.jdField_b_of_type_Int);
    if (!TextUtils.isEmpty(paramqxv.d)) {
      localGameLiveInfo.bytes_game_name.set(ByteStringMicro.copyFromUtf8(paramqxv.d));
    }
    if (!TextUtils.isEmpty(paramqxv.c)) {
      localGameLiveInfo.bytes_play_url.set(ByteStringMicro.copyFromUtf8(paramqxv.c));
    }
    if (!TextUtils.isEmpty(paramqxv.e)) {
      localGameLiveInfo.bytes_tips_wording.set(ByteStringMicro.copyFromUtf8(paramqxv.e));
    }
    if (!TextUtils.isEmpty(paramqxv.f)) {
      localGameLiveInfo.bytes_status.set(ByteStringMicro.copyFromUtf8(paramqxv.f));
    }
    if (!TextUtils.isEmpty(paramqxv.g)) {
      localGameLiveInfo.bytes_status_icon_url.set(ByteStringMicro.copyFromUtf8(paramqxv.g));
    }
    return localGameLiveInfo;
  }
  
  public String toString()
  {
    return "GameLiveInfo{playBillId=" + this.jdField_a_of_type_JavaLangString + ", status=" + this.jdField_a_of_type_Int + ", audienceCount=" + this.jdField_b_of_type_Int + ", audiences=" + this.jdField_b_of_type_JavaLangString + ", playUrl=" + this.c + ", gameName=" + this.d + ", tipsWording=" + this.e + ", liveStatus=" + this.f + ", statusIconUrl=" + this.g + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qxv
 * JD-Core Version:    0.7.0.1
 */