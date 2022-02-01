package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.extendfriend.limitchat.CompletePesonalDataTask;
import com.tencent.mobileqq.mini.ui.dialog.DialogFromBottom;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/extendfriend/wiget/CompletePersonalDataDialog;", "Lcom/tencent/mobileqq/mini/ui/dialog/DialogFromBottom;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "subTitleView", "Landroid/widget/TextView;", "getSubTitleView", "()Landroid/widget/TextView;", "setSubTitleView", "(Landroid/widget/TextView;)V", "taskAdapter", "Lcom/tencent/mobileqq/extendfriend/wiget/CompletePersonalDataDialog$TaskAdapter;", "init", "", "refresh", "maxMatchCount", "", "leftMatchCount", "tasks", "", "Lcom/tencent/mobileqq/extendfriend/limitchat/CompletePesonalDataTask;", "showDialog", "updateTasks", "Companion", "SpacesItemDecoration", "TaskAdapter", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CompletePersonalDataDialog
  extends DialogFromBottom
{
  public static final CompletePersonalDataDialog.Companion a;
  @Nullable
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  @Nullable
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CompletePersonalDataDialog.TaskAdapter jdField_a_of_type_ComTencentMobileqqExtendfriendWigetCompletePersonalDataDialog$TaskAdapter;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqExtendfriendWigetCompletePersonalDataDialog$Companion = new CompletePersonalDataDialog.Companion(null);
  }
  
  public CompletePersonalDataDialog(@NotNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private final void a(Context paramContext)
  {
    Object localObject1 = LayoutInflater.from(paramContext).inflate(2131561207, null);
    if (localObject1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
    }
    localObject1 = (LinearLayout)localObject1;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)((LinearLayout)localObject1).findViewById(2131376818));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((LinearLayout)localObject1).findViewById(2131379523));
    Object localObject2 = new LinearLayoutManager(paramContext);
    ((LinearLayoutManager)localObject2).setOrientation(1);
    RecyclerView localRecyclerView = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
    if (localRecyclerView != null) {
      localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject2);
    }
    int i = ViewUtils.b(8.0F);
    int j = ViewUtils.b(0.0F);
    localObject2 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
    if (localObject2 != null) {
      ((RecyclerView)localObject2).addItemDecoration((RecyclerView.ItemDecoration)new CompletePersonalDataDialog.SpacesItemDecoration(i, j));
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetCompletePersonalDataDialog$TaskAdapter = new CompletePersonalDataDialog.TaskAdapter(paramContext);
    paramContext = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
    if (paramContext != null) {
      paramContext.setAdapter((RecyclerView.Adapter)this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetCompletePersonalDataDialog$TaskAdapter);
    }
    ((ImageView)((LinearLayout)localObject1).findViewById(2131363027)).setOnClickListener((View.OnClickListener)new CompletePersonalDataDialog.init.1(this));
    setOnCancelListener((DialogInterface.OnCancelListener)CompletePersonalDataDialog.init.2.a);
    ((LinearLayout)localObject1).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new CompletePersonalDataDialog.init.3((LinearLayout)localObject1));
    setContentView((View)localObject1);
  }
  
  private final void a(List<? extends CompletePesonalDataTask> paramList)
  {
    CompletePersonalDataDialog.TaskAdapter localTaskAdapter = this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetCompletePersonalDataDialog$TaskAdapter;
    if (localTaskAdapter == null) {
      Intrinsics.throwNpe();
    }
    localTaskAdapter.a(paramList);
    paramList = this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetCompletePersonalDataDialog$TaskAdapter;
    if (paramList == null) {
      Intrinsics.throwNpe();
    }
    paramList.notifyDataSetChanged();
  }
  
  public final void a(int paramInt1, int paramInt2, @Nullable List<? extends CompletePesonalDataTask> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CompletePersonalDataDialog", 2, "showDialog maxMatchCount = " + paramInt1 + ",leftMatchCount = " + paramInt2);
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CompletePersonalDataDialog", 2, "showDialog return for empty tasks");
      }
      return;
    }
    b(paramInt1, paramInt2, paramList);
    show();
  }
  
  public final void b(int paramInt1, int paramInt2, @Nullable List<? extends CompletePesonalDataTask> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CompletePersonalDataDialog", 2, "refresh maxMatchCount = " + paramInt1 + ",leftMatchCount = " + paramInt2);
    }
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      Object localObject = StringCompanionObject.INSTANCE;
      localObject = getContext().getString(2131698731);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context.getString(R.stri…_personal_data_sub_title)");
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(paramInt1);
      arrayOfObject[1] = Integer.valueOf(paramInt2);
      localObject = String.format((String)localObject, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
      localTextView.setText((CharSequence)localObject);
    }
    a(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.CompletePersonalDataDialog
 * JD-Core Version:    0.7.0.1
 */