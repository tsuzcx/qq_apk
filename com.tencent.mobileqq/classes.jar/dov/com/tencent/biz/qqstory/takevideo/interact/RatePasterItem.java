package dov.com.tencent.biz.qqstory.takevideo.interact;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.widget.RateWidget;
import com.tencent.mobileqq.utils.StringUtil;

public class RatePasterItem
  extends InteractPasterItem
{
  private View jdField_a_of_type_AndroidViewView;
  private RateWidget jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget;
  
  protected View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public InteractPasterItem.InteractPasterInfo a()
  {
    return new InteractPasterItem.InteractPasterInfo(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.a(), this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.a(), this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.a(), false);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.a(new String[] { this.jdField_a_of_type_AndroidWidgetEditText.getText().toString() });
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.c(false);
  }
  
  public void a(Context paramContext, InteractPasterItem.InteractPasterInfo paramInteractPasterInfo, EditText paramEditText, TextView paramTextView, InteractPasterItem.InteractPasterEditListener paramInteractPasterEditListener)
  {
    super.a(paramContext, paramInteractPasterInfo, paramEditText, paramTextView, paramInteractPasterEditListener);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget = new RateWidget(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.b(false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.a(0.0F);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.c(true);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.a();
    if (paramInteractPasterInfo == null) {
      a(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.a(), true);
    }
    for (;;)
    {
      a(paramEditText.getText().toString(), 24);
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.a(paramInteractPasterInfo.a);
      a(paramInteractPasterInfo.a[0], false);
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.a(new String[] { this.jdField_a_of_type_AndroidWidgetEditText.getText().toString() });
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.c(false);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterItem$InteractPasterEditListener.a();
      return true;
    }
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = StringUtil.b(paramCharSequence.toString());
    if (24 - paramInt2 <= 6)
    {
      paramInt1 = paramInt2;
      Object localObject = paramCharSequence;
      if (24 - paramInt2 < 0)
      {
        localObject = StringUtil.b(paramCharSequence.toString(), 0, 24);
        paramInt1 = StringUtil.b(((CharSequence)localObject).toString());
        a((CharSequence)localObject, false);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%s/%s", new Object[] { Integer.valueOf(paramInt1 / 2), Integer.valueOf(12) }));
      paramCharSequence = (CharSequence)localObject;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.a(new String[] { paramCharSequence.toString() });
      if (TextUtils.isEmpty(paramCharSequence)) {
        a(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.a(), true);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.interact.RatePasterItem
 * JD-Core Version:    0.7.0.1
 */