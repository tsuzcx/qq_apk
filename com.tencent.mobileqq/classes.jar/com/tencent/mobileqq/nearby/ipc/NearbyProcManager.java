package com.tencent.mobileqq.nearby.ipc;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.avatar.api.IQQAvatarManagerService;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.config.PicIPManager;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.nearby.NearbyConstants;
import com.tencent.mobileqq.nearby.NearbyReportManager;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.redtouch.NearbyRedNum;
import com.tencent.mobileqq.nearpeople.api.INearbyMineHelper;
import com.tencent.mobileqq.newnearby.INearbyAlbumHelper;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyFeedConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyRankConfig;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;
import tencent.im.oidb.cmd0x9c7.cmd0x9c7.RspBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AppointmentNotify;

public class NearbyProcManager
  implements INearbyProcManager, Manager
{
  protected static SparseArray<Integer> a;
  private INearbyAppInterface b;
  private NearbyProcess c;
  private final List<INearbyProcObserver> d = new ArrayList();
  private final List<INearbyProcObserver> e = new ArrayList();
  private MqqHandler f;
  private MqqHandler g;
  private int[] h = null;
  private boolean[] i = null;
  
  public NearbyProcManager(AppInterface paramAppInterface)
  {
    this.b = ((INearbyAppInterface)paramAppInterface);
    this.c = new NearbyProcess(paramAppInterface, this);
    this.f = ThreadManager.getUIHandler();
    this.g = ThreadManager.getSubThreadHandler();
  }
  
  private void a(SubMsgType0x27.AppointmentNotify paramAppointmentNotify)
  {
    if (paramAppointmentNotify == null) {
      return;
    }
    long l = paramAppointmentNotify.uint32_notifytype.get();
    if (((l == 2L) || (l == 4L)) && (QLog.isColorLevel())) {
      QLog.i("Q.nearby", 2, "hasOnLinePush|shield dating notify");
    }
  }
  
  private Message b(Message paramMessage)
  {
    return this.c.a(paramMessage);
  }
  
  private Object[] c(int paramInt, Object... paramVarArgs)
  {
    return this.c.a(paramInt, paramVarArgs);
  }
  
  private Object[] d(int paramInt)
  {
    return this.c.a(paramInt);
  }
  
  public Bitmap a(String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject = new Message();
    ((Message)localObject).what = 4160;
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString);
    localBundle.putInt("headType", paramInt);
    localBundle.putBoolean("appendToTail", paramBoolean);
    ((Message)localObject).setData(localBundle);
    paramString = b((Message)localObject);
    if (paramString == null) {
      return null;
    }
    paramString = paramString.getData();
    paramString.setClassLoader(Bitmap.class.getClassLoader());
    paramString = (Bitmap)paramString.getParcelable("faceBmp");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ipc getFaceBitmap : ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("Q.dynamicAvatar", 2, ((StringBuilder)localObject).toString());
    }
    return paramString;
  }
  
  public Message a(Message paramMessage)
  {
    Object localObject = paramMessage.getData();
    int j = paramMessage.what;
    if (j != 4118)
    {
      if (j != 4139) {
        return null;
      }
      paramMessage = paramMessage.getData();
      if (paramMessage != null)
      {
        j = paramMessage.getInt("headType");
        localObject = paramMessage.getString("id");
        int k = paramMessage.getInt("idType");
        ((IQQAvatarManagerService)this.b.getRuntimeService(IQQAvatarManagerService.class, "nearby")).removeFaceFromCache(FaceInfo.a(j, (String)localObject, k, 3, 0));
        return null;
      }
    }
    else
    {
      if (localObject == null) {
        return null;
      }
      b(4118, new Object[] { ((Bundle)localObject).getStringArrayList("keys"), ((Bundle)localObject).getStringArrayList("paths") });
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo a(int paramInt)
  {
    Object[] arrayOfObject = c(4157, new Object[] { Integer.valueOf(paramInt) });
    if (arrayOfObject != null) {
      try
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        localRedTypeInfo.mergeFrom((byte[])arrayOfObject[0]);
        return localRedTypeInfo;
      }
      catch (Exception localException)
      {
        if (QLog.isDevelopLevel()) {
          localException.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public void a()
  {
    this.c.a();
  }
  
  public void a(byte paramByte)
  {
    c(4108, new Object[] { Byte.valueOf(paramByte) });
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    c(4170, new Object[] { Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt) });
  }
  
  public void a(INearbyProcObserver paramINearbyProcObserver)
  {
    a(paramINearbyProcObserver, false);
  }
  
  public void a(INearbyProcObserver paramINearbyProcObserver, boolean paramBoolean)
  {
    if (paramINearbyProcObserver == null) {
      return;
    }
    if (paramBoolean) {
      synchronized (this.d)
      {
        if (!this.d.contains(paramINearbyProcObserver)) {
          this.d.add(paramINearbyProcObserver);
        }
        return;
      }
    }
    synchronized (this.e)
    {
      if (!this.e.contains(paramINearbyProcObserver)) {
        this.e.add(paramINearbyProcObserver);
      }
      return;
    }
  }
  
  public void a(Object paramObject)
  {
    oidb_0x8dd.SelfInfo localSelfInfo = (oidb_0x8dd.SelfInfo)paramObject;
    Object localObject = null;
    try
    {
      paramObject = localSelfInfo.toByteArray();
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
      paramObject = null;
    }
    if (paramObject != null) {
      c(4109, new Object[] { paramObject });
    }
    if (paramObject == null) {
      paramObject = localObject;
    } else {
      paramObject = Integer.valueOf(paramObject.length);
    }
    NearbyUtils.a("Q.nearby", "updateSelfCard", new Object[] { localSelfInfo, paramObject });
  }
  
  public void a(String paramString)
  {
    c(4145, new Object[] { paramString });
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 4118;
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("key", paramArrayList);
    localMessage.setData(localBundle);
    paramArrayList = b(localMessage);
    if (paramArrayList != null) {
      paramArrayList = paramArrayList.getData();
    } else {
      paramArrayList = null;
    }
    if (paramArrayList != null) {
      b(4118, new Object[] { paramArrayList.getStringArrayList("key"), paramArrayList.getStringArrayList("path") });
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    int j;
    if (paramBoolean) {
      j = 4099;
    } else {
      j = 4098;
    }
    c(j, new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString6, paramString7, paramString8, paramString9 });
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    c(4142, new Object[] { paramArrayOfByte });
    if (QLog.isColorLevel()) {
      QLog.i("Q.dynamicAvatar", 2, "saveDynamicAvarInfo2db send ipcMsg.");
    }
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getSharedPreferences("nearby_event_file", this.b.getAccount(), 4);
    if (this.i == null)
    {
      this.i = new boolean[2];
      localObject1 = null;
      int j = 0;
      while (j < this.i.length)
      {
        if (j != 0)
        {
          if (j == 1) {
            localObject1 = "config_show_rank";
          }
        }
        else {
          localObject1 = "config_show_date";
        }
        this.i[j] = ((SharedPreferences)localObject2).getBoolean((String)localObject1, false);
        j += 1;
      }
    }
    Object localObject1 = ((SharedPreferences)localObject2).edit();
    localObject2 = this.i;
    label219:
    boolean bool1;
    if (localObject2[paramInt] != paramBoolean)
    {
      localObject2[paramInt] = paramBoolean;
      if ((paramInt == 0) || (paramInt == 1))
      {
        try
        {
          ((SharedPreferences.Editor)localObject1).putBoolean("config_show_rank", paramBoolean);
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            break label219;
          }
          localException.printStackTrace();
          NearbyUtils.a("onGetMyTabConfig", new Object[] { "save config", Integer.valueOf(paramInt), localException.toString() });
        }
        ((SharedPreferences.Editor)localObject1).putBoolean("config_show_date", paramBoolean);
      }
      bool1 = true;
    }
    else
    {
      bool1 = false;
    }
    try
    {
      boolean bool2 = ((SharedPreferences.Editor)localObject1).commit();
      if (QLog.isColorLevel())
      {
        NearbyUtils.a("onGetMyTabConfig", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
        return bool1;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return bool1;
  }
  
  public Object[] a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 4100)
    {
      Object localObject;
      if (paramInt != 4101)
      {
        if (paramInt != 4122)
        {
          if (paramInt != 4126)
          {
            if (paramInt != 4131)
            {
              if (paramInt != 4140)
              {
                int j;
                if (paramInt != 4142)
                {
                  if (paramInt != 4144)
                  {
                    if (paramInt != 4146)
                    {
                      if (paramInt != 4159)
                      {
                        if (paramInt != 4164)
                        {
                          if (paramInt != 4169)
                          {
                            if (paramInt != 4161)
                            {
                              if (paramInt != 4162)
                              {
                                switch (paramInt)
                                {
                                default: 
                                  return null;
                                case 4117: 
                                  ((INearbyMineHelper)QRoute.api(INearbyMineHelper.class)).updateNearbyMyTabCard(this.b, 0, true);
                                  return null;
                                case 4116: 
                                  if (paramVarArgs != null)
                                  {
                                    if (paramVarArgs.length != 1) {
                                      return null;
                                    }
                                    b(4116, paramVarArgs);
                                    return null;
                                  }
                                  return null;
                                case 4115: 
                                  if (paramVarArgs != null)
                                  {
                                    if (paramVarArgs.length != 1) {
                                      return null;
                                    }
                                    b(4115, paramVarArgs);
                                    return null;
                                  }
                                  return null;
                                case 4114: 
                                  if (paramVarArgs != null)
                                  {
                                    if (paramVarArgs.length != 2) {
                                      return null;
                                    }
                                    b(4114, new Object[] { paramVarArgs[0], paramVarArgs[1] });
                                    return null;
                                  }
                                  return null;
                                }
                                if (paramVarArgs != null)
                                {
                                  if (paramVarArgs.length != 2) {
                                    return null;
                                  }
                                  b(4113, new Object[] { paramVarArgs[0], paramVarArgs[1] });
                                  return null;
                                }
                                return null;
                              }
                              try
                              {
                                b(4162, new Object[] { (Integer)paramVarArgs[0], (String)paramVarArgs[1] });
                                return null;
                              }
                              catch (Exception paramVarArgs)
                              {
                                paramVarArgs.printStackTrace();
                                return null;
                              }
                            }
                            try
                            {
                              b(4161, new Object[] { (Integer)paramVarArgs[0], (String)paramVarArgs[1], (Bitmap)paramVarArgs[2] });
                              return null;
                            }
                            catch (Exception paramVarArgs)
                            {
                              paramVarArgs.printStackTrace();
                              return null;
                            }
                          }
                          if ((paramVarArgs != null) && (paramVarArgs.length == 1))
                          {
                            if (!(paramVarArgs[0] instanceof Integer)) {
                              return null;
                            }
                            paramInt = ((Integer)paramVarArgs[0]).intValue();
                            ((INearbyAlbumHelper)QRoute.api(INearbyAlbumHelper.class)).onUploadPic(paramInt);
                            return null;
                          }
                          return null;
                        }
                        try
                        {
                          b(4164, new Object[] { (Integer)paramVarArgs[0] });
                          return null;
                        }
                        catch (Exception paramVarArgs)
                        {
                          paramVarArgs.printStackTrace();
                          return null;
                        }
                      }
                      b(4159, new Object[0]);
                      return null;
                    }
                    if ((paramVarArgs != null) && (paramVarArgs.length == 2))
                    {
                      paramInt = ((Integer)paramVarArgs[0]).intValue();
                      j = ((Integer)paramVarArgs[1]).intValue();
                      ((NearbyHandler)this.b.getBusinessHandler(NearbyConstants.a)).a(paramInt, j);
                      return null;
                    }
                  }
                  else
                  {
                    this.b.clearMyTabCardVisitorInfo();
                    return null;
                  }
                }
                else
                {
                  if (paramVarArgs != null)
                  {
                    if (paramVarArgs.length != 4) {
                      return null;
                    }
                    try
                    {
                      long l = ((Long)paramVarArgs[0]).longValue();
                      paramInt = ((Integer)paramVarArgs[1]).intValue();
                      j = ((Integer)paramVarArgs[2]).intValue();
                      int k = ((Integer)paramVarArgs[3]).intValue();
                      ((NearbyReportManager)this.b.getManager(NearbyConstants.j)).a(l, paramInt, j, k);
                      return null;
                    }
                    catch (Exception paramVarArgs)
                    {
                      paramVarArgs.printStackTrace();
                      return null;
                    }
                  }
                  return null;
                }
              }
              else
              {
                PicIPManager.a();
                return null;
              }
            }
            else
            {
              if (paramVarArgs != null)
              {
                if (paramVarArgs.length != 2) {
                  return null;
                }
                b(4131, new Object[] { Integer.valueOf(((Integer)paramVarArgs[0]).intValue()), Boolean.valueOf(((Boolean)paramVarArgs[1]).booleanValue()) });
                return null;
              }
              return null;
            }
          }
          else
          {
            ((NearbyDataManager)this.b.getManager(NearbyConstants.d)).b();
            return null;
          }
        }
        else if (paramVarArgs != null)
        {
          if (paramVarArgs.length < 3) {
            return null;
          }
          try
          {
            paramInt = ((Integer)paramVarArgs[0]).intValue();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Charm=");
            ((StringBuilder)localObject).append(paramInt);
            QLog.i("updateCharmConfigIPC", 1, ((StringBuilder)localObject).toString());
            if (paramVarArgs[1] != null) {
              new Oidb_0x686.NearbyRankConfig().mergeFrom((byte[])paramVarArgs[1]);
            }
            if (paramVarArgs[2] == null) {
              break label938;
            }
            new Oidb_0x686.NearbyFeedConfig().mergeFrom((byte[])paramVarArgs[2]);
            return null;
          }
          catch (Exception paramVarArgs)
          {
            if (!QLog.isColorLevel()) {
              break label938;
            }
          }
          QLog.d("NearbyProcManager", 2, "MSG_GET_CHARM_EVENT catch exception:", paramVarArgs);
          return null;
        }
        else
        {
          return null;
        }
      }
      else
      {
        if (paramVarArgs != null)
        {
          if (paramVarArgs.length != 1) {
            return null;
          }
          paramVarArgs = (byte[])paramVarArgs[0];
          try
          {
            localObject = new SubMsgType0x27.AppointmentNotify();
            ((SubMsgType0x27.AppointmentNotify)localObject).mergeFrom(paramVarArgs);
            a((SubMsgType0x27.AppointmentNotify)localObject);
            return null;
          }
          catch (Exception paramVarArgs)
          {
            paramVarArgs.printStackTrace();
            return null;
          }
        }
        return null;
      }
    }
    else if ((paramVarArgs != null) && (paramVarArgs.length == 1))
    {
      if (!(paramVarArgs[0] instanceof Integer)) {
        return null;
      }
      paramInt = ((Integer)paramVarArgs[0]).intValue();
      if (QLog.isColorLevel()) {
        NearbyUtils.a("MSG_NOTIFY_HAS_UNREAD_MSG", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    label938:
    return null;
  }
  
  public int b()
  {
    Object[] arrayOfObject = this.c.a(4156);
    if (arrayOfObject != null)
    {
      if (arrayOfObject.length < 1) {
        return -1;
      }
      try
      {
        int j = ((Integer)arrayOfObject[0]).intValue();
        return j;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.w("getMyAccGender", 2, localException.toString());
        }
      }
    }
    return -1;
  }
  
  public DynamicAvatar b(int paramInt, String paramString)
  {
    Object localObject = new Message();
    ((Message)localObject).what = 4143;
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", paramInt);
    localBundle.putString("id", paramString);
    ((Message)localObject).setData(localBundle);
    paramString = b((Message)localObject);
    if (paramString == null) {
      return null;
    }
    paramString = paramString.getData();
    paramString.setClassLoader(DynamicAvatar.class.getClassLoader());
    paramString = (DynamicAvatar)paramString.getParcelable("avatarInfo");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ipc getDynamicAvatarInfo : ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("Q.dynamicAvatar", 2, ((StringBuilder)localObject).toString());
    }
    return paramString;
  }
  
  public void b(int paramInt)
  {
    c(4158, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void b(int paramInt, Object... paramVarArgs)
  {
    List localList = this.e;
    int k = 0;
    int j = 0;
    try
    {
      INearbyProcObserver localINearbyProcObserver;
      while (j < this.e.size())
      {
        localINearbyProcObserver = (INearbyProcObserver)this.e.get(j);
        this.f.post(new NearbyProcManager.1(this, localINearbyProcObserver, paramInt, paramVarArgs));
        j += 1;
      }
      localList = this.d;
      j = k;
      try
      {
        while (j < this.d.size())
        {
          localINearbyProcObserver = (INearbyProcObserver)this.d.get(j);
          this.g.post(new NearbyProcManager.2(this, localINearbyProcObserver, paramInt, paramVarArgs));
          j += 1;
        }
        return;
      }
      finally {}
      throw paramVarArgs;
    }
    finally {}
    for (;;) {}
  }
  
  public void b(INearbyProcObserver paramINearbyProcObserver)
  {
    synchronized (this.e)
    {
      if (this.e.contains(paramINearbyProcObserver)) {
        this.e.remove(paramINearbyProcObserver);
      }
      synchronized (this.d)
      {
        if (this.d.contains(paramINearbyProcObserver)) {
          this.d.remove(paramINearbyProcObserver);
        }
        return;
      }
    }
  }
  
  public void b(Object paramObject)
  {
    paramObject = (cmd0x9c7.RspBody)paramObject;
    if (paramObject == null) {
      paramObject = null;
    } else {
      paramObject = paramObject.toByteArray();
    }
    c(4123, new Object[] { paramObject });
  }
  
  public void b(String paramString)
  {
    c(4168, new Object[] { paramString });
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo c(int paramInt)
  {
    if (a == null)
    {
      a = new SparseArray();
      a.put(65, Integer.valueOf(12));
    }
    Integer localInteger = (Integer)a.get(paramInt);
    if (localInteger != null) {
      return a(localInteger.intValue());
    }
    return null;
  }
  
  public void c()
  {
    d(4147);
  }
  
  public void d()
  {
    d(4148);
  }
  
  public NearbyRedNum e()
  {
    NearbyRedNum localNearbyRedNum = new NearbyRedNum();
    Object[] arrayOfObject = c(4165, new Object[] { Integer.valueOf(0) });
    if (arrayOfObject != null) {
      try
      {
        localNearbyRedNum.a = ((Integer)arrayOfObject[0]).intValue();
        localNearbyRedNum.b = ((Integer)arrayOfObject[1]).intValue();
        localNearbyRedNum.c = ((Integer)arrayOfObject[2]).intValue();
        localNearbyRedNum.d = ((Integer)arrayOfObject[3]).intValue();
        return localNearbyRedNum;
      }
      catch (Exception localException)
      {
        if (QLog.isDevelopLevel()) {
          localException.printStackTrace();
        }
      }
    }
    return localNearbyRedNum;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyProcManager", 2, "clearNearbyMatchMakerRedNum");
    }
    d(4167);
  }
  
  public int g()
  {
    Object localObject = c(4163, new Object[] { AppConstants.NEARBY_LBS_HELLO_UIN });
    try
    {
      int j = ((Integer)localObject[0]).intValue();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getNearbyMsgBoxUnreadNum toolProcess,num=");
        ((StringBuilder)localObject).append(j);
        QLog.d("nearby.msgbox.tab", 2, ((StringBuilder)localObject).toString());
      }
      return j;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.msgbox.tab", 2, "getNearbyMsgBoxUnreadNum，exp=", localException);
      }
    }
    return 0;
  }
  
  public boolean h()
  {
    return this.c.c();
  }
  
  public NearbyRedNum i()
  {
    NearbyRedNum localNearbyRedNum = new NearbyRedNum();
    Object[] arrayOfObject = c(4166, new Object[] { Integer.valueOf(0) });
    if (arrayOfObject != null) {
      try
      {
        localNearbyRedNum.a = ((Integer)arrayOfObject[0]).intValue();
        localNearbyRedNum.b = ((Integer)arrayOfObject[1]).intValue();
        localNearbyRedNum.c = ((Integer)arrayOfObject[2]).intValue();
        localNearbyRedNum.d = ((Integer)arrayOfObject[3]).intValue();
        localNearbyRedNum.e = ((String)arrayOfObject[4]);
        return localNearbyRedNum;
      }
      catch (Exception localException)
      {
        if (QLog.isDevelopLevel()) {
          localException.printStackTrace();
        }
      }
    }
    return localNearbyRedNum;
  }
  
  public void j()
  {
    this.c.b();
  }
  
  public void onDestroy()
  {
    j();
    this.c = null;
    synchronized (this.d)
    {
      this.d.clear();
      synchronized (this.e)
      {
        this.e.clear();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ipc.NearbyProcManager
 * JD-Core Version:    0.7.0.1
 */