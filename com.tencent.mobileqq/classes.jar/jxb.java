import android.content.res.Resources;
import android.os.Handler;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.MultiMembersAudioUI;
import com.tencent.av.ui.MultiMembersVideoUI;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.av.utils.EllipsisUtil;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class jxb
  extends GAudioUIObserver
{
  public jxb(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  protected void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2)
  {
    super.a(paramInt1, paramLong1, paramLong2, paramLong3, paramInt2);
    label301:
    label318:
    VideoViewInfo localVideoViewInfo;
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
          if (QLog.isColorLevel()) {
            QLog.d(this.a.jdField_c_of_type_JavaLangString, 2, "request video success,Info = " + paramLong2);
          }
          if (paramLong2 == 1L)
          {
            this.a.i("onGaOperationResult");
            this.a.R();
            this.a.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c);
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d(this.a.jdField_c_of_type_JavaLangString, 2, "onGaOperationResult --> EV_GA_SDK_REQUEST_VIDEO_SUC Failed. Info = " + paramLong2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_c_of_type_JavaLangString, 2, "request video failed");
        }
      } while (paramLong2 != 1L);
      this.a.c(this.a.jdField_c_of_type_Long, paramInt1, false, -1);
      return;
    case 90: 
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_c_of_type_JavaLangString, 2, "go on stage success CameraNum=" + this.a.n);
      }
      if (paramLong2 == 3L) {
        if (this.a.n > 1)
        {
          this.a.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
          ArrayList localArrayList = this.a.jdField_a_of_type_ComTencentAvVideoController.a().c;
          paramInt1 = 0;
          if (paramInt1 >= localArrayList.size()) {
            break label657;
          }
          localVideoViewInfo = (VideoViewInfo)localArrayList.get(paramInt1);
          if (paramLong1 != localVideoViewInfo.jdField_a_of_type_Long) {
            break label424;
          }
        }
      }
      break;
    }
    label657:
    for (boolean bool = localVideoViewInfo.jdField_a_of_type_Boolean;; bool = false)
    {
      this.a.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(105), Boolean.valueOf(bool) });
      this.a.ad();
      this.a.R();
      this.a.c(true);
      return;
      this.a.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
      break label301;
      label424:
      paramInt1 += 1;
      break label318;
      this.a.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.a.t(2131365399);
      this.a.n();
      if (paramLong2 == 2L)
      {
        this.a.n(54);
        return;
      }
      if (paramLong2 != 4L) {
        break;
      }
      this.a.n(55);
      if (this.a.d != 2) {
        break;
      }
      ReportController.b(null, "CliOper", "", "", "0X8004CFD", "0X8004CFD", 0, 0, "", "", "", "");
      return;
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_c_of_type_JavaLangString, 2, "go on stage failed");
      }
      this.a.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.a.t(2131365399);
      this.a.n();
      if (paramLong2 == 7L) {
        this.a.n(56);
      }
      while (this.a.d == 2)
      {
        ReportController.b(null, "CliOper", "", "", "0X800441E", "0X800441E", 0, 0, "", "", "", "");
        return;
        this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(48, true);
      }
      this.a.n();
      return;
    }
  }
  
  protected void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super.a(paramLong, paramInt1, paramInt2, paramBoolean);
    this.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(paramLong, paramInt1, paramInt2, paramBoolean);
    this.a.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.a(paramLong, paramInt1, paramInt2, paramBoolean);
    if (paramLong == this.a.jdField_c_of_type_Long) {
      this.a.x();
    }
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
    this.a.c(paramLong2, 5, false, 72);
  }
  
  protected void a(long paramLong1, long paramLong2, int paramInt)
  {
    super.a(paramLong1, paramLong2, paramInt);
    if (paramLong2 == this.a.jdField_c_of_type_Long) {
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.a.jdField_c_of_type_JavaLangString, 2, "onMemberVideoOut-->Server Go off Stage ,must close local video");
        }
        this.a.O();
        if (this.a.jdField_a_of_type_ComTencentAvVideoController != null) {
          this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.jdField_c_of_type_Long, this.a.jdField_a_of_type_ComTencentAvVideoController.a().c, 1, false);
        }
      }
    }
    for (;;)
    {
      this.a.c(paramLong2, 6, false, 73);
      return;
      VideoViewInfo localVideoViewInfo = new VideoViewInfo();
      localVideoViewInfo.jdField_a_of_type_Long = paramLong2;
      localVideoViewInfo.jdField_a_of_type_Int = paramInt;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localVideoViewInfo);
      this.a.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(104), localArrayList });
      if (paramInt == 2)
      {
        TipsManager.c(106);
        this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106);
      }
    }
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super.a(paramLong1, paramLong2, paramBoolean);
    if (this.a.jdField_b_of_type_Long != paramLong1)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.a.jdField_c_of_type_JavaLangString, 2, "onMemberJoin,wrong group uin.GroupUin = " + paramLong1 + " , RelationId = " + this.a.jdField_b_of_type_Long + " , isQQUser = " + paramBoolean);
      }
      return;
    }
    this.a.jdField_e_of_type_Boolean = paramBoolean;
    super.a(paramLong1, paramLong2, paramBoolean);
    this.a.c(paramLong2, 1, true, 71);
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    if (this.a.jdField_b_of_type_Long != paramLong1)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.a.jdField_c_of_type_JavaLangString, 2, "onMemberJoin , wrong group uin. GroupUin = " + paramLong1 + " , mRelationId = " + this.a.jdField_b_of_type_Long + " , isQQUser = " + paramBoolean2);
      }
      return;
    }
    this.a.jdField_e_of_type_Boolean = paramBoolean2;
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
  
  protected void a(ArrayList paramArrayList, int paramInt)
  {
    if (paramInt == 0)
    {
      TipsManager.c(104);
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(104);
      if (this.a.jdField_e_of_type_JavaLangRunnable != null)
      {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.jdField_e_of_type_JavaLangRunnable);
        this.a.jdField_e_of_type_JavaLangRunnable = null;
      }
      return;
    }
    if ((paramInt == 1) && (((Long)paramArrayList.get(0)).longValue() == this.a.jdField_c_of_type_Long))
    {
      this.a.j.setText("自我静音");
      TipsManager.a(104, "你的环境有些嘈杂，为免影响他人，不发言时请静音。");
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(104, "你的环境有些嘈杂，为免影响他人，不发言时请静音。", false);
      return;
    }
    Object localObject;
    long l;
    if (this.a.jdField_e_of_type_JavaLangRunnable == null)
    {
      this.a.jdField_e_of_type_JavaLangRunnable = new jxh(this.a);
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
      paramArrayList = this.a.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(paramArrayList.get(0)), String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long), this.a.d);
      float f = this.a.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559833);
      localObject = new StringBuilder();
      EllipsisUtil.b((StringBuilder)localObject, paramArrayList, this.a.i.getPaint(), f);
      if (paramInt != 1) {
        break label362;
      }
      ((StringBuilder)localObject).append("的环境有些嘈杂。");
      this.a.j.setText("将TA静音");
    }
    for (;;)
    {
      paramArrayList = ((StringBuilder)localObject).toString();
      TipsManager.a(104, paramArrayList);
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(104, paramArrayList, false);
      return;
      l = this.a.jdField_a_of_type_ComTencentAvVideoController.jdField_c_of_type_Long;
      break;
      label362:
      ((StringBuilder)localObject).append("等").append(paramInt);
      ((StringBuilder)localObject).append("人的环境有些嘈杂。");
      this.a.j.setText("设置他们的麦克风静音");
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
      TipsManager.c(106);
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106);
    }
  }
  
  protected void b(long paramLong, boolean paramBoolean)
  {
    super.b(paramLong, paramBoolean);
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.y) {}
    do
    {
      return;
      this.a.x();
    } while ((paramLong == 0L) || (paramLong == this.a.jdField_c_of_type_Long));
    Object localObject2;
    if (this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(paramLong), String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long), this.a.d);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() != 0) {}
      }
      else
      {
        localObject1 = String.valueOf(paramLong);
      }
      float f = this.a.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559833);
      localObject2 = new StringBuilder();
      EllipsisUtil.b((StringBuilder)localObject2, (String)localObject1, this.a.i.getPaint(), f);
      if (!paramBoolean) {
        break label219;
      }
    }
    label219:
    for (Object localObject1 = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131429162);; localObject1 = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131429163))
    {
      ((StringBuilder)localObject2).append((String)localObject1);
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(70, ((StringBuilder)localObject2).toString(), 5000L, 0);
      this.a.k(paramBoolean);
      return;
    }
  }
  
  protected void c()
  {
    super.c();
    if ((this.a.f != null) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.a.f);
    }
  }
  
  protected void c(long paramLong)
  {
    super.c(paramLong);
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long == paramLong) {
      this.a.i(true);
    }
  }
  
  protected void c(long paramLong, int paramInt)
  {
    super.c(paramLong, paramInt);
    paramInt = this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, paramInt);
    if ((paramInt != -1) && (((VideoViewInfo)this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.get(paramInt)).jdField_a_of_type_Boolean))
    {
      TipsManager.c(106);
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106);
      TipsManager.c(103);
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(103);
    }
    this.a.ad();
    this.a.j("onFirstFrameDataComeIn");
  }
  
  protected void c(long paramLong, boolean paramBoolean)
  {
    super.c(paramLong, paramBoolean);
    this.a.x();
    if (paramLong == this.a.jdField_c_of_type_Long) {
      return;
    }
    Object localObject2;
    if (this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(paramLong), String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long), this.a.d);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() != 0) {}
      }
      else
      {
        localObject1 = String.valueOf(paramLong);
      }
      float f = this.a.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559833);
      localObject2 = new StringBuilder();
      EllipsisUtil.b((StringBuilder)localObject2, (String)localObject1, this.a.i.getPaint(), f);
      if (!paramBoolean) {
        break label200;
      }
    }
    label200:
    for (Object localObject1 = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131429160);; localObject1 = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131429161))
    {
      ((StringBuilder)localObject2).append((String)localObject1);
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(70, ((StringBuilder)localObject2).toString(), 5000L, 0);
      this.a.k(paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jxb
 * JD-Core Version:    0.7.0.1
 */