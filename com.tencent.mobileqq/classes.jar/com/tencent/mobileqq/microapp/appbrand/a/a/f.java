package com.tencent.mobileqq.microapp.appbrand.a.a;

import aizz;
import android.text.TextUtils;
import android.util.Base64;
import bdhb;
import beae;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.microapp.appbrand.utils.b;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import ndl;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f
  extends a
{
  private static final Set c = new g();
  private static Set d = new m();
  public int b = 0;
  
  private Object a(String paramString1, String paramString2)
  {
    paramString2 = bdhb.a(new File(paramString2));
    if ("base64".equals(paramString1)) {
      return Base64.encodeToString(paramString2, 2);
    }
    try
    {
      paramString1 = new String(paramString2);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  private String a(BaseAppBrandWebview paramBaseAppBrandWebview, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (!paramString.endsWith("Sync"))
    {
      this.a.a(paramBaseAppBrandWebview, paramString, paramJSONObject, paramInt);
      return "";
    }
    return com.tencent.mobileqq.microapp.b.a.a(paramString, paramJSONObject).toString();
  }
  
  private String a(BaseAppBrandWebview paramBaseAppBrandWebview, String paramString1, JSONObject paramJSONObject, String paramString2, int paramInt)
  {
    if (!paramString1.endsWith("Sync"))
    {
      this.a.a(paramBaseAppBrandWebview, paramString1, paramJSONObject, paramString2, paramInt);
      return "";
    }
    return com.tencent.mobileqq.microapp.b.a.a(paramString1, paramJSONObject, paramString2).toString();
  }
  
  private String a(String paramString, f.a parama)
  {
    if (paramString.endsWith("Sync")) {
      return parama.a();
    }
    ThreadManager.excute(new l(this, parama), 16, null, false);
    return "";
  }
  
  private boolean a(JSONArray paramJSONArray, String paramString1, String paramString2, String paramString3)
  {
    paramJSONArray = a(paramJSONArray);
    if (paramJSONArray != null) {}
    for (;;)
    {
      return bdhb.a(paramJSONArray, paramString3);
      paramJSONArray = paramString1.getBytes();
    }
  }
  
  private byte[] a(JSONArray paramJSONArray)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      paramJSONArray = paramJSONArray.optJSONObject(0);
      if (paramJSONArray != null)
      {
        paramJSONArray = paramJSONArray.optString("base64");
        if (!TextUtils.isEmpty(paramJSONArray)) {
          return Base64.decode(paramJSONArray, 0);
        }
      }
    }
    return null;
  }
  
  private boolean b(String paramString)
  {
    return d.contains(paramString);
  }
  
  public String a(String paramString1, String paramString2, BaseAppBrandWebview paramBaseAppBrandWebview, int paramInt)
  {
    QLog.d("FileJsPlugin", 2, "handleNativeRequest: " + paramString1 + " |jsonParams: " + paramString2 + " |callbackId:" + paramInt + "webview: " + paramBaseAppBrandWebview);
    Object localObject5 = new WeakReference(paramBaseAppBrandWebview);
    int i;
    Object localObject6;
    try
    {
      localObject1 = new JSONObject(paramString2);
      if ("createLoadSubPackageTask".equals(paramString1))
      {
        localObject1 = ((JSONObject)localObject1).optString("moduleName");
        i = this.b + 1;
        this.b = i;
        localObject6 = new JSONObject();
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          this.a.a.c.a((String)localObject1, new n(this, (WeakReference)localObject5, i, (String)localObject1));
          ((JSONObject)localObject6).put("loadTaskId", i);
          Object localObject1 = com.tencent.mobileqq.microapp.b.a.a(paramString1, (JSONObject)localObject6).toString();
          return localObject1;
        }
        catch (Throwable localThrowable2)
        {
          JSONObject localJSONObject1;
          localThrowable2.printStackTrace();
        }
        localThrowable1 = localThrowable1;
        localThrowable1.printStackTrace();
        localJSONObject1 = new JSONObject();
      }
    }
    Object localObject7;
    label841:
    do
    {
      for (;;)
      {
        return super.a(paramString1, paramString2, paramBaseAppBrandWebview, paramInt);
        Object localObject8;
        String str3;
        if ("createDownloadTask".equals(paramString1))
        {
          localObject7 = localThrowable2.optString("url");
          Object localObject2 = localThrowable2.optJSONObject("header");
          if ((!TextUtils.isEmpty((CharSequence)localObject7)) && (this.a.a.c.m((String)localObject7)))
          {
            localObject6 = b.a().b((String)localObject7);
            localObject7 = new beae((String)localObject7, new File((String)localObject6));
            ((beae)localObject7).jdField_f_of_type_JavaLangString = "mini_app";
            ((beae)localObject7).jdField_f_of_type_Long = 10000L;
            if (localObject2 != null)
            {
              localObject8 = ((JSONObject)localObject2).keys();
              while (((Iterator)localObject8).hasNext())
              {
                str3 = (String)((Iterator)localObject8).next();
                ((beae)localObject7).a(str3, ((JSONObject)localObject2).optString(str3));
              }
            }
            i = localObject7.hashCode();
            aizz.a().a((beae)localObject7, new o(this, (WeakReference)localObject5, i, (String)localObject6), null);
            localObject2 = new JSONObject();
            try
            {
              ((JSONObject)localObject2).put("downloadTaskId", i);
              localObject2 = com.tencent.mobileqq.microapp.b.a.a(paramString1, (JSONObject)localObject2).toString();
              return localObject2;
            }
            catch (Throwable localThrowable3)
            {
              localThrowable3.printStackTrace();
            }
          }
        }
        else if ("createUploadTask".equals(paramString1))
        {
          localObject7 = localThrowable3.optString("url");
          String str4 = localThrowable3.optString("filePath");
          localObject8 = localThrowable3.optString("name");
          str3 = b.a().d(str4);
          File localFile = new File(str3);
          if ((!TextUtils.isEmpty((CharSequence)localObject7)) && (this.a.a.c.m((String)localObject7)) && (!TextUtils.isEmpty((CharSequence)localObject8)) && (!TextUtils.isEmpty(str3)))
          {
            localObject6 = paramInt + "";
            JSONObject localJSONObject2 = localThrowable3.optJSONObject("header");
            JSONObject localJSONObject3 = localThrowable3.optJSONObject("formData");
            if (TextUtils.isEmpty(str4)) {}
            for (Object localObject3 = "";; localObject3 = str4.replace("wxfile://", ""))
            {
              com.tencent.mobileqq.microapp.b.a.a("POST", (String)localObject7, str3, localJSONObject2, localJSONObject3, (String)localObject8, (String)localObject3, new p(this, (WeakReference)localObject5, (String)localObject6, localFile));
              localObject3 = new JSONObject();
              try
              {
                ((JSONObject)localObject3).put("uploadTaskId", localObject6);
                localObject3 = com.tencent.mobileqq.microapp.b.a.a(paramString1, (JSONObject)localObject3).toString();
                return localObject3;
              }
              catch (Throwable localThrowable4)
              {
                localThrowable4.printStackTrace();
              }
            }
          }
        }
        else
        {
          if (("saveFile".equals(paramString1)) || ("saveFileSync".equals(paramString1))) {
            return a(paramString1, new q(this, localThrowable4.optString("tempFilePath"), paramBaseAppBrandWebview, paramString1, paramInt, localThrowable4.optString("filePath")));
          }
          if (("mkdir".equals(paramString1)) || ("mkdirSync".equals(paramString1))) {
            return a(paramString1, new r(this, localThrowable4.optString("dirPath"), paramBaseAppBrandWebview, paramString1, paramInt));
          }
          if ("getFileInfo".equals(paramString1))
          {
            localObject5 = localThrowable4.optString("filePath");
            String str1 = localThrowable4.optString("digestAlgorithm", "md5");
            localObject7 = b.a().d((String)localObject5);
            if (("md5".equals(str1)) || ("sha1".equals(str1)))
            {
              i = 1;
              if ((TextUtils.isEmpty((CharSequence)localObject7)) || (i == 0)) {
                break label959;
              }
              localObject5 = new File((String)localObject7);
              localObject6 = new JSONObject();
            }
            for (;;)
            {
              try
              {
                if (!"sha1".equals(str1)) {
                  break label961;
                }
                str1 = ndl.a((String)localObject7);
                ((JSONObject)localObject6).put("digest", str1);
                ((JSONObject)localObject6).put("size", ((File)localObject5).length());
                this.a.a(paramBaseAppBrandWebview, paramString1, (JSONObject)localObject6, paramInt);
              }
              catch (Throwable localThrowable5)
              {
                localThrowable5.printStackTrace();
                this.a.b(paramBaseAppBrandWebview, paramString1, null, paramInt);
              }
              break;
              i = 0;
              break label841;
              break;
              localObject4 = MD5Coding.encodeFile2HexStr((String)localObject7);
            }
          }
          if (!"getSavedFileInfo".equals(paramString1)) {
            break;
          }
          Object localObject4 = ((JSONObject)localObject4).optString("filePath");
          localObject4 = b.a().d((String)localObject4);
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            localObject4 = new File((String)localObject4);
            localObject5 = new JSONObject();
            try
            {
              ((JSONObject)localObject5).put("size", ((File)localObject4).length());
              ((JSONObject)localObject5).put("createTime", ((File)localObject4).lastModified() / 1000L);
              this.a.a(paramBaseAppBrandWebview, paramString1, (JSONObject)localObject5, paramInt);
            }
            catch (Throwable localThrowable6)
            {
              localThrowable6.printStackTrace();
              this.a.b(paramBaseAppBrandWebview, paramString1, null, paramInt);
            }
          }
        }
      }
      if (!"getSavedFileList".equals(paramString1)) {
        break;
      }
      localObject5 = b.a().b();
    } while (localObject5 == null);
    for (;;)
    {
      try
      {
        label959:
        label961:
        JSONArray localJSONArray = new JSONArray();
        int j = localObject5.length;
        i = 0;
        if (i < j)
        {
          localObject6 = localObject5[i];
          if ((localObject6 == null) || (!((File)localObject6).exists()) || (!((File)localObject6).isFile())) {
            break label1663;
          }
          localObject7 = new JSONObject();
          ((JSONObject)localObject7).put("filePath", b.a().c(((File)localObject6).getAbsolutePath()));
          ((JSONObject)localObject7).put("size", ((File)localObject6).length());
          ((JSONObject)localObject7).put("createTime", ((File)localObject6).lastModified() / 1000L);
          localJSONArray.put(localObject7);
          break label1663;
        }
        localObject5 = new JSONObject();
        ((JSONObject)localObject5).put("fileList", localJSONArray);
        this.a.a(paramBaseAppBrandWebview, paramString1, (JSONObject)localObject5, paramInt);
      }
      catch (Throwable localThrowable7)
      {
        localThrowable7.printStackTrace();
        this.a.b(paramBaseAppBrandWebview, paramString1, null, paramInt);
      }
      break;
      String str2;
      if ("removeSavedFile".equals(paramString1))
      {
        str2 = localThrowable7.optString("filePath");
        bdhb.a(b.a().d(str2), false);
        this.a.a(paramBaseAppBrandWebview, paramString1, null, paramInt);
        break;
      }
      if ("openDocument".equals(paramString1))
      {
        com.tencent.mobileqq.microapp.appbrand.utils.a.a(new s(this, str2.optString("filePath"), paramBaseAppBrandWebview, paramString1, paramInt));
        break;
      }
      if (("writeFile".equals(paramString1)) || ("writeFileSync".equals(paramString1)))
      {
        paramString2 = str2.optString("filePath");
        localObject5 = str2.optString("data");
        return a(paramString1, new t(this, str2.optString("encoding", "utf8"), paramBaseAppBrandWebview, paramString1, paramInt, paramString2, str2.optJSONArray("__nativeBuffers__"), (String)localObject5));
      }
      if (("readFile".equals(paramString1)) || ("readFileSync".equals(paramString1)))
      {
        paramString2 = str2.optString("filePath");
        return a(paramString1, new h(this, str2.optString("encoding", "utf-8"), paramBaseAppBrandWebview, paramString1, paramInt, paramString2));
      }
      if (("access".equals(paramString1)) || ("accessSync".equals(paramString1))) {
        return a(paramString1, new i(this, str2.optString("path"), paramBaseAppBrandWebview, paramString1, paramInt));
      }
      if (("unlink".equals(paramString1)) || ("unlinkSync".equals(paramString1))) {
        return a(paramString1, new j(this, str2.optString("filePath"), paramBaseAppBrandWebview, paramString1, paramInt));
      }
      if ((!"readdir".equals(paramString1)) && (!"readdirSync".equals(paramString1))) {
        break;
      }
      return a(paramString1, new k(this, str2.optString("dirPath"), paramBaseAppBrandWebview, paramString1, paramInt));
      label1663:
      i += 1;
    }
  }
  
  public Set b()
  {
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.f
 * JD-Core Version:    0.7.0.1
 */