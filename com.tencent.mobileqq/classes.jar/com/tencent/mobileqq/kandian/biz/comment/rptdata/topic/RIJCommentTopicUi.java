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
  private static String a = HardCodeUtil.a(2131915299);
  private final View b;
  private final EditText c;
  private boolean d;
  private final Runnable e;
  
  public RIJCommentTopicUi(View paramView, EditText paramEditText, Runnable paramRunnable)
  {
    this.b = paramView;
    this.c = paramEditText;
    this.e = paramRunnable;
    if (b())
    {
      c();
      QLog.d("RIJCommentTopicUi", 1, "init topic switch on");
      return;
    }
    paramView.setVisibility(8);
    QLog.d("RIJCommentTopicUi", 1, "init topic switch off");
  }
  
  private void a(Spannable paramSpannable)
  {
    boolean bool = b(paramSpannable);
    if ((RIJCommentTopicUtil.a(paramSpannable) | bool))
    {
      this.d = true;
      int i = this.c.getSelectionStart();
      this.c.setSelection(i);
    }
  }
  
  private static boolean b()
  {
    boolean bool1 = ReadInJoyHelper.l();
    boolean bool2 = RIJUserLevelModule.getInstance().getCurrentUserLevelInfo(11).isInLevelGrayList;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isCommentTopicPublishSwitchOn: topicSwitchOn=");
    localStringBuilder.append(bool1);
    localStringBuilder.append(", isInLevelGrayList=");
    localStringBuilder.append(bool2);
    QLog.d("RIJCommentTopicUi", 1, localStringBuilder.toString());
    return (bool1) && (bool2);
  }
  
  private static boolean b(Spannable paramSpannable)
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
  
  private void c()
  {
    this.b.setOnClickListener(this);
    if (e()) {
      this.c.addTextChangedListener(this);
    }
    RIJUserLevelModule.getInstance().requestUserLevel(11, new RIJCommentTopicUi.1(this));
  }
  
  private void d()
  {
    if (!e())
    {
      QQToast.makeText(this.c.getContext(), 0, a, 0).show();
      return;
    }
    this.c.getText().replace(this.c.getSelectionStart(), this.c.getSelectionEnd(), "#");
  }
  
  private static boolean e()
  {
    boolean bool = RIJUserLevelModule.getInstance().getCacheUserLevelWithoutUgcSwitch(11);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hasTopicPrivilege: hasPrivilege=");
    localStringBuilder.append(bool);
    QLog.d("RIJCommentTopicUi", 1, localStringBuilder.toString());
    return bool;
  }
  
  public void a()
  {
    this.c.removeTextChangedListener(this);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.d)
    {
      this.d = false;
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
    d();
    paramView = this.e;
    if (paramView != null) {
      paramView.run();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.rptdata.topic.RIJCommentTopicUi
 * JD-Core Version:    0.7.0.1
 */