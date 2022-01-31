package com.tencent.mobileqq.shortvideo.util;

import aidu;
import aidv;
import aidw;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Base64;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
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
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetworkCenter;
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
  private static AtomicReference a;
  private static volatile boolean c;
  private static boolean d;
  public int a;
  public HashMap a;
  public boolean a;
  public boolean b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference(null);
  }
  
  public RecentDanceConfigMgr()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("video_dance_filter_cfg", 4).getInt("video_dance_version_key", 0);
  }
  
  private static int a(AppInterface paramAppInterface, String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("video_dance_red_dot_cfg", 4).getInt(paramString + paramAppInterface.getCurrentAccountUin(), 0);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int k = a();
    int m = paramConfig.version.get();
    if (QLog.isColorLevel()) {
      QLog.d("RecentDanceConfigMgr", 2, "handleDanceFilterConfig|received remote version: " + m + " | localVersion: " + k);
    }
    if (m != k) {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramQQAppInterface = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if (paramQQAppInterface != null) {
          if (paramQQAppInterface.compress.get() == 1)
          {
            paramQQAppInterface = OlympicUtil.a(paramQQAppInterface.content.get().toByteArray());
            if (paramQQAppInterface == null) {}
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = new String(paramQQAppInterface, "UTF-8");
        i = a(paramQQAppInterface, m);
        j = i;
        if (i != 0)
        {
          if (paramConfig.content_list.size() <= 0) {
            break label367;
          }
          i = a((String)paramConfig.content_list.get(0), m);
          j = i;
          if (QLog.isColorLevel())
          {
            QLog.d("RecentDanceConfigMgr", 2, "receiveAllConfigs[handleDanceFilterConfig]| content_list has data,version: " + m + ",localVersion:" + k);
            j = i;
          }
        }
        return j;
      }
      catch (Throwable paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentDanceConfigMgr", 2, "receiveAllConfigs[handleDanceFilterConfig]|Throwable:" + paramQQAppInterface.getMessage());
        }
        paramQQAppInterface = "";
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecentDanceConfigMgr", 2, "receiveAllConfigs[handleDanceFilterConfig]|inflateConfigString error!");
      }
      paramQQAppInterface = "";
      continue;
      paramQQAppInterface = paramQQAppInterface.content.get().toStringUtf8();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("RecentDanceConfigMgr", 2, "receiveAllConfigs[handleDanceFilterConfig]| content==null");
      }
      int i = -125;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("RecentDanceConfigMgr", 2, "receiveAllConfigs[handleDanceFilterConfig]| msg_content_list is empty ,version: " + m + ",localVersion:" + k);
      }
      i = -125;
      continue;
      label367:
      int j = i;
      if (QLog.isColorLevel())
      {
        QLog.d("RecentDanceConfigMgr", 2, "receiveAllConfigs[handleDanceFilterConfig]| content_list has no data,version: " + m + ",localVersion:" + k);
        return i;
        i = 0;
      }
    }
  }
  
  private static int a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentDanceConfigMgr", 2, "updateDanceFilterConfigContent|received save version: " + paramInt + ",config_content=" + paramString);
    }
    int i;
    if (TextUtils.isEmpty(paramString))
    {
      int j = -101;
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("RecentDanceConfigMgr", 2, "updateDanceFilterConfigContent| version=" + paramInt + ",config_content=" + paramString);
        i = j;
      }
    }
    for (;;)
    {
      if (i == 0) {
        b(paramString);
      }
      return i;
      boolean bool = a(paramString, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("RecentDanceConfigMgr", 2, "updateDanceFilterConfigContent| saveContentOK=" + bool);
      }
      if (bool) {
        i = 0;
      } else {
        i = -128;
      }
    }
  }
  
  public static RecentDanceConfigMgr.DItemInfo a()
  {
    RecentDanceConfigMgr localRecentDanceConfigMgr = a();
    if (localRecentDanceConfigMgr == null) {
      if (QLog.isColorLevel()) {
        QLog.d("RecentDanceConfigMgr", 2, "getPlusItemInfo mgr == null");
      }
    }
    while (!localRecentDanceConfigMgr.jdField_a_of_type_Boolean) {
      return null;
    }
    return (RecentDanceConfigMgr.DItemInfo)localRecentDanceConfigMgr.jdField_a_of_type_JavaUtilHashMap.get("plus");
  }
  
  private static RecentDanceConfigMgr a()
  {
    Object localObject;
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() == null)
    {
      localObject = b();
      if ((localObject != null) && (!"".equals(localObject))) {
        break label52;
      }
      localObject = new RecentDanceConfigMgr();
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.getAndSet(localObject);
    }
    for (;;)
    {
      return (RecentDanceConfigMgr)jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get();
      label52:
      b((String)localObject);
    }
  }
  
  public static String a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("video_dance_stage_name_cfg", 4).getString("video_dance_stage_name_key", "postureRecognizeStage");
  }
  
  private static String a(String paramString, RecentDanceConfigMgr.DItemInfo paramDItemInfo)
  {
    return paramString + paramDItemInfo.icon_md5 + ".png";
  }
  
  private static void a()
  {
    if (!c)
    {
      c = true;
      ThreadManager.post(new aidw(), 5, null, true);
    }
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    a(paramAppInterface, "video_dance_red_dot_version_show");
  }
  
  public static void a(AppInterface paramAppInterface, String paramString)
  {
    RecentDanceConfigMgr localRecentDanceConfigMgr = a();
    if (localRecentDanceConfigMgr == null) {
      QLog.e("RecentDanceConfigMgr", 2, "saveClickedRedDot mgr=null");
    }
    boolean bool;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RecentDanceConfigMgr", 2, "saveClickedRedDot showRedPoint=" + localRecentDanceConfigMgr.b + " redPointVersion=" + localRecentDanceConfigMgr.jdField_a_of_type_Int);
      }
      bool = a(paramAppInterface, localRecentDanceConfigMgr.jdField_a_of_type_Int, paramString);
    } while (!QLog.isColorLevel());
    QLog.d("RecentDanceConfigMgr", 2, "saveClickedRedDot success=" + bool);
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentDanceConfigMgr", 2, "" + paramString);
    }
  }
  
  public static boolean a()
  {
    RecentDanceConfigMgr.DItemInfo localDItemInfo = a();
    if (localDItemInfo != null)
    {
      boolean bool = localDItemInfo.forceRefresh;
      if (QLog.isColorLevel()) {
        QLog.d("RecentDanceConfigMgr", 2, "needDoForceRefreshDanceInPlus force=" + bool);
      }
      localDItemInfo.forceRefresh = false;
      return bool;
    }
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    if (!PtvFilterSoLoad.a(paramContext)) {}
    do
    {
      do
      {
        return false;
      } while (CaptureUtil.jdField_a_of_type_Int != 1);
      paramContext = new File(CapturePtvTemplateManager.a, "ptv_template_new.cfg");
    } while ((!paramContext.exists()) || (TextUtils.isEmpty(CapturePtvTemplateManager.a(paramContext))));
    return true;
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentDanceConfigMgr", 2, "needShowDanceInPlus mgr == null");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecentDanceConfigMgr", 2, "needShowDanceInPlus mgr.showEntrance=" + ((RecentDanceConfigMgr)localObject).jdField_a_of_type_Boolean);
    }
    if (((RecentDanceConfigMgr)localObject).jdField_a_of_type_Boolean)
    {
      localObject = (RecentDanceConfigMgr.DItemInfo)((RecentDanceConfigMgr)localObject).jdField_a_of_type_JavaUtilHashMap.get("plus");
      if (localObject == null) {
        break label237;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecentDanceConfigMgr", 2, "needShowDanceInPlus plus.show=" + ((RecentDanceConfigMgr.DItemInfo)localObject).show);
      }
      if (((RecentDanceConfigMgr.DItemInfo)localObject).show)
      {
        if (((RecentDanceConfigMgr.DItemInfo)localObject).drawable == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecentDanceConfigMgr", 2, "needShowDanceInPlus item.drawable=null");
          }
          return false;
        }
        if ((((RecentDanceConfigMgr.DItemInfo)localObject).showName == null) || ("".equals(((RecentDanceConfigMgr.DItemInfo)localObject).showName)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecentDanceConfigMgr", 2, "needShowDanceInPlus item.showName=null or space");
          }
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.d("RecentDanceConfigMgr", 2, "needShowDanceInPlus sTemplateFileOk=" + d);
        }
        if (d) {
          return a(paramAppInterface, (RecentDanceConfigMgr.DItemInfo)localObject);
        }
        a();
      }
    }
    for (;;)
    {
      return false;
      label237:
      if (QLog.isColorLevel()) {
        QLog.d("RecentDanceConfigMgr", 2, "needShowDanceInPlus PLUS_PANEL=null");
      }
    }
  }
  
  private static boolean a(AppInterface paramAppInterface, int paramInt, String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("video_dance_red_dot_cfg", 4).edit();
    localEditor.putInt(paramString + paramAppInterface.getCurrentAccountUin(), paramInt);
    return localEditor.commit();
  }
  
  private static boolean a(AppInterface paramAppInterface, RecentDanceConfigMgr.DItemInfo paramDItemInfo)
  {
    boolean bool = CaptureUtil.a();
    if (QLog.isColorLevel()) {
      QLog.d("RecentDanceConfigMgr", 2, "needShowDanceInPlus supportMediaCodec=" + bool);
    }
    if (bool)
    {
      if (paramDItemInfo.categoryID == 10)
      {
        bool = ShortVideoGuideUtil.h(paramAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("RecentDanceConfigMgr", 2, "needShowDanceInPlus isSupportDance=" + bool);
        }
        return bool;
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(AppInterface paramAppInterface, int[] paramArrayOfInt)
  {
    return a(paramAppInterface, paramArrayOfInt, "video_dance_red_dot_version_show");
  }
  
  private static boolean a(AppInterface paramAppInterface, int[] paramArrayOfInt, String paramString)
  {
    RecentDanceConfigMgr localRecentDanceConfigMgr = a();
    if (localRecentDanceConfigMgr == null) {
      QLog.e("RecentDanceConfigMgr", 2, "needShowDanceRedDot mgr=null");
    }
    int i;
    do
    {
      do
      {
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("RecentDanceConfigMgr", 2, "needShowDanceRedDot showRedPoint=" + localRecentDanceConfigMgr.b + " redPointVersion=" + localRecentDanceConfigMgr.jdField_a_of_type_Int);
        }
      } while ((!localRecentDanceConfigMgr.b) || (localRecentDanceConfigMgr.jdField_a_of_type_Int <= 0));
      i = a(paramAppInterface, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("RecentDanceConfigMgr", 2, "needShowDanceRedDot[getSpDanceRedDotVersion] currentVersion=" + i);
      }
    } while (localRecentDanceConfigMgr.jdField_a_of_type_Int <= i);
    if (paramArrayOfInt != null) {
      paramArrayOfInt[0] = localRecentDanceConfigMgr.jdField_a_of_type_Int;
    }
    return true;
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
  
  public static RecentDanceConfigMgr.DItemInfo b()
  {
    RecentDanceConfigMgr localRecentDanceConfigMgr = b();
    if (localRecentDanceConfigMgr == null) {
      if (QLog.isColorLevel()) {
        QLog.d("RecentDanceConfigMgr", 2, "getFloatItemInfo mgr == null");
      }
    }
    while (!localRecentDanceConfigMgr.jdField_a_of_type_Boolean) {
      return null;
    }
    return (RecentDanceConfigMgr.DItemInfo)localRecentDanceConfigMgr.jdField_a_of_type_JavaUtilHashMap.get("float");
  }
  
  private static RecentDanceConfigMgr b()
  {
    Object localObject;
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() == null)
    {
      localObject = b();
      if ((localObject != null) && (!"".equals(localObject))) {
        break label52;
      }
      localObject = new RecentDanceConfigMgr();
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.getAndSet(localObject);
    }
    for (;;)
    {
      return (RecentDanceConfigMgr)jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get();
      label52:
      localObject = b((String)localObject);
      if (localObject != null) {
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.getAndSet(localObject);
      }
    }
  }
  
  private static RecentDanceConfigMgr b(String paramString)
  {
    RecentDanceConfigMgr localRecentDanceConfigMgr = new RecentDanceConfigMgr();
    label516:
    for (;;)
    {
      int i;
      RecentDanceConfigMgr.DItemInfo localDItemInfo;
      Object localObject;
      try
      {
        paramString = new JSONObject(paramString);
        localRecentDanceConfigMgr.jdField_a_of_type_Boolean = paramString.optBoolean("showEntrance", false);
        localRecentDanceConfigMgr.b = paramString.optBoolean("showRedPoint", false);
        localRecentDanceConfigMgr.jdField_a_of_type_Int = paramString.optInt("redPointVersion", 0);
        paramString = paramString.getJSONArray("ItemsInfo");
        if ((paramString != null) && (paramString.length() > 0))
        {
          i = 0;
          if (i < paramString.length())
          {
            localDItemInfo = (RecentDanceConfigMgr.DItemInfo)JSONUtils.a(paramString.getJSONObject(i), RecentDanceConfigMgr.DItemInfo.class);
            if (localDItemInfo == null) {
              break label516;
            }
            if ((localDItemInfo.icon_url != null) && (!"".equals(localDItemInfo.icon_url)))
            {
              localObject = a(c(), localDItemInfo);
              if (new File((String)localObject).exists()) {
                break label489;
              }
              if (localDItemInfo.isContent) {
                c(localDItemInfo, (String)localObject);
              }
            }
            else
            {
              localDItemInfo.forceRefresh = false;
              localObject = (RecentDanceConfigMgr)jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get();
              if (localObject != null)
              {
                localObject = (RecentDanceConfigMgr.DItemInfo)((RecentDanceConfigMgr)localObject).jdField_a_of_type_JavaUtilHashMap.get("" + localDItemInfo.name);
                if (localObject == null) {
                  break label498;
                }
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
                if (QLog.isColorLevel()) {
                  QLog.d("RecentDanceConfigMgr", 2, "loadRecentDanceConfigMgr item.forceRefresh=" + localDItemInfo.forceRefresh);
                }
              }
              localRecentDanceConfigMgr.jdField_a_of_type_JavaUtilHashMap.put(localDItemInfo.name, localDItemInfo);
              break label516;
            }
            d(localDItemInfo, (String)localObject);
            continue;
          }
        }
        return localRecentDanceConfigMgr;
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentDanceConfigMgr", 2, "loadRecentDanceConfigMgr[JSONException]", paramString);
        }
        localRecentDanceConfigMgr.jdField_a_of_type_JavaUtilHashMap.clear();
      }
      label489:
      b(localDItemInfo, (String)localObject);
      continue;
      label498:
      if (QLog.isColorLevel())
      {
        QLog.d("RecentDanceConfigMgr", 2, "loadRecentDanceConfigMgr oldItem=null");
        continue;
        i += 1;
      }
    }
  }
  
  private static String b()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("video_dance_filter_cfg", 4).getString("video_dance_content_key", "");
  }
  
  private static String b(String paramString)
  {
    try
    {
      String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      return str;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      try
      {
        paramString = MD5FileUtil.a(new File(paramString));
        return paramString;
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  private static void b(RecentDanceConfigMgr.DItemInfo paramDItemInfo, String paramString)
  {
    Object localObject = null;
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      if (paramString != null) {
        paramDItemInfo.drawable = new BitmapDrawable(paramString);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        paramString = localObject;
        if (QLog.isColorLevel())
        {
          QLog.d("RecentDanceConfigMgr", 2, "genBitmapDrawable: oomError=", localOutOfMemoryError);
          paramString = localObject;
        }
      }
    }
  }
  
  private static void b(String paramString)
  {
    ThreadManager.post(new aidu(paramString), 5, null, true);
  }
  
  public static boolean b()
  {
    Object localObject = b();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentDanceConfigMgr", 2, "needShowDanceFloat mgr == null");
      }
      return false;
    }
    if (((RecentDanceConfigMgr)localObject).jdField_a_of_type_Boolean)
    {
      localObject = (RecentDanceConfigMgr.DItemInfo)((RecentDanceConfigMgr)localObject).jdField_a_of_type_JavaUtilHashMap.get("float");
      if (localObject != null)
      {
        if (((RecentDanceConfigMgr.DItemInfo)localObject).categoryID == 10)
        {
          if (((RecentDanceConfigMgr.DItemInfo)localObject).show) {
            return QmcfManager.a().a(2);
          }
          if (QLog.isColorLevel()) {
            QLog.d("RecentDanceConfigMgr", 2, "hasQmcfEntrance false, show " + ((RecentDanceConfigMgr.DItemInfo)localObject).show);
          }
          return false;
        }
        return ((RecentDanceConfigMgr.DItemInfo)localObject).show;
      }
    }
    return false;
  }
  
  private static String c()
  {
    Object localObject = new StringBuilder(AppConstants.aJ);
    ((StringBuilder)localObject).append("sv_config_icon");
    ((StringBuilder)localObject).append(File.separator);
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File((String)localObject + ".nomedia");
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      return localObject;
    }
    catch (IOException localIOException) {}
    return localObject;
  }
  
  private static void c(RecentDanceConfigMgr.DItemInfo paramDItemInfo, String paramString)
  {
    Object localObject = Base64.decode(paramDItemInfo.icon_url, 0);
    if (localObject != null)
    {
      FileUtils.a((byte[])localObject, paramString);
      if (new File(paramString).exists())
      {
        localObject = b(paramString);
        if ((localObject != null) && (!"".equals(localObject)) && (((String)localObject).equalsIgnoreCase(paramDItemInfo.icon_md5))) {
          break label68;
        }
        FileUtils.d(paramString);
      }
    }
    return;
    label68:
    b(paramDItemInfo, paramString);
  }
  
  private static void d(RecentDanceConfigMgr.DItemInfo paramDItemInfo, String paramString)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new aidv(paramDItemInfo, paramString);
    localHttpNetReq.jdField_a_of_type_JavaLangString = paramDItemInfo.icon_url;
    localHttpNetReq.jdField_a_of_type_Int = 0;
    localHttpNetReq.jdField_c_of_type_JavaLangString = (paramString + "_temp");
    localHttpNetReq.jdField_c_of_type_Int = NetworkUtil.a(NetworkCenter.a().a());
    try
    {
      paramString = BaseApplicationImpl.getApplication().getRuntime();
      if (QQAppInterface.class.isInstance(paramString))
      {
        ((QQAppInterface)paramString).getNetEngine(0).a(localHttpNetReq);
        if (QLog.isColorLevel()) {
          QLog.i("RecentDanceConfigMgr", 2, "processNetWork url: " + paramDItemInfo.icon_url);
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("RecentDanceConfigMgr", 2, "processNetWork[Exception] url: " + paramDItemInfo.icon_url, paramString);
    }
  }
  
  private static boolean d()
  {
    return new File(CapturePtvTemplateManager.a, "ptv_template_new.cfg").exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr
 * JD-Core Version:    0.7.0.1
 */