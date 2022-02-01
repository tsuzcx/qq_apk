package com.tencent.mobileqq.writetogetherui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.writetogether.data.UserEditInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class WriteTogetherEditorView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  WriteTogetherEditorView$1(WriteTogetherEditorView paramWriteTogetherEditorView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((WriteTogetherEditorView.a(this.a) != null) && (WriteTogetherEditorView.a(this.a).size() != 0))
    {
      float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      paramValueAnimator = WriteTogetherEditorView.a(this.a).iterator();
      while (paramValueAnimator.hasNext())
      {
        UserEditInfo localUserEditInfo = (UserEditInfo)paramValueAnimator.next();
        if (localUserEditInfo.i < 0.0F) {
          localUserEditInfo.i = (1.0F - f1);
        }
        float f2 = localUserEditInfo.i;
        WriteTogetherEditorView.b(this.a).put(localUserEditInfo.a, Float.valueOf((f2 + f1) % 1.0F));
      }
      this.a.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.WriteTogetherEditorView.1
 * JD-Core Version:    0.7.0.1
 */