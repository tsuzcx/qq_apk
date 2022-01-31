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

public class mcr
{
  private SwitchFaceProcessor jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor;
  private WeakReference<VideoLayerUIBase> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private mcu[] jdField_a_of_type_ArrayOfMcu = new mcu[2];
  
  public mcr()
  {
    azkt.c(VideoEnvironment.a());
    bhrb.a();
    bkoq.a();
    this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor = new SwitchFaceProcessor();
    int i = 0;
    while (i < 2)
    {
      this.jdField_a_of_type_ArrayOfMcu[i] = new mcu();
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
  
  private void a(mct parammct)
  {
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor.destroy();
      this.jdField_a_of_type_Boolean = false;
      int i = 0;
      while (i < parammct.jdField_a_of_type_ArrayOfMcs.length)
      {
        if (parammct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_Mgp != null) {
          parammct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_Mgp.a(0, 0, 0);
        }
        this.jdField_a_of_type_ArrayOfMcu[i].b();
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
      this.jdField_a_of_type_ArrayOfMcu[i].a();
      i += 1;
    }
  }
  
  public void a(VideoAppInterface paramVideoAppInterface, lsv paramlsv)
  {
    long l5 = System.currentTimeMillis();
    long l3 = 0L;
    long l4 = 0L;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    long l2;
    long l1;
    mct localmct;
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
      localmct = new mct(this);
      localmct.jdField_a_of_type_Lsv = paramlsv;
      m = 0;
      k = 1;
      j = 0;
      while (j < localVideoLayerUIBase.jdField_a_of_type_ArrayOfMgp.length)
      {
        paramlsv = localVideoLayerUIBase.jdField_a_of_type_ArrayOfMgp[j];
        localObject = paramlsv.b();
        int i1 = paramlsv.e();
        if (m >= localmct.jdField_a_of_type_ArrayOfMcs.length) {
          break;
        }
        n = k;
        i = m;
        if (paramlsv.a() == 0)
        {
          n = k;
          i = m;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localmct.jdField_a_of_type_ArrayOfMcs[m].jdField_a_of_type_Mgp = paramlsv;
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
    if ((m == localmct.jdField_a_of_type_ArrayOfMcs.length) && (k != 0) && (paramVideoAppInterface != null) && (paramVideoAppInterface.a(3)))
    {
      paramVideoAppInterface = (FaceItem)((lju)paramVideoAppInterface.a(3)).a();
      if ((paramVideoAppInterface != null) && (!TextUtils.isEmpty(paramVideoAppInterface.getId())) && ("huanlian".equalsIgnoreCase(paramVideoAppInterface.getId())))
      {
        bool = true;
        if (QLog.isColorLevel())
        {
          paramlsv = new StringBuilder().append("WL_DEBUG isSelectedSwitchFace = ").append(bool).append("|");
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
        paramVideoAppInterface = localmct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_Mgp.a();
        localmct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_ArrayOfByte = paramVideoAppInterface.a();
        localmct.jdField_a_of_type_ArrayOfMcs[i].c = paramVideoAppInterface.k();
        localmct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_Int = paramVideoAppInterface.h();
        localmct.jdField_a_of_type_ArrayOfMcs[i].b = paramVideoAppInterface.i();
        localmct.jdField_a_of_type_ArrayOfMcs[i].d = paramVideoAppInterface.j();
        if (localmct.jdField_a_of_type_ArrayOfMcs[i].d % 2 != 0) {
          break label1163;
        }
        localmct.jdField_a_of_type_ArrayOfMcs[i].e = localmct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_Int;
        localmct.jdField_a_of_type_ArrayOfMcs[i].f = localmct.jdField_a_of_type_ArrayOfMcs[i].b;
        label489:
        paramlsv = localmct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_Mgp.b();
        paramVideoAppInterface = paramVideoAppInterface.c();
        if (paramVideoAppInterface == null) {
          break label2021;
        }
      }
    }
    label579:
    label2021:
    for (paramVideoAppInterface = new mcm(paramVideoAppInterface);; paramVideoAppInterface = null)
    {
      float f1;
      if ((paramVideoAppInterface != null) && (paramVideoAppInterface.jdField_a_of_type_ArrayOfByte != null))
      {
        localObject = ByteBuffer.wrap(paramVideoAppInterface.jdField_a_of_type_ArrayOfByte);
        localmct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        if (localVideoLayerUIBase.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().b(paramlsv) != 2) {
          break label1210;
        }
        j = 1;
        if (localmct.jdField_a_of_type_ArrayOfMcs[i].e * paramVideoAppInterface.b >= localmct.jdField_a_of_type_ArrayOfMcs[i].f * paramVideoAppInterface.jdField_a_of_type_Short) {
          break label1216;
        }
        k = paramVideoAppInterface.jdField_a_of_type_Short * localmct.jdField_a_of_type_ArrayOfMcs[i].f / paramVideoAppInterface.b;
        m = (localmct.jdField_a_of_type_ArrayOfMcs[i].e - k) / 2;
        k = 0;
        f1 = localmct.jdField_a_of_type_ArrayOfMcs[i].f / paramVideoAppInterface.b / 1000000.0F;
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
            paramVideoAppInterface.x = (localmct.jdField_a_of_type_ArrayOfMcs[i].e - paramVideoAppInterface.x);
          }
          if ((paramVideoAppInterface.x < 0.0F) || (paramVideoAppInterface.x > localmct.jdField_a_of_type_ArrayOfMcs[i].e) || (paramVideoAppInterface.y < 0.0F) || (paramVideoAppInterface.y > localmct.jdField_a_of_type_ArrayOfMcs[i].f)) {
            localmct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_JavaUtilArrayList = null;
          }
        }
        else
        {
          if (localmct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_JavaUtilArrayList != null)
          {
            if (localmct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_JavaUtilArrayList.size() == 83) {
              a(localmct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_JavaUtilArrayList);
            }
            f1 = Math.abs(((PointF)localmct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_JavaUtilArrayList.get(0)).x - ((PointF)localmct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_JavaUtilArrayList.get(64)).x);
            float f2 = Math.abs(((PointF)localmct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_JavaUtilArrayList.get(18)).x - ((PointF)localmct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_JavaUtilArrayList.get(64)).x);
            float f3 = Math.abs(((PointF)localmct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_JavaUtilArrayList.get(89)).y - ((PointF)localmct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_JavaUtilArrayList.get(64)).y);
            float f4 = Math.abs(((PointF)localmct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_JavaUtilArrayList.get(9)).y - ((PointF)localmct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_JavaUtilArrayList.get(64)).y);
            if ((6.0F * f1 < f2) || (f1 > f2 * 6.0F) || (6.0F * f3 < f4) || (f3 > f4 * 6.0F)) {
              localmct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_JavaUtilArrayList = null;
            }
          }
          i += 1;
          break label333;
          bool = false;
          break;
          paramVideoAppInterface = paramVideoAppInterface.getId();
          break label311;
          localmct.jdField_a_of_type_ArrayOfMcs[i].e = localmct.jdField_a_of_type_ArrayOfMcs[i].b;
          localmct.jdField_a_of_type_ArrayOfMcs[i].f = localmct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_Int;
          break label489;
          j = 0;
          break label579;
          k = paramVideoAppInterface.b * localmct.jdField_a_of_type_ArrayOfMcs[i].e / paramVideoAppInterface.jdField_a_of_type_Short;
          m = 0;
          k = (localmct.jdField_a_of_type_ArrayOfMcs[i].f - k) / 2;
          f1 = localmct.jdField_a_of_type_ArrayOfMcs[i].e / paramVideoAppInterface.jdField_a_of_type_Short / 1000000.0F;
          break label681;
        }
        localmct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_JavaUtilArrayList.add(paramVideoAppInterface);
        n += 8;
      }
      i = 0;
      while (i < 2)
      {
        this.jdField_a_of_type_ArrayOfMcu[i].a(localmct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_Int, localmct.jdField_a_of_type_ArrayOfMcs[i].b, localmct.jdField_a_of_type_ArrayOfMcs[i].c, localmct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_ArrayOfByte, localmct.jdField_a_of_type_ArrayOfMcs[i].d);
        i += 1;
      }
      for (;;)
      {
        try
        {
          if ((GLES20.glCheckFramebufferStatus(36160) == 36053) && (!CollectionUtils.isEmpty(localmct.jdField_a_of_type_ArrayOfMcs[0].jdField_a_of_type_JavaUtilArrayList)) && (!CollectionUtils.isEmpty(localmct.jdField_a_of_type_ArrayOfMcs[1].jdField_a_of_type_JavaUtilArrayList))) {
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
          if ((!this.jdField_a_of_type_Boolean) && (lsa.e()) && (arso.a(mcq.a)))
          {
            this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor.init();
            this.jdField_a_of_type_Boolean = true;
          }
          paramVideoAppInterface = this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor.process(this.jdField_a_of_type_ArrayOfMcu[0].a(), localmct.jdField_a_of_type_ArrayOfMcs[0].jdField_a_of_type_JavaUtilArrayList, localmct.jdField_a_of_type_ArrayOfMcs[0].e, localmct.jdField_a_of_type_ArrayOfMcs[0].f, this.jdField_a_of_type_ArrayOfMcu[1].a(), localmct.jdField_a_of_type_ArrayOfMcs[1].jdField_a_of_type_JavaUtilArrayList, localmct.jdField_a_of_type_ArrayOfMcs[1].e, localmct.jdField_a_of_type_ArrayOfMcs[1].f);
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
          localmct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_Mgp.a(paramVideoAppInterface[i], localmct.jdField_a_of_type_ArrayOfMcs[i].e, localmct.jdField_a_of_type_ArrayOfMcs[i].f);
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
      if ((localmct.jdField_a_of_type_Lsv instanceof lsw))
      {
        GLES20.glViewport(0, 0, ((lsw)localmct.jdField_a_of_type_Lsv).c(), ((lsw)localmct.jdField_a_of_type_Lsv).d());
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
          localmct.jdField_a_of_type_ArrayOfMcs[i].jdField_a_of_type_Mgp.a(0, 0, 0);
          i += 1;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("SwitchFaceView", 2, "WL_DEBUG processFrame_internal e = " + paramVideoAppInterface);
          paramlsv = paramVideoAppInterface.getStackTrace();
          paramVideoAppInterface = "";
          j = paramlsv.length;
          i = 0;
          while (i < j)
          {
            paramVideoAppInterface = paramVideoAppInterface + "WL_DEBUG processFrame_internal ste[" + i + "]" + paramlsv[i].toString() + "\n";
            i += 1;
          }
          QLog.e("SwitchFaceView", 2, paramVideoAppInterface);
        }
        break;
        a(localmct);
        l3 = 0L;
        l4 = 0L;
        break label1681;
        a(localmct);
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
        this.jdField_a_of_type_ArrayOfMcu[i].b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mcr
 * JD-Core Version:    0.7.0.1
 */