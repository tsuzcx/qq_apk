package com.tencent.timi.game.room.impl.test;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public class TimiRoomTestFragment
  extends QPublicBaseFragment
{
  private View a;
  
  public static void a(Context paramContext)
  {
    QPublicFragmentActivity.Launcher.a(paramContext, QPublicFragmentActivity.class, TimiRoomTestFragment.class);
  }
  
  private void a(View paramView)
  {
    paramView.findViewById(2131445130).setOnClickListener(new TimiRoomTestFragment.1(this));
    EditText localEditText = (EditText)paramView.findViewById(2131445133);
    paramView.findViewById(2131445132).setOnClickListener(new TimiRoomTestFragment.2(this, localEditText));
    paramView.findViewById(2131445131).setOnClickListener(new TimiRoomTestFragment.3(this));
    paramView.findViewById(2131445135).setOnClickListener(new TimiRoomTestFragment.4(this));
    paramView.findViewById(2131445136).setOnClickListener(new TimiRoomTestFragment.5(this));
    paramView.findViewById(2131445129).setOnClickListener(new TimiRoomTestFragment.6(this));
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.a = paramLayoutInflater.inflate(2131629476, paramViewGroup, false);
    a(this.a);
    paramLayoutInflater = this.a;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.test.TimiRoomTestFragment
 * JD-Core Version:    0.7.0.1
 */