package com.tencent.mobileqq.data;

import android.text.TextUtils;
import awge;
import awhs;
import bckq;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.List;
import tencent.im.group.group_label.GroupLabel.Label;
import tencent.im.oidb.cmd0x8b4.GroupInfo;

public class ShowExternalTroop
  extends awge
{
  public long addedTimestamp;
  public List<GroupLabel.Label> labelList;
  public String strFaceUrl;
  public String troopDesRich;
  public String troopDesText;
  public String troopName;
  @awhs
  public String troopUin;
  
  public ShowExternalTroop() {}
  
  public ShowExternalTroop(cmd0x8b4.GroupInfo paramGroupInfo)
  {
    if (paramGroupInfo != null)
    {
      this.troopName = paramGroupInfo.str_group_name.get();
      this.troopUin = String.valueOf(paramGroupInfo.uint64_gc.get());
      this.addedTimestamp = paramGroupInfo.uint32_set_display_time.get();
      this.troopDesText = paramGroupInfo.bytes_text_intro.get().toStringUtf8();
      this.troopDesRich = paramGroupInfo.bytes_rich_intro.get().toStringUtf8();
      this.labelList = paramGroupInfo.rpt_group_label.get();
      if (TextUtils.isEmpty(paramGroupInfo.str_face_url.get())) {
        this.strFaceUrl = bckq.a(bckq.a(null, this.troopUin, 0));
      }
    }
    else
    {
      return;
    }
    this.strFaceUrl = paramGroupInfo.str_face_url.get();
  }
  
  public static ShowExternalTroop createShowExternalTroop(String paramString1, String paramString2, long paramLong)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    ShowExternalTroop localShowExternalTroop = new ShowExternalTroop();
    localShowExternalTroop.troopUin = paramString1;
    localShowExternalTroop.troopName = paramString2;
    localShowExternalTroop.addedTimestamp = paramLong;
    localShowExternalTroop.strFaceUrl = bckq.a(bckq.a(null, paramString1, 0));
    return localShowExternalTroop;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.ShowExternalTroop
 * JD-Core Version:    0.7.0.1
 */