package com.tencent.mobileqq.wink.editor.music.viewmodel;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicPlayerViewModel$Range;", "", "start", "", "end", "(Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicPlayerViewModel;II)V", "getEnd", "()I", "setEnd", "(I)V", "getStart", "setStart", "reset", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MusicPlayerViewModel$Range
{
  private int b;
  private int c;
  
  public MusicPlayerViewModel$Range(int paramInt1, int paramInt2)
  {
    this.b = paramInt2;
    int i;
    this.c = i;
  }
  
  public final void a()
  {
    this.b = 0;
    this.c = 15000;
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final int c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.viewmodel.MusicPlayerViewModel.Range
 * JD-Core Version:    0.7.0.1
 */