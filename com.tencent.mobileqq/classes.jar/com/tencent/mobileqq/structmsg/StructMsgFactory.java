package com.tencent.mobileqq.structmsg;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import java.util.regex.Pattern;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class StructMsgFactory
{
  public static AbsStructMsg a()
  {
    StructMsgForGeneralShare localStructMsgForGeneralShare = new StructMsgForGeneralShare();
    localStructMsgForGeneralShare.fwFlag = 0;
    localStructMsgForGeneralShare.mMsgTemplateID = 1;
    localStructMsgForGeneralShare.mMsgServiceID = 1;
    localStructMsgForGeneralShare.mMsgBrief = HardCodeUtil.a(2131714396);
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
    int i = paramBundle.getInt("req_type", 146);
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 5) {
          return new StructMsgForGeneralShare(paramBundle);
        }
        return new StructMsgForImageShare(paramBundle);
      }
      return new StructMsgForHypertext(paramBundle);
    }
    return new StructMsgForAudioShare(paramBundle);
  }
  
  public static AbsStructMsg a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte = a(paramArrayOfByte, paramInt2);
    if ((paramArrayOfByte != null) && ((paramArrayOfByte instanceof AbsShareMsg)))
    {
      long l1 = paramArrayOfByte.mMsgServiceID;
      long l2 = ((AbsShareMsg)paramArrayOfByte).mSourceAppid;
      if ((l1 == 23L) && ((paramInt1 == 82) || (paramInt1 == 43))) {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_AIO", paramQQAppInterface.getCurrentAccountUin(), "AIOchat", "appear_obj", 0, 0, String.valueOf(paramLong), String.valueOf(l1), String.valueOf(l2), "");
      }
      if (l1 == 52L)
      {
        paramQQAppInterface = new StringBuilder("rec flower msg,");
        paramQQAppInterface.append(StructMsgItemLayout12.a(paramArrayOfByte));
        QLog.i("StructMsg", 1, paramQQAppInterface.toString());
        return paramArrayOfByte;
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("StructMsg", 2, "getStructMsgFromXmlBuff = null ,error happened ");
    }
    return paramArrayOfByte;
  }
  
  /* Error */
  public static AbsStructMsg a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 4
    //   8: aload_0
    //   9: ifnonnull +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: new 174	java/io/ObjectInputStream
    //   17: dup
    //   18: new 176	java/io/ByteArrayInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 179	java/io/ByteArrayInputStream:<init>	([B)V
    //   26: invokespecial 182	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   29: astore_3
    //   30: aload 4
    //   32: astore_0
    //   33: aload_3
    //   34: invokevirtual 186	java/io/ObjectInputStream:readInt	()I
    //   37: istore_1
    //   38: iload_1
    //   39: iconst_2
    //   40: if_icmpne +245 -> 285
    //   43: aload 4
    //   45: astore_0
    //   46: new 89	com/tencent/mobileqq/structmsg/StructMsgForAudioShare
    //   49: dup
    //   50: invokespecial 187	com/tencent/mobileqq/structmsg/StructMsgForAudioShare:<init>	()V
    //   53: astore_2
    //   54: aload_2
    //   55: astore_0
    //   56: goto +224 -> 280
    //   59: iload_1
    //   60: sipush 150
    //   63: if_icmpne +19 -> 82
    //   66: aload 4
    //   68: astore_0
    //   69: new 189	com/tencent/mobileqq/structmsg/StructMsgSubImageVideo
    //   72: dup
    //   73: invokespecial 190	com/tencent/mobileqq/structmsg/StructMsgSubImageVideo:<init>	()V
    //   76: astore_2
    //   77: aload_2
    //   78: astore_0
    //   79: goto +201 -> 280
    //   82: aload 4
    //   84: astore_0
    //   85: new 13	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   88: dup
    //   89: invokespecial 14	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:<init>	()V
    //   92: astore_2
    //   93: aload_2
    //   94: astore_0
    //   95: goto +185 -> 280
    //   98: aload 4
    //   100: astore_0
    //   101: new 83	com/tencent/mobileqq/structmsg/StructMsgForImageShare
    //   104: dup
    //   105: invokespecial 191	com/tencent/mobileqq/structmsg/StructMsgForImageShare:<init>	()V
    //   108: astore_2
    //   109: aload_2
    //   110: astore_0
    //   111: goto +169 -> 280
    //   114: aload 4
    //   116: astore_0
    //   117: new 86	com/tencent/mobileqq/structmsg/StructMsgForHypertext
    //   120: dup
    //   121: invokespecial 192	com/tencent/mobileqq/structmsg/StructMsgForHypertext:<init>	()V
    //   124: astore_2
    //   125: aload_2
    //   126: astore_0
    //   127: goto +153 -> 280
    //   130: aload_2
    //   131: astore_0
    //   132: aload_2
    //   133: iload_1
    //   134: putfield 99	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   137: aload_2
    //   138: astore_0
    //   139: aload_2
    //   140: aload_3
    //   141: invokevirtual 196	com/tencent/mobileqq/structmsg/AbsStructMsg:readExternal	(Ljava/io/ObjectInput;)V
    //   144: aload_3
    //   145: invokevirtual 199	java/io/ObjectInputStream:close	()V
    //   148: aload_2
    //   149: areturn
    //   150: astore_3
    //   151: aload_2
    //   152: astore_0
    //   153: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +86 -> 242
    //   159: ldc 149
    //   161: iconst_2
    //   162: aload_3
    //   163: invokevirtual 202	java/io/IOException:getMessage	()Ljava/lang/String;
    //   166: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: aload_2
    //   170: areturn
    //   171: astore_0
    //   172: goto +72 -> 244
    //   175: astore 4
    //   177: goto +16 -> 193
    //   180: astore_0
    //   181: aload_2
    //   182: astore_3
    //   183: goto +61 -> 244
    //   186: astore 4
    //   188: aconst_null
    //   189: astore_0
    //   190: aload 5
    //   192: astore_3
    //   193: aload_3
    //   194: astore_2
    //   195: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq +16 -> 214
    //   201: aload_3
    //   202: astore_2
    //   203: ldc 149
    //   205: iconst_2
    //   206: aload 4
    //   208: invokevirtual 203	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   211: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aload_3
    //   215: ifnull +27 -> 242
    //   218: aload_3
    //   219: invokevirtual 199	java/io/ObjectInputStream:close	()V
    //   222: goto +20 -> 242
    //   225: astore_2
    //   226: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +13 -> 242
    //   232: ldc 149
    //   234: iconst_2
    //   235: aload_2
    //   236: invokevirtual 202	java/io/IOException:getMessage	()Ljava/lang/String;
    //   239: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: aload_0
    //   243: areturn
    //   244: aload_3
    //   245: ifnull +27 -> 272
    //   248: aload_3
    //   249: invokevirtual 199	java/io/ObjectInputStream:close	()V
    //   252: goto +20 -> 272
    //   255: astore_2
    //   256: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   259: ifeq +13 -> 272
    //   262: ldc 149
    //   264: iconst_2
    //   265: aload_2
    //   266: invokevirtual 202	java/io/IOException:getMessage	()Ljava/lang/String;
    //   269: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: goto +5 -> 277
    //   275: aload_0
    //   276: athrow
    //   277: goto -2 -> 275
    //   280: aload_0
    //   281: astore_2
    //   282: goto -152 -> 130
    //   285: iload_1
    //   286: iconst_3
    //   287: if_icmpeq -173 -> 114
    //   290: iload_1
    //   291: bipush 82
    //   293: if_icmpeq -179 -> 114
    //   296: iload_1
    //   297: bipush 120
    //   299: if_icmpne +6 -> 305
    //   302: goto -188 -> 114
    //   305: iload_1
    //   306: iconst_5
    //   307: if_icmpeq -209 -> 98
    //   310: iload_1
    //   311: sipush 137
    //   314: if_icmpne -255 -> 59
    //   317: goto -219 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	paramArrayOfByte	byte[]
    //   37	278	1	i	int
    //   1	202	2	localObject1	Object
    //   225	11	2	localIOException1	IOException
    //   255	11	2	localIOException2	IOException
    //   281	1	2	arrayOfByte	byte[]
    //   29	116	3	localObjectInputStream	java.io.ObjectInputStream
    //   150	13	3	localIOException3	IOException
    //   182	67	3	localObject2	Object
    //   6	109	4	localObject3	Object
    //   175	1	4	localException1	Exception
    //   186	21	4	localException2	Exception
    //   3	188	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   144	148	150	java/io/IOException
    //   33	38	171	finally
    //   46	54	171	finally
    //   69	77	171	finally
    //   85	93	171	finally
    //   101	109	171	finally
    //   117	125	171	finally
    //   132	137	171	finally
    //   139	144	171	finally
    //   33	38	175	java/lang/Exception
    //   46	54	175	java/lang/Exception
    //   69	77	175	java/lang/Exception
    //   85	93	175	java/lang/Exception
    //   101	109	175	java/lang/Exception
    //   117	125	175	java/lang/Exception
    //   132	137	175	java/lang/Exception
    //   139	144	175	java/lang/Exception
    //   14	30	180	finally
    //   195	201	180	finally
    //   203	214	180	finally
    //   14	30	186	java/lang/Exception
    //   218	222	225	java/io/IOException
    //   248	252	255	java/io/IOException
  }
  
  public static AbsStructMsg a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, new Object[] { "getStructMsgFromXmlBuff uncompress begin: ", HexUtil.bytes2HexStr(paramArrayOfByte) });
      }
      Object localObject1 = StructMsgUtils.a(paramArrayOfByte, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "getStructMsgFromXmlBuff uncompress finished");
      }
      paramArrayOfByte = UUID.randomUUID().toString();
      try
      {
        localObject1 = new String((byte[])localObject1, "utf-8");
        boolean bool = a((String)localObject1);
        localObject1 = a(EmotcationConstants.beforXml((String)localObject1, paramArrayOfByte, bool));
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getStructMsgFromXmlBuff:");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.i("StructMsg", 4, ((StringBuilder)localObject2).toString());
        }
        localObject1 = new ByteArrayInputStream(((String)localObject1).getBytes());
        Object localObject2 = new StructMsgParserHandler();
        ((StructMsgParserHandler)localObject2).a(paramArrayOfByte);
        ((StructMsgParserHandler)localObject2).a(bool);
        paramArrayOfByte = SAXParserFactory.newInstance();
        try
        {
          paramArrayOfByte.newSAXParser().parse((InputStream)localObject1, (DefaultHandler)localObject2);
          ((InputStream)localObject1).close();
          paramArrayOfByte = ((StructMsgParserHandler)localObject2).a();
          if ((paramArrayOfByte != null) && (QLog.isColorLevel())) {
            QLog.d("StructMsg", 2, "getStructMsgFromXmlBuff decode structmsg success");
          }
          return paramArrayOfByte;
        }
        catch (Exception paramArrayOfByte)
        {
          if (QLog.isColorLevel())
          {
            QLog.e("StructMsg", 2, "getStructMsg", paramArrayOfByte);
            return null;
          }
        }
        catch (IOException paramArrayOfByte)
        {
          if (QLog.isColorLevel())
          {
            QLog.e("StructMsg", 2, "getStructMsgFromXmlBuffByStream", paramArrayOfByte);
            return null;
          }
        }
        catch (SAXException paramArrayOfByte)
        {
          if (QLog.isColorLevel())
          {
            QLog.e("StructMsg", 2, "getStructMsgFromXmlBuffByStream", paramArrayOfByte);
            return null;
          }
        }
        catch (ParserConfigurationException paramArrayOfByte)
        {
          if (QLog.isColorLevel()) {
            QLog.e("StructMsg", 2, "getStructMsgFromXmlBuffByStream", paramArrayOfByte);
          }
        }
        return null;
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getStructMsgFromXmlBuff = ");
          ((StringBuilder)localObject1).append(paramArrayOfByte.getMessage());
          QLog.d("StructMsg", 2, ((StringBuilder)localObject1).toString());
        }
        return null;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "getStructMsgFromXmlBuff xmlbuff is null or lenght<2");
    }
    return null;
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
    if (paramStructMsgNode.jdField_a_of_type_Int == 3)
    {
      paramStructMsgNode = paramStructMsgNode.jdField_a_of_type_JavaLangString;
    }
    else
    {
      localObject = new StringBuilder();
      int j = paramStructMsgNode.a();
      int i = 0;
      while (i < j)
      {
        StructMsgNode localStructMsgNode = paramStructMsgNode.a(i);
        if ((localStructMsgNode != null) && (localStructMsgNode.jdField_a_of_type_Int == 3)) {
          ((StringBuilder)localObject).append(localStructMsgNode.jdField_a_of_type_JavaLangString);
        }
        i += 1;
      }
      paramStructMsgNode = ((StringBuilder)localObject).toString();
    }
    Object localObject = paramStructMsgNode;
    if (paramStructMsgNode == null) {
      localObject = "";
    }
    return localObject;
  }
  
  public static final String a(String paramString)
  {
    Object localObject = System.getProperty("java.vm.version");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      bool = a((String)localObject, "2.0.0", ".");
    }
    catch (Exception localException)
    {
      boolean bool;
      label32:
      StringBuilder localStringBuilder;
      int i;
      int k;
      int j;
      break label32;
    }
    bool = false;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("java vm version  = ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" isART = ");
      localStringBuilder.append(bool);
      QLog.d("StructMsg", 4, localStringBuilder.toString());
    }
    localObject = AIOUtils.a();
    ((StringBuilder)localObject).append(paramString);
    i = 0;
    for (k = 0; i < paramString.length(); k = j)
    {
      int i1 = paramString.charAt(i);
      int m = i;
      j = k;
      if (i1 != 9)
      {
        m = i;
        j = k;
        if (i1 != 10)
        {
          m = i;
          j = k;
          if (i1 != 13)
          {
            m = i;
            j = k;
            if (i1 != 38)
            {
              m = i;
              j = k;
              if (i1 != 60)
              {
                m = i;
                j = k;
                if (i1 != 62)
                {
                  int n;
                  if (((i1 >= 32) && (i1 <= 55295)) || ((i1 >= 57344) && (i1 <= 65533))) {
                    n = 1;
                  } else {
                    n = 0;
                  }
                  if (bool)
                  {
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
                        localStringBuilder = new StringBuilder();
                        localStringBuilder.append(" ContainInvalidCharacter return null ,invalid char  = ");
                        localStringBuilder.append(Integer.toHexString(i1));
                        QLog.d("StructMsg", 2, localStringBuilder.toString());
                        m = i;
                        j = k;
                      }
                    }
                  }
                  else
                  {
                    m = i;
                    j = k;
                    if (n == 0)
                    {
                      n = paramString.codePointAt(i);
                      if (EmotcationConstants.EMOJI_MAP.get(n, -1) >= 0)
                      {
                        m = i;
                        j = k;
                        if (n > 65535)
                        {
                          m = i + 1;
                          j = k;
                        }
                      }
                      else
                      {
                        ((StringBuilder)localObject).deleteCharAt(i - k);
                        j = k + 1;
                        m = i;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      i = m + 1;
    }
    return ((StringBuilder)localObject).toString();
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.contains("serviceID=\"83\""));
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
    }
    for (;;)
    {
      try
      {
        paramString1 = Pattern.compile(paramString3, 16).split(paramString1);
        paramString2 = Pattern.compile(paramString3, 16).split(paramString2);
        int m = Math.max(paramString1.length, paramString2.length);
        int i = 0;
        if (i < m)
        {
          if (paramString1.length <= i) {
            break label115;
          }
          j = Integer.parseInt(paramString1[i]);
          int k;
          if (paramString2.length > i) {
            k = Integer.parseInt(paramString2[i]);
          } else {
            k = 0;
          }
          if (j < k) {
            return false;
          }
          i += 1;
          continue;
        }
        return true;
      }
      catch (Exception paramString1)
      {
        return false;
      }
      return false;
      label115:
      int j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgFactory
 * JD-Core Version:    0.7.0.1
 */