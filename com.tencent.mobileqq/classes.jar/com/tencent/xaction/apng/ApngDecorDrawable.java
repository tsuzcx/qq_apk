package com.tencent.xaction.apng;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Keep;
import com.tencent.image.ApngImage;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.base.DecorDrawable;
import com.tencent.xaction.api.base.DecorDrawableState;
import com.tencent.xaction.api.data.TimeProp;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.api.util.FileUtil;
import com.tencent.xaction.api.util.FileUtil.Companion;
import com.tencent.xaction.api.util.ScreenUnit;
import com.tencent.xaction.api.util.ScreenUnit.Companion;
import com.tencent.xaction.openapi.api.IPublicDecorDrawable;
import com.tencent.xaction.openapi.api.IXAEngine;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/apng/ApngDecorDrawable;", "Lcom/tencent/xaction/api/base/DecorDrawable;", "()V", "tmpId", "", "doFrameUpdate", "", "animTime", "", "end", "play", "preStart", "view", "Landroid/view/View;", "stop", "ApngDecorDrawableState", "Companion", "XAApng_release"}, k=1, mv={1, 1, 16})
@Keep
public class ApngDecorDrawable
  extends DecorDrawable
{
  public static final ApngDecorDrawable.Companion Companion = new ApngDecorDrawable.Companion(null);
  private static int idCount = 20000;
  private int tmpId;
  
  public ApngDecorDrawable()
  {
    setDrawable((IDrawable)new ApngDrawable());
    IDrawable localIDrawable = getDrawable();
    if (localIDrawable == null) {
      Intrinsics.throwNpe();
    }
    localIDrawable.setDecor((IPublicDecorDrawable)this);
  }
  
  public void doFrameUpdate(float paramFloat) {}
  
  public void end() {}
  
  public void play()
  {
    super.play();
    View localView = getView();
    if (localView != null) {
      localView.post((Runnable)new ApngDecorDrawable.play.1(this));
    }
  }
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Object localObject1 = getDrawable();
    if (localObject1 != null)
    {
      localObject1 = (ApngDrawable)localObject1;
      try
      {
        if ((((ApngDrawable)localObject1).getMApngState() != null) && (getDecorState() != null)) {
          return;
        }
        Object localObject2 = FileUtil.a;
        Object localObject3 = paramView.getContext();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "view.context");
        Object localObject4 = getDecorState();
        if (localObject4 == null) {
          Intrinsics.throwNpe();
        }
        localObject4 = ((DecorDrawableState)localObject4).getPath();
        IXAEngine localIXAEngine = getEngine();
        if (localIXAEngine == null) {
          Intrinsics.throwNpe();
        }
        localObject2 = ((FileUtil.Companion)localObject2).a((Context)localObject3, (String)localObject4, "$PARENT_ROOT", localIXAEngine);
        if (localObject2 != null)
        {
          localObject3 = new Bundle();
          localObject4 = getStyle();
          if (localObject4 == null) {
            Intrinsics.throwNpe();
          }
          int i = ((ViewData)localObject4).getId();
          idCount += 1;
          this.tmpId = (i + idCount);
          ((Bundle)localObject3).putBoolean("key_double_bitmap", true);
          ((Bundle)localObject3).putIntArray("key_tagId_arr", new int[] { this.tmpId });
          localObject2 = new ApngImage(new File((String)localObject2), true, (Bundle)localObject3);
          ((ApngDrawable)localObject1).init(new ApngDrawable.ApngState((ApngImage)localObject2), paramView.getResources());
          paramView = getDecorState();
          if (paramView == null) {
            Intrinsics.throwNpe();
          }
          if (paramView.getG() != ScreenUnit.a.a())
          {
            paramView = getDecorState();
            if (paramView == null) {
              Intrinsics.throwNpe();
            }
            ((ApngDrawable)localObject1).setGravity(paramView.getG());
          }
          paramView = getStyle();
          if (paramView == null) {
            Intrinsics.throwNpe();
          }
          ((ApngImage)localObject2).apngLoop = paramView.getTp().getRc();
          return;
        }
        return;
      }
      catch (IOException paramView)
      {
        paramView.printStackTrace();
        return;
      }
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.apng.ApngDrawable");
  }
  
  public void stop()
  {
    ApngImage.pauseByTag(this.tmpId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.apng.ApngDecorDrawable
 * JD-Core Version:    0.7.0.1
 */