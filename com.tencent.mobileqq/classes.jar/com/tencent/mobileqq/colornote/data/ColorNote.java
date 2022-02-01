package com.tencent.mobileqq.colornote.data;

import android.os.Bundle;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Arrays;

@KeepClassConstructor
public class ColorNote
  extends Entity
  implements Serializable, Cloneable
{
  public static final String PARAM_EXTRA = "param_extra";
  public static final String PARAM_EXTRA_FLAG = "param_extra_flag";
  public static final String PARAM_MAINTITLE = "param_main_title";
  public static final String PARAM_PIC_URL = "param_pic_url";
  public static final String PARAM_RESERVE = "param_reserve";
  public static final String PARAM_SERVICETYPE = "param_service_type";
  public static final String PARAM_SUBTITLE = "param_sub_title";
  public static final String PARAM_SUBTYPE = "param_sub_type";
  public static final int STATE_NORMAL = 1;
  public static final int STATE_OPEN = 2;
  public static final String TAG = "ColorNote";
  public static final int TYPE_HISTORY = 2;
  public static final int TYPE_NORMAL = 0;
  private static final long serialVersionUID = -2145926824830169542L;
  @notColumn
  public boolean animate;
  public long mExtLong;
  public int mExtra = 0;
  public String mMainTitle;
  public String mPicUrl;
  public byte[] mReserve;
  public final int mServiceType;
  public int mState = 1;
  public String mSubTitle;
  public final String mSubType;
  public final long mTime;
  public final String mUniKey;
  
  @Deprecated
  public ColorNote()
  {
    this.mServiceType = -1;
    this.mSubType = "";
    this.mUniKey = (String.valueOf(this.mServiceType) + this.mSubType + this.mExtra);
    this.mTime = NetConnInfoCenter.getServerTime();
  }
  
  public ColorNote(Bundle paramBundle)
  {
    this.mServiceType = paramBundle.getInt("param_service_type", -1);
    this.mSubType = paramBundle.getString("param_sub_type", "");
    this.mExtra = paramBundle.getInt("param_extra", 1);
    this.mUniKey = (String.valueOf(this.mServiceType) + this.mSubType + this.mExtra);
    this.mTime = NetConnInfoCenter.getServerTime();
    this.mMainTitle = paramBundle.getString("param_main_title");
    this.mSubTitle = paramBundle.getString("param_sub_title");
    this.mPicUrl = paramBundle.getString("param_pic_url");
    this.mReserve = paramBundle.getByteArray("param_reserve");
    this.mExtLong = paramBundle.getLong("param_extra_flag", 0L);
    if (((this.mServiceType == -1) || (StringUtil.a(this.mSubType))) && (QLog.isColorLevel())) {
      QLog.d("ColorNote", 2, "Illegal param mServiceType = " + this.mServiceType + ", mSubType = " + this.mSubType);
    }
  }
  
  public ColorNote(ColorNote.Builder paramBuilder)
  {
    this.mServiceType = paramBuilder.jdField_a_of_type_Int;
    this.mSubType = paramBuilder.jdField_a_of_type_JavaLangString;
    this.mSubTitle = paramBuilder.c;
    this.mMainTitle = paramBuilder.jdField_b_of_type_JavaLangString;
    this.mPicUrl = paramBuilder.d;
    this.mReserve = paramBuilder.jdField_a_of_type_ArrayOfByte;
    this.mExtra = paramBuilder.jdField_b_of_type_Int;
    this.mExtLong = paramBuilder.jdField_a_of_type_Long;
    this.mUniKey = (paramBuilder.jdField_a_of_type_Int + paramBuilder.jdField_a_of_type_JavaLangString + paramBuilder.jdField_b_of_type_Int);
    this.mTime = NetConnInfoCenter.getServerTime();
    if (((this.mServiceType == -1) || (StringUtil.a(this.mSubType))) && (QLog.isColorLevel())) {
      QLog.d("ColorNote", 2, "Illegal param mServiceType = " + this.mServiceType + ", mSubType = " + this.mSubType);
    }
  }
  
  public ColorNote(ColorNote paramColorNote)
  {
    this.mServiceType = paramColorNote.getServiceType();
    this.mSubType = paramColorNote.getSubType();
    this.mUniKey = paramColorNote.getUniKey();
    this.mTime = paramColorNote.mTime;
    this.mMainTitle = paramColorNote.getMainTitle();
    this.mSubTitle = paramColorNote.getSubTitle();
    this.mPicUrl = paramColorNote.getPicUrl();
    this.mReserve = paramColorNote.getReserve();
    this.mState = paramColorNote.getState();
    this.mExtra = paramColorNote.mExtra;
    this.animate = paramColorNote.animate;
    this.mExtLong = paramColorNote.mExtLong;
  }
  
  private ColorNote deepCopy()
  {
    return new ColorNote(this);
  }
  
  public Object clone()
  {
    super.clone();
    return deepCopy();
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ColorNote)) {}
    do
    {
      return false;
      paramObject = (ColorNote)paramObject;
    } while ((this.mServiceType != paramObject.getServiceType()) || (!ColorNoteUtils.a(this.mSubType, paramObject.getSubType())) || (!ColorNoteUtils.a(this.mMainTitle, paramObject.getMainTitle())) || (!ColorNoteUtils.a(this.mSubTitle, paramObject.getSubTitle())) || (this.mExtra != paramObject.mExtra));
    return true;
  }
  
  public long getExtLong()
  {
    return this.mExtLong;
  }
  
  public String getMainTitle()
  {
    return this.mMainTitle;
  }
  
  public String getPicUrl()
  {
    return this.mPicUrl;
  }
  
  public byte[] getReserve()
  {
    return this.mReserve;
  }
  
  public int getServiceType()
  {
    return this.mServiceType;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public String getSubTitle()
  {
    return this.mSubTitle;
  }
  
  public String getSubType()
  {
    return this.mSubType;
  }
  
  public long getTime()
  {
    return this.mTime;
  }
  
  public String getUniKey()
  {
    return this.mServiceType + this.mSubType + this.mExtra;
  }
  
  public boolean isOpen()
  {
    return this.mState == 2;
  }
  
  public boolean isTitleAndPicValid()
  {
    return (!StringUtil.a(this.mMainTitle)) && (!StringUtil.a(this.mSubTitle)) && (!StringUtil.a(this.mPicUrl));
  }
  
  public Bundle parseBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("param_service_type", this.mServiceType);
    localBundle.putString("param_sub_type", this.mSubType);
    localBundle.putString("param_main_title", this.mMainTitle);
    localBundle.putString("param_sub_title", this.mSubTitle);
    localBundle.putString("param_pic_url", this.mPicUrl);
    localBundle.putByteArray("param_reserve", this.mReserve);
    localBundle.putInt("param_extra", this.mExtra);
    localBundle.putLong("param_extra_flag", this.mExtLong);
    return localBundle;
  }
  
  public void setState(int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("setState [ ");
      if (paramInt != 2) {
        break label49;
      }
    }
    label49:
    for (String str = "STATE_OPEN ]";; str = "STATE_NORMAL ]")
    {
      QLog.d("ColorNote", 2, str);
      this.mState = paramInt;
      return;
    }
  }
  
  public void setType(int paramInt)
  {
    this.mExtra = paramInt;
  }
  
  public String toString()
  {
    return "hash: " + hashCode() + ". ColorNote{mServiceType=" + this.mServiceType + ", mSubType='" + this.mSubType + '\'' + ", mUniKey='" + this.mUniKey + '\'' + ", mTime=" + this.mTime + ", mMainTitle='" + this.mMainTitle + '\'' + ", mSubTitle='" + this.mSubTitle + '\'' + ", mPicUrl='" + this.mPicUrl + '\'' + ", mReserve=" + Arrays.toString(this.mReserve) + ", mState=" + this.mState + ", mExtra" + this.mExtra + ", extLong" + this.mExtLong + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.data.ColorNote
 * JD-Core Version:    0.7.0.1
 */