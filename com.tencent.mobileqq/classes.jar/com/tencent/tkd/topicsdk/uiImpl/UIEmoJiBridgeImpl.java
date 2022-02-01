package com.tencent.tkd.topicsdk.uiImpl;

import android.graphics.drawable.Drawable;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.interfaces.IEmoJiEmotion;
import com.tencent.tkd.weibo.framework.IEmoJiBridge;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/uiImpl/UIEmoJiBridgeImpl;", "Lcom/tencent/tkd/weibo/framework/IEmoJiBridge;", "()V", "emoJiEmotionImpl", "Lcom/tencent/tkd/topicsdk/interfaces/IEmoJiEmotion;", "getEmoJiDrawableByText", "Landroid/graphics/drawable/Drawable;", "text", "", "getEmoJiMatchPattern", "Ljava/util/regex/Pattern;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class UIEmoJiBridgeImpl
  implements IEmoJiBridge
{
  private final IEmoJiEmotion a = TopicSDK.a.a().a().a();
  
  @Nullable
  public Drawable a(@NotNull String paramString)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    String[] arrayOfString = this.a.a();
    Intrinsics.checkExpressionValueIsNotNull(arrayOfString, "emoJiEmotionImpl.emoJiShowNameArray");
    int[] arrayOfInt = this.a.a();
    Intrinsics.checkExpressionValueIsNotNull(arrayOfInt, "emoJiEmotionImpl.emoJiResourceArray");
    if (arrayOfString.length == 0)
    {
      i = 1;
      if (i == 0)
      {
        if (arrayOfInt.length != 0) {
          break label84;
        }
        i = j;
        label64:
        if ((i == 0) && (arrayOfString.length == arrayOfInt.length)) {
          break label89;
        }
      }
    }
    label84:
    label89:
    do
    {
      return null;
      i = 0;
      break;
      i = 0;
      break label64;
      i = ArraysKt.indexOf(arrayOfString, paramString);
    } while ((i < 0) || (i > ArraysKt.getLastIndex(arrayOfString)));
    int i = arrayOfInt[i];
    return this.a.a(i);
  }
  
  @Nullable
  public Pattern a()
  {
    return Pattern.compile("\\[/[\\u4e00-\\u9fa5]{1,3}]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.uiImpl.UIEmoJiBridgeImpl
 * JD-Core Version:    0.7.0.1
 */