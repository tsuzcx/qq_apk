package com.tencent.mobileqq.wink.editor.text;

import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import com.tencent.videocut.utils.KeyboardStateHelper.KeyboardStateListener;

class WinkEditorTextMenuPart$1
  implements KeyboardStateHelper.KeyboardStateListener
{
  WinkEditorTextMenuPart$1(WinkEditorTextMenuPart paramWinkEditorTextMenuPart) {}
  
  public void a()
  {
    String str = (String)WinkEditorTextMenuPart.a(this.a).d().getValue();
    if ("CATEGORY_KEYBOARD".equals(str))
    {
      WinkEditorTextMenuPart.a(this.a).b("CATEGORY_TEXT_PATTERN");
      return;
    }
    WinkEditorTextMenuPart.a(this.a, str);
  }
  
  public void a(int paramInt)
  {
    if (WinkEditorTextMenuPart.b(this.a).getLayoutParams().height != paramInt)
    {
      WinkEditorTextMenuPart.b(this.a).getLayoutParams().height = paramInt;
      WinkEditorTextMenuPart.b(this.a).requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.text.WinkEditorTextMenuPart.1
 * JD-Core Version:    0.7.0.1
 */