import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.ByteUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.BitSet;

@TargetApi(18)
public class loz
  extends lox
  implements low
{
  private static boolean jdField_a_of_type_Boolean;
  static final int[] jdField_a_of_type_ArrayOfInt = { 2, 13, 14 };
  private int jdField_a_of_type_Int;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private BitSet jdField_a_of_type_JavaUtilBitSet;
  private lho jdField_a_of_type_Lho;
  
  public loz(VideoAppInterface paramVideoAppInterface)
  {
    QLog.w("EffectsRenderController", 1, "EffectsRenderController, constructor, app[" + paramVideoAppInterface + "], mContext[" + this.jdField_a_of_type_AndroidContentContext + "]", new Throwable("打印调用栈"));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramVideoAppInterface.getApplication();
    this.jdField_a_of_type_Lho = new lho(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Lpb = new lpb(this.jdField_a_of_type_AndroidContentContext, new lpo(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
    this.jdField_a_of_type_Lpb.a.a = this.jdField_a_of_type_Lho;
    this.jdField_a_of_type_JavaUtilBitSet = new BitSet();
    if (QLog.isColorLevel()) {
      com.tencent.av.video.effect.QavVideoEffect.DEBUG_MODE = true;
    }
    lot.a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public static boolean f()
  {
    if (Build.VERSION.SDK_INT <= 15) {
      if (QLog.isColorLevel()) {
        QLog.i("EffectsRenderController", 1, "isUserAfterTreatmentPower android.os.Build.VERSION.SDK_INT <= 15");
      }
    }
    do
    {
      return false;
      if (lol.b()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("EffectsRenderController", 1, "isUserAfterTreatmentPower isMachineSupportAfterTreatment=false");
    return false;
    return true;
  }
  
  public static boolean g()
  {
    boolean bool1 = true;
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = lid.a(VideoController.a().a());
      if (!jdField_a_of_type_Boolean)
      {
        QLog.w("EffectsRenderController", 1, "isLoadedSO, 加载so失败");
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
      QLog.w("EffectsRenderController", 1, "isLoadedSO, soloadedPTV[" + GraphicRenderMgr.soloadedPTV + "]");
      bool2 = GraphicRenderMgr.soloadedPTV;
      bool1 = bool2;
    } while (!GraphicRenderMgr.soloadedPTV);
    Object localObject = BaseApplicationImpl.getContext();
    localObject = VideoController.a().a((Context)localObject);
    if (localObject != null) {
      ((loz)localObject).b();
    }
    VideoController.a().j(GraphicRenderMgr.soloadedPTV);
    return bool2;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 5))
    {
      if (!this.jdField_a_of_type_JavaUtilBitSet.get(paramInt)) {
        QLog.w("EffectsRenderController", 1, "setExtInfo, flag[" + paramInt + "]", new Throwable("打印调用栈"));
      }
      this.jdField_a_of_type_JavaUtilBitSet.set(paramInt);
    }
    while (paramInt < 5) {
      return;
    }
    throw new IllegalArgumentException("setExtInfo fail, EXP_BIT_MAX[5" + anni.a(2131702780));
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_Lho.a(paramVideoAppInterface);
  }
  
  protected void a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(130), paramString, paramArrayOfByte });
    }
  }
  
  public void a(lop paramlop, lpq paramlpq)
  {
    int i = 0;
    paramlpq.a();
    boolean bool;
    label59:
    label65:
    lhk locallhk;
    if (!paramlpq.c)
    {
      if ((b()) && (lid.b()))
      {
        bool = true;
        paramlpq.c = bool;
      }
    }
    else
    {
      if ((!this.jdField_a_of_type_JavaUtilBitSet.get(0)) && (!this.jdField_a_of_type_JavaUtilBitSet.get(1))) {
        break label123;
      }
      bool = true;
      paramlpq.jdField_a_of_type_Boolean = bool;
      if (i >= jdField_a_of_type_ArrayOfInt.length) {
        break label197;
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(jdField_a_of_type_ArrayOfInt[i]))
      {
        locallhk = (lhk)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(jdField_a_of_type_ArrayOfInt[i]);
        if (locallhk != null) {
          break label129;
        }
      }
    }
    label123:
    do
    {
      i += 1;
      break label65;
      bool = false;
      break;
      bool = false;
      break label59;
      lhm locallhm = locallhk.a(paramlop.b, paramlop.jdField_a_of_type_Int);
      if (locallhm != null)
      {
        paramlpq.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = locallhm.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
        paramlpq.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = locallhm.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem;
      }
      if (paramlpq.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) {
        locallhk.a(this.jdField_a_of_type_Lho);
      }
    } while ((paramlpq.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem == null) || (paramlpq.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null));
    label129:
    label197:
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1)) {
      paramlpq.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = ((lgn)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1)).a();
    }
  }
  
  public boolean a()
  {
    if (!b()) {}
    for (;;)
    {
      return false;
      if ((lpj.b()) || (lpj.c())) {
        return true;
      }
      ley localley = lbu.a().a();
      if ((localley.d == 2) || (localley.d == 4)) {}
      for (int i = 1; (i != 0) && ((!localley.jdField_a_of_type_JavaUtilBitSet.isEmpty()) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.k()) || (localley.ax)); i = 0) {
        return true;
      }
    }
  }
  
  protected byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2, short paramShort3, short paramShort4)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    label318:
    label335:
    int i;
    if ((this.jdField_a_of_type_JavaUtilBitSet.get(0)) || (this.jdField_a_of_type_JavaUtilBitSet.get(1)) || (this.jdField_a_of_type_JavaUtilBitSet.get(2)) || (this.jdField_a_of_type_JavaUtilBitSet.get(3))) {
      if ((this.jdField_a_of_type_JavaUtilBitSet.get(2)) || (this.jdField_a_of_type_JavaUtilBitSet.get(3)))
      {
        paramShort1 = VideoController.a().b(false);
        lbc.c("EffectsRenderController", "buildExtInfo volume :" + paramShort1 + this.jdField_a_of_type_JavaUtilBitSet.get(1) + "|" + this.jdField_a_of_type_JavaUtilBitSet.get(0));
        if (paramShort1 < 100)
        {
          localObject = new byte[2];
          ByteUtils.Word2Byte((byte[])localObject, 0, (short)paramShort1);
          localObject = new loa((short)2, (short)2, (byte[])localObject);
          if (this.jdField_a_of_type_JavaUtilBitSet.get(3))
          {
            localArrayList.add(localObject);
            paramShort2 = 0 + ((loa)localObject).a();
            if (!this.jdField_a_of_type_JavaUtilBitSet.get(0))
            {
              paramShort1 = paramShort2;
              if (!this.jdField_a_of_type_JavaUtilBitSet.get(1)) {}
            }
            else
            {
              lbc.c("EffectsRenderController", "buildExtInfo face :" + paramArrayOfByte1 + "|" + this.jdField_a_of_type_JavaUtilBitSet.get(1) + "|" + this.jdField_a_of_type_JavaUtilBitSet.get(0));
              if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null))
              {
                paramShort1 = paramShort2;
                if (paramArrayOfByte3 == null) {}
              }
              else
              {
                if (paramArrayOfByte1 == null) {
                  break label641;
                }
                paramArrayOfByte1 = new loa((short)1, (short)paramArrayOfByte1.length, paramArrayOfByte1);
                if (paramArrayOfByte2 == null) {
                  break label646;
                }
                paramArrayOfByte2 = new loa((short)4, (short)paramArrayOfByte2.length, paramArrayOfByte2);
                if (paramArrayOfByte3 == null) {
                  break label651;
                }
                i = 1;
                label342:
                if (!this.jdField_a_of_type_JavaUtilBitSet.get(1)) {
                  break label747;
                }
                if (i == 0) {
                  break label657;
                }
                paramArrayOfByte1 = new loa((short)6, (short)paramArrayOfByte3.length, paramArrayOfByte3);
                localArrayList.add(paramArrayOfByte1);
                paramShort1 = paramArrayOfByte1.a() + paramShort2;
                label388:
                paramArrayOfByte1 = new byte[8];
                if (i == 0) {
                  break label731;
                }
                paramShort2 = paramShort4;
                label402:
                if (i == 0) {
                  break label739;
                }
                i = paramShort3;
                label411:
                paramArrayOfByte1[0] = ((byte)(paramShort2 >> 8));
                paramArrayOfByte1[1] = ((byte)(paramShort2 >> 0));
                paramArrayOfByte1[2] = ((byte)(i >> 8));
                paramArrayOfByte1[3] = ((byte)(i >> 0));
                paramArrayOfByte1[4] = ((byte)(paramShort3 >> 8));
                paramArrayOfByte1[5] = ((byte)(paramShort3 >> 0));
                paramArrayOfByte1[6] = ((byte)(paramShort4 >> 8));
                paramArrayOfByte1[7] = ((byte)(paramShort4 >> 0));
                paramArrayOfByte1 = new loa((short)3, (short)paramArrayOfByte1.length, paramArrayOfByte1);
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
      label510:
      paramShort2 = paramShort1;
      if (this.jdField_a_of_type_JavaUtilBitSet.get(4))
      {
        paramArrayOfByte1 = lfj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
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
            paramArrayOfByte1.put(lob.a((loa)localArrayList.get(paramShort1)));
            paramShort1 += 1;
            continue;
            if (this.jdField_a_of_type_JavaUtilBitSet.get(2))
            {
              localObject = lob.a((loa)localObject);
              a(this.jdField_a_of_type_JavaLangString, (byte[])localObject);
            }
            paramShort2 = 0;
            break;
            label641:
            paramArrayOfByte1 = null;
            break label318;
            label646:
            paramArrayOfByte2 = null;
            break label335;
            label651:
            i = 0;
            break label342;
            label657:
            if (((lhz)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(5)).a(3, "SUPPORT_SWITCH_FACE") == 1) {}
            for (paramShort1 = 1;; paramShort1 = 0)
            {
              if (paramShort1 != 0) {
                break label712;
              }
              localArrayList.add(paramArrayOfByte1);
              paramShort1 = paramArrayOfByte1.a() + paramShort2;
              break;
            }
            label712:
            localArrayList.add(paramArrayOfByte2);
            paramShort1 = paramArrayOfByte2.a() + paramShort2;
            break label388;
            label731:
            paramShort2 = 320;
            break label402;
            label739:
            i = 240;
            break label411;
            label747:
            paramShort1 = paramShort2;
            if (!this.jdField_a_of_type_JavaUtilBitSet.get(0)) {
              break label510;
            }
            paramArrayOfByte1 = lob.a(paramArrayOfByte1);
            a(this.jdField_a_of_type_JavaLangString, paramArrayOfByte1);
            paramShort1 = paramShort2;
            break label510;
          }
        }
        return paramArrayOfByte1.array();
      }
      return null;
      paramShort1 = 0;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 5))
    {
      if (this.jdField_a_of_type_JavaUtilBitSet.get(paramInt)) {
        QLog.w("EffectsRenderController", 1, "clearExtInfo, flag[" + paramInt + "]", new Throwable("打印调用栈"));
      }
      this.jdField_a_of_type_JavaUtilBitSet.clear(paramInt);
    }
  }
  
  protected void c(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)) {
      ((lhp)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)).c();
    }
    super.c(paramLong);
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)) {
      ((lhp)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)).c();
    }
    super.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     loz
 * JD-Core Version:    0.7.0.1
 */