package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import android.text.TextUtils;
import aukw;
import bdup;
import bduz;
import bdzn;
import bipi;
import bitd;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import nlw;

public class ForwardSdkShareProcessor$UrlExchangeStep$1
  implements Runnable
{
  public ForwardSdkShareProcessor$UrlExchangeStep$1(bduz parambduz) {}
  
  public void run()
  {
    this.a.a("UrlExchangeStep|run,retry=" + bduz.a(this.a));
    if (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.a.f();
      return;
    }
    Object localObject = new Bundle();
    String str = this.a.jdField_b_of_type_Bdup.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    int i;
    long l;
    boolean bool;
    if ((!bdup.a(this.a.jdField_b_of_type_Bdup).get()) && (TextUtils.isEmpty(bdup.a(this.a.jdField_b_of_type_Bdup))))
    {
      i = 0;
      ((Bundle)localObject).putString("report_type", "102");
      ((Bundle)localObject).putString("act_type", "52");
      ((Bundle)localObject).putString("intext_3", "0");
      ((Bundle)localObject).putString("stringext_1", bdup.e(this.a.jdField_b_of_type_Bdup));
      ((Bundle)localObject).putString("intext_4", "" + i);
      bipi.a().a((Bundle)localObject, "", str, false);
      l = System.currentTimeMillis();
      aukw.a("batch_url_exchange");
      localObject = new Bundle();
      HashMap localHashMap = nlw.a(this.a.jdField_b_of_type_Bdup.jdField_a_of_type_AndroidContentContext, str, bdup.f(this.a.jdField_b_of_type_Bdup), 1, bdup.a(this.a.jdField_b_of_type_Bdup), (Bundle)localObject);
      l = System.currentTimeMillis() - l;
      bool = ((Bundle)localObject).getBoolean("isSuccess");
      i = ((Bundle)localObject).getInt("retcode", -1);
      bduz.b(this.a).set(i);
      localObject = new HashMap();
      ((HashMap)localObject).put("param_ret_code", Integer.toString(i));
      aukw.a("batch_url_exchange", str, (HashMap)localObject, bool);
      this.a.a("UrlExchangeStep|run,suc=" + bool + ",ret=" + bduz.b(this.a) + ",cost=" + l);
      Bundle localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "12");
      localBundle.putString("intext_3", "0");
      if (!bool) {
        break label1099;
      }
      localObject = "0";
      label415:
      localBundle.putString("intext_1", (String)localObject);
      localBundle.putString("intext_2", "" + bduz.b(this.a));
      localBundle.putString("intext_5", "" + l);
      if (!bool) {
        localBundle.putString("stringext_1", bdup.e(this.a.jdField_b_of_type_Bdup));
      }
      bipi.a().a(localBundle, "", str, false);
      if (!bool) {
        break label1107;
      }
      bdup.a(this.a.jdField_b_of_type_Bdup).putAll(localHashMap);
      bdup.c(this.a.jdField_b_of_type_Bdup).set(true);
      this.a.a("UrlExchangeStep|run,url=" + bdup.a(this.a.jdField_b_of_type_Bdup).toString());
      localObject = (String)bdup.a(this.a.jdField_b_of_type_Bdup).get("imageUrl");
      if (localObject != null)
      {
        aukw.a("reuse_image_for_aio");
        bitd.a(false, bdup.a(this.a.jdField_b_of_type_Bdup), bdup.a(this.a.jdField_b_of_type_Bdup), (String)localObject);
        aukw.a("reuse_image_for_aio", str, true);
      }
    }
    label1099:
    label1107:
    do
    {
      if (!bool) {
        QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|ret=" + bduz.b(this.a) + ",cost=" + l + ",url=" + bdup.a(this.a.jdField_b_of_type_Bdup).toString());
      }
      localObject = this.a.jdField_b_of_type_Bdup.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_b_of_type_Bdup.jdField_a_of_type_Bdzn.c, this.a.jdField_b_of_type_Bdup.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, this.a.jdField_b_of_type_Bdup.jdField_a_of_type_Bdzn.jdField_a_of_type_Long);
      if ((localObject != null) && ((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
      {
        localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
        str = (String)bdup.a(this.a.jdField_b_of_type_Bdup).get("targetUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mMsgUrl = str;
        }
        str = (String)bdup.a(this.a.jdField_b_of_type_Bdup).get("sourceUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mSourceUrl = str;
        }
        str = (String)bdup.a(this.a.jdField_b_of_type_Bdup).get("sourceIcon");
        if (str != null) {
          ((AbsShareMsg)localObject).mSourceIcon = str;
        }
        str = (String)bdup.a(this.a.jdField_b_of_type_Bdup).get("audioUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mContentSrc = str;
        }
        str = (String)bdup.a(this.a.jdField_b_of_type_Bdup).get("imageUrl");
        if (str != null)
        {
          ((AbsShareMsg)localObject).shareData.imageUrlStatus = 1;
          ((AbsShareMsg)localObject).updateCover(str);
        }
        if (bdup.c(this.a.jdField_b_of_type_Bdup).get()) {
          ((AbsShareMsg)localObject).shareData.shortUrlStatus = 1;
        }
        this.a.jdField_b_of_type_Bdup.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Bdup.jdField_a_of_type_Bdzn.c, this.a.jdField_b_of_type_Bdup.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, this.a.jdField_b_of_type_Bdup.jdField_a_of_type_Bdzn.jdField_a_of_type_Long, ((AbsShareMsg)localObject).getBytes());
      }
      this.a.b();
      return;
      i = bdup.a(this.a.jdField_b_of_type_Bdup).length();
      break;
      localObject = "1";
      break label415;
      if ((bduz.b(this.a).get() == 100000) && (bdup.c(this.a.jdField_b_of_type_Bdup) < 2))
      {
        bdup.d(this.a.jdField_b_of_type_Bdup);
        bdup.d(this.a.jdField_b_of_type_Bdup, null);
        bdup.a(this.a.jdField_b_of_type_Bdup, true);
        bdup.a(this.a.jdField_b_of_type_Bdup);
        return;
      }
    } while ((bduz.b(this.a).get() != -1) || (bduz.a(this.a).getAndIncrement() >= 2));
    ThreadManager.post(this, 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.UrlExchangeStep.1
 * JD-Core Version:    0.7.0.1
 */