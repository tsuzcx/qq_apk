package com.tencent.mobileqq.data;

import android.text.TextUtils;
import atmo;
import atnz;
import atoc;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import tencent.im.oidb.cmd0xa28.oidb_0xa28.Achievement;
import tencent.im.oidb.cmd0xa28.oidb_0xa28.HonourInfo;
import tencent.im.oidb.cmd0xa28.oidb_0xa28.Profile;
import tencent.im.oidb.cmd0xa28.oidb_0xa28.RoleInfo;
import tencent.im.oidb.cmd0xa28.oidb_0xa28.RspBody;

public class KplCard
  extends atmo
{
  public String bgUrl;
  public String commonInfo;
  public String gameLevel;
  public String gameNick;
  public int gender;
  public long mvpLevel;
  public String qqNick;
  @atnz
  public List<KplRoleInfo> roleList;
  public long round;
  public String sRoleList;
  public String score;
  public long superLevel;
  @atoc
  public String uin;
  
  public static KplCard parseProto(oidb_0xa28.RspBody paramRspBody, String paramString)
  {
    long l2 = 0L;
    KplCard localKplCard = new KplCard();
    localKplCard.uin = paramString;
    paramString = (oidb_0xa28.Profile)paramRspBody.msg_profile_info.get();
    localKplCard.gameNick = paramString.bytes_game_nick.get().toStringUtf8();
    localKplCard.qqNick = paramString.bytes_qq_nick.get().toStringUtf8();
    localKplCard.gender = paramString.uint32_gender.get();
    localKplCard.gameLevel = paramString.bytes_game_level.get().toStringUtf8();
    localKplCard.commonInfo = paramString.bytes_common_info.get().toStringUtf8();
    localKplCard.bgUrl = paramString.str_bg_url.get();
    oidb_0xa28.Achievement localAchievement = paramRspBody.msg_game_info.msg_achieve_info;
    long l1;
    if (localAchievement.uint64_mvp_level.has())
    {
      l1 = localAchievement.uint64_mvp_level.get();
      localKplCard.mvpLevel = l1;
      if (!localAchievement.uint64_super.has()) {
        break label300;
      }
      l1 = localAchievement.uint64_super.get();
      label168:
      localKplCard.superLevel = l1;
      if (!localAchievement.bytes_score.has()) {
        break label305;
      }
    }
    label300:
    label305:
    for (paramString = localAchievement.bytes_score.get().toStringUtf8();; paramString = "")
    {
      localKplCard.score = paramString;
      l1 = l2;
      if (localAchievement.uint64_round.has()) {
        l1 = localAchievement.uint64_round.get();
      }
      localKplCard.round = l1;
      paramString = paramRspBody.msg_game_info.msg_role_list.get();
      paramRspBody = new ArrayList(paramString.size());
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        paramRspBody.add(KplRoleInfo.parseProtoResp((oidb_0xa28.RoleInfo)paramString.next()));
      }
      l1 = 0L;
      break;
      l1 = 0L;
      break label168;
    }
    localKplCard.roleList = paramRspBody;
    localKplCard.saveListAsString();
    return localKplCard;
  }
  
  public void saveListAsString()
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.roleList.iterator();
    while (localIterator.hasNext())
    {
      String str = ((KplRoleInfo)localIterator.next()).toJsonString();
      if (!TextUtils.isEmpty(str)) {
        localJSONArray.put(str);
      }
    }
    this.sRoleList = localJSONArray.toString();
  }
  
  public void transStringToList()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = new JSONArray(this.sRoleList);
      int i = 0;
      while (i < localJSONArray.length())
      {
        KplRoleInfo localKplRoleInfo = KplRoleInfo.parseJsonString(localJSONArray.getString(i));
        if (localKplRoleInfo != null) {
          localArrayList.add(localKplRoleInfo);
        }
        i += 1;
      }
      this.roleList = localJSONException;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("KplCard", 1, "transStringToList exception:");
      localJSONException.printStackTrace();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.KplCard
 * JD-Core Version:    0.7.0.1
 */