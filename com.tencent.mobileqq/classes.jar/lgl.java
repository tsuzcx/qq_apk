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

public class lgl
  extends ajtb
{
  lgn jdField_a_of_type_Lgn = null;
  lgp jdField_a_of_type_Lgp = null;
  private lgm[] jdField_a_of_type_ArrayOfLgm;
  private lgo[] jdField_a_of_type_ArrayOfLgo;
  
  public lgl(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_Lgp != null)
    {
      i = 0;
      int j = -1;
      while (i < this.jdField_a_of_type_Lgp.a.length)
      {
        if (this.jdField_a_of_type_Lgp.a[i] == paramInt) {
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
          String str = ajya.a(2131700888) + paramInt + "]，需要在FrameDataHandlerArray中添加";
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
  
  public static lgl a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return null;
    }
    return (lgl)paramVideoAppInterface.a(3);
  }
  
  private lgm[] a()
  {
    if (this.jdField_a_of_type_ArrayOfLgm == null) {}
    try
    {
      if (this.jdField_a_of_type_ArrayOfLgm == null)
      {
        this.jdField_a_of_type_Lgn = new lgn();
        this.jdField_a_of_type_ArrayOfLgm = new lgm[this.jdField_a_of_type_Lgn.a.length];
      }
      return this.jdField_a_of_type_ArrayOfLgm;
    }
    finally {}
  }
  
  private lgo[] a()
  {
    if (this.jdField_a_of_type_ArrayOfLgo == null) {}
    try
    {
      if (this.jdField_a_of_type_ArrayOfLgo == null)
      {
        this.jdField_a_of_type_Lgp = new lgp();
        this.jdField_a_of_type_ArrayOfLgo = new lgo[this.jdField_a_of_type_Lgp.a.length];
      }
      return this.jdField_a_of_type_ArrayOfLgo;
    }
    finally {}
  }
  
  private int b(int paramInt, boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_Lgn != null)
    {
      i = 0;
      int j = -1;
      while (i < this.jdField_a_of_type_Lgn.a.length)
      {
        if (this.jdField_a_of_type_Lgn.a[i] == paramInt) {
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
          String str = ajya.a(2131700890) + paramInt + "]，需要在C2CDataHandlerArray中添加";
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
  
  public int a(ArrayList<lpa> paramArrayList)
  {
    int i = 0;
    lgo[] arrayOflgo = this.jdField_a_of_type_ArrayOfLgo;
    if (arrayOflgo == null) {
      return 0;
    }
    int k;
    for (int j = 0; i < arrayOflgo.length; j = k)
    {
      Object localObject = arrayOflgo[i];
      k = j;
      if (localObject != null)
      {
        localObject = ((lgo)localObject).a();
        k = j;
        if (localObject != null)
        {
          paramArrayList.add(localObject);
          k = j + ((lpa)localObject).a();
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
    lgo[] arrayOflgo;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      arrayOflgo = this.jdField_a_of_type_ArrayOfLgo;
      if (arrayOflgo != null) {}
    }
    else
    {
      return;
    }
    paramArrayOfByte = lpb.a(paramArrayOfByte);
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
      lgo locallgo = arrayOflgo[k];
      if (locallgo != null) {
        locallgo.a(paramString, (lpa)paramArrayOfByte.valueAt(i));
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
  
  public boolean a(int paramInt, lgm paramlgm)
  {
    lgm[] arrayOflgm = a();
    paramInt = b(paramInt, true);
    if (arrayOflgm[paramInt] == null)
    {
      arrayOflgm[paramInt] = paramlgm;
      return true;
    }
    lze.a("registerC2CDataHandler重复注册");
    return false;
  }
  
  public boolean a(int paramInt, lgo paramlgo)
  {
    Object localObject = BaseApplicationImpl.getContext();
    localObject = VideoController.a().a((Context)localObject);
    if (localObject == null)
    {
      lze.a("registerFrameDataHandler, EffectController为空");
      return false;
    }
    ((lpt)localObject).a(4);
    localObject = a();
    paramInt = a(paramInt, true);
    if (localObject[paramInt] == null)
    {
      localObject[paramInt] = paramlgo;
      return true;
    }
    lze.a("registerFrameDataHandler重复注册");
    return false;
  }
  
  public boolean a(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfLgm;
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
    return ((lgm)localObject).a(paramInt, ByteBuffer.wrap(paramArrayOfByte).getInt(), lpb.a(paramArrayOfByte, 4, paramArrayOfByte.length - 4));
  }
  
  public boolean b(int paramInt, lgo paramlgo)
  {
    paramInt = a(paramInt, true);
    lgo[] arrayOflgo = this.jdField_a_of_type_ArrayOfLgo;
    if ((arrayOflgo != null) && (arrayOflgo[paramInt] != null) && (paramlgo.equals(arrayOflgo[paramInt])))
    {
      arrayOflgo[paramInt] = null;
      return true;
    }
    lze.a("unregisterFrameDataHandler取消注册失败");
    return false;
  }
  
  protected Class<? extends ajte> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = 0L;
    if (paramToServiceMsg != null) {
      l = mtj.a(paramToServiceMsg);
    }
    if (QLog.isDevelopLevel()) {
      QLog.w("AVDataSender", 1, "onReceive, serviceCmd[" + "null" + "], seq[" + l + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lgl
 * JD-Core Version:    0.7.0.1
 */