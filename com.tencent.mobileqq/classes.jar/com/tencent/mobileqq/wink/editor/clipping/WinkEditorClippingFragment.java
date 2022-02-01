package com.tencent.mobileqq.wink.editor.clipping;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailProviderImpl;
import com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ReorderContainerView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ReorderListener;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.CommonConfig;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.LayoutConfig;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.ScrollConfig;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.TimeBarConfig;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.VideoTrackConfig;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragDropScrollView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragDropScrollViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanelViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.DragDropViewEmptyClickEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEventHandler;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEventObserver;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelScrollEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.SelectChangedEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.VideoScaleEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.VideoTrackClipClickEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.VideoTrackCutEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.VideoTrackEmptyClickEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar.TimeBarView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar.TimeBarViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackContainerView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackController;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.tavcut.TavCut;
import com.tencent.tavcut.render.player.IPlayer;
import com.tencent.tavcut.render.player.IPlayer.PlayerListener;
import com.tencent.tavcut.session.ICutSession;
import com.tencent.tavcut.session.ISessionListener;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.utils.DensityUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class WinkEditorClippingFragment
  extends BasePartFragment
  implements PanelEventObserver
{
  private final ISessionListener A = new WinkEditorClippingFragment.3(this);
  private boolean B = false;
  private final String a = getClass().getSimpleName();
  private final int b = 1;
  private ArrayList<MediaClip> c = new ArrayList();
  private Long d = Long.valueOf(0L);
  private Long e = Long.valueOf(200L);
  private TimelineViewModel f;
  private TimelinePanelViewController g;
  private VideoTrackController h;
  private DragDropScrollViewController i;
  private TimeBarViewController j;
  private ReorderContainerView k;
  private TimelinePanel l;
  private ImageView m;
  private ImageView n;
  private ImageView o;
  private FrameLayout p;
  private RelativeLayout q;
  private VideoSetSpeedDialog r;
  private RelativeLayout s;
  private ImageView t;
  private TextView u;
  private ImageView v;
  private TextView w;
  private TextView x;
  private final IPlayer.PlayerListener y = new WinkEditorClippingFragment.1(this);
  private final ReorderListener z = new WinkEditorClippingFragment.2(this);
  
  private void a(View paramView)
  {
    Object localObject = (FrameLayout)paramView.findViewById(2131433281);
    paramView = TavCut.a.b();
    paramView.a(TavCut.a.c(null));
    localObject = TavCut.a.a((FrameLayout)localObject);
    ((IPlayer)localObject).b(true);
    ((IPlayer)localObject).a(true);
    ((IPlayer)localObject).a(this.y);
    paramView.a((IPlayer)localObject);
    this.f.a(paramView, (IPlayer)localObject);
    this.f.i().a(this.A);
  }
  
  private void a(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.s;
    if (localRelativeLayout != null)
    {
      localRelativeLayout.setClickable(paramBoolean);
      if (paramBoolean)
      {
        this.t.setImageResource(2130848871);
        this.u.setTextColor(getResources().getColor(2131168464));
        return;
      }
      this.t.setImageResource(2130848872);
      this.u.setTextColor(getResources().getColor(2131168481));
    }
  }
  
  @RequiresApi(api=21)
  private void b(View paramView)
  {
    this.k = ((ReorderContainerView)paramView.findViewById(2131444627));
    this.l = ((TimelinePanel)paramView.findViewById(2131449845));
    this.p = ((FrameLayout)paramView.findViewById(2131433229));
    this.q = ((RelativeLayout)paramView.findViewById(2131450183));
    this.s = ((RelativeLayout)paramView.findViewById(2131450182));
    VideoReport.setElementId(this.s, "em_xsj_delete_button");
    VideoReport.setElementClickPolicy(this.s, ClickPolicy.REPORT_ALL);
    VideoReport.setElementExposePolicy(this.s, ExposurePolicy.REPORT_NONE);
    this.m = ((ImageView)paramView.findViewById(2131436163));
    this.n = ((ImageView)paramView.findViewById(2131436165));
    this.o = ((ImageView)paramView.findViewById(2131436168));
    this.x = ((TextView)paramView.findViewById(2131448805));
    this.t = ((ImageView)paramView.findViewById(2131436340));
    this.u = ((TextView)paramView.findViewById(2131448373));
    this.v = ((ImageView)paramView.findViewById(2131436583));
    this.w = ((TextView)paramView.findViewById(2131448758));
    i();
    k();
    m();
    l();
    n();
    o();
    u();
    w();
    x();
  }
  
  private void b(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.q;
    if (localRelativeLayout != null)
    {
      localRelativeLayout.setClickable(paramBoolean);
      if (paramBoolean)
      {
        this.v.setImageResource(2130848879);
        this.w.setTextColor(getResources().getColor(2131168464));
        return;
      }
      this.v.setImageResource(2130848878);
      this.w.setTextColor(getResources().getColor(2131168481));
    }
  }
  
  private void e()
  {
    if (this.f == null) {
      this.f = ((TimelineViewModel)new ViewModelProvider(this).get(TimelineViewModel.class));
    }
  }
  
  private void f()
  {
    Bundle localBundle = getArguments();
    if ((localBundle != null) && (localBundle.containsKey("CLIP_RESOURCE_MODEL")))
    {
      this.c = localBundle.getParcelableArrayList("CLIP_RESOURCE_MODEL");
      this.d = Long.valueOf(localBundle.getLong("CLIP_CURRENT_PLAY_TIME"));
    }
    this.f.a(this.c, this.d.longValue());
  }
  
  @RequiresApi(api=17)
  private void g()
  {
    this.f.c().observe(getViewLifecycleOwner(), new -..Lambda.WinkEditorClippingFragment.QJoLLyW7rVhC3fWsAhUOtHIHduU(this));
    this.f.b().observe(getViewLifecycleOwner(), new -..Lambda.WinkEditorClippingFragment.m3Ytqr84pOI9muV_gRpcjZKcu8s(this));
    this.f.d().observe(getViewLifecycleOwner(), new -..Lambda.WinkEditorClippingFragment.ROwHS6cPecGHdA9uRJenb52oNLM(this));
    this.f.e().observe(getViewLifecycleOwner(), new -..Lambda.WinkEditorClippingFragment.WoIChHavzTWfwML7VOc8kvAPtoU(this));
  }
  
  private void h()
  {
    this.g = new TimelinePanelViewController();
    this.j = new TimeBarViewController();
    this.h = new VideoTrackController(ThumbnailProviderImpl.a);
    this.i = new DragDropScrollViewController();
    this.g.a(this.j);
    this.g.a(this.h);
    this.g.a(this.i);
  }
  
  private void i()
  {
    ImageView localImageView = this.m;
    if (localImageView != null) {
      localImageView.setOnClickListener(new -..Lambda.WinkEditorClippingFragment.8JFaGNzSxNqDeJsQGbdLQdDYJJY(this));
    }
    localImageView = this.n;
    if (localImageView != null) {
      localImageView.setOnClickListener(new -..Lambda.WinkEditorClippingFragment.FfAW8dPQafjwx72VaTy6215tRI8(this));
    }
    localImageView = this.o;
    if (localImageView != null) {
      localImageView.setOnClickListener(new -..Lambda.WinkEditorClippingFragment.3PDNQRNdeq7ReS4l-O7AxNR_Vj8(this));
    }
  }
  
  @RequiresApi(api=21)
  private void k()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      ((TimelinePanelViewController)localObject).a(this.l);
      localObject = new CommonConfig(new ScrollConfig(), new LayoutConfig(), new VideoTrackConfig(), new TimeBarConfig());
      this.g.a((CommonConfig)localObject);
      this.g.f();
      this.g.i().a(this, -..Lambda.WinkEditorClippingFragment.tbp0PxwrCOkxEh2CsAibrJ58Gc8.INSTANCE);
    }
  }
  
  private void l()
  {
    TimeBarView localTimeBarView = new TimeBarView(getContext());
    Object localObject = new LinearLayout.LayoutParams(-1, DensityUtils.a.a(20.0F));
    ((LinearLayout.LayoutParams)localObject).topMargin = DensityUtils.a.a(12.0F);
    localTimeBarView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localTimeBarView.setMaxDurationLimit(180000000L);
    localObject = getActivity();
    if (localObject != null) {
      localTimeBarView.setMaxDurationLimitTip(((Context)localObject).getString(2131913988));
    }
    this.j.a(localTimeBarView);
  }
  
  @RequiresApi(api=19)
  private void m()
  {
    VideoTrackContainerView localVideoTrackContainerView = new VideoTrackContainerView(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, DensityUtils.a.a(56.0F));
    localLayoutParams.topMargin = DensityUtils.a.a(6.0F);
    localVideoTrackContainerView.setLayoutParams(localLayoutParams);
    this.h.a(localVideoTrackContainerView);
    localVideoTrackContainerView.setItemOnLongClickListener(new -..Lambda.WinkEditorClippingFragment.ZKdLcKlwx7vN7LHBCeDfkP543iA(this));
  }
  
  private void n()
  {
    DragDropScrollView localDragDropScrollView = new DragDropScrollView(getContext());
    localDragDropScrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.i.a(localDragDropScrollView);
  }
  
  private void o()
  {
    this.k.a(ThumbnailProviderImpl.a);
    this.k.setReorderListener(this.z);
  }
  
  private void u()
  {
    FrameLayout localFrameLayout = this.p;
    if (localFrameLayout != null) {
      localFrameLayout.setOnClickListener(new -..Lambda.WinkEditorClippingFragment.u5IHIjVQ7cr1_xC093cOpYhcdHg(this));
    }
  }
  
  private void w()
  {
    RelativeLayout localRelativeLayout = this.q;
    if (localRelativeLayout != null) {
      localRelativeLayout.setOnClickListener(new -..Lambda.WinkEditorClippingFragment._WeH1s5p1kFCYSDZc0b9xKxMXRQ(this));
    }
  }
  
  private void x()
  {
    RelativeLayout localRelativeLayout = this.s;
    if (localRelativeLayout != null) {
      localRelativeLayout.setOnClickListener(new -..Lambda.WinkEditorClippingFragment.w9CwoYwF_MkcNEJcoY6VYhydQNE(this));
    }
  }
  
  private void y()
  {
    if (this.r == null)
    {
      this.r = new VideoSetSpeedDialog(getActivity(), 2131952062);
      this.r.c(83);
      this.r.b((int)this.q.getX());
      this.r.a(DisplayUtil.a(getActivity(), 7.0F) + this.q.getHeight());
      this.r.a(new -..Lambda.WinkEditorClippingFragment.Cka9Jy62XH1UNJc9IvSQ-_K77Mk(this));
    }
    VideoSetSpeedDialog localVideoSetSpeedDialog = this.r;
    if ((localVideoSetSpeedDialog != null) && (!localVideoSetSpeedDialog.isShowing()))
    {
      if (this.f.m() != null) {
        this.r.a(this.f.m().floatValue());
      }
      this.r.show();
    }
  }
  
  private void z()
  {
    String str;
    if (this.D == null)
    {
      str = this.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportDaTongRegister mContentView == null , subPage: ");
      ((StringBuilder)localObject).append(b());
      QLog.i(str, 1, ((StringBuilder)localObject).toString());
      return;
    }
    VideoReport.addToDetectionWhitelist(getActivity());
    if (!TextUtils.isEmpty(a())) {
      str = a();
    } else {
      str = b();
    }
    VideoReport.setPageId(this.D, str);
    VideoReport.setPageParams(this.D, new WinkDTParamBuilder().buildPageParams(null));
    VideoReport.ignorePageInOutEvent(this.D, true);
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportDaTongRegister subPage: ");
    localStringBuilder.append(b());
    localStringBuilder.append(", pageId: ");
    localStringBuilder.append(str);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
  }
  
  public String a()
  {
    return "pg_xsj_edit_page";
  }
  
  public void a(Bundle paramBundle)
  {
    FragmentManager localFragmentManager = getFragmentManager();
    if (localFragmentManager != null)
    {
      Iterator localIterator = localFragmentManager.getFragments().iterator();
      while (localIterator.hasNext())
      {
        Fragment localFragment = (Fragment)localIterator.next();
        if ((localFragment instanceof WinkEditorFragment))
        {
          if (localFragment.getArguments() == null) {
            localFragment.setArguments(new Bundle());
          }
          localFragment.getArguments().putAll(paramBundle);
          localFragmentManager.beginTransaction().show(localFragment).hide(this).commit();
        }
      }
    }
  }
  
  public void a(@NotNull PanelEvent paramPanelEvent)
  {
    if ((paramPanelEvent instanceof PanelScrollEvent))
    {
      TimelineViewModel localTimelineViewModel = this.f;
      paramPanelEvent = (PanelScrollEvent)paramPanelEvent;
      localTimelineViewModel.a(paramPanelEvent.a(), paramPanelEvent.b());
      return;
    }
    if ((paramPanelEvent instanceof VideoTrackClipClickEvent))
    {
      this.f.a((VideoTrackClipClickEvent)paramPanelEvent);
      return;
    }
    if ((paramPanelEvent instanceof VideoTrackCutEvent))
    {
      this.f.a((VideoTrackCutEvent)paramPanelEvent);
      return;
    }
    if ((!(paramPanelEvent instanceof DragDropViewEmptyClickEvent)) && (!(paramPanelEvent instanceof VideoTrackEmptyClickEvent)) && (!(paramPanelEvent instanceof SelectChangedEvent)))
    {
      if ((paramPanelEvent instanceof VideoScaleEvent)) {
        this.f.a.b();
      }
    }
    else {
      this.f.k();
    }
  }
  
  public String b()
  {
    return this.a;
  }
  
  protected int c()
  {
    return 2131628239;
  }
  
  protected List<Part> d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new WinkEditorClippingMenuPart());
    return localArrayList;
  }
  
  protected int j()
  {
    return 0;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getParcelableArrayListExtra("localMediaInfos");
      this.f.b(paramIntent);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.f.s();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (!paramBoolean)
    {
      f();
      return;
    }
    this.f.a.b();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.f.a.c())
    {
      this.B = true;
      this.f.a.b();
      return;
    }
    this.B = false;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.B) {
      this.f.a.a();
    }
  }
  
  @RequiresApi(api=21)
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    z();
    e();
    a(paramView);
    f();
    h();
    b(paramView);
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingFragment
 * JD-Core Version:    0.7.0.1
 */