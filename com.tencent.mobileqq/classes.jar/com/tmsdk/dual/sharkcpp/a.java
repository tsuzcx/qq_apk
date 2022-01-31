package com.tmsdk.dual.sharkcpp;

import android.text.TextUtils;
import com.tmsdk.dual.sharkcpp.callback.SharkCallbackPullCloudCmd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tmsdkdual.h;
import tmsdkdual.m;

public class a
{
  private static a K = null;
  private volatile boolean L = false;
  private ArrayList<Integer> M = new ArrayList();
  private Object mLock = new Object();
  
  public static a o()
  {
    if (K == null) {}
    try
    {
      if (K == null) {
        K = new a();
      }
      return K;
    }
    finally {}
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, List<String> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      try
      {
        if (paramList.size() > 0) {
          switch (paramInt1)
          {
          case 962: 
            paramInt1 = Integer.parseInt((String)paramList.get(0));
            tmsdkdual.a.b().a("sr_g", paramInt1);
            m.b("CloudManager", "receive cloud cmd:ECMD_ID_SOFT_UP");
            return;
          }
        }
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
        return;
      }
    }
    h.a(paramList);
    m.b("CloudManager", "receive cloud cmd:ECMD_ID_SOFT_UP");
    return;
    paramList = (String)paramList.get(0);
    tmsdkdual.a.b().a("NET_GET_PHONE_FILTER_IPS", paramList);
    m.b("CloudManager", "receive cloud cmd:ECMD_ID_IP_FILTER");
    return;
    if (paramList.size() >= 2)
    {
      str1 = (String)paramList.get(1);
      if (!TextUtils.isEmpty(str1)) {
        tmsdkdual.a.b().a("kc_f_t_k", str1);
      }
    }
    if (paramList.size() >= 3)
    {
      str1 = (String)paramList.get(2);
      if (!TextUtils.isEmpty(str1)) {
        tmsdkdual.a.b().a("kc_f_t_u_p", str1);
      }
    }
    m.b("CloudManager", "receive cloud cmd : ECMD_KING_CARD_CHECK_ORDER, params:" + paramList);
    return;
    String str1 = (String)paramList.get(0);
    tmsdkdual.a.b().a("CLOUD_MNC_FILTER", str1);
    m.b("CloudManager", "receive cloud cmd : ECMD_MNC_FILTER_EXTEND, params:" + paramList);
    return;
    String str5 = (String)paramList.get(0);
    String str4 = (String)paramList.get(1);
    String str2 = (String)paramList.get(2);
    String str3 = (String)paramList.get(3);
    str1 = (String)paramList.get(4);
    boolean bool = TextUtils.isEmpty(str5);
    if (!bool) {}
    try
    {
      tmsdkdual.a.b().a("PN_CTR_FETCH_SUC_INTERVAL_CLOUD", Long.parseLong(str5));
      label449:
      bool = TextUtils.isEmpty(str4);
      if (!bool) {}
      try
      {
        tmsdkdual.a.b().a("PN_CTR_FETCH_FAIL_INTERVAL_CLOUD", Long.parseLong(str4));
        label475:
        if (!TextUtils.isEmpty(str2)) {
          tmsdkdual.a.b().a("PN_CTR_FAIL_RESULT_SET_CLOUD", str2);
        }
        bool = TextUtils.isEmpty(str3);
        if (!bool) {}
        try
        {
          tmsdkdual.a.b().a("PN_CTR_FETCH_SUC_NOT_ADAPTER_INTERVAL_CLOUD", Long.parseLong(str3));
          label520:
          bool = TextUtils.isEmpty(str1);
          if (!bool) {}
          try
          {
            tmsdkdual.a.b().a("PN_CTR_TOTAL_INTERVAL_CLOUD", Long.parseLong(str1));
            label546:
            m.b("CloudManager", "receive cloud cmd : ECMD_PN_CTR_CONFIGS, params:" + paramList);
            return;
            str1 = (String)paramList.get(0);
            str2 = (String)paramList.get(1);
            str3 = (String)paramList.get(2);
            if (!TextUtils.isEmpty(str1)) {
              tmsdkdual.a.b().a("KC_CTR_FETCH_INTERVAL_CLOUD", Long.parseLong(str1));
            }
            if (!TextUtils.isEmpty(str2)) {
              tmsdkdual.a.b().a("KC_CTR_RESULT_SETTING", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
              tmsdkdual.a.b().a("KC_CTR_OPEN", "1".equals(str3));
            }
            m.b("CloudManager", "receive cloud cmd : ECMD_KC_CTR_CONFIGS, params:" + paramList);
            return;
            str1 = (String)paramList.get(0);
            str2 = (String)paramList.get(1);
            if ((!TextUtils.isEmpty(str1)) && ("1".equals(str1)))
            {
              tmsdkdual.a.b().a("PN_LAST_FETCH_TIME", 0L);
              tmsdkdual.a.b().a("PN_LAST_FATCH_RESULT", -1);
              tmsdkdual.a.b().a("NET_GET_NUMBER_CACHE", null);
              tmsdkdual.a.b().a("KC_CTR_LAST_FETCH_TIME", 0L);
              tmsdkdual.a.b().a("KC_CTR_RESULT_CACHE", -1);
              tmsdkdual.a.b().a("KC_CTR_LAST_PHONE_NUMBER", null);
              tmsdkdual.a.b().a("KC_CTR_CODE_CACHE", -1);
            }
            if (!TextUtils.isEmpty(str2)) {
              tmsdkdual.a.b().a("IS_CLEAR_CTR", "1".equals(str2));
            }
            if (paramList.size() >= 3)
            {
              str1 = (String)paramList.get(2);
              if (!TextUtils.isEmpty(str1)) {
                tmsdkdual.a.b().a("IS_CLEAR_CTR_N", "1".equals(str1));
              }
            }
            if (paramList.size() >= 4)
            {
              str1 = (String)paramList.get(3);
              bool = TextUtils.isEmpty(str1);
              if (bool) {}
            }
            try
            {
              tmsdkdual.a.b().a("IS_CLEAR_CTR_INTERVAL", Long.parseLong(str1));
              label938:
              m.b("CloudManager", "receive cloud cmd : ECMD_CTR_CLEAR_SWITCH, params:" + paramList);
              return;
              str1 = (String)paramList.get(0);
              str2 = (String)paramList.get(1);
              str3 = (String)paramList.get(2);
              str4 = (String)paramList.get(3);
              str5 = (String)paramList.get(4);
              if (!TextUtils.isEmpty(str1)) {
                tmsdkdual.a.b().a("r_drsn", "1".equals(str1));
              }
              if (!TextUtils.isEmpty(str2)) {
                tmsdkdual.a.b().a("r_drsn", "1".equals(str2));
              }
              if (!TextUtils.isEmpty(str3)) {
                tmsdkdual.a.b().a("r_drss", "1".equals(str3));
              }
              if (!TextUtils.isEmpty(str4)) {
                tmsdkdual.a.b().a("r_dri", Integer.parseInt(str4));
              }
              if (!TextUtils.isEmpty(str5)) {
                tmsdkdual.a.b().a("r_drcito", "1".equals(str5));
              }
              m.b("CloudManager", "receive cloud cmd : ECMD_KC_DAILY_REPORT_CONF, params:" + paramList);
              return;
              str1 = (String)paramList.get(0);
              str2 = (String)paramList.get(1);
              if (!TextUtils.isEmpty(str1)) {
                tmsdkdual.a.b().a("r_nprinterval", Long.parseLong(str1));
              }
              if (!TextUtils.isEmpty(str2)) {
                tmsdkdual.a.b().a("r_nprpc", str2);
              }
              str1 = (String)paramList.get(2);
              str2 = (String)paramList.get(3);
              if (!TextUtils.isEmpty(str1)) {
                tmsdkdual.a.b().a("r_kcrintval", Long.parseLong(str1));
              }
              if (!TextUtils.isEmpty(str2)) {
                tmsdkdual.a.b().a("r_kcrpc", str2);
              }
              m.b("CloudManager", "receive cloud cmd : ECMD_NET_PHONE_REPORT_CONF, params:" + paramList);
              return;
            }
            catch (Exception localException1)
            {
              break label938;
            }
          }
          catch (Exception localException2)
          {
            break label546;
          }
        }
        catch (Exception localException3)
        {
          break label520;
        }
      }
      catch (Exception localException4)
      {
        break label475;
      }
    }
    catch (Exception localException5)
    {
      break label449;
    }
  }
  
  public void f(int paramInt)
  {
    if (!tmsdkdual.a.b().a(paramInt)) {
      return;
    }
    SharkCppProxy.pullCloudCmdAsyn(paramInt, new SharkCallbackPullCloudCmd()
    {
      public void onFinish(int paramAnonymousInt1, long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt2, int paramAnonymousInt3, List<String> paramAnonymousList)
      {
        if (paramAnonymousInt1 != 0) {
          return;
        }
        tmsdkdual.a.b().a("lpt" + paramAnonymousInt2, System.currentTimeMillis());
        a.this.a(paramAnonymousLong1, paramAnonymousLong2, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousList);
      }
    });
  }
  
  public void init()
  {
    synchronized (this.mLock)
    {
      if (!this.L)
      {
        this.M.add(Integer.valueOf(962));
        this.M.add(Integer.valueOf(1589));
        this.M.add(Integer.valueOf(6028));
        this.M.add(Integer.valueOf(6032));
        this.M.add(Integer.valueOf(6034));
        this.M.add(Integer.valueOf(6039));
        this.M.add(Integer.valueOf(6041));
        this.M.add(Integer.valueOf(6040));
        this.M.add(Integer.valueOf(6047));
        this.M.add(Integer.valueOf(6048));
        this.L = true;
      }
      return;
    }
  }
  
  public void p()
  {
    init();
    synchronized (this.mLock)
    {
      Iterator localIterator = this.M.iterator();
      if (localIterator.hasNext()) {
        f(((Integer)localIterator.next()).intValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tmsdk.dual.sharkcpp.a
 * JD-Core Version:    0.7.0.1
 */