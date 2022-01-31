import android.content.Context;
import android.util.SparseArray;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class kwb
  extends ajfb
{
  kwd jdField_a_of_type_Kwd = null;
  kwf jdField_a_of_type_Kwf = null;
  private kwc[] jdField_a_of_type_ArrayOfKwc;
  private kwe[] jdField_a_of_type_ArrayOfKwe;
  
  public kwb(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_Kwf != null)
    {
      i = 0;
      int j = -1;
      while (i < this.jdField_a_of_type_Kwf.a.length)
      {
        if (this.jdField_a_of_type_Kwf.a[i] == paramInt) {
          j = i;
        }
        i += 1;
      }
      i = j;
      if (paramBoolean)
      {
        i = j;
        if (j == -1)
        {
          String str = ajjy.a(2131635093) + paramInt + "]，需要在FrameDataHandlerArray中添加";
          QLog.d("AVDataSender", 1, str);
          throw new IllegalArgumentException(str);
        }
      }
    }
    else
    {
      i = -1;
    }
    return i;
  }
  
  public static kwb a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return null;
    }
    return (kwb)paramVideoAppInterface.a(3);
  }
  
  private kwc[] a()
  {
    if (this.jdField_a_of_type_ArrayOfKwc == null) {}
    try
    {
      if (this.jdField_a_of_type_ArrayOfKwc == null)
      {
        this.jdField_a_of_type_Kwd = new kwd();
        this.jdField_a_of_type_ArrayOfKwc = new kwc[this.jdField_a_of_type_Kwd.a.length];
      }
      return this.jdField_a_of_type_ArrayOfKwc;
    }
    finally {}
  }
  
  private kwe[] a()
  {
    if (this.jdField_a_of_type_ArrayOfKwe == null) {}
    try
    {
      if (this.jdField_a_of_type_ArrayOfKwe == null)
      {
        this.jdField_a_of_type_Kwf = new kwf();
        this.jdField_a_of_type_ArrayOfKwe = new kwe[this.jdField_a_of_type_Kwf.a.length];
      }
      return this.jdField_a_of_type_ArrayOfKwe;
    }
    finally {}
  }
  
  private int b(int paramInt, boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_Kwd != null)
    {
      i = 0;
      int j = -1;
      while (i < this.jdField_a_of_type_Kwd.a.length)
      {
        if (this.jdField_a_of_type_Kwd.a[i] == paramInt) {
          j = i;
        }
        i += 1;
      }
      i = j;
      if (paramBoolean)
      {
        i = j;
        if (j == -1)
        {
          String str = ajjy.a(2131635095) + paramInt + "]，需要在C2CDataHandlerArray中添加";
          QLog.d("AVDataSender", 1, str);
          throw new IllegalArgumentException(str);
        }
      }
    }
    else
    {
      i = -1;
    }
    return i;
  }
  
  public int a(ArrayList<lep> paramArrayList)
  {
    int i = 0;
    kwe[] arrayOfkwe = this.jdField_a_of_type_ArrayOfKwe;
    if (arrayOfkwe == null) {
      return 0;
    }
    int k;
    for (int j = 0; i < arrayOfkwe.length; j = k)
    {
      Object localObject = arrayOfkwe[i];
      k = j;
      if (localObject != null)
      {
        localObject = ((kwe)localObject).a();
        k = j;
        if (localObject != null)
        {
          paramArrayList.add(localObject);
          k = j + ((lep)localObject).a();
        }
      }
      i += 1;
    }
    return j;
  }
  
  public void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(i + 4);
      localByteBuffer.putInt(paramInt2);
      if (i > 0) {
        localByteBuffer.put(paramArrayOfByte);
      }
      VideoController.a().a(paramInt1, localByteBuffer.array());
      return;
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    kwe[] arrayOfkwe;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      arrayOfkwe = this.jdField_a_of_type_ArrayOfKwe;
      if (arrayOfkwe != null) {}
    }
    else
    {
      return;
    }
    paramArrayOfByte = leq.a(paramArrayOfByte);
    int i = 0;
    label28:
    int j;
    if (i < paramArrayOfByte.size())
    {
      j = paramArrayOfByte.keyAt(i);
      int k = a(j, false);
      if (k < 0) {
        break label92;
      }
      kwe localkwe = arrayOfkwe[k];
      if (localkwe != null) {
        localkwe.a(paramString, (lep)paramArrayOfByte.valueAt(i));
      }
    }
    for (;;)
    {
      i += 1;
      break label28;
      break;
      label92:
      if (AudioHelper.d()) {
        QLog.d("AVDataSender", 1, "notifyFrameDataCome, msgType[" + j + "], i[" + i + "]");
      }
    }
  }
  
  public boolean a(int paramInt, kwc paramkwc)
  {
    kwc[] arrayOfkwc = a();
    paramInt = b(paramInt, true);
    if (arrayOfkwc[paramInt] == null)
    {
      arrayOfkwc[paramInt] = paramkwc;
      return true;
    }
    lor.a("registerC2CDataHandler重复注册");
    return false;
  }
  
  public boolean a(int paramInt, kwe paramkwe)
  {
    Object localObject = BaseApplicationImpl.getContext();
    localObject = VideoController.a().a((Context)localObject);
    if (localObject == null)
    {
      lor.a("registerFrameDataHandler, EffectController为空");
      return false;
    }
    ((lfg)localObject).a(4);
    localObject = a();
    paramInt = a(paramInt, true);
    if (localObject[paramInt] == null)
    {
      localObject[paramInt] = paramkwe;
      return true;
    }
    lor.a("registerFrameDataHandler重复注册");
    return false;
  }
  
  public boolean a(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfKwc;
    if (localObject == null) {}
    do
    {
      int i;
      do
      {
        return false;
        i = b(paramInt, false);
      } while (i < 0);
      localObject = localObject[i];
    } while (localObject == null);
    return ((kwc)localObject).a(paramInt, ByteBuffer.wrap(paramArrayOfByte).getInt(), leq.a(paramArrayOfByte, 4, paramArrayOfByte.length - 4));
  }
  
  public boolean b(int paramInt, kwe paramkwe)
  {
    paramInt = a(paramInt, true);
    kwe[] arrayOfkwe = this.jdField_a_of_type_ArrayOfKwe;
    if ((arrayOfkwe != null) && (arrayOfkwe[paramInt] != null) && (paramkwe.equals(arrayOfkwe[paramInt])))
    {
      arrayOfkwe[paramInt] = null;
      return true;
    }
    lor.a("unregisterFrameDataHandler取消注册失败");
    return false;
  }
  
  protected Class<? extends ajfe> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = 0L;
    if (paramToServiceMsg != null) {
      l = min.a(paramToServiceMsg);
    }
    if (QLog.isDevelopLevel()) {
      QLog.w("AVDataSender", 1, "onReceive, serviceCmd[" + "null" + "], seq[" + l + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kwb
 * JD-Core Version:    0.7.0.1
 */