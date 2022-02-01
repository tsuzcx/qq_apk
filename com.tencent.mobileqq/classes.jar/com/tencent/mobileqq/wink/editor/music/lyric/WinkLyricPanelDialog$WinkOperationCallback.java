package com.tencent.mobileqq.wink.editor.music.lyric;

public abstract interface WinkLyricPanelDialog$WinkOperationCallback
{
  public abstract void onClickCancelBtn();
  
  public abstract void onClickConfirmBtn();
  
  public abstract void onIndicatorDragged(int paramInt);
  
  public abstract void onMusicWaveMoveEnd(boolean paramBoolean);
  
  public abstract void onMusicWaveMoveStart();
  
  public abstract void onMusicWaveMoving(int paramInt1, int paramInt2);
  
  public abstract void onResetMusicRangeToRecommend(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.WinkLyricPanelDialog.WinkOperationCallback
 * JD-Core Version:    0.7.0.1
 */