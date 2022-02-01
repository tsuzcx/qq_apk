package com.tencent.mobileqq.emoticonview;

import android.text.Editable;
import android.widget.EditText;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.statistics.ReportController;

class SmallEmoticonInfo$2
  implements QueryCallback<EmoticonPackage>
{
  SmallEmoticonInfo$2(SmallEmoticonInfo paramSmallEmoticonInfo, int paramInt1, int paramInt2, EditText paramEditText, BaseQQAppInterface paramBaseQQAppInterface) {}
  
  public void postQuery(EmoticonPackage paramEmoticonPackage)
  {
    Object localObject1 = EmosmUtils.b(this.val$epId, this.val$eId);
    Object localObject2 = new char[5];
    localObject2[0] = 20;
    localObject2[1] = localObject1[3];
    localObject2[2] = localObject1[2];
    localObject2[3] = localObject1[1];
    localObject2[4] = localObject1[0];
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.isAPNG == 2)) {
      localObject2[1] = 511;
    }
    int i = this.val$input.getSelectionStart();
    int j = this.val$input.getSelectionEnd();
    this.val$input.getEditableText().replace(i, j, String.valueOf((char[])localObject2));
    this.val$input.requestFocus();
    paramEmoticonPackage = this.val$app;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.val$epId);
    ((StringBuilder)localObject1).append("");
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.val$eId);
    ((StringBuilder)localObject2).append("");
    ReportController.b(paramEmoticonPackage, "CliOper", "", "", "ep_mall", "0X800717E", 0, 0, (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SmallEmoticonInfo.2
 * JD-Core Version:    0.7.0.1
 */