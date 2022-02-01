package com.tencent.mobileqq.music;

import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.smallscreen.IServiceSyncListener;

class ColorNoteMusicProxy$1
  implements IServiceSyncListener
{
  ColorNoteMusicProxy$1(ColorNoteMusicProxy paramColorNoteMusicProxy) {}
  
  public void onServiceSyncSucc(boolean paramBoolean)
  {
    if ((ColorNoteMusicProxy.a(this.a)) && (ColorNoteMusicProxy.b(this.a) != null) && (!ColorNoteMusicProxy.b(this.a).isColorNoteExist())) {
      ColorNoteMusicProxy.b(this.a).insertColorNote();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.music.ColorNoteMusicProxy.1
 * JD-Core Version:    0.7.0.1
 */