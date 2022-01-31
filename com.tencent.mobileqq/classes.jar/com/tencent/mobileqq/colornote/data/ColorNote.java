package com.tencent.mobileqq.colornote.data;

import amhc;
import amhi;
import android.os.Bundle;
import android.text.TextUtils;
import aukm;
import aulx;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Arrays;

public class ColorNote
  extends aukm
  implements Serializable, Cloneable
{
  public static final String PARAM_EXTRA = "param_extra";
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
  @aulx
  public boolean animate;
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
  
  public ColorNote(amhc paramamhc)
  {
    this.mServiceType = paramamhc.jdField_a_of_type_Int;
    this.mSubType = paramamhc.jdField_a_of_type_JavaLangString;
    this.mSubTitle = paramamhc.c;
    this.mMainTitle = paramamhc.jdField_b_of_type_JavaLangString;
    this.mPicUrl = paramamhc.d;
    this.mReserve = paramamhc.jdField_a_of_type_ArrayOfByte;
    this.mExtra = paramamhc.jdField_b_of_type_Int;
    this.mUniKey = (paramamhc.jdField_a_of_type_Int + paramamhc.jdField_a_of_type_JavaLangString + paramamhc.jdField_b_of_type_Int);
    this.mTime = NetConnInfoCenter.getServerTime();
    if (((this.mServiceType == -1) || (TextUtils.isEmpty(this.mSubType))) && (QLog.isColorLevel())) {
      QLog.d("ColorNote", 2, "Illegal param mServiceType = " + this.mServiceType + ", mSubType = " + this.mSubType);
    }
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
    if (((this.mServiceType == -1) || (TextUtils.isEmpty(this.mSubType))) && (QLog.isColorLevel())) {
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
    } while ((this.mServiceType != paramObject.getServiceType()) || (!amhi.a(this.mSubType, paramObject.getSubType())) || (!amhi.a(this.mMainTitle, paramObject.getMainTitle())) || (!amhi.a(this.mSubTitle, paramObject.getSubTitle())) || (this.mExtra != paramObject.mExtra));
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
    return this.mServiceType + this.mSubType + this.mExtra;
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
    localBundle.putInt("param_extra", this.mExtra);
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
  
  public void setType(int paramInt)
  {
    this.mExtra = paramInt;
  }
  
  public String toString()
  {
    return "ColorNote{mServiceType=" + this.mServiceType + ", mSubType='" + this.mSubType + '\'' + ", mUniKey='" + this.mUniKey + '\'' + ", mTime=" + this.mTime + ", mMainTitle='" + this.mMainTitle + '\'' + ", mSubTitle='" + this.mSubTitle + '\'' + ", mPicUrl='" + this.mPicUrl + '\'' + ", mReserve=" + Arrays.toString(this.mReserve) + ", mState=" + this.mState + ", mExtra" + this.mExtra + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.data.ColorNote
 * JD-Core Version:    0.7.0.1
 */