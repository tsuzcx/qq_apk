package com.tencent.mobileqq.structmsg;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Pattern;

public class StructMsgFactory
{
  public static AbsStructMsg a()
  {
    StructMsgForGeneralShare localStructMsgForGeneralShare = new StructMsgForGeneralShare();
    localStructMsgForGeneralShare.fwFlag = 0;
    localStructMsgForGeneralShare.mMsgTemplateID = 1;
    localStructMsgForGeneralShare.mMsgServiceID = 1;
    localStructMsgForGeneralShare.mMsgBrief = "你有新消息";
    localStructMsgForGeneralShare.mMsgAction = "";
    localStructMsgForGeneralShare.mMsgActionData = "";
    localStructMsgForGeneralShare.mMsg_A_ActionData = "";
    localStructMsgForGeneralShare.mMsg_I_ActionData = "";
    localStructMsgForGeneralShare.mMsgUrl = "";
    localStructMsgForGeneralShare.mFlag = 55;
    StructMsgElementFactory.a(0).a(new StructMsgItemTitle(""));
    return localStructMsgForGeneralShare;
  }
  
  public static AbsStructMsg a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    switch (paramBundle.getInt("req_type", 1))
    {
    case 4: 
    default: 
      return new StructMsgForGeneralShare(paramBundle);
    case 2: 
      return new StructMsgForAudioShare(paramBundle);
    case 3: 
      return new StructMsgForHypertext(paramBundle);
    }
    return new StructMsgForImageShare(paramBundle);
  }
  
  public static AbsStructMsg a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte = a(paramArrayOfByte, paramInt2);
    if ((paramArrayOfByte != null) && ((paramArrayOfByte instanceof AbsShareMsg)))
    {
      l1 = paramArrayOfByte.mMsgServiceID;
      l2 = ((AbsShareMsg)paramArrayOfByte).mSourceAppid;
      if ((l1 == 23L) && ((paramInt1 == 82) || (paramInt1 == 43))) {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_AIO", paramQQAppInterface.getCurrentAccountUin(), "AIOchat", "appear_obj", 0, 0, String.valueOf(paramLong), String.valueOf(l1), String.valueOf(l2), "");
      }
      if (l1 == 52L)
      {
        paramQQAppInterface = new StringBuilder("rec flower msg,");
        paramQQAppInterface.append(StructMsgItemLayout12.a(paramArrayOfByte));
        QLog.i("StructMsg", 1, paramQQAppInterface.toString());
      }
    }
    while (!QLog.isColorLevel())
    {
      long l1;
      long l2;
      return paramArrayOfByte;
    }
    QLog.d("StructMsg", 2, "getStructMsgFromXmlBuff = null ,error happened ");
    return paramArrayOfByte;
  }
  
  /* Error */
  public static AbsStructMsg a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_0
    //   8: ifnonnull +5 -> 13
    //   11: aload_2
    //   12: areturn
    //   13: new 170	java/io/ObjectInputStream
    //   16: dup
    //   17: new 172	java/io/ByteArrayInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 175	java/io/ByteArrayInputStream:<init>	([B)V
    //   25: invokespecial 178	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore 4
    //   30: aload 4
    //   32: astore_2
    //   33: aload 5
    //   35: astore_3
    //   36: aload 4
    //   38: invokevirtual 182	java/io/ObjectInputStream:readInt	()I
    //   41: istore_1
    //   42: iload_1
    //   43: iconst_2
    //   44: if_icmpne +77 -> 121
    //   47: aload 4
    //   49: astore_2
    //   50: aload 5
    //   52: astore_3
    //   53: new 79	com/tencent/mobileqq/structmsg/StructMsgForAudioShare
    //   56: dup
    //   57: invokespecial 183	com/tencent/mobileqq/structmsg/StructMsgForAudioShare:<init>	()V
    //   60: astore_0
    //   61: aload_0
    //   62: ifnull +24 -> 86
    //   65: aload 4
    //   67: astore_2
    //   68: aload_0
    //   69: astore_3
    //   70: aload_0
    //   71: iload_1
    //   72: putfield 95	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   75: aload 4
    //   77: astore_2
    //   78: aload_0
    //   79: astore_3
    //   80: aload_0
    //   81: aload 4
    //   83: invokevirtual 187	com/tencent/mobileqq/structmsg/AbsStructMsg:readExternal	(Ljava/io/ObjectInput;)V
    //   86: aload_0
    //   87: astore_2
    //   88: aload 4
    //   90: ifnull -79 -> 11
    //   93: aload 4
    //   95: invokevirtual 190	java/io/ObjectInputStream:close	()V
    //   98: aload_0
    //   99: areturn
    //   100: astore_3
    //   101: aload_0
    //   102: astore_2
    //   103: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq -95 -> 11
    //   109: ldc 145
    //   111: iconst_2
    //   112: aload_3
    //   113: invokevirtual 193	java/io/IOException:getMessage	()Ljava/lang/String;
    //   116: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: aload_0
    //   120: areturn
    //   121: iload_1
    //   122: iconst_3
    //   123: if_icmpeq +15 -> 138
    //   126: iload_1
    //   127: bipush 82
    //   129: if_icmpeq +9 -> 138
    //   132: iload_1
    //   133: bipush 120
    //   135: if_icmpne +20 -> 155
    //   138: aload 4
    //   140: astore_2
    //   141: aload 5
    //   143: astore_3
    //   144: new 82	com/tencent/mobileqq/structmsg/StructMsgForHypertext
    //   147: dup
    //   148: invokespecial 194	com/tencent/mobileqq/structmsg/StructMsgForHypertext:<init>	()V
    //   151: astore_0
    //   152: goto -91 -> 61
    //   155: iload_1
    //   156: iconst_5
    //   157: if_icmpne +20 -> 177
    //   160: aload 4
    //   162: astore_2
    //   163: aload 5
    //   165: astore_3
    //   166: new 85	com/tencent/mobileqq/structmsg/StructMsgForImageShare
    //   169: dup
    //   170: invokespecial 195	com/tencent/mobileqq/structmsg/StructMsgForImageShare:<init>	()V
    //   173: astore_0
    //   174: goto -113 -> 61
    //   177: aload 4
    //   179: astore_2
    //   180: aload 5
    //   182: astore_3
    //   183: new 13	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   186: dup
    //   187: invokespecial 14	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:<init>	()V
    //   190: astore_0
    //   191: goto -130 -> 61
    //   194: astore 5
    //   196: aconst_null
    //   197: astore_0
    //   198: aload_0
    //   199: astore_2
    //   200: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   203: ifeq +16 -> 219
    //   206: aload_0
    //   207: astore_2
    //   208: ldc 145
    //   210: iconst_2
    //   211: aload 5
    //   213: invokevirtual 196	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   216: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload_3
    //   220: astore_2
    //   221: aload_0
    //   222: ifnull -211 -> 11
    //   225: aload_0
    //   226: invokevirtual 190	java/io/ObjectInputStream:close	()V
    //   229: aload_3
    //   230: areturn
    //   231: astore_0
    //   232: aload_3
    //   233: astore_2
    //   234: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   237: ifeq -226 -> 11
    //   240: ldc 145
    //   242: iconst_2
    //   243: aload_0
    //   244: invokevirtual 193	java/io/IOException:getMessage	()Ljava/lang/String;
    //   247: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: aload_3
    //   251: areturn
    //   252: astore_0
    //   253: aconst_null
    //   254: astore_2
    //   255: aload_2
    //   256: ifnull +7 -> 263
    //   259: aload_2
    //   260: invokevirtual 190	java/io/ObjectInputStream:close	()V
    //   263: aload_0
    //   264: athrow
    //   265: astore_2
    //   266: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq -6 -> 263
    //   272: ldc 145
    //   274: iconst_2
    //   275: aload_2
    //   276: invokevirtual 193	java/io/IOException:getMessage	()Ljava/lang/String;
    //   279: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: goto -19 -> 263
    //   285: astore_0
    //   286: goto -31 -> 255
    //   289: astore 5
    //   291: aload 4
    //   293: astore_0
    //   294: goto -96 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	paramArrayOfByte	byte[]
    //   41	117	1	i	int
    //   6	254	2	localObject1	Object
    //   265	11	2	localIOException1	java.io.IOException
    //   1	79	3	localObject2	Object
    //   100	13	3	localIOException2	java.io.IOException
    //   143	108	3	localObject3	Object
    //   28	264	4	localObjectInputStream	java.io.ObjectInputStream
    //   3	178	5	localObject4	Object
    //   194	18	5	localException1	Exception
    //   289	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   93	98	100	java/io/IOException
    //   13	30	194	java/lang/Exception
    //   225	229	231	java/io/IOException
    //   13	30	252	finally
    //   259	263	265	java/io/IOException
    //   36	42	285	finally
    //   53	61	285	finally
    //   70	75	285	finally
    //   80	86	285	finally
    //   144	152	285	finally
    //   166	174	285	finally
    //   183	191	285	finally
    //   200	206	285	finally
    //   208	219	285	finally
    //   36	42	289	java/lang/Exception
    //   53	61	289	java/lang/Exception
    //   70	75	289	java/lang/Exception
    //   80	86	289	java/lang/Exception
    //   144	152	289	java/lang/Exception
    //   166	174	289	java/lang/Exception
    //   183	191	289	java/lang/Exception
  }
  
  /* Error */
  public static AbsStructMsg a(byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +9 -> 10
    //   4: aload_0
    //   5: arraylength
    //   6: iconst_2
    //   7: if_icmpge +21 -> 28
    //   10: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +11 -> 24
    //   16: ldc 145
    //   18: iconst_2
    //   19: ldc 204
    //   21: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: aconst_null
    //   25: astore_0
    //   26: aload_0
    //   27: areturn
    //   28: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +25 -> 56
    //   34: ldc 145
    //   36: iconst_2
    //   37: iconst_2
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: ldc 206
    //   45: aastore
    //   46: dup
    //   47: iconst_1
    //   48: aload_0
    //   49: invokestatic 211	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   52: aastore
    //   53: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   56: aload_0
    //   57: iload_1
    //   58: invokestatic 219	com/tencent/mobileqq/structmsg/StructMsgUtils:a	([BI)[B
    //   61: astore_3
    //   62: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   65: ifeq +11 -> 76
    //   68: ldc 145
    //   70: iconst_2
    //   71: ldc 221
    //   73: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: invokestatic 227	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   79: invokevirtual 228	java/util/UUID:toString	()Ljava/lang/String;
    //   82: astore_0
    //   83: new 117	java/lang/String
    //   86: dup
    //   87: aload_3
    //   88: ldc 230
    //   90: invokespecial 233	java/lang/String:<init>	([BLjava/lang/String;)V
    //   93: astore_3
    //   94: aload_3
    //   95: invokestatic 236	com/tencent/mobileqq/structmsg/StructMsgFactory:a	(Ljava/lang/String;)Z
    //   98: istore_2
    //   99: aload_3
    //   100: aload_0
    //   101: iload_2
    //   102: invokestatic 241	com/tencent/mobileqq/text/EmotcationConstants:a	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   105: invokestatic 244	com/tencent/mobileqq/structmsg/StructMsgFactory:a	(Ljava/lang/String;)Ljava/lang/String;
    //   108: astore_3
    //   109: invokestatic 247	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   112: ifeq +28 -> 140
    //   115: ldc 145
    //   117: iconst_4
    //   118: new 131	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   125: ldc 250
    //   127: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_3
    //   131: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 154	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: new 172	java/io/ByteArrayInputStream
    //   143: dup
    //   144: aload_3
    //   145: invokevirtual 254	java/lang/String:getBytes	()[B
    //   148: invokespecial 175	java/io/ByteArrayInputStream:<init>	([B)V
    //   151: astore_3
    //   152: new 256	com/tencent/mobileqq/structmsg/StructMsgParserHandler
    //   155: dup
    //   156: invokespecial 257	com/tencent/mobileqq/structmsg/StructMsgParserHandler:<init>	()V
    //   159: astore 4
    //   161: aload 4
    //   163: aload_0
    //   164: invokevirtual 259	com/tencent/mobileqq/structmsg/StructMsgParserHandler:a	(Ljava/lang/String;)V
    //   167: aload 4
    //   169: iload_2
    //   170: invokevirtual 262	com/tencent/mobileqq/structmsg/StructMsgParserHandler:a	(Z)V
    //   173: invokestatic 268	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   176: astore_0
    //   177: aload_0
    //   178: invokevirtual 272	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   181: aload_3
    //   182: aload 4
    //   184: invokevirtual 278	javax/xml/parsers/SAXParser:parse	(Ljava/io/InputStream;Lorg/xml/sax/helpers/DefaultHandler;)V
    //   187: aload_3
    //   188: invokevirtual 281	java/io/InputStream:close	()V
    //   191: aload 4
    //   193: invokevirtual 283	com/tencent/mobileqq/structmsg/StructMsgParserHandler:a	()Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   196: astore_3
    //   197: aload_3
    //   198: astore_0
    //   199: aload_3
    //   200: ifnull -174 -> 26
    //   203: aload_3
    //   204: astore_0
    //   205: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq -182 -> 26
    //   211: ldc 145
    //   213: iconst_2
    //   214: ldc_w 285
    //   217: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aload_3
    //   221: areturn
    //   222: astore_0
    //   223: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   226: ifeq +13 -> 239
    //   229: ldc 145
    //   231: iconst_2
    //   232: ldc_w 287
    //   235: aload_0
    //   236: invokestatic 291	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   239: aconst_null
    //   240: areturn
    //   241: astore_0
    //   242: aload_0
    //   243: invokevirtual 294	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   246: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   249: ifeq +32 -> 281
    //   252: ldc 145
    //   254: iconst_2
    //   255: new 131	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   262: ldc_w 296
    //   265: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_0
    //   269: invokevirtual 297	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   272: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: aconst_null
    //   282: areturn
    //   283: astore_0
    //   284: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   287: ifeq -48 -> 239
    //   290: ldc 145
    //   292: iconst_2
    //   293: ldc_w 287
    //   296: aload_0
    //   297: invokestatic 291	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   300: goto -61 -> 239
    //   303: astore_0
    //   304: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   307: ifeq -68 -> 239
    //   310: ldc 145
    //   312: iconst_2
    //   313: ldc_w 287
    //   316: aload_0
    //   317: invokestatic 291	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   320: goto -81 -> 239
    //   323: astore_0
    //   324: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   327: ifeq -88 -> 239
    //   330: ldc 145
    //   332: iconst_2
    //   333: ldc_w 299
    //   336: aload_0
    //   337: invokestatic 291	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   340: goto -101 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	paramArrayOfByte	byte[]
    //   0	343	1	paramInt	int
    //   98	72	2	bool	boolean
    //   61	160	3	localObject	Object
    //   159	33	4	localStructMsgParserHandler	StructMsgParserHandler
    // Exception table:
    //   from	to	target	type
    //   177	197	222	javax/xml/parsers/ParserConfigurationException
    //   205	220	222	javax/xml/parsers/ParserConfigurationException
    //   83	140	241	java/io/UnsupportedEncodingException
    //   177	197	283	org/xml/sax/SAXException
    //   205	220	283	org/xml/sax/SAXException
    //   177	197	303	java/io/IOException
    //   205	220	303	java/io/IOException
    //   177	197	323	java/lang/Exception
    //   205	220	323	java/lang/Exception
  }
  
  public static StructMsgForGeneralShare a()
  {
    return new StructMsgForGeneralShare();
  }
  
  public static StructMsgNode a(StructMsgNode paramStructMsgNode)
  {
    for (paramStructMsgNode = paramStructMsgNode.a(); (paramStructMsgNode != null) && (paramStructMsgNode.jdField_a_of_type_Int != 1); paramStructMsgNode = paramStructMsgNode.a()) {}
    return paramStructMsgNode;
  }
  
  public static String a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode.jdField_a_of_type_Int == 3) {}
    Object localObject;
    for (paramStructMsgNode = paramStructMsgNode.jdField_a_of_type_JavaLangString;; paramStructMsgNode = ((StringBuilder)localObject).toString())
    {
      localObject = paramStructMsgNode;
      if (paramStructMsgNode == null) {
        localObject = "";
      }
      return localObject;
      localObject = new StringBuilder();
      int j = paramStructMsgNode.a();
      int i = 0;
      if (i < j)
      {
        StructMsgNode localStructMsgNode = paramStructMsgNode.a(i);
        if (localStructMsgNode == null) {}
        for (;;)
        {
          i += 1;
          break;
          if (localStructMsgNode.jdField_a_of_type_Int == 3) {
            ((StringBuilder)localObject).append(localStructMsgNode.jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
  }
  
  public static final String a(String paramString)
  {
    Object localObject = System.getProperty("java.vm.version");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      try
      {
        bool = a((String)localObject, "2.0.0", ".");
        if (QLog.isDevelopLevel()) {
          QLog.d("StructMsg", 4, "java vm version  = " + (String)localObject + " isART = " + bool);
        }
        localObject = AIOUtils.a().append(paramString);
        i = 0;
        k = 0;
        if (i < paramString.length())
        {
          int i1 = paramString.charAt(i);
          m = i;
          j = k;
          switch (i1)
          {
          default: 
            if (((i1 < 32) || (i1 > 55295)) && ((i1 < 57344) || (i1 > 65533))) {
              continue;
            }
            n = 1;
            if (!bool) {
              continue;
            }
            m = i;
            j = k;
            if (n == 0)
            {
              ((StringBuilder)localObject).deleteCharAt(i - k);
              k += 1;
              m = i;
              j = k;
              if (QLog.isColorLevel())
              {
                QLog.d("StructMsg", 2, " ContainInvalidCharacter return null ,invalid char  = " + Integer.toHexString(i1));
                j = k;
                m = i;
              }
            }
            break;
          }
          i = m + 1;
          k = j;
          continue;
        }
      }
      catch (Exception localException)
      {
        int i;
        int k;
        bool = false;
        continue;
        int n = 0;
        continue;
        int m = i;
        int j = k;
        if (n != 0) {
          continue;
        }
        n = paramString.codePointAt(i);
        if (EmotcationConstants.a.get(n, -1) >= 0)
        {
          m = i;
          j = k;
          if (n <= 65535) {
            continue;
          }
          m = i + 1;
          j = k;
          continue;
        }
        ((StringBuilder)localObject).deleteCharAt(i - k);
        j = k + 1;
        m = i;
        continue;
      }
      return ((StringBuilder)localObject).toString();
      boolean bool = false;
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (paramString.contains("serviceID=\"83\"")) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return false;
      try
      {
        paramString1 = Pattern.compile(paramString3, 16).split(paramString1);
        paramString2 = Pattern.compile(paramString3, 16).split(paramString2);
        int m = Math.max(paramString1.length, paramString2.length);
        int i = 0;
        label49:
        if (i < m)
        {
          int j;
          if (paramString1.length > i)
          {
            j = Integer.parseInt(paramString1[i]);
            label69:
            if (paramString2.length <= i) {
              break label103;
            }
          }
          label103:
          for (int k = Integer.parseInt(paramString2[i]); j >= k; k = 0)
          {
            i += 1;
            break label49;
            j = 0;
            break label69;
          }
        }
        return true;
      }
      catch (Exception paramString1) {}
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgFactory
 * JD-Core Version:    0.7.0.1
 */