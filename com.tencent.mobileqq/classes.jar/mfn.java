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

public class mfn
  extends ldz
{
  public mfn(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  protected void a(long paramLong)
  {
    QLog.w(this.a.jdField_d_of_type_JavaLangString, 1, "onDestroyUI, groupId[" + paramLong + "], mRelationId[" + this.a.jdField_b_of_type_Long + "], mIntentRelationId[" + this.a.jdField_a_of_type_Long + "]");
    if ((this.a.jdField_b_of_type_Long == paramLong) || (this.a.jdField_a_of_type_Long == paramLong)) {
      this.a.d(true);
    }
  }
  
  protected void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super.a(paramLong, paramInt1, paramInt2, paramBoolean);
    this.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(paramLong, paramInt1, paramInt2, paramBoolean);
    ((AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).a.b(paramLong, paramBoolean);
    if (paramLong == this.a.c) {
      this.a.e();
    }
  }
  
  protected void a(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_d_of_type_JavaLangString, 1, "onGaOperationResult, result[" + paramInt1 + "], uin[" + paramLong2 + "], info[" + paramLong3 + "], groupId[" + paramLong4 + "], relationType[" + paramInt2 + "], mCameraNum[" + this.a.q + "], seq[" + paramLong1 + "]");
    }
    lno locallno;
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
        QLog.d(this.a.jdField_d_of_type_JavaLangString, 2, "onGaOperationResult --> EV_GA_SDK_REQUEST_VIDEO_SUC Failed. Info = " + paramLong3);
        return;
      } while (paramLong3 != 1L);
      this.a.a(this.a.c, paramInt1, false, -1, 0);
      return;
    case 90: 
      if (paramLong3 == 3L)
      {
        ArrayList localArrayList = this.a.jdField_a_of_type_ComTencentAvVideoController.a().c;
        paramInt1 = 0;
        if (paramInt1 >= localArrayList.size()) {
          break label761;
        }
        locallno = (lno)localArrayList.get(paramInt1);
        if ((paramLong2 != locallno.jdField_a_of_type_Long) || (locallno.jdField_a_of_type_Int != 1)) {
          break;
        }
      }
      break;
    }
    label485:
    label622:
    label761:
    for (boolean bool = locallno.jdField_a_of_type_Boolean;; bool = false)
    {
      this.a.jdField_b_of_type_Mcc.update(null, new Object[] { Integer.valueOf(105), Boolean.valueOf(bool), Long.valueOf(paramLong1) });
      this.a.C(paramLong1);
      this.a.a("onGaOperationResult.2", paramLong1);
      for (;;)
      {
        this.a.i(paramLong1, 65535);
        return;
        paramInt1 += 1;
        break;
        if (paramLong3 == 2L)
        {
          mak.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1029);
        }
        else if (paramLong3 == 4L)
        {
          if ((paramLong2 == this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().j))
          {
            paramInt1 = 1;
            if (paramInt1 != 0) {
              break label546;
            }
            mak.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1031);
          }
          for (;;)
          {
            if (this.a.jdField_e_of_type_Int != 2) {
              break label622;
            }
            bcef.b(null, "CliOper", "", "", "0X8004CFD", "0X8004CFD", 0, 0, "", "", "", "");
            break;
            paramInt1 = 0;
            break label485;
            if (QLog.isColorLevel()) {
              QLog.d(this.a.jdField_d_of_type_JavaLangString, 2, "VideoConstants.GaChatOperationResult.EV_GA_SDK_GO_ON_STAGE_SUC with repeat message " + MultiVideoCtrlLayerUIBase.a(this.a));
            }
            if (MultiVideoCtrlLayerUIBase.a(this.a))
            {
              mak.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1031);
              MultiVideoCtrlLayerUIBase.a(this.a, false);
            }
          }
        }
        else if (paramLong3 == 8L)
        {
          if (MultiVideoCtrlLayerUIBase.a(this.a))
          {
            MultiVideoCtrlLayerUIBase.a(this.a, false);
            mak.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1033, this.a.jdField_a_of_type_AndroidContentResResources.getString(2131695243));
          }
        }
        else if ((paramLong3 == 9L) && (MultiVideoCtrlLayerUIBase.a(this.a)))
        {
          MultiVideoCtrlLayerUIBase.a(this.a, false);
          mak.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1033, this.a.jdField_a_of_type_AndroidContentResResources.getString(2131695244));
        }
      }
      this.a.u(paramLong3);
      return;
      this.a.i(paramLong1, 65535);
      return;
    }
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    if (paramLong3 == this.a.c) {
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().j)
      {
        if (QLog.isColorLevel()) {
          QLog.w(this.a.jdField_d_of_type_JavaLangString, 1, "onMemberVideoOut, seq[" + paramLong1 + "]");
        }
        this.a.s(paramLong1);
        if (this.a.jdField_a_of_type_ComTencentAvVideoController != null) {
          this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.c, this.a.jdField_a_of_type_ComTencentAvVideoController.a().c, this.a.jdField_a_of_type_ComTencentAvVideoController.a().d, 1, false);
        }
      }
    }
    for (;;)
    {
      this.a.s();
      this.a.a(paramLong3, 6, false, 73, 0);
      return;
      lno locallno = new lno();
      locallno.jdField_a_of_type_Long = paramLong3;
      locallno.jdField_a_of_type_Int = paramInt;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(locallno);
      this.a.jdField_b_of_type_Mcc.update(null, new Object[] { Integer.valueOf(104), localArrayList });
      if (paramInt == 2)
      {
        this.a.i(1036);
        mak.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
      }
    }
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super.a(paramLong1, paramLong2, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_d_of_type_JavaLangString, 1, "onMemberLeave, mRelationId[" + this.a.jdField_b_of_type_Long + "], groupId[" + paramLong1 + "], friendUin[" + paramLong2 + "], isQQUser[" + this.a.jdField_d_of_type_Boolean + "->" + paramBoolean + "]");
    }
    if (this.a.jdField_b_of_type_Long != paramLong1) {
      return;
    }
    this.a.jdField_d_of_type_Boolean = paramBoolean;
    super.a(paramLong1, paramLong2, paramBoolean);
    this.a.a(paramLong2, 1, true, 71, 0);
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_d_of_type_JavaLangString, 1, "onMemberJoin, mRelationId[" + this.a.jdField_b_of_type_Long + "], groupId[" + paramLong1 + "], isQQUser[" + paramBoolean2 + "], friendUin[" + paramLong2 + "], isRefresh[" + paramBoolean1 + "]");
    }
    if (this.a.jdField_b_of_type_Long != paramLong1) {
      return;
    }
    this.a.jdField_d_of_type_Boolean = paramBoolean2;
    this.a.a(paramLong2, 0, paramBoolean1, 70, 0);
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong, paramBoolean1, paramBoolean2);
    if (((paramLong == this.a.c) && (paramBoolean1)) || ((paramBoolean1) || (paramLong == 0L))) {
      this.a.e();
    }
    if ((paramLong == this.a.c) || (paramLong == 0L)) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder();
      if (!paramBoolean1) {
        break;
      }
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().H != 1))
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
        str = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131695082);
        float f = mrj.a(str, this.a.jdField_e_of_type_AndroidWidgetTextView.getPaint());
        f = Math.min(this.a.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().widthPixels - f - this.a.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297934) * 2, this.a.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297158));
        mrj.b(localStringBuilder, (String)localObject, this.a.jdField_e_of_type_AndroidWidgetTextView.getPaint(), f);
        localStringBuilder.append(str);
      }
      mak.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1033, localStringBuilder.toString());
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null) && ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().H != 1) || (!paramBoolean1)) && ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().H != 0) || (paramBoolean1))) {
        this.a.e(paramBoolean1);
      }
    } while ((this.a.jdField_a_of_type_ComTencentAvVideoController.a() == null) || (paramBoolean2));
    Object localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
    if (paramBoolean1) {}
    for (int i = 1;; i = 0)
    {
      ((lez)localObject).e("setRoomMicOff", i);
      return;
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a() == null) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().H == 0)) {
        break;
      }
      localStringBuilder.append(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131695079));
      break;
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    super.a(paramLong, paramBoolean1, paramBoolean2, paramInt);
    if (paramBoolean1) {}
    for (int i = 42;; i = 43)
    {
      this.a.a(paramLong, 2, paramBoolean2, i, paramInt);
      return;
    }
  }
  
  protected void a(ArrayList<Long> paramArrayList, int paramInt)
  {
    if (paramInt == 0)
    {
      mak.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1034);
      mak.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1035);
      if (this.a.jdField_e_of_type_JavaLangRunnable != null)
      {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.jdField_e_of_type_JavaLangRunnable);
        this.a.jdField_e_of_type_JavaLangRunnable = null;
      }
      return;
    }
    if ((paramInt == 1) && (((Long)paramArrayList.get(0)).longValue() == this.a.c))
    {
      mak.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1034, 2131695066);
      mak.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1035, this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695410), new mfo(this));
      return;
    }
    Object localObject;
    long l;
    if (this.a.jdField_e_of_type_JavaLangRunnable == null)
    {
      this.a.jdField_e_of_type_JavaLangRunnable = new MultiVideoCtrlLayerUIBase.RefreshNoiseStateRunnable(this.a);
      localObject = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      Runnable localRunnable = this.a.jdField_e_of_type_JavaLangRunnable;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.c < 2000L)
      {
        l = 2000L;
        ((Handler)localObject).postDelayed(localRunnable, l);
      }
    }
    else
    {
      paramArrayList = this.a.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(paramArrayList.get(0)), String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().g), this.a.jdField_e_of_type_Int);
      float f = this.a.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297158);
      localObject = new StringBuilder();
      mrj.b((StringBuilder)localObject, paramArrayList, this.a.jdField_e_of_type_AndroidWidgetTextView.getPaint(), f);
      if (paramInt != 1) {
        break label419;
      }
      ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695067));
      mak.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1035, this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695411), new mfp(this));
    }
    for (;;)
    {
      paramArrayList = ((StringBuilder)localObject).toString();
      mak.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1034, paramArrayList);
      return;
      l = this.a.jdField_a_of_type_ComTencentAvVideoController.c;
      break;
      label419:
      ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695068)).append(paramInt);
      ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695069));
      mak.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1035, this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695412), new mfq(this));
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
      this.a.a(paramLong2, i, false, j, 0);
      return;
      i = 8;
      j = 79;
      this.a.i(1036);
      mak.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
    }
  }
  
  protected void c(long paramLong, int paramInt)
  {
    long l = AudioHelper.b();
    if (QLog.isDevelopLevel()) {
      QLog.w(this.a.jdField_d_of_type_JavaLangString, 1, "onFirstFrameDataComeIn, uin[" + paramLong + "], videoSrcType[" + paramInt + "], seq[" + l + "]");
    }
    paramInt = this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, paramInt);
    if ((paramInt != -1) && (((lno)this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.get(paramInt)).jdField_a_of_type_Boolean))
    {
      this.a.F();
      mak.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
      mak.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
    }
    this.a.C(l);
    this.a.e("onFirstFrameDataComeIn");
  }
  
  protected void c(long paramLong1, long paramLong2)
  {
    super.c(paramLong1, paramLong2);
    this.a.s();
    this.a.a(paramLong2, 5, false, 72, 0);
  }
  
  protected void d()
  {
    if ((this.a.f != null) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.a.f);
    }
  }
  
  protected void d(long paramLong, int paramInt)
  {
    super.d(paramLong, paramInt);
    if ((paramLong == this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) || (paramInt != 0) || (paramLong == 0L)) {
      this.a.e();
    }
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController.u) || (paramLong == this.a.c) || (paramLong == 0L)) {
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
      float f = this.a.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297158);
      localStringBuilder.append(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131695085));
      mrj.b(localStringBuilder, (String)localObject, this.a.jdField_e_of_type_AndroidWidgetTextView.getPaint(), f);
      localStringBuilder.append(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131695084));
      mak.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1033, localStringBuilder.toString());
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
      localStringBuilder.append(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131695086));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mfn
 * JD-Core Version:    0.7.0.1
 */