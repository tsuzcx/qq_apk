package com.tencent.mobileqq.transfile;

import android.content.Intent;
import anri;
import anry;
import aoks;
import axqc;
import azla;
import azlb;
import bhaa;
import bhhr;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

class TransFileController$1$1
  implements azla
{
  TransFileController$1$1(TransFileController.1 param1, boolean paramBoolean, String paramString) {}
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void onSend(azlb paramazlb)
  {
    int j = 0;
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append(" onSend result is null ? ");
      if (paramazlb != null) {
        break label70;
      }
      bool = true;
      localObject = ((StringBuilder)localObject).append(bool).append(" result is: ");
      if (paramazlb != null) {
        break label76;
      }
    }
    label70:
    label76:
    for (int i = -99;; i = paramazlb.a)
    {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, i);
      if (paramazlb != null) {
        break label84;
      }
      return;
      bool = false;
      break;
    }
    label84:
    if (paramazlb.a == 0)
    {
      bool = true;
      label94:
      localObject = (anri)this.this$1.val$app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      if (localObject == null) {
        break label231;
      }
      ((anri)localObject).a(bool, this.this$1.val$app.getCurrentAccountUin(), paramazlb.b);
      if (bool) {
        break label238;
      }
      bhaa.a("TransferRequest.onSend", paramazlb.b, paramazlb.toString());
      if (!"FROM_MINI_APP".equals(this.val$tempfrom)) {
        break label401;
      }
      if (!bool) {
        break label403;
      }
      i = j;
      if (!bool) {
        break label410;
      }
    }
    label138:
    label156:
    label175:
    for (paramazlb = "ok";; paramazlb = "upload failed")
    {
      this.this$1.val$intent.putExtra("param_result_code", i);
      this.this$1.val$intent.putExtra("param_result_desc", paramazlb);
      anry.a().a(this.this$1.val$intent);
      return;
      bool = false;
      break label94;
      label231:
      aoks.a(null);
      break label138;
      label238:
      if (((Integer)axqc.a(this.this$1.val$app.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue() != 1) {
        axqc.a(this.this$1.val$app.getAccount(), "qq_avatar_type", Integer.valueOf(1));
      }
      if (this.val$tempisSyncQZone) {
        ThreadManager.getUIHandler().post(new TransFileController.1.1.1(this));
      }
      if (bhhr.ag(this.this$1.val$app.getApp(), this.this$1.val$app.getCurrentAccountUin()) == 2) {
        break label156;
      }
      paramazlb = (anri)this.this$1.val$app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Integer.valueOf(42104));
      paramazlb.a(this.this$1.val$app.getCurrentAccountUin(), this.this$1.val$app.getCurrentAccountUin(), 0, (ArrayList)localObject);
      break label156;
      break;
      i = -10002;
      break label175;
    }
  }
  
  public void updateMsg(azlb paramazlb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TransFileController.1.1
 * JD-Core Version:    0.7.0.1
 */