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

public class lgq
  extends ajtd
{
  lgs jdField_a_of_type_Lgs = null;
  lgu jdField_a_of_type_Lgu = null;
  private lgr[] jdField_a_of_type_ArrayOfLgr;
  private lgt[] jdField_a_of_type_ArrayOfLgt;
  
  public lgq(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_Lgu != null)
    {
      i = 0;
      int j = -1;
      while (i < this.jdField_a_of_type_Lgu.a.length)
      {
        if (this.jdField_a_of_type_Lgu.a[i] == paramInt) {
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
          String str = ajyc.a(2131700877) + paramInt + "]，需要在FrameDataHandlerArray中添加";
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
  
  public static lgq a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return null;
    }
    return (lgq)paramVideoAppInterface.a(3);
  }
  
  private lgr[] a()
  {
    if (this.jdField_a_of_type_ArrayOfLgr == null) {}
    try
    {
      if (this.jdField_a_of_type_ArrayOfLgr == null)
      {
        this.jdField_a_of_type_Lgs = new lgs();
        this.jdField_a_of_type_ArrayOfLgr = new lgr[this.jdField_a_of_type_Lgs.a.length];
      }
      return this.jdField_a_of_type_ArrayOfLgr;
    }
    finally {}
  }
  
  private lgt[] a()
  {
    if (this.jdField_a_of_type_ArrayOfLgt == null) {}
    try
    {
      if (this.jdField_a_of_type_ArrayOfLgt == null)
      {
        this.jdField_a_of_type_Lgu = new lgu();
        this.jdField_a_of_type_ArrayOfLgt = new lgt[this.jdField_a_of_type_Lgu.a.length];
      }
      return this.jdField_a_of_type_ArrayOfLgt;
    }
    finally {}
  }
  
  private int b(int paramInt, boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_Lgs != null)
    {
      i = 0;
      int j = -1;
      while (i < this.jdField_a_of_type_Lgs.a.length)
      {
        if (this.jdField_a_of_type_Lgs.a[i] == paramInt) {
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
          String str = ajyc.a(2131700879) + paramInt + "]，需要在C2CDataHandlerArray中添加";
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
  
  public int a(ArrayList<lpf> paramArrayList)
  {
    int i = 0;
    lgt[] arrayOflgt = this.jdField_a_of_type_ArrayOfLgt;
    if (arrayOflgt == null) {
      return 0;
    }
    int k;
    for (int j = 0; i < arrayOflgt.length; j = k)
    {
      Object localObject = arrayOflgt[i];
      k = j;
      if (localObject != null)
      {
        localObject = ((lgt)localObject).a();
        k = j;
        if (localObject != null)
        {
          paramArrayList.add(localObject);
          k = j + ((lpf)localObject).a();
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
    lgt[] arrayOflgt;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      arrayOflgt = this.jdField_a_of_type_ArrayOfLgt;
      if (arrayOflgt != null) {}
    }
    else
    {
      return;
    }
    paramArrayOfByte = lpg.a(paramArrayOfByte);
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
      lgt locallgt = arrayOflgt[k];
      if (locallgt != null) {
        locallgt.a(paramString, (lpf)paramArrayOfByte.valueAt(i));
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
  
  public boolean a(int paramInt, lgr paramlgr)
  {
    lgr[] arrayOflgr = a();
    paramInt = b(paramInt, true);
    if (arrayOflgr[paramInt] == null)
    {
      arrayOflgr[paramInt] = paramlgr;
      return true;
    }
    lzj.a("registerC2CDataHandler重复注册");
    return false;
  }
  
  public boolean a(int paramInt, lgt paramlgt)
  {
    Object localObject = BaseApplicationImpl.getContext();
    localObject = VideoController.a().a((Context)localObject);
    if (localObject == null)
    {
      lzj.a("registerFrameDataHandler, EffectController为空");
      return false;
    }
    ((lpy)localObject).a(4);
    localObject = a();
    paramInt = a(paramInt, true);
    if (localObject[paramInt] == null)
    {
      localObject[paramInt] = paramlgt;
      return true;
    }
    lzj.a("registerFrameDataHandler重复注册");
    return false;
  }
  
  public boolean a(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfLgr;
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
    return ((lgr)localObject).a(paramInt, ByteBuffer.wrap(paramArrayOfByte).getInt(), lpg.a(paramArrayOfByte, 4, paramArrayOfByte.length - 4));
  }
  
  public boolean b(int paramInt, lgt paramlgt)
  {
    paramInt = a(paramInt, true);
    lgt[] arrayOflgt = this.jdField_a_of_type_ArrayOfLgt;
    if ((arrayOflgt != null) && (arrayOflgt[paramInt] != null) && (paramlgt.equals(arrayOflgt[paramInt])))
    {
      arrayOflgt[paramInt] = null;
      return true;
    }
    lzj.a("unregisterFrameDataHandler取消注册失败");
    return false;
  }
  
  protected Class<? extends ajtg> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = 0L;
    if (paramToServiceMsg != null) {
      l = mtm.a(paramToServiceMsg);
    }
    if (QLog.isDevelopLevel()) {
      QLog.w("AVDataSender", 1, "onReceive, serviceCmd[" + "null" + "], seq[" + l + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lgq
 * JD-Core Version:    0.7.0.1
 */