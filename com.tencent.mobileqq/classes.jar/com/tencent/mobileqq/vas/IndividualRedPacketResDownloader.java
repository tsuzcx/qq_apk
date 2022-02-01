package com.tencent.mobileqq.vas;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.AnimConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IndividualRedPacketResDownloader
{
  QQAppInterface a;
  public QQLruCache<String, IndividualRedPacketResDownloader.RedPacketTemplateInfo> b;
  public IndividualRedPacketResDownloader.Char300Info c = new IndividualRedPacketResDownloader.Char300Info();
  public IndividualRedPacketResDownloader.Char300Info d = new IndividualRedPacketResDownloader.Char300Info();
  public IndividualRedPacketResDownloader.RedPacketResInfo e = new IndividualRedPacketResDownloader.RedPacketResInfo();
  public String f = null;
  public String g = null;
  public String h = null;
  ArrayList<IndividualRedPacketResDownloader.DownloadHolder> i;
  public boolean j;
  public boolean k;
  public Map<String, List<String>> l = new HashMap();
  AtomicBoolean m = new AtomicBoolean(false);
  long n;
  public AtomicBoolean o = new AtomicBoolean(false);
  IndividualRedPacketManager p;
  CallBacker q = new IndividualRedPacketResDownloader.1(this);
  
  public IndividualRedPacketResDownloader(QQAppInterface paramQQAppInterface, IndividualRedPacketManager paramIndividualRedPacketManager)
  {
    this.a = paramQQAppInterface;
    this.d.a = "";
    this.p = paramIndividualRedPacketManager;
    this.k = paramIndividualRedPacketManager.c().getBoolean("mall_entrance_switch", false);
    this.j = paramIndividualRedPacketManager.c().getBoolean("redpacket_is_show_switch", false);
    this.b = new QQLruCache(1009, 100, 300);
    this.e.k = 8;
    this.d.k = 26;
    paramQQAppInterface = (IVasQuickUpdateService)paramQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
    if (paramQQAppInterface != null) {
      paramQQAppInterface.addCallBacker(this.q);
    }
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, JSONArray paramJSONArray, ArrayList<IndividualRedPacketResDownloader.DownloadHolder> paramArrayList)
  {
    int i1 = paramInt2;
    paramInt2 = 0;
    boolean bool1;
    String str;
    int i2;
    IndividualRedPacketResDownloader.RedPacketTemplateInfo localRedPacketTemplateInfo;
    if (paramInt2 < paramJSONArray.length())
    {
      if ((paramInt2 < paramInt1) && (i1 < paramInt3)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      str = paramJSONArray.optString(paramInt2);
      if (TextUtils.isEmpty(str)) {
        i2 = i1;
      } else {
        localRedPacketTemplateInfo = (IndividualRedPacketResDownloader.RedPacketTemplateInfo)this.b.get(str);
      }
    }
    for (;;)
    {
      synchronized (this.l)
      {
        if (!this.l.containsKey(str)) {
          break label189;
        }
        bool2 = a(false, str, localRedPacketTemplateInfo);
        boolean bool3 = bool1;
        if (bool1)
        {
          bool3 = bool1;
          if (!bool2) {
            bool3 = b(str);
          }
        }
        i2 = i1;
        if (bool3)
        {
          i2 = i1;
          if (!bool2) {
            i2 = a(i1, paramArrayList, str);
          }
        }
        paramInt2 += 1;
        i1 = i2;
      }
      return i1;
      label189:
      boolean bool2 = false;
    }
  }
  
  private int a(int paramInt, ArrayList<IndividualRedPacketResDownloader.DownloadHolder> paramArrayList, String paramString)
  {
    IndividualRedPacketResDownloader.DownloadHolder localDownloadHolder = new IndividualRedPacketResDownloader.DownloadHolder();
    localDownloadHolder.a = 16L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("luckyMoney.item.");
    localStringBuilder.append(paramString);
    localDownloadHolder.b = localStringBuilder.toString();
    localDownloadHolder.c = IndividualRedPacketManager.a(paramString, null, 0, 0, 0);
    paramArrayList.add(localDownloadHolder);
    return paramInt + 1;
  }
  
  private IndividualRedPacketResDownloader.RedPacketTemplateInfo a(String paramString, IndividualRedPacketResDownloader.RedPacketTemplateInfo paramRedPacketTemplateInfo)
  {
    IndividualRedPacketResDownloader.RedPacketTemplateInfo localRedPacketTemplateInfo;
    if ((paramRedPacketTemplateInfo != null) && (!a(paramRedPacketTemplateInfo.b)) && (!a(paramRedPacketTemplateInfo.c)))
    {
      localRedPacketTemplateInfo = paramRedPacketTemplateInfo;
      if (!a(paramRedPacketTemplateInfo.d)) {}
    }
    else
    {
      localRedPacketTemplateInfo = a(paramString);
    }
    return localRedPacketTemplateInfo;
  }
  
  @Nullable
  private JSONObject a(JSONObject paramJSONObject)
  {
    long l1 = paramJSONObject.optLong("timestamp", 1L);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initAllConfigJson timestamp=");
      localStringBuilder.append(l1);
      localStringBuilder.append(", mJsonTimestamp:");
      localStringBuilder.append(this.n);
      QLog.d("IndividualRedPacketResDownloader", 2, localStringBuilder.toString());
    }
    if (l1 <= this.n) {
      return null;
    }
    this.n = l1;
    paramJSONObject = paramJSONObject.optJSONObject("data");
    if (paramJSONObject == null)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("initAllConfigJson, null == data, timestamp=");
      paramJSONObject.append(l1);
      paramJSONObject.append(", mJsonTimestamp:");
      paramJSONObject.append(this.n);
      QLog.e("IndividualRedPacketResDownloader", 2, paramJSONObject.toString());
      return null;
    }
    return paramJSONObject;
  }
  
  private void a(File paramFile, String paramString)
  {
    if ((!TextUtils.isEmpty(this.d.b)) && (!paramString.equals(this.p.c().getString("special_unzip_version_key", ""))))
    {
      File localFile = new File(IndividualRedPacketManager.a(null, null, 26, 0, 0));
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(IndividualRedPacketManager.a(2));
      ((StringBuilder)localObject).append("images");
      localObject = ((StringBuilder)localObject).toString();
      if (a(localFile.getAbsolutePath(), (String)localObject))
      {
        this.p.c().edit().putString("special_unzip_version_key", paramString).commit();
        return;
      }
      if ((!localFile.exists()) && (paramFile != null)) {
        paramFile.delete();
      }
    }
  }
  
  private void a(String paramString, boolean paramBoolean, int paramInt1, IndividualRedPacketResDownloader.RedPacketResInfo paramRedPacketResInfo, int paramInt2)
  {
    paramRedPacketResInfo.j = paramInt1;
    if (paramBoolean) {
      a(true, false, paramString, new File(IndividualRedPacketManager.a(null, null, paramInt2, 0, 0)));
    }
  }
  
  private void a(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      b(paramJSONArray);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse urllist == null");
    }
  }
  
  private void a(JSONObject paramJSONObject, boolean paramBoolean, IndividualRedPacketResDownloader.RedPacketTemplateInfo paramRedPacketTemplateInfo)
  {
    Object localObject = paramJSONObject.optJSONArray("aioChar");
    if ((localObject != null) && (((JSONArray)localObject).length() >= 4))
    {
      paramRedPacketTemplateInfo.b.b = new Rect(((JSONArray)localObject).optInt(0), ((JSONArray)localObject).optInt(1), ((JSONArray)localObject).optInt(0) + ((JSONArray)localObject).optInt(2), ((JSONArray)localObject).optInt(1) + ((JSONArray)localObject).optInt(3));
      paramRedPacketTemplateInfo.b.a = ((JSONArray)localObject).optInt(2);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTemplateByJson aioChar error,name:");
      ((StringBuilder)localObject).append(paramRedPacketTemplateInfo.b.f);
      ((StringBuilder)localObject).append(", id:");
      ((StringBuilder)localObject).append(paramRedPacketTemplateInfo.a);
      ((StringBuilder)localObject).append(", isV710:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.e("IndividualRedPacketResDownloader", 2, ((StringBuilder)localObject).toString());
      paramRedPacketTemplateInfo.b.b = new Rect(1, 1, 1, 1);
      paramRedPacketTemplateInfo.b.a = 1;
      paramRedPacketTemplateInfo.e = IndividualRedPacketResDownloader.RedPacketTemplateInfo.g;
    }
    localObject = paramJSONObject.optJSONArray("packetChar");
    if ((localObject != null) && (((JSONArray)localObject).length() >= 4))
    {
      paramRedPacketTemplateInfo.c.b = new Rect(((JSONArray)localObject).optInt(0), ((JSONArray)localObject).optInt(1), ((JSONArray)localObject).optInt(0) + ((JSONArray)localObject).optInt(2), ((JSONArray)localObject).optInt(1) + ((JSONArray)localObject).optInt(3));
      paramRedPacketTemplateInfo.c.a = ((JSONArray)localObject).optInt(2);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTemplateByJson packetChar error,name:");
      ((StringBuilder)localObject).append(paramRedPacketTemplateInfo.b.f);
      ((StringBuilder)localObject).append(", id:");
      ((StringBuilder)localObject).append(paramRedPacketTemplateInfo.a);
      ((StringBuilder)localObject).append(", isV710:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.e("IndividualRedPacketResDownloader", 2, ((StringBuilder)localObject).toString());
      paramRedPacketTemplateInfo.c.b = new Rect(1, 1, 1, 1);
      paramRedPacketTemplateInfo.c.a = 1;
      paramRedPacketTemplateInfo.e = IndividualRedPacketResDownloader.RedPacketTemplateInfo.g;
    }
    paramJSONObject = paramJSONObject.optJSONArray("sendChar");
    if ((paramJSONObject != null) && (paramJSONObject.length() >= 4))
    {
      paramRedPacketTemplateInfo.d.b = new Rect(paramJSONObject.optInt(0), paramJSONObject.optInt(1), paramJSONObject.optInt(0) + paramJSONObject.optInt(2), paramJSONObject.optInt(1) + paramJSONObject.optInt(3));
      paramRedPacketTemplateInfo.d.a = paramJSONObject.optInt(2);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("getTemplateByJson sendChar error,name:");
      paramJSONObject.append(paramRedPacketTemplateInfo.b.f);
      paramJSONObject.append(", id:");
      paramJSONObject.append(paramRedPacketTemplateInfo.a);
      paramJSONObject.append(", isV710:");
      paramJSONObject.append(paramBoolean);
      QLog.d("IndividualRedPacketResDownloader", 2, paramJSONObject.toString());
    }
  }
  
  private void a(boolean paramBoolean, ArrayList<IndividualRedPacketResDownloader.DownloadHolder> paramArrayList, int paramInt)
  {
    ArrayList localArrayList = this.i;
    if (localArrayList == null) {
      this.i = paramArrayList;
    } else {
      localArrayList.addAll(paramArrayList);
    }
    if ((!this.m.get()) && ((1 == paramInt) || (paramBoolean)) && (this.p.g()))
    {
      a();
      return;
    }
    this.i = null;
  }
  
  public static boolean a(IndividualRedPacketResDownloader.RedPacketResInfo paramRedPacketResInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramRedPacketResInfo != null)
    {
      if (paramRedPacketResInfo.k == 0) {
        return false;
      }
      paramRedPacketResInfo = IndividualRedPacketManager.a(paramRedPacketResInfo.g, paramRedPacketResInfo.f, paramRedPacketResInfo.k, paramRedPacketResInfo.i, 0);
      if (TextUtils.isEmpty(paramRedPacketResInfo)) {
        paramRedPacketResInfo = null;
      } else {
        paramRedPacketResInfo = new File(paramRedPacketResInfo);
      }
      bool1 = bool2;
      if (paramRedPacketResInfo != null)
      {
        bool1 = bool2;
        if (paramRedPacketResInfo.exists())
        {
          bool1 = bool2;
          if (paramRedPacketResInfo.isFile()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean a(IndividualRedPacketResDownloader.RedPacketTemplateInfo paramRedPacketTemplateInfo)
  {
    if ((paramRedPacketTemplateInfo != null) && (paramRedPacketTemplateInfo.b != null) && (paramRedPacketTemplateInfo.c != null))
    {
      if (paramRedPacketTemplateInfo.d == null) {
        return true;
      }
      return new File(IndividualRedPacketManager.a(paramRedPacketTemplateInfo.a, null, 0, 0, 0)).exists();
    }
    return true;
  }
  
  private boolean a(File paramFile1, File paramFile2, File paramFile3, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("data");
    if (paramJSONObject == null)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion data fail Err, return");
      return true;
    }
    JSONArray localJSONArray = paramJSONObject.optJSONArray("templateList");
    if (localJSONArray == null)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion templateList fail Err, return");
      return true;
    }
    int i1 = 0;
    while (i1 < localJSONArray.length())
    {
      Object localObject2 = a(localJSONArray.optJSONObject(i1), false);
      if (!a((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2))
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append(((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).a);
        paramJSONObject.append("_");
        paramJSONObject.append(((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).h);
        Object localObject3 = paramJSONObject.toString();
        paramJSONObject = new StringBuilder();
        paramJSONObject.append(paramFile1.getAbsolutePath());
        paramJSONObject.append(File.separator);
        paramJSONObject.append((String)localObject3);
        Object localObject1 = paramJSONObject.toString();
        IndividualRedPacketResDownloader.DecorateInfo localDecorateInfo = ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).b;
        paramJSONObject = (JSONObject)localObject1;
        if (localDecorateInfo.k == 19)
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append((String)localObject1);
          paramJSONObject.append("_zip");
          paramJSONObject = paramJSONObject.toString();
        }
        if (new File(paramJSONObject).exists())
        {
          localObject1 = new String[3];
          localObject1[0] = paramJSONObject;
          paramJSONObject = new StringBuilder();
          paramJSONObject.append(paramFile2.getAbsolutePath());
          paramJSONObject.append(File.separator);
          paramJSONObject.append((String)localObject3);
          localObject1[1] = paramJSONObject.toString();
          paramJSONObject = new StringBuilder();
          paramJSONObject.append(paramFile3.getAbsolutePath());
          paramJSONObject.append(File.separator);
          paramJSONObject.append((String)localObject3);
          localObject1[2] = paramJSONObject.toString();
          paramJSONObject = ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).c;
          localObject3 = ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).d;
          localObject2 = new String[3];
          localObject2[0] = IndividualRedPacketManager.a(localDecorateInfo.g, localDecorateInfo.f, localDecorateInfo.k, localDecorateInfo.i, 0);
          localObject2[1] = IndividualRedPacketManager.a(paramJSONObject.g, paramJSONObject.f, paramJSONObject.k, paramJSONObject.i, 0);
          localObject2[2] = IndividualRedPacketManager.a(((IndividualRedPacketResDownloader.DecorateInfo)localObject3).g, ((IndividualRedPacketResDownloader.DecorateInfo)localObject3).f, ((IndividualRedPacketResDownloader.DecorateInfo)localObject3).k, ((IndividualRedPacketResDownloader.DecorateInfo)localObject3).i, 0);
          int i2 = 0;
          while (i2 < localObject1.length)
          {
            if (!FileUtils.copyFile(localObject1[i2], localObject2[i2]))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              paramJSONObject = new StringBuilder();
              paramJSONObject.append("updateResVersion copyFile aio file Err:");
              paramJSONObject.append(localObject1[i2]);
              paramJSONObject.append(", newPath:");
              paramJSONObject.append(localObject2[i2]);
              QLog.e("IndividualRedPacketResDownloader", 2, paramJSONObject.toString());
              break;
            }
            i2 += 1;
          }
        }
      }
      i1 += 1;
    }
    return false;
  }
  
  private boolean a(File paramFile1, File paramFile2, File paramFile3, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramFile1.exists())
    {
      bool = paramBoolean;
      if (paramFile1.isDirectory())
      {
        bool = paramBoolean;
        if (paramFile2.exists())
        {
          bool = paramBoolean;
          if (paramFile2.isDirectory())
          {
            bool = paramBoolean;
            if (paramFile3.exists())
            {
              bool = paramBoolean;
              if (paramFile3.isDirectory())
              {
                paramFile1 = paramFile1.list();
                paramFile2 = paramFile2.list();
                paramFile3 = paramFile3.list();
                bool = paramBoolean;
                if (paramFile1.length > 0)
                {
                  bool = paramBoolean;
                  if (paramFile2.length > 0)
                  {
                    bool = paramBoolean;
                    if (paramFile3.length > 0) {
                      bool = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool;
  }
  
  private boolean a(String paramString, int paramInt)
  {
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      paramInt = 2;
    } else {
      paramInt = -1;
    }
    if ("iRedPacket_v3.json".equals(paramString))
    {
      a(true, false);
      return bool;
    }
    QQAppInterface localQQAppInterface;
    String str;
    if ("iRedPacket_v3.char300.json".equals(paramString))
    {
      b(paramString, bool);
      localQQAppInterface = this.a;
      str = IndividualRedPacketManager.G;
      if (bool) {
        paramString = "1";
      } else {
        paramString = "0";
      }
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X800612D", "0X800612D", 0, 0, str, paramString, "1", "");
      return bool;
    }
    if ("iRedPacket_v3.font.zip".equals(paramString))
    {
      a(paramString, bool, paramInt, this.e, 21);
      localQQAppInterface = this.a;
      str = IndividualRedPacketManager.G;
      if (bool) {
        paramString = "1";
      } else {
        paramString = "0";
      }
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X800612C", "0X800612C", 0, 0, str, paramString, "1", "");
      return bool;
    }
    if ("iRedPacket_v3.specialChar.zip".equals(paramString))
    {
      a(paramString, bool, paramInt, this.d, 25);
      return bool;
    }
    if (paramString.startsWith("luckyMoney.item.")) {
      c(paramString, bool);
    }
    return bool;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    File localFile = new File(paramString1);
    boolean bool1 = localFile.exists();
    boolean bool3 = true;
    int i1;
    if ((bool1) && (localFile.isFile()))
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("uncompressZip zipFile.exists(), zipFile.length()=");
        ((StringBuilder)localObject).append(localFile.length());
        QLog.d("IndividualRedPacketResDownloader", 2, ((StringBuilder)localObject).toString());
      }
      try
      {
        FileUtils.uncompressZip(paramString1, paramString2, false);
        localObject = new File(paramString2);
        if (!((File)localObject).exists()) {
          break label202;
        }
        i1 = ThemeUtil.getFileNumInFile((File)localObject);
      }
      catch (IOException localIOException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("uncompressZip FileUtils.uncompressZip IOException:");
        localStringBuilder.append(localIOException.getMessage());
        QLog.e("IndividualRedPacketResDownloader", 1, localStringBuilder.toString());
      }
      QLog.e("IndividualRedPacketResDownloader", 1, "uncompressZip fileNum == 0");
    }
    for (bool1 = false;; bool1 = true)
    {
      boolean bool2 = a(paramString1, paramString2, localFile, bool1, false);
      break label185;
      bool2 = false;
      bool1 = false;
      label185:
      if (!bool1)
      {
        if (bool2) {
          return true;
        }
        bool3 = false;
      }
      return bool3;
      label202:
      i1 = 0;
      if (i1 <= 0) {
        break;
      }
    }
  }
  
  private static boolean a(String paramString1, String paramString2, File paramFile, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      paramString2 = new File(paramString2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uncompressZip DownloaderFactory.unzipResource, themeZipPath:");
      localStringBuilder.append(paramString1);
      QLog.d("IndividualRedPacketResDownloader", 1, localStringBuilder.toString());
      paramBoolean2 = DownloaderFactory.a(paramFile, paramString2, false);
    }
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      FileUtils.deleteFile(paramString1);
      QLog.e("IndividualRedPacketResDownloader", 1, "uncompressZip result false");
    }
    return paramBoolean2;
  }
  
  private boolean a(boolean paramBoolean, String paramString, IndividualRedPacketResDownloader.RedPacketTemplateInfo paramRedPacketTemplateInfo)
  {
    paramRedPacketTemplateInfo = a(paramString, paramRedPacketTemplateInfo);
    if ((paramRedPacketTemplateInfo != null) && (a(paramRedPacketTemplateInfo.b)) && (a(paramRedPacketTemplateInfo.c)) && (a(paramRedPacketTemplateInfo.d)))
    {
      List localList = (List)this.l.get(paramString);
      int i1 = 0;
      while (i1 < localList.size())
      {
        String str = (String)localList.get(i1);
        if (!TextUtils.isEmpty(str))
        {
          this.p.a(str, paramRedPacketTemplateInfo.b.k);
          IndividualRedPacketManager localIndividualRedPacketManager = this.p;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_tp");
          localIndividualRedPacketManager.a(localStringBuilder.toString(), paramRedPacketTemplateInfo.c.k);
          localIndividualRedPacketManager = this.p;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_send");
          localIndividualRedPacketManager.a(localStringBuilder.toString(), paramRedPacketTemplateInfo.d.k);
        }
        i1 += 1;
      }
      this.l.remove(paramString);
      return paramBoolean;
    }
    a(16L, paramString, null);
    return true;
  }
  
  @NotNull
  private ArrayList<IndividualRedPacketResDownloader.DownloadHolder> b(JSONObject paramJSONObject, boolean paramBoolean)
  {
    Object localObject1 = paramJSONObject.optJSONArray("isPreload");
    int i1 = 5;
    int i2;
    if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
    {
      localObject1 = ((JSONArray)localObject1).optJSONObject(0);
      i1 = ((JSONObject)localObject1).optInt("isPreload", 5);
      i2 = ((JSONObject)localObject1).optInt("preloadTotal", 50);
    }
    else
    {
      i2 = 50;
    }
    Object localObject2 = paramJSONObject.optJSONArray("templateIdList");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAndDownloadBeforeUse ,emergencyDownload:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", templateIdList:");
      if (localObject2 == null) {
        localObject1 = "null";
      } else {
        localObject1 = Integer.valueOf(((JSONArray)localObject2).length());
      }
      localStringBuilder.append(localObject1);
      QLog.d("IndividualRedPacketResDownloader", 2, localStringBuilder.toString());
    }
    localObject1 = new ArrayList();
    int i3 = 0;
    if (localObject2 != null) {
      i3 = a(i2, 0, i1, (JSONArray)localObject2, (ArrayList)localObject1);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkAndDownloadBeforeUse finish! size = ");
      ((StringBuilder)localObject2).append(this.b.size());
      ((StringBuilder)localObject2).append(", preloadSize=");
      ((StringBuilder)localObject2).append(i3);
      ((StringBuilder)localObject2).append(", totalCanPreload=");
      ((StringBuilder)localObject2).append(i1);
      QLog.d("IndividualRedPacketResDownloader", 2, ((StringBuilder)localObject2).toString());
    }
    a(paramJSONObject.optJSONArray("vipRedPacketURL"));
    return localObject1;
  }
  
  private JSONObject b(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IndividualRedPacketResDownloader", 2, "updateResVersion null == resJson waiting download");
    }
    Object localObject = this.a.getApplication().getApplicationContext();
    String str = ClubContentJsonTask.g.a;
    localObject = new File(((Context)localObject).getFilesDir(), str);
    localObject = new DownloadTask(ClubContentJsonTask.g.b, (File)localObject);
    ((DownloadTask)localObject).J = true;
    if (DownloaderFactory.a((DownloadTask)localObject, this.a) == 0) {
      return ClubContentJsonTask.a(this.a, ClubContentJsonTask.g, false);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateResVersion download Err : ");
    ((StringBuilder)localObject).append(ClubContentJsonTask.g.b);
    QLog.e("IndividualRedPacketResDownloader", 2, ((StringBuilder)localObject).toString());
    return paramJSONObject;
  }
  
  @Nullable
  private JSONObject b(boolean paramBoolean1, boolean paramBoolean2, String paramString, File paramFile)
  {
    StringBuilder localStringBuilder1;
    if ((paramFile != null) && (paramFile.exists())) {
      try
      {
        JSONObject localJSONObject = new JSONObject(FileUtils.readFileContent(paramFile));
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("initJsonBySCID ,filePath:");
        localStringBuilder2.append(paramFile.getAbsolutePath());
        QLog.e("IndividualRedPacketResDownloader", 2, localStringBuilder2.toString(), localThrowable);
      }
    } else {
      localStringBuilder1 = null;
    }
    if (localStringBuilder1 == null)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("initJsonBySCID null == resJson, scid=");
        localStringBuilder1.append(paramString);
        localStringBuilder1.append(", isAfterDownload:");
        localStringBuilder1.append(paramBoolean1);
        localStringBuilder1.append(", isInit");
        localStringBuilder1.append(paramBoolean2);
        localStringBuilder1.append(", file=");
        if (paramFile != null) {
          paramString = paramFile.getAbsolutePath();
        } else {
          paramString = "null";
        }
        localStringBuilder1.append(paramString);
        QLog.e("IndividualRedPacketResDownloader", 2, localStringBuilder1.toString());
      }
      return null;
    }
    return localStringBuilder1;
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(BaseApplicationImpl.getContext().getFilesDir());
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("pddata/vas/redpacket/");
      ((StringBuilder)localObject).append("iRedPacket_v3.char300.json");
      localObject = ((StringBuilder)localObject).toString();
      a(true, false, paramString, VasUpdateUtil.a(this.a, 16L, "iRedPacket_v3.char300.json", (String)localObject, false, this.q));
    }
  }
  
  private void b(JSONArray paramJSONArray)
  {
    int i1 = 0;
    while (i1 < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optJSONObject(i1);
      String str = ((JSONObject)localObject).optString("name");
      localObject = ((JSONObject)localObject).optString("url", null);
      if ("aioTail".equals(str)) {
        this.g = ((String)localObject);
      } else if ("personalityMall".equals(str)) {
        this.f = ((String)localObject);
      } else if ("tencentPay".equals(str)) {
        this.h = ((String)localObject);
      }
      i1 += 1;
    }
    if (QLog.isColorLevel())
    {
      paramJSONArray = new StringBuilder();
      paramJSONArray.append("checkAndDownloadBeforeUse mAioTailURL:");
      paramJSONArray.append(this.g);
      paramJSONArray.append(", mTencentPayURL:");
      paramJSONArray.append(this.h);
      paramJSONArray.append(", mPersonalityMallURL:");
      paramJSONArray.append(this.f);
      QLog.d("IndividualRedPacketResDownloader", 2, paramJSONArray.toString());
    }
  }
  
  private boolean b(String paramString)
  {
    if (new File(IndividualRedPacketManager.a(paramString, null, 0, 0, 0)).exists()) {
      return false;
    }
    return new File(IndividualRedPacketManager.a(paramString, null, 3, 0, 0)).exists() ^ true;
  }
  
  private void c(String paramString, boolean paramBoolean)
  {
    String str1 = IndividualRedPacketManager.a(paramString);
    int i1;
    Object localObject2;
    if (paramBoolean)
    {
      paramString = a(str1);
      if ((paramString != null) && (this.p != null))
      {
        int i2 = paramString.b.k;
        int i3 = paramString.b.i;
        i1 = 0;
        ??? = IndividualRedPacketManager.a(str1, null, i2, i3, 0);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)???);
        ((StringBuilder)localObject2).append("_dir2");
        ??? = ((StringBuilder)localObject2).toString();
        VasUpdateUtil.a(new File((String)???));
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("callBacker delete animateDir: ");
          ((StringBuilder)localObject2).append((String)???);
          QLog.d("IndividualRedPacketResDownloader", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
    for (;;)
    {
      synchronized (this.l)
      {
        if (this.l.containsKey(str1))
        {
          localObject2 = (List)this.l.get(str1);
          if (i1 < ((List)localObject2).size())
          {
            String str2 = (String)((List)localObject2).get(i1);
            if (TextUtils.isEmpty(str2)) {
              break label422;
            }
            this.p.a(str2, paramString.b.k);
            IndividualRedPacketManager localIndividualRedPacketManager = this.p;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(str2);
            localStringBuilder.append("_tp");
            localIndividualRedPacketManager.a(localStringBuilder.toString(), paramString.c.k);
            localIndividualRedPacketManager = this.p;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(str2);
            localStringBuilder.append("_send");
            localIndividualRedPacketManager.a(localStringBuilder.toString(), paramString.d.k);
            break label422;
          }
          this.l.remove(paramString.a);
        }
      }
      ??? = this.a;
      localObject2 = IndividualRedPacketManager.G;
      if (paramBoolean) {
        paramString = "1";
      } else {
        paramString = "0";
      }
      ReportController.b((AppRuntime)???, "CliOper", "", "", "0X800612E", "0X800612E", 0, 0, (String)localObject2, paramString, "1", str1);
      return;
      label422:
      i1 += 1;
    }
  }
  
  private boolean c(JSONObject paramJSONObject, boolean paramBoolean)
  {
    Object localObject = paramJSONObject.optString("time");
    boolean bool1 = TextUtils.isEmpty((CharSequence)localObject);
    boolean bool2 = true;
    if (!bool1) {
      if (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String)localObject).getTime() - NetConnInfoCenter.getServerTimeMillis() < 172800000L) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
    }
    localObject = this.p.c();
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
    if (paramJSONObject.has("androidShowSwitch"))
    {
      if (paramJSONObject.getInt("androidShowSwitch") == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.j = bool1;
    }
    if (paramJSONObject.has("androidEntrySwitch"))
    {
      if (paramJSONObject.getInt("androidEntrySwitch") == 1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      this.k = bool1;
    }
    if ((this.j != ((SharedPreferences)localObject).getBoolean("redpacket_is_show_switch", false)) || (this.k != ((SharedPreferences)localObject).getBoolean("mall_entrance_switch", false)))
    {
      localEditor.putBoolean("redpacket_is_show_switch", this.j);
      localEditor.putBoolean("mall_entrance_switch", this.k);
      localEditor.commit();
    }
    return paramBoolean;
  }
  
  private void e()
  {
    if ((this.c.j == 2) && (this.e.j == 2) && (this.p.g()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse goto preCreatePersonalFontImg");
      }
      this.p.a(this.c);
    }
  }
  
  private boolean f()
  {
    if (this.a != null)
    {
      IndividualRedPacketManager localIndividualRedPacketManager = this.p;
      if (localIndividualRedPacketManager == null) {
        return true;
      }
      return localIndividualRedPacketManager.m.get();
    }
    return true;
  }
  
  public IndividualRedPacketResDownloader.RedPacketTemplateInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = new File(IndividualRedPacketManager.a(paramString, null, 0, 0, 0));
    if (paramString.exists()) {
      try
      {
        IndividualRedPacketResDownloader.RedPacketTemplateInfo localRedPacketTemplateInfo = a(new JSONObject(FileUtils.readFileContent(paramString)), true);
        if (localRedPacketTemplateInfo != null) {
          this.b.put(localRedPacketTemplateInfo.a, localRedPacketTemplateInfo);
        }
        return localRedPacketTemplateInfo;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadPacketJson ,filePath:");
        localStringBuilder.append(paramString.getAbsolutePath());
        QLog.e("IndividualRedPacketResDownloader", 2, localStringBuilder.toString(), localThrowable);
      }
    }
    return null;
  }
  
  public IndividualRedPacketResDownloader.RedPacketTemplateInfo a(String paramString, boolean paramBoolean)
  {
    IndividualRedPacketResDownloader.RedPacketTemplateInfo localRedPacketTemplateInfo2 = (IndividualRedPacketResDownloader.RedPacketTemplateInfo)this.b.get(paramString);
    if (!paramBoolean) {
      return localRedPacketTemplateInfo2;
    }
    IndividualRedPacketResDownloader.RedPacketTemplateInfo localRedPacketTemplateInfo1;
    if ((localRedPacketTemplateInfo2 != null) && (localRedPacketTemplateInfo2.b != null) && (localRedPacketTemplateInfo2.c != null))
    {
      localRedPacketTemplateInfo1 = localRedPacketTemplateInfo2;
      if (localRedPacketTemplateInfo2.d != null) {}
    }
    else
    {
      localRedPacketTemplateInfo1 = a(paramString);
    }
    return localRedPacketTemplateInfo1;
  }
  
  IndividualRedPacketResDownloader.RedPacketTemplateInfo a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      localObject1 = paramJSONObject.optString("id");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return null;
      }
      IndividualRedPacketResDownloader.RedPacketTemplateInfo localRedPacketTemplateInfo = new IndividualRedPacketResDownloader.RedPacketTemplateInfo();
      localRedPacketTemplateInfo.b = new IndividualRedPacketResDownloader.DecorateInfo();
      localRedPacketTemplateInfo.b.k = 2;
      localRedPacketTemplateInfo.c = new IndividualRedPacketResDownloader.DecorateInfo();
      localRedPacketTemplateInfo.c.k = 3;
      localRedPacketTemplateInfo.d = new IndividualRedPacketResDownloader.DecorateInfo();
      localRedPacketTemplateInfo.d.k = 14;
      localRedPacketTemplateInfo.a = ((String)localObject1);
      localRedPacketTemplateInfo.b.g = ((String)localObject1);
      localRedPacketTemplateInfo.c.g = ((String)localObject1);
      localRedPacketTemplateInfo.d.g = ((String)localObject1);
      localRedPacketTemplateInfo.b.f = paramJSONObject.optString("name");
      localRedPacketTemplateInfo.c.f = localRedPacketTemplateInfo.b.f;
      localRedPacketTemplateInfo.d.f = localRedPacketTemplateInfo.b.f;
      localRedPacketTemplateInfo.e = paramJSONObject.optInt("customWord", IndividualRedPacketResDownloader.RedPacketTemplateInfo.g);
      localRedPacketTemplateInfo.i = paramJSONObject.optInt("fontTypeId", 1);
      localRedPacketTemplateInfo.h = paramJSONObject.optInt("version", 0);
      localRedPacketTemplateInfo.b.i = localRedPacketTemplateInfo.h;
      localRedPacketTemplateInfo.c.i = localRedPacketTemplateInfo.h;
      localRedPacketTemplateInfo.d.i = localRedPacketTemplateInfo.h;
      if (localRedPacketTemplateInfo.e == IndividualRedPacketResDownloader.RedPacketTemplateInfo.f)
      {
        a(paramJSONObject, paramBoolean, localRedPacketTemplateInfo);
      }
      else
      {
        localObject1 = paramJSONObject.optString("aioPngZip", null);
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).indexOf("http") >= 0))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getTemplateByJson aioPngZip ,name=");
            ((StringBuilder)localObject2).append(localRedPacketTemplateInfo.b.f);
            ((StringBuilder)localObject2).append(", id:");
            ((StringBuilder)localObject2).append(localRedPacketTemplateInfo.a);
            ((StringBuilder)localObject2).append(", url:");
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(", isV710:");
            ((StringBuilder)localObject2).append(paramBoolean);
            QLog.d("IndividualRedPacketResDownloader", 2, ((StringBuilder)localObject2).toString());
          }
          localObject2 = new ICustomizeStrategyFactory.AnimConfig();
          ((ICustomizeStrategyFactory.AnimConfig)localObject2).c = paramJSONObject.optInt("interval", 100);
          ((ICustomizeStrategyFactory.AnimConfig)localObject2).b = paramJSONObject.optInt("flameCount", 0);
          localRedPacketTemplateInfo.b.c = ((ICustomizeStrategyFactory.AnimConfig)localObject2);
          localRedPacketTemplateInfo.b.d = ((String)localObject1);
          localRedPacketTemplateInfo.b.k = 19;
        }
      }
      Object localObject2 = localRedPacketTemplateInfo.b;
      localObject1 = localRedPacketTemplateInfo.b.c;
      if (localObject1 == null) {
        localObject1 = paramJSONObject.optString("aioImgUrl", "");
      } else {
        localObject1 = localRedPacketTemplateInfo.b.d;
      }
      ((IndividualRedPacketResDownloader.DecorateInfo)localObject2).h = ((String)localObject1);
      localRedPacketTemplateInfo.c.h = paramJSONObject.optString("redEnvelopeImgUrl", "");
      localRedPacketTemplateInfo.d.h = paramJSONObject.optString("sendImgUrl", "");
      return localRedPacketTemplateInfo;
    }
    catch (Throwable paramJSONObject)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getTemplateByJson Err:");
      ((StringBuilder)localObject1).append(paramJSONObject.toString());
      ((StringBuilder)localObject1).append(", isV710:");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.e("IndividualRedPacketResDownloader", 2, ((StringBuilder)localObject1).toString());
    }
    return null;
  }
  
  public JSONObject a(File paramFile, JSONObject paramJSONObject)
  {
    if ((paramFile != null) && (paramFile.exists())) {
      try
      {
        JSONObject localJSONObject = new JSONObject(FileUtils.readFileContent(paramFile));
        return localJSONObject;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initJsonBySCID ,filePath:");
        localStringBuilder.append(paramFile.getAbsolutePath());
        QLog.e("IndividualRedPacketResDownloader", 2, localStringBuilder.toString(), localThrowable);
      }
    }
    return paramJSONObject;
  }
  
  void a()
  {
    try
    {
      if ((this.a != null) && (this.p != null) && (this.i != null))
      {
        int i1 = this.i.size();
        if (i1 > 0)
        {
          try
          {
            IndividualRedPacketResDownloader.DownloadHolder localDownloadHolder = (IndividualRedPacketResDownloader.DownloadHolder)this.i.remove(0);
            if (localDownloadHolder == null)
            {
              a();
              return;
            }
            if (new File(localDownloadHolder.c).exists())
            {
              a();
              return;
            }
            localObject2 = (IVasQuickUpdateService)this.a.getRuntimeService(IVasQuickUpdateService.class, "");
            ((IVasQuickUpdateService)localObject2).addCallBacker(this.q);
            ((IVasQuickUpdateService)localObject2).downloadItem(localDownloadHolder.a, localDownloadHolder.b, "silent_download.redbag");
          }
          catch (Exception localException)
          {
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("preDownload, err=");
            ((StringBuilder)localObject2).append(localException.getMessage());
            QLog.d("IndividualRedPacketResDownloader", 2, ((StringBuilder)localObject2).toString());
          }
          return;
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    try
    {
      if ((this.a == null) || (0L == paramLong) || (TextUtils.isEmpty(paramString1))) {
        break label207;
      }
      if ("iRedPacket_v3.specialChar.zip".equals(paramString1))
      {
        paramString2 = IndividualRedPacketManager.a(null, null, 11, 0, 0);
      }
      else
      {
        paramString2 = new File(IndividualRedPacketManager.a(paramString1, null, 24, 0, 0));
        boolean bool = paramString2.exists();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("downloadResIfNotExsit, id: ");
          localStringBuilder.append(paramString1);
          localStringBuilder.append(" exists: ");
          localStringBuilder.append(bool);
          QLog.d("IndividualRedPacketResDownloader", 1, localStringBuilder.toString());
        }
        if (bool) {
          VasUpdateUtil.a(paramString2);
        }
        paramString2 = IndividualRedPacketManager.a(paramString1, null, 0, 0, 0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("luckyMoney.item.");
        localStringBuilder.append(paramString1);
        paramString1 = localStringBuilder.toString();
      }
    }
    finally
    {
      for (;;)
      {
        for (;;)
        {
          label207:
          throw paramString1;
        }
      }
    }
    VasUpdateUtil.a(this.a, paramLong, paramString1, paramString2, true, this.q);
    return;
    paramString2 = new StringBuilder();
    paramString2.append("downloadResIfNotExsit err filePath, bid=");
    paramString2.append(paramLong);
    paramString2.append(",id:");
    paramString2.append(paramString1);
    QLog.e("IndividualRedPacketResDownloader", 1, paramString2.toString());
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        if ((this.a != null) && (this.p != null))
        {
          Object localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(BaseApplicationImpl.getContext().getFilesDir());
          ((StringBuilder)localObject1).append(File.separator);
          ((StringBuilder)localObject1).append("pddata/vas/redpacket/");
          ((StringBuilder)localObject1).append("iRedPacket_v3.json");
          localObject1 = ((StringBuilder)localObject1).toString();
          Object localObject4 = this.a;
          boolean bool2 = false;
          if (!paramBoolean1)
          {
            bool1 = true;
            localObject1 = a(VasUpdateUtil.a((AppRuntime)localObject4, 16L, "iRedPacket_v3.json", (String)localObject1, bool1, this.q), null);
            if (localObject1 == null)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("initAllConfigJson null == resJson,isAfterDownload:");
              ((StringBuilder)localObject1).append(paramBoolean1);
              ((StringBuilder)localObject1).append(", isInit");
              ((StringBuilder)localObject1).append(paramBoolean2);
              QLog.e("IndividualRedPacketResDownloader", 2, ((StringBuilder)localObject1).toString());
              return;
            }
            try
            {
              localObject4 = a((JSONObject)localObject1);
              if (localObject4 == null) {
                return;
              }
              localObject1 = ((JSONObject)localObject4).optJSONArray("activityInfo");
              if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
                break label349;
              }
              localObject1 = ((JSONArray)localObject1).optJSONObject(0);
              if (localObject1 != null)
              {
                paramBoolean1 = c((JSONObject)localObject1, false);
              }
              else
              {
                QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse ,activityInfoObj0 == null");
                paramBoolean1 = bool2;
              }
              a(paramBoolean1, b((JSONObject)localObject4, paramBoolean1), NetworkUtil.getSystemNetwork(null));
              this.o.set(true);
            }
            catch (Exception localException)
            {
              QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse parse Json config error: ", localException);
            }
            catch (JSONException localJSONException)
            {
              QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse parse Json config JSONException: ", localJSONException);
              VasMonitorHandler.a(this.a, "individual_v2_redpacket_json_err", "decode_json_err", localJSONException.getMessage(), null, 0.0F);
            }
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      boolean bool1 = false;
      continue;
      label349:
      Object localObject3 = null;
    }
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, File paramFile)
  {
    if (this.a != null)
    {
      if (this.p == null) {
        return;
      }
      Object localObject = b(paramBoolean1, paramBoolean2, paramString, paramFile);
      if (localObject == null) {
        return;
      }
      try
      {
        if ("iRedPacket_v3.char300.json".equals(paramString))
        {
          JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("data");
          if (localJSONArray != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            int i1 = 0;
            while (i1 < localJSONArray.length())
            {
              localStringBuilder.append(localJSONArray.getString(i1));
              i1 += 1;
            }
            this.c.a = localStringBuilder.toString();
            this.c.j = 2;
          }
        }
        paramBoolean1 = "iRedPacket_v3.font.zip".equals(paramString);
        if (paramBoolean1)
        {
          this.e.g = ((JSONObject)localObject).optString("id", "");
          this.e.f = ((JSONObject)localObject).optString("name", "");
          this.e.i = ((JSONObject)localObject).optInt("version");
          this.e.j = 2;
          this.p.b(this.e.g);
        }
        if ("iRedPacket_v3.specialChar.zip".equals(paramString))
        {
          this.d.g = ((JSONObject)localObject).optString("id", "0");
          this.d.i = ((JSONObject)localObject).optInt("version");
          this.d.j = 2;
          this.d.b = ((JSONObject)localObject).optString("char", "");
          paramString = this.d;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(this.d.b);
          paramString.a = ((StringBuilder)localObject).toString();
          paramString = new StringBuilder();
          paramString.append(this.d.g);
          paramString.append(this.d.i);
          a(paramFile, paramString.toString());
        }
        e();
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e("IndividualRedPacketResDownloader", 2, "initJsonBySCID parse Json config JSONException: ", paramString);
        VasMonitorHandler.a(this.a, "individual_v2_redpacket_json_err", "decode_json_err", paramString.getMessage(), null, 0.0F);
      }
    }
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null) {
      ((IVasQuickUpdateService)localQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this.q);
    }
    this.a = null;
    this.b.evictAll();
    this.p = null;
  }
  
  public void c()
  {
    if (this.a == null) {
      return;
    }
    a(false, true);
    Object localObject = IndividualRedPacketManager.a(null, null, 8, 0, 0);
    if (VasUpdateUtil.a(this.a, 16L, "iRedPacket_v3.font.zip", (String)localObject, true, this.q) != null) {
      a(false, true, "iRedPacket_v3.font.zip", new File(IndividualRedPacketManager.a(null, null, 21, 0, 0)));
    }
    localObject = IndividualRedPacketManager.a(null, null, 25, 0, 0);
    a(false, true, "iRedPacket_v3.specialChar.zip", VasUpdateUtil.a(this.a, 16L, "iRedPacket_v3.specialChar.zip", (String)localObject, true, this.q));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(BaseApplicationImpl.getContext().getFilesDir());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("pddata/vas/redpacket/");
    ((StringBuilder)localObject).append("iRedPacket_v3.char300.json");
    localObject = ((StringBuilder)localObject).toString();
    a(false, true, "iRedPacket_v3.char300.json", VasUpdateUtil.a(this.a, 16L, "iRedPacket_v3.char300.json", (String)localObject, true, this.q));
  }
  
  public void d()
  {
    if (f()) {
      return;
    }
    try
    {
      if (this.p.c().getBoolean("res_version_has_updated", false)) {
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(IndividualRedPacketManager.a(3));
      ((StringBuilder)localObject1).append("10029_0");
      localObject1 = new File(((StringBuilder)localObject1).toString());
      localObject2 = new File(IndividualRedPacketManager.a(null, null, 8, 0, 0));
      if ((((File)localObject1).exists()) && (!((File)localObject2).exists())) {
        ((File)localObject1).renameTo((File)localObject2);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(AppConstants.SDCARD_PATH);
      ((StringBuilder)localObject1).append("RedPacket/templateAIO");
      File localFile1 = new File(VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject1).toString()));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(AppConstants.SDCARD_PATH);
      ((StringBuilder)localObject1).append("RedPacket/templateTENPAY");
      File localFile2 = new File(VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject1).toString()));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(AppConstants.SDCARD_PATH);
      ((StringBuilder)localObject1).append("RedPacket/templateSEND");
      File localFile3 = new File(VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject1).toString()));
      if (!a(localFile1, localFile2, localFile3, false))
      {
        this.p.c().edit().putBoolean("res_version_has_updated", true).commit();
        return;
      }
      localObject2 = ClubContentJsonTask.a(this.a, ClubContentJsonTask.g, false);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = b((JSONObject)localObject2);
      }
      if (localObject1 == null)
      {
        QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion fail Err, return");
        return;
      }
      if (a(localFile1, localFile2, localFile3, (JSONObject)localObject1)) {
        return;
      }
      localObject1 = this.p.c().edit();
      ((SharedPreferences.Editor)localObject1).putBoolean("res_version_has_updated", true);
      ((SharedPreferences.Editor)localObject1).commit();
      VasUpdateUtil.a(localFile1);
      VasUpdateUtil.a(localFile2);
      VasUpdateUtil.a(localFile3);
      return;
    }
    catch (Throwable localThrowable)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateResVersion TODO v7.10 updateErr:");
      ((StringBuilder)localObject2).append(localThrowable.toString());
      QLog.e("IndividualRedPacketResDownloader", 2, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.IndividualRedPacketResDownloader
 * JD-Core Version:    0.7.0.1
 */