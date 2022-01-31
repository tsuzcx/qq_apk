package com.tencent.txproxy;

import android.content.Intent;

public class RunPluginParams
{
  private static final String TAG = "OpenRoomParam";
  public Intent intent;
  public String mAddr_city;
  public String mAddr_country;
  public String mAddr_province;
  public int mAge = 0;
  public String mAppid = "";
  public String mAuthId;
  public String mAuthKey;
  public int mAuthType = 1;
  public int mBirthDay = 0;
  public int mBirthMonth = 0;
  public int mBirthYear = 0;
  public boolean mDownloadInHost = false;
  boolean mFourceClearLocalPlugin = false;
  public String mFromId = "0";
  public int mGender = 0;
  public String mHometown_city;
  public String mHometown_country;
  public String mHometown_province;
  public String mLaunchSchema;
  public String mLauncherName = "";
  public boolean mLogInHost = false;
  public boolean mNeedConfirmNetworkBeforeDownload = true;
  public String mNickName;
  public String mPackageName;
  public boolean mReportInHost = false;
  public long mRoomId = 0L;
  public String mRoomName;
  public String mSourceId;
  public String mUserData;
  public String mVasName = "";
  public int mVasType = 0;
  public String mXAppMainActivityName = "com.tencent.intervideo.xapp.LauncherActivity";
  public String mXAppPackageName = "com.tencent.intervideo.xapp";
  public boolean useDefaultLoading = true;
  public String vasSchema;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.txproxy.RunPluginParams
 * JD-Core Version:    0.7.0.1
 */