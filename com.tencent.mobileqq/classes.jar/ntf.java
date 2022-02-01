import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public abstract class ntf
  implements BusinessObserver
{
  public boolean a;
  public int b;
  public WeakReference<QQAppInterface> b;
  
  public ntf()
  {
    this.jdField_b_of_type_Int = 1;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(null);
    this.a = true;
  }
  
  public ntf(boolean paramBoolean)
  {
    this.jdField_b_of_type_Int = 1;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(null);
    this.a = paramBoolean;
  }
  
  private void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean) {
      a(-1, null, paramBundle);
    }
    label163:
    do
    {
      for (;;)
      {
        return;
        Object localObject = paramBundle.getByteArray("data");
        if (this.jdField_b_of_type_Int != 1) {
          break label163;
        }
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        try
        {
          localObject = (oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.mergeFrom((byte[])localObject);
          if ((((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get() == 0) || (!a(((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get(), ((oidb_sso.OIDBSSOPkg)localObject).str_error_msg.get(), paramBundle))) {
            if ((!((oidb_sso.OIDBSSOPkg)localObject).uint32_result.has()) || (!((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() == null))
            {
              a(-1, null, paramBundle);
              return;
            }
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          a(-1, null, paramBundle);
          return;
        }
      }
      a(localInvalidProtocolBufferMicroException.uint32_result.get(), localInvalidProtocolBufferMicroException.bytes_bodybuffer.get().toByteArray(), paramBundle);
      return;
    } while (this.jdField_b_of_type_Int != 2);
    a(0, localInvalidProtocolBufferMicroException, paramBundle);
  }
  
  public abstract void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle);
  
  public boolean a(int paramInt, String paramString, Bundle paramBundle)
  {
    return false;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a)
    {
      a(paramInt, paramBoolean, paramBundle);
      return;
    }
    ThreadManager.post(new ProtoUtils.TroopProtocolObserver.1(this, paramInt, paramBoolean, paramBundle), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ntf
 * JD-Core Version:    0.7.0.1
 */