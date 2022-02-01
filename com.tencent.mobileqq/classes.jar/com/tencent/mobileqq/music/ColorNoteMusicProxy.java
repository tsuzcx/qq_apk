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
  private IColorNoteController jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController = (IColorNoteController)QRoute.api(IColorNoteController.class);
  private IServiceSyncListener jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenIServiceSyncListener = new ColorNoteMusicProxy.1(this);
  private boolean jdField_a_of_type_Boolean = true;
  
  public ColorNoteMusicProxy(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.init(paramContext, false, false);
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setServiceInfo(this);
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.disableToast();
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setServiceSyncListener(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenIServiceSyncListener);
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.registerBroadcast();
    QQPlayerService.b(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.onDestroy();
  }
  
  public ColorNote getColorNote()
  {
    SongInfo localSongInfo = QQPlayerService.b();
    byte[] arrayOfByte = null;
    if (localSongInfo != null)
    {
      if (localSongInfo.f != null) {
        arrayOfByte = localSongInfo.f.getBytes();
      }
      return new ColorNote.Builder().a(16973824).a("music_color_note_only_one").b(localSongInfo.c).c(localSongInfo.h).d(localSongInfo.e).a(arrayOfByte).a();
    }
    return null;
  }
  
  public String getToken()
  {
    return QQPlayerService.a();
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo)
  {
    if ((paramSongInfo != null) && (this.jdField_a_of_type_Boolean))
    {
      ColorNote localColorNote = getColorNote();
      localColorNote.mMainTitle = paramSongInfo.c;
      localColorNote.mSubTitle = paramSongInfo.h;
      localColorNote.mPicUrl = paramSongInfo.e;
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.updateColorNote(localColorNote);
    }
  }
  
  public void onPlayStateChanged(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.deleteColorNote();
      return;
    }
    if (((IColorNoteHelper)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IColorNoteHelper.class, "all")).isColorNoteExit(16973824, "music_color_note_only_one")) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.deleteColorNote();
    }
    if ((QQPlayerService.a(QQPlayerService.b())) && (this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.shouldDisplayColorNote()) && (paramInt == 2)) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.insertColorNote();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.music.ColorNoteMusicProxy
 * JD-Core Version:    0.7.0.1
 */