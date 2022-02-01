package com.tencent.mobileqq.qcall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.utils.StringUtil;

public class QCallCardInfo
  extends Entity
  implements Parcelable, Cloneable
{
  public static final int CARD_BLACK = 2;
  public static final int CARD_FREE = 1;
  public static final Parcelable.Creator<QCallCardInfo> CREATOR = new QCallCardInfo.1();
  public static int HIDE = 1;
  public static final int NONE = 0;
  public static int SHOW;
  public String autoRemark;
  public int birthday;
  @notColumn
  public int card_type;
  @notColumn
  public int contact_qq_status;
  @notColumn
  public int freeStatus;
  public int gender;
  public int identity;
  public int in_use_flag;
  @notColumn
  public int isPopup;
  public int is_ever_pstn;
  public View.OnClickListener mOnClickListener;
  public int netstatus;
  public String nickname;
  public int normal_all_free_time;
  public int normal_left_free_time;
  public int phone_mask;
  public String phonenum;
  public int pre_recycle_flag;
  @notColumn
  public int pstn_freeStatus;
  @notColumn
  public int qid_qq_status;
  public String qq;
  @Deprecated
  public long qqUin;
  public String qqUin2;
  public int recycle_flag;
  public String recycle_ip;
  public int recycle_time;
  public String reg_ip;
  public int reg_time;
  public String remark;
  @unique
  public String uin;
  public int used_free_time;
  public int vip_all_free_time;
  public int vip_left_free_time;
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getCardType()
  {
    return this.card_type;
  }
  
  public boolean isHideMobile()
  {
    return this.phone_mask == HIDE;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[ qid=");
    localStringBuilder.append(UinUtils.c(this.uin));
    localStringBuilder.append(",nickname=");
    localStringBuilder.append(StringUtil.crypticCenter(this.nickname));
    localStringBuilder.append(",in_use_flag=");
    localStringBuilder.append(this.in_use_flag);
    localStringBuilder.append(",phoneNum=");
    localStringBuilder.append(UinUtils.c(this.phonenum));
    localStringBuilder.append(",phone_mask=");
    localStringBuilder.append(this.phone_mask);
    localStringBuilder.append(",qqUin=");
    localStringBuilder.append(UinUtils.c(this.qq));
    localStringBuilder.append(",qqUin2=");
    localStringBuilder.append(UinUtils.c(this.qqUin2));
    localStringBuilder.append(",remark=");
    localStringBuilder.append(this.remark);
    localStringBuilder.append(",network=");
    localStringBuilder.append(this.netstatus);
    localStringBuilder.append(",autoRemark=");
    localStringBuilder.append(this.autoRemark);
    localStringBuilder.append(",freestatus=");
    localStringBuilder.append(this.freeStatus);
    localStringBuilder.append(",pstn_freestatus=");
    localStringBuilder.append(this.pstn_freeStatus);
    localStringBuilder.append(",card_type=");
    localStringBuilder.append(this.card_type);
    localStringBuilder.append(",is_ever_pstn=");
    localStringBuilder.append(this.is_ever_pstn);
    localStringBuilder.append(",vip_all_free_time=");
    localStringBuilder.append(this.vip_all_free_time);
    localStringBuilder.append(",vip_left_free_time=");
    localStringBuilder.append(this.vip_left_free_time);
    localStringBuilder.append(",normal_all_free_time=");
    localStringBuilder.append(this.normal_all_free_time);
    localStringBuilder.append(",normal_left_free_time=");
    localStringBuilder.append(this.normal_left_free_time);
    localStringBuilder.append(",used_free_time=");
    localStringBuilder.append(this.used_free_time);
    localStringBuilder.append(",identity=");
    localStringBuilder.append(this.identity);
    localStringBuilder.append(",isPopup=");
    localStringBuilder.append(this.isPopup);
    localStringBuilder.append(",qid_qq_status=");
    localStringBuilder.append(this.qid_qq_status);
    localStringBuilder.append(",contact_qq_status=");
    localStringBuilder.append(this.contact_qq_status);
    localStringBuilder.append(" ] ");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeString(this.uin);
      paramParcel.writeString(this.nickname);
      paramParcel.writeInt(this.gender);
      paramParcel.writeInt(this.birthday);
      paramParcel.writeInt(this.in_use_flag);
      paramParcel.writeInt(this.pre_recycle_flag);
      paramParcel.writeInt(this.recycle_flag);
      paramParcel.writeInt(this.reg_time);
      paramParcel.writeString(this.reg_ip);
      paramParcel.writeInt(this.recycle_time);
      paramParcel.writeString(this.recycle_ip);
      paramParcel.writeString(this.remark);
      paramParcel.writeInt(this.netstatus);
      paramParcel.writeString(this.qq);
      paramParcel.writeString(this.phonenum);
      paramParcel.writeInt(this.phone_mask);
      paramParcel.writeInt(this.freeStatus);
      paramParcel.writeInt(this.pstn_freeStatus);
      paramParcel.writeInt(this.is_ever_pstn);
      paramParcel.writeInt(this.vip_all_free_time);
      paramParcel.writeInt(this.vip_left_free_time);
      paramParcel.writeInt(this.normal_all_free_time);
      paramParcel.writeInt(this.normal_left_free_time);
      paramParcel.writeInt(this.used_free_time);
      paramParcel.writeInt(this.identity);
      paramParcel.writeString(this.autoRemark);
      paramParcel.writeInt(this.card_type);
      paramParcel.writeInt(this.isPopup);
      paramParcel.writeString(this.qqUin2);
      paramParcel.writeInt(this.qid_qq_status);
      paramParcel.writeInt(this.contact_qq_status);
      return;
    }
    catch (RuntimeException paramParcel) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallCardInfo
 * JD-Core Version:    0.7.0.1
 */