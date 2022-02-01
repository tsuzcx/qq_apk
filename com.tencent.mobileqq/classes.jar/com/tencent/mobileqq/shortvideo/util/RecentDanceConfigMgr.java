package com.tencent.mobileqq.shortvideo.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Base64;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RecentDanceConfigMgr
{
  private static AtomicReference<RecentDanceConfigMgr> c = new AtomicReference(null);
  private static volatile boolean d = false;
  private static boolean e = false;
  public boolean a = false;
  public HashMap<String, RecentDanceConfigMgr.DItemInfo> b = new HashMap();
  
  public static int a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("video_dance_filter_cfg", 4).getInt("video_dance_version_key", 0);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int k = a();
    int m = paramConfig.version.get();
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("handleDanceFilterConfig|received remote version: ");
      paramQQAppInterface.append(m);
      paramQQAppInterface.append(" | localVersion: ");
      paramQQAppInterface.append(k);
      QLog.d("RecentDanceConfigMgr", 2, paramQQAppInterface.toString());
    }
    int j = -125;
    label214:
    int i;
    if (m != k)
    {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramQQAppInterface = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if (paramQQAppInterface != null)
        {
          if (paramQQAppInterface.compress.get() == 1)
          {
            paramQQAppInterface = OlympicUtil.a(paramQQAppInterface.content.get().toByteArray());
            if (paramQQAppInterface != null)
            {
              try
              {
                paramQQAppInterface = new String(paramQQAppInterface, "UTF-8");
              }
              catch (Throwable paramQQAppInterface)
              {
                if (!QLog.isColorLevel()) {
                  break label214;
                }
              }
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("receiveAllConfigs[handleDanceFilterConfig]|Throwable:");
              localStringBuilder.append(paramQQAppInterface.getMessage());
              QLog.d("RecentDanceConfigMgr", 2, localStringBuilder.toString());
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("RecentDanceConfigMgr", 2, "receiveAllConfigs[handleDanceFilterConfig]|inflateConfigString error!");
            }
            paramQQAppInterface = "";
          }
          else
          {
            paramQQAppInterface = paramQQAppInterface.content.get().toStringUtf8();
          }
          i = b(paramQQAppInterface, m);
        }
        else
        {
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("RecentDanceConfigMgr", 2, "receiveAllConfigs[handleDanceFilterConfig]| content==null");
            i = j;
          }
        }
      }
      else
      {
        i = j;
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("receiveAllConfigs[handleDanceFilterConfig]| msg_content_list is empty ,version: ");
          paramQQAppInterface.append(m);
          paramQQAppInterface.append(",localVersion:");
          paramQQAppInterface.append(k);
          QLog.d("RecentDanceConfigMgr", 2, paramQQAppInterface.toString());
          i = j;
        }
      }
    }
    else {
      i = 0;
    }
    j = i;
    if (i != 0) {
      if (paramConfig.content_list.size() > 0)
      {
        i = b((String)paramConfig.content_list.get(0), m);
        j = i;
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("receiveAllConfigs[handleDanceFilterConfig]| content_list has data,version: ");
          paramQQAppInterface.append(m);
          paramQQAppInterface.append(",localVersion:");
          paramQQAppInterface.append(k);
          QLog.d("RecentDanceConfigMgr", 2, paramQQAppInterface.toString());
          return i;
        }
      }
      else
      {
        j = i;
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("receiveAllConfigs[handleDanceFilterConfig]| content_list has no data,version: ");
          paramQQAppInterface.append(m);
          paramQQAppInterface.append(",localVersion:");
          paramQQAppInterface.append(k);
          QLog.d("RecentDanceConfigMgr", 2, paramQQAppInterface.toString());
          j = i;
        }
      }
    }
    return j;
  }
  
  private static String a(String paramString, RecentDanceConfigMgr.DItemInfo paramDItemInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramDItemInfo.icon_md5);
    localStringBuilder.append(".png");
    return localStringBuilder.toString();
  }
  
  public static boolean a(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("video_dance_stage_name_cfg", 4).edit();
    localEditor.putString("video_dance_stage_name_key", paramString);
    return localEditor.commit();
  }
  
  private static boolean a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("video_dance_filter_cfg", 4).edit();
    localEditor.putString("video_dance_content_key", paramString);
    localEditor.putInt("video_dance_version_key", paramInt);
    return localEditor.commit();
  }
  
  private static int b(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateDanceFilterConfigContent|received save version: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",config_content=");
      localStringBuilder.append(paramString);
      QLog.d("RecentDanceConfigMgr", 2, localStringBuilder.toString());
    }
    int i;
    if (TextUtils.isEmpty(paramString))
    {
      int j = -101;
      i = j;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateDanceFilterConfigContent| version=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(",config_content=");
        localStringBuilder.append(paramString);
        QLog.d("RecentDanceConfigMgr", 2, localStringBuilder.toString());
        i = j;
      }
    }
    else
    {
      boolean bool = a(paramString, paramInt);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateDanceFilterConfigContent| saveContentOK=");
        localStringBuilder.append(bool);
        QLog.d("RecentDanceConfigMgr", 2, localStringBuilder.toString());
      }
      if (bool) {
        i = 0;
      } else {
        i = -128;
      }
    }
    if (i == 0) {
      e(paramString);
    }
    return i;
  }
  
  private static void b(RecentDanceConfigMgr.DItemInfo paramDItemInfo, String paramString)
  {
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentDanceConfigMgr", 2, "genBitmapDrawable: oomError=", paramString);
      }
      paramString = null;
    }
    if (paramString != null) {
      paramDItemInfo.drawable = new BitmapDrawable(paramString);
    }
  }
  
  private static void c(RecentDanceConfigMgr.DItemInfo paramDItemInfo, String paramString)
  {
    Object localObject = Base64.decode(paramDItemInfo.icon_url, 0);
    if (localObject != null)
    {
      FileUtils.writeFile((byte[])localObject, paramString);
      if (new File(paramString).exists())
      {
        localObject = f(paramString);
        if ((localObject != null) && (!"".equals(localObject)) && (((String)localObject).equalsIgnoreCase(paramDItemInfo.icon_md5)))
        {
          b(paramDItemInfo, paramString);
          return;
        }
        FileUtils.deleteFile(paramString);
      }
    }
  }
  
  private static RecentDanceConfigMgr d(String paramString)
  {
    localRecentDanceConfigMgr = new RecentDanceConfigMgr();
    try
    {
      paramString = new JSONObject(paramString);
      localRecentDanceConfigMgr.a = paramString.optBoolean("showEntrance", false);
      paramString = paramString.getJSONArray("ItemsInfo");
      if ((paramString != null) && (paramString.length() > 0))
      {
        int i = 0;
        while (i < paramString.length())
        {
          RecentDanceConfigMgr.DItemInfo localDItemInfo = (RecentDanceConfigMgr.DItemInfo)JSONUtils.a(paramString.getJSONObject(i), RecentDanceConfigMgr.DItemInfo.class);
          if (localDItemInfo != null)
          {
            Object localObject = localDItemInfo.icon_url;
            if ((localObject != null) && (!"".equals(localDItemInfo.icon_url)))
            {
              localObject = a(d(), localDItemInfo);
              if (!new File((String)localObject).exists())
              {
                if (localDItemInfo.isContent) {
                  c(localDItemInfo, (String)localObject);
                } else {
                  d(localDItemInfo, (String)localObject);
                }
              }
              else {
                b(localDItemInfo, (String)localObject);
              }
            }
            localDItemInfo.forceRefresh = false;
            localObject = (RecentDanceConfigMgr)c.get();
            if (localObject != null)
            {
              localObject = ((RecentDanceConfigMgr)localObject).b;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("");
              localStringBuilder.append(localDItemInfo.name);
              localObject = (RecentDanceConfigMgr.DItemInfo)((HashMap)localObject).get(localStringBuilder.toString());
              if (localObject != null)
              {
                if ((TextUtils.isEmpty(((RecentDanceConfigMgr.DItemInfo)localObject).icon_md5)) && (!TextUtils.isEmpty(localDItemInfo.icon_md5))) {
                  localDItemInfo.forceRefresh = true;
                }
                if ((!TextUtils.isEmpty(((RecentDanceConfigMgr.DItemInfo)localObject).icon_md5)) && (TextUtils.isEmpty(localDItemInfo.icon_md5))) {
                  localDItemInfo.forceRefresh = true;
                }
                if ((!TextUtils.isEmpty(((RecentDanceConfigMgr.DItemInfo)localObject).icon_md5)) && (!TextUtils.isEmpty(localDItemInfo.icon_md5)) && (!localDItemInfo.icon_md5.equalsIgnoreCase(((RecentDanceConfigMgr.DItemInfo)localObject).icon_md5))) {
                  localDItemInfo.forceRefresh = true;
                }
                if ((TextUtils.isEmpty(((RecentDanceConfigMgr.DItemInfo)localObject).showName)) && (!TextUtils.isEmpty(localDItemInfo.showName))) {
                  localDItemInfo.forceRefresh = true;
                }
                if ((!TextUtils.isEmpty(((RecentDanceConfigMgr.DItemInfo)localObject).showName)) && (TextUtils.isEmpty(localDItemInfo.showName))) {
                  localDItemInfo.forceRefresh = true;
                }
                if ((!TextUtils.isEmpty(((RecentDanceConfigMgr.DItemInfo)localObject).showName)) && (!TextUtils.isEmpty(localDItemInfo.showName)) && (!localDItemInfo.showName.equalsIgnoreCase(((RecentDanceConfigMgr.DItemInfo)localObject).showName))) {
                  localDItemInfo.forceRefresh = true;
                }
                if (QLog.isColorLevel())
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("loadRecentDanceConfigMgr item.forceRefresh=");
                  ((StringBuilder)localObject).append(localDItemInfo.forceRefresh);
                  QLog.d("RecentDanceConfigMgr", 2, ((StringBuilder)localObject).toString());
                }
              }
              else if (QLog.isColorLevel())
              {
                QLog.d("RecentDanceConfigMgr", 2, "loadRecentDanceConfigMgr oldItem=null");
              }
            }
            localRecentDanceConfigMgr.b.put(localDItemInfo.name, localDItemInfo);
          }
          i += 1;
        }
      }
      return localRecentDanceConfigMgr;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentDanceConfigMgr", 2, "loadRecentDanceConfigMgr[JSONException]", paramString);
      }
      localRecentDanceConfigMgr.b.clear();
    }
  }
  
  private static String d()
  {
    Object localObject1 = new StringBuilder(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject1).append("sv_config_icon");
    ((StringBuilder)localObject1).append(File.separator);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(".nomedia");
    localObject2 = new File(((StringBuilder)localObject2).toString());
    if (!((File)localObject2).exists()) {}
    try
    {
      ((File)localObject2).createNewFile();
      return localObject1;
    }
    catch (IOException localIOException) {}
    return localObject1;
  }
  
  private static void d(RecentDanceConfigMgr.DItemInfo paramDItemInfo, String paramString)
  {
    Object localObject = new HttpNetReq();
    ((HttpNetReq)localObject).mCallback = new RecentDanceConfigMgr.2(paramDItemInfo, paramString);
    ((HttpNetReq)localObject).mReqUrl = paramDItemInfo.icon_url;
    ((HttpNetReq)localObject).mHttpMethod = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_temp");
    ((HttpNetReq)localObject).mOutPath = localStringBuilder.toString();
    ((HttpNetReq)localObject).mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    try
    {
      paramString = BaseApplicationImpl.getApplication().getRuntime();
      if (QQAppInterface.class.isInstance(paramString))
      {
        ((IHttpEngineService)((QQAppInterface)paramString).getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("processNetWork url: ");
          paramString.append(paramDItemInfo.icon_url);
          QLog.i("RecentDanceConfigMgr", 2, paramString.toString());
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("processNetWork[Exception] url: ");
        ((StringBuilder)localObject).append(paramDItemInfo.icon_url);
        QLog.i("RecentDanceConfigMgr", 2, ((StringBuilder)localObject).toString(), paramString);
      }
    }
  }
  
  private static void e(String paramString)
  {
    ThreadManager.post(new RecentDanceConfigMgr.1(paramString), 5, null, true);
  }
  
  private static boolean e()
  {
    return new File(CapturePtvTemplateManager.d, "ptv_template_new.cfg").exists();
  }
  
  private static String f(String paramString)
  {
    try
    {
      String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      return str;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label10:
      label24:
      break label10;
    }
    try
    {
      paramString = MD5FileUtil.a(new File(paramString));
      return paramString;
    }
    catch (Exception paramString)
    {
      break label24;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr
 * JD-Core Version:    0.7.0.1
 */