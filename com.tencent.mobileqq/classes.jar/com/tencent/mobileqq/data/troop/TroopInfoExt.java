package com.tencent.mobileqq.data.troop;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.Serializable;
import tencent.im.oidb.cmd0xef0.oidb_0xef0.GroupInfoExt;

public class TroopInfoExt
  implements Serializable
{
  public static final String TAG = "TroopInfoExt";
  public int group_info_ext_seq;
  public int light_char_num;
  public byte[] lucky_word;
  public long lucky_word_id;
  public int star_id;
  
  public static TroopInfoExt parseFromGroupInfoExt(oidb_0xef0.GroupInfoExt paramGroupInfoExt)
  {
    TroopInfoExt localTroopInfoExt = new TroopInfoExt();
    if ((paramGroupInfoExt != null) && (paramGroupInfoExt.has()))
    {
      if (((oidb_0xef0.GroupInfoExt)paramGroupInfoExt.get()).uint32_group_info_ext_seq.has()) {
        localTroopInfoExt.group_info_ext_seq = ((oidb_0xef0.GroupInfoExt)paramGroupInfoExt.get()).uint32_group_info_ext_seq.get();
      }
      if (((oidb_0xef0.GroupInfoExt)paramGroupInfoExt.get()).uint64_lucky_word_id.has()) {
        localTroopInfoExt.lucky_word_id = ((oidb_0xef0.GroupInfoExt)paramGroupInfoExt.get()).uint64_lucky_word_id.get();
      }
      if (((oidb_0xef0.GroupInfoExt)paramGroupInfoExt.get()).uint32_light_char_num.has()) {
        localTroopInfoExt.light_char_num = ((oidb_0xef0.GroupInfoExt)paramGroupInfoExt.get()).uint32_light_char_num.get();
      }
      if (((oidb_0xef0.GroupInfoExt)paramGroupInfoExt.get()).bytes_lucky_word.has()) {
        localTroopInfoExt.lucky_word = ((oidb_0xef0.GroupInfoExt)paramGroupInfoExt.get()).bytes_lucky_word.get().toByteArray();
      }
      if (((oidb_0xef0.GroupInfoExt)paramGroupInfoExt.get()).uint32_star_id.has()) {
        localTroopInfoExt.star_id = ((oidb_0xef0.GroupInfoExt)paramGroupInfoExt.get()).uint32_star_id.get();
      }
    }
    return localTroopInfoExt;
  }
  
  public oidb_0xef0.GroupInfoExt convToGroupInfoExt()
  {
    oidb_0xef0.GroupInfoExt localGroupInfoExt = new oidb_0xef0.GroupInfoExt();
    localGroupInfoExt.uint32_group_info_ext_seq.set(this.group_info_ext_seq);
    localGroupInfoExt.uint64_lucky_word_id.set(this.lucky_word_id);
    localGroupInfoExt.uint32_light_char_num.set(this.light_char_num);
    if (this.lucky_word != null) {
      localGroupInfoExt.bytes_lucky_word.set(ByteStringMicro.copyFrom(this.lucky_word));
    }
    localGroupInfoExt.uint32_star_id.set(this.star_id);
    return localGroupInfoExt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.troop.TroopInfoExt
 * JD-Core Version:    0.7.0.1
 */