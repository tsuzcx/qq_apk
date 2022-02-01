package com.tencent.mobileqq.cmshow.engine;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.action.ActionStatus;
import com.tencent.mobileqq.cmshow.engine.action.COMPLETE;
import com.tencent.mobileqq.cmshow.engine.action.INTERRUPT;
import com.tencent.mobileqq.cmshow.engine.action.START;
import com.tencent.mobileqq.cmshow.engine.action.UNKNOWN;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/EngineHelper;", "", "()V", "TAG", "", "uiHandler", "Landroid/os/Handler;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "debug", "", "action", "Lkotlin/Function0;", "genArgumentParam", "cmd", "reqData", "genArgumentParam$cmshow_impl_release", "isRunOnUiThread", "", "runOnUiThread", "savePixels2File", "path", "pixels", "", "width", "", "height", "byteLength", "savePixels2File$cmshow_impl_release", "toast", "message", "iconType", "wrapResultFailed", "Lorg/json/JSONObject;", "errMsg", "wrapResultFailed$cmshow_impl_release", "wrapResultSuccess", "wrapResultSuccess$cmshow_impl_release", "extractErrCode", "extractErrCode$cmshow_impl_release", "isVariableCmd", "isVariableCmd$cmshow_impl_release", "toActionStatus", "Lcom/tencent/mobileqq/cmshow/engine/action/ActionStatus;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class EngineHelper
{
  public static final EngineHelper a = new EngineHelper();
  private static final Handler b = new Handler(Looper.getMainLooper());
  
  private final boolean c()
  {
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    Intrinsics.checkExpressionValueIsNotNull(localLooper, "Looper.getMainLooper()");
    return Intrinsics.areEqual(localThread, localLooper.getThread());
  }
  
  @Nullable
  public final QQAppInterface a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        return (QQAppInterface)localObject;
      }
    }
    return null;
  }
  
  @NotNull
  public final ActionStatus a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return (ActionStatus)UNKNOWN.a;
        }
        return (ActionStatus)INTERRUPT.a;
      }
      return (ActionStatus)COMPLETE.a;
    }
    return (ActionStatus)START.a;
  }
  
  @NotNull
  public final String a(@NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "cmd");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"cmd\":\"");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\", \"params\":");
    localStringBuilder.append(paramString2);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  /* Error */
  public final void a(@Nullable String paramString, @NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc 172
    //   3: invokestatic 145	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: new 147	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   13: astore 6
    //   15: aload 6
    //   17: ldc 174
    //   19: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 6
    //   25: aload_1
    //   26: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 6
    //   32: ldc 176
    //   34: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 6
    //   40: iload_3
    //   41: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 6
    //   47: ldc 181
    //   49: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 6
    //   55: iload 4
    //   57: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 6
    //   63: ldc 183
    //   65: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 6
    //   71: iload 5
    //   73: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: ldc 185
    //   79: iconst_1
    //   80: aload 6
    //   82: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 191	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: new 193	java/io/File
    //   91: dup
    //   92: aload_1
    //   93: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
    //   96: astore 8
    //   98: aload 8
    //   100: invokevirtual 200	java/io/File:getParentFile	()Ljava/io/File;
    //   103: invokevirtual 203	java/io/File:exists	()Z
    //   106: ifne +12 -> 118
    //   109: aload 8
    //   111: invokevirtual 200	java/io/File:getParentFile	()Ljava/io/File;
    //   114: invokevirtual 206	java/io/File:mkdirs	()Z
    //   117: pop
    //   118: aload 8
    //   120: invokevirtual 203	java/io/File:exists	()Z
    //   123: ifeq +9 -> 132
    //   126: aload 8
    //   128: invokevirtual 209	java/io/File:delete	()Z
    //   131: pop
    //   132: aload_2
    //   133: invokevirtual 213	java/lang/Object:clone	()Ljava/lang/Object;
    //   136: checkcast 215	[B
    //   139: iload 5
    //   141: iload 4
    //   143: idiv
    //   144: iconst_4
    //   145: idiv
    //   146: iload 4
    //   148: iload_3
    //   149: invokestatic 220	com/tencent/mobileqq/apollo/utils/ApolloRecordUtil:a	([BIII)[B
    //   152: astore 12
    //   154: aload 12
    //   156: ldc 222
    //   158: invokestatic 94	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   161: aconst_null
    //   162: checkcast 224	java/io/FileOutputStream
    //   165: astore 7
    //   167: aconst_null
    //   168: checkcast 226	android/graphics/Bitmap
    //   171: astore_1
    //   172: aload_1
    //   173: astore_2
    //   174: aload 7
    //   176: astore 6
    //   178: aload_1
    //   179: astore 9
    //   181: aload_1
    //   182: astore 10
    //   184: aload_1
    //   185: astore 11
    //   187: iload_3
    //   188: iload 4
    //   190: getstatic 232	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   193: invokestatic 236	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   196: astore_1
    //   197: aload_1
    //   198: astore_2
    //   199: aload 7
    //   201: astore 6
    //   203: aload_1
    //   204: astore 9
    //   206: aload_1
    //   207: astore 10
    //   209: aload_1
    //   210: astore 11
    //   212: aload_1
    //   213: aload 12
    //   215: invokestatic 242	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   218: checkcast 244	java/nio/Buffer
    //   221: invokevirtual 248	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   224: aload_1
    //   225: astore_2
    //   226: aload 7
    //   228: astore 6
    //   230: aload_1
    //   231: astore 9
    //   233: aload_1
    //   234: astore 10
    //   236: aload_1
    //   237: astore 11
    //   239: new 224	java/io/FileOutputStream
    //   242: dup
    //   243: aload 8
    //   245: invokespecial 251	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   248: astore 8
    //   250: aload_1
    //   251: getstatic 257	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   254: bipush 100
    //   256: aload 8
    //   258: checkcast 259	java/io/OutputStream
    //   261: invokevirtual 263	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   264: pop
    //   265: aload 8
    //   267: invokevirtual 266	java/io/FileOutputStream:flush	()V
    //   270: aload 8
    //   272: invokevirtual 269	java/io/FileOutputStream:close	()V
    //   275: aload_1
    //   276: ifnull +213 -> 489
    //   279: aload_1
    //   280: invokevirtual 272	android/graphics/Bitmap:isRecycled	()Z
    //   283: ifne +206 -> 489
    //   286: aload_1
    //   287: invokevirtual 275	android/graphics/Bitmap:recycle	()V
    //   290: return
    //   291: astore_2
    //   292: aload 8
    //   294: astore 6
    //   296: goto +194 -> 490
    //   299: astore_2
    //   300: aload 8
    //   302: astore 7
    //   304: aload_2
    //   305: astore 8
    //   307: goto +40 -> 347
    //   310: astore_2
    //   311: aload 8
    //   313: astore 7
    //   315: aload_2
    //   316: astore 8
    //   318: goto +78 -> 396
    //   321: astore_2
    //   322: aload 8
    //   324: astore 7
    //   326: aload_2
    //   327: astore 8
    //   329: goto +116 -> 445
    //   332: astore 7
    //   334: aload_2
    //   335: astore_1
    //   336: aload 7
    //   338: astore_2
    //   339: goto +151 -> 490
    //   342: astore 8
    //   344: aload 9
    //   346: astore_1
    //   347: aload_1
    //   348: astore_2
    //   349: aload 7
    //   351: astore 6
    //   353: ldc 185
    //   355: iconst_1
    //   356: ldc_w 277
    //   359: aload 8
    //   361: checkcast 279	java/lang/Throwable
    //   364: invokestatic 283	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   367: aload 7
    //   369: ifnull +8 -> 377
    //   372: aload 7
    //   374: invokevirtual 269	java/io/FileOutputStream:close	()V
    //   377: aload_1
    //   378: ifnull +111 -> 489
    //   381: aload_1
    //   382: invokevirtual 272	android/graphics/Bitmap:isRecycled	()Z
    //   385: ifne +104 -> 489
    //   388: goto -102 -> 286
    //   391: astore 8
    //   393: aload 10
    //   395: astore_1
    //   396: aload_1
    //   397: astore_2
    //   398: aload 7
    //   400: astore 6
    //   402: ldc 185
    //   404: iconst_1
    //   405: ldc_w 285
    //   408: aload 8
    //   410: checkcast 279	java/lang/Throwable
    //   413: invokestatic 283	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   416: aload 7
    //   418: ifnull +8 -> 426
    //   421: aload 7
    //   423: invokevirtual 269	java/io/FileOutputStream:close	()V
    //   426: aload_1
    //   427: ifnull +62 -> 489
    //   430: aload_1
    //   431: invokevirtual 272	android/graphics/Bitmap:isRecycled	()Z
    //   434: ifne +55 -> 489
    //   437: goto -151 -> 286
    //   440: astore 8
    //   442: aload 11
    //   444: astore_1
    //   445: aload_1
    //   446: astore_2
    //   447: aload 7
    //   449: astore 6
    //   451: ldc 185
    //   453: iconst_1
    //   454: ldc_w 287
    //   457: aload 8
    //   459: checkcast 279	java/lang/Throwable
    //   462: invokestatic 283	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   465: aload 7
    //   467: ifnull +8 -> 475
    //   470: aload 7
    //   472: invokevirtual 269	java/io/FileOutputStream:close	()V
    //   475: aload_1
    //   476: ifnull +13 -> 489
    //   479: aload_1
    //   480: invokevirtual 272	android/graphics/Bitmap:isRecycled	()Z
    //   483: ifne +6 -> 489
    //   486: goto -200 -> 286
    //   489: return
    //   490: aload 6
    //   492: ifnull +8 -> 500
    //   495: aload 6
    //   497: invokevirtual 269	java/io/FileOutputStream:close	()V
    //   500: aload_1
    //   501: ifnull +14 -> 515
    //   504: aload_1
    //   505: invokevirtual 272	android/graphics/Bitmap:isRecycled	()Z
    //   508: ifne +7 -> 515
    //   511: aload_1
    //   512: invokevirtual 275	android/graphics/Bitmap:recycle	()V
    //   515: goto +5 -> 520
    //   518: aload_2
    //   519: athrow
    //   520: goto -2 -> 518
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	523	0	this	EngineHelper
    //   0	523	1	paramString	String
    //   0	523	2	paramArrayOfByte	byte[]
    //   0	523	3	paramInt1	int
    //   0	523	4	paramInt2	int
    //   0	523	5	paramInt3	int
    //   13	483	6	localObject1	Object
    //   165	160	7	localObject2	Object
    //   332	139	7	localObject3	Object
    //   96	232	8	localObject4	Object
    //   342	18	8	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   391	18	8	localIOException	java.io.IOException
    //   440	18	8	localFileNotFoundException	java.io.FileNotFoundException
    //   179	166	9	str1	String
    //   182	212	10	str2	String
    //   185	258	11	str3	String
    //   152	62	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   250	270	291	finally
    //   250	270	299	java/lang/OutOfMemoryError
    //   250	270	310	java/io/IOException
    //   250	270	321	java/io/FileNotFoundException
    //   187	197	332	finally
    //   212	224	332	finally
    //   239	250	332	finally
    //   353	367	332	finally
    //   402	416	332	finally
    //   451	465	332	finally
    //   187	197	342	java/lang/OutOfMemoryError
    //   212	224	342	java/lang/OutOfMemoryError
    //   239	250	342	java/lang/OutOfMemoryError
    //   187	197	391	java/io/IOException
    //   212	224	391	java/io/IOException
    //   239	250	391	java/io/IOException
    //   187	197	440	java/io/FileNotFoundException
    //   212	224	440	java/io/FileNotFoundException
    //   239	250	440	java/io/FileNotFoundException
  }
  
  public final void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "action");
    if (c())
    {
      paramFunction0.invoke();
      return;
    }
    b.post((Runnable)new EngineHelper.runOnUiThread.1(paramFunction0));
  }
  
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$isVariableCmd");
    return (StringsKt.startsWith$default(paramString, "apollo_", false, 2, null)) && (!StringsKt.endsWith$default(paramString, ".local", false, 2, null));
  }
  
  public final int b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$extractErrCode");
    try
    {
      int i = new JSONObject(paramString).optInt("errCode", 0);
      return i;
    }
    catch (Throwable paramString) {}
    return 0;
  }
  
  @NotNull
  public final JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("errCode", 0);
    return localJSONObject;
  }
  
  @NotNull
  public final JSONObject c(@Nullable String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("errCode", 1);
    if (!TextUtils.isEmpty((CharSequence)paramString)) {
      localJSONObject.put("errMsg", paramString);
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.EngineHelper
 * JD-Core Version:    0.7.0.1
 */