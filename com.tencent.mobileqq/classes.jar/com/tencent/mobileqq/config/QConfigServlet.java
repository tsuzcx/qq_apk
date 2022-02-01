package com.tencent.mobileqq.config;

import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ArConfigUtils;
import com.tencent.mobileqq.config.injectimpl.OldServletInjectorImpl;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QConfigServlet
  extends MSFServlet
{
  protected static int a = 0;
  public static String a = "";
  @ConfigInject(configPath="/Foundation/QQCommon/src/main/resources/Inject_config_old_servlet.yml", version=1)
  public static ArrayList<Class<? extends IOldServletInjector>> a;
  protected static boolean a = false;
  protected static int b = 0;
  private static final String b = "QConfigServlet";
  protected static boolean b;
  protected static int c;
  protected static boolean c;
  protected static boolean d;
  protected static boolean e;
  protected static boolean f;
  protected static boolean g;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(OldServletInjectorImpl.class);
    jdField_a_of_type_JavaUtilArrayList.add(OldServletInjectorImpl.class);
  }
  
  public static String a(ConfigurationService.Config paramConfig, int paramInt1, int paramInt2)
  {
    if (paramConfig.version.get() == paramInt1) {
      return null;
    }
    if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() != 0))
    {
      if (paramConfig.msg_content_list.size() >= 2)
      {
        localObject1 = jdField_b_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleCompressConfig, 拉到了多份配置, type[");
        ((StringBuilder)localObject2).append(paramInt2);
        ((StringBuilder)localObject2).append("], size[");
        ((StringBuilder)localObject2).append(paramConfig.msg_content_list.size());
        ((StringBuilder)localObject2).append("]");
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        paramInt1 = 1;
      }
      else
      {
        paramInt1 = 0;
      }
      Object localObject2 = ((ConfigurationService.Content)paramConfig.msg_content_list.get(paramInt1)).content.get().toByteArray();
      if (localObject2 == null)
      {
        paramConfig = jdField_b_of_type_JavaLangString;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleCompressConfig| config content is null. type=");
        ((StringBuilder)localObject1).append(paramInt2);
        QLog.e(paramConfig, 1, ((StringBuilder)localObject1).toString());
        return null;
      }
      Object localObject1 = localObject2;
      if (((ConfigurationService.Content)paramConfig.msg_content_list.get(0)).compress.get() == 1)
      {
        localObject2 = ArConfigUtils.a((byte[])localObject2);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          paramConfig = jdField_b_of_type_JavaLangString;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handleCompressConfig| decompress is failed. type=");
          ((StringBuilder)localObject1).append(paramInt2);
          ((StringBuilder)localObject1).append(", data=null");
          QLog.e(paramConfig, 1, ((StringBuilder)localObject1).toString());
          return null;
        }
      }
      StringBuilder localStringBuilder1;
      try
      {
        localObject2 = new String((byte[])localObject1, "utf-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        localStringBuilder1 = null;
      }
      if (localStringBuilder1 == null)
      {
        paramConfig = jdField_b_of_type_JavaLangString;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("handleCompressConfig| switch data[] to String failed. type=");
        localStringBuilder1.append(paramInt2);
        localStringBuilder1.append(", data=");
        localStringBuilder1.append(new String((byte[])localObject1));
        QLog.e(paramConfig, 1, localStringBuilder1.toString());
        return null;
      }
      localObject1 = String.format("handleCompressConfig| config is update. version=%d, type=%d", new Object[] { Integer.valueOf(paramConfig.version.get()), Integer.valueOf(paramInt2) });
      if (QLog.isColorLevel())
      {
        if ((paramConfig.version.get() != 397) && (paramConfig.version.get() != 394))
        {
          paramConfig = jdField_b_of_type_JavaLangString;
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append((String)localObject1);
          localStringBuilder2.append("content=");
          localStringBuilder2.append(localStringBuilder1);
          QLog.i(paramConfig, 2, localStringBuilder2.toString());
          return localStringBuilder1;
        }
      }
      else {
        QLog.i(jdField_b_of_type_JavaLangString, 1, (String)localObject1);
      }
      return localStringBuilder1;
    }
    paramConfig = String.format("handleCompressConfig| version is update but config content is null. newVersion=%d, oldVersion=%d, type=%d", new Object[] { Integer.valueOf(paramConfig.version.get()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    QLog.i(jdField_b_of_type_JavaLangString, 1, paramConfig);
    return "";
  }
  
  private static void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >> 24));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 16));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 8));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)paramLong);
  }
  
  private static byte[] a(ConfigurationService.ReqGetConfig paramReqGetConfig)
  {
    paramReqGetConfig = paramReqGetConfig.toByteArray();
    long l = paramReqGetConfig.length;
    int i = (int)l;
    byte[] arrayOfByte = new byte[i + 4];
    a(arrayOfByte, 0, l + 4L);
    System.arraycopy(paramReqGetConfig, 0, arrayOfByte, 4, i);
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length - 4;
    byte[] arrayOfByte = new byte[i];
    PkgTools.copyData(arrayOfByte, 0, paramArrayOfByte, 4, i);
    return arrayOfByte;
  }
  
  public IOldServletInjector a()
  {
    if (jdField_a_of_type_JavaUtilArrayList.size() != 0) {
      try
      {
        IOldServletInjector localIOldServletInjector = (IOldServletInjector)((Class)jdField_a_of_type_JavaUtilArrayList.get(0)).newInstance();
        return localIOldServletInjector;
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
    } else {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "getOldServletInjector. mOldServletInjectors.size() = 0");
    }
    return new QConfigServlet.1(this);
  }
  
  public ConfigurationService.RespGetConfig a()
  {
    return new ConfigurationService.RespGetConfig();
  }
  
  /* Error */
  protected void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, HandlerThread paramHandlerThread)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +14 -> 17
    //   6: aload_1
    //   7: ldc 234
    //   9: invokevirtual 240	android/content/Intent:getParcelableArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   12: astore 14
    //   14: goto +21 -> 35
    //   17: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +1541 -> 1561
    //   23: getstatic 68	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   26: iconst_2
    //   27: ldc 242
    //   29: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: goto +1529 -> 1561
    //   35: aload 14
    //   37: ifnull +1501 -> 1538
    //   40: aload 14
    //   42: invokevirtual 247	java/util/ArrayList:isEmpty	()Z
    //   45: ifeq +6 -> 51
    //   48: goto +1490 -> 1538
    //   51: aload 14
    //   53: invokestatic 252	com/tencent/mobileqq/config/QConfigHelper:a	(Ljava/util/ArrayList;)[I
    //   56: astore 16
    //   58: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +93 -> 154
    //   64: aload 16
    //   66: arraylength
    //   67: istore 5
    //   69: iconst_0
    //   70: istore 4
    //   72: iload 4
    //   74: iload 5
    //   76: if_icmpge +78 -> 154
    //   79: aload 16
    //   81: iload 4
    //   83: iaload
    //   84: istore 6
    //   86: getstatic 68	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   89: astore 14
    //   91: new 70	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   98: astore 15
    //   100: aload 15
    //   102: ldc 254
    //   104: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 15
    //   110: iload 6
    //   112: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 15
    //   118: ldc_w 256
    //   121: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload 15
    //   127: aload 16
    //   129: arraylength
    //   130: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 14
    //   136: iconst_2
    //   137: aload 15
    //   139: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 174	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: iload 4
    //   147: iconst_1
    //   148: iadd
    //   149: istore 4
    //   151: goto -79 -> 72
    //   154: aload_2
    //   155: invokevirtual 261	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   158: astore 14
    //   160: aload_2
    //   161: invokevirtual 264	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   164: istore 9
    //   166: aload 14
    //   168: ifnull +1314 -> 1482
    //   171: aload 14
    //   173: arraylength
    //   174: iconst_4
    //   175: if_icmpge +6 -> 181
    //   178: goto +1304 -> 1482
    //   181: aload_2
    //   182: aload 14
    //   184: invokestatic 265	com/tencent/mobileqq/config/QConfigServlet:a	([B)[B
    //   187: invokevirtual 268	com/tencent/qphone/base/remote/FromServiceMsg:putWupBuffer	([B)V
    //   190: aload_0
    //   191: invokevirtual 270	com/tencent/mobileqq/config/QConfigServlet:a	()Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;
    //   194: astore 14
    //   196: aload 14
    //   198: aload_2
    //   199: invokevirtual 261	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   202: invokevirtual 274	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   205: pop
    //   206: aload 14
    //   208: getfield 277	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:cookies_new	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   211: invokevirtual 280	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   214: ifeq +1353 -> 1567
    //   217: aload 14
    //   219: getfield 277	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:cookies_new	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   222: invokevirtual 108	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   225: invokevirtual 114	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   228: astore_2
    //   229: goto +3 -> 232
    //   232: aload_2
    //   233: ifnull +30 -> 263
    //   236: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   239: ifeq +13 -> 252
    //   242: getstatic 68	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   245: iconst_2
    //   246: ldc_w 282
    //   249: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   252: invokestatic 287	com/tencent/mobileqq/config/QConfigManager:a	()Lcom/tencent/mobileqq/config/QConfigManager;
    //   255: getstatic 289	com/tencent/mobileqq/config/QConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   258: aload_2
    //   259: invokevirtual 292	com/tencent/mobileqq/config/QConfigManager:a	(Ljava/lang/String;[B)Z
    //   262: pop
    //   263: aload_0
    //   264: invokevirtual 294	com/tencent/mobileqq/config/QConfigServlet:a	()Lcom/tencent/mobileqq/config/IOldServletInjector;
    //   267: aload 14
    //   269: invokeinterface 297 2 0
    //   274: iconst_1
    //   275: putstatic 299	com/tencent/mobileqq/config/QConfigServlet:jdField_c_of_type_Boolean	Z
    //   278: iload 9
    //   280: ifeq +845 -> 1125
    //   283: aload 14
    //   285: getfield 302	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   288: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   291: ifne +834 -> 1125
    //   294: aload 14
    //   296: getfield 305	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   299: ifnull +826 -> 1125
    //   302: aload 14
    //   304: getfield 305	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   307: invokevirtual 66	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   310: ifne +6 -> 316
    //   313: goto +812 -> 1125
    //   316: invokestatic 309	java/lang/System:currentTimeMillis	()J
    //   319: lstore 10
    //   321: new 30	java/util/ArrayList
    //   324: dup
    //   325: aload 16
    //   327: arraylength
    //   328: invokespecial 312	java/util/ArrayList:<init>	(I)V
    //   331: astore 15
    //   333: aload 16
    //   335: arraylength
    //   336: istore 5
    //   338: iconst_0
    //   339: istore 4
    //   341: iload 4
    //   343: iload 5
    //   345: if_icmpge +28 -> 373
    //   348: aload 15
    //   350: aload 16
    //   352: iload 4
    //   354: iaload
    //   355: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   358: invokeinterface 315 2 0
    //   363: pop
    //   364: iload 4
    //   366: iconst_1
    //   367: iadd
    //   368: istore 4
    //   370: goto -29 -> 341
    //   373: aload 14
    //   375: getfield 305	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   378: invokevirtual 66	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   381: istore 5
    //   383: iconst_0
    //   384: istore 4
    //   386: iload 4
    //   388: iload 5
    //   390: if_icmpge +172 -> 562
    //   393: aload 14
    //   395: getfield 305	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   398: iload 4
    //   400: invokevirtual 97	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   403: checkcast 48	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config
    //   406: astore_2
    //   407: aload_2
    //   408: ifnonnull +6 -> 414
    //   411: goto +1161 -> 1572
    //   414: aload_2
    //   415: getfield 318	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   418: invokevirtual 319	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   421: ifne +6 -> 427
    //   424: goto +1148 -> 1572
    //   427: aload_2
    //   428: getfield 318	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   431: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   434: istore 6
    //   436: invokestatic 287	com/tencent/mobileqq/config/QConfigManager:a	()Lcom/tencent/mobileqq/config/QConfigManager;
    //   439: iload 6
    //   441: invokevirtual 322	com/tencent/mobileqq/config/QConfigManager:a	(I)Z
    //   444: ifne +6 -> 450
    //   447: goto +1125 -> 1572
    //   450: aload 15
    //   452: iload 6
    //   454: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   457: invokeinterface 325 2 0
    //   462: pop
    //   463: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   466: ifeq +62 -> 528
    //   469: getstatic 68	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   472: astore 17
    //   474: new 70	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   481: astore 18
    //   483: aload 18
    //   485: ldc_w 327
    //   488: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload 18
    //   494: iload 6
    //   496: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload 18
    //   502: ldc_w 329
    //   505: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload 18
    //   511: iload 5
    //   513: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: aload 17
    //   519: iconst_2
    //   520: aload 18
    //   522: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokestatic 174	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   528: aload_2
    //   529: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   532: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   535: istore 7
    //   537: invokestatic 287	com/tencent/mobileqq/config/QConfigManager:a	()Lcom/tencent/mobileqq/config/QConfigManager;
    //   540: iload 6
    //   542: iload 7
    //   544: aload_2
    //   545: getstatic 289	com/tencent/mobileqq/config/QConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   548: invokevirtual 332	com/tencent/mobileqq/config/QConfigManager:a	(IILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;Ljava/lang/String;)V
    //   551: getstatic 334	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_Int	I
    //   554: iconst_1
    //   555: iadd
    //   556: putstatic 334	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_Int	I
    //   559: goto +1013 -> 1572
    //   562: aload_0
    //   563: invokevirtual 294	com/tencent/mobileqq/config/QConfigServlet:a	()Lcom/tencent/mobileqq/config/IOldServletInjector;
    //   566: aload_0
    //   567: invokevirtual 338	com/tencent/mobileqq/config/QConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   570: aload 14
    //   572: aload 15
    //   574: aload_1
    //   575: aload 16
    //   577: iload 9
    //   579: invokeinterface 341 7 0
    //   584: iconst_1
    //   585: putstatic 343	com/tencent/mobileqq/config/QConfigServlet:e	Z
    //   588: invokestatic 309	java/lang/System:currentTimeMillis	()J
    //   591: lstore 12
    //   593: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   596: ifeq +46 -> 642
    //   599: getstatic 68	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   602: astore_2
    //   603: new 70	java/lang/StringBuilder
    //   606: dup
    //   607: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   610: astore 16
    //   612: aload 16
    //   614: ldc_w 345
    //   617: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: pop
    //   621: aload 16
    //   623: lload 12
    //   625: lload 10
    //   627: lsub
    //   628: invokevirtual 348	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   631: pop
    //   632: aload_2
    //   633: iconst_2
    //   634: aload 16
    //   636: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   639: invokestatic 94	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   642: iconst_0
    //   643: istore 6
    //   645: aload_1
    //   646: ldc_w 350
    //   649: iconst_0
    //   650: invokevirtual 354	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   653: istore 9
    //   655: iload 9
    //   657: ifeq +942 -> 1599
    //   660: aload_1
    //   661: ldc_w 356
    //   664: iconst_0
    //   665: invokevirtual 360	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   668: istore 7
    //   670: getstatic 68	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   673: iconst_2
    //   674: iconst_2
    //   675: anewarray 155	java/lang/Object
    //   678: dup
    //   679: iconst_0
    //   680: ldc_w 362
    //   683: aastore
    //   684: dup
    //   685: iconst_1
    //   686: iload 7
    //   688: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   691: aastore
    //   692: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   695: iload 7
    //   697: iconst_3
    //   698: if_icmpge +892 -> 1590
    //   701: aload 14
    //   703: getfield 369	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:next_req_types	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   706: invokevirtual 374	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   709: astore 16
    //   711: aload 16
    //   713: ifnull +877 -> 1590
    //   716: aload 16
    //   718: invokeinterface 375 1 0
    //   723: ifle +867 -> 1590
    //   726: aload 16
    //   728: invokeinterface 375 1 0
    //   733: newarray int
    //   735: astore_2
    //   736: aload 16
    //   738: invokeinterface 375 1 0
    //   743: istore 8
    //   745: iconst_0
    //   746: istore 5
    //   748: aload_2
    //   749: astore_1
    //   750: iload 7
    //   752: istore 4
    //   754: iload 5
    //   756: iload 8
    //   758: if_icmpge +52 -> 810
    //   761: aload 16
    //   763: iload 5
    //   765: invokeinterface 376 2 0
    //   770: checkcast 157	java/lang/Integer
    //   773: invokevirtual 379	java/lang/Integer:intValue	()I
    //   776: istore 4
    //   778: aload_2
    //   779: iload 5
    //   781: iload 4
    //   783: iastore
    //   784: aload 15
    //   786: invokeinterface 375 1 0
    //   791: ifle +790 -> 1581
    //   794: aload 15
    //   796: iload 4
    //   798: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   801: invokeinterface 325 2 0
    //   806: pop
    //   807: goto +774 -> 1581
    //   810: aload 15
    //   812: invokeinterface 383 1 0
    //   817: astore_2
    //   818: aload_2
    //   819: invokeinterface 388 1 0
    //   824: ifeq +120 -> 944
    //   827: aload_2
    //   828: invokeinterface 391 1 0
    //   833: checkcast 157	java/lang/Integer
    //   836: invokevirtual 379	java/lang/Integer:intValue	()I
    //   839: istore 5
    //   841: invokestatic 287	com/tencent/mobileqq/config/QConfigManager:a	()Lcom/tencent/mobileqq/config/QConfigManager;
    //   844: iload 5
    //   846: invokevirtual 322	com/tencent/mobileqq/config/QConfigManager:a	(I)Z
    //   849: ifeq -31 -> 818
    //   852: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   855: ifeq +67 -> 922
    //   858: getstatic 68	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   861: astore 16
    //   863: new 70	java/lang/StringBuilder
    //   866: dup
    //   867: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   870: astore 17
    //   872: aload 17
    //   874: ldc_w 393
    //   877: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: pop
    //   881: aload 17
    //   883: iload 5
    //   885: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   888: pop
    //   889: aload 17
    //   891: ldc_w 256
    //   894: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: pop
    //   898: aload 17
    //   900: aload 15
    //   902: invokeinterface 375 1 0
    //   907: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   910: pop
    //   911: aload 16
    //   913: iconst_2
    //   914: aload 17
    //   916: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   919: invokestatic 94	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   922: invokestatic 287	com/tencent/mobileqq/config/QConfigManager:a	()Lcom/tencent/mobileqq/config/QConfigManager;
    //   925: iload 5
    //   927: getstatic 289	com/tencent/mobileqq/config/QConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   930: invokevirtual 396	com/tencent/mobileqq/config/QConfigManager:a	(ILjava/lang/String;)V
    //   933: getstatic 398	com/tencent/mobileqq/config/QConfigServlet:jdField_c_of_type_Int	I
    //   936: iconst_1
    //   937: iadd
    //   938: putstatic 398	com/tencent/mobileqq/config/QConfigServlet:jdField_c_of_type_Int	I
    //   941: goto -123 -> 818
    //   944: aload_0
    //   945: invokevirtual 294	com/tencent/mobileqq/config/QConfigServlet:a	()Lcom/tencent/mobileqq/config/IOldServletInjector;
    //   948: aload_0
    //   949: invokevirtual 338	com/tencent/mobileqq/config/QConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   952: aload 15
    //   954: invokeinterface 401 3 0
    //   959: iconst_1
    //   960: putstatic 403	com/tencent/mobileqq/config/QConfigServlet:f	Z
    //   963: iload 9
    //   965: ifeq +128 -> 1093
    //   968: iload 4
    //   970: iconst_3
    //   971: if_icmpge +122 -> 1093
    //   974: aload_1
    //   975: ifnull +118 -> 1093
    //   978: aload_1
    //   979: arraylength
    //   980: ifle +113 -> 1093
    //   983: new 70	java/lang/StringBuilder
    //   986: dup
    //   987: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   990: astore_2
    //   991: aload_2
    //   992: ldc_w 405
    //   995: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: pop
    //   999: aload_1
    //   1000: arraylength
    //   1001: istore 7
    //   1003: iload 6
    //   1005: istore 5
    //   1007: iload 5
    //   1009: iload 7
    //   1011: if_icmpge +29 -> 1040
    //   1014: aload_2
    //   1015: aload_1
    //   1016: iload 5
    //   1018: iaload
    //   1019: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1022: pop
    //   1023: aload_2
    //   1024: ldc_w 407
    //   1027: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: pop
    //   1031: iload 5
    //   1033: iconst_1
    //   1034: iadd
    //   1035: istore 5
    //   1037: goto -30 -> 1007
    //   1040: getstatic 68	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1043: iconst_1
    //   1044: aload_2
    //   1045: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1048: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1051: aload 14
    //   1053: getfield 410	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:cookies	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1056: invokevirtual 280	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1059: ifeq +548 -> 1607
    //   1062: aload 14
    //   1064: getfield 410	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:cookies	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1067: invokevirtual 108	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1070: invokevirtual 114	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1073: astore_2
    //   1074: goto +3 -> 1077
    //   1077: aload_1
    //   1078: getstatic 289	com/tencent/mobileqq/config/QConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1081: aload_2
    //   1082: iload 4
    //   1084: iconst_1
    //   1085: iadd
    //   1086: invokestatic 413	com/tencent/mobileqq/config/QConfigManager:a	([ILjava/lang/String;[BI)V
    //   1089: iconst_1
    //   1090: putstatic 415	com/tencent/mobileqq/config/QConfigServlet:g	Z
    //   1093: getstatic 420	android/os/Build$VERSION:SDK_INT	I
    //   1096: bipush 18
    //   1098: if_icmplt +11 -> 1109
    //   1101: aload_3
    //   1102: invokevirtual 425	android/os/HandlerThread:quitSafely	()Z
    //   1105: pop
    //   1106: goto +277 -> 1383
    //   1109: aload_3
    //   1110: invokevirtual 428	android/os/HandlerThread:quit	()Z
    //   1113: pop
    //   1114: goto +269 -> 1383
    //   1117: astore_1
    //   1118: goto +268 -> 1386
    //   1121: astore_1
    //   1122: goto +229 -> 1351
    //   1125: iload 9
    //   1127: ifne +22 -> 1149
    //   1130: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1133: ifeq +81 -> 1214
    //   1136: getstatic 68	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1139: iconst_2
    //   1140: ldc_w 430
    //   1143: invokestatic 174	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1146: goto +68 -> 1214
    //   1149: aload 14
    //   1151: getfield 302	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1154: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1157: ifeq +22 -> 1179
    //   1160: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1163: ifeq +51 -> 1214
    //   1166: getstatic 68	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1169: iconst_2
    //   1170: ldc_w 432
    //   1173: invokestatic 174	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1176: goto +38 -> 1214
    //   1179: aload 14
    //   1181: getfield 305	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1184: ifnull +14 -> 1198
    //   1187: aload 14
    //   1189: getfield 305	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1192: invokevirtual 66	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   1195: ifne +19 -> 1214
    //   1198: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1201: ifeq +13 -> 1214
    //   1204: getstatic 68	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1207: iconst_2
    //   1208: ldc_w 434
    //   1211: invokestatic 174	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1214: aload 16
    //   1216: arraylength
    //   1217: istore 6
    //   1219: iconst_0
    //   1220: istore 5
    //   1222: iload 5
    //   1224: iload 6
    //   1226: if_icmpge +77 -> 1303
    //   1229: aload 16
    //   1231: iload 5
    //   1233: iaload
    //   1234: istore 4
    //   1236: invokestatic 287	com/tencent/mobileqq/config/QConfigManager:a	()Lcom/tencent/mobileqq/config/QConfigManager;
    //   1239: iload 4
    //   1241: invokevirtual 322	com/tencent/mobileqq/config/QConfigManager:a	(I)Z
    //   1244: ifne +6 -> 1250
    //   1247: goto +382 -> 1629
    //   1250: invokestatic 287	com/tencent/mobileqq/config/QConfigManager:a	()Lcom/tencent/mobileqq/config/QConfigManager;
    //   1253: iload 4
    //   1255: invokevirtual 437	com/tencent/mobileqq/config/QConfigManager:a	(I)Lcom/tencent/mobileqq/config/IQConfigProcessor;
    //   1258: astore_2
    //   1259: aload_2
    //   1260: ifnull +369 -> 1629
    //   1263: aload 14
    //   1265: getfield 302	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1268: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1271: ifeq +341 -> 1612
    //   1274: bipush 254
    //   1276: istore 4
    //   1278: goto +3 -> 1281
    //   1281: iload 4
    //   1283: ifeq +346 -> 1629
    //   1286: aload_2
    //   1287: iload 4
    //   1289: invokevirtual 442	com/tencent/mobileqq/config/IQConfigProcessor:onReqFailed	(I)V
    //   1292: getstatic 444	com/tencent/mobileqq/config/QConfigServlet:jdField_a_of_type_Int	I
    //   1295: iconst_1
    //   1296: iadd
    //   1297: putstatic 444	com/tencent/mobileqq/config/QConfigServlet:jdField_a_of_type_Int	I
    //   1300: goto +329 -> 1629
    //   1303: aload_0
    //   1304: invokevirtual 294	com/tencent/mobileqq/config/QConfigServlet:a	()Lcom/tencent/mobileqq/config/IOldServletInjector;
    //   1307: aload_0
    //   1308: invokevirtual 338	com/tencent/mobileqq/config/QConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1311: aload 14
    //   1313: aload_1
    //   1314: aload 16
    //   1316: iload 9
    //   1318: invokeinterface 447 6 0
    //   1323: iconst_1
    //   1324: putstatic 449	com/tencent/mobileqq/config/QConfigServlet:d	Z
    //   1327: getstatic 420	android/os/Build$VERSION:SDK_INT	I
    //   1330: bipush 18
    //   1332: if_icmplt +11 -> 1343
    //   1335: aload_3
    //   1336: invokevirtual 425	android/os/HandlerThread:quitSafely	()Z
    //   1339: pop
    //   1340: goto +8 -> 1348
    //   1343: aload_3
    //   1344: invokevirtual 428	android/os/HandlerThread:quit	()Z
    //   1347: pop
    //   1348: aload_0
    //   1349: monitorexit
    //   1350: return
    //   1351: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1354: ifeq +14 -> 1368
    //   1357: getstatic 68	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1360: iconst_2
    //   1361: aload_1
    //   1362: invokevirtual 450	java/lang/Exception:toString	()Ljava/lang/String;
    //   1365: invokestatic 94	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1368: getstatic 420	android/os/Build$VERSION:SDK_INT	I
    //   1371: istore 4
    //   1373: iload 4
    //   1375: bipush 18
    //   1377: if_icmplt -268 -> 1109
    //   1380: goto -279 -> 1101
    //   1383: aload_0
    //   1384: monitorexit
    //   1385: return
    //   1386: getstatic 420	android/os/Build$VERSION:SDK_INT	I
    //   1389: bipush 18
    //   1391: if_icmplt +11 -> 1402
    //   1394: aload_3
    //   1395: invokevirtual 425	android/os/HandlerThread:quitSafely	()Z
    //   1398: pop
    //   1399: goto +8 -> 1407
    //   1402: aload_3
    //   1403: invokevirtual 428	android/os/HandlerThread:quit	()Z
    //   1406: pop
    //   1407: aload_1
    //   1408: athrow
    //   1409: astore_1
    //   1410: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1413: ifeq +45 -> 1458
    //   1416: getstatic 68	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1419: astore_2
    //   1420: new 70	java/lang/StringBuilder
    //   1423: dup
    //   1424: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   1427: astore 14
    //   1429: aload 14
    //   1431: ldc_w 452
    //   1434: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1437: pop
    //   1438: aload 14
    //   1440: aload_1
    //   1441: invokevirtual 453	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   1444: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1447: pop
    //   1448: aload_2
    //   1449: iconst_2
    //   1450: aload 14
    //   1452: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1455: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1458: getstatic 420	android/os/Build$VERSION:SDK_INT	I
    //   1461: bipush 18
    //   1463: if_icmplt +11 -> 1474
    //   1466: aload_3
    //   1467: invokevirtual 425	android/os/HandlerThread:quitSafely	()Z
    //   1470: pop
    //   1471: goto +8 -> 1479
    //   1474: aload_3
    //   1475: invokevirtual 428	android/os/HandlerThread:quit	()Z
    //   1478: pop
    //   1479: aload_0
    //   1480: monitorexit
    //   1481: return
    //   1482: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1485: ifeq +13 -> 1498
    //   1488: getstatic 68	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1491: iconst_2
    //   1492: ldc_w 455
    //   1495: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1498: aload_0
    //   1499: invokevirtual 294	com/tencent/mobileqq/config/QConfigServlet:a	()Lcom/tencent/mobileqq/config/IOldServletInjector;
    //   1502: aload 16
    //   1504: aload_2
    //   1505: invokeinterface 458 3 0
    //   1510: iconst_1
    //   1511: putstatic 460	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_Boolean	Z
    //   1514: getstatic 420	android/os/Build$VERSION:SDK_INT	I
    //   1517: bipush 18
    //   1519: if_icmplt +11 -> 1530
    //   1522: aload_3
    //   1523: invokevirtual 425	android/os/HandlerThread:quitSafely	()Z
    //   1526: pop
    //   1527: goto +8 -> 1535
    //   1530: aload_3
    //   1531: invokevirtual 428	android/os/HandlerThread:quit	()Z
    //   1534: pop
    //   1535: aload_0
    //   1536: monitorexit
    //   1537: return
    //   1538: iconst_1
    //   1539: putstatic 462	com/tencent/mobileqq/config/QConfigServlet:jdField_a_of_type_Boolean	Z
    //   1542: aload_3
    //   1543: invokevirtual 428	android/os/HandlerThread:quit	()Z
    //   1546: pop
    //   1547: aload_0
    //   1548: monitorexit
    //   1549: return
    //   1550: astore_1
    //   1551: aload_0
    //   1552: monitorexit
    //   1553: goto +5 -> 1558
    //   1556: aload_1
    //   1557: athrow
    //   1558: goto -2 -> 1556
    //   1561: aconst_null
    //   1562: astore 14
    //   1564: goto -1529 -> 35
    //   1567: aconst_null
    //   1568: astore_2
    //   1569: goto -1337 -> 232
    //   1572: iload 4
    //   1574: iconst_1
    //   1575: iadd
    //   1576: istore 4
    //   1578: goto -1192 -> 386
    //   1581: iload 5
    //   1583: iconst_1
    //   1584: iadd
    //   1585: istore 5
    //   1587: goto -839 -> 748
    //   1590: aconst_null
    //   1591: astore_1
    //   1592: iload 7
    //   1594: istore 4
    //   1596: goto -786 -> 810
    //   1599: aconst_null
    //   1600: astore_1
    //   1601: iconst_0
    //   1602: istore 4
    //   1604: goto -794 -> 810
    //   1607: aconst_null
    //   1608: astore_2
    //   1609: goto -532 -> 1077
    //   1612: iload 9
    //   1614: ifne +9 -> 1623
    //   1617: iconst_m1
    //   1618: istore 4
    //   1620: goto -339 -> 1281
    //   1623: iconst_0
    //   1624: istore 4
    //   1626: goto -345 -> 1281
    //   1629: iload 5
    //   1631: iconst_1
    //   1632: iadd
    //   1633: istore 5
    //   1635: goto -413 -> 1222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1638	0	this	QConfigServlet
    //   0	1638	1	paramIntent	Intent
    //   0	1638	2	paramFromServiceMsg	FromServiceMsg
    //   0	1638	3	paramHandlerThread	HandlerThread
    //   70	1555	4	i	int
    //   67	1567	5	j	int
    //   84	1143	6	k	int
    //   535	1058	7	m	int
    //   743	16	8	n	int
    //   164	1449	9	bool	boolean
    //   319	307	10	l1	long
    //   591	33	12	l2	long
    //   12	1551	14	localObject1	Object
    //   98	855	15	localObject2	Object
    //   56	1447	16	localObject3	Object
    //   472	443	17	localObject4	Object
    //   481	40	18	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   283	313	1117	finally
    //   316	338	1117	finally
    //   348	364	1117	finally
    //   373	383	1117	finally
    //   393	407	1117	finally
    //   414	424	1117	finally
    //   427	447	1117	finally
    //   450	528	1117	finally
    //   528	559	1117	finally
    //   562	642	1117	finally
    //   645	655	1117	finally
    //   660	695	1117	finally
    //   701	711	1117	finally
    //   716	745	1117	finally
    //   761	778	1117	finally
    //   784	807	1117	finally
    //   810	818	1117	finally
    //   818	922	1117	finally
    //   922	941	1117	finally
    //   944	963	1117	finally
    //   978	1003	1117	finally
    //   1014	1031	1117	finally
    //   1040	1074	1117	finally
    //   1077	1093	1117	finally
    //   1130	1146	1117	finally
    //   1149	1176	1117	finally
    //   1179	1198	1117	finally
    //   1198	1214	1117	finally
    //   1214	1219	1117	finally
    //   1236	1247	1117	finally
    //   1250	1259	1117	finally
    //   1263	1274	1117	finally
    //   1286	1300	1117	finally
    //   1303	1327	1117	finally
    //   1351	1368	1117	finally
    //   283	313	1121	java/lang/Exception
    //   316	338	1121	java/lang/Exception
    //   348	364	1121	java/lang/Exception
    //   373	383	1121	java/lang/Exception
    //   393	407	1121	java/lang/Exception
    //   414	424	1121	java/lang/Exception
    //   427	447	1121	java/lang/Exception
    //   450	528	1121	java/lang/Exception
    //   528	559	1121	java/lang/Exception
    //   562	642	1121	java/lang/Exception
    //   645	655	1121	java/lang/Exception
    //   660	695	1121	java/lang/Exception
    //   701	711	1121	java/lang/Exception
    //   716	745	1121	java/lang/Exception
    //   761	778	1121	java/lang/Exception
    //   784	807	1121	java/lang/Exception
    //   810	818	1121	java/lang/Exception
    //   818	922	1121	java/lang/Exception
    //   922	941	1121	java/lang/Exception
    //   944	963	1121	java/lang/Exception
    //   978	1003	1121	java/lang/Exception
    //   1014	1031	1121	java/lang/Exception
    //   1040	1074	1121	java/lang/Exception
    //   1077	1093	1121	java/lang/Exception
    //   1130	1146	1121	java/lang/Exception
    //   1149	1176	1121	java/lang/Exception
    //   1179	1198	1121	java/lang/Exception
    //   1198	1214	1121	java/lang/Exception
    //   1214	1219	1121	java/lang/Exception
    //   1236	1247	1121	java/lang/Exception
    //   1250	1259	1121	java/lang/Exception
    //   1263	1274	1121	java/lang/Exception
    //   1286	1300	1121	java/lang/Exception
    //   1303	1327	1121	java/lang/Exception
    //   196	206	1409	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   6	14	1550	finally
    //   17	32	1550	finally
    //   40	48	1550	finally
    //   51	69	1550	finally
    //   86	145	1550	finally
    //   154	166	1550	finally
    //   171	178	1550	finally
    //   181	196	1550	finally
    //   196	206	1550	finally
    //   206	229	1550	finally
    //   236	252	1550	finally
    //   252	263	1550	finally
    //   263	278	1550	finally
    //   1093	1101	1550	finally
    //   1101	1106	1550	finally
    //   1109	1114	1550	finally
    //   1327	1340	1550	finally
    //   1343	1348	1550	finally
    //   1368	1373	1550	finally
    //   1386	1399	1550	finally
    //   1402	1407	1550	finally
    //   1407	1409	1550	finally
    //   1410	1458	1550	finally
    //   1458	1471	1550	finally
    //   1474	1479	1550	finally
    //   1482	1498	1550	finally
    //   1498	1527	1550	finally
    //   1530	1535	1550	finally
    //   1538	1547	1550	finally
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("QConfigServlet", -2);
    localHandlerThread.start();
    new Handler(localHandlerThread.getLooper()).post(new QConfigServlet.2(this, paramIntent, paramFromServiceMsg, localHandlerThread));
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.QConfigServlet
 * JD-Core Version:    0.7.0.1
 */