package com.tencent.mobileqq.qcall;

import agub;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class PstnCardInfo
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new agub();
  public int pstn_c2c_call_time;
  public int pstn_c2c_last_guide_recharge_time;
  public int pstn_c2c_try_status;
  public int pstn_c2c_vip;
  public int pstn_ever_c2c_vip;
  public int pstn_ever_multi_vip;
  public int pstn_multi_call_time;
  public int pstn_multi_last_guide_recharge_time;
  public int pstn_multi_try_status;
  public int pstn_multi_vip;
  @unique
  public String uin;
  
  public PstnCardInfo() {}
  
  public PstnCardInfo(Parcel paramParcel)
  {
    this.uin = paramParcel.readString();
    this.pstn_c2c_vip = paramParcel.readInt();
    this.pstn_multi_vip = paramParcel.readInt();
    this.pstn_ever_c2c_vip = paramParcel.readInt();
    this.pstn_ever_multi_vip = paramParcel.readInt();
    this.pstn_c2c_try_status = paramParcel.readInt();
    this.pstn_multi_try_status = paramParcel.readInt();
    this.pstn_c2c_call_time = paramParcel.readInt();
    this.pstn_multi_call_time = paramParcel.readInt();
    this.pstn_c2c_last_guide_recharge_time = paramParcel.readInt();
    this.pstn_multi_last_guide_recharge_time = paramParcel.readInt();
    if (this.pstn_ever_c2c_vip != 0) {
      this.pstn_c2c_try_status = 1;
    }
    if (this.pstn_ever_multi_vip != 0) {
      this.pstn_multi_try_status = 1;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(" == PstnCardInfo : ");
    localStringBuilder.append("pstn_c2c_vip: ").append(this.pstn_c2c_vip).append(",pstn_multi_vip: ").append(this.pstn_multi_vip).append(", pstn_ever_c2c_vip: ").append(this.pstn_ever_c2c_vip).append(", pstn_ever_multi_vip: ").append(this.pstn_ever_multi_vip).append(", pstn_c2c_try_status: ").append(this.pstn_c2c_try_status).append(", pstn_multi_try_status: ").append(this.pstn_multi_try_status).append(", pstn_c2c_call_time: ").append(this.pstn_c2c_call_time).append(", pstn_multi_call_time: ").append(this.pstn_multi_call_time).append(", pstn_c2c_last_guide_recharge_time: ").append(this.pstn_c2c_last_guide_recharge_time).append(", pstn_multi_last_guide_recharge_time: ").append(this.pstn_multi_last_guide_recharge_time);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.uin);
    paramParcel.writeInt(this.pstn_c2c_vip);
    paramParcel.writeInt(this.pstn_multi_vip);
    paramParcel.writeInt(this.pstn_ever_c2c_vip);
    paramParcel.writeInt(this.pstn_ever_multi_vip);
    paramParcel.writeInt(this.pstn_c2c_try_status);
    paramParcel.writeInt(this.pstn_multi_try_status);
    paramParcel.writeInt(this.pstn_c2c_call_time);
    paramParcel.writeInt(this.pstn_multi_call_time);
    paramParcel.writeInt(this.pstn_c2c_last_guide_recharge_time);
    paramParcel.writeInt(this.pstn_multi_last_guide_recharge_time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.PstnCardInfo
 * JD-Core Version:    0.7.0.1
 */