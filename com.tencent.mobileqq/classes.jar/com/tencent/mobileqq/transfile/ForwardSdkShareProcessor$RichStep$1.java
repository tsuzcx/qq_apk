package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import android.text.TextUtils;
import ayvy;
import baoo;
import baov;
import baub;
import bfdq;
import bfhl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ForwardSdkShareProcessor$RichStep$1
  implements Runnable
{
  public ForwardSdkShareProcessor$RichStep$1(baov parambaov) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "RichStep|run|retry=" + baov.a(this.a));
    }
    if (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.a.f();
      return;
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putString("report_type", "102");
    ((Bundle)localObject1).putString("act_type", "53");
    ((Bundle)localObject1).putString("intext_4", "1");
    ((Bundle)localObject1).putString("intext_3", "0");
    ((Bundle)localObject1).putString("intext_2", "" + baoo.a(this.a.jdField_b_of_type_Baoo));
    ((Bundle)localObject1).putString("stringext_1", baoo.e(this.a.jdField_b_of_type_Baoo));
    bfdq.a().a((Bundle)localObject1, "", this.a.jdField_b_of_type_Baoo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    long l = System.currentTimeMillis();
    int j = -1;
    int n = baoo.a(this.a.jdField_b_of_type_Baoo);
    int i = j;
    for (;;)
    {
      try
      {
        Object localObject3 = bfhl.a(this.a.jdField_b_of_type_Baoo.jdField_a_of_type_AndroidContentContext, baoo.e(this.a.jdField_b_of_type_Baoo), this.a.jdField_b_of_type_Baoo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        i = j;
        int m = ((Integer)localObject3[0]).intValue();
        if (m != 0) {
          break label1353;
        }
        i = m;
        localObject1 = (String)localObject3[1];
        i = m;
        Object localObject2 = (String)localObject3[2];
        i = m;
        localObject3 = (String)localObject3[3];
        i = m;
        boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
        if (!bool)
        {
          j = 4;
          k = j;
          i = j;
        }
        int k = 0;
      }
      catch (Exception localException1)
      {
        try
        {
          if (TextUtils.isEmpty(baoo.d(this.a.jdField_b_of_type_Baoo)))
          {
            i = j;
            baoo.a(this.a.jdField_b_of_type_Baoo, baoo.a(this.a.jdField_b_of_type_Baoo) & 0xFFFFFFFB);
            i = j;
            baoo.a(this.a.jdField_b_of_type_Baoo, (String)localObject1);
            k = j;
          }
          j = k;
          i = k;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            k |= 0x2;
            j = k;
            i = k;
            if (TextUtils.isEmpty(baoo.c(this.a.jdField_b_of_type_Baoo)))
            {
              i = k;
              baoo.a(this.a.jdField_b_of_type_Baoo, baoo.a(this.a.jdField_b_of_type_Baoo) & 0xFFFFFFFD);
              i = k;
              baoo.b(this.a.jdField_b_of_type_Baoo, (String)localObject2);
              j = k;
            }
          }
          k = j;
          i = j;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            j |= 0x1;
            k = j;
            i = j;
            if (TextUtils.isEmpty(baoo.a(this.a.jdField_b_of_type_Baoo)))
            {
              k = j;
              i = j;
              if (TextUtils.isEmpty(baoo.b(this.a.jdField_b_of_type_Baoo)))
              {
                i = j;
                baoo.a(this.a.jdField_b_of_type_Baoo, baoo.a(this.a.jdField_b_of_type_Baoo) & 0xFFFFFFFE);
                i = j;
                baoo.c(this.a.jdField_b_of_type_Baoo, (String)localObject3);
                k = j;
              }
            }
          }
          i = k;
          baov.a(this.a).set(false);
          i = k;
          localObject1 = this.a.jdField_b_of_type_Baoo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.c, this.a.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.jdField_a_of_type_Int, this.a.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.jdField_a_of_type_Long);
          if (localObject1 != null)
          {
            i = k;
            if ((localObject1 instanceof MessageForStructing))
            {
              i = k;
              if ((((MessageForStructing)localObject1).structingMsg instanceof AbsShareMsg))
              {
                i = k;
                localObject1 = (AbsShareMsg)((MessageForStructing)localObject1).structingMsg;
                i = k;
                if (baoo.d(this.a.jdField_b_of_type_Baoo) != null)
                {
                  i = k;
                  ayvy.a(baoo.d(this.a.jdField_b_of_type_Baoo), false);
                }
                i = k;
                if (baoo.c(this.a.jdField_b_of_type_Baoo) != null)
                {
                  i = k;
                  ayvy.a(baoo.c(this.a.jdField_b_of_type_Baoo), false);
                }
                i = k;
                ((AbsShareMsg)localObject1).updateTitleSummaryAndCover(baoo.d(this.a.jdField_b_of_type_Baoo), baoo.c(this.a.jdField_b_of_type_Baoo), baoo.a(this.a.jdField_b_of_type_Baoo));
                i = k;
                this.a.jdField_b_of_type_Baoo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.c, this.a.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.jdField_a_of_type_Int, this.a.jdField_b_of_type_Baoo.jdField_a_of_type_Baub.jdField_a_of_type_Long, ((AbsShareMsg)localObject1).getBytes());
                i = k;
                this.a.jdField_b_of_type_Baoo.d(1002);
              }
            }
          }
          i = k;
          k = m;
          m = i;
          l = System.currentTimeMillis() - l;
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("report_type", "102");
          ((Bundle)localObject1).putString("act_type", "13");
          ((Bundle)localObject1).putString("intext_3", "0");
          localObject2 = new StringBuilder().append("");
          if (k == 0) {
            continue;
          }
          i = 1;
          ((Bundle)localObject1).putString("intext_1", i);
          ((Bundle)localObject1).putString("stringext_2", "" + k);
          ((Bundle)localObject1).putString("stringext_3", "1");
          ((Bundle)localObject1).putString("intext_5", "" + l);
          ((Bundle)localObject1).putString("intext_2", "" + n);
          ((Bundle)localObject1).putString("intext_4", "" + m);
          if (k != 0) {
            ((Bundle)localObject1).putString("stringext_1", baoo.e(this.a.jdField_b_of_type_Baoo));
          }
          bfdq.a().a((Bundle)localObject1, "", this.a.jdField_b_of_type_Baoo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
          if (QLog.isColorLevel())
          {
            localObject1 = "RichStep|run|ret=" + k + ",lack=" + baoo.a(this.a.jdField_b_of_type_Baoo) + ",cost=" + l;
            if ((k == 0) && (l <= 3000L)) {
              continue;
            }
            QLog.e("BaseTransProcessor", 2, (String)localObject1);
          }
          if (!baov.a(this.a).get()) {
            continue;
          }
          if ((k != -1) || (baov.a(this.a).getAndIncrement() >= 2)) {
            continue;
          }
          ThreadManager.post(this, 8, null, true);
          return;
        }
        catch (Exception localException2)
        {
          j = m;
          continue;
        }
        localException1 = localException1;
        k = 0;
        j = i;
        i = k;
        m = i;
        k = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.share.ForwardSdkShareProcessor", 4, localException1, new Object[0]);
        m = i;
        k = j;
        continue;
        i = 0;
        continue;
        QLog.d("BaseTransProcessor", 2, localException1);
        continue;
        baov.a(this.a).set(false);
        QLog.d("Q.share.ForwardSdkShareProcessor", 1, "RichStep|rich fail,lack=" + baoo.a(this.a.jdField_b_of_type_Baoo) + ",cost=" + l);
        this.a.a = true;
        this.a.b();
        return;
      }
      continue;
      label1353:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.RichStep.1
 * JD-Core Version:    0.7.0.1
 */