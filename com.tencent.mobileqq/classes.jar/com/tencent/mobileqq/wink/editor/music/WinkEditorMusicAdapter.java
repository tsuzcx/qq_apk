package com.tencent.mobileqq.wink.editor.music;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.wink.editor.music.lyric.util.UIUtils;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WinkEditorMusicAdapter
  extends RecyclerView.Adapter<WinkEditorMusicAdapter.WinkEditorMusicViewHolder>
{
  private Context a;
  private List<WinkEditorMusicInfo> b = new LinkedList();
  private WinkEditorMusicAdapter.ClickCallback c;
  private final int d;
  private boolean e = false;
  private Set<WinkEditorMusicAdapter.WinkEditorMusicViewHolder> f = new HashSet();
  private int g;
  private int h;
  private int i;
  
  public WinkEditorMusicAdapter(@NonNull Context paramContext, @Nullable WinkEditorMusicAdapter.ClickCallback paramClickCallback)
  {
    this.a = paramContext;
    this.c = paramClickCallback;
    this.d = paramContext.getResources().getDimensionPixelSize(2131296589);
    this.g = UIUtils.a(6.0F, paramContext.getResources());
    this.h = UIUtils.a(2.0F, paramContext.getResources());
    this.i = UIUtils.a(16.0F, paramContext.getResources());
  }
  
  @NonNull
  public WinkEditorMusicAdapter.WinkEditorMusicViewHolder a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new WinkEditorMusicAdapter.WinkEditorMusicViewHolder(LayoutInflater.from(this.a).inflate(2131628249, paramViewGroup, false), this.c, this.d);
    WinkEditorMusicAdapter.WinkEditorMusicViewHolder.a(paramViewGroup, this.g, this.h, this.i);
    return paramViewGroup;
  }
  
  public List<WinkEditorMusicInfo> a()
  {
    return new LinkedList(this.b);
  }
  
  public void a(WinkEditorMusicAdapter.WinkEditorMusicViewHolder paramWinkEditorMusicViewHolder)
  {
    super.onViewAttachedToWindow(paramWinkEditorMusicViewHolder);
    this.f.add(paramWinkEditorMusicViewHolder);
  }
  
  public void a(@NonNull WinkEditorMusicAdapter.WinkEditorMusicViewHolder paramWinkEditorMusicViewHolder, int paramInt)
  {
    paramWinkEditorMusicViewHolder.a((WinkEditorMusicInfo)this.b.get(paramInt), paramInt, this.b.size());
    EventCollector.getInstance().onRecyclerBindViewHolder(paramWinkEditorMusicViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(@NonNull List<WinkEditorMusicInfo> paramList)
  {
    this.b.clear();
    this.b.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void b(WinkEditorMusicAdapter.WinkEditorMusicViewHolder paramWinkEditorMusicViewHolder)
  {
    super.onViewDetachedFromWindow(paramWinkEditorMusicViewHolder);
    this.f.remove(paramWinkEditorMusicViewHolder);
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.WinkEditorMusicAdapter
 * JD-Core Version:    0.7.0.1
 */