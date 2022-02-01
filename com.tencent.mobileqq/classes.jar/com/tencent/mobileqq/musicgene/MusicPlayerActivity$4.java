package com.tencent.mobileqq.musicgene;

import android.os.Bundle;
import android.os.Message;

class MusicPlayerActivity$4
  implements AlbumDecodeHandler.OnDecodeCompleteCallback
{
  MusicPlayerActivity$4(MusicPlayerActivity paramMusicPlayerActivity) {}
  
  public void a(String paramString, int paramInt1, int paramInt2, Object paramObject)
  {
    paramString = Message.obtain(MusicPlayerActivity.a(this.a), 49);
    Bundle localBundle = new Bundle();
    localBundle.putIntArray("KEY_COLOR_LIST", new int[] { paramInt1, paramInt2 });
    localBundle.putBoolean("KEY_MATCH_SONG", ((Boolean)paramObject).booleanValue());
    paramString.setData(localBundle);
    paramString.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicPlayerActivity.4
 * JD-Core Version:    0.7.0.1
 */