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

public class lio
  extends alpd
{
  liq jdField_a_of_type_Liq = null;
  lis jdField_a_of_type_Lis = null;
  private lip[] jdField_a_of_type_ArrayOfLip;
  private lir[] jdField_a_of_type_ArrayOfLir;
  
  public lio(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_Lis != null)
    {
      i = 0;
      int j = -1;
      while (i < this.jdField_a_of_type_Lis.a.length)
      {
        if (this.jdField_a_of_type_Lis.a[i] == paramInt) {
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
          String str = alud.a(2131701269) + paramInt + "]，需要在FrameDataHandlerArray中添加";
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
  
  public static lio a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return null;
    }
    return (lio)paramVideoAppInterface.a(3);
  }
  
  private lip[] a()
  {
    if (this.jdField_a_of_type_ArrayOfLip == null) {}
    try
    {
      if (this.jdField_a_of_type_ArrayOfLip == null)
      {
        this.jdField_a_of_type_Liq = new liq();
        this.jdField_a_of_type_ArrayOfLip = new lip[this.jdField_a_of_type_Liq.a.length];
      }
      return this.jdField_a_of_type_ArrayOfLip;
    }
    finally {}
  }
  
  private lir[] a()
  {
    if (this.jdField_a_of_type_ArrayOfLir == null) {}
    try
    {
      if (this.jdField_a_of_type_ArrayOfLir == null)
      {
        this.jdField_a_of_type_Lis = new lis();
        this.jdField_a_of_type_ArrayOfLir = new lir[this.jdField_a_of_type_Lis.a.length];
      }
      return this.jdField_a_of_type_ArrayOfLir;
    }
    finally {}
  }
  
  private int b(int paramInt, boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_Liq != null)
    {
      i = 0;
      int j = -1;
      while (i < this.jdField_a_of_type_Liq.a.length)
      {
        if (this.jdField_a_of_type_Liq.a[i] == paramInt) {
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
          String str = alud.a(2131701271) + paramInt + "]，需要在C2CDataHandlerArray中添加";
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
  
  public int a(ArrayList<lrd> paramArrayList)
  {
    int i = 0;
    lir[] arrayOflir = this.jdField_a_of_type_ArrayOfLir;
    if (arrayOflir == null) {
      return 0;
    }
    int k;
    for (int j = 0; i < arrayOflir.length; j = k)
    {
      Object localObject = arrayOflir[i];
      k = j;
      if (localObject != null)
      {
        localObject = ((lir)localObject).a();
        k = j;
        if (localObject != null)
        {
          paramArrayList.add(localObject);
          k = j + ((lrd)localObject).a();
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
    lir[] arrayOflir;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      arrayOflir = this.jdField_a_of_type_ArrayOfLir;
      if (arrayOflir != null) {}
    }
    else
    {
      return;
    }
    paramArrayOfByte = lre.a(paramArrayOfByte);
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
      lir locallir = arrayOflir[k];
      if (locallir != null) {
        locallir.a(paramString, (lrd)paramArrayOfByte.valueAt(i));
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
  
  public boolean a(int paramInt, lip paramlip)
  {
    lip[] arrayOflip = a();
    paramInt = b(paramInt, true);
    if (arrayOflip[paramInt] == null)
    {
      arrayOflip[paramInt] = paramlip;
      return true;
    }
    mbt.a("registerC2CDataHandler重复注册");
    return false;
  }
  
  public boolean a(int paramInt, lir paramlir)
  {
    Object localObject = BaseApplicationImpl.getContext();
    localObject = VideoController.a().a((Context)localObject);
    if (localObject == null)
    {
      mbt.a("registerFrameDataHandler, EffectController为空");
      return false;
    }
    ((lrz)localObject).a(4);
    localObject = a();
    paramInt = a(paramInt, true);
    if (localObject[paramInt] == null)
    {
      localObject[paramInt] = paramlir;
      return true;
    }
    mbt.a("registerFrameDataHandler重复注册");
    return false;
  }
  
  public boolean a(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfLip;
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
    return ((lip)localObject).a(paramInt, ByteBuffer.wrap(paramArrayOfByte).getInt(), lre.a(paramArrayOfByte, 4, paramArrayOfByte.length - 4));
  }
  
  public boolean b(int paramInt, lir paramlir)
  {
    paramInt = a(paramInt, true);
    lir[] arrayOflir = this.jdField_a_of_type_ArrayOfLir;
    if ((arrayOflir != null) && (arrayOflir[paramInt] != null) && (paramlir.equals(arrayOflir[paramInt])))
    {
      arrayOflir[paramInt] = null;
      return true;
    }
    mbt.a("unregisterFrameDataHandler取消注册失败");
    return false;
  }
  
  protected Class<? extends alpg> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = 0L;
    if (paramToServiceMsg != null) {
      l = mwd.a(paramToServiceMsg);
    }
    if (QLog.isDevelopLevel()) {
      QLog.w("AVDataSender", 1, "onReceive, serviceCmd[" + "null" + "], seq[" + l + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lio
 * JD-Core Version:    0.7.0.1
 */