package com.tencent.mobileqq.guild.message.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.data.ChannelMsgEvent;
import com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService.MsgSeqTimeItem;
import com.tencent.mobileqq.guild.message.unread.DecreaseMsgSeqInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

public class GuildMessageBoxDataServiceImpl
  implements IGuildMessageBoxDataService
{
  private static final String GUILD_MSG_BOX_SP_NAME = "guildMsgBoxSP";
  private static final String TAG = "GuildMessageBoxDataServiceImpl";
  private AppRuntime mApp;
  private HashMap<String, List<ChannelMsgEvent>> mChannelMsgEventMap = new HashMap();
  private EntityManager mEntityManager;
  
  private boolean addChannelMsgEventToCache(ChannelMsgEvent paramChannelMsgEvent)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addChannelMsgEventToCache, info = ");
    ((StringBuilder)localObject).append(paramChannelMsgEvent);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = true;
    QLog.d("GuildMessageBoxDataServiceImpl", 1, (String)localObject);
    if (paramChannelMsgEvent != null)
    {
      if (TextUtils.isEmpty(paramChannelMsgEvent.channelId)) {
        return false;
      }
      localObject = (List)this.mChannelMsgEventMap.get(paramChannelMsgEvent.channelId);
      if (localObject != null)
      {
        if (!((List)localObject).contains(paramChannelMsgEvent)) {
          ((List)localObject).add(paramChannelMsgEvent);
        } else {
          bool = false;
        }
      }
      else
      {
        localObject = new ArrayList();
        ((List)localObject).add(paramChannelMsgEvent);
      }
      this.mChannelMsgEventMap.put(paramChannelMsgEvent.channelId, localObject);
      return bool;
    }
    return false;
  }
  
  private void sortChannelMsgEventList(String paramString)
  {
    try
    {
      if ((this.mChannelMsgEventMap != null) && (!TextUtils.isEmpty(paramString)))
      {
        Collections.sort((List)this.mChannelMsgEventMap.get(paramString), new GuildMessageBoxDataServiceImpl.3(this));
        return;
      }
      return;
    }
    finally {}
  }
  
  private boolean updateEntity(Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity == null) {
      return false;
    }
    if (this.mEntityManager.isOpen())
    {
      if (paramEntity.getStatus() == 1000)
      {
        this.mEntityManager.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
        return bool;
      }
      return this.mEntityManager.update(paramEntity);
    }
    return false;
  }
  
  private void verifyMsgEventList()
  {
    Object localObject = (IGuildMsgSeqTimeService)this.mApp.getRuntimeService(IGuildMsgSeqTimeService.class, "");
    if (localObject == null)
    {
      QLog.d("GuildMessageBoxDataServiceImpl", 1, "verifyMsgEventList, guildMsgSeqTimeService == null");
      return;
    }
    Iterator localIterator1 = this.mChannelMsgEventMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      if (localEntry != null)
      {
        IGuildMsgSeqTimeService.MsgSeqTimeItem localMsgSeqTimeItem = ((IGuildMsgSeqTimeService)localObject).getReadedMsgSeq((String)localEntry.getKey());
        HashSet localHashSet = ((IGuildMsgSeqTimeService)localObject).getDecreaseMsgSeqList((String)localEntry.getKey());
        DecreaseMsgSeqInfo localDecreaseMsgSeqInfo = new DecreaseMsgSeqInfo();
        if (localEntry.getValue() != null)
        {
          Iterator localIterator2 = ((List)localEntry.getValue()).iterator();
          while (localIterator2.hasNext())
          {
            ChannelMsgEvent localChannelMsgEvent = (ChannelMsgEvent)localIterator2.next();
            localDecreaseMsgSeqInfo.msgSeq = localChannelMsgEvent.msgSeq;
            if (((localMsgSeqTimeItem != null) && (localMsgSeqTimeItem.a >= localChannelMsgEvent.msgSeq)) || (localHashSet.contains(localDecreaseMsgSeqInfo))) {
              localIterator2.remove();
            }
          }
          sortChannelMsgEventList((String)localEntry.getKey());
        }
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("verifyMsgEventList, mChannelMsgEventMap = ");
    ((StringBuilder)localObject).append(this.mChannelMsgEventMap);
    QLog.d("GuildMessageBoxDataServiceImpl", 1, ((StringBuilder)localObject).toString());
  }
  
  public void addChannelMsgBoxEvent(ChannelMsgEvent paramChannelMsgEvent)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("addChannelMsgBoxEvent, event = ");
      ((StringBuilder)localObject1).append(paramChannelMsgEvent);
      QLog.d("GuildMessageBoxDataServiceImpl", 1, ((StringBuilder)localObject1).toString());
      if (paramChannelMsgEvent == null) {
        return;
      }
      Object localObject2 = (IGuildMsgSeqTimeService)this.mApp.getRuntimeService(IGuildMsgSeqTimeService.class, "");
      localObject1 = ((IGuildMsgSeqTimeService)localObject2).getReadedMsgSeq(paramChannelMsgEvent.channelId);
      localObject2 = ((IGuildMsgSeqTimeService)localObject2).getDecreaseMsgSeqList(paramChannelMsgEvent.channelId);
      if ((localObject1 == null) || (((IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject1).a < paramChannelMsgEvent.msgSeq))
      {
        boolean bool = ((HashSet)localObject2).contains(new DecreaseMsgSeqInfo(paramChannelMsgEvent.msgSeq, DecreaseMsgSeqInfo.MSGTYPE_NONE));
        if (!bool) {}
      }
      else
      {
        return;
      }
      if (addChannelMsgEventToCache(paramChannelMsgEvent))
      {
        sortChannelMsgEventList(paramChannelMsgEvent.channelId);
        ThreadManager.excute(new GuildMessageBoxDataServiceImpl.1(this, paramChannelMsgEvent), 32, null, true);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void addChannelMsgBoxEventList(String paramString, List<ChannelMsgEvent> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 44	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   9: astore 6
    //   11: aload 6
    //   13: ldc 233
    //   15: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload 6
    //   21: aload_1
    //   22: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload 6
    //   28: ldc 235
    //   30: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 6
    //   36: aload_2
    //   37: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: ldc 13
    //   43: iconst_1
    //   44: aload 6
    //   46: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_1
    //   53: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifne +303 -> 359
    //   59: aload_2
    //   60: ifnull +299 -> 359
    //   63: aload_2
    //   64: invokeinterface 238 1 0
    //   69: ifne +6 -> 75
    //   72: goto +287 -> 359
    //   75: aload_0
    //   76: getfield 130	com/tencent/mobileqq/guild/message/api/impl/GuildMessageBoxDataServiceImpl:mApp	Lmqq/app/AppRuntime;
    //   79: ldc 132
    //   81: ldc 134
    //   83: invokevirtual 140	mqq/app/AppRuntime:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   86: checkcast 132	com/tencent/mobileqq/guild/message/api/IGuildMsgSeqTimeService
    //   89: astore 7
    //   91: aload 7
    //   93: aload_1
    //   94: invokeinterface 172 2 0
    //   99: astore 6
    //   101: aload 7
    //   103: aload_1
    //   104: invokeinterface 176 2 0
    //   109: astore 7
    //   111: iconst_0
    //   112: istore 5
    //   114: iconst_0
    //   115: istore_3
    //   116: iload 5
    //   118: istore 4
    //   120: aload_0
    //   121: getfield 40	com/tencent/mobileqq/guild/message/api/impl/GuildMessageBoxDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   124: invokevirtual 242	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   127: invokevirtual 247	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   130: iload 5
    //   132: istore 4
    //   134: aload_2
    //   135: invokeinterface 183 1 0
    //   140: astore_2
    //   141: iload_3
    //   142: istore 4
    //   144: aload_2
    //   145: invokeinterface 157 1 0
    //   150: ifeq +100 -> 250
    //   153: iload_3
    //   154: istore 4
    //   156: aload_2
    //   157: invokeinterface 161 1 0
    //   162: checkcast 66	com/tencent/mobileqq/guild/data/ChannelMsgEvent
    //   165: astore 8
    //   167: aload 8
    //   169: ifnull -28 -> 141
    //   172: iload_3
    //   173: istore 4
    //   175: aload 7
    //   177: new 178	com/tencent/mobileqq/guild/message/unread/DecreaseMsgSeqInfo
    //   180: dup
    //   181: aload 8
    //   183: getfield 187	com/tencent/mobileqq/guild/data/ChannelMsgEvent:msgSeq	J
    //   186: getstatic 211	com/tencent/mobileqq/guild/message/unread/DecreaseMsgSeqInfo:MSGTYPE_NONE	I
    //   189: invokespecial 214	com/tencent/mobileqq/guild/message/unread/DecreaseMsgSeqInfo:<init>	(JI)V
    //   192: invokevirtual 196	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   195: ifne -54 -> 141
    //   198: aload 6
    //   200: ifnull +23 -> 223
    //   203: iload_3
    //   204: istore 4
    //   206: aload 6
    //   208: getfield 193	com/tencent/mobileqq/guild/message/api/IGuildMsgSeqTimeService$MsgSeqTimeItem:a	J
    //   211: aload 8
    //   213: getfield 187	com/tencent/mobileqq/guild/data/ChannelMsgEvent:msgSeq	J
    //   216: lcmp
    //   217: iflt +6 -> 223
    //   220: goto -79 -> 141
    //   223: iload_3
    //   224: istore 4
    //   226: aload_0
    //   227: aload 8
    //   229: invokespecial 216	com/tencent/mobileqq/guild/message/api/impl/GuildMessageBoxDataServiceImpl:addChannelMsgEventToCache	(Lcom/tencent/mobileqq/guild/data/ChannelMsgEvent;)Z
    //   232: ifeq -91 -> 141
    //   235: iload_3
    //   236: istore 4
    //   238: aload_0
    //   239: aload 8
    //   241: invokespecial 36	com/tencent/mobileqq/guild/message/api/impl/GuildMessageBoxDataServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   244: pop
    //   245: iconst_1
    //   246: istore_3
    //   247: goto -106 -> 141
    //   250: iload_3
    //   251: istore 4
    //   253: aload_0
    //   254: getfield 40	com/tencent/mobileqq/guild/message/api/impl/GuildMessageBoxDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   257: invokevirtual 242	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   260: invokevirtual 250	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   263: aload_0
    //   264: getfield 40	com/tencent/mobileqq/guild/message/api/impl/GuildMessageBoxDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   267: invokevirtual 242	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   270: astore_2
    //   271: aload_2
    //   272: invokevirtual 253	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   275: goto +60 -> 335
    //   278: astore_1
    //   279: goto +68 -> 347
    //   282: astore_2
    //   283: new 44	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   290: astore 6
    //   292: aload 6
    //   294: ldc 254
    //   296: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload 6
    //   302: aload_2
    //   303: invokevirtual 255	java/lang/Exception:toString	()Ljava/lang/String;
    //   306: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: ldc 13
    //   312: iconst_1
    //   313: aload 6
    //   315: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 258	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   321: aload_0
    //   322: getfield 40	com/tencent/mobileqq/guild/message/api/impl/GuildMessageBoxDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   325: invokevirtual 242	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   328: astore_2
    //   329: iload 4
    //   331: istore_3
    //   332: goto -61 -> 271
    //   335: iload_3
    //   336: ifeq +8 -> 344
    //   339: aload_0
    //   340: aload_1
    //   341: invokespecial 201	com/tencent/mobileqq/guild/message/api/impl/GuildMessageBoxDataServiceImpl:sortChannelMsgEventList	(Ljava/lang/String;)V
    //   344: aload_0
    //   345: monitorexit
    //   346: return
    //   347: aload_0
    //   348: getfield 40	com/tencent/mobileqq/guild/message/api/impl/GuildMessageBoxDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   351: invokevirtual 242	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   354: invokevirtual 253	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   357: aload_1
    //   358: athrow
    //   359: aload_0
    //   360: monitorexit
    //   361: return
    //   362: astore_1
    //   363: aload_0
    //   364: monitorexit
    //   365: goto +5 -> 370
    //   368: aload_1
    //   369: athrow
    //   370: goto -2 -> 368
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	373	0	this	GuildMessageBoxDataServiceImpl
    //   0	373	1	paramString	String
    //   0	373	2	paramList	List<ChannelMsgEvent>
    //   115	221	3	i	int
    //   118	212	4	j	int
    //   112	19	5	k	int
    //   9	305	6	localObject1	Object
    //   89	87	7	localObject2	Object
    //   165	75	8	localChannelMsgEvent	ChannelMsgEvent
    // Exception table:
    //   from	to	target	type
    //   120	130	278	finally
    //   134	141	278	finally
    //   144	153	278	finally
    //   156	167	278	finally
    //   175	198	278	finally
    //   206	220	278	finally
    //   226	235	278	finally
    //   238	245	278	finally
    //   253	263	278	finally
    //   283	321	278	finally
    //   120	130	282	java/lang/Exception
    //   134	141	282	java/lang/Exception
    //   144	153	282	java/lang/Exception
    //   156	167	282	java/lang/Exception
    //   175	198	282	java/lang/Exception
    //   206	220	282	java/lang/Exception
    //   226	235	282	java/lang/Exception
    //   238	245	282	java/lang/Exception
    //   253	263	282	java/lang/Exception
    //   2	59	362	finally
    //   63	72	362	finally
    //   75	111	362	finally
    //   263	271	362	finally
    //   271	275	362	finally
    //   321	329	362	finally
    //   339	344	362	finally
    //   347	359	362	finally
  }
  
  /* Error */
  public void clearChannelMsgBoxReadEventList(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 44	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   9: astore 4
    //   11: aload 4
    //   13: ldc_w 264
    //   16: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload 4
    //   22: aload_1
    //   23: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload 4
    //   29: ldc_w 266
    //   32: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload 4
    //   38: lload_2
    //   39: invokevirtual 269	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: ldc 13
    //   45: iconst_1
    //   46: aload 4
    //   48: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: aload_1
    //   55: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: ifne +317 -> 375
    //   61: aload_0
    //   62: getfield 29	com/tencent/mobileqq/guild/message/api/impl/GuildMessageBoxDataServiceImpl:mChannelMsgEventMap	Ljava/util/HashMap;
    //   65: ifnull +310 -> 375
    //   68: aload_0
    //   69: getfield 29	com/tencent/mobileqq/guild/message/api/impl/GuildMessageBoxDataServiceImpl:mChannelMsgEventMap	Ljava/util/HashMap;
    //   72: aload_1
    //   73: invokevirtual 79	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   76: astore 4
    //   78: aload 4
    //   80: ifnonnull +6 -> 86
    //   83: goto +292 -> 375
    //   86: aload_0
    //   87: getfield 130	com/tencent/mobileqq/guild/message/api/impl/GuildMessageBoxDataServiceImpl:mApp	Lmqq/app/AppRuntime;
    //   90: ldc 132
    //   92: ldc 134
    //   94: invokevirtual 140	mqq/app/AppRuntime:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   97: checkcast 132	com/tencent/mobileqq/guild/message/api/IGuildMsgSeqTimeService
    //   100: aload_1
    //   101: invokeinterface 172 2 0
    //   106: astore 4
    //   108: new 44	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   115: astore 5
    //   117: aload 5
    //   119: ldc_w 271
    //   122: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 5
    //   128: aload 4
    //   130: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: ldc 13
    //   136: iconst_1
    //   137: aload 5
    //   139: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: aload_0
    //   146: getfield 40	com/tencent/mobileqq/guild/message/api/impl/GuildMessageBoxDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   149: invokevirtual 242	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   152: invokevirtual 247	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   155: aload_0
    //   156: getfield 29	com/tencent/mobileqq/guild/message/api/impl/GuildMessageBoxDataServiceImpl:mChannelMsgEventMap	Ljava/util/HashMap;
    //   159: aload_1
    //   160: invokevirtual 79	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   163: checkcast 81	java/util/List
    //   166: invokeinterface 183 1 0
    //   171: astore_1
    //   172: aload_1
    //   173: invokeinterface 157 1 0
    //   178: ifeq +102 -> 280
    //   181: aload_1
    //   182: invokeinterface 161 1 0
    //   187: checkcast 66	com/tencent/mobileqq/guild/data/ChannelMsgEvent
    //   190: astore 5
    //   192: aload 5
    //   194: ifnull -22 -> 172
    //   197: aload 5
    //   199: getfield 274	com/tencent/mobileqq/guild/data/ChannelMsgEvent:eventType	J
    //   202: lload_2
    //   203: lcmp
    //   204: ifne -32 -> 172
    //   207: aload 5
    //   209: getfield 187	com/tencent/mobileqq/guild/data/ChannelMsgEvent:msgSeq	J
    //   212: aload 4
    //   214: getfield 193	com/tencent/mobileqq/guild/message/api/IGuildMsgSeqTimeService$MsgSeqTimeItem:a	J
    //   217: lcmp
    //   218: ifle +43 -> 261
    //   221: new 44	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   228: astore 6
    //   230: aload 6
    //   232: ldc_w 276
    //   235: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 6
    //   241: aload 5
    //   243: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: ldc 13
    //   249: iconst_1
    //   250: aload 6
    //   252: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   258: goto -86 -> 172
    //   261: aload_0
    //   262: getfield 40	com/tencent/mobileqq/guild/message/api/impl/GuildMessageBoxDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   265: aload 5
    //   267: invokevirtual 278	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   270: pop
    //   271: aload_1
    //   272: invokeinterface 199 1 0
    //   277: goto -105 -> 172
    //   280: aload_0
    //   281: getfield 40	com/tencent/mobileqq/guild/message/api/impl/GuildMessageBoxDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   284: invokevirtual 242	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   287: invokevirtual 250	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   290: aload_0
    //   291: getfield 40	com/tencent/mobileqq/guild/message/api/impl/GuildMessageBoxDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   294: invokevirtual 242	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   297: astore_1
    //   298: aload_1
    //   299: invokevirtual 253	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   302: goto +58 -> 360
    //   305: astore_1
    //   306: goto +57 -> 363
    //   309: astore_1
    //   310: new 44	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   317: astore 4
    //   319: aload 4
    //   321: ldc_w 279
    //   324: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload 4
    //   330: aload_1
    //   331: invokevirtual 255	java/lang/Exception:toString	()Ljava/lang/String;
    //   334: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: ldc 13
    //   340: iconst_1
    //   341: aload 4
    //   343: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 258	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: aload_0
    //   350: getfield 40	com/tencent/mobileqq/guild/message/api/impl/GuildMessageBoxDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   353: invokevirtual 242	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   356: astore_1
    //   357: goto -59 -> 298
    //   360: aload_0
    //   361: monitorexit
    //   362: return
    //   363: aload_0
    //   364: getfield 40	com/tencent/mobileqq/guild/message/api/impl/GuildMessageBoxDataServiceImpl:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   367: invokevirtual 242	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   370: invokevirtual 253	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   373: aload_1
    //   374: athrow
    //   375: new 44	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   382: astore 4
    //   384: aload 4
    //   386: ldc_w 264
    //   389: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload 4
    //   395: aload_1
    //   396: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload 4
    //   402: ldc_w 281
    //   405: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: ldc 13
    //   411: iconst_1
    //   412: aload 4
    //   414: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   420: aload_0
    //   421: monitorexit
    //   422: return
    //   423: astore_1
    //   424: aload_0
    //   425: monitorexit
    //   426: goto +5 -> 431
    //   429: aload_1
    //   430: athrow
    //   431: goto -2 -> 429
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	this	GuildMessageBoxDataServiceImpl
    //   0	434	1	paramString	String
    //   0	434	2	paramLong	long
    //   9	404	4	localObject1	Object
    //   115	151	5	localObject2	Object
    //   228	23	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   86	172	305	finally
    //   172	192	305	finally
    //   197	258	305	finally
    //   261	277	305	finally
    //   280	290	305	finally
    //   310	349	305	finally
    //   86	172	309	java/lang/Exception
    //   172	192	309	java/lang/Exception
    //   197	258	309	java/lang/Exception
    //   261	277	309	java/lang/Exception
    //   280	290	309	java/lang/Exception
    //   2	78	423	finally
    //   290	298	423	finally
    //   298	302	423	finally
    //   349	357	423	finally
    //   363	375	423	finally
    //   375	420	423	finally
  }
  
  public HashMap<String, List<ChannelMsgEvent>> getAllChannelMsgEventList()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAllChannelMsgEventList, mChannelMsgEventMap = ");
    localStringBuilder.append(this.mChannelMsgEventMap);
    QLog.d("GuildMessageBoxDataServiceImpl", 1, localStringBuilder.toString());
    return this.mChannelMsgEventMap;
  }
  
  @Nullable
  public List<ChannelMsgEvent> getChannelMsgEventList(String paramString, long paramLong)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.mChannelMsgEventMap.containsKey(paramString))) {
      return (List)this.mChannelMsgEventMap.get(paramString);
    }
    return null;
  }
  
  public int getChannelMsgEventUnreadCount(String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getChannelMsgEventUnreadCount, channelId = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", eventType = ");
      localStringBuilder.append(paramLong);
      QLog.d("GuildMessageBoxDataServiceImpl", 1, localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && (this.mChannelMsgEventMap.containsKey(paramString)) && (this.mChannelMsgEventMap.get(paramString) != null)) {
      return ((List)this.mChannelMsgEventMap.get(paramString)).size();
    }
    return 0;
  }
  
  public String getMessageBoxCookie()
  {
    String str = this.mApp.getCurrentUin();
    if (TextUtils.isEmpty(str))
    {
      QLog.d("GuildMessageBoxDataServiceImpl", 1, "getMessageBoxCookie, spKeyName = null");
      return null;
    }
    return this.mApp.getApp().getSharedPreferences("guildMsgBoxSP", 0).getString(str, "");
  }
  
  public void initMsgBoxData()
  {
    this.mEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
    Object localObject = (ArrayList)this.mEntityManager.query(ChannelMsgEvent.class, false, null, null, null, null, null, null);
    if (localObject == null)
    {
      QLog.e("GuildMessageBoxDataServiceImpl", 1, "[initMsgBoxData] entices == null");
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      addChannelMsgEventToCache((ChannelMsgEvent)((Iterator)localObject).next());
    }
    verifyMsgEventList();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    initMsgBoxData();
  }
  
  public void onDestroy()
  {
    EntityManager localEntityManager = this.mEntityManager;
    if (localEntityManager != null) {
      localEntityManager.close();
    }
  }
  
  public void removeChannelMsgBoxReadEvent(ChannelMsgEvent paramChannelMsgEvent)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeChannelMsgBoxReadEvent, event = ");
      localStringBuilder.append(paramChannelMsgEvent);
      QLog.d("GuildMessageBoxDataServiceImpl", 1, localStringBuilder.toString());
      if ((paramChannelMsgEvent != null) && (this.mChannelMsgEventMap != null) && (this.mChannelMsgEventMap.get(paramChannelMsgEvent.channelId) != null) && (((List)this.mChannelMsgEventMap.get(paramChannelMsgEvent.channelId)).contains(paramChannelMsgEvent)))
      {
        ThreadManager.excute(new GuildMessageBoxDataServiceImpl.2(this, paramChannelMsgEvent), 32, null, true);
        ((List)this.mChannelMsgEventMap.get(paramChannelMsgEvent.channelId)).remove(paramChannelMsgEvent);
        return;
      }
      paramChannelMsgEvent = new StringBuilder();
      paramChannelMsgEvent.append("removeChannelMsgBoxReadEvent, mChannelMsgEventMap: ");
      paramChannelMsgEvent.append(this.mChannelMsgEventMap);
      QLog.d("GuildMessageBoxDataServiceImpl", 1, paramChannelMsgEvent.toString());
      return;
    }
    finally {}
  }
  
  public boolean setMessageBoxCookie(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setMessageBoxCookie, cookie = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("GuildMessageBoxDataServiceImpl", 1, ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    localObject = this.mApp.getCurrentUin();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return false;
    }
    this.mApp.getApp().getSharedPreferences("guildMsgBoxSP", 0).edit().putString((String)localObject, paramString).commit();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.GuildMessageBoxDataServiceImpl
 * JD-Core Version:    0.7.0.1
 */