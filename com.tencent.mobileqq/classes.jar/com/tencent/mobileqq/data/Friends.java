package com.tencent.mobileqq.data;

import QQService.EVIPSPEC;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.PrimaryKeyJoinColumn;
import com.tencent.mobileqq.persistence.defaultValue;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;

@PrimaryKeyJoinColumn(name="uin")
public class Friends
  extends Entity
  implements Cloneable
{
  public static final int CLIENT_DEFAULT = 0;
  public static final int CLIENT_IPHONE = 3;
  public static final int CLIENT_MOBILE = 2;
  public static final int CLIENT_PC = 1;
  public static final int FRIEND_TYPE_QIM = 1;
  public static final int GATHER_TYPE_GATHERED = 1;
  public static final int GATHER_TYPE_NORMAL = 0;
  public static final int GATHER_TYPE_RECOMMENDED = 2;
  private static final long LOGIN_TYPE_OFFLINE = 10L;
  public static int MULTI_FLAGS_MASK_OLYMPICTORCH = 2;
  public static int MULTI_FLAGS_MASK_SHIELD = 1;
  public static final int NET_2G = 2;
  public static final int NET_3G = 3;
  public static final int NET_4G = 4;
  public static final int NET_5G = 5;
  public static final int NET_UNKNOW = 0;
  public static final int NET_WIFI = 1;
  public static final int TERM_TYPE_ANDROID_PAD = 68104;
  public static final int TERM_TYPE_AOL_CHAOJIHUIYUAN = 73730;
  public static final int TERM_TYPE_AOL_HUIYUAN = 73474;
  public static final int TERM_TYPE_AOL_SQQ = 69378;
  public static final int TERM_TYPE_CAR = 65806;
  public static final int TERM_TYPE_HRTX_IPHONE = 66566;
  public static final int TERM_TYPE_HRTX_PC = 66561;
  public static final int TERM_TYPE_MC_3G = 65795;
  public static final int TERM_TYPE_MISRO_MSG = 69634;
  public static final int TERM_TYPE_MOBILE_ANDROID = 65799;
  public static final int TERM_TYPE_MOBILE_ANDROID_NEW = 72450;
  public static final int TERM_TYPE_MOBILE_HD = 65805;
  public static final int TERM_TYPE_MOBILE_HD_NEW = 71426;
  public static final int TERM_TYPE_MOBILE_IPAD = 68361;
  public static final int TERM_TYPE_MOBILE_IPAD_NEW = 72194;
  public static final int TERM_TYPE_MOBILE_IPHONE = 67586;
  public static final int TERM_TYPE_MOBILE_OTHER = 65794;
  public static final int TERM_TYPE_MOBILE_PC = 65793;
  public static final int TERM_TYPE_MOBILE_WINPHONE_NEW = 72706;
  public static final int TERM_TYPE_QQ_FORELDER = 70922;
  public static final int TERM_TYPE_QQ_SERVICE = 71170;
  public static final int TERM_TYPE_TV_QQ = 69130;
  public static final int TERM_TYPE_WIN8 = 69899;
  public static final int TERM_TYPE_WINPHONE = 65804;
  public long abilityBits = 0L;
  public String adCode;
  public int age;
  public String alias;
  public String area;
  public long autoStatusUpdateSecond;
  public int bigClubExtTemplateId = 0;
  public int bigClubInfo = 0;
  public int bigClubTemplateId = 0;
  public int cNewLoverDiamondFlag = 0;
  public byte cSpecialFlag;
  public String city;
  public String constellationBgImageUrl;
  public String constellationDateStr;
  public String constellationIconUrl;
  public String constellationJumpUrl;
  public String constellationLuckyColor;
  public String constellationLuckyNumber;
  public String constellationTodayTrend;
  public String constellationTomorrowTrend;
  public long curOlympicRank = -1L;
  public String customModel = "";
  @notColumn
  public String customOnlineStatus;
  @notColumn
  public int customOnlineStatusType;
  public long datetime;
  public byte detalStatusFlag;
  public int diyFontId = 0;
  public int eNetwork = 0;
  @Deprecated
  public short faceid;
  public int friendType = 0;
  public int gameCardId = 0;
  public byte gathtertype = 0;
  public byte gender;
  public int grayNameplateFlag = 0;
  public int groupid = -1;
  @Deprecated
  public int hollywoodVipInfo = 0;
  public int iBatteryStatus = 0;
  public int iTermType;
  @Deprecated
  public byte isIphoneOnline;
  @Deprecated
  public boolean isMqqOnLine;
  @Deprecated
  public byte isRemark = 1;
  public long lastLoginType;
  public double latitude;
  public double longitude;
  public int mComparePartInt;
  public String mCompareSpell;
  public String medalsInfo;
  @Deprecated
  public byte memberLevel;
  public int multiFlags = 0;
  public volatile String name;
  public int namePlateOfKingDan;
  public boolean namePlateOfKingDanDisplatSwitch;
  public long namePlateOfKingGameId;
  public long namePlateOfKingLoginTime;
  public String nameplateCfgInfo;
  public int nameplateVipType = 0;
  @notColumn
  public int netTypeIconId;
  public int poiFlag;
  public String poiName;
  public long poiUpdateTime;
  public int qqVipInfo = 0;
  public String recommReason;
  public int relationIconFlag = 0;
  public String remark;
  public long showLoginClient;
  @Deprecated
  public String signature;
  public String singerName;
  public String smartRemark;
  @notColumn
  public int songDuration;
  public long songEndTime;
  public String songId;
  public String songName;
  @notColumn
  public int songPauseRemainTime;
  public int songSourceType;
  @Deprecated
  public byte sqqOnLineState;
  @Deprecated
  public byte sqqtype;
  @Deprecated
  public byte status = 10;
  public String strMasterUin = "";
  @notColumn
  public String strTermDesc;
  public int superQqInfo = 0;
  public int superVipInfo = 0;
  public int superVipTemplateId = 0;
  public String temper;
  public long uExtOnlineStatus = 0L;
  @unique
  public String uin;
  public String weatherDecs;
  @defaultValue(defaultInteger=1)
  public int weatherFlag;
  public String weatherTip;
  public String weatherType;
  public String weatherTypeId;
  public long weatherUpdateTime;
  
  public static boolean isValidUin(long paramLong)
  {
    return paramLong > 10000L;
  }
  
  public static boolean isValidUin(String paramString)
  {
    boolean bool = false;
    try
    {
      long l = Long.valueOf(Long.parseLong(paramString)).longValue();
      if (l > 10000L) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Friends clone failed.");
        localStringBuilder.append(localCloneNotSupportedException.toString());
        QLog.d("FriendsManager", 2, localStringBuilder.toString());
      }
    }
    return this;
  }
  
  protected boolean entityByCursor(Cursor paramCursor)
  {
    this.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
    this.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
    this.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
    this.cSpecialFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cSpecialFlag")));
    this.groupid = paramCursor.getInt(paramCursor.getColumnIndex("groupid"));
    this.detalStatusFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("detalStatusFlag")));
    this.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
    this.alias = paramCursor.getString(paramCursor.getColumnIndex("alias"));
    this.iTermType = paramCursor.getInt(paramCursor.getColumnIndex("iTermType"));
    this.qqVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("qqVipInfo"));
    this.superQqInfo = paramCursor.getInt(paramCursor.getColumnIndex("superQqInfo"));
    this.superVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("superVipInfo"));
    this.bigClubInfo = paramCursor.getInt(paramCursor.getColumnIndex("bigClubInfo"));
    this.lastLoginType = paramCursor.getLong(paramCursor.getColumnIndex("lastLoginType"));
    this.showLoginClient = paramCursor.getLong(paramCursor.getColumnIndex("showLoginClient"));
    this.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
    this.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
    this.eNetwork = paramCursor.getInt(paramCursor.getColumnIndex("eNetwork"));
    this.multiFlags = paramCursor.getInt(paramCursor.getColumnIndex("multiFlags"));
    this.abilityBits = paramCursor.getLong(paramCursor.getColumnIndex("abilityBits"));
    this.gathtertype = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gathtertype")));
    this.smartRemark = paramCursor.getString(paramCursor.getColumnIndex("smartRemark"));
    this.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
    this.gender = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gender")));
    this.recommReason = paramCursor.getString(paramCursor.getColumnIndex("recommReason"));
    this.friendType = paramCursor.getInt(paramCursor.getColumnIndex("friendType"));
    this.strMasterUin = paramCursor.getString(paramCursor.getColumnIndex("strMasterUin"));
    this.superVipTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("superVipTemplateId"));
    this.bigClubTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("bigClubTemplateId"));
    this.bigClubExtTemplateId = paramCursor.getInt(paramCursor.getColumnIndex("bigClubExtTemplateId"));
    this.gameCardId = paramCursor.getInt(paramCursor.getColumnIndex("gameCardId"));
    this.diyFontId = paramCursor.getInt(paramCursor.getColumnIndex("diyFontId"));
    this.nameplateVipType = paramCursor.getInt(paramCursor.getColumnIndex("nameplateVipType"));
    this.grayNameplateFlag = paramCursor.getInt(paramCursor.getColumnIndex("grayNameplateFlag"));
    this.cNewLoverDiamondFlag = paramCursor.getInt(paramCursor.getColumnIndex("cNewLoverDiamondFlag"));
    this.medalsInfo = paramCursor.getString(paramCursor.getColumnIndex("medalsInfo"));
    this.relationIconFlag = paramCursor.getInt(paramCursor.getColumnIndex("relationIconFlag"));
    this.nameplateCfgInfo = paramCursor.getString(paramCursor.getColumnIndex("nameplateCfgInfo"));
    this.uExtOnlineStatus = paramCursor.getLong(paramCursor.getColumnIndex("uExtOnlineStatus"));
    this.iBatteryStatus = paramCursor.getInt(paramCursor.getColumnIndex("iBatteryStatus"));
    this.customModel = paramCursor.getString(paramCursor.getColumnIndex("customModel"));
    this.constellationTodayTrend = paramCursor.getString(paramCursor.getColumnIndex("constellationTodayTrend"));
    this.constellationTomorrowTrend = paramCursor.getString(paramCursor.getColumnIndex("constellationTomorrowTrend"));
    this.constellationBgImageUrl = paramCursor.getString(paramCursor.getColumnIndex("constellationBgImageUrl"));
    this.constellationIconUrl = paramCursor.getString(paramCursor.getColumnIndex("constellationIconUrl"));
    this.constellationJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("constellationJumpUrl"));
    this.constellationDateStr = paramCursor.getString(paramCursor.getColumnIndex("constellationDateStr"));
    this.constellationLuckyColor = paramCursor.getString(paramCursor.getColumnIndex("constellationLuckyColor"));
    this.constellationLuckyNumber = paramCursor.getString(paramCursor.getColumnIndex("constellationLuckyNumber"));
    this.temper = paramCursor.getString(paramCursor.getColumnIndex("temper"));
    this.weatherType = paramCursor.getString(paramCursor.getColumnIndex("weatherType"));
    this.weatherTypeId = paramCursor.getString(paramCursor.getColumnIndex("weatherTypeId"));
    this.weatherTip = paramCursor.getString(paramCursor.getColumnIndex("weatherTip"));
    this.adCode = paramCursor.getString(paramCursor.getColumnIndex("adCode"));
    this.city = paramCursor.getString(paramCursor.getColumnIndex("city"));
    this.area = paramCursor.getString(paramCursor.getColumnIndex("area"));
    this.weatherUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("weatherUpdateTime"));
    this.weatherFlag = paramCursor.getInt(paramCursor.getColumnIndex("weatherFlag"));
    this.weatherDecs = paramCursor.getString(paramCursor.getColumnIndex("weatherDecs"));
    this.autoStatusUpdateSecond = paramCursor.getLong(paramCursor.getColumnIndex("autoStatusUpdateSecond"));
    this.curOlympicRank = paramCursor.getLong(paramCursor.getColumnIndex("curOlympicRank"));
    if (QLog.isColorLevel())
    {
      paramCursor = new StringBuilder();
      paramCursor.append("entityByCursor uin=");
      paramCursor.append(this.uin);
      paramCursor.append(", cSpecialFlag=");
      paramCursor.append(this.cSpecialFlag);
      QLog.i("Friends", 2, paramCursor.toString());
    }
    return true;
  }
  
  public int getBatteryCapacity()
  {
    int i = this.iBatteryStatus & 0x7F;
    if (QLog.isColorLevel()) {
      QLog.d("Friends", 2, new Object[] { "getBatteryCapacity:", Integer.valueOf(i) });
    }
    return i;
  }
  
  public String getFriendName()
  {
    if (!TextUtils.isEmpty(this.name)) {
      return this.name;
    }
    return this.uin;
  }
  
  public String getFriendNick()
  {
    if (!TextUtils.isEmpty(this.remark)) {
      return this.remark;
    }
    if (!TextUtils.isEmpty(this.name)) {
      return this.name;
    }
    return this.uin;
  }
  
  public String getFriendNickWithAlias()
  {
    if (!TextUtils.isEmpty(this.remark)) {
      return this.remark;
    }
    if (!TextUtils.isEmpty(this.name)) {
      return this.name;
    }
    if (!TextUtils.isEmpty(this.alias)) {
      return this.alias;
    }
    return this.uin;
  }
  
  public String getFriendNickWithoutUin()
  {
    if (!TextUtils.isEmpty(this.remark)) {
      return this.remark;
    }
    if (!TextUtils.isEmpty(this.name)) {
      return this.name;
    }
    return "";
  }
  
  public long getLastLoginType()
  {
    long l2 = this.lastLoginType;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = 10L;
    }
    return l1;
  }
  
  public int getServiceLevel(EVIPSPEC paramEVIPSPEC)
  {
    int i = paramEVIPSPEC.value();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 7) {
            return 0;
          }
          i = this.bigClubInfo;
        }
        else
        {
          i = this.superVipInfo;
        }
      }
      else {
        i = this.superQqInfo;
      }
    }
    else {
      i = this.qqVipInfo;
    }
    return i & 0xFFFF;
  }
  
  public int getServiceType(EVIPSPEC paramEVIPSPEC)
  {
    int i = paramEVIPSPEC.value();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 7) {
            return 0;
          }
          i = this.bigClubInfo;
        }
        else
        {
          i = this.superVipInfo;
        }
      }
      else {
        i = this.superQqInfo;
      }
    }
    else {
      i = this.qqVipInfo;
    }
    return (i & 0xFF0000) >>> 16;
  }
  
  public boolean isBatteryCharging()
  {
    return (this.iBatteryStatus & 0x80) > 0;
  }
  
  public boolean isFriend()
  {
    return this.groupid >= 0;
  }
  
  public boolean isServiceEnabled(EVIPSPEC paramEVIPSPEC)
  {
    int i = paramEVIPSPEC.value();
    if (i != 1) {
      if (i != 2) {
        if (i != 3)
        {
          if (i != 7) {
            return false;
          }
          if ((this.bigClubInfo & 0xFF000000) == 0) {
            break label83;
          }
        }
      }
    }
    while ((this.qqVipInfo & 0xFF000000) != 0) {
      for (;;)
      {
        return true;
        if ((this.superVipInfo & 0xFF000000) == 0) {
          break;
        }
        continue;
        if ((this.superQqInfo & 0xFF000000) == 0) {
          break;
        }
      }
    }
    label83:
    return false;
  }
  
  public boolean isShield()
  {
    return (this.multiFlags & MULTI_FLAGS_MASK_SHIELD) > 0;
  }
  
  public void setShieldFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.multiFlags |= MULTI_FLAGS_MASK_SHIELD;
      return;
    }
    this.multiFlags &= (MULTI_FLAGS_MASK_SHIELD ^ 0xFFFFFFFF);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Friends{uin='");
    localStringBuilder.append(this.uin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", remark='");
    localStringBuilder.append(this.remark);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", groupid=");
    localStringBuilder.append(this.groupid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", gathtertype=");
    localStringBuilder.append(this.gathtertype);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.Friends
 * JD-Core Version:    0.7.0.1
 */