package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import android.text.TextUtils;
import arzy;
import baoo;
import baoy;
import baub;
import bfdq;
import bfhl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import ndd;

public class ForwardSdkShareProcessor$UrlExchangeStep$1
  implements Runnable
{
  public ForwardSdkShareProcessor$UrlExchangeStep$1(baoy parambaoy) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "UrlExchangeStep|run,retry=" + baoy.a(this.a));
    }
    if (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.a.f();
      return;
    }
    Object localObject = new Bundle();
    String str = this.a.jdField_b_of_type_Baoo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    int i;
    long l;
    boolean bool;
    if ((!baoo.b(this.a.jdField_b_of_type_Baoo).get()) && (TextUtils.isEmpty(baoo.a(this.a.jdField_b_of_type_Baoo))))
    {
      i = 0;
      ((Bundle)localObject).putString("report_type", "102");
      ((Bundle)localObject).putString("act_type", "52");
      ((Bundle)localObject).putString("intext_3", "0");
      ((Bundle)localObject).putString("stringext_1", baoo.e(this.a.jdField_b_of_type_Baoo));
      ((Bundle)localObject).putString("intext_4", "" + i);
      bfdq.a().a((Bundle)localObject, "", str, false);
      l = System.currentTimeMillis();
      arzy.a("batch_url_exchange");
      localObject = new Bundle();
      HashMap localHashMap = ndd.a(this.a.jdField_b_of_type_Baoo.jdField_a_of_type_AndroidContentContext, str, baoo.f(this.a.jdField_b_of_type_Baoo), 1, baoo.a(this.a.jdField_b_of_type_Baoo), (Bundle)localObject);
      l = System.currentTimeMillis() - l;
      bool = ((Bundle)localObject).getBoolean("isSuccess");
      i = ((Bundle)localObject).getInt("retcode", -1);
      baoy.b(this.a).set(i);
      localObject = new HashMap();
      ((HashMap)localObject).put("param_ret_code", Integer.toString(i));
      arzy.a("batch_url_exchange", str, (HashMap)localObject, bool);
      if (QLog.isColorLevel()) {
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, "UrlExchangeStep|run,suc=" + bool + ",ret=" + baoy.b(this.a) + ",cost=" + l);
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
      localBundle.putString("intext_2", "" + baoy.b(this.a));
      localBundle.putString("intext_5", "" + l);
      if (!bool) {
        localBundle.putString("stringext_1", baoo.e(this.a.jdField_b_of_type_Baoo));
      }
      bfdq.a().a(localBundle, "", str, false);
      if (!bool) {
        break label1122;
      }
      baoo.a(this.a.jdField_b_of_type_Baoo).putAll(localHashMap);
      baoo.c(this.a.jdField_b_of_type_Baoo).set(true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, "UrlExchangeStep|run,url=" + baoo.a(this.a.jdField_b_of_type_Baoo).toString());
      }
      localObject = (String)baoo.a(this.a.jdField_b_of_type_Baoo).get("imageUrl");
      if (localObject != null)
      {
        arzy.a("reuse_image_for_aio");
        bfhl.a(false, baoo.a(this.a.jdField_b_of_type_Baoo), baoo.a(this.a.jdField_b_of_type_Baoo), (String)localObject);
        arzy.a("reuse_image_for_aio", str, true);
      }
    }
    label1114:
    label1122:
    do
    {
      if (!bool) {
        QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|ret=" + baoy.b(this.a) + ",cost=" + l + ",url=" + baoo.a(this.a.jdField_b_of_type_Baoo).toString());
      }
      localObject = this.a.jdField_b_of_type_Baoo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.c, this.a.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.jdField_a_of_type_Int, this.a.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.jdField_a_of_type_Long);
      if ((localObject != null) && ((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
      {
        localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
        str = (String)baoo.a(this.a.jdField_b_of_type_Baoo).get("targetUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mMsgUrl = str;
        }
        str = (String)baoo.a(this.a.jdField_b_of_type_Baoo).get("sourceUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mSourceUrl = str;
        }
        str = (String)baoo.a(this.a.jdField_b_of_type_Baoo).get("sourceIcon");
        if (str != null) {
          ((AbsShareMsg)localObject).mSourceIcon = str;
        }
        str = (String)baoo.a(this.a.jdField_b_of_type_Baoo).get("audioUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mContentSrc = str;
        }
        str = (String)baoo.a(this.a.jdField_b_of_type_Baoo).get("imageUrl");
        if (str != null)
        {
          ((AbsShareMsg)localObject).shareData.imageUrlStatus = 1;
          ((AbsShareMsg)localObject).updateCover(str);
        }
        if (baoo.c(this.a.jdField_b_of_type_Baoo).get()) {
          ((AbsShareMsg)localObject).shareData.shortUrlStatus = 1;
        }
        this.a.jdField_b_of_type_Baoo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.c, this.a.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.jdField_a_of_type_Int, this.a.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.jdField_a_of_type_Long, ((AbsShareMsg)localObject).getBytes());
      }
      this.a.b();
      return;
      i = baoo.a(this.a.jdField_b_of_type_Baoo).length();
      break;
      localObject = "1";
      break label425;
      if ((baoy.b(this.a).get() == 100000) && (baoo.c(this.a.jdField_b_of_type_Baoo) < 2))
      {
        baoo.d(this.a.jdField_b_of_type_Baoo);
        baoo.d(this.a.jdField_b_of_type_Baoo, null);
        baoo.a(this.a.jdField_b_of_type_Baoo, true);
        baoo.a(this.a.jdField_b_of_type_Baoo);
        return;
      }
    } while ((baoy.b(this.a).get() != -1) || (baoy.a(this.a).getAndIncrement() >= 2));
    ThreadManager.post(this, 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.UrlExchangeStep.1
 * JD-Core Version:    0.7.0.1
 */