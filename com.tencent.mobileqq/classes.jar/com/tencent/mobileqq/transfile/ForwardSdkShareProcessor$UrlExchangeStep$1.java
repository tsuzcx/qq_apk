package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import android.text.TextUtils;
import aqgj;
import ayqt;
import ayrd;
import aywc;
import bdes;
import bdin;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import naj;

public class ForwardSdkShareProcessor$UrlExchangeStep$1
  implements Runnable
{
  public ForwardSdkShareProcessor$UrlExchangeStep$1(ayrd paramayrd) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "UrlExchangeStep|run,retry=" + ayrd.a(this.a));
    }
    if (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.a.f();
      return;
    }
    Object localObject = new Bundle();
    String str = this.a.jdField_b_of_type_Ayqt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    int i;
    long l;
    boolean bool;
    if ((!ayqt.b(this.a.jdField_b_of_type_Ayqt).get()) && (TextUtils.isEmpty(ayqt.a(this.a.jdField_b_of_type_Ayqt))))
    {
      i = 0;
      ((Bundle)localObject).putString("report_type", "102");
      ((Bundle)localObject).putString("act_type", "52");
      ((Bundle)localObject).putString("intext_3", "0");
      ((Bundle)localObject).putString("stringext_1", ayqt.e(this.a.jdField_b_of_type_Ayqt));
      ((Bundle)localObject).putString("intext_4", "" + i);
      bdes.a().a((Bundle)localObject, "", str, false);
      l = System.currentTimeMillis();
      aqgj.a("batch_url_exchange");
      localObject = new Bundle();
      HashMap localHashMap = naj.a(this.a.jdField_b_of_type_Ayqt.jdField_a_of_type_AndroidContentContext, str, ayqt.f(this.a.jdField_b_of_type_Ayqt), 1, ayqt.a(this.a.jdField_b_of_type_Ayqt), (Bundle)localObject);
      l = System.currentTimeMillis() - l;
      bool = ((Bundle)localObject).getBoolean("isSuccess");
      i = ((Bundle)localObject).getInt("retcode", -1);
      ayrd.b(this.a).set(i);
      localObject = new HashMap();
      ((HashMap)localObject).put("param_ret_code", Integer.toString(i));
      aqgj.a("batch_url_exchange", str, (HashMap)localObject, bool);
      if (QLog.isColorLevel()) {
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, "UrlExchangeStep|run,suc=" + bool + ",ret=" + ayrd.b(this.a) + ",cost=" + l);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "12");
      localBundle.putString("intext_3", "0");
      if (!bool) {
        break label1114;
      }
      localObject = "0";
      label425:
      localBundle.putString("intext_1", (String)localObject);
      localBundle.putString("intext_2", "" + ayrd.b(this.a));
      localBundle.putString("intext_5", "" + l);
      if (!bool) {
        localBundle.putString("stringext_1", ayqt.e(this.a.jdField_b_of_type_Ayqt));
      }
      bdes.a().a(localBundle, "", str, false);
      if (!bool) {
        break label1122;
      }
      ayqt.a(this.a.jdField_b_of_type_Ayqt).putAll(localHashMap);
      ayqt.c(this.a.jdField_b_of_type_Ayqt).set(true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, "UrlExchangeStep|run,url=" + ayqt.a(this.a.jdField_b_of_type_Ayqt).toString());
      }
      localObject = (String)ayqt.a(this.a.jdField_b_of_type_Ayqt).get("imageUrl");
      if (localObject != null)
      {
        aqgj.a("reuse_image_for_aio");
        bdin.a(false, ayqt.a(this.a.jdField_b_of_type_Ayqt), ayqt.a(this.a.jdField_b_of_type_Ayqt), (String)localObject);
        aqgj.a("reuse_image_for_aio", str, true);
      }
    }
    label1114:
    label1122:
    do
    {
      if (!bool) {
        QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|ret=" + ayrd.b(this.a) + ",cost=" + l + ",url=" + ayqt.a(this.a.jdField_b_of_type_Ayqt).toString());
      }
      localObject = this.a.jdField_b_of_type_Ayqt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_b_of_type_Ayqt.jdField_a_of_type_Aywc.c, this.a.jdField_b_of_type_Ayqt.jdField_a_of_type_Aywc.jdField_a_of_type_Int, this.a.jdField_b_of_type_Ayqt.jdField_a_of_type_Aywc.jdField_a_of_type_Long);
      if ((localObject != null) && ((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
      {
        localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
        str = (String)ayqt.a(this.a.jdField_b_of_type_Ayqt).get("targetUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mMsgUrl = str;
        }
        str = (String)ayqt.a(this.a.jdField_b_of_type_Ayqt).get("sourceUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mSourceUrl = str;
        }
        str = (String)ayqt.a(this.a.jdField_b_of_type_Ayqt).get("sourceIcon");
        if (str != null) {
          ((AbsShareMsg)localObject).mSourceIcon = str;
        }
        str = (String)ayqt.a(this.a.jdField_b_of_type_Ayqt).get("audioUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mContentSrc = str;
        }
        str = (String)ayqt.a(this.a.jdField_b_of_type_Ayqt).get("imageUrl");
        if (str != null)
        {
          ((AbsShareMsg)localObject).shareData.imageUrlStatus = 1;
          ((AbsShareMsg)localObject).updateCover(str);
        }
        if (ayqt.c(this.a.jdField_b_of_type_Ayqt).get()) {
          ((AbsShareMsg)localObject).shareData.shortUrlStatus = 1;
        }
        this.a.jdField_b_of_type_Ayqt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Ayqt.jdField_a_of_type_Aywc.c, this.a.jdField_b_of_type_Ayqt.jdField_a_of_type_Aywc.jdField_a_of_type_Int, this.a.jdField_b_of_type_Ayqt.jdField_a_of_type_Aywc.jdField_a_of_type_Long, ((AbsShareMsg)localObject).getBytes());
      }
      this.a.b();
      return;
      i = ayqt.a(this.a.jdField_b_of_type_Ayqt).length();
      break;
      localObject = "1";
      break label425;
      if ((ayrd.b(this.a).get() == 100000) && (ayqt.c(this.a.jdField_b_of_type_Ayqt) < 2))
      {
        ayqt.d(this.a.jdField_b_of_type_Ayqt);
        ayqt.d(this.a.jdField_b_of_type_Ayqt, null);
        ayqt.a(this.a.jdField_b_of_type_Ayqt, true);
        ayqt.a(this.a.jdField_b_of_type_Ayqt);
        return;
      }
    } while ((ayrd.b(this.a).get() != -1) || (ayrd.a(this.a).getAndIncrement() >= 2));
    ThreadManager.post(this, 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.UrlExchangeStep.1
 * JD-Core Version:    0.7.0.1
 */