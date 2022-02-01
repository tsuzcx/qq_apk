package com.tencent.mobileqq.troop.data;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import java.util.List;
import tencent.im.group.group_label.GroupLabel.Label;
import tencent.im.oidb.cmd0x8b4.GroupInfo;

public class ShowExternalTroop
  extends Entity
{
  public long addedTimestamp;
  public List<GroupLabel.Label> labelList;
  public String strFaceUrl;
  public String troopDesRich;
  public String troopDesText;
  public String troopName;
  @unique
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
      if (TextUtils.isEmpty(paramGroupInfo.str_face_url.get()))
      {
        paramGroupInfo = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
        this.strFaceUrl = paramGroupInfo.getThumbPhoto(paramGroupInfo.getAvatarAddress(null, this.troopUin, 0));
        return;
      }
      this.strFaceUrl = paramGroupInfo.str_face_url.get();
    }
  }
  
  public static ShowExternalTroop createShowExternalTroop(String paramString1, String paramString2, long paramLong)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return null;
      }
      ShowExternalTroop localShowExternalTroop = new ShowExternalTroop();
      localShowExternalTroop.troopUin = paramString1;
      localShowExternalTroop.troopName = paramString2;
      localShowExternalTroop.addedTimestamp = paramLong;
      paramString2 = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
      localShowExternalTroop.strFaceUrl = paramString2.getThumbPhoto(paramString2.getAvatarAddress(null, paramString1, 0));
      return localShowExternalTroop;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.ShowExternalTroop
 * JD-Core Version:    0.7.0.1
 */