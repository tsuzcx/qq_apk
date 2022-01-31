import android.content.res.Resources;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MultiMembersAudioUI;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase.RefreshNoiseStateRunnable;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class mfv
  extends lfb
{
  public mfv(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  protected void a(long paramLong)
  {
    QLog.w(this.a.jdField_c_of_type_JavaLangString, 1, "onDestroyUI, groupId[" + paramLong + "], mRelationId[" + this.a.jdField_b_of_type_Long + "], mIntentRelationId[" + this.a.jdField_a_of_type_Long + "]");
    if ((this.a.jdField_b_of_type_Long == paramLong) || (this.a.jdField_a_of_type_Long == paramLong)) {
      this.a.d(true);
    }
  }
  
  protected void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super.a(paramLong, paramInt1, paramInt2, paramBoolean);
    this.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(paramLong, paramInt1, paramInt2, paramBoolean);
    ((AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).a.b(paramLong, paramBoolean);
    if (paramLong == this.a.jdField_c_of_type_Long) {
      this.a.e();
    }
  }
  
  protected void a(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_c_of_type_JavaLangString, 1, "onGaOperationResult, result[" + paramInt1 + "], uin[" + paramLong2 + "], info[" + paramLong3 + "], groupId[" + paramLong4 + "], relationType[" + paramInt2 + "], mCameraNum[" + this.a.o + "], seq[" + paramLong1 + "]");
    }
    lon locallon;
    switch (paramInt1)
    {
    default: 
    case 96: 
    case 97: 
    case 98: 
      do
      {
        do
        {
          return;
          if (paramLong3 == 1L)
          {
            this.a.d("onGaOperationResult");
            this.a.a("onGaOperationResult.1", paramLong1);
            this.a.b(paramLong1, this.a.jdField_a_of_type_ComTencentAvVideoController.a().c);
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d(this.a.jdField_c_of_type_JavaLangString, 2, "onGaOperationResult --> EV_GA_SDK_REQUEST_VIDEO_SUC Failed. Info = " + paramLong3);
        return;
      } while (paramLong3 != 1L);
      this.a.c(this.a.jdField_c_of_type_Long, paramInt1, false, -1);
      return;
    case 90: 
      if (paramLong3 == 3L)
      {
        ArrayList localArrayList = this.a.jdField_a_of_type_ComTencentAvVideoController.a().c;
        paramInt1 = 0;
        if (paramInt1 >= localArrayList.size()) {
          break label751;
        }
        locallon = (lon)localArrayList.get(paramInt1);
        if (paramLong2 != locallon.jdField_a_of_type_Long) {
          break;
        }
      }
      break;
    }
    label475:
    label612:
    label751:
    for (boolean bool = locallon.jdField_a_of_type_Boolean;; bool = false)
    {
      this.a.jdField_b_of_type_Mcf.update(null, new Object[] { Integer.valueOf(105), Boolean.valueOf(bool), Long.valueOf(paramLong1) });
      this.a.z(paramLong1);
      this.a.a("onGaOperationResult.2", paramLong1);
      for (;;)
      {
        this.a.f(paramLong1, 65535);
        return;
        paramInt1 += 1;
        break;
        if (paramLong3 == 2L)
        {
          mao.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1029);
        }
        else if (paramLong3 == 4L)
        {
          if ((paramLong2 == this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().j))
          {
            paramInt1 = 1;
            if (paramInt1 != 0) {
              break label536;
            }
            mao.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1031);
          }
          for (;;)
          {
            if (this.a.jdField_e_of_type_Int != 2) {
              break label612;
            }
            axqy.b(null, "CliOper", "", "", "0X8004CFD", "0X8004CFD", 0, 0, "", "", "", "");
            break;
            paramInt1 = 0;
            break label475;
            if (QLog.isColorLevel()) {
              QLog.d(this.a.jdField_c_of_type_JavaLangString, 2, "VideoConstants.GaChatOperationResult.EV_GA_SDK_GO_ON_STAGE_SUC with repeat message " + MultiVideoCtrlLayerUIBase.a(this.a));
            }
            if (MultiVideoCtrlLayerUIBase.a(this.a))
            {
              mao.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1031);
              MultiVideoCtrlLayerUIBase.a(this.a, false);
            }
          }
        }
        else if (paramLong3 == 8L)
        {
          if (MultiVideoCtrlLayerUIBase.a(this.a))
          {
            MultiVideoCtrlLayerUIBase.a(this.a, false);
            mao.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1033, this.a.jdField_a_of_type_AndroidContentResResources.getString(2131696017));
          }
        }
        else if ((paramLong3 == 9L) && (MultiVideoCtrlLayerUIBase.a(this.a)))
        {
          MultiVideoCtrlLayerUIBase.a(this.a, false);
          mao.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1033, this.a.jdField_a_of_type_AndroidContentResResources.getString(2131696018));
        }
      }
      this.a.t(paramLong3);
      return;
      this.a.f(paramLong1, 65535);
      return;
    }
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    if (paramLong3 == this.a.jdField_c_of_type_Long) {
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().j)
      {
        if (QLog.isColorLevel()) {
          QLog.w(this.a.jdField_c_of_type_JavaLangString, 1, "onMemberVideoOut, seq[" + paramLong1 + "]");
        }
        this.a.r(paramLong1);
        if (this.a.jdField_a_of_type_ComTencentAvVideoController != null) {
          this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.jdField_c_of_type_Long, this.a.jdField_a_of_type_ComTencentAvVideoController.a().c, this.a.jdField_a_of_type_ComTencentAvVideoController.a().d, 1, false);
        }
      }
    }
    for (;;)
    {
      this.a.c(paramLong3, 6, false, 73);
      return;
      lon locallon = new lon();
      locallon.jdField_a_of_type_Long = paramLong3;
      locallon.jdField_a_of_type_Int = paramInt;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(locallon);
      this.a.jdField_b_of_type_Mcf.update(null, new Object[] { Integer.valueOf(104), localArrayList });
      if (paramInt == 2)
      {
        this.a.i(1036);
        mao.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
      }
    }
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super.a(paramLong1, paramLong2, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_c_of_type_JavaLangString, 1, "onMemberLeave, mRelationId[" + this.a.jdField_b_of_type_Long + "], groupId[" + paramLong1 + "], friendUin[" + paramLong2 + "], isQQUser[" + this.a.jdField_d_of_type_Boolean + "->" + paramBoolean + "]");
    }
    if (this.a.jdField_b_of_type_Long != paramLong1) {
      return;
    }
    this.a.jdField_d_of_type_Boolean = paramBoolean;
    super.a(paramLong1, paramLong2, paramBoolean);
    this.a.c(paramLong2, 1, true, 71);
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_c_of_type_JavaLangString, 1, "onMemberJoin, mRelationId[" + this.a.jdField_b_of_type_Long + "], groupId[" + paramLong1 + "], isQQUser[" + paramBoolean2 + "], friendUin[" + paramLong2 + "], isRefresh[" + paramBoolean1 + "]");
    }
    if (this.a.jdField_b_of_type_Long != paramLong1) {
      return;
    }
    this.a.jdField_d_of_type_Boolean = paramBoolean2;
    this.a.c(paramLong2, 0, paramBoolean1, 70);
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong, paramBoolean1, paramBoolean2);
    if (paramBoolean1) {}
    for (int i = 42;; i = 43)
    {
      this.a.c(paramLong, 2, paramBoolean2, i);
      return;
    }
  }
  
  protected void a(ArrayList<Long> paramArrayList, int paramInt)
  {
    if (paramInt == 0)
    {
      mao.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1034);
      mao.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1035);
      if (this.a.jdField_e_of_type_JavaLangRunnable != null)
      {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.jdField_e_of_type_JavaLangRunnable);
        this.a.jdField_e_of_type_JavaLangRunnable = null;
      }
      return;
    }
    if ((paramInt == 1) && (((Long)paramArrayList.get(0)).longValue() == this.a.jdField_c_of_type_Long))
    {
      mao.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1034, 2131695843);
      mao.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1035, this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131696177), new mfw(this));
      return;
    }
    Object localObject;
    long l;
    if (this.a.jdField_e_of_type_JavaLangRunnable == null)
    {
      this.a.jdField_e_of_type_JavaLangRunnable = new MultiVideoCtrlLayerUIBase.RefreshNoiseStateRunnable(this.a);
      localObject = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      Runnable localRunnable = this.a.jdField_e_of_type_JavaLangRunnable;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.jdField_c_of_type_Long < 2000L)
      {
        l = 2000L;
        ((Handler)localObject).postDelayed(localRunnable, l);
      }
    }
    else
    {
      paramArrayList = this.a.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(paramArrayList.get(0)), String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().g), this.a.jdField_e_of_type_Int);
      float f = this.a.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297021);
      localObject = new StringBuilder();
      mrc.b((StringBuilder)localObject, paramArrayList, this.a.jdField_d_of_type_AndroidWidgetTextView.getPaint(), f);
      if (paramInt != 1) {
        break label419;
      }
      ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695844));
      mao.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1035, this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131696178), new mfx(this));
    }
    for (;;)
    {
      paramArrayList = ((StringBuilder)localObject).toString();
      mao.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1034, paramArrayList);
      return;
      l = this.a.jdField_a_of_type_ComTencentAvVideoController.jdField_c_of_type_Long;
      break;
      label419:
      ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695845)).append(paramInt);
      ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695846));
      mao.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1035, this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131696179), new mfy(this));
    }
  }
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.b(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    int i;
    int j;
    if (paramBoolean1)
    {
      i = 7;
      j = 78;
    }
    for (;;)
    {
      this.a.c(paramLong2, i, false, j);
      return;
      i = 8;
      j = 79;
      this.a.i(1036);
      mao.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
    }
  }
  
  protected void b(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.b(paramLong, paramBoolean1, paramBoolean2);
    if (((!this.a.jdField_a_of_type_ComTencentAvVideoController.v) && ((paramLong != this.a.jdField_c_of_type_Long) || (!paramBoolean1)) && (paramBoolean1)) || (paramLong == 0L)) {
      this.a.e();
    }
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController.v) || (paramLong == this.a.jdField_c_of_type_Long) || (paramLong == 0L)) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder();
      if (!paramBoolean1) {
        break;
      }
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().G != 1))
      {
        String str = this.a.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(paramLong), String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().g), this.a.jdField_e_of_type_Int);
        if (str != null)
        {
          localObject = str;
          if (str.length() != 0) {}
        }
        else
        {
          localObject = String.valueOf(paramLong);
        }
        str = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131695859);
        float f = mrc.a(str, this.a.jdField_d_of_type_AndroidWidgetTextView.getPaint());
        f = Math.min(this.a.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().widthPixels - f - this.a.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297765) * 2, this.a.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297021));
        mrc.b(localStringBuilder, (String)localObject, this.a.jdField_d_of_type_AndroidWidgetTextView.getPaint(), f);
        localStringBuilder.append(str);
      }
      mao.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1033, localStringBuilder.toString());
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null) && ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().G != 1) || (!paramBoolean1)) && ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().G != 0) || (paramBoolean1))) {
        this.a.e(paramBoolean1);
      }
    } while ((this.a.jdField_a_of_type_ComTencentAvVideoController.a() == null) || (paramBoolean2));
    Object localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
    if (paramBoolean1) {}
    for (int i = 1;; i = 0)
    {
      ((lga)localObject).c("setRoomMicOff", i);
      return;
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a() == null) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().G == 0)) {
        break;
      }
      localStringBuilder.append(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131695856));
      break;
    }
  }
  
  protected void c()
  {
    if ((this.a.f != null) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.a.f);
    }
  }
  
  protected void c(long paramLong, int paramInt)
  {
    long l = AudioHelper.b();
    if (QLog.isDevelopLevel()) {
      QLog.w(this.a.jdField_c_of_type_JavaLangString, 1, "onFirstFrameDataComeIn, uin[" + paramLong + "], videoSrcType[" + paramInt + "], seq[" + l + "]");
    }
    paramInt = this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, paramInt);
    if ((paramInt != -1) && (((lon)this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.get(paramInt)).jdField_a_of_type_Boolean))
    {
      this.a.E();
      mao.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
      mao.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
    }
    this.a.z(l);
    this.a.e("onFirstFrameDataComeIn");
  }
  
  protected void c(long paramLong1, long paramLong2)
  {
    super.c(paramLong1, paramLong2);
    this.a.c(paramLong2, 5, false, 72);
  }
  
  protected void d(long paramLong, int paramInt)
  {
    super.d(paramLong, paramInt);
    if ((paramLong == this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) || (paramInt != 0) || (paramLong == 0L)) {
      this.a.e();
    }
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController.v) || (paramLong == this.a.jdField_c_of_type_Long) || (paramLong == 0L)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    if (paramInt == 1)
    {
      String str = this.a.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(paramLong), String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().g), this.a.jdField_e_of_type_Int);
      if (str != null)
      {
        localObject = str;
        if (str.length() != 0) {}
      }
      else
      {
        localObject = String.valueOf(paramLong);
      }
      float f = this.a.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297021);
      localStringBuilder.append(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131695862));
      mrc.b(localStringBuilder, (String)localObject, this.a.jdField_d_of_type_AndroidWidgetTextView.getPaint(), f);
      localStringBuilder.append(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131695861));
      mao.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1033, localStringBuilder.toString());
      localObject = this.a;
      if (paramInt != 1) {
        break label287;
      }
    }
    label287:
    for (boolean bool = true;; bool = false)
    {
      ((MultiVideoCtrlLayerUIBase)localObject).e(bool);
      return;
      if (paramInt != 0) {
        break;
      }
      localStringBuilder.append(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131695863));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mfv
 * JD-Core Version:    0.7.0.1
 */