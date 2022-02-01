package com.tencent.mobileqq.vas;

import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.QueryCallback;

final class ColorNickManager$1
  implements QueryCallback<EmoticonPackage>
{
  ColorNickManager$1(int paramInt1, int paramInt2, EditText paramEditText) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    char[] arrayOfChar1 = EmosmUtils.a(this.a, this.b);
    char[] arrayOfChar2 = new char[7];
    int j = 0;
    arrayOfChar2[0] = '<';
    arrayOfChar2[1] = '$';
    arrayOfChar2[2] = arrayOfChar1[0];
    arrayOfChar2[3] = arrayOfChar1[1];
    arrayOfChar2[4] = arrayOfChar1[2];
    arrayOfChar2[5] = arrayOfChar1[3];
    arrayOfChar2[6] = '>';
    int i = j;
    if (paramEmoticonPackage != null)
    {
      i = j;
      if (paramEmoticonPackage.isAPNG == 2)
      {
        arrayOfChar2[1] = 'ǿ';
        i = j;
      }
    }
    while (i < arrayOfChar2.length)
    {
      if (arrayOfChar2[i] == 0) {
        arrayOfChar2[i] = 'Ā';
      }
      i += 1;
    }
    i = this.c.getSelectionStart();
    j = this.c.getSelectionEnd();
    this.c.getEditableText().replace(i, j, String.valueOf(arrayOfChar2));
    this.c.requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorNickManager.1
 * JD-Core Version:    0.7.0.1
 */