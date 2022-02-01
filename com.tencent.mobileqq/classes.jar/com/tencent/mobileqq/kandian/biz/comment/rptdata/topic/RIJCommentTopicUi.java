package com.tencent.mobileqq.kandian.biz.comment.rptdata.topic;

import android.text.Editable;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.account.UserLevelInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class RIJCommentTopicUi
  implements TextWatcher, View.OnClickListener
{
  private static String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131717824);
  private final View jdField_a_of_type_AndroidViewView;
  private final EditText jdField_a_of_type_AndroidWidgetEditText;
  private final Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean;
  
  public RIJCommentTopicUi(View paramView, EditText paramEditText, Runnable paramRunnable)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    if (a())
    {
      b();
      QLog.d("RIJCommentTopicUi", 1, "init topic switch on");
      return;
    }
    paramView.setVisibility(8);
    QLog.d("RIJCommentTopicUi", 1, "init topic switch off");
  }
  
  private void a(Spannable paramSpannable)
  {
    boolean bool = a(paramSpannable);
    if ((RIJCommentTopicUtil.a(paramSpannable) | bool))
    {
      this.jdField_a_of_type_Boolean = true;
      int i = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(i);
    }
  }
  
  private static boolean a()
  {
    boolean bool1 = ReadInJoyHelper.f();
    boolean bool2 = RIJUserLevelModule.getInstance().getCurrentUserLevelInfo(11).isInLevelGrayList;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isCommentTopicPublishSwitchOn: topicSwitchOn=");
    localStringBuilder.append(bool1);
    localStringBuilder.append(", isInLevelGrayList=");
    localStringBuilder.append(bool2);
    QLog.d("RIJCommentTopicUi", 1, localStringBuilder.toString());
    return (bool1) && (bool2);
  }
  
  private static boolean a(Spannable paramSpannable)
  {
    int j = paramSpannable.length();
    int i = 0;
    RIJCommentTopicSpan[] arrayOfRIJCommentTopicSpan = (RIJCommentTopicSpan[])paramSpannable.getSpans(0, j, RIJCommentTopicSpan.class);
    if ((arrayOfRIJCommentTopicSpan != null) && (arrayOfRIJCommentTopicSpan.length > 0))
    {
      j = arrayOfRIJCommentTopicSpan.length;
      while (i < j)
      {
        paramSpannable.removeSpan(arrayOfRIJCommentTopicSpan[i]);
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    if (b()) {
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    }
    RIJUserLevelModule.getInstance().requestUserLevel(11, new RIJCommentTopicUi.1(this));
  }
  
  private static boolean b()
  {
    boolean bool = RIJUserLevelModule.getInstance().getCacheUserLevelWithoutUgcSwitch(11);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hasTopicPrivilege: hasPrivilege=");
    localStringBuilder.append(bool);
    QLog.d("RIJCommentTopicUi", 1, localStringBuilder.toString());
    return bool;
  }
  
  private void c()
  {
    if (!b())
    {
      QQToast.a(this.jdField_a_of_type_AndroidWidgetEditText.getContext(), 0, jdField_a_of_type_JavaLangString, 0).a();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.getText().replace(this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart(), this.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd(), "#");
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    if (TextUtils.isEmpty(paramEditable)) {
      return;
    }
    a(paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    c();
    paramView = this.jdField_a_of_type_JavaLangRunnable;
    if (paramView != null) {
      paramView.run();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.rptdata.topic.RIJCommentTopicUi
 * JD-Core Version:    0.7.0.1
 */