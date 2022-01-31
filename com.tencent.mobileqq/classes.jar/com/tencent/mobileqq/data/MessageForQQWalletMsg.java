package com.tencent.mobileqq.data;

import aipw;
import aizl;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.HashMap;
import mqq.app.AppRuntime;
import msf.msgcomm.msg_comm.DiscussInfo;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;

public class MessageForQQWalletMsg
  extends ChatMessage
{
  public static final int MSG_TYPE_AA_PAY = 16;
  public static final int MSG_TYPE_COMMAND_REDPACKET = 6;
  public static final int MSG_TYPE_COMMON_REDPACKET = 2;
  public static final int MSG_TYPE_COMMON_REDPACKET_SPECIFY = 7;
  public static final int MSG_TYPE_COMMON_REDPACKET_SPECIFY_OVER_3 = 11;
  public static final int MSG_TYPE_COMMON_THEME_REDPACKET = 4;
  public static final int MSG_TYPE_DRAW_REDPACKET = 22;
  public static final int MSG_TYPE_EMOJI_REDPACKET = 19;
  public static final int MSG_TYPE_GOLD_REDPACKET = 23;
  public static final int MSG_TYPE_H5_COMMON_REDPACKET = 20;
  public static final int MSG_TYPE_H5_REDPACKET = 17;
  public static final int MSG_TYPE_IDIOM_SOLITAIRE = 21;
  public static final int MSG_TYPE_INDIVIDUAL_REDPACKET = 2001;
  public static final int MSG_TYPE_KSONG_REDPACKET = 18;
  public static final int MSG_TYPE_LOOK_REDPACKET = 14;
  public static final int MSG_TYPE_LUCY_REDPACKET = 3;
  public static final int MSG_TYPE_LUCY_REDPACKET_SPECIFY = 8;
  public static final int MSG_TYPE_LUCY_REDPACKET_SPECIFY_OVER_3 = 12;
  public static final int MSG_TYPE_LUCY_THEME_REDPACKET = 5;
  public static final int MSG_TYPE_PAYER = 9;
  public static final int MSG_TYPE_PAYER_NOTIFY = 10;
  public static final int MSG_TYPE_PUBLIC_ACCOUNT_REDPACKET = 2002;
  public static final int MSG_TYPE_TRANSFER = 1;
  public static final int MSG_TYPE_VOICE_COMMAND_REDPACKET = 13;
  public static final int MSG_TYPE_VOICE_COMMAND_REDPACKET_C2C = 15;
  public static final int MSG_TYPE_WORDCHAIN = 24;
  private static int QQWALLET_TYPE_REDPACKET;
  private static int QQWALLET_TYPE_TRANSFER = 1;
  private static int SUBVERSION_REDPACKET = 2;
  private static int SUBVERSION_TRANSFER;
  private static int VERSION1;
  private static int VERSION17;
  private static int VERSION2;
  private static int VERSION32;
  public static int[] mMsgType = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 2002, 17, 18, 19, 20, 21, 22, 23, 24 };
  public int fromHBList;
  public boolean isLoadFinish;
  public QQWalletRedPacketMsg mQQWalletRedPacketMsg;
  public QQWalletTransferMsg mQQWalletTransferMsg;
  public int messageType;
  public Bitmap specifyIcon;
  
  static
  {
    QQWALLET_TYPE_REDPACKET = 2;
    VERSION1 = 1;
    VERSION2 = 2;
    VERSION17 = 17;
    VERSION32 = 32;
    SUBVERSION_TRANSFER = 4;
  }
  
  public MessageForQQWalletMsg() {}
  
  public MessageForQQWalletMsg(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5)
  {
    init(paramLong1, paramLong2, paramLong3, "[QQWallet Msg]", paramLong4, -2025, paramInt, paramLong5);
  }
  
  public static boolean isCommandRedPacketMsg(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForQQWalletMsg)) && (((MessageForQQWalletMsg)paramMessageRecord).messageType == 6);
  }
  
  public static boolean isRedPacketMsg(MessageRecord paramMessageRecord)
  {
    boolean bool1 = true;
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForQQWalletMsg)))
    {
      MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramMessageRecord;
      Object localObject = null;
      if ((localMessageForQQWalletMsg.mQQWalletTransferMsg != null) && (localMessageForQQWalletMsg.mQQWalletTransferMsg.elem != null))
      {
        localMessageForQQWalletMsg.parse();
        paramMessageRecord = localMessageForQQWalletMsg.mQQWalletTransferMsg.elem;
      }
      boolean bool2;
      while (paramMessageRecord == null)
      {
        bool2 = false;
        return bool2;
        paramMessageRecord = localObject;
        if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg != null)
        {
          paramMessageRecord = localObject;
          if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null) {
            return true;
          }
        }
      }
      paramMessageRecord = paramMessageRecord.nativeAndroid;
      if (TextUtils.isEmpty(paramMessageRecord)) {
        return false;
      }
      paramMessageRecord = paramMessageRecord.split("\\?");
      if ((!TextUtils.isEmpty(paramMessageRecord[0])) && (paramMessageRecord[0].equals("red"))) {}
      for (;;)
      {
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MessageForQQWaletMsg", 2, "isRedPacketMsg : " + bool1);
        return bool1;
        bool1 = false;
      }
    }
    return false;
  }
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: new 188	java/io/ObjectInputStream
    //   3: dup
    //   4: new 190	java/io/ByteArrayInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 194	com/tencent/mobileqq/data/MessageForQQWalletMsg:msgData	[B
    //   12: invokespecial 197	java/io/ByteArrayInputStream:<init>	([B)V
    //   15: invokespecial 200	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore 4
    //   20: aload 4
    //   22: astore_3
    //   23: aload 4
    //   25: invokevirtual 204	java/io/ObjectInputStream:readInt	()I
    //   28: istore_1
    //   29: aload 4
    //   31: astore_3
    //   32: iload_1
    //   33: getstatic 85	com/tencent/mobileqq/data/MessageForQQWalletMsg:VERSION1	I
    //   36: if_icmpeq +13 -> 49
    //   39: aload 4
    //   41: astore_3
    //   42: iload_1
    //   43: getstatic 87	com/tencent/mobileqq/data/MessageForQQWalletMsg:VERSION2	I
    //   46: if_icmpne +55 -> 101
    //   49: aload 4
    //   51: astore_3
    //   52: aload 4
    //   54: invokevirtual 204	java/io/ObjectInputStream:readInt	()I
    //   57: getstatic 81	com/tencent/mobileqq/data/MessageForQQWalletMsg:QQWALLET_TYPE_TRANSFER	I
    //   60: if_icmpne +30 -> 90
    //   63: aload 4
    //   65: astore_3
    //   66: aload_0
    //   67: new 117	com/tencent/mobileqq/data/QQWalletTransferMsg
    //   70: dup
    //   71: invokespecial 205	com/tencent/mobileqq/data/QQWalletTransferMsg:<init>	()V
    //   74: putfield 115	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   77: aload 4
    //   79: astore_3
    //   80: aload_0
    //   81: getfield 115	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   84: iload_1
    //   85: aload 4
    //   87: invokevirtual 209	com/tencent/mobileqq/data/QQWalletTransferMsg:readExternal	(ILjava/io/ObjectInput;)V
    //   90: aload 4
    //   92: ifnull +8 -> 100
    //   95: aload 4
    //   97: invokevirtual 212	java/io/ObjectInputStream:close	()V
    //   100: return
    //   101: aload 4
    //   103: astore_3
    //   104: iload_1
    //   105: getstatic 89	com/tencent/mobileqq/data/MessageForQQWalletMsg:VERSION17	I
    //   108: if_icmpne +89 -> 197
    //   111: aload 4
    //   113: astore_3
    //   114: aload_0
    //   115: new 128	com/tencent/mobileqq/data/QQWalletRedPacketMsg
    //   118: dup
    //   119: invokespecial 213	com/tencent/mobileqq/data/QQWalletRedPacketMsg:<init>	()V
    //   122: putfield 126	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   125: aload 4
    //   127: astore_3
    //   128: aload_0
    //   129: getfield 126	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   132: aload 4
    //   134: invokevirtual 216	com/tencent/mobileqq/data/QQWalletRedPacketMsg:readExternal	(Ljava/io/ObjectInput;)V
    //   137: goto -47 -> 90
    //   140: astore 5
    //   142: aload 4
    //   144: astore_3
    //   145: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq +16 -> 164
    //   151: aload 4
    //   153: astore_3
    //   154: ldc 218
    //   156: iconst_2
    //   157: ldc 220
    //   159: aload 5
    //   161: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   164: aload 4
    //   166: astore_3
    //   167: aload_0
    //   168: aconst_null
    //   169: putfield 115	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   172: aload 4
    //   174: astore_3
    //   175: aload_0
    //   176: aconst_null
    //   177: putfield 126	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   180: aload 4
    //   182: ifnull -82 -> 100
    //   185: aload 4
    //   187: invokevirtual 212	java/io/ObjectInputStream:close	()V
    //   190: return
    //   191: astore_3
    //   192: aload_3
    //   193: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   196: return
    //   197: aload 4
    //   199: astore_3
    //   200: iload_1
    //   201: getstatic 91	com/tencent/mobileqq/data/MessageForQQWalletMsg:VERSION32	I
    //   204: if_icmplt -114 -> 90
    //   207: aload 4
    //   209: astore_3
    //   210: aload 4
    //   212: invokevirtual 204	java/io/ObjectInputStream:readInt	()I
    //   215: istore_1
    //   216: aload 4
    //   218: astore_3
    //   219: aload 4
    //   221: invokevirtual 204	java/io/ObjectInputStream:readInt	()I
    //   224: istore_2
    //   225: aload 4
    //   227: astore_3
    //   228: aload_0
    //   229: aload 4
    //   231: invokevirtual 204	java/io/ObjectInputStream:readInt	()I
    //   234: putfield 112	com/tencent/mobileqq/data/MessageForQQWalletMsg:messageType	I
    //   237: aload 4
    //   239: astore_3
    //   240: iload_1
    //   241: getstatic 81	com/tencent/mobileqq/data/MessageForQQWalletMsg:QQWALLET_TYPE_TRANSFER	I
    //   244: if_icmpne +53 -> 297
    //   247: aload 4
    //   249: astore_3
    //   250: aload_0
    //   251: new 117	com/tencent/mobileqq/data/QQWalletTransferMsg
    //   254: dup
    //   255: invokespecial 205	com/tencent/mobileqq/data/QQWalletTransferMsg:<init>	()V
    //   258: putfield 115	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   261: aload 4
    //   263: astore_3
    //   264: aload_0
    //   265: getfield 115	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   268: iload_2
    //   269: aload 4
    //   271: invokevirtual 209	com/tencent/mobileqq/data/QQWalletTransferMsg:readExternal	(ILjava/io/ObjectInput;)V
    //   274: goto -184 -> 90
    //   277: astore 5
    //   279: aload_3
    //   280: astore 4
    //   282: aload 5
    //   284: astore_3
    //   285: aload 4
    //   287: ifnull +8 -> 295
    //   290: aload 4
    //   292: invokevirtual 212	java/io/ObjectInputStream:close	()V
    //   295: aload_3
    //   296: athrow
    //   297: aload 4
    //   299: astore_3
    //   300: iload_1
    //   301: getstatic 83	com/tencent/mobileqq/data/MessageForQQWalletMsg:QQWALLET_TYPE_REDPACKET	I
    //   304: if_icmpne -214 -> 90
    //   307: aload 4
    //   309: astore_3
    //   310: aload_0
    //   311: new 128	com/tencent/mobileqq/data/QQWalletRedPacketMsg
    //   314: dup
    //   315: invokespecial 213	com/tencent/mobileqq/data/QQWalletRedPacketMsg:<init>	()V
    //   318: putfield 126	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   321: aload 4
    //   323: astore_3
    //   324: aload_0
    //   325: getfield 126	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   328: aload 4
    //   330: invokevirtual 216	com/tencent/mobileqq/data/QQWalletRedPacketMsg:readExternal	(Ljava/io/ObjectInput;)V
    //   333: goto -243 -> 90
    //   336: astore_3
    //   337: aload_3
    //   338: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   341: return
    //   342: astore 4
    //   344: aload 4
    //   346: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   349: goto -54 -> 295
    //   352: astore_3
    //   353: aconst_null
    //   354: astore 4
    //   356: goto -71 -> 285
    //   359: astore 5
    //   361: aconst_null
    //   362: astore 4
    //   364: goto -222 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	MessageForQQWalletMsg
    //   28	277	1	i	int
    //   224	45	2	j	int
    //   22	153	3	localObject1	Object
    //   191	2	3	localException1	Exception
    //   199	125	3	localObject2	Object
    //   336	2	3	localException2	Exception
    //   352	1	3	localObject3	Object
    //   18	311	4	localObject4	Object
    //   342	3	4	localException3	Exception
    //   354	9	4	localObject5	Object
    //   140	20	5	localException4	Exception
    //   277	6	5	localObject6	Object
    //   359	1	5	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   23	29	140	java/lang/Exception
    //   32	39	140	java/lang/Exception
    //   42	49	140	java/lang/Exception
    //   52	63	140	java/lang/Exception
    //   66	77	140	java/lang/Exception
    //   80	90	140	java/lang/Exception
    //   104	111	140	java/lang/Exception
    //   114	125	140	java/lang/Exception
    //   128	137	140	java/lang/Exception
    //   200	207	140	java/lang/Exception
    //   210	216	140	java/lang/Exception
    //   219	225	140	java/lang/Exception
    //   228	237	140	java/lang/Exception
    //   240	247	140	java/lang/Exception
    //   250	261	140	java/lang/Exception
    //   264	274	140	java/lang/Exception
    //   300	307	140	java/lang/Exception
    //   310	321	140	java/lang/Exception
    //   324	333	140	java/lang/Exception
    //   185	190	191	java/lang/Exception
    //   23	29	277	finally
    //   32	39	277	finally
    //   42	49	277	finally
    //   52	63	277	finally
    //   66	77	277	finally
    //   80	90	277	finally
    //   104	111	277	finally
    //   114	125	277	finally
    //   128	137	277	finally
    //   145	151	277	finally
    //   154	164	277	finally
    //   167	172	277	finally
    //   175	180	277	finally
    //   200	207	277	finally
    //   210	216	277	finally
    //   219	225	277	finally
    //   228	237	277	finally
    //   240	247	277	finally
    //   250	261	277	finally
    //   264	274	277	finally
    //   300	307	277	finally
    //   310	321	277	finally
    //   324	333	277	finally
    //   95	100	336	java/lang/Exception
    //   290	295	342	java/lang/Exception
    //   0	20	352	finally
    //   0	20	359	java/lang/Exception
  }
  
  public byte[] getBytes()
  {
    prewrite();
    return this.msgData;
  }
  
  public int getIsHideTitleDefault()
  {
    if ((this.mQQWalletRedPacketMsg == null) || (this.mQQWalletRedPacketMsg.elem == null) || (this.mQQWalletRedPacketMsg.elem.skinId <= 0) || (this.messageType == 18) || (this.messageType == 17) || (this.messageType == 19) || (this.messageType == 21) || (this.messageType == 22) || (this.messageType == 23) || (this.messageType == 24)) {
      return 0;
    }
    return 1;
  }
  
  public String getMsgSummary()
  {
    if ((this.mQQWalletTransferMsg != null) && (this.mQQWalletTransferMsg.elem != null)) {
      return this.mQQWalletTransferMsg.elem.notice;
    }
    if ((this.mQQWalletRedPacketMsg != null) && (this.mQQWalletRedPacketMsg.elem != null)) {
      return this.mQQWalletRedPacketMsg.elem.notice;
    }
    return "";
  }
  
  public String getSummaryMsg()
  {
    return getMsgSummary();
  }
  
  public boolean isMsgEmpty()
  {
    if ((this.mQQWalletTransferMsg == null) && (this.mQQWalletRedPacketMsg == null)) {}
    while (this.msgData == null) {
      return true;
    }
    return false;
  }
  
  public boolean isRedPackExpired()
  {
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    return this.time + 90000L < l;
  }
  
  public boolean isSender()
  {
    return (this.senderuin != null) && (this.senderuin.equalsIgnoreCase(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public boolean needVipBubble()
  {
    return false;
  }
  
  public void onDecodeFinish(QQAppInterface paramQQAppInterface, msg_comm.Msg paramMsg)
  {
    int i = paramMsg.msg_head.msg_type.get();
    long l;
    if ((i == 82) || (i == 43)) {
      l = paramMsg.msg_head.group_info.group_code.get();
    }
    for (;;)
    {
      this.frienduin = String.valueOf(l);
      this.time = paramMsg.msg_head.msg_time.get();
      aizl.a(paramQQAppInterface, this);
      RedPacketEmojiFragment.a(paramQQAppInterface, this);
      return;
      if ((i == 83) || (i == 42)) {
        l = paramMsg.msg_head.discuss_info.discuss_uin.get();
      } else if (paramQQAppInterface.getCurrentAccountUin().equals(String.valueOf(paramMsg.msg_head.to_uin.get()))) {
        l = paramMsg.msg_head.from_uin.get();
      } else {
        l = paramMsg.msg_head.to_uin.get();
      }
    }
  }
  
  public HashMap<String, String> parseUrlParams(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("&");
      int i = 0;
      if (i < paramString.length)
      {
        if (TextUtils.isEmpty(paramString[i])) {}
        for (;;)
        {
          i += 1;
          break;
          String[] arrayOfString = paramString[i].split("=");
          if (arrayOfString.length == 2)
          {
            try
            {
              arrayOfString[1] = URLDecoder.decode(arrayOfString[1], "UTF-8");
              localHashMap.put(arrayOfString[0], arrayOfString[1]);
            }
            catch (Exception localException)
            {
              if (QLog.isDevelopLevel()) {
                localException.printStackTrace();
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.qqwalletmsg", 2, "QQWalletMsgItemBuilder failed to URLDecoder.decode WalletAction value,tmps[1] is:" + arrayOfString[0] + ",tmps[1] is:" + arrayOfString[1], localException);
            }
          }
        }
      }
    }
    return localHashMap;
  }
  
  public void postRead()
  {
    parse();
    try
    {
      ((aipw)BaseApplicationImpl.sApplication.getAppRuntime(this.selfuin).getManager(125)).a(true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.qqwalletmsg", 2, "postRead init read status");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  /* Error */
  public void prewrite()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: getfield 115	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   6: ifnull +220 -> 226
    //   9: new 417	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 418	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore 4
    //   18: new 420	java/io/ObjectOutputStream
    //   21: dup
    //   22: aload 4
    //   24: invokespecial 423	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore_2
    //   28: aload_2
    //   29: astore_1
    //   30: aload_2
    //   31: getstatic 91	com/tencent/mobileqq/data/MessageForQQWalletMsg:VERSION32	I
    //   34: invokevirtual 427	java/io/ObjectOutputStream:writeInt	(I)V
    //   37: aload_2
    //   38: astore_1
    //   39: aload_2
    //   40: getstatic 81	com/tencent/mobileqq/data/MessageForQQWalletMsg:QQWALLET_TYPE_TRANSFER	I
    //   43: invokevirtual 427	java/io/ObjectOutputStream:writeInt	(I)V
    //   46: aload_2
    //   47: astore_1
    //   48: aload_2
    //   49: getstatic 93	com/tencent/mobileqq/data/MessageForQQWalletMsg:SUBVERSION_TRANSFER	I
    //   52: invokevirtual 427	java/io/ObjectOutputStream:writeInt	(I)V
    //   55: aload_2
    //   56: astore_1
    //   57: aload_2
    //   58: aload_0
    //   59: getfield 112	com/tencent/mobileqq/data/MessageForQQWalletMsg:messageType	I
    //   62: invokevirtual 427	java/io/ObjectOutputStream:writeInt	(I)V
    //   65: aload_2
    //   66: astore_1
    //   67: aload_0
    //   68: getfield 115	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   71: aload_2
    //   72: invokevirtual 431	com/tencent/mobileqq/data/QQWalletTransferMsg:writeExternal	(Ljava/io/ObjectOutput;)V
    //   75: aload_2
    //   76: astore_1
    //   77: aload_2
    //   78: invokevirtual 432	java/io/ObjectOutputStream:close	()V
    //   81: aload_2
    //   82: astore_1
    //   83: aload_0
    //   84: aload 4
    //   86: invokevirtual 435	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   89: putfield 194	com/tencent/mobileqq/data/MessageForQQWalletMsg:msgData	[B
    //   92: aload_2
    //   93: ifnull +7 -> 100
    //   96: aload_2
    //   97: invokevirtual 432	java/io/ObjectOutputStream:close	()V
    //   100: aload 4
    //   102: ifnull +8 -> 110
    //   105: aload 4
    //   107: invokevirtual 436	java/io/ByteArrayOutputStream:close	()V
    //   110: return
    //   111: astore_1
    //   112: aload_1
    //   113: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   116: goto -16 -> 100
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   124: return
    //   125: astore_3
    //   126: aconst_null
    //   127: astore_2
    //   128: aload_2
    //   129: astore_1
    //   130: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +15 -> 148
    //   136: aload_2
    //   137: astore_1
    //   138: ldc 218
    //   140: iconst_2
    //   141: ldc_w 438
    //   144: aload_3
    //   145: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   148: aload_2
    //   149: astore_1
    //   150: aload_3
    //   151: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   154: aload_2
    //   155: ifnull +7 -> 162
    //   158: aload_2
    //   159: invokevirtual 432	java/io/ObjectOutputStream:close	()V
    //   162: aload 4
    //   164: ifnull -54 -> 110
    //   167: aload 4
    //   169: invokevirtual 436	java/io/ByteArrayOutputStream:close	()V
    //   172: return
    //   173: astore_1
    //   174: aload_1
    //   175: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   178: return
    //   179: astore_1
    //   180: aload_1
    //   181: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   184: goto -22 -> 162
    //   187: astore_2
    //   188: aconst_null
    //   189: astore_1
    //   190: aload_1
    //   191: ifnull +7 -> 198
    //   194: aload_1
    //   195: invokevirtual 432	java/io/ObjectOutputStream:close	()V
    //   198: aload 4
    //   200: ifnull +8 -> 208
    //   203: aload 4
    //   205: invokevirtual 436	java/io/ByteArrayOutputStream:close	()V
    //   208: aload_2
    //   209: athrow
    //   210: astore_1
    //   211: aload_1
    //   212: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   215: goto -17 -> 198
    //   218: astore_1
    //   219: aload_1
    //   220: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   223: goto -15 -> 208
    //   226: aload_0
    //   227: getfield 126	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   230: ifnull -120 -> 110
    //   233: new 417	java/io/ByteArrayOutputStream
    //   236: dup
    //   237: invokespecial 418	java/io/ByteArrayOutputStream:<init>	()V
    //   240: astore 4
    //   242: new 420	java/io/ObjectOutputStream
    //   245: dup
    //   246: aload 4
    //   248: invokespecial 423	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   251: astore_2
    //   252: aload_2
    //   253: getstatic 91	com/tencent/mobileqq/data/MessageForQQWalletMsg:VERSION32	I
    //   256: invokevirtual 427	java/io/ObjectOutputStream:writeInt	(I)V
    //   259: aload_2
    //   260: getstatic 83	com/tencent/mobileqq/data/MessageForQQWalletMsg:QQWALLET_TYPE_REDPACKET	I
    //   263: invokevirtual 427	java/io/ObjectOutputStream:writeInt	(I)V
    //   266: aload_2
    //   267: getstatic 95	com/tencent/mobileqq/data/MessageForQQWalletMsg:SUBVERSION_REDPACKET	I
    //   270: invokevirtual 427	java/io/ObjectOutputStream:writeInt	(I)V
    //   273: aload_2
    //   274: aload_0
    //   275: getfield 112	com/tencent/mobileqq/data/MessageForQQWalletMsg:messageType	I
    //   278: invokevirtual 427	java/io/ObjectOutputStream:writeInt	(I)V
    //   281: aload_0
    //   282: getfield 126	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   285: aload_2
    //   286: invokevirtual 439	com/tencent/mobileqq/data/QQWalletRedPacketMsg:writeExternal	(Ljava/io/ObjectOutput;)V
    //   289: aload_2
    //   290: invokevirtual 432	java/io/ObjectOutputStream:close	()V
    //   293: aload_0
    //   294: aload 4
    //   296: invokevirtual 435	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   299: putfield 194	com/tencent/mobileqq/data/MessageForQQWalletMsg:msgData	[B
    //   302: aload_2
    //   303: ifnull +7 -> 310
    //   306: aload_2
    //   307: invokevirtual 432	java/io/ObjectOutputStream:close	()V
    //   310: aload 4
    //   312: ifnull -202 -> 110
    //   315: aload 4
    //   317: invokevirtual 436	java/io/ByteArrayOutputStream:close	()V
    //   320: return
    //   321: astore_1
    //   322: aload_1
    //   323: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   326: return
    //   327: astore_1
    //   328: aload_1
    //   329: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   332: goto -22 -> 310
    //   335: astore_2
    //   336: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   339: ifeq +13 -> 352
    //   342: ldc 218
    //   344: iconst_2
    //   345: ldc_w 438
    //   348: aload_2
    //   349: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   352: aload_2
    //   353: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   356: aload_1
    //   357: ifnull +7 -> 364
    //   360: aload_1
    //   361: invokevirtual 432	java/io/ObjectOutputStream:close	()V
    //   364: aload 4
    //   366: ifnull -256 -> 110
    //   369: aload 4
    //   371: invokevirtual 436	java/io/ByteArrayOutputStream:close	()V
    //   374: return
    //   375: astore_1
    //   376: aload_1
    //   377: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   380: return
    //   381: astore_1
    //   382: aload_1
    //   383: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   386: goto -22 -> 364
    //   389: astore_1
    //   390: aconst_null
    //   391: astore_2
    //   392: aload_2
    //   393: ifnull +7 -> 400
    //   396: aload_2
    //   397: invokevirtual 432	java/io/ObjectOutputStream:close	()V
    //   400: aload 4
    //   402: ifnull +8 -> 410
    //   405: aload 4
    //   407: invokevirtual 436	java/io/ByteArrayOutputStream:close	()V
    //   410: aload_1
    //   411: athrow
    //   412: astore_2
    //   413: aload_2
    //   414: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   417: goto -17 -> 400
    //   420: astore_2
    //   421: aload_2
    //   422: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   425: goto -15 -> 410
    //   428: astore_1
    //   429: goto -37 -> 392
    //   432: astore_3
    //   433: aload_1
    //   434: astore_2
    //   435: aload_3
    //   436: astore_1
    //   437: goto -45 -> 392
    //   440: astore_3
    //   441: aload_2
    //   442: astore_1
    //   443: aload_3
    //   444: astore_2
    //   445: goto -109 -> 336
    //   448: astore_2
    //   449: goto -259 -> 190
    //   452: astore_3
    //   453: goto -325 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	this	MessageForQQWalletMsg
    //   1	82	1	localObject1	Object
    //   111	2	1	localException1	Exception
    //   119	2	1	localException2	Exception
    //   129	21	1	localObject2	Object
    //   173	2	1	localException3	Exception
    //   179	2	1	localException4	Exception
    //   189	6	1	localObject3	Object
    //   210	2	1	localException5	Exception
    //   218	2	1	localException6	Exception
    //   321	2	1	localException7	Exception
    //   327	34	1	localException8	Exception
    //   375	2	1	localException9	Exception
    //   381	2	1	localException10	Exception
    //   389	22	1	localObject4	Object
    //   428	6	1	localObject5	Object
    //   436	7	1	localObject6	Object
    //   27	132	2	localObjectOutputStream1	java.io.ObjectOutputStream
    //   187	22	2	localObject7	Object
    //   251	56	2	localObjectOutputStream2	java.io.ObjectOutputStream
    //   335	18	2	localException11	Exception
    //   391	6	2	localObject8	Object
    //   412	2	2	localException12	Exception
    //   420	2	2	localException13	Exception
    //   434	11	2	localObject9	Object
    //   448	1	2	localObject10	Object
    //   125	26	3	localException14	Exception
    //   432	4	3	localObject11	Object
    //   440	4	3	localException15	Exception
    //   452	1	3	localException16	Exception
    //   16	390	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   96	100	111	java/lang/Exception
    //   105	110	119	java/lang/Exception
    //   18	28	125	java/lang/Exception
    //   167	172	173	java/lang/Exception
    //   158	162	179	java/lang/Exception
    //   18	28	187	finally
    //   194	198	210	java/lang/Exception
    //   203	208	218	java/lang/Exception
    //   315	320	321	java/lang/Exception
    //   306	310	327	java/lang/Exception
    //   242	252	335	java/lang/Exception
    //   369	374	375	java/lang/Exception
    //   360	364	381	java/lang/Exception
    //   242	252	389	finally
    //   396	400	412	java/lang/Exception
    //   405	410	420	java/lang/Exception
    //   252	302	428	finally
    //   336	352	432	finally
    //   352	356	432	finally
    //   252	302	440	java/lang/Exception
    //   30	37	448	finally
    //   39	46	448	finally
    //   48	55	448	finally
    //   57	65	448	finally
    //   67	75	448	finally
    //   77	81	448	finally
    //   83	92	448	finally
    //   130	136	448	finally
    //   138	148	448	finally
    //   150	154	448	finally
    //   30	37	452	java/lang/Exception
    //   39	46	452	java/lang/Exception
    //   48	55	452	java/lang/Exception
    //   57	65	452	java/lang/Exception
    //   67	75	452	java/lang/Exception
    //   77	81	452	java/lang/Exception
    //   83	92	452	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQQWalletMsg
 * JD-Core Version:    0.7.0.1
 */