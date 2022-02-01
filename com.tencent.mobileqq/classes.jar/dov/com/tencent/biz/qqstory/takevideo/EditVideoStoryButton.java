package dov.com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.LiuHaiUtils;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.capture.view.ProviderView;
import dov.com.qq.im.capture.view.StaticStickerProviderView;
import dov.com.qq.im.editipc.PeakIpcController;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelItemInfo;

public class EditVideoStoryButton
  extends EditVideoPart
  implements View.OnClickListener
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  ProgressPieDrawable jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
  private ProviderView jdField_a_of_type_DovComQqImCaptureViewProviderView;
  private DoodleLayout jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
  private SendPanelItemInfo jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  float jdField_b_of_type_Float = 3.0F;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  
  public EditVideoStoryButton(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private Bundle a()
  {
    Bundle localBundle = null;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle != null) {
      localBundle = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle("container");
    }
    return localBundle;
  }
  
  private ProgressPieDrawable a()
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(a());
    localProgressPieDrawable.a(AIOUtils.a(50.0F, a()));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.g(-1);
    localProgressPieDrawable.f(0);
    localProgressPieDrawable.d(-15550475);
    localProgressPieDrawable.i(3);
    localProgressPieDrawable.jdField_f_of_type_Boolean = true;
    localProgressPieDrawable.jdField_f_of_type_Int = 2;
    localProgressPieDrawable.e(true);
    localProgressPieDrawable.a(new EditVideoStoryButton.5(this));
    return localProgressPieDrawable;
  }
  
  private void b(int paramInt)
  {
    int i = paramInt;
    if (b()) {
      i = (int)(paramInt * 50.0F / 100.0F + 50.0F);
    }
    c(i);
  }
  
  private void b(String paramString)
  {
    PeakIpcController.a(paramString, new EditVideoStoryButton.2(this));
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("VIDEO_STORY_JUMP_TO_TYPE", 0) == 2) {}
    for (int i = 1; (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (i == 0); i = 0) {
      return true;
    }
    return false;
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.b(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.d(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a(String.valueOf(paramInt) + "%");
    } while (!QLog.isColorLevel());
    QLog.w("EditVideoStoryButton", 2, "[setProgress] current:" + this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a() + ", progress:" + paramInt);
  }
  
  @TargetApi(16)
  private void k()
  {
    a(2131364261).setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131381506));
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131381508));
    if (LiuHaiUtils.f())
    {
      this.jdField_b_of_type_AndroidViewView = a(2131381517);
      this.jdField_b_of_type_AndroidViewView.setBackground(null);
    }
    a(2131381511).setOnClickListener(this);
    if ((!AECameraEntry.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent())) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14)) {
      ((TextView)a(2131381511)).setText(HardCodeUtil.a(2131703844));
    }
    Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent();
    int i = AECameraEntry.a((Intent)localObject);
    if ((AECameraEntry.e((Intent)localObject)) || (AECameraEntry.f((Intent)localObject)) || (i == AECameraEntry.n.a()) || (i == AECameraEntry.g.a()) || (i == AECameraEntry.q.a()) || (i == AECameraEntry.r.a()) || (i == AECameraEntry.o.a()) || (i == AECameraEntry.s.a()) || (i == AECameraEntry.v.a())) {
      ((TextView)a(2131381511)).setText(a().getText(2131716930));
    }
    if ((AECameraEntry.a((Intent)localObject, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())) || (AECameraEntry.c(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent())))
    {
      a(2131381520).setVisibility(8);
      a(2131381515).setVisibility(8);
      a(2131381516).setVisibility(8);
      if ((localObject != null) && (((Intent)localObject).getBooleanExtra("key_from_pic_choose", false))) {
        ((TextView)a(2131380149)).setText(2131694499);
      }
      a(2131381510).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131381513));
      this.jdField_a_of_type_AndroidViewView = a(2131381509);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
        if (i > 0) {
          break label641;
        }
        ((ViewGroup.LayoutParams)localObject).height += LiuHaiUtils.e;
        label437:
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        if (i > 0) {
          break label654;
        }
        ((ViewGroup.LayoutParams)localObject).height += LiuHaiUtils.e;
        label469:
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if ((VideoUtils.b()) && (ScreenUtil.getRealHeight(a()) / ScreenUtil.getRealWidth(a()) >= 2.0F) && (LiuHaiUtils.jdField_a_of_type_Boolean))
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        i = ((RelativeLayout.LayoutParams)localObject).leftMargin;
        int j = ((RelativeLayout.LayoutParams)localObject).topMargin;
        ((RelativeLayout.LayoutParams)localObject).setMargins(i, LiuHaiUtils.b((Activity)a()) + j, ((RelativeLayout.LayoutParams)localObject).rightMargin, ((RelativeLayout.LayoutParams)localObject).bottomMargin);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b()) {
        break label667;
      }
    }
    label641:
    label654:
    label667:
    for (localObject = "2";; localObject = "1")
    {
      VSReporter.a("mystatus_edit", "edit_exp", 0, 0, new String[] { localObject });
      if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
        break label674;
      }
      CaptureReportUtil.f(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager);
      return;
      a(2131381515).setOnClickListener(this);
      a(2131381516).setOnClickListener(this);
      break;
      ((ViewGroup.LayoutParams)localObject).height += i;
      break label437;
      ((ViewGroup.LayoutParams)localObject).height = (i + ((ViewGroup.LayoutParams)localObject).height);
      break label469;
    }
    label674:
    CaptureReportUtil.h(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager);
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView == null)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView = new StaticStickerProviderView(a());
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setTabBarPosition(1);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_DovComQqImCaptureViewProviderView);
    }
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EditVideoStoryButton", 2, "build provider view failed ");
      }
      return;
    }
    if (!this.jdField_a_of_type_DovComQqImCaptureViewProviderView.d())
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        int k = this.jdField_a_of_type_DovComQqImCaptureViewProviderView.d();
        int j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        int i = j;
        if (j <= 0) {
          i = LiuHaiUtils.e;
        }
        i = (int)UIUtils.a(a(), i);
        this.jdField_a_of_type_DovComQqImCaptureViewProviderView.d(i + k);
      }
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.a(a());
    }
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(0);
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView.c();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void n()
  {
    ShortVideoForwardManager.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity(), 21, "baseView", "{\n  \"data\": {\n    \"puin\": \"892820726\",\n    \"nick\": \"我五岁了哦！\",\n    \"id\": \"xx\",\n    \"avatarJumpUrl\": \"https://h5.qzone.qq.com/v2/wezone/jump?_wv=3&_proxy=1&schema=mqqapi%3A%2F%2Fqcircle%2Fopenmainpage%3Fuin%3D892820726%26issinglefeed%3D1%26from%3D6%26sharecategory%3D2%26shareentrance%3D1\",\n    \"contentJumpUrl\": \"https://h5.qzone.qq.com/v2/wezone/jump?_wv=3&_proxy=1&schema=mqqapi%3A%2F%2Fqcircle%2Fopendetail%3Ffeedid%3DB_193ead5f48eb06008928207260X5c%26sourcetype%3D10%26createtime%3D1605189145%26uin%3D892820726%26shareuin%3D1715054455%26issinglefeed%3D1%26from%3D6%26is_feed_detail%3D1%26sharecategory%3D2%26shareentrance%3D1\",\n    \"iconJumpUrl\": \"https://h5.qzone.qq.com/v2/wezone/jump?_wv=3&_proxy=1&schema=mqqapi%3A%2F%2Fqcircle%2Fopenfolder%3Fissinglefeed%3D1%26from%3D6%26sharecategory%3D2%26shareentrance%3D1\",\n    \"media\": [\n      {\n        \"isVideo\": true,\n        \"videoDuration\": 6153,\n        \"height\": 1080,\n        \"width\": 612,\n        \"url\": \"https://photogz.photo.store.qq.com/psc?/V54acxHN3cWMMd1uSEP42tVDpt3rbFDX/bqQfVz5yrrGYSXMvKr.cqfwp.5mjtGNPmLXd7x240uDFGDWpqsTaAx9IH1rzBk4C2oJi9NLpvQo.nrHoAHTVX6w0vBQPm2u1D8U5owjcQfc!/b&ek=1&kp=1&pt=0&bo=ZAI4BGQCOAQRECc!&tl=1&lsr=6&vuin=1715054455&tm=1607943600#sce=79-11-1&rf=v1_and_sq_8.5.0_0_rdm_b_t_-2-0-31\"\n      }\n    ],\n    \"total\": 1,\n    \"title\": \"分享了来自小世界的作品\",\n    \"type\": 2,\n    \"isAIO\": 1,\n    \"appName\": \"qcircle\",\n    \"fuelNum\": 57393,\n    \"likeNum\": 41463\n  }\n}");
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent().getStringExtra("KEY_SEND_ARK_MSG_ID");
    AEQLog.b("EditVideoStoryButton", "onCreate--arkViewId=" + this.jdField_a_of_type_JavaLangString);
    k();
  }
  
  public void a(int paramInt)
  {
    int i = paramInt;
    if (b()) {
      i = (int)(50.0F * paramInt / 100.0F);
    }
    c(i);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramIntent != null) && ((this.jdField_b_of_type_JavaLangString == null) || (!this.jdField_b_of_type_JavaLangString.equals(paramIntent.getStringExtra("fakeId")))));
        if (this.jdField_b_of_type_Int == 20) {}
        Object localObject;
        for (boolean bool = true;; bool = false)
        {
          localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo;
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
          this.jdField_a_of_type_Boolean = true;
          if (paramInt2 != -1) {
            break;
          }
          a(100);
          ThreadManager.excute(new EditVideoStoryButton.1(this, paramIntent, bool, (SendPanelItemInfo)localObject), 64, null, true);
          return;
        }
        if (paramInt2 == 1)
        {
          i();
          if (b())
          {
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.m();
            return;
          }
          localObject = new StringBuilder(HardCodeUtil.a(2131703919));
          if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
            ((StringBuilder)localObject).append(": ").append(paramIntent.getStringExtra("error"));
          }
          QQToast.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), 1, (CharSequence)localObject, 0).a();
          return;
        }
      } while (paramInt2 != 0);
      i();
      return;
    } while (paramInt2 != -1);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(paramInt2, paramIntent, 2130772034, 0);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    super.a(paramInt1, paramInt2, paramObject);
    switch (paramInt2)
    {
    default: 
      c();
    }
    do
    {
      return;
      m();
      return;
      if (paramInt1 == 6) {
        a(true, true, false);
      }
      for (;;)
      {
        c();
        this.jdField_b_of_type_Int = paramInt2;
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo = null;
        return;
        a(true, false);
      }
      a(false, false);
      return;
      this.jdField_b_of_type_Int = paramInt2;
    } while (!(paramObject instanceof SendPanelItemInfo));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo = ((SendPanelItemInfo)paramObject);
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Float = paramInt;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Float = (50000.0F / (float)paramLong);
    if (this.jdField_b_of_type_Float == 0.0F) {
      this.jdField_b_of_type_Float = 1.0F;
    }
    d();
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  @TargetApi(14)
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(a());
      Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        if (Build.VERSION.SDK_INT >= 14) {
          ((Window)localObject).setDimAmount(0.0F);
        }
      }
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561994);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373545);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371908)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(0);
    a().a().postDelayed(new EditVideoStoryButton.3(this), paramInt);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramBoolean1, paramBoolean2, true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean2)
    {
      this.d = (System.currentTimeMillis() + 500L);
      if (paramBoolean3) {
        this.d += 500L;
      }
      if (paramBoolean1) {
        TakeVideoUtils.a(this.jdField_a_of_type_AndroidViewViewGroup, paramBoolean3);
      }
      for (;;)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 11, Long.valueOf(this.d)));
        return;
        TakeVideoUtils.a(this.jdField_a_of_type_AndroidViewViewGroup);
      }
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setAnimation(null);
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramBoolean1) {}
    for (int i = 0;; i = 8)
    {
      localViewGroup.setVisibility(i);
      this.d = 0L;
      break;
    }
  }
  
  public boolean a()
  {
    return System.currentTimeMillis() < this.d;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  void d()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi == null) {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a().postDelayed(new EditVideoStoryButton.4(this), 1000L);
  }
  
  public void g()
  {
    i();
    super.g();
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (Math.abs(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) > 500L)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      i = paramView.getId();
      if (this.d <= System.currentTimeMillis()) {
        break label91;
      }
      SLog.d("EditVideoStoryButton", "animation is playing, please wait, animation end time: %d, now: %d.", new Object[] { Long.valueOf(this.d), Long.valueOf(System.currentTimeMillis()) });
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      SLog.d("EditVideoStoryButton", "you click button too fast, ignore it !");
      continue;
      label91:
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.z();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.r();
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null))
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditMode(false);
        if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a() != null) && (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a().getTakePicToVideo())) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditMode(true);
        }
      }
      switch (i)
      {
      case 2131381512: 
      case 2131381513: 
      case 2131381514: 
      default: 
        break;
      case 2131381510: 
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.e();
        break;
      case 2131381516: 
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(2))
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
        }
        else
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.u();
          VSReporter.a("mystatus_edit", "word_entry_clk", 0, 0, new String[0]);
        }
        break;
      case 2131381515: 
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(3))
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
        }
        else
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(3);
          VSReporter.a("mystatus_edit", "sticker_entry_clk", 0, 0, new String[0]);
        }
        break;
      case 2131381511: 
        AEQLog.b("EditVideoStoryButton", "【Click】+ video_story_control_publish");
        long l = SystemClock.uptimeMillis();
        if ((l - this.jdField_b_of_type_Long >= 800L) && (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().isFinishing()))
        {
          this.jdField_b_of_type_Long = l;
          QLog.i("[vs_publish_flow] ", 1, "on vs publish button click");
          AEBaseReportParam.a().c();
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.d();
          AEBaseDataReporter.a().c();
          AEBaseReportParam.a().e();
          if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
            CaptureReportUtil.e(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager);
          } else {
            CaptureReportUtil.g(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager);
          }
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton
 * JD-Core Version:    0.7.0.1
 */