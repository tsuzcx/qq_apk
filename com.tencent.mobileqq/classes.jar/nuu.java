import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.qqstory.storyHome.detail.model.SpannableStringUtils.ClickNickCallback;

public final class nuu
  extends ClickableSpan
{
  public nuu(SpannableStringUtils.ClickNickCallback paramClickNickCallback, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelSpannableStringUtils$ClickNickCallback.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(paramTextPaint.getColor());
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nuu
 * JD-Core Version:    0.7.0.1
 */