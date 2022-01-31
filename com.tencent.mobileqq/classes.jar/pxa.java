import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.pts.utils.PTSFileUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class pxa
{
  private static volatile pxa jdField_a_of_type_Pxa;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "native_article", "default_feeds" };
  private HashMap<String, List<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private String a(String paramString)
  {
    String str = "";
    if (TextUtils.equals(paramString, "native_article")) {
      str = bkbq.a("native_proteus_offline_bid");
    }
    if (TextUtils.equals(paramString, "default_feeds")) {
      str = bkbq.a("default_feeds_proteus_offline_bid");
    }
    return str;
  }
  
  public static pxa a()
  {
    if (jdField_a_of_type_Pxa == null) {}
    try
    {
      if (jdField_a_of_type_Pxa == null) {
        jdField_a_of_type_Pxa = new pxa();
      }
      return jdField_a_of_type_Pxa;
    }
    finally {}
  }
  
  private void a(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if ((localBaseApplication == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Object localObject = localBaseApplication.getAssets();
    String str1 = "proteus" + File.separator + paramString + File.separator + "pages";
    QLog.i("PTSStyleManager", 1, "[loadLocalStyleFileImp], businessName = " + paramString + ", path = " + str1);
    for (;;)
    {
      int i;
      try
      {
        localObject = ((AssetManager)localObject).list(str1);
        if (localObject != null)
        {
          int j = localObject.length;
          i = 0;
          if (i >= j) {
            break;
          }
          String str2 = localObject[i];
          QLog.i("PTSStyleManager", 1, "[loadLocalStyleFileImp], appName = " + str2);
          String str3 = PTSFileUtil.getFilePath(str2, str1, ".frametree");
          PTSFileUtil.loadFile(str3, localBaseApplication, true);
          if (!PTSFileUtil.isFileInMap(str3)) {
            break label277;
          }
          a(str2, paramString);
          if ((!QLog.isColorLevel()) && (!QLog.isDebugVersion())) {
            break label277;
          }
          QLog.i("PTSStyleManager", 2, "[loadLocalStyleFileImp] load style succeed, appName = " + str2 + ", frameTreeJsonPath = " + str3);
          break label277;
        }
        QLog.i("PTSStyleManager", 1, "[loadLocalStyleFileImp], fileLists is null.");
        return;
      }
      catch (IOException paramString)
      {
        QLog.e("PTSStyleManager", 1, "[loadLocalStyleFileImp], e = " + paramString);
        return;
      }
      label277:
      i += 1;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      return;
    }
    List localList = (List)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString2, localObject);
    }
    ((List)localObject).add(paramString1);
  }
  
  private void b(String paramString)
  {
    int i = 0;
    String str1 = a(paramString);
    if ((TextUtils.isEmpty(str1)) || (str1.equals("0")))
    {
      QLog.i("PTSStyleManager", 1, "[loadOfflineStyleFileImp], bid is null or empty.");
      return;
    }
    str1 = ncb.a(str1) + str1;
    str1 = str1 + File.separator + "pages";
    QLog.i("PTSStyleManager", 1, "[loadOfflineStyleFileImp], businessName = " + paramString + ", path = " + str1);
    for (;;)
    {
      try
      {
        Object localObject = new File(str1);
        if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
        {
          localObject = ((File)localObject).listFiles();
          int j = localObject.length;
          if (i >= j) {
            break;
          }
          String str2 = localObject[i].getName();
          QLog.i("PTSStyleManager", 1, "[loadOfflineStyleFileImp], appName = " + str2);
          String str3 = PTSFileUtil.getFilePath(str2, str1, ".frametree");
          PTSFileUtil.loadFile(str3, null, false);
          if (!PTSFileUtil.isFileInMap(str3)) {
            break label323;
          }
          a(str2, paramString);
          if ((!QLog.isColorLevel()) && (!QLog.isDebugVersion())) {
            break label323;
          }
          QLog.i("PTSStyleManager", 2, "[loadOfflineStyleFileImp] load style succeed, appName = " + str2 + ", frameTreeJsonPath = " + str3);
          break label323;
        }
        QLog.i("PTSStyleManager", 1, "[loadOfflineStyleFileImp], pages directory does not exists.");
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("PTSStyleManager", 1, "[loadOfflineStyleFileImp], e = " + paramString);
        return;
      }
      label323:
      i += 1;
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    Object localObject1;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("PTSStyleManager", 1, "[getFrameTreeJson], businessName or appName is null.");
      localObject1 = "";
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject1 = "";
      localObject2 = a(paramString1);
      localObject2 = PTSFileUtil.getFilePath(paramString2, ncb.a((String)localObject2) + (String)localObject2 + File.separator + "pages", ".frametree");
      if (PTSFileUtil.isFileInMap((String)localObject2)) {
        localObject1 = PTSFileUtil.getFileContent((String)localObject2, null, false);
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        String str = PTSFileUtil.getFilePath(paramString2, "proteus" + File.separator + paramString1 + File.separator + "pages", ".frametree");
        localObject2 = localObject1;
        if (PTSFileUtil.isFileInMap(str)) {
          localObject2 = PTSFileUtil.getFileContent(str, BaseApplicationImpl.getContext(), true);
        }
      }
      localObject1 = localObject2;
    } while (!TextUtils.isEmpty((CharSequence)localObject2));
    QLog.e("PTSStyleManager", 1, "[getFrameTreeJson], frameTreeJson is empty, businessName = " + paramString1 + ", appName = " + paramString2);
    return localObject2;
  }
  
  public List<String> a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      return null;
    }
    return (List)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      a(str);
      b(str);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pxa
 * JD-Core Version:    0.7.0.1
 */