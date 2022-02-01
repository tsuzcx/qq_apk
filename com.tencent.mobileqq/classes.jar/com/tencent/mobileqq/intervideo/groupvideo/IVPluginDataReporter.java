package com.tencent.mobileqq.intervideo.groupvideo;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.intervideo.IAppSettingUtil;
import com.tencent.mobileqq.intervideo.IBaseApplicationImplUtil;
import com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVPluginReportInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;

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
  private String mQQVersion = ((IAppSettingUtil)QRoute.api(IAppSettingUtil.class)).getSubVersion();
  private String mRoomType;
  private String mRoomid;
  private String mSdkversion = String.valueOf(ApkUtils.a(((IBaseApplicationImplUtil)QRoute.api(IBaseApplicationImplUtil.class)).getContext()));
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
    String str1 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HttpUtil.getNetWorkType());
    ((StringBuilder)localObject).append("");
    this.networktype = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("IVPluginDataReporter: department = ");
      ((StringBuilder)localObject).append(this.mDepartment);
      ((StringBuilder)localObject).append(" op_type = ");
      ((StringBuilder)localObject).append(this.mOpType);
      ((StringBuilder)localObject).append(" op_name = ");
      ((StringBuilder)localObject).append(this.mOpName);
      ((StringBuilder)localObject).append(" op_in = ");
      ((StringBuilder)localObject).append(this.mOpIn);
      ((StringBuilder)localObject).append(" d1= ");
      ((StringBuilder)localObject).append(this.d1);
      ((StringBuilder)localObject).append(" d2=");
      ((StringBuilder)localObject).append(this.d2);
      ((StringBuilder)localObject).append(" d3=");
      ((StringBuilder)localObject).append(this.d3);
      ((StringBuilder)localObject).append(" d4=");
      ((StringBuilder)localObject).append(this.d4);
      ((StringBuilder)localObject).append(" timelong=");
      ((StringBuilder)localObject).append(this.mTimeLong);
      ((StringBuilder)localObject).append(" op_result = ");
      ((StringBuilder)localObject).append(this.mOpResult);
      ((StringBuilder)localObject).append(" qq_version = ");
      ((StringBuilder)localObject).append(this.mQQVersion);
      QLog.d("IVPluginDataReporter", 1, ((StringBuilder)localObject).toString());
    }
    if ((!TextUtils.isEmpty(this.mDepartment)) && (!TextUtils.isEmpty(this.mOpName)) && (!TextUtils.isEmpty(this.mOpType)))
    {
      localObject = this.mDepartment;
      String str2 = this.mToUin;
      String str3 = this.mOpType;
      String str4 = this.mOpName;
      int i = this.mOpIn;
      int j = this.mOpResult;
      String str5 = this.d1;
      String str6 = this.d2;
      String str7 = this.d3;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d4);
      localStringBuilder.append("|");
      localStringBuilder.append(this.mTimeLong);
      localStringBuilder.append("|");
      localStringBuilder.append(this.mRoomid);
      localStringBuilder.append("|");
      localStringBuilder.append(this.mRoomType);
      localStringBuilder.append("|");
      localStringBuilder.append(this.mSource);
      localStringBuilder.append("|");
      localStringBuilder.append(this.networktype);
      localStringBuilder.append("|");
      localStringBuilder.append(this.mPlatform);
      localStringBuilder.append("|");
      localStringBuilder.append(this.mMacVersion);
      localStringBuilder.append("|");
      localStringBuilder.append(this.mSysVersion);
      localStringBuilder.append("|");
      localStringBuilder.append(this.mFrameVersion);
      localStringBuilder.append("|");
      localStringBuilder.append(this.mSdkversion);
      localStringBuilder.append("|");
      localStringBuilder.append(this.mQQVersion);
      localStringBuilder.append("|");
      localStringBuilder.append(str1);
      localStringBuilder.append("|");
      localStringBuilder.append(this.mLastOpName);
      ReportController.b(null, "dc03445", (String)localObject, str2, str3, str4, i, 1, j, str5, str6, str7, localStringBuilder.toString());
      return;
    }
    QLog.e("IVPluginDataReporter", 1, "has null str ,stop report");
  }
  
  public IVPluginDataReporter toUin(String paramString)
  {
    this.mToUin = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter
 * JD-Core Version:    0.7.0.1
 */