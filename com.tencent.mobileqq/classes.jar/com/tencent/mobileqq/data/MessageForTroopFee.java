package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class MessageForTroopFee
  extends ChatMessage
{
  public String actionUrl;
  public String backgroundColor = "#FD9527";
  public String brief;
  public String source;
  public String summary;
  public String title;
  
  public static MessageForTroopFee decodeMsgFromXmlBuff(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong, byte[] paramArrayOfByte, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 2))
    {
      paramQQAppInterface = StructMsgUtils.a(paramArrayOfByte, paramInt2);
      try
      {
        paramQQAppInterface = StructMsgFactory.a(new String(paramQQAppInterface, "utf-8"));
        paramQQAppInterface = new ByteArrayInputStream(paramQQAppInterface.getBytes());
        paramArrayOfByte = new MessageForTroopFee.TroopFeeParserHandler();
        SAXParserFactory localSAXParserFactory = SAXParserFactory.newInstance();
        try
        {
          localSAXParserFactory.newSAXParser().parse(paramQQAppInterface, paramArrayOfByte);
          paramQQAppInterface.close();
          paramQQAppInterface = paramArrayOfByte.a();
          if ((paramQQAppInterface.checkParams()) && (QLog.isColorLevel())) {
            QLog.d("StructMsg", 2, "decode MessageForTroopFee for xml buff by stream success");
          }
          return paramQQAppInterface;
        }
        catch (Exception paramQQAppInterface)
        {
          if (QLog.isColorLevel())
          {
            QLog.e(".troop.troop_fee", 2, "decode MessageForTroopFee for xml buff by stream", paramQQAppInterface);
            return null;
          }
        }
        catch (IOException paramQQAppInterface)
        {
          if (QLog.isColorLevel())
          {
            QLog.e(".troop.troop_fee", 2, "decode MessageForTroopFee for xml buff by stream", paramQQAppInterface);
            return null;
          }
        }
        catch (SAXException paramQQAppInterface)
        {
          if (QLog.isColorLevel())
          {
            QLog.e(".troop.troop_fee", 2, "decode MessageForTroopFee for xml buff by stream", paramQQAppInterface);
            return null;
          }
        }
        catch (ParserConfigurationException paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.e(".troop.troop_fee", 2, "decode MessageForTroopFee for xml buff by stream", paramQQAppInterface);
          }
        }
        return null;
      }
      catch (UnsupportedEncodingException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return null;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "decode MessageForTroopFee for xml buff by stream failed. xmlbuff is null or lenght<2");
    }
    return null;
  }
  
  public boolean checkParams()
  {
    return (!TextUtils.isEmpty(this.title)) && (!TextUtils.isEmpty(this.summary)) && (!TextUtils.isEmpty(this.source)) && (!TextUtils.isEmpty(this.actionUrl)) && (!TextUtils.isEmpty(this.brief));
  }
  
  public void copyFrom(MessageForTroopFee paramMessageForTroopFee)
  {
    this.title = paramMessageForTroopFee.title;
    this.summary = paramMessageForTroopFee.summary;
    this.source = paramMessageForTroopFee.source;
    this.actionUrl = paramMessageForTroopFee.actionUrl;
    this.brief = paramMessageForTroopFee.brief;
  }
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_1
    //   5: new 137	java/io/ObjectInputStream
    //   8: dup
    //   9: new 52	java/io/ByteArrayInputStream
    //   12: dup
    //   13: aload_0
    //   14: getfield 141	com/tencent/mobileqq/data/MessageForTroopFee:msgData	[B
    //   17: invokespecial 59	java/io/ByteArrayInputStream:<init>	([B)V
    //   20: invokespecial 144	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   23: astore_2
    //   24: aload_0
    //   25: aload_2
    //   26: invokevirtual 148	com/tencent/mobileqq/data/MessageForTroopFee:readExternal	(Ljava/io/ObjectInput;)V
    //   29: aload_0
    //   30: aload_0
    //   31: invokevirtual 152	com/tencent/mobileqq/data/MessageForTroopFee:getSummaryMsg	()Ljava/lang/String;
    //   34: putfield 155	com/tencent/mobileqq/data/MessageForTroopFee:msg	Ljava/lang/String;
    //   37: aload_2
    //   38: invokevirtual 156	java/io/ObjectInputStream:close	()V
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
    //   66: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +14 -> 83
    //   72: aload_2
    //   73: astore_1
    //   74: ldc 105
    //   76: iconst_2
    //   77: ldc 158
    //   79: aload_3
    //   80: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   83: aload_2
    //   84: ifnull +13 -> 97
    //   87: aload_2
    //   88: invokevirtual 156	java/io/ObjectInputStream:close	()V
    //   91: return
    //   92: astore_1
    //   93: aload_1
    //   94: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   97: return
    //   98: aload_2
    //   99: ifnull +15 -> 114
    //   102: aload_2
    //   103: invokevirtual 156	java/io/ObjectInputStream:close	()V
    //   106: goto +8 -> 114
    //   109: astore_2
    //   110: aload_2
    //   111: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   114: aload_1
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	MessageForTroopFee
    //   4	1	1	localObject1	java.lang.Object
    //   42	1	1	localObject2	java.lang.Object
    //   46	8	1	localException1	Exception
    //   56	18	1	localObject3	java.lang.Object
    //   92	23	1	localException2	Exception
    //   23	80	2	localObject4	java.lang.Object
    //   109	2	2	localException3	Exception
    //   48	1	3	localException4	Exception
    //   52	4	3	localObject5	java.lang.Object
    //   60	20	3	localException5	Exception
    //   1	61	4	localObject6	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   24	37	42	finally
    //   24	37	46	java/lang/Exception
    //   5	24	52	finally
    //   66	72	52	finally
    //   74	83	52	finally
    //   5	24	60	java/lang/Exception
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.brief);
    localStringBuilder.append(this.title);
    return localStringBuilder.toString();
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  /* Error */
  protected void prewrite()
  {
    // Byte code:
    //   0: new 180	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 181	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 183	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 186	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: aload_2
    //   23: invokevirtual 190	com/tencent/mobileqq/data/MessageForTroopFee:writeExternal	(Ljava/io/ObjectOutput;)V
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: invokevirtual 191	java/io/ObjectOutputStream:close	()V
    //   32: aload_2
    //   33: astore_1
    //   34: aload_0
    //   35: aload 4
    //   37: invokevirtual 194	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   40: putfield 141	com/tencent/mobileqq/data/MessageForTroopFee:msgData	[B
    //   43: aload_2
    //   44: invokevirtual 191	java/io/ObjectOutputStream:close	()V
    //   47: goto +8 -> 55
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   55: aload 4
    //   57: invokevirtual 195	java/io/ByteArrayOutputStream:close	()V
    //   60: return
    //   61: astore_3
    //   62: goto +12 -> 74
    //   65: astore_1
    //   66: aconst_null
    //   67: astore_2
    //   68: goto +64 -> 132
    //   71: astore_3
    //   72: aconst_null
    //   73: astore_2
    //   74: aload_2
    //   75: astore_1
    //   76: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +14 -> 93
    //   82: aload_2
    //   83: astore_1
    //   84: ldc 105
    //   86: iconst_2
    //   87: ldc 197
    //   89: aload_3
    //   90: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   93: aload_2
    //   94: astore_1
    //   95: aload_3
    //   96: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   99: aload_2
    //   100: ifnull +15 -> 115
    //   103: aload_2
    //   104: invokevirtual 191	java/io/ObjectOutputStream:close	()V
    //   107: goto +8 -> 115
    //   110: astore_1
    //   111: aload_1
    //   112: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   115: aload 4
    //   117: invokevirtual 195	java/io/ByteArrayOutputStream:close	()V
    //   120: return
    //   121: astore_1
    //   122: aload_1
    //   123: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   126: return
    //   127: astore_3
    //   128: aload_1
    //   129: astore_2
    //   130: aload_3
    //   131: astore_1
    //   132: aload_2
    //   133: ifnull +15 -> 148
    //   136: aload_2
    //   137: invokevirtual 191	java/io/ObjectOutputStream:close	()V
    //   140: goto +8 -> 148
    //   143: astore_2
    //   144: aload_2
    //   145: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   148: aload 4
    //   150: invokevirtual 195	java/io/ByteArrayOutputStream:close	()V
    //   153: goto +8 -> 161
    //   156: astore_2
    //   157: aload_2
    //   158: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   161: aload_1
    //   162: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	MessageForTroopFee
    //   20	14	1	localObject1	java.lang.Object
    //   50	2	1	localException1	Exception
    //   65	1	1	localObject2	java.lang.Object
    //   75	20	1	localObject3	java.lang.Object
    //   110	2	1	localException2	Exception
    //   121	8	1	localException3	Exception
    //   131	31	1	localObject4	java.lang.Object
    //   18	119	2	localObject5	java.lang.Object
    //   143	2	2	localException4	Exception
    //   156	2	2	localException5	Exception
    //   61	1	3	localException6	Exception
    //   71	25	3	localException7	Exception
    //   127	4	3	localObject6	java.lang.Object
    //   7	142	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   43	47	50	java/lang/Exception
    //   21	26	61	java/lang/Exception
    //   28	32	61	java/lang/Exception
    //   34	43	61	java/lang/Exception
    //   9	19	65	finally
    //   9	19	71	java/lang/Exception
    //   103	107	110	java/lang/Exception
    //   55	60	121	java/lang/Exception
    //   115	120	121	java/lang/Exception
    //   21	26	127	finally
    //   28	32	127	finally
    //   34	43	127	finally
    //   76	82	127	finally
    //   84	93	127	finally
    //   95	99	127	finally
    //   136	140	143	java/lang/Exception
    //   148	153	156	java/lang/Exception
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    this.title = paramObjectInput.readUTF();
    this.summary = paramObjectInput.readUTF();
    this.source = paramObjectInput.readUTF();
    this.actionUrl = paramObjectInput.readUTF();
    this.brief = paramObjectInput.readUTF();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.title);
    paramObjectOutput.writeUTF(this.summary);
    paramObjectOutput.writeUTF(this.source);
    paramObjectOutput.writeUTF(this.actionUrl);
    paramObjectOutput.writeUTF(this.brief);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTroopFee
 * JD-Core Version:    0.7.0.1
 */