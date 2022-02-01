package com.tencent.mobileqq.wink.editor.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel.EditMode;
import com.tencent.mobileqq.wink.editor.WinkMaterialViewModel;
import com.tencent.mobileqq.wink.editor.WinkMaterialViewModelFactory;
import com.tencent.mobileqq.wink.editor.WinkTavCutDelegate;
import com.tencent.mobileqq.wink.editor.music.ui.MarqueeTextView;
import java.util.HashMap;

public abstract class WinkEditorMenuPart
  extends Part
{
  protected String a = getClass().getSimpleName();
  protected MarqueeTextView b;
  protected WinkEditorViewModel c;
  protected Animation d;
  protected Animation e;
  protected boolean f;
  private View g;
  private ViewStub h;
  private boolean i;
  private View.OnClickListener j;
  private WinkMaterialViewModel k;
  
  public static HashMap<String, String> a(Activity paramActivity)
  {
    if ((paramActivity != null) && (paramActivity.getIntent() != null))
    {
      HashMap localHashMap = (HashMap)paramActivity.getIntent().getSerializableExtra("key_attrs");
      if ((localHashMap != null) && (!localHashMap.isEmpty()))
      {
        paramActivity.getIntent().removeExtra("key_attrs");
        return localHashMap;
      }
    }
    return new HashMap();
  }
  
  private void s()
  {
    this.d = AnimationUtils.loadAnimation(g(), 2130772482);
    this.e = AnimationUtils.loadAnimation(g(), 2130772481);
    this.e.setAnimationListener(new WinkEditorMenuPart.1(this));
  }
  
  private View.OnClickListener t()
  {
    if (this.j == null) {
      this.j = new -..Lambda.WinkEditorMenuPart.sVJkbwYWQQF6_9GzR-AFSbLUDFk(this);
    }
    return this.j;
  }
  
  public View F()
  {
    return this.g;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.g = paramView.findViewById(d());
    View localView = this.g;
    if ((localView instanceof ViewStub)) {
      this.h = ((ViewStub)localView);
    } else {
      this.i = true;
    }
    this.c = ((WinkEditorViewModel)a(WinkEditorViewModel.class));
    this.c.c().observe(j(), new -..Lambda.WinkEditorMenuPart.n2iWg_DlFy7WktC5Oydupe2KM7Q(this));
    s();
    this.b = ((MarqueeTextView)paramView.findViewById(2131439026));
  }
  
  public void a(WinkEditorViewModel.EditMode paramEditMode)
  {
    if (!this.i) {
      return;
    }
    if (paramEditMode == WinkEditorViewModel.EditMode.Image)
    {
      F().setOnClickListener(t());
      return;
    }
    F().setOnClickListener(null);
    F().setFocusable(false);
    F().setClickable(false);
  }
  
  protected void c(View paramView)
  {
    super.c(paramView);
    a(this.c.n());
  }
  
  @IdRes
  public abstract int d();
  
  @NonNull
  public abstract MenuType e();
  
  protected void f()
  {
    if (this.f) {
      return;
    }
    if (F() == null) {
      return;
    }
    if (!this.i)
    {
      ViewStub localViewStub = this.h;
      if (localViewStub != null)
      {
        this.i = true;
        this.g = localViewStub.inflate();
        c(this.g);
      }
    }
    this.f = true;
    F().setVisibility(0);
    m();
  }
  
  public void i()
  {
    this.c.a(e());
  }
  
  public void l()
  {
    this.c.p();
  }
  
  protected void m()
  {
    F().startAnimation(this.d);
  }
  
  protected void n()
  {
    if (!this.f) {
      return;
    }
    if (F() == null) {
      return;
    }
    this.f = false;
    o();
  }
  
  protected void o()
  {
    F().startAnimation(this.e);
  }
  
  protected WinkMaterialViewModel p()
  {
    if (this.k == null)
    {
      Bundle localBundle = j().getArguments();
      boolean bool = true;
      if (localBundle != null) {
        bool = localBundle.getBoolean("IS_IMAGE_MODEL");
      }
      this.k = ((WinkMaterialViewModel)new ViewModelProvider(j(), new WinkMaterialViewModelFactory(5, bool)).get(WinkMaterialViewModel.class));
    }
    return this.k;
  }
  
  @Nullable
  protected WinkTavCutDelegate q()
  {
    if ((j() instanceof WinkEditorFragment)) {
      return ((WinkEditorFragment)j()).h();
    }
    return null;
  }
  
  protected WinkEditorFragment r()
  {
    return (WinkEditorFragment)j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
 * JD-Core Version:    0.7.0.1
 */