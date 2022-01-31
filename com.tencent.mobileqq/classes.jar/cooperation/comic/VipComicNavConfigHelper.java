package cooperation.comic;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VipComicNavConfigHelper
{
  private static Map jdField_a_of_type_JavaUtilMap;
  public static volatile boolean a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "NavConfig", "FavNavConfig", "CateNavConfig", "MoreNavConfig", "GroupNavConfig" };
  
  static
  {
    jdField_a_of_type_Boolean = a();
  }
  
  public static VipComicNavConfigHelper.TabItemData a(String paramString)
  {
    Map localMap = a();
    if ((localMap != null) && (localMap.containsKey(paramString))) {
      return (VipComicNavConfigHelper.TabItemData)localMap.get(paramString);
    }
    return null;
  }
  
  public static File a()
  {
    return new File(BaseApplicationImpl.getApplication().getFilesDir(), "comic_config/");
  }
  
  public static String a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (jdField_a_of_type_Boolean)
    {
      paramString = a(paramString);
      localObject1 = localObject2;
      if (paramString != null) {
        localObject1 = new File(c(), paramString.c).getAbsolutePath();
      }
    }
    return localObject1;
  }
  
  public static Map a()
  {
    if (jdField_a_of_type_JavaUtilMap == null) {
      a();
    }
    return jdField_a_of_type_JavaUtilMap;
  }
  
  public static JSONObject a()
  {
    String str = FileUtils.a(new File(a(), "vipComic_nav_config.json"));
    if (!TextUtils.isEmpty(str)) {
      return new JSONObject(str);
    }
    return null;
  }
  
  public static void a()
  {
    try
    {
      JSONObject localJSONObject1 = a();
      if (localJSONObject1 != null)
      {
        if (jdField_a_of_type_JavaUtilMap != null) {
          jdField_a_of_type_JavaUtilMap.clear();
        }
        jdField_a_of_type_JavaUtilMap = new HashMap();
        String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
        int k = arrayOfString.length;
        int i = 0;
        if (i < k)
        {
          String str = arrayOfString[i];
          Object localObject = localJSONObject1.optJSONArray(str);
          int j;
          if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
            j = ((JSONArray)localObject).length() - 1;
          }
          for (;;)
          {
            if (j >= 0)
            {
              JSONObject localJSONObject2 = ((JSONArray)localObject).optJSONObject(j);
              if ((localJSONObject2 != null) && (SwiftWebViewUtils.a(localJSONObject2, str)))
              {
                localObject = new VipComicNavConfigHelper.TabItemData();
                ((VipComicNavConfigHelper.TabItemData)localObject).a = localJSONObject2.optString("tabName");
                ((VipComicNavConfigHelper.TabItemData)localObject).b = localJSONObject2.optString("tabUrl");
                ((VipComicNavConfigHelper.TabItemData)localObject).c = localJSONObject2.optString("tabIcon");
                jdField_a_of_type_JavaUtilMap.put(str, localObject);
              }
            }
            else
            {
              i += 1;
              break;
            }
            j -= 1;
          }
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("VipComicNavConfigHelper", 1, localJSONException, new Object[0]);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (a()) {
      a();
    }
    for (;;)
    {
      if (!b()) {
        ((VasQuickUpdateManager)paramQQAppInterface.getManager(183)).a(100L, "vipComic_nav_tabIcon.zip", "helper");
      }
      return;
      ((VasQuickUpdateManager)paramQQAppInterface.getManager(183)).a(100L, "vipComic_nav_config.json", "helper");
    }
  }
  
  public static boolean a()
  {
    return b().exists();
  }
  
  public static File b()
  {
    return new File(a(), "vipComic_nav_config.json");
  }
  
  public static boolean b()
  {
    jdField_a_of_type_Boolean = c();
    return jdField_a_of_type_Boolean;
  }
  
  public static File c()
  {
    return new File(a(), "tab_icons/");
  }
  
  private static boolean c()
  {
    Object localObject1 = a();
    if ((localObject1 != null) && (!((Map)localObject1).isEmpty()))
    {
      Object localObject2 = c().list();
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        localObject2 = Arrays.asList((Object[])localObject2);
        localObject1 = ((Map)localObject1).values().iterator();
        while (((Iterator)localObject1).hasNext()) {
          if (!((List)localObject2).contains(((VipComicNavConfigHelper.TabItemData)((Iterator)localObject1).next()).c)) {
            return false;
          }
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.comic.VipComicNavConfigHelper
 * JD-Core Version:    0.7.0.1
 */