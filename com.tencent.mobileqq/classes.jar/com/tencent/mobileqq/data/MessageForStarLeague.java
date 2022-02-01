package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MessageForStarLeague
  extends ChatMessage
{
  public static final int LEVEL_STATUS_DOWN = 2;
  public static final int LEVEL_STATUS_UP = 1;
  public String actionUrl;
  public String brief;
  public int levelStatus;
  public String starAvatar;
  public String starName;
  public String subTitle;
  
  public static MessageForStarLeague decodeMsgFromXmlBuff(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong, byte[] paramArrayOfByte, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 2))
    {
      paramQQAppInterface = StructMsgUtils.a(paramArrayOfByte, paramInt2);
      try
      {
        paramQQAppInterface = StructMsgFactory.a(new String(paramQQAppInterface, "utf-8"));
        paramQQAppInterface = new ByteArrayInputStream(paramQQAppInterface.getBytes());
        paramArrayOfByte = new MessageForStarLeague.TroopStarLeagueHandler();
        SAXParserFactory localSAXParserFactory = SAXParserFactory.newInstance();
        try
        {
          localSAXParserFactory.newSAXParser().parse(paramQQAppInterface, paramArrayOfByte);
          paramQQAppInterface.close();
          paramQQAppInterface = paramArrayOfByte.a();
          return paramQQAppInterface;
        }
        catch (Exception paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.e(".troop.troop_fee", 2, "decode MessageForTroopFee for xml buff by stream", paramQQAppInterface);
          }
          return null;
        }
        if (!QLog.isColorLevel()) {
          break label125;
        }
      }
      catch (UnsupportedEncodingException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return null;
      }
    }
    else
    {
      QLog.d("StructMsg", 2, "decode MessageForTroopFee for xml buff by stream failed. xmlbuff is null or lenght<2");
    }
    label125:
    return null;
  }
  
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
    this.starName = paramObjectInput.readUTF();
    this.starAvatar = paramObjectInput.readUTF();
    this.subTitle = paramObjectInput.readUTF();
    this.actionUrl = paramObjectInput.readUTF();
    this.brief = paramObjectInput.readUTF();
    try
    {
      this.levelStatus = Integer.parseInt(paramObjectInput.readUTF());
      return;
    }
    catch (Exception paramObjectInput) {}
  }
  
  private void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(getNotNullString(this.starName));
    paramObjectOutput.writeUTF(getNotNullString(this.starAvatar));
    paramObjectOutput.writeUTF(getNotNullString(this.subTitle));
    paramObjectOutput.writeUTF(getNotNullString(this.actionUrl));
    paramObjectOutput.writeUTF(String.valueOf(getNotNullString(this.brief)));
    paramObjectOutput.writeUTF(String.valueOf(this.levelStatus));
  }
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_1
    //   5: new 157	java/io/ObjectInputStream
    //   8: dup
    //   9: new 47	java/io/ByteArrayInputStream
    //   12: dup
    //   13: aload_0
    //   14: getfield 161	com/tencent/mobileqq/data/MessageForStarLeague:msgData	[B
    //   17: invokespecial 54	java/io/ByteArrayInputStream:<init>	([B)V
    //   20: invokespecial 164	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   23: astore_2
    //   24: aload_0
    //   25: aload_2
    //   26: invokespecial 166	com/tencent/mobileqq/data/MessageForStarLeague:readExternal	(Ljava/io/ObjectInput;)V
    //   29: aload_0
    //   30: aload_0
    //   31: invokevirtual 169	com/tencent/mobileqq/data/MessageForStarLeague:getSummaryMsg	()Ljava/lang/String;
    //   34: putfield 172	com/tencent/mobileqq/data/MessageForStarLeague:msg	Ljava/lang/String;
    //   37: aload_2
    //   38: invokevirtual 173	java/io/ObjectInputStream:close	()V
    //   41: return
    //   42: astore_1
    //   43: goto +55 -> 98
    //   46: astore_1
    //   47: aload_1
    //   48: astore_3
    //   49: goto +15 -> 64
    //   52: astore_3
    //   53: aload_1
    //   54: astore_2
    //   55: aload_3
    //   56: astore_1
    //   57: goto +41 -> 98
    //   60: astore_3
    //   61: aload 4
    //   63: astore_2
    //   64: aload_2
    //   65: astore_1
    //   66: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +14 -> 83
    //   72: aload_2
    //   73: astore_1
    //   74: ldc 175
    //   76: iconst_2
    //   77: ldc 177
    //   79: aload_3
    //   80: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   83: aload_2
    //   84: ifnull +13 -> 97
    //   87: aload_2
    //   88: invokevirtual 173	java/io/ObjectInputStream:close	()V
    //   91: return
    //   92: astore_1
    //   93: aload_1
    //   94: invokevirtual 180	java/lang/Exception:printStackTrace	()V
    //   97: return
    //   98: aload_2
    //   99: ifnull +15 -> 114
    //   102: aload_2
    //   103: invokevirtual 173	java/io/ObjectInputStream:close	()V
    //   106: goto +8 -> 114
    //   109: astore_2
    //   110: aload_2
    //   111: invokevirtual 180	java/lang/Exception:printStackTrace	()V
    //   114: aload_1
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	MessageForStarLeague
    //   4	1	1	localObject1	java.lang.Object
    //   42	1	1	localObject2	java.lang.Object
    //   46	8	1	localIOException1	java.io.IOException
    //   56	18	1	localObject3	java.lang.Object
    //   92	23	1	localException1	Exception
    //   23	80	2	localObject4	java.lang.Object
    //   109	2	2	localException2	Exception
    //   48	1	3	localIOException2	java.io.IOException
    //   52	4	3	localObject5	java.lang.Object
    //   60	20	3	localIOException3	java.io.IOException
    //   1	61	4	localObject6	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   24	37	42	finally
    //   24	37	46	java/io/IOException
    //   5	24	52	finally
    //   66	72	52	finally
    //   74	83	52	finally
    //   5	24	60	java/io/IOException
    //   37	41	92	java/lang/Exception
    //   87	91	92	java/lang/Exception
    //   102	106	109	java/lang/Exception
  }
  
  public byte[] getBytes()
  {
    prewrite();
    return this.msgData;
  }
  
  public String getSummaryMsg()
  {
    if (!TextUtils.isEmpty(this.brief)) {
      return this.brief;
    }
    return this.subTitle;
  }
  
  protected void postRead()
  {
    super.parse();
  }
  
  /* Error */
  protected void prewrite()
  {
    // Byte code:
    //   0: new 194	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 195	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 197	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 200	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: aload_2
    //   23: invokespecial 202	com/tencent/mobileqq/data/MessageForStarLeague:writeExternal	(Ljava/io/ObjectOutput;)V
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: invokevirtual 203	java/io/ObjectOutputStream:close	()V
    //   32: aload_2
    //   33: astore_1
    //   34: aload_0
    //   35: aload 4
    //   37: invokevirtual 206	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   40: putfield 161	com/tencent/mobileqq/data/MessageForStarLeague:msgData	[B
    //   43: aload_2
    //   44: invokevirtual 203	java/io/ObjectOutputStream:close	()V
    //   47: goto +19 -> 66
    //   50: astore_1
    //   51: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +12 -> 66
    //   57: ldc 175
    //   59: iconst_2
    //   60: ldc 208
    //   62: aload_1
    //   63: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   66: aload 4
    //   68: invokevirtual 209	java/io/ByteArrayOutputStream:close	()V
    //   71: return
    //   72: astore_1
    //   73: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq +88 -> 164
    //   79: ldc 175
    //   81: iconst_2
    //   82: ldc 208
    //   84: aload_1
    //   85: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   88: return
    //   89: astore_3
    //   90: goto +12 -> 102
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_2
    //   96: goto +74 -> 170
    //   99: astore_3
    //   100: aconst_null
    //   101: astore_2
    //   102: aload_2
    //   103: astore_1
    //   104: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq +14 -> 121
    //   110: aload_2
    //   111: astore_1
    //   112: ldc 175
    //   114: iconst_2
    //   115: ldc 208
    //   117: aload_3
    //   118: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   121: aload_2
    //   122: ifnull +26 -> 148
    //   125: aload_2
    //   126: invokevirtual 203	java/io/ObjectOutputStream:close	()V
    //   129: goto +19 -> 148
    //   132: astore_1
    //   133: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq +12 -> 148
    //   139: ldc 175
    //   141: iconst_2
    //   142: ldc 208
    //   144: aload_1
    //   145: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   148: aload 4
    //   150: invokevirtual 209	java/io/ByteArrayOutputStream:close	()V
    //   153: return
    //   154: astore_1
    //   155: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +6 -> 164
    //   161: goto -82 -> 79
    //   164: return
    //   165: astore_3
    //   166: aload_1
    //   167: astore_2
    //   168: aload_3
    //   169: astore_1
    //   170: aload_2
    //   171: ifnull +26 -> 197
    //   174: aload_2
    //   175: invokevirtual 203	java/io/ObjectOutputStream:close	()V
    //   178: goto +19 -> 197
    //   181: astore_2
    //   182: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq +12 -> 197
    //   188: ldc 175
    //   190: iconst_2
    //   191: ldc 208
    //   193: aload_2
    //   194: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   197: aload 4
    //   199: invokevirtual 209	java/io/ByteArrayOutputStream:close	()V
    //   202: goto +19 -> 221
    //   205: astore_2
    //   206: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq +12 -> 221
    //   212: ldc 175
    //   214: iconst_2
    //   215: ldc 208
    //   217: aload_2
    //   218: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   221: goto +5 -> 226
    //   224: aload_1
    //   225: athrow
    //   226: goto -2 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	MessageForStarLeague
    //   20	14	1	localObject1	java.lang.Object
    //   50	13	1	localException1	Exception
    //   72	13	1	localException2	Exception
    //   93	1	1	localObject2	java.lang.Object
    //   103	9	1	localObject3	java.lang.Object
    //   132	13	1	localException3	Exception
    //   154	13	1	localException4	Exception
    //   169	56	1	localObject4	java.lang.Object
    //   18	157	2	localObject5	java.lang.Object
    //   181	13	2	localException5	Exception
    //   205	13	2	localException6	Exception
    //   89	1	3	localIOException1	java.io.IOException
    //   99	19	3	localIOException2	java.io.IOException
    //   165	4	3	localObject6	java.lang.Object
    //   7	191	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   43	47	50	java/lang/Exception
    //   66	71	72	java/lang/Exception
    //   21	26	89	java/io/IOException
    //   28	32	89	java/io/IOException
    //   34	43	89	java/io/IOException
    //   9	19	93	finally
    //   9	19	99	java/io/IOException
    //   125	129	132	java/lang/Exception
    //   148	153	154	java/lang/Exception
    //   21	26	165	finally
    //   28	32	165	finally
    //   34	43	165	finally
    //   104	110	165	finally
    //   112	121	165	finally
    //   174	178	181	java/lang/Exception
    //   197	202	205	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForStarLeague
 * JD-Core Version:    0.7.0.1
 */