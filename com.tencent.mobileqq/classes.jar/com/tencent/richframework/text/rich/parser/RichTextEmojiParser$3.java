package com.tencent.richframework.text.rich.parser;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig.TextImageSpanConfig;

class RichTextEmojiParser$3
  extends QCirclePicStateListener
{
  RichTextEmojiParser$3(RichTextEmojiParser paramRichTextEmojiParser, RichTextPreloadConfig.TextImageSpanConfig paramTextImageSpanConfig, SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, String paramString, RichTextEmojiParser.OnDrawableListener paramOnDrawableListener) {}
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    super.onStateChang(paramInt, paramOption);
    if (paramInt == 6)
    {
      Object localObject = new BitmapDrawable(paramOption.getResultBitMap());
      RichTextEmojiParser.a(this.a, this.b, this.c, this.d, (Drawable)localObject, true, this.e);
      localObject = this.f;
      if (localObject != null) {
        ((RichTextEmojiParser.OnDrawableListener)localObject).a(null);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramOption.getSeq());
      ((StringBuilder)localObject).append(":parse url success");
      QLog.d("RichTextEmojiParser", 4, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.text.rich.parser.RichTextEmojiParser.3
 * JD-Core Version:    0.7.0.1
 */