package com.tencent.mobileqq.triton.render;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/render/RenderContext$Companion;", "", "()V", "TAG", "", "checkOpenGLES30", "", "context", "Landroid/content/Context;", "Triton_release"}, k=1, mv={1, 1, 16})
public final class RenderContext$Companion
{
  private final boolean checkOpenGLES30(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSystemService("activity");
      if (paramContext != null)
      {
        if (((ActivityManager)paramContext).getDeviceConfigurationInfo().reqGlEsVersion >= 196608) {
          return true;
        }
      }
      else {
        throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
      }
    }
    catch (Exception paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get support ES3 error! ");
      localStringBuilder.append(paramContext.getMessage());
      Logger.e$default("RenderContext", localStringBuilder.toString(), null, 4, null);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.render.RenderContext.Companion
 * JD-Core Version:    0.7.0.1
 */