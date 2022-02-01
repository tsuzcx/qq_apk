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
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.kandian.biz.biu.BiuNicknameSpan;
import com.tencent.mobileqq.kandian.biz.comment.emotion.util.RIJEmotionUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.ugc.selectmember.ReadInJoySelectMemberFragment;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.ugc.ResultRecord;
import com.tencent.mobileqq.utils.NumberUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RIJCommentAtUi
  implements TextWatcher, View.OnClickListener
{
  private final Activity a;
  private final EditText b;
  private final Runnable c;
  
  public RIJCommentAtUi(Activity paramActivity, View paramView, EditText paramEditText, Runnable paramRunnable)
  {
    this.a = paramActivity;
    this.b = paramEditText;
    this.c = paramRunnable;
    if (a())
    {
      paramView.setOnClickListener(this);
      paramEditText.addTextChangedListener(this);
      return;
    }
    paramView.setVisibility(8);
  }
  
  @Nullable
  private static String a(long paramLong)
  {
    if (paramLong == 0L) {
      return null;
    }
    ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(paramLong, null);
    if (localReadInJoyUserInfo != null) {
      return localReadInJoyUserInfo.nick;
    }
    return ReadInJoyUserInfoModule.d();
  }
  
  private void a(Intent paramIntent)
  {
    Object localObject = b(paramIntent);
    if (((List)localObject).isEmpty()) {
      return;
    }
    paramIntent = c();
    RIJEmotionUtil.a(paramIntent);
    int j = this.b.getSelectionStart();
    int i = j;
    if (a(paramIntent.toString(), j))
    {
      paramIntent.delete(j - 1, j);
      i = j - 1;
      this.b.setSelection(i);
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = ((ResultRecord)((Iterator)localObject).next()).a();
      String str2 = a(NumberUtils.a(str1, 0L));
      if (!TextUtils.isEmpty(str2))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("@");
        localStringBuilder.append(BiuNicknameSpan.a(str2));
        localStringBuilder.append(' ');
        str2 = localStringBuilder.toString();
        paramIntent.insert(i, str2);
        paramIntent.setSpan(new RIJCommentAtSpan(str1, 0L, str2, -12541697), i, str2.length() + i, 33);
        i += str2.length();
      }
    }
    this.b.setText(paramIntent);
    this.b.setSelection(i);
  }
  
  public static boolean a()
  {
    boolean bool = ReadInJoyHelper.m();
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
  
  private static List<ResultRecord> b(Intent paramIntent)
  {
    ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("result_set");
    paramIntent = localArrayList;
    if (localArrayList == null) {
      paramIntent = Collections.emptyList();
    }
    return paramIntent;
  }
  
  private void b()
  {
    InputMethodUtil.b(this.b);
    Intent localIntent = new Intent();
    localIntent.putExtra("maxSelect", 1);
    PublicFragmentActivity.a(this.a, localIntent, ReadInJoySelectMemberFragment.class, 10000);
  }
  
  private SpannableStringBuilder c()
  {
    Editable localEditable = this.b.getEditableText();
    Object localObject = localEditable;
    if (localEditable == null) {
      localObject = "";
    }
    return new SpannableStringBuilder((CharSequence)localObject);
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
    b();
    paramView = this.c;
    if (paramView != null) {
      paramView.run();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 == 1) && (paramInt2 == 0) && ("@".equals(paramCharSequence.toString().substring(paramInt1, paramInt1 + 1)))) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.rptdata.at.RIJCommentAtUi
 * JD-Core Version:    0.7.0.1
 */