package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mqp.app.sec.ScConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.os.MqqHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class AntiFraudConfigFileUtil
{
  private int jdField_a_of_type_Int = -1;
  private Bundle jdField_a_of_type_AndroidOsBundle = null;
  private SecSvcObserver jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver = new AntiFraudConfigFileUtil.3(this);
  private Bundle b = new Bundle();
  
  public static AntiFraudConfigFileUtil a()
  {
    return AntiFraudConfigFileUtil.UinSafetyWordingConfigFileUtilHolder.a;
  }
  
  private void a(Bundle paramBundle, String paramString, Element paramElement)
  {
    int i;
    try
    {
      i = Integer.parseInt(paramString);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      i = 0;
    }
    if ((i != 1) && (i != 2)) {
      paramString = paramElement.getFirstChild();
    }
    while (paramString != null)
    {
      if ((paramString instanceof Element))
      {
        paramElement = new Bundle();
        a(paramElement, (Element)paramString);
        paramBundle.putBundle(paramString.getNodeName(), paramElement);
      }
      paramString = paramString.getNextSibling();
      continue;
      Object localObject1 = paramElement.getElementsByTagName("TailWording");
      Object localObject2;
      Object localObject3;
      String str;
      if (((NodeList)localObject1).getLength() > 0)
      {
        localObject2 = new Bundle();
        i = 0;
        while (i < ((NodeList)localObject1).getLength())
        {
          localObject3 = (Element)((NodeList)localObject1).item(i);
          str = ((Element)localObject3).getAttribute("Status");
          paramString = str;
          if (TextUtils.isEmpty(str)) {
            paramString = "0";
          }
          ((Bundle)localObject2).putString(paramString, ((Element)localObject3).getTextContent());
          i += 1;
        }
        paramBundle.putBundle("TailWording", (Bundle)localObject2);
      }
      paramString = paramElement.getElementsByTagName("Action");
      if (paramString.getLength() > 0)
      {
        paramElement = new Bundle();
        i = 0;
        while (i < paramString.getLength())
        {
          localObject2 = (Element)paramString.item(i);
          str = ((Element)localObject2).getAttribute("PlaceHolder");
          if (!TextUtils.isEmpty(str))
          {
            localObject1 = new Bundle();
            localObject3 = ((Element)localObject2).getAttribute("Type");
            ((Bundle)localObject1).putString("Type", (String)localObject3);
            ((Bundle)localObject1).putString("Name", ((Element)localObject2).getAttribute("Name"));
            if (((String)localObject3).equalsIgnoreCase("openURL"))
            {
              a((Bundle)localObject1, (Element)localObject2);
            }
            else
            {
              localObject3 = ((Element)localObject2).getElementsByTagName("AlertTitle");
              if (((NodeList)localObject3).getLength() > 0) {
                a((Bundle)localObject1, (Element)((NodeList)localObject3).item(0));
              }
              localObject3 = ((Element)localObject2).getElementsByTagName("AlertText");
              if (((NodeList)localObject3).getLength() > 0) {
                a((Bundle)localObject1, (Element)((NodeList)localObject3).item(0));
              }
              localObject3 = ((Element)localObject2).getElementsByTagName("AlertOtherBtnText");
              if (((NodeList)localObject3).getLength() > 0) {
                a((Bundle)localObject1, (Element)((NodeList)localObject3).item(0));
              }
              localObject2 = ((Element)localObject2).getElementsByTagName("AlertCancelBtnText");
              if (((NodeList)localObject2).getLength() > 0) {
                a((Bundle)localObject1, (Element)((NodeList)localObject2).item(0));
              }
            }
            paramElement.putBundle(str, (Bundle)localObject1);
          }
          i += 1;
        }
        paramBundle.putBundle("Action", paramElement);
      }
    }
  }
  
  private void a(Bundle paramBundle, Element paramElement)
  {
    String str = paramElement.getNodeName();
    paramElement = paramElement.getFirstChild();
    Object localObject2;
    for (Object localObject1 = ""; paramElement != null; localObject1 = localObject2)
    {
      localObject2 = localObject1;
      if ((paramElement instanceof Text))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(paramElement.getNodeValue());
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      paramElement = paramElement.getNextSibling();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramBundle.putString(str, (String)localObject1);
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse config file:");
      localStringBuilder.append(paramString);
      QLog.d("UinSafety.WordingConfigFileUtil", 2, localStringBuilder.toString());
    }
    paramString = a(paramString);
    if (paramString != null) {
      b(paramString);
    }
  }
  
  private void b(String paramString)
  {
    Object localObject1 = DocumentBuilderFactory.newInstance();
    for (;;)
    {
      try
      {
        File localFile = new File(paramString);
        String str = localFile.getName();
        str = str.substring(0, str.lastIndexOf("."));
        Object localObject3 = ((DocumentBuilderFactory)localObject1).newDocumentBuilder().parse(localFile).getDocumentElement();
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getBundle(str);
        if (localObject1 != null)
        {
          localObject1 = ((Bundle)localObject1).getString("Version");
          boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
          if (!bool)
          {
            try
            {
              i = Integer.parseInt((String)localObject1);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              break label505;
            }
            localObject2 = ((Element)localObject3).getAttribute("Version");
            int j;
            try
            {
              j = Integer.parseInt((String)localObject2);
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
              j = 0;
            }
            if (j < i)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              paramString = new StringBuilder();
              paramString.append(str);
              paramString.append(" file version below current used version.");
              QLog.d("UinSafety.WordingConfigFileUtil", 2, paramString.toString());
              return;
            }
            if (ScConfigManager.a().a(paramString)) {
              return;
            }
            Bundle localBundle1 = new Bundle();
            paramString = (String)localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              paramString = Integer.toString(0);
            }
            localBundle1.putString("Version", paramString);
            this.jdField_a_of_type_Int = j;
            paramString = ((Element)localObject3).getElementsByTagName("SubConfig");
            i = 0;
            if (i < paramString.getLength())
            {
              Object localObject4 = (Element)paramString.item(i);
              localObject2 = ((Element)localObject4).getAttribute("Type");
              localObject3 = new Bundle();
              Object localObject5 = ((Element)localObject4).getElementsByTagName("Element");
              j = 0;
              if (j < ((NodeList)localObject5).getLength())
              {
                Element localElement = (Element)((NodeList)localObject5).item(j);
                Bundle localBundle2 = new Bundle();
                a(localBundle2, (String)localObject2, localElement);
                ((Bundle)localObject3).putBundle(localElement.getAttribute("Value"), localBundle2);
                j += 1;
                continue;
              }
              localObject4 = ((Element)localObject4).getElementsByTagName("PublicElement");
              if (((NodeList)localObject4).getLength() > 0)
              {
                localObject4 = (Element)((NodeList)localObject4).item(0);
                localObject5 = new Bundle();
                a((Bundle)localObject5, (String)localObject2, (Element)localObject4);
                ((Bundle)localObject3).putBundle("PublicElement", (Bundle)localObject5);
              }
              localBundle1.putBundle((String)localObject2, (Bundle)localObject3);
              i += 1;
              continue;
            }
            this.jdField_a_of_type_AndroidOsBundle.putBundle(str, localBundle1);
            return;
          }
        }
      }
      catch (Exception paramString)
      {
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("exception occurred.");
          ((StringBuilder)localObject2).append(paramString.getMessage());
          QLog.d("UinSafety.WordingConfigFileUtil", 2, ((StringBuilder)localObject2).toString());
        }
        paramString.printStackTrace();
        return;
      }
      label505:
      int i = 0;
    }
  }
  
  public int a(String paramString)
  {
    Object localObject = DocumentBuilderFactory.newInstance();
    try
    {
      paramString = new File(paramString);
      String str = paramString.getName();
      str.substring(0, str.lastIndexOf("."));
      paramString = ((DocumentBuilderFactory)localObject).newDocumentBuilder().parse(paramString).getDocumentElement().getAttribute("Version");
      try
      {
        int i = Integer.parseInt(paramString);
        return i;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return -1;
      }
      return -1;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("exception occurred.");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.d("UinSafety.WordingConfigFileUtil", 2, ((StringBuilder)localObject).toString());
      }
      paramString.printStackTrace();
    }
  }
  
  public long a(String paramString)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("LastModifiedTime");
    return localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
  }
  
  public Object a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    ThreadManager.getFileThreadHandler().post(new AntiFraudConfigFileUtil.2(this, paramString1));
    paramString1 = this.jdField_a_of_type_AndroidOsBundle.getBundle(paramString1);
    if (paramString1 != null)
    {
      Bundle localBundle2 = paramString1.getBundle(Integer.toString(paramInt1));
      if (localBundle2 != null)
      {
        paramString1 = localBundle2.getBundle(Integer.toString(paramInt2));
        if (paramString1 != null)
        {
          Bundle localBundle1 = paramString1.getBundle(paramString2);
          paramString1 = localBundle1;
          if (localBundle1 != null) {
            return paramString1;
          }
          localBundle2 = localBundle2.getBundle("PublicElement");
          paramString1 = localBundle1;
          if (localBundle2 == null) {
            return paramString1;
          }
          return localBundle2.getBundle(paramString2);
        }
      }
    }
    paramString1 = null;
    return paramString1;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir().getPath());
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".xml");
    return localStringBuilder.toString();
  }
  
  public String a(String paramString1, String paramString2)
  {
    Object localObject = paramString1;
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject = paramString1;
      if (TextUtils.equals("SenstiveMessageTipsCfg", paramString1)) {
        localObject = "SensMsgTipsCfg";
      }
    }
    ThreadManager.getFileThreadHandler().post(new AntiFraudConfigFileUtil.1(this, (String)localObject));
    paramString1 = null;
    localObject = this.jdField_a_of_type_AndroidOsBundle.getBundle((String)localObject);
    if (localObject != null) {
      paramString1 = ((Bundle)localObject).getString(paramString2);
    }
    return paramString1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    long l1 = a(paramString);
    long l2 = b(paramString);
    if (System.currentTimeMillis() - l1 >= l2 * 1000L)
    {
      SecSvcHandler localSecSvcHandler = (SecSvcHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
      paramQQAppInterface = paramString;
      if (TextUtils.equals(paramString, "SensMsgTipsCfg")) {
        paramQQAppInterface = "SenstiveMessageTipsCfg";
      }
      localSecSvcHandler.a(paramQQAppInterface);
    }
  }
  
  /* Error */
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +11 -> 12
    //   4: aload_1
    //   5: aload_0
    //   6: getfield 29	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver	Lcom/tencent/mobileqq/app/SecSvcObserver;
    //   9: invokevirtual 322	com/tencent/mobileqq/app/QQAppInterface:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   12: aload_2
    //   13: invokestatic 102	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifeq +4 -> 20
    //   19: return
    //   20: aload_2
    //   21: ldc_w 352
    //   24: invokevirtual 127	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   27: ifeq +52 -> 79
    //   30: aload_0
    //   31: aload_2
    //   32: invokevirtual 324	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:a	(Ljava/lang/String;)J
    //   35: lstore 6
    //   37: aload_0
    //   38: aload_2
    //   39: invokevirtual 326	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:b	(Ljava/lang/String;)J
    //   42: lstore 8
    //   44: aload_1
    //   45: ifnull +362 -> 407
    //   48: invokestatic 332	java/lang/System:currentTimeMillis	()J
    //   51: lload 6
    //   53: lsub
    //   54: lload 8
    //   56: ldc2_w 333
    //   59: lmul
    //   60: lcmp
    //   61: iflt +346 -> 407
    //   64: aload_1
    //   65: getstatic 340	com/tencent/mobileqq/app/BusinessHandlerFactory:SEC_SVC_HANDLER	Ljava/lang/String;
    //   68: invokevirtual 344	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   71: checkcast 346	com/tencent/mobileqq/app/SecSvcHandler
    //   74: aload_2
    //   75: invokevirtual 347	com/tencent/mobileqq/app/SecSvcHandler:a	(Ljava/lang/String;)V
    //   78: return
    //   79: aload_2
    //   80: ldc_w 312
    //   83: invokevirtual 127	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   86: ifeq +321 -> 407
    //   89: aload_0
    //   90: aload_2
    //   91: invokevirtual 354	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   94: astore 12
    //   96: aload_0
    //   97: ldc_w 312
    //   100: invokevirtual 173	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   103: astore 14
    //   105: aload 12
    //   107: invokestatic 102	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: istore 10
    //   112: aload_0
    //   113: getfield 17	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:jdField_a_of_type_Int	I
    //   116: iconst_m1
    //   117: if_icmpne +21 -> 138
    //   120: aload 12
    //   122: invokestatic 102	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   125: ifne +13 -> 138
    //   128: aload_0
    //   129: aload_0
    //   130: aload 14
    //   132: invokevirtual 356	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:a	(Ljava/lang/String;)I
    //   135: putfield 17	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:jdField_a_of_type_Int	I
    //   138: aload_0
    //   139: getfield 17	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:jdField_a_of_type_Int	I
    //   142: iconst_2
    //   143: if_icmpge +6 -> 149
    //   146: iconst_1
    //   147: istore 10
    //   149: aload 12
    //   151: astore_1
    //   152: iload 10
    //   154: ifeq +227 -> 381
    //   157: aconst_null
    //   158: astore_2
    //   159: aconst_null
    //   160: astore 13
    //   162: invokestatic 259	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   165: invokevirtual 360	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   168: ldc_w 362
    //   171: invokevirtual 368	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   174: astore_1
    //   175: new 370	java/io/FileOutputStream
    //   178: dup
    //   179: aload 14
    //   181: invokespecial 371	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   184: astore_2
    //   185: sipush 4096
    //   188: newarray byte
    //   190: astore 11
    //   192: aload_1
    //   193: aload 11
    //   195: invokevirtual 377	java/io/InputStream:read	([B)I
    //   198: istore 5
    //   200: iload 5
    //   202: ifle +15 -> 217
    //   205: aload_2
    //   206: aload 11
    //   208: iconst_0
    //   209: iload 5
    //   211: invokevirtual 383	java/io/OutputStream:write	([BII)V
    //   214: goto -22 -> 192
    //   217: aload_1
    //   218: ifnull +7 -> 225
    //   221: aload_1
    //   222: invokevirtual 386	java/io/InputStream:close	()V
    //   225: aload_2
    //   226: invokevirtual 387	java/io/OutputStream:close	()V
    //   229: goto +81 -> 310
    //   232: astore 4
    //   234: aload_2
    //   235: astore_3
    //   236: aload 4
    //   238: astore_2
    //   239: goto +11 -> 250
    //   242: astore 11
    //   244: goto +35 -> 279
    //   247: astore_2
    //   248: aconst_null
    //   249: astore_3
    //   250: aload_2
    //   251: astore 4
    //   253: goto +99 -> 352
    //   256: astore 11
    //   258: aconst_null
    //   259: astore_2
    //   260: goto +19 -> 279
    //   263: astore 4
    //   265: aconst_null
    //   266: astore_3
    //   267: aload_2
    //   268: astore_1
    //   269: goto +83 -> 352
    //   272: astore 11
    //   274: aconst_null
    //   275: astore_2
    //   276: aload 13
    //   278: astore_1
    //   279: aload 11
    //   281: invokevirtual 52	java/lang/Exception:printStackTrace	()V
    //   284: aload_1
    //   285: ifnull +10 -> 295
    //   288: aload_1
    //   289: invokevirtual 386	java/io/InputStream:close	()V
    //   292: goto +3 -> 295
    //   295: aload_2
    //   296: ifnull +14 -> 310
    //   299: aload_2
    //   300: invokevirtual 387	java/io/OutputStream:close	()V
    //   303: goto +7 -> 310
    //   306: aload_1
    //   307: invokevirtual 388	java/io/IOException:printStackTrace	()V
    //   310: aload 12
    //   312: astore_1
    //   313: aload 14
    //   315: invokestatic 392	com/tencent/mobileqq/filemanager/util/FileUtil:b	(Ljava/lang/String;)Z
    //   318: ifeq +63 -> 381
    //   321: aload 14
    //   323: invokestatic 397	com/tencent/mobileqq/utils/SecUtil:getFileMd5	(Ljava/lang/String;)Ljava/lang/String;
    //   326: astore_1
    //   327: aload_0
    //   328: ldc_w 312
    //   331: aload_1
    //   332: invokevirtual 399	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   335: aload_0
    //   336: aload_0
    //   337: aload 14
    //   339: invokevirtual 356	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:a	(Ljava/lang/String;)I
    //   342: putfield 17	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:jdField_a_of_type_Int	I
    //   345: goto +36 -> 381
    //   348: astore 4
    //   350: aload_2
    //   351: astore_3
    //   352: aload_1
    //   353: ifnull +10 -> 363
    //   356: aload_1
    //   357: invokevirtual 386	java/io/InputStream:close	()V
    //   360: goto +3 -> 363
    //   363: aload_3
    //   364: ifnull +14 -> 378
    //   367: aload_3
    //   368: invokevirtual 387	java/io/OutputStream:close	()V
    //   371: goto +7 -> 378
    //   374: aload_1
    //   375: invokevirtual 388	java/io/IOException:printStackTrace	()V
    //   378: aload 4
    //   380: athrow
    //   381: aload_1
    //   382: aload 4
    //   384: invokestatic 310	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   387: ifne +20 -> 407
    //   390: aload_3
    //   391: invokestatic 102	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   394: ifne +13 -> 407
    //   397: aload_0
    //   398: ldc_w 312
    //   401: aload 4
    //   403: aload_3
    //   404: invokevirtual 402	com/tencent/mobileqq/utils/AntiFraudConfigFileUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   407: return
    //   408: astore_1
    //   409: goto -103 -> 306
    //   412: astore_1
    //   413: goto -39 -> 374
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	this	AntiFraudConfigFileUtil
    //   0	416	1	paramQQAppInterface	QQAppInterface
    //   0	416	2	paramString1	String
    //   0	416	3	paramString2	String
    //   0	416	4	paramString3	String
    //   198	12	5	i	int
    //   35	17	6	l1	long
    //   42	13	8	l2	long
    //   110	43	10	bool	boolean
    //   190	17	11	arrayOfByte	byte[]
    //   242	1	11	localException1	Exception
    //   256	1	11	localException2	Exception
    //   272	8	11	localException3	Exception
    //   94	217	12	str1	String
    //   160	117	13	localObject	Object
    //   103	235	14	str2	String
    // Exception table:
    //   from	to	target	type
    //   185	192	232	finally
    //   192	200	232	finally
    //   205	214	232	finally
    //   185	192	242	java/lang/Exception
    //   192	200	242	java/lang/Exception
    //   205	214	242	java/lang/Exception
    //   175	185	247	finally
    //   175	185	256	java/lang/Exception
    //   162	175	263	finally
    //   162	175	272	java/lang/Exception
    //   279	284	348	finally
    //   221	225	408	java/io/IOException
    //   225	229	408	java/io/IOException
    //   288	292	408	java/io/IOException
    //   299	303	408	java/io/IOException
    //   356	360	412	java/io/IOException
    //   367	371	412	java/io/IOException
  }
  
  public void a(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("LastModifiedTime");
    localEditor.putLong(localStringBuilder.toString(), paramLong);
    localEditor.commit();
  }
  
  public void a(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("MD5");
    localEditor.putString(localStringBuilder.toString(), paramString2);
    localEditor.commit();
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    int i = this.b.getInt(paramString2, 0);
    if (i != 1)
    {
      if (i == 3) {
        return;
      }
      try
      {
        this.b.putInt(paramString2, 1);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      ThreadManager.post(new AntiFraudConfigFileUtil.4(this, paramString1, paramString3, paramString2), 5, null, false);
    }
  }
  
  public long b(String paramString)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("EffectTime");
    return localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
  }
  
  public String b(String paramString)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("MD5");
    return localSharedPreferences.getString(localStringBuilder.toString(), null);
  }
  
  public void b(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("EffectTime");
    localEditor.putLong(localStringBuilder.toString(), paramLong);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AntiFraudConfigFileUtil
 * JD-Core Version:    0.7.0.1
 */