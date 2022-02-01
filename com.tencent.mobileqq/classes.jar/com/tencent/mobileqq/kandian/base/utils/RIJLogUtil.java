package com.tencent.mobileqq.kandian.base.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.Base64Util;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/RIJLogUtil;", "", "()V", "getStackTrace", "", "e", "", "wrapLogUin", "uin", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJLogUtil
{
  public static final RIJLogUtil a = new RIJLogUtil();
  
  /* Error */
  @kotlin.jvm.JvmStatic
  @Nullable
  public static final String a(@NotNull java.lang.Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 39
    //   3: invokestatic 45	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aconst_null
    //   7: checkcast 47	java/io/StringWriter
    //   10: astore_3
    //   11: aconst_null
    //   12: checkcast 49	java/io/PrintWriter
    //   15: astore_1
    //   16: new 47	java/io/StringWriter
    //   19: dup
    //   20: invokespecial 50	java/io/StringWriter:<init>	()V
    //   23: astore_2
    //   24: new 49	java/io/PrintWriter
    //   27: dup
    //   28: aload_2
    //   29: checkcast 52	java/io/Writer
    //   32: invokespecial 55	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   35: astore_3
    //   36: aload_0
    //   37: aload_3
    //   38: invokevirtual 61	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   41: aload_3
    //   42: invokevirtual 64	java/io/PrintWriter:flush	()V
    //   45: aload_2
    //   46: invokevirtual 65	java/io/StringWriter:flush	()V
    //   49: aload_2
    //   50: invokevirtual 68	java/io/StringWriter:close	()V
    //   53: goto +8 -> 61
    //   56: astore_0
    //   57: aload_0
    //   58: invokevirtual 70	java/io/IOException:printStackTrace	()V
    //   61: aload_3
    //   62: invokevirtual 71	java/io/PrintWriter:close	()V
    //   65: aload_2
    //   66: invokestatic 77	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   69: areturn
    //   70: astore_0
    //   71: aload_3
    //   72: astore_1
    //   73: goto +10 -> 83
    //   76: astore_0
    //   77: goto +6 -> 83
    //   80: astore_0
    //   81: aload_3
    //   82: astore_2
    //   83: aload_2
    //   84: ifnull +15 -> 99
    //   87: aload_2
    //   88: invokevirtual 68	java/io/StringWriter:close	()V
    //   91: goto +8 -> 99
    //   94: astore_2
    //   95: aload_2
    //   96: invokevirtual 70	java/io/IOException:printStackTrace	()V
    //   99: aload_1
    //   100: ifnull +7 -> 107
    //   103: aload_1
    //   104: invokevirtual 71	java/io/PrintWriter:close	()V
    //   107: aload_0
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	paramThrowable	java.lang.Throwable
    //   15	89	1	localObject1	Object
    //   23	65	2	localObject2	Object
    //   94	2	2	localIOException	java.io.IOException
    //   10	72	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   49	53	56	java/io/IOException
    //   36	49	70	finally
    //   24	36	76	finally
    //   16	24	80	finally
    //   87	91	94	java/io/IOException
  }
  
  @NotNull
  public final String a(long paramLong)
  {
    return a(String.valueOf(paramLong));
  }
  
  @NotNull
  public final String a(@Nullable String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return "";
    }
    if (paramString != null)
    {
      Charset localCharset = Charset.forName("utf-8");
      Intrinsics.checkExpressionValueIsNotNull(localCharset, "Charset.forName(charsetName)");
      if (paramString != null)
      {
        paramString = paramString.getBytes(localCharset);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    else
    {
      paramString = null;
    }
    paramString = Base64Util.encodeToString(paramString, 0);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "Base64Util.encodeToStrin…8\")), Base64Util.DEFAULT)");
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.RIJLogUtil
 * JD-Core Version:    0.7.0.1
 */