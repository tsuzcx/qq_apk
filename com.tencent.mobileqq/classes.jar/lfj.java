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

public class lfj
  extends anii
{
  lfl jdField_a_of_type_Lfl = null;
  lfn jdField_a_of_type_Lfn = null;
  private lfk[] jdField_a_of_type_ArrayOfLfk;
  private lfm[] jdField_a_of_type_ArrayOfLfm;
  
  public lfj(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_Lfn != null)
    {
      i = 0;
      int j = -1;
      while (i < this.jdField_a_of_type_Lfn.a.length)
      {
        if (this.jdField_a_of_type_Lfn.a[i] == paramInt) {
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
          String str = anni.a(2131699694) + paramInt + "]，需要在FrameDataHandlerArray中添加";
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
  
  public static lfj a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return null;
    }
    return (lfj)paramVideoAppInterface.a(3);
  }
  
  private lfk[] a()
  {
    if (this.jdField_a_of_type_ArrayOfLfk == null) {}
    try
    {
      if (this.jdField_a_of_type_ArrayOfLfk == null)
      {
        this.jdField_a_of_type_Lfl = new lfl();
        this.jdField_a_of_type_ArrayOfLfk = new lfk[this.jdField_a_of_type_Lfl.a.length];
      }
      return this.jdField_a_of_type_ArrayOfLfk;
    }
    finally {}
  }
  
  private lfm[] a()
  {
    if (this.jdField_a_of_type_ArrayOfLfm == null) {}
    try
    {
      if (this.jdField_a_of_type_ArrayOfLfm == null)
      {
        this.jdField_a_of_type_Lfn = new lfn();
        this.jdField_a_of_type_ArrayOfLfm = new lfm[this.jdField_a_of_type_Lfn.a.length];
      }
      return this.jdField_a_of_type_ArrayOfLfm;
    }
    finally {}
  }
  
  private int b(int paramInt, boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_Lfl != null)
    {
      i = 0;
      int j = -1;
      while (i < this.jdField_a_of_type_Lfl.a.length)
      {
        if (this.jdField_a_of_type_Lfl.a[i] == paramInt) {
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
          String str = anni.a(2131699696) + paramInt + "]，需要在C2CDataHandlerArray中添加";
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
  
  public int a(ArrayList<loa> paramArrayList)
  {
    int i = 0;
    lfm[] arrayOflfm = this.jdField_a_of_type_ArrayOfLfm;
    if (arrayOflfm == null) {
      return 0;
    }
    int k;
    for (int j = 0; i < arrayOflfm.length; j = k)
    {
      Object localObject = arrayOflfm[i];
      k = j;
      if (localObject != null)
      {
        localObject = ((lfm)localObject).a();
        k = j;
        if (localObject != null)
        {
          paramArrayList.add(localObject);
          k = j + ((loa)localObject).a();
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
    lfm[] arrayOflfm;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      arrayOflfm = this.jdField_a_of_type_ArrayOfLfm;
      if (arrayOflfm != null) {}
    }
    else
    {
      return;
    }
    paramArrayOfByte = lob.a(paramArrayOfByte);
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
      lfm locallfm = arrayOflfm[k];
      if (locallfm != null) {
        locallfm.a(paramString, (loa)paramArrayOfByte.valueAt(i));
      }
    }
    for (;;)
    {
      i += 1;
      break label28;
      break;
      label92:
      if (AudioHelper.e()) {
        QLog.d("AVDataSender", 1, "notifyFrameDataCome, msgType[" + j + "], i[" + i + "]");
      }
    }
  }
  
  public boolean a(int paramInt, lfk paramlfk)
  {
    lfk[] arrayOflfk = a();
    paramInt = b(paramInt, true);
    if (arrayOflfk[paramInt] == null)
    {
      arrayOflfk[paramInt] = paramlfk;
      return true;
    }
    lyu.a("registerC2CDataHandler重复注册");
    return false;
  }
  
  public boolean a(int paramInt, lfm paramlfm)
  {
    Object localObject = BaseApplicationImpl.getContext();
    localObject = VideoController.a().a((Context)localObject);
    if (localObject == null)
    {
      lyu.a("registerFrameDataHandler, EffectController为空");
      return false;
    }
    ((low)localObject).a(4);
    localObject = a();
    paramInt = a(paramInt, true);
    if (localObject[paramInt] == null)
    {
      localObject[paramInt] = paramlfm;
      return true;
    }
    lyu.a("registerFrameDataHandler重复注册");
    return false;
  }
  
  public boolean a(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfLfk;
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
    return ((lfk)localObject).a(paramInt, ByteBuffer.wrap(paramArrayOfByte).getInt(), lob.a(paramArrayOfByte, 4, paramArrayOfByte.length - 4));
  }
  
  public boolean b(int paramInt, lfm paramlfm)
  {
    paramInt = a(paramInt, true);
    lfm[] arrayOflfm = this.jdField_a_of_type_ArrayOfLfm;
    if ((arrayOflfm != null) && (arrayOflfm[paramInt] != null) && (paramlfm.equals(arrayOflfm[paramInt])))
    {
      arrayOflfm[paramInt] = null;
      return true;
    }
    lyu.a("unregisterFrameDataHandler取消注册失败");
    return false;
  }
  
  protected Class<? extends anil> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = 0L;
    if (paramToServiceMsg != null) {
      l = mtl.a(paramToServiceMsg);
    }
    if (QLog.isDevelopLevel()) {
      QLog.w("AVDataSender", 1, "onReceive, serviceCmd[" + "null" + "], seq[" + l + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lfj
 * JD-Core Version:    0.7.0.1
 */