package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import android.text.TextUtils;
import axqk;
import axqu;
import axvt;
import bcad;
import bcdx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mpl;

public class ForwardSdkShareProcessor$UrlExchangeStep$1
  implements Runnable
{
  public ForwardSdkShareProcessor$UrlExchangeStep$1(axqu paramaxqu) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "UrlExchangeStep|run,retry=" + axqu.a(this.a));
    }
    if (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.a.f();
      return;
    }
    Object localObject = new Bundle();
    String str = this.a.jdField_b_of_type_Axqk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    int i;
    long l;
    boolean bool;
    if ((!axqk.b(this.a.jdField_b_of_type_Axqk).get()) && (TextUtils.isEmpty(axqk.a(this.a.jdField_b_of_type_Axqk))))
    {
      i = 0;
      ((Bundle)localObject).putString("report_type", "102");
      ((Bundle)localObject).putString("act_type", "52");
      ((Bundle)localObject).putString("intext_3", "0");
      ((Bundle)localObject).putString("stringext_1", axqk.e(this.a.jdField_b_of_type_Axqk));
      ((Bundle)localObject).putString("intext_4", "" + i);
      bcad.a().a((Bundle)localObject, "", str, false);
      l = System.currentTimeMillis();
      localObject = new Bundle();
      HashMap localHashMap = mpl.a(this.a.jdField_b_of_type_Axqk.jdField_a_of_type_AndroidContentContext, str, axqk.f(this.a.jdField_b_of_type_Axqk), 1, axqk.a(this.a.jdField_b_of_type_Axqk), (Bundle)localObject);
      l = System.currentTimeMillis() - l;
      bool = ((Bundle)localObject).getBoolean("isSuccess");
      axqu.b(this.a).set(((Bundle)localObject).getInt("retcode", -1));
      if (QLog.isColorLevel()) {
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, "UrlExchangeStep|run,suc=" + bool + ",ret=" + axqu.b(this.a) + ",cost=" + l);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "12");
      localBundle.putString("intext_3", "0");
      if (!bool) {
        break label1060;
      }
      localObject = "0";
      label386:
      localBundle.putString("intext_1", (String)localObject);
      localBundle.putString("intext_2", "" + axqu.b(this.a));
      localBundle.putString("intext_5", "" + l);
      if (!bool) {
        localBundle.putString("stringext_1", axqk.e(this.a.jdField_b_of_type_Axqk));
      }
      bcad.a().a(localBundle, "", str, false);
      if (!bool) {
        break label1068;
      }
      axqk.a(this.a.jdField_b_of_type_Axqk).putAll(localHashMap);
      axqk.c(this.a.jdField_b_of_type_Axqk).set(true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, "UrlExchangeStep|run,url=" + axqk.a(this.a.jdField_b_of_type_Axqk).toString());
      }
      localObject = (String)axqk.a(this.a.jdField_b_of_type_Axqk).get("imageUrl");
      if (localObject != null) {
        bcdx.a(false, axqk.a(this.a.jdField_b_of_type_Axqk), axqk.a(this.a.jdField_b_of_type_Axqk), (String)localObject);
      }
    }
    label1060:
    label1068:
    do
    {
      if (!bool) {
        QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|ret=" + axqu.b(this.a) + ",cost=" + l + ",url=" + axqk.a(this.a.jdField_b_of_type_Axqk).toString());
      }
      localObject = this.a.jdField_b_of_type_Axqk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_b_of_type_Axqk.jdField_a_of_type_Axvt.c, this.a.jdField_b_of_type_Axqk.jdField_a_of_type_Axvt.jdField_a_of_type_Int, this.a.jdField_b_of_type_Axqk.jdField_a_of_type_Axvt.jdField_a_of_type_Long);
      if ((localObject != null) && ((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
      {
        localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
        str = (String)axqk.a(this.a.jdField_b_of_type_Axqk).get("targetUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mMsgUrl = str;
        }
        str = (String)axqk.a(this.a.jdField_b_of_type_Axqk).get("sourceUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mSourceUrl = str;
        }
        str = (String)axqk.a(this.a.jdField_b_of_type_Axqk).get("sourceIcon");
        if (str != null) {
          ((AbsShareMsg)localObject).mSourceIcon = str;
        }
        str = (String)axqk.a(this.a.jdField_b_of_type_Axqk).get("audioUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mContentSrc = str;
        }
        str = (String)axqk.a(this.a.jdField_b_of_type_Axqk).get("imageUrl");
        if (str != null)
        {
          ((AbsShareMsg)localObject).shareData.imageUrlStatus = 1;
          ((AbsShareMsg)localObject).updateCover(str);
        }
        if (axqk.c(this.a.jdField_b_of_type_Axqk).get()) {
          ((AbsShareMsg)localObject).shareData.shortUrlStatus = 1;
        }
        this.a.jdField_b_of_type_Axqk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Axqk.jdField_a_of_type_Axvt.c, this.a.jdField_b_of_type_Axqk.jdField_a_of_type_Axvt.jdField_a_of_type_Int, this.a.jdField_b_of_type_Axqk.jdField_a_of_type_Axvt.jdField_a_of_type_Long, ((AbsShareMsg)localObject).getBytes());
      }
      this.a.b();
      return;
      i = axqk.a(this.a.jdField_b_of_type_Axqk).length();
      break;
      localObject = "1";
      break label386;
      if ((axqu.b(this.a).get() == 100000) && (axqk.c(this.a.jdField_b_of_type_Axqk) < 2))
      {
        axqk.d(this.a.jdField_b_of_type_Axqk);
        axqk.d(this.a.jdField_b_of_type_Axqk, null);
        axqk.a(this.a.jdField_b_of_type_Axqk, true);
        axqk.a(this.a.jdField_b_of_type_Axqk);
        return;
      }
    } while ((axqu.b(this.a).get() != -1) || (axqu.a(this.a).getAndIncrement() >= 2));
    ThreadManager.post(this, 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.UrlExchangeStep.1
 * JD-Core Version:    0.7.0.1
 */