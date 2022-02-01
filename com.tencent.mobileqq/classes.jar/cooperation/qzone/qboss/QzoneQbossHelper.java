package cooperation.qzone.qboss;

import BOSSStrategyCenter.tAdvDesc;
import NS_MOBILE_QBOSS_PROTO.MobileQbossAdvRsp;
import android.os.Bundle;
import android.text.TextUtils;
import ayrb;
import bcvz;
import bkyz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
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
  extends ayrb
{
  public static final String TAG = "QzoneQbossHelper";
  private static QzoneQbossHelper sInstance;
  private WeakReference<IQbossCallback> mQbossCallback;
  
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
    return Boolean.valueOf(bkyz.a(BaseApplicationImpl.getContext(), paramString));
  }
  
  public static String findPkgNameInJson(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Pattern.compile("\"download_app_package_name\":\"[^\"]*").matcher(paramString);
      localObject1 = localObject2;
      if (paramString.find())
      {
        paramString = paramString.group(0).split("\"");
        localObject1 = localObject2;
        if (paramString.length == 4)
        {
          localObject1 = localObject2;
          if (paramString[3].length() > 0) {
            localObject1 = paramString[3];
          }
        }
      }
    }
    return localObject1;
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
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), bcvz.class);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.qboss.QzoneQbossHelper
 * JD-Core Version:    0.7.0.1
 */