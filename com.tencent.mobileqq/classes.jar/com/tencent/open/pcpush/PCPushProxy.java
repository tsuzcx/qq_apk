package com.tencent.open.pcpush;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PCPushProxy
  implements DownloadListener
{
  protected static PCPushProxy a;
  protected static List<PCPushProxy.OnDownloadListener> a;
  protected int a;
  protected Handler a;
  protected PCPushDBHelper a;
  protected ConcurrentHashMap<String, PCPushProxy.PkgEntry> a;
  
  protected PCPushProxy()
  {
    this.jdField_a_of_type_Int = 111;
    this.jdField_a_of_type_AndroidOsHandler = new PCPushProxy.WorkHandler(this, ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
    jdField_a_of_type_JavaUtilList = new ArrayList(10);
    this.jdField_a_of_type_ComTencentOpenPcpushPCPushDBHelper = new PCPushDBHelper();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    DownloadManager.a().a(this);
  }
  
  public static PCPushProxy a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenPcpushPCPushProxy == null) {
        jdField_a_of_type_ComTencentOpenPcpushPCPushProxy = new PCPushProxy();
      }
      PCPushProxy localPCPushProxy = jdField_a_of_type_ComTencentOpenPcpushPCPushProxy;
      return localPCPushProxy;
    }
    finally {}
  }
  
  public int a(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("--> open key = ");
    ((StringBuilder)localObject1).append(paramString);
    LogUtility.c("PCPushProxy", ((StringBuilder)localObject1).toString());
    localObject1 = (PCPushProxy.PkgEntry)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("open fail entry is null, error : OPEN_FAIL_KEY_NOT_EXISTS, key = ");
      ((StringBuilder)localObject1).append(paramString);
      LogUtility.e("PCPushProxy", ((StringBuilder)localObject1).toString());
      return 1;
    }
    if (((PCPushProxy.PkgEntry)localObject1).jdField_b_of_type_Int != 1)
    {
      localObject2 = a(paramString);
      if ((localObject2 == null) || (((String)localObject2).trim().equals("")) || (!new File((String)localObject2).exists()))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("open fail, error : file not exist or be deleted, key = ");
        ((StringBuilder)localObject1).append(paramString);
        LogUtility.e("PCPushProxy", ((StringBuilder)localObject1).toString());
        return 2;
      }
    }
    Object localObject2 = Message.obtain();
    ((Message)localObject2).what = 4;
    ((Message)localObject2).obj = paramString;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
    paramString = CommonDataAdapter.a().a();
    if (paramString == null)
    {
      LogUtility.c("PCPushProxy", "open fail, error : OPEN_FAIL_OTHERS");
      return 4;
    }
    localObject2 = paramString.getPackageManager();
    if (localObject2 == null)
    {
      LogUtility.c("PCPushProxy", "open fail, error : OPEN_FAIL_OTHERS");
      return 4;
    }
    if (((PCPushProxy.PkgEntry)localObject1).jdField_b_of_type_Int == 1)
    {
      try
      {
        localObject2 = ((PackageManager)localObject2).getLaunchIntentForPackage(((PCPushProxy.PkgEntry)localObject1).jdField_d_of_type_JavaLangString);
        if (localObject2 == null)
        {
          paramString = new StringBuilder();
          paramString.append("open fail, because package not found, package = ");
          paramString.append(((PCPushProxy.PkgEntry)localObject1).jdField_d_of_type_JavaLangString);
          LogUtility.c("PCPushProxy", paramString.toString());
          return 4;
        }
        ((Intent)localObject2).addFlags(268435456);
        paramString.startActivity((Intent)localObject2);
      }
      catch (Exception paramString)
      {
        LogUtility.a("PCPushProxy", "open fail, error : ", paramString);
        return 4;
      }
    }
    else
    {
      localObject1 = DownloadManager.a().a(((PCPushProxy.PkgEntry)localObject1).jdField_b_of_type_JavaLangString);
      if (localObject1 == null) {
        return 4;
      }
      localObject1 = OpenFileUtil.a(paramString, new File(((DownloadInfo)localObject1).l));
      if (localObject1 != null)
      {
        localObject2 = ((PackageManager)localObject2).queryIntentActivities((Intent)localObject1, 0);
        if ((localObject2 != null) && (((List)localObject2).size() != 0))
        {
          paramString.startActivity((Intent)localObject1);
        }
        else
        {
          LogUtility.c("PCPushProxy", "open fail, error : OPEN_FAIL_NO_RESPONSE_APP");
          return 3;
        }
      }
    }
    LogUtility.c("PCPushProxy", "open success");
    return 0;
  }
  
  public PCPushProxy.PkgEntry a(byte[] paramArrayOfByte)
  {
    LogUtility.c("PCPushProxy", "--> parse");
    Object localObject = new MessageContent.MsgContent();
    try
    {
      ((MessageContent.MsgContent)localObject).mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    paramArrayOfByte = new PCPushProxy.PkgEntry();
    paramArrayOfByte.jdField_b_of_type_JavaLangString = String.valueOf(((MessageContent.MsgContent)localObject).appid.get());
    paramArrayOfByte.jdField_e_of_type_JavaLangString = ((MessageContent.MsgContent)localObject).appname.get();
    paramArrayOfByte.h = ((MessageContent.MsgContent)localObject).appsize.get();
    paramArrayOfByte.jdField_f_of_type_JavaLangString = ((MessageContent.MsgContent)localObject).appurl.get();
    paramArrayOfByte.jdField_b_of_type_Int = ((MessageContent.MsgContent)localObject).filetype.get();
    paramArrayOfByte.g = ((MessageContent.MsgContent)localObject).iconurl.get();
    paramArrayOfByte.jdField_d_of_type_JavaLangString = ((MessageContent.MsgContent)localObject).pkgname.get();
    paramArrayOfByte.i = ((MessageContent.MsgContent)localObject).source.get();
    paramArrayOfByte.j = ((MessageContent.MsgContent)localObject).srciconurl.get();
    paramArrayOfByte.jdField_a_of_type_Int = ((MessageContent.MsgContent)localObject).versioncode.get();
    paramArrayOfByte.jdField_c_of_type_JavaLangString = ((MessageContent.MsgContent)localObject).via.get();
    paramArrayOfByte.jdField_a_of_type_JavaLangString = b(paramArrayOfByte.jdField_f_of_type_JavaLangString);
    if (paramArrayOfByte.jdField_b_of_type_Int != 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unapk");
      ((StringBuilder)localObject).append(SystemClock.currentThreadTimeMillis());
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(paramArrayOfByte.jdField_b_of_type_JavaLangString);
      paramArrayOfByte.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      paramArrayOfByte.jdField_d_of_type_JavaLangString = paramArrayOfByte.jdField_e_of_type_JavaLangString;
    }
    boolean bool = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramArrayOfByte.jdField_a_of_type_JavaLangString);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("add entry to mPkgEntryMap, hasKey = ");
    ((StringBuilder)localObject).append(bool);
    LogUtility.c("PCPushProxy", ((StringBuilder)localObject).toString());
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("add entry to mPkgEntryMap, key = ");
      ((StringBuilder)localObject).append(paramArrayOfByte.jdField_a_of_type_JavaLangString);
      LogUtility.c("PCPushProxy", ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramArrayOfByte.jdField_a_of_type_JavaLangString, paramArrayOfByte);
    }
    localObject = Message.obtain();
    ((Message)localObject).what = 2;
    ((Message)localObject).obj = paramArrayOfByte.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    return paramArrayOfByte;
  }
  
  protected String a()
  {
    Object localObject = CommonDataAdapter.a().a();
    if (localObject != null)
    {
      localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
      if (localObject != null)
      {
        localObject = ((ConnectivityManager)localObject).getNetworkInfo(1);
        if ((localObject != null) && (((NetworkInfo)localObject).isConnected()) && (((NetworkInfo)localObject).isAvailable())) {
          return "ANDROIDQQ.PCPUSH.AUTO";
        }
      }
    }
    int i = this.jdField_a_of_type_Int;
    if (i == 111) {
      return "ANDROIDQQ.PCPUSH.SINGLEDETAIL";
    }
    if (i == 112) {
      return "ANDROIDQQ.PCPUSH.MUTIDETAIL";
    }
    if (i == 113) {
      return "ANDROIDQQ.PCPUSH.UNREADPOP";
    }
    return "ANDROIDQQ.PCPUSH.AUTO";
  }
  
  public String a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      return null;
    }
    Object localObject = (PCPushProxy.PkgEntry)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDownloadPath error because entry = null, key = ");
      ((StringBuilder)localObject).append(paramString);
      LogUtility.e("PCPushProxy", ((StringBuilder)localObject).toString());
      return null;
    }
    paramString = DownloadManager.a().a(((PCPushProxy.PkgEntry)localObject).jdField_b_of_type_JavaLangString);
    if (paramString != null) {
      return paramString.l;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(PCPushProxy.OnDownloadListener paramOnDownloadListener)
  {
    LogUtility.c("PCPushProxy", "registerDownloadLitener dataline register listeners");
    if (!jdField_a_of_type_JavaUtilList.contains(paramOnDownloadListener)) {
      jdField_a_of_type_JavaUtilList.add(paramOnDownloadListener);
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("--> pause key = ");
    ((StringBuilder)localObject).append(paramString);
    LogUtility.c("PCPushProxy", ((StringBuilder)localObject).toString());
    localObject = (PCPushProxy.PkgEntry)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pause error because entry = null, key = ");
      ((StringBuilder)localObject).append(paramString);
      LogUtility.e("PCPushProxy", ((StringBuilder)localObject).toString());
      return;
    }
    paramString = new Bundle();
    paramString.putString(DownloadConstants.jdField_b_of_type_JavaLangString, ((PCPushProxy.PkgEntry)localObject).jdField_b_of_type_JavaLangString);
    paramString.putString(DownloadConstants.j, ((PCPushProxy.PkgEntry)localObject).jdField_f_of_type_JavaLangString);
    paramString.putString(DownloadConstants.jdField_f_of_type_JavaLangString, ((PCPushProxy.PkgEntry)localObject).jdField_d_of_type_JavaLangString);
    paramString.putString(DownloadConstants.i, ((PCPushProxy.PkgEntry)localObject).jdField_c_of_type_JavaLangString);
    paramString.putString(DownloadConstants.l, ((PCPushProxy.PkgEntry)localObject).jdField_e_of_type_JavaLangString);
    String str = DownloadConstants.z;
    int i = ((PCPushProxy.PkgEntry)localObject).jdField_b_of_type_Int;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    paramString.putBoolean(str, bool);
    paramString.putInt(DownloadConstants.k, 3);
    DownloadApi.a(null, paramString, "5", null, 0);
  }
  
  public boolean a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("--> start key = ");
    ((StringBuilder)localObject).append(paramString);
    LogUtility.c("PCPushProxy", ((StringBuilder)localObject).toString());
    if (!DownloadManager.a().a().contains(this))
    {
      DownloadManager.a().a(this);
      LogUtility.c("PCPushProxy", "PCPushProxy has not register, register download listener");
    }
    localObject = (PCPushProxy.PkgEntry)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start error because entry = null, key = ");
      ((StringBuilder)localObject).append(paramString);
      LogUtility.e("PCPushProxy", ((StringBuilder)localObject).toString());
      return false;
    }
    if (((PCPushProxy.PkgEntry)localObject).jdField_e_of_type_Int != 101)
    {
      if (((PCPushProxy.PkgEntry)localObject).jdField_e_of_type_Int == 104) {
        return true;
      }
      if (((PCPushProxy.PkgEntry)localObject).jdField_e_of_type_Int != 105) {
        if (!((PCPushProxy.PkgEntry)localObject).jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH."))
        {
          paramString = new StringBuilder();
          paramString.append(a());
          paramString.append(".");
          paramString.append(((PCPushProxy.PkgEntry)localObject).jdField_c_of_type_JavaLangString);
          ((PCPushProxy.PkgEntry)localObject).jdField_c_of_type_JavaLangString = paramString.toString();
        }
        else
        {
          if (((PCPushProxy.PkgEntry)localObject).jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.AUTO.")) {
            i = 21;
          } else if (((PCPushProxy.PkgEntry)localObject).jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.SINGLEDETAIL.")) {
            i = 29;
          } else if (((PCPushProxy.PkgEntry)localObject).jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.MUTIDETAIL.")) {
            i = 27;
          } else if (((PCPushProxy.PkgEntry)localObject).jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.UNREADPOP.")) {
            i = 26;
          } else {
            i = 16;
          }
          paramString = new StringBuilder();
          paramString.append(a());
          paramString.append(((PCPushProxy.PkgEntry)localObject).jdField_c_of_type_JavaLangString.substring(i));
          ((PCPushProxy.PkgEntry)localObject).jdField_c_of_type_JavaLangString = paramString.toString();
        }
      }
      paramString = new Bundle();
      paramString.putString(DownloadConstants.jdField_b_of_type_JavaLangString, ((PCPushProxy.PkgEntry)localObject).jdField_b_of_type_JavaLangString);
      paramString.putString(DownloadConstants.j, ((PCPushProxy.PkgEntry)localObject).jdField_f_of_type_JavaLangString);
      paramString.putString(DownloadConstants.jdField_f_of_type_JavaLangString, ((PCPushProxy.PkgEntry)localObject).jdField_d_of_type_JavaLangString);
      paramString.putString(DownloadConstants.i, ((PCPushProxy.PkgEntry)localObject).jdField_c_of_type_JavaLangString);
      paramString.putString(DownloadConstants.l, ((PCPushProxy.PkgEntry)localObject).jdField_e_of_type_JavaLangString);
      String str = DownloadConstants.z;
      boolean bool;
      if (((PCPushProxy.PkgEntry)localObject).jdField_b_of_type_Int == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramString.putBoolean(str, bool);
      int k = ((PCPushProxy.PkgEntry)localObject).jdField_b_of_type_Int;
      int j = 2;
      int i = j;
      if (k == 1)
      {
        i = j;
        if (((PCPushProxy.PkgEntry)localObject).jdField_d_of_type_Int == 2) {
          i = 12;
        }
      }
      paramString.putInt(DownloadConstants.k, i);
      DownloadApi.a(null, paramString, "5", null, 0);
    }
    return true;
  }
  
  protected String b(String paramString)
  {
    if (paramString != null)
    {
      if ("".equals(paramString)) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("p");
      localStringBuilder.append(paramString.hashCode());
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(paramInt);
  }
  
  public void b(PCPushProxy.OnDownloadListener paramOnDownloadListener)
  {
    if (jdField_a_of_type_JavaUtilList.contains(paramOnDownloadListener)) {
      jdField_a_of_type_JavaUtilList.remove(paramOnDownloadListener);
    }
  }
  
  public void b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("--> install key = ");
    ((StringBuilder)localObject).append(paramString);
    LogUtility.c("PCPushProxy", ((StringBuilder)localObject).toString());
    localObject = (PCPushProxy.PkgEntry)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("install error because entry = null, key = ");
      ((StringBuilder)localObject).append(paramString);
      LogUtility.e("PCPushProxy", ((StringBuilder)localObject).toString());
      return;
    }
    int i = ((PCPushProxy.PkgEntry)localObject).jdField_b_of_type_Int;
    boolean bool = true;
    if (i != 1)
    {
      LogUtility.e("PCPushProxy", "The file to be installing is not a apk file");
      return;
    }
    paramString = new Bundle();
    paramString.putString(DownloadConstants.jdField_b_of_type_JavaLangString, ((PCPushProxy.PkgEntry)localObject).jdField_b_of_type_JavaLangString);
    paramString.putString(DownloadConstants.j, ((PCPushProxy.PkgEntry)localObject).jdField_f_of_type_JavaLangString);
    paramString.putString(DownloadConstants.jdField_f_of_type_JavaLangString, ((PCPushProxy.PkgEntry)localObject).jdField_d_of_type_JavaLangString);
    paramString.putString(DownloadConstants.i, ((PCPushProxy.PkgEntry)localObject).jdField_c_of_type_JavaLangString);
    paramString.putString(DownloadConstants.l, ((PCPushProxy.PkgEntry)localObject).jdField_e_of_type_JavaLangString);
    String str = DownloadConstants.z;
    if (((PCPushProxy.PkgEntry)localObject).jdField_b_of_type_Int != 1) {
      bool = false;
    }
    paramString.putBoolean(str, bool);
    paramString.putInt(DownloadConstants.k, 5);
    DownloadApi.a(null, paramString, "5", null, 0);
  }
  
  public boolean b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("--> isInstalled key = ");
    ((StringBuilder)localObject).append(paramString);
    LogUtility.c("PCPushProxy", ((StringBuilder)localObject).toString());
    localObject = (PCPushProxy.PkgEntry)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("--> key : ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" 's entry is not exist.");
      LogUtility.c("PCPushProxy", ((StringBuilder)localObject).toString());
      return false;
    }
    return AppUtil.a(((PCPushProxy.PkgEntry)localObject).jdField_d_of_type_JavaLangString);
  }
  
  public void c(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("--> delete key = ");
    ((StringBuilder)localObject).append(paramString);
    LogUtility.c("PCPushProxy", ((StringBuilder)localObject).toString());
    localObject = (PCPushProxy.PkgEntry)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("delete error because entry = null, key = ");
      ((StringBuilder)localObject).append(paramString);
      LogUtility.e("PCPushProxy", ((StringBuilder)localObject).toString());
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString(DownloadConstants.jdField_b_of_type_JavaLangString, ((PCPushProxy.PkgEntry)localObject).jdField_b_of_type_JavaLangString);
    localBundle.putString(DownloadConstants.j, ((PCPushProxy.PkgEntry)localObject).jdField_f_of_type_JavaLangString);
    localBundle.putString(DownloadConstants.jdField_f_of_type_JavaLangString, ((PCPushProxy.PkgEntry)localObject).jdField_d_of_type_JavaLangString);
    localBundle.putString(DownloadConstants.i, ((PCPushProxy.PkgEntry)localObject).jdField_c_of_type_JavaLangString);
    localBundle.putString(DownloadConstants.l, ((PCPushProxy.PkgEntry)localObject).jdField_e_of_type_JavaLangString);
    String str = DownloadConstants.z;
    int i = ((PCPushProxy.PkgEntry)localObject).jdField_b_of_type_Int;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    localBundle.putBoolean(str, bool);
    localBundle.putInt(DownloadConstants.k, 10);
    DownloadApi.a(null, localBundle, "5", null, 0);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    localObject = Message.obtain();
    ((Message)localObject).what = 3;
    ((Message)localObject).obj = paramString;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    paramString1 = new StringBuilder();
    paramString1.append("--> installSucceed packageName = ");
    paramString1.append(paramString2);
    LogUtility.c("PCPushProxy", paramString1.toString());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    label47:
    PCPushProxy.PkgEntry localPkgEntry;
    for (paramString1 = null; localIterator.hasNext(); paramString1 = localPkgEntry)
    {
      localPkgEntry = (PCPushProxy.PkgEntry)localIterator.next();
      if ((!paramString2.equals(localPkgEntry.jdField_d_of_type_JavaLangString)) || (localPkgEntry.jdField_c_of_type_Int != 0)) {
        break label47;
      }
      localPkgEntry.jdField_c_of_type_Int = 1;
    }
    if (paramString1 == null) {
      return;
    }
    paramString2 = jdField_a_of_type_JavaUtilList.iterator();
    while (paramString2.hasNext()) {
      ((PCPushProxy.OnDownloadListener)paramString2.next()).a(6, paramString1.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("--> onDownloadCancel info = ");
    ((StringBuilder)localObject).append(paramDownloadInfo.toString());
    LogUtility.c("PCPushProxy", ((StringBuilder)localObject).toString());
    paramDownloadInfo = b(paramDownloadInfo.jdField_d_of_type_JavaLangString);
    localObject = jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((PCPushProxy.OnDownloadListener)((Iterator)localObject).next()).a(5, paramDownloadInfo);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (paramDownloadInfo != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("--> onDownloadError info = ");
      ((StringBuilder)localObject).append(paramDownloadInfo.toString());
      ((StringBuilder)localObject).append(" errorCode = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" errorMsg = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" state = ");
      ((StringBuilder)localObject).append(paramInt2);
      LogUtility.c("PCPushProxy", ((StringBuilder)localObject).toString());
      localObject = b(paramDownloadInfo.jdField_d_of_type_JavaLangString);
      paramDownloadInfo = (PCPushProxy.PkgEntry)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if (paramDownloadInfo == null)
      {
        paramDownloadInfo = new StringBuilder();
        paramDownloadInfo.append("onDownloadError error because entry = null, key = ");
        paramDownloadInfo.append((String)localObject);
        LogUtility.e("PCPushProxy", paramDownloadInfo.toString());
        return;
      }
      paramDownloadInfo.jdField_e_of_type_Int = 105;
    }
    else
    {
      paramDownloadInfo = null;
    }
    Object localObject = jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((PCPushProxy.OnDownloadListener)((Iterator)localObject).next()).a(paramDownloadInfo, paramInt1, paramString, paramInt2);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("--> onDownloadFinish info = ");
    ((StringBuilder)localObject).append(paramDownloadInfo.toString());
    LogUtility.c("PCPushProxy", ((StringBuilder)localObject).toString());
    paramDownloadInfo = b(paramDownloadInfo.jdField_d_of_type_JavaLangString);
    localObject = (PCPushProxy.PkgEntry)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramDownloadInfo);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadPause error because entry = null, key = ");
      ((StringBuilder)localObject).append(paramDownloadInfo);
      LogUtility.e("PCPushProxy", ((StringBuilder)localObject).toString());
      return;
    }
    ((PCPushProxy.PkgEntry)localObject).jdField_e_of_type_Int = 102;
    localObject = jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((PCPushProxy.OnDownloadListener)((Iterator)localObject).next()).a(4, paramDownloadInfo);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("--> onDownloadPause info = ");
    ((StringBuilder)localObject).append(paramDownloadInfo.toString());
    LogUtility.c("PCPushProxy", ((StringBuilder)localObject).toString());
    paramDownloadInfo = b(paramDownloadInfo.jdField_d_of_type_JavaLangString);
    localObject = (PCPushProxy.PkgEntry)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramDownloadInfo);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadPause error because entry = null, key = ");
      ((StringBuilder)localObject).append(paramDownloadInfo);
      LogUtility.e("PCPushProxy", ((StringBuilder)localObject).toString());
      return;
    }
    ((PCPushProxy.PkgEntry)localObject).jdField_e_of_type_Int = 105;
    localObject = jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((PCPushProxy.OnDownloadListener)((Iterator)localObject).next()).a(2, paramDownloadInfo);
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("--> onDownloadUpdate infos = ");
    ((StringBuilder)localObject1).append(paramList.toString());
    LogUtility.c("PCPushProxy", ((StringBuilder)localObject1).toString());
    localObject1 = new ArrayList(10);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject3 = (DownloadInfo)paramList.next();
      String str = b(((DownloadInfo)localObject3).jdField_d_of_type_JavaLangString);
      Object localObject2 = (PCPushProxy.PkgEntry)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      if (localObject2 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onDownloadUpdate error because entry = null, key = ");
        ((StringBuilder)localObject2).append(str);
        LogUtility.e("PCPushProxy", ((StringBuilder)localObject2).toString());
      }
      else
      {
        int i = ((PCPushProxy.PkgEntry)localObject2).jdField_e_of_type_Int;
        int j = ((DownloadInfo)localObject3).a();
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3)
            {
              if (j != 4)
              {
                if (j == 20) {
                  ((PCPushProxy.PkgEntry)localObject2).jdField_e_of_type_Int = 104;
                }
              }
              else if (((PCPushProxy.PkgEntry)localObject2).jdField_c_of_type_Int == 1) {
                ((PCPushProxy.PkgEntry)localObject2).jdField_e_of_type_Int = 103;
              } else {
                ((PCPushProxy.PkgEntry)localObject2).jdField_e_of_type_Int = 102;
              }
            }
            else {
              ((PCPushProxy.PkgEntry)localObject2).jdField_e_of_type_Int = 105;
            }
          }
          else {
            ((PCPushProxy.PkgEntry)localObject2).jdField_e_of_type_Int = 101;
          }
        }
        else {
          ((PCPushProxy.PkgEntry)localObject2).jdField_e_of_type_Int = 100;
        }
        ((PCPushProxy.PkgEntry)localObject2).jdField_f_of_type_Int = ((DownloadInfo)localObject3).jdField_f_of_type_Int;
        if ((i != 101) && (((PCPushProxy.PkgEntry)localObject2).jdField_e_of_type_Int == 101))
        {
          localObject3 = jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((PCPushProxy.OnDownloadListener)((Iterator)localObject3).next()).a(1, str);
          }
        }
        ((List)localObject1).add(localObject2);
      }
    }
    paramList = jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((PCPushProxy.OnDownloadListener)paramList.next()).a((List)localObject1);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("--> onDownloadWait info = ");
    ((StringBuilder)localObject).append(paramDownloadInfo.toString());
    LogUtility.c("PCPushProxy", ((StringBuilder)localObject).toString());
    paramDownloadInfo = b(paramDownloadInfo.jdField_d_of_type_JavaLangString);
    localObject = jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((PCPushProxy.OnDownloadListener)((Iterator)localObject).next()).a(3, paramDownloadInfo);
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.pcpush.PCPushProxy
 * JD-Core Version:    0.7.0.1
 */