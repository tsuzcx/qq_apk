import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Message;
import com.tencent.av.AVFunChat.AVFunChatMessage;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

@SuppressLint({"HandlerLeak"})
public class llc
  implements mwx
{
  private final String jdField_a_of_type_JavaLangString = "VcControllerImpl_NativeEventHandler";
  
  public llc(VcControllerImpl paramVcControllerImpl) {}
  
  public boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject;
    long l1;
    String str;
    boolean bool;
    for (;;)
    {
      try
      {
        i = paramMessage.what;
        localObject = (mwi)paramMessage.obj;
        if (localObject == null)
        {
          lba.h("VcControllerImpl_NativeEventHandler", "p is null");
          return true;
        }
        paramMessage = ((mwi)localObject).jdField_a_of_type_ArrayOfByte;
        l1 = ((mwi)localObject).jdField_a_of_type_Long;
        str = mrb.a(((mwi)localObject).b);
        switch (i)
        {
        case 4: 
          lhu.a((int)l1, ((mwi)localObject).c, ((mwi)localObject).d, ((mwi)localObject).jdField_a_of_type_JavaLangString);
          break;
        case 6: 
          if (!mqw.a()) {
            continue;
          }
        }
      }
      finally {}
      mqw.a().a(this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl, null);
      continue;
      long l2 = ((mwi)localObject).c;
      long l3 = ((mwi)localObject).d;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(l2, l3, l1);
      continue;
      if (((mwi)localObject).c != 1L) {
        break;
      }
      bool = true;
      label246:
      int i = (int)((mwi)localObject).d;
      try
      {
        paramMessage = new String(((mwi)localObject).jdField_a_of_type_ArrayOfByte, "utf-8");
        int j = ((mwi)localObject).jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(bool, i, paramMessage, j);
      }
      catch (UnsupportedEncodingException paramMessage)
      {
        for (;;)
        {
          paramMessage.printStackTrace();
          paramMessage = "";
        }
      }
      if (lvl.a().a)
      {
        lvl.a().k = ((mwi)localObject).f;
      }
      else
      {
        lvl.a().z = ((mwi)localObject).f;
        continue;
        i = (int)((mwi)localObject).jdField_a_of_type_Long;
        if (QLog.isColorLevel()) {
          QLog.d("NativeEventHandler", 2, "SharpConfigPayload. version = " + i);
        }
        BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD").putExtra("version", i));
        lvm.a().a("load", i);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.onAudioData(paramMessage);
      }
    }
    for (;;)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, (int)l1, paramMessage);
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.c((int)l1, new String(paramMessage));
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.d((int)l1, new String(paramMessage));
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(paramMessage);
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.q(new String(paramMessage));
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.s(new String(paramMessage));
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.r(new String(paramMessage));
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, new String(paramMessage));
        break;
        try
        {
          localObject = new AVFunChat.AVFunChatMessage();
          ((AVFunChat.AVFunChatMessage)localObject).mergeFrom(paramMessage);
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, (AVFunChat.AVFunChatMessage)localObject);
        }
        catch (InvalidProtocolBufferMicroException paramMessage)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("VcControllerImpl", 2, "EM_AVFUNCHATTYPE_CreativeCop InvalidProtocolBufferMicroException fail", paramMessage);
        }
        catch (Throwable paramMessage) {}
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("VcControllerImpl", 2, "EM_AVFUNCHATTYPE_CreativeCop parse fail", paramMessage);
      break;
      bcef.b(null, "CliOper", "", "", "0X800A7A4", "0X800A7A4", 0, (int)((mwi)localObject).c, "", "", "", "");
      break;
      bcef.b(null, "CliOper", "", "", "0X800A7A5", "0X800A7A5", 0, (int)((mwi)localObject).c, "", "", "", "");
      break;
      break;
      bool = false;
      break label246;
      switch ((int)l1)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     llc
 * JD-Core Version:    0.7.0.1
 */