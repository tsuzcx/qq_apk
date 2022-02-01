package com.tencent.mobileqq.nearby.api;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DatingConfig;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.dating.DatingProxyManager;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.dating.StrangerHdHeadUrlFetcher;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.INearbyRelevantHandler;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.interestTag.IInterestTagUtils;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcServiceUtils;
import com.tencent.mobileqq.nearby.ipc.NearbyProxyObserver;
import com.tencent.mobileqq.nearby.profilecard.NearbySendMsgHelper;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.NearbyRedNum;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.nearpeople.api.INearbyMineHelper;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.util.IPCFaceHelper;
import com.tencent.mobileqq.util.IPCIconHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x686.Oidb_0x686.CharmEvent;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyCharmNotify;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyFeedConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyRankConfig;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;
import tencent.im.oidb.cmd0x9c7.cmd0x9c7.RspBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AppointmentNotify;

public class NearbyProxy
  implements INearbyProxy, Manager
{
  QQAppInterface a;
  List<NearbyProxyObserver> b = new ArrayList();
  List<NearbyProxyObserver> c = new ArrayList();
  MqqHandler d;
  MqqHandler e;
  ConditionSearchManager f;
  ConditionSearchManager.IConfigListener g;
  protected IFaceDecoder h;
  protected HashSet<String> i = new HashSet();
  IPCFaceHelper j;
  IPCIconHelper k;
  int l = 0;
  INearbyConfigUtil m;
  int n = -2147483648;
  ShieldListObserver o = new NearbyProxy.10(this);
  MessageObserver p = new NearbyProxy.11(this);
  private ArrayList<String> q;
  
  public NearbyProxy(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.d = ThreadManager.getUIHandler();
    this.e = ThreadManager.getSubThreadHandler();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ThreadManager.post(new NearbyProxy.9(paramQQAppInterface), 5, null, false);
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt2 == 3) && (paramInt1 == 5);
  }
  
  private Object[] b(int paramInt, Object... paramVarArgs)
  {
    return ConnectNearbyProcServiceUtils.a(paramInt, paramVarArgs);
  }
  
  private Object[] d(int paramInt)
  {
    return ConnectNearbyProcServiceUtils.a(paramInt);
  }
  
  public Message a(Context arg1, Message paramMessage)
  {
    if (paramMessage == null) {
      return null;
    }
    ??? = paramMessage.getData();
    int i1 = paramMessage.what;
    if (i1 != 4118)
    {
      if (i1 != 4143)
      {
        if (i1 != 4160)
        {
          if (i1 != 4137)
          {
            if (i1 != 4138)
            {
              switch (i1)
              {
              default: 
                return null;
              case 4135: 
                paramMessage = ???.getStringArrayList("faceKeyList");
                long l1 = ???.getLong("faceTimestamp", 0L);
                c(true).a(paramMessage, l1);
                return null;
              case 4134: 
                ???.setClassLoader(Setting.class.getClassLoader());
                ??? = (Setting)???.getParcelable("setting");
                c(true).a(???);
                return null;
              }
              ??? = ???.getString("key");
              ??? = c(true).a(???);
              paramMessage = Message.obtain();
              localObject = new Bundle();
              ((Bundle)localObject).putParcelable("setting", ???);
              paramMessage.setData((Bundle)localObject);
              return paramMessage;
            }
            ??? = c(true).b();
            paramMessage = Message.obtain();
            localObject = new Bundle();
            ((Bundle)localObject).putString("IP", ???);
            paramMessage.setData((Bundle)localObject);
            return paramMessage;
          }
          ??? = c(true).a();
          paramMessage = Message.obtain();
          localObject = new Bundle();
          ((Bundle)localObject).putString("IP", ???);
          paramMessage.setData((Bundle)localObject);
          return paramMessage;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.dynamicAvatar", 2, "handle ipc msg get face bitmap");
        }
        try
        {
          ??? = Message.obtain();
          localObject = paramMessage.getData();
          paramMessage = ((Bundle)localObject).getString("uin");
          i1 = ((Bundle)localObject).getInt("headType");
          ((Bundle)localObject).getBoolean("appendToTail");
          if (this.h == null)
          {
            this.h = ((IQQAvatarService)this.a.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.a);
            this.h.setDecodeTaskCompletionListener(new NearbyProxy.4(this));
          }
          localObject = this.h.getBitmapFromCache(i1, paramMessage, 200);
          if (localObject == null) {
            synchronized (this.i)
            {
              this.i.add(paramMessage);
              this.h.requestDecodeFace(paramMessage, i1, true);
              return null;
            }
          }
          paramMessage = new Bundle();
          paramMessage.putParcelable("faceBmp", (Parcelable)localObject);
          ???.setData(paramMessage);
          return ???;
        }
        catch (Exception ???)
        {
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("MSG_GET_FACE_BITMAP exception:");
            paramMessage.append(???);
            QLog.e("NearbyProxy", 2, paramMessage.toString());
          }
          return null;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "handle ipc msg get dynamic_avatar_info.");
      }
      ??? = Message.obtain();
      paramMessage = paramMessage.getData();
      i1 = paramMessage.getInt("type");
      Object localObject = paramMessage.getString("id");
      localObject = ((DynamicAvatarManager)this.a.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).b(i1, (String)localObject);
      if (localObject == null) {
        return null;
      }
      Bundle localBundle = new Bundle();
      paramMessage.putParcelable("avatarInfo", (Parcelable)localObject);
      ???.setData(localBundle);
      return ???;
    }
    if (??? == null) {
      return null;
    }
    ??? = h().a(???);
    paramMessage = Message.obtain();
    paramMessage.setData(???);
    return paramMessage;
  }
  
  public String a()
  {
    Object localObject1 = (DatingConfig)i().getDatingConfig();
    if (localObject1 != null) {
      localObject1 = ((DatingConfig)localObject1).aioTravelProfileSendMsgTip;
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = BaseApplication.getContext().getResources().getString(2131896705);
    }
    return localObject2;
  }
  
  public String a(String paramString)
  {
    Object localObject1 = (DatingConfig)i().getDatingConfig();
    if (localObject1 != null)
    {
      localObject1 = ((DatingConfig)localObject1).aioFirstTips;
    }
    else
    {
      DatingUtil.b("getFirstAIOTips", new Object[] { "datingConfig is null" });
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = BaseApplication.getContext().getResources().getString(2131896693);
    }
    return ((String)localObject2).replace("%", paramString);
  }
  
  public void a(int paramInt)
  {
    b(4164, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    List localList = this.b;
    int i2 = 0;
    int i1 = 0;
    try
    {
      Object localObject;
      while (i1 < this.b.size())
      {
        localObject = (NearbyProxyObserver)this.b.get(i1);
        this.d.post(new NearbyProxy.5(this, (NearbyProxyObserver)localObject, paramInt, paramVarArgs));
        i1 += 1;
      }
      if (paramInt == 4124)
      {
        localObject = this.b.iterator();
        while (((Iterator)localObject).hasNext())
        {
          NearbyProxyObserver localNearbyProxyObserver = (NearbyProxyObserver)((Iterator)localObject).next();
          if ((localNearbyProxyObserver != null) && (localNearbyProxyObserver.b())) {
            ((Iterator)localObject).remove();
          }
        }
      }
      localList = this.c;
      i1 = i2;
      try
      {
        while (i1 < this.c.size())
        {
          localObject = (NearbyProxyObserver)this.c.get(i1);
          this.e.post(new NearbyProxy.6(this, (NearbyProxyObserver)localObject, paramInt, paramVarArgs));
          i1 += 1;
        }
        if (paramInt == 4124)
        {
          paramVarArgs = this.c.iterator();
          while (paramVarArgs.hasNext())
          {
            localObject = (NearbyProxyObserver)paramVarArgs.next();
            if ((localObject != null) && (((NearbyProxyObserver)localObject).b())) {
              paramVarArgs.remove();
            }
          }
        }
        return;
      }
      finally {}
      throw paramVarArgs;
    }
    finally {}
    for (;;) {}
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateNearbyProfileCardRecord,tinyID = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",visitDuration = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",visitPicCount = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",opflag = ");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("|");
      localStringBuilder.append(Integer.toBinaryString(paramInt3));
      QLog.d("NearbyProxy", 2, localStringBuilder.toString());
    }
    b(4142, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  public void a(NearbyProxyObserver paramNearbyProxyObserver)
  {
    a(paramNearbyProxyObserver, false);
  }
  
  public void a(NearbyProxyObserver paramNearbyProxyObserver, boolean paramBoolean)
  {
    if (paramNearbyProxyObserver == null) {
      return;
    }
    if (paramBoolean) {
      synchronized (this.c)
      {
        if (!this.c.contains(paramNearbyProxyObserver)) {
          this.c.add(paramNearbyProxyObserver);
        }
        return;
      }
    }
    synchronized (this.b)
    {
      if (!this.b.contains(paramNearbyProxyObserver)) {
        this.b.add(paramNearbyProxyObserver);
      }
      return;
    }
  }
  
  public void a(Object paramObject)
  {
    paramObject = (SubMsgType0x27.AppointmentNotify)paramObject;
    if (paramObject == null) {
      return;
    }
    boolean bool;
    if (paramObject.uint32_notifytype.get() == 6) {
      bool = j();
    } else {
      bool = true;
    }
    if (bool) {
      if (ConnectNearbyProcServiceUtils.a())
      {
        b(4101, new Object[] { paramObject.toByteArray() });
      }
      else
      {
        ((INearbyProcessMonitor)QRoute.api(INearbyProcessMonitor.class)).startNearbyProcess(this.a.getAccount(), 4);
        NearbyProxy.8 local8 = new NearbyProxy.8(this, paramObject);
        local8.a(true);
        a(local8);
      }
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("hasOnLinePush", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramObject.uint32_notifytype.get()), Boolean.valueOf(ConnectNearbyProcServiceUtils.a()) });
    }
  }
  
  public void a(String paramString, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    Oidb_0x686.NearbyRankConfig localNearbyRankConfig = (Oidb_0x686.NearbyRankConfig)paramObject1;
    paramObject2 = (Oidb_0x686.NearbyFeedConfig)paramObject2;
    paramObject1 = (Oidb_0x686.CharmEvent)paramObject3;
    paramObject3 = (Oidb_0x686.NearbyCharmNotify)paramObject4;
    ((INearbyCardManagerUtils)QRoute.api(INearbyCardManagerUtils.class)).updateNearbyPeopleCard(this.a, paramString, paramObject1, paramObject3);
    int i1;
    if (paramObject1 != null) {
      i1 = paramObject1.uint32_new_charm_level.get();
    } else if (paramObject3 != null) {
      i1 = paramObject3.uint32_new_charm_level.get();
    } else {
      i1 = 0;
    }
    if (ConnectNearbyProcServiceUtils.a())
    {
      paramObject1 = null;
      if (localNearbyRankConfig == null) {
        paramString = null;
      } else {
        paramString = localNearbyRankConfig.toByteArray();
      }
      if (paramObject2 != null) {
        paramObject1 = paramObject2.toByteArray();
      }
      b(4122, new Object[] { Integer.valueOf(i1), paramString, paramObject1 });
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    this.q = paramArrayList;
  }
  
  void a(boolean paramBoolean, Object... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return;
    }
    if (paramBoolean)
    {
      ReportController.b(this.a, (String)paramVarArgs[0], (String)paramVarArgs[1], (String)paramVarArgs[2], (String)paramVarArgs[3], (String)paramVarArgs[4], ((Integer)paramVarArgs[5]).intValue(), ((Integer)paramVarArgs[6]).intValue(), (String)paramVarArgs[7], (String)paramVarArgs[8], (String)paramVarArgs[9], (String)paramVarArgs[10]);
      return;
    }
    ReportController.b(this.a, (String)paramVarArgs[0], (String)paramVarArgs[1], (String)paramVarArgs[2], (String)paramVarArgs[3], (String)paramVarArgs[4], ((Integer)paramVarArgs[5]).intValue(), ((Integer)paramVarArgs[6]).intValue(), (String)paramVarArgs[7], (String)paramVarArgs[8], (String)paramVarArgs[9], (String)paramVarArgs[10]);
  }
  
  public Object[] a(Context paramContext, int paramInt, Object... paramVarArgs)
  {
    boolean bool1 = false;
    if (paramInt != 4098) {
      if (paramInt != 4099) {
        if (paramInt != 4132) {
          if (paramInt != 4145) {
            if (paramInt != 4147) {
              if (paramInt != 4163) {
                if (paramInt != 4170) {
                  if (paramInt != 4141) {
                    if (paramInt != 4142) {
                      switch (paramInt)
                      {
                      default: 
                        switch (paramInt)
                        {
                        default: 
                          switch (paramInt)
                          {
                          default: 
                            switch (paramInt)
                            {
                            default: 
                              switch (paramInt)
                              {
                              default: 
                                switch (paramInt)
                                {
                                default: 
                                  return null;
                                case 4168: 
                                  paramContext = new TransferRequest();
                                  paramContext.mIsUp = true;
                                  paramContext.mLocalPath = ((String)paramVarArgs[0]);
                                  paramContext.mFileType = 8;
                                  ((ITransFileController)this.a.getRuntimeService(ITransFileController.class)).transferAsync(paramContext);
                                  return null;
                                case 4167: 
                                  paramContext = (TroopRedTouchManager)this.a.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
                                  paramContext.a(70);
                                  paramContext.d(70);
                                  return null;
                                case 4166: 
                                  paramContext = (TroopRedTouchManager)this.a.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
                                  paramVarArgs = paramContext.b(70);
                                  paramVarArgs.e = paramContext.c(70);
                                  if (paramVarArgs == null) {
                                    break;
                                  }
                                  return new Object[] { Integer.valueOf(paramVarArgs.a), Integer.valueOf(paramVarArgs.b), Integer.valueOf(paramVarArgs.c), Integer.valueOf(paramVarArgs.d), paramVarArgs.e };
                                case 4165: 
                                  paramContext = ((TroopRedTouchManager)this.a.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).n();
                                  if (paramContext == null) {
                                    break;
                                  }
                                  return new Object[] { Integer.valueOf(paramContext.a), Integer.valueOf(paramContext.b), Integer.valueOf(paramContext.c), Integer.valueOf(paramContext.d) };
                                }
                                break;
                              case 4158: 
                                paramContext = (Integer)paramVarArgs[0];
                                ((TroopRedTouchManager)this.a.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).d(paramContext.intValue());
                                return null;
                              case 4157: 
                                paramContext = (Integer)paramVarArgs[0];
                                paramVarArgs = (TroopRedTouchManager)this.a.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
                                switch (paramContext.intValue())
                                {
                                case 4: 
                                case 6: 
                                case 7: 
                                case 8: 
                                case 11: 
                                default: 
                                case 12: 
                                case 10: 
                                case 9: 
                                case 5: 
                                  do
                                  {
                                    paramContext = null;
                                    break;
                                    paramContext = paramVarArgs.h();
                                    break;
                                    paramContext = paramVarArgs.m();
                                    break;
                                    paramContext = paramVarArgs.o();
                                    break;
                                  } while (!paramVarArgs.p());
                                  paramContext = new BusinessInfoCheckUpdate.RedTypeInfo();
                                  break;
                                case 3: 
                                  paramContext = paramVarArgs.d();
                                  break;
                                case 2: 
                                  paramContext = paramVarArgs.c();
                                  break;
                                case 1: 
                                  paramContext = paramVarArgs.b();
                                }
                                if (paramContext == null) {
                                  break;
                                }
                                return new Object[] { paramContext.toByteArray() };
                              case 4156: 
                                if (QLog.isColorLevel()) {
                                  QLog.d("NearbyProxy", 2, "MSG_GET_NOW_SEX_INFO!");
                                }
                                paramContext = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
                                if (paramContext == null) {
                                  paramContext = null;
                                } else {
                                  paramContext = paramContext.f(this.a.getCurrentAccountUin());
                                }
                                if (paramContext == null) {
                                  break;
                                }
                                return new Object[] { Short.valueOf(paramContext.shGender) };
                              }
                              break;
                            case 4129: 
                              if (paramVarArgs != null)
                              {
                                if (paramVarArgs.length != 1) {
                                  return null;
                                }
                                paramContext = (String)paramVarArgs[0];
                                paramVarArgs = this.f;
                                if (paramVarArgs != null) {
                                  return new Object[] { paramVarArgs.f(paramContext.split("-")) };
                                }
                              }
                            case 4130: 
                              paramContext = this.f;
                              if (paramContext == null) {
                                return null;
                              }
                              paramContext.b(this);
                              paramContext = this.g;
                              if (paramContext != null) {
                                this.f.d(paramContext);
                              }
                              return null;
                            case 4128: 
                              if (this.f == null) {
                                this.f = ((ConditionSearchManager)this.a.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER));
                              }
                              this.g = new NearbyProxy.2(this);
                              this.f.a(this);
                              this.f.c(this.g);
                              return null;
                            }
                            paramContext = this.m;
                            if (paramContext != null) {
                              paramContext.updateDatingConfig();
                            }
                            return null;
                          case 4123: 
                            if (paramVarArgs != null)
                            {
                              if (paramVarArgs.length < 1) {
                                return null;
                              }
                              try
                              {
                                paramVarArgs = (byte[])paramVarArgs[0];
                                paramContext = new cmd0x9c7.RspBody();
                                try
                                {
                                  paramContext.mergeFrom(paramVarArgs);
                                }
                                catch (Exception paramVarArgs) {}
                                paramVarArgs.printStackTrace();
                              }
                              catch (Exception paramVarArgs)
                              {
                                paramContext = null;
                              }
                              b(paramContext);
                            }
                            return null;
                          case 4122: 
                            if (paramVarArgs != null)
                            {
                              if (paramVarArgs.length < 3) {
                                return null;
                              }
                              str = (String)paramVarArgs[0];
                              if (paramVarArgs[1] == null) {}
                            }
                            break;
                          }
                          break;
                        }
                        break;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    try
    {
      arrayOfByte = (byte[])paramVarArgs[1];
      paramContext = new Oidb_0x686.CharmEvent();
    }
    catch (Throwable paramContext)
    {
      byte[] arrayOfByte;
      label1038:
      break label1041;
    }
    try
    {
      paramContext.mergeFrom(arrayOfByte);
    }
    catch (Throwable localThrowable1)
    {
      break label1038;
    }
    break label1043;
    label1041:
    paramContext = null;
    label1043:
    if (paramVarArgs[2] != null) {}
    try
    {
      arrayOfByte = (byte[])paramVarArgs[2];
      paramVarArgs = new Oidb_0x686.NearbyCharmNotify();
    }
    catch (Throwable paramVarArgs)
    {
      label1078:
      label1080:
      boolean bool2;
      break label1078;
    }
    try
    {
      paramVarArgs.mergeFrom(arrayOfByte);
    }
    catch (Throwable localThrowable2)
    {
      break label1080;
    }
    paramVarArgs = null;
    ((INearbyCardManagerUtils)QRoute.api(INearbyCardManagerUtils.class)).updateNearbyPeopleCard(this.a, str, paramContext, paramVarArgs);
    return null;
    if (paramVarArgs == null) {
      return null;
    }
    paramContext = (String)paramVarArgs[0];
    String str = (String)paramVarArgs[1];
    paramInt = ((Integer)paramVarArgs[2]).intValue();
    AddMessageHelper.a(this.a, paramContext, str, paramInt);
    return null;
    if (paramVarArgs == null) {
      return null;
    }
    paramContext = (String)paramVarArgs[0];
    str = (String)paramVarArgs[1];
    paramInt = ((Integer)paramVarArgs[2]).intValue();
    bool1 = ((Boolean)paramVarArgs[3]).booleanValue();
    bool2 = ((Boolean)paramVarArgs[4]).booleanValue();
    AddMessageHelper.a(this.a, paramContext, str, paramInt, bool1, bool2);
    return null;
    if (paramVarArgs == null) {
      return null;
    }
    paramContext = (String)paramVarArgs[0];
    return new Object[] { Boolean.valueOf(RecentUtil.a(this.a, paramContext)) };
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length < 1) {
        return null;
      }
      return new Object[] { Boolean.valueOf(((ShieldMsgManger)this.a.getManager(QQManagerFactory.SHIELD_LIST_MANAGER)).a((String)paramVarArgs[0])) };
    }
    return null;
    if ((paramVarArgs != null) && (paramVarArgs.length >= 1))
    {
      this.a.addObserver(this.p);
      ((MessageHandler)this.a.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).b((String)paramVarArgs[0], 1);
      return new Object[] { Boolean.valueOf(true) };
    }
    return new Object[] { Boolean.valueOf(false) };
    if ((paramVarArgs != null) && (paramVarArgs.length >= 2))
    {
      this.a.addObserver(this.p);
      ((MessageHandler)this.a.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).c(((Long)paramVarArgs[0]).longValue(), ((Integer)paramVarArgs[1]).intValue(), 1);
      return new Object[] { Boolean.valueOf(true) };
    }
    return new Object[] { Boolean.valueOf(false) };
    if ((paramVarArgs != null) && (paramVarArgs.length == 1))
    {
      if (!(paramVarArgs[0] instanceof byte[])) {
        return null;
      }
      paramVarArgs = (byte[])paramVarArgs[0];
      if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
        try
        {
          paramContext = new oidb_0x8dd.SelfInfo();
          paramContext.mergeFrom(paramVarArgs);
          paramVarArgs = (INearbyCardManager)this.a.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
          if (paramVarArgs != null)
          {
            paramVarArgs.b(paramContext);
            return null;
          }
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      }
    }
    return null;
    if ((paramVarArgs != null) && (paramVarArgs.length >= 1))
    {
      if (!(paramVarArgs[0] instanceof Byte)) {
        return null;
      }
      if (((Byte)paramVarArgs[0]).byteValue() == 0) {
        bool1 = true;
      }
      b(bool1);
    }
    return null;
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length != 3) {
        return null;
      }
      return new Object[] { ((DatingProxyManager)this.a.getManager(QQManagerFactory.DATING_PROXY_MANAGER)).b().a((String)paramVarArgs[0], ((Integer)paramVarArgs[1]).intValue(), ((Boolean)paramVarArgs[2]).booleanValue()) };
    }
    return null;
    if (paramVarArgs == null) {
      return null;
    }
    return new Object[] { ((IRedTouchManager)this.a.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath((String)paramVarArgs[0]).toByteArray() };
    if (paramVarArgs == null) {
      return null;
    }
    return new Object[] { Boolean.valueOf(((IRedTouchManager)this.a.getRuntimeService(IRedTouchManager.class, "")).isNumRedTouchEnable(((Integer)paramVarArgs[0]).intValue())) };
    if (paramVarArgs == null) {
      return null;
    }
    if (paramVarArgs.length >= 6) {
      bool1 = ((Boolean)paramVarArgs[5]).booleanValue();
    } else {
      bool1 = false;
    }
    paramContext = ((INearbyMineHelper)QRoute.api(INearbyMineHelper.class)).createRedTouchAppInfo(this.a, ((Integer)paramVarArgs[0]).intValue(), ((Integer)paramVarArgs[1]).intValue(), (String)paramVarArgs[2], (String)paramVarArgs[3], ((Boolean)paramVarArgs[4]).booleanValue());
    if (bool1) {
      return new Object[] { paramContext.toByteArray() };
    }
    return null;
    ThreadManager.postImmediately(new NearbyProxy.1(this), null, true);
    return null;
    if ((paramVarArgs != null) && (paramVarArgs.length == 1))
    {
      paramContext = (byte[])paramVarArgs[0];
      ((DynamicAvatarManager)this.a.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).a(paramContext);
      if (QLog.isColorLevel())
      {
        QLog.i("Q.dynamicAvatar", 2, "handle ipc msg: save dynamic info 2 db.");
        return null;
        if ((paramVarArgs != null) && (paramVarArgs.length == 1))
        {
          paramContext = ((LocalRedTouchManager)this.a.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).a(((Integer)paramVarArgs[0]).intValue());
          if (paramContext != null) {
            return new Object[] { Integer.valueOf(paramContext.taskId), Long.valueOf(paramContext.curSeq), Integer.valueOf(paramContext.redtouchType), Integer.valueOf(paramContext.count), paramContext.icon, paramContext.tips, Long.valueOf(paramContext.receiveTime), Integer.valueOf(paramContext.validTimeRemained), Boolean.valueOf(paramContext.unReadFlag), Integer.valueOf(paramContext.passThroughLevel), paramContext.configVersion, Boolean.valueOf(paramContext.isClosed) };
          }
        }
        return null;
        try
        {
          NearbySendMsgHelper.a(this.a, ((Long)paramVarArgs[0]).longValue(), (String)paramVarArgs[1], ((Integer)paramVarArgs[2]).intValue(), null);
          return null;
        }
        catch (Exception paramContext)
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("MSG_ADD_ARK_MESSAGE error: ");
          paramVarArgs.append(paramContext);
          QLog.e("NearbyProxy", 1, paramVarArgs.toString());
          return null;
        }
        paramContext = (String)paramVarArgs[0];
        return new Object[] { Integer.valueOf(MsgBoxListActivity.getNearbyMsgBoxUnReadNum(this.a, paramContext, false)) };
        if (QLog.isColorLevel()) {
          QLog.d("NearbyProxy", 2, "call preload now plugin!");
        }
        new Handler(Looper.getMainLooper()).post(new NearbyProxy.3(this));
        return null;
        if (paramVarArgs != null)
        {
          paramContext = (String)paramVarArgs[0];
          ((INearbyCardManager)this.a.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).f().put(paramContext, Integer.valueOf(1));
          if (QLog.isColorLevel())
          {
            paramVarArgs = new StringBuilder();
            paramVarArgs.append("handle ipc msg: MSG_SHOULD_REFRESH_CARD_MSG uin:");
            paramVarArgs.append(paramContext);
            QLog.i("MSG_SHOULD_REFRESH_CARD_MSG", 2, paramVarArgs.toString());
            return null;
            ((NearbyCardManager)this.a.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).a(true);
            return null;
            a(true, paramVarArgs);
            return null;
            a(false, paramVarArgs);
          }
        }
      }
    }
    return null;
  }
  
  public void b()
  {
    d(4159);
  }
  
  public void b(int paramInt)
  {
    if (ConnectNearbyProcServiceUtils.a())
    {
      ((NearbyProxy)NearbyManagerHelper.a(this.a)).b(4100, new Object[] { Integer.valueOf(paramInt) });
    }
    else
    {
      ((INearbyProcessMonitor)QRoute.api(INearbyProcessMonitor.class)).startNearbyProcess(this.a.getAccount(), 3);
      NearbyProxy.7 local7 = new NearbyProxy.7(this, paramInt);
      local7.a(true);
      a(local7);
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("realHasUnreadMsg", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(ConnectNearbyProcServiceUtils.a()) });
    }
  }
  
  public void b(Object paramObject)
  {
    paramObject = (cmd0x9c7.RspBody)paramObject;
    NearbyUtils.a("Q.nearby", "updateNearbyCard", new Object[] { paramObject });
    if (paramObject == null) {
      return;
    }
    if (paramObject.rpt_msg_tags.has()) {
      paramObject = paramObject.rpt_msg_tags.get();
    } else {
      paramObject = null;
    }
    Object localObject1 = new ArrayList();
    if ((paramObject != null) && (paramObject.size() > 0))
    {
      int i1 = 0;
      while (i1 < paramObject.size())
      {
        localObject2 = (InterestTag)((IInterestTagUtils)QRoute.api(IInterestTagUtils.class)).convertFrom(paramObject.get(i1));
        if (localObject2 != null) {
          ((List)localObject1).add(localObject2);
        }
        i1 += 1;
      }
    }
    localObject1 = this.a;
    EntityManager localEntityManager = ((QQAppInterface)localObject1).getEntityManagerFactory(((QQAppInterface)localObject1).getAccount()).createEntityManager();
    Object localObject2 = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { this.a.getCurrentAccountUin() });
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new NearbyPeopleCard();
      ((NearbyPeopleCard)localObject1).uin = this.a.getCurrentAccountUin();
    }
    ((NearbyPeopleCard)localObject1).updateInterestTags(((NearbyPeopleCard)localObject1).tagFlag, paramObject);
    if (((NearbyPeopleCard)localObject1).getStatus() == 1000)
    {
      localEntityManager.persistOrReplace((Entity)localObject1);
      return;
    }
    if ((((NearbyPeopleCard)localObject1).getStatus() == 1001) || (((NearbyPeopleCard)localObject1).getStatus() == 1002)) {
      localEntityManager.update((Entity)localObject1);
    }
  }
  
  public void b(String paramString)
  {
    if (g() == null) {
      a(new ArrayList());
    }
    if (!g().contains(paramString)) {
      g().add(paramString);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    int i1 = 2;
    boolean bool = false;
    DatingUtil.b("setNearbyDatingMsg", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.l) });
    int i2 = this.l;
    if ((i2 == 1) || (i2 == 3)) {
      bool = true;
    }
    if ((this.l == 0) || (bool != paramBoolean)) {
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.a.getAccount(), "dating_recv_msg", Boolean.valueOf(paramBoolean));
    }
    if (paramBoolean) {
      i1 = 1;
    }
    this.l = i1;
  }
  
  public IPCFaceHelper c(boolean paramBoolean)
  {
    try
    {
      if ((this.j == null) && (paramBoolean)) {
        this.j = new IPCFaceHelper(this.a);
      }
      IPCFaceHelper localIPCFaceHelper = this.j;
      return localIPCFaceHelper;
    }
    finally {}
  }
  
  public void c()
  {
    d(4140);
  }
  
  public void c(int paramInt)
  {
    b(4169, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void d()
  {
    a(4124, null);
  }
  
  public void e()
  {
    if (ConnectNearbyProcServiceUtils.a())
    {
      ((NearbyProxy)NearbyManagerHelper.a(this.a)).b(4100, new Object[] { Integer.valueOf(7) });
    }
    else
    {
      INearbyRelevantHandler localINearbyRelevantHandler = (INearbyRelevantHandler)this.a.getBusinessHandler(BusinessHandlerFactory.NEARBY_RELEVANT_HANDLER);
      if (localINearbyRelevantHandler != null) {
        localINearbyRelevantHandler.a();
      }
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("hasUnreadMsg", new Object[] { Boolean.valueOf(ConnectNearbyProcServiceUtils.a()) });
    }
  }
  
  public boolean f()
  {
    if (this.l == 0)
    {
      if (((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getDatingSessionSwitch(this.a.getCurrentAccountUin())) {
        i1 = 3;
      } else {
        i1 = 4;
      }
      this.l = i1;
    }
    int i1 = this.l;
    boolean bool = true;
    if (i1 != 1)
    {
      if (i1 == 3) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public ArrayList<String> g()
  {
    return this.q;
  }
  
  public IPCIconHelper h()
  {
    try
    {
      if (this.k == null) {
        this.k = new IPCIconHelper(this.a);
      }
      IPCIconHelper localIPCIconHelper = this.k;
      return localIPCIconHelper;
    }
    finally {}
  }
  
  public INearbyConfigUtil i()
  {
    try
    {
      if (this.m == null) {
        this.m = ((INearbyConfigUtil)QRoute.api(INearbyConfigUtil.class));
      }
      INearbyConfigUtil localINearbyConfigUtil = this.m;
      return localINearbyConfigUtil;
    }
    finally {}
  }
  
  public boolean j()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onDestroy()
  {
    this.b.clear();
    this.c.clear();
    this.a.removeObserver(this.o);
    this.a.removeObserver(this.p);
    IFaceDecoder localIFaceDecoder = this.h;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.NearbyProxy
 * JD-Core Version:    0.7.0.1
 */