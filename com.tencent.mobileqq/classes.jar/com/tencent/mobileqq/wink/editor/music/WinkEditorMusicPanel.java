package com.tencent.mobileqq.wink.editor.music;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.LinkedList;
import java.util.List;

public class WinkEditorMusicPanel
  extends FrameLayout
  implements WinkEditorMusicAdapter.ClickCallback
{
  private RecyclerView a;
  private ImageView b;
  private ImageView c;
  private LinearLayoutManager d;
  private WinkEditorMusicAdapter e;
  private float f = 0.8F;
  private boolean g;
  private WinkEditorMusicPanel.OperationCallback h;
  private boolean i = true;
  private boolean j = false;
  
  public WinkEditorMusicPanel(@NonNull Context paramContext)
  {
    super(paramContext);
    View localView = LayoutInflater.from(paramContext).inflate(2131628244, this);
    this.a = ((RecyclerView)localView.findViewById(2131445213));
    this.b = ((ImageView)localView.findViewById(2131450174));
    this.c = ((ImageView)localView.findViewById(2131450176));
    this.d = new LinearLayoutManager(paramContext, 0, false);
    this.e = new WinkEditorMusicAdapter(paramContext, this);
    VideoReport.setElementId(this.b, "em_xsj_music_cut_button");
    this.a.setLayoutManager(this.d);
    this.a.setAdapter(this.e);
    this.e.a(WinkEditorMusicInfo.a);
    this.b.setOnClickListener(new -..Lambda.WinkEditorMusicPanel.LOyPRNiKKV3sHCSZLOqY56kR-1M(this));
    this.c.setOnClickListener(new -..Lambda.WinkEditorMusicPanel.4Ib30hnw6lDVnwwLNIj55phST48(this));
  }
  
  private boolean a()
  {
    if (this.d != null)
    {
      WinkEditorMusicAdapter localWinkEditorMusicAdapter = this.e;
      if (localWinkEditorMusicAdapter == null) {
        return false;
      }
      return localWinkEditorMusicAdapter.getItemCount() != 0;
    }
    return false;
  }
  
  private int b(int paramInt)
  {
    int k = this.e.getItemCount();
    if (paramInt < 0) {
      return 0;
    }
    k -= 1;
    if (paramInt > k) {
      return k;
    }
    return paramInt;
  }
  
  public void a(int paramInt)
  {
    if (!a()) {
      return;
    }
    paramInt = b(paramInt);
    this.d.scrollToPosition(paramInt);
  }
  
  public void a(@Nullable WinkEditorMusicInfo paramWinkEditorMusicInfo, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      paramWinkEditorMusicInfo = this.h;
      if (paramWinkEditorMusicInfo != null) {
        paramWinkEditorMusicInfo.a();
      }
      return;
    }
    if (!paramBoolean)
    {
      setEnableBgm(false);
      return;
    }
    this.j = true;
    WinkEditorMusicPanel.OperationCallback localOperationCallback = this.h;
    if (localOperationCallback != null) {
      localOperationCallback.a(paramWinkEditorMusicInfo, paramInt1);
    }
  }
  
  public void a(@NonNull List<WinkEditorMusicInfo> paramList)
  {
    WinkEditorMusicAdapter localWinkEditorMusicAdapter = this.e;
    if (localWinkEditorMusicAdapter != null) {
      localWinkEditorMusicAdapter.a(paramList);
    }
  }
  
  @NonNull
  public List<WinkEditorMusicInfo> getBackgroundMusicData()
  {
    WinkEditorMusicAdapter localWinkEditorMusicAdapter = this.e;
    if (localWinkEditorMusicAdapter != null) {
      return localWinkEditorMusicAdapter.a();
    }
    return new LinkedList();
  }
  
  public void setAutoTemplate(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void setClipEntranceVisible(boolean paramBoolean)
  {
    ImageView localImageView = this.b;
    if (localImageView != null)
    {
      if (paramBoolean)
      {
        localImageView.setVisibility(0);
        return;
      }
      localImageView.setVisibility(4);
    }
  }
  
  public void setEnableBgm(boolean paramBoolean)
  {
    this.j = paramBoolean;
    WinkEditorMusicPanel.OperationCallback localOperationCallback = this.h;
    if (localOperationCallback != null) {
      localOperationCallback.a(this.j);
    }
  }
  
  public void setMusicDisableEnable(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setOperationCallback(@Nullable WinkEditorMusicPanel.OperationCallback paramOperationCallback)
  {
    this.h = paramOperationCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.WinkEditorMusicPanel
 * JD-Core Version:    0.7.0.1
 */