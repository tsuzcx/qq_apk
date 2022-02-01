package dov.com.qq.im.capture.text;

import android.text.Spanned;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.LengthInputFilter;

class ShadowBubbleTextItem$1
  extends EditTextDialog.LengthInputFilter
{
  ShadowBubbleTextItem$1(ShadowBubbleTextItem paramShadowBubbleTextItem, int paramInt)
  {
    super(paramInt);
  }
  
  public int a(CharSequence paramCharSequence)
  {
    return 0;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    int j = 0;
    String str = paramCharSequence.subSequence(paramInt1, paramInt2).toString().replaceAll("\n", "");
    int i;
    if (paramInt2 - paramInt1 != str.length())
    {
      i = 1;
      if (i == 0) {
        break label92;
      }
      paramInt2 = str.length();
      paramInt1 = j;
      paramCharSequence = str;
    }
    label92:
    for (;;)
    {
      paramSpanned = super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
      if ((paramSpanned == null) && (i != 0))
      {
        return paramCharSequence;
        i = 0;
        break;
      }
      return paramSpanned;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.text.ShadowBubbleTextItem.1
 * JD-Core Version:    0.7.0.1
 */