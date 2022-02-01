package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import android.text.TextUtils;
import avcw;
import betj;
import bett;
import beyg;
import bjqh;
import bjuc;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import nnr;

public class ForwardSdkShareProcessor$UrlExchangeStep$1
  implements Runnable
{
  public ForwardSdkShareProcessor$UrlExchangeStep$1(bett parambett) {}
  
  public void run()
  {
    this.a.a("UrlExchangeStep|run,retry=" + bett.a(this.a));
    if (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.a.f();
      return;
    }
    Object localObject = new Bundle();
    String str = this.a.jdField_b_of_type_Betj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    int i;
    long l;
    boolean bool;
    if ((!betj.a(this.a.jdField_b_of_type_Betj).get()) && (TextUtils.isEmpty(this.a.jdField_b_of_type_Betj.e)))
    {
      i = 0;
      ((Bundle)localObject).putString("report_type", "102");
      ((Bundle)localObject).putString("act_type", "52");
      ((Bundle)localObject).putString("intext_3", "0");
      ((Bundle)localObject).putString("stringext_1", this.a.jdField_b_of_type_Betj.jdField_a_of_type_JavaLangString);
      ((Bundle)localObject).putString("intext_4", "" + i);
      bjqh.a().a((Bundle)localObject, "", str, false);
      l = System.currentTimeMillis();
      avcw.a("batch_url_exchange");
      localObject = new Bundle();
      HashMap localHashMap = nnr.a(this.a.jdField_b_of_type_Betj.jdField_a_of_type_AndroidContentContext, str, betj.a(this.a.jdField_b_of_type_Betj), 1, this.a.jdField_b_of_type_Betj.b, (Bundle)localObject);
      l = System.currentTimeMillis() - l;
      bool = ((Bundle)localObject).getBoolean("isSuccess");
      i = ((Bundle)localObject).getInt("retcode", -1);
      bett.b(this.a).set(i);
      localObject = new HashMap();
      ((HashMap)localObject).put("param_ret_code", Integer.toString(i));
      avcw.a("batch_url_exchange", str, (HashMap)localObject, bool);
      this.a.a("UrlExchangeStep|run,suc=" + bool + ",ret=" + bett.b(this.a) + ",cost=" + l);
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
      localBundle.putString("intext_2", "" + bett.b(this.a));
      localBundle.putString("intext_5", "" + l);
      if (!bool) {
        localBundle.putString("stringext_1", this.a.jdField_b_of_type_Betj.jdField_a_of_type_JavaLangString);
      }
      bjqh.a().a(localBundle, "", str, false);
      if (!bool) {
        break label1107;
      }
      this.a.jdField_b_of_type_Betj.b.putAll(localHashMap);
      this.a.jdField_b_of_type_Betj.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.a.a("UrlExchangeStep|run,url=" + this.a.jdField_b_of_type_Betj.b.toString());
      localObject = (String)this.a.jdField_b_of_type_Betj.b.get("imageUrl");
      if (localObject != null)
      {
        avcw.a("reuse_image_for_aio");
        bjuc.a(false, this.a.jdField_b_of_type_Betj.e, this.a.jdField_b_of_type_Betj.e, (String)localObject);
        avcw.a("reuse_image_for_aio", str, true);
      }
    }
    label1099:
    label1107:
    do
    {
      if (!bool) {
        QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|ret=" + bett.b(this.a) + ",cost=" + l + ",url=" + this.a.jdField_b_of_type_Betj.b.toString());
      }
      localObject = this.a.jdField_b_of_type_Betj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_b_of_type_Betj.jdField_a_of_type_Beyg.c, this.a.jdField_b_of_type_Betj.jdField_a_of_type_Beyg.jdField_a_of_type_Int, this.a.jdField_b_of_type_Betj.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
      if ((localObject != null) && ((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
      {
        localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
        str = (String)this.a.jdField_b_of_type_Betj.b.get("targetUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mMsgUrl = str;
        }
        str = (String)this.a.jdField_b_of_type_Betj.b.get("sourceUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mSourceUrl = str;
        }
        str = (String)this.a.jdField_b_of_type_Betj.b.get("sourceIcon");
        if (str != null) {
          ((AbsShareMsg)localObject).mSourceIcon = str;
        }
        str = (String)this.a.jdField_b_of_type_Betj.b.get("audioUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mContentSrc = str;
        }
        str = (String)this.a.jdField_b_of_type_Betj.b.get("imageUrl");
        if (str != null)
        {
          ((AbsShareMsg)localObject).shareData.imageUrlStatus = 1;
          ((AbsShareMsg)localObject).updateCover(str);
        }
        if (this.a.jdField_b_of_type_Betj.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          ((AbsShareMsg)localObject).shareData.shortUrlStatus = 1;
        }
        this.a.jdField_b_of_type_Betj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Betj.jdField_a_of_type_Beyg.c, this.a.jdField_b_of_type_Betj.jdField_a_of_type_Beyg.jdField_a_of_type_Int, this.a.jdField_b_of_type_Betj.jdField_a_of_type_Beyg.jdField_a_of_type_Long, ((AbsShareMsg)localObject).getBytes());
      }
      this.a.b();
      return;
      i = this.a.jdField_b_of_type_Betj.e.length();
      break;
      localObject = "1";
      break label415;
      if ((bett.b(this.a).get() == 100000) && (betj.b(this.a.jdField_b_of_type_Betj) < 2))
      {
        betj.c(this.a.jdField_b_of_type_Betj);
        betj.a(this.a.jdField_b_of_type_Betj, null);
        betj.a(this.a.jdField_b_of_type_Betj, true);
        betj.a(this.a.jdField_b_of_type_Betj);
        return;
      }
    } while ((bett.b(this.a).get() != -1) || (bett.a(this.a).getAndIncrement() >= 2));
    ThreadManager.post(this, 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.UrlExchangeStep.1
 * JD-Core Version:    0.7.0.1
 */