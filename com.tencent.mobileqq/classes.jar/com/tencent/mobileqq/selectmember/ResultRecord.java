package com.tencent.mobileqq.selectmember;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.annotation.PluginInterface;

@PluginInterface
public class ResultRecord
  implements Parcelable
{
  public static final Parcelable.Creator<ResultRecord> CREATOR = new ResultRecord.1();
  public String gameLevelIcon;
  public String groupUin;
  public boolean isNewTroop;
  public long lastChooseTime;
  public String name;
  public String phone;
  public int type;
  public String uin;
  public int uinType = -1;
  
  public ResultRecord() {}
  
  private ResultRecord(Parcel paramParcel)
  {
    this.uin = paramParcel.readString();
    this.name = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.groupUin = paramParcel.readString();
    this.phone = paramParcel.readString();
    this.lastChooseTime = paramParcel.readLong();
    this.uinType = paramParcel.readInt();
    int i = paramParcel.readInt();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.isNewTroop = bool;
    this.gameLevelIcon = paramParcel.readString();
  }
  
  public ResultRecord(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, long paramLong, boolean paramBoolean, String paramString5)
  {
    this.uin = paramString1;
    this.name = paramString2;
    this.type = paramInt1;
    this.uinType = paramInt2;
    this.groupUin = paramString3;
    this.phone = paramString4;
    this.lastChooseTime = paramLong;
    this.isNewTroop = paramBoolean;
    this.gameLevelIcon = paramString5;
  }
  
  public ResultRecord(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    init(paramString1, paramString2, paramInt, paramString3, paramString4);
  }
  
  public static ResultRecord copyResultRecord(ResultRecord paramResultRecord)
  {
    if (paramResultRecord != null)
    {
      ResultRecord localResultRecord = new ResultRecord();
      localResultRecord.uin = paramResultRecord.uin;
      localResultRecord.name = paramResultRecord.name;
      localResultRecord.type = paramResultRecord.type;
      localResultRecord.groupUin = paramResultRecord.groupUin;
      localResultRecord.phone = paramResultRecord.phone;
      localResultRecord.uinType = paramResultRecord.uinType;
      localResultRecord.isNewTroop = paramResultRecord.isNewTroop;
      localResultRecord.gameLevelIcon = paramResultRecord.gameLevelIcon;
      return localResultRecord;
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof ResultRecord))
    {
      paramObject = (ResultRecord)paramObject;
      if ((paramObject.uin.equals(this.uin)) && (paramObject.type == this.type) && (((!TextUtils.isEmpty(this.phone)) && (!TextUtils.isEmpty(paramObject.phone)) && (this.phone.equals(paramObject.phone))) || ((TextUtils.isEmpty(this.phone)) && (TextUtils.isEmpty(paramObject.phone))))) {
        return true;
      }
    }
    return false;
  }
  
  public int getUinType()
  {
    if ((this.uinType == -1) && (this.type == 4)) {
      return 1006;
    }
    return this.uinType;
  }
  
  public void init(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    this.uin = paramString1;
    this.name = paramString2;
    this.uinType = paramInt;
    this.groupUin = paramString3;
    this.phone = paramString4;
    this.lastChooseTime = 0L;
    this.isNewTroop = false;
    this.gameLevelIcon = "";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[uin:");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(", name:");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", type:");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", groupUin:");
    localStringBuilder.append(this.groupUin);
    localStringBuilder.append(", uinType:");
    localStringBuilder.append(this.uinType);
    localStringBuilder.append(", phone:");
    localStringBuilder.append(this.phone);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.ResultRecord
 * JD-Core Version:    0.7.0.1
 */