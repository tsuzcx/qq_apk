package com.tencent.timi.game.base;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.timi.game.base.ui.TimiGamePageLoadingView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/base/TimiGameBaseFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "()V", "mLoadingDelay", "", "mLoadingView", "Lcom/tencent/timi/game/base/ui/TimiGamePageLoadingView;", "mShowTask", "Ljava/lang/Runnable;", "finish", "", "exitSource", "", "getRootView", "Landroid/view/ViewGroup;", "hideLoadingView", "", "isLoadingShowing", "showLoadingView", "loadingTextResId", "loadingText", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract class TimiGameBaseFragment
  extends QPublicBaseFragment
{
  private TimiGamePageLoadingView a;
  private final long b = 500L;
  private Runnable c;
  private HashMap d;
  
  @Nullable
  public abstract ViewGroup a();
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "loadingText");
    int i;
    if (((CharSequence)paramString).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramString = getString(2131917232);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "getString(R.string.timi_game_loading_hint_default)");
    }
    Object localObject = getActivity();
    if (localObject != null) {
      localObject = ((FragmentActivity)localObject).getBaseContext();
    } else {
      localObject = null;
    }
    if ((this.a == null) && (localObject != null)) {
      this.a = new TimiGamePageLoadingView((Context)localObject, null, 0, 6, null);
    }
    localObject = new ViewGroup.LayoutParams(-1, -1);
    ViewGroup localViewGroup = a();
    if (localViewGroup != null) {
      localViewGroup.removeView((View)this.a);
    }
    localViewGroup = a();
    if (localViewGroup != null) {
      localViewGroup.addView((View)this.a, (ViewGroup.LayoutParams)localObject);
    }
    localObject = this.a;
    if (localObject != null) {
      ((TimiGamePageLoadingView)localObject).setHintText(paramString);
    }
    ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.c);
    this.c = ((Runnable)new TimiGameBaseFragment.showLoadingView.1(this));
    ThreadManagerV2.getUIHandlerV2().postDelayed(this.c, this.b);
  }
  
  public boolean a(int paramInt)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
    return true;
  }
  
  public void b(int paramInt)
  {
    String str = getString(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(str, "getString(loadingTextResId)");
    a(str);
  }
  
  public View c(int paramInt)
  {
    if (this.d == null) {
      this.d = new HashMap();
    }
    View localView2 = (View)this.d.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = getView();
      if (localView1 == null) {
        return null;
      }
      localView1 = localView1.findViewById(paramInt);
      this.d.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void d()
  {
    HashMap localHashMap = this.d;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public void dK_()
  {
    b(2131917232);
  }
  
  public void dL_()
  {
    ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.c);
    TimiGamePageLoadingView localTimiGamePageLoadingView = this.a;
    if (localTimiGamePageLoadingView != null) {
      localTimiGamePageLoadingView.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.base.TimiGameBaseFragment
 * JD-Core Version:    0.7.0.1
 */