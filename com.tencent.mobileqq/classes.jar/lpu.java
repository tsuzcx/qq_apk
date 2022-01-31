import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.ByteUtils;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.BitSet;

@TargetApi(18)
public class lpu
  extends lqc
  implements lpt
{
  public static String a;
  static boolean jdField_b_of_type_Boolean;
  static boolean c;
  private int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private BitSet jdField_a_of_type_JavaUtilBitSet;
  private lip jdField_a_of_type_Lip;
  lkb jdField_a_of_type_Lkb = new lpv(this);
  lpw jdField_a_of_type_Lpw = new lpw();
  public lpy a;
  boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_JavaLangString = "EffectsRenderController";
  }
  
  public lpu(VideoAppInterface paramVideoAppInterface, GLRootView paramGLRootView)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "EffectsRenderController, constructor, app[" + paramVideoAppInterface + "], mContext[" + this.jdField_a_of_type_AndroidContentContext + "]", new Throwable("打印调用栈"));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramVideoAppInterface.getApplication();
    this.jdField_a_of_type_Lip = new lip(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Lpy = new lpy(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Lip, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_JavaUtilBitSet = new BitSet();
    if (QLog.isColorLevel()) {
      com.tencent.av.video.effect.QavVideoEffect.DEBUG_MODE = true;
    }
    lpq.a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a(lpp paramlpp, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2)
  {
    if (paramlpp != null)
    {
      paramArrayOfByte1 = a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramShort1, paramShort2, (short)paramlpp.jdField_a_of_type_Int, (short)paramlpp.jdField_b_of_type_Int);
      if (paramlpp.jdField_a_of_type_Mrd != null) {
        paramlpp.jdField_a_of_type_Mrd.f();
      }
      GraphicRenderMgr.getInstance().sendCameraFrame(paramlpp.jdField_a_of_type_ArrayOfByte, paramlpp.jdField_c_of_type_Int, paramlpp.jdField_a_of_type_Int, paramlpp.jdField_b_of_type_Int, paramlpp.d, paramlpp.e, paramlpp.jdField_b_of_type_Long, paramlpp.jdField_a_of_type_Boolean, VideoController.a().a, paramArrayOfByte1, paramlpp.f, paramlpp.g);
    }
  }
  
  public static boolean a()
  {
    return biik.b();
  }
  
  public static boolean a(int paramInt, long paramLong)
  {
    if (f()) {
      return true;
    }
    int i = bbdh.a();
    if (i < 17)
    {
      lcg.c(jdField_a_of_type_JavaLangString, "isUserEffectFace error  OSversion:" + i);
      return false;
    }
    return a(paramInt, paramLong, 1073741824L);
  }
  
  public static boolean a(int paramInt, long paramLong1, long paramLong2)
  {
    int i = llw.e();
    if (i < paramInt)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "isSupportOfDevice fail, cpuCount[" + i + " < " + paramInt + "]");
      return false;
    }
    long l = llw.c();
    if ((l != 0L) && (l < paramLong1))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "isSupportOfDevice fail, cpuFrequency[" + l + " < " + paramLong1 + "]");
      return false;
    }
    paramLong1 = bbdh.d();
    if (paramLong1 < paramLong2)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "isSupportOfDevice fail, mem[" + paramLong1 + " < " + paramLong2 + "]");
      return false;
    }
    return true;
  }
  
  private void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "realyInit, isInitial[" + this.jdField_a_of_type_Boolean + "], soloadedPTV[" + GraphicRenderMgr.soloadedPTV + "], seq[" + paramLong + "]");
    }
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      super.b();
      this.jdField_a_of_type_Lpy.a(paramLong);
    } while (!ljw.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Lpy.a(paramLong, ljw.l, ljw.k);
  }
  
  private void b(lpp paramlpp)
  {
    short s1 = 0;
    byte[] arrayOfByte = paramlpp.jdField_a_of_type_ArrayOfByte;
    lkh.a().a(arrayOfByte, 3);
    boolean bool;
    Object localObject5;
    Object localObject1;
    Object localObject4;
    Object localObject3;
    label100:
    Object localObject2;
    if ((this.jdField_a_of_type_JavaUtilBitSet.get(0)) || (this.jdField_a_of_type_JavaUtilBitSet.get(1)))
    {
      bool = true;
      if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)) {
        break label435;
      }
      localObject5 = (liq)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2);
      localObject1 = ((liq)localObject5).a(paramlpp.jdField_b_of_type_Int, paramlpp.jdField_a_of_type_Int);
      if (localObject1 == null) {
        break label426;
      }
      localObject4 = ((lio)localObject1).jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
      localObject3 = ((lio)localObject1).jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem;
      localObject2 = localObject3;
      localObject1 = localObject4;
      if (localObject3 != null)
      {
        ((liq)localObject5).a(this.jdField_a_of_type_Lip);
        localObject1 = localObject4;
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      if ((localObject1 == null) || (localObject2 == null)) {
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(13))
        {
          localObject3 = ((lig)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(13)).a(paramlpp.jdField_b_of_type_Int, paramlpp.jdField_a_of_type_Int);
          if (localObject3 == null) {
            break label423;
          }
          localObject1 = ((lio)localObject3).jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
          localObject2 = ((lio)localObject3).jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem;
        }
      }
      label423:
      for (;;)
      {
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        label208:
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1)) {}
        for (localObject3 = ((lhp)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1)).a();; localObject3 = null)
        {
          localObject5 = paramlpp.jdField_a_of_type_Mrd;
          ((mrd)localObject5).c();
          localObject4 = this.jdField_a_of_type_Lpy.a(paramlpp, (FilterDesc)localObject3, (VideoMaterial)localObject2, bool, false, (PendantItem)localObject1, this);
          ((mrd)localObject5).d();
          lkh.a().a(arrayOfByte, 0);
          int i = liq.a((PendantItem)localObject1, false);
          GraphicRenderMgr.getInstance().setBeautyOrFaceConfig(i, 1);
          short s2;
          if (localObject4 != null)
          {
            localObject1 = ((lpz)localObject4).jdField_b_of_type_ArrayOfByte;
            localObject2 = ((lpz)localObject4).c;
            localObject3 = ((lpz)localObject4).d;
            s1 = ((lpz)localObject4).a;
            s2 = ((lpz)localObject4).jdField_b_of_type_Short;
            paramlpp = (lpp)localObject4;
          }
          for (;;)
          {
            paramlpp.jdField_a_of_type_Mrd = ((mrd)localObject5);
            a(paramlpp, (byte[])localObject1, (byte[])localObject2, (byte[])localObject3, s1, s2);
            return;
            bool = false;
            break;
            localObject3 = (lig)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(13);
            if (localObject3 != null) {
              ((lig)localObject3).c();
            }
            localObject3 = localObject2;
            localObject2 = localObject1;
            localObject1 = localObject3;
            break label208;
            s2 = 0;
            localObject3 = null;
            localObject2 = null;
            localObject1 = null;
          }
        }
      }
      label426:
      localObject3 = null;
      localObject4 = null;
      break label100;
      label435:
      localObject2 = null;
      localObject1 = null;
    }
  }
  
  public static boolean b()
  {
    if (Build.VERSION.SDK_INT <= 15) {
      return false;
    }
    return a(2, 1200000L, 1073741824L);
  }
  
  private void c(long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if (AudioHelper.e()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "realyTerminate, seq[" + paramLong + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)) {
      ((liq)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)).d();
    }
    if (this.jdField_a_of_type_Lpy != null) {
      this.jdField_a_of_type_Lpy.c(paramLong);
    }
    super.d();
  }
  
  public static boolean c()
  {
    if (Build.VERSION.SDK_INT <= 15) {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "isUserAfterTreatmentPower android.os.Build.VERSION.SDK_INT <= 15");
      }
    }
    do
    {
      return false;
      if (lpl.b()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 1, "isUserAfterTreatmentPower isMachineSupportAfterTreatment=false");
    return false;
    return true;
  }
  
  public static boolean d()
  {
    if (c) {
      return true;
    }
    lpd locallpd = lpd.a();
    if ((locallpd != null) && (locallpd.f()))
    {
      c = true;
      return true;
    }
    if (!b()) {
      return false;
    }
    if ((a(4, 1400000L, 1073741824L)) || (a(8, 1200000L, 1073741824L))) {}
    for (int i = 1; i == 0; i = 0) {
      return false;
    }
    if ((locallpd != null) && (!locallpd.e()))
    {
      lcg.e(jdField_a_of_type_JavaLangString, "isUserEffectFace| model in black list.modle=" + Build.MANUFACTURER + ":" + Build.MODEL);
      return false;
    }
    c = true;
    return c;
  }
  
  public static boolean e()
  {
    boolean bool1 = true;
    if (!jdField_b_of_type_Boolean)
    {
      jdField_b_of_type_Boolean = ljd.a(VideoController.a().a());
      if (!jdField_b_of_type_Boolean)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "isLoadedSO, 加载so失败");
        bool1 = false;
      }
    }
    boolean bool2;
    do
    {
      do
      {
        return bool1;
      } while (GraphicRenderMgr.soloadedPTV);
      GraphicRenderMgr.loadPtuSO();
      QLog.w(jdField_a_of_type_JavaLangString, 1, "isLoadedSO, soloadedPTV[" + GraphicRenderMgr.soloadedPTV + "]");
      bool2 = GraphicRenderMgr.soloadedPTV;
      bool1 = bool2;
    } while (!GraphicRenderMgr.soloadedPTV);
    Object localObject = BaseApplicationImpl.getContext();
    localObject = VideoController.a().a((Context)localObject);
    if (localObject != null) {
      ((lpu)localObject).c();
    }
    VideoController.a().k(GraphicRenderMgr.soloadedPTV);
    return bool2;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Lpy != null) {
      this.jdField_a_of_type_Lpy.b();
    }
  }
  
  public static boolean f()
  {
    String str = Build.MODEL;
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return str.equals("MI 5");
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)) {
      ((liq)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)).d();
    }
    if (this.jdField_a_of_type_Lpy != null) {
      this.jdField_a_of_type_Lpy.c();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5).sendToTarget();
  }
  
  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 5))
    {
      if (!this.jdField_a_of_type_JavaUtilBitSet.get(paramInt)) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "setExtInfo, flag[" + paramInt + "]", new Throwable("打印调用栈"));
      }
      this.jdField_a_of_type_JavaUtilBitSet.set(paramInt);
    }
    while (paramInt < 5) {
      return;
    }
    throw new IllegalArgumentException("setExtInfo fail, EXP_BIT_MAX[5" + ajya.a(2131703999));
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Lpy != null) {
      this.jdField_a_of_type_Lpy.b(paramLong);
    }
  }
  
  void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Lpy.a(paramLong);
    this.jdField_a_of_type_Lpy.a(paramLong, paramInt1, paramInt2);
  }
  
  protected void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      b(mtj.a(paramMessage.obj));
      return;
    case 2: 
      c(mtj.a(paramMessage.obj));
      return;
    case 3: 
      b((lpp)paramMessage.obj);
      return;
    case 4: 
      a(mtj.a(paramMessage.obj), ljw.l, ljw.k);
      return;
    case 5: 
      g();
      return;
    }
    f();
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_Lip.a(paramVideoAppInterface);
  }
  
  void a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(130), paramString, paramArrayOfByte });
    }
  }
  
  public void a(lpp paramlpp)
  {
    this.jdField_a_of_type_Lpw.a(paramlpp.jdField_a_of_type_ArrayOfByte, paramlpp.jdField_a_of_type_Int, paramlpp.jdField_b_of_type_Int, paramlpp.jdField_c_of_type_Int, paramlpp.d, paramlpp.jdField_a_of_type_Long, paramlpp.jdField_a_of_type_Boolean, paramlpp.jdField_c_of_type_Long);
    if ((paramlpp.jdField_a_of_type_ArrayOfByte == null) || (paramlpp.jdField_a_of_type_Int == 0) || (paramlpp.jdField_b_of_type_Int == 0)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(3))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      lkh.a().a(2, 0);
    }
    lkh.a().a(paramlpp.jdField_a_of_type_ArrayOfByte, 2);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, paramlpp).sendToTarget();
  }
  
  byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2, short paramShort3, short paramShort4)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    label320:
    label337:
    int i;
    if ((this.jdField_a_of_type_JavaUtilBitSet.get(0)) || (this.jdField_a_of_type_JavaUtilBitSet.get(1)) || (this.jdField_a_of_type_JavaUtilBitSet.get(2)) || (this.jdField_a_of_type_JavaUtilBitSet.get(3))) {
      if ((this.jdField_a_of_type_JavaUtilBitSet.get(2)) || (this.jdField_a_of_type_JavaUtilBitSet.get(3)))
      {
        paramShort1 = VideoController.a().c(false);
        lcg.c(jdField_a_of_type_JavaLangString, "buildExtInfo volume :" + paramShort1 + this.jdField_a_of_type_JavaUtilBitSet.get(1) + "|" + this.jdField_a_of_type_JavaUtilBitSet.get(0));
        if (paramShort1 < 100)
        {
          localObject = new byte[2];
          ByteUtils.Word2Byte((byte[])localObject, 0, (short)paramShort1);
          localObject = new lpa((short)2, (short)2, (byte[])localObject);
          if (this.jdField_a_of_type_JavaUtilBitSet.get(3))
          {
            localArrayList.add(localObject);
            paramShort2 = 0 + ((lpa)localObject).a();
            if (!this.jdField_a_of_type_JavaUtilBitSet.get(0))
            {
              paramShort1 = paramShort2;
              if (!this.jdField_a_of_type_JavaUtilBitSet.get(1)) {}
            }
            else
            {
              lcg.c(jdField_a_of_type_JavaLangString, "buildExtInfo face :" + paramArrayOfByte1 + "|" + this.jdField_a_of_type_JavaUtilBitSet.get(1) + "|" + this.jdField_a_of_type_JavaUtilBitSet.get(0));
              if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null))
              {
                paramShort1 = paramShort2;
                if (paramArrayOfByte3 == null) {}
              }
              else
              {
                if (paramArrayOfByte1 == null) {
                  break label643;
                }
                paramArrayOfByte1 = new lpa((short)1, (short)paramArrayOfByte1.length, paramArrayOfByte1);
                if (paramArrayOfByte2 == null) {
                  break label648;
                }
                paramArrayOfByte2 = new lpa((short)4, (short)paramArrayOfByte2.length, paramArrayOfByte2);
                if (paramArrayOfByte3 == null) {
                  break label653;
                }
                i = 1;
                label344:
                if (!this.jdField_a_of_type_JavaUtilBitSet.get(1)) {
                  break label749;
                }
                if (i == 0) {
                  break label659;
                }
                paramArrayOfByte1 = new lpa((short)6, (short)paramArrayOfByte3.length, paramArrayOfByte3);
                localArrayList.add(paramArrayOfByte1);
                paramShort1 = paramArrayOfByte1.a() + paramShort2;
                label390:
                paramArrayOfByte1 = new byte[8];
                if (i == 0) {
                  break label733;
                }
                paramShort2 = paramShort4;
                label404:
                if (i == 0) {
                  break label741;
                }
                i = paramShort3;
                label413:
                paramArrayOfByte1[0] = ((byte)(paramShort2 >> 8));
                paramArrayOfByte1[1] = ((byte)(paramShort2 >> 0));
                paramArrayOfByte1[2] = ((byte)(i >> 8));
                paramArrayOfByte1[3] = ((byte)(i >> 0));
                paramArrayOfByte1[4] = ((byte)(paramShort3 >> 8));
                paramArrayOfByte1[5] = ((byte)(paramShort3 >> 0));
                paramArrayOfByte1[6] = ((byte)(paramShort4 >> 8));
                paramArrayOfByte1[7] = ((byte)(paramShort4 >> 0));
                paramArrayOfByte1 = new lpa((short)3, (short)paramArrayOfByte1.length, paramArrayOfByte1);
                localArrayList.add(paramArrayOfByte1);
                paramShort1 = paramArrayOfByte1.a() + paramShort1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label512:
      paramShort2 = paramShort1;
      if (this.jdField_a_of_type_JavaUtilBitSet.get(4))
      {
        paramArrayOfByte1 = lgl.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        paramShort2 = paramShort1;
        if (paramArrayOfByte1 != null) {
          paramShort2 = paramShort1 + paramArrayOfByte1.a(localArrayList);
        }
      }
      if (paramShort2 > 0)
      {
        paramArrayOfByte1 = ByteBuffer.allocate(paramShort2);
        paramShort2 = localArrayList.size();
        paramShort1 = 0;
        for (;;)
        {
          if (paramShort1 < paramShort2)
          {
            paramArrayOfByte1.put(lpb.a((lpa)localArrayList.get(paramShort1)));
            paramShort1 += 1;
            continue;
            if (this.jdField_a_of_type_JavaUtilBitSet.get(2))
            {
              localObject = lpb.a((lpa)localObject);
              a(this.jdField_b_of_type_JavaLangString, (byte[])localObject);
            }
            paramShort2 = 0;
            break;
            label643:
            paramArrayOfByte1 = null;
            break label320;
            label648:
            paramArrayOfByte2 = null;
            break label337;
            label653:
            i = 0;
            break label344;
            label659:
            if (((liz)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(5)).a(3, "SUPPORT_SWITCH_FACE") == 1) {}
            for (paramShort1 = 1;; paramShort1 = 0)
            {
              if (paramShort1 != 0) {
                break label714;
              }
              localArrayList.add(paramArrayOfByte1);
              paramShort1 = paramArrayOfByte1.a() + paramShort2;
              break;
            }
            label714:
            localArrayList.add(paramArrayOfByte2);
            paramShort1 = paramArrayOfByte2.a() + paramShort2;
            break label390;
            label733:
            paramShort2 = 320;
            break label404;
            label741:
            i = 240;
            break label413;
            label749:
            paramShort1 = paramShort2;
            if (!this.jdField_a_of_type_JavaUtilBitSet.get(0)) {
              break label512;
            }
            paramArrayOfByte1 = lpb.a(paramArrayOfByte1);
            a(this.jdField_b_of_type_JavaLangString, paramArrayOfByte1);
            paramShort1 = paramShort2;
            break label512;
          }
        }
        return paramArrayOfByte1.array();
      }
      return null;
      paramShort1 = 0;
    }
  }
  
  public void b()
  {
    long l = AudioHelper.b();
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.obj = Long.valueOf(l);
    localMessage.sendToTarget();
    CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Lkb);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6).sendToTarget();
  }
  
  public void c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 5))
    {
      if (this.jdField_a_of_type_JavaUtilBitSet.get(paramInt)) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "clearExtInfo, flag[" + paramInt + "]", new Throwable("打印调用栈"));
      }
      this.jdField_a_of_type_JavaUtilBitSet.clear(paramInt);
    }
  }
  
  public void d()
  {
    long l = AudioHelper.b();
    CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(this.jdField_a_of_type_Lkb);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.obj = Long.valueOf(l);
    localMessage.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lpu
 * JD-Core Version:    0.7.0.1
 */