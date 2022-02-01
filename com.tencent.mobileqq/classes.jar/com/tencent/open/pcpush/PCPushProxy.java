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
  protected static List<PCPushProxy.OnDownloadListener> f;
  protected int b = 111;
  protected Handler c = new PCPushProxy.WorkHandler(this, ThreadManager.getSubThreadLooper());
  protected ConcurrentHashMap<String, PCPushProxy.PkgEntry> d = new ConcurrentHashMap(10);
  protected PCPushDBHelper e;
  
  protected PCPushProxy()
  {
    f = new ArrayList(10);
    this.e = new PCPushDBHelper();
    this.c.sendEmptyMessage(1);
    DownloadManager.b().a(this);
  }
  
  public static PCPushProxy a()
  {
    try
    {
      if (a == null) {
        a = new PCPushProxy();
      }
      PCPushProxy localPCPushProxy = a;
      return localPCPushProxy;
    }
    finally {}
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
    paramArrayOfByte.b = String.valueOf(((MessageContent.MsgContent)localObject).appid.get());
    paramArrayOfByte.f = ((MessageContent.MsgContent)localObject).appname.get();
    paramArrayOfByte.i = ((MessageContent.MsgContent)localObject).appsize.get();
    paramArrayOfByte.g = ((MessageContent.MsgContent)localObject).appurl.get();
    paramArrayOfByte.j = ((MessageContent.MsgContent)localObject).filetype.get();
    paramArrayOfByte.h = ((MessageContent.MsgContent)localObject).iconurl.get();
    paramArrayOfByte.d = ((MessageContent.MsgContent)localObject).pkgname.get();
    paramArrayOfByte.k = ((MessageContent.MsgContent)localObject).source.get();
    paramArrayOfByte.l = ((MessageContent.MsgContent)localObject).srciconurl.get();
    paramArrayOfByte.e = ((MessageContent.MsgContent)localObject).versioncode.get();
    paramArrayOfByte.c = ((MessageContent.MsgContent)localObject).via.get();
    paramArrayOfByte.a = h(paramArrayOfByte.g);
    if (paramArrayOfByte.j != 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unapk");
      ((StringBuilder)localObject).append(SystemClock.currentThreadTimeMillis());
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(paramArrayOfByte.b);
      paramArrayOfByte.b = ((StringBuilder)localObject).toString();
      paramArrayOfByte.d = paramArrayOfByte.f;
    }
    boolean bool = this.d.containsKey(paramArrayOfByte.a);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("add entry to mPkgEntryMap, hasKey = ");
    ((StringBuilder)localObject).append(bool);
    LogUtility.c("PCPushProxy", ((StringBuilder)localObject).toString());
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("add entry to mPkgEntryMap, key = ");
      ((StringBuilder)localObject).append(paramArrayOfByte.a);
      LogUtility.c("PCPushProxy", ((StringBuilder)localObject).toString());
      this.d.put(paramArrayOfByte.a, paramArrayOfByte);
    }
    localObject = Message.obtain();
    ((Message)localObject).what = 2;
    ((Message)localObject).obj = paramArrayOfByte.a;
    this.c.sendMessage((Message)localObject);
    return paramArrayOfByte;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(PCPushProxy.OnDownloadListener paramOnDownloadListener)
  {
    LogUtility.c("PCPushProxy", "registerDownloadLitener dataline register listeners");
    if (!f.contains(paramOnDownloadListener)) {
      f.add(paramOnDownloadListener);
    }
  }
  
  public boolean a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("--> start key = ");
    ((StringBuilder)localObject).append(paramString);
    LogUtility.c("PCPushProxy", ((StringBuilder)localObject).toString());
    if (!DownloadManager.b().i().contains(this))
    {
      DownloadManager.b().a(this);
      LogUtility.c("PCPushProxy", "PCPushProxy has not register, register download listener");
    }
    localObject = (PCPushProxy.PkgEntry)this.d.get(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start error because entry = null, key = ");
      ((StringBuilder)localObject).append(paramString);
      LogUtility.e("PCPushProxy", ((StringBuilder)localObject).toString());
      return false;
    }
    if (((PCPushProxy.PkgEntry)localObject).o != 101)
    {
      if (((PCPushProxy.PkgEntry)localObject).o == 104) {
        return true;
      }
      if (((PCPushProxy.PkgEntry)localObject).o != 105) {
        if (!((PCPushProxy.PkgEntry)localObject).c.startsWith("ANDROIDQQ.PCPUSH."))
        {
          paramString = new StringBuilder();
          paramString.append(b());
          paramString.append(".");
          paramString.append(((PCPushProxy.PkgEntry)localObject).c);
          ((PCPushProxy.PkgEntry)localObject).c = paramString.toString();
        }
        else
        {
          if (((PCPushProxy.PkgEntry)localObject).c.startsWith("ANDROIDQQ.PCPUSH.AUTO.")) {
            i = 21;
          } else if (((PCPushProxy.PkgEntry)localObject).c.startsWith("ANDROIDQQ.PCPUSH.SINGLEDETAIL.")) {
            i = 29;
          } else if (((PCPushProxy.PkgEntry)localObject).c.startsWith("ANDROIDQQ.PCPUSH.MUTIDETAIL.")) {
            i = 27;
          } else if (((PCPushProxy.PkgEntry)localObject).c.startsWith("ANDROIDQQ.PCPUSH.UNREADPOP.")) {
            i = 26;
          } else {
            i = 16;
          }
          paramString = new StringBuilder();
          paramString.append(b());
          paramString.append(((PCPushProxy.PkgEntry)localObject).c.substring(i));
          ((PCPushProxy.PkgEntry)localObject).c = paramString.toString();
        }
      }
      paramString = new Bundle();
      paramString.putString(DownloadConstants.b, ((PCPushProxy.PkgEntry)localObject).b);
      paramString.putString(DownloadConstants.j, ((PCPushProxy.PkgEntry)localObject).g);
      paramString.putString(DownloadConstants.f, ((PCPushProxy.PkgEntry)localObject).d);
      paramString.putString(DownloadConstants.i, ((PCPushProxy.PkgEntry)localObject).c);
      paramString.putString(DownloadConstants.l, ((PCPushProxy.PkgEntry)localObject).f);
      String str = DownloadConstants.z;
      boolean bool;
      if (((PCPushProxy.PkgEntry)localObject).j == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramString.putBoolean(str, bool);
      int k = ((PCPushProxy.PkgEntry)localObject).j;
      int j = 2;
      int i = j;
      if (k == 1)
      {
        i = j;
        if (((PCPushProxy.PkgEntry)localObject).n == 2) {
          i = 12;
        }
      }
      paramString.putInt(DownloadConstants.k, i);
      DownloadApi.a(null, paramString, "5", null, 0);
    }
    return true;
  }
  
  protected String b()
  {
    Object localObject = CommonDataAdapter.a().b();
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
    int i = this.b;
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
  
  public void b(int paramInt)
  {
    this.c.sendEmptyMessage(paramInt);
  }
  
  public void b(PCPushProxy.OnDownloadListener paramOnDownloadListener)
  {
    if (f.contains(paramOnDownloadListener)) {
      f.remove(paramOnDownloadListener);
    }
  }
  
  public void b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("--> pause key = ");
    ((StringBuilder)localObject).append(paramString);
    LogUtility.c("PCPushProxy", ((StringBuilder)localObject).toString());
    localObject = (PCPushProxy.PkgEntry)this.d.get(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pause error because entry = null, key = ");
      ((StringBuilder)localObject).append(paramString);
      LogUtility.e("PCPushProxy", ((StringBuilder)localObject).toString());
      return;
    }
    paramString = new Bundle();
    paramString.putString(DownloadConstants.b, ((PCPushProxy.PkgEntry)localObject).b);
    paramString.putString(DownloadConstants.j, ((PCPushProxy.PkgEntry)localObject).g);
    paramString.putString(DownloadConstants.f, ((PCPushProxy.PkgEntry)localObject).d);
    paramString.putString(DownloadConstants.i, ((PCPushProxy.PkgEntry)localObject).c);
    paramString.putString(DownloadConstants.l, ((PCPushProxy.PkgEntry)localObject).f);
    String str = DownloadConstants.z;
    int i = ((PCPushProxy.PkgEntry)localObject).j;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    paramString.putBoolean(str, bool);
    paramString.putInt(DownloadConstants.k, 3);
    DownloadApi.a(null, paramString, "5", null, 0);
  }
  
  public void c(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("--> install key = ");
    ((StringBuilder)localObject).append(paramString);
    LogUtility.c("PCPushProxy", ((StringBuilder)localObject).toString());
    localObject = (PCPushProxy.PkgEntry)this.d.get(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("install error because entry = null, key = ");
      ((StringBuilder)localObject).append(paramString);
      LogUtility.e("PCPushProxy", ((StringBuilder)localObject).toString());
      return;
    }
    int i = ((PCPushProxy.PkgEntry)localObject).j;
    boolean bool = true;
    if (i != 1)
    {
      LogUtility.e("PCPushProxy", "The file to be installing is not a apk file");
      return;
    }
    paramString = new Bundle();
    paramString.putString(DownloadConstants.b, ((PCPushProxy.PkgEntry)localObject).b);
    paramString.putString(DownloadConstants.j, ((PCPushProxy.PkgEntry)localObject).g);
    paramString.putString(DownloadConstants.f, ((PCPushProxy.PkgEntry)localObject).d);
    paramString.putString(DownloadConstants.i, ((PCPushProxy.PkgEntry)localObject).c);
    paramString.putString(DownloadConstants.l, ((PCPushProxy.PkgEntry)localObject).f);
    String str = DownloadConstants.z;
    if (((PCPushProxy.PkgEntry)localObject).j != 1) {
      bool = false;
    }
    paramString.putBoolean(str, bool);
    paramString.putInt(DownloadConstants.k, 5);
    DownloadApi.a(null, paramString, "5", null, 0);
  }
  
  public void d(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("--> delete key = ");
    ((StringBuilder)localObject).append(paramString);
    LogUtility.c("PCPushProxy", ((StringBuilder)localObject).toString());
    localObject = (PCPushProxy.PkgEntry)this.d.get(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("delete error because entry = null, key = ");
      ((StringBuilder)localObject).append(paramString);
      LogUtility.e("PCPushProxy", ((StringBuilder)localObject).toString());
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString(DownloadConstants.b, ((PCPushProxy.PkgEntry)localObject).b);
    localBundle.putString(DownloadConstants.j, ((PCPushProxy.PkgEntry)localObject).g);
    localBundle.putString(DownloadConstants.f, ((PCPushProxy.PkgEntry)localObject).d);
    localBundle.putString(DownloadConstants.i, ((PCPushProxy.PkgEntry)localObject).c);
    localBundle.putString(DownloadConstants.l, ((PCPushProxy.PkgEntry)localObject).f);
    String str = DownloadConstants.z;
    int i = ((PCPushProxy.PkgEntry)localObject).j;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    localBundle.putBoolean(str, bool);
    localBundle.putInt(DownloadConstants.k, 10);
    DownloadApi.a(null, localBundle, "5", null, 0);
    this.d.remove(paramString);
    localObject = Message.obtain();
    ((Message)localObject).what = 3;
    ((Message)localObject).obj = paramString;
    this.c.sendMessage((Message)localObject);
  }
  
  public boolean e(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("--> isInstalled key = ");
    ((StringBuilder)localObject).append(paramString);
    LogUtility.c("PCPushProxy", ((StringBuilder)localObject).toString());
    localObject = (PCPushProxy.PkgEntry)this.d.get(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("--> key : ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" 's entry is not exist.");
      LogUtility.c("PCPushProxy", ((StringBuilder)localObject).toString());
      return false;
    }
    return AppUtil.a(((PCPushProxy.PkgEntry)localObject).d);
  }
  
  public int f(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("--> open key = ");
    ((StringBuilder)localObject1).append(paramString);
    LogUtility.c("PCPushProxy", ((StringBuilder)localObject1).toString());
    localObject1 = (PCPushProxy.PkgEntry)this.d.get(paramString);
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("open fail entry is null, error : OPEN_FAIL_KEY_NOT_EXISTS, key = ");
      ((StringBuilder)localObject1).append(paramString);
      LogUtility.e("PCPushProxy", ((StringBuilder)localObject1).toString());
      return 1;
    }
    if (((PCPushProxy.PkgEntry)localObject1).j != 1)
    {
      localObject2 = g(paramString);
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
    this.c.sendMessage((Message)localObject2);
    paramString = CommonDataAdapter.a().b();
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
    if (((PCPushProxy.PkgEntry)localObject1).j == 1)
    {
      try
      {
        localObject2 = ((PackageManager)localObject2).getLaunchIntentForPackage(((PCPushProxy.PkgEntry)localObject1).d);
        if (localObject2 == null)
        {
          paramString = new StringBuilder();
          paramString.append("open fail, because package not found, package = ");
          paramString.append(((PCPushProxy.PkgEntry)localObject1).d);
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
      localObject1 = DownloadManager.b().d(((PCPushProxy.PkgEntry)localObject1).b);
      if (localObject1 == null) {
        return 4;
      }
      localObject1 = OpenFileUtil.a(paramString, new File(((DownloadInfo)localObject1).q));
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
  
  public String g(String paramString)
  {
    if (!this.d.containsKey(paramString)) {
      return null;
    }
    Object localObject = (PCPushProxy.PkgEntry)this.d.get(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDownloadPath error because entry = null, key = ");
      ((StringBuilder)localObject).append(paramString);
      LogUtility.e("PCPushProxy", ((StringBuilder)localObject).toString());
      return null;
    }
    paramString = DownloadManager.b().d(((PCPushProxy.PkgEntry)localObject).b);
    if (paramString != null) {
      return paramString.q;
    }
    return null;
  }
  
  protected String h(String paramString)
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
  
  public void installSucceed(String paramString1, String paramString2)
  {
    paramString1 = new StringBuilder();
    paramString1.append("--> installSucceed packageName = ");
    paramString1.append(paramString2);
    LogUtility.c("PCPushProxy", paramString1.toString());
    Iterator localIterator = this.d.values().iterator();
    label47:
    PCPushProxy.PkgEntry localPkgEntry;
    for (paramString1 = null; localIterator.hasNext(); paramString1 = localPkgEntry)
    {
      localPkgEntry = (PCPushProxy.PkgEntry)localIterator.next();
      if ((!paramString2.equals(localPkgEntry.d)) || (localPkgEntry.m != 0)) {
        break label47;
      }
      localPkgEntry.m = 1;
    }
    if (paramString1 == null) {
      return;
    }
    paramString2 = f.iterator();
    while (paramString2.hasNext()) {
      ((PCPushProxy.OnDownloadListener)paramString2.next()).a(6, paramString1.a);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("--> onDownloadCancel info = ");
    ((StringBuilder)localObject).append(paramDownloadInfo.toString());
    LogUtility.c("PCPushProxy", ((StringBuilder)localObject).toString());
    paramDownloadInfo = h(paramDownloadInfo.d);
    localObject = f.iterator();
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
      localObject = h(paramDownloadInfo.d);
      paramDownloadInfo = (PCPushProxy.PkgEntry)this.d.get(localObject);
      if (paramDownloadInfo == null)
      {
        paramDownloadInfo = new StringBuilder();
        paramDownloadInfo.append("onDownloadError error because entry = null, key = ");
        paramDownloadInfo.append((String)localObject);
        LogUtility.e("PCPushProxy", paramDownloadInfo.toString());
        return;
      }
      paramDownloadInfo.o = 105;
    }
    else
    {
      paramDownloadInfo = null;
    }
    Object localObject = f.iterator();
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
    paramDownloadInfo = h(paramDownloadInfo.d);
    localObject = (PCPushProxy.PkgEntry)this.d.get(paramDownloadInfo);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadPause error because entry = null, key = ");
      ((StringBuilder)localObject).append(paramDownloadInfo);
      LogUtility.e("PCPushProxy", ((StringBuilder)localObject).toString());
      return;
    }
    ((PCPushProxy.PkgEntry)localObject).o = 102;
    localObject = f.iterator();
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
    paramDownloadInfo = h(paramDownloadInfo.d);
    localObject = (PCPushProxy.PkgEntry)this.d.get(paramDownloadInfo);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadPause error because entry = null, key = ");
      ((StringBuilder)localObject).append(paramDownloadInfo);
      LogUtility.e("PCPushProxy", ((StringBuilder)localObject).toString());
      return;
    }
    ((PCPushProxy.PkgEntry)localObject).o = 105;
    localObject = f.iterator();
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
      String str = h(((DownloadInfo)localObject3).d);
      Object localObject2 = (PCPushProxy.PkgEntry)this.d.get(str);
      if (localObject2 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onDownloadUpdate error because entry = null, key = ");
        ((StringBuilder)localObject2).append(str);
        LogUtility.e("PCPushProxy", ((StringBuilder)localObject2).toString());
      }
      else
      {
        int i = ((PCPushProxy.PkgEntry)localObject2).o;
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
                  ((PCPushProxy.PkgEntry)localObject2).o = 104;
                }
              }
              else if (((PCPushProxy.PkgEntry)localObject2).m == 1) {
                ((PCPushProxy.PkgEntry)localObject2).o = 103;
              } else {
                ((PCPushProxy.PkgEntry)localObject2).o = 102;
              }
            }
            else {
              ((PCPushProxy.PkgEntry)localObject2).o = 105;
            }
          }
          else {
            ((PCPushProxy.PkgEntry)localObject2).o = 101;
          }
        }
        else {
          ((PCPushProxy.PkgEntry)localObject2).o = 100;
        }
        ((PCPushProxy.PkgEntry)localObject2).p = ((DownloadInfo)localObject3).t;
        if ((i != 101) && (((PCPushProxy.PkgEntry)localObject2).o == 101))
        {
          localObject3 = f.iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((PCPushProxy.OnDownloadListener)((Iterator)localObject3).next()).a(1, str);
          }
        }
        ((List)localObject1).add(localObject2);
      }
    }
    paramList = f.iterator();
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
    paramDownloadInfo = h(paramDownloadInfo.d);
    localObject = f.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((PCPushProxy.OnDownloadListener)((Iterator)localObject).next()).a(3, paramDownloadInfo);
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.pcpush.PCPushProxy
 * JD-Core Version:    0.7.0.1
 */