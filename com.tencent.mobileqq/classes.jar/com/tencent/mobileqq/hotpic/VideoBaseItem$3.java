package com.tencent.mobileqq.hotpic;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;

class VideoBaseItem$3
  implements TVK_IMediaPlayer.OnErrorListener
{
  VideoBaseItem$3(VideoBaseItem paramVideoBaseItem) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    VideoBaseItem localVideoBaseItem = this.a;
    localVideoBaseItem.c = 7;
    if (VideoBaseItem.a(localVideoBaseItem) != null) {
      VideoBaseItem.a(this.a).a(this.a.b, paramTVK_IMediaPlayer, paramInt1, paramInt2, paramInt3, paramString, paramObject);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.VideoBaseItem.3
 * JD-Core Version:    0.7.0.1
 */