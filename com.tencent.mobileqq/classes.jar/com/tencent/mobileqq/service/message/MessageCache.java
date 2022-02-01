package com.tencent.mobileqq.service.message;

import MessageSvcPack.stConfNumInfo;
import PushNotifyPack.DisMsgReadedNotify;
import PushNotifyPack.GroupMsgReadedNotify;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.InitMsgModule;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import msf.msgcomm.msg_comm.Msg;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageCache
{
  public static int a;
  private static final AppShareID jdField_a_of_type_ComTencentMobileqqDataAppShareID = new AppShareID();
  public static MessageCache.Callback a;
  public static MessageCache.RegPrxyCache a;
  private static String jdField_a_of_type_JavaLangString;
  public static boolean a;
  public static int b;
  public static HashMap<String, MessageCache.MsgCacheStrategyParam> b;
  private ConcurrentHashMap<String, byte[]> A = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> B = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> C = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> D = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> E = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> F = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> G = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> H = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> I = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> J = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> K = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> L = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> M = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> N = new ConcurrentHashMap();
  private ConcurrentHashMap<Pair<String, Integer>, Long> O = new ConcurrentHashMap();
  private ConcurrentHashMap<Pair<String, Integer>, Long> P = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<String, Set<Integer>>> Q = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<Integer, HashSet<Long>>> R = new ConcurrentHashMap();
  private ConcurrentHashMap<String, MessageRecord> S = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> T = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> U = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> V = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> W = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> X = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> Y = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> Z = new ConcurrentHashMap();
  private long jdField_a_of_type_Long = -1L;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
  private MessageCache.AsyncEditor jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor;
  public MessageCacheItem a;
  ArrayList<MessageRecord> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public HashMap<Long, MessageRecord> a;
  private final HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  public List<MessageRecord> a;
  private Set<String> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  public ConcurrentHashMap<String, String> a;
  public AtomicInteger a;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private ConcurrentHashMap<String, byte[]> aa = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> ab = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> ac = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ArrayList<Object[]>> ad = new ConcurrentHashMap();
  private ConcurrentHashMap<Long, ArrayList<msg_comm.Msg>> ae = new ConcurrentHashMap();
  private ConcurrentHashMap<Long, ArrayList<msg_comm.Msg>> af = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> ag = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ArrayList<Object[]>> ah = new ConcurrentHashMap();
  private ConcurrentHashMap<String, DisMsgReadedNotify> ai = new ConcurrentHashMap();
  private ConcurrentHashMap<String, GroupMsgReadedNotify> aj = new ConcurrentHashMap();
  private ConcurrentHashMap<String, AppShareID> ak = new ConcurrentHashMap();
  private ConcurrentHashMap<String, OpenID> al = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Object> am = new ConcurrentHashMap();
  private long jdField_b_of_type_Long = 0L;
  private ArrayList<stConfNumInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public ConcurrentHashMap<String, String> b;
  private boolean jdField_b_of_type_Boolean = false;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int jdField_c_of_type_Int = 0;
  private ArrayList<String> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Long, ArrayList<String>> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  public ConcurrentHashMap<String, Long> c;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = -1;
  public ConcurrentHashMap<String, Long> d;
  private boolean jdField_d_of_type_Boolean = false;
  private int e;
  public ConcurrentHashMap<String, Set<String>> e;
  public ConcurrentHashMap<String, Long> f = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> g = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Object[]> h = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Object[]> i = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Boolean> j = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Boolean> k = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> l = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> m = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Boolean> n = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> o = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Pair<Long, Long>> p = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Pair<Long, Long>> q = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<Long, MessageCache.MsgSendingInfo>> r = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<Long, MessageCache.MsgSendingInfo>> s = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ArrayList<RevokeMsgInfo>> t = new ConcurrentHashMap();
  private ConcurrentHashMap<String, List<Integer>> u = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> v = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> w = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> x = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> y = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> z = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_Int = 200;
    jdField_a_of_type_JavaLangString = "Q.msg.MessageCache";
    jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$Callback = new MessageCacheDummyCallback();
    InitMsgModule.a();
    jdField_b_of_type_Int = 3;
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public MessageCache(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_e_of_type_Int = -1;
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramAppRuntime.getApp().getSharedPreferences(paramAppRuntime.getCurrentAccountUin(), 0);
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor = new MessageCache.AsyncEditor(this);
    jdField_a_of_type_Boolean = false;
  }
  
  public static long a()
  {
    return NetConnInfoCenter.getServerTime();
  }
  
  private String a(List<Integer> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      int i1 = 0;
      while (i1 < paramList.size())
      {
        if (i1 != paramList.size() - 1)
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(paramList.get(i1));
          localStringBuilder2.append("|");
          localStringBuilder1.append(localStringBuilder2.toString());
        }
        else
        {
          localStringBuilder1.append(paramList.get(i1));
        }
        i1 += 1;
      }
      return localStringBuilder1.toString();
    }
    return "";
  }
  
  private String a(byte[] paramArrayOfByte)
  {
    return jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$Callback.a(paramArrayOfByte);
  }
  
  private StringBuilder a()
  {
    return jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$Callback.a();
  }
  
  private List<Integer> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i2;
    int i1;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return localArrayList;
      }
      paramString = paramString.split("\\|");
      i2 = paramString.length;
      i1 = 0;
    }
    for (;;)
    {
      String str;
      if (i1 < i2) {
        str = paramString[i1];
      }
      try
      {
        localArrayList.add(Integer.valueOf(str));
        label59:
        i1 += 1;
        continue;
        return localArrayList;
      }
      catch (Exception localException)
      {
        break label59;
      }
    }
  }
  
  public static void a(MessageCache.Callback paramCallback)
  {
    jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$Callback = paramCallback;
  }
  
  public static boolean a(MessageCache.MsgSendingInfo paramMsgSendingInfo)
  {
    if ((paramMsgSendingInfo != null) && (paramMsgSendingInfo.jdField_b_of_type_Long > 0L))
    {
      long l1 = System.currentTimeMillis() - paramMsgSendingInfo.jdField_b_of_type_Long;
      if ((l1 < jdField_a_of_type_Int) && (l1 > 0L)) {
        return false;
      }
    }
    return true;
  }
  
  private String b(byte[] paramArrayOfByte)
  {
    return jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$Callback.b(paramArrayOfByte);
  }
  
  private List<MessageRecord> b(String paramString, int paramInt)
  {
    return jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$Callback.a(paramString, paramInt, this);
  }
  
  private void i(String paramString, long paramLong)
  {
    paramString = MD5.toMD5(paramString);
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
    {
      MessageCache.AsyncEditor localAsyncEditor = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteFriendMsgTime");
      localStringBuilder.append(paramString);
      localAsyncEditor.putLong(localStringBuilder.toString(), paramLong);
    }
  }
  
  private byte[] q(String paramString)
  {
    return jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$Callback.a(paramString);
  }
  
  private byte[] r(String paramString)
  {
    return jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$Callback.b(paramString);
  }
  
  public int a()
  {
    if ((this.jdField_c_of_type_Int <= 0) && (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)) {
      this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("getlastMessageTime", 1);
    }
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--->>getBuddyMsgLastSeq: ");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return this.jdField_c_of_type_Int;
  }
  
  public int a(String paramString)
  {
    if (!this.ac.containsKey(paramString)) {
      this.ac.put(paramString, Integer.valueOf(2));
    }
    return ((Integer)this.ac.get(paramString)).intValue();
  }
  
  public int a(String paramString, int paramInt)
  {
    paramString = a(paramString, paramInt).iterator();
    for (paramInt = 0; paramString.hasNext(); paramInt = Math.max(((Integer)paramString.next()).intValue(), paramInt)) {}
    return paramInt + 1;
  }
  
  public long a(String paramString)
  {
    String str = this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin();
    if (!TextUtils.isEmpty(str))
    {
      if (TextUtils.isEmpty(paramString)) {
        return -1L;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("_noticetime_");
      ((StringBuilder)localObject).append(paramString);
      paramString = ((StringBuilder)localObject).toString();
      if (!this.f.containsKey(paramString))
      {
        localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("birth");
        long l1 = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getLong(paramString, -1L);
        if (l1 == -1L) {
          return -1L;
        }
        this.f.put(paramString, Long.valueOf(l1));
      }
      return ((Long)this.f.get(paramString)).longValue();
    }
    return -1L;
  }
  
  public long a(String paramString, int paramInt)
  {
    String str = UinTypeUtil.a(paramString, paramInt);
    Object localObject;
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() == null)
    {
      if (QLog.isColorLevel())
      {
        str = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getMsgDelLastSeq uin = ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(",type = ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" , lastSeqId = ");
        ((StringBuilder)localObject).append(0);
        QLog.d(str, 2, ((StringBuilder)localObject).toString());
      }
      return 0L;
    }
    if (!this.L.containsKey(str))
    {
      localObject = this.jdField_a_of_type_AndroidContentSharedPreferences;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDelMsgLastSeq");
      localStringBuilder.append(str);
      long l1 = ((SharedPreferences)localObject).getLong(localStringBuilder.toString(), 0L);
      this.L.put(str, Long.valueOf(l1));
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getMsgDelLastSeq uin = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(",type = ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" , lastSeqId = ");
        localStringBuilder.append(l1);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
    }
    return ((Long)this.L.get(str)).longValue();
  }
  
  public DisMsgReadedNotify a(String paramString)
  {
    return (DisMsgReadedNotify)this.ai.remove(paramString);
  }
  
  public GroupMsgReadedNotify a(String paramString)
  {
    return (GroupMsgReadedNotify)this.aj.remove(paramString);
  }
  
  public Pair<Long, Long> a(String paramString)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() == null) {
      return null;
    }
    Object localObject2 = (Pair)this.p.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getDisscussionInfoSeq");
      ((StringBuilder)localObject2).append(paramString);
      long l1 = ((SharedPreferences)localObject1).getLong(((StringBuilder)localObject2).toString(), 0L);
      localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getDisscussionInfoLastTime");
      ((StringBuilder)localObject2).append(paramString);
      localObject1 = new Pair(Long.valueOf(l1), Long.valueOf(((SharedPreferences)localObject1).getLong(((StringBuilder)localObject2).toString(), 0L)));
      this.p.put(paramString, localObject1);
    }
    return localObject1;
  }
  
  public BaseMsgProxy a()
  {
    return jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$Callback.a(0, this);
  }
  
  public AppShareID a(String paramString)
  {
    Object localObject1;
    if (!this.ak.containsKey(paramString))
    {
      localObject1 = this.jdField_a_of_type_MqqAppAppRuntime.getEntityManagerFactory().createEntityManager();
      Object localObject2 = (AppShareID)((EntityManager)localObject1).find(AppShareID.class, "strPkgName=?", new String[] { paramString });
      if (localObject2 != null)
      {
        a(paramString, (AppShareID)localObject2);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Add cache from db appid = ");
          ((StringBuilder)localObject2).append(paramString);
          QLog.d("share_appid", 2, ((StringBuilder)localObject2).toString());
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Not exist in db appid = ");
          ((StringBuilder)localObject2).append(paramString);
          QLog.d("share_appid", 2, ((StringBuilder)localObject2).toString());
        }
        a(paramString, jdField_a_of_type_ComTencentMobileqqDataAppShareID);
      }
      ((EntityManager)localObject1).close();
    }
    else if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Already in cache appid = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("share_appid", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.ak.get(paramString) == jdField_a_of_type_ComTencentMobileqqDataAppShareID) {
      return null;
    }
    return (AppShareID)this.ak.get(paramString);
  }
  
  public MessageRecord a(int paramInt, String paramString, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.valueOf(paramInt));
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramLong);
    paramString = ((StringBuilder)localObject).toString();
    localObject = (MessageRecord)this.S.get(paramString);
    this.S.remove(paramString);
    return localObject;
  }
  
  public OpenID a(String paramString)
  {
    Object localObject1;
    if (!this.al.containsKey(paramString))
    {
      localObject1 = this.jdField_a_of_type_MqqAppAppRuntime.getEntityManagerFactory().createEntityManager();
      Object localObject2 = (OpenID)((EntityManager)localObject1).find(OpenID.class, paramString);
      if (localObject2 != null)
      {
        a(paramString, (OpenID)localObject2);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Add cache from db appid = ");
          ((StringBuilder)localObject2).append(paramString);
          QLog.d("openid", 2, ((StringBuilder)localObject2).toString());
        }
      }
      ((EntityManager)localObject1).close();
    }
    else if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Already in cache appid = ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(",openid=");
      ((StringBuilder)localObject1).append(((OpenID)this.al.get(paramString)).openID);
      QLog.d("openid", 2, ((StringBuilder)localObject1).toString());
    }
    return (OpenID)this.al.get(paramString);
  }
  
  public MessageCache.MsgSendingInfo a(MessageRecord paramMessageRecord)
  {
    return a(paramMessageRecord, jdField_a_of_type_Int);
  }
  
  public MessageCache.MsgSendingInfo a(MessageRecord paramMessageRecord, int paramInt)
  {
    String str = UinTypeUtil.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    MessageCache.MsgSendingInfo localMsgSendingInfo = new MessageCache.MsgSendingInfo(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, System.currentTimeMillis());
    localMsgSendingInfo.jdField_b_of_type_Int = paramInt;
    Object localObject;
    if (this.r.containsKey(str))
    {
      localObject = (ConcurrentHashMap)this.r.get(str);
      if (localObject != null)
      {
        ((ConcurrentHashMap)localObject).put(Long.valueOf(paramMessageRecord.uniseq), localMsgSendingInfo);
      }
      else
      {
        localObject = new ConcurrentHashMap();
        ((ConcurrentHashMap)localObject).put(Long.valueOf(paramMessageRecord.uniseq), localMsgSendingInfo);
        this.r.put(str, localObject);
      }
    }
    else
    {
      localObject = new ConcurrentHashMap();
      ((ConcurrentHashMap)localObject).put(Long.valueOf(paramMessageRecord.uniseq), localMsgSendingInfo);
      this.r.put(str, localObject);
    }
    if (paramMessageRecord.isLongMsg())
    {
      if (this.R.containsKey(str))
      {
        if (((ConcurrentHashMap)this.R.get(str)).containsKey(Integer.valueOf(paramMessageRecord.longMsgId)))
        {
          ((HashSet)((ConcurrentHashMap)this.R.get(str)).get(Integer.valueOf(paramMessageRecord.longMsgId))).add(Long.valueOf(paramMessageRecord.uniseq));
          return localMsgSendingInfo;
        }
        localObject = new HashSet();
        ((HashSet)localObject).add(Long.valueOf(paramMessageRecord.uniseq));
        ((ConcurrentHashMap)this.R.get(str)).put(Integer.valueOf(paramMessageRecord.longMsgId), localObject);
        return localMsgSendingInfo;
      }
      localObject = new ConcurrentHashMap();
      HashSet localHashSet = new HashSet();
      localHashSet.add(Long.valueOf(paramMessageRecord.uniseq));
      ((ConcurrentHashMap)localObject).put(Integer.valueOf(paramMessageRecord.longMsgId), localHashSet);
      this.R.put(str, localObject);
    }
    return localMsgSendingInfo;
  }
  
  public MessageCache.MsgSendingInfo a(String paramString, int paramInt, long paramLong)
  {
    int i4 = 0;
    int i3 = 0;
    QLog.i("MsgSend", 1, String.format("removeSendingCache key = %d %s %d", new Object[] { Long.valueOf(paramLong), MsfSdkUtils.getShortUin(paramString), Integer.valueOf(paramInt) }), new RuntimeException());
    String str2 = UinTypeUtil.a(paramString, paramInt);
    boolean bool = this.r.containsKey(str2);
    String str1 = null;
    paramString = null;
    Object localObject;
    if (bool)
    {
      localObject = (ConcurrentHashMap)this.r.get(str2);
      if (localObject != null) {
        paramString = (MessageCache.MsgSendingInfo)((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong));
      }
      str1 = paramString;
      if (localObject != null)
      {
        str1 = paramString;
        if (((ConcurrentHashMap)localObject).isEmpty())
        {
          this.r.remove(str2);
          str1 = paramString;
        }
      }
    }
    if ((!d()) && (this.s.containsKey(str2)))
    {
      paramString = (ConcurrentHashMap)this.s.get(str2);
      if (paramString != null) {
        paramString.remove(Long.valueOf(paramLong));
      }
      if ((paramString != null) && (paramString.isEmpty())) {
        this.s.remove(str2);
      }
      if (QLog.isColorLevel())
      {
        paramString = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("msgSending:delete result in messageSendingTemp ");
        ((StringBuilder)localObject).append(this.s);
        QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
      }
    }
    if (this.R.containsKey(str2))
    {
      paramString = ((ConcurrentHashMap)this.R.get(str2)).keySet().iterator();
      int i2;
      do
      {
        i1 = i4;
        if (!paramString.hasNext()) {
          break;
        }
        i2 = ((Integer)paramString.next()).intValue();
        localObject = (Set)((ConcurrentHashMap)this.R.get(str2)).get(Integer.valueOf(i2));
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("removeSendingCache  longMsgFragmentSet = %s", new Object[] { localObject }));
        }
      } while (!((Set)localObject).contains(Long.valueOf(paramLong)));
      ((Set)localObject).remove(Long.valueOf(paramLong));
      paramInt = i3;
      if (((Set)localObject).isEmpty()) {
        paramInt = i2;
      }
      int i1 = paramInt;
      if (QLog.isColorLevel())
      {
        paramString = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("removeSendingCache uniseq=");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append("longid=");
        ((StringBuilder)localObject).append(i2);
        QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
        i1 = paramInt;
      }
      if (i1 != 0) {
        ((ConcurrentHashMap)this.R.get(str2)).remove(Integer.valueOf(i1));
      }
    }
    return str1;
  }
  
  public MessageCacheItem a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCacheItem == null) {
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCacheItem = new MessageCacheItem(this.jdField_a_of_type_MqqAppAppRuntime, 1026, "hctopic", this.jdField_a_of_type_AndroidContentSharedPreferences, this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor);
    }
    return this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCacheItem;
  }
  
  public ArrayList<String> a()
  {
    return this.jdField_c_of_type_JavaUtilArrayList;
  }
  
  public ArrayList<msg_comm.Msg> a(long paramLong)
  {
    return (ArrayList)this.ae.get(Long.valueOf(paramLong));
  }
  
  public ArrayList<Object[]> a(String paramString)
  {
    return (ArrayList)this.ad.get(paramString);
  }
  
  public HashSet<String> a()
  {
    return this.jdField_a_of_type_JavaUtilHashSet;
  }
  
  public List<Integer> a(String paramString, int paramInt)
  {
    String str = UinTypeUtil.a(paramString, paramInt);
    if (!this.u.containsKey(str))
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLongMsgIdArray");
      localStringBuilder.append(UinTypeUtil.a(paramString, paramInt));
      paramString = localSharedPreferences.getString(localStringBuilder.toString(), "");
      this.u.put(str, a(paramString));
    }
    return (List)this.u.get(str);
  }
  
  public Map<String, Set<Integer>> a(String paramString, int paramInt)
  {
    synchronized (this.Q)
    {
      paramString = UinTypeUtil.a(paramString, paramInt);
      if ((this.Q.containsKey(paramString)) && (this.Q.get(paramString) != null))
      {
        Map localMap = (Map)this.Q.get(paramString);
        if ((localMap != null) && (localMap.isEmpty()))
        {
          this.Q.remove(paramString);
          return null;
        }
        return localMap;
      }
      return null;
    }
  }
  
  public Set<String> a()
  {
    String str = this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    if (!this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
    {
      Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("birth");
      localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_list");
      localObject = ((SharedPreferences)localObject).getStringSet(localStringBuilder.toString(), null);
      if (localObject == null) {
        return null;
      }
      this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject);
    }
    return (Set)this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
  }
  
  public ConcurrentHashMap<String, Integer> a()
  {
    return this.ac;
  }
  
  public AppRuntime a()
  {
    return this.jdField_a_of_type_MqqAppAppRuntime;
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "clearDiscNumInfoCache");
      }
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor.putInt("getlastMessageTime", paramInt);
      if (QLog.isColorLevel())
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("--->>setBuddyMsgLastSeq lastseq = ");
        localStringBuilder.append(paramInt);
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(long paramLong)
  {
    this.ae.remove(Long.valueOf(paramLong));
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    Object localObject2 = (ArrayList)this.jdField_c_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (this.jdField_c_of_type_JavaUtilHashMap.size() >= 20)
      {
        long l1 = 0L;
        localObject1 = this.jdField_c_of_type_JavaUtilHashMap.keySet().iterator();
        long l2;
        for (;;)
        {
          l2 = l1;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          l2 = ((Long)((Iterator)localObject1).next()).longValue();
          long l3 = Long.parseLong((String)((ArrayList)this.jdField_c_of_type_JavaUtilHashMap.get(Long.valueOf(l2))).get(0));
          if (paramLong2 - l3 > 300L) {
            break;
          }
          if (l3 < paramLong2) {
            l1 = l2;
          }
        }
        this.jdField_c_of_type_JavaUtilHashMap.remove(Long.valueOf(l2));
      }
      localObject1 = new ArrayList();
    }
    if (((ArrayList)localObject1).size() >= 20) {
      ((ArrayList)localObject1).remove(0);
    }
    localObject2 = Long.toString(paramLong2);
    if (((ArrayList)localObject1).size() == 0) {
      ((ArrayList)localObject1).add(localObject2);
    } else {
      ((ArrayList)localObject1).set(0, localObject2);
    }
    ((ArrayList)localObject1).add(paramString);
    this.jdField_c_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong1), localObject1);
  }
  
  public void a(long paramLong, List<msg_comm.Msg> paramList)
  {
    ArrayList localArrayList2 = (ArrayList)this.ae.get(Long.valueOf(paramLong));
    ArrayList localArrayList1;
    if (localArrayList2 != null)
    {
      localArrayList1 = localArrayList2;
      if (localArrayList2.size() != 0) {}
    }
    else
    {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.addAll(paramList);
    this.ae.put(Long.valueOf(paramLong), localArrayList1);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    synchronized (this.Q)
    {
      if (!paramMessageRecord.isLongMsg()) {
        return;
      }
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("addOnlineLongMsgFragment longid=");
        ((StringBuilder)localObject2).append(paramMessageRecord.getLongMsgInfoString());
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject3 = UinTypeUtil.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      Object localObject2 = UinTypeUtil.a(paramMessageRecord);
      if ((this.Q.containsKey(localObject3)) && (this.Q.get(localObject3) != null))
      {
        localObject1 = (ConcurrentHashMap)this.Q.get(localObject3);
      }
      else
      {
        localObject1 = new ConcurrentHashMap();
        this.Q.put(localObject3, localObject1);
      }
      if (((ConcurrentHashMap)localObject1).containsKey(localObject2))
      {
        localObject3 = (Set)((ConcurrentHashMap)localObject1).get(localObject2);
        ((Set)localObject3).add(Integer.valueOf(paramMessageRecord.longMsgIndex));
        if (paramMessageRecord.longMsgCount <= ((Set)localObject3).size()) {
          ((ConcurrentHashMap)localObject1).remove(localObject2);
        }
      }
      else
      {
        localObject3 = new HashSet();
        ((Set)localObject3).add(Integer.valueOf(paramMessageRecord.longMsgIndex));
        ((ConcurrentHashMap)localObject1).put(localObject2, localObject3);
      }
      return;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_c_of_type_JavaUtilArrayList.add(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.ac.put(paramString, Integer.valueOf(paramInt));
    if (paramInt != 0)
    {
      if (QLog.isColorLevel())
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setTroopMsgResponseState state: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" state: ");
        localStringBuilder.append(paramInt);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      if (paramInt == 2) {
        f(paramString);
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1).add(Integer.valueOf(paramInt2));
    if (a(paramString, paramInt1).size() > 50)
    {
      paramInt2 = 0;
      while (paramInt2 < 10)
      {
        a(paramString, paramInt1).remove(0);
        paramInt2 += 1;
      }
    }
    MessageCache.AsyncEditor localAsyncEditor = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getLongMsgIdArray");
    localStringBuilder.append(UinTypeUtil.a(paramString, paramInt1));
    localAsyncEditor.putString(localStringBuilder.toString(), a(a(paramString, paramInt1))).commit();
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    Object localObject;
    if (paramInt == 1)
    {
      paramLong = Math.max(paramLong, b(paramString));
    }
    else if (paramInt == 3000)
    {
      paramLong = Math.max(paramLong, h(paramString));
    }
    else
    {
      localObject = b(paramString, paramInt);
      long l1 = paramLong;
      if (localObject != null)
      {
        l1 = paramLong;
        if (!((List)localObject).isEmpty()) {
          l1 = Math.max(paramLong, ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time);
        }
      }
      b(paramString, 0L, 0L);
      paramLong = l1;
      if (paramInt == 0)
      {
        i(paramString, NetConnInfoCenter.getServerTimeMillis());
        paramLong = l1;
      }
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("addMsgDelLastSeq uin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",type = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" , lastSeqId = ");
      localStringBuilder.append(paramLong);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.L.put(UinTypeUtil.a(paramString, paramInt), Long.valueOf(Math.max(paramLong, a(paramString, paramInt))));
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDelMsgLastSeq");
      localStringBuilder.append(UinTypeUtil.a(paramString, paramInt));
      ((MessageCache.AsyncEditor)localObject).putLong(localStringBuilder.toString(), paramLong).commit();
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    synchronized (this.Q)
    {
      paramString1 = a(paramString1, paramInt);
      if (paramString1 == null) {
        return;
      }
      if (paramString1.containsKey(paramString2)) {
        paramString1.remove(paramString2);
      }
      return;
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    paramLong = Math.max(paramLong, b(paramString));
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("addGroupMsgLastSeq ");
      localStringBuilder.append(paramLong);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.g.put(paramString, Long.valueOf(paramLong));
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroopLastMessageTime");
      localStringBuilder.append(paramString);
      ((MessageCache.AsyncEditor)localObject).putLong(localStringBuilder.toString(), paramLong);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    this.p.put(paramString, new Pair(Long.valueOf(paramLong1), Long.valueOf(paramLong2)));
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
    {
      MessageCache.AsyncEditor localAsyncEditor = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDisscussionInfoSeq");
      localStringBuilder.append(paramString);
      localAsyncEditor.putLong(localStringBuilder.toString(), paramLong1);
      localAsyncEditor = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDisscussionInfoLastTime");
      localStringBuilder.append(paramString);
      localAsyncEditor.putLong(localStringBuilder.toString(), paramLong2);
    }
  }
  
  public void a(String paramString, DisMsgReadedNotify paramDisMsgReadedNotify)
  {
    this.ai.put(paramString, paramDisMsgReadedNotify);
  }
  
  public void a(String paramString, GroupMsgReadedNotify paramGroupMsgReadedNotify)
  {
    this.aj.put(paramString, paramGroupMsgReadedNotify);
  }
  
  public void a(String paramString, AppShareID paramAppShareID)
  {
    this.ak.put(paramString, paramAppShareID);
    if (QLog.isColorLevel())
    {
      paramAppShareID = new StringBuilder();
      paramAppShareID.append("add share appid to cache = ");
      paramAppShareID.append(paramString);
      QLog.d("share_appid", 2, paramAppShareID.toString());
    }
  }
  
  public void a(String paramString, OpenID paramOpenID)
  {
    this.al.put(paramString, paramOpenID);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("add openid to cache = ");
      paramString.append(paramOpenID);
      QLog.d("openid", 2, paramString.toString());
    }
  }
  
  public void a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      paramString1 = localStringBuilder.toString();
    }
    try
    {
      paramString2 = (byte[])this.V.get(paramString1);
      if (((paramString2 == null) || (!Arrays.equals(paramString2, paramArrayOfByte))) && (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null))
      {
        paramString2 = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("confess_sig");
        paramString2 = paramString2.getSharedPreferences(localStringBuilder.toString(), 0).edit();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
        {
          this.V.put(paramString1, paramArrayOfByte);
          paramString2.putString(paramString1, b(paramArrayOfByte));
        }
        else
        {
          this.V.remove(paramString1);
          paramString2.remove(paramString1);
        }
        paramString2.commit();
      }
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public void a(String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    ConcurrentHashMap localConcurrentHashMap;
    Object localObject;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      if (paramBoolean) {
        localConcurrentHashMap = this.X;
      } else {
        localConcurrentHashMap = this.Y;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramString2);
      paramString2 = ((StringBuilder)localObject).toString();
    }
    for (;;)
    {
      try
      {
        paramString1 = (byte[])localConcurrentHashMap.get(paramString2);
        if (((paramString1 == null) || (!Arrays.equals(paramString1, paramArrayOfByte))) && (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null))
        {
          localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
          localStringBuilder.append("MatchChat");
          if (paramBoolean)
          {
            paramString1 = "";
            localStringBuilder.append(paramString1);
            paramString1 = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
            if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
            {
              localConcurrentHashMap.put(paramString2, paramArrayOfByte);
              paramString1.putString(paramString2, b(paramArrayOfByte));
            }
            else
            {
              localConcurrentHashMap.remove(paramString2);
              paramString1.remove(paramString2);
            }
            paramString1.commit();
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramString1)
      {
        return;
      }
      paramString1 = "_campus";
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addWpaMsgKey uin:");
      localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      localStringBuilder.append("peerUin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" key:");
      localStringBuilder.append(a(paramArrayOfByte));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = (byte[])this.v.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.v.put(paramString, paramArrayOfByte);
      if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
      {
        paramArrayOfByte = a(paramArrayOfByte);
        this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor.putString(paramString, paramArrayOfByte);
      }
    }
  }
  
  public void a(String paramString, Object[] paramArrayOfObject)
  {
    ArrayList localArrayList2 = (ArrayList)this.ad.get(paramString);
    ArrayList localArrayList1;
    if (localArrayList2 != null)
    {
      localArrayList1 = localArrayList2;
      if (localArrayList2.size() != 0) {}
    }
    else
    {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.add(paramArrayOfObject);
    this.ad.put(paramString, localArrayList1);
  }
  
  public void a(ArrayList<RevokeMsgInfo> paramArrayList)
  {
    Object localObject1 = (RevokeMsgInfo)paramArrayList.get(0);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("RevokeNotifyCache, add cache, ");
      ((StringBuilder)localObject2).append(((RevokeMsgInfo)localObject1).toString());
      QLog.d("revokeMsg", 2, ((StringBuilder)localObject2).toString());
    }
    int i2 = ((RevokeMsgInfo)localObject1).jdField_a_of_type_Int;
    Object localObject2 = ((RevokeMsgInfo)localObject1).jdField_a_of_type_JavaLangString;
    int i1;
    if (((RevokeMsgInfo)localObject1).jdField_c_of_type_Int > 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      localObject1 = String.format("%s&%d&%d&%d", new Object[] { localObject2, Integer.valueOf(i2), Integer.valueOf(((RevokeMsgInfo)localObject1).jdField_b_of_type_Int), Integer.valueOf(((RevokeMsgInfo)localObject1).jdField_c_of_type_Int) });
    } else {
      localObject1 = String.format("%s&%d&%d", new Object[] { localObject2, Integer.valueOf(i2), Long.valueOf(((RevokeMsgInfo)localObject1).jdField_a_of_type_Long) });
    }
    if (this.t.containsKey(localObject1))
    {
      localObject1 = (ArrayList)this.t.get(localObject1);
      localObject2 = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        RevokeMsgInfo localRevokeMsgInfo1 = (RevokeMsgInfo)paramArrayList.next();
        Iterator localIterator = ((ArrayList)localObject1).iterator();
        RevokeMsgInfo localRevokeMsgInfo2;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localRevokeMsgInfo2 = (RevokeMsgInfo)localIterator.next();
        } while ((localRevokeMsgInfo1.jdField_a_of_type_Long != localRevokeMsgInfo2.jdField_a_of_type_Long) || (localRevokeMsgInfo1.jdField_b_of_type_Long != localRevokeMsgInfo2.jdField_b_of_type_Long));
        ((ArrayList)localObject2).add(localRevokeMsgInfo1);
      }
      ((ArrayList)localObject1).addAll((Collection)localObject2);
      return;
    }
    this.t.put(localObject1, paramArrayList);
  }
  
  public void a(List<stConfNumInfo> paramList)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addDiscNumInfoCache size = ");
        int i1;
        if (paramList == null) {
          i1 = 0;
        } else {
          i1 = paramList.size();
        }
        localStringBuilder.append(i1);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      this.jdField_b_of_type_JavaUtilArrayList.addAll(paramList);
      return;
    }
    finally {}
  }
  
  public void a(Set<String> paramSet)
  {
    String str = this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin();
    if ((!TextUtils.isEmpty(str)) && (paramSet != null))
    {
      this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramSet);
      Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("birth");
      localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_list");
      ((SharedPreferences.Editor)localObject).putStringSet(localStringBuilder.toString(), paramSet);
      ((SharedPreferences.Editor)localObject).apply();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
    {
      String str1 = a(paramArrayOfByte);
      String str2;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        str2 = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("--->>setLastSyncCookie lastSyncCookie:");
        localStringBuilder.append(str1);
        QLog.d(str2, 2, localStringBuilder.toString());
      }
      if (QLog.isColorLevel())
      {
        str2 = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("--->>setBuddyMsgLastSeq cookie = ");
        localStringBuilder.append(a(paramArrayOfByte));
        QLog.d(str2, 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor.putString("getMsgV4_vSyncCookie", str1);
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("removeDiscPullSeqCache, uinArray: ");
    int i2 = paramArrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str = paramArrayOfString[i1];
      localStringBuilder.append(str);
      localStringBuilder.append(",");
      if (this.n.containsKey(str)) {
        this.n.remove(str);
      }
      i1 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isDiscPullSeqFinish size = ");
      localStringBuilder.append(this.n.size());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return this.n.isEmpty();
  }
  
  public boolean a(int paramInt, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramInt));
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    paramString = localStringBuilder.toString();
    return this.S.containsKey(paramString);
  }
  
  public boolean a(long paramLong, String paramString)
  {
    Object localObject = (ArrayList)this.jdField_c_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() == 0) {
        return false;
      }
      localObject = ((ArrayList)localObject).iterator();
      ((Iterator)localObject).next();
      while (((Iterator)localObject).hasNext()) {
        if (paramString.equals((String)((Iterator)localObject).next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return a(paramMessageRecord.frienduin, paramMessageRecord.istroop, UinTypeUtil.a(paramMessageRecord));
  }
  
  public boolean a(String paramString)
  {
    paramString = MD5.toMD5(paramString);
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteFriendMsgTime");
      localStringBuilder.append(paramString);
      return localSharedPreferences.contains(localStringBuilder.toString());
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = a(paramString, paramInt1).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((Integer)((Iterator)localObject).next()).intValue() == paramInt2)
      {
        if (QLog.isColorLevel())
        {
          localObject = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("long msg id is exist! uin=");
          localStringBuilder.append(paramString);
          localStringBuilder.append(",istroop=");
          localStringBuilder.append(paramInt1);
          localStringBuilder.append(",longMsgID=");
          localStringBuilder.append(paramInt2);
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt, long paramLong)
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (localMessageRecord == null) {
      return false;
    }
    return (localMessageRecord.frienduin.equals(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop == paramInt) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq == paramLong);
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2)
  {
    synchronized (this.Q)
    {
      paramString1 = a(paramString1, paramInt);
      if (paramString1 == null) {
        return false;
      }
      if (paramString1.containsKey(paramString2))
      {
        if (((Set)paramString1.get(paramString2)).isEmpty())
        {
          paramString1.remove(paramString2);
          return false;
        }
        return true;
      }
      return false;
    }
  }
  
  public boolean a(String paramString, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_JavaUtilSet.size() == 0) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong2);
    paramString = localStringBuilder.toString();
    return this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_d_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("getRegPrxyFailFlag", false);
    }
    return this.jdField_d_of_type_Boolean;
  }
  
  public byte[] a()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfByte;
    if (((localObject == null) || (localObject.length == 0)) && (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null))
    {
      localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("getMsgV4_vSyncCookie", "");
      if (((String)localObject).length() == 0) {
        this.jdField_a_of_type_ArrayOfByte = null;
      } else {
        this.jdField_a_of_type_ArrayOfByte = q((String)localObject);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--->>getLastSyncCookie lastSyncCookie:");
      localStringBuilder.append(a(this.jdField_a_of_type_ArrayOfByte));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public byte[] a(String paramString)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() == null) {
      return null;
    }
    if (!this.A.containsKey(paramString))
    {
      Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      localStringBuilder.append("pub");
      localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
      if (localObject == null) {
        return null;
      }
      localObject = r((String)localObject);
      this.A.put(paramString, localObject);
    }
    return (byte[])this.A.get(paramString);
  }
  
  public byte[] a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      paramString1 = localStringBuilder.toString();
      if (!this.V.containsKey(paramString1))
      {
        paramString2 = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("confess_sig");
        paramString2 = paramString2.getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString1, null);
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString2 = r(paramString2);
          if ((paramString2 != null) && (paramString2.length > 0))
          {
            this.V.put(paramString1, paramString2);
            return paramString2;
          }
        }
        return null;
      }
      return (byte[])this.V.get(paramString1);
    }
    return null;
  }
  
  public byte[] a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      ConcurrentHashMap localConcurrentHashMap;
      if (paramBoolean) {
        localConcurrentHashMap = this.X;
      } else {
        localConcurrentHashMap = this.Y;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramString2);
      paramString2 = ((StringBuilder)localObject).toString();
      if (!localConcurrentHashMap.containsKey(paramString2))
      {
        localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("MatchChat");
        if (paramBoolean) {
          paramString1 = "";
        } else {
          paramString1 = "_campus";
        }
        localStringBuilder.append(paramString1);
        paramString1 = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString2, null);
        if (!TextUtils.isEmpty(paramString1))
        {
          paramString1 = r(paramString1);
          if ((paramString1 != null) && (paramString1.length > 0))
          {
            localConcurrentHashMap.put(paramString2, paramString1);
            return paramString1;
          }
        }
        return null;
      }
      return (byte[])localConcurrentHashMap.get(paramString2);
    }
    return null;
  }
  
  public Object[] a(String paramString)
  {
    if (this.i.containsKey(paramString)) {
      return (Object[])this.i.get(paramString);
    }
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDiscussionMemberSeq");
      localStringBuilder.append(paramString);
      long l1 = localSharedPreferences.getLong(localStringBuilder.toString(), -1L);
      localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDiscussionConfigSeq");
      localStringBuilder.append(paramString);
      long l2 = localSharedPreferences.getLong(localStringBuilder.toString(), -1L);
      if (l1 != 0L) {
        return new Object[] { Long.valueOf(l1), Long.valueOf(l2) };
      }
    }
    return null;
  }
  
  public int b()
  {
    if (this.jdField_e_of_type_Int < 0) {
      if (this.jdField_a_of_type_AndroidContentSharedPreferences.contains("msgsignal_switch")) {
        this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("msgsignal_switch", 0);
      } else {
        this.jdField_e_of_type_Int = 0;
      }
    }
    return this.jdField_e_of_type_Int;
  }
  
  public int b(String paramString)
  {
    if (!this.ag.containsKey(paramString)) {
      this.ag.put(paramString, Integer.valueOf(2));
    }
    return ((Integer)this.ag.get(paramString)).intValue();
  }
  
  public long b()
  {
    String str = this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin();
    if (TextUtils.isEmpty(str)) {
      return -1L;
    }
    if (!this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
    {
      Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("birth");
      localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_time");
      long l1 = ((SharedPreferences)localObject).getLong(localStringBuilder.toString(), -1L);
      if (l1 == -1L) {
        return -1L;
      }
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Long.valueOf(l1));
    }
    return ((Long)this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).longValue();
  }
  
  public long b(String paramString)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() == null) {
      return 0L;
    }
    if (!this.g.containsKey(paramString))
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroopLastMessageTime");
      localStringBuilder.append(paramString);
      long l1 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
      this.g.put(paramString, Long.valueOf(l1));
    }
    paramString = (Long)this.g.get(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.longValue();
  }
  
  public Pair<Long, Long> b(String paramString)
  {
    paramString = MD5.toMD5(paramString);
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() == null) {
      return null;
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (!this.q.containsKey(paramString))
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      StringBuilder localStringBuilder = a();
      localStringBuilder.append("getC2CLastMessageTime");
      localStringBuilder.append(paramString);
      long l1 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
      localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      localStringBuilder = a();
      localStringBuilder.append("getC2CLastMessageTimeRand");
      localStringBuilder.append(paramString);
      long l2 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
      this.q.put(paramString, new Pair(Long.valueOf(l1), Long.valueOf(l2)));
    }
    return (Pair)this.q.get(paramString);
  }
  
  public ArrayList<stConfNumInfo> b()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cloneDiscNumInfoCache size = ");
        localStringBuilder.append(this.jdField_b_of_type_JavaUtilArrayList.size());
        QLog.d((String)localObject1, 2, localStringBuilder.toString());
      }
      Object localObject1 = (ArrayList)this.jdField_b_of_type_JavaUtilArrayList.clone();
      return localObject1;
    }
    finally {}
  }
  
  public ArrayList<msg_comm.Msg> b(long paramLong)
  {
    return (ArrayList)this.af.get(Long.valueOf(paramLong));
  }
  
  public ArrayList<Object[]> b(String paramString)
  {
    return (ArrayList)this.ah.get(paramString);
  }
  
  public ConcurrentHashMap<String, ArrayList<Object[]>> b()
  {
    return this.ad;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "clearDiscPullSeqCache");
    }
    this.n.clear();
  }
  
  public void b(int paramInt)
  {
    if (b() != paramInt)
    {
      this.jdField_e_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor.putInt("msgsignal_switch", paramInt);
      if (QLog.isColorLevel())
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("--->>setMsgSignalSwitch = ");
        localStringBuilder.append(paramInt);
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void b(long paramLong)
  {
    this.af.remove(Long.valueOf(paramLong));
  }
  
  public void b(long paramLong, List<msg_comm.Msg> paramList)
  {
    ArrayList localArrayList2 = (ArrayList)this.af.get(Long.valueOf(paramLong));
    ArrayList localArrayList1;
    if (localArrayList2 != null)
    {
      localArrayList1 = localArrayList2;
      if (localArrayList2.size() != 0) {}
    }
    else
    {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.addAll(paramList);
    this.af.put(Long.valueOf(paramLong), localArrayList1);
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.valueOf(paramMessageRecord.istroop));
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramMessageRecord.frienduin);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramMessageRecord.uniseq);
    localObject = ((StringBuilder)localObject).toString();
    this.S.put(localObject, paramMessageRecord);
  }
  
  public void b(String paramString)
  {
    this.ad.remove(paramString);
  }
  
  public void b(String paramString, int paramInt)
  {
    this.ag.put(paramString, Integer.valueOf(paramInt));
    if (paramInt != 0)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(128);
        localStringBuilder.append("setDiscussionMsgState discussionUin: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" state: ");
        localStringBuilder.append(paramInt);
        QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
      if (paramInt == 2) {
        h(paramString);
      }
    }
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    Object localObject = UinTypeUtil.a(paramString, paramInt);
    paramString = new MessageCache.MsgSendingInfo(paramString, paramInt, paramLong, 0L);
    ConcurrentHashMap localConcurrentHashMap;
    if (this.s.containsKey(localObject))
    {
      localConcurrentHashMap = (ConcurrentHashMap)this.s.get(localObject);
      if (localConcurrentHashMap != null)
      {
        localConcurrentHashMap.put(Long.valueOf(paramLong), paramString);
      }
      else
      {
        localConcurrentHashMap = new ConcurrentHashMap();
        localConcurrentHashMap.put(Long.valueOf(paramLong), paramString);
        this.s.put(localObject, localConcurrentHashMap);
      }
    }
    else
    {
      localConcurrentHashMap = new ConcurrentHashMap();
      localConcurrentHashMap.put(Long.valueOf(paramLong), paramString);
      this.s.put(localObject, localConcurrentHashMap);
    }
    if (QLog.isColorLevel())
    {
      paramString = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("msgSending:addSendingCacheTemp,msgSendingTemp:");
      ((StringBuilder)localObject).append(this.s);
      ((StringBuilder)localObject).append(" msgCache:");
      ((StringBuilder)localObject).append(hashCode());
      QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(String paramString, long paramLong)
  {
    paramLong = Math.max(paramLong, c(paramString));
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("addGroupExpiredSeq ");
      localStringBuilder.append(paramLong);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.l.put(paramString, Long.valueOf(paramLong));
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroopExpiredSeq");
      localStringBuilder.append(paramString);
      ((MessageCache.AsyncEditor)localObject).putLong(localStringBuilder.toString(), paramLong);
    }
  }
  
  public void b(String paramString, long paramLong1, long paramLong2)
  {
    paramString = MD5.toMD5(paramString);
    this.q.put(paramString, new Pair(Long.valueOf(paramLong1), Long.valueOf(paramLong2)));
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
    {
      MessageCache.AsyncEditor localAsyncEditor = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getC2CLastMessageTime");
      localStringBuilder.append(paramString);
      localAsyncEditor.putLong(localStringBuilder.toString(), paramLong1);
      localAsyncEditor = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getC2CLastMessageTimeRand");
      localStringBuilder.append(paramString);
      localAsyncEditor.putLong(localStringBuilder.toString(), paramLong2);
    }
  }
  
  public void b(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    a(paramString1, paramString2, paramArrayOfByte, true);
  }
  
  public void b(String paramString, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addPCQQSearchMsgKey uin:");
      localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      localStringBuilder.append("peerUin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" key:");
      localStringBuilder.append(a(paramArrayOfByte));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = (byte[])this.w.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.w.put(paramString, paramArrayOfByte);
      if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
      {
        paramArrayOfByte = a(paramArrayOfByte);
        this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor.putString(paramString, paramArrayOfByte);
      }
    }
  }
  
  public void b(String paramString, Object[] paramArrayOfObject)
  {
    if (paramString != null)
    {
      this.i.put(paramString, paramArrayOfObject);
      if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
      {
        MessageCache.AsyncEditor localAsyncEditor = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getDiscussionMemberSeq");
        localStringBuilder.append(paramString);
        localAsyncEditor.putLong(localStringBuilder.toString(), ((Long)paramArrayOfObject[0]).longValue());
        localAsyncEditor = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getDiscussionConfigSeq");
        localStringBuilder.append(paramString);
        localAsyncEditor.putLong(localStringBuilder.toString(), ((Long)paramArrayOfObject[1]).longValue());
      }
    }
  }
  
  public void b(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((MessageRecord)paramList.next());
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
    {
      paramArrayOfByte = a(paramArrayOfByte);
      if (QLog.isColorLevel())
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("--->>setLastPubAccountCookie lastPACookie:");
        localStringBuilder.append(paramArrayOfByte);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor.putString("getMsgV4_vPubAccountCookie", paramArrayOfByte);
    }
  }
  
  public boolean b()
  {
    return this.j.isEmpty();
  }
  
  public boolean b(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    if (paramMessageRecord == null) {
      return false;
    }
    Object localObject = UinTypeUtil.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if (paramMessageRecord.isLongMsg())
    {
      boolean bool1 = bool2;
      if (this.R.containsKey(localObject))
      {
        bool1 = bool2;
        if (((ConcurrentHashMap)this.R.get(localObject)).containsKey(Integer.valueOf(paramMessageRecord.longMsgId))) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if (this.r.containsKey(localObject))
    {
      localObject = (ConcurrentHashMap)this.r.get(localObject);
      if ((localObject != null) && (((ConcurrentHashMap)localObject).containsKey(Long.valueOf(paramMessageRecord.uniseq)))) {
        return true;
      }
    }
    return false;
  }
  
  public byte[] b()
  {
    if ((this.jdField_b_of_type_ArrayOfByte == null) && (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)) {
      this.jdField_b_of_type_ArrayOfByte = q(this.jdField_a_of_type_AndroidContentSharedPreferences.getString("getMsgV4_vPubAccountCookie", ""));
    }
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--->>getLastPubAccountCookie lastPACookie:");
      localStringBuilder.append(a(this.jdField_b_of_type_ArrayOfByte));
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return this.jdField_b_of_type_ArrayOfByte;
  }
  
  public byte[] b(String paramString)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getWpaMsgKey uin:null peerUin:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" key:null");
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      return null;
    }
    if (!this.v.containsKey(paramString))
    {
      localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString, null);
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getWpaMsgKey uin:");
          localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
          localStringBuilder.append("peerUin:");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" key:null");
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        return null;
      }
      localObject = q((String)localObject);
      this.v.put(paramString, localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getWpaMsgKey uin:");
      localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      localStringBuilder.append("peerUin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" key:");
      localStringBuilder.append(a((byte[])this.v.get(paramString)));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return (byte[])this.v.get(paramString);
  }
  
  public byte[] b(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, true);
  }
  
  public Object[] b(String paramString)
  {
    if (this.h.containsKey(paramString)) {
      return (Object[])this.h.get(paramString);
    }
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroopMemberSeq");
      localStringBuilder.append(paramString);
      long l1 = localSharedPreferences.getLong(localStringBuilder.toString(), -1L);
      localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroopConfigSeq");
      localStringBuilder.append(paramString);
      long l2 = localSharedPreferences.getLong(localStringBuilder.toString(), -1L);
      if (l1 != 0L) {
        return new Object[] { Long.valueOf(l1), Long.valueOf(l2) };
      }
    }
    return null;
  }
  
  public int c(String paramString)
  {
    return jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$Callback.a(paramString, this);
  }
  
  public long c()
  {
    if ((this.jdField_a_of_type_Long == -1L) && (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)) {
      this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getTroopDiscMsgLastTime", 0L);
    }
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--->>getTroopAndDiscMsgLastTime lastTime: ");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return this.jdField_a_of_type_Long;
  }
  
  public long c(String paramString)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() == null) {
      return 0L;
    }
    if (!this.l.containsKey(paramString))
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroopExpiredSeq");
      localStringBuilder.append(paramString);
      long l1 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
      this.l.put(paramString, Long.valueOf(l1));
    }
    return ((Long)this.l.get(paramString)).longValue();
  }
  
  public ConcurrentHashMap<String, Integer> c()
  {
    return this.ag;
  }
  
  public void c()
  {
    this.T.clear();
  }
  
  public void c(long paramLong)
  {
    String str = this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin();
    if ((!TextUtils.isEmpty(str)) && (paramLong > 0L))
    {
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Long.valueOf(paramLong));
      Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("birth");
      localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_time");
      ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), paramLong);
      ((SharedPreferences.Editor)localObject).apply();
    }
  }
  
  public void c(MessageRecord paramMessageRecord)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageRecord.frienduin);
    localStringBuilder.append("_");
    localStringBuilder.append(paramMessageRecord.msgUid);
    localStringBuilder.append("_");
    localStringBuilder.append(paramMessageRecord.shmsgseq);
    paramMessageRecord = localStringBuilder.toString();
    this.jdField_a_of_type_JavaUtilSet.add(paramMessageRecord);
  }
  
  public void c(String paramString)
  {
    if (paramString != null) {
      this.n.put(paramString, Boolean.valueOf(true));
    }
  }
  
  public void c(String paramString, long paramLong)
  {
    paramLong = Math.max(paramLong, d(paramString));
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("addDiscExpiredSeq ");
      localStringBuilder.append(paramLong);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.m.put(paramString, Long.valueOf(paramLong));
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDiscussionExpiredSeq");
      localStringBuilder.append(paramString);
      ((MessageCache.AsyncEditor)localObject).putLong(localStringBuilder.toString(), paramLong);
    }
  }
  
  public void c(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      paramString1 = localStringBuilder.toString();
    }
    try
    {
      paramString2 = (byte[])this.Z.get(paramString1);
      if (((paramString2 == null) || (!Arrays.equals(paramString2, paramArrayOfByte))) && (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null))
      {
        paramString2 = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("tiny_session_sig");
        paramString2 = paramString2.getSharedPreferences(localStringBuilder.toString(), 0).edit();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
        {
          this.Z.put(paramString1, paramArrayOfByte);
          paramString2.putString(paramString1, b(paramArrayOfByte));
        }
        else
        {
          this.Z.remove(paramString1);
          paramString2.remove(paramString1);
        }
        paramString2.commit();
      }
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public void c(String paramString, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("addBusinessCrmMsgKey----> sig:");
      localStringBuilder.append(a(paramArrayOfByte));
      localStringBuilder.append(",length:");
      localStringBuilder.append(paramArrayOfByte.length);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = (byte[])this.x.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.x.put(paramString, paramArrayOfByte);
      if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
      {
        localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("crm");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
        paramArrayOfByte = b(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public void c(String paramString, Object[] paramArrayOfObject)
  {
    if (paramString != null)
    {
      this.h.put(paramString, paramArrayOfObject);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "addGroupMsgMemberSeq: groupUin=", paramString, "lastSeqId=", paramArrayOfObject[0] });
      }
      if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
      {
        MessageCache.AsyncEditor localAsyncEditor = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTroopMemberSeq");
        localStringBuilder.append(paramString);
        localAsyncEditor.putLong(localStringBuilder.toString(), ((Long)paramArrayOfObject[0]).longValue());
        localAsyncEditor = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTroopConfigSeq");
        localStringBuilder.append(paramString);
        localAsyncEditor.putLong(localStringBuilder.toString(), ((Long)paramArrayOfObject[1]).longValue());
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor.putBoolean("getRegPrxyFailFlag", paramBoolean);
      if (QLog.isColorLevel())
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("--->>setRegPrxyFailFlag = ");
        localStringBuilder.append(paramBoolean);
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  public boolean c()
  {
    return this.k.isEmpty();
  }
  
  public boolean c(MessageRecord paramMessageRecord)
  {
    boolean bool2 = b(paramMessageRecord);
    boolean bool1 = bool2;
    if (paramMessageRecord.msgtype != -1051)
    {
      if (paramMessageRecord.msgtype == -1035) {
        return bool2;
      }
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (!paramMessageRecord.isLongMsg()) {
          if ((paramMessageRecord.istroop != 0) && (paramMessageRecord.istroop != 1))
          {
            bool1 = bool2;
            if (paramMessageRecord.istroop != 3000) {}
          }
          else
          {
            Object localObject = UinTypeUtil.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
            localObject = (ConcurrentHashMap)this.r.get(localObject);
            bool1 = bool2;
            if (localObject != null)
            {
              paramMessageRecord = (MessageCache.MsgSendingInfo)((ConcurrentHashMap)localObject).get(Long.valueOf(paramMessageRecord.uniseq));
              bool1 = bool2;
              if (paramMessageRecord != null)
              {
                long l1 = System.currentTimeMillis() - paramMessageRecord.jdField_b_of_type_Long;
                bool1 = bool2;
                if (l1 < paramMessageRecord.jdField_b_of_type_Int)
                {
                  bool1 = bool2;
                  if (l1 > 0L)
                  {
                    bool2 = false;
                    bool1 = bool2;
                    if (QLog.isDevelopLevel())
                    {
                      paramMessageRecord = new StringBuilder();
                      paramMessageRecord.append("isStartSendingUI, ");
                      paramMessageRecord.append(false);
                      QLog.d("MsgSend", 4, paramMessageRecord.toString());
                      bool1 = bool2;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public byte[] c(String paramString)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("pcQQSearchKey uin:null peerUin:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" key:null");
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      return null;
    }
    if (!this.w.containsKey(paramString))
    {
      localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString, null);
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("pcQQSearchKey uin:");
          localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
          localStringBuilder.append("peerUin:");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" key:null");
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        return null;
      }
      localObject = q((String)localObject);
      this.w.put(paramString, localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pcQQSearchKey uin:");
      localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      localStringBuilder.append("peerUin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" key:");
      localStringBuilder.append(a((byte[])this.w.get(paramString)));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return (byte[])this.w.get(paramString);
  }
  
  public byte[] c(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      paramString1 = localStringBuilder.toString();
      if (!this.Z.containsKey(paramString1))
      {
        paramString2 = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("tiny_session_sig");
        paramString2 = paramString2.getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString1, null);
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString2 = r(paramString2);
          if ((paramString2 != null) && (paramString2.length > 0))
          {
            this.Z.put(paramString1, paramString2);
            return paramString2;
          }
        }
        return null;
      }
      return (byte[])this.Z.get(paramString1);
    }
    return null;
  }
  
  public long d(String paramString)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() == null) {
      return 0L;
    }
    if (!this.m.containsKey(paramString))
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDiscussionExpiredSeq");
      localStringBuilder.append(paramString);
      long l1 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
      this.m.put(paramString, Long.valueOf(l1));
    }
    return ((Long)this.m.get(paramString)).longValue();
  }
  
  public ConcurrentHashMap<String, ArrayList<Object[]>> d()
  {
    return this.ah;
  }
  
  public void d()
  {
    if (!this.r.isEmpty())
    {
      localObject1 = new JSONArray();
      Object localObject2 = this.r.entrySet().iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        if ((((Map.Entry)localObject3).getValue() != null) && (!((ConcurrentHashMap)((Map.Entry)localObject3).getValue()).isEmpty()))
        {
          localObject3 = ((ConcurrentHashMap)((Map.Entry)localObject3).getValue()).entrySet().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("uin", ((MessageCache.MsgSendingInfo)localEntry.getValue()).jdField_a_of_type_JavaLangString);
              localJSONObject.put("type", ((MessageCache.MsgSendingInfo)localEntry.getValue()).jdField_a_of_type_Int);
              localJSONObject.put("uniseq", ((MessageCache.MsgSendingInfo)localEntry.getValue()).jdField_a_of_type_Long);
              ((JSONArray)localObject1).put(localJSONObject);
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
      if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor.putString("msgSending", ((JSONArray)localObject1).toString());
        if (QLog.isColorLevel())
        {
          localObject2 = jdField_a_of_type_JavaLangString;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("msgSending:write msgSending file before exit,");
          ((StringBuilder)localObject3).append(((JSONArray)localObject1).toString());
          QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
        }
      }
    }
    e();
    this.jdField_c_of_type_Int = -1;
    this.g.clear();
    this.ad.clear();
    this.o.clear();
    this.ah.clear();
    this.ai.clear();
    this.aj.clear();
    this.q.clear();
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    this.ak.clear();
    this.al.clear();
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    this.r.clear();
    this.s.clear();
    this.h.clear();
    this.i.clear();
    this.k.clear();
    this.j.clear();
    this.M.clear();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCacheItem;
    if (localObject1 != null) {
      ((MessageCacheItem)localObject1).a();
    }
  }
  
  public void d(long paramLong)
  {
    if (this.jdField_a_of_type_Long < paramLong)
    {
      this.jdField_a_of_type_Long = paramLong;
      if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
      {
        if (QLog.isColorLevel())
        {
          String str = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("--->>setTroopAndDiscMsgLastTime lastTime: ");
          localStringBuilder.append(paramLong);
          QLog.d(str, 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor.putLong("getTroopDiscMsgLastTime", this.jdField_a_of_type_Long);
      }
    }
  }
  
  public void d(MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  public void d(String paramString)
  {
    this.ah.remove(paramString);
  }
  
  public void d(String paramString, long paramLong)
  {
    Object localObject1 = this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin();
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(paramString)) && (paramLong > 0L))
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("_noticetime_");
      ((StringBuilder)localObject2).append(paramString);
      paramString = ((StringBuilder)localObject2).toString();
      this.f.put(paramString, Long.valueOf(paramLong));
      localObject2 = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("birth");
      localObject1 = ((BaseApplication)localObject2).getSharedPreferences(localStringBuilder.toString(), 0).edit();
      ((SharedPreferences.Editor)localObject1).putLong(paramString, paramLong);
      ((SharedPreferences.Editor)localObject1).apply();
    }
  }
  
  public void d(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      paramString1 = localStringBuilder.toString();
      try
      {
        paramString2 = (byte[])this.ab.get(paramString1);
        if (((paramString2 == null) || (!Arrays.equals(paramString2, paramArrayOfByte))) && (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null))
        {
          paramString2 = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
          localStringBuilder.append("game_buddy");
          paramString2 = paramString2.getSharedPreferences(localStringBuilder.toString(), 0).edit();
          if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
          {
            this.ab.put(paramString1, paramArrayOfByte);
            paramString2.putString(paramString1, b(paramArrayOfByte));
          }
          else
          {
            this.ab.remove(paramString1);
            paramString2.remove(paramString1);
          }
          paramString2.apply();
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append(jdField_a_of_type_JavaLangString);
        paramString2.append("GameBuddy");
        QLog.d(paramString2.toString(), 2, "addGameBuddyChatSessionKey throw e, e = ", paramString1);
      }
    }
  }
  
  public void d(String paramString, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addBusinessCrmSigt uin:");
      localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      localStringBuilder.append("peerUin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" key:");
      localStringBuilder.append(a(paramArrayOfByte));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = (byte[])this.y.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte))) {
      this.y.put(paramString, paramArrayOfByte);
    }
  }
  
  public void d(String paramString, Object[] paramArrayOfObject)
  {
    ArrayList localArrayList2 = (ArrayList)this.ah.get(paramString);
    ArrayList localArrayList1;
    if (localArrayList2 != null)
    {
      localArrayList1 = localArrayList2;
      if (localArrayList2.size() != 0) {}
    }
    else
    {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.add(paramArrayOfObject);
    this.ah.put(paramString, localArrayList1);
  }
  
  public boolean d()
  {
    ConcurrentHashMap localConcurrentHashMap = this.s;
    return (localConcurrentHashMap == null) || (localConcurrentHashMap.isEmpty());
  }
  
  public boolean d(MessageRecord paramMessageRecord)
  {
    if (this.t.isEmpty()) {
      return false;
    }
    Object localObject;
    if (paramMessageRecord.isLongMsg()) {
      localObject = String.format("%s&%d&%d&%d", new Object[] { paramMessageRecord.frienduin, Integer.valueOf(paramMessageRecord.istroop), Integer.valueOf(paramMessageRecord.longMsgId), Integer.valueOf(paramMessageRecord.longMsgCount) });
    } else {
      localObject = String.format("%s&%d&%d", new Object[] { paramMessageRecord.frienduin, Integer.valueOf(paramMessageRecord.istroop), Long.valueOf(paramMessageRecord.shmsgseq) });
    }
    if (this.t.containsKey(localObject))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("RevokeNotifyCache, msgFilter true, ");
        ((StringBuilder)localObject).append(paramMessageRecord.toString());
        QLog.d("revokeMsg", 2, ((StringBuilder)localObject).toString());
      }
      return true;
    }
    return false;
  }
  
  public byte[] d(String paramString)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getBusinessCrmKey uin:null peerUin:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" key:null");
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      return null;
    }
    if (!this.x.containsKey(paramString))
    {
      localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      localStringBuilder.append("crm");
      localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("businessCrmKey uin:");
          localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
          localStringBuilder.append("peerUin:");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" key:null");
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        return null;
      }
      localObject = r((String)localObject);
      this.x.put(paramString, localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("businessCrmKey uin:");
      localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      localStringBuilder.append("peerUin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" key:");
      localStringBuilder.append(a((byte[])this.x.get(paramString)));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return (byte[])this.x.get(paramString);
  }
  
  public byte[] d(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      paramString1 = localStringBuilder.toString();
      if (!this.ab.containsKey(paramString1))
      {
        paramString2 = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("game_buddy");
        paramString2 = paramString2.getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString1, null);
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString2 = r(paramString2);
          if ((paramString2 != null) && (paramString2.length > 0))
          {
            this.ab.put(paramString1, paramString2);
            return paramString2;
          }
        }
        return null;
      }
      return (byte[])this.ab.get(paramString1);
    }
    return null;
  }
  
  public long e(String paramString)
  {
    String str = this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin();
    if (str == null) {
      return 0L;
    }
    if (!this.N.containsKey(paramString))
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(str);
      long l1 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
      this.N.put(paramString, Long.valueOf(l1));
    }
    return ((Long)this.N.get(paramString)).longValue();
  }
  
  public ConcurrentHashMap<String, ConcurrentHashMap<Long, MessageCache.MsgSendingInfo>> e()
  {
    return this.s;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "msgCache commit.");
      }
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor.commit();
    }
  }
  
  public void e(String paramString)
  {
    this.j.put(paramString, Boolean.valueOf(true));
  }
  
  public void e(String paramString, long paramLong)
  {
    this.N.put(paramString, Long.valueOf(paramLong));
    String str = this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin();
    if (str != null)
    {
      MessageCache.AsyncEditor localAsyncEditor = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(str);
      localAsyncEditor.putLong(localStringBuilder.toString(), paramLong).commit();
    }
  }
  
  public void e(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      paramString1 = localStringBuilder.toString();
      try
      {
        paramString2 = (byte[])this.aa.get(paramString1);
        if (((paramString2 == null) || (!Arrays.equals(paramString2, paramArrayOfByte))) && (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null))
        {
          paramString2 = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
          localStringBuilder.append("qq_circle");
          paramString2 = paramString2.getSharedPreferences(localStringBuilder.toString(), 0).edit();
          if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
          {
            this.aa.put(paramString1, paramArrayOfByte);
            paramString2.putString(paramString1, b(paramArrayOfByte));
          }
          else
          {
            this.aa.remove(paramString1);
            paramString2.remove(paramString1);
          }
          paramString2.apply();
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append(jdField_a_of_type_JavaLangString);
        paramString2.append("QQCircle");
        QLog.d(paramString2.toString(), 2, "addQQCircleChatSessionKey throw e, e = ", paramString1);
      }
    }
  }
  
  public void e(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])this.A.get(paramString);
    if ((localObject == null) || (!localObject.equals(paramArrayOfByte)))
    {
      this.A.put(paramString, paramArrayOfByte);
      if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
      {
        localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("pub");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
        paramArrayOfByte = b(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public boolean e()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public byte[] e(String paramString)
  {
    String str;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() == null)
    {
      if (QLog.isColorLevel())
      {
        str = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("businessCrmSigt uin:null peerUin:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" key:null");
        QLog.d(str, 2, localStringBuilder.toString());
      }
      return null;
    }
    if (!this.y.containsKey(paramString)) {
      return null;
    }
    if (QLog.isColorLevel())
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("businessCrmSigt uin:");
      localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      localStringBuilder.append("peerUin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" key:");
      localStringBuilder.append(a((byte[])this.y.get(paramString)));
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return (byte[])this.y.get(paramString);
  }
  
  public byte[] e(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      paramString1 = localStringBuilder.toString();
      if (!this.aa.containsKey(paramString1))
      {
        paramString2 = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("qq_circle");
        paramString2 = paramString2.getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString1, null);
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString2 = r(paramString2);
          if ((paramString2 != null) && (paramString2.length > 0))
          {
            this.aa.put(paramString1, paramString2);
            return paramString2;
          }
        }
        return null;
      }
      return (byte[])this.aa.get(paramString1);
    }
    return null;
  }
  
  public long f(String paramString)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() == null) {
      return 0L;
    }
    Object localObject2 = (Long)this.M.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getFriendFeedLastTime");
      ((StringBuilder)localObject2).append(paramString);
      long l1 = ((SharedPreferences)localObject1).getLong(((StringBuilder)localObject2).toString(), -1L);
      this.M.put(paramString, Long.valueOf(l1));
      localObject1 = Long.valueOf(l1);
    }
    return ((Long)localObject1).longValue();
  }
  
  public ConcurrentHashMap<String, ArrayList<RevokeMsgInfo>> f()
  {
    return this.t;
  }
  
  public void f()
  {
    synchronized (this.Q)
    {
      this.Q.clear();
      return;
    }
  }
  
  public void f(String paramString)
  {
    if (this.j.containsKey(paramString)) {
      this.j.remove(paramString);
    }
  }
  
  public void f(String paramString, long paramLong)
  {
    this.M.put(paramString, Long.valueOf(paramLong));
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
    {
      MessageCache.AsyncEditor localAsyncEditor = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFriendFeedLastTime");
      localStringBuilder.append(paramString);
      localAsyncEditor.putLong(localStringBuilder.toString(), paramLong);
    }
  }
  
  public void f(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])this.B.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.B.put(paramString, paramArrayOfByte);
      if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
      {
        localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("same_state");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
        paramArrayOfByte = b(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public byte[] f(String paramString)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() == null) {
      return null;
    }
    if (!this.I.containsKey(paramString))
    {
      Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      localStringBuilder.append("circle_group");
      localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
      if (localObject == null) {
        return null;
      }
      localObject = r((String)localObject);
      this.I.put(paramString, localObject);
    }
    return (byte[])this.I.get(paramString);
  }
  
  public long g(String paramString)
  {
    paramString = (Long)this.T.get(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.longValue();
  }
  
  public void g()
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dumpGroupMsgJob size = ");
      localStringBuilder.append(this.j.size());
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void g(String paramString)
  {
    this.k.put(paramString, Boolean.valueOf(true));
  }
  
  public void g(String paramString, long paramLong)
  {
    this.T.put(paramString, Long.valueOf(paramLong));
  }
  
  public void g(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      Object localObject = (byte[])this.C.get(paramString);
      if (((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte))) && (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null))
      {
        localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("accost");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
        {
          this.C.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, b(paramArrayOfByte));
        }
        else
        {
          this.C.remove(paramString);
          ((SharedPreferences.Editor)localObject).remove(paramString);
        }
        ((SharedPreferences.Editor)localObject).commit();
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public byte[] g(String paramString)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() == null) {
      return null;
    }
    if (!this.J.containsKey(paramString))
    {
      Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      localStringBuilder.append("circle_group_av");
      localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
      if (localObject == null) {
        return null;
      }
      localObject = r((String)localObject);
      this.J.put(paramString, localObject);
    }
    return (byte[])this.J.get(paramString);
  }
  
  public long h(String paramString)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() == null) {
      return 0L;
    }
    if (!this.o.containsKey(paramString))
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDiscussionLastMessageTime");
      localStringBuilder.append(paramString);
      long l1 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
      this.o.put(paramString, Long.valueOf(l1));
    }
    return ((Long)this.o.get(paramString)).longValue();
  }
  
  public void h()
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dumpDiscMsgJob size = ");
      localStringBuilder.append(this.k.size());
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void h(String paramString)
  {
    if (this.k.containsKey(paramString)) {
      this.k.remove(paramString);
    }
  }
  
  public void h(String paramString, long paramLong)
  {
    paramLong = Math.max(paramLong, h(paramString));
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("addDiscussionMsgLastSeq ");
      localStringBuilder.append(paramLong);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.o.put(paramString, Long.valueOf(paramLong));
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDiscussionLastMessageTime");
      localStringBuilder.append(paramString);
      ((MessageCache.AsyncEditor)localObject).putLong(localStringBuilder.toString(), paramLong);
    }
  }
  
  public void h(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      Object localObject = (byte[])this.F.get(paramString);
      if (((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte))) && (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null))
      {
        localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("tribe_bytes_chat_sig");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
        {
          this.F.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, b(paramArrayOfByte));
        }
        else
        {
          this.F.remove(paramString);
          ((SharedPreferences.Editor)localObject).remove(paramString);
        }
        ((SharedPreferences.Editor)localObject).commit();
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public byte[] h(String paramString)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() == null) {
      return null;
    }
    if (!this.K.containsKey(paramString))
    {
      Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      localStringBuilder.append("friend_validation");
      localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
      if (localObject == null) {
        return null;
      }
      localObject = r((String)localObject);
      this.K.put(paramString, localObject);
    }
    return (byte[])this.K.get(paramString);
  }
  
  public long i(String paramString)
  {
    long l1 = h(paramString);
    long l2 = d(paramString);
    long l3 = a(paramString, 3000);
    return Math.max(Math.max(l1, l2), l3);
  }
  
  public void i()
  {
    this.jdField_a_of_type_JavaUtilSet.clear();
  }
  
  public void i(String paramString)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeHotChatSeq groupUin:");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.g.put(paramString, Long.valueOf(0L));
    this.h.put(paramString, new Object[] { Long.valueOf(0L), Long.valueOf(0L) });
    this.l.put(paramString, Long.valueOf(0L));
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroopLastMessageTime");
      localStringBuilder.append(paramString);
      ((MessageCache.AsyncEditor)localObject).remove(localStringBuilder.toString());
      localObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroopMemberSeq");
      localStringBuilder.append(paramString);
      ((MessageCache.AsyncEditor)localObject).remove(localStringBuilder.toString());
      localObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroopConfigSeq");
      localStringBuilder.append(paramString);
      ((MessageCache.AsyncEditor)localObject).remove(localStringBuilder.toString());
      localObject = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroopExpiredSeq");
      localStringBuilder.append(paramString);
      ((MessageCache.AsyncEditor)localObject).remove(localStringBuilder.toString());
    }
  }
  
  public void i(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      Object localObject = (byte[])this.H.get(paramString);
      if (((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte))) && (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null))
      {
        localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("movie_ticket_bytes_chat_sig");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
        {
          this.H.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, b(paramArrayOfByte));
        }
        else
        {
          this.H.remove(paramString);
          ((SharedPreferences.Editor)localObject).remove(paramString);
        }
        ((SharedPreferences.Editor)localObject).commit();
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public byte[] i(String paramString)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() == null) {
      return null;
    }
    if (!this.B.containsKey(paramString))
    {
      Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      localStringBuilder.append("same_state");
      localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
      if (localObject == null) {
        return null;
      }
      localObject = r((String)localObject);
      this.B.put(paramString, localObject);
    }
    return (byte[])this.B.get(paramString);
  }
  
  public long j(String paramString)
  {
    long l1 = a(paramString, 1);
    long l2 = b(paramString);
    long l3 = c(paramString);
    return Math.max(Math.max(l2, l1), l3);
  }
  
  public void j(String paramString)
  {
    paramString = MD5.toMD5(paramString);
    if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
    {
      MessageCache.AsyncEditor localAsyncEditor = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteFriendMsgTime");
      localStringBuilder.append(paramString);
      localAsyncEditor.remove(localStringBuilder.toString());
    }
  }
  
  public void j(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      Object localObject = (byte[])this.U.get(paramString);
      if (((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte))) && (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null))
      {
        localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("approval_assistant");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
        {
          this.U.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, b(paramArrayOfByte));
        }
        else
        {
          this.U.remove(paramString);
          ((SharedPreferences.Editor)localObject).remove(paramString);
        }
        ((SharedPreferences.Editor)localObject).commit();
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public byte[] j(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() == null) {
        return null;
      }
      if (!this.F.containsKey(paramString))
      {
        Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("tribe_bytes_chat_sig");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = r((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            this.F.put(paramString, localObject);
            return localObject;
          }
        }
        return null;
      }
      return (byte[])this.F.get(paramString);
    }
    return null;
  }
  
  public void k(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      Object localObject = (byte[])this.E.get(paramString);
      if (((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte))) && (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null))
      {
        localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("dating");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
        {
          this.E.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, b(paramArrayOfByte));
        }
        else
        {
          this.E.remove(paramString);
          ((SharedPreferences.Editor)localObject).remove(paramString);
        }
        ((SharedPreferences.Editor)localObject).commit();
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public byte[] k(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() == null) {
        return null;
      }
      if (!this.G.containsKey(paramString))
      {
        Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("audioroom_bytes_chat_sig");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = r((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            this.G.put(paramString, localObject);
            return localObject;
          }
        }
        return null;
      }
      return (byte[])this.G.get(paramString);
    }
    return null;
  }
  
  public void l(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])this.I.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.I.put(paramString, paramArrayOfByte);
      if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
      {
        localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("circle_group");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
        paramArrayOfByte = b(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public byte[] l(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() == null) {
        return null;
      }
      if (!this.H.containsKey(paramString))
      {
        Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("movie_ticket_bytes_chat_sig");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = r((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            this.H.put(paramString, localObject);
            return localObject;
          }
        }
        return null;
      }
      return (byte[])this.H.get(paramString);
    }
    return null;
  }
  
  public void m(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])this.J.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.J.put(paramString, paramArrayOfByte);
      if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
      {
        localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("circle_group_av");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
        paramArrayOfByte = b(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public byte[] m(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() == null) {
        return null;
      }
      if (!this.C.containsKey(paramString))
      {
        Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("accost");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = r((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            this.C.put(paramString, localObject);
            return localObject;
          }
        }
        return null;
      }
      return (byte[])this.C.get(paramString);
    }
    return null;
  }
  
  public void n(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])this.K.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.K.put(paramString, paramArrayOfByte);
      if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null)
      {
        localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("friend_validation");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
        paramArrayOfByte = b(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public byte[] n(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() == null) {
        return null;
      }
      if (!this.U.containsKey(paramString))
      {
        Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("approval_assistant");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = r((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            this.U.put(paramString, localObject);
            return localObject;
          }
        }
        return null;
      }
      return (byte[])this.U.get(paramString);
    }
    return null;
  }
  
  public void o(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      Object localObject = (byte[])this.G.get(paramString);
      if (((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte))) && (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() != null))
      {
        localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("audioroom_bytes_chat_sig");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
        {
          this.G.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, b(paramArrayOfByte));
        }
        else
        {
          this.G.remove(paramString);
          ((SharedPreferences.Editor)localObject).remove(paramString);
        }
        ((SharedPreferences.Editor)localObject).commit();
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public byte[] o(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() == null) {
        return null;
      }
      if (!this.D.containsKey(paramString))
      {
        Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("nearby_assistant");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = r((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            this.D.put(paramString, localObject);
            return localObject;
          }
        }
        return null;
      }
      return (byte[])this.D.get(paramString);
    }
    return null;
  }
  
  public byte[] p(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin() == null) {
        return null;
      }
      if (!this.E.containsKey(paramString))
      {
        Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        localStringBuilder.append("dating");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = r((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            this.E.put(paramString, localObject);
            return localObject;
          }
        }
        return null;
      }
      return (byte[])this.E.get(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageCache
 * JD-Core Version:    0.7.0.1
 */