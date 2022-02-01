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

public class lfx
  extends BusinessHandler
{
  lfz jdField_a_of_type_Lfz = null;
  lgb jdField_a_of_type_Lgb = null;
  private lfy[] jdField_a_of_type_ArrayOfLfy;
  private lga[] jdField_a_of_type_ArrayOfLga;
  
  public lfx(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_Lgb != null)
    {
      i = 0;
      int j = -1;
      while (i < this.jdField_a_of_type_Lgb.a.length)
      {
        if (this.jdField_a_of_type_Lgb.a[i] == paramInt) {
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
          String str = anvx.a(2131700387) + paramInt + "]，需要在FrameDataHandlerArray中添加";
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
  
  public static lfx a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return null;
    }
    return (lfx)paramVideoAppInterface.a(3);
  }
  
  private lfy[] a()
  {
    if (this.jdField_a_of_type_ArrayOfLfy == null) {}
    try
    {
      if (this.jdField_a_of_type_ArrayOfLfy == null)
      {
        this.jdField_a_of_type_Lfz = new lfz();
        this.jdField_a_of_type_ArrayOfLfy = new lfy[this.jdField_a_of_type_Lfz.a.length];
      }
      return this.jdField_a_of_type_ArrayOfLfy;
    }
    finally {}
  }
  
  private lga[] a()
  {
    if (this.jdField_a_of_type_ArrayOfLga == null) {}
    try
    {
      if (this.jdField_a_of_type_ArrayOfLga == null)
      {
        this.jdField_a_of_type_Lgb = new lgb();
        this.jdField_a_of_type_ArrayOfLga = new lga[this.jdField_a_of_type_Lgb.a.length];
      }
      return this.jdField_a_of_type_ArrayOfLga;
    }
    finally {}
  }
  
  private int b(int paramInt, boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_Lfz != null)
    {
      i = 0;
      int j = -1;
      while (i < this.jdField_a_of_type_Lfz.a.length)
      {
        if (this.jdField_a_of_type_Lfz.a[i] == paramInt) {
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
          String str = anvx.a(2131700389) + paramInt + "]，需要在C2CDataHandlerArray中添加";
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
  
  public int a(ArrayList<loj> paramArrayList)
  {
    int i = 0;
    lga[] arrayOflga = this.jdField_a_of_type_ArrayOfLga;
    if (arrayOflga == null) {
      return 0;
    }
    int k;
    for (int j = 0; i < arrayOflga.length; j = k)
    {
      Object localObject = arrayOflga[i];
      k = j;
      if (localObject != null)
      {
        localObject = ((lga)localObject).a();
        k = j;
        if (localObject != null)
        {
          paramArrayList.add(localObject);
          k = j + ((loj)localObject).a();
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
    lga[] arrayOflga;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      arrayOflga = this.jdField_a_of_type_ArrayOfLga;
      if (arrayOflga != null) {}
    }
    else
    {
      return;
    }
    paramArrayOfByte = lok.a(paramArrayOfByte);
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
      lga locallga = arrayOflga[k];
      if (locallga != null) {
        locallga.a(paramString, (loj)paramArrayOfByte.valueAt(i));
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
  
  public boolean a(int paramInt, lfy paramlfy)
  {
    lfy[] arrayOflfy = a();
    paramInt = b(paramInt, true);
    if (arrayOflfy[paramInt] == null)
    {
      arrayOflfy[paramInt] = paramlfy;
      return true;
    }
    lzr.a("registerC2CDataHandler重复注册");
    return false;
  }
  
  public boolean a(int paramInt, lga paramlga)
  {
    Object localObject = BaseApplicationImpl.getContext();
    localObject = VideoController.a().a((Context)localObject);
    if (localObject == null)
    {
      lzr.a("registerFrameDataHandler, EffectController为空");
      return false;
    }
    ((lpe)localObject).a(4);
    localObject = a();
    paramInt = a(paramInt, true);
    if (localObject[paramInt] == null)
    {
      localObject[paramInt] = paramlga;
      return true;
    }
    lzr.a("registerFrameDataHandler重复注册");
    return false;
  }
  
  public boolean a(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfLfy;
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
    return ((lfy)localObject).a(paramInt, ByteBuffer.wrap(paramArrayOfByte).getInt(), lok.a(paramArrayOfByte, 4, paramArrayOfByte.length - 4));
  }
  
  public boolean b(int paramInt, lga paramlga)
  {
    paramInt = a(paramInt, true);
    lga[] arrayOflga = this.jdField_a_of_type_ArrayOfLga;
    if ((arrayOflga != null) && (arrayOflga[paramInt] != null) && (paramlga.equals(arrayOflga[paramInt])))
    {
      arrayOflga[paramInt] = null;
      return true;
    }
    lzr.a("unregisterFrameDataHandler取消注册失败");
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
      l = mur.a(paramToServiceMsg);
    }
    if (QLog.isDevelopLevel()) {
      QLog.w("AVDataSender", 1, "onReceive, serviceCmd[" + "null" + "], seq[" + l + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lfx
 * JD-Core Version:    0.7.0.1
 */