package com.tencent.mobileqq.qwallet.hb.grap.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;

class RedPacketKSongFragment$10
  implements IPreloadService.OnGetPathListener
{
  RedPacketKSongFragment$10(RedPacketKSongFragment paramRedPacketKSongFragment) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      RedPacketKSongFragment.SongInfo localSongInfo = new RedPacketKSongFragment.SongInfo();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramPathResult.folderPath);
      localStringBuilder.append("/");
      localStringBuilder.append("original.mp3");
      localSongInfo.a = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramPathResult.folderPath);
      localStringBuilder.append("/");
      localStringBuilder.append("accompany.mp3");
      localSongInfo.b = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramPathResult.folderPath);
      localStringBuilder.append("/");
      localStringBuilder.append("lyrics.qrc");
      localSongInfo.c = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramPathResult.folderPath);
      localStringBuilder.append("/");
      localStringBuilder.append("config.cfg");
      localSongInfo.d = localStringBuilder.toString();
      RedPacketKSongFragment.a(this.a, localSongInfo);
      if (this.a.d()) {
        return;
      }
      this.a.getQBaseActivity().runOnUiThread(new RedPacketKSongFragment.10.1(this));
      return;
    }
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketKSongFragment.10
 * JD-Core Version:    0.7.0.1
 */