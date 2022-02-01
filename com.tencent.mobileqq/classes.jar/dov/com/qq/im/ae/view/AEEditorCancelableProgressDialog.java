package dov.com.qq.im.ae.view;

import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class AEEditorCancelableProgressDialog
  extends ReportDialog
{
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private ProgressPieDrawable jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
  private final TextView b;
  
  public AEEditorCancelableProgressDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131755842);
    setCancelable(false);
    setCanceledOnTouchOutside(false);
    setContentView(2131558594);
    this.b = ((TextView)findViewById(2131380305));
    paramContext = (ImageView)findViewById(2131369760);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable = a();
    paramContext.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363941));
  }
  
  private ProgressPieDrawable a()
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(getContext());
    localProgressPieDrawable.a(UIUtils.a(getContext(), 94.0F));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.g(-1711276033);
    localProgressPieDrawable.h(18);
    localProgressPieDrawable.b(true);
    localProgressPieDrawable.d(false);
    localProgressPieDrawable.f(0);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.d(-16722948);
    localProgressPieDrawable.e(872415231);
    localProgressPieDrawable.i(6);
    localProgressPieDrawable.e(true);
    localProgressPieDrawable.jdField_f_of_type_Boolean = true;
    localProgressPieDrawable.jdField_f_of_type_Int = 2;
    return localProgressPieDrawable;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a(paramInt + "%");
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
  
  public void a(String paramString)
  {
    this.b.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.view.AEEditorCancelableProgressDialog
 * JD-Core Version:    0.7.0.1
 */