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
  public static final SelectPopupController.Companion a;
  private int jdField_a_of_type_Int;
  @NotNull
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private ISelectPopupModel<T> jdField_a_of_type_ComTencentTkdTopicsdkPublisharticleSelectPopupISelectPopupModel;
  private SelectPopupView jdField_a_of_type_ComTencentTkdTopicsdkPublisharticleSelectPopupSelectPopupView;
  private RichEditText jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
  private final Pattern jdField_a_of_type_JavaUtilRegexPattern;
  @Nullable
  private Function1<? super Boolean, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  private final Function2<Integer, Integer, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction2;
  @Nullable
  private Function3<? super Integer, ? super Boolean, ? super T, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction3;
  private int b;
  private int c;
  private int d;
  private final int e;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkPublisharticleSelectPopupSelectPopupController$Companion = new SelectPopupController.Companion(null);
  }
  
  private SelectPopupController(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Int = DisplayUtils.a.a((Context)this.jdField_a_of_type_AndroidAppActivity, 12.0F);
    this.b = -1;
    this.c = -1;
    this.d = -1;
    this.jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("\\W");
    this.e = 12;
    this.jdField_a_of_type_KotlinJvmFunctionsFunction2 = ((Function2)new SelectPopupController.selectionChangeListener.1(this));
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    c(paramBoolean1, paramBoolean2);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showPopupView x: ");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(", y: ");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append('.');
    TLog.b("SelectPopupController", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticleSelectPopupSelectPopupView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selectPopupView");
    }
    RichEditText localRichEditText = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localRichEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    ((SelectPopupView)localObject).showAtLocation((View)localRichEditText, 0, this.b, this.c);
    localObject = this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
    if (localObject != null) {
      localObject = (Unit)((Function1)localObject).invoke(Boolean.valueOf(true));
    }
  }
  
  private final void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    c(paramBoolean1, paramBoolean2);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updatePopupView x: ");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(", y: ");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append('.');
    TLog.b("SelectPopupController", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticleSelectPopupSelectPopupView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selectPopupView");
    }
    ((SelectPopupView)localObject).update(this.b, this.c, -1, -1);
  }
  
  private final void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    int i = ((RichEditText)localObject).getSelectionStart();
    localObject = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localObject = ((RichEditText)localObject).getLayout();
    int j = ((Layout)localObject).getLineForOffset(i);
    int k = ((Layout)localObject).getLineBaseline(j);
    int m = ((Layout)localObject).getLineAscent(j);
    int n = (int)((Layout)localObject).getPrimaryHorizontal(i);
    i = (int)((Layout)localObject).getPrimaryHorizontal(0) + this.jdField_a_of_type_Int;
    localObject = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    j = ((RichEditText)localObject).getRight();
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticleSelectPopupSelectPopupView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selectPopupView");
    }
    j = j - ((SelectPopupView)localObject).getWidth() - this.jdField_a_of_type_Int;
    if (!paramBoolean1) {
      if (paramBoolean2) {
        i = j;
      } else {
        i = Math.min(n, j);
      }
    }
    this.b = i;
    i = (int)(k + m);
    localObject = new int[2];
    RichEditText localRichEditText = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localRichEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    localRichEditText.getLocationInWindow((int[])localObject);
    localRichEditText = this.jdField_a_of_type_ComTencentTkdWeiboRichEditTextRichEditText;
    if (localRichEditText == null) {
      Intrinsics.throwUninitializedPropertyAccessException("richEditText");
    }
    j = localRichEditText.getLineHeight();
    k = DisplayUtils.a.a((Context)this.jdField_a_of_type_AndroidAppActivity, 5.0F);
    this.c = (i + localObject[1] + j + k);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updatePopupXY x: ");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(", y: ");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append('.');
    TLog.b("SelectPopupController", ((StringBuilder)localObject).toString());
  }
  
  @Nullable
  public final Function3<Integer, Boolean, T, Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction3;
  }
  
  public final void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("hidePopupView. ");
    ((StringBuilder)localObject).append(paramInt);
    TLog.b("SelectPopupController", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticleSelectPopupSelectPopupView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selectPopupView");
    }
    ((SelectPopupView)localObject).b("");
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticleSelectPopupSelectPopupView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selectPopupView");
    }
    ((SelectPopupView)localObject).dismiss();
    localObject = this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
    if (localObject != null) {
      localObject = (Unit)((Function1)localObject).invoke(Boolean.valueOf(false));
    }
  }
  
  public final void a(@Nullable Function1<? super Boolean, Unit> paramFunction1)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public final void a(@Nullable Function3<? super Integer, ? super Boolean, ? super T, Unit> paramFunction3)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction3 = paramFunction3;
  }
  
  public final boolean a()
  {
    SelectPopupView localSelectPopupView = this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticleSelectPopupSelectPopupView;
    if (localSelectPopupView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selectPopupView");
    }
    return localSelectPopupView.isShowing();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.selectPopup.SelectPopupController
 * JD-Core Version:    0.7.0.1
 */