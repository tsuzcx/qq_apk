import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.av.so.ResInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONObject;

public class mal
{
  private static volatile mal jdField_a_of_type_Mal;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  ArrayList<man> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ArrayList<ResInfo> b;
  
  private mal()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    QLog.i("ResMgr", 1, "ResMgr for " + localBaseApplicationImpl.getQQProcessName());
    a(localBaseApplicationImpl);
    this.b = a();
    if (this.b == null) {
      this.b = new ArrayList();
    }
  }
  
  public static String a(ResInfo paramResInfo)
  {
    return AVSoUtils.b() + "qavRes" + File.separator + paramResInfo.resType + File.separator + paramResInfo.resId + File.separator + paramResInfo.resVersion + File.separator + paramResInfo.resMd5 + File.separator;
  }
  
  public static ArrayList<ResInfo> a()
  {
    Object localObject = lbt.b(367).a;
    QLog.i("ResMgr", 1, "getResInfoListFromConfig. jsonContent = " + (String)localObject);
    try
    {
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.e("ResMgr", 1, "updateResInfoList failed. jsonContent is empty.");
        return new ArrayList();
      }
      localObject = ResInfo.parseConfig(new JSONObject((String)localObject));
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.e("ResMgr", 1, "updateResInfoList failed. exception = " + localException);
    }
    return new ArrayList();
  }
  
  public static mal a()
  {
    if (jdField_a_of_type_Mal == null) {}
    try
    {
      if (jdField_a_of_type_Mal == null) {
        jdField_a_of_type_Mal = new mal();
      }
      return jdField_a_of_type_Mal;
    }
    finally {}
  }
  
  private boolean a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("ACTION_QAV_RES_DOWNLOAD_STATE_NOTIFY");
    localIntentFilter.addAction("ACTION_QAV_RES_NEW_CONFIG_NOTIFY");
    return paramBaseApplicationImpl.registerReceiver(new mam(this), localIntentFilter) != null;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (new File(paramString1).exists())
    {
      if (!paramString2.equalsIgnoreCase(aznv.a(paramString1)))
      {
        QLog.e("ResMgr", 1, "checkFileValid failed. check md5 failed. fileName = " + paramString1 + ", md5FromConfig = " + paramString2);
        return false;
      }
      return true;
    }
    QLog.e("ResMgr", 1, "checkFileValid failed. file is not exist. fileName = " + paramString1 + ", md5FromConfig = " + paramString2);
    return false;
  }
  
  public static String b(ResInfo paramResInfo)
  {
    if (paramResInfo == null)
    {
      QLog.e("ResMgr", 1, "getResIdRootDir failed. resInfo == null.");
      return "";
    }
    return AVSoUtils.b() + "qavRes" + File.separator + paramResInfo.resType + File.separator + paramResInfo.resId + File.separator;
  }
  
  public ResInfo a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.b.size())
        {
          if (((ResInfo)this.b.get(i)).resId.equalsIgnoreCase(paramString))
          {
            paramString = (ResInfo)this.b.get(i);
            return paramString;
          }
        }
        else {
          return null;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public String a(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null)
    {
      QLog.e("ResMgr", 1, "getResFullFileName failed. resInfo == null.");
      return "";
    }
    return a(paramString) + paramString.resFileName;
  }
  
  public boolean a(String paramString)
  {
    BusinessCommonConfig.notifyQQDownload(3, paramString, 0);
    return true;
  }
  
  public boolean b(String paramString)
  {
    ResInfo localResInfo = a(paramString);
    if (localResInfo == null) {
      return false;
    }
    return a(a(paramString), localResInfo.resMd5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mal
 * JD-Core Version:    0.7.0.1
 */