package com.tencent.mobileqq.config;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.BaseConf;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import protocol.KQQConfig.GetResourceRespInfoV2;

public class ConfigManager
  implements CommandListener, IHttpCommunicatorListener
{
  public static final byte[] a = { -16, 68, 31, 95, -12, 45, -91, -113, -36, -9, -108, -102, -70, 98, -44, 17 };
  private static int e = 1;
  public ConfigManager.UpdateStruct b = new ConfigManager.UpdateStruct(this);
  String c;
  private Timer d;
  private boolean f = false;
  private int[] g = new int[0];
  private File h;
  private String i;
  
  public ConfigManager(Context paramContext, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramContext.getFilesDir().getAbsolutePath());
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append(paramString);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new File((String)localObject1);
    try
    {
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdirs();
      }
      label90:
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramContext.getFilesDir().getAbsolutePath());
      ((StringBuilder)localObject2).append("/");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("/");
      ((StringBuilder)localObject2).append("qq_config.dat");
      this.c = ((StringBuilder)localObject2).toString();
      if (QLog.isDevelopLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("savePointFilePath == ");
        paramContext.append(this.c);
        QLog.i("SPLASH_ConfigServlet", 4, paramContext.toString());
      }
      this.h = new File((String)localObject1, "qq_config.dat");
      try
      {
        if (!this.h.exists()) {
          this.h.createNewFile();
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      this.d = ThreadManager.getTimer();
      this.i = paramString;
      return;
    }
    catch (Exception localException)
    {
      break label90;
    }
  }
  
  public static final int a()
  {
    int j = e;
    e = j + 1;
    return j;
  }
  
  public static ResourcePluginInfo a(EntityManager paramEntityManager, boolean paramBoolean, GetResourceRespInfoV2 paramGetResourceRespInfoV2)
  {
    ResourcePluginInfo localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = paramGetResourceRespInfoV2.strPkgName;
    localResourcePluginInfo.strResName = paramGetResourceRespInfoV2.strResName;
    if (paramBoolean) {
      localObject1 = paramGetResourceRespInfoV2.strResURL_big;
    } else {
      localObject1 = paramGetResourceRespInfoV2.strResURL_small;
    }
    localResourcePluginInfo.strResURL = ((String)localObject1);
    localResourcePluginInfo.uiCurVer = paramGetResourceRespInfoV2.uiNewVer;
    localResourcePluginInfo.sLanType = paramGetResourceRespInfoV2.sLanType;
    localResourcePluginInfo.sResSubType = paramGetResourceRespInfoV2.sResSubType;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("plugin config xml:");
      ((StringBuilder)localObject1).append(paramGetResourceRespInfoV2.strResConf);
      QLog.i("ConfigManager", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = ConfigParser.b(paramGetResourceRespInfoV2.strResConf);
    if (localObject1 != null)
    {
      localResourcePluginInfo.strGotoUrl = ((String)((HashMap)localObject1).get("pluginEntranceUrl"));
      localObject2 = (String)((HashMap)localObject1).get("newswitch");
      if (localObject2 == null) {}
    }
    try
    {
      if ((byte)Integer.parseInt((String)localObject2) == 0) {
        localResourcePluginInfo.isNew = 1;
      } else {
        localResourcePluginInfo.isNew = 0;
      }
    }
    catch (Exception localException1)
    {
      label183:
      label207:
      break label183;
    }
    Object localObject2 = (String)((HashMap)localObject1).get("pluginType");
    try
    {
      localResourcePluginInfo.lebaSearchResultType = Integer.parseInt((String)localObject2);
    }
    catch (Exception localException2)
    {
      break label207;
    }
    localResourcePluginInfo.lebaSearchResultType = -1;
    localResourcePluginInfo.pluginSetTips = ((String)((HashMap)localObject1).get("pluginSetTips"));
    localResourcePluginInfo.pluginBg = ((String)((HashMap)localObject1).get("bgcolor"));
    localObject1 = (String)((HashMap)localObject1).get("fullConfig");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      if (Integer.parseInt((String)localObject1) == 1) {
        localResourcePluginInfo.enableFlag(1);
      } else {
        localResourcePluginInfo.disableFlag(1);
      }
    }
    catch (Exception localException3)
    {
      label281:
      label357:
      break label281;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("fullConfig ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("WholePeopleLebaEntryChecker", 2, ((StringBuilder)localObject2).toString());
      break label357;
      localResourcePluginInfo.strGotoUrl = "";
      localResourcePluginInfo.isNew = 0;
      localResourcePluginInfo.lebaSearchResultType = -1;
      localResourcePluginInfo.pluginSetTips = "";
      localResourcePluginInfo.pluginBg = null;
    }
    localResourcePluginInfo.strNewPluginDesc = paramGetResourceRespInfoV2.strNewPluginDesc;
    localResourcePluginInfo.strNewPluginURL = paramGetResourceRespInfoV2.strNewPluginURL;
    localResourcePluginInfo.sPriority = paramGetResourceRespInfoV2.sPriority;
    localResourcePluginInfo.strResDesc = paramGetResourceRespInfoV2.strResDesc;
    localResourcePluginInfo.cCanChangeState = paramGetResourceRespInfoV2.cCanChangeState;
    localResourcePluginInfo.cDefaultState = paramGetResourceRespInfoV2.cDefaultState;
    localResourcePluginInfo.uiResId = paramGetResourceRespInfoV2.uiResId;
    if (localResourcePluginInfo.cDefaultState == 0) {
      localResourcePluginInfo.cLocalState = 1;
    } else if (localResourcePluginInfo.cDefaultState == 1) {
      localResourcePluginInfo.cLocalState = 0;
    }
    localResourcePluginInfo.iPluginType = paramGetResourceRespInfoV2.iPluginType;
    ResourcePluginInfo.persistOrReplace(paramEntityManager, localResourcePluginInfo);
    return localResourcePluginInfo;
  }
  
  static String a(String paramString, int paramInt)
  {
    Object localObject = paramString;
    if (paramInt > 0)
    {
      if (paramString.indexOf("g_q=") != -1) {
        return paramString;
      }
      if (paramString.indexOf('?') > 0)
      {
        if (paramString.endsWith("g_q="))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(paramInt);
          return ((StringBuilder)localObject).toString();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("&g_q=");
        ((StringBuilder)localObject).append(paramInt);
        return ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("?g_q=");
      ((StringBuilder)localObject).append(paramInt);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  private void a(BaseConf paramBaseConf, DataInputStream paramDataInputStream)
  {
    paramBaseConf.a(paramDataInputStream);
  }
  
  public void a(BaseConf paramBaseConf, DataOutputStream paramDataOutputStream)
  {
    paramBaseConf.a(paramDataOutputStream);
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 120	com/tencent/mobileqq/config/ConfigManager:h	Ljava/io/File;
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 7
    //   9: aload 4
    //   11: ifnull +69 -> 80
    //   14: aload 4
    //   16: invokevirtual 96	java/io/File:exists	()Z
    //   19: ifeq +61 -> 80
    //   22: aload_0
    //   23: getfield 120	com/tencent/mobileqq/config/ConfigManager:h	Ljava/io/File;
    //   26: invokevirtual 323	java/io/File:canRead	()Z
    //   29: ifeq +51 -> 80
    //   32: aload_0
    //   33: getfield 120	com/tencent/mobileqq/config/ConfigManager:h	Ljava/io/File;
    //   36: invokevirtual 327	java/io/File:length	()J
    //   39: lconst_0
    //   40: lcmp
    //   41: ifle +39 -> 80
    //   44: new 329	java/io/FileInputStream
    //   47: dup
    //   48: aload_0
    //   49: getfield 120	com/tencent/mobileqq/config/ConfigManager:h	Ljava/io/File;
    //   52: invokespecial 332	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: astore 5
    //   57: new 334	java/io/BufferedInputStream
    //   60: dup
    //   61: aload 5
    //   63: invokespecial 337	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: astore 4
    //   68: goto +19 -> 87
    //   71: aconst_null
    //   72: astore 5
    //   74: aconst_null
    //   75: astore 4
    //   77: goto +10 -> 87
    //   80: aconst_null
    //   81: astore 5
    //   83: aload 5
    //   85: astore 4
    //   87: iconst_0
    //   88: istore_2
    //   89: iconst_1
    //   90: istore_3
    //   91: aload 7
    //   93: astore 6
    //   95: aload 4
    //   97: ifnull +218 -> 315
    //   100: aload 7
    //   102: astore 6
    //   104: aload 4
    //   106: invokevirtual 340	java/io/BufferedInputStream:available	()I
    //   109: ifle +206 -> 315
    //   112: new 342	java/io/DataInputStream
    //   115: dup
    //   116: aload 4
    //   118: invokespecial 343	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   121: astore 6
    //   123: iconst_0
    //   124: istore_1
    //   125: aload 6
    //   127: astore 7
    //   129: iload_1
    //   130: getstatic 348	com/tencent/mobileqq/config/Config:e	[Lcom/tencent/mobileqq/config/struct/BaseConf;
    //   133: arraylength
    //   134: if_icmpge +79 -> 213
    //   137: aload 6
    //   139: astore 7
    //   141: getstatic 348	com/tencent/mobileqq/config/Config:e	[Lcom/tencent/mobileqq/config/struct/BaseConf;
    //   144: iload_1
    //   145: aaload
    //   146: astore 8
    //   148: aload 6
    //   150: astore 7
    //   152: aload_0
    //   153: aload 8
    //   155: aload 6
    //   157: invokespecial 350	com/tencent/mobileqq/config/ConfigManager:a	(Lcom/tencent/mobileqq/config/struct/BaseConf;Ljava/io/DataInputStream;)V
    //   160: aload 6
    //   162: astore 7
    //   164: aload 8
    //   166: getfield 352	com/tencent/mobileqq/config/struct/BaseConf:e	B
    //   169: iconst_1
    //   170: if_icmpeq +15 -> 185
    //   173: aload 6
    //   175: astore 7
    //   177: aload 8
    //   179: getfield 352	com/tencent/mobileqq/config/struct/BaseConf:e	B
    //   182: ifne +24 -> 206
    //   185: aload 6
    //   187: astore 7
    //   189: aload 8
    //   191: invokevirtual 354	com/tencent/mobileqq/config/struct/BaseConf:c	()Z
    //   194: ifeq +12 -> 206
    //   197: aload 6
    //   199: astore 7
    //   201: aload 8
    //   203: invokevirtual 356	com/tencent/mobileqq/config/struct/BaseConf:a	()V
    //   206: iload_1
    //   207: iconst_1
    //   208: iadd
    //   209: istore_1
    //   210: goto -85 -> 125
    //   213: goto +102 -> 315
    //   216: astore 8
    //   218: goto +16 -> 234
    //   221: astore 6
    //   223: aconst_null
    //   224: astore 7
    //   226: goto +56 -> 282
    //   229: astore 8
    //   231: aconst_null
    //   232: astore 6
    //   234: aload 6
    //   236: astore 7
    //   238: aload 8
    //   240: invokevirtual 126	java/lang/Exception:printStackTrace	()V
    //   243: aload 5
    //   245: ifnull +8 -> 253
    //   248: aload 5
    //   250: invokevirtual 359	java/io/FileInputStream:close	()V
    //   253: aload 4
    //   255: ifnull +8 -> 263
    //   258: aload 4
    //   260: invokevirtual 360	java/io/BufferedInputStream:close	()V
    //   263: iload_3
    //   264: istore_1
    //   265: aload 6
    //   267: ifnull +80 -> 347
    //   270: aload 6
    //   272: invokevirtual 361	java/io/DataInputStream:close	()V
    //   275: iload_3
    //   276: istore_1
    //   277: goto +70 -> 347
    //   280: astore 6
    //   282: aload 5
    //   284: ifnull +8 -> 292
    //   287: aload 5
    //   289: invokevirtual 359	java/io/FileInputStream:close	()V
    //   292: aload 4
    //   294: ifnull +8 -> 302
    //   297: aload 4
    //   299: invokevirtual 360	java/io/BufferedInputStream:close	()V
    //   302: aload 7
    //   304: ifnull +8 -> 312
    //   307: aload 7
    //   309: invokevirtual 361	java/io/DataInputStream:close	()V
    //   312: aload 6
    //   314: athrow
    //   315: aload 5
    //   317: ifnull +8 -> 325
    //   320: aload 5
    //   322: invokevirtual 359	java/io/FileInputStream:close	()V
    //   325: aload 4
    //   327: ifnull +8 -> 335
    //   330: aload 4
    //   332: invokevirtual 360	java/io/BufferedInputStream:close	()V
    //   335: aload 6
    //   337: ifnull +8 -> 345
    //   340: aload 6
    //   342: invokevirtual 361	java/io/DataInputStream:close	()V
    //   345: iconst_0
    //   346: istore_1
    //   347: iload_1
    //   348: ifeq +28 -> 376
    //   351: iload_2
    //   352: istore_1
    //   353: iload_1
    //   354: getstatic 348	com/tencent/mobileqq/config/Config:e	[Lcom/tencent/mobileqq/config/struct/BaseConf;
    //   357: arraylength
    //   358: if_icmpge +18 -> 376
    //   361: getstatic 348	com/tencent/mobileqq/config/Config:e	[Lcom/tencent/mobileqq/config/struct/BaseConf;
    //   364: iload_1
    //   365: aaload
    //   366: invokevirtual 356	com/tencent/mobileqq/config/struct/BaseConf:a	()V
    //   369: iload_1
    //   370: iconst_1
    //   371: iadd
    //   372: istore_1
    //   373: goto -20 -> 353
    //   376: return
    //   377: astore 4
    //   379: goto -308 -> 71
    //   382: astore 4
    //   384: goto -310 -> 74
    //   387: astore 5
    //   389: goto -136 -> 253
    //   392: astore 4
    //   394: goto -131 -> 263
    //   397: astore 4
    //   399: iload_3
    //   400: istore_1
    //   401: goto -54 -> 347
    //   404: astore 5
    //   406: goto -114 -> 292
    //   409: astore 4
    //   411: goto -109 -> 302
    //   414: astore 4
    //   416: goto -104 -> 312
    //   419: astore 5
    //   421: goto -96 -> 325
    //   424: astore 4
    //   426: goto -91 -> 335
    //   429: astore 4
    //   431: goto -86 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	this	ConfigManager
    //   124	277	1	j	int
    //   88	264	2	k	int
    //   90	310	3	m	int
    //   4	327	4	localObject1	Object
    //   377	1	4	localException1	Exception
    //   382	1	4	localException2	Exception
    //   392	1	4	localException3	Exception
    //   397	1	4	localException4	Exception
    //   409	1	4	localException5	Exception
    //   414	1	4	localException6	Exception
    //   424	1	4	localException7	Exception
    //   429	1	4	localException8	Exception
    //   55	266	5	localFileInputStream	java.io.FileInputStream
    //   387	1	5	localException9	Exception
    //   404	1	5	localException10	Exception
    //   419	1	5	localException11	Exception
    //   93	105	6	localObject2	Object
    //   221	1	6	localObject3	Object
    //   232	39	6	localObject4	Object
    //   280	61	6	localObject5	Object
    //   7	301	7	localObject6	Object
    //   146	56	8	localBaseConf	BaseConf
    //   216	1	8	localException12	Exception
    //   229	10	8	localException13	Exception
    // Exception table:
    //   from	to	target	type
    //   129	137	216	java/lang/Exception
    //   141	148	216	java/lang/Exception
    //   152	160	216	java/lang/Exception
    //   164	173	216	java/lang/Exception
    //   177	185	216	java/lang/Exception
    //   189	197	216	java/lang/Exception
    //   201	206	216	java/lang/Exception
    //   104	123	221	finally
    //   104	123	229	java/lang/Exception
    //   129	137	280	finally
    //   141	148	280	finally
    //   152	160	280	finally
    //   164	173	280	finally
    //   177	185	280	finally
    //   189	197	280	finally
    //   201	206	280	finally
    //   238	243	280	finally
    //   44	57	377	java/lang/Exception
    //   57	68	382	java/lang/Exception
    //   248	253	387	java/lang/Exception
    //   258	263	392	java/lang/Exception
    //   270	275	397	java/lang/Exception
    //   287	292	404	java/lang/Exception
    //   297	302	409	java/lang/Exception
    //   307	312	414	java/lang/Exception
    //   320	325	419	java/lang/Exception
    //   330	335	424	java/lang/Exception
    //   340	345	429	java/lang/Exception
  }
  
  public void c()
  {
    try
    {
      if ((this.h != null) && (this.h.exists()))
      {
        this.h.delete();
        this.h = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 76	java/io/File
    //   4: dup
    //   5: aload_0
    //   6: getfield 103	com/tencent/mobileqq/config/ConfigManager:c	Ljava/lang/String;
    //   9: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: putfield 120	com/tencent/mobileqq/config/ConfigManager:h	Ljava/io/File;
    //   15: aload_0
    //   16: getfield 120	com/tencent/mobileqq/config/ConfigManager:h	Ljava/io/File;
    //   19: invokevirtual 96	java/io/File:exists	()Z
    //   22: ifne +19 -> 41
    //   25: aload_0
    //   26: getfield 120	com/tencent/mobileqq/config/ConfigManager:h	Ljava/io/File;
    //   29: invokevirtual 123	java/io/File:createNewFile	()Z
    //   32: pop
    //   33: goto +8 -> 41
    //   36: astore_2
    //   37: aload_2
    //   38: invokevirtual 126	java/lang/Exception:printStackTrace	()V
    //   41: aload_0
    //   42: getfield 120	com/tencent/mobileqq/config/ConfigManager:h	Ljava/io/File;
    //   45: astore_2
    //   46: aload_2
    //   47: ifnull +160 -> 207
    //   50: aload_2
    //   51: invokevirtual 96	java/io/File:exists	()Z
    //   54: ifeq +153 -> 207
    //   57: aconst_null
    //   58: astore_2
    //   59: new 366	java/io/BufferedOutputStream
    //   62: dup
    //   63: new 368	java/io/FileOutputStream
    //   66: dup
    //   67: aload_0
    //   68: getfield 120	com/tencent/mobileqq/config/ConfigManager:h	Ljava/io/File;
    //   71: invokespecial 369	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   74: invokespecial 372	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   77: astore_3
    //   78: new 374	java/io/DataOutputStream
    //   81: dup
    //   82: aload_3
    //   83: invokespecial 375	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   86: astore 4
    //   88: iconst_0
    //   89: istore_1
    //   90: iload_1
    //   91: getstatic 348	com/tencent/mobileqq/config/Config:e	[Lcom/tencent/mobileqq/config/struct/BaseConf;
    //   94: arraylength
    //   95: if_icmpge +21 -> 116
    //   98: aload_0
    //   99: getstatic 348	com/tencent/mobileqq/config/Config:e	[Lcom/tencent/mobileqq/config/struct/BaseConf;
    //   102: iload_1
    //   103: aaload
    //   104: aload 4
    //   106: invokevirtual 377	com/tencent/mobileqq/config/ConfigManager:a	(Lcom/tencent/mobileqq/config/struct/BaseConf;Ljava/io/DataOutputStream;)V
    //   109: iload_1
    //   110: iconst_1
    //   111: iadd
    //   112: istore_1
    //   113: goto -23 -> 90
    //   116: aload_3
    //   117: invokevirtual 378	java/io/BufferedOutputStream:close	()V
    //   120: aload 4
    //   122: invokevirtual 379	java/io/DataOutputStream:close	()V
    //   125: return
    //   126: astore_2
    //   127: aload_3
    //   128: astore 5
    //   130: aload 4
    //   132: astore_3
    //   133: goto +28 -> 161
    //   136: aload 4
    //   138: astore_2
    //   139: goto +44 -> 183
    //   142: astore_2
    //   143: aconst_null
    //   144: astore 4
    //   146: aload_3
    //   147: astore 5
    //   149: aload 4
    //   151: astore_3
    //   152: goto +9 -> 161
    //   155: astore_2
    //   156: aconst_null
    //   157: astore_3
    //   158: aload_3
    //   159: astore 5
    //   161: aload 5
    //   163: ifnull +8 -> 171
    //   166: aload 5
    //   168: invokevirtual 378	java/io/BufferedOutputStream:close	()V
    //   171: aload_3
    //   172: ifnull +7 -> 179
    //   175: aload_3
    //   176: invokevirtual 379	java/io/DataOutputStream:close	()V
    //   179: aload_2
    //   180: athrow
    //   181: aconst_null
    //   182: astore_3
    //   183: aload_3
    //   184: ifnull +7 -> 191
    //   187: aload_3
    //   188: invokevirtual 378	java/io/BufferedOutputStream:close	()V
    //   191: aload_2
    //   192: ifnull +7 -> 199
    //   195: aload_2
    //   196: invokevirtual 379	java/io/DataOutputStream:close	()V
    //   199: aload_0
    //   200: getfield 120	com/tencent/mobileqq/config/ConfigManager:h	Ljava/io/File;
    //   203: invokevirtual 364	java/io/File:delete	()Z
    //   206: pop
    //   207: return
    //   208: astore_3
    //   209: goto -28 -> 181
    //   212: astore 4
    //   214: goto -31 -> 183
    //   217: astore_2
    //   218: goto -82 -> 136
    //   221: astore_2
    //   222: goto -102 -> 120
    //   225: astore_2
    //   226: return
    //   227: astore 4
    //   229: goto -58 -> 171
    //   232: astore_3
    //   233: goto -54 -> 179
    //   236: astore_3
    //   237: goto -46 -> 191
    //   240: astore_2
    //   241: goto -42 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	ConfigManager
    //   89	24	1	j	int
    //   36	2	2	localException1	Exception
    //   45	14	2	localFile	File
    //   126	1	2	localObject1	Object
    //   138	1	2	localObject2	Object
    //   142	1	2	localObject3	Object
    //   155	41	2	localObject4	Object
    //   217	1	2	localException2	Exception
    //   221	1	2	localException3	Exception
    //   225	1	2	localException4	Exception
    //   240	1	2	localException5	Exception
    //   77	111	3	localObject5	Object
    //   208	1	3	localException6	Exception
    //   232	1	3	localException7	Exception
    //   236	1	3	localException8	Exception
    //   86	64	4	localDataOutputStream	DataOutputStream
    //   212	1	4	localException9	Exception
    //   227	1	4	localException10	Exception
    //   128	39	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   15	33	36	java/lang/Exception
    //   90	109	126	finally
    //   78	88	142	finally
    //   59	78	155	finally
    //   59	78	208	java/lang/Exception
    //   78	88	212	java/lang/Exception
    //   90	109	217	java/lang/Exception
    //   116	120	221	java/lang/Exception
    //   120	125	225	java/lang/Exception
    //   166	171	227	java/lang/Exception
    //   175	179	232	java/lang/Exception
    //   187	191	236	java/lang/Exception
    //   195	199	240	java/lang/Exception
  }
  
  public void decode(HttpMsg arg1, HttpMsg paramHttpMsg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShanPing", 2, "config-huibao--decode------------");
    }
    paramHttpMsg2 = paramHttpMsg2.getRecvData();
    try
    {
      synchronized (this.g)
      {
        if (this.f) {
          return;
        }
        ConfigParser.a(paramHttpMsg2, new ConfigRespStruct(), this.i);
        f();
        e();
        return;
      }
      return;
    }
    catch (RuntimeException ???) {}
  }
  
  public void e()
  {
    this.f = true;
    Object localObject = Config.d();
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ConfigListener)((Iterator)localObject).next()).a();
      }
    }
  }
  
  public boolean f()
  {
    int j = this.b.b;
    return (j == 1) || (j == 2);
  }
  
  public void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    e();
  }
  
  public void handleRedirect(String paramString) {}
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.ConfigManager
 * JD-Core Version:    0.7.0.1
 */