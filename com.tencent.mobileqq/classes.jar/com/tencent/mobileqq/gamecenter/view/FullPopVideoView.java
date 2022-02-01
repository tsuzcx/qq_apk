package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import avmj;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

public class FullPopVideoView
  extends FrameLayout
  implements TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnSeekCompleteListener, TVK_IMediaPlayer.OnVideoPreparedListener
{
  private avmj jdField_a_of_type_Avmj;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  
  public FullPopVideoView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public FullPopVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
    }
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FullPopVideoView", 1, "onCompletion ");
    }
    if (this.jdField_a_of_type_Avmj != null) {
      this.jdField_a_of_type_Avmj.a();
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
    }
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    return false;
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (paramTVK_IMediaPlayer != null)
    {
      long l = paramTVK_IMediaPlayer.getCurrentPostion();
      if (QLog.isColorLevel()) {
        QLog.d("FullPopVideoView", 1, "onSeekComplete Postion=" + l);
      }
    }
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer) {}
  
  public void setListener(avmj paramavmj)
  {
    this.jdField_a_of_type_Avmj = paramavmj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.FullPopVideoView
 * JD-Core Version:    0.7.0.1
 */