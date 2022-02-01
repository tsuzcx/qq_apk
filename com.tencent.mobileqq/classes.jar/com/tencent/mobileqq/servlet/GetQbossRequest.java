package com.tencent.mobileqq.servlet;

import BOSSStrategyCenter.tAdvDesc;
import NS_MOBILE_QBOSS_PROTO.MobileQbossAdvRsp;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.util.pm.PackageUtil;
import cooperation.qzone.QzoneExternalRequest;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

public class GetQbossRequest
  extends QzoneExternalRequest
{
  private JceStruct a;
  
  public GetQbossRequest(long paramLong, ArrayList<Integer> paramArrayList, boolean paramBoolean) {}
  
  public static MobileQbossAdvRsp a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = (MobileQbossAdvRsp)QzoneExternalRequest.decode(paramArrayOfByte, "get");
    if (paramArrayOfByte == null) {
      return null;
    }
    a(paramArrayOfByte);
    return paramArrayOfByte;
  }
  
  public static String a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject = null;
    if (!bool)
    {
      paramString = Pattern.compile("\"download_app_package_name\":\"[^\"]*").matcher(paramString);
      if (paramString.find())
      {
        String[] arrayOfString = paramString.group(0).split("\"");
        if (arrayOfString.length == 4)
        {
          if (QZLog.isDevelopLevel()) {
            QZLog.d("GetQbossRequest", 4, "QBoss filter : find PkgName in json");
          }
          paramString = localObject;
          if (arrayOfString[3].length() > 0) {
            paramString = arrayOfString[3];
          }
          return paramString;
        }
      }
    }
    if (QZLog.isDevelopLevel()) {
      QZLog.d("GetQbossRequest", 4, "QBoss filter : not find PkgName in json");
    }
    return null;
  }
  
  private static void a(MobileQbossAdvRsp paramMobileQbossAdvRsp)
  {
    if (paramMobileQbossAdvRsp == null) {
      return;
    }
    paramMobileQbossAdvRsp = paramMobileQbossAdvRsp.mapAdv.entrySet().iterator();
    while (paramMobileQbossAdvRsp.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMobileQbossAdvRsp.next();
      Iterator localIterator = ((ArrayList)localEntry.getValue()).iterator();
      while (localIterator.hasNext())
      {
        tAdvDesc localtAdvDesc = (tAdvDesc)localIterator.next();
        String str = a(localtAdvDesc.res_data);
        if ((str != null) && (b(str).booleanValue()))
        {
          localIterator.remove();
          ((IQbossReportManager)QRoute.api(IQbossReportManager.class)).reportIntercept(localtAdvDesc.res_traceinfo, null);
        }
      }
      if (((ArrayList)localEntry.getValue()).size() == 0) {
        paramMobileQbossAdvRsp.remove();
      }
    }
  }
  
  public static Boolean b(String paramString)
  {
    boolean bool = PackageUtil.d(MobileQQ.sMobileQQ.getApplicationContext(), paramString);
    if (QZLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QBoss filter : ");
      String str;
      if (bool) {
        str = "";
      } else {
        str = "not ";
      }
      localStringBuilder.append(str);
      localStringBuilder.append("install PkgName = ");
      localStringBuilder.append(paramString);
      QZLog.d("GetQbossRequest", 4, localStringBuilder.toString());
    }
    return Boolean.valueOf(bool);
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.mobileqboss.get";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "get";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.GetQbossRequest
 * JD-Core Version:    0.7.0.1
 */