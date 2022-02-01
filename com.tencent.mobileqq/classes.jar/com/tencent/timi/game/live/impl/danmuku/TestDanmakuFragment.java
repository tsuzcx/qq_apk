package com.tencent.timi.game.live.impl.danmuku;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/impl/danmuku/TestDanmakuFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "()V", "rootView", "Landroid/view/View;", "generateTestData", "", "Lcom/tencent/timi/game/live/impl/danmuku/DanmakuDataBean;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onStart", "onStop", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TestDanmakuFragment
  extends QPublicBaseFragment
{
  private View a;
  private HashMap b;
  
  public void a()
  {
    HashMap localHashMap = this.b;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  @Nullable
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    this.a = paramLayoutInflater.inflate(2131629502, paramViewGroup, false);
    paramLayoutInflater = this.a;
    if (paramLayoutInflater != null) {
      paramLayoutInflater.setBackgroundColor(-16777216);
    }
    paramLayoutInflater = this.a;
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater = (EsportsDanmakuView)paramLayoutInflater.findViewById(2131431569);
      if (paramLayoutInflater != null) {
        paramLayoutInflater.e();
      }
    }
    paramLayoutInflater = this.a;
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater = (Button)paramLayoutInflater.findViewById(2131445570);
      if (paramLayoutInflater != null) {
        paramLayoutInflater.setOnClickListener((View.OnClickListener)new TestDanmakuFragment.onCreateView.1(this));
      }
    }
    paramLayoutInflater = this.a;
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater = (Button)paramLayoutInflater.findViewById(2131430751);
      if (paramLayoutInflater != null) {
        paramLayoutInflater.setOnClickListener((View.OnClickListener)new TestDanmakuFragment.onCreateView.2(this));
      }
    }
    paramLayoutInflater = this.a;
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater = (Button)paramLayoutInflater.findViewById(2131444508);
      if (paramLayoutInflater != null) {
        paramLayoutInflater.setOnClickListener((View.OnClickListener)new TestDanmakuFragment.onCreateView.3(this));
      }
    }
    paramLayoutInflater = this.a;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (EsportsDanmakuView)((View)localObject).findViewById(2131431569);
      if (localObject != null) {
        ((EsportsDanmakuView)localObject).b();
      }
    }
    a();
  }
  
  public void onStart()
  {
    super.onStart();
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (EsportsDanmakuView)((View)localObject).findViewById(2131431569);
      if (localObject != null) {
        ((EsportsDanmakuView)localObject).c();
      }
    }
  }
  
  public void onStop()
  {
    super.onStop();
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (EsportsDanmakuView)((View)localObject).findViewById(2131431569);
      if (localObject != null) {
        ((EsportsDanmakuView)localObject).d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.TestDanmakuFragment
 * JD-Core Version:    0.7.0.1
 */