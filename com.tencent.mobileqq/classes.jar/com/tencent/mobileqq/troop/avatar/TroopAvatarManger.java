package com.tencent.mobileqq.troop.avatar;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HeadDpcCfg;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.handler.ITroopAvatarHandler;
import com.tencent.mobileqq.troop.soso.SosoSrvAddrProvider;
import com.tencent.qphone.base.util.QLog;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import java.util.Random;

public class TroopAvatarManger
{
  protected static final List<String> a;
  protected static Map<String, UploadingTask> a;
  protected ITroopAvatarHandler a;
  protected final String a;
  protected final String b = "5520";
  protected final String c = "3";
  protected final String d = "5";
  protected final String e = "cgi-bin/httpconn";
  public String f;
  
  static
  {
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_JavaUtilList.add("2408:8756:3af0:10::107");
    jdField_a_of_type_JavaUtilList.add("240e:ff:f101:10::104");
    jdField_a_of_type_JavaUtilList.add("2402:4e00:8010::132");
    jdField_a_of_type_JavaUtilList.add("2402:4e00:8010::22");
    jdField_a_of_type_JavaUtilList.add("2408:80f1:31:50::21");
    jdField_a_of_type_JavaUtilList.add("240e:e1:a900:50::3d");
    jdField_a_of_type_JavaUtilList.add("2402:4e00:8020:2::86");
    jdField_a_of_type_JavaUtilList.add("2409:8c1e:8fd0:50::1c");
    jdField_a_of_type_JavaUtilList.add("2408:8711:10:10::13");
    jdField_a_of_type_JavaUtilList.add("240e:928:1400:10::23");
    jdField_a_of_type_JavaUtilList.add("2402:4e00:8030:1::a0");
    jdField_a_of_type_JavaUtilList.add("2409:8702:4860:10::41");
  }
  
  public TroopAvatarManger(String paramString, Class<? extends UploadingTask> paramClass, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = "0x6ff0072";
    this.jdField_a_of_type_ComTencentMobileqqTroopApiHandlerITroopAvatarHandler = ((ITroopAvatarHandler)paramAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAvatarHandlerName()));
    this.f = paramString;
    if (jdField_a_of_type_JavaUtilMap == null) {
      jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    if ((UploadingTask)jdField_a_of_type_JavaUtilMap.get(paramString) == null)
    {
      paramClass = UploadingFactory.a(paramClass);
      jdField_a_of_type_JavaUtilMap.put(paramString, paramClass);
    }
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
  
  public String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject3 = null;
    String str = null;
    Object localObject2 = localObject3;
    for (;;)
    {
      int i;
      try
      {
        localObject1 = InetAddress.getAllByName(paramString1);
        if (localObject1 == null) {
          break label187;
        }
        localObject2 = localObject3;
        int j = localObject1.length;
        i = 0;
        if (i >= j) {
          break label187;
        }
        Object localObject4 = localObject1[i];
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
            break label178;
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
        QLog.i("TroopAvatarManger", 1, String.format("tryGetIpByHost host[%s] %s", new Object[] { paramString1, localObject1 }));
        return str;
      }
      catch (UnknownHostException paramString1)
      {
        QLog.i("TroopAvatarManger", 1, "UnknownHostException", paramString1);
        return localObject2;
      }
      label178:
      i += 1;
      continue;
      label187:
      Object localObject1 = null;
    }
  }
  
  public String a(String paramString, boolean paramBoolean)
  {
    int i = new Random().nextInt(100);
    String str;
    if (paramBoolean)
    {
      int j = jdField_a_of_type_JavaUtilList.size();
      str = (String)jdField_a_of_type_JavaUtilList.get(Math.abs(i) % j);
    }
    else if (Math.abs(i) % 2 == 0)
    {
      str = "14.17.18.20";
    }
    else
    {
      str = "112.90.139.96";
    }
    paramString = a(paramString, str, 80);
    QLog.i("TroopAvatarManger", 1, String.format("tryGetIpByRandomIp ip=%s bIpv6=%b", new Object[] { str, Boolean.valueOf(paramBoolean) }));
    return paramString;
  }
  
  public ArrayList<UploadItem> a()
  {
    return ((UploadingTask)jdField_a_of_type_JavaUtilMap.get(this.f)).a();
  }
  
  protected List<String> a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool2 = HeadDpcCfg.a().a();
    int k = NetConnInfoCenter.getActiveNetIpFamily(true);
    Object localObject = SosoSrvAddrProvider.a();
    ((SosoSrvAddrProvider)localObject).b();
    int j = 0;
    if (k == 3)
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
      if (k == 2) {
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
      if (k == 2) {
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
    int i = j;
    if (QLog.isColorLevel())
    {
      QLog.i("TroopAvatarManger", 2, String.format("getSrvAddr type=%d prefV6=%b getUrl=%s", new Object[] { Integer.valueOf(k), Boolean.valueOf(bool2), Arrays.toString(localArrayList.toArray()) }));
      i = j;
    }
    while (i < localArrayList.size())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append((String)localArrayList.get(i));
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
      localArrayList.set(i, paramAppInterface.toString());
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopApiHandlerITroopAvatarHandler = null;
  }
  
  public void a(Class<? extends Thread> paramClass, AppInterface paramAppInterface, ArrayList<TroopClipPic> paramArrayList, String paramString1, String paramString2, String paramString3, HashMap<String, String> paramHashMap)
  {
    ThreadManager.executeOnNetWorkThread(new TroopAvatarManger.1(this, paramAppInterface, paramString1, paramString3, paramString2, (UploadingTask)jdField_a_of_type_JavaUtilMap.get(this.f), paramClass, paramArrayList, paramHashMap));
  }
  
  public void a(String paramString)
  {
    ITroopAvatarHandler localITroopAvatarHandler = this.jdField_a_of_type_ComTencentMobileqqTroopApiHandlerITroopAvatarHandler;
    if (localITroopAvatarHandler != null) {
      localITroopAvatarHandler.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt, ArrayList<Integer> paramArrayList)
  {
    ITroopAvatarHandler localITroopAvatarHandler = this.jdField_a_of_type_ComTencentMobileqqTroopApiHandlerITroopAvatarHandler;
    if (localITroopAvatarHandler != null) {
      localITroopAvatarHandler.a(paramString, paramInt, paramArrayList);
    }
  }
  
  public void a(Observer paramObserver)
  {
    ((UploadingTask)jdField_a_of_type_JavaUtilMap.get(this.f)).addObserver(paramObserver);
  }
  
  public void b(Observer paramObserver)
  {
    ((UploadingTask)jdField_a_of_type_JavaUtilMap.get(this.f)).a(paramObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopAvatarManger
 * JD-Core Version:    0.7.0.1
 */