package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class MessageForTroopGift
  extends MessageForDeliverGiftTips
{
  public String comefrom = "";
  public int giftPicId;
  public String giftUrl = "";
  public boolean isLoading = false;
  public boolean isReported = false;
  public String message = "";
  public String title = "";
  
  private String getNotNullString(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private void readExternal(ObjectInput paramObjectInput)
  {
    this.animationPackageId = paramObjectInput.readInt();
    this.remindBrief = paramObjectInput.readUTF();
    this.animationBrief = paramObjectInput.readUTF();
    this.giftCount = paramObjectInput.readInt();
    this.senderUin = paramObjectInput.readLong();
    this.receiverUin = paramObjectInput.readLong();
    this.title = paramObjectInput.readUTF();
    this.subtitle = paramObjectInput.readUTF();
    this.message = paramObjectInput.readUTF();
    this.giftPicId = paramObjectInput.readInt();
    this.comefrom = paramObjectInput.readUTF();
    this.exflag = paramObjectInput.readInt();
    this.isReported = paramObjectInput.readBoolean();
    this.summary = paramObjectInput.readUTF();
    this.jumpUrl = paramObjectInput.readUTF();
    this.isFromNearby = paramObjectInput.readBoolean();
    this.sendScore = paramObjectInput.readInt();
    this.recvScore = paramObjectInput.readInt();
    this.charmHeroism = paramObjectInput.readUTF();
    this.btFlag = paramObjectInput.readInt();
    this.objColor = paramObjectInput.readInt();
    this.senderName = paramObjectInput.readUTF();
    try
    {
      this.version = paramObjectInput.readInt();
      if (this.version < 1) {
        return;
      }
      this.bagId = paramObjectInput.readUTF();
      if (this.version < 2) {
        return;
      }
      this.animationType = paramObjectInput.readInt();
      this.interactId = paramObjectInput.readUTF();
      this.interactState = paramObjectInput.readInt();
      this.alreadyPlayMicroseconds = paramObjectInput.readLong();
      this.playTotalMicroseconds = paramObjectInput.readLong();
      this.interactText = paramObjectInput.readUTF();
      this.participateNum = paramObjectInput.readInt();
      this.interactFirstUin = paramObjectInput.readLong();
      this.interactFirstNickname = paramObjectInput.readUTF();
      this.interacEndtUrl = paramObjectInput.readUTF();
      this.receiverHead = paramObjectInput.readUTF();
      this.receiverName = paramObjectInput.readUTF();
      this.is_activity_gift = paramObjectInput.readInt();
      this.activity_text = paramObjectInput.readUTF();
      this.activity_text_color = paramObjectInput.readUTF();
      this.activity_url = paramObjectInput.readUTF();
      this.animationPackageUrl = paramObjectInput.readUTF();
      return;
    }
    catch (IOException paramObjectInput)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.send_gift", 2, "readExternal error.", paramObjectInput);
      }
    }
  }
  
  private void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.animationPackageId);
    paramObjectOutput.writeUTF(getNotNullString(this.remindBrief));
    paramObjectOutput.writeUTF(getNotNullString(this.animationBrief));
    paramObjectOutput.writeInt(this.giftCount);
    paramObjectOutput.writeLong(this.senderUin);
    paramObjectOutput.writeLong(this.receiverUin);
    paramObjectOutput.writeUTF(getNotNullString(this.title));
    paramObjectOutput.writeUTF(getNotNullString(this.subtitle));
    paramObjectOutput.writeUTF(getNotNullString(this.message));
    paramObjectOutput.writeInt(this.giftPicId);
    paramObjectOutput.writeUTF(getNotNullString(this.comefrom));
    paramObjectOutput.writeInt(this.exflag);
    paramObjectOutput.writeBoolean(this.isReported);
    paramObjectOutput.writeUTF(getNotNullString(this.summary));
    paramObjectOutput.writeUTF(getNotNullString(this.jumpUrl));
    paramObjectOutput.writeBoolean(this.isFromNearby);
    paramObjectOutput.writeInt(this.sendScore);
    paramObjectOutput.writeInt(this.recvScore);
    paramObjectOutput.writeUTF(getNotNullString(this.charmHeroism));
    paramObjectOutput.writeInt(this.btFlag);
    paramObjectOutput.writeInt(this.objColor);
    paramObjectOutput.writeUTF(getNotNullString(this.senderName));
    paramObjectOutput.writeInt(2);
    paramObjectOutput.writeUTF(getNotNullString(this.bagId));
    paramObjectOutput.writeInt(this.animationType);
    paramObjectOutput.writeUTF(getNotNullString(this.interactId));
    paramObjectOutput.writeInt(this.interactState);
    paramObjectOutput.writeLong(this.alreadyPlayMicroseconds);
    paramObjectOutput.writeLong(this.playTotalMicroseconds);
    paramObjectOutput.writeUTF(getNotNullString(this.interactText));
    paramObjectOutput.writeInt(this.participateNum);
    paramObjectOutput.writeLong(this.interactFirstUin);
    paramObjectOutput.writeUTF(getNotNullString(this.interactFirstNickname));
    paramObjectOutput.writeUTF(getNotNullString(this.interacEndtUrl));
    paramObjectOutput.writeUTF(getNotNullString(this.receiverHead));
    paramObjectOutput.writeUTF(getNotNullString(this.receiverName));
    paramObjectOutput.writeInt(this.is_activity_gift);
    paramObjectOutput.writeUTF(getNotNullString(this.activity_text));
    paramObjectOutput.writeUTF(getNotNullString(this.activity_text_color));
    paramObjectOutput.writeUTF(getNotNullString(this.activity_url));
    paramObjectOutput.writeUTF(getNotNullString(this.animationPackageUrl));
  }
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 209	com/tencent/mobileqq/data/MessageForTroopGift:msg	Ljava/lang/String;
    //   4: invokestatic 215	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +9 -> 16
    //   10: aload_0
    //   11: iconst_1
    //   12: putfield 218	com/tencent/mobileqq/data/MessageForTroopGift:mIsParsed	Z
    //   15: return
    //   16: aconst_null
    //   17: astore 4
    //   19: aconst_null
    //   20: astore_1
    //   21: new 220	java/io/ObjectInputStream
    //   24: dup
    //   25: new 222	java/io/ByteArrayInputStream
    //   28: dup
    //   29: aload_0
    //   30: getfield 226	com/tencent/mobileqq/data/MessageForTroopGift:msgData	[B
    //   33: invokespecial 229	java/io/ByteArrayInputStream:<init>	([B)V
    //   36: invokespecial 232	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   39: astore_2
    //   40: aload_0
    //   41: aload_2
    //   42: invokespecial 234	com/tencent/mobileqq/data/MessageForTroopGift:readExternal	(Ljava/io/ObjectInput;)V
    //   45: aload_0
    //   46: aload_0
    //   47: getfield 87	com/tencent/mobileqq/data/MessageForTroopGift:summary	Ljava/lang/String;
    //   50: putfield 209	com/tencent/mobileqq/data/MessageForTroopGift:msg	Ljava/lang/String;
    //   53: aload_2
    //   54: invokevirtual 237	java/io/ObjectInputStream:close	()V
    //   57: return
    //   58: astore_1
    //   59: goto +55 -> 114
    //   62: astore_1
    //   63: aload_1
    //   64: astore_3
    //   65: goto +15 -> 80
    //   68: astore_3
    //   69: aload_1
    //   70: astore_2
    //   71: aload_3
    //   72: astore_1
    //   73: goto +41 -> 114
    //   76: astore_3
    //   77: aload 4
    //   79: astore_2
    //   80: aload_2
    //   81: astore_1
    //   82: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +14 -> 99
    //   88: aload_2
    //   89: astore_1
    //   90: ldc 175
    //   92: iconst_2
    //   93: ldc 239
    //   95: aload_3
    //   96: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   99: aload_2
    //   100: ifnull +13 -> 113
    //   103: aload_2
    //   104: invokevirtual 237	java/io/ObjectInputStream:close	()V
    //   107: return
    //   108: astore_1
    //   109: aload_1
    //   110: invokevirtual 242	java/lang/Exception:printStackTrace	()V
    //   113: return
    //   114: aload_2
    //   115: ifnull +15 -> 130
    //   118: aload_2
    //   119: invokevirtual 237	java/io/ObjectInputStream:close	()V
    //   122: goto +8 -> 130
    //   125: astore_2
    //   126: aload_2
    //   127: invokevirtual 242	java/lang/Exception:printStackTrace	()V
    //   130: aload_1
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	MessageForTroopGift
    //   20	1	1	localObject1	java.lang.Object
    //   58	1	1	localObject2	java.lang.Object
    //   62	8	1	localIOException1	IOException
    //   72	18	1	localObject3	java.lang.Object
    //   108	23	1	localException1	java.lang.Exception
    //   39	80	2	localObject4	java.lang.Object
    //   125	2	2	localException2	java.lang.Exception
    //   64	1	3	localIOException2	IOException
    //   68	4	3	localObject5	java.lang.Object
    //   76	20	3	localIOException3	IOException
    //   17	61	4	localObject6	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   40	53	58	finally
    //   40	53	62	java/io/IOException
    //   21	40	68	finally
    //   82	88	68	finally
    //   90	99	68	finally
    //   21	40	76	java/io/IOException
    //   53	57	108	java/lang/Exception
    //   103	107	108	java/lang/Exception
    //   118	122	125	java/lang/Exception
  }
  
  public String getSummaryMsg()
  {
    return this.summary;
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public String makeGiftIconUrl()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("makeGiftIconUrl--giftUrl=");
      localStringBuilder.append(this.giftUrl);
      QLog.d(".troop.send_gift", 2, localStringBuilder.toString(), null);
    }
    if (TextUtils.isEmpty(this.giftUrl))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://pub.idqqimg.com/pc/misc/groupgift/objicon_");
      localStringBuilder.append(this.giftPicId);
      localStringBuilder.append(".png");
      return localStringBuilder.toString();
    }
    return this.giftUrl;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  /* Error */
  public void prewrite()
  {
    // Byte code:
    //   0: new 271	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 272	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 274	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 277	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: aload_2
    //   23: invokespecial 279	com/tencent/mobileqq/data/MessageForTroopGift:writeExternal	(Ljava/io/ObjectOutput;)V
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: invokevirtual 280	java/io/ObjectOutputStream:close	()V
    //   32: aload_2
    //   33: astore_1
    //   34: aload_0
    //   35: aload 4
    //   37: invokevirtual 284	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   40: putfield 226	com/tencent/mobileqq/data/MessageForTroopGift:msgData	[B
    //   43: aload_2
    //   44: invokevirtual 280	java/io/ObjectOutputStream:close	()V
    //   47: goto +20 -> 67
    //   50: astore_1
    //   51: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +13 -> 67
    //   57: ldc 175
    //   59: iconst_2
    //   60: ldc_w 286
    //   63: aload_1
    //   64: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   67: aload 4
    //   69: invokevirtual 287	java/io/ByteArrayOutputStream:close	()V
    //   72: return
    //   73: astore_1
    //   74: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq +91 -> 168
    //   80: ldc 175
    //   82: iconst_2
    //   83: ldc_w 286
    //   86: aload_1
    //   87: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   90: return
    //   91: astore_3
    //   92: goto +12 -> 104
    //   95: astore_1
    //   96: aconst_null
    //   97: astore_2
    //   98: goto +76 -> 174
    //   101: astore_3
    //   102: aconst_null
    //   103: astore_2
    //   104: aload_2
    //   105: astore_1
    //   106: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   109: ifeq +15 -> 124
    //   112: aload_2
    //   113: astore_1
    //   114: ldc 175
    //   116: iconst_2
    //   117: ldc_w 286
    //   120: aload_3
    //   121: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   124: aload_2
    //   125: ifnull +27 -> 152
    //   128: aload_2
    //   129: invokevirtual 280	java/io/ObjectOutputStream:close	()V
    //   132: goto +20 -> 152
    //   135: astore_1
    //   136: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq +13 -> 152
    //   142: ldc 175
    //   144: iconst_2
    //   145: ldc_w 286
    //   148: aload_1
    //   149: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   152: aload 4
    //   154: invokevirtual 287	java/io/ByteArrayOutputStream:close	()V
    //   157: return
    //   158: astore_1
    //   159: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq +6 -> 168
    //   165: goto -85 -> 80
    //   168: return
    //   169: astore_3
    //   170: aload_1
    //   171: astore_2
    //   172: aload_3
    //   173: astore_1
    //   174: aload_2
    //   175: ifnull +27 -> 202
    //   178: aload_2
    //   179: invokevirtual 280	java/io/ObjectOutputStream:close	()V
    //   182: goto +20 -> 202
    //   185: astore_2
    //   186: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq +13 -> 202
    //   192: ldc 175
    //   194: iconst_2
    //   195: ldc_w 286
    //   198: aload_2
    //   199: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   202: aload 4
    //   204: invokevirtual 287	java/io/ByteArrayOutputStream:close	()V
    //   207: goto +20 -> 227
    //   210: astore_2
    //   211: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq +13 -> 227
    //   217: ldc 175
    //   219: iconst_2
    //   220: ldc_w 286
    //   223: aload_2
    //   224: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   227: goto +5 -> 232
    //   230: aload_1
    //   231: athrow
    //   232: goto -2 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	this	MessageForTroopGift
    //   20	14	1	localObject1	java.lang.Object
    //   50	14	1	localException1	java.lang.Exception
    //   73	14	1	localException2	java.lang.Exception
    //   95	1	1	localObject2	java.lang.Object
    //   105	9	1	localObject3	java.lang.Object
    //   135	14	1	localException3	java.lang.Exception
    //   158	13	1	localException4	java.lang.Exception
    //   173	58	1	localObject4	java.lang.Object
    //   18	161	2	localObject5	java.lang.Object
    //   185	14	2	localException5	java.lang.Exception
    //   210	14	2	localException6	java.lang.Exception
    //   91	1	3	localIOException1	IOException
    //   101	20	3	localIOException2	IOException
    //   169	4	3	localObject6	java.lang.Object
    //   7	196	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   43	47	50	java/lang/Exception
    //   67	72	73	java/lang/Exception
    //   21	26	91	java/io/IOException
    //   28	32	91	java/io/IOException
    //   34	43	91	java/io/IOException
    //   9	19	95	finally
    //   9	19	101	java/io/IOException
    //   128	132	135	java/lang/Exception
    //   152	157	158	java/lang/Exception
    //   21	26	169	finally
    //   28	32	169	finally
    //   34	43	169	finally
    //   106	112	169	finally
    //   114	124	169	finally
    //   178	182	185	java/lang/Exception
    //   202	207	210	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTroopGift
 * JD-Core Version:    0.7.0.1
 */