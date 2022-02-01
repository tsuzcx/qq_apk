package com.tencent.mobileqq.wink.editor.music.lyric.interaction;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.wink.editor.music.lyric.LyricParserHelper;
import com.tencent.mobileqq.wink.editor.music.lyric.data.Lyric;
import com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewController;
import com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewSingleLine;
import com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricWithBuoyView;
import com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricWithBuoyView.OnLyricWithBuoyViewOperationListener;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;

public class MoreLyricLayout
  extends LinearLayout
  implements IMoreLyricLayout, WinkSlidingUpPanelLayout.PanelSlideListener, LyricWithBuoyView.OnLyricWithBuoyViewOperationListener
{
  private ImageView a = null;
  private LyricViewSingleLine b = null;
  private LyricViewController c = null;
  private MoreLyricLayout.LyricScrollListener d = new MoreLyricLayout.LyricScrollListener(this, null);
  private LyricWithBuoyView e = null;
  private WinkSlidingUpPanelLayout f;
  private long g;
  private boolean h = false;
  private IMoreLyricLayout.OnMoreLyricLayoutActionListener i;
  private IMoreLyricLayout.OnViewActionReportListener j;
  private IMoreLyricLayout.OnLayoutVisibleChangeListener k;
  private LinearLayout l = null;
  private RelativeLayout m = null;
  private MoreLyricLayout.LyricBackgroundEffect n = null;
  private MoreLyricLayout.OnDragCallback o = null;
  private int p = 0;
  
  public MoreLyricLayout(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public MoreLyricLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }
  
  public MoreLyricLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }
  
  private void b()
  {
    IMoreLyricLayout.OnViewActionReportListener localOnViewActionReportListener = this.j;
    if (localOnViewActionReportListener != null) {
      localOnViewActionReportListener.a();
    }
  }
  
  private void b(int paramInt)
  {
    IMoreLyricLayout.OnMoreLyricLayoutActionListener localOnMoreLyricLayoutActionListener = this.i;
    if (localOnMoreLyricLayoutActionListener == null)
    {
      AEQLog.a("MoreLyricLayout", "notifyLyricSelection() mOnMoreLyricLayoutActionListener == null.");
      return;
    }
    localOnMoreLyricLayoutActionListener.a(paramInt);
  }
  
  private void b(boolean paramBoolean)
  {
    IMoreLyricLayout.OnViewActionReportListener localOnViewActionReportListener = this.j;
    if (localOnViewActionReportListener != null) {
      localOnViewActionReportListener.a(paramBoolean);
    }
  }
  
  private void c()
  {
    IMoreLyricLayout.OnViewActionReportListener localOnViewActionReportListener = this.j;
    if (localOnViewActionReportListener != null) {
      localOnViewActionReportListener.c();
    }
  }
  
  private void c(boolean paramBoolean)
  {
    IMoreLyricLayout.OnLayoutVisibleChangeListener localOnLayoutVisibleChangeListener = this.k;
    if (localOnLayoutVisibleChangeListener != null) {
      localOnLayoutVisibleChangeListener.a(paramBoolean);
    }
  }
  
  private void d()
  {
    IMoreLyricLayout.OnViewActionReportListener localOnViewActionReportListener = this.j;
    if (localOnViewActionReportListener != null) {
      localOnViewActionReportListener.b();
    }
  }
  
  private void d(boolean paramBoolean)
  {
    Object localObject = this.m;
    if (localObject == null)
    {
      AEQLog.a("MoreLyricLayout", "changeDragStyle() mLyricViewSingleLine == null.");
    }
    else
    {
      int i2 = 8;
      if (paramBoolean) {
        i1 = 8;
      } else {
        i1 = 0;
      }
      ((RelativeLayout)localObject).setVisibility(i1);
      localObject = this.e;
      if (paramBoolean) {
        i1 = 4;
      } else {
        i1 = 0;
      }
      ((LyricWithBuoyView)localObject).setVisibility(i1);
      localObject = this.b;
      int i1 = i2;
      if (paramBoolean) {
        i1 = 0;
      }
      ((LyricViewSingleLine)localObject).setVisibility(i1);
      localObject = this.a;
      if (paramBoolean) {
        i1 = 2130848849;
      } else {
        i1 = 2130848848;
      }
      ((ImageView)localObject).setImageResource(i1);
    }
    localObject = this.o;
    if (localObject != null) {
      ((MoreLyricLayout.OnDragCallback)localObject).a(paramBoolean);
    }
  }
  
  private void e()
  {
    LayoutInflater.from(getContext()).inflate(2131628250, this, true);
    this.a = ((ImageView)findViewById(2131439033));
    this.b = ((LyricViewSingleLine)findViewById(2131439035));
    this.c = new LyricViewController(this.b);
    this.e = ((LyricWithBuoyView)findViewById(2131439034));
    LyricWithBuoyView localLyricWithBuoyView = this.e;
    if (localLyricWithBuoyView != null) {
      localLyricWithBuoyView.a(this.d);
    }
    this.f = ((WinkSlidingUpPanelLayout)findViewById(2131438873));
    this.f.a(this);
    this.f.setFadeOnClickListener(new MoreLyricLayout.1(this));
    this.l = ((LinearLayout)findViewById(2131439031));
    this.m = ((RelativeLayout)findViewById(2131438872));
    VideoReport.setElementId(this.f, "em_xsj_song_panel");
    a(true);
  }
  
  private void f()
  {
    WinkSlidingUpPanelLayout localWinkSlidingUpPanelLayout = this.f;
    if (localWinkSlidingUpPanelLayout == null) {
      AEQLog.a("MoreLyricLayout", "resetSlidingCollapsedState() mSlidingUpPanelLayout == null.");
    } else {
      localWinkSlidingUpPanelLayout.setPanelState(WinkSlidingUpPanelLayout.PanelState.COLLAPSED);
    }
    g();
  }
  
  private void g()
  {
    LyricWithBuoyView localLyricWithBuoyView = this.e;
    if (localLyricWithBuoyView == null)
    {
      AEQLog.a("MoreLyricLayout", "resetSlidingCollapsedState() mLyricWithBuoyView == null.");
      return;
    }
    localLyricWithBuoyView.a();
  }
  
  public void a()
  {
    b((int)this.g);
  }
  
  public void a(int paramInt)
  {
    if (this.p == paramInt) {
      return;
    }
    this.p = paramInt;
    Object localObject = this.c;
    if (localObject != null) {
      ((LyricViewController)localObject).a(paramInt);
    }
    localObject = this.e;
    if (localObject != null) {
      ((LyricWithBuoyView)localObject).b(paramInt);
    }
  }
  
  public void a(View paramView, float paramFloat)
  {
    paramView = this.n;
    if (paramView != null) {
      paramView.a(paramFloat);
    }
  }
  
  public void a(View paramView, WinkSlidingUpPanelLayout.PanelState paramPanelState1, WinkSlidingUpPanelLayout.PanelState paramPanelState2)
  {
    paramView = new StringBuilder();
    paramView.append("onPanelStateChanged() newState => ");
    paramView.append(paramPanelState2);
    AEQLog.a("MoreLyricLayout", paramView.toString());
    if (paramPanelState2 == WinkSlidingUpPanelLayout.PanelState.DRAGGING)
    {
      d(false);
      d();
      return;
    }
    if (paramPanelState2 == WinkSlidingUpPanelLayout.PanelState.COLLAPSED)
    {
      d(true);
      g();
      b(false);
      return;
    }
    if (paramPanelState2 == WinkSlidingUpPanelLayout.PanelState.ANCHORED)
    {
      f();
      return;
    }
    paramView = WinkDTParamBuilder.buildElementParams();
    paramView.put("xsj_music_id", WinkDatongCurrentParams.get("xsj_music_id"));
    paramView.put("xsj_music_name", WinkDatongCurrentParams.get("xsj_music_name"));
    VideoReport.reportEvent("ev_xsj_camera_action", this.f, paramView);
    d(false);
    b(true);
  }
  
  public void a(WinkEditorMusicInfo paramWinkEditorMusicInfo, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramWinkEditorMusicInfo == null)
    {
      AEQLog.c("MoreLyricLayout", "initLyricView() mData == null.");
      return;
    }
    f();
    Object localObject2 = paramWinkEditorMusicInfo.j();
    String str = paramWinkEditorMusicInfo.k();
    this.h = false;
    Object localObject1;
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(((String)localObject2).trim())))
    {
      localObject1 = localObject2;
      if (!((String)localObject2).equals("[00:00:00]该音乐暂无歌词")) {}
    }
    else
    {
      str = "LRC";
      localObject1 = "[00:00:00]该音乐暂无歌词";
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str)))
    {
      paramWinkEditorMusicInfo = this.c;
      if (paramWinkEditorMusicInfo != null) {
        paramWinkEditorMusicInfo.a();
      }
      LyricViewController localLyricViewController;
      if (TextUtils.equals(str.toUpperCase(), "LRC"))
      {
        localObject2 = LyricParserHelper.a((String)localObject1, false);
        localLyricViewController = this.c;
        paramWinkEditorMusicInfo = (WinkEditorMusicInfo)localObject2;
        if (localLyricViewController != null)
        {
          localLyricViewController.a(null, (Lyric)localObject2, null);
          paramWinkEditorMusicInfo = (WinkEditorMusicInfo)localObject2;
        }
      }
      else if (TextUtils.equals(str.toUpperCase(), "QRC"))
      {
        localObject2 = LyricParserHelper.a((String)localObject1, true);
        localLyricViewController = this.c;
        paramWinkEditorMusicInfo = (WinkEditorMusicInfo)localObject2;
        if (localLyricViewController != null)
        {
          localLyricViewController.a((Lyric)localObject2, null, null);
          paramWinkEditorMusicInfo = (WinkEditorMusicInfo)localObject2;
        }
      }
      else
      {
        paramWinkEditorMusicInfo = null;
      }
      if (paramWinkEditorMusicInfo != null)
      {
        paramWinkEditorMusicInfo = new StringBuilder();
        paramWinkEditorMusicInfo.append("initLyricView() startTime => ");
        paramWinkEditorMusicInfo.append(paramInt);
        paramWinkEditorMusicInfo.append(",lyricFormat:");
        paramWinkEditorMusicInfo.append(str);
        AEQLog.a("MoreLyricLayout", paramWinkEditorMusicInfo.toString());
        paramWinkEditorMusicInfo = this.c;
        if (paramWinkEditorMusicInfo != null)
        {
          paramWinkEditorMusicInfo.a(false);
          this.c.a(paramInt, true);
          this.c.a(null);
        }
        this.h = true;
        a(paramBoolean1 ^ true);
        paramWinkEditorMusicInfo = this.e;
        if (paramWinkEditorMusicInfo != null)
        {
          paramWinkEditorMusicInfo.a((String)localObject1, str, paramInt, null);
          this.e.setOnLyricWithBuoyViewOperationListener(this);
        }
        if (paramBoolean1) {
          b();
        }
      }
      else
      {
        a(true);
      }
      return;
    }
    AEQLog.a("MoreLyricLayout", "initLyricView() lyric info is empty.");
    a(true);
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hideLyricLayout() hide > ");
    localStringBuilder.append(paramBoolean);
    AEQLog.a("MoreLyricLayout", localStringBuilder.toString());
    boolean bool = false;
    int i1;
    if (paramBoolean) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    setVisibility(i1);
    f();
    paramBoolean = bool;
    if (getVisibility() == 0) {
      paramBoolean = true;
    }
    c(paramBoolean);
  }
  
  public void setLyricBackgroundEffect(MoreLyricLayout.LyricBackgroundEffect paramLyricBackgroundEffect)
  {
    this.n = paramLyricBackgroundEffect;
  }
  
  public void setLyricSeek(int paramInt)
  {
    if (!this.h)
    {
      AEQLog.c("MoreLyricLayout", "setLyricSeek() current not lyric.");
      return;
    }
    Object localObject = this.c;
    if (localObject == null) {
      AEQLog.c("MoreLyricLayout", "setLyricSeek() mLyricViewController == null.");
    } else {
      ((LyricViewController)localObject).a(paramInt, false);
    }
    localObject = this.e;
    if (localObject == null)
    {
      AEQLog.c("MoreLyricLayout", "setLyricSeek() mLyricWithBuoyView == null.");
      return;
    }
    ((LyricWithBuoyView)localObject).setSelectedFlag(paramInt, false);
    localObject = this.e.getMusicCurrentTime();
    if (localObject != null) {
      ((TextView)localObject).setText(LyricWithBuoyView.a(paramInt));
    }
  }
  
  public void setMoreBackground(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      AEQLog.c("MoreLyricLayout", "setMoreBackground() drawable == null.");
      return;
    }
    LinearLayout localLinearLayout = this.l;
    if (localLinearLayout == null)
    {
      AEQLog.c("MoreLyricLayout", "setMoreBackground() mMusicBarLyricDragView == null.");
      return;
    }
    localLinearLayout.setBackgroundDrawable(paramDrawable);
  }
  
  public void setOnDragCallback(MoreLyricLayout.OnDragCallback paramOnDragCallback)
  {
    this.o = paramOnDragCallback;
  }
  
  public void setOnMoreLyricLayoutActionListener(IMoreLyricLayout.OnMoreLyricLayoutActionListener paramOnMoreLyricLayoutActionListener)
  {
    this.i = paramOnMoreLyricLayoutActionListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.interaction.MoreLyricLayout
 * JD-Core Version:    0.7.0.1
 */