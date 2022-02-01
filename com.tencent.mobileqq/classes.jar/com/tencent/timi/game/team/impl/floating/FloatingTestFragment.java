package com.tencent.timi.game.team.impl.floating;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import org.jetbrains.annotations.NotNull;

public class FloatingTestFragment
  extends QPublicBaseFragment
{
  private WaveAvatarRoundView a;
  private TeamFloatingStateView b;
  
  private Button a()
  {
    Button localButton = new Button(getActivity());
    localButton.setText("展示头像");
    localButton.setGravity(17);
    localButton.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)UITools.a(getContext(), 50.0F)));
    localButton.setOnClickListener(new FloatingTestFragment.1(this));
    return localButton;
  }
  
  private Button b()
  {
    Button localButton = new Button(getActivity());
    localButton.setText("播放音浪动画");
    localButton.setGravity(17);
    localButton.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)UITools.a(getContext(), 50.0F)));
    localButton.setOnClickListener(new FloatingTestFragment.2(this));
    return localButton;
  }
  
  private Button c()
  {
    Button localButton = new Button(getActivity());
    localButton.setText("停止音浪动画");
    localButton.setGravity(17);
    localButton.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)UITools.a(getContext(), 50.0F)));
    localButton.setOnClickListener(new FloatingTestFragment.3(this));
    return localButton;
  }
  
  private Button d()
  {
    Button localButton = new Button(getActivity());
    localButton.setText("播放震动动画");
    localButton.setGravity(17);
    localButton.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)UITools.a(getContext(), 50.0F)));
    localButton.setOnClickListener(new FloatingTestFragment.4(this));
    return localButton;
  }
  
  private Button e()
  {
    Button localButton = new Button(getActivity());
    localButton.setText("播放切换状态动画");
    localButton.setGravity(17);
    localButton.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)UITools.a(getContext(), 50.0F)));
    localButton.setOnClickListener(new FloatingTestFragment.5(this));
    return localButton;
  }
  
  private Button f()
  {
    Button localButton = new Button(getActivity());
    localButton.setText("播放王者图标动画");
    localButton.setGravity(17);
    localButton.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)UITools.a(getContext(), 50.0F)));
    localButton.setOnClickListener(new FloatingTestFragment.6(this));
    return localButton;
  }
  
  private Button g()
  {
    Button localButton = new Button(getActivity());
    localButton.setText("停止王者图标动画");
    localButton.setGravity(17);
    localButton.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)UITools.a(getContext(), 50.0F)));
    localButton.setOnClickListener(new FloatingTestFragment.7(this));
    return localButton;
  }
  
  private Button h()
  {
    Button localButton = new Button(getActivity());
    localButton.setText("显示红点");
    localButton.setGravity(17);
    localButton.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)UITools.a(getContext(), 50.0F)));
    localButton.setOnClickListener(new FloatingTestFragment.8(this));
    return localButton;
  }
  
  private Button i()
  {
    Button localButton = new Button(getActivity());
    localButton.setText("隐藏红点");
    localButton.setGravity(17);
    localButton.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)UITools.a(getContext(), 50.0F)));
    localButton.setOnClickListener(new FloatingTestFragment.9(this));
    return localButton;
  }
  
  private Button j()
  {
    Button localButton = new Button(getActivity());
    localButton.setText("展示人数");
    localButton.setGravity(17);
    localButton.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)UITools.a(getContext(), 50.0F)));
    localButton.setOnClickListener(new FloatingTestFragment.10(this));
    return localButton;
  }
  
  private Button k()
  {
    Button localButton = new Button(getActivity());
    localButton.setText("隐藏人数");
    localButton.setGravity(17);
    localButton.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)UITools.a(getContext(), 50.0F)));
    localButton.setOnClickListener(new FloatingTestFragment.11(this));
    return localButton;
  }
  
  private Button l()
  {
    Button localButton = new Button(getActivity());
    localButton.setText("播放红包动画");
    localButton.setGravity(17);
    localButton.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)UITools.a(getContext(), 50.0F)));
    localButton.setOnClickListener(new FloatingTestFragment.12(this));
    return localButton;
  }
  
  private Button m()
  {
    Button localButton = new Button(getActivity());
    localButton.setText("暂停红包动画");
    localButton.setGravity(17);
    localButton.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)UITools.a(getContext(), 50.0F)));
    localButton.setOnClickListener(new FloatingTestFragment.13(this));
    return localButton;
  }
  
  public View onCreateView(@NonNull @NotNull LayoutInflater paramLayoutInflater, @androidx.annotation.Nullable @org.jetbrains.annotations.Nullable ViewGroup paramViewGroup, @androidx.annotation.Nullable @org.jetbrains.annotations.Nullable Bundle paramBundle)
  {
    paramLayoutInflater = new RelativeLayout(getContext());
    paramLayoutInflater.setPadding(0, (int)UITools.a(getContext(), 40.0F), 0, 0);
    paramLayoutInflater.setBackgroundColor(-1);
    paramViewGroup = new LinearLayout(getContext());
    paramViewGroup.setOrientation(1);
    paramViewGroup.addView(a());
    paramViewGroup.addView(b());
    paramViewGroup.addView(c());
    paramViewGroup.addView(d());
    paramViewGroup.addView(e());
    paramViewGroup.addView(f());
    paramViewGroup.addView(g());
    paramViewGroup.addView(h());
    paramViewGroup.addView(i());
    paramViewGroup.addView(j());
    paramViewGroup.addView(k());
    paramViewGroup.addView(l());
    paramViewGroup.addView(m());
    paramBundle = new TeamFloatingView(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.bottomMargin = ((int)UITools.a(getContext(), 74.0F));
    localLayoutParams.rightMargin = ((int)UITools.a(getContext(), 6.0F));
    paramBundle.setLayoutParams(localLayoutParams);
    paramLayoutInflater.addView(paramBundle);
    this.a = paramBundle.getAvatarView();
    this.b = paramBundle.getStateView();
    paramLayoutInflater.addView(paramViewGroup);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.floating.FloatingTestFragment
 * JD-Core Version:    0.7.0.1
 */