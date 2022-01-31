package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import android.text.TextUtils;
import aqgh;
import ayqr;
import ayrb;
import aywa;
import bded;
import bdhy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import nam;

public class ForwardSdkShareProcessor$UrlExchangeStep$1
  implements Runnable
{
  public ForwardSdkShareProcessor$UrlExchangeStep$1(ayrb paramayrb) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "UrlExchangeStep|run,retry=" + ayrb.a(this.a));
    }
    if (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.a.f();
      return;
    }
    Object localObject = new Bundle();
    String str = this.a.jdField_b_of_type_Ayqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    int i;
    long l;
    boolean bool;
    if ((!ayqr.b(this.a.jdField_b_of_type_Ayqr).get()) && (TextUtils.isEmpty(ayqr.a(this.a.jdField_b_of_type_Ayqr))))
    {
      i = 0;
      ((Bundle)localObject).putString("report_type", "102");
      ((Bundle)localObject).putString("act_type", "52");
      ((Bundle)localObject).putString("intext_3", "0");
      ((Bundle)localObject).putString("stringext_1", ayqr.e(this.a.jdField_b_of_type_Ayqr));
      ((Bundle)localObject).putString("intext_4", "" + i);
      bded.a().a((Bundle)localObject, "", str, false);
      l = System.currentTimeMillis();
      aqgh.a("batch_url_exchange");
      localObject = new Bundle();
      HashMap localHashMap = nam.a(this.a.jdField_b_of_type_Ayqr.jdField_a_of_type_AndroidContentContext, str, ayqr.f(this.a.jdField_b_of_type_Ayqr), 1, ayqr.a(this.a.jdField_b_of_type_Ayqr), (Bundle)localObject);
      l = System.currentTimeMillis() - l;
      bool = ((Bundle)localObject).getBoolean("isSuccess");
      i = ((Bundle)localObject).getInt("retcode", -1);
      ayrb.b(this.a).set(i);
      localObject = new HashMap();
      ((HashMap)localObject).put("param_ret_code", Integer.toString(i));
      aqgh.a("batch_url_exchange", str, (HashMap)localObject, bool);
      if (QLog.isColorLevel()) {
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, "UrlExchangeStep|run,suc=" + bool + ",ret=" + ayrb.b(this.a) + ",cost=" + l);
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
      localBundle.putString("intext_2", "" + ayrb.b(this.a));
      localBundle.putString("intext_5", "" + l);
      if (!bool) {
        localBundle.putString("stringext_1", ayqr.e(this.a.jdField_b_of_type_Ayqr));
      }
      bded.a().a(localBundle, "", str, false);
      if (!bool) {
        break label1122;
      }
      ayqr.a(this.a.jdField_b_of_type_Ayqr).putAll(localHashMap);
      ayqr.c(this.a.jdField_b_of_type_Ayqr).set(true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, "UrlExchangeStep|run,url=" + ayqr.a(this.a.jdField_b_of_type_Ayqr).toString());
      }
      localObject = (String)ayqr.a(this.a.jdField_b_of_type_Ayqr).get("imageUrl");
      if (localObject != null)
      {
        aqgh.a("reuse_image_for_aio");
        bdhy.a(false, ayqr.a(this.a.jdField_b_of_type_Ayqr), ayqr.a(this.a.jdField_b_of_type_Ayqr), (String)localObject);
        aqgh.a("reuse_image_for_aio", str, true);
      }
    }
    label1114:
    label1122:
    do
    {
      if (!bool) {
        QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|ret=" + ayrb.b(this.a) + ",cost=" + l + ",url=" + ayqr.a(this.a.jdField_b_of_type_Ayqr).toString());
      }
      localObject = this.a.jdField_b_of_type_Ayqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_b_of_type_Ayqr.jdField_a_of_type_Aywa.c, this.a.jdField_b_of_type_Ayqr.jdField_a_of_type_Aywa.jdField_a_of_type_Int, this.a.jdField_b_of_type_Ayqr.jdField_a_of_type_Aywa.jdField_a_of_type_Long);
      if ((localObject != null) && ((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
      {
        localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
        str = (String)ayqr.a(this.a.jdField_b_of_type_Ayqr).get("targetUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mMsgUrl = str;
        }
        str = (String)ayqr.a(this.a.jdField_b_of_type_Ayqr).get("sourceUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mSourceUrl = str;
        }
        str = (String)ayqr.a(this.a.jdField_b_of_type_Ayqr).get("sourceIcon");
        if (str != null) {
          ((AbsShareMsg)localObject).mSourceIcon = str;
        }
        str = (String)ayqr.a(this.a.jdField_b_of_type_Ayqr).get("audioUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mContentSrc = str;
        }
        str = (String)ayqr.a(this.a.jdField_b_of_type_Ayqr).get("imageUrl");
        if (str != null)
        {
          ((AbsShareMsg)localObject).shareData.imageUrlStatus = 1;
          ((AbsShareMsg)localObject).updateCover(str);
        }
        if (ayqr.c(this.a.jdField_b_of_type_Ayqr).get()) {
          ((AbsShareMsg)localObject).shareData.shortUrlStatus = 1;
        }
        this.a.jdField_b_of_type_Ayqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Ayqr.jdField_a_of_type_Aywa.c, this.a.jdField_b_of_type_Ayqr.jdField_a_of_type_Aywa.jdField_a_of_type_Int, this.a.jdField_b_of_type_Ayqr.jdField_a_of_type_Aywa.jdField_a_of_type_Long, ((AbsShareMsg)localObject).getBytes());
      }
      this.a.b();
      return;
      i = ayqr.a(this.a.jdField_b_of_type_Ayqr).length();
      break;
      localObject = "1";
      break label425;
      if ((ayrb.b(this.a).get() == 100000) && (ayqr.c(this.a.jdField_b_of_type_Ayqr) < 2))
      {
        ayqr.d(this.a.jdField_b_of_type_Ayqr);
        ayqr.d(this.a.jdField_b_of_type_Ayqr, null);
        ayqr.a(this.a.jdField_b_of_type_Ayqr, true);
        ayqr.a(this.a.jdField_b_of_type_Ayqr);
        return;
      }
    } while ((ayrb.b(this.a).get() != -1) || (ayrb.a(this.a).getAndIncrement() >= 2));
    ThreadManager.post(this, 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.UrlExchangeStep.1
 * JD-Core Version:    0.7.0.1
 */