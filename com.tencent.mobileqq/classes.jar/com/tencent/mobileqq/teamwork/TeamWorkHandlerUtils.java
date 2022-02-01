package com.tencent.mobileqq.teamwork;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TeamWorkHandlerUtils
{
  private static String a;
  private static String b;
  
  private static File a(String paramString)
  {
    return new File(a(), MD5Utils.encodeHexStr(paramString));
  }
  
  public static String a()
  {
    String str = a;
    if (str != null) {
      return str;
    }
    str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("Tencent");
    localStringBuilder.append("/");
    localStringBuilder.append("tdoc");
    localStringBuilder.append("/");
    str = localStringBuilder.toString();
    a = str;
    return str;
  }
  
  public static String a(String paramString)
  {
    return Uri.parse(paramString).getLastPathSegment();
  }
  
  public static String a(String paramString, SharePolicyInfo paramSharePolicyInfo)
  {
    for (;;)
    {
      try
      {
        int k = paramSharePolicyInfo.a;
        j = 1;
        int i = k;
        if (k == 0) {
          i = 1;
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("url", URLEncoder.encode(paramSharePolicyInfo.e));
        if (paramSharePolicyInfo.j != null) {
          localJSONObject.put("title", URLEncoder.encode(paramSharePolicyInfo.j));
        }
        localJSONObject.put("type", 0);
        Object localObject = paramSharePolicyInfo.k;
        if (localObject == null) {
          localObject = "0";
        } else {
          localObject = paramSharePolicyInfo.k;
        }
        localJSONObject.put("folderId", localObject);
        localObject = new StringBuilder("https://docs.qq.com/cgi-bin/online_docs/wxqrcode");
        ((StringBuilder)localObject).append('?');
        ((StringBuilder)localObject).append("domainId=");
        ((StringBuilder)localObject).append(paramSharePolicyInfo.i);
        ((StringBuilder)localObject).append("&padId=");
        ((StringBuilder)localObject).append(paramSharePolicyInfo.h);
        ((StringBuilder)localObject).append("&dataType=");
        if (paramSharePolicyInfo.b != 3) {
          break label521;
        }
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append("&page=");
        ((StringBuilder)localObject).append("pages/shareFriend/shareFriend");
        ((StringBuilder)localObject).append("&ac=");
        ((StringBuilder)localObject).append("share");
        ((StringBuilder)localObject).append("&t=");
        ((StringBuilder)localObject).append("0");
        ((StringBuilder)localObject).append("&policy=");
        ((StringBuilder)localObject).append(String.valueOf(i));
        ((StringBuilder)localObject).append("&right_flag=");
        ((StringBuilder)localObject).append("1");
        ((StringBuilder)localObject).append("&param=");
        ((StringBuilder)localObject).append(localJSONObject.toString());
        ((StringBuilder)localObject).append("&type=");
        ((StringBuilder)localObject).append("1");
        localObject = ((ITeamWorkHttpUtils)QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsGet(paramString, ((StringBuilder)localObject).toString(), "docs.qq.com");
        if (localObject != null)
        {
          paramSharePolicyInfo = new JSONObject((String)localObject);
          paramString = paramSharePolicyInfo;
          try
          {
            if (paramSharePolicyInfo.optInt("retcode", -1) == 0) {
              break label444;
            }
            paramSharePolicyInfo.put("retcode", -1);
            paramString = paramSharePolicyInfo;
            if (!QLog.isColorLevel()) {
              break label444;
            }
            paramString = new StringBuilder();
            paramString.append("failed result");
            paramString.append((String)localObject);
            QLog.e("TeamWorkHandlerUtils", 2, paramString.toString());
            paramString = paramSharePolicyInfo;
          }
          catch (JSONException localJSONException1)
          {
            continue;
          }
        }
        else
        {
          paramString = null;
        }
      }
      catch (JSONException localJSONException2)
      {
        paramSharePolicyInfo = null;
        paramString = paramSharePolicyInfo;
        if (QLog.isColorLevel())
        {
          QLog.e("TeamWorkHandlerUtils", 2, localJSONException2, new Object[0]);
          paramString = paramSharePolicyInfo;
        }
      }
      label444:
      paramSharePolicyInfo = paramString;
      if (paramString == null)
      {
        paramString = new JSONObject();
        try
        {
          paramString.put("retcode", -1);
          paramSharePolicyInfo = paramString;
        }
        catch (JSONException localJSONException3)
        {
          paramSharePolicyInfo = paramString;
          if (QLog.isColorLevel())
          {
            QLog.e("TeamWorkHandlerUtils", 2, localJSONException3, new Object[0]);
            paramSharePolicyInfo = paramString;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("TeamWorkHandlerUtils", 2, paramSharePolicyInfo.toString());
      }
      return (String)paramSharePolicyInfo.opt("key");
      label521:
      int j = 0;
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      Object localObject = paramString1.split("\\$");
      if (localObject.length == 2)
      {
        new JSONObject();
        try
        {
          paramString1 = UUID.randomUUID().toString().replaceAll("-", "");
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("TOK=");
          localStringBuilder1.append(paramString1);
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("domain_id=");
          localStringBuilder2.append(localObject[0]);
          localStringBuilder2.append("&pad_id=");
          localStringBuilder2.append(localObject[1]);
          localStringBuilder2.append("&list_type=");
          localStringBuilder2.append(5);
          localStringBuilder2.append("&xsrf=");
          localStringBuilder2.append(paramString1);
          localObject = new HashMap();
          ((Map)localObject).put("HTTP_X_XSRF_PROTECTION", paramString1);
          paramString1 = ((ITeamWorkHttpUtils)QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsPost(localStringBuilder2.toString(), paramString2, "https://docs.qq.com/cgi-bin/online_docs/doc_delete", "docs.qq.com", localStringBuilder1.toString(), (Map)localObject, false);
          return paramString1;
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
        }
      }
    }
    return null;
  }
  
  private static JSONObject a(String paramString, int paramInt, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("uintype", paramInt);
    localJSONObject.put("uin", paramString);
    if (paramBoolean) {
      paramInt = 2;
    } else {
      paramInt = 1;
    }
    localJSONObject.put("info", paramInt);
    localJSONObject.put("new", 1);
    return localJSONObject;
  }
  
  public static JSONObject a(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = (ITeamWorkHttpUtils)QRoute.api(ITeamWorkHttpUtils.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://docs.qq.com/cgi-bin/online_docs/doc_infoguest?docUrl=");
      localStringBuilder.append(paramString1);
      localObject = ((ITeamWorkHttpUtils)localObject).sendHttpsGet(paramString2, localStringBuilder.toString(), "docs.qq.com");
      if (localObject != null)
      {
        paramString2 = new JSONObject((String)localObject);
        paramString1 = paramString2;
        try
        {
          if (paramString2.optInt("retcode", -1) == 0) {
            break label155;
          }
          paramString2.put("retcode", -1);
          paramString1 = paramString2;
          if (!QLog.isColorLevel()) {
            break label155;
          }
          paramString1 = new StringBuilder();
          paramString1.append("failed result");
          paramString1.append((String)localObject);
          QLog.e("TeamWorkHandlerUtils", 2, paramString1.toString());
          paramString1 = paramString2;
        }
        catch (JSONException localJSONException1)
        {
          break label134;
        }
      }
      else
      {
        paramString1 = null;
      }
    }
    catch (JSONException localJSONException2)
    {
      paramString2 = null;
      label134:
      paramString1 = paramString2;
      if (QLog.isColorLevel())
      {
        QLog.e("TeamWorkHandlerUtils", 2, localJSONException2, new Object[0]);
        paramString1 = paramString2;
      }
    }
    label155:
    paramString2 = paramString1;
    if (paramString1 == null)
    {
      paramString2 = new JSONObject();
      try
      {
        paramString2.put("retcode", -1);
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TeamWorkHandlerUtils", 2, paramString2.toString());
    }
    return paramString2;
  }
  
  public static JSONObject a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      ITeamWorkHttpUtils localITeamWorkHttpUtils = (ITeamWorkHttpUtils)QRoute.api(ITeamWorkHttpUtils.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://docs.qq.com/cgi-go/users/pushNotify?docname=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("&url=");
      localStringBuilder.append(URLEncoder.encode(paramString2, "UTF-8"));
      localStringBuilder.append("&authflag=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("&groupcode=");
      localStringBuilder.append(paramString3);
      localStringBuilder.append("&touin=");
      localStringBuilder.append(paramString4);
      paramString3 = localITeamWorkHttpUtils.sendHttpsGet(paramString5, localStringBuilder.toString(), "docs.qq.com");
      if (paramString3 != null)
      {
        paramString2 = new JSONObject(paramString3);
        paramString1 = paramString2;
        try
        {
          if (paramString2.optInt("retcode", -1) == 0) {
            break label267;
          }
          paramString2.put("retcode", -1);
          paramString1 = paramString2;
          if (!QLog.isColorLevel()) {
            break label267;
          }
          paramString1 = new StringBuilder();
          paramString1.append("failed result");
          paramString1.append(paramString3);
          QLog.e("sendLocalCooperationGrayTip", 2, paramString1.toString());
          paramString1 = paramString2;
        }
        catch (UnsupportedEncodingException paramString3)
        {
          break label217;
        }
        catch (JSONException paramString3)
        {
          break label245;
        }
      }
      else
      {
        paramString1 = null;
      }
    }
    catch (UnsupportedEncodingException paramString3)
    {
      paramString2 = null;
      paramString1 = paramString2;
      if (QLog.isColorLevel())
      {
        QLog.e("sendLocalCooperationGrayTip", 2, paramString3, new Object[0]);
        paramString1 = paramString2;
      }
    }
    catch (JSONException paramString3)
    {
      label217:
      paramString2 = null;
      label245:
      paramString1 = paramString2;
      if (QLog.isColorLevel())
      {
        QLog.e("sendLocalCooperationGrayTip", 2, paramString3, new Object[0]);
        paramString1 = paramString2;
      }
    }
    label267:
    paramString2 = paramString1;
    if (paramString1 == null)
    {
      paramString2 = new JSONObject();
      try
      {
        paramString2.put("retcode", -1);
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("sendLocalCooperationGrayTip", 2, paramString2.toString());
    }
    return paramString2;
  }
  
  public static JSONObject a(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      String str = ((ITeamWorkHttpUtils)QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsPost(paramJSONObject, paramString, "https://docs.qq.com/cgi-go/imp/import_form_url", "docs.qq.com");
      if (str != null)
      {
        paramJSONObject = new JSONObject(str);
        paramString = paramJSONObject;
        try
        {
          if (paramJSONObject.optInt("retcode", -1) == 0) {
            return paramString;
          }
          paramString = paramJSONObject;
          if (!QLog.isColorLevel()) {
            return paramString;
          }
          paramString = new StringBuilder();
          paramString.append("checkFormCache failed result");
          paramString.append(str);
          QLog.e("TeamWorkHandlerUtils", 2, paramString.toString());
          return paramJSONObject;
        }
        catch (JSONException localJSONException1) {}
      }
      else
      {
        return null;
      }
    }
    catch (JSONException localJSONException2)
    {
      paramJSONObject = null;
      paramString = paramJSONObject;
      if (QLog.isColorLevel())
      {
        QLog.e("TeamWorkHandlerUtils", 2, localJSONException2, new Object[0]);
        paramString = paramJSONObject;
      }
    }
    return paramString;
  }
  
  public static JSONObject a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    try
    {
      paramString2 = ((ITeamWorkHttpUtils)QRoute.api(ITeamWorkHttpUtils.class)).uploadFileWithParam(paramJSONObject, paramString1, "https://docs.qq.com/cgi-go/imp/import_form_file", paramString2);
      if (paramString2 != null)
      {
        paramJSONObject = new JSONObject(paramString2);
        paramString1 = paramJSONObject;
        try
        {
          if (paramJSONObject.optInt("retcode", -1) == 0) {
            return paramString1;
          }
          paramString1 = paramJSONObject;
          if (!QLog.isColorLevel()) {
            return paramString1;
          }
          paramString1 = new StringBuilder();
          paramString1.append("checkFormCache failed result");
          paramString1.append(paramString2);
          QLog.e("TeamWorkHandlerUtils", 2, paramString1.toString());
          return paramJSONObject;
        }
        catch (JSONException paramString2) {}
      }
      else
      {
        return null;
      }
    }
    catch (JSONException paramString2)
    {
      paramJSONObject = null;
      paramString1 = paramJSONObject;
      if (QLog.isColorLevel())
      {
        QLog.e("TeamWorkHandlerUtils", 2, paramString2, new Object[0]);
        paramString1 = paramJSONObject;
      }
    }
    return paramString1;
  }
  
  public static void a()
  {
    Object localObject1 = new File(a());
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (System.currentTimeMillis() - localObject2.lastModified() > 7200000L) {
          localObject2.delete();
        }
        i += 1;
      }
    }
  }
  
  public static void a(String paramString)
  {
    paramString = a(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doc_url=");
    localStringBuilder.append(URLEncoder.encode(paramString3));
    paramString3 = localStringBuilder.toString();
    paramString1 = ((ITeamWorkHttpUtils)QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsPost(paramString3, paramString1, "https://docs.qq.com/cgi-bin/online_docs/doc_content", "docs.qq.com");
    if (!TextUtils.isEmpty(paramString1)) {
      FileUtils.writeFile(a(), MD5Utils.encodeHexStr(paramString2), paramString1);
    }
  }
  
  public static boolean a(String paramString)
  {
    paramString = a(paramString);
    if (System.currentTimeMillis() - paramString.lastModified() > 7200000L)
    {
      paramString.delete();
      return false;
    }
    return paramString.exists();
  }
  
  public static boolean a(String paramString, SharePolicyInfo paramSharePolicyInfo)
  {
    String str = UUID.randomUUID().toString().replaceAll("-", "");
    StringBuilder localStringBuilder = new StringBuilder("https://docs.qq.com/cgi-bin/api/wechatshare/shareTips");
    localStringBuilder.append('?');
    localStringBuilder.append("domainId=");
    localStringBuilder.append(paramSharePolicyInfo.i);
    localStringBuilder.append("&padId=");
    localStringBuilder.append(paramSharePolicyInfo.h);
    localStringBuilder.append("&xsrf=");
    localStringBuilder.append(str);
    paramSharePolicyInfo = new StringBuilder();
    paramSharePolicyInfo.append("TOK=");
    paramSharePolicyInfo.append(str);
    try
    {
      paramString = ((ITeamWorkHttpUtils)QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsGet(paramString, localStringBuilder.toString(), "docs.qq.com", paramSharePolicyInfo.toString());
      if (paramString != null) {
        if (new JSONObject(paramString).optInt("retcode", -1) != 0)
        {
          if (QLog.isColorLevel())
          {
            paramSharePolicyInfo = new StringBuilder();
            paramSharePolicyInfo.append("wechatShareTips failed result");
            paramSharePolicyInfo.append(paramString);
            QLog.e("TeamWorkHandlerUtils", 2, paramSharePolicyInfo.toString());
            return false;
          }
        }
        else {
          return true;
        }
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TeamWorkHandlerUtils", 2, paramString, new Object[0]);
      }
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, int paramInt, List<String> paramList1, List<String> paramList2, List<String> paramList3)
  {
    if (TextUtils.isEmpty(paramString3)) {
      return false;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("policy", paramInt);
        if (((paramList1 != null) && (!paramList1.isEmpty())) || ((paramList2 != null) && (!paramList2.isEmpty())) || ((paramList3 != null) && (!paramList3.isEmpty())))
        {
          JSONArray localJSONArray = new JSONArray();
          if (paramList1 != null)
          {
            paramList1 = paramList1.iterator();
            if (paramList1.hasNext())
            {
              String str = (String)paramList1.next();
              if (str == null) {
                continue;
              }
              localJSONArray.put(a(str, 0, paramBoolean2));
              continue;
            }
          }
          if (paramList2 != null)
          {
            paramList1 = paramList2.iterator();
            if (paramList1.hasNext())
            {
              paramList2 = (String)paramList1.next();
              if (paramList2 == null) {
                continue;
              }
              localJSONArray.put(a(paramList2, 2, paramBoolean2));
              continue;
            }
          }
          if (paramList3 != null)
          {
            paramList1 = paramList3.iterator();
            if (paramList1.hasNext())
            {
              paramList2 = (String)paramList1.next();
              if (paramList2 == null) {
                continue;
              }
              localJSONArray.put(a(paramList2, 3, paramBoolean2));
              continue;
            }
          }
          localJSONObject.put("addmemlist", localJSONArray);
        }
        paramList1 = UUID.randomUUID().toString().replaceAll("-", "");
        paramString2 = new StringBuilder(String.format("https://docs.qq.com/cgi-bin/redirect/%s/ep/api/setpadinfo", new Object[] { paramString2 }));
        paramString2.append('?');
        paramString2.append("localPadId=");
        paramString2.append(paramString3);
        paramString2.append("&type=1");
        paramString2.append("&data=");
        paramString2.append(localJSONObject.toString());
        paramString2.append("&dataType=");
        if (!paramBoolean1) {
          break label529;
        }
        paramInt = 1;
        paramString2.append(paramInt);
        paramString2.append("&xsrf=");
        paramString2.append(paramList1);
        paramString3 = new StringBuilder();
        paramString3.append("TOK=");
        paramString3.append(paramList1);
        paramString1 = ((ITeamWorkHttpUtils)QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsGet(paramString1, paramString2.toString(), "docs.qq.com", paramString3.toString());
        if (paramString1 != null) {
          if (new JSONObject(paramString1).optInt("retcode", -1) != 0)
          {
            if (QLog.isColorLevel())
            {
              paramString2 = new StringBuilder();
              paramString2.append("setPolicy4AllByHttp failed result");
              paramString2.append(paramString1);
              QLog.e("TeamWorkHandlerUtils", 2, paramString2.toString());
              return false;
            }
          }
          else {
            return true;
          }
        }
      }
      catch (JSONException paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TeamWorkHandlerUtils", 2, paramString1, new Object[0]);
        }
      }
      return false;
      label529:
      paramInt = 0;
    }
  }
  
  public static String b()
  {
    Object localObject1 = b;
    if (localObject1 != null) {
      return localObject1;
    }
    Object localObject2 = MobileQQ.sMobileQQ.getExternalFilesDir(null);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = MobileQQ.sMobileQQ.getFilesDir();
    }
    localObject2 = ((File)localObject1).getAbsolutePath();
    localObject1 = localObject2;
    if (!((String)localObject2).endsWith("/"))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("/");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    b = (String)localObject1;
    return localObject1;
  }
  
  public static String b(String paramString)
  {
    return FileUtils.readFileContent(a(paramString));
  }
  
  public static JSONObject b(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      String str = ((ITeamWorkHttpUtils)QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsPost(paramJSONObject, paramString, "https://docs.qq.com/cgi-go/imp/import_form_cache", "docs.qq.com");
      if (str != null)
      {
        paramJSONObject = new JSONObject(str);
        paramString = paramJSONObject;
        try
        {
          if (paramJSONObject.optInt("retcode", -1) == 0) {
            return paramString;
          }
          paramJSONObject.put("retcode", -1);
          paramString = paramJSONObject;
          if (!QLog.isColorLevel()) {
            return paramString;
          }
          paramString = new StringBuilder();
          paramString.append("checkFormCache failed result");
          paramString.append(str);
          QLog.e("TeamWorkHandlerUtils", 2, paramString.toString());
          return paramJSONObject;
        }
        catch (JSONException localJSONException1) {}
      }
      else
      {
        return null;
      }
    }
    catch (JSONException localJSONException2)
    {
      paramJSONObject = null;
      paramString = paramJSONObject;
      if (QLog.isColorLevel())
      {
        QLog.e("TeamWorkHandlerUtils", 2, localJSONException2, new Object[0]);
        paramString = paramJSONObject;
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils
 * JD-Core Version:    0.7.0.1
 */