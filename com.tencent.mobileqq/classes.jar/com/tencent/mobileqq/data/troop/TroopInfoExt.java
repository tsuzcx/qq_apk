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
  public int essenceSwitch = 0;
  public int groupInfoExtSeq = 0;
  public int lightCharNum = 0;
  public byte[] luckyWord;
  public long luckyWordId = 0L;
  public int starId = 0;
  
  public static TroopInfoExt parseFromGroupInfoExt(oidb_0xef0.GroupInfoExt paramGroupInfoExt)
  {
    TroopInfoExt localTroopInfoExt = new TroopInfoExt();
    if ((paramGroupInfoExt != null) && (paramGroupInfoExt.has()))
    {
      if (((oidb_0xef0.GroupInfoExt)paramGroupInfoExt.get()).uint32_group_info_ext_seq.has()) {
        localTroopInfoExt.groupInfoExtSeq = ((oidb_0xef0.GroupInfoExt)paramGroupInfoExt.get()).uint32_group_info_ext_seq.get();
      }
      if (((oidb_0xef0.GroupInfoExt)paramGroupInfoExt.get()).uint64_lucky_word_id.has()) {
        localTroopInfoExt.luckyWordId = ((oidb_0xef0.GroupInfoExt)paramGroupInfoExt.get()).uint64_lucky_word_id.get();
      }
      if (((oidb_0xef0.GroupInfoExt)paramGroupInfoExt.get()).uint32_light_char_num.has()) {
        localTroopInfoExt.lightCharNum = ((oidb_0xef0.GroupInfoExt)paramGroupInfoExt.get()).uint32_light_char_num.get();
      }
      if (((oidb_0xef0.GroupInfoExt)paramGroupInfoExt.get()).bytes_lucky_word.has()) {
        localTroopInfoExt.luckyWord = ((oidb_0xef0.GroupInfoExt)paramGroupInfoExt.get()).bytes_lucky_word.get().toByteArray();
      }
      if (((oidb_0xef0.GroupInfoExt)paramGroupInfoExt.get()).uint32_star_id.has()) {
        localTroopInfoExt.starId = ((oidb_0xef0.GroupInfoExt)paramGroupInfoExt.get()).uint32_star_id.get();
      }
      if (((oidb_0xef0.GroupInfoExt)paramGroupInfoExt.get()).uint32_essential_msg_switch.has()) {
        localTroopInfoExt.essenceSwitch = ((oidb_0xef0.GroupInfoExt)paramGroupInfoExt.get()).uint32_essential_msg_switch.get();
      }
    }
    return localTroopInfoExt;
  }
  
  public oidb_0xef0.GroupInfoExt convToGroupInfoExt()
  {
    oidb_0xef0.GroupInfoExt localGroupInfoExt = new oidb_0xef0.GroupInfoExt();
    localGroupInfoExt.uint32_group_info_ext_seq.set(this.groupInfoExtSeq);
    localGroupInfoExt.uint64_lucky_word_id.set(this.luckyWordId);
    localGroupInfoExt.uint32_light_char_num.set(this.lightCharNum);
    if (this.luckyWord != null) {
      localGroupInfoExt.bytes_lucky_word.set(ByteStringMicro.copyFrom(this.luckyWord));
    }
    localGroupInfoExt.uint32_star_id.set(this.starId);
    localGroupInfoExt.uint32_essential_msg_switch.set(this.essenceSwitch);
    return localGroupInfoExt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.troop.TroopInfoExt
 * JD-Core Version:    0.7.0.1
 */