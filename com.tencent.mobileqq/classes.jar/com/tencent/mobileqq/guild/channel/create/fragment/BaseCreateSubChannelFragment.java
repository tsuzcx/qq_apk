package com.tencent.mobileqq.guild.channel.create.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public abstract class BaseCreateSubChannelFragment
  extends QPublicBaseFragment
{
  protected ViewGroup a;
  protected CreateSubChannelInfo b;
  public BaseDialogFragment c;
  
  public AppInterface a()
  {
    if ((getQBaseActivity().getAppRuntime() instanceof AppInterface)) {
      return (AppInterface)getQBaseActivity().getAppRuntime();
    }
    return null;
  }
  
  public void a(BaseDialogFragment paramBaseDialogFragment)
  {
    this.c = paramBaseDialogFragment;
  }
  
  protected abstract int b();
  
  protected abstract void c();
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle == null)
    {
      QLog.e("BaseCreateSubChannelFragment", 2, "onCreate error: bundle is null");
      return;
    }
    this.b = ((CreateSubChannelInfo)paramBundle.getParcelable("extra_key_subchannel_info"));
    if (QLog.isColorLevel())
    {
      paramBundle = this.b;
      if (paramBundle != null) {
        QLog.i("BaseCreateSubChannelFragment", 2, String.format("onCreate, guildId=%s, from=%s, categoryId=%s, channelType=%s", new Object[] { paramBundle.a, this.b.c, Long.valueOf(this.b.b), Integer.valueOf(this.b.d) }));
      }
    }
  }
  
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.a = ((ViewGroup)paramLayoutInflater.inflate(b(), paramViewGroup, false));
    if (QLog.isColorLevel()) {
      QLog.i("BaseCreateSubChannelFragment", 2, "onCreateView");
    }
    c();
    paramLayoutInflater = this.a;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.fragment.BaseCreateSubChannelFragment
 * JD-Core Version:    0.7.0.1
 */