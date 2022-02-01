package com.tencent.mobileqq.relationx.icebreaking;

import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecApi;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecData;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.CfgProcess;
import com.tencent.mobileqq.config.CfgProcess.CfgParseResult;
import com.tencent.mobileqq.config.CfgProcess.OnGetConfigListener;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberCardHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.api.observer.TroopPushObserver;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pb.icebreakhotpic.IcebreakHotPic.ImgInfo;
import com.tencent.pb.icebreakhotpic.IcebreakHotPic.ReqBody;
import com.tencent.pb.icebreakhotpic.IcebreakHotPic.RspBody;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.ThrowablesUtils;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class IceBreakingMng
  implements Handler.Callback, CfgProcess.OnGetConfigListener, Manager
{
  public static final String a = HardCodeUtil.a(2131903662);
  public static boolean b = false;
  private final Object A;
  private WeakReference<OnIceBreakChangeListener> B;
  private WeakReference<IIceBreakHotPicCallback> C;
  private volatile String D;
  private TroopObserver E;
  private TroopMngObserver F;
  private TroopPushObserver G;
  public boolean c = false;
  QQAppInterface d;
  public int e;
  FriendListObserver f;
  private final ConcurrentHashMap<String, Integer> g = new ConcurrentHashMap();
  private final ConcurrentHashMap<String, Integer> h = new ConcurrentHashMap();
  private final ConcurrentHashMap<String, Integer> i = new ConcurrentHashMap();
  private final ConcurrentHashMap<String, Integer> j = new ConcurrentHashMap();
  private final ConcurrentHashMap<String, Integer> k = new ConcurrentHashMap();
  private MqqWeakReferenceHandler l = new MqqWeakReferenceHandler(ThreadManager.getFileThreadLooper(), this);
  private Set<String> m = new HashSet();
  private Set<String> n = new HashSet();
  private Set<String> o = new HashSet();
  private Set<String> p = new HashSet();
  private volatile boolean q = false;
  private boolean r = false;
  private boolean s = false;
  private String t;
  private String u;
  private float v;
  private boolean w;
  private int x;
  private int y;
  private boolean z;
  
  public IceBreakingMng(QQAppInterface paramQQAppInterface)
  {
    String str = a;
    this.t = str;
    this.u = str;
    this.v = 7.0F;
    this.w = false;
    this.x = 100;
    this.y = 50;
    this.e = 60;
    this.z = false;
    this.A = new Object();
    this.f = new IceBreakingMng.1(this);
    this.E = new IceBreakingMng.4(this);
    this.F = new IceBreakingMng.5(this);
    this.G = new IceBreakingMng.6(this);
    this.d = paramQQAppInterface;
    this.d.getConfigProcess().a("breaking_ice_config", this);
    this.l.sendEmptyMessage(0);
    paramQQAppInterface.addObserver(this.f, true);
    paramQQAppInterface.addObserver(this.E, true);
    paramQQAppInterface.addObserver(this.G, true);
    paramQQAppInterface.addObserver(this.F, true);
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, ConcurrentHashMap<String, Integer> paramConcurrentHashMap)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!paramBoolean1)
    {
      bool1 = bool2;
      if (paramConcurrentHashMap.containsValue(Integer.valueOf(0)))
      {
        Iterator localIterator = paramConcurrentHashMap.entrySet().iterator();
        while (localIterator.hasNext()) {
          if (((Integer)((Map.Entry)localIterator.next()).getValue()).intValue() == 0) {
            localIterator.remove();
          }
        }
        bool1 = true;
      }
    }
    paramBoolean1 = bool1;
    if (!paramBoolean2)
    {
      paramBoolean1 = bool1;
      if (paramConcurrentHashMap.containsValue(Integer.valueOf(1)))
      {
        paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
        while (paramConcurrentHashMap.hasNext()) {
          if (((Integer)((Map.Entry)paramConcurrentHashMap.next()).getValue()).intValue() == 0) {
            paramConcurrentHashMap.remove();
          }
        }
        paramBoolean1 = true;
      }
    }
    return paramBoolean1;
  }
  
  /* Error */
  private Object[] a(boolean paramBoolean, String paramString)
  {
    // Byte code:
    //   0: getstatic 70	com/tencent/mobileqq/relationx/icebreaking/IceBreakingMng:a	Ljava/lang/String;
    //   3: astore 13
    //   5: iload_1
    //   6: ifne +23 -> 29
    //   9: aload_0
    //   10: getfield 165	com/tencent/mobileqq/relationx/icebreaking/IceBreakingMng:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: invokevirtual 245	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   16: aload_0
    //   17: getfield 165	com/tencent/mobileqq/relationx/icebreaking/IceBreakingMng:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokevirtual 249	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   23: ldc 173
    //   25: invokestatic 254	com/tencent/mobileqq/utils/SharedPreUtils:s	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   28: astore_2
    //   29: bipush 50
    //   31: istore 5
    //   33: bipush 100
    //   35: istore 6
    //   37: ldc 127
    //   39: fstore 4
    //   41: aload_2
    //   42: invokestatic 260	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   45: ifne +260 -> 305
    //   48: new 262	org/json/JSONObject
    //   51: dup
    //   52: aload_2
    //   53: invokespecial 264	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   56: astore 15
    //   58: aload 15
    //   60: ldc_w 266
    //   63: iconst_0
    //   64: invokevirtual 270	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   67: istore_1
    //   68: aload 15
    //   70: ldc_w 272
    //   73: iconst_0
    //   74: invokevirtual 270	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   77: istore 10
    //   79: aload 15
    //   81: ldc_w 274
    //   84: getstatic 70	com/tencent/mobileqq/relationx/icebreaking/IceBreakingMng:a	Ljava/lang/String;
    //   87: invokevirtual 278	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   90: astore_2
    //   91: aload 13
    //   93: astore 14
    //   95: fload 4
    //   97: fstore_3
    //   98: aload 15
    //   100: ldc_w 280
    //   103: getstatic 70	com/tencent/mobileqq/relationx/icebreaking/IceBreakingMng:a	Ljava/lang/String;
    //   106: invokevirtual 278	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   109: astore 13
    //   111: aload 13
    //   113: astore 14
    //   115: fload 4
    //   117: fstore_3
    //   118: aload 15
    //   120: ldc_w 282
    //   123: ldc2_w 283
    //   126: invokevirtual 288	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   129: d2f
    //   130: fstore 4
    //   132: aload 13
    //   134: astore 14
    //   136: fload 4
    //   138: fstore_3
    //   139: aload 15
    //   141: ldc_w 290
    //   144: iconst_0
    //   145: invokevirtual 270	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   148: istore 12
    //   150: iload 5
    //   152: istore 7
    //   154: iload 6
    //   156: istore 8
    //   158: aload 15
    //   160: ldc_w 292
    //   163: bipush 100
    //   165: invokevirtual 296	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   168: istore 6
    //   170: iload 5
    //   172: istore 7
    //   174: iload 6
    //   176: istore 8
    //   178: aload 15
    //   180: ldc_w 298
    //   183: bipush 50
    //   185: invokevirtual 296	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   188: istore 5
    //   190: iload 5
    //   192: istore 7
    //   194: iload 6
    //   196: istore 8
    //   198: aload 15
    //   200: ldc_w 300
    //   203: bipush 60
    //   205: invokevirtual 296	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   208: istore 9
    //   210: aload 15
    //   212: ldc_w 302
    //   215: iconst_0
    //   216: invokevirtual 270	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   219: istore 11
    //   221: iload 9
    //   223: istore 7
    //   225: fload 4
    //   227: fstore_3
    //   228: aload 13
    //   230: astore 14
    //   232: goto +135 -> 367
    //   235: astore 15
    //   237: iload 9
    //   239: istore 7
    //   241: fload 4
    //   243: fstore_3
    //   244: aload 13
    //   246: astore 14
    //   248: goto +111 -> 359
    //   251: astore 15
    //   253: bipush 60
    //   255: istore 9
    //   257: iload 7
    //   259: istore 5
    //   261: iload 8
    //   263: istore 6
    //   265: fload 4
    //   267: fstore_3
    //   268: iload 9
    //   270: istore 7
    //   272: aload 13
    //   274: astore 14
    //   276: goto +83 -> 359
    //   279: astore 15
    //   281: aload_2
    //   282: astore 13
    //   284: aload 15
    //   286: astore_2
    //   287: goto +59 -> 346
    //   290: astore_2
    //   291: aload 13
    //   293: astore 14
    //   295: fload 4
    //   297: fstore_3
    //   298: goto +48 -> 346
    //   301: astore_2
    //   302: goto +34 -> 336
    //   305: aload 13
    //   307: astore 14
    //   309: iconst_0
    //   310: istore_1
    //   311: bipush 60
    //   313: istore 7
    //   315: iconst_0
    //   316: istore 10
    //   318: iconst_0
    //   319: istore 11
    //   321: iconst_0
    //   322: istore 12
    //   324: aload 13
    //   326: astore_2
    //   327: fload 4
    //   329: fstore_3
    //   330: goto +37 -> 367
    //   333: astore_2
    //   334: iconst_0
    //   335: istore_1
    //   336: aload 13
    //   338: astore 14
    //   340: iconst_0
    //   341: istore 10
    //   343: fload 4
    //   345: fstore_3
    //   346: bipush 60
    //   348: istore 7
    //   350: iconst_0
    //   351: istore 12
    //   353: aload_2
    //   354: astore 15
    //   356: aload 13
    //   358: astore_2
    //   359: aload 15
    //   361: invokevirtual 305	java/lang/Exception:printStackTrace	()V
    //   364: iconst_0
    //   365: istore 11
    //   367: bipush 10
    //   369: anewarray 4	java/lang/Object
    //   372: dup
    //   373: iconst_0
    //   374: iload_1
    //   375: invokestatic 310	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   378: aastore
    //   379: dup
    //   380: iconst_1
    //   381: iload 10
    //   383: invokestatic 310	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   386: aastore
    //   387: dup
    //   388: iconst_2
    //   389: aload_2
    //   390: aastore
    //   391: dup
    //   392: iconst_3
    //   393: aload 14
    //   395: aastore
    //   396: dup
    //   397: iconst_4
    //   398: fload_3
    //   399: invokestatic 315	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   402: aastore
    //   403: dup
    //   404: iconst_5
    //   405: iload 12
    //   407: invokestatic 310	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   410: aastore
    //   411: dup
    //   412: bipush 6
    //   414: iload 6
    //   416: invokestatic 200	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   419: aastore
    //   420: dup
    //   421: bipush 7
    //   423: iload 5
    //   425: invokestatic 200	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   428: aastore
    //   429: dup
    //   430: bipush 8
    //   432: iload 7
    //   434: invokestatic 200	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   437: aastore
    //   438: dup
    //   439: bipush 9
    //   441: iload 11
    //   443: invokestatic 310	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   446: aastore
    //   447: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	448	0	this	IceBreakingMng
    //   0	448	1	paramBoolean	boolean
    //   0	448	2	paramString	String
    //   97	302	3	f1	float
    //   39	305	4	f2	float
    //   31	393	5	i1	int
    //   35	380	6	i2	int
    //   152	281	7	i3	int
    //   156	106	8	i4	int
    //   208	61	9	i5	int
    //   77	305	10	bool1	boolean
    //   219	223	11	bool2	boolean
    //   148	258	12	bool3	boolean
    //   3	354	13	str1	String
    //   93	301	14	str2	String
    //   56	155	15	localJSONObject	org.json.JSONObject
    //   235	1	15	localException1	Exception
    //   251	1	15	localException2	Exception
    //   279	6	15	localException3	Exception
    //   354	6	15	str3	String
    // Exception table:
    //   from	to	target	type
    //   210	221	235	java/lang/Exception
    //   158	170	251	java/lang/Exception
    //   178	190	251	java/lang/Exception
    //   198	210	251	java/lang/Exception
    //   98	111	279	java/lang/Exception
    //   118	132	279	java/lang/Exception
    //   139	150	279	java/lang/Exception
    //   79	91	290	java/lang/Exception
    //   68	79	301	java/lang/Exception
    //   41	68	333	java/lang/Exception
  }
  
  private void i()
  {
    Object localObject2 = null;
    Object[] arrayOfObject = a(false, null);
    Object localObject11 = FileUtils.readObject(String.format("%s_%s", new Object[] { "break_ice_map", this.d.getCurrentAccountUin() }));
    Object localObject10 = FileUtils.readObject(String.format("%s_%s", new Object[] { "entered_c2c", this.d.getCurrentAccountUin() }));
    Object localObject9 = FileUtils.readObject(String.format("%s_%s", new Object[] { "entered_troop", this.d.getCurrentAccountUin() }));
    Object localObject8 = FileUtils.readObject(String.format("%s_%s", new Object[] { "entered_match_chat", this.d.getCurrentAccountUin() }));
    Object localObject7 = FileUtils.readObject(String.format("%s_%s", new Object[] { "entered_qcircle_chat", this.d.getCurrentAccountUin() }));
    if (this.q) {
      return;
    }
    ??? = localObject2;
    if (localObject11 != null)
    {
      ??? = localObject2;
      if ((localObject11 instanceof ConcurrentHashMap)) {
        ??? = (ConcurrentHashMap)localObject11;
      }
    }
    localObject2 = ???;
    if (??? == null) {
      localObject2 = new ConcurrentHashMap();
    }
    if (localObject10 != null) {
      synchronized (this.m)
      {
        this.m.addAll((Set)localObject10);
      }
    }
    if (localObject9 != null) {
      synchronized (this.n)
      {
        this.n.addAll((Set)localObject9);
      }
    }
    if (localObject8 != null) {
      synchronized (this.o)
      {
        this.o.addAll((Set)localObject8);
      }
    }
    if (localObject7 != null) {
      synchronized (this.p)
      {
        this.p.addAll((Set)localObject7);
      }
    }
    a(((Boolean)arrayOfObject[0]).booleanValue(), ((Boolean)arrayOfObject[1]).booleanValue(), localConcurrentHashMap);
    synchronized (this.A)
    {
      if (!this.q)
      {
        if (localConcurrentHashMap != null) {
          this.g.putAll(localConcurrentHashMap);
        }
        this.r = ((Boolean)arrayOfObject[0]).booleanValue();
        this.s = ((Boolean)arrayOfObject[1]).booleanValue();
        this.t = ((String)arrayOfObject[2]);
        this.u = ((String)arrayOfObject[3]);
        this.v = ((Float)arrayOfObject[4]).floatValue();
        this.w = ((Boolean)arrayOfObject[5]).booleanValue();
        this.x = ((Integer)arrayOfObject[6]).intValue();
        this.y = ((Integer)arrayOfObject[7]).intValue();
        this.e = ((Integer)arrayOfObject[8]).intValue();
        this.z = ((Boolean)arrayOfObject[9]).booleanValue();
        this.q = true;
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("init IceBreak Config: mSwitchNewFrd: ");
        ((StringBuilder)???).append(this.r);
        ((StringBuilder)???).append(",mSwitchOldFrd: ");
        ((StringBuilder)???).append(this.s);
        ((StringBuilder)???).append(",mTipNewFrd: ");
        ((StringBuilder)???).append(this.t);
        ((StringBuilder)???).append(",mTipOldFrd: ");
        ((StringBuilder)???).append(this.u);
        ((StringBuilder)???).append(",mDaysOldFrd: ");
        ((StringBuilder)???).append(this.v);
        ((StringBuilder)???).append(",switchTroop: ");
        ((StringBuilder)???).append(this.w);
        ((StringBuilder)???).append(",troopMemberMinCount: ");
        ((StringBuilder)???).append(this.x);
        ((StringBuilder)???).append(",troopMemberNotFriendRate: ");
        ((StringBuilder)???).append(this.y);
        ((StringBuilder)???).append(",showDuration: ");
        ((StringBuilder)???).append(this.e);
        ((StringBuilder)???).append(",mSwitchNewFrdMiniCard: ");
        ((StringBuilder)???).append(this.z);
        QLog.d("IceBreak.Mng", 2, ((StringBuilder)???).toString());
      }
      return;
    }
  }
  
  private void j()
  {
    if (!this.q) {
      i();
    }
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    localConcurrentHashMap.putAll(this.g);
    FileUtils.writeObject(String.format("%s_%s", new Object[] { "break_ice_map", this.d.getCurrentAccountUin() }), localConcurrentHashMap);
  }
  
  private void v(String paramString)
  {
    Object localObject2 = (TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject1 = ((TroopManager)localObject2).g(paramString);
    if (localObject1 == null)
    {
      QLog.i("IceBreak.HotPic", 1, "troop info is null.");
      return;
    }
    if (((TroopInfo)localObject1).wMemberNum < this.x)
    {
      Object localObject3 = ((TroopManager)localObject2).w(paramString);
      int i2 = 0;
      int i1 = 0;
      if ((localObject3 != null) && (((List)localObject3).size() > 1))
      {
        i2 = ((List)localObject3).size();
        localObject2 = (FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER);
        String str1 = this.d.getCurrentAccountUin();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          String str2 = ((TroopMemberInfo)((Iterator)localObject3).next()).memberuin;
          if ((!TextUtils.isEmpty(str2)) && (!str2.equals(str1)) && (!((FriendsManager)localObject2).n(str2))) {
            i1 += 1;
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("noFriendCount: ");
        ((StringBuilder)localObject2).append(i1);
        ((StringBuilder)localObject2).append(" total count: ");
        ((StringBuilder)localObject2).append(((TroopInfo)localObject1).wMemberNum);
        QLog.i("IceBreak.HotPic", 1, ((StringBuilder)localObject2).toString());
        if (i1 * 1.0F / (i2 - 1) > this.y / 100.0F) {
          l(paramString);
        }
      }
      else
      {
        if (localObject3 == null) {
          i1 = i2;
        } else {
          i1 = ((List)localObject3).size();
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("troop member size: ");
        ((StringBuilder)localObject1).append(i1);
        QLog.i("IceBreak.HotPic", 1, ((StringBuilder)localObject1).toString());
        this.D = paramString;
        ((ITroopMemberListHandler)this.d.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER)).a(paramString);
      }
    }
    else
    {
      l(paramString);
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    if (!this.q) {
      i();
    }
    if (paramInt == 1)
    {
      paramString = (Integer)this.h.get(paramString);
      if (paramString == null) {
        return -1;
      }
      return paramString.intValue();
    }
    if (IceBreakingUtil.d(paramInt))
    {
      paramString = (Integer)this.i.get(paramString);
      if (paramString == null) {
        return -1;
      }
      return paramString.intValue();
    }
    if (IceBreakingUtil.e(paramInt))
    {
      paramString = (Integer)this.j.get(paramString);
      if (paramString == null) {
        return -1;
      }
      return paramString.intValue();
    }
    if (paramInt == 10007)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getBreakIceType hasSendIceBreak : ");
        localStringBuilder.append(b);
        localStringBuilder.append(" mBreakingIceGameChatMap.size() : ");
        localStringBuilder.append(this.k.size());
        QLog.d("IceBreak.Mng", 2, localStringBuilder.toString());
      }
      if ((this.k.size() == 0) && (!b)) {
        t(paramString);
      }
      paramString = (Integer)this.k.get(paramString);
      if (paramString == null) {
        return -1;
      }
      return paramString.intValue();
    }
    paramString = (Integer)this.g.get(paramString);
    if (paramString == null) {
      return -1;
    }
    return paramString.intValue();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreak.HotPic", 2, "removeAllEnteredMatchChat ");
    }
    if (!this.q) {
      i();
    }
    if (!this.o.isEmpty()) {
      synchronized (this.o)
      {
        this.o.clear();
        d();
        return;
      }
    }
  }
  
  public void a(IIceBreakHotPicCallback paramIIceBreakHotPicCallback)
  {
    this.C = new WeakReference(paramIIceBreakHotPicCallback);
  }
  
  public void a(OnIceBreakChangeListener paramOnIceBreakChangeListener)
  {
    this.B = new WeakReference(paramOnIceBreakChangeListener);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("removeEnteredMatchChat ");
      ((StringBuilder)???).append(paramString);
      QLog.d("IceBreak.HotPic", 2, ((StringBuilder)???).toString());
    }
    if (!this.q) {
      i();
    }
    if (this.o.contains(paramString)) {
      synchronized (this.o)
      {
        this.o.remove(paramString);
        d();
        return;
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreak.Mng", 2, String.format("request HotPicList fromUin: %s, termType: %s, aioType: %s, toUin: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 }));
    }
    try
    {
      IcebreakHotPic.ReqBody localReqBody = new IcebreakHotPic.ReqBody();
      localReqBody.setHasFlag(true);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(SystemClock.uptimeMillis());
      localObject = ((StringBuilder)localObject).toString();
      localReqBody.bytes_session_id.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localReqBody.uint64_src_uin.set(Long.parseLong(paramString1));
      localReqBody.uint32_src_term.set(paramInt1);
      localReqBody.uint32_aio_type.set(paramInt2);
      localReqBody.uint64_to_uin.set(Long.parseLong(paramString2));
      localReqBody.str_client_ver.set("8.8.17");
      paramString1 = ((FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(this.d.getCurrentAccountUin());
      if (paramString1 != null) {
        localReqBody.uint32_age.set(paramString1.age);
      } else {
        localReqBody.uint32_age.set(0);
      }
      paramString1 = localReqBody.toByteArray();
      paramString2 = ByteBuffer.allocate(paramString1.length + 4);
      paramString2.putInt(paramString1.length + 4).put(paramString1);
      paramString1 = paramString2.array();
      paramString1 = ((IStickerRecApi)QRoute.api(IStickerRecApi.class)).getStickerRecIntent(this.d.getApp(), paramString1, "BreakIceSvr.Pull");
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("request HotPicList, sessionId = ");
        paramString2.append((String)localObject);
        QLog.d("IceBreak.Mng", 2, paramString2.toString());
      }
      this.d.startServlet(paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.d("IceBreak.Mng", 1, "request HotPicList exception", paramString1);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!a(paramBoolean)) {
      return;
    }
    Object localObject = ((FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(paramString);
    boolean bool;
    if ((localObject != null) && (((Friends)localObject).isFriend())) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      this.g.put(paramString, Integer.valueOf(paramBoolean ^ true));
      localObject = this.B;
      if (localObject != null)
      {
        localObject = (OnIceBreakChangeListener)((WeakReference)localObject).get();
        if (localObject != null) {
          ((OnIceBreakChangeListener)localObject).a(paramString, false);
        }
      }
      if (this.l.hasMessages(1)) {
        this.l.removeMessages(1);
      }
      this.l.sendEmptyMessage(1);
    }
    else
    {
      j(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.i("IceBreak.IceBreakingUtil", 2, String.format(Locale.getDefault(), "addToBreakingIceList uin: %s, ret: %s", new Object[] { paramString, Boolean.valueOf(bool) }));
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    try
    {
      Object localObject = new IcebreakHotPic.RspBody();
      ((IcebreakHotPic.RspBody)localObject).mergeFrom(paramArrayOfByte);
      if (((IcebreakHotPic.RspBody)localObject).int32_result.get() != 0)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("handleGetIceBreakHotPicResponse response code error,result:");
        paramArrayOfByte.append(((IcebreakHotPic.RspBody)localObject).int32_result.get());
        paramArrayOfByte.append(" message : ");
        paramArrayOfByte.append(((IcebreakHotPic.RspBody)localObject).bytes_fail_msg.get());
        QLog.d("IceBreak.HotPic", 2, paramArrayOfByte.toString());
        return;
      }
      paramArrayOfByte = ((IcebreakHotPic.RspBody)localObject).rpt_msg_img_info.get();
      if ((paramArrayOfByte != null) && (!paramArrayOfByte.isEmpty()))
      {
        int i2 = ((IcebreakHotPic.RspBody)localObject).int32_img_num.get();
        localObject = new ArrayList();
        int i1 = 0;
        while (i1 < paramArrayOfByte.size())
        {
          IcebreakHotPic.ImgInfo localImgInfo = (IcebreakHotPic.ImgInfo)paramArrayOfByte.get(i1);
          StickerRecData localStickerRecData = new StickerRecData();
          localStickerRecData.f(i1);
          localStickerRecData.c(localImgInfo.uint64_img_size.get());
          localStickerRecData.a(localImgInfo.uint32_img_width.get());
          localStickerRecData.b(localImgInfo.uint32_img_height.get());
          localStickerRecData.e(localImgInfo.bytes_img_md5.get().toStringUtf8());
          localStickerRecData.c(localImgInfo.bytes_img_down_url.get().toStringUtf8());
          localStickerRecData.b(localImgInfo.bytes_img_word.get().toStringUtf8());
          localStickerRecData.d(localImgInfo.uint64_thumb_size.get());
          localStickerRecData.d(localImgInfo.uint32_thumb_img_height.get());
          localStickerRecData.c(localImgInfo.uint32_thumb_img_width.get());
          localStickerRecData.d(localImgInfo.bytes_thumb_down_url.get().toStringUtf8());
          localStickerRecData.f(localImgInfo.bytes_thumb_img_md5.get().toStringUtf8());
          ((List)localObject).add(localStickerRecData);
          i1 += 1;
        }
        ThreadManager.getUIHandler().post(new IceBreakingMng.2(this, (List)localObject, i2));
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("handleGetIceBreakHotPicResponse staticImageNum:");
          paramArrayOfByte.append(i2);
          paramArrayOfByte.append("dateList: ");
          paramArrayOfByte.append(localObject);
          QLog.d("IceBreak.HotPic", 2, paramArrayOfByte.toString());
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("IceBreak.HotPic", 2, "handleGetIceBreakHotPicResponse imgInfos is null or empty");
        }
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IceBreak.HotPic", 2, ThrowablesUtils.a(paramArrayOfByte));
      }
    }
    return;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (!this.q) {
      i();
    }
    if (this.c)
    {
      this.r = true;
      this.s = true;
    }
    if (paramBoolean) {
      return this.r;
    }
    return this.s;
  }
  
  public void b()
  {
    if (!this.q) {
      i();
    }
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.m);
    FileUtils.writeObject(String.format("%s_%s", new Object[] { "entered_c2c", this.d.getCurrentAccountUin() }), localHashSet);
  }
  
  public void b(OnIceBreakChangeListener paramOnIceBreakChangeListener)
  {
    WeakReference localWeakReference = this.B;
    if ((localWeakReference != null) && (localWeakReference.get() == paramOnIceBreakChangeListener)) {
      this.B = null;
    }
  }
  
  public void b(String paramString)
  {
    if (!this.q) {
      i();
    }
    if (!this.o.contains(paramString)) {
      synchronized (this.o)
      {
        this.o.add(paramString);
        return;
      }
    }
  }
  
  public void c()
  {
    if (!this.q) {
      i();
    }
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.n);
    FileUtils.writeObject(String.format("%s_%s", new Object[] { "entered_troop", this.d.getCurrentAccountUin() }), localHashSet);
  }
  
  public void c(String paramString)
  {
    if (!this.q) {
      i();
    }
    if (!this.p.contains(paramString)) {
      synchronized (this.p)
      {
        this.p.add(paramString);
        return;
      }
    }
  }
  
  public void d()
  {
    if (!this.q) {
      i();
    }
    HashSet localHashSet = new HashSet();
    synchronized (this.o)
    {
      localHashSet.addAll(this.o);
      FileUtils.writeObject(String.format("%s_%s", new Object[] { "entered_match_chat", this.d.getCurrentAccountUin() }), localHashSet);
      return;
    }
  }
  
  public void d(String paramString)
  {
    if (!this.q) {
      i();
    }
    if (!this.m.contains(paramString)) {
      synchronized (this.m)
      {
        this.m.add(paramString);
        return;
      }
    }
  }
  
  public void e()
  {
    if (!this.q) {
      i();
    }
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.p);
    FileUtils.writeObject(String.format("%s_%s", new Object[] { "entered_qcircle_chat", this.d.getCurrentAccountUin() }), localHashSet);
  }
  
  public void e(String paramString)
  {
    if (!this.q) {
      i();
    }
    if (!this.n.contains(paramString)) {
      synchronized (this.n)
      {
        this.n.add(paramString);
        return;
      }
    }
  }
  
  public float f()
  {
    if (!this.q) {
      i();
    }
    return this.v;
  }
  
  public boolean f(String paramString)
  {
    if (!this.q) {
      i();
    }
    return this.m.contains(paramString);
  }
  
  public boolean g()
  {
    if (!this.q) {
      i();
    }
    if (this.c) {
      this.z = true;
    }
    return this.z;
  }
  
  public boolean g(String paramString)
  {
    if (!this.q) {
      i();
    }
    return this.n.contains(paramString);
  }
  
  public void h()
  {
    this.C = null;
  }
  
  public boolean h(String paramString)
  {
    if (!this.q) {
      i();
    }
    return this.o.contains(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 0)
    {
      if (i1 == 1) {
        j();
      }
    }
    else {
      i();
    }
    return false;
  }
  
  public boolean i(String paramString)
  {
    if (!this.q) {
      i();
    }
    return this.p.contains(paramString);
  }
  
  public boolean j(String paramString)
  {
    if (!this.q) {
      i();
    }
    Object localObject1 = this.g.remove(paramString);
    boolean bool = false;
    if (localObject1 != null)
    {
      Object localObject2 = this.B;
      if (localObject2 != null)
      {
        localObject2 = (OnIceBreakChangeListener)((WeakReference)localObject2).get();
        if (localObject2 != null) {
          ((OnIceBreakChangeListener)localObject2).b(paramString, false);
        }
      }
      if (this.l.hasMessages(1)) {
        this.l.removeMessages(1);
      }
      this.l.sendEmptyMessage(1);
    }
    if (QLog.isColorLevel()) {
      QLog.i("IceBreak.IceBreakingUtil", 2, String.format(Locale.getDefault(), "removeFromBreakingIceList uin: %s , ret:%s", new Object[] { paramString, localObject1 }));
    }
    if (localObject1 != null) {
      bool = true;
    }
    return bool;
  }
  
  public boolean k(String paramString)
  {
    if (!this.q) {
      i();
    }
    boolean bool2 = this.g.containsKey(paramString);
    boolean bool1 = bool2;
    if (bool2)
    {
      paramString = ((FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(paramString);
      if ((paramString != null) && (paramString.isFriend())) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public void l(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("insertTroopToBreakingIceMap troopUin: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("IceBreak.Mng", 1, ((StringBuilder)localObject).toString());
    this.h.put(paramString, Integer.valueOf(0));
    localObject = this.B;
    if (localObject != null)
    {
      localObject = (OnIceBreakChangeListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((OnIceBreakChangeListener)localObject).a(paramString, true);
      }
    }
  }
  
  public void m(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("removeTroopFromBreakingIceMap troopUin: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("IceBreak.Mng", 1, ((StringBuilder)localObject).toString());
    this.h.remove(paramString);
    localObject = this.B;
    if (localObject != null)
    {
      localObject = (OnIceBreakChangeListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((OnIceBreakChangeListener)localObject).b(paramString, true);
      }
    }
  }
  
  public void n(String paramString)
  {
    this.i.remove(paramString);
    Object localObject = this.B;
    if (localObject != null)
    {
      localObject = (OnIceBreakChangeListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((OnIceBreakChangeListener)localObject).b(paramString, false);
      }
    }
  }
  
  public void o(String paramString)
  {
    this.j.remove(paramString);
    Object localObject = this.B;
    if (localObject != null)
    {
      localObject = (OnIceBreakChangeListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((OnIceBreakChangeListener)localObject).b(paramString, false);
      }
    }
  }
  
  public void onDestroy()
  {
    this.l.removeCallbacksAndMessages(null);
    this.d.getConfigProcess().a(this);
    this.d.removeObserver(this.f);
    this.d.removeObserver(this.E);
    this.d.removeObserver(this.G);
    this.d.removeObserver(this.F);
  }
  
  public void onGetConfig(QQAppInterface paramQQAppInterface, int paramInt, String paramString, CfgProcess.CfgParseResult paramCfgParseResult)
  {
    if ((paramCfgParseResult != null) && ("breaking_ice_config".equals(paramString)))
    {
      if (!this.q) {
        i();
      }
      paramQQAppInterface = a(true, paramCfgParseResult.d);
      boolean bool1 = ((Boolean)paramQQAppInterface[0]).booleanValue();
      boolean bool2 = ((Boolean)paramQQAppInterface[1]).booleanValue();
      this.t = ((String)paramQQAppInterface[2]);
      this.u = ((String)paramQQAppInterface[3]);
      this.v = ((Float)paramQQAppInterface[4]).floatValue();
      this.w = ((Boolean)paramQQAppInterface[5]).booleanValue();
      this.x = ((Integer)paramQQAppInterface[6]).intValue();
      this.y = ((Integer)paramQQAppInterface[7]).intValue();
      this.e = ((Integer)paramQQAppInterface[8]).intValue();
      this.z = ((Boolean)paramQQAppInterface[9]).booleanValue();
      if ((bool1 != this.r) || (bool2 != this.s))
      {
        this.r = ((Boolean)paramQQAppInterface[0]).booleanValue();
        this.s = ((Boolean)paramQQAppInterface[1]).booleanValue();
        paramQQAppInterface = new ConcurrentHashMap(this.g.size());
        paramQQAppInterface.putAll(this.g);
        if (a(this.r, this.s, paramQQAppInterface))
        {
          this.g.clear();
          this.g.putAll(paramQQAppInterface);
          if (this.l.hasMessages(1)) {
            this.l.removeMessages(1);
          }
          this.l.sendEmptyMessage(1);
        }
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("onGetConfig: mSwitchNewFrd: ");
        paramQQAppInterface.append(this.r);
        paramQQAppInterface.append(",mSwitchOldFrd: ");
        paramQQAppInterface.append(this.s);
        paramQQAppInterface.append(",mTipNewFrd: ");
        paramQQAppInterface.append(this.t);
        paramQQAppInterface.append(",mTipOldFrd: ");
        paramQQAppInterface.append(this.u);
        paramQQAppInterface.append(",mDaysOldFrd: ");
        paramQQAppInterface.append(this.v);
        paramQQAppInterface.append(",switchTroop: ");
        paramQQAppInterface.append(this.w);
        paramQQAppInterface.append(",troopMemberMinCount: ");
        paramQQAppInterface.append(this.x);
        paramQQAppInterface.append(",troopMemberNotFriendRate: ");
        paramQQAppInterface.append(this.y);
        paramQQAppInterface.append(",showDuration: ");
        paramQQAppInterface.append(this.e);
        paramQQAppInterface.append(",mSwitchNewFrdMiniCard: ");
        paramQQAppInterface.append(this.z);
        QLog.d("IceBreak.Mng", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public void p(String paramString)
  {
    this.k.remove(paramString);
    Object localObject = this.B;
    if (localObject != null)
    {
      localObject = (OnIceBreakChangeListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((OnIceBreakChangeListener)localObject).b(paramString, false);
      }
    }
  }
  
  public void q(String paramString)
  {
    if (h(paramString))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkNeedShowIceBreakMatchChat enter ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("IceBreak.Mng", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (!((IExpandManager)this.d.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).C())
    {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.Mng", 2, "checkNeedShowIceBreakMatchChat switch is off");
      }
      return;
    }
    this.i.put(paramString, Integer.valueOf(0));
    Object localObject = this.B;
    if (localObject != null)
    {
      localObject = (OnIceBreakChangeListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((OnIceBreakChangeListener)localObject).a(paramString, false);
      }
    }
  }
  
  public void r(String paramString)
  {
    if (i(paramString))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkNeedShowIceBreakMatchChat enter ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("IceBreak.Mng", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    this.j.put(paramString, Integer.valueOf(0));
    Object localObject = this.B;
    if (localObject != null)
    {
      localObject = (OnIceBreakChangeListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((OnIceBreakChangeListener)localObject).a(paramString, false);
      }
    }
  }
  
  public boolean s(String paramString)
  {
    paramString = this.d.getMessageFacade().a(paramString, 10007, null, 60);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" msgList.size() ");
      ((StringBuilder)localObject).append(paramString.size());
      QLog.d("IceBreak.Mng", 2, ((StringBuilder)localObject).toString());
    }
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      localObject = (MessageRecord)paramString.next();
      if (((((MessageRecord)localObject).msgtype == -1000) || (((MessageRecord)localObject).msgtype == -1001) || (((MessageRecord)localObject).msgtype == -2000) || (((MessageRecord)localObject).msgtype == -2001)) && (((MessageRecord)localObject).issend == 1)) {
        return true;
      }
    }
    return false;
  }
  
  public void t(String paramString)
  {
    if (s(paramString))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkNeedShowIceBreakGameChat enter: ");
        ((StringBuilder)localObject).append(MobileQQ.getShortUinStr(paramString));
        QLog.d("IceBreak.Mng", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    this.k.put(paramString, Integer.valueOf(2));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkNeedShowIceBreakGameChat mBreakingIceGameChatMap: ");
      ((StringBuilder)localObject).append(this.k.size());
      QLog.d("IceBreak.Mng", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.B;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      ((OnIceBreakChangeListener)this.B.get()).a(paramString, false);
    }
  }
  
  public void u(String paramString)
  {
    if (!((IStickerRecManager)this.d.getRuntimeService(IStickerRecManager.class)).isEmotionRecSettingOpen())
    {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.HotPic", 2, "checkNeedShowIceBreakForTroop emotionRec switch is off");
      }
      return;
    }
    if (g(paramString))
    {
      QLog.i("IceBreak.HotPic", 1, "entered toop.");
      return;
    }
    if (!this.w)
    {
      QLog.i("IceBreak.HotPic", 1, "troop switch is off.");
      return;
    }
    TroopMemberInfo localTroopMemberInfo = ((TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER)).g(paramString, this.d.getCurrentAccountUin());
    if ((localTroopMemberInfo != null) && (localTroopMemberInfo.last_active_time != localTroopMemberInfo.join_time))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("last_active_time: ");
      localStringBuilder.append(localTroopMemberInfo.last_active_time);
      localStringBuilder.append(" join_time: ");
      localStringBuilder.append(localTroopMemberInfo.join_time);
      QLog.i("IceBreak.HotPic", 1, localStringBuilder.toString());
      if (localTroopMemberInfo.last_active_time > localTroopMemberInfo.join_time) {
        return;
      }
      v(paramString);
      return;
    }
    QLog.i("IceBreak.HotPic", 1, "troop member info is null.");
    this.D = paramString;
    ((ITroopMemberCardHandler)this.d.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER)).a(Long.valueOf(paramString).longValue(), Long.valueOf(this.d.getCurrentAccountUin()).longValue(), true);
    ThreadManager.getSubThreadHandler().post(new IceBreakingMng.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng
 * JD-Core Version:    0.7.0.1
 */