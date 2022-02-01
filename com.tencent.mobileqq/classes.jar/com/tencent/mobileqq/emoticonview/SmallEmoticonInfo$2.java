package com.tencent.mobileqq.emoticonview;

import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.model.QueryCallback;
import com.tencent.mobileqq.statistics.ReportController;

class SmallEmoticonInfo$2
  implements QueryCallback<EmoticonPackage>
{
  SmallEmoticonInfo$2(SmallEmoticonInfo paramSmallEmoticonInfo, int paramInt1, int paramInt2, EditText paramEditText, QQAppInterface paramQQAppInterface) {}
  
  public void postQuery(EmoticonPackage paramEmoticonPackage)
  {
    char[] arrayOfChar1 = EmosmUtils.a(this.val$epId, this.val$eId);
    char[] arrayOfChar2 = new char[5];
    arrayOfChar2[0] = '\024';
    arrayOfChar2[1] = arrayOfChar1[3];
    arrayOfChar2[2] = arrayOfChar1[2];
    arrayOfChar2[3] = arrayOfChar1[1];
    arrayOfChar2[4] = arrayOfChar1[0];
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.isAPNG == 2)) {
      arrayOfChar2[1] = 'ǿ';
    }
    int i = this.val$input.getSelectionStart();
    int j = this.val$input.getSelectionEnd();
    this.val$input.getEditableText().replace(i, j, String.valueOf(arrayOfChar2));
    this.val$input.requestFocus();
    ReportController.b(this.val$app, "CliOper", "", "", "ep_mall", "0X800717E", 0, 0, this.val$epId + "", this.val$eId + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SmallEmoticonInfo.2
 * JD-Core Version:    0.7.0.1
 */