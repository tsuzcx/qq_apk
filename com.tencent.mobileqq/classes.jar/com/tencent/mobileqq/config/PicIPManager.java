package com.tencent.mobileqq.config;

import ConfigPush.DomainIpChannel;
import ConfigPush.DomainIpInfo;
import ConfigPush.DomainIpList;
import ConfigPush.FileStoragePushFSSvcList;
import ConfigPush.FileStorageServerListInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PicIPManager
{
  public static final String[][] a;
  private static boolean[] b;
  private static String[] c;
  private static String[] d;
  private static Hashtable<String, ArrayList<String>>[] e;
  
  static
  {
    int k = 8;
    int i = 0;
    String[] arrayOfString1 = { "p_qlogo_cn_2g", "p_qlogo_cn_3g", "p_plogo_cn_4g", "p_plogo_cn_wifi" };
    String[] arrayOfString2 = { "pgdt_gtimg_cn_2g", "pgdt_gtimg_cn_3g", "pgdt_gtimg_cn_4g", "pgdt_gtimg_cn_wifi" };
    String[] arrayOfString3 = { "sqimg_qq_com_2g", "sqimg_qq_com_3g", "sqimg_qq_com_4g", "sqimg_qq_com_wifi" };
    String[] arrayOfString4 = { "download_wegame_qq_com_2g", "download_wegame_qq_com_3g", "download_wegame_qq_com_4g", "download_wegame_qq_com_wifi" };
    a = new String[][] { { "q_qlogo_cn_2g", "q_qlogo_cn_3g", "q_qlogo_cn_4g", "q_qlogo_cn_wifi" }, arrayOfString1, { "p_qpic_cn_2g", "p_qpic_cn_3g", "p_qpic_cn_4g", "p_qpic_cn_wifi" }, arrayOfString2, arrayOfString3, arrayOfString4, { "wfqqreader_3g_qq_cn_2g", "wfqqreader_3g_qq_cn_3g", "wfqqreader_3g_qq_cn_4g", "wfqqreader_3g_qq_cn_wifi" }, { "buluo_qq_com_2g", "buluo_qq_com_3g", "buluo_qq_com_4g", "buluo_qq_com_wifi" } };
    b = new boolean[13];
    c = new String[14];
    d = new String[14];
    e = new Hashtable[11];
    int j;
    for (;;)
    {
      j = k;
      if (i > 7) {
        break;
      }
      e[i] = new Hashtable(4);
      i += 1;
    }
    while (j < 11)
    {
      e[j] = new Hashtable(3);
      j += 1;
    }
  }
  
  public static String a(int paramInt)
  {
    int i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    if (i == 1)
    {
      i = 3;
    }
    else if (i == 2)
    {
      i = 0;
    }
    else if (i == 3)
    {
      i = 1;
    }
    else
    {
      if (i != 4) {
        break label376;
      }
      i = 2;
    }
    if ((a[paramInt][i].equals(d[paramInt])) && (!TextUtils.isEmpty(c[paramInt]))) {
      return c[paramInt];
    }
    int j;
    if (b[paramInt] == 0)
    {
      localObject1 = BaseApplication.getContext().getSharedPreferences("QQHeadIPList", 4);
      if (localObject1 == null) {
        return null;
      }
      j = 0;
      while (j <= 3)
      {
        String str = ((SharedPreferences)localObject1).getString(a[paramInt][j], null);
        if (!TextUtils.isEmpty(str))
        {
          Object localObject2 = str.split("\\|");
          if ((localObject2 != null) && (localObject2.length > 0))
          {
            ArrayList localArrayList = new ArrayList();
            int k = 0;
            while (k < localObject2.length)
            {
              localArrayList.add(localObject2[k]);
              k += 1;
            }
            e[paramInt].put(a[paramInt][j], localArrayList);
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getIpList array=");
            ((StringBuilder)localObject2).append(str);
            QLog.i("PicIPManager", 2, ((StringBuilder)localObject2).toString());
          }
        }
        j += 1;
      }
      b[paramInt] = true;
    }
    Object localObject1 = (ArrayList)e[paramInt].get(a[paramInt][i]);
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      double d1 = Math.random();
      double d2 = ((ArrayList)localObject1).size();
      Double.isNaN(d2);
      j = (int)(d1 * d2);
      c[paramInt] = ((String)((ArrayList)localObject1).get(j));
      d[paramInt] = a[paramInt][i];
    }
    return c[paramInt];
    label376:
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getIpList netType unknown netType=");
    ((StringBuilder)localObject1).append(i);
    QLog.i("PicIPManager", 1, ((StringBuilder)localObject1).toString());
    return null;
  }
  
  public static String a(int paramInt, String paramString)
  {
    String str = String.valueOf(DeviceInfoUtil.X());
    if ((str.equals(d[paramInt])) && (!TextUtils.isEmpty(c[paramInt]))) {
      return c[paramInt];
    }
    Object localObject1;
    if (b[paramInt] == 0)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getQzoneIp ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.i("PicIPManager", 2, ((StringBuilder)localObject1).toString());
      }
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      if (paramInt == 10) {
        localObject1 = ".*qzonestyle.gtimg.cn";
      } else if (paramInt == 8) {
        localObject1 = "ugc.qpic.cn";
      } else if (paramInt == 9) {
        localObject1 = "a[0-9].qpic.cn";
      } else if (paramInt == 11) {
        localObject1 = ".*qzs.qq.com";
      } else {
        localObject1 = "";
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return null;
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString).getJSONArray((String)localObject1);
        i = 0;
        if (i < paramString.length())
        {
          Object localObject2 = paramString.getJSONObject(i);
          localObject1 = ((JSONObject)localObject2).getString("apn");
          localObject2 = ((JSONObject)localObject2).getString("ip");
          ArrayList localArrayList = (ArrayList)e[paramInt].get(localObject1);
          if (localArrayList == null)
          {
            localArrayList = new ArrayList();
            localArrayList.add(localObject2);
            e[paramInt].put(localObject1, localArrayList);
            break label376;
          }
          localArrayList.add(localObject2);
          break label376;
        }
        b[paramInt] = true;
      }
      catch (JSONException paramString)
      {
        if (QLog.isDevelopLevel()) {
          paramString.printStackTrace();
        }
      }
      paramString = (ArrayList)e[paramInt].get(str);
      if ((paramString != null) && (!paramString.isEmpty()))
      {
        double d1 = Math.random();
        double d2 = paramString.size();
        Double.isNaN(d2);
        i = (int)(d1 * d2);
        c[paramInt] = ((String)paramString.get(i));
        d[paramInt] = str;
        return c[paramInt];
      }
      return null;
      label376:
      i += 1;
    }
  }
  
  public static String a(ArrayList<FileStorageServerListInfo> paramArrayList)
  {
    String str = String.valueOf(NetworkUtil.getSystemNetwork(BaseApplication.getContext()));
    if ((str.equals(d[12])) && (!TextUtils.isEmpty(c[12]))) {
      return c[12];
    }
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return null;
      }
      double d1 = Math.random();
      double d2 = paramArrayList.size();
      Double.isNaN(d2);
      paramArrayList = (FileStorageServerListInfo)paramArrayList.get((int)(d1 * d2 + 1.0D));
      if (paramArrayList == null) {
        return null;
      }
      d[12] = str;
      c[12] = paramArrayList.sIP;
      return c[12];
    }
    return null;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PicIPManager", 2, "resetInitedFlag.");
    }
    int i = 0;
    while (i <= 7)
    {
      b[i] = false;
      i += 1;
    }
  }
  
  public static boolean a(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    int i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    int j;
    if (i == 1)
    {
      j = 3;
    }
    else if (i == 2)
    {
      j = 0;
    }
    else if (i == 3)
    {
      j = 1;
    }
    else
    {
      if (i != 4) {
        break label791;
      }
      j = 2;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("saveQQHeadIpList netType=");
      ((StringBuilder)localObject1).append(i);
      QLog.i("PicIPManager", 2, ((StringBuilder)localObject1).toString());
    }
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("QQHeadIPList", 4);
    if (localSharedPreferences != null) {
      localObject1 = localSharedPreferences.edit();
    } else {
      localObject1 = null;
    }
    i = 0;
    Object localObject2;
    while (i <= 7)
    {
      localObject2 = (ArrayList)e[i].get(Integer.valueOf(j));
      if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty())) {
        ((ArrayList)localObject2).clear();
      }
      if (localObject1 != null) {
        ((SharedPreferences.Editor)localObject1).putString(a[i][j], "");
      }
      c[i] = null;
      d[i] = null;
      i += 1;
    }
    if (localObject1 != null) {
      ((SharedPreferences.Editor)localObject1).commit();
    }
    if ((paramFileStoragePushFSSvcList != null) && (paramFileStoragePushFSSvcList.domainIpChannel != null) && (paramFileStoragePushFSSvcList.domainIpChannel.vDomain_iplists != null))
    {
      paramFileStoragePushFSSvcList = paramFileStoragePushFSSvcList.domainIpChannel.vDomain_iplists.iterator();
      while (paramFileStoragePushFSSvcList.hasNext())
      {
        localObject1 = (DomainIpList)paramFileStoragePushFSSvcList.next();
        if ((((DomainIpList)localObject1).vIplist != null) && (((DomainIpList)localObject1).vIplist.size() != 0))
        {
          localObject2 = new StringBuilder();
          i = 0;
          while (i < ((DomainIpList)localObject1).vIplist.size())
          {
            ((StringBuilder)localObject2).append(NetworkUtil.intAddr2Ip(((DomainIpInfo)((DomainIpList)localObject1).vIplist.get(i)).uIp));
            if (i < ((DomainIpList)localObject1).vIplist.size() - 1) {
              ((StringBuilder)localObject2).append("|");
            }
            i += 1;
          }
          Object localObject3;
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("saveQQHeadIpList.uDomain_type=");
            ((StringBuilder)localObject3).append(((DomainIpList)localObject1).uDomain_type);
            ((StringBuilder)localObject3).append(".strBuilder=");
            ((StringBuilder)localObject3).append(((StringBuilder)localObject2).toString());
            QLog.i("PicIPManager", 2, ((StringBuilder)localObject3).toString());
          }
          if (((DomainIpList)localObject1).uDomain_type == 8)
          {
            i = 0;
          }
          else if (((DomainIpList)localObject1).uDomain_type == 9)
          {
            i = 1;
          }
          else if (((DomainIpList)localObject1).uDomain_type == 10)
          {
            i = 2;
          }
          else if (((DomainIpList)localObject1).uDomain_type == 11)
          {
            i = 3;
          }
          else if (((DomainIpList)localObject1).uDomain_type == 12)
          {
            i = 4;
          }
          else if (((DomainIpList)localObject1).uDomain_type == 13)
          {
            i = 5;
          }
          else if (((DomainIpList)localObject1).uDomain_type == 14)
          {
            i = 6;
          }
          else
          {
            if (((DomainIpList)localObject1).uDomain_type != 15) {
              continue;
            }
            i = 7;
          }
          if ((((DomainIpList)localObject1).vIplist != null) && (((DomainIpList)localObject1).vIplist.size() != 0))
          {
            localObject2 = new StringBuilder();
            localObject3 = new ArrayList();
            int k = 0;
            while (k < ((DomainIpList)localObject1).vIplist.size())
            {
              String str = NetworkUtil.intAddr2Ip(((DomainIpInfo)((DomainIpList)localObject1).vIplist.get(k)).uIp);
              ((ArrayList)localObject3).add(str);
              ((StringBuilder)localObject2).append(str);
              if (k < ((DomainIpList)localObject1).vIplist.size() - 1) {
                ((StringBuilder)localObject2).append("|");
              }
              k += 1;
            }
            e[i].put(a[i][j], localObject3);
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("saveQQHeadIpList.sIpList=");
              ((StringBuilder)localObject1).append(localObject3);
              ((StringBuilder)localObject1).append(",sb=");
              ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
              QLog.i("PicIPManager", 2, ((StringBuilder)localObject1).toString());
            }
            if (localSharedPreferences != null) {
              localSharedPreferences.edit().putString(a[i][j], ((StringBuilder)localObject2).toString()).commit();
            }
          }
        }
      }
    }
    return true;
    label791:
    paramFileStoragePushFSSvcList = new StringBuilder();
    paramFileStoragePushFSSvcList.append("saveQQHeadIpList netType unknown netType=");
    paramFileStoragePushFSSvcList.append(i);
    QLog.i("PicIPManager", 1, paramFileStoragePushFSSvcList.toString());
    return false;
  }
  
  public static String b(ArrayList<FileStorageServerListInfo> paramArrayList)
  {
    String str = String.valueOf(NetworkUtil.getSystemNetwork(BaseApplication.getContext()));
    if ((str.equals(d[13])) && (!TextUtils.isEmpty(c[13]))) {
      return c[13];
    }
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return null;
      }
      double d1 = Math.random();
      double d2 = paramArrayList.size();
      Double.isNaN(d2);
      paramArrayList = (FileStorageServerListInfo)paramArrayList.get((int)(d1 * d2 + 1.0D));
      if (paramArrayList == null) {
        return null;
      }
      d[13] = str;
      c[13] = paramArrayList.sIP;
      return c[13];
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.PicIPManager
 * JD-Core Version:    0.7.0.1
 */