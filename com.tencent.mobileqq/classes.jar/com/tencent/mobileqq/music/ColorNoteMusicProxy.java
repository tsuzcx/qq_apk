package com.tencent.mobileqq.music;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.Builder;
import com.tencent.mobileqq.colornote.data.IColorNoteHelper;
import com.tencent.mobileqq.colornote.smallscreen.IServiceSyncListener;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppRuntime;

public class ColorNoteMusicProxy
  implements IServiceInfo, QQPlayerCallback
{
  private IColorNoteController a = (IColorNoteController)QRoute.api(IColorNoteController.class);
  private boolean b = true;
  private IServiceSyncListener c = new ColorNoteMusicProxy.1(this);
  
  public ColorNoteMusicProxy(Context paramContext)
  {
    this.a.init(paramContext, false, false);
    this.a.setServiceInfo(this);
    this.a.disableToast();
    this.a.setServiceSyncListener(this.c);
    this.a.registerBroadcast();
    QQPlayerService.b(this);
  }
  
  public void a()
  {
    this.a.onDestroy();
  }
  
  public ColorNote getColorNote()
  {
    SongInfo localSongInfo = QQPlayerService.g();
    byte[] arrayOfByte = null;
    if (localSongInfo != null)
    {
      if (localSongInfo.h != null) {
        arrayOfByte = localSongInfo.h.getBytes();
      }
      return new ColorNote.Builder().a(16973824).a("music_color_note_only_one").b(localSongInfo.e).c(localSongInfo.j).d(localSongInfo.g).a(arrayOfByte).a();
    }
    return null;
  }
  
  public String getToken()
  {
    return QQPlayerService.o();
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo)
  {
    if ((paramSongInfo != null) && (this.b))
    {
      ColorNote localColorNote = getColorNote();
      localColorNote.mMainTitle = paramSongInfo.e;
      localColorNote.mSubTitle = paramSongInfo.j;
      localColorNote.mPicUrl = paramSongInfo.g;
      this.a.updateColorNote(localColorNote);
    }
  }
  
  public void onPlayStateChanged(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 1))
    {
      this.a.deleteColorNote();
      return;
    }
    if (((IColorNoteHelper)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IColorNoteHelper.class, "all")).isColorNoteExit(16973824, "music_color_note_only_one")) {
      this.a.deleteColorNote();
    }
    if ((QQPlayerService.a(QQPlayerService.g())) && (this.a.shouldDisplayColorNote()) && (paramInt == 2)) {
      this.a.insertColorNote();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.music.ColorNoteMusicProxy
 * JD-Core Version:    0.7.0.1
 */