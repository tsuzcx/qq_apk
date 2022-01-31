package cooperation.qzone.contentbox;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import cooperation.qzone.util.QZLog;

public class MsgFootTips
  extends FrameLayout
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  private String d;
  private String e;
  
  public void setBackgroundColor(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(paramInt);
    }
  }
  
  public void setDividerVisible(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void setLoadingDataText(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setLoadingMoreDataText(String paramString)
  {
    this.b = paramString;
  }
  
  public void setNoDataText(String paramString)
  {
    this.c = paramString;
  }
  
  public void setNoMoreDataText(String paramString)
  {
    this.d = paramString;
  }
  
  public void setNoMoreDataVisibility(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setState(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetProgressBar == null)) {
      return;
    }
    setVisibility(0);
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 8) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      QZLog.d("QZoneMsgManager.MsgFootTips", 2, "setState state(" + paramInt + ")，" + this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    case 1: 
      QZLog.d("QZoneMsgManager.MsgFootTips", 2, "setState state(" + paramInt + ")，" + this.b);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.b);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    case 2: 
      QZLog.d("QZoneMsgManager.MsgFootTips", 2, "setState state(" + paramInt + ")，" + this.c);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.c);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    case 3: 
      QZLog.d("QZoneMsgManager.MsgFootTips", 2, "setState state(" + paramInt + ")，隐藏");
      setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return;
    case 4: 
      QZLog.d("QZoneMsgManager.MsgFootTips", 2, "setState state(" + paramInt + ")，" + this.d);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.d);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      setVisibility(8);
      return;
    case 6: 
      QZLog.d("QZoneMsgManager.MsgFootTips", 2, "setState state(" + paramInt + ")，" + this.d);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.d);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      setVisibility(4);
      return;
    case 7: 
      QZLog.d("QZoneMsgManager.MsgFootTips", 2, "setState state(" + paramInt + ")，" + this.d);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.d);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      setVisibility(0);
      return;
    }
    QZLog.d("QZoneMsgManager.MsgFootTips", 2, "setState state(" + paramInt + ")，" + this.e);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.e);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgFootTips
 * JD-Core Version:    0.7.0.1
 */