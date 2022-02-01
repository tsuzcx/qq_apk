package com.tencent.mobileqq.data;

import android.text.TextUtils;
import aruz;
import bdof;
import bdpo;
import com.tencent.mobileqq.app.QQAppInterface;
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
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 2)) {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "decode MessageForTroopFee for xml buff by stream failed. xmlbuff is null or lenght<2");
      }
    }
    for (;;)
    {
      return null;
      paramQQAppInterface = bdpo.a(paramArrayOfByte, paramInt2);
      try
      {
        paramQQAppInterface = bdof.a(new String(paramQQAppInterface, "utf-8"));
        paramQQAppInterface = new ByteArrayInputStream(paramQQAppInterface.getBytes());
        paramArrayOfByte = new aruz();
        SAXParserFactory localSAXParserFactory = SAXParserFactory.newInstance();
        if (!QLog.isColorLevel()) {}
      }
      catch (UnsupportedEncodingException paramQQAppInterface)
      {
        try
        {
          localSAXParserFactory.newSAXParser().parse(paramQQAppInterface, paramArrayOfByte);
          paramQQAppInterface.close();
          paramQQAppInterface = paramArrayOfByte.a();
          return paramQQAppInterface;
        }
        catch (Exception paramQQAppInterface) {}
        paramQQAppInterface = paramQQAppInterface;
        paramQQAppInterface.printStackTrace();
        return null;
      }
    }
    QLog.e(".troop.troop_fee", 2, "decode MessageForTroopFee for xml buff by stream", paramQQAppInterface);
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
    //   0: new 157	java/io/ObjectInputStream
    //   3: dup
    //   4: new 61	java/io/ByteArrayInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 161	com/tencent/mobileqq/data/MessageForStarLeague:msgData	[B
    //   12: invokespecial 68	java/io/ByteArrayInputStream:<init>	([B)V
    //   15: invokespecial 164	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: aload_2
    //   23: invokespecial 166	com/tencent/mobileqq/data/MessageForStarLeague:readExternal	(Ljava/io/ObjectInput;)V
    //   26: aload_2
    //   27: astore_1
    //   28: aload_0
    //   29: aload_0
    //   30: invokevirtual 169	com/tencent/mobileqq/data/MessageForStarLeague:getSummaryMsg	()Ljava/lang/String;
    //   33: putfield 172	com/tencent/mobileqq/data/MessageForStarLeague:msg	Ljava/lang/String;
    //   36: aload_2
    //   37: ifnull +7 -> 44
    //   40: aload_2
    //   41: invokevirtual 173	java/io/ObjectInputStream:close	()V
    //   44: return
    //   45: astore_1
    //   46: aload_1
    //   47: invokevirtual 174	java/lang/Exception:printStackTrace	()V
    //   50: return
    //   51: astore_3
    //   52: aconst_null
    //   53: astore_2
    //   54: aload_2
    //   55: astore_1
    //   56: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +14 -> 73
    //   62: aload_2
    //   63: astore_1
    //   64: ldc 176
    //   66: iconst_2
    //   67: ldc 178
    //   69: aload_3
    //   70: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   73: aload_2
    //   74: ifnull -30 -> 44
    //   77: aload_2
    //   78: invokevirtual 173	java/io/ObjectInputStream:close	()V
    //   81: return
    //   82: astore_1
    //   83: aload_1
    //   84: invokevirtual 174	java/lang/Exception:printStackTrace	()V
    //   87: return
    //   88: astore_2
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_1
    //   92: ifnull +7 -> 99
    //   95: aload_1
    //   96: invokevirtual 173	java/io/ObjectInputStream:close	()V
    //   99: aload_2
    //   100: athrow
    //   101: astore_1
    //   102: aload_1
    //   103: invokevirtual 174	java/lang/Exception:printStackTrace	()V
    //   106: goto -7 -> 99
    //   109: astore_2
    //   110: goto -19 -> 91
    //   113: astore_3
    //   114: goto -60 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	MessageForStarLeague
    //   20	8	1	localObjectInputStream1	java.io.ObjectInputStream
    //   45	2	1	localException1	Exception
    //   55	9	1	localObjectInputStream2	java.io.ObjectInputStream
    //   82	2	1	localException2	Exception
    //   90	6	1	localObject1	java.lang.Object
    //   101	2	1	localException3	Exception
    //   18	60	2	localObjectInputStream3	java.io.ObjectInputStream
    //   88	12	2	localObject2	java.lang.Object
    //   109	1	2	localObject3	java.lang.Object
    //   51	19	3	localIOException1	java.io.IOException
    //   113	1	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   40	44	45	java/lang/Exception
    //   0	19	51	java/io/IOException
    //   77	81	82	java/lang/Exception
    //   0	19	88	finally
    //   95	99	101	java/lang/Exception
    //   21	26	109	finally
    //   28	36	109	finally
    //   56	62	109	finally
    //   64	73	109	finally
    //   21	26	113	java/io/IOException
    //   28	36	113	java/io/IOException
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
  
  public void postRead()
  {
    super.parse();
  }
  
  /* Error */
  public void prewrite()
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
    //   44: ifnull +7 -> 51
    //   47: aload_2
    //   48: invokevirtual 203	java/io/ObjectOutputStream:close	()V
    //   51: aload 4
    //   53: ifnull +8 -> 61
    //   56: aload 4
    //   58: invokevirtual 207	java/io/ByteArrayOutputStream:close	()V
    //   61: return
    //   62: astore_1
    //   63: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq -15 -> 51
    //   69: ldc 176
    //   71: iconst_2
    //   72: ldc 209
    //   74: aload_1
    //   75: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   78: goto -27 -> 51
    //   81: astore_1
    //   82: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq -24 -> 61
    //   88: ldc 176
    //   90: iconst_2
    //   91: ldc 209
    //   93: aload_1
    //   94: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   97: return
    //   98: astore_3
    //   99: aconst_null
    //   100: astore_2
    //   101: aload_2
    //   102: astore_1
    //   103: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +14 -> 120
    //   109: aload_2
    //   110: astore_1
    //   111: ldc 176
    //   113: iconst_2
    //   114: ldc 209
    //   116: aload_3
    //   117: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   120: aload_2
    //   121: ifnull +7 -> 128
    //   124: aload_2
    //   125: invokevirtual 203	java/io/ObjectOutputStream:close	()V
    //   128: aload 4
    //   130: ifnull -69 -> 61
    //   133: aload 4
    //   135: invokevirtual 207	java/io/ByteArrayOutputStream:close	()V
    //   138: return
    //   139: astore_1
    //   140: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq -82 -> 61
    //   146: ldc 176
    //   148: iconst_2
    //   149: ldc 209
    //   151: aload_1
    //   152: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   155: return
    //   156: astore_1
    //   157: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq -32 -> 128
    //   163: ldc 176
    //   165: iconst_2
    //   166: ldc 209
    //   168: aload_1
    //   169: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   172: goto -44 -> 128
    //   175: astore_2
    //   176: aconst_null
    //   177: astore_1
    //   178: aload_1
    //   179: ifnull +7 -> 186
    //   182: aload_1
    //   183: invokevirtual 203	java/io/ObjectOutputStream:close	()V
    //   186: aload 4
    //   188: ifnull +8 -> 196
    //   191: aload 4
    //   193: invokevirtual 207	java/io/ByteArrayOutputStream:close	()V
    //   196: aload_2
    //   197: athrow
    //   198: astore_1
    //   199: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq -16 -> 186
    //   205: ldc 176
    //   207: iconst_2
    //   208: ldc 209
    //   210: aload_1
    //   211: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   214: goto -28 -> 186
    //   217: astore_1
    //   218: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq -25 -> 196
    //   224: ldc 176
    //   226: iconst_2
    //   227: ldc 209
    //   229: aload_1
    //   230: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   233: goto -37 -> 196
    //   236: astore_2
    //   237: goto -59 -> 178
    //   240: astore_3
    //   241: goto -140 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	MessageForStarLeague
    //   20	14	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   62	13	1	localException1	Exception
    //   81	13	1	localException2	Exception
    //   102	9	1	localObjectOutputStream2	java.io.ObjectOutputStream
    //   139	13	1	localException3	Exception
    //   156	13	1	localException4	Exception
    //   177	6	1	localObject1	java.lang.Object
    //   198	13	1	localException5	Exception
    //   217	13	1	localException6	Exception
    //   18	107	2	localObjectOutputStream3	java.io.ObjectOutputStream
    //   175	22	2	localObject2	java.lang.Object
    //   236	1	2	localObject3	java.lang.Object
    //   98	19	3	localIOException1	java.io.IOException
    //   240	1	3	localIOException2	java.io.IOException
    //   7	185	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   47	51	62	java/lang/Exception
    //   56	61	81	java/lang/Exception
    //   9	19	98	java/io/IOException
    //   133	138	139	java/lang/Exception
    //   124	128	156	java/lang/Exception
    //   9	19	175	finally
    //   182	186	198	java/lang/Exception
    //   191	196	217	java/lang/Exception
    //   21	26	236	finally
    //   28	32	236	finally
    //   34	43	236	finally
    //   103	109	236	finally
    //   111	120	236	finally
    //   21	26	240	java/io/IOException
    //   28	32	240	java/io/IOException
    //   34	43	240	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForStarLeague
 * JD-Core Version:    0.7.0.1
 */