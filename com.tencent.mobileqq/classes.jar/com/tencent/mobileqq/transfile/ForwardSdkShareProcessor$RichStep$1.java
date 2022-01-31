package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import android.text.TextUtils;
import azah;
import basx;
import bate;
import bayk;
import bfhz;
import bflu;
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
  public ForwardSdkShareProcessor$RichStep$1(bate parambate) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "RichStep|run|retry=" + bate.a(this.a));
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
    ((Bundle)localObject1).putString("intext_2", "" + basx.a(this.a.jdField_b_of_type_Basx));
    ((Bundle)localObject1).putString("stringext_1", basx.e(this.a.jdField_b_of_type_Basx));
    bfhz.a().a((Bundle)localObject1, "", this.a.jdField_b_of_type_Basx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    long l = System.currentTimeMillis();
    int j = -1;
    int n = basx.a(this.a.jdField_b_of_type_Basx);
    int i = j;
    for (;;)
    {
      try
      {
        Object localObject3 = bflu.a(this.a.jdField_b_of_type_Basx.jdField_a_of_type_AndroidContentContext, basx.e(this.a.jdField_b_of_type_Basx), this.a.jdField_b_of_type_Basx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
          if (TextUtils.isEmpty(basx.d(this.a.jdField_b_of_type_Basx)))
          {
            i = j;
            basx.a(this.a.jdField_b_of_type_Basx, basx.a(this.a.jdField_b_of_type_Basx) & 0xFFFFFFFB);
            i = j;
            basx.a(this.a.jdField_b_of_type_Basx, (String)localObject1);
            k = j;
          }
          j = k;
          i = k;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            k |= 0x2;
            j = k;
            i = k;
            if (TextUtils.isEmpty(basx.c(this.a.jdField_b_of_type_Basx)))
            {
              i = k;
              basx.a(this.a.jdField_b_of_type_Basx, basx.a(this.a.jdField_b_of_type_Basx) & 0xFFFFFFFD);
              i = k;
              basx.b(this.a.jdField_b_of_type_Basx, (String)localObject2);
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
            if (TextUtils.isEmpty(basx.a(this.a.jdField_b_of_type_Basx)))
            {
              k = j;
              i = j;
              if (TextUtils.isEmpty(basx.b(this.a.jdField_b_of_type_Basx)))
              {
                i = j;
                basx.a(this.a.jdField_b_of_type_Basx, basx.a(this.a.jdField_b_of_type_Basx) & 0xFFFFFFFE);
                i = j;
                basx.c(this.a.jdField_b_of_type_Basx, (String)localObject3);
                k = j;
              }
            }
          }
          i = k;
          bate.a(this.a).set(false);
          i = k;
          localObject1 = this.a.jdField_b_of_type_Basx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_b_of_type_Basx.jdField_a_of_type_Bayk.c, this.a.jdField_b_of_type_Basx.jdField_a_of_type_Bayk.jdField_a_of_type_Int, this.a.jdField_b_of_type_Basx.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
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
                if (basx.d(this.a.jdField_b_of_type_Basx) != null)
                {
                  i = k;
                  azah.a(basx.d(this.a.jdField_b_of_type_Basx), false);
                }
                i = k;
                if (basx.c(this.a.jdField_b_of_type_Basx) != null)
                {
                  i = k;
                  azah.a(basx.c(this.a.jdField_b_of_type_Basx), false);
                }
                i = k;
                ((AbsShareMsg)localObject1).updateTitleSummaryAndCover(basx.d(this.a.jdField_b_of_type_Basx), basx.c(this.a.jdField_b_of_type_Basx), basx.a(this.a.jdField_b_of_type_Basx));
                i = k;
                this.a.jdField_b_of_type_Basx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Basx.jdField_a_of_type_Bayk.c, this.a.jdField_b_of_type_Basx.jdField_a_of_type_Bayk.jdField_a_of_type_Int, this.a.jdField_b_of_type_Basx.jdField_a_of_type_Bayk.jdField_a_of_type_Long, ((AbsShareMsg)localObject1).getBytes());
                i = k;
                this.a.jdField_b_of_type_Basx.d(1002);
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
            ((Bundle)localObject1).putString("stringext_1", basx.e(this.a.jdField_b_of_type_Basx));
          }
          bfhz.a().a((Bundle)localObject1, "", this.a.jdField_b_of_type_Basx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
          if (QLog.isColorLevel())
          {
            localObject1 = "RichStep|run|ret=" + k + ",lack=" + basx.a(this.a.jdField_b_of_type_Basx) + ",cost=" + l;
            if ((k == 0) && (l <= 3000L)) {
              continue;
            }
            QLog.e("BaseTransProcessor", 2, (String)localObject1);
          }
          if (!bate.a(this.a).get()) {
            continue;
          }
          if ((k != -1) || (bate.a(this.a).getAndIncrement() >= 2)) {
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
        bate.a(this.a).set(false);
        QLog.d("Q.share.ForwardSdkShareProcessor", 1, "RichStep|rich fail,lack=" + basx.a(this.a.jdField_b_of_type_Basx) + ",cost=" + l);
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