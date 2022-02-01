package com.tencent.mobileqq.qqgift.api.impl.service;

import android.text.TextUtils;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.gift.common.gift_data.nano.CornerIcon;
import com.tencent.gift.common.gift_data.nano.ExtData;
import com.tencent.gift.common.gift_data.nano.FreeInfo;
import com.tencent.gift.common.gift_data.nano.GiftData;
import com.tencent.gift.gift_info_svr.nano.GetGiftDetailReq;
import com.tencent.gift.gift_info_svr.nano.GetGiftDetailRsp;
import com.tencent.gift.gift_info_svr.nano.GetGiftListReq;
import com.tencent.gift.gift_info_svr.nano.GetGiftListRsp;
import com.tencent.gift.gift_info_svr.nano.GiftListInfo;
import com.tencent.gift.gift_trans_svr.gift_trans_svr.nano.GetBalanceReq;
import com.tencent.gift.gift_trans_svr.gift_trans_svr.nano.GetBalanceRsp;
import com.tencent.gift.gift_trans_svr.gift_trans_svr.nano.SendGiftOverReq;
import com.tencent.gift.gift_trans_svr.gift_trans_svr.nano.SendGiftReq;
import com.tencent.gift.gift_trans_svr.gift_trans_svr.nano.SendGiftRsp;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftServiceModule;
import com.tencent.mobileqq.qqgift.callback.service.IQQGiftBalanceCallback;
import com.tencent.mobileqq.qqgift.callback.service.IQQGiftDetailCallback;
import com.tencent.mobileqq.qqgift.callback.service.IQQGiftListCallback;
import com.tencent.mobileqq.qqgift.callback.service.IQQGiftSendCallback;
import com.tencent.mobileqq.qqgift.data.QQGiftComboReqMapData;
import com.tencent.mobileqq.qqgift.data.service.GiftListData;
import com.tencent.mobileqq.qqgift.data.service.GiftSendReqData;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData.CornerIcon;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData.FreeInfo;
import com.tencent.mobileqq.qqgift.sdk.config.QQGiftSDKConfig;
import com.tencent.mobileqq.qqgift.sso.IQQGiftSsoModule;
import com.tencent.mobileqq.qqgift.sso.QQGiftRspData;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class QQGiftServiceModuleImpl
  implements IQQGiftServiceModule
{
  private IQQGiftSDK a;
  private int b = 0;
  private GiftSendReqData c;
  private final HashMap<String, QQGiftPanelCache> d = new HashMap();
  private ConcurrentHashMap<Long, QQGiftComboReqMapData> e = null;
  
  private String a(IQQGiftSendCallback paramIQQGiftSendCallback, SendGiftReq paramSendGiftReq, String paramString)
  {
    String str = this.a.c().b;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.a.c().a);
    ((StringBuilder)localObject1).append("&");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = localObject2;
    if (paramSendGiftReq.b != 0L)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(paramSendGiftReq.b);
      ((StringBuilder)localObject1).append("&");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = localObject1;
    if (paramSendGiftReq.c != 0L)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(paramSendGiftReq.c);
      ((StringBuilder)localObject2).append("&");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    localObject1 = localObject2;
    if (paramSendGiftReq.d != 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(paramSendGiftReq.d);
      ((StringBuilder)localObject1).append("&");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = localObject1;
    if (paramSendGiftReq.e != 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(paramSendGiftReq.e);
      ((StringBuilder)localObject2).append("&");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("&");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    paramString = (String)localObject1;
    if (paramSendGiftReq.h != 0L)
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject1);
      paramString.append(paramSendGiftReq.h);
      paramString.append("&");
      paramString = paramString.toString();
    }
    localObject1 = paramString;
    if (paramSendGiftReq.i != 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(paramSendGiftReq.i);
      ((StringBuilder)localObject1).append("&");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    paramString = (String)localObject1;
    if (paramSendGiftReq.j != 0)
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject1);
      paramString.append(paramSendGiftReq.j);
      paramString.append("&");
      paramString = paramString.toString();
    }
    paramSendGiftReq = paramString;
    if (!TextUtils.isEmpty(str))
    {
      paramSendGiftReq = new StringBuilder();
      paramSendGiftReq.append(paramString);
      paramSendGiftReq.append(str);
      paramSendGiftReq.append("&");
      paramSendGiftReq = paramSendGiftReq.toString();
    }
    try
    {
      paramSendGiftReq = MD5Utils.encodeHexStr(paramSendGiftReq).toLowerCase();
      return paramSendGiftReq;
    }
    catch (Exception paramSendGiftReq)
    {
      a(paramIQQGiftSendCallback, -1, "appSecretKey encode fail");
      paramSendGiftReq.printStackTrace();
    }
    return "";
  }
  
  private void a(long paramLong, GiftListData paramGiftListData, ArrayList<GiftServiceData> paramArrayList)
  {
    if ((paramGiftListData != null) && (paramArrayList != null))
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      synchronized (this.d)
      {
        String str = paramGiftListData.a(e());
        Object localObject = (QQGiftPanelCache)this.d.get(str);
        paramGiftListData = (GiftListData)localObject;
        if (localObject == null)
        {
          localObject = this.d;
          paramGiftListData = new QQGiftPanelCache();
          ((HashMap)localObject).put(str, paramGiftListData);
        }
        localObject = paramGiftListData.b;
        if (localObject == null)
        {
          localObject = new ArrayList();
          paramGiftListData.b = ((List)localObject);
        }
        else
        {
          ((List)localObject).clear();
        }
        ((List)localObject).addAll(paramArrayList);
        paramGiftListData.a = paramLong;
        return;
      }
    }
  }
  
  private void a(long paramLong, boolean paramBoolean, QQGiftRspData paramQQGiftRspData, IQQGiftSendCallback paramIQQGiftSendCallback)
  {
    Object localObject = this.e;
    if ((localObject != null) && (((ConcurrentHashMap)localObject).containsKey(Long.valueOf(paramLong))))
    {
      localObject = (QQGiftComboReqMapData)this.e.get(Long.valueOf(paramLong));
      if ((localObject != null) && (((QQGiftComboReqMapData)localObject).a.decrementAndGet() == 0) && (((QQGiftComboReqMapData)localObject).b != null))
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQGiftServiceModuleImpl", 1, "onReceiveSendComboGift unConsume = 0, overReq != null, doSendComboOver...");
        }
        this.e.remove(Long.valueOf(paramLong));
        a(((QQGiftComboReqMapData)localObject).b);
      }
    }
    if (paramBoolean)
    {
      if ((paramQQGiftRspData != null) && (paramQQGiftRspData.a() != null))
      {
        if (paramQQGiftRspData.c() != 0)
        {
          if (paramQQGiftRspData.c() == -11008)
          {
            a(paramIQQGiftSendCallback, -11008, paramQQGiftRspData.e());
            return;
          }
          a(paramIQQGiftSendCallback, paramQQGiftRspData.c(), paramQQGiftRspData.e());
          return;
        }
        try
        {
          a(paramIQQGiftSendCallback, SendGiftRsp.a(paramQQGiftRspData.a()));
          return;
        }
        catch (InvalidProtocolBufferNanoException paramQQGiftRspData)
        {
          a(paramIQQGiftSendCallback, -1, "SendGiftRsp get open info fail");
          paramIQQGiftSendCallback = new StringBuilder();
          paramIQQGiftSendCallback.append("SendGiftRsp error:");
          paramIQQGiftSendCallback.append(paramQQGiftRspData.getMessage());
          QLog.e("QQGiftServiceModuleImpl", 1, paramIQQGiftSendCallback.toString());
          return;
        }
      }
      a(paramIQQGiftSendCallback, -1, "the data is null");
    }
  }
  
  private void a(SendGiftOverReq paramSendGiftOverReq)
  {
    if (paramSendGiftOverReq == null)
    {
      QLog.e("QQGiftServiceModuleImpl", 1, "doSendComboOver req is null!");
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doSendComboOver giftId:");
      localStringBuilder.append(paramSendGiftOverReq.d);
      localStringBuilder.append(", seq:");
      localStringBuilder.append(paramSendGiftOverReq.f);
      QLog.d("QQGiftServiceModuleImpl", 2, localStringBuilder.toString());
    }
    ((IQQGiftSsoModule)this.a.a("sso_module")).a("trpc.qlive.gift_trans_svr.GiftTrans", "SendGiftOver", MessageNano.toByteArray(paramSendGiftOverReq), new QQGiftServiceModuleImpl.6(this));
  }
  
  private void a(IQQGiftBalanceCallback paramIQQGiftBalanceCallback, int paramInt, String paramString)
  {
    if (paramIQQGiftBalanceCallback != null) {
      paramIQQGiftBalanceCallback.a(paramInt, paramString);
    }
    if (QLog.isColorLevel())
    {
      paramIQQGiftBalanceCallback = new StringBuilder();
      paramIQQGiftBalanceCallback.append("giftSendCallback code ");
      paramIQQGiftBalanceCallback.append(paramInt);
      QLog.d("QQGiftServiceModuleImpl", 2, paramIQQGiftBalanceCallback.toString());
    }
  }
  
  private void a(IQQGiftBalanceCallback paramIQQGiftBalanceCallback, GetBalanceRsp paramGetBalanceRsp, long paramLong)
  {
    if (paramIQQGiftBalanceCallback != null) {
      paramIQQGiftBalanceCallback.a(paramGetBalanceRsp.a, paramLong);
    }
  }
  
  private void a(IQQGiftDetailCallback paramIQQGiftDetailCallback, int paramInt, String paramString)
  {
    if (paramIQQGiftDetailCallback != null) {
      paramIQQGiftDetailCallback.a(paramInt, paramString);
    }
    if (QLog.isColorLevel())
    {
      paramIQQGiftDetailCallback = new StringBuilder();
      paramIQQGiftDetailCallback.append(" giftDetailCallback code ");
      paramIQQGiftDetailCallback.append(paramInt);
      QLog.d("QQGiftServiceModuleImpl", 2, paramIQQGiftDetailCallback.toString());
    }
  }
  
  private void a(IQQGiftDetailCallback paramIQQGiftDetailCallback, GetGiftDetailRsp paramGetGiftDetailRsp)
  {
    GiftServiceData localGiftServiceData = new GiftServiceData();
    localGiftServiceData.a = paramGetGiftDetailRsp.a.a;
    localGiftServiceData.b = paramGetGiftDetailRsp.a.b;
    localGiftServiceData.c = paramGetGiftDetailRsp.a.c;
    localGiftServiceData.d = paramGetGiftDetailRsp.a.d;
    localGiftServiceData.e = paramGetGiftDetailRsp.a.e;
    localGiftServiceData.f = paramGetGiftDetailRsp.a.f;
    if (paramIQQGiftDetailCallback != null) {
      paramIQQGiftDetailCallback.a(localGiftServiceData);
    }
  }
  
  private void a(IQQGiftListCallback paramIQQGiftListCallback, int paramInt, String paramString)
  {
    if (paramIQQGiftListCallback != null) {
      paramIQQGiftListCallback.a(paramInt, paramString);
    }
    if (QLog.isColorLevel())
    {
      paramIQQGiftListCallback = new StringBuilder();
      paramIQQGiftListCallback.append(" giftListCallback code ");
      paramIQQGiftListCallback.append(paramInt);
      QLog.d("QQGiftServiceModuleImpl", 2, paramIQQGiftListCallback.toString());
    }
  }
  
  private void a(IQQGiftListCallback paramIQQGiftListCallback, GetGiftListRsp paramGetGiftListRsp, GiftListData paramGiftListData)
  {
    Object localObject = a(paramGiftListData);
    long l = b(paramGiftListData);
    if ((l == paramGetGiftListRsp.c) && (l != 0L) && (localObject != null) && (!((List)localObject).isEmpty()))
    {
      if (paramIQQGiftListCallback != null) {
        paramIQQGiftListCallback.a((List)localObject);
      }
      return;
    }
    this.b = paramGetGiftListRsp.d;
    localObject = new ArrayList();
    GiftData[] arrayOfGiftData = paramGetGiftListRsp.b;
    int j = arrayOfGiftData.length;
    int i = 0;
    while (i < j)
    {
      GiftData localGiftData = arrayOfGiftData[i];
      GiftServiceData localGiftServiceData = new GiftServiceData();
      localGiftServiceData.a = localGiftData.a;
      localGiftServiceData.b = localGiftData.b;
      localGiftServiceData.c = localGiftData.c;
      localGiftServiceData.d = localGiftData.d;
      localGiftServiceData.e = localGiftData.e;
      localGiftServiceData.f = localGiftData.f;
      localGiftServiceData.g = localGiftData.g;
      localGiftServiceData.j = localGiftData.h;
      localGiftServiceData.getClass();
      localGiftServiceData.k = new GiftServiceData.CornerIcon(localGiftServiceData);
      if (localGiftData.i != null)
      {
        localGiftServiceData.k.a = localGiftData.i.a;
        localGiftServiceData.k.b = localGiftData.i.b;
        localGiftServiceData.k.c = localGiftData.i.c;
      }
      localGiftServiceData.getClass();
      localGiftServiceData.l = new GiftServiceData.FreeInfo(localGiftServiceData);
      if (localGiftData.j != null)
      {
        localGiftServiceData.l.a = localGiftData.j.a;
        localGiftServiceData.l.b = localGiftData.j.b;
      }
      ((ArrayList)localObject).add(localGiftServiceData);
      i += 1;
    }
    if (paramIQQGiftListCallback != null) {
      paramIQQGiftListCallback.a((List)localObject);
    }
    a(paramGetGiftListRsp.c, paramGiftListData, (ArrayList)localObject);
  }
  
  private void a(IQQGiftSendCallback paramIQQGiftSendCallback, int paramInt, String paramString)
  {
    if (paramIQQGiftSendCallback != null) {
      paramIQQGiftSendCallback.a(paramInt, paramString);
    }
    if (QLog.isColorLevel())
    {
      paramIQQGiftSendCallback = new StringBuilder();
      paramIQQGiftSendCallback.append("giftSendCallback code ");
      paramIQQGiftSendCallback.append(paramInt);
      QLog.d("QQGiftServiceModuleImpl", 2, paramIQQGiftSendCallback.toString());
    }
  }
  
  private void a(IQQGiftSendCallback paramIQQGiftSendCallback, SendGiftRsp paramSendGiftRsp)
  {
    if (paramIQQGiftSendCallback != null) {
      paramIQQGiftSendCallback.a();
    }
  }
  
  private long b(GiftListData paramGiftListData)
  {
    QQGiftPanelCache localQQGiftPanelCache = (QQGiftPanelCache)this.d.get(paramGiftListData.a(e()));
    if ((paramGiftListData != null) && (localQQGiftPanelCache != null)) {
      return localQQGiftPanelCache.a;
    }
    return 0L;
  }
  
  private int e()
  {
    if (this.a.c() != null) {
      return this.a.c().a;
    }
    return 0;
  }
  
  public List<GiftServiceData> a(GiftListData paramGiftListData)
  {
    QQGiftPanelCache localQQGiftPanelCache = (QQGiftPanelCache)this.d.get(paramGiftListData.a(e()));
    if ((paramGiftListData != null) && (localQQGiftPanelCache != null)) {
      return localQQGiftPanelCache.b;
    }
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("notifyComboOver giftId:");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", comboSeq:");
      ((StringBuilder)localObject1).append(paramLong);
      QLog.d("QQGiftServiceModuleImpl", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new SendGiftOverReq();
    Object localObject3;
    if (this.c != null)
    {
      ((SendGiftOverReq)localObject1).a = this.a.c().a;
      ((SendGiftOverReq)localObject1).b = this.c.a;
      ((SendGiftOverReq)localObject1).c = this.c.b;
      ((SendGiftOverReq)localObject1).d = paramInt1;
      ((SendGiftOverReq)localObject1).e = paramInt2;
      ((SendGiftOverReq)localObject1).f = paramLong;
      ((SendGiftOverReq)localObject1).g = paramInt3;
      ((SendGiftOverReq)localObject1).h = paramInt3;
      localObject2 = new ArrayList();
      localObject3 = this.c.f.entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
        ExtData localExtData = new ExtData();
        localExtData.a = ((String)localEntry.getKey());
        localExtData.b = ((String)localEntry.getValue());
        ((ArrayList)localObject2).add(localExtData);
      }
      ((SendGiftOverReq)localObject1).i = ((ExtData[])((ArrayList)localObject2).toArray(new ExtData[((ArrayList)localObject2).size()]));
    }
    paramInt2 = 0;
    Object localObject2 = this.e;
    paramInt1 = paramInt2;
    if (localObject2 != null)
    {
      paramInt1 = paramInt2;
      if (((ConcurrentHashMap)localObject2).containsKey(Long.valueOf(paramLong)))
      {
        localObject2 = (QQGiftComboReqMapData)this.e.get(Long.valueOf(paramLong));
        if (localObject2 != null)
        {
          if (((QQGiftComboReqMapData)localObject2).a.get() == 0)
          {
            this.e.remove(Long.valueOf(paramLong));
            paramInt1 = 1;
          }
          else
          {
            ((QQGiftComboReqMapData)localObject2).b = ((SendGiftOverReq)localObject1);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("current comboSeq:");
            ((StringBuilder)localObject3).append(paramLong);
            ((StringBuilder)localObject3).append(", data:");
            ((StringBuilder)localObject3).append(localObject2);
            QLog.e("QQGiftServiceModuleImpl", 1, ((StringBuilder)localObject3).toString());
            paramInt1 = paramInt2;
          }
        }
        else
        {
          this.e.put(Long.valueOf(paramLong), new QQGiftComboReqMapData());
          paramInt1 = paramInt2;
        }
      }
    }
    if (paramInt1 == 0)
    {
      QLog.e("QQGiftServiceModuleImpl", 1, "canSendOverReq is false, wait req consume");
      return;
    }
    a((SendGiftOverReq)localObject1);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, IQQGiftSendCallback paramIQQGiftSendCallback)
  {
    SendGiftReq localSendGiftReq = new SendGiftReq();
    Object localObject1;
    if (this.c != null)
    {
      localSendGiftReq.a = this.a.c().a;
      localSendGiftReq.b = this.c.a;
      localSendGiftReq.c = this.c.b;
      localSendGiftReq.d = paramInt1;
      localSendGiftReq.e = paramInt2;
      localObject2 = this.c.a();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localSendGiftReq.g = ((String)localObject1);
      localSendGiftReq.h = paramLong;
      localSendGiftReq.i = paramInt3;
      localSendGiftReq.j = paramInt4;
      localObject2 = a(paramIQQGiftSendCallback, localSendGiftReq, this.c.a());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localSendGiftReq.f = ((String)localObject1);
      localObject1 = new ArrayList();
      localObject2 = this.c.f.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        ExtData localExtData = new ExtData();
        localExtData.a = ((String)localEntry.getKey());
        localExtData.b = ((String)localEntry.getValue());
        ((ArrayList)localObject1).add(localExtData);
      }
      localSendGiftReq.k = ((ExtData[])((ArrayList)localObject1).toArray(new ExtData[((ArrayList)localObject1).size()]));
    }
    if (paramInt5 == 1) {
      localObject1 = "trpc.qlive.gift_trans_svr_free.GiftTransFree";
    } else {
      localObject1 = "trpc.qlive.gift_trans_svr.GiftTrans";
    }
    Object localObject2 = this.e;
    if (localObject2 != null) {
      if (((ConcurrentHashMap)localObject2).containsKey(Long.valueOf(paramLong)))
      {
        localObject2 = (QQGiftComboReqMapData)this.e.get(Long.valueOf(paramLong));
        if (localObject2 != null) {
          ((QQGiftComboReqMapData)localObject2).a.incrementAndGet();
        }
      }
      else
      {
        this.e.put(Long.valueOf(paramLong), new QQGiftComboReqMapData(new AtomicInteger(1)));
      }
    }
    ((IQQGiftSsoModule)this.a.a("sso_module")).a((String)localObject1, "SendGift", GetGiftDetailReq.toByteArray(localSendGiftReq), new QQGiftServiceModuleImpl.5(this, paramLong, paramIQQGiftSendCallback));
  }
  
  public void a(int paramInt1, int paramInt2, IQQGiftSendCallback paramIQQGiftSendCallback)
  {
    SendGiftReq localSendGiftReq = new SendGiftReq();
    if (this.c != null)
    {
      localSendGiftReq.a = this.a.c().a;
      localSendGiftReq.b = this.c.a;
      localSendGiftReq.c = this.c.b;
      localSendGiftReq.d = paramInt1;
      localSendGiftReq.e = paramInt2;
      Object localObject2 = this.c.a();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localSendGiftReq.g = ((String)localObject1);
      localSendGiftReq.h = 0L;
      localSendGiftReq.i = 0;
      localSendGiftReq.j = 0;
      localObject2 = a(paramIQQGiftSendCallback, localSendGiftReq, this.c.a());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localSendGiftReq.f = ((String)localObject1);
      localObject1 = new ArrayList();
      localObject2 = this.c.f.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        ExtData localExtData = new ExtData();
        localExtData.a = ((String)localEntry.getKey());
        localExtData.b = ((String)localEntry.getValue());
        ((ArrayList)localObject1).add(localExtData);
      }
      localSendGiftReq.k = ((ExtData[])((ArrayList)localObject1).toArray(new ExtData[((ArrayList)localObject1).size()]));
    }
    ((IQQGiftSsoModule)this.a.a("sso_module")).a("trpc.qlive.gift_trans_svr.GiftTrans", "SendGift", GetGiftDetailReq.toByteArray(localSendGiftReq), new QQGiftServiceModuleImpl.4(this, paramIQQGiftSendCallback));
  }
  
  public void a(IQQGiftSDK paramIQQGiftSDK)
  {
    this.a = paramIQQGiftSDK;
    this.c = new GiftSendReqData();
    this.e = new ConcurrentHashMap();
  }
  
  public void a(IQQGiftBalanceCallback paramIQQGiftBalanceCallback)
  {
    GetBalanceReq localGetBalanceReq = new GetBalanceReq();
    localGetBalanceReq.a = this.a.c().a;
    ((IQQGiftSsoModule)this.a.a("sso_module")).a("trpc.qlive.gift_trans_svr.GiftTrans", "GetBalance", GetGiftDetailReq.toByteArray(localGetBalanceReq), 103, new QQGiftServiceModuleImpl.7(this, paramIQQGiftBalanceCallback));
  }
  
  public void a(IQQGiftListCallback paramIQQGiftListCallback)
  {
    GetGiftListReq localGetGiftListReq = new GetGiftListReq();
    localGetGiftListReq.b = this.a.c().a;
    Object localObject = (QQGiftPanelCache)this.d.get(GiftListData.a().a(e()));
    if (localObject != null) {
      localGetGiftListReq.a = ((QQGiftPanelCache)localObject).a;
    } else {
      localGetGiftListReq.a = 0L;
    }
    localGetGiftListReq.c = this.b;
    localObject = new GiftListInfo();
    ((GiftListInfo)localObject).a = 1;
    ((GiftListInfo)localObject).b = "";
    ((GiftListInfo)localObject).c = "";
    ((GiftListInfo)localObject).d = "";
    localGetGiftListReq.d = ((GiftListInfo)localObject);
    ((IQQGiftSsoModule)this.a.a("sso_module")).a("trpc.qlive.gift_info_svr.GiftInfo", "GetGiftList", GetGiftListReq.toByteArray(localGetGiftListReq), new QQGiftServiceModuleImpl.1(this, paramIQQGiftListCallback));
  }
  
  public void a(GiftListData paramGiftListData, IQQGiftListCallback paramIQQGiftListCallback)
  {
    GetGiftListReq localGetGiftListReq = new GetGiftListReq();
    Object localObject = this.a;
    if ((localObject != null) && (((IQQGiftSDK)localObject).c() != null))
    {
      localGetGiftListReq.b = this.a.c().a;
      localObject = (QQGiftPanelCache)this.d.get(paramGiftListData.a(e()));
      if (localObject != null) {
        localGetGiftListReq.a = ((QQGiftPanelCache)localObject).a;
      } else {
        localGetGiftListReq.a = 0L;
      }
      localGetGiftListReq.c = this.b;
      if (paramGiftListData != null)
      {
        localObject = new GiftListInfo();
        ((GiftListInfo)localObject).a = paramGiftListData.a;
        ((GiftListInfo)localObject).b = paramGiftListData.b;
        ((GiftListInfo)localObject).c = paramGiftListData.c;
        ((GiftListInfo)localObject).d = paramGiftListData.d;
        localGetGiftListReq.d = ((GiftListInfo)localObject);
      }
      ((IQQGiftSsoModule)this.a.a("sso_module")).a("trpc.qlive.gift_info_svr.GiftInfo", "GetGiftList", GetGiftListReq.toByteArray(localGetGiftListReq), new QQGiftServiceModuleImpl.2(this, paramIQQGiftListCallback, paramGiftListData));
      return;
    }
    QLog.e("QQGiftServiceModuleImpl", 1, "getGiftList sdkImpl or getSDKConfig is null!");
    if (paramIQQGiftListCallback != null) {
      paramIQQGiftListCallback.a(-999, "getGiftList sdkImpl or getSDKConfig is null");
    }
  }
  
  public void a(GiftSendReqData paramGiftSendReqData)
  {
    GiftSendReqData localGiftSendReqData = this.c;
    if (localGiftSendReqData != null)
    {
      localGiftSendReqData.a = paramGiftSendReqData.a;
      this.c.b = paramGiftSendReqData.b;
      this.c.e = paramGiftSendReqData.e;
      this.c.f = paramGiftSendReqData.f;
    }
  }
  
  public void b()
  {
    this.e = null;
  }
  
  public GiftSendReqData c()
  {
    return this.c;
  }
  
  public List<GiftServiceData> d()
  {
    return a(GiftListData.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.impl.service.QQGiftServiceModuleImpl
 * JD-Core Version:    0.7.0.1
 */