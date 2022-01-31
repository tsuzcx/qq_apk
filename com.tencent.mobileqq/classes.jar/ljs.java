import android.graphics.Bitmap;
import android.graphics.PointF;
import android.util.SparseArray;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;

public class ljs
  extends ljj
{
  private long jdField_a_of_type_Long;
  private WeakReference<ljt> jdField_a_of_type_JavaLangRefWeakReference;
  private Map<String, ljv> jdField_a_of_type_JavaUtilMap = new HashMap();
  protected volatile boolean a;
  
  public ljs(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    super(paramLong, paramVideoAppInterface);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject1 = lpb.a(paramArrayOfByte);
    paramArrayOfByte = (lpa)((SparseArray)localObject1).get(1);
    Object localObject2 = (lpa)((SparseArray)localObject1).get(4);
    int i;
    if (localObject2 != null)
    {
      paramArrayOfByte = ((lpa)localObject2).a();
      i = 1;
    }
    for (;;)
    {
      int j;
      int k;
      int m;
      label162:
      int n;
      float f1;
      label192:
      float f2;
      if (paramArrayOfByte != null)
      {
        localObject1 = (lpa)((SparseArray)localObject1).get(3);
        if (localObject1 != null)
        {
          localObject1 = ((lpa)localObject1).a();
          j = localObject1[0];
          k = (short)(localObject1[1] & 0xFF | j << 8);
          m = (short)(localObject1[2] << 8 | localObject1[3] & 0xFF);
          j = (short)(localObject1[4] << 8 | localObject1[5] & 0xFF);
          j = localObject1[6];
          j = (short)(localObject1[7] & 0xFF | j << 8);
          if (i != 0)
          {
            j = 4;
            n = j * 81 * 2;
            paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
            if (i == 0) {
              break label472;
            }
            f1 = paramArrayOfByte.getInt(n) / 1000000;
            if (i == 0) {
              break label483;
            }
            f2 = paramArrayOfByte.getInt(n + j) / 1000000;
            label212:
            localObject1 = new PointF(f1, f2);
            if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().b(paramString) == 4) {
              break label588;
            }
            f1 = m - f1;
          }
        }
      }
      label290:
      label310:
      label588:
      for (;;)
      {
        localObject2 = new PointF(f1 / m, f2 / k);
        k = j * 73 * 2;
        PointF localPointF1;
        label347:
        label367:
        PointF localPointF2;
        if (i != 0)
        {
          f1 = paramArrayOfByte.getInt(k) / 1000000;
          if (i == 0) {
            break label509;
          }
          f2 = paramArrayOfByte.getInt(k + j) / 1000000;
          localPointF1 = new PointF(f1, f2);
          k = j * 65 * 2;
          if (i == 0) {
            break label524;
          }
          f1 = paramArrayOfByte.getInt(k) / 1000000;
          if (i == 0) {
            break label535;
          }
          f2 = paramArrayOfByte.getInt(k + j) / 1000000;
          localPointF2 = new PointF(f1, f2);
          k = j * 66 * 2;
          if (i == 0) {
            break label550;
          }
          f1 = paramArrayOfByte.getInt(k) / 1000000;
          if (i == 0) {
            break label561;
          }
        }
        for (f2 = paramArrayOfByte.getInt(j + k) / 1000000;; f2 = paramArrayOfByte.getShort(j + k))
        {
          a(paramString, (PointF)localObject2, ljo.a(localPointF2, new PointF(f1, f2), (PointF)localObject1, localPointF1));
          return;
          if (paramArrayOfByte == null) {
            break label591;
          }
          paramArrayOfByte = paramArrayOfByte.a();
          i = 0;
          break;
          j = 2;
          break label162;
          label472:
          f1 = paramArrayOfByte.getShort(n);
          break label192;
          label483:
          f2 = paramArrayOfByte.getShort(n + j);
          break label212;
          f1 = paramArrayOfByte.getShort(k);
          break label290;
          label509:
          f2 = paramArrayOfByte.getShort(k + j);
          break label310;
          f1 = paramArrayOfByte.getShort(k);
          break label347;
          f2 = paramArrayOfByte.getShort(k + j);
          break label367;
          f1 = paramArrayOfByte.getShort(k);
          break label404;
        }
        b(paramString);
        return;
        b(paramString);
        return;
      }
      label404:
      label535:
      label550:
      label561:
      label591:
      paramArrayOfByte = null;
      label524:
      i = 0;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    lcg.c("ARZimuTask_SpitZimuTask", "onSmallScreenMoveChanged");
    lju locallju = a();
    if (locallju == null) {
      return;
    }
    lcg.c("ARZimuTask_SpitZimuTask", "taskPlayer has");
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      locallju.setDrawParticle(paramBoolean);
      locallju.a(false);
      return;
    }
  }
  
  public int a()
  {
    return 300;
  }
  
  PointF a(String paramString, boolean paramBoolean)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {}
    for (paramString = (ljv)this.jdField_a_of_type_JavaUtilMap.get(paramString);; paramString = null)
    {
      if (paramString == null)
      {
        lcg.c("ARZimuTask_SpitZimuTask", "tryGetMouthInfoByUin info == null");
        return null;
      }
      if (!paramString.a())
      {
        lcg.c("ARZimuTask_SpitZimuTask", "tryGetMouthInfoByUin info.checkIsOpenMouth() = false");
        paramString.a();
        return null;
      }
      PointF localPointF = paramString.jdField_a_of_type_AndroidGraphicsPointF;
      paramString.a();
      paramString = localPointF;
      if (paramBoolean) {
        break;
      }
      paramString = localPointF;
      if (localPointF == null) {
        break;
      }
      return ljj.a(localPointF);
    }
  }
  
  protected List<lji> a(lhc paramlhc, boolean paramBoolean)
  {
    c();
    ArrayList localArrayList = new ArrayList();
    paramlhc = new ljr(paramlhc, paramBoolean);
    paramlhc.a(paramBoolean);
    paramlhc.b = true;
    paramlhc.a(this.jdField_a_of_type_AndroidGraphicsTypeface, 32, null);
    localArrayList.add(paramlhc);
    return localArrayList;
  }
  
  ljt a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (ljt)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  lju a()
  {
    ljm localljm = super.a();
    if ((localljm == null) || (!(localljm instanceof lju))) {
      return null;
    }
    return (lju)localljm;
  }
  
  public void a()
  {
    super.a();
    b(0);
    b(1);
    b(true);
    this.jdField_a_of_type_Long = (System.currentTimeMillis() / 1000L);
  }
  
  void a(String paramString, PointF paramPointF, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      localObject1 = (ljv)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      Object localObject2 = ((ljv)localObject1).jdField_a_of_type_AndroidGraphicsPointF;
      StringBuilder localStringBuilder = new StringBuilder().append("updateMouthInfo, temp[");
      boolean bool;
      if (localObject2 == null)
      {
        bool = true;
        QLog.w("ARZimuTask_SpitZimuTask", 1, bool + "], uin[" + paramString + "], isOpenMouth[" + paramBoolean + "], pointF[" + paramPointF.x + "->" + paramPointF.y + "]");
        ((ljv)localObject1).a(paramPointF);
        ((ljv)localObject1).jdField_a_of_type_Boolean = paramBoolean;
        if (!paramBoolean) {
          break label270;
        }
        ((ljv)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
        if ((paramPointF.x < 0.0F) || (paramPointF.y < 0.0F)) {
          break label176;
        }
        a(paramString, (ljv)localObject1);
      }
      label176:
      label380:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  bool = false;
                  break;
                  paramPointF = a();
                } while (paramPointF == null);
                localObject1 = a();
                localObject2 = b();
                if ((localObject1 != null) && (((String)localObject1).equals(paramString)))
                {
                  paramPointF.a(true);
                  return;
                }
                if ((localObject2 != null) && (((String)localObject2).equals(paramString)))
                {
                  paramPointF.a(false);
                  return;
                }
                localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
              } while ((localObject1 == null) || (!((String)localObject1).equals(paramString)));
              paramPointF.a(true);
              return;
              if (System.currentTimeMillis() - ((ljv)localObject1).jdField_a_of_type_Long <= 1500L) {
                break label380;
              }
              paramPointF = a();
            } while (paramPointF == null);
            localObject1 = a();
            localObject2 = b();
            if ((localObject1 != null) && (((String)localObject1).equals(paramString)))
            {
              paramPointF.a(true);
              return;
            }
            if ((localObject2 != null) && (((String)localObject2).equals(paramString)))
            {
              paramPointF.a(false);
              return;
            }
            localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
          } while ((localObject1 == null) || (!((String)localObject1).equals(paramString)));
          paramPointF.a(true);
          return;
          if ((paramPointF.x > 0.0F) && (paramPointF.y > 0.0F))
          {
            a(paramString, (ljv)localObject1);
            return;
          }
          paramPointF = a();
        } while (paramPointF == null);
        localObject1 = a();
        localObject2 = b();
        if ((localObject1 != null) && (((String)localObject1).equals(paramString)))
        {
          paramPointF.a(true);
          return;
        }
        if ((localObject2 != null) && (((String)localObject2).equals(paramString)))
        {
          paramPointF.a(false);
          return;
        }
        localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      } while ((localObject1 == null) || (!((String)localObject1).equals(paramString)));
      label270:
      paramPointF.a(true);
      return;
    }
    Object localObject1 = new ljv();
    ((ljv)localObject1).a(paramPointF);
    ((ljv)localObject1).jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      ((ljv)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject1);
    QLog.w("ARZimuTask_SpitZimuTask", 1, "updateMouthInfo, uin[" + paramString + "], isOpenMouth[" + paramBoolean + "], pointF[" + paramPointF.x + "->" + paramPointF.y + "]");
  }
  
  void a(String paramString, ljv paramljv)
  {
    if (paramString == null) {}
    lju locallju;
    ljv localljv;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            locallju = a();
          } while (locallju == null);
          localljv = paramljv;
          if (paramljv == null)
          {
            localljv = paramljv;
            if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
              localljv = (ljv)this.jdField_a_of_type_JavaUtilMap.get(paramString);
            }
          }
        } while (localljv == null);
        paramljv = a();
        if ((paramljv == null) || (!paramljv.equals(paramString))) {
          break;
        }
      } while (!localljv.a());
      locallju.a(localljv.jdField_a_of_type_AndroidGraphicsPointF.x, localljv.jdField_a_of_type_AndroidGraphicsPointF.y, true);
      return;
      paramljv = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    } while ((paramljv == null) || (!paramljv.equals(paramString)) || (!localljv.a()));
    locallju.a(localljv.jdField_a_of_type_AndroidGraphicsPointF.x, localljv.jdField_a_of_type_AndroidGraphicsPointF.y, true);
  }
  
  protected void a(Observable paramObservable, Object paramObject)
  {
    super.a(paramObservable, paramObject);
    paramObservable = (Object[])paramObject;
    int i = ((Integer)paramObservable[0]).intValue();
    switch (i)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              a((String)paramObservable[1], (byte[])paramObservable[2]);
              return;
              c(((Boolean)paramObservable[1]).booleanValue());
              return;
            } while (this.jdField_a_of_type_Ljm == null);
            lcg.c("ARZimuTask_SpitZimuTask", "handleSubNotify msgType:" + i);
          } while (!this.jdField_a_of_type_Boolean);
          this.jdField_a_of_type_Ljm.b();
          this.jdField_a_of_type_Boolean = false;
          return;
        } while (this.jdField_a_of_type_Ljm == null);
        this.jdField_a_of_type_Ljm.a();
        this.jdField_a_of_type_Boolean = true;
        return;
      } while (this.jdField_a_of_type_Ljm == null);
      paramObservable = a();
    } while (paramObservable == null);
    paramObservable.a(true);
    paramObservable.a(false);
  }
  
  void a(lji paramlji)
  {
    lcg.c("ARZimuTask_SpitZimuTask", "requestRender, begin");
    lju locallju = a();
    if (locallju == null)
    {
      lcg.c("ARZimuTask_SpitZimuTask", "requestRender, taskPlayer is null");
      return;
    }
    lcg.c("ARZimuTask_SpitZimuTask", "requestRender, taskPlayer has");
    if ((paramlji instanceof ljr)) {
      paramlji = (ljr)paramlji;
    }
    for (;;)
    {
      Object localObject1;
      if (paramlji == null)
      {
        lcg.c("ARZimuTask_SpitZimuTask", "requestRender, spitZimuItemTask is null");
        return;
        paramlji = this.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!paramlji.hasNext()) {
            break;
          }
          localObject1 = (lji)paramlji.next();
        } while ((!((lji)localObject1).b()) || (!(localObject1 instanceof ljr)));
        paramlji = (ljr)localObject1;
      }
      else
      {
        localObject1 = a();
        Object localObject2 = b();
        String str = paramlji.a.jdField_a_of_type_JavaLangString;
        boolean bool;
        if ((localObject1 != null) && (str.equals(localObject1))) {
          bool = true;
        }
        for (;;)
        {
          localObject1 = a((String)localObject1, bool);
          if (localObject1 != null) {
            break label406;
          }
          locallju.a(bool);
          lcg.c("ARZimuTask_SpitZimuTask", "requestRender, mouthPoint is null");
          return;
          if ((localObject2 != null) && (str.equals(localObject2)))
          {
            localObject1 = localObject2;
            bool = false;
          }
          else
          {
            if (localObject1 != null)
            {
              lcg.c("ARZimuTask_SpitZimuTask", "requestRender, uin not equal currentPlayUin=" + (String)localObject1 + " taskUin=" + str);
              paramlji.b = false;
              return;
            }
            if (localObject2 != null)
            {
              lcg.c("ARZimuTask_SpitZimuTask", "requestRender, uin not equal smallScreenUin=" + (String)localObject2 + " taskUin=" + str);
              paramlji.b = false;
              return;
            }
            localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
            if ((localObject1 == null) || (!str.equals(localObject1))) {
              break;
            }
            lcg.c("ARZimuTask_SpitZimuTask", "requestRender, uin not equal currentPlayUin&smallScreenUin=null selfUin=" + (String)localObject1 + " taskUin=" + str);
            bool = true;
          }
        }
        lcg.c("ARZimuTask_SpitZimuTask", "requestRender, uin not equal currentPlayUin&smallScreenUin&selfUin=null taskUin=" + str);
        paramlji.b = false;
        return;
        label406:
        lcg.c("ARZimuTask_SpitZimuTask", "requestRender, spitZimuItemTask=" + paramlji.a.jdField_a_of_type_JavaLangCharSequence);
        locallju.a(((PointF)localObject1).x, ((PointF)localObject1).y, bool);
        lcg.c("ARZimuTask_SpitZimuTask", "requestRender, updateEmitterLocation=" + ((PointF)localObject1).x + "|" + ((PointF)localObject1).y);
        localObject1 = paramlji.b();
        if (localObject1 != null)
        {
          int i = ((Bitmap)localObject1).getWidth();
          int j = ((Bitmap)localObject1).getHeight();
          int k = ((Bitmap)localObject1).getByteCount();
          localObject2 = ByteBuffer.allocate(k);
          ((Bitmap)localObject1).copyPixelsToBuffer((Buffer)localObject2);
          locallju.a(((ByteBuffer)localObject2).array(), i, j, bool);
          lcg.c("ARZimuTask_SpitZimuTask", "requestRender, updateParticleTexture=" + i + "|" + j + "|" + k);
          paramlji.b = false;
        }
        while (paramlji.a.a())
        {
          locallju.a(bool);
          lcg.c("ARZimuTask_SpitZimuTask", "requestRender, isEnd");
          return;
          lcg.c("ARZimuTask_SpitZimuTask", "requestRender, bitmap is null");
        }
        break;
        paramlji = null;
      }
    }
  }
  
  public void a(ljt paramljt)
  {
    QLog.w("ARZimuTask_SpitZimuTask", 1, "setMouthDetectorWeakReference, detector[" + paramljt + "]");
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramljt);
  }
  
  public void b()
  {
    super.b();
    c(0);
    c(1);
    b(false);
    this.jdField_a_of_type_JavaUtilMap.clear();
    lju locallju = a();
    if (locallju != null)
    {
      locallju.a(true);
      locallju.a(false);
    }
  }
  
  public void b(int paramInt)
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((ljt)localObject).a();
      if (localObject != null)
      {
        localObject = ((VideoController)localObject).a(((VideoController)localObject).a());
        if (localObject != null) {
          ((lpu)localObject).a(paramInt);
        }
        return;
      }
      QLog.w("ARZimuTask_SpitZimuTask", 1, "setExp, controller为空, type[" + paramInt + "]", new Throwable("打印调用栈"));
      return;
    }
    QLog.w("ARZimuTask_SpitZimuTask", 1, "setExp, IMouthDetector为空, type[" + paramInt + "]", new Throwable("打印调用栈"));
  }
  
  void b(String paramString)
  {
    lju locallju;
    String str2;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      ((ljv)this.jdField_a_of_type_JavaUtilMap.get(paramString)).a();
      locallju = a();
      if (locallju != null)
      {
        String str1 = a();
        str2 = b();
        if (!str1.equals(paramString)) {
          break label63;
        }
        locallju.a(true);
      }
    }
    label63:
    while (!str2.equals(paramString)) {
      return;
    }
    locallju.a(false);
  }
  
  protected void b(boolean paramBoolean)
  {
    Object localObject = a();
    VideoController localVideoController;
    if (localObject != null)
    {
      localVideoController = ((ljt)localObject).a();
      if (localVideoController != null) {
        if (!paramBoolean) {
          break label72;
        }
      }
    }
    label72:
    for (localObject = "START";; localObject = "STOP")
    {
      lcg.c("ARZimuTask_SpitZimuTask", "requestFaceFeatureExp:" + paramBoolean + "|" + (String)localObject);
      localVideoController.a(6, (String)localObject);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((ljt)localObject).a();
      if (localObject != null)
      {
        localObject = ((VideoController)localObject).a(((VideoController)localObject).a());
        if (localObject != null) {
          ((lpu)localObject).c(paramInt);
        }
      }
    }
  }
  
  public String d()
  {
    return "spit";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ljs
 * JD-Core Version:    0.7.0.1
 */