package com.tencent.mobileqq.wink.editor.text;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.wink.editor.MetaMaterialKt;
import com.tencent.mobileqq.wink.editor.WinkMaterialViewModel;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;
import com.tencent.mobileqq.wink.utils.TAVFontManager;
import com.tencent.mobileqq.wink.utils.TAVPAGFileManager;
import com.tencent.videocut.utils.KeyboardStateHelper;
import com.tencent.videocut.utils.KeyboardStateHelper.KeyboardStateListener;
import com.tencent.videocut.utils.KeyboardUtils;
import org.libpag.PAGFile;
import org.libpag.PAGFont;
import org.libpag.PAGText;
import org.libpag.PAGView;

public class WinkEditorTextMenuPart
  extends WinkEditorMenuPart
{
  private WinkEditorTextViewModel A;
  private ApplyMaterialTask B;
  private String g;
  private View h;
  private PAGView i;
  private FrameLayout j;
  private View k;
  private EditText l;
  private LinearLayout m;
  private TextView n;
  private TextView o;
  private TextView p;
  private TextView q;
  private RecyclerView r;
  private Animation s;
  private Animation t;
  private int u;
  private KeyboardStateHelper v;
  private KeyboardStateHelper.KeyboardStateListener w;
  private TextFancyMaterialPanelContentAdapter x;
  private Drawable y;
  private Drawable z;
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramTextView.setTypeface(Typeface.defaultFromStyle(1));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, this.y);
      return;
    }
    paramTextView.setTypeface(Typeface.defaultFromStyle(0));
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, this.z);
  }
  
  private void a(MetaMaterial paramMetaMaterial)
  {
    if (!this.f) {
      i();
    }
    PAGFile localPAGFile = TAVPAGFileManager.a().a(TextMetaMaterialKt.n(paramMetaMaterial));
    if (localPAGFile == null) {
      return;
    }
    PAGText localPAGText = localPAGFile.getTextData(0);
    if (localPAGText == null) {
      return;
    }
    localPAGText.text = TextMetaMaterialKt.k(paramMetaMaterial);
    localPAGText.fillColor = TextMetaMaterialKt.l(paramMetaMaterial);
    localPAGText.justification = TextMetaMaterialKt.j(paramMetaMaterial);
    Object localObject = TextMetaMaterialKt.g(paramMetaMaterial);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = TAVFontManager.a().a((String)localObject);
      if (localObject != null)
      {
        localPAGText.fontStyle = ((PAGFont)localObject).fontStyle;
        localPAGText.fontFamily = ((PAGFont)localObject).fontFamily;
      }
    }
    localPAGFile.replaceText(0, localPAGText);
    if ("CATEGORY_TEXT_DECOR".equals(MetaMaterialKt.d(paramMetaMaterial)))
    {
      this.i.setScaleX(0.8F);
      this.i.setScaleY(0.8F);
    }
    else
    {
      this.i.setScaleX(1.0F);
      this.i.setScaleY(1.0F);
    }
    this.i.setComposition(localPAGFile);
    if ((!TextMetaMaterialKt.k(paramMetaMaterial).equals(this.l.getText().toString())) && (!TextMetaMaterialKt.k(paramMetaMaterial).equals(WinkEditorTextViewModel.a))) {
      this.l.setText(TextMetaMaterialKt.k(paramMetaMaterial));
    }
  }
  
  private void a(String paramString)
  {
    boolean bool = this.v.b();
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 910730760: 
      if (paramString.equals("CATEGORY_KEYBOARD")) {
        i1 = 0;
      }
      break;
    case 793913343: 
      if (paramString.equals("CATEGORY_TEXT_PATTERN")) {
        i1 = 2;
      }
      break;
    case -907563552: 
      if (paramString.equals("CATEGORY_TEXT_STYLE")) {
        i1 = 1;
      }
      break;
    case -921884268: 
      if (paramString.equals("CATEGORY_TEXT_DECOR")) {
        i1 = 3;
      }
      break;
    }
    int i1 = -1;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return;
          }
          b(false);
          if (!bool)
          {
            c(false);
            a(this.p, false);
            a(this.q, true);
            this.r.setVisibility(0);
          }
        }
        else
        {
          b(false);
          if (!bool)
          {
            c(false);
            a(this.p, true);
            a(this.q, false);
            this.r.setVisibility(0);
          }
        }
      }
      else
      {
        b(false);
        if (!bool)
        {
          c(true);
          a(this.p, false);
          a(this.q, false);
          this.r.setVisibility(8);
        }
      }
    }
    else
    {
      b(true);
      c(false);
      a(this.p, false);
      a(this.q, false);
      this.r.setVisibility(8);
    }
  }
  
  private void b(View paramView)
  {
    this.h = paramView.findViewById(2131437978);
    this.h.setOnClickListener(new -..Lambda.WinkEditorTextMenuPart.PsHaSg96-Ef37dGICHFaNmAOVBE(this));
    this.i = ((PAGView)paramView.findViewById(2131447078));
    this.i.play();
    this.i.setRepeatCount(0);
    this.A.f().observe(j(), new -..Lambda.WinkEditorTextMenuPart.PdszvRsKscFM-DwmSAZhL3kKhSc(this));
  }
  
  private void b(boolean paramBoolean)
  {
    a(this.n, paramBoolean);
    if (paramBoolean)
    {
      this.k.setVisibility(0);
      KeyboardUtils.a.a(this.l);
      return;
    }
    this.k.setVisibility(4);
    KeyboardUtils.a.b(this.l);
  }
  
  private void c(boolean paramBoolean) {}
  
  private void d(View paramView)
  {
    this.m = ((LinearLayout)paramView.findViewById(2131438101));
    this.n = ((TextView)paramView.findViewById(2131436786));
    this.o = ((TextView)paramView.findViewById(2131447086));
    this.o.setVisibility(8);
    this.p = ((TextView)paramView.findViewById(2131447079));
    this.q = ((TextView)paramView.findViewById(2131447071));
    -..Lambda.WinkEditorTextMenuPart._AyLg2U2WMNO1k4l_JKkX4B6Ukw local_AyLg2U2WMNO1k4l_JKkX4B6Ukw = new -..Lambda.WinkEditorTextMenuPart._AyLg2U2WMNO1k4l_JKkX4B6Ukw(this);
    this.n.setOnClickListener(local_AyLg2U2WMNO1k4l_JKkX4B6Ukw);
    this.p.setOnClickListener(local_AyLg2U2WMNO1k4l_JKkX4B6Ukw);
    this.q.setOnClickListener(local_AyLg2U2WMNO1k4l_JKkX4B6Ukw);
    paramView.findViewById(2131430278).setOnClickListener(new -..Lambda.WinkEditorTextMenuPart.kdNoNBmOSwHYAWpkhxzMl-RkHDc(this));
    paramView.findViewById(2131431221).setOnClickListener(new -..Lambda.WinkEditorTextMenuPart.HlmjXPRcGXrajfq2nFShfvT7e2Q(this));
  }
  
  private void d(boolean paramBoolean)
  {
    KeyboardUtils.a.b(this.l);
    this.A.a(paramBoolean);
    l();
    this.l.setText("");
  }
  
  private void e(View paramView)
  {
    this.k = paramView.findViewById(2131447068);
    this.l = ((EditText)paramView.findViewById(2131447074));
    this.w = new WinkEditorTextMenuPart.1(this);
    this.v = new KeyboardStateHelper(j().getView());
    this.v.a(this.w);
    this.l.addTextChangedListener(new WinkEditorTextMenuPart.2(this));
  }
  
  private void f(View paramView)
  {
    this.r = ((RecyclerView)paramView.findViewById(2131431335));
    paramView = new GridLayoutManager(g(), 4);
    this.r.setLayoutManager(paramView);
    this.x = new TextFancyMaterialPanelContentAdapter(g());
    this.x.a(t());
    this.r.setAdapter(this.x);
    this.A.e().observe(j(), new -..Lambda.WinkEditorTextMenuPart.yp36JuA7lbAOOijj1NBjDiTJkdo(this));
    this.A.g().observe(j(), new -..Lambda.WinkEditorTextMenuPart.v2eiGvTkxALRSo4I5plC9wu5GbU(this));
  }
  
  private void s()
  {
    this.A = ((WinkEditorTextViewModel)a(WinkEditorTextViewModel.class));
    this.A.h().observe(j(), new -..Lambda.WinkEditorTextMenuPart.CzgjyAkxXgdYO6xg97QDlX3ZbSg(this));
    this.A.i().observe(j(), new -..Lambda.WinkEditorTextMenuPart.u1aYnIT1yhSvjE3tmYYZKcCpBBU(this));
    p().getTextMaterialVOLiveData().observe(j(), new -..Lambda.WinkEditorTextMenuPart.TKPHQFwhTgqwRDg0zNarOTzb33M(this));
    this.A.d().observe(j(), new -..Lambda.WinkEditorTextMenuPart.4jba3XThwyIf3XiFQ3HPDO8p_JQ(this));
  }
  
  private ApplyMaterialTask t()
  {
    if (this.B == null) {
      this.B = new WinkEditorTextMenuPart.3(this);
    }
    return this.B;
  }
  
  protected void c(View paramView)
  {
    super.c(paramView);
    this.g = g().getResources().getString(2131891506);
    this.u = DisplayUtil.a(g(), 2.0F);
    this.y = ContextCompat.getDrawable(g(), 2130848741);
    this.z = ContextCompat.getDrawable(g(), 2130848742);
    this.j = ((FrameLayout)paramView.findViewById(2131431328));
    this.s = AnimationUtils.loadAnimation(g(), 2130772090);
    this.t = AnimationUtils.loadAnimation(g(), 2130772092);
    s();
    e(paramView);
    b(paramView);
    d(paramView);
    f(paramView);
  }
  
  public int d()
  {
    return 2131447076;
  }
  
  @NonNull
  public MenuType e()
  {
    return MenuType.TEXT;
  }
  
  public void f()
  {
    super.f();
    this.A.b();
  }
  
  protected void m()
  {
    if (!"CATEGORY_KEYBOARD".equals(this.A.c()))
    {
      this.i.startAnimation(this.s);
      this.h.startAnimation(this.s);
      this.m.startAnimation(this.d);
    }
  }
  
  protected void o()
  {
    if (!"CATEGORY_KEYBOARD".equals(this.A.c()))
    {
      this.i.startAnimation(this.t);
      this.h.startAnimation(this.t);
      this.m.startAnimation(this.e);
      return;
    }
    F().setVisibility(4);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    this.v.b(this.w);
    this.v.a();
    this.v = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.text.WinkEditorTextMenuPart
 * JD-Core Version:    0.7.0.1
 */