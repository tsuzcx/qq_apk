package com.tencent.open.pcpush;

import alre;
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
  protected static List a;
  protected int a;
  protected Handler a;
  public PCPushDBHelper a;
  public ConcurrentHashMap a;
  
  protected PCPushProxy()
  {
    this.jdField_a_of_type_Int = 111;
    DownloadManager.a().a(this);
    this.jdField_a_of_type_AndroidOsHandler = new alre(this, ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
    jdField_a_of_type_JavaUtilList = new ArrayList(10);
    this.jdField_a_of_type_ComTencentOpenPcpushPCPushDBHelper = new PCPushDBHelper();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
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
    LogUtility.c("PCPushProxy", "--> open key = " + paramString);
    Object localObject1 = (PCPushProxy.PkgEntry)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject1 == null)
    {
      LogUtility.e("PCPushProxy", "open fail entry is null, error : OPEN_FAIL_KEY_NOT_EXISTS, key = " + paramString);
      return 1;
    }
    if (((PCPushProxy.PkgEntry)localObject1).jdField_b_of_type_Int != 1)
    {
      localObject2 = a(paramString);
      if ((localObject2 == null) || (((String)localObject2).trim().equals("")) || (!new File((String)localObject2).exists()))
      {
        LogUtility.e("PCPushProxy", "open fail, error : file not exist or be deleted, key = " + paramString);
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
    if (((PCPushProxy.PkgEntry)localObject1).jdField_b_of_type_Int == 1) {}
    for (;;)
    {
      try
      {
        localObject2 = ((PackageManager)localObject2).getLaunchIntentForPackage(((PCPushProxy.PkgEntry)localObject1).jdField_d_of_type_JavaLangString);
        if (localObject2 == null)
        {
          LogUtility.c("PCPushProxy", "open fail, because package not found, package = " + ((PCPushProxy.PkgEntry)localObject1).jdField_d_of_type_JavaLangString);
          return 4;
        }
        ((Intent)localObject2).addFlags(268435456);
        paramString.startActivity((Intent)localObject2);
        LogUtility.c("PCPushProxy", "open success");
        return 0;
      }
      catch (Exception paramString)
      {
        LogUtility.a("PCPushProxy", "open fail, error : ", paramString);
        return 4;
      }
      localObject1 = DownloadManager.a().a(((PCPushProxy.PkgEntry)localObject1).jdField_b_of_type_JavaLangString);
      if (localObject1 == null) {
        return 4;
      }
      localObject1 = OpenFileUtil.a(paramString, new File(((DownloadInfo)localObject1).k));
      if (localObject1 != null)
      {
        localObject2 = ((PackageManager)localObject2).queryIntentActivities((Intent)localObject1, 0);
        if ((localObject2 == null) || (((List)localObject2).size() == 0))
        {
          LogUtility.c("PCPushProxy", "open fail, error : OPEN_FAIL_NO_RESPONSE_APP");
          return 3;
        }
        paramString.startActivity((Intent)localObject1);
      }
    }
  }
  
  public PCPushProxy.PkgEntry a(byte[] paramArrayOfByte)
  {
    LogUtility.c("PCPushProxy", "--> parse");
    Object localObject = new MessageContent.MsgContent();
    try
    {
      ((MessageContent.MsgContent)localObject).mergeFrom(paramArrayOfByte);
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
        paramArrayOfByte.jdField_b_of_type_JavaLangString = ("unapk" + SystemClock.currentThreadTimeMillis() + "#" + paramArrayOfByte.jdField_b_of_type_JavaLangString);
        paramArrayOfByte.jdField_d_of_type_JavaLangString = paramArrayOfByte.jdField_e_of_type_JavaLangString;
      }
      boolean bool = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramArrayOfByte.jdField_a_of_type_JavaLangString);
      LogUtility.c("PCPushProxy", "add entry to mPkgEntryMap, hasKey = " + bool);
      if (!bool)
      {
        LogUtility.c("PCPushProxy", "add entry to mPkgEntryMap, key = " + paramArrayOfByte.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramArrayOfByte.jdField_a_of_type_JavaLangString, paramArrayOfByte);
      }
      localObject = Message.obtain();
      ((Message)localObject).what = 2;
      ((Message)localObject).obj = paramArrayOfByte.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
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
    if (this.jdField_a_of_type_Int == 111) {
      return "ANDROIDQQ.PCPUSH.SINGLEDETAIL";
    }
    if (this.jdField_a_of_type_Int == 112) {
      return "ANDROIDQQ.PCPUSH.MUTIDETAIL";
    }
    if (this.jdField_a_of_type_Int == 113) {
      return "ANDROIDQQ.PCPUSH.UNREADPOP";
    }
    return "ANDROIDQQ.PCPUSH.AUTO";
  }
  
  public String a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      return null;
    }
    PCPushProxy.PkgEntry localPkgEntry = (PCPushProxy.PkgEntry)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localPkgEntry == null)
    {
      LogUtility.e("PCPushProxy", "getDownloadPath error because entry = null, key = " + paramString);
      return null;
    }
    paramString = DownloadManager.a().a(localPkgEntry.jdField_b_of_type_JavaLangString);
    if (paramString != null) {
      return paramString.k;
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
    LogUtility.c("PCPushProxy", "--> pause key = " + paramString);
    PCPushProxy.PkgEntry localPkgEntry = (PCPushProxy.PkgEntry)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localPkgEntry == null)
    {
      LogUtility.e("PCPushProxy", "pause error because entry = null, key = " + paramString);
      return;
    }
    paramString = new Bundle();
    paramString.putString(DownloadConstants.jdField_a_of_type_JavaLangString, localPkgEntry.jdField_b_of_type_JavaLangString);
    paramString.putString(DownloadConstants.i, localPkgEntry.jdField_f_of_type_JavaLangString);
    paramString.putString(DownloadConstants.jdField_e_of_type_JavaLangString, localPkgEntry.jdField_d_of_type_JavaLangString);
    paramString.putString(DownloadConstants.h, localPkgEntry.jdField_c_of_type_JavaLangString);
    paramString.putString(DownloadConstants.k, localPkgEntry.jdField_e_of_type_JavaLangString);
    String str = DownloadConstants.x;
    if (localPkgEntry.jdField_b_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.putBoolean(str, bool);
      paramString.putInt(DownloadConstants.j, 3);
      DownloadApi.a(null, paramString, 5, null, 0);
      return;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = true;
    LogUtility.c("PCPushProxy", "--> start key = " + paramString);
    if (!DownloadManager.a().a().contains(this))
    {
      DownloadManager.a().a(this);
      LogUtility.c("PCPushProxy", "PCPushProxy has not register, register download listener");
    }
    PCPushProxy.PkgEntry localPkgEntry = (PCPushProxy.PkgEntry)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    boolean bool1;
    if (localPkgEntry == null)
    {
      LogUtility.e("PCPushProxy", "start error because entry = null, key = " + paramString);
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (localPkgEntry.jdField_e_of_type_Int == 101);
      bool1 = bool2;
    } while (localPkgEntry.jdField_e_of_type_Int == 104);
    label273:
    int i;
    if (localPkgEntry.jdField_e_of_type_Int != 105)
    {
      if (!localPkgEntry.jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.")) {
        localPkgEntry.jdField_c_of_type_JavaLangString = (a() + "." + localPkgEntry.jdField_c_of_type_JavaLangString);
      }
    }
    else
    {
      paramString = new Bundle();
      paramString.putString(DownloadConstants.jdField_a_of_type_JavaLangString, localPkgEntry.jdField_b_of_type_JavaLangString);
      paramString.putString(DownloadConstants.i, localPkgEntry.jdField_f_of_type_JavaLangString);
      paramString.putString(DownloadConstants.jdField_e_of_type_JavaLangString, localPkgEntry.jdField_d_of_type_JavaLangString);
      paramString.putString(DownloadConstants.h, localPkgEntry.jdField_c_of_type_JavaLangString);
      paramString.putString(DownloadConstants.k, localPkgEntry.jdField_e_of_type_JavaLangString);
      String str = DownloadConstants.x;
      if (localPkgEntry.jdField_b_of_type_Int != 1) {
        break label459;
      }
      bool1 = true;
      paramString.putBoolean(str, bool1);
      if (localPkgEntry.jdField_b_of_type_Int != 1) {
        break label469;
      }
      if (localPkgEntry.jdField_d_of_type_Int != 2) {
        break label464;
      }
      i = 12;
    }
    for (;;)
    {
      paramString.putInt(DownloadConstants.j, i);
      DownloadApi.a(null, paramString, 5, null, 0);
      return true;
      if (localPkgEntry.jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.AUTO.")) {
        i = "ANDROIDQQ.PCPUSH.AUTO".length();
      }
      for (;;)
      {
        localPkgEntry.jdField_c_of_type_JavaLangString = (a() + localPkgEntry.jdField_c_of_type_JavaLangString.substring(i));
        break;
        if (localPkgEntry.jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.SINGLEDETAIL.")) {
          i = "ANDROIDQQ.PCPUSH.SINGLEDETAIL".length();
        } else if (localPkgEntry.jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.MUTIDETAIL.")) {
          i = "ANDROIDQQ.PCPUSH.MUTIDETAIL".length();
        } else if (localPkgEntry.jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.UNREADPOP.")) {
          i = "ANDROIDQQ.PCPUSH.UNREADPOP".length();
        } else {
          i = "ANDROIDQQ.PCPUSH".length();
        }
      }
      label459:
      bool1 = false;
      break label273;
      label464:
      i = 2;
      continue;
      label469:
      i = 2;
    }
  }
  
  protected String b(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return "";
    }
    return "p" + paramString.hashCode();
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
    LogUtility.c("PCPushProxy", "--> install key = " + paramString);
    PCPushProxy.PkgEntry localPkgEntry = (PCPushProxy.PkgEntry)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localPkgEntry == null)
    {
      LogUtility.e("PCPushProxy", "install error because entry = null, key = " + paramString);
      return;
    }
    if (localPkgEntry.jdField_b_of_type_Int != 1)
    {
      LogUtility.e("PCPushProxy", "The file to be installing is not a apk file");
      return;
    }
    paramString = new Bundle();
    paramString.putString(DownloadConstants.jdField_a_of_type_JavaLangString, localPkgEntry.jdField_b_of_type_JavaLangString);
    paramString.putString(DownloadConstants.i, localPkgEntry.jdField_f_of_type_JavaLangString);
    paramString.putString(DownloadConstants.jdField_e_of_type_JavaLangString, localPkgEntry.jdField_d_of_type_JavaLangString);
    paramString.putString(DownloadConstants.h, localPkgEntry.jdField_c_of_type_JavaLangString);
    paramString.putString(DownloadConstants.k, localPkgEntry.jdField_e_of_type_JavaLangString);
    String str = DownloadConstants.x;
    if (localPkgEntry.jdField_b_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.putBoolean(str, bool);
      paramString.putInt(DownloadConstants.j, 5);
      DownloadApi.a(null, paramString, 5, null, 0);
      return;
    }
  }
  
  public boolean b(String paramString)
  {
    LogUtility.c("PCPushProxy", "--> isInstalled key = " + paramString);
    PCPushProxy.PkgEntry localPkgEntry = (PCPushProxy.PkgEntry)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localPkgEntry == null)
    {
      LogUtility.c("PCPushProxy", "--> key : " + paramString + " 's entry is not exist.");
      return false;
    }
    return AppUtil.a(localPkgEntry.jdField_d_of_type_JavaLangString);
  }
  
  public void c(String paramString)
  {
    LogUtility.c("PCPushProxy", "--> delete key = " + paramString);
    Object localObject = (PCPushProxy.PkgEntry)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject == null)
    {
      LogUtility.e("PCPushProxy", "delete error because entry = null, key = " + paramString);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString(DownloadConstants.jdField_a_of_type_JavaLangString, ((PCPushProxy.PkgEntry)localObject).jdField_b_of_type_JavaLangString);
    localBundle.putString(DownloadConstants.i, ((PCPushProxy.PkgEntry)localObject).jdField_f_of_type_JavaLangString);
    localBundle.putString(DownloadConstants.jdField_e_of_type_JavaLangString, ((PCPushProxy.PkgEntry)localObject).jdField_d_of_type_JavaLangString);
    localBundle.putString(DownloadConstants.h, ((PCPushProxy.PkgEntry)localObject).jdField_c_of_type_JavaLangString);
    localBundle.putString(DownloadConstants.k, ((PCPushProxy.PkgEntry)localObject).jdField_e_of_type_JavaLangString);
    String str = DownloadConstants.x;
    if (((PCPushProxy.PkgEntry)localObject).jdField_b_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean(str, bool);
      localBundle.putInt(DownloadConstants.j, 10);
      DownloadApi.a(null, localBundle, 5, null, 0);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      localObject = Message.obtain();
      ((Message)localObject).what = 3;
      ((Message)localObject).obj = paramString;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      return;
    }
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    LogUtility.c("PCPushProxy", "--> installSucceed packageName = " + paramString2);
    paramString1 = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    if (localIterator.hasNext())
    {
      PCPushProxy.PkgEntry localPkgEntry = (PCPushProxy.PkgEntry)localIterator.next();
      if ((!paramString2.equals(localPkgEntry.jdField_d_of_type_JavaLangString)) || (localPkgEntry.jdField_c_of_type_Int != 0)) {
        break label136;
      }
      localPkgEntry.jdField_c_of_type_Int = 1;
      paramString1 = localPkgEntry;
    }
    label136:
    for (;;)
    {
      break;
      if (paramString1 == null) {}
      for (;;)
      {
        return;
        paramString2 = jdField_a_of_type_JavaUtilList.iterator();
        while (paramString2.hasNext()) {
          ((PCPushProxy.OnDownloadListener)paramString2.next()).a(6, paramString1.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    LogUtility.c("PCPushProxy", "--> onDownloadCancel info = " + paramDownloadInfo.toString());
    paramDownloadInfo = b(paramDownloadInfo.jdField_c_of_type_JavaLangString);
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((PCPushProxy.OnDownloadListener)localIterator.next()).a(5, paramDownloadInfo);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    Object localObject;
    if (paramDownloadInfo != null)
    {
      LogUtility.c("PCPushProxy", "--> onDownloadError info = " + paramDownloadInfo.toString() + " errorCode = " + paramInt1 + " errorMsg = " + paramString + " state = " + paramInt2);
      localObject = b(paramDownloadInfo.jdField_c_of_type_JavaLangString);
      paramDownloadInfo = (PCPushProxy.PkgEntry)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if (paramDownloadInfo == null)
      {
        LogUtility.e("PCPushProxy", "onDownloadError error because entry = null, key = " + (String)localObject);
        return;
      }
      paramDownloadInfo.jdField_e_of_type_Int = 105;
    }
    for (;;)
    {
      localObject = jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((PCPushProxy.OnDownloadListener)((Iterator)localObject).next()).a(paramDownloadInfo, paramInt1, paramString, paramInt2);
      }
      break;
      paramDownloadInfo = null;
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    LogUtility.c("PCPushProxy", "--> onDownloadFinish info = " + paramDownloadInfo.toString());
    paramDownloadInfo = b(paramDownloadInfo.jdField_c_of_type_JavaLangString);
    Object localObject = (PCPushProxy.PkgEntry)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramDownloadInfo);
    if (localObject == null) {
      LogUtility.e("PCPushProxy", "onDownloadPause error because entry = null, key = " + paramDownloadInfo);
    }
    for (;;)
    {
      return;
      ((PCPushProxy.PkgEntry)localObject).jdField_e_of_type_Int = 102;
      localObject = jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((PCPushProxy.OnDownloadListener)((Iterator)localObject).next()).a(4, paramDownloadInfo);
      }
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    LogUtility.c("PCPushProxy", "--> onDownloadPause info = " + paramDownloadInfo.toString());
    paramDownloadInfo = b(paramDownloadInfo.jdField_c_of_type_JavaLangString);
    Object localObject = (PCPushProxy.PkgEntry)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramDownloadInfo);
    if (localObject == null) {
      LogUtility.e("PCPushProxy", "onDownloadPause error because entry = null, key = " + paramDownloadInfo);
    }
    for (;;)
    {
      return;
      ((PCPushProxy.PkgEntry)localObject).jdField_e_of_type_Int = 105;
      localObject = jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((PCPushProxy.OnDownloadListener)((Iterator)localObject).next()).a(2, paramDownloadInfo);
      }
    }
  }
  
  public void onDownloadUpdate(List paramList)
  {
    LogUtility.c("PCPushProxy", "--> onDownloadUpdate infos = " + paramList.toString());
    ArrayList localArrayList = new ArrayList(10);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (DownloadInfo)paramList.next();
      String str = b(((DownloadInfo)localObject).jdField_c_of_type_JavaLangString);
      PCPushProxy.PkgEntry localPkgEntry = (PCPushProxy.PkgEntry)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      if (localPkgEntry == null)
      {
        LogUtility.e("PCPushProxy", "onDownloadUpdate error because entry = null, key = " + str);
      }
      else
      {
        int i = localPkgEntry.jdField_e_of_type_Int;
        switch (((DownloadInfo)localObject).a())
        {
        }
        for (;;)
        {
          localPkgEntry.jdField_f_of_type_Int = ((DownloadInfo)localObject).g;
          if ((i == 101) || (localPkgEntry.jdField_e_of_type_Int != 101)) {
            break;
          }
          localObject = jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((PCPushProxy.OnDownloadListener)((Iterator)localObject).next()).a(1, str);
          }
          localPkgEntry.jdField_e_of_type_Int = 104;
          continue;
          localPkgEntry.jdField_e_of_type_Int = 101;
          continue;
          if (localPkgEntry.jdField_c_of_type_Int == 1)
          {
            localPkgEntry.jdField_e_of_type_Int = 103;
          }
          else
          {
            localPkgEntry.jdField_e_of_type_Int = 102;
            continue;
            localPkgEntry.jdField_e_of_type_Int = 105;
            continue;
            localPkgEntry.jdField_e_of_type_Int = 100;
          }
        }
        localArrayList.add(localPkgEntry);
      }
    }
    paramList = jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((PCPushProxy.OnDownloadListener)paramList.next()).a(localArrayList);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    LogUtility.c("PCPushProxy", "--> onDownloadWait info = " + paramDownloadInfo.toString());
    paramDownloadInfo = b(paramDownloadInfo.jdField_c_of_type_JavaLangString);
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((PCPushProxy.OnDownloadListener)localIterator.next()).a(3, paramDownloadInfo);
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.pcpush.PCPushProxy
 * JD-Core Version:    0.7.0.1
 */