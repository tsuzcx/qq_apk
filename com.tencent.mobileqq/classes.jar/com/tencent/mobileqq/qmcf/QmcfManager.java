package com.tencent.mobileqq.qmcf;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.shortvideo.resource.ArtFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.util.SoLoader;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public class QmcfManager
{
  public static final int FRAME_TYPE_CL_MALI = 2;
  public static final int FRAME_TYPE_CL_OCL = 3;
  public static final int FRAME_TYPE_GL = 4;
  public static final int FRAME_TYPE_NONE = -1;
  public static final int FRAME_TYPE_NO_SUPPORT = 0;
  public static final int FRAME_TYPE_SNPE = 1;
  public static boolean FrameExtraction = false;
  public static String QMCF_FRAME_TYPE = "qmcf_frame_type";
  public static final int QMCF_MODE_ART = 1;
  public static final int QMCF_MODE_BIGHEAD = 3;
  public static final int QMCF_MODE_NONE = 0;
  public static final int QMCF_MODE_POSE = 2;
  private static final String TAG = "QMCF_MGR";
  private static int artFilterLimitVersion = 1;
  private static QmcfManager g_sInstance;
  public static boolean hasSNPESo = false;
  public static boolean isDebugMode = false;
  public static boolean isQQRun = true;
  private static QmcfReporter mReporter;
  private static QmcfSwitchStrategy mSwitchStrategy = new QmcfSwitchStrategy();
  public String CommonPrefixPath = null;
  private int currFrameType = -1;
  private String currModelResFolder;
  private int currQmcfMode = 0;
  public int mCameraMode = 1;
  private Object mReadResLock = new Object();
  public float[] mSTMatrix = new float[16];
  public boolean modeChanged = false;
  private HashMap modelItemsMap = new HashMap(16);
  private ArrayList<String> modelSwichList = new ArrayList();
  public boolean modelSwitched = false;
  ExecutorService singleThreadExecutor = null;
  
  static
  {
    mReporter = new QmcfReporter();
  }
  
  public static QmcfManager getInstance()
  {
    if (g_sInstance == null) {
      g_sInstance = new QmcfManager();
    }
    return g_sInstance;
  }
  
  /* Error */
  private String getQmcfModelPath(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore_2
    //   5: aconst_null
    //   6: astore 8
    //   8: aconst_null
    //   9: astore 7
    //   11: aload 8
    //   13: astore 6
    //   15: iload_2
    //   16: ifne +390 -> 406
    //   19: new 137	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   26: astore 6
    //   28: aload 6
    //   30: aload_1
    //   31: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 6
    //   37: ldc 144
    //   39: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: new 146	java/io/File
    //   46: dup
    //   47: aload 6
    //   49: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokespecial 153	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: astore 9
    //   57: aload 8
    //   59: astore 6
    //   61: aload 9
    //   63: invokevirtual 157	java/io/File:exists	()Z
    //   66: ifeq +340 -> 406
    //   69: aload 9
    //   71: invokestatic 163	com/tencent/mobileqq/activity/richmedia/FileUtils:readFileContent	(Ljava/io/File;)Ljava/lang/String;
    //   74: astore 10
    //   76: aload 8
    //   78: astore 6
    //   80: aload 10
    //   82: ifnull +324 -> 406
    //   85: aload 8
    //   87: astore 6
    //   89: aload 10
    //   91: invokevirtual 169	java/lang/String:length	()I
    //   94: ifle +312 -> 406
    //   97: iconst_0
    //   98: istore 4
    //   100: iconst_0
    //   101: istore_3
    //   102: iload_3
    //   103: istore_2
    //   104: aload 7
    //   106: astore 6
    //   108: new 171	org/json/JSONObject
    //   111: dup
    //   112: aload 10
    //   114: invokespecial 172	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   117: astore 10
    //   119: iload_3
    //   120: istore_2
    //   121: aload 7
    //   123: astore 6
    //   125: aload 10
    //   127: ldc 174
    //   129: invokevirtual 177	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   132: astore 8
    //   134: iload_3
    //   135: istore_2
    //   136: aload 7
    //   138: astore 6
    //   140: aload 10
    //   142: ldc 179
    //   144: invokevirtual 177	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   147: astore 10
    //   149: iload_3
    //   150: istore_2
    //   151: aload 7
    //   153: astore 6
    //   155: new 137	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   162: astore 11
    //   164: iload_3
    //   165: istore_2
    //   166: aload 7
    //   168: astore 6
    //   170: aload 11
    //   172: aload_1
    //   173: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: iload_3
    //   178: istore_2
    //   179: aload 7
    //   181: astore 6
    //   183: aload 11
    //   185: aload 8
    //   187: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: iload_3
    //   192: istore_2
    //   193: aload 7
    //   195: astore 6
    //   197: aload 11
    //   199: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: astore 11
    //   204: iload_3
    //   205: istore_2
    //   206: aload 7
    //   208: astore 6
    //   210: new 137	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   217: astore 12
    //   219: iload_3
    //   220: istore_2
    //   221: aload 7
    //   223: astore 6
    //   225: aload 12
    //   227: aload_1
    //   228: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: iload_3
    //   233: istore_2
    //   234: aload 7
    //   236: astore 6
    //   238: aload 12
    //   240: aload 10
    //   242: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: iload_3
    //   247: istore_2
    //   248: aload 7
    //   250: astore 6
    //   252: aload 12
    //   254: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: astore_1
    //   258: iload_3
    //   259: istore_2
    //   260: aload_1
    //   261: astore 6
    //   263: new 146	java/io/File
    //   266: dup
    //   267: aload 11
    //   269: invokespecial 153	java/io/File:<init>	(Ljava/lang/String;)V
    //   272: invokevirtual 157	java/io/File:exists	()Z
    //   275: istore 5
    //   277: iload_3
    //   278: istore_2
    //   279: aload_1
    //   280: astore 6
    //   282: new 146	java/io/File
    //   285: dup
    //   286: aload_1
    //   287: invokespecial 153	java/io/File:<init>	(Ljava/lang/String;)V
    //   290: invokevirtual 157	java/io/File:exists	()Z
    //   293: istore_3
    //   294: invokestatic 184	com/tencent/sveffects/SLog:isEnable	()Z
    //   297: ifeq +42 -> 339
    //   300: ldc 30
    //   302: ldc 186
    //   304: iconst_4
    //   305: anewarray 4	java/lang/Object
    //   308: dup
    //   309: iconst_0
    //   310: iload 5
    //   312: invokestatic 192	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   315: aastore
    //   316: dup
    //   317: iconst_1
    //   318: iload_3
    //   319: invokestatic 192	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   322: aastore
    //   323: dup
    //   324: iconst_2
    //   325: aload 8
    //   327: aastore
    //   328: dup
    //   329: iconst_3
    //   330: aload 10
    //   332: aastore
    //   333: invokestatic 196	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   336: invokestatic 200	com/tencent/sveffects/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   339: aload_1
    //   340: astore 6
    //   342: iload_3
    //   343: ifne +63 -> 406
    //   346: aload 9
    //   348: invokevirtual 203	java/io/File:delete	()Z
    //   351: pop
    //   352: aload_1
    //   353: areturn
    //   354: astore_1
    //   355: iload_3
    //   356: istore_2
    //   357: goto +37 -> 394
    //   360: astore 7
    //   362: goto +15 -> 377
    //   365: astore_1
    //   366: goto +28 -> 394
    //   369: astore 7
    //   371: iload 4
    //   373: istore_3
    //   374: aload 6
    //   376: astore_1
    //   377: iload_3
    //   378: istore_2
    //   379: aload 7
    //   381: invokevirtual 206	java/lang/Exception:printStackTrace	()V
    //   384: aload_1
    //   385: astore 6
    //   387: iload_3
    //   388: ifne +18 -> 406
    //   391: goto -45 -> 346
    //   394: iload_2
    //   395: ifne +9 -> 404
    //   398: aload 9
    //   400: invokevirtual 203	java/io/File:delete	()Z
    //   403: pop
    //   404: aload_1
    //   405: athrow
    //   406: aload 6
    //   408: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	409	0	this	QmcfManager
    //   0	409	1	paramString	String
    //   4	391	2	bool1	boolean
    //   101	287	3	bool2	boolean
    //   98	274	4	bool3	boolean
    //   275	36	5	bool4	boolean
    //   13	394	6	localObject1	Object
    //   9	240	7	localObject2	Object
    //   360	1	7	localException1	Exception
    //   369	11	7	localException2	Exception
    //   6	320	8	str	String
    //   55	344	9	localFile	File
    //   74	257	10	localObject3	Object
    //   162	106	11	localObject4	Object
    //   217	36	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   294	339	354	finally
    //   294	339	360	java/lang/Exception
    //   108	119	365	finally
    //   125	134	365	finally
    //   140	149	365	finally
    //   155	164	365	finally
    //   170	177	365	finally
    //   183	191	365	finally
    //   197	204	365	finally
    //   210	219	365	finally
    //   225	232	365	finally
    //   238	246	365	finally
    //   252	258	365	finally
    //   263	277	365	finally
    //   282	294	365	finally
    //   379	384	365	finally
    //   108	119	369	java/lang/Exception
    //   125	134	369	java/lang/Exception
    //   140	149	369	java/lang/Exception
    //   155	164	369	java/lang/Exception
    //   170	177	369	java/lang/Exception
    //   183	191	369	java/lang/Exception
    //   197	204	369	java/lang/Exception
    //   210	219	369	java/lang/Exception
    //   225	232	369	java/lang/Exception
    //   238	246	369	java/lang/Exception
    //   252	258	369	java/lang/Exception
    //   263	277	369	java/lang/Exception
    //   282	294	369	java/lang/Exception
  }
  
  public boolean checkPathValid()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(SdkContext.getInstance().getResources().getArtFilterResource().getCommonPrefix());
      ((StringBuilder)localObject).append("binarys/");
      this.CommonPrefixPath = ((StringBuilder)localObject).toString();
      localObject = new File(this.CommonPrefixPath);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      return true;
    }
    catch (Exception localException)
    {
      if (SLog.isEnable()) {
        SLog.d("QMCF_MGR", "createDir excep");
      }
      localException.printStackTrace();
    }
    return false;
  }
  
  public void destroy()
  {
    if (SLog.isEnable()) {
      SLog.d("QMCF_MGR", "destroy");
    }
    mReporter.clearReporter();
    this.modelSwitched = false;
  }
  
  public byte[] drink(byte[] paramArrayOfByte)
  {
    return QMCF.nDrink(paramArrayOfByte, paramArrayOfByte.length, QMCF.getDefaultSign());
  }
  
  public int getCurrFrameType()
  {
    if (this.currFrameType == -1)
    {
      this.currFrameType = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).getInt(QMCF_FRAME_TYPE, 4);
      if (SLog.isEnable())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCurrFrameType:");
        localStringBuilder.append(this.currFrameType);
        SLog.d("QMCF_MGR", localStringBuilder.toString());
      }
    }
    return this.currFrameType;
  }
  
  public int getCurrQmcfMode()
  {
    return this.currQmcfMode;
  }
  
  public String getCurrResFolder()
  {
    return this.currModelResFolder;
  }
  
  public QmcfSwitchStrategy getCurrSwitchStrategy()
  {
    return mSwitchStrategy;
  }
  
  public int getMatchQmcfMode(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 3) {
      return 2;
    }
    return 0;
  }
  
  /* Error */
  public QmcfModelItem getQmcfModelItem()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 120	com/tencent/mobileqq/qmcf/QmcfManager:currModelResFolder	Ljava/lang/String;
    //   4: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +19 -> 26
    //   10: invokestatic 184	com/tencent/sveffects/SLog:isEnable	()Z
    //   13: ifeq +11 -> 24
    //   16: ldc 30
    //   18: ldc_w 286
    //   21: invokestatic 200	com/tencent/sveffects/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: aconst_null
    //   25: areturn
    //   26: aload_0
    //   27: getfield 92	com/tencent/mobileqq/qmcf/QmcfManager:mReadResLock	Ljava/lang/Object;
    //   30: astore 13
    //   32: aload 13
    //   34: monitorenter
    //   35: new 137	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   42: astore 7
    //   44: aload 7
    //   46: aload_0
    //   47: getfield 120	com/tencent/mobileqq/qmcf/QmcfManager:currModelResFolder	Ljava/lang/String;
    //   50: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 7
    //   56: ldc 144
    //   58: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: new 146	java/io/File
    //   65: dup
    //   66: aload 7
    //   68: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokespecial 153	java/io/File:<init>	(Ljava/lang/String;)V
    //   74: astore 14
    //   76: aload 14
    //   78: invokevirtual 157	java/io/File:exists	()Z
    //   81: ifne +53 -> 134
    //   84: invokestatic 184	com/tencent/sveffects/SLog:isEnable	()Z
    //   87: ifeq +42 -> 129
    //   90: new 137	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   97: astore 7
    //   99: aload 7
    //   101: ldc_w 288
    //   104: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 7
    //   110: aload 14
    //   112: invokevirtual 291	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   115: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: ldc 30
    //   121: aload 7
    //   123: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 200	com/tencent/sveffects/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload 13
    //   131: monitorexit
    //   132: aconst_null
    //   133: areturn
    //   134: aload 14
    //   136: invokestatic 163	com/tencent/mobileqq/activity/richmedia/FileUtils:readFileContent	(Ljava/io/File;)Ljava/lang/String;
    //   139: astore 7
    //   141: aload 7
    //   143: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   146: ifeq +8 -> 154
    //   149: aload 13
    //   151: monitorexit
    //   152: aconst_null
    //   153: areturn
    //   154: new 171	org/json/JSONObject
    //   157: dup
    //   158: aload 7
    //   160: invokespecial 172	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   163: astore 8
    //   165: aload 8
    //   167: ldc 174
    //   169: invokevirtual 177	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   172: astore 7
    //   174: aload 8
    //   176: ldc 179
    //   178: invokevirtual 177	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   181: astore 11
    //   183: aload 8
    //   185: ldc_w 293
    //   188: invokevirtual 296	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   191: astore 12
    //   193: aload 8
    //   195: ldc_w 298
    //   198: invokevirtual 302	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   201: istore_1
    //   202: aload 7
    //   204: astore 9
    //   206: aload 11
    //   208: astore 10
    //   210: aload 12
    //   212: astore 11
    //   214: goto +79 -> 293
    //   217: astore 10
    //   219: aload 7
    //   221: astore 8
    //   223: aload 11
    //   225: astore 9
    //   227: aload 12
    //   229: astore 7
    //   231: goto +43 -> 274
    //   234: astore 10
    //   236: aconst_null
    //   237: astore 12
    //   239: aload 7
    //   241: astore 8
    //   243: aload 11
    //   245: astore 9
    //   247: aload 12
    //   249: astore 7
    //   251: goto +23 -> 274
    //   254: astore 10
    //   256: aload 7
    //   258: astore 8
    //   260: goto +8 -> 268
    //   263: astore 10
    //   265: aconst_null
    //   266: astore 8
    //   268: aconst_null
    //   269: astore 9
    //   271: aconst_null
    //   272: astore 7
    //   274: aload 10
    //   276: invokevirtual 206	java/lang/Exception:printStackTrace	()V
    //   279: iconst_0
    //   280: istore_1
    //   281: aload 7
    //   283: astore 11
    //   285: aload 9
    //   287: astore 10
    //   289: aload 8
    //   291: astore 9
    //   293: aload_0
    //   294: getfield 99	com/tencent/mobileqq/qmcf/QmcfManager:modelItemsMap	Ljava/util/HashMap;
    //   297: aload 9
    //   299: invokevirtual 306	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   302: ifnonnull +396 -> 698
    //   305: invokestatic 312	java/lang/System:currentTimeMillis	()J
    //   308: lstore_2
    //   309: new 137	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   316: astore 7
    //   318: aload 7
    //   320: aload_0
    //   321: getfield 120	com/tencent/mobileqq/qmcf/QmcfManager:currModelResFolder	Ljava/lang/String;
    //   324: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload 7
    //   330: aload 9
    //   332: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 7
    //   338: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: astore 8
    //   343: new 137	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   350: astore 7
    //   352: aload 7
    //   354: aload_0
    //   355: getfield 120	com/tencent/mobileqq/qmcf/QmcfManager:currModelResFolder	Ljava/lang/String;
    //   358: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload 7
    //   364: aload 10
    //   366: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload 7
    //   372: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: astore 7
    //   377: new 137	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   384: astore 12
    //   386: aload 12
    //   388: aload_0
    //   389: getfield 120	com/tencent/mobileqq/qmcf/QmcfManager:currModelResFolder	Ljava/lang/String;
    //   392: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload 12
    //   398: aload 11
    //   400: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload 12
    //   406: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: astore 12
    //   411: new 146	java/io/File
    //   414: dup
    //   415: aload 8
    //   417: invokespecial 153	java/io/File:<init>	(Ljava/lang/String;)V
    //   420: invokevirtual 157	java/io/File:exists	()Z
    //   423: istore 5
    //   425: new 146	java/io/File
    //   428: dup
    //   429: aload 7
    //   431: invokespecial 153	java/io/File:<init>	(Ljava/lang/String;)V
    //   434: invokevirtual 157	java/io/File:exists	()Z
    //   437: istore 6
    //   439: iload 5
    //   441: ifeq +121 -> 562
    //   444: iload 6
    //   446: ifeq +116 -> 562
    //   449: aload_0
    //   450: aload 7
    //   452: invokevirtual 315	com/tencent/mobileqq/qmcf/QmcfManager:readQmcfModelFile	(Ljava/lang/String;)Ljava/lang/String;
    //   455: astore 14
    //   457: aload 14
    //   459: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   462: ifne +54 -> 516
    //   465: new 317	com/tencent/mobileqq/qmcf/QmcfModelItem
    //   468: dup
    //   469: invokespecial 318	com/tencent/mobileqq/qmcf/QmcfModelItem:<init>	()V
    //   472: astore 7
    //   474: aload 7
    //   476: aload 14
    //   478: putfield 321	com/tencent/mobileqq/qmcf/QmcfModelItem:modelDeployString	Ljava/lang/String;
    //   481: aload 7
    //   483: aload 8
    //   485: putfield 324	com/tencent/mobileqq/qmcf/QmcfModelItem:modelParamPath	Ljava/lang/String;
    //   488: aload 7
    //   490: aload 12
    //   492: putfield 327	com/tencent/mobileqq/qmcf/QmcfModelItem:modelDlcPath	Ljava/lang/String;
    //   495: aload 7
    //   497: iload_1
    //   498: putfield 330	com/tencent/mobileqq/qmcf/QmcfModelItem:modelEncrypt	I
    //   501: aload_0
    //   502: getfield 99	com/tencent/mobileqq/qmcf/QmcfManager:modelItemsMap	Ljava/util/HashMap;
    //   505: aload 9
    //   507: aload 7
    //   509: invokevirtual 334	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   512: pop
    //   513: goto +58 -> 571
    //   516: invokestatic 184	com/tencent/sveffects/SLog:isEnable	()Z
    //   519: ifeq +173 -> 692
    //   522: aload 14
    //   524: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   527: ifne +159 -> 686
    //   530: iconst_1
    //   531: istore 4
    //   533: goto +3 -> 536
    //   536: ldc 30
    //   538: ldc_w 336
    //   541: iconst_1
    //   542: anewarray 4	java/lang/Object
    //   545: dup
    //   546: iconst_0
    //   547: iload 4
    //   549: invokestatic 192	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   552: aastore
    //   553: invokestatic 196	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   556: invokestatic 200	com/tencent/sveffects/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   559: goto +133 -> 692
    //   562: aload 14
    //   564: invokevirtual 203	java/io/File:delete	()Z
    //   567: pop
    //   568: goto +124 -> 692
    //   571: aload 7
    //   573: astore 8
    //   575: invokestatic 184	com/tencent/sveffects/SLog:isEnable	()Z
    //   578: ifeq +68 -> 646
    //   581: ldc 30
    //   583: ldc_w 338
    //   586: bipush 6
    //   588: anewarray 4	java/lang/Object
    //   591: dup
    //   592: iconst_0
    //   593: invokestatic 312	java/lang/System:currentTimeMillis	()J
    //   596: lload_2
    //   597: lsub
    //   598: invokestatic 343	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   601: aastore
    //   602: dup
    //   603: iconst_1
    //   604: iload 5
    //   606: invokestatic 192	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   609: aastore
    //   610: dup
    //   611: iconst_2
    //   612: iload 6
    //   614: invokestatic 192	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   617: aastore
    //   618: dup
    //   619: iconst_3
    //   620: aload 9
    //   622: aastore
    //   623: dup
    //   624: iconst_4
    //   625: aload 10
    //   627: aastore
    //   628: dup
    //   629: iconst_5
    //   630: aload 11
    //   632: aastore
    //   633: invokestatic 196	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   636: invokestatic 200	com/tencent/sveffects/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   639: aload 7
    //   641: astore 8
    //   643: goto +3 -> 646
    //   646: aload_0
    //   647: getfield 99	com/tencent/mobileqq/qmcf/QmcfManager:modelItemsMap	Ljava/util/HashMap;
    //   650: aload 9
    //   652: invokevirtual 306	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   655: ifnull +17 -> 672
    //   658: aload_0
    //   659: getfield 99	com/tencent/mobileqq/qmcf/QmcfManager:modelItemsMap	Ljava/util/HashMap;
    //   662: aload 9
    //   664: invokevirtual 306	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   667: checkcast 317	com/tencent/mobileqq/qmcf/QmcfModelItem
    //   670: astore 8
    //   672: aload 13
    //   674: monitorexit
    //   675: aload 8
    //   677: areturn
    //   678: astore 7
    //   680: aload 13
    //   682: monitorexit
    //   683: aload 7
    //   685: athrow
    //   686: iconst_0
    //   687: istore 4
    //   689: goto -153 -> 536
    //   692: aconst_null
    //   693: astore 7
    //   695: goto -124 -> 571
    //   698: aconst_null
    //   699: astore 8
    //   701: goto -55 -> 646
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	704	0	this	QmcfManager
    //   201	297	1	i	int
    //   308	289	2	l	long
    //   531	157	4	bool1	boolean
    //   423	182	5	bool2	boolean
    //   437	176	6	bool3	boolean
    //   42	598	7	localObject1	Object
    //   678	6	7	localObject2	Object
    //   693	1	7	localObject3	Object
    //   163	537	8	localObject4	Object
    //   204	459	9	localObject5	Object
    //   208	1	10	localObject6	Object
    //   217	1	10	localException1	Exception
    //   234	1	10	localException2	Exception
    //   254	1	10	localException3	Exception
    //   263	12	10	localException4	Exception
    //   287	339	10	localObject7	Object
    //   181	450	11	localObject8	Object
    //   191	300	12	localObject9	Object
    //   30	651	13	localObject10	Object
    //   74	489	14	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   193	202	217	java/lang/Exception
    //   183	193	234	java/lang/Exception
    //   174	183	254	java/lang/Exception
    //   154	174	263	java/lang/Exception
    //   35	129	678	finally
    //   129	132	678	finally
    //   134	152	678	finally
    //   154	174	678	finally
    //   174	183	678	finally
    //   183	193	678	finally
    //   193	202	678	finally
    //   274	279	678	finally
    //   293	439	678	finally
    //   449	513	678	finally
    //   516	530	678	finally
    //   536	559	678	finally
    //   562	568	678	finally
    //   575	639	678	finally
    //   646	672	678	finally
    //   672	675	678	finally
    //   680	683	678	finally
  }
  
  public int getRunType()
  {
    if (getCurrFrameType() == 4) {
      return 1;
    }
    return 0;
  }
  
  public boolean hasQmcfEntrance(int paramInt)
  {
    return hasQmcfEntrance(paramInt, false);
  }
  
  public boolean hasQmcfEntrance(int paramInt, boolean paramBoolean)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    if (i < 21) {
      return false;
    }
    boolean bool4 = isQmcfSupported(paramInt);
    boolean bool3 = SoLoader.isLoadArtFilterSuccess();
    boolean bool1 = bool3;
    if (bool4)
    {
      bool1 = bool3;
      if (!bool3) {
        if (paramBoolean)
        {
          paramBoolean = SoLoader.loadSvArtFilterSO(SdkContext.getInstance().getApplication());
          bool1 = paramBoolean;
          if (SLog.isEnable())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("reloadso :");
            localStringBuilder.append(paramBoolean);
            SLog.d("QMCF_MGR", localStringBuilder.toString());
            bool1 = paramBoolean;
          }
        }
        else
        {
          bool1 = SoLoader.isQmcfSoUnLoaded();
        }
      }
    }
    paramBoolean = bool2;
    if (bool4)
    {
      paramBoolean = bool2;
      if (bool1) {
        paramBoolean = true;
      }
    }
    return paramBoolean;
  }
  
  public boolean isArtFilterVersionOK(int paramInt)
  {
    return paramInt >= artFilterLimitVersion;
  }
  
  public boolean isQmcfNoNeedBeauty()
  {
    int i = this.currQmcfMode;
    boolean bool = true;
    if (i != 1)
    {
      if (i == 2) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public boolean isQmcfSupported()
  {
    QmcfSwitchStrategy localQmcfSwitchStrategy = mSwitchStrategy;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!localQmcfSwitchStrategy.isModeSupported(1))
    {
      bool1 = bool2;
      if (!mSwitchStrategy.isModeSupported(2))
      {
        if (mSwitchStrategy.isModeSupported(3)) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public boolean isQmcfSupported(int paramInt)
  {
    return mSwitchStrategy.isModeSupported(paramInt);
  }
  
  public boolean isQmcfWork()
  {
    return this.currQmcfMode != 0;
  }
  
  public boolean needConvertCoor()
  {
    return this.mCameraMode == 1;
  }
  
  /* Error */
  public String readQmcfModelFile(String paramString)
  {
    // Byte code:
    //   0: invokestatic 312	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: new 146	java/io/File
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 153	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore_1
    //   13: aload_1
    //   14: invokevirtual 157	java/io/File:exists	()Z
    //   17: istore 4
    //   19: aconst_null
    //   20: astore 5
    //   22: aconst_null
    //   23: astore 7
    //   25: iload 4
    //   27: ifeq +206 -> 233
    //   30: new 385	java/io/FileInputStream
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 388	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   38: astore 5
    //   40: aload 5
    //   42: astore_1
    //   43: new 165	java/lang/String
    //   46: dup
    //   47: aload_0
    //   48: aload 5
    //   50: invokestatic 394	com/tencent/ttpic/baseutils/io/IOUtils:toByteArray	(Ljava/io/InputStream;)[B
    //   53: invokevirtual 396	com/tencent/mobileqq/qmcf/QmcfManager:drink	([B)[B
    //   56: invokespecial 399	java/lang/String:<init>	([B)V
    //   59: astore 6
    //   61: aload 5
    //   63: invokevirtual 402	java/io/FileInputStream:close	()V
    //   66: goto +8 -> 74
    //   69: astore_1
    //   70: aload_1
    //   71: invokevirtual 206	java/lang/Exception:printStackTrace	()V
    //   74: aload 6
    //   76: astore_1
    //   77: goto +55 -> 132
    //   80: astore 6
    //   82: goto +15 -> 97
    //   85: astore_1
    //   86: aconst_null
    //   87: astore 5
    //   89: goto +122 -> 211
    //   92: astore 6
    //   94: aconst_null
    //   95: astore 5
    //   97: aload 5
    //   99: astore_1
    //   100: aload 6
    //   102: invokevirtual 206	java/lang/Exception:printStackTrace	()V
    //   105: aload 7
    //   107: astore_1
    //   108: aload 5
    //   110: ifnull +22 -> 132
    //   113: aload 5
    //   115: invokevirtual 402	java/io/FileInputStream:close	()V
    //   118: aload 7
    //   120: astore_1
    //   121: goto +11 -> 132
    //   124: astore_1
    //   125: aload_1
    //   126: invokevirtual 206	java/lang/Exception:printStackTrace	()V
    //   129: aload 7
    //   131: astore_1
    //   132: aload_1
    //   133: astore 5
    //   135: invokestatic 184	com/tencent/sveffects/SLog:isEnable	()Z
    //   138: ifeq +95 -> 233
    //   141: new 137	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   148: astore 5
    //   150: aload 5
    //   152: ldc_w 404
    //   155: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload 5
    //   161: invokestatic 312	java/lang/System:currentTimeMillis	()J
    //   164: lload_2
    //   165: lsub
    //   166: invokevirtual 407	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 5
    //   172: ldc_w 409
    //   175: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 5
    //   181: aload_1
    //   182: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   185: iconst_1
    //   186: ixor
    //   187: invokevirtual 373	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: ldc 30
    //   193: aload 5
    //   195: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 200	com/tencent/sveffects/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload_1
    //   202: areturn
    //   203: astore 6
    //   205: aload_1
    //   206: astore 5
    //   208: aload 6
    //   210: astore_1
    //   211: aload 5
    //   213: ifnull +18 -> 231
    //   216: aload 5
    //   218: invokevirtual 402	java/io/FileInputStream:close	()V
    //   221: goto +10 -> 231
    //   224: astore 5
    //   226: aload 5
    //   228: invokevirtual 206	java/lang/Exception:printStackTrace	()V
    //   231: aload_1
    //   232: athrow
    //   233: aload 5
    //   235: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	QmcfManager
    //   0	236	1	paramString	String
    //   3	162	2	l	long
    //   17	9	4	bool	boolean
    //   20	197	5	localObject1	Object
    //   224	10	5	localException1	Exception
    //   59	16	6	str	String
    //   80	1	6	localException2	Exception
    //   92	9	6	localException3	Exception
    //   203	6	6	localObject2	Object
    //   23	107	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   61	66	69	java/lang/Exception
    //   43	61	80	java/lang/Exception
    //   30	40	85	finally
    //   30	40	92	java/lang/Exception
    //   113	118	124	java/lang/Exception
    //   43	61	203	finally
    //   100	105	203	finally
    //   216	221	224	java/lang/Exception
  }
  
  public void reportQmcfFrameConsume(int paramInt1, int paramInt2, String paramString)
  {
    mReporter.reportMtaFrameCost(paramInt1, paramInt2, paramString, this.currQmcfMode, this.currFrameType);
  }
  
  public void setCameraMode(int paramInt)
  {
    this.mCameraMode = paramInt;
  }
  
  public void setCurrFrameType(int paramInt)
  {
    if (this.currFrameType != paramInt)
    {
      Object localObject = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).edit();
      ((SharedPreferences.Editor)localObject).putInt(QMCF_FRAME_TYPE, paramInt);
      ((SharedPreferences.Editor)localObject).commit();
      if (SLog.isEnable())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setCurrFrameType:");
        ((StringBuilder)localObject).append(paramInt);
        SLog.d("QMCF_MGR", ((StringBuilder)localObject).toString());
      }
    }
    this.currFrameType = paramInt;
  }
  
  public void setCurrQmcfMode(int paramInt)
  {
    this.currQmcfMode = paramInt;
  }
  
  public void setCurrResFolder(String paramString)
  {
    this.currModelResFolder = paramString;
  }
  
  public void setIsQQRun(boolean paramBoolean)
  {
    isQQRun = paramBoolean;
  }
  
  public void setQmcfInitSuccess(boolean paramBoolean)
  {
    mSwitchStrategy.setInitSuccess(paramBoolean);
  }
  
  public void setQmcfMobileNotSupport(String paramString)
  {
    if (mSwitchStrategy.isMobileSupported())
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("svaf_gpuinfo", paramString);
      paramString = mReporter;
      QmcfReporter.report("svaf_nosupport_ocl", localHashMap, true);
    }
    mSwitchStrategy.setMobileSupport(false);
  }
  
  public void setQmcfMobileSupport()
  {
    mSwitchStrategy.setMobileSupport(true);
  }
  
  public void setQmcfProcessConsume(long paramLong)
  {
    mReporter.updateProcessConsume(paramLong);
  }
  
  public void setQmcfRunSupported(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    mSwitchStrategy.setQmcfRunSupported(paramBoolean1, paramBoolean2, paramInt);
  }
  
  public void setSTMatrix(float[] paramArrayOfFloat)
  {
    this.mSTMatrix = paramArrayOfFloat;
  }
  
  public void switchQmcfModel(int paramInt, String paramString)
  {
    if (SLog.isEnable())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("switchQmcfModel begin resFold");
      ((StringBuilder)???).append(paramString);
      SLog.d("QMCF_MGR", ((StringBuilder)???).toString());
    }
    synchronized (this.modelSwichList)
    {
      if (paramInt == this.currQmcfMode)
      {
        this.modelSwichList.add(paramString);
        if (this.currQmcfMode == 1) {
          this.modelSwitched = true;
        }
      }
      else
      {
        this.modeChanged = true;
        this.modelSwichList.clear();
        this.modelSwichList.add(paramString);
      }
      this.currQmcfMode = paramInt;
      this.currModelResFolder = paramString;
      if (this.singleThreadExecutor == null)
      {
        if (SLog.isEnable()) {
          SLog.d("QMCF_MGR", "switchQmcfModel create singleThreadExecutor");
        }
        this.singleThreadExecutor = Executors.newSingleThreadExecutor();
      }
      this.singleThreadExecutor.execute(new QmcfManager.1(this));
      return;
    }
  }
  
  public void updateQmcfFrameConsume(long paramLong)
  {
    mReporter.updateFrameConsume(paramLong);
  }
  
  public void updateQmcfMainSwitch(JSONObject paramJSONObject)
  {
    mSwitchStrategy.updateMainSwitch(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qmcf.QmcfManager
 * JD-Core Version:    0.7.0.1
 */