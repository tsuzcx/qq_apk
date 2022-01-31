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

public class mac
{
  private SwitchFaceProcessor jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor;
  private WeakReference<VideoLayerUIBase> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private maf[] jdField_a_of_type_ArrayOfMaf = new maf[2];
  
  public mac()
  {
    axle.c(VideoEnvironment.a());
    bfma.a();
    biik.a();
    this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor = new SwitchFaceProcessor();
    int i = 0;
    while (i < 2)
    {
      this.jdField_a_of_type_ArrayOfMaf[i] = new maf();
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
  
  private void a(mae parammae)
  {
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor.destroy();
      this.jdField_a_of_type_Boolean = false;
      int i = 0;
      while (i < parammae.jdField_a_of_type_ArrayOfMad.length)
      {
        if (parammae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_Mdz != null) {
          parammae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_Mdz.a(0, 0, 0);
        }
        this.jdField_a_of_type_ArrayOfMaf[i].b();
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
      this.jdField_a_of_type_ArrayOfMaf[i].a();
      i += 1;
    }
  }
  
  public void a(VideoAppInterface paramVideoAppInterface, lqo paramlqo)
  {
    long l5 = System.currentTimeMillis();
    long l3 = 0L;
    long l4 = 0L;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    long l2;
    long l1;
    mae localmae;
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
      localmae = new mae(this);
      localmae.jdField_a_of_type_Lqo = paramlqo;
      m = 0;
      k = 1;
      j = 0;
      while (j < localVideoLayerUIBase.jdField_a_of_type_ArrayOfMdz.length)
      {
        paramlqo = localVideoLayerUIBase.jdField_a_of_type_ArrayOfMdz[j];
        localObject = paramlqo.b();
        int i1 = paramlqo.e();
        if (m >= localmae.jdField_a_of_type_ArrayOfMad.length) {
          break;
        }
        n = k;
        i = m;
        if (paramlqo.a() == 0)
        {
          n = k;
          i = m;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localmae.jdField_a_of_type_ArrayOfMad[m].jdField_a_of_type_Mdz = paramlqo;
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
    if ((m == localmae.jdField_a_of_type_ArrayOfMad.length) && (k != 0) && (paramVideoAppInterface != null) && (paramVideoAppInterface.a(3)))
    {
      paramVideoAppInterface = (FaceItem)((lhr)paramVideoAppInterface.a(3)).a();
      if ((paramVideoAppInterface != null) && (!TextUtils.isEmpty(paramVideoAppInterface.getId())) && ("huanlian".equalsIgnoreCase(paramVideoAppInterface.getId())))
      {
        bool = true;
        if (QLog.isColorLevel())
        {
          paramlqo = new StringBuilder().append("WL_DEBUG isSelectedSwitchFace = ").append(bool).append("|");
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
        paramVideoAppInterface = localmae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_Mdz.a();
        localmae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_ArrayOfByte = paramVideoAppInterface.a();
        localmae.jdField_a_of_type_ArrayOfMad[i].c = paramVideoAppInterface.k();
        localmae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_Int = paramVideoAppInterface.h();
        localmae.jdField_a_of_type_ArrayOfMad[i].b = paramVideoAppInterface.i();
        localmae.jdField_a_of_type_ArrayOfMad[i].d = paramVideoAppInterface.j();
        if (localmae.jdField_a_of_type_ArrayOfMad[i].d % 2 != 0) {
          break label1163;
        }
        localmae.jdField_a_of_type_ArrayOfMad[i].e = localmae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_Int;
        localmae.jdField_a_of_type_ArrayOfMad[i].f = localmae.jdField_a_of_type_ArrayOfMad[i].b;
        label489:
        paramlqo = localmae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_Mdz.b();
        paramVideoAppInterface = paramVideoAppInterface.c();
        if (paramVideoAppInterface == null) {
          break label2021;
        }
      }
    }
    label579:
    label2021:
    for (paramVideoAppInterface = new lzx(paramVideoAppInterface);; paramVideoAppInterface = null)
    {
      float f1;
      if ((paramVideoAppInterface != null) && (paramVideoAppInterface.jdField_a_of_type_ArrayOfByte != null))
      {
        localObject = ByteBuffer.wrap(paramVideoAppInterface.jdField_a_of_type_ArrayOfByte);
        localmae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        if (localVideoLayerUIBase.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().b(paramlqo) != 2) {
          break label1210;
        }
        j = 1;
        if (localmae.jdField_a_of_type_ArrayOfMad[i].e * paramVideoAppInterface.b >= localmae.jdField_a_of_type_ArrayOfMad[i].f * paramVideoAppInterface.jdField_a_of_type_Short) {
          break label1216;
        }
        k = paramVideoAppInterface.jdField_a_of_type_Short * localmae.jdField_a_of_type_ArrayOfMad[i].f / paramVideoAppInterface.b;
        m = (localmae.jdField_a_of_type_ArrayOfMad[i].e - k) / 2;
        k = 0;
        f1 = localmae.jdField_a_of_type_ArrayOfMad[i].f / paramVideoAppInterface.b / 1000000.0F;
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
            paramVideoAppInterface.x = (localmae.jdField_a_of_type_ArrayOfMad[i].e - paramVideoAppInterface.x);
          }
          if ((paramVideoAppInterface.x < 0.0F) || (paramVideoAppInterface.x > localmae.jdField_a_of_type_ArrayOfMad[i].e) || (paramVideoAppInterface.y < 0.0F) || (paramVideoAppInterface.y > localmae.jdField_a_of_type_ArrayOfMad[i].f)) {
            localmae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_JavaUtilArrayList = null;
          }
        }
        else
        {
          if (localmae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_JavaUtilArrayList != null)
          {
            if (localmae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_JavaUtilArrayList.size() == 83) {
              a(localmae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_JavaUtilArrayList);
            }
            f1 = Math.abs(((PointF)localmae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_JavaUtilArrayList.get(0)).x - ((PointF)localmae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_JavaUtilArrayList.get(64)).x);
            float f2 = Math.abs(((PointF)localmae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_JavaUtilArrayList.get(18)).x - ((PointF)localmae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_JavaUtilArrayList.get(64)).x);
            float f3 = Math.abs(((PointF)localmae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_JavaUtilArrayList.get(89)).y - ((PointF)localmae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_JavaUtilArrayList.get(64)).y);
            float f4 = Math.abs(((PointF)localmae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_JavaUtilArrayList.get(9)).y - ((PointF)localmae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_JavaUtilArrayList.get(64)).y);
            if ((6.0F * f1 < f2) || (f1 > f2 * 6.0F) || (6.0F * f3 < f4) || (f3 > f4 * 6.0F)) {
              localmae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_JavaUtilArrayList = null;
            }
          }
          i += 1;
          break label333;
          bool = false;
          break;
          paramVideoAppInterface = paramVideoAppInterface.getId();
          break label311;
          localmae.jdField_a_of_type_ArrayOfMad[i].e = localmae.jdField_a_of_type_ArrayOfMad[i].b;
          localmae.jdField_a_of_type_ArrayOfMad[i].f = localmae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_Int;
          break label489;
          j = 0;
          break label579;
          k = paramVideoAppInterface.b * localmae.jdField_a_of_type_ArrayOfMad[i].e / paramVideoAppInterface.jdField_a_of_type_Short;
          m = 0;
          k = (localmae.jdField_a_of_type_ArrayOfMad[i].f - k) / 2;
          f1 = localmae.jdField_a_of_type_ArrayOfMad[i].e / paramVideoAppInterface.jdField_a_of_type_Short / 1000000.0F;
          break label681;
        }
        localmae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_JavaUtilArrayList.add(paramVideoAppInterface);
        n += 8;
      }
      i = 0;
      while (i < 2)
      {
        this.jdField_a_of_type_ArrayOfMaf[i].a(localmae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_Int, localmae.jdField_a_of_type_ArrayOfMad[i].b, localmae.jdField_a_of_type_ArrayOfMad[i].c, localmae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_ArrayOfByte, localmae.jdField_a_of_type_ArrayOfMad[i].d);
        i += 1;
      }
      for (;;)
      {
        try
        {
          if ((GLES20.glCheckFramebufferStatus(36160) == 36053) && (!CollectionUtils.isEmpty(localmae.jdField_a_of_type_ArrayOfMad[0].jdField_a_of_type_JavaUtilArrayList)) && (!CollectionUtils.isEmpty(localmae.jdField_a_of_type_ArrayOfMad[1].jdField_a_of_type_JavaUtilArrayList))) {
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
          if ((!this.jdField_a_of_type_Boolean) && (lpu.e()) && (apvd.a(mab.a)))
          {
            this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor.init();
            this.jdField_a_of_type_Boolean = true;
          }
          paramVideoAppInterface = this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor.process(this.jdField_a_of_type_ArrayOfMaf[0].a(), localmae.jdField_a_of_type_ArrayOfMad[0].jdField_a_of_type_JavaUtilArrayList, localmae.jdField_a_of_type_ArrayOfMad[0].e, localmae.jdField_a_of_type_ArrayOfMad[0].f, this.jdField_a_of_type_ArrayOfMaf[1].a(), localmae.jdField_a_of_type_ArrayOfMad[1].jdField_a_of_type_JavaUtilArrayList, localmae.jdField_a_of_type_ArrayOfMad[1].e, localmae.jdField_a_of_type_ArrayOfMad[1].f);
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
          localmae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_Mdz.a(paramVideoAppInterface[i], localmae.jdField_a_of_type_ArrayOfMad[i].e, localmae.jdField_a_of_type_ArrayOfMad[i].f);
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
      if ((localmae.jdField_a_of_type_Lqo instanceof lqp))
      {
        GLES20.glViewport(0, 0, ((lqp)localmae.jdField_a_of_type_Lqo).c(), ((lqp)localmae.jdField_a_of_type_Lqo).d());
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
          localmae.jdField_a_of_type_ArrayOfMad[i].jdField_a_of_type_Mdz.a(0, 0, 0);
          i += 1;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("SwitchFaceView", 2, "WL_DEBUG processFrame_internal e = " + paramVideoAppInterface);
          paramlqo = paramVideoAppInterface.getStackTrace();
          paramVideoAppInterface = "";
          j = paramlqo.length;
          i = 0;
          while (i < j)
          {
            paramVideoAppInterface = paramVideoAppInterface + "WL_DEBUG processFrame_internal ste[" + i + "]" + paramlqo[i].toString() + "\n";
            i += 1;
          }
          QLog.e("SwitchFaceView", 2, paramVideoAppInterface);
        }
        break;
        a(localmae);
        l3 = 0L;
        l4 = 0L;
        break label1681;
        a(localmae);
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
        this.jdField_a_of_type_ArrayOfMaf[i].b();
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
 * Qualified Name:     mac
 * JD-Core Version:    0.7.0.1
 */