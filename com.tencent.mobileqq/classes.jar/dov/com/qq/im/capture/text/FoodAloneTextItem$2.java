package dov.com.qq.im.capture.text;

import android.text.Spanned;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.LengthInputFilter;

class FoodAloneTextItem$2
  extends EditTextDialog.LengthInputFilter
{
  FoodAloneTextItem$2(FoodAloneTextItem paramFoodAloneTextItem, int paramInt)
  {
    super(paramInt);
  }
  
  public int a(CharSequence paramCharSequence)
  {
    return 0;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    String str = paramSpanned.subSequence(0, paramInt3).toString() + paramCharSequence.subSequence(paramInt1, paramInt2).toString() + paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString();
    this.jdField_a_of_type_Int = (str.length() - TroopFileUtils.b(str).length() + 20);
    return super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.text.FoodAloneTextItem.2
 * JD-Core Version:    0.7.0.1
 */