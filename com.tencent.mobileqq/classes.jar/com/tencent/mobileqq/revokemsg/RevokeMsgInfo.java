package com.tencent.mobileqq.revokemsg;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class RevokeMsgInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RevokeMsgInfo> CREATOR = new RevokeMsgInfo.1();
  public int a;
  public long b;
  public String c;
  public String d;
  public String e;
  public long f;
  public long g;
  public String h;
  public int i;
  public int j;
  public int k;
  public String l;
  public int m;
  public int n = 0;
  public boolean o = true;
  public int p = 0;
  public String q = "";
  
  public RevokeMsgInfo() {}
  
  public RevokeMsgInfo(MessageRecord paramMessageRecord)
  {
    this.a = paramMessageRecord.istroop;
    this.c = paramMessageRecord.frienduin;
    this.b = paramMessageRecord.shmsgseq;
    this.f = paramMessageRecord.msgUid;
    this.g = paramMessageRecord.time;
    this.h = paramMessageRecord.senderuin;
    this.i = paramMessageRecord.longMsgId;
    this.j = paramMessageRecord.longMsgCount;
    this.k = paramMessageRecord.longMsgIndex;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @SuppressLint({"DefaultLocale"})
  public String toString()
  {
    return String.format("RevokeMsgInfo[istroop= %d, shmsgseq= %d, frienduin= %s, fromuin= %s msguid= %d, time= %d, senduin= %s, longmsgid= %d, longmsgcount=%d longmsgindex=%d, showGrayTips = %s, grayTipsWordingId = %d, grayTipsWording = %s", new Object[] { Integer.valueOf(this.a), Long.valueOf(this.b), this.c, this.d, Long.valueOf(this.f), Long.valueOf(this.g), this.h, Integer.valueOf(this.i), Integer.valueOf(this.j), Integer.valueOf(this.k), Boolean.valueOf(this.o), Integer.valueOf(this.p), this.q });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeInt(this.a);
      paramParcel.writeLong(this.b);
      paramParcel.writeString(this.c);
      paramParcel.writeString(this.h);
      paramParcel.writeLong(this.f);
      paramParcel.writeLong(this.g);
      paramParcel.writeString(this.l);
      paramParcel.writeInt(this.m);
      paramParcel.writeInt(this.n);
      if (!this.o) {
        break label125;
      }
      paramInt = 1;
    }
    catch (Exception paramParcel)
    {
      for (;;)
      {
        continue;
        label125:
        paramInt = 0;
      }
    }
    paramParcel.writeInt(paramInt);
    paramParcel.writeInt(this.p);
    paramParcel.writeString(this.q);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("revokeMsg", 2, "revokeMsgInfo writeToParcel failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.revokemsg.RevokeMsgInfo
 * JD-Core Version:    0.7.0.1
 */