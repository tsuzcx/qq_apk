package com.tencent.mobileqq.pushdialog;

import OnlinePushPack.MsgInfo;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOAssist;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.UniteEntity;
import com.tencent.mobileqq.graytip.UniteEntity.Note;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x122.submsgtype0x122.MsgBody;

public class PushDialogHandler
{
  private static volatile PushDialogHandler jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogHandler;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
  
  private Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public static PushDialogHandler a()
  {
    if (jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogHandler == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogHandler == null) {
          jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogHandler = new PushDialogHandler();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqPushdialogPushDialogHandler;
  }
  
  private void a(long paramLong1, long paramLong2, submsgtype0x122.MsgBody paramMsgBody)
  {
    Object localObject1 = paramMsgBody.bytes_content.get().toByteArray();
    if (localObject1 != null)
    {
      paramMsgBody = null;
      try
      {
        localObject1 = new String((byte[])localObject1, "utf-8");
        if (QLog.isColorLevel()) {
          QLog.d("PushDialogHandler", 2, new Object[] { "configContent : ", localObject1 });
        }
        localObject1 = UniteGrayTipUtil.a((String)localObject1);
        paramMsgBody = (submsgtype0x122.MsgBody)localObject1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        QLog.e("PushDialogHandler", 1, "e:", localUnsupportedEncodingException);
      }
      if (paramMsgBody != null)
      {
        paramMsgBody = paramMsgBody.a();
        if (paramMsgBody.a() != 6)
        {
          QLog.e("PushDialogHandler", 1, new Object[] { "error note type:", Integer.valueOf(paramMsgBody.a()) });
          return;
        }
        paramMsgBody = paramMsgBody.a();
        if (paramMsgBody != null)
        {
          Iterator localIterator = paramMsgBody.iterator();
          Object localObject16 = "";
          Object localObject7 = "";
          Object localObject8 = localObject7;
          Object localObject9 = localObject8;
          Object localObject3 = localObject9;
          paramMsgBody = localObject3;
          Object localObject6 = paramMsgBody;
          Object localObject2 = localObject6;
          Object localObject4 = localObject2;
          Object localObject19;
          for (Object localObject5 = localObject4; localIterator.hasNext(); localObject5 = localObject19)
          {
            UniteEntity.Note localNote = (UniteEntity.Note)localIterator.next();
            localObject10 = localNote.a();
            Object localObject21 = localNote.a();
            Object localObject20;
            Object localObject18;
            Object localObject17;
            Object localObject15;
            Object localObject14;
            Object localObject13;
            Object localObject12;
            Object localObject11;
            if (localNote.a() == 7)
            {
              localObject20 = (String)((HashMap)localObject10).get(Integer.valueOf(2));
              localObject19 = localObject5;
              localObject18 = localObject4;
              localObject17 = localObject2;
              localObject15 = localObject6;
              localObject14 = paramMsgBody;
              localObject13 = localObject3;
              localObject12 = localObject9;
              localObject11 = localObject8;
              localObject10 = localObject7;
            }
            for (;;)
            {
              break;
              if (localNote.a() == 8)
              {
                localObject10 = (String)((HashMap)localObject10).get(Integer.valueOf(1));
                localObject20 = localObject16;
                localObject10 = localObject7;
                localObject11 = localObject8;
                localObject12 = localObject9;
                localObject13 = localObject3;
                localObject14 = paramMsgBody;
                localObject15 = localObject6;
                localObject17 = localObject2;
                localObject18 = localObject4;
                localObject19 = localObject5;
                if (localObject21 != null)
                {
                  localObject20 = localObject16;
                  localObject10 = localObject7;
                  localObject11 = localObject8;
                  localObject12 = localObject9;
                  localObject13 = localObject3;
                  localObject14 = paramMsgBody;
                  localObject15 = localObject6;
                  localObject17 = localObject2;
                  localObject18 = localObject4;
                  localObject19 = localObject5;
                  if (((List)localObject21).size() != 0)
                  {
                    localObject21 = ((List)localObject21).iterator();
                    for (;;)
                    {
                      localObject20 = localObject16;
                      localObject10 = localObject7;
                      localObject11 = localObject8;
                      localObject12 = localObject9;
                      localObject13 = localObject3;
                      localObject14 = paramMsgBody;
                      localObject15 = localObject6;
                      localObject17 = localObject2;
                      localObject18 = localObject4;
                      localObject19 = localObject5;
                      if (!((Iterator)localObject21).hasNext()) {
                        break;
                      }
                      localObject11 = (UniteEntity.Note)((Iterator)localObject21).next();
                      localObject10 = ((UniteEntity.Note)localObject11).a();
                      if (((UniteEntity.Note)localObject11).a() == 2)
                      {
                        if (localObject10 != null)
                        {
                          localObject10 = (String)((HashMap)localObject10).get(Integer.valueOf(2));
                          if (!TextUtils.isEmpty((CharSequence)localObject10)) {
                            localObject7 = localObject10;
                          }
                        }
                      }
                      else if ((((UniteEntity.Note)localObject11).a() == 3) && (localObject10 != null))
                      {
                        localObject8 = (String)((HashMap)localObject10).get(Integer.valueOf(2));
                        localObject9 = (String)((HashMap)localObject10).get(Integer.valueOf(4));
                      }
                    }
                  }
                }
              }
              else
              {
                localObject20 = localObject16;
                localObject10 = localObject7;
                localObject11 = localObject8;
                localObject12 = localObject9;
                localObject13 = localObject3;
                localObject14 = paramMsgBody;
                localObject15 = localObject6;
                localObject17 = localObject2;
                localObject18 = localObject4;
                localObject19 = localObject5;
                if (localNote.a() == 9)
                {
                  localObject20 = localObject16;
                  localObject10 = localObject7;
                  localObject11 = localObject8;
                  localObject12 = localObject9;
                  localObject13 = localObject3;
                  localObject14 = paramMsgBody;
                  localObject15 = localObject6;
                  localObject17 = localObject2;
                  localObject18 = localObject4;
                  localObject19 = localObject5;
                  if (localObject21 != null)
                  {
                    localObject21 = ((List)localObject21).iterator();
                    int i = 0;
                    for (;;)
                    {
                      localObject20 = localObject16;
                      localObject10 = localObject7;
                      localObject11 = localObject8;
                      localObject12 = localObject9;
                      localObject13 = localObject3;
                      localObject14 = paramMsgBody;
                      localObject15 = localObject6;
                      localObject17 = localObject2;
                      localObject18 = localObject4;
                      localObject19 = localObject5;
                      if (!((Iterator)localObject21).hasNext()) {
                        break;
                      }
                      localObject10 = (UniteEntity.Note)((Iterator)localObject21).next();
                      if (((UniteEntity.Note)localObject10).a() == 10)
                      {
                        localObject11 = ((UniteEntity.Note)localObject10).a();
                        localObject10 = (String)((HashMap)localObject11).get(Integer.valueOf(2));
                        localObject15 = (String)((HashMap)localObject11).get(Integer.valueOf(4));
                        if (i == 0)
                        {
                          localObject2 = localObject15;
                          localObject3 = localObject10;
                        }
                        for (;;)
                        {
                          localObject12 = localObject3;
                          localObject13 = paramMsgBody;
                          localObject14 = localObject6;
                          localObject6 = localObject2;
                          localObject11 = localObject4;
                          break label897;
                          if (i != 1) {
                            break;
                          }
                          localObject4 = localObject15;
                          paramMsgBody = (submsgtype0x122.MsgBody)localObject10;
                        }
                        localObject12 = localObject3;
                        localObject13 = paramMsgBody;
                        localObject14 = localObject6;
                        localObject6 = localObject2;
                        localObject11 = localObject4;
                        if (i == 2)
                        {
                          localObject5 = localObject15;
                          localObject11 = localObject4;
                          localObject6 = localObject2;
                          localObject14 = localObject10;
                          localObject13 = paramMsgBody;
                          localObject12 = localObject3;
                        }
                        label897:
                        i += 1;
                        localObject3 = localObject12;
                        paramMsgBody = (submsgtype0x122.MsgBody)localObject13;
                        localObject2 = localObject6;
                        localObject4 = localObject11;
                      }
                      else
                      {
                        localObject14 = localObject6;
                      }
                      localObject6 = localObject14;
                    }
                  }
                }
              }
            }
            localObject16 = localObject20;
            localObject7 = localObject10;
            localObject8 = localObject11;
            localObject9 = localObject12;
            localObject3 = localObject13;
            paramMsgBody = (submsgtype0x122.MsgBody)localObject14;
            localObject6 = localObject15;
            localObject2 = localObject17;
            localObject4 = localObject18;
          }
          Object localObject10 = new Intent();
          ((Intent)localObject10).putExtra("public_fragment_window_feature", 1);
          ((Intent)localObject10).putExtra("BusiType", paramLong2);
          ((Intent)localObject10).putExtra("Title", (String)localObject16);
          ((Intent)localObject10).putExtra("Message", (String)localObject7);
          ((Intent)localObject10).putExtra("contentUrlText", (String)localObject8);
          ((Intent)localObject10).putExtra("contentUrlValue", (String)localObject9);
          ((Intent)localObject10).putExtra("btnText1", localObject3);
          ((Intent)localObject10).putExtra("btnText2", paramMsgBody);
          ((Intent)localObject10).putExtra("btnText3", (String)localObject6);
          ((Intent)localObject10).putExtra("btnAction1", localObject2);
          ((Intent)localObject10).putExtra("btnAction2", localObject4);
          ((Intent)localObject10).putExtra("btnAction3", localObject5);
          QPublicFragmentActivity.Launcher.a((Intent)localObject10, QPublicTransFragmentActivity.class, ((ILoginRegisterApi)QRoute.api(ILoginRegisterApi.class)).getHintDlgFragment());
        }
      }
    }
  }
  
  public void a(submsgtype0x122.MsgBody paramMsgBody, MsgInfo paramMsgInfo, QQAppInterface paramQQAppInterface)
  {
    if (paramMsgBody.uint64_busi_type.has()) {
      paramMsgBody.uint64_busi_type.get();
    }
    boolean bool = paramMsgBody.uint64_busi_id.has();
    long l2 = 0L;
    if (bool) {
      l1 = paramMsgBody.uint64_busi_id.get();
    } else {
      l1 = 0L;
    }
    if (paramMsgBody.uint32_ctrl_flag.has()) {
      paramMsgBody.uint32_ctrl_flag.get();
    }
    if (paramMsgBody.uint32_c2c_type.has()) {
      paramMsgBody.uint32_c2c_type.get();
    }
    if (paramMsgBody.uint32_service_type.has()) {
      paramMsgBody.uint32_service_type.get();
    }
    byte[] arrayOfByte;
    if (paramMsgBody.bytes_content.has()) {
      arrayOfByte = paramMsgBody.bytes_content.get().toByteArray();
    } else {
      arrayOfByte = null;
    }
    if (paramMsgBody.uint64_templ_id.has()) {
      l2 = paramMsgBody.uint64_templ_id.get();
    }
    if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
      try
      {
        new String(arrayOfByte, "utf-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    } else if (QLog.isColorLevel()) {
      QLog.e("PushDialogHandler", 2, "handleC2COnlinePushMsgGrayTipResp fail content is null");
    }
    if (l1 == 1001L)
    {
      a(l1, l2, paramMsgBody);
      return;
    }
    long l1 = paramMsgInfo.getURealMsgTime();
    paramMsgBody = new PushDialogTemplate(paramMsgBody, paramMsgInfo.lFromUin, l1 * 1000L);
    if (a(paramQQAppInterface, paramMsgInfo))
    {
      paramMsgInfo = AIOAssist.a();
      if (paramMsgInfo != null)
      {
        a().post(new PushDialogHandler.1(this, paramMsgInfo, paramMsgBody));
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    PushDialogDbUtil.a().b(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, paramMsgBody);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, MsgInfo paramMsgInfo)
  {
    boolean bool2 = false;
    paramQQAppInterface = paramQQAppInterface.getMessageProxy(0).d(String.valueOf(paramMsgInfo.lFromUin), 0);
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (!paramQQAppInterface.isEmpty()) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.PushDialogHandler
 * JD-Core Version:    0.7.0.1
 */