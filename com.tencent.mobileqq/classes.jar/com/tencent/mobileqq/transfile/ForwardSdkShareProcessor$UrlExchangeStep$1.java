package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import android.text.TextUtils;
import aseh;
import basx;
import bath;
import bayk;
import bfhz;
import bflu;
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
  public ForwardSdkShareProcessor$UrlExchangeStep$1(bath parambath) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "UrlExchangeStep|run,retry=" + bath.a(this.a));
    }
    if (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.a.f();
      return;
    }
    Object localObject = new Bundle();
    String str = this.a.jdField_b_of_type_Basx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    int i;
    long l;
    boolean bool;
    if ((!basx.b(this.a.jdField_b_of_type_Basx).get()) && (TextUtils.isEmpty(basx.a(this.a.jdField_b_of_type_Basx))))
    {
      i = 0;
      ((Bundle)localObject).putString("report_type", "102");
      ((Bundle)localObject).putString("act_type", "52");
      ((Bundle)localObject).putString("intext_3", "0");
      ((Bundle)localObject).putString("stringext_1", basx.e(this.a.jdField_b_of_type_Basx));
      ((Bundle)localObject).putString("intext_4", "" + i);
      bfhz.a().a((Bundle)localObject, "", str, false);
      l = System.currentTimeMillis();
      aseh.a("batch_url_exchange");
      localObject = new Bundle();
      HashMap localHashMap = ndd.a(this.a.jdField_b_of_type_Basx.jdField_a_of_type_AndroidContentContext, str, basx.f(this.a.jdField_b_of_type_Basx), 1, basx.a(this.a.jdField_b_of_type_Basx), (Bundle)localObject);
      l = System.currentTimeMillis() - l;
      bool = ((Bundle)localObject).getBoolean("isSuccess");
      i = ((Bundle)localObject).getInt("retcode", -1);
      bath.b(this.a).set(i);
      localObject = new HashMap();
      ((HashMap)localObject).put("param_ret_code", Integer.toString(i));
      aseh.a("batch_url_exchange", str, (HashMap)localObject, bool);
      if (QLog.isColorLevel()) {
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, "UrlExchangeStep|run,suc=" + bool + ",ret=" + bath.b(this.a) + ",cost=" + l);
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
      localBundle.putString("intext_2", "" + bath.b(this.a));
      localBundle.putString("intext_5", "" + l);
      if (!bool) {
        localBundle.putString("stringext_1", basx.e(this.a.jdField_b_of_type_Basx));
      }
      bfhz.a().a(localBundle, "", str, false);
      if (!bool) {
        break label1122;
      }
      basx.a(this.a.jdField_b_of_type_Basx).putAll(localHashMap);
      basx.c(this.a.jdField_b_of_type_Basx).set(true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, "UrlExchangeStep|run,url=" + basx.a(this.a.jdField_b_of_type_Basx).toString());
      }
      localObject = (String)basx.a(this.a.jdField_b_of_type_Basx).get("imageUrl");
      if (localObject != null)
      {
        aseh.a("reuse_image_for_aio");
        bflu.a(false, basx.a(this.a.jdField_b_of_type_Basx), basx.a(this.a.jdField_b_of_type_Basx), (String)localObject);
        aseh.a("reuse_image_for_aio", str, true);
      }
    }
    label1114:
    label1122:
    do
    {
      if (!bool) {
        QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|ret=" + bath.b(this.a) + ",cost=" + l + ",url=" + basx.a(this.a.jdField_b_of_type_Basx).toString());
      }
      localObject = this.a.jdField_b_of_type_Basx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_b_of_type_Basx.jdField_a_of_type_Bayk.c, this.a.jdField_b_of_type_Basx.jdField_a_of_type_Bayk.jdField_a_of_type_Int, this.a.jdField_b_of_type_Basx.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
      if ((localObject != null) && ((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
      {
        localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
        str = (String)basx.a(this.a.jdField_b_of_type_Basx).get("targetUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mMsgUrl = str;
        }
        str = (String)basx.a(this.a.jdField_b_of_type_Basx).get("sourceUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mSourceUrl = str;
        }
        str = (String)basx.a(this.a.jdField_b_of_type_Basx).get("sourceIcon");
        if (str != null) {
          ((AbsShareMsg)localObject).mSourceIcon = str;
        }
        str = (String)basx.a(this.a.jdField_b_of_type_Basx).get("audioUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mContentSrc = str;
        }
        str = (String)basx.a(this.a.jdField_b_of_type_Basx).get("imageUrl");
        if (str != null)
        {
          ((AbsShareMsg)localObject).shareData.imageUrlStatus = 1;
          ((AbsShareMsg)localObject).updateCover(str);
        }
        if (basx.c(this.a.jdField_b_of_type_Basx).get()) {
          ((AbsShareMsg)localObject).shareData.shortUrlStatus = 1;
        }
        this.a.jdField_b_of_type_Basx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Basx.jdField_a_of_type_Bayk.c, this.a.jdField_b_of_type_Basx.jdField_a_of_type_Bayk.jdField_a_of_type_Int, this.a.jdField_b_of_type_Basx.jdField_a_of_type_Bayk.jdField_a_of_type_Long, ((AbsShareMsg)localObject).getBytes());
      }
      this.a.b();
      return;
      i = basx.a(this.a.jdField_b_of_type_Basx).length();
      break;
      localObject = "1";
      break label425;
      if ((bath.b(this.a).get() == 100000) && (basx.c(this.a.jdField_b_of_type_Basx) < 2))
      {
        basx.d(this.a.jdField_b_of_type_Basx);
        basx.d(this.a.jdField_b_of_type_Basx, null);
        basx.a(this.a.jdField_b_of_type_Basx, true);
        basx.a(this.a.jdField_b_of_type_Basx);
        return;
      }
    } while ((bath.b(this.a).get() != -1) || (bath.a(this.a).getAndIncrement() >= 2));
    ThreadManager.post(this, 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.UrlExchangeStep.1
 * JD-Core Version:    0.7.0.1
 */