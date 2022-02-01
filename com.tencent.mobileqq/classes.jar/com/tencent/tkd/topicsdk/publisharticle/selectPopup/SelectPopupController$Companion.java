package com.tencent.tkd.topicsdk.publisharticle.selectPopup;

import android.app.Activity;
import android.content.Context;
import android.text.TextWatcher;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/selectPopup/SelectPopupController$Companion;", "", "()V", "TAG", "", "TYPE_DEFAULT", "", "init", "Lcom/tencent/tkd/topicsdk/publisharticle/selectPopup/SelectPopupController;", "T", "activity", "Landroid/app/Activity;", "text", "Lcom/tencent/tkd/weibo/richEditText/RichEditText;", "model", "Lcom/tencent/tkd/topicsdk/publisharticle/selectPopup/ISelectPopupModel;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class SelectPopupController$Companion
{
  @NotNull
  public final <T> SelectPopupController<T> a(@NotNull Activity paramActivity, @NotNull RichEditText paramRichEditText, @NotNull ISelectPopupModel<T> paramISelectPopupModel)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramRichEditText, "text");
    Intrinsics.checkParameterIsNotNull(paramISelectPopupModel, "model");
    SelectPopupController localSelectPopupController = new SelectPopupController(paramActivity, null);
    paramRichEditText.setOnSelectionChangeListener(SelectPopupController.a(localSelectPopupController));
    paramRichEditText.addTextChangedListener((TextWatcher)new SelectPopupController.InnerTextWatcher(localSelectPopupController, (Context)paramActivity));
    SelectPopupController.a(localSelectPopupController, paramRichEditText);
    SelectPopupController.a(localSelectPopupController, paramISelectPopupModel);
    Object localObject = paramRichEditText.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "text.context");
    localObject = new SelectPopupView((Context)localObject, null, 2, null);
    ((SelectPopupView)localObject).a((Function0)new SelectPopupController.Companion.init..inlined.apply.lambda.1(localSelectPopupController, paramRichEditText, paramActivity, paramISelectPopupModel));
    ((SelectPopupView)localObject).b((Function0)new SelectPopupController.Companion.init..inlined.apply.lambda.2(localSelectPopupController, paramRichEditText, paramActivity, paramISelectPopupModel));
    SelectPopupController.a(localSelectPopupController, (SelectPopupView)localObject);
    return localSelectPopupController;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.selectPopup.SelectPopupController.Companion
 * JD-Core Version:    0.7.0.1
 */