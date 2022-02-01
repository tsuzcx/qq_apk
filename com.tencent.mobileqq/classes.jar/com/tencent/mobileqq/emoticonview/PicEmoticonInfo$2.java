package com.tencent.mobileqq.emoticonview;

import acvv;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import avlc;
import avli;
import avma;
import avmr;
import avsq;
import avtb;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class PicEmoticonInfo$2
  implements avtb<EmoticonPackage>
{
  PicEmoticonInfo$2(PicEmoticonInfo paramPicEmoticonInfo, QQAppInterface paramQQAppInterface, int paramInt, Context paramContext, SessionInfo paramSessionInfo) {}
  
  public void postQuery(EmoticonPackage paramEmoticonPackage)
  {
    int i = avlc.a(this.this$0.emoticon.magicValue);
    if ((-1 != i) && (paramEmoticonPackage != null))
    {
      paramEmoticonPackage.rscType = i;
      ((avsq)this.val$app.getManager(14)).a(paramEmoticonPackage);
    }
    paramEmoticonPackage = "rscType?" + i + ";value=" + this.val$random;
    this.this$0.emoticon.magicValue = paramEmoticonPackage;
    if (QLog.isColorLevel()) {
      QLog.d("PicEmoticonInfo", 2, "before play,magicvalue:" + paramEmoticonPackage);
    }
    avli localavli = avma.a(this.this$0.emoticon, 0);
    if ((localavli != null) && (!localavli.c))
    {
      acvv.a(this.val$app, this.val$context, this.val$sessionInfo, this.this$0.emoticon);
      return;
    }
    ((FragmentActivity)this.val$context).getChatFragment().a().getMagicfaceViewController().a(this.this$0.emoticon, new PicEmoticonInfo.2.1(this, paramEmoticonPackage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.PicEmoticonInfo.2
 * JD-Core Version:    0.7.0.1
 */