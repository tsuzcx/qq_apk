package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.IPtvTemplateItemCallback;

public class QIMPtvTemplateItemView
  extends LinearLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  QIMPtvTemplateAdapter.IPtvTemplateItemCallback jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$IPtvTemplateItemCallback;
  
  public QIMPtvTemplateItemView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public QIMPtvTemplateItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$IPtvTemplateItemCallback != null) {
      this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$IPtvTemplateItemCallback.a(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.QIMPtvTemplateItemView
 * JD-Core Version:    0.7.0.1
 */