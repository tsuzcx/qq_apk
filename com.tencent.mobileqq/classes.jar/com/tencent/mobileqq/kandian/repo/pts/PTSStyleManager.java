package com.tencent.mobileqq.kandian.repo.pts;

import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusOfflineBidSp;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.pts.utils.PTSFileUtil;
import com.tencent.pts.utils.PTSLog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class PTSStyleManager
{
  private static volatile PTSStyleManager a;
  private static final String[] b = { "native_article", "default_feeds" };
  private HashMap<String, List<String>> c = new HashMap();
  private HashMap<String, Boolean> d = new HashMap();
  
  public static PTSStyleManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new PTSStyleManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    try
    {
      paramAbsBaseArticleInfo = new JSONObject(paramAbsBaseArticleInfo.proteusItemsData).optString("style_ID");
      return paramAbsBaseArticleInfo;
    }
    catch (NullPointerException paramAbsBaseArticleInfo)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getStyle] e = ");
      localStringBuilder.append(paramAbsBaseArticleInfo);
      QLog.e("PTSStyleManager", 1, localStringBuilder.toString());
    }
    catch (JSONException paramAbsBaseArticleInfo)
    {
      QLog.e("PTSStyleManager", 1, paramAbsBaseArticleInfo.getMessage());
    }
    return null;
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    Object localObject = PTSFileUtil.getFileContent(paramString, BaseApplicationImpl.getContext(), paramBoolean);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramBoolean = c((String)localObject, "8.8.17");
      this.d.put(paramString, Boolean.valueOf(paramBoolean));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[checkFrameTreeVersion] frameTreeJsonPath = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("isValid = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("PTSStyleManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private void b(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (localBaseApplication != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("proteus");
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("pages");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[loadLocalStyleFileImp], businessName = ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(", path = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("PTSStyleManager", 1, ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("manifest");
      localObject2 = ((StringBuilder)localObject2).toString();
      String str = PTSFileUtil.getFileContent((String)localObject2, localBaseApplication, true);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[loadLocalStyleFileImp], manifestFilePath = ");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(", manifest content = ");
      ((StringBuilder)localObject3).append(str);
      QLog.i("PTSStyleManager", 1, ((StringBuilder)localObject3).toString());
      if (!TextUtils.isEmpty(str))
      {
        localObject2 = str.split("\n");
        int j = localObject2.length;
        int i = 0;
        while (i < j)
        {
          str = localObject2[i];
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[loadLocalStyleFileImp] manifest pageName = ");
          ((StringBuilder)localObject3).append(str);
          QLog.i("PTSStyleManager", 1, ((StringBuilder)localObject3).toString());
          localObject3 = PTSFileUtil.getFilePath(str, (String)localObject1, ".frametree");
          try
          {
            try
            {
              PTSFileUtil.loadFile((String)localObject3, localBaseApplication, true);
            }
            catch (Throwable localThrowable)
            {
              StringBuilder localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("[loadLocalStyleFileImp] t = ");
              localStringBuilder2.append(localThrowable);
              QLog.i("PTSStyleManager", 1, localStringBuilder2.toString());
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            label363:
            StringBuilder localStringBuilder1;
            break label363;
          }
          GlobalImageCache.a.evict(0);
          PTSFileUtil.loadFile((String)localObject3, localBaseApplication, true);
          if (PTSFileUtil.isFileInMap((String)localObject3))
          {
            a((String)localObject3, true);
            b(str, paramString);
            if ((QLog.isColorLevel()) || (QLog.isDebugVersion()))
            {
              localStringBuilder1 = new StringBuilder();
              localStringBuilder1.append("[loadLocalStyleFileImp] load style succeed, pageName = ");
              localStringBuilder1.append(str);
              localStringBuilder1.append(", frameTreeJsonPath = ");
              localStringBuilder1.append((String)localObject3);
              QLog.i("PTSStyleManager", 2, localStringBuilder1.toString());
            }
          }
          i += 1;
        }
      }
      else
      {
        QLog.i("PTSStyleManager", 1, "[loadLocalStyleFileImp], manifestContent is empty.");
      }
    }
    else
    {
      return;
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    Object localObject = this.c;
    if (localObject == null) {
      return;
    }
    List localList = (List)((HashMap)localObject).get(paramString2);
    localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.c.put(paramString2, localObject);
    }
    ((List)localObject).add(paramString1);
  }
  
  private void c(String paramString)
  {
    Object localObject1 = d(paramString);
    Object localObject2;
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals("0")))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(OfflineEnvHelper.b((String)localObject1));
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("pages");
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[loadOfflineStyleFileImp], businessName = ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(", path = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("PTSStyleManager", 1, ((StringBuilder)localObject2).toString());
    }
    int i;
    label459:
    label475:
    for (;;)
    {
      try
      {
        localObject2 = new File((String)localObject1);
        if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory()))
        {
          localObject2 = ((File)localObject2).listFiles();
          int j = localObject2.length;
          i = 0;
          if (i >= j) {
            break label459;
          }
          str = localObject2[i].getName();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[loadOfflineStyleFileImp], pageName = ");
          ((StringBuilder)localObject3).append(str);
          QLog.i("PTSStyleManager", 1, ((StringBuilder)localObject3).toString());
          localObject3 = PTSFileUtil.getFilePath(str, (String)localObject1, ".frametree");
        }
      }
      catch (Exception paramString)
      {
        String str;
        Object localObject3;
        StringBuilder localStringBuilder2;
        StringBuilder localStringBuilder1;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[loadOfflineStyleFileImp], e = ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.e("PTSStyleManager", 1, ((StringBuilder)localObject1).toString());
      }
      try
      {
        try
        {
          PTSFileUtil.loadFile((String)localObject3, null, false);
        }
        catch (Throwable localThrowable)
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("[loadOfflineStyleFileImp] t = ");
          localStringBuilder2.append(localThrowable);
          QLog.i("PTSStyleManager", 1, localStringBuilder2.toString());
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        continue;
        i += 1;
      }
      GlobalImageCache.a.evict(0);
      PTSFileUtil.loadFile((String)localObject3, null, false);
      if (PTSFileUtil.isFileInMap((String)localObject3))
      {
        a((String)localObject3, false);
        b(str, paramString);
        if ((QLog.isColorLevel()) || (QLog.isDebugVersion()))
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("[loadOfflineStyleFileImp] load style succeed, pageName = ");
          localStringBuilder1.append(str);
          localStringBuilder1.append(", frameTreeJsonPath = ");
          localStringBuilder1.append((String)localObject3);
          QLog.i("PTSStyleManager", 2, localStringBuilder1.toString());
          break label475;
          QLog.i("PTSStyleManager", 1, "[loadOfflineStyleFileImp], pages directory does not exists.");
          return;
          return;
          QLog.i("PTSStyleManager", 1, "[loadOfflineStyleFileImp], bid is null or empty.");
          return;
        }
      }
    }
  }
  
  private boolean c(String paramString1, String paramString2)
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject = new JSONObject(paramString1);
      paramString1 = ((JSONObject)localObject).optString("max_version", "");
      localObject = ((JSONObject)localObject).optString("min_version", "");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isVersionValid] currentVersion = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", minVersion = ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", maxVersion = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", timeCost = ");
      localStringBuilder.append(System.currentTimeMillis() - l);
      PTSLog.i("PTSStyleManager", localStringBuilder.toString());
      if ((!TextUtils.isEmpty(paramString1)) && (d(paramString2, paramString1) > 0)) {
        return false;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        int i = d(paramString2, (String)localObject);
        if (i < 0) {
          return false;
        }
      }
    }
    catch (JSONException paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("[isVersionValid] e = ");
      paramString2.append(paramString1);
      PTSLog.e("PTSStyleManager", paramString2.toString());
    }
    return true;
  }
  
  private int d(String paramString1, String paramString2)
  {
    paramString1 = e(paramString1);
    paramString2 = e(paramString2);
    int j = Math.min(paramString1.size(), paramString2.size());
    int i = 0;
    while (i < j)
    {
      if (((Integer)paramString1.get(i)).intValue() > ((Integer)paramString2.get(i)).intValue()) {
        return 1;
      }
      if (((Integer)paramString1.get(i)).intValue() < ((Integer)paramString2.get(i)).intValue()) {
        return -1;
      }
      i += 1;
    }
    return 0;
  }
  
  private String d(String paramString)
  {
    String str;
    if (TextUtils.equals(paramString, "native_article")) {
      str = RIJProteusOfflineBidSp.a("native_proteus_offline_bid");
    } else {
      str = "";
    }
    if (TextUtils.equals(paramString, "default_feeds")) {
      str = RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid");
    }
    return str;
  }
  
  private List<Integer> e(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    paramString = paramString.split("\\.");
    int i = 0;
    while (i < paramString.length)
    {
      try
      {
        localArrayList.add(Integer.valueOf(Integer.parseInt(paramString[i])));
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[getVersionArray] e =");
        localStringBuilder.append(localException);
        PTSLog.e("PTSStyleManager", localStringBuilder.toString());
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public String a(String paramString1, String paramString2)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    Object localObject2 = "";
    if ((!bool) && (!TextUtils.isEmpty(paramString2)))
    {
      Object localObject1 = d(paramString1);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(OfflineEnvHelper.b((String)localObject1));
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append("pages");
      Object localObject4 = PTSFileUtil.getFilePath(paramString2, ((StringBuilder)localObject3).toString(), ".frametree");
      if (PTSFileUtil.isFileInMap((String)localObject4))
      {
        localObject3 = PTSFileUtil.getFileContent((String)localObject4, null, false);
        Boolean localBoolean = (Boolean)this.d.get(localObject4);
        localObject1 = localObject3;
        if (localBoolean != null)
        {
          localObject1 = localObject3;
          if (!localBoolean.booleanValue())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[getFrameTreeJson] version is not valid, frameTreeJsonPath = ");
            ((StringBuilder)localObject1).append((String)localObject4);
            QLog.i("PTSStyleManager", 1, ((StringBuilder)localObject1).toString());
          }
        }
      }
      else
      {
        localObject1 = "";
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("proteus");
        ((StringBuilder)localObject3).append(File.separator);
        ((StringBuilder)localObject3).append(paramString1);
        ((StringBuilder)localObject3).append(File.separator);
        ((StringBuilder)localObject3).append("pages");
        localObject3 = PTSFileUtil.getFilePath(paramString2, ((StringBuilder)localObject3).toString(), ".frametree");
        if (PTSFileUtil.isFileInMap((String)localObject3))
        {
          localObject1 = PTSFileUtil.getFileContent((String)localObject3, BaseApplicationImpl.getContext(), true);
          localObject4 = (Boolean)this.d.get(localObject3);
          if ((localObject4 != null) && (!((Boolean)localObject4).booleanValue()))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[getFrameTreeJson] version is not valid, frameTreeJsonPath = ");
            ((StringBuilder)localObject1).append((String)localObject3);
            QLog.i("PTSStyleManager", 1, ((StringBuilder)localObject1).toString());
            localObject1 = localObject2;
          }
          else {}
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[getFrameTreeJson], frameTreeJson is empty, businessName = ");
        ((StringBuilder)localObject2).append(paramString1);
        ((StringBuilder)localObject2).append(", pageName = ");
        ((StringBuilder)localObject2).append(paramString2);
        QLog.e("PTSStyleManager", 1, ((StringBuilder)localObject2).toString());
      }
      return localObject1;
    }
    QLog.e("PTSStyleManager", 1, "[getFrameTreeJson], businessName or pageName is null.");
    return "";
  }
  
  public List<String> a(String paramString)
  {
    HashMap localHashMap = this.c;
    if (localHashMap == null) {
      return null;
    }
    return (List)localHashMap.get(paramString);
  }
  
  public void b()
  {
    String[] arrayOfString = b;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      b(str);
      c(str);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.pts.PTSStyleManager
 * JD-Core Version:    0.7.0.1
 */