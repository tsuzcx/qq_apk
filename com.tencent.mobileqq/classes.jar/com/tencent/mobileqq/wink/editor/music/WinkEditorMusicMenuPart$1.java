package com.tencent.mobileqq.wink.editor.music;

import com.tencent.mobileqq.wink.editor.WinkTavCutDelegate;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment.PlayerControlCallback;
import com.tencent.tavcut.render.player.IPlayer;

class WinkEditorMusicMenuPart$1
  implements MusicSelectFragment.PlayerControlCallback
{
  WinkEditorMusicMenuPart$1(WinkEditorMusicMenuPart paramWinkEditorMusicMenuPart) {}
  
  public void a()
  {
    if (((WinkEditorMusicMenuPart.a(this.a) instanceof WinkVideoTavCut)) && (WinkEditorMusicMenuPart.b(this.a).a() != null)) {
      WinkEditorMusicMenuPart.c(this.a).a().b();
    }
  }
  
  public void a(int paramInt)
  {
    if (((WinkEditorMusicMenuPart.g(this.a) instanceof WinkVideoTavCut)) && (WinkEditorMusicMenuPart.h(this.a).a() != null))
    {
      WinkEditorMusicMenuPart.i(this.a).a().a(paramInt);
      WinkEditorMusicMenuPart.j(this.a).a().a();
    }
  }
  
  public void b()
  {
    if (((WinkEditorMusicMenuPart.d(this.a) instanceof WinkVideoTavCut)) && (WinkEditorMusicMenuPart.e(this.a).a() != null)) {
      WinkEditorMusicMenuPart.f(this.a).a().a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.WinkEditorMusicMenuPart.1
 * JD-Core Version:    0.7.0.1
 */