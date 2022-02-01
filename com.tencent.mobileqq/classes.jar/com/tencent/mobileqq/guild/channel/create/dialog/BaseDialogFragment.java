package com.tencent.mobileqq.guild.channel.create.dialog;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.audio.data.AudioRoomLiveData;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.util.QQGuildDisplayHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.WeakReferenceHandler;

public abstract class BaseDialogFragment
  extends BottomSheetDialogFragment
  implements DialogInterface.OnKeyListener, Handler.Callback
{
  protected View a;
  public Boolean b = Boolean.valueOf(true);
  public BaseDialogFragment c;
  public BaseDialogFragment d;
  protected CreateSubChannelInfo e;
  protected BottomSheetBehavior f;
  private View g;
  private BaseDialogFragment.ICallback h;
  private final WeakReferenceHandler i = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private Observer j = new BaseDialogFragment.1(this);
  
  private void a(boolean paramBoolean)
  {
    int m = this.g.getMeasuredHeight();
    int k;
    if (paramBoolean) {
      k = QQGuildDisplayHelper.b(QBaseActivity.sTopActivity);
    } else {
      k = h();
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { m, k });
    localValueAnimator.addUpdateListener(new BaseDialogFragment.4(this));
    if (paramBoolean) {
      localValueAnimator.setStartDelay(h() * 400 / QQGuildDisplayHelper.b(QBaseActivity.sTopActivity));
    }
    localValueAnimator.setDuration(400L);
    localValueAnimator.start();
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseDialogFragment", 2, "reopen");
    }
    a(false);
  }
  
  private int h()
  {
    int k = QQGuildDisplayHelper.a(QBaseActivity.sTopActivity);
    k = (int)(QQGuildDisplayHelper.b(QBaseActivity.sTopActivity) * 0.213823F - k);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("backgroundHeight: ");
      localStringBuilder.append(k);
      QLog.i("BaseDialogFragment", 2, localStringBuilder.toString());
    }
    return k;
  }
  
  protected abstract Fragment a(CreateSubChannelInfo paramCreateSubChannelInfo);
  
  public void a()
  {
    a(true);
  }
  
  public void a(BaseDialogFragment.ICallback paramICallback)
  {
    this.h = paramICallback;
  }
  
  public void a(BaseDialogFragment paramBaseDialogFragment)
  {
    this.c = paramBaseDialogFragment;
  }
  
  public void b()
  {
    int k = h() * 400 / QQGuildDisplayHelper.b(QBaseActivity.sTopActivity);
    this.i.sendEmptyMessageDelayed(1, k);
  }
  
  public void b(BaseDialogFragment paramBaseDialogFragment)
  {
    this.d = paramBaseDialogFragment;
  }
  
  public void c()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("closeAndBackLastPage : ");
      ((StringBuilder)localObject).append(this);
      QLog.i("BaseDialogFragment", 2, ((StringBuilder)localObject).toString());
    }
    dismiss();
    Object localObject = this.c;
    if (localObject != null)
    {
      ((BaseDialogFragment)localObject).b = Boolean.valueOf(true);
      this.c.g();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseDialogFragment", 2, "closeAllDialog");
    }
    dismiss();
    BaseDialogFragment localBaseDialogFragment = this.c;
    if (localBaseDialogFragment != null) {
      localBaseDialogFragment.d();
    }
    localBaseDialogFragment = this.d;
    if (localBaseDialogFragment != null) {
      localBaseDialogFragment.dismiss();
    }
  }
  
  protected void e()
  {
    this.g = this.a.findViewById(2131430777);
    ViewGroup.LayoutParams localLayoutParams = this.g.getLayoutParams();
    localLayoutParams.height = h();
    this.g.setLayoutParams(localLayoutParams);
    this.g.setOnClickListener(new BaseDialogFragment.3(this));
    getChildFragmentManager().beginTransaction().replace(2131431895, a(this.e)).commit();
  }
  
  protected boolean f()
  {
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      dismiss();
    }
    return false;
  }
  
  public void onCreate(@androidx.annotation.Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null) {
      this.e = ((CreateSubChannelInfo)paramBundle.getParcelable("extra_key_subchannel_info"));
    }
    if (QLog.isColorLevel())
    {
      paramBundle = this.e;
      if (paramBundle != null) {
        QLog.i("BaseDialogFragment", 2, String.format("onCreate, guildId=%s, from=%s, categoryId=%s, channelType=%s", new Object[] { paramBundle.a, this.e.c, Long.valueOf(this.e.b), Integer.valueOf(this.e.d) }));
      }
    }
  }
  
  public Dialog onCreateDialog(@android.support.annotation.Nullable Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseDialogFragment", 2, "onCreateDialog");
    }
    super.onCreate(paramBundle);
    paramBundle = (BottomSheetDialog)super.onCreateDialog(paramBundle);
    paramBundle.getWindow().getAttributes().windowAnimations = 2131952042;
    if (f()) {
      paramBundle.getWindow().clearFlags(2);
    }
    return paramBundle;
  }
  
  @androidx.annotation.Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @androidx.annotation.Nullable ViewGroup paramViewGroup, @androidx.annotation.Nullable Bundle paramBundle)
  {
    this.a = paramLayoutInflater.inflate(2131624984, paramViewGroup, false);
    e();
    AudioRoomLiveData.a.a().observe(getViewLifecycleOwner(), this.j);
    AudioRoomLiveData.a.c().postValue(Boolean.valueOf(true));
    paramLayoutInflater = this.a;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseDialogFragment", 2, "onDismiss");
    }
    this.b = Boolean.valueOf(true);
    AudioRoomLiveData.a.a().removeObserver(this.j);
    AudioRoomLiveData.a.c().postValue(Boolean.valueOf(false));
    super.onDismiss(paramDialogInterface);
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (QLog.isColorLevel())
    {
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append("onKey: keyCode=");
      paramDialogInterface.append(paramInt);
      QLog.i("BaseDialogFragment", 2, paramDialogInterface.toString());
    }
    if (paramInt == 4)
    {
      c();
      return true;
    }
    return false;
  }
  
  public void onStart()
  {
    super.onStart();
    ((View)this.a.getParent()).setBackgroundColor(0);
    BottomSheetDialog localBottomSheetDialog = (BottomSheetDialog)getDialog();
    localBottomSheetDialog.setOnKeyListener(this);
    this.f = localBottomSheetDialog.a();
    this.f.d(3);
    this.f.a(0);
    this.f.b(new BaseDialogFragment.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment
 * JD-Core Version:    0.7.0.1
 */