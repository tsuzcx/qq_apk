package com.tencent.mobileqq.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity.MaxBytesTextWatcher;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class UnitedVerifyMsgEditFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  BaseActivity a;
  int b = 100;
  EditText c;
  TextView d;
  AddFriendVerifyActivity.MaxBytesTextWatcher e;
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.b = getArguments().getInt("VERIFY_MSG_BYTES_LIMIT", 100);
    setTitle(getString(2131886219));
    setLeftButton(2131887648, null);
    setRightButton(2131887750, this);
    this.c = ((EditText)this.mContentView.findViewById(2131444679));
    this.d = ((TextView)this.mContentView.findViewById(2131444680));
    this.e = new AddFriendVerifyActivity.MaxBytesTextWatcher(this.b, this.c);
    this.c.addTextChangedListener(this.e);
    ThreadManager.post(new UnitedVerifyMsgEditFragment.1(this), 8, null, true);
  }
  
  protected int getContentLayoutId()
  {
    return 2131627934;
  }
  
  public boolean onBackEvent()
  {
    this.a.setResult(0);
    boolean bool = super.onBackEvent();
    this.a.overridePendingTransition(2130772007, 2130772018);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.rightViewText)
    {
      String str = this.c.getText().toString();
      Intent localIntent = new Intent();
      localIntent.putExtra("VERIFY_MSG", str);
      this.a.setResult(-1, localIntent);
      this.a.finish();
      this.a.overridePendingTransition(2130772007, 2130772018);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = getBaseActivity();
  }
  
  public void onDestroyView()
  {
    this.c.removeTextChangedListener(this.e);
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.UnitedVerifyMsgEditFragment
 * JD-Core Version:    0.7.0.1
 */