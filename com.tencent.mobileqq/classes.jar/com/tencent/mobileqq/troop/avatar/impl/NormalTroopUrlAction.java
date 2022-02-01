package com.tencent.mobileqq.troop.avatar.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HeadDpcCfg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.avatar.BaseUrlAction;
import com.tencent.mobileqq.troop.avatar.HeaderSetting;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread.UploadState;
import com.tencent.mobileqq.troop.avatar.UploadItem;
import com.tencent.mobileqq.troop.soso.SosoSrvAddrProvider;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class NormalTroopUrlAction
  extends BaseUrlAction
{
  protected static final List<String> h = new ArrayList();
  protected final String c = "0x6ff0072";
  protected final String d = "5520";
  protected final String e = "3";
  protected final String f = "5";
  protected final String g = "cgi-bin/httpconn";
  private final String i = "TroopAvatarManger_NormalTroopUrlAction";
  
  static
  {
    h.add("2408:8756:3af0:10::107");
    h.add("240e:ff:f101:10::104");
    h.add("2402:4e00:8010::132");
    h.add("2402:4e00:8010::22");
    h.add("2408:80f1:31:50::21");
    h.add("240e:e1:a900:50::3d");
    h.add("2402:4e00:8020:2::86");
    h.add("2409:8c1e:8fd0:50::1c");
    h.add("2408:8711:10:10::13");
    h.add("240e:928:1400:10::23");
    h.add("2402:4e00:8030:1::a0");
    h.add("2409:8702:4860:10::41");
  }
  
  private String a(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    try
    {
      paramString1 = new URL("http", paramString2, paramInt, "cgi-bin/httpconn").toString();
      return paramString1;
    }
    catch (MalformedURLException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  private String a(boolean paramBoolean)
  {
    Object localObject2 = a("htdata3.qq.com", "cgi-bin/httpconn", paramBoolean ^ true);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = a("htdata4.qq.com", "cgi-bin/httpconn", paramBoolean ^ true);
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = a("cgi-bin/httpconn", paramBoolean);
    }
    return localObject2;
  }
  
  public int a(HttpURLConnection paramHttpURLConnection, TroopUploadingThread.UploadState paramUploadState, UploadItem paramUploadItem)
  {
    int m = -1;
    Object localObject1 = Integer.valueOf(-1);
    Map localMap = paramHttpURLConnection.getHeaderFields();
    try
    {
      k = paramHttpURLConnection.getResponseCode();
    }
    catch (IOException localIOException)
    {
      QLog.d("TroopAvatarManger_NormalTroopUrlAction", 1, "getResult IOException", localIOException);
      k = -1;
    }
    Object localObject3 = null;
    String str = null;
    Object localObject2 = localObject1;
    if (localMap != null)
    {
      Iterator localIterator = localMap.keySet().iterator();
      for (;;)
      {
        localObject2 = localObject1;
        localObject3 = str;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (String)localIterator.next();
        if (localObject2 != null)
        {
          localObject3 = localMap.get(localObject2);
          if ((localObject3 != null) && ((localObject3 instanceof List))) {
            if (((String)localObject2).equals("Result"))
            {
              localObject2 = (List)localObject3;
              localObject3 = ((List)localObject2).get(0);
              if ((localObject3 != null) && ((localObject3 instanceof String))) {
                localObject1 = Integer.valueOf(Integer.parseInt((String)((List)localObject2).get(0)));
              }
            }
            else if (((String)localObject2).equals("NewSeq"))
            {
              localObject2 = (List)localObject3;
              localObject3 = ((List)localObject2).get(0);
              if ((localObject3 != null) && ((localObject3 instanceof String))) {
                paramUploadState.c = Integer.parseInt((String)((List)localObject2).get(0));
              }
            }
            else if (((String)localObject2).equals("FileName"))
            {
              localObject2 = (List)localObject3;
              localObject3 = ((List)localObject2).get(0);
              if ((localObject3 != null) && ((localObject3 instanceof String))) {
                str = (String)((List)localObject2).get(0);
              }
            }
            else if (((String)localObject2).equals("X-ErrMsg"))
            {
              localObject2 = (List)localObject3;
              localObject3 = ((List)localObject2).get(0);
              if ((localObject3 != null) && ((localObject3 instanceof String))) {
                paramUploadState.g = new String(((ITroopCardApi)QRoute.api(ITroopCardApi.class)).base64Decode((String)((List)localObject2).get(0)));
              }
            }
            else if (((String)localObject2).equals("X-ErrNo"))
            {
              localObject2 = (List)localObject3;
              localObject3 = ((List)localObject2).get(0);
              if ((localObject3 != null) && ((localObject3 instanceof String)))
              {
                paramUploadState.f = Integer.parseInt((String)((List)localObject2).get(0));
                localObject1 = Integer.valueOf(paramUploadState.f);
              }
            }
          }
        }
      }
    }
    int j = ((Integer)localObject2).intValue();
    if (k != 200) {
      j = 102;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("result:");
    ((StringBuilder)localObject1).append(j);
    ((StringBuilder)localObject1).append("resCode:");
    ((StringBuilder)localObject1).append(k);
    QLog.d("TroopAvatarManger_NormalTroopUrlAction", 1, ((StringBuilder)localObject1).toString());
    int k = m;
    if (localObject3 != null)
    {
      k = m;
      if (((String)localObject3).contains("_"))
      {
        localObject1 = ((String)localObject3).split("_");
        k = m;
        if (localObject1.length == 2) {
          try
          {
            paramUploadState.b = Integer.parseInt(localObject1[1]);
            k = j;
          }
          catch (NumberFormatException paramUploadState)
          {
            paramUploadState.printStackTrace();
            k = m;
          }
        }
      }
    }
    if (paramUploadItem.c) {
      return 104;
    }
    paramHttpURLConnection.disconnect();
    return k;
  }
  
  public String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject3 = null;
    String str = null;
    Object localObject2 = localObject3;
    for (;;)
    {
      int j;
      try
      {
        localObject1 = InetAddress.getAllByName(paramString1);
        if (localObject1 == null) {
          break label189;
        }
        localObject2 = localObject3;
        int k = localObject1.length;
        j = 0;
        if (j >= k) {
          break label189;
        }
        Object localObject4 = localObject1[j];
        localObject2 = localObject3;
        if (((localObject4 instanceof Inet4Address)) && (paramBoolean))
        {
          localObject2 = localObject3;
          localObject1 = localObject4.getHostAddress();
        }
        else
        {
          localObject2 = localObject3;
          if ((!(localObject4 instanceof Inet6Address)) || (paramBoolean)) {
            break label180;
          }
          localObject2 = localObject3;
          localObject1 = localObject4.getHostAddress();
        }
        localObject2 = localObject3;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = localObject3;
          str = a(paramString2, (String)localObject1, 80);
        }
        localObject2 = str;
        QLog.i("TroopAvatarManger_NormalTroopUrlAction", 1, String.format("tryGetIpByHost host[%s] %s", new Object[] { paramString1, localObject1 }));
        return str;
      }
      catch (UnknownHostException paramString1)
      {
        QLog.i("TroopAvatarManger_NormalTroopUrlAction", 1, "UnknownHostException", paramString1);
        return localObject2;
      }
      label180:
      j += 1;
      continue;
      label189:
      Object localObject1 = null;
    }
  }
  
  public String a(String paramString, boolean paramBoolean)
  {
    int j = new Random().nextInt(100);
    String str;
    if (paramBoolean)
    {
      int k = h.size();
      str = (String)h.get(Math.abs(j) % k);
    }
    else if (Math.abs(j) % 2 == 0)
    {
      str = "14.17.18.20";
    }
    else
    {
      str = "112.90.139.96";
    }
    paramString = a(paramString, str, 80);
    QLog.i("TroopAvatarManger_NormalTroopUrlAction", 1, String.format("tryGetIpByRandomIp ip=%s bIpv6=%b", new Object[] { str, Boolean.valueOf(paramBoolean) }));
    return paramString;
  }
  
  public List<String> a(AppInterface paramAppInterface)
  {
    if (this.a != null)
    {
      String str1 = this.a.getString("userData");
      String str2 = "0";
      if (str1 == null) {
        str1 = "0";
      } else {
        str1 = this.a.getString("userData");
      }
      if (this.a.getString("range") != null) {
        str2 = this.a.getString("range");
      }
      return a(paramAppInterface, str1, str2, this.a.getString("troopCode"), this.a.getString("uin"), this.a.getString("ukey"));
    }
    return new ArrayList();
  }
  
  protected List<String> a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool2 = HeadDpcCfg.a().c();
    int m = NetConnInfoCenter.getActiveNetIpFamily(true);
    Object localObject = SosoSrvAddrProvider.a();
    ((SosoSrvAddrProvider)localObject).c();
    int k = 0;
    if (m == 3)
    {
      String str = ((SosoSrvAddrProvider)localObject).a(paramAppInterface, 0, bool2, true);
      if (!TextUtils.isEmpty(str))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("cgi-bin/httpconn");
        localArrayList.add(localStringBuilder.toString());
      }
      paramAppInterface = ((SosoSrvAddrProvider)localObject).a(paramAppInterface, 0, bool2 ^ true, true);
      if (!TextUtils.isEmpty(paramAppInterface))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramAppInterface);
        ((StringBuilder)localObject).append("cgi-bin/httpconn");
        localArrayList.add(((StringBuilder)localObject).toString());
      }
      if (localArrayList.size() < 2)
      {
        paramAppInterface = a(false);
        if (!TextUtils.isEmpty(paramAppInterface)) {
          localArrayList.add(paramAppInterface);
        }
      }
      paramAppInterface = a("cgi-bin/httpconn", "htdata3.qq.com", 80);
      if (!TextUtils.isEmpty(paramAppInterface)) {
        localArrayList.add(paramAppInterface);
      }
    }
    else
    {
      boolean bool1;
      if (m == 2) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramAppInterface = ((SosoSrvAddrProvider)localObject).a(paramAppInterface, 0, bool1, true);
      if (!TextUtils.isEmpty(paramAppInterface))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramAppInterface);
        ((StringBuilder)localObject).append("cgi-bin/httpconn");
        localArrayList.add(((StringBuilder)localObject).toString());
      }
      if (m == 2) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramAppInterface = a(bool1);
      if (!TextUtils.isEmpty(paramAppInterface)) {
        localArrayList.add(paramAppInterface);
      }
      paramAppInterface = a("cgi-bin/httpconn", "htdata3.qq.com", 80);
      if (!TextUtils.isEmpty(paramAppInterface)) {
        localArrayList.add(paramAppInterface);
      }
    }
    int j = k;
    if (QLog.isColorLevel())
    {
      QLog.i("TroopAvatarManger_NormalTroopUrlAction", 2, String.format("getSrvAddr type=%d prefV6=%b getUrl=%s", new Object[] { Integer.valueOf(m), Boolean.valueOf(bool2), Arrays.toString(localArrayList.toArray()) }));
      j = k;
    }
    while (j < localArrayList.size())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append((String)localArrayList.get(j));
      paramAppInterface.append("?htcmd=");
      paramAppInterface.append("0x6ff0072");
      paramAppInterface.append("&ver=");
      paramAppInterface.append("5520");
      paramAppInterface.append("&ukey=");
      paramAppInterface.append(paramString5);
      paramAppInterface.append("&range=");
      paramAppInterface.append(paramString2);
      paramAppInterface.append("&uin=");
      paramAppInterface.append(paramString4);
      paramAppInterface.append("&seq=23&groupuin=");
      paramAppInterface.append(paramString3);
      paramAppInterface.append("&filetype=");
      paramAppInterface.append("3");
      paramAppInterface.append("&imagetype=");
      paramAppInterface.append("5");
      paramAppInterface.append("&userdata=");
      paramAppInterface.append(paramString1);
      localArrayList.set(j, paramAppInterface.toString());
      j += 1;
    }
    return localArrayList;
  }
  
  public void b(AppInterface paramAppInterface)
  {
    paramAppInterface = new HeaderSetting();
    paramAppInterface.a("sslv6.htdata.qq.com");
    this.b = paramAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.impl.NormalTroopUrlAction
 * JD-Core Version:    0.7.0.1
 */