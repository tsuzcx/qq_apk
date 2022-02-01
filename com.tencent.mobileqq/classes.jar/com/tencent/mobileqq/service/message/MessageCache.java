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
  public static MessageCache.RegPrxyCache d;
  public static MessageCache.Callback e;
  public static int n = 3;
  public static HashMap<String, MessageCache.MsgCacheStrategyParam> p = new HashMap();
  public static boolean q;
  private static final AppShareID r = new AppShareID();
  private static String s;
  private ConcurrentHashMap<String, Long> A = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> B = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Boolean> C = new ConcurrentHashMap();
  private ArrayList<stConfNumInfo> D = new ArrayList();
  private ConcurrentHashMap<String, Long> E = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Pair<Long, Long>> F = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Pair<Long, Long>> G = new ConcurrentHashMap();
  private ArrayList<String> H = new ArrayList();
  private ConcurrentHashMap<String, ConcurrentHashMap<Long, MessageCache.MsgSendingInfo>> I = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<Long, MessageCache.MsgSendingInfo>> J = new ConcurrentHashMap();
  private boolean K = false;
  private MessageRecord L = null;
  private ConcurrentHashMap<String, ArrayList<RevokeMsgInfo>> M = new ConcurrentHashMap();
  private ConcurrentHashMap<String, List<Integer>> N = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> O = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> P = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> Q = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> R = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> S = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> T = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> U = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> V = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> W = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> X = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> Y = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> Z = new ConcurrentHashMap();
  private SharedPreferences aA;
  private MessageCache.AsyncEditor aB;
  private int aC = -1;
  private boolean aD = false;
  private ConcurrentHashMap<String, Integer> aE = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ArrayList<Object[]>> aF = new ConcurrentHashMap();
  private ConcurrentHashMap<Long, ArrayList<msg_comm.Msg>> aG = new ConcurrentHashMap();
  private ConcurrentHashMap<Long, ArrayList<msg_comm.Msg>> aH = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> aI = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ArrayList<Object[]>> aJ = new ConcurrentHashMap();
  private ConcurrentHashMap<String, DisMsgReadedNotify> aK = new ConcurrentHashMap();
  private ConcurrentHashMap<String, GroupMsgReadedNotify> aL = new ConcurrentHashMap();
  private long aM = 0L;
  private ConcurrentHashMap<String, AppShareID> aN = new ConcurrentHashMap();
  private final HashSet<String> aO = new HashSet();
  private ConcurrentHashMap<String, OpenID> aP = new ConcurrentHashMap();
  private HashMap<Long, ArrayList<String>> aQ = new HashMap();
  private ConcurrentHashMap<String, Object> aR = new ConcurrentHashMap();
  private boolean aS = false;
  private ConcurrentHashMap<String, byte[]> aa = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> ab = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> ac = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> ad = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> ae = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> af = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> ag = new ConcurrentHashMap();
  private ConcurrentHashMap<Pair<String, Integer>, Long> ah = new ConcurrentHashMap();
  private ConcurrentHashMap<Pair<String, Integer>, Long> ai = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<String, Set<Integer>>> aj = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<Integer, HashSet<Long>>> ak = new ConcurrentHashMap();
  private ConcurrentHashMap<String, MessageRecord> al = new ConcurrentHashMap();
  private Set<String> am = Collections.synchronizedSet(new HashSet());
  private ConcurrentHashMap<String, Long> an = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> ao = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> ap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> aq = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> ar = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> as = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> at = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> au = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> av = new ConcurrentHashMap();
  private byte[] aw;
  private byte[] ax;
  private long ay = -1L;
  private int az = -1;
  public ConcurrentHashMap<String, String> b = new ConcurrentHashMap();
  public AtomicInteger c = new AtomicInteger(0);
  public ConcurrentHashMap<String, String> f = new ConcurrentHashMap();
  public ConcurrentHashMap<String, Long> g = new ConcurrentHashMap();
  public HashMap<Long, MessageRecord> h = new HashMap();
  public ConcurrentHashMap<String, Long> i = new ConcurrentHashMap();
  public ConcurrentHashMap<String, Set<String>> j = new ConcurrentHashMap();
  public ConcurrentHashMap<String, Long> k = new ConcurrentHashMap();
  public MessageCacheItem l;
  public List<MessageRecord> m = new ArrayList();
  ArrayList<MessageRecord> o = new ArrayList();
  private AppRuntime t;
  private int u = 0;
  private ConcurrentHashMap<String, Long> v = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Object[]> w = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Object[]> x = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Boolean> y = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Boolean> z = new ConcurrentHashMap();
  
  static
  {
    a = 200;
    s = "Q.msg.MessageCache";
    e = new MessageCacheDummyCallback();
    InitMsgModule.a();
  }
  
  public MessageCache(AppRuntime paramAppRuntime)
  {
    this.t = paramAppRuntime;
    this.aA = paramAppRuntime.getApp().getSharedPreferences(paramAppRuntime.getCurrentAccountUin(), 0);
    this.aB = new MessageCache.AsyncEditor(this);
    q = false;
  }
  
  private StringBuilder J()
  {
    return e.a();
  }
  
  private byte[] Y(String paramString)
  {
    return e.a(paramString);
  }
  
  private byte[] Z(String paramString)
  {
    return e.b(paramString);
  }
  
  public static void a(MessageCache.Callback paramCallback)
  {
    e = paramCallback;
  }
  
  public static boolean a(MessageCache.MsgSendingInfo paramMsgSendingInfo)
  {
    if ((paramMsgSendingInfo != null) && (paramMsgSendingInfo.d > 0L))
    {
      long l1 = System.currentTimeMillis() - paramMsgSendingInfo.d;
      if ((l1 < a) && (l1 > 0L)) {
        return false;
      }
    }
    return true;
  }
  
  public static long c()
  {
    return NetConnInfoCenter.getServerTime();
  }
  
  private String c(byte[] paramArrayOfByte)
  {
    return e.a(paramArrayOfByte);
  }
  
  private String d(byte[] paramArrayOfByte)
  {
    return e.b(paramArrayOfByte);
  }
  
  private List<MessageRecord> e(String paramString, int paramInt)
  {
    return e.a(paramString, paramInt, this);
  }
  
  private void i(String paramString, long paramLong)
  {
    paramString = MD5.toMD5(paramString);
    if (this.t.getCurrentAccountUin() != null)
    {
      MessageCache.AsyncEditor localAsyncEditor = this.aB;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteFriendMsgTime");
      localStringBuilder.append(paramString);
      localAsyncEditor.putLong(localStringBuilder.toString(), paramLong);
    }
  }
  
  public void A()
  {
    this.am.clear();
  }
  
  public Object[] A(String paramString)
  {
    if (this.x.containsKey(paramString)) {
      return (Object[])this.x.get(paramString);
    }
    if (this.t.getCurrentAccountUin() != null)
    {
      SharedPreferences localSharedPreferences = this.aA;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDiscussionMemberSeq");
      localStringBuilder.append(paramString);
      long l1 = localSharedPreferences.getLong(localStringBuilder.toString(), -1L);
      localSharedPreferences = this.aA;
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
  
  public boolean B()
  {
    ConcurrentHashMap localConcurrentHashMap = this.J;
    return (localConcurrentHashMap == null) || (localConcurrentHashMap.isEmpty());
  }
  
  public Object[] B(String paramString)
  {
    if (this.w.containsKey(paramString)) {
      return (Object[])this.w.get(paramString);
    }
    if (this.t.getCurrentAccountUin() != null)
    {
      SharedPreferences localSharedPreferences = this.aA;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroopMemberSeq");
      localStringBuilder.append(paramString);
      long l1 = localSharedPreferences.getLong(localStringBuilder.toString(), -1L);
      localSharedPreferences = this.aA;
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
  
  public ConcurrentHashMap<String, ConcurrentHashMap<Long, MessageCache.MsgSendingInfo>> C()
  {
    return this.J;
  }
  
  public void C(String paramString)
  {
    if (paramString != null) {
      this.C.put(paramString, Boolean.valueOf(true));
    }
  }
  
  public int D(String paramString)
  {
    if (!this.aI.containsKey(paramString)) {
      this.aI.put(paramString, Integer.valueOf(2));
    }
    return ((Integer)this.aI.get(paramString)).intValue();
  }
  
  public boolean D()
  {
    return this.K;
  }
  
  public DisMsgReadedNotify E(String paramString)
  {
    return (DisMsgReadedNotify)this.aK.remove(paramString);
  }
  
  public ConcurrentHashMap<String, ArrayList<RevokeMsgInfo>> E()
  {
    return this.M;
  }
  
  public int F()
  {
    if (this.aC < 0) {
      if (this.aA.contains("msgsignal_switch")) {
        this.aC = this.aA.getInt("msgsignal_switch", 0);
      } else {
        this.aC = 0;
      }
    }
    return this.aC;
  }
  
  public GroupMsgReadedNotify F(String paramString)
  {
    return (GroupMsgReadedNotify)this.aL.remove(paramString);
  }
  
  public long G(String paramString)
  {
    paramString = (Long)this.an.get(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.longValue();
  }
  
  public MessageCacheItem G()
  {
    if (this.l == null) {
      this.l = new MessageCacheItem(this.t, 1026, "hctopic", this.aA, this.aB);
    }
    return this.l;
  }
  
  public BaseMsgProxy H()
  {
    return e.a(0, this);
  }
  
  public void H(String paramString)
  {
    this.aJ.remove(paramString);
  }
  
  public ArrayList<Object[]> I(String paramString)
  {
    return (ArrayList)this.aJ.get(paramString);
  }
  
  public long J(String paramString)
  {
    if (this.t.getCurrentAccountUin() == null) {
      return 0L;
    }
    if (!this.E.containsKey(paramString))
    {
      SharedPreferences localSharedPreferences = this.aA;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDiscussionLastMessageTime");
      localStringBuilder.append(paramString);
      long l1 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
      this.E.put(paramString, Long.valueOf(l1));
    }
    return ((Long)this.E.get(paramString)).longValue();
  }
  
  public Pair<Long, Long> K(String paramString)
  {
    if (this.t.getCurrentAccountUin() == null) {
      return null;
    }
    Object localObject2 = (Pair)this.F.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.aA;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getDisscussionInfoSeq");
      ((StringBuilder)localObject2).append(paramString);
      long l1 = ((SharedPreferences)localObject1).getLong(((StringBuilder)localObject2).toString(), 0L);
      localObject1 = this.aA;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getDisscussionInfoLastTime");
      ((StringBuilder)localObject2).append(paramString);
      localObject1 = new Pair(Long.valueOf(l1), Long.valueOf(((SharedPreferences)localObject1).getLong(((StringBuilder)localObject2).toString(), 0L)));
      this.F.put(paramString, localObject1);
    }
    return localObject1;
  }
  
  public long L(String paramString)
  {
    long l1 = J(paramString);
    long l2 = x(paramString);
    long l3 = b(paramString, 3000);
    return Math.max(Math.max(l1, l2), l3);
  }
  
  public long M(String paramString)
  {
    long l1 = b(paramString, 1);
    long l2 = v(paramString);
    long l3 = w(paramString);
    return Math.max(Math.max(l2, l1), l3);
  }
  
  public Pair<Long, Long> N(String paramString)
  {
    paramString = MD5.toMD5(paramString);
    if (this.t.getCurrentAccountUin() == null) {
      return null;
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (!this.G.containsKey(paramString))
    {
      SharedPreferences localSharedPreferences = this.aA;
      StringBuilder localStringBuilder = J();
      localStringBuilder.append("getC2CLastMessageTime");
      localStringBuilder.append(paramString);
      long l1 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
      localSharedPreferences = this.aA;
      localStringBuilder = J();
      localStringBuilder.append("getC2CLastMessageTimeRand");
      localStringBuilder.append(paramString);
      long l2 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
      this.G.put(paramString, new Pair(Long.valueOf(l1), Long.valueOf(l2)));
    }
    return (Pair)this.G.get(paramString);
  }
  
  public AppShareID O(String paramString)
  {
    Object localObject1;
    if (!this.aN.containsKey(paramString))
    {
      localObject1 = this.t.getEntityManagerFactory().createEntityManager();
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
        a(paramString, r);
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
    if (this.aN.get(paramString) == r) {
      return null;
    }
    return (AppShareID)this.aN.get(paramString);
  }
  
  public void P(String paramString)
  {
    this.y.put(paramString, Boolean.valueOf(true));
  }
  
  public void Q(String paramString)
  {
    if (this.y.containsKey(paramString)) {
      this.y.remove(paramString);
    }
  }
  
  public void R(String paramString)
  {
    this.z.put(paramString, Boolean.valueOf(true));
  }
  
  public void S(String paramString)
  {
    if (this.z.containsKey(paramString)) {
      this.z.remove(paramString);
    }
  }
  
  public OpenID T(String paramString)
  {
    Object localObject1;
    if (!this.aP.containsKey(paramString))
    {
      localObject1 = this.t.getEntityManagerFactory().createEntityManager();
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
      ((StringBuilder)localObject1).append(((OpenID)this.aP.get(paramString)).openID);
      QLog.d("openid", 2, ((StringBuilder)localObject1).toString());
    }
    return (OpenID)this.aP.get(paramString);
  }
  
  public void U(String paramString)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = s;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeHotChatSeq groupUin:");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.v.put(paramString, Long.valueOf(0L));
    this.w.put(paramString, new Object[] { Long.valueOf(0L), Long.valueOf(0L) });
    this.A.put(paramString, Long.valueOf(0L));
    if (this.t.getCurrentAccountUin() != null)
    {
      localObject = this.aB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroopLastMessageTime");
      localStringBuilder.append(paramString);
      ((MessageCache.AsyncEditor)localObject).remove(localStringBuilder.toString());
      localObject = this.aB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroopMemberSeq");
      localStringBuilder.append(paramString);
      ((MessageCache.AsyncEditor)localObject).remove(localStringBuilder.toString());
      localObject = this.aB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroopConfigSeq");
      localStringBuilder.append(paramString);
      ((MessageCache.AsyncEditor)localObject).remove(localStringBuilder.toString());
      localObject = this.aB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroopExpiredSeq");
      localStringBuilder.append(paramString);
      ((MessageCache.AsyncEditor)localObject).remove(localStringBuilder.toString());
    }
  }
  
  public int V(String paramString)
  {
    return e.a(paramString, this);
  }
  
  public void W(String paramString)
  {
    paramString = MD5.toMD5(paramString);
    if (this.t.getCurrentAccountUin() != null)
    {
      MessageCache.AsyncEditor localAsyncEditor = this.aB;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteFriendMsgTime");
      localStringBuilder.append(paramString);
      localAsyncEditor.remove(localStringBuilder.toString());
    }
  }
  
  public boolean X(String paramString)
  {
    paramString = MD5.toMD5(paramString);
    if (this.t.getCurrentAccountUin() != null)
    {
      SharedPreferences localSharedPreferences = this.aA;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteFriendMsgTime");
      localStringBuilder.append(paramString);
      return localSharedPreferences.contains(localStringBuilder.toString());
    }
    return false;
  }
  
  public MessageCache.MsgSendingInfo a(MessageRecord paramMessageRecord, int paramInt)
  {
    String str = UinTypeUtil.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    MessageCache.MsgSendingInfo localMsgSendingInfo = new MessageCache.MsgSendingInfo(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, System.currentTimeMillis());
    localMsgSendingInfo.e = paramInt;
    Object localObject;
    if (this.I.containsKey(str))
    {
      localObject = (ConcurrentHashMap)this.I.get(str);
      if (localObject != null)
      {
        ((ConcurrentHashMap)localObject).put(Long.valueOf(paramMessageRecord.uniseq), localMsgSendingInfo);
      }
      else
      {
        localObject = new ConcurrentHashMap();
        ((ConcurrentHashMap)localObject).put(Long.valueOf(paramMessageRecord.uniseq), localMsgSendingInfo);
        this.I.put(str, localObject);
      }
    }
    else
    {
      localObject = new ConcurrentHashMap();
      ((ConcurrentHashMap)localObject).put(Long.valueOf(paramMessageRecord.uniseq), localMsgSendingInfo);
      this.I.put(str, localObject);
    }
    if (paramMessageRecord.isLongMsg())
    {
      if (this.ak.containsKey(str))
      {
        if (((ConcurrentHashMap)this.ak.get(str)).containsKey(Integer.valueOf(paramMessageRecord.longMsgId)))
        {
          ((HashSet)((ConcurrentHashMap)this.ak.get(str)).get(Integer.valueOf(paramMessageRecord.longMsgId))).add(Long.valueOf(paramMessageRecord.uniseq));
          return localMsgSendingInfo;
        }
        localObject = new HashSet();
        ((HashSet)localObject).add(Long.valueOf(paramMessageRecord.uniseq));
        ((ConcurrentHashMap)this.ak.get(str)).put(Integer.valueOf(paramMessageRecord.longMsgId), localObject);
        return localMsgSendingInfo;
      }
      localObject = new ConcurrentHashMap();
      HashSet localHashSet = new HashSet();
      localHashSet.add(Long.valueOf(paramMessageRecord.uniseq));
      ((ConcurrentHashMap)localObject).put(Integer.valueOf(paramMessageRecord.longMsgId), localHashSet);
      this.ak.put(str, localObject);
    }
    return localMsgSendingInfo;
  }
  
  public AppRuntime a()
  {
    return this.t;
  }
  
  public void a(int paramInt)
  {
    this.u = paramInt;
    if (this.t.getCurrentAccountUin() != null)
    {
      this.aB.putInt("getlastMessageTime", paramInt);
      if (QLog.isColorLevel())
      {
        String str = s;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("--->>setBuddyMsgLastSeq lastseq = ");
        localStringBuilder.append(paramInt);
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(long paramLong)
  {
    this.aG.remove(Long.valueOf(paramLong));
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    Object localObject2 = (ArrayList)this.aQ.get(Long.valueOf(paramLong1));
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (this.aQ.size() >= 20)
      {
        long l1 = 0L;
        localObject1 = this.aQ.keySet().iterator();
        long l2;
        for (;;)
        {
          l2 = l1;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          l2 = ((Long)((Iterator)localObject1).next()).longValue();
          long l3 = Long.parseLong((String)((ArrayList)this.aQ.get(Long.valueOf(l2))).get(0));
          if (paramLong2 - l3 > 300L) {
            break;
          }
          if (l3 < paramLong2) {
            l1 = l2;
          }
        }
        this.aQ.remove(Long.valueOf(l2));
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
    this.aQ.put(Long.valueOf(paramLong1), localObject1);
  }
  
  public void a(long paramLong, List<msg_comm.Msg> paramList)
  {
    ArrayList localArrayList2 = (ArrayList)this.aG.get(Long.valueOf(paramLong));
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
    this.aG.put(Long.valueOf(paramLong), localArrayList1);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    synchronized (this.aj)
    {
      if (!paramMessageRecord.isLongMsg()) {
        return;
      }
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = s;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("addOnlineLongMsgFragment longid=");
        ((StringBuilder)localObject2).append(paramMessageRecord.getLongMsgInfoString());
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject3 = UinTypeUtil.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      Object localObject2 = UinTypeUtil.a(paramMessageRecord);
      if ((this.aj.containsKey(localObject3)) && (this.aj.get(localObject3) != null))
      {
        localObject1 = (ConcurrentHashMap)this.aj.get(localObject3);
      }
      else
      {
        localObject1 = new ConcurrentHashMap();
        this.aj.put(localObject3, localObject1);
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
    this.H.add(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.aE.put(paramString, Integer.valueOf(paramInt));
    if (paramInt != 0)
    {
      if (QLog.isColorLevel())
      {
        String str = s;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setTroopMsgResponseState state: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" state: ");
        localStringBuilder.append(paramInt);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      if (paramInt == 2) {
        Q(paramString);
      }
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    Object localObject;
    if (paramInt == 1)
    {
      paramLong = Math.max(paramLong, v(paramString));
    }
    else if (paramInt == 3000)
    {
      paramLong = Math.max(paramLong, J(paramString));
    }
    else
    {
      localObject = e(paramString, paramInt);
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
      localObject = s;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("addMsgDelLastSeq uin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",type = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" , lastSeqId = ");
      localStringBuilder.append(paramLong);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.ae.put(UinTypeUtil.a(paramString, paramInt), Long.valueOf(Math.max(paramLong, b(paramString, paramInt))));
    if (this.t.getCurrentAccountUin() != null)
    {
      localObject = this.aB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDelMsgLastSeq");
      localStringBuilder.append(UinTypeUtil.a(paramString, paramInt));
      ((MessageCache.AsyncEditor)localObject).putLong(localStringBuilder.toString(), paramLong).commit();
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    paramLong = Math.max(paramLong, v(paramString));
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = s;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("addGroupMsgLastSeq ");
      localStringBuilder.append(paramLong);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.v.put(paramString, Long.valueOf(paramLong));
    if (this.t.getCurrentAccountUin() != null)
    {
      localObject = this.aB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroopLastMessageTime");
      localStringBuilder.append(paramString);
      ((MessageCache.AsyncEditor)localObject).putLong(localStringBuilder.toString(), paramLong);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    this.F.put(paramString, new Pair(Long.valueOf(paramLong1), Long.valueOf(paramLong2)));
    if (this.t.getCurrentAccountUin() != null)
    {
      MessageCache.AsyncEditor localAsyncEditor = this.aB;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDisscussionInfoSeq");
      localStringBuilder.append(paramString);
      localAsyncEditor.putLong(localStringBuilder.toString(), paramLong1);
      localAsyncEditor = this.aB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDisscussionInfoLastTime");
      localStringBuilder.append(paramString);
      localAsyncEditor.putLong(localStringBuilder.toString(), paramLong2);
    }
  }
  
  public void a(String paramString, DisMsgReadedNotify paramDisMsgReadedNotify)
  {
    this.aK.put(paramString, paramDisMsgReadedNotify);
  }
  
  public void a(String paramString, GroupMsgReadedNotify paramGroupMsgReadedNotify)
  {
    this.aL.put(paramString, paramGroupMsgReadedNotify);
  }
  
  public void a(String paramString, AppShareID paramAppShareID)
  {
    this.aN.put(paramString, paramAppShareID);
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
    this.aP.put(paramString, paramOpenID);
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
      paramString2 = (byte[])this.ap.get(paramString1);
      if (((paramString2 == null) || (!Arrays.equals(paramString2, paramArrayOfByte))) && (this.t.getCurrentAccountUin() != null))
      {
        paramString2 = this.t.getApp();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.t.getCurrentAccountUin());
        localStringBuilder.append("confess_sig");
        paramString2 = paramString2.getSharedPreferences(localStringBuilder.toString(), 0).edit();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
        {
          this.ap.put(paramString1, paramArrayOfByte);
          paramString2.putString(paramString1, d(paramArrayOfByte));
        }
        else
        {
          this.ap.remove(paramString1);
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
        localConcurrentHashMap = this.ar;
      } else {
        localConcurrentHashMap = this.as;
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
        if (((paramString1 == null) || (!Arrays.equals(paramString1, paramArrayOfByte))) && (this.t.getCurrentAccountUin() != null))
        {
          localObject = this.t.getApp();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.t.getCurrentAccountUin());
          localStringBuilder.append("MatchChat");
          if (paramBoolean)
          {
            paramString1 = "";
            localStringBuilder.append(paramString1);
            paramString1 = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
            if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
            {
              localConcurrentHashMap.put(paramString2, paramArrayOfByte);
              paramString1.putString(paramString2, d(paramArrayOfByte));
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
      localObject = s;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addWpaMsgKey uin:");
      localStringBuilder.append(this.t.getCurrentAccountUin());
      localStringBuilder.append("peerUin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" key:");
      localStringBuilder.append(c(paramArrayOfByte));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = (byte[])this.O.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.O.put(paramString, paramArrayOfByte);
      if (this.t.getCurrentAccountUin() != null)
      {
        paramArrayOfByte = c(paramArrayOfByte);
        this.aB.putString(paramString, paramArrayOfByte);
      }
    }
  }
  
  public void a(String paramString, Object[] paramArrayOfObject)
  {
    ArrayList localArrayList2 = (ArrayList)this.aF.get(paramString);
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
    this.aF.put(paramString, localArrayList1);
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
    int i2 = ((RevokeMsgInfo)localObject1).a;
    Object localObject2 = ((RevokeMsgInfo)localObject1).c;
    int i1;
    if (((RevokeMsgInfo)localObject1).j > 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      localObject1 = String.format("%s&%d&%d&%d", new Object[] { localObject2, Integer.valueOf(i2), Integer.valueOf(((RevokeMsgInfo)localObject1).i), Integer.valueOf(((RevokeMsgInfo)localObject1).j) });
    } else {
      localObject1 = String.format("%s&%d&%d", new Object[] { localObject2, Integer.valueOf(i2), Long.valueOf(((RevokeMsgInfo)localObject1).b) });
    }
    if (this.M.containsKey(localObject1))
    {
      localObject1 = (ArrayList)this.M.get(localObject1);
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
        } while ((localRevokeMsgInfo1.b != localRevokeMsgInfo2.b) || (localRevokeMsgInfo1.f != localRevokeMsgInfo2.f));
        ((ArrayList)localObject2).add(localRevokeMsgInfo1);
      }
      ((ArrayList)localObject1).addAll((Collection)localObject2);
      return;
    }
    this.M.put(localObject1, paramArrayList);
  }
  
  public void a(List<stConfNumInfo> paramList)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        String str = s;
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
      this.D.addAll(paramList);
      return;
    }
    finally {}
  }
  
  public void a(Set<String> paramSet)
  {
    String str = this.t.getCurrentAccountUin();
    if ((!TextUtils.isEmpty(str)) && (paramSet != null))
    {
      this.j.put(str, paramSet);
      Object localObject = this.t.getApp();
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
    this.aD = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.aw = paramArrayOfByte;
    if (this.t.getCurrentAccountUin() != null)
    {
      String str1 = c(paramArrayOfByte);
      String str2;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        str2 = s;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("--->>setLastSyncCookie lastSyncCookie:");
        localStringBuilder.append(str1);
        QLog.d(str2, 2, localStringBuilder.toString());
      }
      if (QLog.isColorLevel())
      {
        str2 = s;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("--->>setBuddyMsgLastSeq cookie = ");
        localStringBuilder.append(c(paramArrayOfByte));
        QLog.d(str2, 2, localStringBuilder.toString());
      }
      this.aB.putString("getMsgV4_vSyncCookie", str1);
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
      if (this.C.containsKey(str)) {
        this.C.remove(str);
      }
      i1 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(s, 2, localStringBuilder.toString());
    }
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
    return this.al.containsKey(paramString);
  }
  
  public boolean a(long paramLong, String paramString)
  {
    Object localObject = (ArrayList)this.aQ.get(Long.valueOf(paramLong));
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
  
  public boolean a(String paramString1, int paramInt, String paramString2)
  {
    synchronized (this.aj)
    {
      paramString1 = d(paramString1, paramInt);
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
  
  public byte[] a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (this.t.getCurrentAccountUin() != null))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      paramString1 = localStringBuilder.toString();
      if (!this.ap.containsKey(paramString1))
      {
        paramString2 = this.t.getApp();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.t.getCurrentAccountUin());
        localStringBuilder.append("confess_sig");
        paramString2 = paramString2.getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString1, null);
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString2 = Z(paramString2);
          if ((paramString2 != null) && (paramString2.length > 0))
          {
            this.ap.put(paramString1, paramString2);
            return paramString2;
          }
        }
        return null;
      }
      return (byte[])this.ap.get(paramString1);
    }
    return null;
  }
  
  public byte[] a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (this.t.getCurrentAccountUin() != null))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      ConcurrentHashMap localConcurrentHashMap;
      if (paramBoolean) {
        localConcurrentHashMap = this.ar;
      } else {
        localConcurrentHashMap = this.as;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramString2);
      paramString2 = ((StringBuilder)localObject).toString();
      if (!localConcurrentHashMap.containsKey(paramString2))
      {
        localObject = this.t.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.t.getCurrentAccountUin());
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
          paramString1 = Z(paramString1);
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
  
  public int b(String paramString)
  {
    if (!this.aE.containsKey(paramString)) {
      this.aE.put(paramString, Integer.valueOf(2));
    }
    return ((Integer)this.aE.get(paramString)).intValue();
  }
  
  public long b(String paramString, int paramInt)
  {
    String str = UinTypeUtil.a(paramString, paramInt);
    Object localObject;
    if (this.t.getCurrentAccountUin() == null)
    {
      if (QLog.isColorLevel())
      {
        str = s;
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
    if (!this.ae.containsKey(str))
    {
      localObject = this.aA;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDelMsgLastSeq");
      localStringBuilder.append(str);
      long l1 = ((SharedPreferences)localObject).getLong(localStringBuilder.toString(), 0L);
      this.ae.put(str, Long.valueOf(l1));
      if (QLog.isColorLevel())
      {
        localObject = s;
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
    return ((Long)this.ae.get(str)).longValue();
  }
  
  public MessageRecord b(int paramInt, String paramString, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.valueOf(paramInt));
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramLong);
    paramString = ((StringBuilder)localObject).toString();
    localObject = (MessageRecord)this.al.get(paramString);
    this.al.remove(paramString);
    return localObject;
  }
  
  public MessageCache.MsgSendingInfo b(String paramString, int paramInt, long paramLong)
  {
    int i4 = 0;
    int i3 = 0;
    QLog.i("MsgSend", 1, String.format("removeSendingCache key = %d %s %d", new Object[] { Long.valueOf(paramLong), MsfSdkUtils.getShortUin(paramString), Integer.valueOf(paramInt) }), new RuntimeException());
    String str2 = UinTypeUtil.a(paramString, paramInt);
    boolean bool = this.I.containsKey(str2);
    String str1 = null;
    paramString = null;
    Object localObject;
    if (bool)
    {
      localObject = (ConcurrentHashMap)this.I.get(str2);
      if (localObject != null) {
        paramString = (MessageCache.MsgSendingInfo)((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong));
      }
      str1 = paramString;
      if (localObject != null)
      {
        str1 = paramString;
        if (((ConcurrentHashMap)localObject).isEmpty())
        {
          this.I.remove(str2);
          str1 = paramString;
        }
      }
    }
    if ((!B()) && (this.J.containsKey(str2)))
    {
      paramString = (ConcurrentHashMap)this.J.get(str2);
      if (paramString != null) {
        paramString.remove(Long.valueOf(paramLong));
      }
      if ((paramString != null) && (paramString.isEmpty())) {
        this.J.remove(str2);
      }
      if (QLog.isColorLevel())
      {
        paramString = s;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("msgSending:delete result in messageSendingTemp ");
        ((StringBuilder)localObject).append(this.J);
        QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
      }
    }
    if (this.ak.containsKey(str2))
    {
      paramString = ((ConcurrentHashMap)this.ak.get(str2)).keySet().iterator();
      int i2;
      do
      {
        i1 = i4;
        if (!paramString.hasNext()) {
          break;
        }
        i2 = ((Integer)paramString.next()).intValue();
        localObject = (Set)((ConcurrentHashMap)this.ak.get(str2)).get(Integer.valueOf(i2));
        if (QLog.isColorLevel()) {
          QLog.d(s, 2, String.format("removeSendingCache  longMsgFragmentSet = %s", new Object[] { localObject }));
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
        paramString = s;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("removeSendingCache uniseq=");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append("longid=");
        ((StringBuilder)localObject).append(i2);
        QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
        i1 = paramInt;
      }
      if (i1 != 0) {
        ((ConcurrentHashMap)this.ak.get(str2)).remove(Integer.valueOf(i1));
      }
    }
    return str1;
  }
  
  public ArrayList<String> b()
  {
    return this.H;
  }
  
  public ArrayList<msg_comm.Msg> b(long paramLong)
  {
    return (ArrayList)this.aG.get(Long.valueOf(paramLong));
  }
  
  public void b(int paramInt)
  {
    if (F() != paramInt)
    {
      this.aC = paramInt;
      this.aB.putInt("msgsignal_switch", paramInt);
      if (QLog.isColorLevel())
      {
        String str = s;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("--->>setMsgSignalSwitch = ");
        localStringBuilder.append(paramInt);
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void b(long paramLong, List<msg_comm.Msg> paramList)
  {
    ArrayList localArrayList2 = (ArrayList)this.aH.get(Long.valueOf(paramLong));
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
    this.aH.put(Long.valueOf(paramLong), localArrayList1);
  }
  
  public void b(String paramString1, int paramInt, String paramString2)
  {
    synchronized (this.aj)
    {
      paramString1 = d(paramString1, paramInt);
      if (paramString1 == null) {
        return;
      }
      if (paramString1.containsKey(paramString2)) {
        paramString1.remove(paramString2);
      }
      return;
    }
  }
  
  public void b(String paramString, long paramLong)
  {
    paramLong = Math.max(paramLong, w(paramString));
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = s;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("addGroupExpiredSeq ");
      localStringBuilder.append(paramLong);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.A.put(paramString, Long.valueOf(paramLong));
    if (this.t.getCurrentAccountUin() != null)
    {
      localObject = this.aB;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroopExpiredSeq");
      localStringBuilder.append(paramString);
      ((MessageCache.AsyncEditor)localObject).putLong(localStringBuilder.toString(), paramLong);
    }
  }
  
  public void b(String paramString, long paramLong1, long paramLong2)
  {
    paramString = MD5.toMD5(paramString);
    this.G.put(paramString, new Pair(Long.valueOf(paramLong1), Long.valueOf(paramLong2)));
    if (this.t.getCurrentAccountUin() != null)
    {
      MessageCache.AsyncEditor localAsyncEditor = this.aB;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getC2CLastMessageTime");
      localStringBuilder.append(paramString);
      localAsyncEditor.putLong(localStringBuilder.toString(), paramLong1);
      localAsyncEditor = this.aB;
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
      localObject = s;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addPCQQSearchMsgKey uin:");
      localStringBuilder.append(this.t.getCurrentAccountUin());
      localStringBuilder.append("peerUin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" key:");
      localStringBuilder.append(c(paramArrayOfByte));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = (byte[])this.P.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.P.put(paramString, paramArrayOfByte);
      if (this.t.getCurrentAccountUin() != null)
      {
        paramArrayOfByte = c(paramArrayOfByte);
        this.aB.putString(paramString, paramArrayOfByte);
      }
    }
  }
  
  public void b(String paramString, Object[] paramArrayOfObject)
  {
    if (paramString != null)
    {
      this.x.put(paramString, paramArrayOfObject);
      if (this.t.getCurrentAccountUin() != null)
      {
        MessageCache.AsyncEditor localAsyncEditor = this.aB;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getDiscussionMemberSeq");
        localStringBuilder.append(paramString);
        localAsyncEditor.putLong(localStringBuilder.toString(), ((Long)paramArrayOfObject[0]).longValue());
        localAsyncEditor = this.aB;
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
    this.K = paramBoolean;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    this.ax = paramArrayOfByte;
    if (this.t.getCurrentAccountUin() != null)
    {
      paramArrayOfByte = c(paramArrayOfByte);
      if (QLog.isColorLevel())
      {
        String str = s;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("--->>setLastPubAccountCookie lastPACookie:");
        localStringBuilder.append(paramArrayOfByte);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      this.aB.putString("getMsgV4_vPubAccountCookie", paramArrayOfByte);
    }
  }
  
  public boolean b(MessageRecord paramMessageRecord)
  {
    return a(paramMessageRecord.frienduin, paramMessageRecord.istroop, UinTypeUtil.a(paramMessageRecord));
  }
  
  public byte[] b(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, true);
  }
  
  public void c(long paramLong)
  {
    this.aH.remove(Long.valueOf(paramLong));
  }
  
  public void c(MessageRecord paramMessageRecord)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.valueOf(paramMessageRecord.istroop));
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramMessageRecord.frienduin);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramMessageRecord.uniseq);
    localObject = ((StringBuilder)localObject).toString();
    this.al.put(localObject, paramMessageRecord);
  }
  
  public void c(String paramString)
  {
    this.aF.remove(paramString);
  }
  
  public void c(String paramString, int paramInt)
  {
    this.aI.put(paramString, Integer.valueOf(paramInt));
    if (paramInt != 0)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(128);
        localStringBuilder.append("setDiscussionMsgState discussionUin: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" state: ");
        localStringBuilder.append(paramInt);
        QLog.d(s, 2, localStringBuilder.toString());
      }
      if (paramInt == 2) {
        S(paramString);
      }
    }
  }
  
  public void c(String paramString, int paramInt, long paramLong)
  {
    Object localObject = UinTypeUtil.a(paramString, paramInt);
    paramString = new MessageCache.MsgSendingInfo(paramString, paramInt, paramLong, 0L);
    ConcurrentHashMap localConcurrentHashMap;
    if (this.J.containsKey(localObject))
    {
      localConcurrentHashMap = (ConcurrentHashMap)this.J.get(localObject);
      if (localConcurrentHashMap != null)
      {
        localConcurrentHashMap.put(Long.valueOf(paramLong), paramString);
      }
      else
      {
        localConcurrentHashMap = new ConcurrentHashMap();
        localConcurrentHashMap.put(Long.valueOf(paramLong), paramString);
        this.J.put(localObject, localConcurrentHashMap);
      }
    }
    else
    {
      localConcurrentHashMap = new ConcurrentHashMap();
      localConcurrentHashMap.put(Long.valueOf(paramLong), paramString);
      this.J.put(localObject, localConcurrentHashMap);
    }
    if (QLog.isColorLevel())
    {
      paramString = s;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("msgSending:addSendingCacheTemp,msgSendingTemp:");
      ((StringBuilder)localObject).append(this.J);
      ((StringBuilder)localObject).append(" msgCache:");
      ((StringBuilder)localObject).append(hashCode());
      QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void c(String paramString, long paramLong)
  {
    paramLong = Math.max(paramLong, x(paramString));
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = s;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("addDiscExpiredSeq ");
      localStringBuilder.append(paramLong);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.B.put(paramString, Long.valueOf(paramLong));
    if (this.t.getCurrentAccountUin() != null)
    {
      localObject = this.aB;
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
      paramString2 = (byte[])this.at.get(paramString1);
      if (((paramString2 == null) || (!Arrays.equals(paramString2, paramArrayOfByte))) && (this.t.getCurrentAccountUin() != null))
      {
        paramString2 = this.t.getApp();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.t.getCurrentAccountUin());
        localStringBuilder.append("tiny_session_sig");
        paramString2 = paramString2.getSharedPreferences(localStringBuilder.toString(), 0).edit();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
        {
          this.at.put(paramString1, paramArrayOfByte);
          paramString2.putString(paramString1, d(paramArrayOfByte));
        }
        else
        {
          this.at.remove(paramString1);
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
      localObject = s;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("addBusinessCrmMsgKey----> sig:");
      localStringBuilder.append(c(paramArrayOfByte));
      localStringBuilder.append(",length:");
      localStringBuilder.append(paramArrayOfByte.length);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = (byte[])this.Q.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.Q.put(paramString, paramArrayOfByte);
      if (this.t.getCurrentAccountUin() != null)
      {
        localObject = this.t.getApp();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.t.getCurrentAccountUin());
        localStringBuilder.append("crm");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
        paramArrayOfByte = d(paramArrayOfByte);
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
      this.w.put(paramString, paramArrayOfObject);
      if (QLog.isColorLevel()) {
        QLog.d(s, 2, new Object[] { "addGroupMsgMemberSeq: groupUin=", paramString, "lastSeqId=", paramArrayOfObject[0] });
      }
      if (this.t.getCurrentAccountUin() != null)
      {
        MessageCache.AsyncEditor localAsyncEditor = this.aB;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTroopMemberSeq");
        localStringBuilder.append(paramString);
        localAsyncEditor.putLong(localStringBuilder.toString(), ((Long)paramArrayOfObject[0]).longValue());
        localAsyncEditor = this.aB;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTroopConfigSeq");
        localStringBuilder.append(paramString);
        localAsyncEditor.putLong(localStringBuilder.toString(), ((Long)paramArrayOfObject[1]).longValue());
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.aS = paramBoolean;
    if (this.t.getCurrentAccountUin() != null)
    {
      this.aB.putBoolean("getRegPrxyFailFlag", paramBoolean);
      if (QLog.isColorLevel())
      {
        String str = s;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("--->>setRegPrxyFailFlag = ");
        localStringBuilder.append(paramBoolean);
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  public boolean c(String paramString, long paramLong1, long paramLong2)
  {
    if (this.am.size() == 0) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong2);
    paramString = localStringBuilder.toString();
    return this.am.contains(paramString);
  }
  
  public byte[] c(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (this.t.getCurrentAccountUin() != null))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      paramString1 = localStringBuilder.toString();
      if (!this.at.containsKey(paramString1))
      {
        paramString2 = this.t.getApp();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.t.getCurrentAccountUin());
        localStringBuilder.append("tiny_session_sig");
        paramString2 = paramString2.getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString1, null);
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString2 = Z(paramString2);
          if ((paramString2 != null) && (paramString2.length > 0))
          {
            this.at.put(paramString1, paramString2);
            return paramString2;
          }
        }
        return null;
      }
      return (byte[])this.at.get(paramString1);
    }
    return null;
  }
  
  public int d()
  {
    if ((this.u <= 0) && (this.t.getCurrentAccountUin() != null)) {
      this.u = this.aA.getInt("getlastMessageTime", 1);
    }
    if (QLog.isColorLevel())
    {
      String str = s;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--->>getBuddyMsgLastSeq: ");
      localStringBuilder.append(this.u);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return this.u;
  }
  
  public ArrayList<msg_comm.Msg> d(long paramLong)
  {
    return (ArrayList)this.aH.get(Long.valueOf(paramLong));
  }
  
  public ArrayList<Object[]> d(String paramString)
  {
    return (ArrayList)this.aF.get(paramString);
  }
  
  public Map<String, Set<Integer>> d(String paramString, int paramInt)
  {
    synchronized (this.aj)
    {
      paramString = UinTypeUtil.a(paramString, paramInt);
      if ((this.aj.containsKey(paramString)) && (this.aj.get(paramString) != null))
      {
        Map localMap = (Map)this.aj.get(paramString);
        if ((localMap != null) && (localMap.isEmpty()))
        {
          this.aj.remove(paramString);
          return null;
        }
        return localMap;
      }
      return null;
    }
  }
  
  public void d(MessageRecord paramMessageRecord)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageRecord.frienduin);
    localStringBuilder.append("_");
    localStringBuilder.append(paramMessageRecord.msgUid);
    localStringBuilder.append("_");
    localStringBuilder.append(paramMessageRecord.shmsgseq);
    paramMessageRecord = localStringBuilder.toString();
    this.am.add(paramMessageRecord);
  }
  
  public void d(String paramString, long paramLong)
  {
    Object localObject1 = this.t.getCurrentAccountUin();
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(paramString)) && (paramLong > 0L))
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("_noticetime_");
      ((StringBuilder)localObject2).append(paramString);
      paramString = ((StringBuilder)localObject2).toString();
      this.k.put(paramString, Long.valueOf(paramLong));
      localObject2 = this.t.getApp();
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
        paramString2 = (byte[])this.au.get(paramString1);
        if (((paramString2 == null) || (!Arrays.equals(paramString2, paramArrayOfByte))) && (this.t.getCurrentAccountUin() != null))
        {
          paramString2 = this.t.getApp();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.t.getCurrentAccountUin());
          localStringBuilder.append("qq_circle");
          paramString2 = paramString2.getSharedPreferences(localStringBuilder.toString(), 0).edit();
          if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
          {
            this.au.put(paramString1, paramArrayOfByte);
            paramString2.putString(paramString1, d(paramArrayOfByte));
          }
          else
          {
            this.au.remove(paramString1);
            paramString2.remove(paramString1);
          }
          paramString2.apply();
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append(s);
        paramString2.append("QQCircle");
        QLog.d(paramString2.toString(), 2, "addQQCircleChatSessionKey throw e, e = ", paramString1);
      }
    }
  }
  
  public void d(String paramString, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel())
    {
      localObject = s;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addBusinessCrmSigt uin:");
      localStringBuilder.append(this.t.getCurrentAccountUin());
      localStringBuilder.append("peerUin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" key:");
      localStringBuilder.append(c(paramArrayOfByte));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = (byte[])this.R.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte))) {
      this.R.put(paramString, paramArrayOfByte);
    }
  }
  
  public void d(String paramString, Object[] paramArrayOfObject)
  {
    ArrayList localArrayList2 = (ArrayList)this.aJ.get(paramString);
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
    this.aJ.put(paramString, localArrayList1);
  }
  
  public boolean d(String paramString, int paramInt, long paramLong)
  {
    MessageRecord localMessageRecord = this.L;
    if (localMessageRecord == null) {
      return false;
    }
    return (localMessageRecord.frienduin.equals(paramString)) && (this.L.istroop == paramInt) && (this.L.uniseq == paramLong);
  }
  
  public boolean d(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.aS = this.aA.getBoolean("getRegPrxyFailFlag", false);
    }
    return this.aS;
  }
  
  public byte[] d(String paramString1, String paramString2)
  {
    if ((this.t.getCurrentAccountUin() != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      paramString1 = localStringBuilder.toString();
      if (!this.au.containsKey(paramString1))
      {
        paramString2 = this.t.getApp();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.t.getCurrentAccountUin());
        localStringBuilder.append("qq_circle");
        paramString2 = paramString2.getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString1, null);
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString2 = Z(paramString2);
          if ((paramString2 != null) && (paramString2.length > 0))
          {
            this.au.put(paramString1, paramString2);
            return paramString2;
          }
        }
        return null;
      }
      return (byte[])this.au.get(paramString1);
    }
    return null;
  }
  
  public MessageCache.MsgSendingInfo e(MessageRecord paramMessageRecord)
  {
    return a(paramMessageRecord, a);
  }
  
  public void e(long paramLong)
  {
    String str = this.t.getCurrentAccountUin();
    if ((!TextUtils.isEmpty(str)) && (paramLong > 0L))
    {
      this.i.put(str, Long.valueOf(paramLong));
      Object localObject = this.t.getApp();
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
  
  public void e(String paramString, long paramLong)
  {
    this.ag.put(paramString, Long.valueOf(paramLong));
    String str = this.t.getCurrentAccountUin();
    if (str != null)
    {
      MessageCache.AsyncEditor localAsyncEditor = this.aB;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(str);
      localAsyncEditor.putLong(localStringBuilder.toString(), paramLong).commit();
    }
  }
  
  public void e(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])this.T.get(paramString);
    if ((localObject == null) || (!localObject.equals(paramArrayOfByte)))
    {
      this.T.put(paramString, paramArrayOfByte);
      if (this.t.getCurrentAccountUin() != null)
      {
        localObject = this.t.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.t.getCurrentAccountUin());
        localStringBuilder.append("pub");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
        paramArrayOfByte = d(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public byte[] e()
  {
    Object localObject = this.aw;
    if (((localObject == null) || (localObject.length == 0)) && (this.t.getCurrentAccountUin() != null))
    {
      localObject = this.aA.getString("getMsgV4_vSyncCookie", "");
      if (((String)localObject).length() == 0) {
        this.aw = null;
      } else {
        this.aw = Y((String)localObject);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = s;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--->>getLastSyncCookie lastSyncCookie:");
      localStringBuilder.append(c(this.aw));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return this.aw;
  }
  
  public byte[] e(String paramString)
  {
    if (this.t.getCurrentAccountUin() == null) {
      return null;
    }
    if (!this.T.containsKey(paramString))
    {
      Object localObject = this.t.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.t.getCurrentAccountUin());
      localStringBuilder.append("pub");
      localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
      if (localObject == null) {
        return null;
      }
      localObject = Z((String)localObject);
      this.T.put(paramString, localObject);
    }
    return (byte[])this.T.get(paramString);
  }
  
  public long f(String paramString)
  {
    String str = this.t.getCurrentAccountUin();
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
      if (!this.k.containsKey(paramString))
      {
        localObject = this.t.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("birth");
        long l1 = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getLong(paramString, -1L);
        if (l1 == -1L) {
          return -1L;
        }
        this.k.put(paramString, Long.valueOf(l1));
      }
      return ((Long)this.k.get(paramString)).longValue();
    }
    return -1L;
  }
  
  public void f(long paramLong)
  {
    if (this.ay < paramLong)
    {
      this.ay = paramLong;
      if (this.t.getCurrentAccountUin() != null)
      {
        if (QLog.isColorLevel())
        {
          String str = s;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("--->>setTroopAndDiscMsgLastTime lastTime: ");
          localStringBuilder.append(paramLong);
          QLog.d(str, 2, localStringBuilder.toString());
        }
        this.aB.putLong("getTroopDiscMsgLastTime", this.ay);
      }
    }
  }
  
  public void f(String paramString, long paramLong)
  {
    this.af.put(paramString, Long.valueOf(paramLong));
    if (this.t.getCurrentAccountUin() != null)
    {
      MessageCache.AsyncEditor localAsyncEditor = this.aB;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFriendFeedLastTime");
      localStringBuilder.append(paramString);
      localAsyncEditor.putLong(localStringBuilder.toString(), paramLong);
    }
  }
  
  public void f(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])this.U.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.U.put(paramString, paramArrayOfByte);
      if (this.t.getCurrentAccountUin() != null)
      {
        localObject = this.t.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.t.getCurrentAccountUin());
        localStringBuilder.append("same_state");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
        paramArrayOfByte = d(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public boolean f(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    if (paramMessageRecord == null) {
      return false;
    }
    Object localObject = UinTypeUtil.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if (paramMessageRecord.isLongMsg())
    {
      boolean bool1 = bool2;
      if (this.ak.containsKey(localObject))
      {
        bool1 = bool2;
        if (((ConcurrentHashMap)this.ak.get(localObject)).containsKey(Integer.valueOf(paramMessageRecord.longMsgId))) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if (this.I.containsKey(localObject))
    {
      localObject = (ConcurrentHashMap)this.I.get(localObject);
      if ((localObject != null) && (((ConcurrentHashMap)localObject).containsKey(Long.valueOf(paramMessageRecord.uniseq)))) {
        return true;
      }
    }
    return false;
  }
  
  public byte[] f()
  {
    if ((this.ax == null) && (this.t.getCurrentAccountUin() != null)) {
      this.ax = Y(this.aA.getString("getMsgV4_vPubAccountCookie", ""));
    }
    if (QLog.isColorLevel())
    {
      String str = s;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--->>getLastPubAccountCookie lastPACookie:");
      localStringBuilder.append(c(this.ax));
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return this.ax;
  }
  
  public ConcurrentHashMap<String, Integer> g()
  {
    return this.aE;
  }
  
  public void g(String paramString, long paramLong)
  {
    this.an.put(paramString, Long.valueOf(paramLong));
  }
  
  public void g(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      Object localObject = (byte[])this.V.get(paramString);
      if (((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte))) && (this.t.getCurrentAccountUin() != null))
      {
        localObject = this.t.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.t.getCurrentAccountUin());
        localStringBuilder.append("accost");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
        {
          this.V.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, d(paramArrayOfByte));
        }
        else
        {
          this.V.remove(paramString);
          ((SharedPreferences.Editor)localObject).remove(paramString);
        }
        ((SharedPreferences.Editor)localObject).commit();
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public boolean g(MessageRecord paramMessageRecord)
  {
    boolean bool2 = f(paramMessageRecord);
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
          if ((paramMessageRecord.istroop != 0) && (paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 3000))
          {
            bool1 = bool2;
            if (paramMessageRecord.istroop != 10014) {}
          }
          else
          {
            Object localObject = UinTypeUtil.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
            localObject = (ConcurrentHashMap)this.I.get(localObject);
            bool1 = bool2;
            if (localObject != null)
            {
              paramMessageRecord = (MessageCache.MsgSendingInfo)((ConcurrentHashMap)localObject).get(Long.valueOf(paramMessageRecord.uniseq));
              bool1 = bool2;
              if (paramMessageRecord != null)
              {
                long l1 = System.currentTimeMillis() - paramMessageRecord.d;
                bool1 = bool2;
                if (l1 < paramMessageRecord.e)
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
  
  public byte[] g(String paramString)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (this.t.getCurrentAccountUin() == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = s;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getWpaMsgKey uin:null peerUin:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" key:null");
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      return null;
    }
    if (!this.O.containsKey(paramString))
    {
      localObject = this.aA.getString(paramString, null);
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = s;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getWpaMsgKey uin:");
          localStringBuilder.append(this.t.getCurrentAccountUin());
          localStringBuilder.append("peerUin:");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" key:null");
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        return null;
      }
      localObject = Y((String)localObject);
      this.O.put(paramString, localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = s;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getWpaMsgKey uin:");
      localStringBuilder.append(this.t.getCurrentAccountUin());
      localStringBuilder.append("peerUin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" key:");
      localStringBuilder.append(c((byte[])this.O.get(paramString)));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return (byte[])this.O.get(paramString);
  }
  
  public ConcurrentHashMap<String, ArrayList<Object[]>> h()
  {
    return this.aF;
  }
  
  public void h(String paramString, long paramLong)
  {
    paramLong = Math.max(paramLong, J(paramString));
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = s;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("addDiscussionMsgLastSeq ");
      localStringBuilder.append(paramLong);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.E.put(paramString, Long.valueOf(paramLong));
    if (this.t.getCurrentAccountUin() != null)
    {
      localObject = this.aB;
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
      Object localObject = (byte[])this.Y.get(paramString);
      if (((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte))) && (this.t.getCurrentAccountUin() != null))
      {
        localObject = this.t.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.t.getCurrentAccountUin());
        localStringBuilder.append("tribe_bytes_chat_sig");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
        {
          this.Y.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, d(paramArrayOfByte));
        }
        else
        {
          this.Y.remove(paramString);
          ((SharedPreferences.Editor)localObject).remove(paramString);
        }
        ((SharedPreferences.Editor)localObject).commit();
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public boolean h(MessageRecord paramMessageRecord)
  {
    if (this.M.isEmpty()) {
      return false;
    }
    Object localObject;
    if (paramMessageRecord.isLongMsg()) {
      localObject = String.format("%s&%d&%d&%d", new Object[] { paramMessageRecord.frienduin, Integer.valueOf(paramMessageRecord.istroop), Integer.valueOf(paramMessageRecord.longMsgId), Integer.valueOf(paramMessageRecord.longMsgCount) });
    } else {
      localObject = String.format("%s&%d&%d", new Object[] { paramMessageRecord.frienduin, Integer.valueOf(paramMessageRecord.istroop), Long.valueOf(paramMessageRecord.shmsgseq) });
    }
    if (this.M.containsKey(localObject))
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
  
  public byte[] h(String paramString)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (this.t.getCurrentAccountUin() == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = s;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("pcQQSearchKey uin:null peerUin:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" key:null");
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      return null;
    }
    if (!this.P.containsKey(paramString))
    {
      localObject = this.aA.getString(paramString, null);
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = s;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("pcQQSearchKey uin:");
          localStringBuilder.append(this.t.getCurrentAccountUin());
          localStringBuilder.append("peerUin:");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" key:null");
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        return null;
      }
      localObject = Y((String)localObject);
      this.P.put(paramString, localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = s;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pcQQSearchKey uin:");
      localStringBuilder.append(this.t.getCurrentAccountUin());
      localStringBuilder.append("peerUin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" key:");
      localStringBuilder.append(c((byte[])this.P.get(paramString)));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return (byte[])this.P.get(paramString);
  }
  
  public Set<String> i()
  {
    String str = this.t.getCurrentAccountUin();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    if (!this.j.containsKey(str))
    {
      Object localObject = this.t.getApp();
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
      this.j.put(str, localObject);
    }
    return (Set)this.j.get(str);
  }
  
  public void i(MessageRecord paramMessageRecord)
  {
    this.L = paramMessageRecord;
  }
  
  public void i(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      Object localObject = (byte[])this.aa.get(paramString);
      if (((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte))) && (this.t.getCurrentAccountUin() != null))
      {
        localObject = this.t.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.t.getCurrentAccountUin());
        localStringBuilder.append("movie_ticket_bytes_chat_sig");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
        {
          this.aa.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, d(paramArrayOfByte));
        }
        else
        {
          this.aa.remove(paramString);
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
    Object localObject;
    StringBuilder localStringBuilder;
    if (this.t.getCurrentAccountUin() == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = s;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getBusinessCrmKey uin:null peerUin:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" key:null");
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      return null;
    }
    if (!this.Q.containsKey(paramString))
    {
      localObject = this.t.getApp();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.t.getCurrentAccountUin());
      localStringBuilder.append("crm");
      localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = s;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("businessCrmKey uin:");
          localStringBuilder.append(this.t.getCurrentAccountUin());
          localStringBuilder.append("peerUin:");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" key:null");
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        return null;
      }
      localObject = Z((String)localObject);
      this.Q.put(paramString, localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = s;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("businessCrmKey uin:");
      localStringBuilder.append(this.t.getCurrentAccountUin());
      localStringBuilder.append("peerUin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" key:");
      localStringBuilder.append(c((byte[])this.Q.get(paramString)));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return (byte[])this.Q.get(paramString);
  }
  
  public long j()
  {
    String str = this.t.getCurrentAccountUin();
    if (TextUtils.isEmpty(str)) {
      return -1L;
    }
    if (!this.i.containsKey(str))
    {
      Object localObject = this.t.getApp();
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
      this.i.put(str, Long.valueOf(l1));
    }
    return ((Long)this.i.get(str)).longValue();
  }
  
  public void j(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      Object localObject = (byte[])this.ao.get(paramString);
      if (((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte))) && (this.t.getCurrentAccountUin() != null))
      {
        localObject = this.t.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.t.getCurrentAccountUin());
        localStringBuilder.append("approval_assistant");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
        {
          this.ao.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, d(paramArrayOfByte));
        }
        else
        {
          this.ao.remove(paramString);
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
    String str;
    StringBuilder localStringBuilder;
    if (this.t.getCurrentAccountUin() == null)
    {
      if (QLog.isColorLevel())
      {
        str = s;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("businessCrmSigt uin:null peerUin:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" key:null");
        QLog.d(str, 2, localStringBuilder.toString());
      }
      return null;
    }
    if (!this.R.containsKey(paramString)) {
      return null;
    }
    if (QLog.isColorLevel())
    {
      str = s;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("businessCrmSigt uin:");
      localStringBuilder.append(this.t.getCurrentAccountUin());
      localStringBuilder.append("peerUin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" key:");
      localStringBuilder.append(c((byte[])this.R.get(paramString)));
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return (byte[])this.R.get(paramString);
  }
  
  public ArrayList<stConfNumInfo> k()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = s;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cloneDiscNumInfoCache size = ");
        localStringBuilder.append(this.D.size());
        QLog.d((String)localObject1, 2, localStringBuilder.toString());
      }
      Object localObject1 = (ArrayList)this.D.clone();
      return localObject1;
    }
    finally {}
  }
  
  public void k(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      Object localObject = (byte[])this.X.get(paramString);
      if (((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte))) && (this.t.getCurrentAccountUin() != null))
      {
        localObject = this.t.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.t.getCurrentAccountUin());
        localStringBuilder.append("dating");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
        {
          this.X.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, d(paramArrayOfByte));
        }
        else
        {
          this.X.remove(paramString);
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
    if (this.t.getCurrentAccountUin() == null) {
      return null;
    }
    if (!this.ab.containsKey(paramString))
    {
      Object localObject = this.t.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.t.getCurrentAccountUin());
      localStringBuilder.append("circle_group");
      localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
      if (localObject == null) {
        return null;
      }
      localObject = Z((String)localObject);
      this.ab.put(paramString, localObject);
    }
    return (byte[])this.ab.get(paramString);
  }
  
  public void l()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(s, 2, "clearDiscNumInfoCache");
      }
      this.D.clear();
      return;
    }
    finally {}
  }
  
  public void l(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])this.ab.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.ab.put(paramString, paramArrayOfByte);
      if (this.t.getCurrentAccountUin() != null)
      {
        localObject = this.t.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.t.getCurrentAccountUin());
        localStringBuilder.append("circle_group");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
        paramArrayOfByte = d(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public byte[] l(String paramString)
  {
    if (this.t.getCurrentAccountUin() == null) {
      return null;
    }
    if (!this.ac.containsKey(paramString))
    {
      Object localObject = this.t.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.t.getCurrentAccountUin());
      localStringBuilder.append("circle_group_av");
      localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
      if (localObject == null) {
        return null;
      }
      localObject = Z((String)localObject);
      this.ac.put(paramString, localObject);
    }
    return (byte[])this.ac.get(paramString);
  }
  
  public void m(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])this.ac.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.ac.put(paramString, paramArrayOfByte);
      if (this.t.getCurrentAccountUin() != null)
      {
        localObject = this.t.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.t.getCurrentAccountUin());
        localStringBuilder.append("circle_group_av");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
        paramArrayOfByte = d(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public boolean m()
  {
    if (QLog.isColorLevel())
    {
      String str = s;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isDiscPullSeqFinish size = ");
      localStringBuilder.append(this.C.size());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return this.C.isEmpty();
  }
  
  public byte[] m(String paramString)
  {
    if (this.t.getCurrentAccountUin() == null) {
      return null;
    }
    if (!this.ad.containsKey(paramString))
    {
      Object localObject = this.t.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.t.getCurrentAccountUin());
      localStringBuilder.append("friend_validation");
      localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
      if (localObject == null) {
        return null;
      }
      localObject = Z((String)localObject);
      this.ad.put(paramString, localObject);
    }
    return (byte[])this.ad.get(paramString);
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d(s, 2, "clearDiscPullSeqCache");
    }
    this.C.clear();
  }
  
  public void n(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])this.ad.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.ad.put(paramString, paramArrayOfByte);
      if (this.t.getCurrentAccountUin() != null)
      {
        localObject = this.t.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.t.getCurrentAccountUin());
        localStringBuilder.append("friend_validation");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
        paramArrayOfByte = d(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public byte[] n(String paramString)
  {
    if (this.t.getCurrentAccountUin() == null) {
      return null;
    }
    if (!this.U.containsKey(paramString))
    {
      Object localObject = this.t.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.t.getCurrentAccountUin());
      localStringBuilder.append("same_state");
      localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
      if (localObject == null) {
        return null;
      }
      localObject = Z((String)localObject);
      this.U.put(paramString, localObject);
    }
    return (byte[])this.U.get(paramString);
  }
  
  public ConcurrentHashMap<String, Integer> o()
  {
    return this.aI;
  }
  
  public void o(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      Object localObject = (byte[])this.Z.get(paramString);
      if (((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte))) && (this.t.getCurrentAccountUin() != null))
      {
        localObject = this.t.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.t.getCurrentAccountUin());
        localStringBuilder.append("audioroom_bytes_chat_sig");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
        {
          this.Z.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, d(paramArrayOfByte));
        }
        else
        {
          this.Z.remove(paramString);
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
      if (this.t.getCurrentAccountUin() == null) {
        return null;
      }
      if (!this.Y.containsKey(paramString))
      {
        Object localObject = this.t.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.t.getCurrentAccountUin());
        localStringBuilder.append("tribe_bytes_chat_sig");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = Z((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            this.Y.put(paramString, localObject);
            return localObject;
          }
        }
        return null;
      }
      return (byte[])this.Y.get(paramString);
    }
    return null;
  }
  
  public void p()
  {
    this.an.clear();
  }
  
  public byte[] p(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.t.getCurrentAccountUin() == null) {
        return null;
      }
      if (!this.Z.containsKey(paramString))
      {
        Object localObject = this.t.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.t.getCurrentAccountUin());
        localStringBuilder.append("audioroom_bytes_chat_sig");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = Z((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            this.Z.put(paramString, localObject);
            return localObject;
          }
        }
        return null;
      }
      return (byte[])this.Z.get(paramString);
    }
    return null;
  }
  
  public ConcurrentHashMap<String, ArrayList<Object[]>> q()
  {
    return this.aJ;
  }
  
  public byte[] q(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.t.getCurrentAccountUin() == null) {
        return null;
      }
      if (!this.aa.containsKey(paramString))
      {
        Object localObject = this.t.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.t.getCurrentAccountUin());
        localStringBuilder.append("movie_ticket_bytes_chat_sig");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = Z((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            this.aa.put(paramString, localObject);
            return localObject;
          }
        }
        return null;
      }
      return (byte[])this.aa.get(paramString);
    }
    return null;
  }
  
  public long r()
  {
    if ((this.ay == -1L) && (this.t.getCurrentAccountUin() != null)) {
      this.ay = this.aA.getLong("getTroopDiscMsgLastTime", 0L);
    }
    if (QLog.isColorLevel())
    {
      String str = s;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--->>getTroopAndDiscMsgLastTime lastTime: ");
      localStringBuilder.append(this.ay);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return this.ay;
  }
  
  public byte[] r(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.t.getCurrentAccountUin() == null) {
        return null;
      }
      if (!this.V.containsKey(paramString))
      {
        Object localObject = this.t.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.t.getCurrentAccountUin());
        localStringBuilder.append("accost");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = Z((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            this.V.put(paramString, localObject);
            return localObject;
          }
        }
        return null;
      }
      return (byte[])this.V.get(paramString);
    }
    return null;
  }
  
  public void s()
  {
    if (!this.I.isEmpty())
    {
      localObject1 = new JSONArray();
      Object localObject2 = this.I.entrySet().iterator();
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
              localJSONObject.put("uin", ((MessageCache.MsgSendingInfo)localEntry.getValue()).a);
              localJSONObject.put("type", ((MessageCache.MsgSendingInfo)localEntry.getValue()).b);
              localJSONObject.put("uniseq", ((MessageCache.MsgSendingInfo)localEntry.getValue()).c);
              ((JSONArray)localObject1).put(localJSONObject);
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
      if (this.t.getCurrentAccountUin() != null)
      {
        this.aB.putString("msgSending", ((JSONArray)localObject1).toString());
        if (QLog.isColorLevel())
        {
          localObject2 = s;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("msgSending:write msgSending file before exit,");
          ((StringBuilder)localObject3).append(((JSONArray)localObject1).toString());
          QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
        }
      }
    }
    t();
    this.u = -1;
    this.v.clear();
    this.aF.clear();
    this.E.clear();
    this.aJ.clear();
    this.aK.clear();
    this.aL.clear();
    this.G.clear();
    this.aM = 0L;
    this.aO.clear();
    this.aN.clear();
    this.aP.clear();
    this.H.clear();
    this.I.clear();
    this.J.clear();
    this.w.clear();
    this.x.clear();
    this.z.clear();
    this.y.clear();
    this.af.clear();
    Object localObject1 = this.l;
    if (localObject1 != null) {
      ((MessageCacheItem)localObject1).a();
    }
  }
  
  public byte[] s(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.t.getCurrentAccountUin() == null) {
        return null;
      }
      if (!this.ao.containsKey(paramString))
      {
        Object localObject = this.t.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.t.getCurrentAccountUin());
        localStringBuilder.append("approval_assistant");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = Z((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            this.ao.put(paramString, localObject);
            return localObject;
          }
        }
        return null;
      }
      return (byte[])this.ao.get(paramString);
    }
    return null;
  }
  
  public void t()
  {
    if (this.aB != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(s, 2, "msgCache commit.");
      }
      this.aB.commit();
    }
  }
  
  public byte[] t(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.t.getCurrentAccountUin() == null) {
        return null;
      }
      if (!this.W.containsKey(paramString))
      {
        Object localObject = this.t.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.t.getCurrentAccountUin());
        localStringBuilder.append("nearby_assistant");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = Z((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            this.W.put(paramString, localObject);
            return localObject;
          }
        }
        return null;
      }
      return (byte[])this.W.get(paramString);
    }
    return null;
  }
  
  public HashSet<String> u()
  {
    return this.aO;
  }
  
  public byte[] u(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.t.getCurrentAccountUin() == null) {
        return null;
      }
      if (!this.X.containsKey(paramString))
      {
        Object localObject = this.t.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.t.getCurrentAccountUin());
        localStringBuilder.append("dating");
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString(paramString, null);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = Z((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            this.X.put(paramString, localObject);
            return localObject;
          }
        }
        return null;
      }
      return (byte[])this.X.get(paramString);
    }
    return null;
  }
  
  public long v(String paramString)
  {
    if (this.t.getCurrentAccountUin() == null) {
      return 0L;
    }
    if (!this.v.containsKey(paramString))
    {
      SharedPreferences localSharedPreferences = this.aA;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroopLastMessageTime");
      localStringBuilder.append(paramString);
      long l1 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
      this.v.put(paramString, Long.valueOf(l1));
    }
    paramString = (Long)this.v.get(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.longValue();
  }
  
  public void v()
  {
    synchronized (this.aj)
    {
      this.aj.clear();
      return;
    }
  }
  
  public long w(String paramString)
  {
    if (this.t.getCurrentAccountUin() == null) {
      return 0L;
    }
    if (!this.A.containsKey(paramString))
    {
      SharedPreferences localSharedPreferences = this.aA;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroopExpiredSeq");
      localStringBuilder.append(paramString);
      long l1 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
      this.A.put(paramString, Long.valueOf(l1));
    }
    return ((Long)this.A.get(paramString)).longValue();
  }
  
  public boolean w()
  {
    return this.y.isEmpty();
  }
  
  public long x(String paramString)
  {
    if (this.t.getCurrentAccountUin() == null) {
      return 0L;
    }
    if (!this.B.containsKey(paramString))
    {
      SharedPreferences localSharedPreferences = this.aA;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDiscussionExpiredSeq");
      localStringBuilder.append(paramString);
      long l1 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
      this.B.put(paramString, Long.valueOf(l1));
    }
    return ((Long)this.B.get(paramString)).longValue();
  }
  
  public void x()
  {
    if (QLog.isColorLevel())
    {
      String str = s;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dumpGroupMsgJob size = ");
      localStringBuilder.append(this.y.size());
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public long y(String paramString)
  {
    String str = this.t.getCurrentAccountUin();
    if (str == null) {
      return 0L;
    }
    if (!this.ag.containsKey(paramString))
    {
      SharedPreferences localSharedPreferences = this.aA;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(str);
      long l1 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
      this.ag.put(paramString, Long.valueOf(l1));
    }
    return ((Long)this.ag.get(paramString)).longValue();
  }
  
  public boolean y()
  {
    return this.z.isEmpty();
  }
  
  public long z(String paramString)
  {
    if (this.t.getCurrentAccountUin() == null) {
      return 0L;
    }
    Object localObject2 = (Long)this.af.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.aA;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getFriendFeedLastTime");
      ((StringBuilder)localObject2).append(paramString);
      long l1 = ((SharedPreferences)localObject1).getLong(((StringBuilder)localObject2).toString(), -1L);
      this.af.put(paramString, Long.valueOf(l1));
      localObject1 = Long.valueOf(l1);
    }
    return ((Long)localObject1).longValue();
  }
  
  public void z()
  {
    if (QLog.isColorLevel())
    {
      String str = s;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dumpDiscMsgJob size = ");
      localStringBuilder.append(this.z.size());
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageCache
 * JD-Core Version:    0.7.0.1
 */