package com.tencent.tkd.topicsdk.common;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/common/DisplayUtils;", "", "()V", "dip2px", "", "context", "Landroid/content/Context;", "dpValue", "", "getDisplayDuration", "", "duration", "getDisplayHeight", "getDisplaySize", "", "getDisplayWidth", "toPx", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public final class DisplayUtils
{
  public static final DisplayUtils a = new DisplayUtils();
  
  private final int[] a(Context paramContext)
  {
    paramContext = paramContext.getSystemService("window");
    if (paramContext == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
    }
    paramContext = (WindowManager)paramContext;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    if (Build.VERSION.SDK_INT >= 17) {
      paramContext.getDefaultDisplay().getRealMetrics(localDisplayMetrics);
    }
    for (;;)
    {
      return new int[] { localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels };
      paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
    }
  }
  
  public final int a(float paramFloat, @NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return a(paramContext, paramFloat);
  }
  
  public final int a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return a(paramContext)[0];
  }
  
  public final int a(@NotNull Context paramContext, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = paramContext.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.resources");
    return (int)(paramContext.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  @Nullable
  public final String a(int paramInt)
  {
    int k = paramInt / 3600;
    int j = paramInt / 60;
    int i = j;
    if (k > 0) {
      i = j - k * 60;
    }
    paramInt %= 60;
    Object localObject2;
    if (i >= 10)
    {
      localObject1 = String.valueOf(i);
      if (paramInt < 10) {
        break label173;
      }
      localObject2 = String.valueOf(paramInt);
      label56:
      if (k <= 0) {
        break label262;
      }
      if (k < 10) {
        break label217;
      }
      localObject3 = String.valueOf(k);
    }
    for (;;)
    {
      Object localObject4 = StringCompanionObject.INSTANCE;
      localObject4 = new Object[3];
      localObject4[0] = localObject3;
      localObject4[1] = localObject1;
      localObject4[2] = localObject2;
      localObject1 = String.format("%s:%s:%s", Arrays.copyOf((Object[])localObject4, localObject4.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
      return localObject1;
      localObject1 = StringCompanionObject.INSTANCE;
      localObject1 = new Object[1];
      localObject1[0] = Integer.valueOf(i);
      localObject1 = String.format("0%d", Arrays.copyOf((Object[])localObject1, localObject1.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
      break;
      label173:
      localObject2 = StringCompanionObject.INSTANCE;
      localObject2 = new Object[1];
      localObject2[0] = Integer.valueOf(paramInt);
      localObject2 = String.format("0%d", Arrays.copyOf((Object[])localObject2, localObject2.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "java.lang.String.format(format, *args)");
      break label56;
      label217:
      localObject3 = StringCompanionObject.INSTANCE;
      localObject3 = new Object[1];
      localObject3[0] = Integer.valueOf(k);
      localObject3 = String.format("0%d", Arrays.copyOf((Object[])localObject3, localObject3.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "java.lang.String.format(format, *args)");
    }
    label262:
    Object localObject3 = StringCompanionObject.INSTANCE;
    localObject3 = new Object[2];
    localObject3[0] = localObject1;
    localObject3[1] = localObject2;
    Object localObject1 = String.format("%s:%s", Arrays.copyOf((Object[])localObject3, localObject3.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
    return localObject1;
  }
  
  public final int b(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return a(paramContext)[1];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.DisplayUtils
 * JD-Core Version:    0.7.0.1
 */