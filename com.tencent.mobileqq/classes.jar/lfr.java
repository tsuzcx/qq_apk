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

public class lfr
  extends anud
{
  lft jdField_a_of_type_Lft = null;
  lfv jdField_a_of_type_Lfv = null;
  private lfs[] jdField_a_of_type_ArrayOfLfs;
  private lfu[] jdField_a_of_type_ArrayOfLfu;
  
  public lfr(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_Lfv != null)
    {
      i = 0;
      int j = -1;
      while (i < this.jdField_a_of_type_Lfv.a.length)
      {
        if (this.jdField_a_of_type_Lfv.a[i] == paramInt) {
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
          String str = anzj.a(2131699801) + paramInt + "]，需要在FrameDataHandlerArray中添加";
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
  
  public static lfr a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return null;
    }
    return (lfr)paramVideoAppInterface.a(3);
  }
  
  private lfs[] a()
  {
    if (this.jdField_a_of_type_ArrayOfLfs == null) {}
    try
    {
      if (this.jdField_a_of_type_ArrayOfLfs == null)
      {
        this.jdField_a_of_type_Lft = new lft();
        this.jdField_a_of_type_ArrayOfLfs = new lfs[this.jdField_a_of_type_Lft.a.length];
      }
      return this.jdField_a_of_type_ArrayOfLfs;
    }
    finally {}
  }
  
  private lfu[] a()
  {
    if (this.jdField_a_of_type_ArrayOfLfu == null) {}
    try
    {
      if (this.jdField_a_of_type_ArrayOfLfu == null)
      {
        this.jdField_a_of_type_Lfv = new lfv();
        this.jdField_a_of_type_ArrayOfLfu = new lfu[this.jdField_a_of_type_Lfv.a.length];
      }
      return this.jdField_a_of_type_ArrayOfLfu;
    }
    finally {}
  }
  
  private int b(int paramInt, boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_Lft != null)
    {
      i = 0;
      int j = -1;
      while (i < this.jdField_a_of_type_Lft.a.length)
      {
        if (this.jdField_a_of_type_Lft.a[i] == paramInt) {
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
          String str = anzj.a(2131699803) + paramInt + "]，需要在C2CDataHandlerArray中添加";
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
  
  public int a(ArrayList<loo> paramArrayList)
  {
    int i = 0;
    lfu[] arrayOflfu = this.jdField_a_of_type_ArrayOfLfu;
    if (arrayOflfu == null) {
      return 0;
    }
    int k;
    for (int j = 0; i < arrayOflfu.length; j = k)
    {
      Object localObject = arrayOflfu[i];
      k = j;
      if (localObject != null)
      {
        localObject = ((lfu)localObject).a();
        k = j;
        if (localObject != null)
        {
          paramArrayList.add(localObject);
          k = j + ((loo)localObject).a();
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
    lfu[] arrayOflfu;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      arrayOflfu = this.jdField_a_of_type_ArrayOfLfu;
      if (arrayOflfu != null) {}
    }
    else
    {
      return;
    }
    paramArrayOfByte = lop.a(paramArrayOfByte);
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
      lfu locallfu = arrayOflfu[k];
      if (locallfu != null) {
        locallfu.a(paramString, (loo)paramArrayOfByte.valueAt(i));
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
  
  public boolean a(int paramInt, lfs paramlfs)
  {
    lfs[] arrayOflfs = a();
    paramInt = b(paramInt, true);
    if (arrayOflfs[paramInt] == null)
    {
      arrayOflfs[paramInt] = paramlfs;
      return true;
    }
    lzq.a("registerC2CDataHandler重复注册");
    return false;
  }
  
  public boolean a(int paramInt, lfu paramlfu)
  {
    Object localObject = BaseApplicationImpl.getContext();
    localObject = VideoController.a().a((Context)localObject);
    if (localObject == null)
    {
      lzq.a("registerFrameDataHandler, EffectController为空");
      return false;
    }
    ((lpj)localObject).a(4);
    localObject = a();
    paramInt = a(paramInt, true);
    if (localObject[paramInt] == null)
    {
      localObject[paramInt] = paramlfu;
      return true;
    }
    lzq.a("registerFrameDataHandler重复注册");
    return false;
  }
  
  public boolean a(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfLfs;
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
    return ((lfs)localObject).a(paramInt, ByteBuffer.wrap(paramArrayOfByte).getInt(), lop.a(paramArrayOfByte, 4, paramArrayOfByte.length - 4));
  }
  
  public boolean b(int paramInt, lfu paramlfu)
  {
    paramInt = a(paramInt, true);
    lfu[] arrayOflfu = this.jdField_a_of_type_ArrayOfLfu;
    if ((arrayOflfu != null) && (arrayOflfu[paramInt] != null) && (paramlfu.equals(arrayOflfu[paramInt])))
    {
      arrayOflfu[paramInt] = null;
      return true;
    }
    lzq.a("unregisterFrameDataHandler取消注册失败");
    return false;
  }
  
  protected Class<? extends anui> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = 0L;
    if (paramToServiceMsg != null) {
      l = muk.a(paramToServiceMsg);
    }
    if (QLog.isDevelopLevel()) {
      QLog.w("AVDataSender", 1, "onReceive, serviceCmd[" + "null" + "], seq[" + l + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lfr
 * JD-Core Version:    0.7.0.1
 */