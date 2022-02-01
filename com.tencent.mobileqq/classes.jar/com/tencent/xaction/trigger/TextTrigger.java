package com.tencent.xaction.trigger;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.DecorDrawable;
import com.tencent.xaction.api.base.DecorDrawable.Companion;
import com.tencent.xaction.api.data.KeyWord;
import com.tencent.xaction.impl.AnimStateListener;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XATimeline;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/trigger/TextTrigger;", "Lcom/tencent/xaction/trigger/BaseTrigger;", "()V", "keywords", "Ljava/util/ArrayList;", "Lcom/tencent/xaction/api/data/KeyWord;", "Lkotlin/collections/ArrayList;", "getKeywords", "()Ljava/util/ArrayList;", "keyAnim", "", "it", "stateKey", "", "notifyState", "key", "value", "", "sendText", "text", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class TextTrigger
  extends BaseTrigger
{
  @Nullable
  private final ArrayList<KeyWord> keywords;
  
  @RequiresApi(16)
  private final boolean keyAnim(KeyWord paramKeyWord, String paramString)
  {
    if (Intrinsics.areEqual(paramString, "$MSG_TEXT_FIRST")) {
      return true;
    }
    int i;
    if (Intrinsics.areEqual(paramString, "$MSG_TEXT")) {
      i = paramKeyWord.getHierarchy();
    } else {
      i = paramKeyWord.getStaticHierarchy();
    }
    Object localObject1 = getIView();
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    localObject1 = ((IView)localObject1).getDecor().b();
    if (localObject1 != null)
    {
      Object localObject2 = DecorDrawable.Companion;
      Object localObject3 = getEngine();
      if (localObject3 == null) {
        Intrinsics.throwNpe();
      }
      localObject2 = ((DecorDrawable.Companion)localObject2).a((XAEngine)localObject3, paramKeyWord.getDrawableId(), i, (View)localObject1, true, true);
      if ((localObject2 instanceof Drawable))
      {
        localObject3 = getIView();
        if (localObject3 == null) {
          Intrinsics.throwNpe();
        }
        ((IView)localObject3).getDecor().setDrawable((Drawable)localObject2);
      }
      if (localObject2 != null)
      {
        localObject3 = ((IDrawable)localObject2).getDecor();
        if (localObject3 != null)
        {
          localObject3 = ((DecorDrawable)localObject3).getTl();
          if (localObject3 == null) {
            Intrinsics.throwNpe();
          }
          ((XATimeline)localObject3).e();
          if (Intrinsics.areEqual(paramString, "$MSG_TEXT"))
          {
            paramString = ((IDrawable)localObject2).getDecor();
            if (paramString != null)
            {
              paramString = ((DecorDrawable)paramString).getTl();
              if (paramString == null) {
                Intrinsics.throwNpe();
              }
              paramString.a((AnimStateListener)new TextTrigger.keyAnim.1((View)localObject1));
              paramString = ((IDrawable)localObject2).getDecor();
              if (paramString != null)
              {
                paramString = ((DecorDrawable)paramString).getTl();
                if (paramString == null) {
                  Intrinsics.throwNpe();
                }
                paramString.c();
              }
              else
              {
                throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.base.DecorDrawable");
              }
            }
            else
            {
              throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.base.DecorDrawable");
            }
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.base.DecorDrawable");
        }
      }
      paramString = getIView();
      if (paramString == null) {
        Intrinsics.throwNpe();
      }
      paramString = paramString.getDecor().b();
      if (paramString == null) {
        Intrinsics.throwNpe();
      }
      updateStatus(paramString, paramKeyWord.getStatus());
      setStatus("");
      return true;
    }
    return false;
  }
  
  @Nullable
  public final ArrayList<KeyWord> getKeywords()
  {
    return this.keywords;
  }
  
  public boolean notifyState(@NotNull String paramString, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    Intrinsics.checkParameterIsNotNull(paramObject, "value");
    super.notifyState(paramString, paramObject);
    if (((paramObject instanceof String)) && (Build.VERSION.SDK_INT >= 16)) {
      return sendText(paramString, (String)paramObject);
    }
    return false;
  }
  
  @RequiresApi(16)
  public final boolean sendText(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "stateKey");
    Intrinsics.checkParameterIsNotNull(paramString2, "text");
    if (getIView() != null)
    {
      if (getEngine() == null) {
        return false;
      }
      Object localObject = this.keywords;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          KeyWord localKeyWord = (KeyWord)((Iterator)localObject).next();
          String[] arrayOfString = localKeyWord.getKeys();
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            String str = arrayOfString[i];
            if (StringsKt.contains$default((CharSequence)paramString2, (CharSequence)str, false, 2, null)) {
              return keyAnim(localKeyWord, paramString1);
            }
            i += 1;
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.trigger.TextTrigger
 * JD-Core Version:    0.7.0.1
 */