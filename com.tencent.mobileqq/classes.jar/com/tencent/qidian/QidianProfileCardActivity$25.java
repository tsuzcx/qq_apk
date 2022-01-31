package com.tencent.qidian;

import android.text.TextUtils;
import awmk;
import bizm;
import bizt;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;

class QidianProfileCardActivity$25
  implements Runnable
{
  QidianProfileCardActivity$25(QidianProfileCardActivity paramQidianProfileCardActivity, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    Object localObject2 = this.this$0.app.getCurrentNickname();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.this$0.app.getCurrentNickname();
    }
    localObject2 = bizt.a();
    ((bizt)localObject2).a = this.this$0.app.getCurrentAccountUin();
    ((bizt)localObject2).b = ((String)localObject1);
    bizm.a(this.this$0, (bizt)localObject2, this.this$0.jdField_a_of_type_Awmk.a.a, this.this$0.jdField_a_of_type_Awmk.a.g, -1, 5, this.this$0.jdField_a_of_type_Asor, this.a, false);
    QidianProfileCardActivity.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.25
 * JD-Core Version:    0.7.0.1
 */