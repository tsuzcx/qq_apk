import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.ui.VideoLayerUIBase;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.module_switchface.SwitchFaceProcessor;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class lzy
{
  private SwitchFaceProcessor jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor;
  private WeakReference<VideoLayerUIBase> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private mab[] jdField_a_of_type_ArrayOfMab;
  
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
  
  private void a(maa parammaa)
  {
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor.destroy();
      this.jdField_a_of_type_Boolean = false;
      int i = 0;
      while (i < parammaa.jdField_a_of_type_ArrayOfLzz.length)
      {
        if (parammaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_Mdy != null) {
          parammaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_Mdy.a(0, 0, 0);
        }
        this.jdField_a_of_type_ArrayOfMab[i].a();
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
  
  public void a(VideoAppInterface paramVideoAppInterface, lqb paramlqb)
  {
    long l5 = System.currentTimeMillis();
    long l3 = 0L;
    long l4 = 0L;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    long l2;
    long l1;
    maa localmaa;
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
        break label1687;
      }
      localmaa = new maa(this);
      localmaa.jdField_a_of_type_Lqb = paramlqb;
      m = 0;
      k = 1;
      j = 0;
      while (j < localVideoLayerUIBase.jdField_a_of_type_ArrayOfMdy.length)
      {
        paramlqb = localVideoLayerUIBase.jdField_a_of_type_ArrayOfMdy[j];
        localObject = paramlqb.b();
        int i1 = paramlqb.e();
        if (m >= localmaa.jdField_a_of_type_ArrayOfLzz.length) {
          break;
        }
        n = k;
        i = m;
        if (paramlqb.a() == 0)
        {
          n = k;
          i = m;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localmaa.jdField_a_of_type_ArrayOfLzz[m].jdField_a_of_type_Mdy = paramlqb;
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
    if ((m == localmaa.jdField_a_of_type_ArrayOfLzz.length) && (k != 0) && (paramVideoAppInterface != null) && (paramVideoAppInterface.a(3)))
    {
      paramVideoAppInterface = (FaceItem)((lgr)paramVideoAppInterface.a(3)).a();
      if ((paramVideoAppInterface != null) && (!TextUtils.isEmpty(paramVideoAppInterface.getId())) && ("huanlian".equalsIgnoreCase(paramVideoAppInterface.getId())))
      {
        bool = true;
        if (QLog.isColorLevel())
        {
          paramlqb = new StringBuilder().append("WL_DEBUG isSelectedSwitchFace = ").append(bool).append("|");
          if (paramVideoAppInterface != null) {
            break label1154;
          }
          paramVideoAppInterface = "null";
          label311:
          QLog.d("SwitchFaceView", 2, paramVideoAppInterface);
        }
        if (!bool) {
          break label1967;
        }
        i = 0;
        label333:
        if (i >= 2) {
          break label1310;
        }
        paramVideoAppInterface = localmaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_Mdy.a();
        localmaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_ArrayOfByte = paramVideoAppInterface.a();
        localmaa.jdField_a_of_type_ArrayOfLzz[i].c = paramVideoAppInterface.k();
        localmaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_Int = paramVideoAppInterface.h();
        localmaa.jdField_a_of_type_ArrayOfLzz[i].b = paramVideoAppInterface.i();
        localmaa.jdField_a_of_type_ArrayOfLzz[i].d = paramVideoAppInterface.j();
        if (localmaa.jdField_a_of_type_ArrayOfLzz[i].d % 2 != 0) {
          break label1162;
        }
        localmaa.jdField_a_of_type_ArrayOfLzz[i].e = localmaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_Int;
        localmaa.jdField_a_of_type_ArrayOfLzz[i].f = localmaa.jdField_a_of_type_ArrayOfLzz[i].b;
        label489:
        paramlqb = localmaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_Mdy.b();
        paramVideoAppInterface = paramVideoAppInterface.c();
        if (paramVideoAppInterface == null) {
          break label2019;
        }
      }
    }
    label579:
    label2019:
    for (paramVideoAppInterface = new lzt(paramVideoAppInterface);; paramVideoAppInterface = null)
    {
      float f1;
      if ((paramVideoAppInterface != null) && (paramVideoAppInterface.jdField_a_of_type_ArrayOfByte != null))
      {
        localObject = ByteBuffer.wrap(paramVideoAppInterface.jdField_a_of_type_ArrayOfByte);
        localmaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        if (localVideoLayerUIBase.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().b(paramlqb) != 2) {
          break label1209;
        }
        j = 1;
        if (localmaa.jdField_a_of_type_ArrayOfLzz[i].e * paramVideoAppInterface.b >= localmaa.jdField_a_of_type_ArrayOfLzz[i].f * paramVideoAppInterface.jdField_a_of_type_Short) {
          break label1215;
        }
        k = paramVideoAppInterface.jdField_a_of_type_Short * localmaa.jdField_a_of_type_ArrayOfLzz[i].f / paramVideoAppInterface.b;
        m = (localmaa.jdField_a_of_type_ArrayOfLzz[i].e - k) / 2;
        k = 0;
        f1 = localmaa.jdField_a_of_type_ArrayOfLzz[i].f / paramVideoAppInterface.b / 1000000.0F;
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
            paramVideoAppInterface.x = (localmaa.jdField_a_of_type_ArrayOfLzz[i].e - paramVideoAppInterface.x);
          }
          if ((paramVideoAppInterface.x < 0.0F) || (paramVideoAppInterface.x > localmaa.jdField_a_of_type_ArrayOfLzz[i].e) || (paramVideoAppInterface.y < 0.0F) || (paramVideoAppInterface.y > localmaa.jdField_a_of_type_ArrayOfLzz[i].f)) {
            localmaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_JavaUtilArrayList = null;
          }
        }
        else
        {
          if (localmaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_JavaUtilArrayList != null)
          {
            if (localmaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_JavaUtilArrayList.size() == 83) {
              a(localmaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_JavaUtilArrayList);
            }
            f1 = Math.abs(((PointF)localmaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_JavaUtilArrayList.get(0)).x - ((PointF)localmaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_JavaUtilArrayList.get(64)).x);
            float f2 = Math.abs(((PointF)localmaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_JavaUtilArrayList.get(18)).x - ((PointF)localmaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_JavaUtilArrayList.get(64)).x);
            float f3 = Math.abs(((PointF)localmaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_JavaUtilArrayList.get(89)).y - ((PointF)localmaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_JavaUtilArrayList.get(64)).y);
            float f4 = Math.abs(((PointF)localmaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_JavaUtilArrayList.get(9)).y - ((PointF)localmaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_JavaUtilArrayList.get(64)).y);
            if ((6.0F * f1 < f2) || (f1 > f2 * 6.0F) || (6.0F * f3 < f4) || (f3 > f4 * 6.0F)) {
              localmaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_JavaUtilArrayList = null;
            }
          }
          i += 1;
          break label333;
          bool = false;
          break;
          paramVideoAppInterface = paramVideoAppInterface.getId();
          break label311;
          localmaa.jdField_a_of_type_ArrayOfLzz[i].e = localmaa.jdField_a_of_type_ArrayOfLzz[i].b;
          localmaa.jdField_a_of_type_ArrayOfLzz[i].f = localmaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_Int;
          break label489;
          j = 0;
          break label579;
          k = paramVideoAppInterface.b * localmaa.jdField_a_of_type_ArrayOfLzz[i].e / paramVideoAppInterface.jdField_a_of_type_Short;
          m = 0;
          k = (localmaa.jdField_a_of_type_ArrayOfLzz[i].f - k) / 2;
          f1 = localmaa.jdField_a_of_type_ArrayOfLzz[i].e / paramVideoAppInterface.jdField_a_of_type_Short / 1000000.0F;
          break label680;
        }
        localmaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_JavaUtilArrayList.add(paramVideoAppInterface);
        n += 8;
      }
      i = 0;
      while (i < 2)
      {
        this.jdField_a_of_type_ArrayOfMab[i].a(localmaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_Int, localmaa.jdField_a_of_type_ArrayOfLzz[i].b, localmaa.jdField_a_of_type_ArrayOfLzz[i].c, localmaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_ArrayOfByte, localmaa.jdField_a_of_type_ArrayOfLzz[i].d);
        i += 1;
      }
      for (;;)
      {
        try
        {
          if ((GLES20.glCheckFramebufferStatus(36160) == 36053) && (!CollectionUtils.isEmpty(localmaa.jdField_a_of_type_ArrayOfLzz[0].jdField_a_of_type_JavaUtilArrayList)) && (!CollectionUtils.isEmpty(localmaa.jdField_a_of_type_ArrayOfLzz[1].jdField_a_of_type_JavaUtilArrayList))) {
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
          if ((!this.jdField_a_of_type_Boolean) && (lou.g()) && (FileUtil.isFileExists(lzx.a)))
          {
            this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor.init();
            this.jdField_a_of_type_Boolean = true;
          }
          paramVideoAppInterface = this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor.process(this.jdField_a_of_type_ArrayOfMab[0].a(), localmaa.jdField_a_of_type_ArrayOfLzz[0].jdField_a_of_type_JavaUtilArrayList, localmaa.jdField_a_of_type_ArrayOfLzz[0].e, localmaa.jdField_a_of_type_ArrayOfLzz[0].f, this.jdField_a_of_type_ArrayOfMab[1].a(), localmaa.jdField_a_of_type_ArrayOfLzz[1].jdField_a_of_type_JavaUtilArrayList, localmaa.jdField_a_of_type_ArrayOfLzz[1].e, localmaa.jdField_a_of_type_ArrayOfLzz[1].f);
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
          localmaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_Mdy.a(paramVideoAppInterface[i], localmaa.jdField_a_of_type_ArrayOfLzz[i].e, localmaa.jdField_a_of_type_ArrayOfLzz[i].f);
          i += 1;
        }
        catch (RuntimeException paramVideoAppInterface)
        {
          break label1845;
          l1 = 0L;
          l2 = 0L;
        }
      }
      l3 = l1;
      l4 = l2;
      if ((localmaa.jdField_a_of_type_Lqb instanceof lqc))
      {
        GLES20.glViewport(0, 0, ((lqc)localmaa.jdField_a_of_type_Lqb).c(), ((lqc)localmaa.jdField_a_of_type_Lqb).d());
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
          localmaa.jdField_a_of_type_ArrayOfLzz[i].jdField_a_of_type_Mdy.a(0, 0, 0);
          i += 1;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("SwitchFaceView", 2, "WL_DEBUG processFrame_internal e = " + paramVideoAppInterface);
          paramlqb = paramVideoAppInterface.getStackTrace();
          paramVideoAppInterface = "";
          j = paramlqb.length;
          i = 0;
          while (i < j)
          {
            paramVideoAppInterface = paramVideoAppInterface + "WL_DEBUG processFrame_internal ste[" + i + "]" + paramlqb[i].toString() + "\n";
            i += 1;
          }
          QLog.e("SwitchFaceView", 2, paramVideoAppInterface);
        }
        break;
        a(localmaa);
        l3 = 0L;
        l4 = 0L;
        break label1679;
        a(localmaa);
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
      int i = 0;
      while (i < 2)
      {
        this.jdField_a_of_type_ArrayOfMab[i].a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lzy
 * JD-Core Version:    0.7.0.1
 */