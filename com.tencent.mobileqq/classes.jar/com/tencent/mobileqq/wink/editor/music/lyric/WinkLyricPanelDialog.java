package com.tencent.mobileqq.wink.editor.music.lyric;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.wink.editor.music.TimeUtils;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.WinkEditorPanelDialogDelegate;
import com.tencent.mobileqq.wink.editor.music.lyric.interaction.MoreLyricLayout;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.Map;

public class WinkLyricPanelDialog
  extends ReportDialog
  implements View.OnClickListener, WinkMusicWaveScrollProcessor.IMusicBarMoveListener, WinkMusicWaveView.IDragIndicatorListener
{
  private final WinkEditorPanelDialogDelegate a;
  private final FrameLayout b;
  private MoreLyricLayout c = null;
  private final TextView d;
  private final TextView e;
  private final WinkMusicWaveView f;
  private final RelativeLayout g;
  private final TextView h;
  private final TextView i;
  private final View j;
  private WinkLyricPanelDialog.WinkOperationCallback k;
  private int l;
  private int m;
  private int n;
  private int o;
  private boolean p = false;
  
  public WinkLyricPanelDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131951681);
    paramContext = LayoutInflater.from(paramContext).inflate(2131628243, null);
    this.b = ((FrameLayout)paramContext.findViewById(2131433296));
    this.c = ((MoreLyricLayout)paramContext.findViewById(2131438762));
    this.d = ((TextView)paramContext.findViewById(2131448761));
    this.e = ((TextView)paramContext.findViewById(2131448429));
    this.f = ((WinkMusicWaveView)paramContext.findViewById(2131427886));
    this.g = ((RelativeLayout)paramContext.findViewById(2131437792));
    this.h = ((TextView)paramContext.findViewById(2131448809));
    this.i = ((TextView)paramContext.findViewById(2131448709));
    this.c.setOnMoreLyricLayoutActionListener(new WinkLyricPanelDialog.1(this));
    this.c.setOnDragCallback(new WinkLyricPanelDialog.2(this));
    this.f.setDragIndicatorListener(this);
    this.j = paramContext.findViewById(2131436332);
    this.j.setOnClickListener(this);
    VideoReport.setElementId(this.j, "em_xsj_music_cut_finish");
    VideoReport.setElementClickPolicy(this.j, ClickPolicy.REPORT_ALL);
    paramContext.findViewById(2131436301).setOnClickListener(this);
    paramContext.findViewById(2131436458).setOnClickListener(this);
    paramContext.findViewById(2131436459).setOnClickListener(this);
    this.i.setOnClickListener(this);
    setContentView(paramContext);
    this.a = new WinkEditorPanelDialogDelegate(this, paramContext, new WinkLyricPanelDialog.3(this));
  }
  
  private void a(boolean paramBoolean)
  {
    if ((!d()) && (!paramBoolean))
    {
      this.h.setVisibility(8);
      this.i.setVisibility(0);
      return;
    }
    this.h.setVisibility(0);
    this.i.setVisibility(8);
  }
  
  private void c()
  {
    a(false);
  }
  
  private void c(int paramInt)
  {
    int i1 = this.o;
    b(paramInt);
    Object localObject = this.c;
    if (localObject != null) {
      ((MoreLyricLayout)localObject).setLyricSeek(paramInt);
    }
    this.m = paramInt;
    localObject = this.k;
    if (localObject != null)
    {
      ((WinkLyricPanelDialog.WinkOperationCallback)localObject).onMusicWaveMoving(paramInt, i1 + paramInt);
      c();
      this.k.onMusicWaveMoveEnd(true);
    }
  }
  
  private boolean d()
  {
    return this.m == this.l;
  }
  
  public void a()
  {
    WinkLyricPanelDialog.WinkOperationCallback localWinkOperationCallback = this.k;
    if (localWinkOperationCallback != null) {
      localWinkOperationCallback.onMusicWaveMoveStart();
    }
  }
  
  public void a(int paramInt)
  {
    WinkMusicWaveView localWinkMusicWaveView = this.f;
    if (localWinkMusicWaveView != null)
    {
      WinkLyricPanelDialog.WinkOperationCallback localWinkOperationCallback = this.k;
      if (localWinkOperationCallback != null) {
        localWinkOperationCallback.onIndicatorDragged(localWinkMusicWaveView.a(this.o));
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.p = true;
    this.m = paramInt1;
    WinkLyricPanelDialog.WinkOperationCallback localWinkOperationCallback = this.k;
    if (localWinkOperationCallback != null) {
      localWinkOperationCallback.onMusicWaveMoving(paramInt1, paramInt2);
    }
  }
  
  public void a(@Nullable WinkLyricPanelDialog.WinkOperationCallback paramWinkOperationCallback)
  {
    this.k = paramWinkOperationCallback;
  }
  
  public void a(@NonNull WinkEditorMusicInfo paramWinkEditorMusicInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    this.l = paramWinkEditorMusicInfo.g();
    this.n = paramWinkEditorMusicInfo.h();
    this.o = paramInt2;
    this.m = paramInt1;
    WinkLyricProgressCalculator.a().b(paramInt1, Math.min(paramInt1 + paramInt2, this.n));
    Object localObject = this.f;
    if (localObject != null)
    {
      ((WinkMusicWaveView)localObject).a(paramWinkEditorMusicInfo.c(), WinkEditorMusicHelper.a(paramWinkEditorMusicInfo), paramWinkEditorMusicInfo.h(), paramInt2, false, paramInt3, paramInt4, true, paramBoolean);
      this.f.setOnMusicMoveListener(this);
      b(paramInt1);
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((MoreLyricLayout)localObject).setVisibility(0);
      this.c.a(paramWinkEditorMusicInfo, paramInt1, true, false);
    }
    paramWinkEditorMusicInfo = this.b;
    if (paramWinkEditorMusicInfo != null) {
      paramWinkEditorMusicInfo.setAlpha(1.0F);
    }
    c();
  }
  
  public void b()
  {
    if (this.k != null)
    {
      c();
      this.k.onMusicWaveMoveEnd(this.p);
    }
    this.p = false;
  }
  
  public void b(int paramInt)
  {
    WinkMusicWaveView localWinkMusicWaveView = this.f;
    if (localWinkMusicWaveView != null) {
      localWinkMusicWaveView.b(paramInt);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject = this.f;
    if ((localObject != null) && (!((WinkMusicWaveView)localObject).f()))
    {
      this.f.setIndicatorIndexByVideo(paramInt1, paramInt2);
      this.f.setCurrentPosition(paramInt1, paramInt2);
    }
    localObject = this.c;
    if (localObject != null) {
      ((MoreLyricLayout)localObject).a((int)WinkLyricProgressCalculator.a().a(false));
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    TextView localTextView = this.d;
    if (localTextView != null) {
      localTextView.setText(TimeUtils.a(TimeUtils.a, paramInt1));
    }
    localTextView = this.e;
    if (localTextView != null) {
      localTextView.setText(TimeUtils.a(TimeUtils.a, Math.min(paramInt2, this.n)));
    }
  }
  
  public void dismiss()
  {
    this.a.c();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    Object localObject;
    if ((i1 != 2131436301) && (i1 != 2131436458))
    {
      if ((i1 != 2131436332) && (i1 != 2131436459))
      {
        if ((i1 == 2131448709) && (!d()))
        {
          localObject = this.k;
          if (localObject != null)
          {
            ((WinkLyricPanelDialog.WinkOperationCallback)localObject).onResetMusicRangeToRecommend(this.l);
            a(true);
          }
        }
      }
      else
      {
        localObject = this.k;
        if (localObject != null) {
          ((WinkLyricPanelDialog.WinkOperationCallback)localObject).onClickConfirmBtn();
        }
        localObject = WinkDTParamBuilder.buildElementParams();
        ((Map)localObject).put("xsj_music_id", WinkDatongCurrentParams.get("xsj_music_id"));
        ((Map)localObject).put("xsj_music_name", WinkDatongCurrentParams.get("xsj_music_name"));
        VideoReport.reportEvent("dt_clck", this.j, (Map)localObject);
        dismiss();
      }
    }
    else
    {
      localObject = this.k;
      if (localObject != null) {
        ((WinkLyricPanelDialog.WinkOperationCallback)localObject).onClickCancelBtn();
      }
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a.a();
  }
  
  public void show()
  {
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.WinkLyricPanelDialog
 * JD-Core Version:    0.7.0.1
 */