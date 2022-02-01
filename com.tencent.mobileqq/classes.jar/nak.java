import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_vgame.common.AvGameCommon.GameInfo;
import trpc.qq_vgame.game_list.AvGameList.GameListItemInfo;

public class nak
{
  public int a;
  public long a;
  public String a;
  public naj a;
  public int b;
  public long b;
  public String b;
  public long c;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  
  public nak()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Naj = new naj();
    this.jdField_b_of_type_Int = 0;
  }
  
  protected nak a()
  {
    nak localnak = new nak();
    try
    {
      localnak.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localnak.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localnak.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localnak.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localnak.jdField_a_of_type_Naj = this.jdField_a_of_type_Naj;
      localnak.f = this.f;
      localnak.g = this.g;
      localnak.h = this.h;
      localnak.i = this.i;
      localnak.d = this.d;
      localnak.e = this.e;
      localnak.j = this.j;
      localnak.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      localnak.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      localnak.jdField_c_of_type_Long = this.jdField_c_of_type_Long;
      localnak.m = this.m;
      localnak.l = this.l;
      localnak.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localnak.k = this.k;
      return localnak;
    }
    catch (Exception localException) {}
    return localnak;
  }
  
  public final void a(AvGameList.GameListItemInfo paramGameListItemInfo)
  {
    this.jdField_a_of_type_Int = paramGameListItemInfo.game_type.get();
    this.jdField_a_of_type_JavaLangString = paramGameListItemInfo.game_name.get();
    this.jdField_b_of_type_JavaLangString = paramGameListItemInfo.game_desc.get();
    this.jdField_c_of_type_JavaLangString = paramGameListItemInfo.backgroup_pic_url.get();
    this.jdField_a_of_type_Naj.a();
    this.jdField_a_of_type_Naj.a((AvGameCommon.GameInfo)paramGameListItemInfo.game_info.get());
    this.f = paramGameListItemInfo.answer_right_pic_url.get();
    this.f = paramGameListItemInfo.answer_right_pic_url_new.get();
    this.g = paramGameListItemInfo.game_over_pic_url.get();
    this.h = paramGameListItemInfo.tips_one_line_pic_url.get();
    this.i = paramGameListItemInfo.tips_two_line_pic_url.get();
    this.d = paramGameListItemInfo.prepare_pic_url.get();
    this.e = paramGameListItemInfo.prepare_pic_tp_url.get();
    this.j = paramGameListItemInfo.music_name.get();
    this.jdField_b_of_type_Int = paramGameListItemInfo.status.get();
    this.jdField_b_of_type_Long = paramGameListItemInfo.online_time.get();
    this.jdField_c_of_type_Long = paramGameListItemInfo.offline_time.get();
    this.m = paramGameListItemInfo.prepare_wording.get();
    this.l = paramGameListItemInfo.game_name_url.get();
    this.jdField_a_of_type_Long = paramGameListItemInfo.total_player_num.get();
    this.k = paramGameListItemInfo.backgroup_small_pic_url.get();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("type").append("=").append(this.jdField_a_of_type_Int).append("|");
    localStringBuilder.append("name").append("=").append(this.jdField_a_of_type_JavaLangString).append("|");
    localStringBuilder.append("desc").append("=").append(this.jdField_b_of_type_JavaLangString).append("|");
    localStringBuilder.append("bgUrl").append("=").append(this.jdField_c_of_type_JavaLangString).append("|");
    localStringBuilder.append("answerRightPicUrl").append("=").append(this.f).append("|");
    localStringBuilder.append("gameOverPicUrl").append("=").append(this.g).append("|");
    localStringBuilder.append("oneLineTipBgPicUrl").append("=").append(this.h).append("|");
    localStringBuilder.append("twoLinesTipBgPicUrl").append("=").append(this.i).append("|");
    localStringBuilder.append("preparePicUrl").append("=").append(this.d).append("|");
    localStringBuilder.append("prepareAlphaPicUrl").append("=").append(this.e).append("|");
    localStringBuilder.append("gameBgName").append("=").append(this.j).append("|");
    localStringBuilder.append("onlineStatus").append("=").append(this.jdField_b_of_type_Int).append("|");
    localStringBuilder.append("onlineTime").append("=").append(this.jdField_b_of_type_Long).append("|");
    localStringBuilder.append("offlineTime").append("=").append(this.jdField_c_of_type_Long).append("|");
    localStringBuilder.append("prepareWording").append("=").append(this.m).append("|");
    localStringBuilder.append("gameNameUrl").append("=").append(this.l).append("|");
    localStringBuilder.append("bgSmallUrl").append("=").append(this.k).append("|");
    localStringBuilder.append("playerNum").append("=").append(this.jdField_a_of_type_Long).append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nak
 * JD-Core Version:    0.7.0.1
 */