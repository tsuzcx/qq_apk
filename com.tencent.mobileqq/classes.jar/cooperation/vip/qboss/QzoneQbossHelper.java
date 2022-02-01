package cooperation.vip.qboss;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.tianshu.data.IQbossCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.pm.PackageUtil;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;

public class QzoneQbossHelper
  extends QZoneObserver
{
  private static QzoneQbossHelper jdField_a_of_type_CooperationVipQbossQzoneQbossHelper;
  private WeakReference<IQbossCallback> jdField_a_of_type_JavaLangRefWeakReference;
  
  public QzoneQbossHelper()
  {
    this.a = null;
  }
  
  public static Boolean a(String paramString)
  {
    boolean bool = PackageUtil.a(BaseApplicationImpl.getContext(), paramString);
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
      QZLog.d("QzoneQbossHelper", 4, localStringBuilder.toString());
    }
    return Boolean.valueOf(bool);
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
            QZLog.d("QzoneQbossHelper", 4, "QBoss filter : find PkgName in json");
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
      QZLog.d("QzoneQbossHelper", 4, "QBoss filter : not find PkgName in json");
    }
    return null;
  }
  
  protected void h(boolean paramBoolean, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("requestType");
    Object localObject = this.a;
    if (localObject != null) {
      localObject = (IQbossCallback)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (paramBoolean)
    {
      if (localObject != null) {
        ((IQbossCallback)localObject).a(paramBundle, str1, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      }
      QLog.i("QzoneQbossHelper", 1, "onGetQbossData rsp success");
    }
    else
    {
      int i = paramBundle.getInt("ret", 0);
      String str2 = paramBundle.getString("msg");
      paramBundle = paramBundle.getIntegerArrayList("appid");
      if (localObject != null) {
        ((IQbossCallback)localObject).a(i, str2, str1, paramBundle);
      }
    }
    BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.qboss.QzoneQbossHelper
 * JD-Core Version:    0.7.0.1
 */