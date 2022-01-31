import android.graphics.drawable.Drawable;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.KeyboardAndEmojiManager;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.text.TextUtils;

public class nzs
  implements EmoticonCallback
{
  public nzs(KeyboardAndEmojiManager paramKeyboardAndEmojiManager) {}
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    if (((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)) && (KeyboardAndEmojiManager.a(this.a) != null)) {
      ((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).a(PlayModeUtils.a(), KeyboardAndEmojiManager.a(this.a), KeyboardAndEmojiManager.a(this.a), null);
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void b()
  {
    if (KeyboardAndEmojiManager.a(this.a) != null) {
      TextUtils.a(KeyboardAndEmojiManager.a(this.a));
    }
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void c() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzs
 * JD-Core Version:    0.7.0.1
 */