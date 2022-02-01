package cooperation.qzone.qboss;

import BOSSStrategyCenter.tAdvDesc;
import NS_MOBILE_QBOSS_PROTO.MobileQbossAdvRsp;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.servlet.QzoneGetQbossServlet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.pm.PackageUtil;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class QzoneQbossHelper
  extends QZoneObserver
{
  public static final String TAG = "QzoneQbossHelper";
  private static QzoneQbossHelper sInstance = null;
  private WeakReference<IQbossCallback> mQbossCallback = null;
  
  public static void filterQbossAdvRsp(MobileQbossAdvRsp paramMobileQbossAdvRsp)
  {
    if (paramMobileQbossAdvRsp == null) {}
    for (;;)
    {
      return;
      paramMobileQbossAdvRsp = paramMobileQbossAdvRsp.mapAdv.entrySet().iterator();
      while (paramMobileQbossAdvRsp.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMobileQbossAdvRsp.next();
        Iterator localIterator = ((ArrayList)localEntry.getValue()).iterator();
        while (localIterator.hasNext())
        {
          tAdvDesc localtAdvDesc = (tAdvDesc)localIterator.next();
          String str = findPkgNameInJson(localtAdvDesc.res_data);
          if ((str != null) && (findPkgInstalled(str).booleanValue()))
          {
            localIterator.remove();
            QbossReportManager.getInstance().reportIntercept(localtAdvDesc.res_traceinfo, null);
          }
        }
        if (((ArrayList)localEntry.getValue()).size() == 0) {
          paramMobileQbossAdvRsp.remove();
        }
      }
    }
  }
  
  public static Boolean findPkgInstalled(String paramString)
  {
    boolean bool = PackageUtil.a(BaseApplicationImpl.getContext(), paramString);
    StringBuilder localStringBuilder;
    if (QZLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder().append("QBoss filter : ");
      if (!bool) {
        break label62;
      }
    }
    label62:
    for (String str = "";; str = "not ")
    {
      QZLog.d("QzoneQbossHelper", 4, str + "install PkgName = " + paramString);
      return Boolean.valueOf(bool);
    }
  }
  
  public static String findPkgNameInJson(String paramString)
  {
    Object localObject = null;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Pattern.compile("\"download_app_package_name\":\"[^\"]*").matcher(paramString);
      if (paramString.find())
      {
        String[] arrayOfString = paramString.group(0).split("\"");
        if (arrayOfString.length == 4)
        {
          if (QZLog.isDevelopLevel()) {
            QZLog.d("QzoneQbossHelper", 4, "QBoss filter : find PkgName in json");
          }
          paramString = localObject;
          if (arrayOfString[3].length() > 0) {
            paramString = arrayOfString[3];
          }
        }
      }
    }
    do
    {
      return paramString;
      paramString = localObject;
    } while (!QZLog.isDevelopLevel());
    QZLog.d("QzoneQbossHelper", 4, "QBoss filter : not find PkgName in json");
    return null;
  }
  
  public static QzoneQbossHelper getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new QzoneQbossHelper();
      }
      return sInstance;
    }
    finally {}
  }
  
  public void getQbossData(ArrayList<Integer> paramArrayList, IQbossCallback paramIQbossCallback)
  {
    getQbossData(paramArrayList, paramIQbossCallback, null);
  }
  
  public void getQbossData(ArrayList<Integer> paramArrayList, IQbossCallback paramIQbossCallback, String paramString)
  {
    this.mQbossCallback = new WeakReference(paramIQbossCallback);
    paramIQbossCallback = BaseApplicationImpl.getApplication().getRuntime();
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), QzoneGetQbossServlet.class);
    localNewIntent.putExtra("selfuin", Long.parseLong(paramIQbossCallback.getAccount()));
    localNewIntent.putIntegerArrayListExtra("appid", paramArrayList);
    localNewIntent.putExtra("requestType", paramString);
    paramIQbossCallback.registObserver(this);
    paramIQbossCallback.startServlet(localNewIntent);
    QLog.i("QzoneQbossHelper", 1, "getQbossData req");
  }
  
  public void onGetQbossData(boolean paramBoolean, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("requestType");
    if (this.mQbossCallback != null) {}
    for (IQbossCallback localIQbossCallback = (IQbossCallback)this.mQbossCallback.get();; localIQbossCallback = null)
    {
      if (paramBoolean)
      {
        if (localIQbossCallback != null) {
          localIQbossCallback.getQbossSuccess(paramBundle, str1, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
        }
        QLog.i("QzoneQbossHelper", 1, "onGetQbossData rsp success");
      }
      for (;;)
      {
        BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(this);
        return;
        int i = paramBundle.getInt("ret", 0);
        String str2 = paramBundle.getString("msg");
        paramBundle = paramBundle.getIntegerArrayList("appid");
        if (localIQbossCallback != null) {
          localIQbossCallback.getQbossFail(i, str2, str1, paramBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.qboss.QzoneQbossHelper
 * JD-Core Version:    0.7.0.1
 */