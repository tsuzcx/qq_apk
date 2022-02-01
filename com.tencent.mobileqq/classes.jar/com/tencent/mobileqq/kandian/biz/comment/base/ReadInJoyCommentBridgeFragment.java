package com.tencent.mobileqq.kandian.biz.comment.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.comment.publisher.qq.QQPublishCommentFragment;
import org.jetbrains.annotations.NotNull;

public class ReadInJoyCommentBridgeFragment
  extends PublicBaseFragment
{
  private ReadInJoyCommentComponentFragment a;
  private ReadInJoyCommentEntrance b;
  private Boolean c;
  
  private boolean a()
  {
    if (this.c == null)
    {
      if ((Build.VERSION.SDK_INT != 21) && (Build.VERSION.SDK_INT != 22)) {
        this.c = Boolean.valueOf(ReadInJoyHelper.o());
      } else {
        this.c = Boolean.valueOf(ReadInJoyHelper.p());
      }
      b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isUseCommentModule: useCommentModule=");
      localStringBuilder.append(this.c);
      QLog.d("ReadInJoyCommentBridgeFragment", 1, localStringBuilder.toString());
    }
    return this.c.booleanValue();
  }
  
  private boolean a(FragmentManager paramFragmentManager)
  {
    Fragment localFragment = paramFragmentManager.findFragmentByTag("ReadInJoyCommentComponentFragment");
    if (localFragment != null)
    {
      if ((localFragment instanceof ReadInJoyCommentComponentFragment))
      {
        this.a = ((ReadInJoyCommentComponentFragment)localFragment);
        return true;
      }
      paramFragmentManager.beginTransaction().remove(localFragment).commitAllowingStateLoss();
    }
    return false;
  }
  
  private void b()
  {
    Bundle localBundle = getArguments();
    if ((localBundle != null) && (localBundle.getInt("comment_editor_scene", 0) != 0)) {
      this.c = Boolean.valueOf(true);
    }
  }
  
  private void c()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    this.b = new ReadInJoyCommentEntrance(localQBaseActivity, localQBaseActivity.getIntent());
    this.b.b();
  }
  
  private void d()
  {
    if (a()) {
      return;
    }
    e();
    if (this.a.isAdded()) {
      return;
    }
    Object localObject = getQBaseActivity();
    if (localObject != null)
    {
      localObject = ((QBaseActivity)localObject).getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject).add(2131433667, this.a, "ReadInJoyCommentComponentFragment");
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
    }
  }
  
  private void e()
  {
    if (this.a != null) {
      return;
    }
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if ((localQBaseActivity != null) && (a(localQBaseActivity.getSupportFragmentManager()))) {
      return;
    }
    this.a = new ReadInJoyCommentComponentFragment();
    this.a.setArguments(getArguments());
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    d();
    ReadInJoyCommentComponentFragment localReadInJoyCommentComponentFragment = this.a;
    if (localReadInJoyCommentComponentFragment != null) {
      localReadInJoyCommentComponentFragment.initWindowStyleAndAnimation(paramActivity);
    }
  }
  
  public boolean isWrapContent()
  {
    d();
    ReadInJoyCommentComponentFragment localReadInJoyCommentComponentFragment = this.a;
    if (localReadInJoyCommentComponentFragment != null) {
      return localReadInJoyCommentComponentFragment.isWrapContent();
    }
    return false;
  }
  
  public boolean needImmersive()
  {
    d();
    ReadInJoyCommentComponentFragment localReadInJoyCommentComponentFragment = this.a;
    if (localReadInJoyCommentComponentFragment != null) {
      return localReadInJoyCommentComponentFragment.needImmersive();
    }
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @androidx.annotation.Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = this.a;
    if (localObject != null) {
      ((ReadInJoyCommentComponentFragment)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    localObject = this.b;
    if (localObject != null) {
      ((ReadInJoyCommentEntrance)localObject).a().onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    ReadInJoyCommentComponentFragment localReadInJoyCommentComponentFragment = this.a;
    if (localReadInJoyCommentComponentFragment != null) {
      return localReadInJoyCommentComponentFragment.onBackEvent();
    }
    return super.onBackEvent();
  }
  
  @org.jetbrains.annotations.Nullable
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (a()) {
      c();
    } else {
      d();
    }
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ReadInJoyCommentEntrance.g();
  }
  
  public void onFinish()
  {
    ReadInJoyCommentComponentFragment localReadInJoyCommentComponentFragment = this.a;
    if (localReadInJoyCommentComponentFragment != null) {
      localReadInJoyCommentComponentFragment.onFinish();
    }
  }
  
  public void onPause()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (localFragmentActivity.isFinishing())) {
      ReadInJoyCommentEntrance.f();
    }
    super.onPause();
    ReadInJoyCommentEntrance.e();
  }
  
  public void onResume()
  {
    super.onResume();
    ReadInJoyCommentEntrance.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.ReadInJoyCommentBridgeFragment
 * JD-Core Version:    0.7.0.1
 */