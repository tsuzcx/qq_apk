package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.qroute.annotation.PluginInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@PluginInterface
public class TroopCreateInfo
{
  public static final int INVALID_TROOP_CLASSIFY = 0;
  public static final int INVALID_TROOP_TYPE = -1;
  public static final int TROOP_TYPE_200 = 1;
  public String classificationInfo;
  public int classify;
  public int createFrom = 0;
  public String disPlayTroopName;
  public int groupUin;
  public boolean hasAddGrayTips;
  public boolean hasTroopHead;
  public String introduction;
  public List<TroopCreateInfo.InviteMemberInfo> inviteMembers = Collections.synchronizedList(new ArrayList());
  public boolean isJumpAio;
  public String location;
  public long maxSeq;
  public String name;
  public byte[] signOriginal;
  public int troopSize;
  public int troopType;
  public String troopUin;
  public int verifyType;
  
  public TroopCreateInfo()
  {
    reset();
  }
  
  public void parseFromJsonString(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.classify = paramString.optInt("classify", 0);
        this.verifyType = paramString.optInt("verifyType", 2);
        this.classificationInfo = paramString.optString("classificationInfo", "");
        this.name = paramString.optString("name", "");
        this.introduction = paramString.optString("introduction", "");
        this.location = paramString.optString("location", "");
        this.troopType = paramString.optInt("group_type", -1);
        int i = paramString.optInt("isJumpAio");
        bool = true;
        if (i == 1)
        {
          this.isJumpAio = bool;
          this.createFrom = paramString.optInt("create_source", 0);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      boolean bool = false;
    }
  }
  
  public void reset()
  {
    this.troopSize = 1;
    this.signOriginal = new byte[0];
    this.classify = 0;
    this.verifyType = 0;
    this.classificationInfo = "";
    this.name = "";
    this.introduction = "";
    this.location = "";
    this.troopSize = 1;
    this.troopType = -1;
    this.hasTroopHead = false;
    List localList = this.inviteMembers;
    if (localList != null) {
      localList.clear();
    }
    this.hasAddGrayTips = false;
    this.isJumpAio = false;
    this.maxSeq = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopCreateInfo
 * JD-Core Version:    0.7.0.1
 */