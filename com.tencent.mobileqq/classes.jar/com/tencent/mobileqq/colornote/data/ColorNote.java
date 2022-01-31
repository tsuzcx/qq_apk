package com.tencent.mobileqq.colornote.data;

import alsl;
import alsr;
import android.os.Bundle;
import android.text.TextUtils;
import atmo;
import atnz;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Arrays;

public class ColorNote
  extends atmo
  implements Serializable
{
  public static final String PARAM_MAINTITLE = "param_main_title";
  public static final String PARAM_PIC_URL = "param_pic_url";
  public static final String PARAM_RESERVE = "param_reserve";
  public static final String PARAM_SERVICETYPE = "param_service_type";
  public static final String PARAM_SUBTITLE = "param_sub_title";
  public static final String PARAM_SUBTYPE = "param_sub_type";
  public static final int STATE_NORMAL = 1;
  public static final int STATE_OPEN = 2;
  public static final String TAG = "ColorNote";
  private static final long serialVersionUID = -2145926824830169542L;
  @atnz
  public boolean animate;
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
    this.mUniKey = (String.valueOf(this.mServiceType) + this.mSubType);
    this.mTime = NetConnInfoCenter.getServerTime();
  }
  
  public ColorNote(alsl paramalsl)
  {
    this.mServiceType = paramalsl.jdField_a_of_type_Int;
    this.mSubType = paramalsl.jdField_a_of_type_JavaLangString;
    this.mSubTitle = paramalsl.c;
    this.mMainTitle = paramalsl.b;
    this.mPicUrl = paramalsl.d;
    this.mReserve = paramalsl.jdField_a_of_type_ArrayOfByte;
    this.mUniKey = (paramalsl.jdField_a_of_type_Int + paramalsl.jdField_a_of_type_JavaLangString);
    this.mTime = NetConnInfoCenter.getServerTime();
    if (((this.mServiceType == -1) || (TextUtils.isEmpty(this.mSubType))) && (QLog.isColorLevel())) {
      QLog.d("ColorNote", 2, "Illegal param mServiceType = " + this.mServiceType + ", mSubType = " + this.mSubType);
    }
  }
  
  public ColorNote(Bundle paramBundle)
  {
    this.mServiceType = paramBundle.getInt("param_service_type", -1);
    this.mSubType = paramBundle.getString("param_sub_type", "");
    this.mUniKey = (String.valueOf(this.mServiceType) + this.mSubType);
    this.mTime = NetConnInfoCenter.getServerTime();
    this.mMainTitle = paramBundle.getString("param_main_title");
    this.mSubTitle = paramBundle.getString("param_sub_title");
    this.mPicUrl = paramBundle.getString("param_pic_url");
    this.mReserve = paramBundle.getByteArray("param_reserve");
    if (((this.mServiceType == -1) || (TextUtils.isEmpty(this.mSubType))) && (QLog.isColorLevel())) {
      QLog.d("ColorNote", 2, "Illegal param mServiceType = " + this.mServiceType + ", mSubType = " + this.mSubType);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ColorNote)) {}
    do
    {
      return false;
      paramObject = (ColorNote)paramObject;
    } while ((this.mServiceType != paramObject.getServiceType()) || (!alsr.a(this.mSubType, paramObject.getSubType())) || (!alsr.a(this.mMainTitle, paramObject.getMainTitle())) || (!alsr.a(this.mSubTitle, paramObject.getSubTitle())));
    return true;
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
    return this.mUniKey;
  }
  
  public boolean isOpen()
  {
    return this.mState == 2;
  }
  
  public boolean isTitleAndPicValid()
  {
    return (!TextUtils.isEmpty(this.mMainTitle)) && (!TextUtils.isEmpty(this.mSubTitle)) && (!TextUtils.isEmpty(this.mPicUrl));
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
    return localBundle;
  }
  
  public void setState(int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("setState [ ");
      if (paramInt != 2) {
        break label47;
      }
    }
    label47:
    for (String str = "STATE_OPEN ]";; str = "STATE_NORMAL ]")
    {
      QLog.d("ColorNote", 2, str);
      this.mState = paramInt;
      return;
    }
  }
  
  public String toString()
  {
    return "ColorNote{mServiceType=" + this.mServiceType + ", mSubType='" + this.mSubType + '\'' + ", mUniKey='" + this.mUniKey + '\'' + ", mTime=" + this.mTime + ", mMainTitle='" + this.mMainTitle + '\'' + ", mSubTitle='" + this.mSubTitle + '\'' + ", mPicUrl='" + this.mPicUrl + '\'' + ", mReserve=" + Arrays.toString(this.mReserve) + ", mState=" + this.mState + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.data.ColorNote
 * JD-Core Version:    0.7.0.1
 */