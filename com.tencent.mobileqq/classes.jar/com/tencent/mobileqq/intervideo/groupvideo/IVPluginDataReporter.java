package com.tencent.mobileqq.intervideo.groupvideo;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import apao;
import azqs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVPluginReportInterface;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import ndd;

public class IVPluginDataReporter
  implements IVPluginReportInterface
{
  public static final String REPORT_TAG = "dc03445";
  private static final String TAG = "IVPluginDataReporter";
  private String d1 = "";
  private String d2 = "";
  private String d3 = "";
  private String d4 = "";
  private String mDepartment;
  private int mFrameVersion;
  private String mLastOpName;
  private String mMacVersion = Build.MODEL;
  private int mOpIn;
  private String mOpName = "";
  private int mOpResult;
  private String mOpType = "";
  private int mPlatform = 2;
  private String mQQVersion = "8.3.5";
  private String mRoomType;
  private String mRoomid;
  private String mSdkversion = String.valueOf(apao.a(BaseApplicationImpl.getContext()));
  private String mSource;
  private String mSysVersion = Build.VERSION.RELEASE;
  private String mTimeLong;
  private String mToUin = "";
  private String networktype = "";
  
  public IVPluginDataReporter d1(String paramString)
  {
    this.d1 = paramString;
    return this;
  }
  
  public IVPluginDataReporter d2(String paramString)
  {
    this.d2 = paramString;
    return this;
  }
  
  public IVPluginDataReporter d3(String paramString)
  {
    this.d3 = paramString;
    return this;
  }
  
  public IVPluginDataReporter d4(String paramString)
  {
    this.d4 = paramString;
    return this;
  }
  
  public IVPluginDataReporter opDepartment(String paramString)
  {
    this.mDepartment = paramString;
    return this;
  }
  
  public IVPluginDataReporter opIn(int paramInt)
  {
    this.mOpIn = paramInt;
    return this;
  }
  
  public IVPluginDataReporter opName(String paramString)
  {
    this.mOpName = paramString;
    return this;
  }
  
  public IVPluginDataReporter opResult(int paramInt)
  {
    this.mOpResult = paramInt;
    return this;
  }
  
  public IVPluginDataReporter opType(String paramString)
  {
    this.mOpType = paramString;
    return this;
  }
  
  public void report()
  {
    String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
    this.networktype = (ndd.a() + "");
    if (QLog.isColorLevel()) {
      QLog.d("IVPluginDataReporter", 1, "IVPluginDataReporter: department = " + this.mDepartment + " op_type = " + this.mOpType + " op_name = " + this.mOpName + " op_in = " + this.mOpIn + " d1= " + this.d1 + " d2=" + this.d2 + " d3=" + this.d3 + " d4=" + this.d4 + " timelong=" + this.mTimeLong + " op_result = " + this.mOpResult + " qq_version = " + this.mQQVersion);
    }
    if ((TextUtils.isEmpty(this.mDepartment)) || (TextUtils.isEmpty(this.mOpName)) || (TextUtils.isEmpty(this.mOpType)))
    {
      QLog.e("IVPluginDataReporter", 1, "has null str ,stop report");
      return;
    }
    azqs.b(null, "dc03445", this.mDepartment, this.mToUin, this.mOpType, this.mOpName, this.mOpIn, 1, this.mOpResult, this.d1, this.d2, this.d3, this.d4 + "|" + this.mTimeLong + "|" + this.mRoomid + "|" + this.mRoomType + "|" + this.mSource + "|" + this.networktype + "|" + this.mPlatform + "|" + this.mMacVersion + "|" + this.mSysVersion + "|" + this.mFrameVersion + "|" + this.mSdkversion + "|" + this.mQQVersion + "|" + str + "|" + this.mLastOpName);
  }
  
  public IVPluginDataReporter toUin(String paramString)
  {
    this.mToUin = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter
 * JD-Core Version:    0.7.0.1
 */