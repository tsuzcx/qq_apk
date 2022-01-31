package com.tencent.mobileqq.util;

import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.GroupIconHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.avatar.dynamicavatar.VasFaceManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.VasManager.CompleteListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class FaceDecodeTaskImpl
  extends FaceDecodeTask
  implements VasManager.CompleteListener
{
  QQAppInterface a;
  
  public FaceDecodeTaskImpl(QQAppInterface paramQQAppInterface, FaceInfo paramFaceInfo, FaceDecodeTask.DecodeCompletionListener paramDecodeCompletionListener)
  {
    super(paramQQAppInterface, paramFaceInfo, paramDecodeCompletionListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  protected void a()
  {
    m = 0;
    j = 0;
    n = 1;
    k = 1;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.p);
    i = m;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int != 101)
      {
        i = m;
        if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int != 1001) {
          break label341;
        }
      }
      i = m;
      localDiscussionHandler = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
      i = m;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int != 1001) {
        break label149;
      }
      i = m;
      this.jdField_a_of_type_AndroidGraphicsBitmap = localDiscussionHandler.a(GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString), false);
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      Object localObject3;
      do
      {
        for (;;)
        {
          DiscussionHandler localDiscussionHandler;
          i = m;
          if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int != 4)
          {
            i = m;
            if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int != 113) {}
          }
          else
          {
            i = m;
            if (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString))
            {
              i = m;
              String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, (byte)this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.c, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int);
              i = m;
              this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(str);
              i = m;
              if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
              {
                i = m;
                k = HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                i = m;
                this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a(BaseApplicationImpl.sApplication.getResources(), k);
                i = m;
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(str, this.jdField_a_of_type_AndroidGraphicsBitmap, (byte)1);
              }
              this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.q);
              try
              {
                if (jdField_a_of_type_MqqOsMqqHandler == null) {
                  continue;
                }
                jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
                return;
              }
              catch (Exception localException3) {}
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, localException3);
              return;
            }
            i = m;
            if (!TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString))
            {
              i = m;
              this.jdField_a_of_type_AndroidGraphicsBitmap = ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, false);
              i = m;
              this.jdField_a_of_type_Boolean = false;
              this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.q);
              try
              {
                if (jdField_a_of_type_MqqOsMqqHandler == null) {
                  continue;
                }
                jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
                return;
              }
              catch (Exception localException4) {}
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, localException4);
              return;
            }
          }
          i = m;
          VasFaceManager localVasFaceManager;
          if (QQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int))
          {
            i = m;
            localVasFaceManager = ((VasExtensionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).a;
            i = m;
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, true);
            if (localObject3 != null)
            {
              i = m;
              long l = ((ExtensionInfo)localObject3).faceIdUpdateTime;
              if (l != 0L) {}
            }
            else
            {
              i = n;
            }
          }
          try
          {
            localVasFaceManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, this, Boolean.TRUE);
            this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.q);
            return;
          }
          catch (Throwable localThrowable2)
          {
            for (;;)
            {
              int i1;
              boolean bool;
              Pair localPair;
              j = 1;
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            j = k;
          }
          i = m;
          i1 = ((ExtensionInfo)localObject3).faceId;
          if (i1 > 0)
          {
            i = n;
            localVasFaceManager.a(((ExtensionInfo)localObject3).faceId, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.d, this, null);
            this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.q);
            return;
          }
          i = m;
          if ((Setting)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int).second != null) {
            break label1054;
          }
          i = m;
          this.jdField_a_of_type_Boolean = true;
          i = m;
          if (QLog.isColorLevel())
          {
            i = m;
            QLog.d("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap, needdown-settingNull, faceInfo=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.toString());
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.q);
          try
          {
            if (jdField_a_of_type_MqqOsMqqHandler != null)
            {
              jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
              return;
            }
          }
          catch (Exception localException5) {}
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, localException5);
      return;
      i = m;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int)) {
        break label1229;
      }
      for (bool = true;; bool = false)
      {
        for (;;)
        {
          i = m;
          this.jdField_a_of_type_Boolean = bool;
          i = m;
          if (!this.jdField_a_of_type_Boolean) {
            break label1235;
          }
          i = m;
          if (QLog.isColorLevel())
          {
            i = m;
            QLog.d("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap, needdown-fileNotExit, faceInfo=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.toString());
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.q);
          try
          {
            if (jdField_a_of_type_MqqOsMqqHandler == null) {
              break;
            }
            jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
            return;
          }
          catch (Exception localException6) {}
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, localException6);
        return;
      }
      i = m;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 101) {
        break label1330;
      }
      i = m;
      localPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int);
      if (localPair == null) {
        break label1512;
      }
      i = m;
      if (!((Boolean)localPair.first).booleanValue()) {
        break label1512;
      }
      i = m;
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Byte = 1;
      i = m;
      FaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo);
      for (;;)
      {
        for (;;)
        {
          i = m;
          this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, (byte)this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.c, 100, false, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(), this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int);
          i = m;
          if (QLog.isColorLevel())
          {
            i = m;
            if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
            {
              i = m;
              QLog.d("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap fail. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString);
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.q);
          try
          {
            if (jdField_a_of_type_MqqOsMqqHandler == null) {
              break;
            }
            jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
            return;
          }
          catch (Exception localException7) {}
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, localException7);
        return;
        i = m;
        if ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Boolean) && (localException7 != null))
        {
          i = m;
          if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int != 1)
          {
            i = m;
            if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int != 32) {}
          }
          else
          {
            i = m;
            localObject3 = (DynamicAvatarManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(179);
            i = m;
            if (((DynamicAvatarManager)localObject3).a(((DynamicAvatarManager)localObject3).b(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString), (Setting)localException7.second, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int))
            {
              i = m;
              if (QLog.isColorLevel())
              {
                i = m;
                QLog.i("Q.dynamicAvatar", 2, "FaceDecodeTaskImpl isNeed2UpdateSettingInfo.");
              }
              i = m;
              this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Byte = 1;
              i = m;
              FaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo);
            }
          }
        }
      }
    }
    catch (Throwable localThrowable1)
    {
      do
      {
        for (;;)
        {
          i = j;
          if (QLog.isColorLevel())
          {
            i = j;
            QLog.e("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, localThrowable1);
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.q);
          if (j == 0) {
            try
            {
              if (jdField_a_of_type_MqqOsMqqHandler != null)
              {
                jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
                return;
              }
            }
            catch (Exception localException8) {}
          }
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, localException8);
      return;
    }
    finally
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.q);
        if (i == 0) {}
        try
        {
          if (jdField_a_of_type_MqqOsMqqHandler != null) {
            jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
          }
          throw localObject1;
        }
        catch (Exception localException9)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap sendMessage exception. uin=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, localException9);
            }
          }
        }
      }
    }
    i = m;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(FaceInfo.q);
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (paramObject == Boolean.TRUE) {
      a(this);
    }
    do
    {
      return;
      if (paramString == null) {
        break;
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, (byte)this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.c, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.d, false, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a(), this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int);
    } while (jdField_a_of_type_MqqOsMqqHandler == null);
    jdField_a_of_type_MqqOsMqqHandler.sendMessage(jdField_a_of_type_MqqOsMqqHandler.obtainMessage(jdField_a_of_type_Int, this));
    return;
    QLog.e("Q.qqhead.VasFaceManager", 1, "TaskImpl failed to download store face, faceInfo: " + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.toString());
    ((VasExtensionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).a.b(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, 0);
    a(this);
  }
  
  protected boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.util.FaceDecodeTaskImpl
 * JD-Core Version:    0.7.0.1
 */