import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.ui.VideoLayerUIBase;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.module_switchface.SwitchFaceProcessor;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class mah
{
  private SwitchFaceProcessor jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor;
  private WeakReference<VideoLayerUIBase> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private mak[] jdField_a_of_type_ArrayOfMak = new mak[2];
  
  public mah()
  {
    axlc.c(VideoEnvironment.a());
    bflj.a();
    biht.a();
    this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor = new SwitchFaceProcessor();
    int i = 0;
    while (i < 2)
    {
      this.jdField_a_of_type_ArrayOfMak[i] = new mak();
      i += 1;
    }
  }
  
  private void a(List<PointF> paramList)
  {
    float f1 = ((PointF)paramList.get(55)).x;
    float f2 = (((PointF)paramList.get(63)).x - ((PointF)paramList.get(55)).x) / 2.0F;
    float f3 = ((PointF)paramList.get(55)).y;
    paramList.add(new PointF(f1 + f2, (((PointF)paramList.get(63)).y - ((PointF)paramList.get(55)).y) / 2.0F + f3));
    f1 = ((PointF)paramList.get(23)).x;
    f2 = (((PointF)paramList.get(31)).x - ((PointF)paramList.get(23)).x) / 2.0F;
    f3 = ((PointF)paramList.get(23)).y;
    paramList.add(new PointF(f1 + f2, (((PointF)paramList.get(31)).y - ((PointF)paramList.get(23)).y) / 2.0F + f3));
    f1 = ((PointF)paramList.get(59)).x;
    f2 = (((PointF)paramList.get(77)).x - ((PointF)paramList.get(59)).x) / 2.0F;
    f3 = ((PointF)paramList.get(59)).y;
    paramList.add(new PointF(f1 + f2, (((PointF)paramList.get(77)).y - ((PointF)paramList.get(59)).y) / 2.0F + f3));
    f1 = ((PointF)paramList.get(35)).x;
    f2 = ((PointF)paramList.get(35)).x;
    f3 = ((PointF)paramList.get(6)).x;
    float f4 = ((PointF)paramList.get(35)).y;
    paramList.add(new PointF(f1 + (f2 - f3), ((PointF)paramList.get(35)).y - ((PointF)paramList.get(6)).y + f4));
    f1 = ((PointF)paramList.get(64)).x;
    f2 = ((PointF)paramList.get(64)).x;
    f3 = ((PointF)paramList.get(9)).x;
    f4 = ((PointF)paramList.get(64)).y;
    paramList.add(new PointF(f1 + (f2 - f3) * 1.4F, (((PointF)paramList.get(64)).y - ((PointF)paramList.get(9)).y) * 1.4F + f4));
    f1 = ((PointF)paramList.get(45)).x;
    f2 = ((PointF)paramList.get(45)).x;
    f3 = ((PointF)paramList.get(12)).x;
    f4 = ((PointF)paramList.get(45)).y;
    paramList.add(new PointF(f1 + (f2 - f3), ((PointF)paramList.get(45)).y - ((PointF)paramList.get(12)).y + f4));
    f1 = ((PointF)paramList.get(83)).x;
    f2 = ((PointF)paramList.get(83)).x;
    f3 = ((PointF)paramList.get(59)).x;
    f4 = ((PointF)paramList.get(83)).y;
    paramList.add(new PointF(f1 + (f2 - f3), ((PointF)paramList.get(83)).y - ((PointF)paramList.get(59)).y + f4));
  }
  
  private void a(maj parammaj)
  {
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor.destroy();
      this.jdField_a_of_type_Boolean = false;
      int i = 0;
      while (i < parammaj.jdField_a_of_type_ArrayOfMai.length)
      {
        if (parammaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_Mee != null) {
          parammaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_Mee.a(0, 0, 0);
        }
        this.jdField_a_of_type_ArrayOfMak[i].b();
        i += 1;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SwitchFaceView", 2, "WL_DEBUG onDestroy e = " + localThrowable);
        }
      }
    }
  }
  
  public void a()
  {
    int i = 0;
    while (i < 2)
    {
      this.jdField_a_of_type_ArrayOfMak[i].a();
      i += 1;
    }
  }
  
  public void a(VideoAppInterface paramVideoAppInterface, lqt paramlqt)
  {
    long l5 = System.currentTimeMillis();
    long l3 = 0L;
    long l4 = 0L;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    long l2;
    long l1;
    maj localmaj;
    int m;
    int k;
    int j;
    Object localObject;
    int n;
    int i;
    for (VideoLayerUIBase localVideoLayerUIBase = (VideoLayerUIBase)this.jdField_a_of_type_JavaLangRefWeakReference.get();; localVideoLayerUIBase = null)
    {
      l2 = l3;
      l1 = l4;
      if (localVideoLayerUIBase == null) {
        break label1689;
      }
      localmaj = new maj(this);
      localmaj.jdField_a_of_type_Lqt = paramlqt;
      m = 0;
      k = 1;
      j = 0;
      while (j < localVideoLayerUIBase.jdField_a_of_type_ArrayOfMee.length)
      {
        paramlqt = localVideoLayerUIBase.jdField_a_of_type_ArrayOfMee[j];
        localObject = paramlqt.b();
        int i1 = paramlqt.e();
        if (m >= localmaj.jdField_a_of_type_ArrayOfMai.length) {
          break;
        }
        n = k;
        i = m;
        if (paramlqt.a() == 0)
        {
          n = k;
          i = m;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localmaj.jdField_a_of_type_ArrayOfMai[m].jdField_a_of_type_Mee = paramlqt;
            m += 1;
            n = k;
            i = m;
            if (i1 != 0)
            {
              n = 0;
              i = m;
            }
          }
        }
        j += 1;
        k = n;
        m = i;
      }
    }
    boolean bool;
    if ((m == localmaj.jdField_a_of_type_ArrayOfMai.length) && (k != 0) && (paramVideoAppInterface != null) && (paramVideoAppInterface.a(3)))
    {
      paramVideoAppInterface = (FaceItem)((lhw)paramVideoAppInterface.a(3)).a();
      if ((paramVideoAppInterface != null) && (!TextUtils.isEmpty(paramVideoAppInterface.getId())) && ("huanlian".equalsIgnoreCase(paramVideoAppInterface.getId())))
      {
        bool = true;
        if (QLog.isColorLevel())
        {
          paramlqt = new StringBuilder().append("WL_DEBUG isSelectedSwitchFace = ").append(bool).append("|");
          if (paramVideoAppInterface != null) {
            break label1155;
          }
          paramVideoAppInterface = "null";
          label311:
          QLog.d("SwitchFaceView", 2, paramVideoAppInterface);
        }
        if (!bool) {
          break label1969;
        }
        i = 0;
        label333:
        if (i >= 2) {
          break label1312;
        }
        paramVideoAppInterface = localmaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_Mee.a();
        localmaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_ArrayOfByte = paramVideoAppInterface.a();
        localmaj.jdField_a_of_type_ArrayOfMai[i].c = paramVideoAppInterface.k();
        localmaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_Int = paramVideoAppInterface.h();
        localmaj.jdField_a_of_type_ArrayOfMai[i].b = paramVideoAppInterface.i();
        localmaj.jdField_a_of_type_ArrayOfMai[i].d = paramVideoAppInterface.j();
        if (localmaj.jdField_a_of_type_ArrayOfMai[i].d % 2 != 0) {
          break label1163;
        }
        localmaj.jdField_a_of_type_ArrayOfMai[i].e = localmaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_Int;
        localmaj.jdField_a_of_type_ArrayOfMai[i].f = localmaj.jdField_a_of_type_ArrayOfMai[i].b;
        label489:
        paramlqt = localmaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_Mee.b();
        paramVideoAppInterface = paramVideoAppInterface.c();
        if (paramVideoAppInterface == null) {
          break label2021;
        }
      }
    }
    label579:
    label2021:
    for (paramVideoAppInterface = new mac(paramVideoAppInterface);; paramVideoAppInterface = null)
    {
      float f1;
      if ((paramVideoAppInterface != null) && (paramVideoAppInterface.jdField_a_of_type_ArrayOfByte != null))
      {
        localObject = ByteBuffer.wrap(paramVideoAppInterface.jdField_a_of_type_ArrayOfByte);
        localmaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        if (localVideoLayerUIBase.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().b(paramlqt) != 2) {
          break label1210;
        }
        j = 1;
        if (localmaj.jdField_a_of_type_ArrayOfMai[i].e * paramVideoAppInterface.b >= localmaj.jdField_a_of_type_ArrayOfMai[i].f * paramVideoAppInterface.jdField_a_of_type_Short) {
          break label1216;
        }
        k = paramVideoAppInterface.jdField_a_of_type_Short * localmaj.jdField_a_of_type_ArrayOfMai[i].f / paramVideoAppInterface.b;
        m = (localmaj.jdField_a_of_type_ArrayOfMai[i].e - k) / 2;
        k = 0;
        f1 = localmaj.jdField_a_of_type_ArrayOfMai[i].f / paramVideoAppInterface.b / 1000000.0F;
        n = 0;
      }
      for (;;)
      {
        if (n < ((ByteBuffer)localObject).capacity())
        {
          paramVideoAppInterface = new PointF();
          paramVideoAppInterface.x = (m + ((ByteBuffer)localObject).getInt(n) * f1);
          paramVideoAppInterface.y = (k + ((ByteBuffer)localObject).getInt(n + 4) * f1);
          if (j != 0) {
            paramVideoAppInterface.x = (localmaj.jdField_a_of_type_ArrayOfMai[i].e - paramVideoAppInterface.x);
          }
          if ((paramVideoAppInterface.x < 0.0F) || (paramVideoAppInterface.x > localmaj.jdField_a_of_type_ArrayOfMai[i].e) || (paramVideoAppInterface.y < 0.0F) || (paramVideoAppInterface.y > localmaj.jdField_a_of_type_ArrayOfMai[i].f)) {
            localmaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_JavaUtilArrayList = null;
          }
        }
        else
        {
          if (localmaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_JavaUtilArrayList != null)
          {
            if (localmaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_JavaUtilArrayList.size() == 83) {
              a(localmaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_JavaUtilArrayList);
            }
            f1 = Math.abs(((PointF)localmaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_JavaUtilArrayList.get(0)).x - ((PointF)localmaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_JavaUtilArrayList.get(64)).x);
            float f2 = Math.abs(((PointF)localmaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_JavaUtilArrayList.get(18)).x - ((PointF)localmaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_JavaUtilArrayList.get(64)).x);
            float f3 = Math.abs(((PointF)localmaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_JavaUtilArrayList.get(89)).y - ((PointF)localmaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_JavaUtilArrayList.get(64)).y);
            float f4 = Math.abs(((PointF)localmaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_JavaUtilArrayList.get(9)).y - ((PointF)localmaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_JavaUtilArrayList.get(64)).y);
            if ((6.0F * f1 < f2) || (f1 > f2 * 6.0F) || (6.0F * f3 < f4) || (f3 > f4 * 6.0F)) {
              localmaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_JavaUtilArrayList = null;
            }
          }
          i += 1;
          break label333;
          bool = false;
          break;
          paramVideoAppInterface = paramVideoAppInterface.getId();
          break label311;
          localmaj.jdField_a_of_type_ArrayOfMai[i].e = localmaj.jdField_a_of_type_ArrayOfMai[i].b;
          localmaj.jdField_a_of_type_ArrayOfMai[i].f = localmaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_Int;
          break label489;
          j = 0;
          break label579;
          k = paramVideoAppInterface.b * localmaj.jdField_a_of_type_ArrayOfMai[i].e / paramVideoAppInterface.jdField_a_of_type_Short;
          m = 0;
          k = (localmaj.jdField_a_of_type_ArrayOfMai[i].f - k) / 2;
          f1 = localmaj.jdField_a_of_type_ArrayOfMai[i].e / paramVideoAppInterface.jdField_a_of_type_Short / 1000000.0F;
          break label681;
        }
        localmaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_JavaUtilArrayList.add(paramVideoAppInterface);
        n += 8;
      }
      i = 0;
      while (i < 2)
      {
        this.jdField_a_of_type_ArrayOfMak[i].a(localmaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_Int, localmaj.jdField_a_of_type_ArrayOfMai[i].b, localmaj.jdField_a_of_type_ArrayOfMai[i].c, localmaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_ArrayOfByte, localmaj.jdField_a_of_type_ArrayOfMai[i].d);
        i += 1;
      }
      for (;;)
      {
        try
        {
          if ((GLES20.glCheckFramebufferStatus(36160) == 36053) && (!CollectionUtils.isEmpty(localmaj.jdField_a_of_type_ArrayOfMai[0].jdField_a_of_type_JavaUtilArrayList)) && (!CollectionUtils.isEmpty(localmaj.jdField_a_of_type_ArrayOfMai[1].jdField_a_of_type_JavaUtilArrayList))) {
            l2 = System.currentTimeMillis();
          }
        }
        catch (RuntimeException paramVideoAppInterface)
        {
          l2 = 0L;
          l1 = 0L;
        }
        try
        {
          if ((!this.jdField_a_of_type_Boolean) && (lpz.e()) && (apvb.a(mag.a)))
          {
            this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor.init();
            this.jdField_a_of_type_Boolean = true;
          }
          paramVideoAppInterface = this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor.process(this.jdField_a_of_type_ArrayOfMak[0].a(), localmaj.jdField_a_of_type_ArrayOfMai[0].jdField_a_of_type_JavaUtilArrayList, localmaj.jdField_a_of_type_ArrayOfMai[0].e, localmaj.jdField_a_of_type_ArrayOfMai[0].f, this.jdField_a_of_type_ArrayOfMak[1].a(), localmaj.jdField_a_of_type_ArrayOfMai[1].jdField_a_of_type_JavaUtilArrayList, localmaj.jdField_a_of_type_ArrayOfMai[1].e, localmaj.jdField_a_of_type_ArrayOfMai[1].f);
          l1 = System.currentTimeMillis();
          i = 0;
          if (i >= 2) {}
        }
        catch (RuntimeException paramVideoAppInterface)
        {
          for (;;)
          {
            l1 = 0L;
          }
        }
        try
        {
          localmaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_Mee.a(paramVideoAppInterface[i], localmaj.jdField_a_of_type_ArrayOfMai[i].e, localmaj.jdField_a_of_type_ArrayOfMai[i].f);
          i += 1;
        }
        catch (RuntimeException paramVideoAppInterface)
        {
          break label1847;
          l1 = 0L;
          l2 = 0L;
        }
      }
      l3 = l1;
      l4 = l2;
      if ((localmaj.jdField_a_of_type_Lqt instanceof lqu))
      {
        GLES20.glViewport(0, 0, ((lqu)localmaj.jdField_a_of_type_Lqt).c(), ((lqu)localmaj.jdField_a_of_type_Lqt).d());
        l4 = l2;
        l3 = l1;
      }
      l1 = l3;
      l2 = l4;
      for (;;)
      {
        l3 = System.currentTimeMillis();
        if ((QLog.isColorLevel()) && (l2 != 0L) && (l1 != 0L))
        {
          QLog.d("SwitchFaceView", 2, "WL_DEBUG processFrame_internal before SwitchFaceProcessor.process cost = " + (l2 - l5));
          QLog.d("SwitchFaceView", 2, "WL_DEBUG processFrame_internal SwitchFaceProcessor.process cost = " + (l1 - l2));
          QLog.d("SwitchFaceView", 2, "WL_DEBUG processFrame_internal after SwitchFaceProcessor.process cost = " + (l3 - l1));
        }
        return;
        i = 0;
        while (i < 2)
        {
          localmaj.jdField_a_of_type_ArrayOfMai[i].jdField_a_of_type_Mee.a(0, 0, 0);
          i += 1;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("SwitchFaceView", 2, "WL_DEBUG processFrame_internal e = " + paramVideoAppInterface);
          paramlqt = paramVideoAppInterface.getStackTrace();
          paramVideoAppInterface = "";
          j = paramlqt.length;
          i = 0;
          while (i < j)
          {
            paramVideoAppInterface = paramVideoAppInterface + "WL_DEBUG processFrame_internal ste[" + i + "]" + paramlqt[i].toString() + "\n";
            i += 1;
          }
          QLog.e("SwitchFaceView", 2, paramVideoAppInterface);
        }
        break;
        a(localmaj);
        l3 = 0L;
        l4 = 0L;
        break label1681;
        a(localmaj);
        l2 = l3;
        l1 = l4;
      }
    }
  }
  
  public void a(VideoLayerUIBase paramVideoLayerUIBase)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVideoLayerUIBase);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor.destroy();
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SwitchFaceView", 2, "WL_DEBUG onDestroy e = " + localThrowable);
        }
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor.destroy();
      this.jdField_a_of_type_Boolean = false;
      int i = 0;
      while (i < 2)
      {
        this.jdField_a_of_type_ArrayOfMak[i].b();
        i += 1;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SwitchFaceView", 2, "WL_DEBUG onDestroy e = " + localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mah
 * JD-Core Version:    0.7.0.1
 */