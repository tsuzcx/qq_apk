package com.tencent.mobileqq.guild.mainframe.container.empty;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public class GuildEmptyFragment
  extends QPublicBaseFragment
{
  private ViewGroup a;
  
  public static GuildEmptyFragment a(Intent paramIntent)
  {
    GuildEmptyFragment localGuildEmptyFragment = new GuildEmptyFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("data", paramIntent);
    localGuildEmptyFragment.setArguments(localBundle);
    return localGuildEmptyFragment;
  }
  
  public void a()
  {
    ViewGroup localViewGroup = this.a;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(0);
    }
  }
  
  public void b()
  {
    ViewGroup localViewGroup = this.a;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(8);
    }
  }
  
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.a = ((ViewGroup)paramLayoutInflater.inflate(2131625080, paramViewGroup, false));
    paramLayoutInflater = this.a;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.empty.GuildEmptyFragment
 * JD-Core Version:    0.7.0.1
 */