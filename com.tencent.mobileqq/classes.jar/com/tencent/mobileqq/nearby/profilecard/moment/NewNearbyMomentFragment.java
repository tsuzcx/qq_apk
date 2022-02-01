package com.tencent.mobileqq.nearby.profilecard.moment;

import android.content.Context;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/nearby/profilecard/moment/NewNearbyMomentFragment;", "Lcom/tencent/mobileqq/nearby/profilecard/moment/NearbyMomentFragment;", "()V", "getEmptyContentString", "", "getEmptyImageUrl", "getErrorImageUrl", "getLoadingGifUrl", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class NewNearbyMomentFragment
  extends NearbyMomentFragment
{
  private HashMap c;
  
  @NotNull
  protected String a()
  {
    return "https://dldir1.qq.com/huayang/qq/images/76b8502dfdeaa7e0b68992999351a2bb.png";
  }
  
  @NotNull
  protected String b()
  {
    return "https://dldir1.qq.com/huayang/qq/images/76b8502dfdeaa7e0b68992999351a2bb.png";
  }
  
  @NotNull
  protected String c()
  {
    return "https://dldir1.qq.com/huayang/qq/images/76b8502dfdeaa7e0b68992999351a2bb.png";
  }
  
  @NotNull
  protected String f()
  {
    Object localObject = this.a;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mEmptyTextView");
    localObject = ((TextView)localObject).getContext().getString(1946615820);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mEmptyTextView.context.g…ile_empty_content_notice)");
    return localObject;
  }
  
  public void g()
  {
    HashMap localHashMap = this.c;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NewNearbyMomentFragment
 * JD-Core Version:    0.7.0.1
 */