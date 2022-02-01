package com.tencent.tkd.topicsdk.publisharticle.selectPopup;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.View;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/selectPopup/SelectPopupController;", "T", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "invalidCharPattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "onPopupClickListener", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "selectionStart", "", "createBySpace", "", "getOnPopupClickListener", "()Lkotlin/jvm/functions/Function3;", "setOnPopupClickListener", "(Lkotlin/jvm/functions/Function3;)V", "onPopupViewShowListener", "Lkotlin/Function1;", "show", "getOnPopupViewShowListener", "()Lkotlin/jvm/functions/Function1;", "setOnPopupViewShowListener", "(Lkotlin/jvm/functions/Function1;)V", "popupHorizontalMargin", "getPopupHorizontalMargin", "()I", "setPopupHorizontalMargin", "(I)V", "popupXInWindow", "popupYInWindow", "richEditText", "Lcom/tencent/tkd/weibo/richEditText/RichEditText;", "selectPopupModel", "Lcom/tencent/tkd/topicsdk/publisharticle/selectPopup/ISelectPopupModel;", "selectPopupView", "Lcom/tencent/tkd/topicsdk/publisharticle/selectPopup/SelectPopupView;", "selectionChangeListener", "Lkotlin/Function2;", "wordingLimit", "wordingStartPos", "hidePopupView", "value", "isPopupShowing", "showPopupView", "isForceLeft", "isForceRight", "updatePopupViewPosition", "updatePopupXY", "Companion", "InnerTextWatcher", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class SelectPopupController<T>
{
  public static final SelectPopupController.Companion a = new SelectPopupController.Companion(null);
  @Nullable
  private Function3<? super Integer, ? super Boolean, ? super T, Unit> b;
  private int c;
  @Nullable
  private Function1<? super Boolean, Unit> d;
  private SelectPopupView e;
  private RichEditText f;
  private ISelectPopupModel<T> g;
  private int h;
  private int i;
  private int j;
  private final Pattern k;
  private final int l;
  private final Function2<Integer, Integer, Unit> m;
  @NotNull
  private final Activity n;
  
  private SelectPopupController(Activity paramActivity)
  {
    this.n = paramActivity;
    this.c = DisplayUtils.a.a((Context)this.n, 12.0F);
    this.h = -1;
    this.i = -1;
    this.j = -1;
    this.k = Pattern.compile("\\W");
    this.l = 12;
    this.m = ((Function2)new SelectPopupController.selectionChangeListener.1(this));
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    c(paramBoolean1, paramBoolean2);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showPopupView x: ");
    ((StringBuilder)localObject).append(this.h);
    ((StringBuilder)localObject).append(", y: ");
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append('.');
    TLog.b("SelectPopupController", ((StringBuilder)localObject).toString());
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selectPopupView");
    }
    RichEditText localRichEditText = this.f;
    if (localRichEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    ((SelectPopupView)localObject).showAtLocation((View)localRichEditText, 0, this.h, this.i);
    localObject = this.d;
    if (localObject != null) {
      localObject = (Unit)((Function1)localObject).invoke(Boolean.valueOf(true));
    }
  }
  
  private final void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    c(paramBoolean1, paramBoolean2);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updatePopupView x: ");
    ((StringBuilder)localObject).append(this.h);
    ((StringBuilder)localObject).append(", y: ");
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append('.');
    TLog.b("SelectPopupController", ((StringBuilder)localObject).toString());
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selectPopupView");
    }
    ((SelectPopupView)localObject).update(this.h, this.i, -1, -1);
  }
  
  private final void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    int i1 = ((RichEditText)localObject).getSelectionStart();
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localObject = ((RichEditText)localObject).getLayout();
    int i2 = ((Layout)localObject).getLineForOffset(i1);
    int i3 = ((Layout)localObject).getLineBaseline(i2);
    int i4 = ((Layout)localObject).getLineAscent(i2);
    int i5 = (int)((Layout)localObject).getPrimaryHorizontal(i1);
    i1 = (int)((Layout)localObject).getPrimaryHorizontal(0) + this.c;
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    i2 = ((RichEditText)localObject).getRight();
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selectPopupView");
    }
    i2 = i2 - ((SelectPopupView)localObject).getWidth() - this.c;
    if (!paramBoolean1) {
      if (paramBoolean2) {
        i1 = i2;
      } else {
        i1 = Math.min(i5, i2);
      }
    }
    this.h = i1;
    i1 = (int)(i3 + i4);
    localObject = new int[2];
    RichEditText localRichEditText = this.f;
    if (localRichEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localRichEditText.getLocationInWindow((int[])localObject);
    localRichEditText = this.f;
    if (localRichEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    i2 = localRichEditText.getLineHeight();
    i3 = DisplayUtils.a.a((Context)this.n, 5.0F);
    this.i = (i1 + localObject[1] + i2 + i3);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updatePopupXY x: ");
    ((StringBuilder)localObject).append(this.h);
    ((StringBuilder)localObject).append(", y: ");
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append('.');
    TLog.b("SelectPopupController", ((StringBuilder)localObject).toString());
  }
  
  @Nullable
  public final Function3<Integer, Boolean, T, Unit> a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("hidePopupView. ");
    ((StringBuilder)localObject).append(paramInt);
    TLog.b("SelectPopupController", ((StringBuilder)localObject).toString());
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selectPopupView");
    }
    ((SelectPopupView)localObject).b("");
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selectPopupView");
    }
    ((SelectPopupView)localObject).dismiss();
    localObject = this.d;
    if (localObject != null) {
      localObject = (Unit)((Function1)localObject).invoke(Boolean.valueOf(false));
    }
  }
  
  public final void a(@Nullable Function1<? super Boolean, Unit> paramFunction1)
  {
    this.d = paramFunction1;
  }
  
  public final void a(@Nullable Function3<? super Integer, ? super Boolean, ? super T, Unit> paramFunction3)
  {
    this.b = paramFunction3;
  }
  
  public final boolean b()
  {
    SelectPopupView localSelectPopupView = this.e;
    if (localSelectPopupView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selectPopupView");
    }
    return localSelectPopupView.isShowing();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.selectPopup.SelectPopupController
 * JD-Core Version:    0.7.0.1
 */