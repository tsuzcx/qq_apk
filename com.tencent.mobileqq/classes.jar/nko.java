import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.biz.ProtoUtils.StoryProtocolObserver.1;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

public abstract class nko
  implements BusinessObserver
{
  public final long a;
  public WeakReference<QQAppInterface> a;
  public boolean a;
  
  public nko()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(null);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  private void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    String str = paramBundle.getString("cmd");
    if (paramBoolean)
    {
      localObject = paramBundle.getByteArray("data");
      if ((localObject != null) && (localObject.length > 0))
      {
        paramBundle = a(0, (byte[])localObject, paramBundle);
        if (paramBundle != null)
        {
          paramInt = paramBundle.error_code.get();
          paramBundle = paramBundle.error_desc.get().toStringUtf8();
          if (paramInt == 0) {
            yuk.a("Q.qqstory.net:StoryProtocolObserver", "get cmd:%s success take time:%d data length=%d", str, Long.valueOf(l), Integer.valueOf(localObject.length));
          }
          for (;;)
          {
            yup.b("story_net", str, 0, paramInt, new String[] { paramBundle, String.valueOf(l), yup.a(BaseApplication.getContext()) });
            return;
            yuk.d("Q.qqstory.net:StoryProtocolObserver", "get cmd:%s error:%d msg:%s take time:%d data length%d", new Object[] { str, Integer.valueOf(paramInt), paramBundle, Long.valueOf(l), Integer.valueOf(localObject.length) });
          }
        }
        yuk.d("Q.qqstory.net:StoryProtocolObserver", "get cmd:%s error. response is null", new Object[] { str });
        yup.b("story_net", str, 0, 940002, new String[] { "response is null", String.valueOf(l), yup.a(BaseApplication.getContext()) });
        return;
      }
      a(-1, null, paramBundle);
      yuk.d("Q.qqstory.net:StoryProtocolObserver", "get cmd:" + str + " channel error:%d, take time:%d", new Object[] { Integer.valueOf(-1), Long.valueOf(l) });
      yup.b("story_net", str, 0, 940002, new String[] { "rsp data error", String.valueOf(l), yup.a(BaseApplication.getContext()) });
      return;
    }
    paramInt = paramBundle.getInt("data_error_code");
    Object localObject = paramBundle.getString("data_error_msg");
    a(paramInt, null, paramBundle);
    yuk.d("Q.qqstory.net:StoryProtocolObserver", "get cmd:" + str + " channel error:%d, take time:%d", new Object[] { Integer.valueOf(-1), Long.valueOf(l) });
    yup.b("story_net", str, 0, paramInt, new String[] { localObject, String.valueOf(l), yup.a(BaseApplication.getContext()) });
  }
  
  public abstract qqstory_struct.ErrorInfo a(int paramInt, @Nullable byte[] paramArrayOfByte, Bundle paramBundle);
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      a(paramInt, paramBoolean, paramBundle);
      return;
    }
    ThreadManager.post(new ProtoUtils.StoryProtocolObserver.1(this, paramInt, paramBoolean, paramBundle), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nko
 * JD-Core Version:    0.7.0.1
 */