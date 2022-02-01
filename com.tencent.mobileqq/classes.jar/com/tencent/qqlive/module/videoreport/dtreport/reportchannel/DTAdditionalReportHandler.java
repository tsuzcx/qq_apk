package com.tencent.qqlive.module.videoreport.dtreport.reportchannel;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqlive.module.videoreport.IAdditionalReportListener;
import com.tencent.qqlive.module.videoreport.ISessionChangeListener;
import com.tencent.qqlive.module.videoreport.SessionChangeReason;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider;

public class DTAdditionalReportHandler
  implements IAdditionalReportListener, ISessionChangeListener
{
  private static final String TAG = "DTAdditionalReportHandl";
  private String mLastCallFrom = "";
  private String mLastCallScheme = "";
  private int mLastStartType = -1;
  
  private DTAdditionalReportHandler()
  {
    VideoReport.registerSessionChangeListener(this);
  }
  
  public static DTAdditionalReportHandler getInstance()
  {
    return DTAdditionalReportHandler.InstanceHolder.INSTANCE;
  }
  
  private boolean handleAppVstEvent()
  {
    Object localObject = DTEventDynamicParams.getInstance().getDTParamProvider();
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    int j = ((IDTParamProvider)localObject).getStartType();
    String str = ((IDTParamProvider)localObject).getCallFrom();
    localObject = ((IDTParamProvider)localObject).getCallScheme();
    if (VideoReport.isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleAppVstEvent: startType=");
      localStringBuilder.append(j);
      localStringBuilder.append(", callFrom=");
      localStringBuilder.append(str);
      localStringBuilder.append(", callScheme=");
      localStringBuilder.append((String)localObject);
      Log.i("DTAdditionalReportHandl", localStringBuilder.toString());
    }
    boolean bool3 = isStartParamsChanged(j, str, (String)localObject);
    int i;
    if (j == 0) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool1 = bool2;
    if (i == 0)
    {
      bool1 = bool2;
      if (bool3)
      {
        this.mLastStartType = j;
        this.mLastCallFrom = str;
        this.mLastCallScheme = ((String)localObject);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean isStartParamsChanged(int paramInt, String paramString1, String paramString2)
  {
    return (this.mLastStartType != paramInt) || (!TextUtils.equals(this.mLastCallFrom, paramString1)) || (!TextUtils.equals(this.mLastCallScheme, paramString2));
  }
  
  private void updateAppStartParams()
  {
    Object localObject = DTEventDynamicParams.getInstance().getDTParamProvider();
    if (localObject == null) {
      return;
    }
    this.mLastStartType = ((IDTParamProvider)localObject).getStartType();
    this.mLastCallFrom = ((IDTParamProvider)localObject).getCallFrom();
    this.mLastCallScheme = ((IDTParamProvider)localObject).getCallScheme();
    if (VideoReport.isDebugMode())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateAppStartParams: mLastStartType=");
      ((StringBuilder)localObject).append(this.mLastStartType);
      ((StringBuilder)localObject).append("， mLastCallFrom=");
      ((StringBuilder)localObject).append(this.mLastCallFrom);
      ((StringBuilder)localObject).append("， mLastCallScheme=");
      ((StringBuilder)localObject).append(this.mLastCallScheme);
      Log.i("DTAdditionalReportHandl", ((StringBuilder)localObject).toString());
    }
  }
  
  public void changeSession(SessionChangeReason paramSessionChangeReason)
  {
    if (VideoReport.isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("changeSession: reason=");
      localStringBuilder.append(paramSessionChangeReason);
      Log.i("DTAdditionalReportHandl", localStringBuilder.toString());
    }
    updateAppStartParams();
  }
  
  String getCallFrom()
  {
    return this.mLastCallFrom;
  }
  
  String getCallScheme()
  {
    return this.mLastCallScheme;
  }
  
  int getStartType()
  {
    return this.mLastStartType;
  }
  
  public boolean shouldAdditionalReport(String paramString)
  {
    if (VideoReport.isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shouldAdditionalReport: eventKey=");
      localStringBuilder.append(paramString);
      Log.i("DTAdditionalReportHandl", localStringBuilder.toString());
    }
    boolean bool = false;
    if ("origin_vst".equals(paramString)) {
      bool = handleAppVstEvent();
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTAdditionalReportHandler
 * JD-Core Version:    0.7.0.1
 */