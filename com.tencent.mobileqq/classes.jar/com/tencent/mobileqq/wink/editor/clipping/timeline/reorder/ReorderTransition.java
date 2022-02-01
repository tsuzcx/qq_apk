package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.graphics.Rect;
import android.transition.TransitionValues;
import android.view.View;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ReorderTransition;", "", "()V", "tempLocation", "", "captureStartValue", "Landroid/animation/Animator;", "views", "", "Landroid/view/View;", "targetIndex", "", "startX", "thumbWidth", "createAnimator", "start", "Landroid/transition/TransitionValues;", "end", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ReorderTransition
{
  public static final ReorderTransition a = new ReorderTransition();
  private static final int[] b = new int[2];
  
  @RequiresApi(19)
  private final Animator a(TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    View localView = paramTransitionValues1.view;
    Object localObject1 = paramTransitionValues1.values.get("android:clipBounds:bounds");
    if (localObject1 != null)
    {
      localObject1 = (Rect)localObject1;
      Object localObject2 = paramTransitionValues2.values.get("android:clipBounds:bounds");
      if (localObject2 != null)
      {
        localObject2 = (Rect)localObject2;
        LeftEvaluator localLeftEvaluator = new LeftEvaluator(new Rect());
        localObject1 = ObjectAnimator.ofObject(localView, ReorderBounds.a.a(), (TypeEvaluator)localLeftEvaluator, new Rect[] { localObject1, localObject2 });
        ((ObjectAnimator)localObject1).addListener((Animator.AnimatorListener)new ReorderTransition.createAnimator.1(localView));
        paramTransitionValues1 = paramTransitionValues1.values.get("android:changeBounds:windowX");
        if (paramTransitionValues1 != null)
        {
          int i = ((Integer)paramTransitionValues1).intValue();
          paramTransitionValues1 = paramTransitionValues2.values.get("android:changeBounds:windowX");
          if (paramTransitionValues1 != null)
          {
            float f1 = ((Integer)paramTransitionValues1).intValue();
            float f2 = i;
            Intrinsics.checkExpressionValueIsNotNull(localView, "target");
            float f3 = localView.getTranslationX();
            paramTransitionValues1 = ObjectAnimator.ofFloat(localView, "translationX", new float[] { f1 - f2 });
            paramTransitionValues1.addListener((Animator.AnimatorListener)new ReorderTransition.createAnimator.2(localView, f3));
            paramTransitionValues2 = new AnimatorSet();
            paramTransitionValues2.playTogether(new Animator[] { (Animator)localObject1, (Animator)paramTransitionValues1 });
            return (Animator)paramTransitionValues2;
          }
          throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
      }
      throw new TypeCastException("null cannot be cast to non-null type android.graphics.Rect");
    }
    throw new TypeCastException("null cannot be cast to non-null type android.graphics.Rect");
  }
  
  @RequiresApi(19)
  @NotNull
  public final Animator a(@Nullable List<? extends View> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramList == null) {
      return (Animator)new AnimatorSet();
    }
    List localList = (List)new ArrayList();
    Object localObject2 = (Iterable)CollectionsKt.getIndices((Collection)paramList);
    Object localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add((View)paramList.get(((IntIterator)localObject2).nextInt()));
    }
    paramList = ((Iterable)localObject1).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      localObject1 = paramList.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      localObject1 = (View)localObject1;
      localObject2 = new TransitionValues();
      ((View)localObject1).getLocationInWindow(b);
      Object localObject3 = ((TransitionValues)localObject2).values;
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "startValue.values");
      ((Map)localObject3).put("android:changeBounds:windowX", Integer.valueOf(b[0]));
      localObject3 = ((TransitionValues)localObject2).values;
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "startValue.values");
      ((Map)localObject3).put("android:clipBounds:bounds", new Rect(0, 0, ((View)localObject1).getWidth(), ((View)localObject1).getHeight()));
      ((TransitionValues)localObject2).view = ((View)localObject1);
      localObject3 = new TransitionValues();
      Map localMap = ((TransitionValues)localObject3).values;
      Intrinsics.checkExpressionValueIsNotNull(localMap, "endValue.values");
      localMap.put("android:clipBounds:bounds", new Rect(0, 0, paramInt3, ((View)localObject1).getHeight()));
      localMap = ((TransitionValues)localObject3).values;
      Intrinsics.checkExpressionValueIsNotNull(localMap, "endValue.values");
      localMap.put("android:changeBounds:windowX", Integer.valueOf(paramInt2 + (i - paramInt1) * paramInt3));
      ((TransitionValues)localObject3).view = ((View)localObject1);
      localList.add(a.a((TransitionValues)localObject2, (TransitionValues)localObject3));
      i += 1;
    }
    paramList = new AnimatorSet();
    paramList.playTogether((Collection)localList);
    return (Animator)paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ReorderTransition
 * JD-Core Version:    0.7.0.1
 */