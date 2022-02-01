package com.tencent.mobileqq.wink.editor.music;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.editor.music.lyric.WinkLyricPanelDialog;
import com.tencent.mobileqq.wink.editor.music.lyric.WinkLyricPanelDialog.WinkOperationCallback;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/music/WinkEditorMusicControlPanel;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lyricPanelDialog", "Lcom/tencent/mobileqq/wink/editor/music/lyric/WinkLyricPanelDialog;", "musicPanel", "Lcom/tencent/mobileqq/wink/editor/music/WinkEditorMusicPanel;", "musicWaveViewHeight", "musicWaveViewWidth", "clearMusicListViewCache", "", "hide", "hideMusicListPanel", "hideMusicLyricPanel", "onBgmVolumeChanged", "volume", "", "onCurrentMusicDownloadFailed", "onReceiveMusicFromWeb", "musicInfoFromWeb", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "scrollToMusicListPosition", "position", "setClipEntranceVisible", "visible", "", "setEnableMusic", "enable", "setMusicDisableEnable", "setMusicListOperationCallback", "callback", "Lcom/tencent/mobileqq/wink/editor/music/WinkEditorMusicPanel$OperationCallback;", "setMusicLyricOperationCallback", "Lcom/tencent/mobileqq/wink/editor/music/lyric/WinkLyricPanelDialog$WinkOperationCallback;", "showMusicListPanel", "showMusicLyricPanel", "editorMusicInfo", "savedMusicStartTimeInMs", "videoClipDurationInMs", "", "forceRefreshWaveView", "(Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;Ljava/lang/Integer;JZ)V", "updateBackgroundMusicData", "musicInfoList", "", "updateMusicLyricProgress", "videoClipProgressInMs", "updateMusicLyricRangeText", "startTimeInMs", "endTimeInMs", "updateMusicLyricTrimBoxPosition", "musicProgressInMs", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class WinkEditorMusicControlPanel
  extends FrameLayout
{
  private WinkEditorMusicPanel a;
  private WinkLyricPanelDialog b;
  private int c = ViewUtils.getScreenWidth();
  private int d;
  
  public WinkEditorMusicControlPanel(@NotNull Context paramContext)
  {
    super(paramContext);
    paramContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context");
    this.d = paramContext.getResources().getDimensionPixelSize(2131300051);
    this.a = new WinkEditorMusicPanel(getContext());
    addView((View)this.a, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.b = new WinkLyricPanelDialog(getContext());
  }
  
  public WinkEditorMusicControlPanel(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context");
    this.d = paramContext.getResources().getDimensionPixelSize(2131300051);
    this.a = new WinkEditorMusicPanel(getContext());
    addView((View)this.a, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.b = new WinkLyricPanelDialog(getContext());
  }
  
  public WinkEditorMusicControlPanel(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context");
    this.d = paramContext.getResources().getDimensionPixelSize(2131300051);
    this.a = new WinkEditorMusicPanel(getContext());
    addView((View)this.a, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.b = new WinkLyricPanelDialog(getContext());
  }
  
  public final void a(int paramInt)
  {
    WinkEditorMusicPanel localWinkEditorMusicPanel = this.a;
    if (localWinkEditorMusicPanel != null) {
      localWinkEditorMusicPanel.a(paramInt);
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    WinkLyricPanelDialog localWinkLyricPanelDialog = this.b;
    if (localWinkLyricPanelDialog != null) {
      localWinkLyricPanelDialog.c(paramInt1, paramInt2);
    }
  }
  
  public final void a(@NotNull WinkEditorMusicInfo paramWinkEditorMusicInfo, @Nullable Integer paramInteger, long paramLong, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramWinkEditorMusicInfo, "editorMusicInfo");
    WinkLyricPanelDialog localWinkLyricPanelDialog = this.b;
    if ((localWinkLyricPanelDialog != null) && (!localWinkLyricPanelDialog.isShowing()))
    {
      int i;
      if (paramInteger != null) {
        i = paramInteger.intValue();
      } else {
        i = paramWinkEditorMusicInfo.g();
      }
      paramInteger = this.b;
      if (paramInteger != null) {
        paramInteger.a(paramWinkEditorMusicInfo, i, (int)paramLong, this.c, this.d, paramBoolean);
      }
      a(i, (int)(i + paramLong));
      paramWinkEditorMusicInfo = this.b;
      if (paramWinkEditorMusicInfo != null) {
        paramWinkEditorMusicInfo.show();
      }
    }
  }
  
  public final void a(@NotNull List<? extends WinkEditorMusicInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "musicInfoList");
    WinkEditorMusicPanel localWinkEditorMusicPanel = this.a;
    if (localWinkEditorMusicPanel != null) {
      localWinkEditorMusicPanel.a(paramList);
    }
  }
  
  public final void b(int paramInt)
  {
    WinkLyricPanelDialog localWinkLyricPanelDialog = this.b;
    if ((localWinkLyricPanelDialog != null) && (localWinkLyricPanelDialog.isShowing() == true))
    {
      localWinkLyricPanelDialog = this.b;
      if (localWinkLyricPanelDialog != null) {
        localWinkLyricPanelDialog.b(paramInt);
      }
    }
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    WinkLyricPanelDialog localWinkLyricPanelDialog = this.b;
    if ((localWinkLyricPanelDialog != null) && (localWinkLyricPanelDialog.isShowing() == true))
    {
      localWinkLyricPanelDialog = this.b;
      if (localWinkLyricPanelDialog != null) {
        localWinkLyricPanelDialog.b(paramInt1, paramInt2);
      }
    }
  }
  
  public final void setClipEntranceVisible(boolean paramBoolean)
  {
    WinkEditorMusicPanel localWinkEditorMusicPanel = this.a;
    if (localWinkEditorMusicPanel != null) {
      localWinkEditorMusicPanel.setClipEntranceVisible(paramBoolean);
    }
  }
  
  public final void setEnableMusic(boolean paramBoolean)
  {
    WinkEditorMusicPanel localWinkEditorMusicPanel = this.a;
    if (localWinkEditorMusicPanel != null) {
      localWinkEditorMusicPanel.setEnableBgm(paramBoolean);
    }
  }
  
  public final void setMusicDisableEnable(boolean paramBoolean)
  {
    WinkEditorMusicPanel localWinkEditorMusicPanel = this.a;
    if (localWinkEditorMusicPanel != null) {
      localWinkEditorMusicPanel.setMusicDisableEnable(paramBoolean);
    }
  }
  
  public final void setMusicListOperationCallback(@Nullable WinkEditorMusicPanel.OperationCallback paramOperationCallback)
  {
    WinkEditorMusicPanel localWinkEditorMusicPanel = this.a;
    if (localWinkEditorMusicPanel != null) {
      localWinkEditorMusicPanel.setOperationCallback(paramOperationCallback);
    }
  }
  
  public final void setMusicLyricOperationCallback(@Nullable WinkLyricPanelDialog.WinkOperationCallback paramWinkOperationCallback)
  {
    WinkLyricPanelDialog localWinkLyricPanelDialog = this.b;
    if (localWinkLyricPanelDialog != null) {
      localWinkLyricPanelDialog.a(paramWinkOperationCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.WinkEditorMusicControlPanel
 * JD-Core Version:    0.7.0.1
 */