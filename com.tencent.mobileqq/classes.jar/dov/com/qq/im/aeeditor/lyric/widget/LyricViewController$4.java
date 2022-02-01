package dov.com.qq.im.aeeditor.lyric.widget;

import android.os.SystemClock;
import android.util.Log;
import bnub;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Lyric;

public class LyricViewController$4
  implements Runnable
{
  public LyricViewController$4(bnub parambnub, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric == null) || (this.this$0.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.isEmpty()))
    {
      Log.w("ModuleController", "seek before set lyric");
      return;
    }
    this.this$0.jdField_a_of_type_Long = (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Int);
    if ((this.this$0.jdField_a_of_type_Boolean) && (this.this$0.jdField_a_of_type_Int > 0))
    {
      bnub localbnub = this.this$0;
      localbnub.jdField_a_of_type_Long -= this.this$0.jdField_a_of_type_Int;
    }
    bnub.a(this.this$0, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.widget.LyricViewController.4
 * JD-Core Version:    0.7.0.1
 */