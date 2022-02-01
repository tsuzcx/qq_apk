package com.tencent.mobileqq.wink.editor.music.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.wink.editor.music.viewmodel.AbsWinkMusicPlayerViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel.VolumeType;
import com.tencent.mobileqq.wink.editor.music.vo.Scene;
import com.tencent.mobileqq.wink.view.StartPointSeekBar;
import com.tencent.mobileqq.wink.view.StartPointSeekBar.OnSeekBarChangeListener;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicVolumeControlFragment;", "Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicMenuBaseFragment;", "()V", "musicPlayViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/AbsWinkMusicPlayerViewModel;", "getMusicPlayViewModel", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/AbsWinkMusicPlayerViewModel;", "musicPlayViewModel$delegate", "Lkotlin/Lazy;", "musicSourceViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "getMusicSourceViewModel", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "musicSourceViewModel$delegate", "musicVolumeControlViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "getMusicVolumeControlViewModel", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "musicVolumeControlViewModel$delegate", "getScene", "Lcom/tencent/mobileqq/wink/editor/music/vo/Scene;", "initViewModel", "", "initViews", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setSliderProgress", "slider", "Lcom/tencent/mobileqq/wink/view/StartPointSeekBar;", "newProgress", "", "tip", "Landroid/widget/TextView;", "value", "", "sliderType", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;", "sliderToPlayerVolume", "sliderValue", "volumeToSliderValue", "volume", "turnEnable", "enabled", "", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MusicVolumeControlFragment
  extends MusicMenuBaseFragment
{
  public static final MusicVolumeControlFragment.Companion b = new MusicVolumeControlFragment.Companion(null);
  private static final String f = MusicVolumeControlFragment.class.getSimpleName();
  private final Lazy c = LazyKt.lazy((Function0)new MusicVolumeControlFragment.musicVolumeControlViewModel.2(this));
  private final Lazy d = LazyKt.lazy((Function0)new MusicVolumeControlFragment.musicPlayViewModel.2(this));
  private final Lazy e = LazyKt.lazy((Function0)new MusicVolumeControlFragment.musicSourceViewModel.2(this));
  private HashMap g;
  
  public MusicVolumeControlFragment()
  {
    super(2131628266);
  }
  
  private final float a(float paramFloat)
  {
    return paramFloat * 100.0F;
  }
  
  private final void a(StartPointSeekBar paramStartPointSeekBar, double paramDouble, TextView paramTextView)
  {
    paramStartPointSeekBar.setProgress(paramDouble);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((int)paramDouble);
    localStringBuilder.append('%');
    StartPointSeekBar.a(paramStartPointSeekBar, localStringBuilder.toString(), paramTextView);
  }
  
  private final void a(@NotNull StartPointSeekBar paramStartPointSeekBar, boolean paramBoolean)
  {
    paramStartPointSeekBar.setEnabled(paramBoolean);
    int i;
    if (paramBoolean) {
      i = 2130840085;
    } else {
      i = 2130840086;
    }
    paramStartPointSeekBar.setThumbDrawable(i);
    if (paramBoolean) {
      i = 2130848853;
    } else {
      i = 2130848852;
    }
    paramStartPointSeekBar.setBackgroundDrawable(i);
  }
  
  private final float b(float paramFloat)
  {
    return paramFloat / 100.0F;
  }
  
  private final MusicVolumeControlViewModel b()
  {
    return (MusicVolumeControlViewModel)this.c.getValue();
  }
  
  private final AbsWinkMusicPlayerViewModel c()
  {
    return (AbsWinkMusicPlayerViewModel)this.d.getValue();
  }
  
  private final MusicSourceViewModel d()
  {
    return (MusicSourceViewModel)this.e.getValue();
  }
  
  private final void e()
  {
    StartPointSeekBar localStartPointSeekBar = (StartPointSeekBar)a(2131446067);
    localStartPointSeekBar.setSectionEnable(false);
    localStartPointSeekBar.setAbsoluteMinMaxValue(0.0D, 100.0D);
    localStartPointSeekBar.setOnSeekBarChangeListener((StartPointSeekBar.OnSeekBarChangeListener)new MusicVolumeControlFragment.initViews..inlined.apply.lambda.1(this));
    Object localObject2 = (Float)b().b().getValue();
    Object localObject1 = Float.valueOf(0.0F);
    if (localObject2 == null) {
      localObject2 = localObject1;
    }
    double d1 = ((Float)localObject2).floatValue();
    Intrinsics.checkExpressionValueIsNotNull(localStartPointSeekBar, "this");
    localObject2 = (TextView)a(2131448233);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "tvOriginTip");
    a(localStartPointSeekBar, d1, (TextView)localObject2);
    localStartPointSeekBar = (StartPointSeekBar)a(2131446065);
    localStartPointSeekBar.setSectionEnable(false);
    localStartPointSeekBar.setAbsoluteMinMaxValue(0.0D, 100.0D);
    localStartPointSeekBar.setOnSeekBarChangeListener((StartPointSeekBar.OnSeekBarChangeListener)new MusicVolumeControlFragment.initViews..inlined.apply.lambda.2(this));
    localObject2 = (Float)b().d().getValue();
    if (localObject2 != null) {
      localObject1 = localObject2;
    }
    d1 = ((Float)localObject1).floatValue();
    Intrinsics.checkExpressionValueIsNotNull(localStartPointSeekBar, "this");
    localObject1 = (TextView)a(2131448230);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "tvMusicTip");
    a(localStartPointSeekBar, d1, (TextView)localObject1);
  }
  
  private final void f()
  {
    b().d().observe(getViewLifecycleOwner(), (Observer)new MusicVolumeControlFragment.initViewModel.1(this));
    d().p().observe(getViewLifecycleOwner(), (Observer)new MusicVolumeControlFragment.initViewModel.2(this));
    b().c().observe(getViewLifecycleOwner(), (Observer)new MusicVolumeControlFragment.initViewModel.3(this));
    b().a().observe(getViewLifecycleOwner(), (Observer)new MusicVolumeControlFragment.initViewModel.4(this));
  }
  
  private final Scene g()
  {
    Object localObject1 = getArguments();
    if (localObject1 != null) {
      localObject1 = ((Bundle)localObject1).get("scene");
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof Scene)) {
      localObject2 = null;
    }
    localObject1 = (Scene)localObject2;
    if (localObject1 != null) {
      return localObject1;
    }
    return Scene.EDIT;
  }
  
  public View a(int paramInt)
  {
    if (this.g == null) {
      this.g = new HashMap();
    }
    View localView2 = (View)this.g.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = getView();
      if (localView1 == null) {
        return null;
      }
      localView1 = localView1.findViewById(paramInt);
      this.g.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void a()
  {
    HashMap localHashMap = this.g;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public final void a(float paramFloat, @NotNull MusicVolumeControlViewModel.VolumeType paramVolumeType)
  {
    Intrinsics.checkParameterIsNotNull(paramVolumeType, "sliderType");
    int i = MusicVolumeControlFragment.WhenMappings.$EnumSwitchMapping$0[paramVolumeType.ordinal()];
    if (i != 1)
    {
      if ((i != 2) && (i != 3)) {
        return;
      }
      paramVolumeType = (StartPointSeekBar)a(2131446065);
      Intrinsics.checkExpressionValueIsNotNull(paramVolumeType, "sldMusic");
      d1 = paramFloat;
      d2 = 100;
      Double.isNaN(d1);
      Double.isNaN(d2);
      localTextView = (TextView)a(2131448230);
      Intrinsics.checkExpressionValueIsNotNull(localTextView, "tvMusicTip");
      a(paramVolumeType, d1 * d2, localTextView);
      return;
    }
    paramVolumeType = (StartPointSeekBar)a(2131446067);
    Intrinsics.checkExpressionValueIsNotNull(paramVolumeType, "sldOrigin");
    double d1 = paramFloat;
    double d2 = 100;
    Double.isNaN(d1);
    Double.isNaN(d2);
    TextView localTextView = (TextView)a(2131448233);
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "tvOriginTip");
    a(paramVolumeType, d1 * d2, localTextView);
  }
  
  public void onViewCreated(@NotNull View paramView, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    e();
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.fragments.MusicVolumeControlFragment
 * JD-Core Version:    0.7.0.1
 */