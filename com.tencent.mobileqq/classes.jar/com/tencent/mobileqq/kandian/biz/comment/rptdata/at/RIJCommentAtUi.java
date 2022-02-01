package com.tencent.mobileqq.kandian.biz.comment.rptdata.at;

import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.kandian.biz.biu.BiuNicknameSpan;
import com.tencent.mobileqq.kandian.biz.comment.emotion.util.RIJEmotionUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.ugc.selectmember.ReadInJoySelectMemberFragment;
import com.tencent.mobileqq.kandian.repo.ugc.ResultRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import java.util.Iterator;

public class RIJCommentAtUi
  implements TextWatcher, View.OnClickListener
{
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private final EditText jdField_a_of_type_AndroidWidgetEditText;
  private final Runnable jdField_a_of_type_JavaLangRunnable;
  
  public RIJCommentAtUi(Activity paramActivity, View paramView, EditText paramEditText, Runnable paramRunnable)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    if (a())
    {
      paramView.setOnClickListener(this);
      paramEditText.addTextChangedListener(this);
      return;
    }
    paramView.setVisibility(8);
  }
  
  private void a()
  {
    InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    Intent localIntent = new Intent();
    localIntent.putExtra("maxSelect", 1);
    PublicFragmentActivity.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, ReadInJoySelectMemberFragment.class, 10000);
  }
  
  private void a(Intent paramIntent)
  {
    Object localObject1 = paramIntent.getParcelableArrayListExtra("result_set");
    if (localObject1 != null)
    {
      int j = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      paramIntent = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText();
      if (paramIntent != null)
      {
        paramIntent = new SpannableStringBuilder(paramIntent);
        RIJEmotionUtil.a(paramIntent);
        int i = j;
        if (a(paramIntent.toString(), j))
        {
          paramIntent.delete(j - 1, j);
          i = j - 1;
          this.jdField_a_of_type_AndroidWidgetEditText.setSelection(i);
        }
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject1).next();
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("@");
          ((StringBuilder)localObject2).append(BiuNicknameSpan.a(localResultRecord.b()));
          ((StringBuilder)localObject2).append(' ');
          localObject2 = ((StringBuilder)localObject2).toString();
          paramIntent.insert(i, (CharSequence)localObject2);
          paramIntent.setSpan(new RIJCommentAtSpan(localResultRecord.a(), 0L, (CharSequence)localObject2, -12541697), i, ((String)localObject2).length() + i, 33);
          i += ((String)localObject2).length();
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setText(paramIntent);
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(i);
      }
    }
  }
  
  public static boolean a()
  {
    boolean bool = ReadInJoyHelper.g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isCommentAtSwitchOn: atSwitchOn=");
    localStringBuilder.append(bool);
    QLog.d("RIJCommentAtUi", 1, localStringBuilder.toString());
    return bool;
  }
  
  private static boolean a(String paramString, int paramInt)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramInt > 0) && (paramString.startsWith("@", paramInt - 1));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 10000) && (paramInt2 == -1))
    {
      if (paramIntent == null) {
        return;
      }
      a(paramIntent);
    }
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    a();
    paramView = this.jdField_a_of_type_JavaLangRunnable;
    if (paramView != null) {
      paramView.run();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 == 1) && (paramInt2 == 0) && ("@".equals(paramCharSequence.toString().substring(paramInt1, paramInt1 + 1)))) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.rptdata.at.RIJCommentAtUi
 * JD-Core Version:    0.7.0.1
 */