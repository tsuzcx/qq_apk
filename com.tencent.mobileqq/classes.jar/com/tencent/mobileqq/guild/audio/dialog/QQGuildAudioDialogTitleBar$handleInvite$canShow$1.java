package com.tencent.mobileqq.guild.audio.dialog;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.audio.data.AudioRoomLiveData;
import com.tencent.mobileqq.guild.audio.data.DIALOG_STATUS;
import com.tencent.mobileqq.guild.share.GuildShareActionSheet.ActionSheetListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/guild/audio/dialog/QQGuildAudioDialogTitleBar$handleInvite$canShow$1", "Lcom/tencent/mobileqq/guild/share/GuildShareActionSheet$ActionSheetListener;", "onClickShareItem", "", "onShareActionSheetDismiss", "onShareActionSheetShow", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class QQGuildAudioDialogTitleBar$handleInvite$canShow$1
  implements GuildShareActionSheet.ActionSheetListener
{
  public void a() {}
  
  public void b()
  {
    AudioRoomLiveData.a.a().postValue(DIALOG_STATUS.REOPEN);
  }
  
  public void c()
  {
    AudioRoomLiveData.a.a().postValue(DIALOG_STATUS.REOPEN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.QQGuildAudioDialogTitleBar.handleInvite.canShow.1
 * JD-Core Version:    0.7.0.1
 */