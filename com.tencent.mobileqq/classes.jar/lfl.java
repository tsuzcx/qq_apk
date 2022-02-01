import android.content.Context;
import android.util.SparseArray;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class lfl
  extends BusinessHandler
{
  lfn jdField_a_of_type_Lfn = null;
  lfp jdField_a_of_type_Lfp = null;
  private lfm[] jdField_a_of_type_ArrayOfLfm;
  private lfo[] jdField_a_of_type_ArrayOfLfo;
  
  public lfl(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_Lfp != null)
    {
      i = 0;
      int j = -1;
      while (i < this.jdField_a_of_type_Lfp.a.length)
      {
        if (this.jdField_a_of_type_Lfp.a[i] == paramInt) {
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
          String str = amtj.a(2131700036) + paramInt + "]，需要在FrameDataHandlerArray中添加";
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
  
  public static lfl a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return null;
    }
    return (lfl)paramVideoAppInterface.a(3);
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
  
  private lfo[] a()
  {
    if (this.jdField_a_of_type_ArrayOfLfo == null) {}
    try
    {
      if (this.jdField_a_of_type_ArrayOfLfo == null)
      {
        this.jdField_a_of_type_Lfp = new lfp();
        this.jdField_a_of_type_ArrayOfLfo = new lfo[this.jdField_a_of_type_Lfp.a.length];
      }
      return this.jdField_a_of_type_ArrayOfLfo;
    }
    finally {}
  }
  
  private int b(int paramInt, boolean paramBoolean)
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
          String str = amtj.a(2131700038) + paramInt + "]，需要在C2CDataHandlerArray中添加";
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
  
  public int a(ArrayList<lnw> paramArrayList)
  {
    int i = 0;
    lfo[] arrayOflfo = this.jdField_a_of_type_ArrayOfLfo;
    if (arrayOflfo == null) {
      return 0;
    }
    int k;
    for (int j = 0; i < arrayOflfo.length; j = k)
    {
      Object localObject = arrayOflfo[i];
      k = j;
      if (localObject != null)
      {
        localObject = ((lfo)localObject).a();
        k = j;
        if (localObject != null)
        {
          paramArrayList.add(localObject);
          k = j + ((lnw)localObject).a();
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
    lfo[] arrayOflfo;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      arrayOflfo = this.jdField_a_of_type_ArrayOfLfo;
      if (arrayOflfo != null) {}
    }
    else
    {
      return;
    }
    paramArrayOfByte = lnx.a(paramArrayOfByte);
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
      lfo locallfo = arrayOflfo[k];
      if (locallfo != null) {
        locallfo.a(paramString, (lnw)paramArrayOfByte.valueAt(i));
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
  
  public boolean a(int paramInt, lfm paramlfm)
  {
    lfm[] arrayOflfm = a();
    paramInt = b(paramInt, true);
    if (arrayOflfm[paramInt] == null)
    {
      arrayOflfm[paramInt] = paramlfm;
      return true;
    }
    lzb.a("registerC2CDataHandler重复注册");
    return false;
  }
  
  public boolean a(int paramInt, lfo paramlfo)
  {
    Object localObject = BaseApplicationImpl.getContext();
    localObject = VideoController.a().a((Context)localObject);
    if (localObject == null)
    {
      lzb.a("registerFrameDataHandler, EffectController为空");
      return false;
    }
    ((lor)localObject).a(4);
    localObject = a();
    paramInt = a(paramInt, true);
    if (localObject[paramInt] == null)
    {
      localObject[paramInt] = paramlfo;
      return true;
    }
    lzb.a("registerFrameDataHandler重复注册");
    return false;
  }
  
  public boolean a(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfLfm;
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
    return ((lfm)localObject).a(paramInt, ByteBuffer.wrap(paramArrayOfByte).getInt(), lnx.a(paramArrayOfByte, 4, paramArrayOfByte.length - 4));
  }
  
  public boolean b(int paramInt, lfo paramlfo)
  {
    paramInt = a(paramInt, true);
    lfo[] arrayOflfo = this.jdField_a_of_type_ArrayOfLfo;
    if ((arrayOflfo != null) && (arrayOflfo[paramInt] != null) && (paramlfo.equals(arrayOflfo[paramInt])))
    {
      arrayOflfo[paramInt] = null;
      return true;
    }
    lzb.a("unregisterFrameDataHandler取消注册失败");
    return false;
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = 0L;
    if (paramToServiceMsg != null) {
      l = mtt.a(paramToServiceMsg);
    }
    if (QLog.isDevelopLevel()) {
      QLog.w("AVDataSender", 1, "onReceive, serviceCmd[" + "null" + "], seq[" + l + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lfl
 * JD-Core Version:    0.7.0.1
 */