package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.PushParam;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.troopgag.api.ITroopGagHandler;
import com.tencent.mobileqq.troop.troopgag.api.ITroopGagHandler.GagMemberParam;
import com.tencent.mobileqq.troop.troopgag.api.ITroopGagService;
import com.tencent.mobileqq.troop.troopgag.data.GagStatus;
import com.tencent.mobileqq.troop.troopgag.data.MemberGagInfo;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.troop.troopgag.data.TroopGagInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.app.message.PushParam;>;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class TroopGagMgr
  implements Manager
{
  SharedPreferences a = null;
  public QQAppInterface b;
  Queue<Integer> c = new LinkedList();
  TroopObserver d = new TroopGagMgr.2(this);
  
  public TroopGagMgr(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
    this.a = BaseApplicationImpl.getApplication().getSharedPreferences("troop_gag_seqlist", 32768);
    paramQQAppInterface = this.a.getString("seqs", null);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.split(";");
      int j = paramQQAppInterface.length;
      int i = 0;
      while (i < j)
      {
        String str = paramQQAppInterface[i];
        try
        {
          this.c.offer(Integer.valueOf(str));
          i += 1;
        }
        finally {}
      }
    }
  }
  
  private void f(String paramString)
  {
    ((ITroopGagHandler)this.b.getBusinessHandler(BusinessHandlerFactory.TROOP_GAG_HANDLER)).a(new GagStatus(paramString, b(paramString)));
  }
  
  public SelfGagInfo a(String paramString, boolean paramBoolean)
  {
    return ((ITroopGagService)this.b.getRuntimeService(ITroopGagService.class, "")).getSelfGagInfo(paramString, paramBoolean);
  }
  
  public String a(Context paramContext, long paramLong)
  {
    return String.format(this.b.getApplication().getApplicationContext().getString(2131895376), new Object[] { b(paramContext, paramLong) });
  }
  
  public String a(Context paramContext, long paramLong1, long paramLong2)
  {
    Object localObject = this.b.getApplication().getApplicationContext();
    paramContext = ((Context)localObject).getString(2131895191);
    String str1 = ((Context)localObject).getString(2131895190);
    localObject = ((Context)localObject).getString(2131895189);
    String str2 = HardCodeUtil.a(2131912658);
    if (paramLong1 < 60L) {
      return String.format(str2, new Object[] { Integer.valueOf(1), paramContext });
    }
    if (paramLong1 <= 3540L) {
      return String.format(str2, new Object[] { Long.valueOf((paramLong1 + 57L) / 60L), paramContext });
    }
    if (paramLong1 <= 84600L) {
      return String.format(str2, new Object[] { Long.valueOf(Math.round((float)paramLong1 * 1.0F / 3600.0F)), str1 });
    }
    return String.format(str2, new Object[] { Long.valueOf(Math.round((float)paramLong1 * 1.0F / 86400.0F)), localObject });
  }
  
  public String a(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager == null) {
      return "";
    }
    paramString = localTroopManager.f(paramString);
    if (paramString == null) {
      return "";
    }
    if (paramString.isTroopOwner(this.b.getCurrentAccountUin())) {
      return "1";
    }
    return "2";
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt2)
  {
    try
    {
      Object localObject1 = this.c.iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (paramInt1 == ((Integer)((Iterator)localObject1).next()).intValue())
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("TroopGagMgr", 4, String.format("Discard message", new Object[0]));
          }
          return;
        }
      }
      if (this.c.size() > 30) {
        this.c.poll();
      }
      this.c.offer(Integer.valueOf(paramInt1));
      Object localObject2 = this.b.getApplication().getApplicationContext();
      localObject1 = String.valueOf(paramLong1);
      if (TextUtils.isEmpty(paramString))
      {
        if (paramLong3 == 0L) {
          paramString = ((Context)localObject2).getResources().getString(2131893818);
        } else {
          paramString = ((Context)localObject2).getResources().getString(2131893807);
        }
      }
      else if (paramLong3 == 0L) {
        paramString = ((Context)localObject2).getResources().getString(2131893810, new Object[] { paramString });
      } else {
        paramString = ((Context)localObject2).getResources().getString(2131893811, new Object[] { paramString, c((Context)localObject2, paramLong3) });
      }
      localObject2 = (MessageForGrayTips)MessageRecordFactory.a(-2030);
      ((MessageForGrayTips)localObject2).frienduin = ((String)localObject1);
      ((MessageForGrayTips)localObject2).init(this.b.getCurrentAccountUin(), (String)localObject1, (String)localObject1, paramString, paramLong2, -2030, 1, paramInt1);
      ((MessageForGrayTips)localObject2).isread = true;
      this.b.getMessageFacade().a((MessageRecord)localObject2, this.b.getCurrentAccountUin());
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, long paramLong3, ArrayList<PushParam> paramArrayList)
  {
    try
    {
      Object localObject1 = this.c.iterator();
      int i;
      do
      {
        bool = ((Iterator)localObject1).hasNext();
        i = 0;
        if (!bool) {
          break;
        }
      } while (paramInt != ((Integer)((Iterator)localObject1).next()).intValue());
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagMgr", 4, String.format("Discard message", new Object[0]));
      }
      return;
      if (this.c.size() > 30) {
        this.c.poll();
      }
      this.c.offer(Integer.valueOf(paramInt));
      String str = String.valueOf(paramLong1);
      localObject1 = this.b.getCurrentAccountUin();
      TroopManager localTroopManager = (TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER);
      Object localObject3 = localTroopManager.f(String.valueOf(paramLong1));
      Object localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = new TroopInfo();
        ((TroopInfo)localObject2).troopuin = String.valueOf(paramLong1);
      }
      if (TextUtils.isEmpty(((TroopInfo)localObject2).troopowneruin)) {
        ((ITroopInfoHandler)this.b.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER)).a(((TroopInfo)localObject2).troopuin, false);
      }
      localObject3 = String.valueOf(paramLong2);
      boolean bool = ((String)localObject3).equalsIgnoreCase(((TroopInfo)localObject2).troopowneruin);
      Iterator localIterator = paramArrayList.iterator();
      paramArrayList = (ArrayList<PushParam>)localObject3;
      while (localIterator.hasNext())
      {
        Object localObject4 = (PushParam)localIterator.next();
        localObject3 = ((PushParam)localObject4).a;
        if ((((PushParam)localObject4).b != 0L) && (((PushParam)localObject4).b != 4294967295L)) {
          paramLong2 = paramLong3 + ((PushParam)localObject4).b;
        } else {
          paramLong2 = ((PushParam)localObject4).b;
        }
        StringBuilder localStringBuilder;
        if (((String)localObject3).equals(localObject1))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(" fightgag.onPushGagMsg ltroopUin = ");
            localStringBuilder.append(str);
            localStringBuilder.append(",lGagTimeStamp = ");
            localStringBuilder.append(paramLong2);
            QLog.d("TroopGagMgr", 2, localStringBuilder.toString());
          }
          ((TroopInfo)localObject2).dwGagTimeStamp_me = paramLong2;
          localTroopManager.b((TroopInfo)localObject2);
          c(str, true);
          a(str, paramArrayList, paramLong3, ((PushParam)localObject4).b, paramInt, false, bool);
          i = 1;
        }
        if (((String)localObject3).equals("0"))
        {
          ((TroopInfo)localObject2).dwGagTimeStamp = paramLong2;
          localTroopManager.b((TroopInfo)localObject2);
          f(str);
          c(str, true);
          a(str, paramArrayList, paramLong3, ((PushParam)localObject4).b, paramInt, true, bool);
          i = 1;
        }
        else
        {
          if (!((String)localObject3).equals(localObject1)) {
            a(str, paramLong3, ((PushParam)localObject4).b, paramInt, paramArrayList, (String)localObject3, bool);
          }
          localObject4 = (ITroopGagService)this.b.getRuntimeService(ITroopGagService.class, "");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramLong1);
          localStringBuilder.append("");
          ((ITroopGagService)localObject4).saveAndUpdateTroopMemberGagStatus(localStringBuilder.toString(), (String)localObject3, paramLong2);
        }
      }
      if (i != 0)
      {
        paramArrayList = (ITroopGagHandler)this.b.getBusinessHandler(BusinessHandlerFactory.TROOP_GAG_HANDLER);
        try
        {
          paramArrayList.a(str);
          return;
        }
        catch (Exception paramArrayList)
        {
          paramArrayList.printStackTrace();
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramArrayList;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    d(this.b.getApplication().getApplicationContext().getString(paramInt), paramBoolean);
  }
  
  public void a(String paramString1, long paramLong1, long paramLong2, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("----------addTroopGagTipsMr friendUin: ");
      ((StringBuilder)localObject1).append(paramString1);
      QLog.d("TroopGagMgr", 2, ((StringBuilder)localObject1).toString());
    }
    boolean bool = c(paramString1);
    Context localContext = this.b.getApplication().getApplicationContext();
    int i;
    if ((paramBoolean) && (bool)) {
      i = 2131895537;
    } else {
      i = 2131895536;
    }
    Object localObject2 = localContext.getString(i);
    if (paramLong2 != 0L) {
      i = 2131895178;
    } else {
      i = 2131895093;
    }
    Object localObject4 = localContext.getString(i);
    Object localObject1 = ContactUtils.b(this.b, paramString1, paramString2);
    String str = ContactUtils.b(this.b, paramString1, paramString3);
    Object localObject3 = this.b.getCurrentAccountUin();
    if (((String)localObject3).equalsIgnoreCase(paramString2))
    {
      localObject2 = HardCodeUtil.a(2131912653);
      localObject1 = "";
      i = 1;
    }
    else
    {
      i = 0;
    }
    int j;
    if (((String)localObject3).equalsIgnoreCase(paramString3))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(HardCodeUtil.a(2131912654));
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject2 = ((StringBuilder)localObject3).toString();
      str = "";
      j = 1;
    }
    else
    {
      j = 0;
    }
    localObject3 = localObject2;
    if (j == 0)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(" ");
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject3 = ((StringBuilder)localObject3).toString();
    }
    if ((bool) && (i == 0))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject3);
      ((StringBuilder)localObject2).append(" ");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(" ");
      ((StringBuilder)localObject3).append((String)localObject4);
      localObject3 = ((StringBuilder)localObject3).toString();
    }
    else
    {
      localObject2 = localObject3;
      localObject1 = "";
      localObject3 = localObject4;
    }
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(str);
    ((StringBuilder)localObject4).append((String)localObject2);
    ((StringBuilder)localObject4).append((String)localObject1);
    ((StringBuilder)localObject4).append((String)localObject3);
    localObject3 = ((StringBuilder)localObject4).toString();
    if (paramLong2 != 0L)
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject3);
      ((StringBuilder)localObject4).append(c(localContext, paramLong2));
      localObject3 = ((StringBuilder)localObject4).toString();
    }
    localObject4 = (MessageForGrayTips)MessageRecordFactory.a(-2030);
    ((MessageForGrayTips)localObject4).frienduin = paramString1;
    ((MessageForGrayTips)localObject4).init(this.b.getCurrentAccountUin(), paramString1, paramString1, (String)localObject3, paramLong1, -2030, 1, paramInt);
    if (!StringUtil.isEmpty(str))
    {
      paramString1 = new Bundle();
      paramString1.putInt("key_action", 5);
      paramString1.putString("troop_mem_uin", paramString3);
      paramString1.putBoolean("need_update_nick", true);
      ((MessageForGrayTips)localObject4).addHightlightItem(0, str.length(), paramString1);
    }
    paramString1 = new StringBuilder();
    paramString1.append(str);
    paramString1.append((String)localObject2);
    paramString1 = paramString1.toString();
    if (!StringUtil.isEmpty((String)localObject1))
    {
      paramString3 = new Bundle();
      paramString3.putInt("key_action", 5);
      paramString3.putString("troop_mem_uin", paramString2);
      paramString3.putBoolean("need_update_nick", true);
      ((MessageForGrayTips)localObject4).addHightlightItem(paramString1.length(), paramString1.length() + ((String)localObject1).length(), paramString3);
    }
    ((MessageForGrayTips)localObject4).isread = true;
    if (MessageHandlerUtils.a(this.b, (MessageRecord)localObject4, false)) {
      return;
    }
    this.b.getMessageFacade().a((MessageRecord)localObject4, this.b.getCurrentAccountUin());
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("----------addTroopGagTipsMr friendUin: ");
      ((StringBuilder)localObject1).append(paramString1);
      QLog.d("TroopGagMgr", 2, ((StringBuilder)localObject1).toString());
    }
    boolean bool = c(paramString1);
    Object localObject3 = this.b.getApplication().getApplicationContext();
    Object localObject2;
    if (!paramBoolean1)
    {
      localObject1 = ((Context)localObject3).getString(2131895187);
      if ((paramBoolean2) && (bool))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(((Context)localObject3).getString(2131895537));
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(((Context)localObject3).getString(2131895536));
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    else if ((paramBoolean2) && (bool))
    {
      localObject2 = ((Context)localObject3).getString(2131895186);
    }
    else
    {
      localObject2 = ((Context)localObject3).getString(2131895179);
    }
    int i;
    if (paramBoolean1)
    {
      if (paramLong2 != 0L) {
        localObject1 = ((Context)localObject3).getString(2131895181);
      } else {
        localObject1 = ((Context)localObject3).getString(2131895094);
      }
    }
    else
    {
      if (paramLong2 != 0L) {
        i = 2131895178;
      } else {
        i = 2131895093;
      }
      localObject1 = ((Context)localObject3).getString(i);
      if (paramLong2 != 0L)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append((String)localObject1);
        ((StringBuilder)localObject4).append(c((Context)localObject3, paramLong2));
        localObject1 = ((StringBuilder)localObject4).toString();
      }
    }
    localObject3 = ContactUtils.b(this.b, paramString1, paramString2);
    if (this.b.getCurrentAccountUin().equalsIgnoreCase(paramString2))
    {
      localObject2 = HardCodeUtil.a(2131912656);
      i = 1;
    }
    else
    {
      i = 0;
    }
    if ((bool) && (i == 0))
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject2);
      ((StringBuilder)localObject4).append(" ");
      localObject4 = ((StringBuilder)localObject4).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = localObject3;
      localObject3 = localObject4;
    }
    else
    {
      localObject4 = "";
      localObject3 = localObject2;
      localObject2 = localObject4;
    }
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append((String)localObject3);
    ((StringBuilder)localObject4).append((String)localObject2);
    ((StringBuilder)localObject4).append((String)localObject1);
    localObject4 = ((StringBuilder)localObject4).toString();
    Object localObject1 = (MessageForGrayTips)MessageRecordFactory.a(-2030);
    ((MessageForGrayTips)localObject1).frienduin = paramString1;
    ((MessageForGrayTips)localObject1).init(this.b.getCurrentAccountUin(), paramString1, paramString1, (String)localObject4, paramLong1, -2030, 1, paramInt);
    if (!StringUtil.isEmpty((String)localObject2))
    {
      paramString1 = new Bundle();
      paramString1.putInt("key_action", 5);
      paramString1.putString("troop_mem_uin", paramString2);
      paramString1.putBoolean("need_update_nick", true);
      ((MessageForGrayTips)localObject1).addHightlightItem(((String)localObject3).length(), ((String)localObject3).length() + ((String)localObject2).length(), paramString1);
    }
    ((MessageForGrayTips)localObject1).isread = true;
    if (MessageHandlerUtils.a(this.b, (MessageRecord)localObject1, false)) {
      return;
    }
    this.b.getMessageFacade().a((MessageRecord)localObject1, this.b.getCurrentAccountUin());
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    paramString1 = ((ITroopGagService)this.b.getRuntimeService(ITroopGagService.class, "")).getTroopMemberGagInfo(paramString1, paramString2);
    NetConnInfoCenter.getServerTime();
    return (paramString1.b != 0L) && (paramString1.b > NetConnInfoCenter.getServerTime());
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    int i = 2131895096;
    if ((!bool) && (!paramString1.equals("0")))
    {
      if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.equals("0")))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new ITroopGagHandler.GagMemberParam(paramString2, paramLong));
        ((ITroopGagHandler)this.b.getBusinessHandler(BusinessHandlerFactory.TROOP_GAG_HANDLER)).a(paramString1, localArrayList);
        return true;
      }
      if (paramLong != 0L) {
        i = 2131895184;
      }
      a(i, false);
      return false;
    }
    if (paramLong != 0L) {
      i = 2131895184;
    }
    a(i, false);
    return false;
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    long l1 = PkgTools.getLongData(paramArrayOfByte, 0);
    int j = paramArrayOfByte[4];
    long l2;
    long l3;
    if (j == 12)
    {
      j = paramArrayOfByte[5];
      l2 = PkgTools.getLongData(paramArrayOfByte, 6);
      PkgTools.getLongData(paramArrayOfByte, 10);
      l3 = NetConnInfoCenter.getServerTime();
      int k = PkgTools.getShortData(paramArrayOfByte, 14);
      j = 16;
      ArrayList localArrayList = new ArrayList();
      while (i < k)
      {
        long l4 = PkgTools.getLongData(paramArrayOfByte, j);
        j += 4;
        long l5 = PkgTools.getLongData(paramArrayOfByte, j);
        j += 4;
        localArrayList.add(new PushParam(String.valueOf(l4), l5));
        i += 1;
      }
      a(paramInt, l1, l2, l3, localArrayList);
      return true;
    }
    if (j == 14)
    {
      i = paramArrayOfByte[5];
      PkgTools.getLongData(paramArrayOfByte, 6);
      l2 = NetConnInfoCenter.getServerTime();
      l3 = PkgTools.getLongData(paramArrayOfByte, 10);
      i = paramArrayOfByte[14];
      a(paramInt, l1, l2, l3, PkgTools.getUTFString(paramArrayOfByte, 15, i), paramArrayOfByte[(15 + i)]);
    }
    return false;
  }
  
  public TroopGagInfo b(String paramString)
  {
    Object localObject = (TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject == null) {
      return new TroopGagInfo(paramString, 0L);
    }
    localObject = ((TroopManager)localObject).g(paramString);
    if (localObject == null) {
      return new TroopGagInfo(paramString, 0L);
    }
    return new TroopGagInfo(paramString, ((TroopInfo)localObject).dwGagTimeStamp);
  }
  
  public String b(Context paramContext, long paramLong)
  {
    long l = NetConnInfoCenter.getServerTime();
    if (paramLong <= l)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagMgr", 4, String.format("error: gagTimeToStringCountDown gagTime <= currentTimeMs", new Object[0]));
      }
      return "";
    }
    return a(paramContext, paramLong - l, paramLong);
  }
  
  public ArrayList<MemberGagInfo> b(String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = ((ITroopGagService)this.b.getRuntimeService(ITroopGagService.class, "")).getTroopMemberGagList(paramString);
    if (paramBoolean) {
      b(paramString, null);
    }
    return localArrayList;
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("fetchGagTroopList:sUin=%s", new Object[] { paramString1 }));
    }
    Object localObject = this.b;
    if (localObject == null) {
      return false;
    }
    if (localObject != null) {
      ((QQAppInterface)localObject).addObserver(this.d);
    }
    localObject = (ITroopMemberListHandler)this.b.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
    if (localObject != null)
    {
      try
      {
        if (TextUtils.isEmpty(paramString2))
        {
          ((ITroopMemberListHandler)localObject).a(Long.parseLong(paramString1), 0L, 6, null, 0, 0);
          return true;
        }
        long l1 = Long.parseLong(paramString1);
        long l2 = Long.parseLong(paramString2);
        paramString1 = new ArrayList();
        paramString1.add(Long.valueOf(l2));
        ((ITroopMemberListHandler)localObject).a(l1, 0L, 3, paramString1, 0, 0);
        return true;
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopGagMgr", 2, paramString1.toString());
        }
        paramString1 = this.b;
        if (paramString1 == null) {
          break label198;
        }
      }
      paramString1.removeObserver(this.d);
      return true;
    }
    else
    {
      paramString1 = this.b;
      if (paramString1 != null) {
        paramString1.removeObserver(this.d);
      }
    }
    label198:
    return true;
  }
  
  public String c(Context paramContext, long paramLong)
  {
    paramContext = this.b.getApplication().getApplicationContext();
    String str1 = paramContext.getString(2131895191);
    String str2 = paramContext.getString(2131895190);
    Object localObject = paramContext.getString(2131895189);
    if (paramLong < 60L)
    {
      paramContext = new StringBuilder();
      paramContext.append(1);
      paramContext.append(str1);
      return paramContext.toString();
    }
    long l1 = paramLong + 59L;
    paramLong = l1 / 86400L;
    long l2 = l1 - 86400L * paramLong;
    l1 = l2 / 3600L;
    l2 = (l2 - 3600L * l1) / 60L;
    paramContext = "";
    if (paramLong > 0L)
    {
      paramContext = new StringBuilder();
      paramContext.append("");
      paramContext.append(paramLong);
      paramContext.append((String)localObject);
      paramContext = paramContext.toString();
    }
    localObject = paramContext;
    if (l1 > 0L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(str2);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramContext = (Context)localObject;
    if (l2 > 0L)
    {
      paramContext = new StringBuilder();
      paramContext.append((String)localObject);
      paramContext.append(l2);
      paramContext.append(str1);
      paramContext = paramContext.toString();
    }
    return paramContext;
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    ((ITroopGagHandler)this.b.getBusinessHandler(BusinessHandlerFactory.TROOP_GAG_HANDLER)).a(new GagStatus(paramString, a(paramString, paramBoolean)));
  }
  
  public boolean c(String paramString)
  {
    Object localObject = (TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject == null) {
      return false;
    }
    localObject = ((TroopManager)localObject).f(paramString);
    if (localObject == null) {
      return false;
    }
    paramString = this.b.getCurrentAccountUin();
    if ((!TextUtils.isEmpty(((TroopInfo)localObject).troopowneruin)) && (paramString.equals(((TroopInfo)localObject).troopowneruin))) {
      return true;
    }
    if (!TextUtils.isEmpty(((TroopInfo)localObject).Administrator))
    {
      localObject = ((TroopInfo)localObject).Administrator.split("\\|");
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (localObject[i].equalsIgnoreCase(paramString)) {
            return true;
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  public void d(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Context localContext = this.b.getApplication().getApplicationContext();
    int i = localContext.getResources().getDimensionPixelSize(2131299920);
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new TroopGagMgr.1(this, paramBoolean, localContext, paramString, i));
      return;
    }
    if (paramBoolean)
    {
      QQToast.makeText(localContext, 2, paramString, 0).show(i);
      return;
    }
    QQToast.makeText(localContext, 2130840055, paramString, 0).show(i);
  }
  
  public boolean d(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager == null) {
      return false;
    }
    paramString = localTroopManager.f(paramString);
    if (paramString == null) {
      return false;
    }
    return this.b.getCurrentAccountUin().equals(paramString.troopowneruin);
  }
  
  public void e(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER);
    paramString = localTroopManager.u(paramString);
    TroopInfo localTroopInfo = localTroopManager.f(paramString);
    if (localTroopInfo != null)
    {
      localTroopInfo.dwGagTimeStamp = 0L;
      localTroopInfo.dwGagTimeStamp_me = 0L;
      localTroopManager.b(localTroopInfo);
      if (localTroopManager.g(paramString, this.b.getCurrentAccountUin()) != null) {
        localTroopManager.a(paramString, this.b.getCurrentAccountUin(), null, -100, null, null, -100, -100, -100, -100L, 0L);
      }
    }
    ((ITroopGagHandler)this.b.getBusinessHandler(BusinessHandlerFactory.TROOP_GAG_HANDLER)).a(paramString);
  }
  
  public void onDestroy()
  {
    try
    {
      if (this.c.size() != 0)
      {
        StringBuffer localStringBuffer = new StringBuffer();
        while (this.c.size() != 0)
        {
          localStringBuffer.append(((Integer)this.c.poll()).intValue());
          if (this.c.size() != 0) {
            localStringBuffer.append(";");
          }
        }
        this.a.edit().putString("seqs", localStringBuffer.toString()).commit();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopGagMgr
 * JD-Core Version:    0.7.0.1
 */