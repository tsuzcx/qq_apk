package com.tencent.mobileqq.relationx.icebreaking;

import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
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
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class IceBreakingMng
  implements Handler.Callback, CfgProcess.OnGetConfigListener, Manager
{
  public static final String a;
  private float jdField_a_of_type_Float;
  public int a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopMngObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver;
  private TroopPushObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(ThreadManager.getFileThreadLooper(), this);
  private final Object jdField_a_of_type_JavaLangObject;
  private WeakReference<OnIceBreakChangeListener> jdField_a_of_type_JavaLangRefWeakReference;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private final ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public boolean a;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private WeakReference<IIceBreakHotPicCallback> jdField_b_of_type_JavaLangRefWeakReference;
  private Set<String> jdField_b_of_type_JavaUtilSet = new HashSet();
  private final ConcurrentHashMap<String, Integer> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private volatile boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private Set<String> jdField_c_of_type_JavaUtilSet = new HashSet();
  private final ConcurrentHashMap<String, Integer> jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_c_of_type_Boolean = false;
  private volatile String jdField_d_of_type_JavaLangString;
  private Set<String> jdField_d_of_type_JavaUtilSet = new HashSet();
  private final ConcurrentHashMap<String, Integer> jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e;
  private boolean f;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131705777);
  }
  
  public IceBreakingMng(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    String str = jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = str;
    this.jdField_c_of_type_JavaLangString = str;
    this.jdField_a_of_type_Float = 7.0F;
    this.e = false;
    this.jdField_b_of_type_Int = 100;
    this.jdField_c_of_type_Int = 50;
    this.jdField_a_of_type_Int = 60;
    this.f = false;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new IceBreakingMng.1(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new IceBreakingMng.3(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new IceBreakingMng.4(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver = new IceBreakingMng.5(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConfigProcess().a("breaking_ice_config", this);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(0);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver, true);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver, true);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver, true);
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
    //   0: getstatic 44	com/tencent/mobileqq/relationx/icebreaking/IceBreakingMng:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3: astore 13
    //   5: iload_1
    //   6: ifne +23 -> 29
    //   9: aload_0
    //   10: getfield 135	com/tencent/mobileqq/relationx/icebreaking/IceBreakingMng:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: invokevirtual 220	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   16: aload_0
    //   17: getfield 135	com/tencent/mobileqq/relationx/icebreaking/IceBreakingMng:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokevirtual 224	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   23: ldc 143
    //   25: invokestatic 229	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   28: astore_2
    //   29: bipush 50
    //   31: istore 5
    //   33: bipush 100
    //   35: istore 6
    //   37: ldc 97
    //   39: fstore 4
    //   41: aload_2
    //   42: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   45: ifne +256 -> 301
    //   48: new 237	org/json/JSONObject
    //   51: dup
    //   52: aload_2
    //   53: invokespecial 239	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   56: astore 15
    //   58: aload 15
    //   60: ldc 241
    //   62: iconst_0
    //   63: invokevirtual 245	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   66: istore_1
    //   67: aload 15
    //   69: ldc 247
    //   71: iconst_0
    //   72: invokevirtual 245	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   75: istore 10
    //   77: aload 15
    //   79: ldc 249
    //   81: getstatic 44	com/tencent/mobileqq/relationx/icebreaking/IceBreakingMng:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   84: invokevirtual 253	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   87: astore_2
    //   88: aload 13
    //   90: astore 14
    //   92: fload 4
    //   94: fstore_3
    //   95: aload 15
    //   97: ldc 255
    //   99: getstatic 44	com/tencent/mobileqq/relationx/icebreaking/IceBreakingMng:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   102: invokevirtual 253	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   105: astore 13
    //   107: aload 13
    //   109: astore 14
    //   111: fload 4
    //   113: fstore_3
    //   114: aload 15
    //   116: ldc_w 257
    //   119: ldc2_w 258
    //   122: invokevirtual 263	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   125: d2f
    //   126: fstore 4
    //   128: aload 13
    //   130: astore 14
    //   132: fload 4
    //   134: fstore_3
    //   135: aload 15
    //   137: ldc_w 265
    //   140: iconst_0
    //   141: invokevirtual 245	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   144: istore 12
    //   146: iload 5
    //   148: istore 7
    //   150: iload 6
    //   152: istore 8
    //   154: aload 15
    //   156: ldc_w 267
    //   159: bipush 100
    //   161: invokevirtual 271	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   164: istore 6
    //   166: iload 5
    //   168: istore 7
    //   170: iload 6
    //   172: istore 8
    //   174: aload 15
    //   176: ldc_w 273
    //   179: bipush 50
    //   181: invokevirtual 271	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   184: istore 5
    //   186: iload 5
    //   188: istore 7
    //   190: iload 6
    //   192: istore 8
    //   194: aload 15
    //   196: ldc_w 275
    //   199: bipush 60
    //   201: invokevirtual 271	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   204: istore 9
    //   206: aload 15
    //   208: ldc_w 277
    //   211: iconst_0
    //   212: invokevirtual 245	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   215: istore 11
    //   217: iload 9
    //   219: istore 7
    //   221: fload 4
    //   223: fstore_3
    //   224: aload 13
    //   226: astore 14
    //   228: goto +135 -> 363
    //   231: astore 15
    //   233: iload 9
    //   235: istore 7
    //   237: fload 4
    //   239: fstore_3
    //   240: aload 13
    //   242: astore 14
    //   244: goto +111 -> 355
    //   247: astore 15
    //   249: bipush 60
    //   251: istore 9
    //   253: iload 7
    //   255: istore 5
    //   257: iload 8
    //   259: istore 6
    //   261: fload 4
    //   263: fstore_3
    //   264: iload 9
    //   266: istore 7
    //   268: aload 13
    //   270: astore 14
    //   272: goto +83 -> 355
    //   275: astore 15
    //   277: aload_2
    //   278: astore 13
    //   280: aload 15
    //   282: astore_2
    //   283: goto +59 -> 342
    //   286: astore_2
    //   287: aload 13
    //   289: astore 14
    //   291: fload 4
    //   293: fstore_3
    //   294: goto +48 -> 342
    //   297: astore_2
    //   298: goto +34 -> 332
    //   301: aload 13
    //   303: astore 14
    //   305: iconst_0
    //   306: istore_1
    //   307: bipush 60
    //   309: istore 7
    //   311: iconst_0
    //   312: istore 10
    //   314: iconst_0
    //   315: istore 11
    //   317: iconst_0
    //   318: istore 12
    //   320: aload 13
    //   322: astore_2
    //   323: fload 4
    //   325: fstore_3
    //   326: goto +37 -> 363
    //   329: astore_2
    //   330: iconst_0
    //   331: istore_1
    //   332: aload 13
    //   334: astore 14
    //   336: iconst_0
    //   337: istore 10
    //   339: fload 4
    //   341: fstore_3
    //   342: bipush 60
    //   344: istore 7
    //   346: iconst_0
    //   347: istore 12
    //   349: aload_2
    //   350: astore 15
    //   352: aload 13
    //   354: astore_2
    //   355: aload 15
    //   357: invokevirtual 280	java/lang/Exception:printStackTrace	()V
    //   360: iconst_0
    //   361: istore 11
    //   363: bipush 10
    //   365: anewarray 4	java/lang/Object
    //   368: dup
    //   369: iconst_0
    //   370: iload_1
    //   371: invokestatic 285	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   374: aastore
    //   375: dup
    //   376: iconst_1
    //   377: iload 10
    //   379: invokestatic 285	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   382: aastore
    //   383: dup
    //   384: iconst_2
    //   385: aload_2
    //   386: aastore
    //   387: dup
    //   388: iconst_3
    //   389: aload 14
    //   391: aastore
    //   392: dup
    //   393: iconst_4
    //   394: fload_3
    //   395: invokestatic 290	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   398: aastore
    //   399: dup
    //   400: iconst_5
    //   401: iload 12
    //   403: invokestatic 285	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   406: aastore
    //   407: dup
    //   408: bipush 6
    //   410: iload 6
    //   412: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   415: aastore
    //   416: dup
    //   417: bipush 7
    //   419: iload 5
    //   421: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   424: aastore
    //   425: dup
    //   426: bipush 8
    //   428: iload 7
    //   430: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   433: aastore
    //   434: dup
    //   435: bipush 9
    //   437: iload 11
    //   439: invokestatic 285	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   442: aastore
    //   443: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	444	0	this	IceBreakingMng
    //   0	444	1	paramBoolean	boolean
    //   0	444	2	paramString	String
    //   94	301	3	f1	float
    //   39	301	4	f2	float
    //   31	389	5	i	int
    //   35	376	6	j	int
    //   148	281	7	k	int
    //   152	106	8	m	int
    //   204	61	9	n	int
    //   75	303	10	bool1	boolean
    //   215	223	11	bool2	boolean
    //   144	258	12	bool3	boolean
    //   3	350	13	str1	String
    //   90	300	14	str2	String
    //   56	151	15	localJSONObject	org.json.JSONObject
    //   231	1	15	localException1	Exception
    //   247	1	15	localException2	Exception
    //   275	6	15	localException3	Exception
    //   350	6	15	str3	String
    // Exception table:
    //   from	to	target	type
    //   206	217	231	java/lang/Exception
    //   154	166	247	java/lang/Exception
    //   174	186	247	java/lang/Exception
    //   194	206	247	java/lang/Exception
    //   95	107	275	java/lang/Exception
    //   114	128	275	java/lang/Exception
    //   135	146	275	java/lang/Exception
    //   77	88	286	java/lang/Exception
    //   67	77	297	java/lang/Exception
    //   41	67	329	java/lang/Exception
  }
  
  private void g()
  {
    Object localObject2 = null;
    Object[] arrayOfObject = a(false, null);
    Object localObject11 = FileUtils.readObject(String.format("%s_%s", new Object[] { "break_ice_map", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }));
    Object localObject10 = FileUtils.readObject(String.format("%s_%s", new Object[] { "entered_c2c", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }));
    Object localObject9 = FileUtils.readObject(String.format("%s_%s", new Object[] { "entered_troop", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }));
    Object localObject8 = FileUtils.readObject(String.format("%s_%s", new Object[] { "entered_match_chat", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }));
    Object localObject7 = FileUtils.readObject(String.format("%s_%s", new Object[] { "entered_qcircle_chat", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }));
    if (this.jdField_b_of_type_Boolean) {
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
      synchronized (this.jdField_a_of_type_JavaUtilSet)
      {
        this.jdField_a_of_type_JavaUtilSet.addAll((Set)localObject10);
      }
    }
    if (localObject9 != null) {
      synchronized (this.jdField_b_of_type_JavaUtilSet)
      {
        this.jdField_b_of_type_JavaUtilSet.addAll((Set)localObject9);
      }
    }
    if (localObject8 != null) {
      synchronized (this.jdField_c_of_type_JavaUtilSet)
      {
        this.jdField_c_of_type_JavaUtilSet.addAll((Set)localObject8);
      }
    }
    if (localObject7 != null) {
      synchronized (this.jdField_d_of_type_JavaUtilSet)
      {
        this.jdField_d_of_type_JavaUtilSet.addAll((Set)localObject7);
      }
    }
    a(((Boolean)arrayOfObject[0]).booleanValue(), ((Boolean)arrayOfObject[1]).booleanValue(), localConcurrentHashMap);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_b_of_type_Boolean)
      {
        if (localConcurrentHashMap != null) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(localConcurrentHashMap);
        }
        this.jdField_c_of_type_Boolean = ((Boolean)arrayOfObject[0]).booleanValue();
        this.jdField_d_of_type_Boolean = ((Boolean)arrayOfObject[1]).booleanValue();
        this.jdField_b_of_type_JavaLangString = ((String)arrayOfObject[2]);
        this.jdField_c_of_type_JavaLangString = ((String)arrayOfObject[3]);
        this.jdField_a_of_type_Float = ((Float)arrayOfObject[4]).floatValue();
        this.e = ((Boolean)arrayOfObject[5]).booleanValue();
        this.jdField_b_of_type_Int = ((Integer)arrayOfObject[6]).intValue();
        this.jdField_c_of_type_Int = ((Integer)arrayOfObject[7]).intValue();
        this.jdField_a_of_type_Int = ((Integer)arrayOfObject[8]).intValue();
        this.f = ((Boolean)arrayOfObject[9]).booleanValue();
        this.jdField_b_of_type_Boolean = true;
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("init IceBreak Config: mSwitchNewFrd: ");
        ((StringBuilder)???).append(this.jdField_c_of_type_Boolean);
        ((StringBuilder)???).append(",mSwitchOldFrd: ");
        ((StringBuilder)???).append(this.jdField_d_of_type_Boolean);
        ((StringBuilder)???).append(",mTipNewFrd: ");
        ((StringBuilder)???).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)???).append(",mTipOldFrd: ");
        ((StringBuilder)???).append(this.jdField_c_of_type_JavaLangString);
        ((StringBuilder)???).append(",mDaysOldFrd: ");
        ((StringBuilder)???).append(this.jdField_a_of_type_Float);
        ((StringBuilder)???).append(",switchTroop: ");
        ((StringBuilder)???).append(this.e);
        ((StringBuilder)???).append(",troopMemberMinCount: ");
        ((StringBuilder)???).append(this.jdField_b_of_type_Int);
        ((StringBuilder)???).append(",troopMemberNotFriendRate: ");
        ((StringBuilder)???).append(this.jdField_c_of_type_Int);
        ((StringBuilder)???).append(",showDuration: ");
        ((StringBuilder)???).append(this.jdField_a_of_type_Int);
        ((StringBuilder)???).append(",mSwitchNewFrdMiniCard: ");
        ((StringBuilder)???).append(this.f);
        QLog.d("IceBreak.Mng", 2, ((StringBuilder)???).toString());
      }
      return;
    }
  }
  
  private void h()
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    localConcurrentHashMap.putAll(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
    FileUtils.writeObject(String.format("%s_%s", new Object[] { "break_ice_map", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }), localConcurrentHashMap);
  }
  
  private void m(String paramString)
  {
    Object localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject1 = ((TroopManager)localObject2).c(paramString);
    if (localObject1 == null)
    {
      QLog.i("IceBreak.HotPic", 1, "troop info is null.");
      return;
    }
    if (((TroopInfo)localObject1).wMemberNum < this.jdField_b_of_type_Int)
    {
      Object localObject3 = ((TroopManager)localObject2).b(paramString);
      int j = 0;
      int i = 0;
      if ((localObject3 != null) && (((List)localObject3).size() > 1))
      {
        j = ((List)localObject3).size();
        localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          String str2 = ((TroopMemberInfo)((Iterator)localObject3).next()).memberuin;
          if ((!TextUtils.isEmpty(str2)) && (!str2.equals(str1)) && (!((FriendsManager)localObject2).b(str2))) {
            i += 1;
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("noFriendCount: ");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" total count: ");
        ((StringBuilder)localObject2).append(((TroopInfo)localObject1).wMemberNum);
        QLog.i("IceBreak.HotPic", 1, ((StringBuilder)localObject2).toString());
        if (i * 1.0F / (j - 1) > this.jdField_c_of_type_Int / 100.0F) {
          f(paramString);
        }
      }
      else
      {
        if (localObject3 == null) {
          i = j;
        } else {
          i = ((List)localObject3).size();
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("troop member size: ");
        ((StringBuilder)localObject1).append(i);
        QLog.i("IceBreak.HotPic", 1, ((StringBuilder)localObject1).toString());
        this.jdField_d_of_type_JavaLangString = paramString;
        ((ITroopMemberListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER)).a(paramString);
      }
    }
    else
    {
      f(paramString);
    }
  }
  
  public float a()
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    return this.jdField_a_of_type_Float;
  }
  
  public int a(String paramString, int paramInt)
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    if (paramInt == 1)
    {
      paramString = (Integer)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString == null) {
        return -1;
      }
      return paramString.intValue();
    }
    if (IceBreakingUtil.d(paramInt))
    {
      paramString = (Integer)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString == null) {
        return -1;
      }
      return paramString.intValue();
    }
    if (IceBreakingUtil.e(paramInt))
    {
      paramString = (Integer)this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString == null) {
        return -1;
      }
      return paramString.intValue();
    }
    paramString = (Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    if (!this.jdField_c_of_type_JavaUtilSet.isEmpty()) {
      synchronized (this.jdField_c_of_type_JavaUtilSet)
      {
        this.jdField_c_of_type_JavaUtilSet.clear();
        d();
        return;
      }
    }
  }
  
  public void a(IIceBreakHotPicCallback paramIIceBreakHotPicCallback)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramIIceBreakHotPicCallback);
  }
  
  public void a(OnIceBreakChangeListener paramOnIceBreakChangeListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnIceBreakChangeListener);
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
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    if (this.jdField_c_of_type_JavaUtilSet.contains(paramString)) {
      synchronized (this.jdField_c_of_type_JavaUtilSet)
      {
        this.jdField_c_of_type_JavaUtilSet.remove(paramString);
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
      localReqBody.str_client_ver.set("8.7.0");
      paramString1 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (paramString1 != null) {
        localReqBody.uint32_age.set(paramString1.age);
      } else {
        localReqBody.uint32_age.set(0);
      }
      paramString1 = localReqBody.toByteArray();
      paramString2 = ByteBuffer.allocate(paramString1.length + 4);
      paramString2.putInt(paramString1.length + 4).put(paramString1);
      paramString1 = paramString2.array();
      paramString1 = ((IStickerRecApi)QRoute.api(IStickerRecApi.class)).getStickerRecIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramString1, "BreakIceSvr.Pull");
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("request HotPicList, sessionId = ");
        paramString2.append((String)localObject);
        QLog.d("IceBreak.Mng", 2, paramString2.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString1);
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
    Object localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
    boolean bool;
    if ((localObject != null) && (((Friends)localObject).isFriend())) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(paramBoolean ^ true));
      localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject != null)
      {
        localObject = (OnIceBreakChangeListener)((WeakReference)localObject).get();
        if (localObject != null) {
          ((OnIceBreakChangeListener)localObject).a(paramString, false);
        }
      }
      if (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.hasMessages(1)) {
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1);
      }
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(1);
    }
    else
    {
      e(paramString);
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
        int j = ((IcebreakHotPic.RspBody)localObject).int32_img_num.get();
        localObject = new ArrayList();
        int i = 0;
        while (i < paramArrayOfByte.size())
        {
          IcebreakHotPic.ImgInfo localImgInfo = (IcebreakHotPic.ImgInfo)paramArrayOfByte.get(i);
          StickerRecData localStickerRecData = new StickerRecData();
          localStickerRecData.f(i);
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
          i += 1;
        }
        ThreadManager.getUIHandler().post(new IceBreakingMng.2(this, (List)localObject, j));
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("handleGetIceBreakHotPicResponse staticImageNum:");
          paramArrayOfByte.append(j);
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
  
  public boolean a()
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    if (this.jdField_a_of_type_Boolean) {
      this.f = true;
    }
    return this.f;
  }
  
  public boolean a(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    return this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_d_of_type_Boolean = true;
    }
    if (paramBoolean) {
      return this.jdField_c_of_type_Boolean;
    }
    return this.jdField_d_of_type_Boolean;
  }
  
  public void b()
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.jdField_a_of_type_JavaUtilSet);
    FileUtils.writeObject(String.format("%s_%s", new Object[] { "entered_c2c", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }), localHashSet);
  }
  
  public void b(OnIceBreakChangeListener paramOnIceBreakChangeListener)
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() == paramOnIceBreakChangeListener)) {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
  
  public void b(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    if (!this.jdField_c_of_type_JavaUtilSet.contains(paramString)) {
      synchronized (this.jdField_c_of_type_JavaUtilSet)
      {
        this.jdField_c_of_type_JavaUtilSet.add(paramString);
        return;
      }
    }
  }
  
  public boolean b(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    return this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void c()
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.jdField_b_of_type_JavaUtilSet);
    FileUtils.writeObject(String.format("%s_%s", new Object[] { "entered_troop", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }), localHashSet);
  }
  
  public void c(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    if (!this.jdField_d_of_type_JavaUtilSet.contains(paramString)) {
      synchronized (this.jdField_d_of_type_JavaUtilSet)
      {
        this.jdField_d_of_type_JavaUtilSet.add(paramString);
        return;
      }
    }
  }
  
  public boolean c(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    return this.jdField_c_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void d()
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    HashSet localHashSet = new HashSet();
    synchronized (this.jdField_c_of_type_JavaUtilSet)
    {
      localHashSet.addAll(this.jdField_c_of_type_JavaUtilSet);
      FileUtils.writeObject(String.format("%s_%s", new Object[] { "entered_match_chat", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }), localHashSet);
      return;
    }
  }
  
  public void d(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    if (!this.jdField_a_of_type_JavaUtilSet.contains(paramString)) {
      synchronized (this.jdField_a_of_type_JavaUtilSet)
      {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
        return;
      }
    }
  }
  
  public boolean d(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    return this.jdField_d_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void e()
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.jdField_d_of_type_JavaUtilSet);
    FileUtils.writeObject(String.format("%s_%s", new Object[] { "entered_qcircle_chat", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }), localHashSet);
  }
  
  public void e(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    if (!this.jdField_b_of_type_JavaUtilSet.contains(paramString)) {
      synchronized (this.jdField_b_of_type_JavaUtilSet)
      {
        this.jdField_b_of_type_JavaUtilSet.add(paramString);
        return;
      }
    }
  }
  
  public boolean e(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    boolean bool = false;
    if (localObject1 != null)
    {
      Object localObject2 = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject2 != null)
      {
        localObject2 = (OnIceBreakChangeListener)((WeakReference)localObject2).get();
        if (localObject2 != null) {
          ((OnIceBreakChangeListener)localObject2).b(paramString, false);
        }
      }
      if (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.hasMessages(1)) {
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1);
      }
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(1);
    }
    if (QLog.isColorLevel()) {
      QLog.i("IceBreak.IceBreakingUtil", 2, String.format(Locale.getDefault(), "removeFromBreakingIceList uin: %s , ret:%s", new Object[] { paramString, localObject1 }));
    }
    if (localObject1 != null) {
      bool = true;
    }
    return bool;
  }
  
  public void f()
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = null;
  }
  
  public void f(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("insertTroopToBreakingIceMap troopUin: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("IceBreak.Mng", 1, ((StringBuilder)localObject).toString());
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(0));
    localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (OnIceBreakChangeListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((OnIceBreakChangeListener)localObject).a(paramString, true);
      }
    }
  }
  
  public boolean f(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    boolean bool2 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
    boolean bool1 = bool2;
    if (bool2)
    {
      paramString = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
      if ((paramString != null) && (paramString.isFriend())) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public void g(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("removeTroopFromBreakingIceMap troopUin: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("IceBreak.Mng", 1, ((StringBuilder)localObject).toString());
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (OnIceBreakChangeListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((OnIceBreakChangeListener)localObject).b(paramString, true);
      }
    }
  }
  
  public void h(String paramString)
  {
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (OnIceBreakChangeListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((OnIceBreakChangeListener)localObject).b(paramString, false);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i == 1) {
        h();
      }
    }
    else {
      g();
    }
    return false;
  }
  
  public void i(String paramString)
  {
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (OnIceBreakChangeListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((OnIceBreakChangeListener)localObject).b(paramString, false);
      }
    }
  }
  
  public void j(String paramString)
  {
    if (c(paramString))
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
    if (!((IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).e())
    {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.Mng", 2, "checkNeedShowIceBreakMatchChat switch is off");
      }
      return;
    }
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(0));
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (OnIceBreakChangeListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((OnIceBreakChangeListener)localObject).a(paramString, false);
      }
    }
  }
  
  public void k(String paramString)
  {
    if (d(paramString))
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
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(0));
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (OnIceBreakChangeListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((OnIceBreakChangeListener)localObject).a(paramString, false);
      }
    }
  }
  
  public void l(String paramString)
  {
    if (!((IStickerRecManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IStickerRecManager.class)).isEmotionRecSettingOpen())
    {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.HotPic", 2, "checkNeedShowIceBreakForTroop emotionRec switch is off");
      }
      return;
    }
    if (b(paramString))
    {
      QLog.i("IceBreak.HotPic", 1, "entered toop.");
      return;
    }
    if (!this.e)
    {
      QLog.i("IceBreak.HotPic", 1, "troop switch is off.");
      return;
    }
    TroopMemberInfo localTroopMemberInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
      m(paramString);
      return;
    }
    QLog.i("IceBreak.HotPic", 1, "troop member info is null.");
    this.jdField_d_of_type_JavaLangString = paramString;
    ((ITroopMemberCardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER)).a(Long.valueOf(paramString).longValue(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue(), true);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConfigProcess().a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
  }
  
  public void onGetConfig(QQAppInterface paramQQAppInterface, int paramInt, String paramString, CfgProcess.CfgParseResult paramCfgParseResult)
  {
    if ((paramCfgParseResult != null) && ("breaking_ice_config".equals(paramString)))
    {
      if (!this.jdField_b_of_type_Boolean) {
        g();
      }
      paramQQAppInterface = a(true, paramCfgParseResult.jdField_a_of_type_JavaLangString);
      boolean bool1 = ((Boolean)paramQQAppInterface[0]).booleanValue();
      boolean bool2 = ((Boolean)paramQQAppInterface[1]).booleanValue();
      this.jdField_b_of_type_JavaLangString = ((String)paramQQAppInterface[2]);
      this.jdField_c_of_type_JavaLangString = ((String)paramQQAppInterface[3]);
      this.jdField_a_of_type_Float = ((Float)paramQQAppInterface[4]).floatValue();
      this.e = ((Boolean)paramQQAppInterface[5]).booleanValue();
      this.jdField_b_of_type_Int = ((Integer)paramQQAppInterface[6]).intValue();
      this.jdField_c_of_type_Int = ((Integer)paramQQAppInterface[7]).intValue();
      this.jdField_a_of_type_Int = ((Integer)paramQQAppInterface[8]).intValue();
      this.f = ((Boolean)paramQQAppInterface[9]).booleanValue();
      if ((bool1 != this.jdField_c_of_type_Boolean) || (bool2 != this.jdField_d_of_type_Boolean))
      {
        this.jdField_c_of_type_Boolean = ((Boolean)paramQQAppInterface[0]).booleanValue();
        this.jdField_d_of_type_Boolean = ((Boolean)paramQQAppInterface[1]).booleanValue();
        paramQQAppInterface = new ConcurrentHashMap(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
        paramQQAppInterface.putAll(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
        if (a(this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean, paramQQAppInterface))
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(paramQQAppInterface);
          if (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.hasMessages(1)) {
            this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1);
          }
          this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(1);
        }
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("onGetConfig: mSwitchNewFrd: ");
        paramQQAppInterface.append(this.jdField_c_of_type_Boolean);
        paramQQAppInterface.append(",mSwitchOldFrd: ");
        paramQQAppInterface.append(this.jdField_d_of_type_Boolean);
        paramQQAppInterface.append(",mTipNewFrd: ");
        paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString);
        paramQQAppInterface.append(",mTipOldFrd: ");
        paramQQAppInterface.append(this.jdField_c_of_type_JavaLangString);
        paramQQAppInterface.append(",mDaysOldFrd: ");
        paramQQAppInterface.append(this.jdField_a_of_type_Float);
        paramQQAppInterface.append(",switchTroop: ");
        paramQQAppInterface.append(this.e);
        paramQQAppInterface.append(",troopMemberMinCount: ");
        paramQQAppInterface.append(this.jdField_b_of_type_Int);
        paramQQAppInterface.append(",troopMemberNotFriendRate: ");
        paramQQAppInterface.append(this.jdField_c_of_type_Int);
        paramQQAppInterface.append(",showDuration: ");
        paramQQAppInterface.append(this.jdField_a_of_type_Int);
        paramQQAppInterface.append(",mSwitchNewFrdMiniCard: ");
        paramQQAppInterface.append(this.f);
        QLog.d("IceBreak.Mng", 2, paramQQAppInterface.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng
 * JD-Core Version:    0.7.0.1
 */