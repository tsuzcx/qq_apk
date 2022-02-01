package com.tencent.mobileqq.troop.data;

import android.database.Cursor;
import android.text.TextUtils;
import beub;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2.GiftBagInfo;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2.Player;

public class TroopGiftBagInfo
  extends Entity
{
  public int amount;
  public int count;
  public long doneTime;
  public int endFlag;
  public long endTime;
  public String ext;
  @unique
  public String giftBagId;
  public String giftName;
  public long giftOwner;
  public String giftUnit;
  @notColumn
  public beub myGrabResult;
  public String myGrabResultData;
  @notColumn
  public List<beub> players;
  public String playersData;
  public int remainAmount;
  public int remainCount;
  public long startTime;
  public long troopUin;
  public int winner;
  
  public TroopGiftBagInfo() {}
  
  public TroopGiftBagInfo(oidb_0x6c2.GiftBagInfo paramGiftBagInfo, oidb_0x6c2.Player paramPlayer)
  {
    this.giftBagId = paramGiftBagInfo.bytes_gift_bagid.get().toStringUtf8();
    this.count = paramGiftBagInfo.int32_count.get();
    this.amount = paramGiftBagInfo.int32_amount.get();
    this.startTime = paramGiftBagInfo.uint64_start_time.get();
    this.endTime = paramGiftBagInfo.uint64_end_time.get();
    List localList = paramGiftBagInfo.msg_paly.get();
    this.players = new ArrayList();
    int i = 0;
    while (i < localList.size())
    {
      beub localbeub = new beub((oidb_0x6c2.Player)localList.get(i));
      this.players.add(localbeub);
      i += 1;
    }
    this.endFlag = paramGiftBagInfo.int32_end.get();
    this.remainCount = paramGiftBagInfo.int32_remain_count.get();
    this.remainAmount = paramGiftBagInfo.int32_remain_amount.get();
    this.winner = paramGiftBagInfo.int32_winner.get();
    this.giftOwner = paramGiftBagInfo.uint64_gift_owner.get();
    this.troopUin = paramGiftBagInfo.uint64_group_id.get();
    this.doneTime = paramGiftBagInfo.uint64_done_time.get();
    this.giftName = paramGiftBagInfo.bytes_gift_name.get().toStringUtf8();
    this.giftUnit = paramGiftBagInfo.bytes_gift_unit.get().toStringUtf8();
    this.ext = paramGiftBagInfo.bytes_ext.get().toStringUtf8();
    if (paramPlayer != null) {
      this.myGrabResult = new beub(paramPlayer);
    }
  }
  
  private List<beub> decodeBagPlayerList(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      localArrayList = new ArrayList();
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        int j = localJSONArray.length();
        int i = 0;
        for (;;)
        {
          paramString = localArrayList;
          if (i >= j) {
            break;
          }
          paramString = localJSONArray.get(i);
          beub localbeub = new beub();
          localbeub.a(paramString.toString());
          localArrayList.add(localbeub);
          i += 1;
        }
        return localArrayList;
      }
      catch (JSONException paramString)
      {
        QLog.e(".troop.send_gift", 2, getClass().getSimpleName() + " toJson error. e=" + paramString);
      }
    }
  }
  
  public boolean entityByCursor(Cursor paramCursor)
  {
    this.giftBagId = paramCursor.getString(paramCursor.getColumnIndex("giftBagId"));
    this.count = paramCursor.getInt(paramCursor.getColumnIndex("count"));
    this.amount = paramCursor.getInt(paramCursor.getColumnIndex("amount"));
    this.startTime = paramCursor.getLong(paramCursor.getColumnIndex("startTime"));
    this.endTime = paramCursor.getLong(paramCursor.getColumnIndex("endTime"));
    this.players = decodeBagPlayerList(paramCursor.getString(paramCursor.getColumnIndex("playersData")));
    this.endFlag = paramCursor.getInt(paramCursor.getColumnIndex("endFlag"));
    this.remainCount = paramCursor.getInt(paramCursor.getColumnIndex("remainCount"));
    this.remainAmount = paramCursor.getInt(paramCursor.getColumnIndex("remainAmount"));
    this.winner = paramCursor.getInt(paramCursor.getColumnIndex("winner"));
    this.giftOwner = paramCursor.getLong(paramCursor.getColumnIndex("giftOwner"));
    this.troopUin = paramCursor.getLong(paramCursor.getColumnIndex("troopUin"));
    this.doneTime = paramCursor.getLong(paramCursor.getColumnIndex("doneTime"));
    this.giftName = paramCursor.getString(paramCursor.getColumnIndex("giftName"));
    this.giftUnit = paramCursor.getString(paramCursor.getColumnIndex("giftUnit"));
    this.ext = paramCursor.getString(paramCursor.getColumnIndex("ext"));
    this.myGrabResult = new beub();
    String str = paramCursor.getString(paramCursor.getColumnIndex("myGrabResultData"));
    if (!TextUtils.isEmpty(str)) {
      this.myGrabResult.a(str);
    }
    return super.entityByCursor(paramCursor);
  }
  
  public boolean hasGrab()
  {
    return (this.myGrabResult != null) && (this.myGrabResult.a > 0);
  }
  
  public void prewrite()
  {
    super.prewrite();
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < this.players.size())
    {
      localJSONArray.put(((beub)this.players.get(i)).a());
      i += 1;
    }
    this.playersData = localJSONArray.toString();
    if (this.myGrabResult != null) {
      this.myGrabResultData = this.myGrabResult.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopGiftBagInfo
 * JD-Core Version:    0.7.0.1
 */