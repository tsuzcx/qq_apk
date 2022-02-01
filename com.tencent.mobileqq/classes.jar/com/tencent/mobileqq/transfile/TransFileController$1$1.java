package com.tencent.mobileqq.transfile;

import amov;
import ampl;
import android.content.Intent;
import awka;
import ayeo;
import ayep;
import bfrj;
import bfyz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

class TransFileController$1$1
  implements ayeo
{
  TransFileController$1$1(TransFileController.1 param1, boolean paramBoolean, String paramString) {}
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void onSend(ayep paramayep)
  {
    int j = 0;
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append(" onSend result is null ? ");
      if (paramayep != null) {
        break label70;
      }
      bool = true;
      localObject = ((StringBuilder)localObject).append(bool).append(" result is: ");
      if (paramayep != null) {
        break label76;
      }
    }
    label70:
    label76:
    for (int i = -99;; i = paramayep.a)
    {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, i);
      if (paramayep != null) {
        break label84;
      }
      return;
      bool = false;
      break;
    }
    label84:
    if (paramayep.a == 0)
    {
      bool = true;
      label94:
      localObject = (amov)this.this$1.val$app.getBusinessHandler(2);
      if (localObject == null) {
        break label229;
      }
      ((amov)localObject).a(bool, this.this$1.val$app.getCurrentAccountUin(), paramayep.b);
      if (bool) {
        break label236;
      }
      bfrj.a("TransferRequest.onSend", paramayep.b, paramayep.toString());
      if (!"FROM_MINI_APP".equals(this.val$tempfrom)) {
        break label397;
      }
      if (!bool) {
        break label399;
      }
      i = j;
      if (!bool) {
        break label406;
      }
    }
    label136:
    label154:
    label173:
    for (paramayep = "ok";; paramayep = "upload failed")
    {
      this.this$1.val$intent.putExtra("param_result_code", i);
      this.this$1.val$intent.putExtra("param_result_desc", paramayep);
      ampl.a().a(this.this$1.val$intent);
      return;
      bool = false;
      break label94;
      label229:
      bfrj.a(null);
      break label136;
      label236:
      if (((Integer)awka.a(this.this$1.val$app.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue() != 1) {
        awka.a(this.this$1.val$app.getAccount(), "qq_avatar_type", Integer.valueOf(1));
      }
      if (this.val$tempisSyncQZone) {
        ThreadManager.getUIHandler().post(new TransFileController.1.1.1(this));
      }
      if (bfyz.ag(this.this$1.val$app.getApp(), this.this$1.val$app.getCurrentAccountUin()) == 2) {
        break label154;
      }
      paramayep = (amov)this.this$1.val$app.getBusinessHandler(2);
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Integer.valueOf(42104));
      paramayep.a(this.this$1.val$app.getCurrentAccountUin(), this.this$1.val$app.getCurrentAccountUin(), 0, (ArrayList)localObject);
      break label154;
      break;
      i = -10002;
      break label173;
    }
  }
  
  public void updateMsg(ayep paramayep) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TransFileController.1.1
 * JD-Core Version:    0.7.0.1
 */