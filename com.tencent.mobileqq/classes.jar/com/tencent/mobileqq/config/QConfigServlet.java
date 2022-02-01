package com.tencent.mobileqq.config;

import android.content.Intent;
import com.tencent.mobileqq.config.injectimpl.OldServletInjectorImpl;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QConfigServlet
  extends MSFServlet
{
  protected static int a;
  public static String a;
  @ConfigInject(configPath="/Foundation/QQCommon/src/main/resources/Inject_config_old_servlet.yml", version=1)
  public static ArrayList<Class<? extends IOldServletInjector>> a;
  protected static boolean a;
  protected static int b;
  private static final String b;
  protected static boolean b;
  protected static int c;
  protected static boolean c;
  protected static boolean d;
  protected static boolean e;
  protected static boolean f;
  protected static boolean g;
  
  static
  {
    jdField_b_of_type_JavaLangString = QConfigServlet.class.getSimpleName();
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 0;
    jdField_c_of_type_Int = 0;
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(OldServletInjectorImpl.class);
    jdField_a_of_type_JavaUtilArrayList.add(OldServletInjectorImpl.class);
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
    byte[] arrayOfByte = new byte[(int)l + 4];
    a(arrayOfByte, 0, 4L + l);
    System.arraycopy(paramReqGetConfig, 0, arrayOfByte, 4, (int)l);
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
    if (jdField_a_of_type_JavaUtilArrayList.size() != 0) {}
    for (;;)
    {
      try
      {
        IOldServletInjector localIOldServletInjector = (IOldServletInjector)((Class)jdField_a_of_type_JavaUtilArrayList.get(0)).newInstance();
        return localIOldServletInjector;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
        return new QConfigServlet.1(this);
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
        continue;
      }
      QLog.i(jdField_b_of_type_JavaLangString, 2, "getOldServletInjector. mOldServletInjectors.size() = 0");
    }
  }
  
  public ConfigurationService.RespGetConfig a()
  {
    return new ConfigurationService.RespGetConfig();
  }
  
  /* Error */
  public void onReceive(Intent paramIntent, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 129
    //   3: invokevirtual 135	android/content/Intent:getIntArrayExtra	(Ljava/lang/String;)[I
    //   6: astore 14
    //   8: aload_2
    //   9: invokevirtual 141	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   12: istore 7
    //   14: aload 14
    //   16: ifnull +9 -> 25
    //   19: aload 14
    //   21: arraylength
    //   22: ifne +8 -> 30
    //   25: iconst_1
    //   26: putstatic 143	com/tencent/mobileqq/config/QConfigServlet:jdField_a_of_type_Boolean	Z
    //   29: return
    //   30: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   33: ifeq +67 -> 100
    //   36: aload 14
    //   38: arraylength
    //   39: istore 4
    //   41: iconst_0
    //   42: istore_3
    //   43: iload_3
    //   44: iload 4
    //   46: if_icmpge +54 -> 100
    //   49: aload 14
    //   51: iload_3
    //   52: iaload
    //   53: istore 5
    //   55: getstatic 31	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   58: iconst_2
    //   59: new 148	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   66: ldc 151
    //   68: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: iload 5
    //   73: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   76: ldc 160
    //   78: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload 14
    //   83: arraylength
    //   84: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   87: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 117	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: iload_3
    //   94: iconst_1
    //   95: iadd
    //   96: istore_3
    //   97: goto -54 -> 43
    //   100: aload_2
    //   101: invokevirtual 166	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   104: astore 13
    //   106: aload 13
    //   108: ifnull +10 -> 118
    //   111: aload 13
    //   113: arraylength
    //   114: iconst_4
    //   115: if_icmpge +35 -> 150
    //   118: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   121: ifeq +12 -> 133
    //   124: getstatic 31	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   127: iconst_2
    //   128: ldc 168
    //   130: invokestatic 170	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload_0
    //   134: invokevirtual 172	com/tencent/mobileqq/config/QConfigServlet:a	()Lcom/tencent/mobileqq/config/IOldServletInjector;
    //   137: aload 14
    //   139: aload_2
    //   140: invokeinterface 175 3 0
    //   145: iconst_1
    //   146: putstatic 177	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_Boolean	Z
    //   149: return
    //   150: aload_2
    //   151: aload 13
    //   153: invokestatic 179	com/tencent/mobileqq/config/QConfigServlet:a	([B)[B
    //   156: invokevirtual 183	com/tencent/qphone/base/remote/FromServiceMsg:putWupBuffer	([B)V
    //   159: aload_0
    //   160: invokevirtual 185	com/tencent/mobileqq/config/QConfigServlet:a	()Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;
    //   163: astore 13
    //   165: aload 13
    //   167: aload_2
    //   168: invokevirtual 166	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   171: invokevirtual 189	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   174: pop
    //   175: aload 13
    //   177: getfield 193	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:cookies_new	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   180: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   183: ifeq +196 -> 379
    //   186: aload 13
    //   188: getfield 193	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:cookies_new	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   191: invokevirtual 201	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   194: invokevirtual 204	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   197: astore_2
    //   198: aload_2
    //   199: ifnull +29 -> 228
    //   202: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +12 -> 217
    //   208: getstatic 31	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   211: iconst_2
    //   212: ldc 206
    //   214: invokestatic 170	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: invokestatic 211	com/tencent/mobileqq/config/QConfigManager:a	()Lcom/tencent/mobileqq/config/QConfigManager;
    //   220: getstatic 35	com/tencent/mobileqq/config/QConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   223: aload_2
    //   224: invokevirtual 214	com/tencent/mobileqq/config/QConfigManager:a	(Ljava/lang/String;[B)Z
    //   227: pop
    //   228: aload_0
    //   229: invokevirtual 172	com/tencent/mobileqq/config/QConfigServlet:a	()Lcom/tencent/mobileqq/config/IOldServletInjector;
    //   232: aload 13
    //   234: invokeinterface 217 2 0
    //   239: iconst_1
    //   240: putstatic 219	com/tencent/mobileqq/config/QConfigServlet:jdField_c_of_type_Boolean	Z
    //   243: iload 7
    //   245: ifeq +33 -> 278
    //   248: aload 13
    //   250: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   253: invokevirtual 227	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   256: ifne +22 -> 278
    //   259: aload 13
    //   261: getfield 231	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   264: ifnull +14 -> 278
    //   267: aload 13
    //   269: getfield 231	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   272: invokevirtual 234	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   275: ifne +265 -> 540
    //   278: iload 7
    //   280: ifne +104 -> 384
    //   283: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   286: ifeq +12 -> 298
    //   289: getstatic 31	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   292: iconst_2
    //   293: ldc 236
    //   295: invokestatic 117	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: aload 14
    //   300: arraylength
    //   301: istore 5
    //   303: iconst_0
    //   304: istore 4
    //   306: iload 4
    //   308: iload 5
    //   310: if_icmpge +205 -> 515
    //   313: aload 14
    //   315: iload 4
    //   317: iaload
    //   318: istore_3
    //   319: invokestatic 211	com/tencent/mobileqq/config/QConfigManager:a	()Lcom/tencent/mobileqq/config/QConfigManager;
    //   322: iload_3
    //   323: invokevirtual 239	com/tencent/mobileqq/config/QConfigManager:b	(I)Z
    //   326: istore 8
    //   328: iload 8
    //   330: ifne +139 -> 469
    //   333: iload 4
    //   335: iconst_1
    //   336: iadd
    //   337: istore 4
    //   339: goto -33 -> 306
    //   342: astore_1
    //   343: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   346: ifeq -317 -> 29
    //   349: getstatic 31	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   352: iconst_2
    //   353: new 148	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   360: ldc 241
    //   362: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload_1
    //   366: invokevirtual 242	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   369: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 170	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: return
    //   379: aconst_null
    //   380: astore_2
    //   381: goto -183 -> 198
    //   384: aload 13
    //   386: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   389: invokevirtual 227	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   392: ifeq +40 -> 432
    //   395: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   398: ifeq -100 -> 298
    //   401: getstatic 31	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   404: iconst_2
    //   405: ldc 244
    //   407: invokestatic 117	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   410: goto -112 -> 298
    //   413: astore_1
    //   414: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   417: ifeq -388 -> 29
    //   420: getstatic 31	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   423: iconst_2
    //   424: aload_1
    //   425: invokevirtual 245	java/lang/Exception:toString	()Ljava/lang/String;
    //   428: invokestatic 248	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   431: return
    //   432: aload 13
    //   434: getfield 231	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   437: ifnull +14 -> 451
    //   440: aload 13
    //   442: getfield 231	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   445: invokevirtual 234	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   448: ifne -150 -> 298
    //   451: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   454: ifeq -156 -> 298
    //   457: getstatic 31	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   460: iconst_2
    //   461: ldc 250
    //   463: invokestatic 117	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   466: goto -168 -> 298
    //   469: invokestatic 211	com/tencent/mobileqq/config/QConfigManager:a	()Lcom/tencent/mobileqq/config/QConfigManager;
    //   472: iload_3
    //   473: invokevirtual 253	com/tencent/mobileqq/config/QConfigManager:a	(I)Lcom/tencent/mobileqq/config/IQConfigProcessor;
    //   476: astore_2
    //   477: aload_2
    //   478: ifnull -145 -> 333
    //   481: aload 13
    //   483: getfield 223	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   486: invokevirtual 227	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   489: ifeq +769 -> 1258
    //   492: bipush 254
    //   494: istore_3
    //   495: iload_3
    //   496: ifeq -163 -> 333
    //   499: aload_2
    //   500: iload_3
    //   501: invokevirtual 259	com/tencent/mobileqq/config/IQConfigProcessor:onReqFailed	(I)V
    //   504: getstatic 37	com/tencent/mobileqq/config/QConfigServlet:jdField_a_of_type_Int	I
    //   507: iconst_1
    //   508: iadd
    //   509: putstatic 37	com/tencent/mobileqq/config/QConfigServlet:jdField_a_of_type_Int	I
    //   512: goto -179 -> 333
    //   515: aload_0
    //   516: invokevirtual 172	com/tencent/mobileqq/config/QConfigServlet:a	()Lcom/tencent/mobileqq/config/IOldServletInjector;
    //   519: aload_0
    //   520: invokevirtual 263	com/tencent/mobileqq/config/QConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   523: aload 13
    //   525: aload_1
    //   526: aload 14
    //   528: iload 7
    //   530: invokeinterface 266 6 0
    //   535: iconst_1
    //   536: putstatic 268	com/tencent/mobileqq/config/QConfigServlet:d	Z
    //   539: return
    //   540: invokestatic 272	java/lang/System:currentTimeMillis	()J
    //   543: lstore 9
    //   545: new 43	java/util/ArrayList
    //   548: dup
    //   549: aload 14
    //   551: arraylength
    //   552: invokespecial 274	java/util/ArrayList:<init>	(I)V
    //   555: astore 15
    //   557: aload 14
    //   559: arraylength
    //   560: istore 4
    //   562: iconst_0
    //   563: istore_3
    //   564: iload_3
    //   565: iload 4
    //   567: if_icmpge +25 -> 592
    //   570: aload 15
    //   572: aload 14
    //   574: iload_3
    //   575: iaload
    //   576: invokestatic 280	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   579: invokeinterface 283 2 0
    //   584: pop
    //   585: iload_3
    //   586: iconst_1
    //   587: iadd
    //   588: istore_3
    //   589: goto -25 -> 564
    //   592: aload 13
    //   594: getfield 231	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   597: invokevirtual 234	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   600: istore 4
    //   602: iconst_0
    //   603: istore_3
    //   604: iload_3
    //   605: iload 4
    //   607: if_icmpge +145 -> 752
    //   610: aload 13
    //   612: getfield 231	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   615: iload_3
    //   616: invokevirtual 286	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   619: checkcast 288	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config
    //   622: astore_2
    //   623: aload_2
    //   624: ifnonnull +6 -> 630
    //   627: goto +646 -> 1273
    //   630: aload_2
    //   631: getfield 291	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   634: invokevirtual 292	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   637: ifeq +636 -> 1273
    //   640: aload_2
    //   641: getfield 291	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   644: invokevirtual 227	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   647: istore 5
    //   649: invokestatic 211	com/tencent/mobileqq/config/QConfigManager:a	()Lcom/tencent/mobileqq/config/QConfigManager;
    //   652: iload 5
    //   654: invokevirtual 239	com/tencent/mobileqq/config/QConfigManager:b	(I)Z
    //   657: ifeq +616 -> 1273
    //   660: aload 15
    //   662: iload 5
    //   664: invokestatic 280	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   667: invokeinterface 295 2 0
    //   672: pop
    //   673: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   676: ifeq +42 -> 718
    //   679: getstatic 31	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   682: iconst_2
    //   683: new 148	java/lang/StringBuilder
    //   686: dup
    //   687: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   690: ldc_w 297
    //   693: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: iload 5
    //   698: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   701: ldc_w 299
    //   704: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: iload 4
    //   709: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   712: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: invokestatic 117	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   718: aload_2
    //   719: getfield 301	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   722: invokevirtual 227	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   725: istore 6
    //   727: invokestatic 211	com/tencent/mobileqq/config/QConfigManager:a	()Lcom/tencent/mobileqq/config/QConfigManager;
    //   730: iload 5
    //   732: iload 6
    //   734: aload_2
    //   735: getstatic 35	com/tencent/mobileqq/config/QConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   738: invokevirtual 304	com/tencent/mobileqq/config/QConfigManager:a	(IILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;Ljava/lang/String;)V
    //   741: getstatic 39	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_Int	I
    //   744: iconst_1
    //   745: iadd
    //   746: putstatic 39	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_Int	I
    //   749: goto +524 -> 1273
    //   752: aload_0
    //   753: invokevirtual 172	com/tencent/mobileqq/config/QConfigServlet:a	()Lcom/tencent/mobileqq/config/IOldServletInjector;
    //   756: aload_0
    //   757: invokevirtual 263	com/tencent/mobileqq/config/QConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   760: aload 13
    //   762: aload 15
    //   764: aload_1
    //   765: aload 14
    //   767: iload 7
    //   769: invokeinterface 307 7 0
    //   774: iconst_1
    //   775: putstatic 309	com/tencent/mobileqq/config/QConfigServlet:e	Z
    //   778: invokestatic 272	java/lang/System:currentTimeMillis	()J
    //   781: lstore 11
    //   783: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   786: ifeq +34 -> 820
    //   789: getstatic 31	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   792: iconst_2
    //   793: new 148	java/lang/StringBuilder
    //   796: dup
    //   797: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   800: ldc_w 311
    //   803: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: lload 11
    //   808: lload 9
    //   810: lsub
    //   811: invokevirtual 314	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   814: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   817: invokestatic 248	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   820: aconst_null
    //   821: astore_2
    //   822: aload_1
    //   823: ldc_w 316
    //   826: iconst_0
    //   827: invokevirtual 320	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   830: istore 7
    //   832: iload 7
    //   834: ifeq +455 -> 1289
    //   837: aload_1
    //   838: ldc_w 322
    //   841: iconst_0
    //   842: invokevirtual 326	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   845: istore 5
    //   847: getstatic 31	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   850: iconst_2
    //   851: iconst_2
    //   852: anewarray 328	java/lang/Object
    //   855: dup
    //   856: iconst_0
    //   857: ldc_w 330
    //   860: aastore
    //   861: dup
    //   862: iconst_1
    //   863: iload 5
    //   865: invokestatic 280	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   868: aastore
    //   869: invokestatic 333	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   872: iload 5
    //   874: istore_3
    //   875: aload_2
    //   876: astore_1
    //   877: iload 5
    //   879: iconst_3
    //   880: if_icmpge +118 -> 998
    //   883: aload 13
    //   885: getfield 337	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:next_req_types	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   888: invokevirtual 342	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   891: astore 14
    //   893: iload 5
    //   895: istore_3
    //   896: aload_2
    //   897: astore_1
    //   898: aload 14
    //   900: ifnull +98 -> 998
    //   903: iload 5
    //   905: istore_3
    //   906: aload_2
    //   907: astore_1
    //   908: aload 14
    //   910: invokeinterface 343 1 0
    //   915: ifle +83 -> 998
    //   918: aload 14
    //   920: invokeinterface 343 1 0
    //   925: newarray int
    //   927: astore_2
    //   928: aload 14
    //   930: invokeinterface 343 1 0
    //   935: istore 6
    //   937: iconst_0
    //   938: istore 4
    //   940: iload 5
    //   942: istore_3
    //   943: aload_2
    //   944: astore_1
    //   945: iload 4
    //   947: iload 6
    //   949: if_icmpge +49 -> 998
    //   952: aload 14
    //   954: iload 4
    //   956: invokeinterface 344 2 0
    //   961: checkcast 276	java/lang/Integer
    //   964: invokevirtual 347	java/lang/Integer:intValue	()I
    //   967: istore_3
    //   968: aload_2
    //   969: iload 4
    //   971: iload_3
    //   972: iastore
    //   973: aload 15
    //   975: invokeinterface 343 1 0
    //   980: ifle +300 -> 1280
    //   983: aload 15
    //   985: iload_3
    //   986: invokestatic 280	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   989: invokeinterface 295 2 0
    //   994: pop
    //   995: goto +285 -> 1280
    //   998: aload 15
    //   1000: invokeinterface 351 1 0
    //   1005: astore_2
    //   1006: aload_2
    //   1007: invokeinterface 356 1 0
    //   1012: ifeq +99 -> 1111
    //   1015: aload_2
    //   1016: invokeinterface 359 1 0
    //   1021: checkcast 276	java/lang/Integer
    //   1024: invokevirtual 347	java/lang/Integer:intValue	()I
    //   1027: istore 4
    //   1029: invokestatic 211	com/tencent/mobileqq/config/QConfigManager:a	()Lcom/tencent/mobileqq/config/QConfigManager;
    //   1032: iload 4
    //   1034: invokevirtual 239	com/tencent/mobileqq/config/QConfigManager:b	(I)Z
    //   1037: ifeq -31 -> 1006
    //   1040: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1043: ifeq +46 -> 1089
    //   1046: getstatic 31	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1049: iconst_2
    //   1050: new 148	java/lang/StringBuilder
    //   1053: dup
    //   1054: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   1057: ldc_w 361
    //   1060: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: iload 4
    //   1065: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1068: ldc 160
    //   1070: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: aload 15
    //   1075: invokeinterface 343 1 0
    //   1080: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1083: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1086: invokestatic 248	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1089: invokestatic 211	com/tencent/mobileqq/config/QConfigManager:a	()Lcom/tencent/mobileqq/config/QConfigManager;
    //   1092: iload 4
    //   1094: getstatic 35	com/tencent/mobileqq/config/QConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1097: invokevirtual 364	com/tencent/mobileqq/config/QConfigManager:a	(ILjava/lang/String;)V
    //   1100: getstatic 41	com/tencent/mobileqq/config/QConfigServlet:jdField_c_of_type_Int	I
    //   1103: iconst_1
    //   1104: iadd
    //   1105: putstatic 41	com/tencent/mobileqq/config/QConfigServlet:jdField_c_of_type_Int	I
    //   1108: goto -102 -> 1006
    //   1111: aload_0
    //   1112: invokevirtual 172	com/tencent/mobileqq/config/QConfigServlet:a	()Lcom/tencent/mobileqq/config/IOldServletInjector;
    //   1115: aload_0
    //   1116: invokevirtual 263	com/tencent/mobileqq/config/QConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1119: aload 15
    //   1121: invokeinterface 367 3 0
    //   1126: iconst_1
    //   1127: putstatic 369	com/tencent/mobileqq/config/QConfigServlet:f	Z
    //   1130: iload 7
    //   1132: ifeq -1103 -> 29
    //   1135: iload_3
    //   1136: iconst_3
    //   1137: if_icmpge -1108 -> 29
    //   1140: aload_1
    //   1141: ifnull -1112 -> 29
    //   1144: aload_1
    //   1145: arraylength
    //   1146: ifle -1117 -> 29
    //   1149: new 148	java/lang/StringBuilder
    //   1152: dup
    //   1153: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   1156: astore_2
    //   1157: aload_2
    //   1158: ldc_w 371
    //   1161: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1164: pop
    //   1165: aload_1
    //   1166: arraylength
    //   1167: istore 5
    //   1169: iconst_0
    //   1170: istore 4
    //   1172: iload 4
    //   1174: iload 5
    //   1176: if_icmpge +27 -> 1203
    //   1179: aload_2
    //   1180: aload_1
    //   1181: iload 4
    //   1183: iaload
    //   1184: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1187: ldc_w 373
    //   1190: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: pop
    //   1194: iload 4
    //   1196: iconst_1
    //   1197: iadd
    //   1198: istore 4
    //   1200: goto -28 -> 1172
    //   1203: getstatic 31	com/tencent/mobileqq/config/QConfigServlet:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1206: iconst_1
    //   1207: aload_2
    //   1208: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1211: invokestatic 170	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1214: aload 13
    //   1216: getfield 376	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:cookies	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1219: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1222: ifeq +31 -> 1253
    //   1225: aload 13
    //   1227: getfield 376	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:cookies	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1230: invokevirtual 201	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1233: invokevirtual 204	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1236: astore_2
    //   1237: aload_1
    //   1238: getstatic 35	com/tencent/mobileqq/config/QConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1241: aload_2
    //   1242: iload_3
    //   1243: iconst_1
    //   1244: iadd
    //   1245: invokestatic 379	com/tencent/mobileqq/config/QConfigManager:a	([ILjava/lang/String;[BI)V
    //   1248: iconst_1
    //   1249: putstatic 381	com/tencent/mobileqq/config/QConfigServlet:g	Z
    //   1252: return
    //   1253: aconst_null
    //   1254: astore_2
    //   1255: goto -18 -> 1237
    //   1258: iload 7
    //   1260: ifne +8 -> 1268
    //   1263: iconst_m1
    //   1264: istore_3
    //   1265: goto -770 -> 495
    //   1268: iconst_0
    //   1269: istore_3
    //   1270: goto -775 -> 495
    //   1273: iload_3
    //   1274: iconst_1
    //   1275: iadd
    //   1276: istore_3
    //   1277: goto -673 -> 604
    //   1280: iload 4
    //   1282: iconst_1
    //   1283: iadd
    //   1284: istore 4
    //   1286: goto -346 -> 940
    //   1289: iconst_0
    //   1290: istore_3
    //   1291: aload_2
    //   1292: astore_1
    //   1293: goto -295 -> 998
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1296	0	this	QConfigServlet
    //   0	1296	1	paramIntent	Intent
    //   0	1296	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   42	1249	3	i	int
    //   39	1246	4	j	int
    //   53	1124	5	k	int
    //   725	225	6	m	int
    //   12	1247	7	bool1	boolean
    //   326	3	8	bool2	boolean
    //   543	266	9	l1	long
    //   781	26	11	l2	long
    //   104	1122	13	localObject1	Object
    //   6	947	14	localObject2	Object
    //   555	565	15	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   165	175	342	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   248	278	413	java/lang/Exception
    //   283	298	413	java/lang/Exception
    //   298	303	413	java/lang/Exception
    //   319	328	413	java/lang/Exception
    //   384	410	413	java/lang/Exception
    //   432	451	413	java/lang/Exception
    //   451	466	413	java/lang/Exception
    //   469	477	413	java/lang/Exception
    //   481	492	413	java/lang/Exception
    //   499	512	413	java/lang/Exception
    //   515	539	413	java/lang/Exception
    //   540	562	413	java/lang/Exception
    //   570	585	413	java/lang/Exception
    //   592	602	413	java/lang/Exception
    //   610	623	413	java/lang/Exception
    //   630	718	413	java/lang/Exception
    //   718	749	413	java/lang/Exception
    //   752	820	413	java/lang/Exception
    //   822	832	413	java/lang/Exception
    //   837	872	413	java/lang/Exception
    //   883	893	413	java/lang/Exception
    //   908	937	413	java/lang/Exception
    //   952	968	413	java/lang/Exception
    //   973	995	413	java/lang/Exception
    //   998	1006	413	java/lang/Exception
    //   1006	1089	413	java/lang/Exception
    //   1089	1108	413	java/lang/Exception
    //   1111	1130	413	java/lang/Exception
    //   1144	1169	413	java/lang/Exception
    //   1179	1194	413	java/lang/Exception
    //   1203	1237	413	java/lang/Exception
    //   1237	1252	413	java/lang/Exception
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int[] arrayOfInt1 = paramIntent.getIntArrayExtra("k_cmd_type");
    if ((arrayOfInt1 == null) || (arrayOfInt1.length == 0)) {
      return;
    }
    int j;
    if (QLog.isColorLevel())
    {
      j = arrayOfInt1.length;
      i = 0;
      while (i < j)
      {
        k = arrayOfInt1[i];
        QLog.i(jdField_b_of_type_JavaLangString, 2, "onSend. cmd: " + k + ",length: " + arrayOfInt1.length);
        i += 1;
      }
    }
    Object localObject1 = new ConfigurationService.ReqGetConfig();
    Object localObject3 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject4 = new ArrayList();
    int k = arrayOfInt1.length;
    int i = 0;
    if (i < k)
    {
      int m = arrayOfInt1[i];
      if (!QConfigManager.a().b(m)) {
        ((List)localObject3).add(Integer.valueOf(m));
      }
      for (;;)
      {
        i += 1;
        break;
        ConfigurationService.ConfigSeq localConfigSeq = new ConfigurationService.ConfigSeq();
        localConfigSeq.type.set(m);
        try
        {
          IQConfigProcessor localIQConfigProcessor = QConfigManager.a().a(m);
          if (localIQConfigProcessor != null)
          {
            j = localIQConfigProcessor.onSend(QConfigManager.a().a(m, jdField_a_of_type_JavaLangString));
            bool = QConfigManager.a().a(getAppRuntime(), m);
            if (bool)
            {
              QConfigManager.a().a(m, 0);
              j = 0;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QConfigManager", 2, "[Send] t=" + m + " v=" + j + " up=" + bool);
            }
            localConfigSeq.version.set(j);
            if (QConfigManager.a().a(m)) {
              localConfigSeq.compress.set(1);
            }
            ((List)localObject2).add(localConfigSeq);
            ((List)localObject4).add(Integer.valueOf(m));
          }
        }
        catch (Exception localException)
        {
          QLog.d("QConfigManager", 1, "exception " + m, localException);
        }
      }
    }
    int[] arrayOfInt2 = new int[((List)localObject3).size()];
    i = 0;
    while (i < ((List)localObject3).size())
    {
      arrayOfInt2[i] = ((Integer)((List)localObject3).get(i)).intValue();
      i += 1;
    }
    a().a(getAppRuntime(), paramIntent, (ConfigurationService.ReqGetConfig)localObject1, arrayOfInt2, (List)localObject2, (List)localObject4, jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      i = ((List)localObject4).size();
      localObject3 = ((List)localObject4).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Integer)((Iterator)localObject3).next();
        QLog.d(jdField_b_of_type_JavaLangString, 2, "addAllConfigs|send type: " + localObject4 + ",length: " + i);
      }
    }
    ((ConfigurationService.ReqGetConfig)localObject1).setHasFlag(true);
    ((ConfigurationService.ReqGetConfig)localObject1).seq_list.addAll((Collection)localObject2);
    boolean bool = paramIntent.getBooleanExtra("key_is_page_req", false);
    localObject2 = ((ConfigurationService.ReqGetConfig)localObject1).is_page_req;
    if (bool) {}
    for (i = 1;; i = 0)
    {
      ((PBInt32Field)localObject2).set(i);
      localObject2 = paramIntent.getByteArrayExtra("key_cookies");
      if (localObject2 != null) {
        ((ConfigurationService.ReqGetConfig)localObject1).cookies.set(ByteStringMicro.copyFrom((byte[])localObject2));
      }
      ((ConfigurationService.ReqGetConfig)localObject1).version.set(1);
      localObject2 = QConfigManager.a().a(jdField_a_of_type_JavaLangString);
      if (localObject2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, "read cookie_new, cookie_new != null");
        }
        ((ConfigurationService.ReqGetConfig)localObject1).cookies_new.set(ByteStringMicro.copyFrom((byte[])localObject2));
      }
      localObject1 = a((ConfigurationService.ReqGetConfig)localObject1);
      if (localObject1.length > 0) {
        paramPacket.putSendData((byte[])localObject1);
      }
      if (!a().a(getAppRuntime(), arrayOfInt1)) {
        break;
      }
      paramPacket.setSSOCommand("ConfigurationService.ReqGetConfigNoLogin");
      paramIntent.putExtra("k_cmd_name", "ConfigurationService.ReqGetConfigNoLogin");
      return;
    }
    paramPacket.setSSOCommand("ConfigurationService.ReqGetConfig");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.QConfigServlet
 * JD-Core Version:    0.7.0.1
 */