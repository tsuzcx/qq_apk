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
public class lsa
  extends lsi
  implements lrz
{
  public static String a;
  static boolean jdField_b_of_type_Boolean;
  static boolean c;
  private int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private BitSet jdField_a_of_type_JavaUtilBitSet;
  private lks jdField_a_of_type_Lks;
  lme jdField_a_of_type_Lme = new lsb(this);
  lsc jdField_a_of_type_Lsc = new lsc();
  public lse a;
  boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_JavaLangString = "EffectsRenderController";
  }
  
  public lsa(VideoAppInterface paramVideoAppInterface, GLRootView paramGLRootView)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "EffectsRenderController, constructor, app[" + paramVideoAppInterface + "], mContext[" + this.jdField_a_of_type_AndroidContentContext + "]", new Throwable("打印调用栈"));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramVideoAppInterface.getApplication();
    this.jdField_a_of_type_Lks = new lks(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Lse = new lse(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Lks, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_JavaUtilBitSet = new BitSet();
    if (QLog.isColorLevel()) {
      com.tencent.av.video.effect.QavVideoEffect.DEBUG_MODE = true;
    }
    lrw.a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a(lrs paramlrs, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2)
  {
    if (paramlrs != null)
    {
      paramArrayOfByte1 = a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramShort1, paramShort2, (short)paramlrs.jdField_a_of_type_Int, (short)paramlrs.jdField_b_of_type_Int);
      if (paramlrs.jdField_a_of_type_Mtx != null) {
        paramlrs.jdField_a_of_type_Mtx.f();
      }
      GraphicRenderMgr.getInstance().sendCameraFrame(paramlrs.jdField_a_of_type_ArrayOfByte, paramlrs.jdField_c_of_type_Int, paramlrs.jdField_a_of_type_Int, paramlrs.jdField_b_of_type_Int, paramlrs.d, paramlrs.e, paramlrs.jdField_b_of_type_Long, paramlrs.jdField_a_of_type_Boolean, VideoController.a().a, paramArrayOfByte1, paramlrs.f, paramlrs.g);
    }
  }
  
  public static boolean a()
  {
    return bkkj.b();
  }
  
  public static boolean a(int paramInt, long paramLong)
  {
    if (f()) {
      return true;
    }
    int i = bdcb.a();
    if (i < 17)
    {
      lek.c(jdField_a_of_type_JavaLangString, "isUserEffectFace error  OSversion:" + i);
      return false;
    }
    return a(paramInt, paramLong, 1073741824L);
  }
  
  public static boolean a(int paramInt, long paramLong1, long paramLong2)
  {
    int i = lnz.e();
    if (i < paramInt)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "isSupportOfDevice fail, cpuCount[" + i + " < " + paramInt + "]");
      return false;
    }
    long l = lnz.d();
    if ((l != 0L) && (l < paramLong1))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "isSupportOfDevice fail, cpuFrequency[" + l + " < " + paramLong1 + "]");
      return false;
    }
    paramLong1 = bdcb.d();
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
      this.jdField_a_of_type_Lse.a(paramLong);
    } while (!llz.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Lse.a(paramLong, llz.l, llz.k);
  }
  
  private void b(lrs paramlrs)
  {
    short s1 = 0;
    byte[] arrayOfByte = paramlrs.jdField_a_of_type_ArrayOfByte;
    lmk.a().a(arrayOfByte, 3);
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
      localObject5 = (lkt)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2);
      localObject1 = ((lkt)localObject5).a(paramlrs.jdField_b_of_type_Int, paramlrs.jdField_a_of_type_Int);
      if (localObject1 == null) {
        break label426;
      }
      localObject4 = ((lkr)localObject1).jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
      localObject3 = ((lkr)localObject1).jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem;
      localObject2 = localObject3;
      localObject1 = localObject4;
      if (localObject3 != null)
      {
        ((lkt)localObject5).a(this.jdField_a_of_type_Lks);
        localObject1 = localObject4;
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      if ((localObject1 == null) || (localObject2 == null)) {
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(13))
        {
          localObject3 = ((lkj)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(13)).a(paramlrs.jdField_b_of_type_Int, paramlrs.jdField_a_of_type_Int);
          if (localObject3 == null) {
            break label423;
          }
          localObject1 = ((lkr)localObject3).jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
          localObject2 = ((lkr)localObject3).jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem;
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
        for (localObject3 = ((ljs)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1)).a();; localObject3 = null)
        {
          localObject5 = paramlrs.jdField_a_of_type_Mtx;
          ((mtx)localObject5).c();
          localObject4 = this.jdField_a_of_type_Lse.a(paramlrs, (FilterDesc)localObject3, (VideoMaterial)localObject2, bool, false, (PendantItem)localObject1, this);
          ((mtx)localObject5).d();
          lmk.a().a(arrayOfByte, 0);
          int i = lkt.a((PendantItem)localObject1, false);
          GraphicRenderMgr.getInstance().setBeautyOrFaceConfig(i, 1);
          short s2;
          if (localObject4 != null)
          {
            localObject1 = ((lsf)localObject4).jdField_b_of_type_ArrayOfByte;
            localObject2 = ((lsf)localObject4).c;
            localObject3 = ((lsf)localObject4).d;
            s1 = ((lsf)localObject4).a;
            s2 = ((lsf)localObject4).jdField_b_of_type_Short;
            paramlrs = (lrs)localObject4;
          }
          for (;;)
          {
            paramlrs.jdField_a_of_type_Mtx = ((mtx)localObject5);
            a(paramlrs, (byte[])localObject1, (byte[])localObject2, (byte[])localObject3, s1, s2);
            return;
            bool = false;
            break;
            localObject3 = (lkj)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(13);
            if (localObject3 != null) {
              ((lkj)localObject3).c();
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
      ((lkt)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)).d();
    }
    if (this.jdField_a_of_type_Lse != null) {
      this.jdField_a_of_type_Lse.c(paramLong);
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
      if (lro.b()) {
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
    lrg locallrg = lrg.a();
    if ((locallrg != null) && (locallrg.f()))
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
    if ((locallrg != null) && (!locallrg.e()))
    {
      lek.e(jdField_a_of_type_JavaLangString, "isUserEffectFace| model in black list.modle=" + Build.MANUFACTURER + ":" + Build.MODEL);
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
      jdField_b_of_type_Boolean = llg.a(VideoController.a().a());
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
      ((lsa)localObject).c();
    }
    VideoController.a().k(GraphicRenderMgr.soloadedPTV);
    return bool2;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Lse != null) {
      this.jdField_a_of_type_Lse.b();
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
      ((lkt)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)).d();
    }
    if (this.jdField_a_of_type_Lse != null) {
      this.jdField_a_of_type_Lse.c();
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
    throw new IllegalArgumentException("setExtInfo fail, EXP_BIT_MAX[5" + alpo.a(2131704371));
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Lse != null) {
      this.jdField_a_of_type_Lse.b(paramLong);
    }
  }
  
  void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Lse.a(paramLong);
    this.jdField_a_of_type_Lse.a(paramLong, paramInt1, paramInt2);
  }
  
  protected void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      b(mwd.a(paramMessage.obj));
      return;
    case 2: 
      c(mwd.a(paramMessage.obj));
      return;
    case 3: 
      b((lrs)paramMessage.obj);
      return;
    case 4: 
      a(mwd.a(paramMessage.obj), llz.l, llz.k);
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
    this.jdField_a_of_type_Lks.a(paramVideoAppInterface);
  }
  
  void a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(130), paramString, paramArrayOfByte });
    }
  }
  
  public void a(lrs paramlrs)
  {
    this.jdField_a_of_type_Lsc.a(paramlrs.jdField_a_of_type_ArrayOfByte, paramlrs.jdField_a_of_type_Int, paramlrs.jdField_b_of_type_Int, paramlrs.jdField_c_of_type_Int, paramlrs.d, paramlrs.jdField_a_of_type_Long, paramlrs.jdField_a_of_type_Boolean, paramlrs.jdField_c_of_type_Long);
    if ((paramlrs.jdField_a_of_type_ArrayOfByte == null) || (paramlrs.jdField_a_of_type_Int == 0) || (paramlrs.jdField_b_of_type_Int == 0)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(3))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      lmk.a().a(2, 0);
    }
    lmk.a().a(paramlrs.jdField_a_of_type_ArrayOfByte, 2);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, paramlrs).sendToTarget();
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
        lek.c(jdField_a_of_type_JavaLangString, "buildExtInfo volume :" + paramShort1 + this.jdField_a_of_type_JavaUtilBitSet.get(1) + "|" + this.jdField_a_of_type_JavaUtilBitSet.get(0));
        if (paramShort1 < 100)
        {
          localObject = new byte[2];
          ByteUtils.Word2Byte((byte[])localObject, 0, (short)paramShort1);
          localObject = new lrd((short)2, (short)2, (byte[])localObject);
          if (this.jdField_a_of_type_JavaUtilBitSet.get(3))
          {
            localArrayList.add(localObject);
            paramShort2 = 0 + ((lrd)localObject).a();
            if (!this.jdField_a_of_type_JavaUtilBitSet.get(0))
            {
              paramShort1 = paramShort2;
              if (!this.jdField_a_of_type_JavaUtilBitSet.get(1)) {}
            }
            else
            {
              lek.c(jdField_a_of_type_JavaLangString, "buildExtInfo face :" + paramArrayOfByte1 + "|" + this.jdField_a_of_type_JavaUtilBitSet.get(1) + "|" + this.jdField_a_of_type_JavaUtilBitSet.get(0));
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
                paramArrayOfByte1 = new lrd((short)1, (short)paramArrayOfByte1.length, paramArrayOfByte1);
                if (paramArrayOfByte2 == null) {
                  break label648;
                }
                paramArrayOfByte2 = new lrd((short)4, (short)paramArrayOfByte2.length, paramArrayOfByte2);
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
                paramArrayOfByte1 = new lrd((short)6, (short)paramArrayOfByte3.length, paramArrayOfByte3);
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
                paramArrayOfByte1 = new lrd((short)3, (short)paramArrayOfByte1.length, paramArrayOfByte1);
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
        paramArrayOfByte1 = lio.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
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
            paramArrayOfByte1.put(lre.a((lrd)localArrayList.get(paramShort1)));
            paramShort1 += 1;
            continue;
            if (this.jdField_a_of_type_JavaUtilBitSet.get(2))
            {
              localObject = lre.a((lrd)localObject);
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
            if (((llc)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(5)).a(3, "SUPPORT_SWITCH_FACE") == 1) {}
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
            paramArrayOfByte1 = lre.a(paramArrayOfByte1);
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
    CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Lme);
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
    CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(this.jdField_a_of_type_Lme);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.obj = Long.valueOf(l);
    localMessage.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lsa
 * JD-Core Version:    0.7.0.1
 */