package com.tencent.mobileqq.nearby;

import adzh;
import adzi;
import adzj;
import adzn;
import adzo;
import adzp;
import adzq;
import adzr;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import appoint.define.appoint_define.InterestTag;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.data.DatingConfig;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcService;
import com.tencent.mobileqq.nearby.ipc.NearbyProxyObserver;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.IPCFaceHelper;
import com.tencent.mobileqq.util.IPCIconHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x686.Oidb_0x686.CharmEvent;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyCharmNotify;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyFeedConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyRankConfig;
import tencent.im.oidb.cmd0x9c7.cmd0x9c7.RspBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AppointmentNotify;

public class NearbyProxy
  implements Manager
{
  int jdField_a_of_type_Int = 0;
  ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener;
  ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new adzj(this);
  public QQAppInterface a;
  public ShieldListObserver a;
  NearbyConfigUtil jdField_a_of_type_ComTencentMobileqqNearbyNearbyConfigUtil;
  protected FaceDecoder a;
  IPCFaceHelper jdField_a_of_type_ComTencentMobileqqUtilIPCFaceHelper;
  IPCIconHelper jdField_a_of_type_ComTencentMobileqqUtilIPCIconHelper;
  public ArrayList a;
  public HashSet a;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  int jdField_b_of_type_Int = -2147483648;
  List jdField_b_of_type_JavaUtilList = new ArrayList();
  MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  
  public NearbyProxy(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new adzi(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
    this.jdField_b_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ThreadManager.post(new adzh(paramQQAppInterface), 5, null, false);
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("delAccountRecord", new Object[] { paramString });
    }
    BaseApplicationImpl.getApplication().getSharedPreferences("nearpeople_filters" + paramString, 4).edit().clear().commit();
    BaseApplicationImpl.getContext().getFileStreamPath(paramString + "v5.8.gods").delete();
    BaseApplicationImpl.getContext().getFileStreamPath(paramString + "v5.3.nb").delete();
    BaseApplicationImpl.getContext().getFileStreamPath(paramString + "v6.0.recomm").delete();
    NearbySPUtil.a(paramString, "history_valid", Boolean.valueOf(false));
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt2 == 3)
    {
      bool1 = bool2;
      if (paramInt1 == 5) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private Object[] a(int paramInt)
  {
    return ConnectNearbyProcService.a(paramInt);
  }
  
  private Object[] a(int paramInt, Object... paramVarArgs)
  {
    return ConnectNearbyProcService.a(paramInt, paramVarArgs);
  }
  
  public static void c()
  {
    if (ConnectNearbyProcService.a()) {
      ConnectNearbyProcService.a(4126);
    }
  }
  
  public Message a(Context arg1, Message paramMessage)
  {
    if (paramMessage == null) {
      return null;
    }
    ??? = paramMessage.getData();
    Object localObject;
    int i;
    switch (paramMessage.what)
    {
    default: 
      return null;
    case 4118: 
      if (??? == null) {
        return null;
      }
      ??? = a().a(???);
      paramMessage = Message.obtain();
      paramMessage.setData(???);
      return paramMessage;
    case 4133: 
      ??? = ???.getString("key");
      ??? = a(true).a(???);
      paramMessage = Message.obtain();
      localObject = new Bundle();
      ((Bundle)localObject).putParcelable("setting", ???);
      paramMessage.setData((Bundle)localObject);
      return paramMessage;
    case 4134: 
      ???.setClassLoader(Setting.class.getClassLoader());
      ??? = (Setting)???.getParcelable("setting");
      a(true).a(???);
      return null;
    case 4135: 
      paramMessage = ???.getStringArrayList("faceKeyList");
      long l = ???.getLong("faceTimestamp", 0L);
      a(true).a(paramMessage, l);
      return null;
    case 4137: 
      ??? = a(true).a();
      paramMessage = Message.obtain();
      localObject = new Bundle();
      ((Bundle)localObject).putString("IP", ???);
      paramMessage.setData((Bundle)localObject);
      return paramMessage;
    case 4138: 
      ??? = a(true).b();
      paramMessage = Message.obtain();
      localObject = new Bundle();
      ((Bundle)localObject).putString("IP", ???);
      paramMessage.setData((Bundle)localObject);
      return paramMessage;
    case 4143: 
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "handle ipc msg get dynamic_avatar_info.");
      }
      ??? = Message.obtain();
      paramMessage = paramMessage.getData();
      i = paramMessage.getInt("type");
      localObject = paramMessage.getString("id");
      localObject = ((DynamicAvatarManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(179)).b(i, (String)localObject);
      if (localObject == null) {
        return null;
      }
      Bundle localBundle = new Bundle();
      paramMessage.putParcelable("avatarInfo", (Parcelable)localObject);
      ???.setData(localBundle);
      return ???;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.dynamicAvatar", 2, "handle ipc msg get face bitmap");
    }
    try
    {
      ??? = Message.obtain();
      localObject = paramMessage.getData();
      paramMessage = ((Bundle)localObject).getString("uin");
      i = ((Bundle)localObject).getInt("headType");
      ((Bundle)localObject).getBoolean("appendToTail");
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(new adzn(this));
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(i, paramMessage, 200);
      if (localObject == null) {
        synchronized (this.jdField_a_of_type_JavaUtilHashSet)
        {
          this.jdField_a_of_type_JavaUtilHashSet.add(paramMessage);
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramMessage, i, true);
          return null;
        }
      }
      paramMessage = new Bundle();
    }
    catch (Exception ???)
    {
      if (QLog.isColorLevel()) {
        QLog.e("NearbyProxy", 2, "MSG_GET_FACE_BITMAP exception:" + ???);
      }
      return null;
    }
    paramMessage.putParcelable("faceBmp", (Parcelable)localObject);
    ???.setData(paramMessage);
    return ???;
  }
  
  public NearbyConfigUtil a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyConfigUtil == null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyConfigUtil = new NearbyConfigUtil();
      }
      NearbyConfigUtil localNearbyConfigUtil = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyConfigUtil;
      return localNearbyConfigUtil;
    }
    finally {}
  }
  
  public IPCFaceHelper a(boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilIPCFaceHelper == null) && (paramBoolean)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilIPCFaceHelper = new IPCFaceHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      IPCFaceHelper localIPCFaceHelper = this.jdField_a_of_type_ComTencentMobileqqUtilIPCFaceHelper;
      return localIPCFaceHelper;
    }
    finally {}
  }
  
  public IPCIconHelper a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilIPCIconHelper == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilIPCIconHelper = new IPCIconHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      IPCIconHelper localIPCIconHelper = this.jdField_a_of_type_ComTencentMobileqqUtilIPCIconHelper;
      return localIPCIconHelper;
    }
    finally {}
  }
  
  public String a()
  {
    String str = null;
    Object localObject = a().a();
    if (localObject != null) {
      str = ((DatingConfig)localObject).aioTravelProfileSendMsgTip;
    }
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = BaseApplication.getContext().getResources().getString(2131437694);
    }
    return localObject;
  }
  
  public String a(String paramString)
  {
    String str = null;
    Object localObject = a().a();
    if (localObject != null) {
      str = ((DatingConfig)localObject).aioFirstTips;
    }
    for (;;)
    {
      localObject = str;
      if (str == null) {
        localObject = BaseApplication.getContext().getResources().getString(2131437645);
      }
      return ((String)localObject).replace("%", paramString);
      DatingUtil.b("getFirstAIOTips", new Object[] { "datingConfig is null" });
    }
  }
  
  public void a()
  {
    a(4124, null);
  }
  
  public void a(int paramInt)
  {
    if (ConnectNearbyProcService.a()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(4100, new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("realHasUnreadMsg", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(ConnectNearbyProcService.a()) });
      }
      return;
      NearbyProcessMonitor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 3);
      adzq localadzq = new adzq(this, paramInt);
      localadzq.a = true;
      a(localadzq);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {}
    do
    {
      return;
      if (ConnectNearbyProcService.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.hotChatDistance", 2, "NearbyProxy.checkIn,  lat=" + paramInt1 + ", lon=" + paramInt2);
        }
        a(4146, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.hotChatDistance", 2, "NearbyProxy.checkIn,  NearbyProc is not running");
  }
  
  public void a(int paramInt, String paramString)
  {
    a(4155, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    int j = 0;
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i = 0;
    Object localObject;
    try
    {
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (NearbyProxyObserver)this.jdField_a_of_type_JavaUtilList.get(i);
        this.jdField_a_of_type_MqqOsMqqHandler.post(new adzo(this, (NearbyProxyObserver)localObject, paramInt, paramVarArgs));
        i += 1;
      }
      if (paramInt == 4124)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          NearbyProxyObserver localNearbyProxyObserver = (NearbyProxyObserver)((Iterator)localObject).next();
          if ((localNearbyProxyObserver != null) && (localNearbyProxyObserver.a)) {
            ((Iterator)localObject).remove();
          }
        }
      }
    }
    finally {}
    localList = this.jdField_b_of_type_JavaUtilList;
    i = j;
    try
    {
      while (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        localObject = (NearbyProxyObserver)this.jdField_b_of_type_JavaUtilList.get(i);
        this.jdField_b_of_type_MqqOsMqqHandler.post(new adzp(this, (NearbyProxyObserver)localObject, paramInt, paramVarArgs));
        i += 1;
      }
      if (paramInt == 4124)
      {
        paramVarArgs = this.jdField_b_of_type_JavaUtilList.iterator();
        while (paramVarArgs.hasNext())
        {
          localObject = (NearbyProxyObserver)paramVarArgs.next();
          if ((localObject != null) && (((NearbyProxyObserver)localObject).a)) {
            paramVarArgs.remove();
          }
        }
      }
    }
    finally {}
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyProxy", 2, "updateNearbyProfileCardRecord,tinyID = " + paramLong + ",visitDuration = " + paramInt1 + ",visitPicCount = " + paramInt2 + ",opflag = " + paramInt3 + "|" + Integer.toBinaryString(paramInt3));
    }
    a(4142, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
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
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        if (!this.jdField_b_of_type_JavaUtilList.contains(paramNearbyProxyObserver)) {
          this.jdField_b_of_type_JavaUtilList.add(paramNearbyProxyObserver);
        }
        return;
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramNearbyProxyObserver)) {
        this.jdField_a_of_type_JavaUtilList.add(paramNearbyProxyObserver);
      }
      return;
    }
  }
  
  public void a(String paramString, Oidb_0x686.NearbyRankConfig paramNearbyRankConfig, Oidb_0x686.NearbyFeedConfig paramNearbyFeedConfig, Oidb_0x686.CharmEvent paramCharmEvent, Oidb_0x686.NearbyCharmNotify paramNearbyCharmNotify)
  {
    Object localObject = null;
    NearbyCardManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramCharmEvent, paramNearbyCharmNotify);
    int i;
    if (paramCharmEvent != null) {
      i = paramCharmEvent.uint32_new_charm_level.get();
    }
    for (;;)
    {
      if (ConnectNearbyProcService.a())
      {
        if (paramNearbyRankConfig != null) {
          break label96;
        }
        paramString = null;
        label42:
        if (paramNearbyFeedConfig != null) {
          break label104;
        }
      }
      label96:
      label104:
      for (paramNearbyRankConfig = localObject;; paramNearbyRankConfig = paramNearbyFeedConfig.toByteArray())
      {
        a(4122, new Object[] { Integer.valueOf(i), paramString, paramNearbyRankConfig });
        return;
        if (paramNearbyCharmNotify == null) {
          break label112;
        }
        i = paramNearbyCharmNotify.uint32_new_charm_level.get();
        break;
        paramString = paramNearbyRankConfig.toByteArray();
        break label42;
      }
      label112:
      i = 0;
    }
  }
  
  public void a(cmd0x9c7.RspBody paramRspBody)
  {
    NearbyUtils.a("Q.nearby", "updateNearbyCard", new Object[] { paramRspBody });
    if (paramRspBody == null) {}
    Object localObject1;
    EntityManager localEntityManager;
    do
    {
      return;
      if (paramRspBody.rpt_msg_tags.has()) {}
      for (paramRspBody = paramRspBody.rpt_msg_tags.get();; paramRspBody = null)
      {
        localObject1 = new ArrayList();
        if ((paramRspBody == null) || (paramRspBody.size() <= 0)) {
          break;
        }
        int i = 0;
        while (i < paramRspBody.size())
        {
          localObject2 = InterestTag.a((appoint_define.InterestTag)paramRspBody.get(i));
          if (localObject2 != null) {
            ((List)localObject1).add(localObject2);
          }
          i += 1;
        }
      }
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).createEntityManager();
      Object localObject2 = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() });
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new NearbyPeopleCard();
        ((NearbyPeopleCard)localObject1).uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      }
      ((NearbyPeopleCard)localObject1).updateInterestTags(((NearbyPeopleCard)localObject1).tagFlag, paramRspBody);
      if (((NearbyPeopleCard)localObject1).getStatus() == 1000)
      {
        localEntityManager.b((Entity)localObject1);
        return;
      }
    } while ((((NearbyPeopleCard)localObject1).getStatus() != 1001) && (((NearbyPeopleCard)localObject1).getStatus() != 1002));
    localEntityManager.a((Entity)localObject1);
  }
  
  public void a(SubMsgType0x27.AppointmentNotify paramAppointmentNotify)
  {
    if (paramAppointmentNotify == null) {
      return;
    }
    if (paramAppointmentNotify.uint32_notifytype.get() == 6) {}
    for (boolean bool = b();; bool = true)
    {
      if (bool)
      {
        if (!ConnectNearbyProcService.a()) {
          break label97;
        }
        a(4101, new Object[] { paramAppointmentNotify.toByteArray() });
      }
      while (QLog.isColorLevel())
      {
        NearbyUtils.a("hasOnLinePush", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramAppointmentNotify.uint32_notifytype.get()), Boolean.valueOf(ConnectNearbyProcService.a()) });
        return;
        label97:
        NearbyProcessMonitor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 4);
        adzr localadzr = new adzr(this, paramAppointmentNotify);
        localadzr.a = true;
        a(localadzr);
      }
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = false;
    int i = 1;
    DatingUtil.b("setNearbyDatingMsg", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.jdField_a_of_type_Int) });
    if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3)) {
      bool = true;
    }
    if ((this.jdField_a_of_type_Int == 0) || (bool != paramBoolean)) {
      NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "dating_recv_msg", Boolean.valueOf(paramBoolean));
    }
    if (paramBoolean) {}
    for (;;)
    {
      this.jdField_a_of_type_Int = i;
      return;
      i = 2;
    }
  }
  
  void a(boolean paramBoolean, Object... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEventRuntime((String)paramVarArgs[0], (String)paramVarArgs[1], (String)paramVarArgs[2], (String)paramVarArgs[3], (String)paramVarArgs[4], ((Integer)paramVarArgs[5]).intValue(), ((Integer)paramVarArgs[6]).intValue(), (String)paramVarArgs[7], (String)paramVarArgs[8], (String)paramVarArgs[9], (String)paramVarArgs[10]);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent((String)paramVarArgs[0], (String)paramVarArgs[1], (String)paramVarArgs[2], (String)paramVarArgs[3], (String)paramVarArgs[4], ((Integer)paramVarArgs[5]).intValue(), ((Integer)paramVarArgs[6]).intValue(), (String)paramVarArgs[7], (String)paramVarArgs[8], (String)paramVarArgs[9], (String)paramVarArgs[10]);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      if (!NearbySPUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label45;
      }
    }
    label45:
    for (int i = 3;; i = 4)
    {
      this.jdField_a_of_type_Int = i;
      if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 3)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  /* Error */
  public Object[] a(Context paramContext, int paramInt, Object... paramVarArgs)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iload_2
    //   4: tableswitch	default:+232 -> 236, 4098:+294->298, 4099:+302->306, 4100:+232->236, 4101:+232->236, 4102:+310->314, 4103:+400->404, 4104:+361->365, 4105:+325->329, 4106:+232->236, 4107:+234->238, 4108:+966->970, 4109:+1024->1028, 4110:+626->630, 4111:+704->708, 4112:+770->774, 4113:+232->236, 4114:+232->236, 4115:+232->236, 4116:+232->236, 4117:+232->236, 4118:+232->236, 4119:+486->490, 4120:+516->520, 4121:+584->588, 4122:+812->816, 4123:+915->919, 4124:+232->236, 4125:+232->236, 4126:+232->236, 4127:+1008->1012, 4128:+1107->1111, 4129:+1163->1167, 4130:+1209->1213, 4131:+232->236, 4132:+1244->1248, 4133:+232->236, 4134:+232->236, 4135:+232->236, 4136:+1262->1266, 4137:+232->236, 4138:+232->236, 4139:+232->236, 4140:+232->236, 4141:+1342->1346, 4142:+1505->1509, 4143:+232->236, 4144:+232->236, 4145:+1560->1564, 4146:+232->236, 4147:+1630->1634, 4148:+1671->1675, 4149:+1712->1716, 4150:+1781->1785, 4151:+1973->1977
    //   237: areturn
    //   238: aload_3
    //   239: ifnull -3 -> 236
    //   242: aload_3
    //   243: arraylength
    //   244: iconst_3
    //   245: if_icmpne -9 -> 236
    //   248: iconst_1
    //   249: anewarray 4	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: aload_0
    //   255: getfield 58	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   258: bipush 70
    //   260: invokevirtual 298	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   263: checkcast 669	com/tencent/mobileqq/dating/DatingProxyManager
    //   266: invokevirtual 672	com/tencent/mobileqq/dating/DatingProxyManager:a	()Lcom/tencent/mobileqq/dating/StrangerHdHeadUrlFetcher;
    //   269: aload_3
    //   270: iconst_0
    //   271: aaload
    //   272: checkcast 400	java/lang/String
    //   275: aload_3
    //   276: iconst_1
    //   277: aaload
    //   278: checkcast 421	java/lang/Integer
    //   281: invokevirtual 655	java/lang/Integer:intValue	()I
    //   284: aload_3
    //   285: iconst_2
    //   286: aaload
    //   287: checkcast 156	java/lang/Boolean
    //   290: invokevirtual 675	java/lang/Boolean:booleanValue	()Z
    //   293: invokevirtual 680	com/tencent/mobileqq/dating/StrangerHdHeadUrlFetcher:a	(Ljava/lang/String;IZ)Ljava/lang/String;
    //   296: aastore
    //   297: areturn
    //   298: aload_0
    //   299: iconst_0
    //   300: aload_3
    //   301: invokevirtual 682	com/tencent/mobileqq/nearby/NearbyProxy:a	(Z[Ljava/lang/Object;)V
    //   304: aconst_null
    //   305: areturn
    //   306: aload_0
    //   307: iconst_1
    //   308: aload_3
    //   309: invokevirtual 682	com/tencent/mobileqq/nearby/NearbyProxy:a	(Z[Ljava/lang/Object;)V
    //   312: aconst_null
    //   313: areturn
    //   314: new 684	adzg
    //   317: dup
    //   318: aload_0
    //   319: invokespecial 685	adzg:<init>	(Lcom/tencent/mobileqq/nearby/NearbyProxy;)V
    //   322: aconst_null
    //   323: iconst_1
    //   324: invokestatic 689	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   327: aconst_null
    //   328: areturn
    //   329: aload_3
    //   330: ifnull -94 -> 236
    //   333: iconst_1
    //   334: anewarray 4	java/lang/Object
    //   337: dup
    //   338: iconst_0
    //   339: aload_0
    //   340: getfield 58	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   343: bipush 35
    //   345: invokevirtual 298	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   348: checkcast 691	com/tencent/mobileqq/redtouch/RedTouchManager
    //   351: aload_3
    //   352: iconst_0
    //   353: aaload
    //   354: checkcast 400	java/lang/String
    //   357: invokevirtual 694	com/tencent/mobileqq/redtouch/RedTouchManager:a	(Ljava/lang/String;)Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   360: invokevirtual 697	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:toByteArray	()[B
    //   363: aastore
    //   364: areturn
    //   365: aload_3
    //   366: ifnull -130 -> 236
    //   369: iconst_1
    //   370: anewarray 4	java/lang/Object
    //   373: dup
    //   374: iconst_0
    //   375: aload_0
    //   376: getfield 58	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   379: bipush 35
    //   381: invokevirtual 298	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   384: checkcast 691	com/tencent/mobileqq/redtouch/RedTouchManager
    //   387: aload_3
    //   388: iconst_0
    //   389: aaload
    //   390: checkcast 421	java/lang/Integer
    //   393: invokevirtual 655	java/lang/Integer:intValue	()I
    //   396: invokevirtual 700	com/tencent/mobileqq/redtouch/RedTouchManager:a	(I)Z
    //   399: invokestatic 160	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   402: aastore
    //   403: areturn
    //   404: aload_3
    //   405: ifnull -169 -> 236
    //   408: aload_3
    //   409: arraylength
    //   410: bipush 6
    //   412: if_icmplt +1625 -> 2037
    //   415: aload_3
    //   416: iconst_5
    //   417: aaload
    //   418: checkcast 156	java/lang/Boolean
    //   421: invokevirtual 675	java/lang/Boolean:booleanValue	()Z
    //   424: istore 4
    //   426: aload_0
    //   427: getfield 58	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   430: aload_3
    //   431: iconst_0
    //   432: aaload
    //   433: checkcast 421	java/lang/Integer
    //   436: invokevirtual 655	java/lang/Integer:intValue	()I
    //   439: aload_3
    //   440: iconst_1
    //   441: aaload
    //   442: checkcast 421	java/lang/Integer
    //   445: invokevirtual 655	java/lang/Integer:intValue	()I
    //   448: aload_3
    //   449: iconst_2
    //   450: aaload
    //   451: checkcast 400	java/lang/String
    //   454: aload_3
    //   455: iconst_3
    //   456: aaload
    //   457: checkcast 400	java/lang/String
    //   460: aload_3
    //   461: iconst_4
    //   462: aaload
    //   463: checkcast 156	java/lang/Boolean
    //   466: invokevirtual 675	java/lang/Boolean:booleanValue	()Z
    //   469: invokestatic 705	com/tencent/mobileqq/nearpeople/mytab/NearbyMineHelper:a	(Lcom/tencent/common/app/AppInterface;IILjava/lang/String;Ljava/lang/String;Z)Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   472: astore_1
    //   473: iload 4
    //   475: ifeq -239 -> 236
    //   478: iconst_1
    //   479: anewarray 4	java/lang/Object
    //   482: dup
    //   483: iconst_0
    //   484: aload_1
    //   485: invokevirtual 697	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:toByteArray	()[B
    //   488: aastore
    //   489: areturn
    //   490: aload_3
    //   491: ifnull -255 -> 236
    //   494: aload_3
    //   495: iconst_0
    //   496: aaload
    //   497: checkcast 400	java/lang/String
    //   500: astore_1
    //   501: iconst_1
    //   502: anewarray 4	java/lang/Object
    //   505: dup
    //   506: iconst_0
    //   507: aload_0
    //   508: getfield 58	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   511: aload_1
    //   512: invokestatic 710	com/tencent/mobileqq/activity/recent/RecentUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   515: invokestatic 160	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   518: aastore
    //   519: areturn
    //   520: aload_3
    //   521: ifnull -285 -> 236
    //   524: aload_3
    //   525: iconst_0
    //   526: aaload
    //   527: checkcast 400	java/lang/String
    //   530: astore_1
    //   531: aload_3
    //   532: iconst_1
    //   533: aaload
    //   534: checkcast 400	java/lang/String
    //   537: astore 6
    //   539: aload_3
    //   540: iconst_2
    //   541: aaload
    //   542: checkcast 421	java/lang/Integer
    //   545: invokevirtual 655	java/lang/Integer:intValue	()I
    //   548: istore_2
    //   549: aload_3
    //   550: iconst_3
    //   551: aaload
    //   552: checkcast 156	java/lang/Boolean
    //   555: invokevirtual 675	java/lang/Boolean:booleanValue	()Z
    //   558: istore 4
    //   560: aload_3
    //   561: iconst_4
    //   562: aaload
    //   563: checkcast 156	java/lang/Boolean
    //   566: invokevirtual 675	java/lang/Boolean:booleanValue	()Z
    //   569: istore 5
    //   571: aload_0
    //   572: getfield 58	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   575: aload_1
    //   576: aload 6
    //   578: iload_2
    //   579: iload 4
    //   581: iload 5
    //   583: invokestatic 715	com/tencent/mobileqq/app/message/AddMessageHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;IZZ)V
    //   586: aconst_null
    //   587: areturn
    //   588: aload_3
    //   589: ifnull -353 -> 236
    //   592: aload_3
    //   593: iconst_0
    //   594: aaload
    //   595: checkcast 400	java/lang/String
    //   598: astore_1
    //   599: aload_3
    //   600: iconst_1
    //   601: aaload
    //   602: checkcast 400	java/lang/String
    //   605: astore 6
    //   607: aload_3
    //   608: iconst_2
    //   609: aaload
    //   610: checkcast 421	java/lang/Integer
    //   613: invokevirtual 655	java/lang/Integer:intValue	()I
    //   616: istore_2
    //   617: aload_0
    //   618: getfield 58	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   621: aload_1
    //   622: aload 6
    //   624: iload_2
    //   625: invokestatic 718	com/tencent/mobileqq/app/message/AddMessageHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;I)V
    //   628: aconst_null
    //   629: areturn
    //   630: aload_3
    //   631: ifnull +9 -> 640
    //   634: aload_3
    //   635: arraylength
    //   636: iconst_2
    //   637: if_icmpge +15 -> 652
    //   640: iconst_1
    //   641: anewarray 4	java/lang/Object
    //   644: dup
    //   645: iconst_0
    //   646: iconst_0
    //   647: invokestatic 160	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   650: aastore
    //   651: areturn
    //   652: aload_0
    //   653: getfield 58	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   656: aload_0
    //   657: getfield 56	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppMessageObserver	Lcom/tencent/mobileqq/app/MessageObserver;
    //   660: invokevirtual 722	com/tencent/mobileqq/app/QQAppInterface:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   663: aload_0
    //   664: getfield 58	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   667: iconst_0
    //   668: invokevirtual 725	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   671: checkcast 727	com/tencent/mobileqq/app/MessageHandler
    //   674: aload_3
    //   675: iconst_0
    //   676: aaload
    //   677: checkcast 521	java/lang/Long
    //   680: invokevirtual 731	java/lang/Long:longValue	()J
    //   683: aload_3
    //   684: iconst_1
    //   685: aaload
    //   686: checkcast 421	java/lang/Integer
    //   689: invokevirtual 655	java/lang/Integer:intValue	()I
    //   692: iconst_1
    //   693: invokevirtual 734	com/tencent/mobileqq/app/MessageHandler:b	(JII)V
    //   696: iconst_1
    //   697: anewarray 4	java/lang/Object
    //   700: dup
    //   701: iconst_0
    //   702: iconst_1
    //   703: invokestatic 160	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   706: aastore
    //   707: areturn
    //   708: aload_3
    //   709: ifnull +9 -> 718
    //   712: aload_3
    //   713: arraylength
    //   714: iconst_1
    //   715: if_icmpge +15 -> 730
    //   718: iconst_1
    //   719: anewarray 4	java/lang/Object
    //   722: dup
    //   723: iconst_0
    //   724: iconst_0
    //   725: invokestatic 160	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   728: aastore
    //   729: areturn
    //   730: aload_0
    //   731: getfield 58	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   734: aload_0
    //   735: getfield 56	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppMessageObserver	Lcom/tencent/mobileqq/app/MessageObserver;
    //   738: invokevirtual 722	com/tencent/mobileqq/app/QQAppInterface:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   741: aload_0
    //   742: getfield 58	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   745: iconst_0
    //   746: invokevirtual 725	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   749: checkcast 727	com/tencent/mobileqq/app/MessageHandler
    //   752: aload_3
    //   753: iconst_0
    //   754: aaload
    //   755: checkcast 400	java/lang/String
    //   758: iconst_1
    //   759: invokevirtual 736	com/tencent/mobileqq/app/MessageHandler:b	(Ljava/lang/String;I)V
    //   762: iconst_1
    //   763: anewarray 4	java/lang/Object
    //   766: dup
    //   767: iconst_0
    //   768: iconst_1
    //   769: invokestatic 160	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   772: aastore
    //   773: areturn
    //   774: aload_3
    //   775: ifnull -539 -> 236
    //   778: aload_3
    //   779: arraylength
    //   780: iconst_1
    //   781: if_icmplt -545 -> 236
    //   784: iconst_1
    //   785: anewarray 4	java/lang/Object
    //   788: dup
    //   789: iconst_0
    //   790: aload_0
    //   791: getfield 58	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   794: bipush 15
    //   796: invokevirtual 298	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   799: checkcast 738	com/tencent/mobileqq/managers/ShieldMsgManger
    //   802: aload_3
    //   803: iconst_0
    //   804: aaload
    //   805: checkcast 400	java/lang/String
    //   808: invokevirtual 740	com/tencent/mobileqq/managers/ShieldMsgManger:a	(Ljava/lang/String;)Z
    //   811: invokestatic 160	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   814: aastore
    //   815: areturn
    //   816: aload_3
    //   817: ifnull -581 -> 236
    //   820: aload_3
    //   821: arraylength
    //   822: iconst_3
    //   823: if_icmplt -587 -> 236
    //   826: aload_3
    //   827: iconst_0
    //   828: aaload
    //   829: checkcast 400	java/lang/String
    //   832: astore 7
    //   834: aload_3
    //   835: iconst_1
    //   836: aaload
    //   837: ifnull +1194 -> 2031
    //   840: aload_3
    //   841: iconst_1
    //   842: aaload
    //   843: checkcast 742	[B
    //   846: checkcast 742	[B
    //   849: astore_1
    //   850: new 539	tencent/im/oidb/cmd0x686/Oidb_0x686$CharmEvent
    //   853: dup
    //   854: invokespecial 743	tencent/im/oidb/cmd0x686/Oidb_0x686$CharmEvent:<init>	()V
    //   857: astore 6
    //   859: aload 6
    //   861: aload_1
    //   862: invokevirtual 747	tencent/im/oidb/cmd0x686/Oidb_0x686$CharmEvent:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   865: pop
    //   866: aload_3
    //   867: iconst_2
    //   868: aaload
    //   869: ifnull +1157 -> 2026
    //   872: aload_3
    //   873: iconst_2
    //   874: aaload
    //   875: checkcast 742	[B
    //   878: checkcast 742	[B
    //   881: astore_3
    //   882: new 549	tencent/im/oidb/cmd0x686/Oidb_0x686$NearbyCharmNotify
    //   885: dup
    //   886: invokespecial 748	tencent/im/oidb/cmd0x686/Oidb_0x686$NearbyCharmNotify:<init>	()V
    //   889: astore_1
    //   890: aload_1
    //   891: aload_3
    //   892: invokevirtual 749	tencent/im/oidb/cmd0x686/Oidb_0x686$NearbyCharmNotify:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   895: pop
    //   896: aload_0
    //   897: getfield 58	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   900: aload 7
    //   902: aload 6
    //   904: aload_1
    //   905: invokestatic 537	com/tencent/mobileqq/nearby/NearbyCardManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ltencent/im/oidb/cmd0x686/Oidb_0x686$CharmEvent;Ltencent/im/oidb/cmd0x686/Oidb_0x686$NearbyCharmNotify;)V
    //   908: aconst_null
    //   909: areturn
    //   910: astore_1
    //   911: aconst_null
    //   912: astore_1
    //   913: aload_1
    //   914: astore 6
    //   916: goto -50 -> 866
    //   919: aload_3
    //   920: ifnull -684 -> 236
    //   923: aload_3
    //   924: arraylength
    //   925: iconst_1
    //   926: if_icmplt -690 -> 236
    //   929: aload_3
    //   930: iconst_0
    //   931: aaload
    //   932: checkcast 742	[B
    //   935: checkcast 742	[B
    //   938: astore_3
    //   939: new 569	tencent/im/oidb/cmd0x9c7/cmd0x9c7$RspBody
    //   942: dup
    //   943: invokespecial 750	tencent/im/oidb/cmd0x9c7/cmd0x9c7$RspBody:<init>	()V
    //   946: astore_1
    //   947: aload_1
    //   948: aload_3
    //   949: invokevirtual 751	tencent/im/oidb/cmd0x9c7/cmd0x9c7$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   952: pop
    //   953: aload_0
    //   954: aload_1
    //   955: invokevirtual 753	com/tencent/mobileqq/nearby/NearbyProxy:a	(Ltencent/im/oidb/cmd0x9c7/cmd0x9c7$RspBody;)V
    //   958: aconst_null
    //   959: areturn
    //   960: astore_3
    //   961: aconst_null
    //   962: astore_1
    //   963: aload_3
    //   964: invokevirtual 756	java/lang/Exception:printStackTrace	()V
    //   967: goto -14 -> 953
    //   970: aload_3
    //   971: ifnull -735 -> 236
    //   974: aload_3
    //   975: arraylength
    //   976: iconst_1
    //   977: if_icmplt -741 -> 236
    //   980: aload_3
    //   981: iconst_0
    //   982: aaload
    //   983: instanceof 758
    //   986: ifeq -750 -> 236
    //   989: aload_3
    //   990: iconst_0
    //   991: aaload
    //   992: checkcast 758	java/lang/Byte
    //   995: invokevirtual 762	java/lang/Byte:byteValue	()B
    //   998: ifne +6 -> 1004
    //   1001: iconst_1
    //   1002: istore 4
    //   1004: aload_0
    //   1005: iload 4
    //   1007: invokevirtual 764	com/tencent/mobileqq/nearby/NearbyProxy:a	(Z)V
    //   1010: aconst_null
    //   1011: areturn
    //   1012: aload_0
    //   1013: getfield 355	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqNearbyNearbyConfigUtil	Lcom/tencent/mobileqq/nearby/NearbyConfigUtil;
    //   1016: ifnull -780 -> 236
    //   1019: aload_0
    //   1020: getfield 355	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqNearbyNearbyConfigUtil	Lcom/tencent/mobileqq/nearby/NearbyConfigUtil;
    //   1023: invokevirtual 766	com/tencent/mobileqq/nearby/NearbyConfigUtil:a	()V
    //   1026: aconst_null
    //   1027: areturn
    //   1028: aload_3
    //   1029: ifnull -793 -> 236
    //   1032: aload_3
    //   1033: arraylength
    //   1034: iconst_1
    //   1035: if_icmpne -799 -> 236
    //   1038: aload_3
    //   1039: iconst_0
    //   1040: aaload
    //   1041: instanceof 742
    //   1044: ifeq -808 -> 236
    //   1047: aload_3
    //   1048: iconst_0
    //   1049: aaload
    //   1050: checkcast 742	[B
    //   1053: checkcast 742	[B
    //   1056: astore_3
    //   1057: aload_3
    //   1058: ifnull -822 -> 236
    //   1061: aload_3
    //   1062: arraylength
    //   1063: ifle -827 -> 236
    //   1066: new 768	tencent/im/oidb/cmd0x8dd/oidb_0x8dd$SelfInfo
    //   1069: dup
    //   1070: invokespecial 769	tencent/im/oidb/cmd0x8dd/oidb_0x8dd$SelfInfo:<init>	()V
    //   1073: astore_1
    //   1074: aload_1
    //   1075: aload_3
    //   1076: invokevirtual 770	tencent/im/oidb/cmd0x8dd/oidb_0x8dd$SelfInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1079: pop
    //   1080: aload_0
    //   1081: getfield 58	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1084: bipush 105
    //   1086: invokevirtual 298	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1089: checkcast 534	com/tencent/mobileqq/nearby/NearbyCardManager
    //   1092: astore_3
    //   1093: aload_3
    //   1094: ifnull -858 -> 236
    //   1097: aload_3
    //   1098: aload_1
    //   1099: invokevirtual 773	com/tencent/mobileqq/nearby/NearbyCardManager:a	(Ltencent/im/oidb/cmd0x8dd/oidb_0x8dd$SelfInfo;)V
    //   1102: aconst_null
    //   1103: areturn
    //   1104: astore_1
    //   1105: aload_1
    //   1106: invokevirtual 756	java/lang/Exception:printStackTrace	()V
    //   1109: aconst_null
    //   1110: areturn
    //   1111: aload_0
    //   1112: getfield 775	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   1115: ifnonnull +19 -> 1134
    //   1118: aload_0
    //   1119: aload_0
    //   1120: getfield 58	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1123: bipush 58
    //   1125: invokevirtual 298	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1128: checkcast 777	com/tencent/mobileqq/app/ConditionSearchManager
    //   1131: putfield 775	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   1134: aload_0
    //   1135: new 779	adzk
    //   1138: dup
    //   1139: aload_0
    //   1140: invokespecial 780	adzk:<init>	(Lcom/tencent/mobileqq/nearby/NearbyProxy;)V
    //   1143: putfield 782	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener	Lcom/tencent/mobileqq/app/ConditionSearchManager$IConfigListener;
    //   1146: aload_0
    //   1147: getfield 775	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   1150: aload_0
    //   1151: invokevirtual 785	com/tencent/mobileqq/app/ConditionSearchManager:a	(Ljava/lang/Object;)V
    //   1154: aload_0
    //   1155: getfield 775	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   1158: aload_0
    //   1159: getfield 782	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener	Lcom/tencent/mobileqq/app/ConditionSearchManager$IConfigListener;
    //   1162: invokevirtual 787	com/tencent/mobileqq/app/ConditionSearchManager:c	(Ljava/lang/Object;)V
    //   1165: aconst_null
    //   1166: areturn
    //   1167: aload_3
    //   1168: ifnull -932 -> 236
    //   1171: aload_3
    //   1172: arraylength
    //   1173: iconst_1
    //   1174: if_icmpne -938 -> 236
    //   1177: aload_3
    //   1178: iconst_0
    //   1179: aaload
    //   1180: checkcast 400	java/lang/String
    //   1183: astore_1
    //   1184: aload_0
    //   1185: getfield 775	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   1188: ifnull +25 -> 1213
    //   1191: iconst_1
    //   1192: anewarray 4	java/lang/Object
    //   1195: dup
    //   1196: iconst_0
    //   1197: aload_0
    //   1198: getfield 775	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   1201: aload_1
    //   1202: ldc_w 789
    //   1205: invokevirtual 793	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1208: invokevirtual 796	com/tencent/mobileqq/app/ConditionSearchManager:a	([Ljava/lang/String;)[Ljava/lang/String;
    //   1211: aastore
    //   1212: areturn
    //   1213: aload_0
    //   1214: getfield 775	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   1217: ifnull -981 -> 236
    //   1220: aload_0
    //   1221: getfield 775	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   1224: aload_0
    //   1225: invokevirtual 798	com/tencent/mobileqq/app/ConditionSearchManager:b	(Ljava/lang/Object;)V
    //   1228: aload_0
    //   1229: getfield 782	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener	Lcom/tencent/mobileqq/app/ConditionSearchManager$IConfigListener;
    //   1232: ifnull -996 -> 236
    //   1235: aload_0
    //   1236: getfield 775	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   1239: aload_0
    //   1240: getfield 782	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener	Lcom/tencent/mobileqq/app/ConditionSearchManager$IConfigListener;
    //   1243: invokevirtual 800	com/tencent/mobileqq/app/ConditionSearchManager:d	(Ljava/lang/Object;)V
    //   1246: aconst_null
    //   1247: areturn
    //   1248: aload_0
    //   1249: getfield 58	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1252: bipush 105
    //   1254: invokevirtual 298	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1257: checkcast 534	com/tencent/mobileqq/nearby/NearbyCardManager
    //   1260: iconst_1
    //   1261: putfield 801	com/tencent/mobileqq/nearby/NearbyCardManager:a	Z
    //   1264: aconst_null
    //   1265: areturn
    //   1266: aload_3
    //   1267: ifnull -1031 -> 236
    //   1270: aload_3
    //   1271: arraylength
    //   1272: bipush 6
    //   1274: if_icmpne -1038 -> 236
    //   1277: aload_3
    //   1278: iconst_0
    //   1279: aaload
    //   1280: checkcast 421	java/lang/Integer
    //   1283: invokevirtual 655	java/lang/Integer:intValue	()I
    //   1286: istore_2
    //   1287: aload_3
    //   1288: iconst_1
    //   1289: aaload
    //   1290: checkcast 400	java/lang/String
    //   1293: astore 6
    //   1295: aload_3
    //   1296: iconst_2
    //   1297: aaload
    //   1298: checkcast 400	java/lang/String
    //   1301: astore 7
    //   1303: aload_3
    //   1304: iconst_3
    //   1305: aaload
    //   1306: checkcast 400	java/lang/String
    //   1309: astore 8
    //   1311: aload_3
    //   1312: iconst_4
    //   1313: aaload
    //   1314: checkcast 400	java/lang/String
    //   1317: astore 9
    //   1319: aload_3
    //   1320: iconst_5
    //   1321: aaload
    //   1322: checkcast 400	java/lang/String
    //   1325: astore_3
    //   1326: aload_1
    //   1327: aload_0
    //   1328: getfield 58	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1331: iload_2
    //   1332: aload 6
    //   1334: aload 7
    //   1336: aload 8
    //   1338: aload 9
    //   1340: aload_3
    //   1341: invokestatic 806	com/tencent/biz/webviewplugin/ReportPlugin:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1344: aconst_null
    //   1345: areturn
    //   1346: aload_3
    //   1347: ifnull -1111 -> 236
    //   1350: aload_3
    //   1351: arraylength
    //   1352: iconst_1
    //   1353: if_icmpne -1117 -> 236
    //   1356: aload_0
    //   1357: getfield 58	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1360: sipush 159
    //   1363: invokevirtual 298	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1366: checkcast 808	com/tencent/mobileqq/nearby/redtouch/LocalRedTouchManager
    //   1369: aload_3
    //   1370: iconst_0
    //   1371: aaload
    //   1372: checkcast 421	java/lang/Integer
    //   1375: invokevirtual 655	java/lang/Integer:intValue	()I
    //   1378: invokevirtual 811	com/tencent/mobileqq/nearby/redtouch/LocalRedTouchManager:a	(I)Lcom/tencent/mobileqq/nearby/redtouch/RedTouchItem;
    //   1381: astore_1
    //   1382: aload_1
    //   1383: ifnull -1147 -> 236
    //   1386: bipush 12
    //   1388: anewarray 4	java/lang/Object
    //   1391: dup
    //   1392: iconst_0
    //   1393: aload_1
    //   1394: getfield 816	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:taskId	I
    //   1397: invokestatic 424	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1400: aastore
    //   1401: dup
    //   1402: iconst_1
    //   1403: aload_1
    //   1404: getfield 819	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:curSeq	J
    //   1407: invokestatic 524	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1410: aastore
    //   1411: dup
    //   1412: iconst_2
    //   1413: aload_1
    //   1414: getfield 822	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:redtouchType	I
    //   1417: invokestatic 424	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1420: aastore
    //   1421: dup
    //   1422: iconst_3
    //   1423: aload_1
    //   1424: getfield 825	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:count	I
    //   1427: invokestatic 424	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1430: aastore
    //   1431: dup
    //   1432: iconst_4
    //   1433: aload_1
    //   1434: getfield 828	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:icon	Ljava/lang/String;
    //   1437: aastore
    //   1438: dup
    //   1439: iconst_5
    //   1440: aload_1
    //   1441: getfield 831	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:tips	Ljava/lang/String;
    //   1444: aastore
    //   1445: dup
    //   1446: bipush 6
    //   1448: aload_1
    //   1449: getfield 834	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:receiveTime	J
    //   1452: invokestatic 524	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1455: aastore
    //   1456: dup
    //   1457: bipush 7
    //   1459: aload_1
    //   1460: getfield 837	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:validTimeRemained	I
    //   1463: invokestatic 424	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1466: aastore
    //   1467: dup
    //   1468: bipush 8
    //   1470: aload_1
    //   1471: getfield 840	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:unReadFlag	Z
    //   1474: invokestatic 160	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1477: aastore
    //   1478: dup
    //   1479: bipush 9
    //   1481: aload_1
    //   1482: getfield 843	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:passThroughLevel	I
    //   1485: invokestatic 424	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1488: aastore
    //   1489: dup
    //   1490: bipush 10
    //   1492: aload_1
    //   1493: getfield 846	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:configVersion	Ljava/lang/String;
    //   1496: aastore
    //   1497: dup
    //   1498: bipush 11
    //   1500: aload_1
    //   1501: getfield 849	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:isClosed	Z
    //   1504: invokestatic 160	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1507: aastore
    //   1508: areturn
    //   1509: aload_3
    //   1510: ifnull -1274 -> 236
    //   1513: aload_3
    //   1514: arraylength
    //   1515: iconst_1
    //   1516: if_icmpne -1280 -> 236
    //   1519: aload_3
    //   1520: iconst_0
    //   1521: aaload
    //   1522: checkcast 742	[B
    //   1525: checkcast 742	[B
    //   1528: astore_1
    //   1529: aload_0
    //   1530: getfield 58	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1533: sipush 179
    //   1536: invokevirtual 298	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1539: checkcast 300	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager
    //   1542: aload_1
    //   1543: invokevirtual 852	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager:a	([B)V
    //   1546: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1549: ifeq -1313 -> 236
    //   1552: ldc_w 278
    //   1555: iconst_2
    //   1556: ldc_w 854
    //   1559: invokestatic 284	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1562: aconst_null
    //   1563: areturn
    //   1564: aload_3
    //   1565: ifnull -1329 -> 236
    //   1568: aload_3
    //   1569: iconst_0
    //   1570: aaload
    //   1571: checkcast 400	java/lang/String
    //   1574: astore_1
    //   1575: aload_0
    //   1576: getfield 58	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1579: bipush 105
    //   1581: invokevirtual 298	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1584: checkcast 534	com/tencent/mobileqq/nearby/NearbyCardManager
    //   1587: getfield 857	com/tencent/mobileqq/nearby/NearbyCardManager:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   1590: aload_1
    //   1591: iconst_1
    //   1592: invokestatic 424	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1595: invokevirtual 863	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1598: pop
    //   1599: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1602: ifeq -1366 -> 236
    //   1605: ldc_w 865
    //   1608: iconst_2
    //   1609: new 102	java/lang/StringBuilder
    //   1612: dup
    //   1613: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   1616: ldc_w 867
    //   1619: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1622: aload_1
    //   1623: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1626: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1629: invokestatic 284	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1632: aconst_null
    //   1633: areturn
    //   1634: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1637: ifeq +13 -> 1650
    //   1640: ldc_w 342
    //   1643: iconst_2
    //   1644: ldc_w 869
    //   1647: invokestatic 460	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1650: new 871	android/os/Handler
    //   1653: dup
    //   1654: invokestatic 877	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   1657: invokespecial 880	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   1660: new 882	adzl
    //   1663: dup
    //   1664: aload_0
    //   1665: aload_1
    //   1666: invokespecial 885	adzl:<init>	(Lcom/tencent/mobileqq/nearby/NearbyProxy;Landroid/content/Context;)V
    //   1669: invokevirtual 886	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1672: pop
    //   1673: aconst_null
    //   1674: areturn
    //   1675: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1678: ifeq +13 -> 1691
    //   1681: ldc_w 342
    //   1684: iconst_2
    //   1685: ldc_w 888
    //   1688: invokestatic 460	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1691: new 871	android/os/Handler
    //   1694: dup
    //   1695: invokestatic 877	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   1698: invokespecial 880	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   1701: new 890	adzm
    //   1704: dup
    //   1705: aload_0
    //   1706: aload_1
    //   1707: invokespecial 891	adzm:<init>	(Lcom/tencent/mobileqq/nearby/NearbyProxy;Landroid/content/Context;)V
    //   1710: invokevirtual 886	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1713: pop
    //   1714: aconst_null
    //   1715: areturn
    //   1716: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1719: ifeq +13 -> 1732
    //   1722: ldc_w 342
    //   1725: iconst_2
    //   1726: ldc_w 893
    //   1729: invokestatic 460	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1732: aload_0
    //   1733: getfield 58	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1736: bipush 50
    //   1738: invokevirtual 298	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1741: checkcast 895	com/tencent/mobileqq/app/FriendsManager
    //   1744: astore_1
    //   1745: aload_1
    //   1746: ifnonnull +24 -> 1770
    //   1749: aconst_null
    //   1750: astore_1
    //   1751: aload_1
    //   1752: ifnull -1516 -> 236
    //   1755: iconst_1
    //   1756: anewarray 4	java/lang/Object
    //   1759: dup
    //   1760: iconst_0
    //   1761: aload_1
    //   1762: getfield 901	com/tencent/mobileqq/data/Card:shGender	S
    //   1765: invokestatic 906	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   1768: aastore
    //   1769: areturn
    //   1770: aload_1
    //   1771: aload_0
    //   1772: getfield 58	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1775: invokevirtual 605	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1778: invokevirtual 909	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   1781: astore_1
    //   1782: goto -31 -> 1751
    //   1785: aload_3
    //   1786: iconst_0
    //   1787: aaload
    //   1788: checkcast 421	java/lang/Integer
    //   1791: astore_1
    //   1792: aload_0
    //   1793: getfield 58	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1796: bipush 69
    //   1798: invokevirtual 298	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1801: checkcast 911	com/tencent/biz/TroopRedpoint/TroopRedTouchManager
    //   1804: astore_3
    //   1805: aload_1
    //   1806: invokevirtual 655	java/lang/Integer:intValue	()I
    //   1809: tableswitch	default:+55 -> 1864, 1:+81->1890, 2:+89->1898, 3:+121->1930, 4:+105->1914, 5:+129->1938, 6:+73->1882, 7:+97->1906, 8:+113->1922, 9:+152->1961, 10:+160->1969
    //   1865: astore_1
    //   1866: aload_1
    //   1867: ifnull -1631 -> 236
    //   1870: iconst_1
    //   1871: anewarray 4	java/lang/Object
    //   1874: dup
    //   1875: iconst_0
    //   1876: aload_1
    //   1877: invokevirtual 914	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:toByteArray	()[B
    //   1880: aastore
    //   1881: areturn
    //   1882: aload_3
    //   1883: invokevirtual 918	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:g	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1886: astore_1
    //   1887: goto -21 -> 1866
    //   1890: aload_3
    //   1891: invokevirtual 920	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:a	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1894: astore_1
    //   1895: goto -29 -> 1866
    //   1898: aload_3
    //   1899: invokevirtual 922	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:b	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1902: astore_1
    //   1903: goto -37 -> 1866
    //   1906: aload_3
    //   1907: invokevirtual 925	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:h	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1910: astore_1
    //   1911: goto -45 -> 1866
    //   1914: aload_3
    //   1915: invokevirtual 927	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:d	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1918: astore_1
    //   1919: goto -53 -> 1866
    //   1922: aload_3
    //   1923: invokevirtual 929	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:i	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1926: astore_1
    //   1927: goto -61 -> 1866
    //   1930: aload_3
    //   1931: invokevirtual 931	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:c	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1934: astore_1
    //   1935: goto -69 -> 1866
    //   1938: aload_3
    //   1939: invokevirtual 932	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:a	()Z
    //   1942: ifeq +14 -> 1956
    //   1945: new 913	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   1948: dup
    //   1949: invokespecial 933	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   1952: astore_1
    //   1953: goto -87 -> 1866
    //   1956: aconst_null
    //   1957: astore_1
    //   1958: goto -92 -> 1866
    //   1961: aload_3
    //   1962: invokevirtual 936	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:j	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1965: astore_1
    //   1966: goto -100 -> 1866
    //   1969: aload_3
    //   1970: invokevirtual 939	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:f	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;
    //   1973: astore_1
    //   1974: goto -108 -> 1866
    //   1977: aload_3
    //   1978: iconst_0
    //   1979: aaload
    //   1980: checkcast 421	java/lang/Integer
    //   1983: astore_1
    //   1984: aload_0
    //   1985: getfield 58	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1988: bipush 69
    //   1990: invokevirtual 298	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1993: checkcast 911	com/tencent/biz/TroopRedpoint/TroopRedTouchManager
    //   1996: aload_1
    //   1997: invokevirtual 655	java/lang/Integer:intValue	()I
    //   2000: invokevirtual 941	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:a	(I)V
    //   2003: aconst_null
    //   2004: areturn
    //   2005: astore_3
    //   2006: goto -1043 -> 963
    //   2009: astore_1
    //   2010: aconst_null
    //   2011: astore_1
    //   2012: goto -1116 -> 896
    //   2015: astore_3
    //   2016: goto -1120 -> 896
    //   2019: astore_1
    //   2020: aload 6
    //   2022: astore_1
    //   2023: goto -1110 -> 913
    //   2026: aconst_null
    //   2027: astore_1
    //   2028: goto -1132 -> 896
    //   2031: aconst_null
    //   2032: astore 6
    //   2034: goto -1168 -> 866
    //   2037: iconst_0
    //   2038: istore 4
    //   2040: goto -1614 -> 426
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2043	0	this	NearbyProxy
    //   0	2043	1	paramContext	Context
    //   0	2043	2	paramInt	int
    //   0	2043	3	paramVarArgs	Object[]
    //   1	2038	4	bool1	boolean
    //   569	13	5	bool2	boolean
    //   537	1496	6	localObject	Object
    //   832	503	7	str1	String
    //   1309	28	8	str2	String
    //   1317	22	9	str3	String
    // Exception table:
    //   from	to	target	type
    //   840	859	910	java/lang/Throwable
    //   929	947	960	java/lang/Exception
    //   1066	1093	1104	java/lang/Exception
    //   1097	1102	1104	java/lang/Exception
    //   947	953	2005	java/lang/Exception
    //   872	890	2009	java/lang/Throwable
    //   890	896	2015	java/lang/Throwable
    //   859	866	2019	java/lang/Throwable
  }
  
  public void b()
  {
    if (ConnectNearbyProcService.a()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(4100, new Object[] { Integer.valueOf(7) });
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("hasUnreadMsg", new Object[] { Boolean.valueOf(ConnectNearbyProcService.a()) });
      }
      return;
      NearbyRelevantHandler localNearbyRelevantHandler = (NearbyRelevantHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(66);
      if (localNearbyRelevantHandler != null) {
        localNearbyRelevantHandler.b();
      }
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_b_of_type_Int == -2147483648) {
      if (!NearbySPUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label39;
      }
    }
    label39:
    for (int i = 1;; i = 0)
    {
      this.jdField_b_of_type_Int = i;
      if (this.jdField_b_of_type_Int != 1) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void d()
  {
    a(4140);
  }
  
  public void e()
  {
    a(4152);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyProxy
 * JD-Core Version:    0.7.0.1
 */