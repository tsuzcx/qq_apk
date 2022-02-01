package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import avcw;
import betj;
import betp;
import beyg;
import bjuc;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

public class ForwardSdkShareProcessor$ImageUploadStep$1
  implements Runnable
{
  public ForwardSdkShareProcessor$ImageUploadStep$1(betp parambetp) {}
  
  public void run()
  {
    int j = 0;
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "ImageUploadStep|run|retry=" + betp.a(this.a));
    if (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.a.f();
      return;
    }
    String str = this.a.jdField_b_of_type_Betj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    long l = System.currentTimeMillis();
    int i;
    byte b;
    if ((!TextUtils.isEmpty(this.a.jdField_b_of_type_Betj.d)) && (TextUtils.isEmpty(this.a.jdField_b_of_type_Betj.e)))
    {
      i = 1;
      if (i == 0) {
        break label156;
      }
      b = 2;
    }
    Object localObject1;
    label156:
    Object localObject2;
    boolean bool;
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = this.a.jdField_b_of_type_Betj.d;
        if (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          this.a.f();
          return;
          i = 0;
          break;
          b = 4;
          continue;
        }
        localObject2 = this.a.a((String)localObject1, l);
        if (!TextUtils.isEmpty((CharSequence)((Pair)localObject2).second))
        {
          this.a.jdField_b_of_type_Betj.e = ((String)((Pair)localObject2).second);
          betj.a(this.a.jdField_b_of_type_Betj).set(true);
          bool = true;
          i = j;
          if (!bool) {}
        }
        else
        {
          try
          {
            localObject2 = new File((String)localObject1).toURL().toString();
            localObject1 = localObject2;
          }
          catch (MalformedURLException localMalformedURLException)
          {
            for (;;)
            {
              QLog.d("Q.share.ForwardSdkShareProcessor", 1, "srcPath to URL err:" + localMalformedURLException.getMessage());
            }
          }
          avcw.a("reuse_image_for_aio");
          bjuc.a(true, (String)localObject1, this.a.jdField_b_of_type_Betj.d, this.a.jdField_b_of_type_Betj.e);
          avcw.a("reuse_image_for_aio", str, true);
          b = 1;
        }
      }
    }
    for (;;)
    {
      localObject1 = this.a.jdField_b_of_type_Betj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_b_of_type_Betj.jdField_a_of_type_Beyg.c, this.a.jdField_b_of_type_Betj.jdField_a_of_type_Beyg.jdField_a_of_type_Int, this.a.jdField_b_of_type_Betj.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
      if (((localObject1 instanceof MessageForStructing)) && ((((MessageForStructing)localObject1).structingMsg instanceof AbsShareMsg)))
      {
        localObject1 = (AbsShareMsg)((MessageForStructing)localObject1).structingMsg;
        ((AbsShareMsg)localObject1).updateCover(this.a.jdField_b_of_type_Betj.e);
        ((AbsShareMsg)localObject1).shareData.imageUrlStatus = b;
        this.a.jdField_b_of_type_Betj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Betj.jdField_a_of_type_Beyg.c, this.a.jdField_b_of_type_Betj.jdField_a_of_type_Beyg.jdField_a_of_type_Int, this.a.jdField_b_of_type_Betj.jdField_a_of_type_Beyg.jdField_a_of_type_Long, ((AbsShareMsg)localObject1).getBytes());
      }
      betj.b(this.a.jdField_b_of_type_Betj).set(true);
      this.a.b();
      return;
      if (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        this.a.f();
        return;
      }
      localObject2 = this.a.a(l);
      i = ((Integer)((Pair)localObject2).first).intValue();
      bool = ((Boolean)((Pair)localObject2).second).booleanValue();
      break;
      if ((i == 100000) && (betj.b(this.a.jdField_b_of_type_Betj) < 2))
      {
        betj.c(this.a.jdField_b_of_type_Betj);
        betj.a(this.a.jdField_b_of_type_Betj, null);
        betj.a(this.a.jdField_b_of_type_Betj, true);
        betj.a(this.a.jdField_b_of_type_Betj);
        return;
      }
      if (betp.b(this.a) < 2)
      {
        ThreadManager.post(this, 8, null, true);
        return;
      }
      this.a.jdField_b_of_type_Betj.b(9402, "upload share thumbnail fail");
      this.a.c();
      return;
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, "skip ImageUploadStep change remote url : " + this.a.jdField_b_of_type_Betj.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ImageUploadStep.1
 * JD-Core Version:    0.7.0.1
 */