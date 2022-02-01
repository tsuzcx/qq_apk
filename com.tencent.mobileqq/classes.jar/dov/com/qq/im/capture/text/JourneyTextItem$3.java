package dov.com.qq.im.capture.text;

import android.text.Spanned;
import android.text.TextUtils;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.LengthInputFilter;

class JourneyTextItem$3
  extends EditTextDialog.LengthInputFilter
{
  JourneyTextItem$3(JourneyTextItem paramJourneyTextItem, int paramInt)
  {
    super(paramInt);
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    String str1;
    String str2;
    int i;
    if (this.jdField_a_of_type_DovComQqImCaptureTextJourneyTextItem.b() == 0)
    {
      str1 = paramSpanned.subSequence(0, paramInt3).toString() + paramCharSequence.subSequence(paramInt1, paramInt2).toString() + paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString();
      str2 = TroopFileUtils.b(str1);
      String[] arrayOfString = this.jdField_a_of_type_DovComQqImCaptureTextJourneyTextItem.a(str2).split("\n");
      int m = arrayOfString.length;
      int j = 0;
      i = 0;
      if (j < m)
      {
        int k = arrayOfString[j].length();
        int n = k / 5;
        if (k % 5 > 0) {}
        for (k = 1;; k = 0)
        {
          i += k + n;
          j += 1;
          break;
        }
      }
      if (!TextUtils.equals(paramCharSequence, "\n")) {
        break label261;
      }
      i += 1;
    }
    label261:
    for (;;)
    {
      if (i > 4)
      {
        if (!TextUtils.equals("", paramCharSequence)) {
          a();
        }
        return "";
      }
      this.jdField_a_of_type_Int = (str1.length() - str2.length() + 20);
      return super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
      this.jdField_a_of_type_Int = 20;
      return super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.text.JourneyTextItem.3
 * JD-Core Version:    0.7.0.1
 */