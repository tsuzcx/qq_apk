package com.tencent.mobileqq.colornote.data;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(this.mServiceType));
    localStringBuilder.append(this.mSubType);
    localStringBuilder.append(this.mExtra);
    this.mUniKey = localStringBuilder.toString();
    this.mTime = NetConnInfoCenter.getServerTime();
  }
  
  public ColorNote(Bundle paramBundle)
  {
    this.mServiceType = paramBundle.getInt("param_service_type", -1);
    this.mSubType = paramBundle.getString("param_sub_type", "");
    this.mExtra = paramBundle.getInt("param_extra", 1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(this.mServiceType));
    localStringBuilder.append(this.mSubType);
    localStringBuilder.append(this.mExtra);
    this.mUniKey = localStringBuilder.toString();
    this.mTime = NetConnInfoCenter.getServerTime();
    this.mMainTitle = paramBundle.getString("param_main_title");
    this.mSubTitle = paramBundle.getString("param_sub_title");
    this.mPicUrl = paramBundle.getString("param_pic_url");
    this.mReserve = paramBundle.getByteArray("param_reserve");
    this.mExtLong = paramBundle.getLong("param_extra_flag", 0L);
    if (((this.mServiceType == -1) || (TextUtils.isEmpty(this.mSubType))) && (QLog.isColorLevel()))
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Illegal param mServiceType = ");
      paramBundle.append(this.mServiceType);
      paramBundle.append(", mSubType = ");
      paramBundle.append(this.mSubType);
      QLog.d("ColorNote", 2, paramBundle.toString());
    }
  }
  
  public ColorNote(ColorNote.Builder paramBuilder)
  {
    this.mServiceType = paramBuilder.a;
    this.mSubType = paramBuilder.b;
    this.mSubTitle = paramBuilder.e;
    this.mMainTitle = paramBuilder.d;
    this.mPicUrl = paramBuilder.f;
    this.mReserve = paramBuilder.g;
    this.mExtra = paramBuilder.c;
    this.mExtLong = paramBuilder.h;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramBuilder.a);
    localStringBuilder.append(paramBuilder.b);
    localStringBuilder.append(paramBuilder.c);
    this.mUniKey = localStringBuilder.toString();
    this.mTime = NetConnInfoCenter.getServerTime();
    if (((this.mServiceType == -1) || (TextUtils.isEmpty(this.mSubType))) && (QLog.isColorLevel()))
    {
      paramBuilder = new StringBuilder();
      paramBuilder.append("Illegal param mServiceType = ");
      paramBuilder.append(this.mServiceType);
      paramBuilder.append(", mSubType = ");
      paramBuilder.append(this.mSubType);
      QLog.d("ColorNote", 2, paramBuilder.toString());
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
  
  private static boolean propertyEquals(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1) ^ true ^ TextUtils.isEmpty(paramString2) ^ true)) {
      return false;
    }
    if (paramString1 == null) {
      return true;
    }
    return paramString1.equals(paramString2);
  }
  
  public Object clone()
  {
    super.clone();
    return deepCopy();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof ColorNote;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (ColorNote)paramObject;
    bool1 = bool2;
    if (this.mServiceType == paramObject.getServiceType())
    {
      bool1 = bool2;
      if (propertyEquals(this.mSubType, paramObject.getSubType()))
      {
        bool1 = bool2;
        if (propertyEquals(this.mMainTitle, paramObject.getMainTitle()))
        {
          bool1 = bool2;
          if (propertyEquals(this.mSubTitle, paramObject.getSubTitle()))
          {
            bool1 = bool2;
            if (this.mExtra == paramObject.mExtra) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mServiceType);
    localStringBuilder.append(this.mSubType);
    localStringBuilder.append(this.mExtra);
    return localStringBuilder.toString();
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
    localBundle.putLong("param_extra_flag", this.mExtLong);
    return localBundle;
  }
  
  public void setState(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setState [ ");
      String str;
      if (paramInt == 2) {
        str = "STATE_OPEN ]";
      } else {
        str = "STATE_NORMAL ]";
      }
      localStringBuilder.append(str);
      QLog.d("ColorNote", 2, localStringBuilder.toString());
    }
    this.mState = paramInt;
  }
  
  public void setType(int paramInt)
  {
    this.mExtra = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hash: ");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(". ColorNote{mServiceType=");
    localStringBuilder.append(this.mServiceType);
    localStringBuilder.append(", mSubType='");
    localStringBuilder.append(this.mSubType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mUniKey='");
    localStringBuilder.append(this.mUniKey);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mTime=");
    localStringBuilder.append(this.mTime);
    localStringBuilder.append(", mMainTitle='");
    localStringBuilder.append(this.mMainTitle);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mSubTitle='");
    localStringBuilder.append(this.mSubTitle);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mPicUrl='");
    localStringBuilder.append(this.mPicUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mState=");
    localStringBuilder.append(this.mState);
    localStringBuilder.append(", mExtra");
    localStringBuilder.append(this.mExtra);
    localStringBuilder.append(", extLong");
    localStringBuilder.append(this.mExtLong);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.data.ColorNote
 * JD-Core Version:    0.7.0.1
 */