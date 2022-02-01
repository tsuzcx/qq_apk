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
      if (this.version >= 2)
      {
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
    //   16: new 220	java/io/ObjectInputStream
    //   19: dup
    //   20: new 222	java/io/ByteArrayInputStream
    //   23: dup
    //   24: aload_0
    //   25: getfield 226	com/tencent/mobileqq/data/MessageForTroopGift:msgData	[B
    //   28: invokespecial 229	java/io/ByteArrayInputStream:<init>	([B)V
    //   31: invokespecial 232	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   34: astore_2
    //   35: aload_2
    //   36: astore_1
    //   37: aload_0
    //   38: aload_2
    //   39: invokespecial 234	com/tencent/mobileqq/data/MessageForTroopGift:readExternal	(Ljava/io/ObjectInput;)V
    //   42: aload_2
    //   43: astore_1
    //   44: aload_0
    //   45: aload_0
    //   46: getfield 87	com/tencent/mobileqq/data/MessageForTroopGift:summary	Ljava/lang/String;
    //   49: putfield 209	com/tencent/mobileqq/data/MessageForTroopGift:msg	Ljava/lang/String;
    //   52: aload_2
    //   53: ifnull -38 -> 15
    //   56: aload_2
    //   57: invokevirtual 237	java/io/ObjectInputStream:close	()V
    //   60: return
    //   61: astore_1
    //   62: aload_1
    //   63: invokevirtual 240	java/lang/Exception:printStackTrace	()V
    //   66: return
    //   67: astore_3
    //   68: aconst_null
    //   69: astore_2
    //   70: aload_2
    //   71: astore_1
    //   72: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +14 -> 89
    //   78: aload_2
    //   79: astore_1
    //   80: ldc 175
    //   82: iconst_2
    //   83: ldc 242
    //   85: aload_3
    //   86: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   89: aload_2
    //   90: ifnull -75 -> 15
    //   93: aload_2
    //   94: invokevirtual 237	java/io/ObjectInputStream:close	()V
    //   97: return
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 240	java/lang/Exception:printStackTrace	()V
    //   103: return
    //   104: astore_2
    //   105: aconst_null
    //   106: astore_1
    //   107: aload_1
    //   108: ifnull +7 -> 115
    //   111: aload_1
    //   112: invokevirtual 237	java/io/ObjectInputStream:close	()V
    //   115: aload_2
    //   116: athrow
    //   117: astore_1
    //   118: aload_1
    //   119: invokevirtual 240	java/lang/Exception:printStackTrace	()V
    //   122: goto -7 -> 115
    //   125: astore_2
    //   126: goto -19 -> 107
    //   129: astore_3
    //   130: goto -60 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	MessageForTroopGift
    //   36	8	1	localObjectInputStream1	java.io.ObjectInputStream
    //   61	2	1	localException1	java.lang.Exception
    //   71	9	1	localObjectInputStream2	java.io.ObjectInputStream
    //   98	2	1	localException2	java.lang.Exception
    //   106	6	1	localObject1	java.lang.Object
    //   117	2	1	localException3	java.lang.Exception
    //   34	60	2	localObjectInputStream3	java.io.ObjectInputStream
    //   104	12	2	localObject2	java.lang.Object
    //   125	1	2	localObject3	java.lang.Object
    //   67	19	3	localIOException1	IOException
    //   129	1	3	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   56	60	61	java/lang/Exception
    //   16	35	67	java/io/IOException
    //   93	97	98	java/lang/Exception
    //   16	35	104	finally
    //   111	115	117	java/lang/Exception
    //   37	42	125	finally
    //   44	52	125	finally
    //   72	78	125	finally
    //   80	89	125	finally
    //   37	42	129	java/io/IOException
    //   44	52	129	java/io/IOException
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
    if (QLog.isColorLevel()) {
      QLog.d(".troop.send_gift", 2, "makeGiftIconUrl--giftUrl=" + this.giftUrl, null);
    }
    if (TextUtils.isEmpty(this.giftUrl)) {
      return "https://pub.idqqimg.com/pc/misc/groupgift/objicon_" + this.giftPicId + ".png";
    }
    return this.giftUrl;
  }
  
  public void postRead()
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
    //   44: ifnull +7 -> 51
    //   47: aload_2
    //   48: invokevirtual 280	java/io/ObjectOutputStream:close	()V
    //   51: aload 4
    //   53: ifnull +8 -> 61
    //   56: aload 4
    //   58: invokevirtual 285	java/io/ByteArrayOutputStream:close	()V
    //   61: return
    //   62: astore_1
    //   63: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq -15 -> 51
    //   69: ldc 175
    //   71: iconst_2
    //   72: ldc_w 287
    //   75: aload_1
    //   76: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   79: goto -28 -> 51
    //   82: astore_1
    //   83: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq -25 -> 61
    //   89: ldc 175
    //   91: iconst_2
    //   92: ldc_w 287
    //   95: aload_1
    //   96: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   99: return
    //   100: astore_3
    //   101: aconst_null
    //   102: astore_2
    //   103: aload_2
    //   104: astore_1
    //   105: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +15 -> 123
    //   111: aload_2
    //   112: astore_1
    //   113: ldc 175
    //   115: iconst_2
    //   116: ldc_w 287
    //   119: aload_3
    //   120: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   123: aload_2
    //   124: ifnull +7 -> 131
    //   127: aload_2
    //   128: invokevirtual 280	java/io/ObjectOutputStream:close	()V
    //   131: aload 4
    //   133: ifnull -72 -> 61
    //   136: aload 4
    //   138: invokevirtual 285	java/io/ByteArrayOutputStream:close	()V
    //   141: return
    //   142: astore_1
    //   143: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq -85 -> 61
    //   149: ldc 175
    //   151: iconst_2
    //   152: ldc_w 287
    //   155: aload_1
    //   156: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   159: return
    //   160: astore_1
    //   161: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   164: ifeq -33 -> 131
    //   167: ldc 175
    //   169: iconst_2
    //   170: ldc_w 287
    //   173: aload_1
    //   174: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   177: goto -46 -> 131
    //   180: astore_2
    //   181: aconst_null
    //   182: astore_1
    //   183: aload_1
    //   184: ifnull +7 -> 191
    //   187: aload_1
    //   188: invokevirtual 280	java/io/ObjectOutputStream:close	()V
    //   191: aload 4
    //   193: ifnull +8 -> 201
    //   196: aload 4
    //   198: invokevirtual 285	java/io/ByteArrayOutputStream:close	()V
    //   201: aload_2
    //   202: athrow
    //   203: astore_1
    //   204: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq -16 -> 191
    //   210: ldc 175
    //   212: iconst_2
    //   213: ldc_w 287
    //   216: aload_1
    //   217: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   220: goto -29 -> 191
    //   223: astore_1
    //   224: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq -26 -> 201
    //   230: ldc 175
    //   232: iconst_2
    //   233: ldc_w 287
    //   236: aload_1
    //   237: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   240: goto -39 -> 201
    //   243: astore_2
    //   244: goto -61 -> 183
    //   247: astore_3
    //   248: goto -145 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	MessageForTroopGift
    //   20	14	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   62	14	1	localException1	java.lang.Exception
    //   82	14	1	localException2	java.lang.Exception
    //   104	9	1	localObjectOutputStream2	java.io.ObjectOutputStream
    //   142	14	1	localException3	java.lang.Exception
    //   160	14	1	localException4	java.lang.Exception
    //   182	6	1	localObject1	java.lang.Object
    //   203	14	1	localException5	java.lang.Exception
    //   223	14	1	localException6	java.lang.Exception
    //   18	110	2	localObjectOutputStream3	java.io.ObjectOutputStream
    //   180	22	2	localObject2	java.lang.Object
    //   243	1	2	localObject3	java.lang.Object
    //   100	20	3	localIOException1	IOException
    //   247	1	3	localIOException2	IOException
    //   7	190	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   47	51	62	java/lang/Exception
    //   56	61	82	java/lang/Exception
    //   9	19	100	java/io/IOException
    //   136	141	142	java/lang/Exception
    //   127	131	160	java/lang/Exception
    //   9	19	180	finally
    //   187	191	203	java/lang/Exception
    //   196	201	223	java/lang/Exception
    //   21	26	243	finally
    //   28	32	243	finally
    //   34	43	243	finally
    //   105	111	243	finally
    //   113	123	243	finally
    //   21	26	247	java/io/IOException
    //   28	32	247	java/io/IOException
    //   34	43	247	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTroopGift
 * JD-Core Version:    0.7.0.1
 */