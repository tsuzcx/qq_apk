package com.tencent.mobileqq.wink.editor.music;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.ViewPagerCompat;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel.EditMode;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.editor.music.adapter.MusicMenuPagerAdapter;
import com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment;
import com.tencent.mobileqq.wink.editor.music.fragments.MusicVolumeControlFragment;
import com.tencent.mobileqq.wink.editor.music.ui.MarqueeTextView;
import com.tencent.mobileqq.wink.editor.music.viewmodel.AbsWinkMusicPlayerViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicPlayerViewModelFactory;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel.VolumeType;
import com.tencent.mobileqq.wink.editor.music.vo.Scene;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateViewModel;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;

public class WinkEditorMusicMenuPart
  extends WinkEditorMenuPart
{
  private ViewPagerCompat g;
  private LinearLayout h;
  private TextView i;
  private TextView j;
  private MusicMenuPagerAdapter k;
  private boolean l;
  private AbsWinkMusicPlayerViewModel m;
  private MusicSourceViewModel n;
  private MusicVolumeControlViewModel o;
  private WinkEditorTemplateViewModel p;
  private boolean q = true;
  private TextView r;
  
  private void a(float paramFloat, MusicVolumeControlViewModel.VolumeType paramVolumeType)
  {
    this.o.a(paramFloat, paramVolumeType);
    MusicMenuPagerAdapter localMusicMenuPagerAdapter = this.k;
    if ((localMusicMenuPagerAdapter != null) && ((localMusicMenuPagerAdapter.getItem(1) instanceof MusicVolumeControlFragment))) {
      ((MusicVolumeControlFragment)this.k.getItem(1)).a(paramFloat, paramVolumeType);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void b(View paramView)
  {
    paramView = new MusicPlayerViewModelFactory((AudioManager)paramView.getContext().getSystemService("audio"), Scene.EDIT);
    FragmentActivity localFragmentActivity = j().getActivity();
    if (localFragmentActivity != null) {
      this.m = ((AbsWinkMusicPlayerViewModel)new ViewModelProvider(localFragmentActivity, paramView).get(AbsWinkMusicPlayerViewModel.class));
    }
  }
  
  private void d(View paramView)
  {
    this.g = ((ViewPagerCompat)paramView.findViewById(2131450000));
    this.g.setScrollable(false);
    this.h = ((LinearLayout)paramView.findViewById(2131442810));
    this.i = ((TextView)paramView.findViewById(2131450177));
    this.j = ((TextView)paramView.findViewById(2131450178));
    if (this.g != null)
    {
      if (j() == null) {
        return;
      }
      this.k = new MusicMenuPagerAdapter(j().getChildFragmentManager(), Scene.EDIT);
      if ((this.k.getItem(0) instanceof MusicSelectFragment))
      {
        ((MusicSelectFragment)this.k.getItem(0)).a(new WinkEditorMusicMenuPart.1(this));
        ((MusicSelectFragment)this.k.getItem(0)).a(new -..Lambda.WinkEditorMusicMenuPart.fuhJzZRobYcCgYM0d3f_gPwo0Ok(this));
      }
      this.g.setAdapter(this.k);
      this.i.setOnClickListener(new -..Lambda.WinkEditorMusicMenuPart.dLEJULUmcL3E7D1krjTiQTe3zXc(this));
      this.j.setOnClickListener(new -..Lambda.WinkEditorMusicMenuPart.-st3p0NMVXHh781pQBQcpZoPPMo(this));
    }
  }
  
  private void s()
  {
    this.p = ((WinkEditorTemplateViewModel)a(WinkEditorTemplateViewModel.class));
    this.p.b().observe(j(), new -..Lambda.WinkEditorMusicMenuPart.RSZ0g8e3gqSr4nIfgTPgdR52Z7o(this));
  }
  
  private void t()
  {
    MusicSourceViewModel localMusicSourceViewModel = this.n;
    if (localMusicSourceViewModel == null) {
      return;
    }
    localMusicSourceViewModel.p().observe(j(), new -..Lambda.WinkEditorMusicMenuPart.7VvIPIPaXCtj5i87xR_SYZEalbk(this));
    this.n.f().observe(j(), new -..Lambda.WinkEditorMusicMenuPart.paGsf8e1bQqhGyiduV5B-fkQIvI(this));
    this.n.d().observe(j(), new -..Lambda.WinkEditorMusicMenuPart.MfziyWxvH7aRk2XClaz955mMGZk(this));
  }
  
  private void u()
  {
    if (this.n != null) {
      this.c.i().observe(j(), new -..Lambda.WinkEditorMusicMenuPart.Taqg35W_hvcijvEoU7US4bbKn8U(this));
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject1 = this.n;
    if (localObject1 != null)
    {
      ((MusicSourceViewModel)localObject1).a(paramLong / 1000L);
      if ((c() != null) && (c().getIntent() != null) && (this.q))
      {
        this.q = false;
        localObject1 = c().getIntent();
        Object localObject2 = ((Intent)localObject1).getParcelableExtra("wink_music_info");
        if ((localObject2 instanceof WinkEditorMusicInfo))
        {
          localObject2 = (WinkEditorMusicInfo)localObject2;
          int i1 = ((Intent)localObject1).getIntExtra("music_start_time", ((WinkEditorMusicInfo)localObject2).g());
          this.n.a(((WinkEditorMusicInfo)localObject2).c(), i1, true);
          this.n.a(Integer.valueOf(i1));
          this.n.a((WinkEditorMusicInfo)localObject2, 1, false);
          float f = ((Intent)localObject1).getFloatExtra("music_volume", 0.5F);
          this.o.b(true);
          this.o.a(f, MusicVolumeControlViewModel.VolumeType.BGM);
          this.o.d(false);
          return;
        }
        if ((q() instanceof WinkVideoTavCut))
        {
          boolean bool = ((WinkVideoTavCut)q()).p();
          this.o.d(bool ^ true);
        }
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    FragmentActivity localFragmentActivity = j().getActivity();
    if (localFragmentActivity != null)
    {
      this.o = ((MusicVolumeControlViewModel)new ViewModelProvider(localFragmentActivity).get(MusicVolumeControlViewModel.class));
      this.n = ((MusicSourceViewModel)new ViewModelProvider(localFragmentActivity).get(MusicSourceViewModel.class));
    }
    VideoReport.setElementId(this.b, "em_xsj_music_button");
    VideoReport.setElementClickPolicy(this.b, ClickPolicy.REPORT_ALL);
    VideoReport.setElementExposePolicy(this.b, ExposurePolicy.REPORT_NONE);
    a("none", "none");
    this.b.setOnClickListener(new -..Lambda.WinkEditorMusicMenuPart.e9zGyB-cjk8Mi1ts-GRGjVxEV3s(this));
    this.b.setCloseButtonListener(new -..Lambda.WinkEditorMusicMenuPart.gMV4cE4SBYe0nfhMfdI2v1dbSKw(this));
    ((WinkEditorViewModel)a(WinkEditorViewModel.class)).c().observe(j(), new -..Lambda.WinkEditorMusicMenuPart.Ji7gVfvFYmx0x5hVTsC_6uLRNmA(this));
    s();
    this.r = ((TextView)paramView.findViewById(2131433321));
    t();
  }
  
  public void a(WinkEditorViewModel.EditMode paramEditMode)
  {
    this.n.a(paramEditMode);
    Object localObject = this.k;
    if (localObject != null)
    {
      localObject = ((MusicMenuPagerAdapter)localObject).getItem(0);
      if ((localObject instanceof MusicSelectFragment)) {
        ((MusicSelectFragment)localObject).b();
      }
    }
    if ((!this.l) && ((q() instanceof WinkVideoTavCut)))
    {
      this.l = true;
      this.p.d().observe(j(), new -..Lambda.WinkEditorMusicMenuPart.SCjPSvuXJ_dQuor8wUw3YaFJpsc(this));
    }
    super.a(paramEditMode);
  }
  
  protected void c(View paramView)
  {
    super.c(paramView);
    b(paramView);
    d(paramView);
    u();
  }
  
  public int d()
  {
    return 2131439027;
  }
  
  @NonNull
  public MenuType e()
  {
    return MenuType.MUSIC;
  }
  
  public void f()
  {
    super.f();
    Object localObject = this.m;
    if (localObject != null)
    {
      ((AbsWinkMusicPlayerViewModel)localObject).c();
      localObject = this.h.getLayoutParams();
      if (this.n.e() == WinkEditorViewModel.EditMode.Image)
      {
        this.j.setVisibility(8);
        this.i.setVisibility(8);
        ((ViewGroup.LayoutParams)localObject).height = ViewUtils.dpToPx(162.0F);
      }
      else
      {
        this.j.setVisibility(0);
        this.i.setVisibility(0);
        ((ViewGroup.LayoutParams)localObject).height = ViewUtils.dpToPx(208.0F);
      }
      this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.h.requestLayout();
    }
    localObject = this.i;
    if (localObject != null) {
      ((TextView)localObject).performClick();
    }
  }
  
  public void n()
  {
    super.n();
    AbsWinkMusicPlayerViewModel localAbsWinkMusicPlayerViewModel = this.m;
    if (localAbsWinkMusicPlayerViewModel != null) {
      localAbsWinkMusicPlayerViewModel.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.WinkEditorMusicMenuPart
 * JD-Core Version:    0.7.0.1
 */