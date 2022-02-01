package dov.com.qq.im.ae.camera.ui.topbar;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.LinearLayout;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.AECameraConfig;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.AEViewModelProviders;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.mode.AEVideoStoryCaptureModeViewModel;
import dov.com.qq.im.ae.part.AEVideoStoryStateViewModel;
import dov.com.qq.im.ae.part.VideoStoryBasePart;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.util.AEFastClickThrottle;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.view.AECircleCaptureStyle;
import dov.com.qq.im.ae.view.AECompoundButton;
import dov.com.qq.im.capture.view.PressScaleAnimDelegate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.light.DeviceSupportUtil;

public class AEVideoStoryTopBarPart
  extends VideoStoryBasePart
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 3;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private AEPituCameraUnit jdField_a_of_type_DovComQqImAeAEPituCameraUnit;
  private AEVideoStoryTopBarViewModel jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel;
  private AEVideoStoryCaptureModeViewModel jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel;
  private AEVideoStoryStateViewModel jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel;
  private AECompoundButton jdField_a_of_type_DovComQqImAeViewAECompoundButton;
  private boolean jdField_a_of_type_Boolean;
  private AECompoundButton b;
  private AECompoundButton c;
  private AECompoundButton d;
  private AECompoundButton e;
  private AECompoundButton f;
  private AECompoundButton g;
  private AECompoundButton h;
  
  public AEVideoStoryTopBarPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
  }
  
  private void a()
  {
    if (!"VIVO;V1836T".equalsIgnoreCase(Build.MANUFACTURER + ";" + Build.MODEL)) {}
    ViewGroup.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    } while (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams));
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localLayoutParams;
    localMarginLayoutParams.topMargin += DisplayUtil.b(this.mActivity, 20.0F);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  private void a(@NonNull AECircleCaptureStyle paramAECircleCaptureStyle)
  {
    if (!AECameraEntry.k(this.mActivity.getIntent())) {}
    do
    {
      return;
      if (this.f != null) {
        this.f.setForegroundAndBackgroundResource(paramAECircleCaptureStyle.k, paramAECircleCaptureStyle.j);
      }
      if (this.b != null) {
        this.b.setForegroundAndBackgroundResource(paramAECircleCaptureStyle.l, paramAECircleCaptureStyle.j);
      }
      if (this.c != null) {
        this.c.setForegroundAndBackgroundResource(paramAECircleCaptureStyle.m, paramAECircleCaptureStyle.j);
      }
      if (this.e != null) {
        this.e.setForegroundAndBackgroundResource(paramAECircleCaptureStyle.n, paramAECircleCaptureStyle.j);
      }
      if (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton != null) {
        this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setForegroundAndBackgroundResource(paramAECircleCaptureStyle.o, paramAECircleCaptureStyle.j);
      }
    } while (this.d == null);
    this.d.setForegroundAndBackgroundResource(paramAECircleCaptureStyle.p, paramAECircleCaptureStyle.j);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (!this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel.a()) {}
    }
    for (;;)
    {
      try
      {
        paramBoolean = DeviceSupportUtil.isAbilityDeviceSupport("shareGLContextError");
        AEQLog.a("AEVideoStoryTopBarPart", "[switchOnLowPriorityTopBtns]: deviceNotSupportSegment = " + paramBoolean);
        AECompoundButton localAECompoundButton = this.h;
        if (paramBoolean)
        {
          i = 8;
          localAECompoundButton.setVisibility(i);
          this.g.setVisibility(0);
          this.c.setVisibility(8);
          this.e.setVisibility(0);
          if (this.d != null) {
            this.d.setVisibility(0);
          }
          if (a()) {
            this.e.setVisibility(8);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        AEQLog.d("AEVideoStoryTopBarPart", "[DeviceSupportUtil.isAbilityDeviceSupport] e = " + localException.toString());
        paramBoolean = false;
        continue;
        int i = 0;
        continue;
      }
      this.c.setVisibility(0);
      continue;
      if (this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel.a())
      {
        this.h.setVisibility(8);
        this.g.setVisibility(8);
      }
      this.b.setVisibility(8);
      this.c.setVisibility(8);
      this.e.setVisibility(8);
      if (this.d != null) {
        this.d.setVisibility(8);
      }
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit).get(AEVideoStoryCaptureModeViewModel.class));
    this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel.a.observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new AEVideoStoryTopBarPart.2(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel = ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit).get(AEVideoStoryTopBarViewModel.class));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a().observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new AEVideoStoryTopBarPart.3(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new AEVideoStoryTopBarPart.4(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new AEVideoStoryTopBarPart.5(this));
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel = ((AEVideoStoryStateViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit).get(AEVideoStoryStateViewModel.class));
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.a().observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new AEVideoStoryTopBarPart.6(this));
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.b().observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new AEVideoStoryTopBarPart.7(this));
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.c().observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new AEVideoStoryTopBarPart.8(this));
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.d().observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new AEVideoStoryTopBarPart.9(this));
  }
  
  private boolean b()
  {
    if (AECameraEntry.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit)) {
      return false;
    }
    Object localObject1 = new HashMap();
    Object localObject2 = new ArrayList();
    ((List)localObject2).add("PCAM10");
    ((List)localObject2).add("PBBM30");
    ((List)localObject2).add("PBAM00");
    ((List)localObject2).add("PBBM00");
    ((List)localObject2).add("PADM00");
    ((List)localObject2).add("pcnm00");
    ((List)localObject2).add("PACM00");
    ((List)localObject2).add("R15x");
    ((List)localObject2).add("PBBM00");
    ((List)localObject2).add("pbft00");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("Y85A");
    localArrayList.add("Y85");
    localArrayList.add("u3x");
    localArrayList.add("X21A");
    localArrayList.add("Y93");
    localArrayList.add("Y81s");
    localArrayList.add("V1914A");
    localArrayList.add("V1918A");
    localArrayList.add("V1818CA");
    localArrayList.add("V1732T");
    localArrayList.add("V1914T");
    ((Map)localObject1).put("vivo", localArrayList);
    ((Map)localObject1).put("oppo", localObject2);
    if (Build.MANUFACTURER != null)
    {
      localObject1 = (List)((Map)localObject1).get(Build.MANUFACTURER.toLowerCase());
      if (localObject1 == null) {
        return "meizu 17".equals(Build.MODEL);
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if ((localObject2 != null) && ((((String)localObject2).equalsIgnoreCase(Build.MODEL)) || ((Build.MANUFACTURER + " " + (String)localObject2).equalsIgnoreCase(Build.MODEL)))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean c()
  {
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel == null) || (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b() == null)) {
      return false;
    }
    Boolean localBoolean = (Boolean)this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().getValue();
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  protected boolean a()
  {
    return (!this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.b().c()) || (!this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.b().f()) || (!this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.b().a());
  }
  
  public void initView()
  {
    ViewStub localViewStub = (ViewStub)this.mRootView.findViewById(2131378601);
    if (localViewStub != null) {
      this.jdField_a_of_type_AndroidViewView = localViewStub.inflate();
    }
    ViewCompat.setOnApplyWindowInsetsListener(this.jdField_a_of_type_AndroidViewView, new AEVideoStoryTopBarPart.1(this));
    ViewCompat.requestApplyInsets(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mRootView.findViewById(2131364284));
    this.f = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131364362));
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131364549));
    this.b = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131365536));
    this.e = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363542));
    this.e.setOnClickListener(this);
    this.d = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131364188));
    if (this.d != null) {
      this.d.setOnClickListener(this);
    }
    this.c = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131367119));
    this.g = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131365402));
    this.g.setOnClickListener(this);
    this.h = ((AECompoundButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131378779));
    this.h.setOnClickListener(this);
    this.h.setSelected(false);
    this.c.setOnClickListener(this);
    this.c.setSelected(this.jdField_a_of_type_Boolean);
    b();
    a();
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel != null) && (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b() != null))
    {
      AEQLog.a("AEVideoStoryTopBarPart", "【抠背开关】-> onResume -> post:" + c());
      this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().postValue(Boolean.valueOf(c()));
    }
    if (this.c != null) {
      this.c.setSelected(this.jdField_a_of_type_Boolean);
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    boolean bool3 = true;
    boolean bool4 = AECameraEntry.k(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a().getIntent());
    switch (paramView.getId())
    {
    default: 
    case 2131363542: 
    case 2131364188: 
    case 2131365402: 
    case 2131378779: 
    case 2131364362: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        AEBaseDataReporter.a().L();
        PressScaleAnimDelegate.a(this.e.a(), 200L, null);
        VSReporter.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
        if (this.mPartManager != null) {
          if (this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.a())
          {
            this.mPartManager.a(327686, new Object[0]);
          }
          else if (!this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.b())
          {
            Object localObject;
            if (bool4)
            {
              if (!AEFastClickThrottle.a(paramView))
              {
                localObject = new Intent();
                ((Intent)localObject).setAction("ae_editor_bottom_tab_show_hide");
                ((Intent)localObject).putExtra("is_show", false);
                this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a().sendBroadcast((Intent)localObject);
                AEReportUtils.b(10, null);
              }
            }
            else
            {
              this.mPartManager.a(131077, new Object[0]);
              continue;
              if (this.mPartManager != null) {
                if (bool4)
                {
                  if (!AEFastClickThrottle.a(paramView))
                  {
                    localObject = new Intent();
                    ((Intent)localObject).setAction("ae_editor_bottom_tab_show_hide");
                    ((Intent)localObject).putExtra("is_show", false);
                    this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a().sendBroadcast((Intent)localObject);
                    AEReportUtils.b(7, null);
                  }
                }
                else
                {
                  AEBaseDataReporter.a().ap();
                  this.mPartManager.a(131078, new Object[0]);
                  continue;
                  PressScaleAnimDelegate.a(this.g.a(), 200L, null);
                  localObject = (AEVideoStoryTopBarViewModel.CountDownSetting)this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a().getValue();
                  int i;
                  if ((localObject != null) && (((AEVideoStoryTopBarViewModel.CountDownSetting)localObject).a()))
                  {
                    i = 1;
                    label378:
                    localObject = this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a();
                    if (i != 0) {
                      break label446;
                    }
                    bool1 = true;
                    label393:
                    ((MutableLiveData)localObject).postValue(new AEVideoStoryTopBarViewModel.CountDownSetting(bool1, this.jdField_a_of_type_Int));
                    if (!this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel.a()) {
                      continue;
                    }
                    localObject = AEBaseReportParam.a();
                    if (i != 0) {
                      break label451;
                    }
                  }
                  label446:
                  label451:
                  for (bool1 = bool3;; bool1 = false)
                  {
                    ((AEBaseReportParam)localObject).g(bool1);
                    break;
                    i = 0;
                    break label378;
                    bool1 = false;
                    break label393;
                  }
                  PressScaleAnimDelegate.a(this.h.a(), 200L, null);
                  bool3 = c();
                  localObject = new StringBuilder().append("【抠背开关】-> 点击 ->post:");
                  if (!bool3)
                  {
                    bool1 = true;
                    label498:
                    AEQLog.a("AEVideoStoryTopBarPart", bool1);
                    localObject = this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b();
                    if (bool3) {
                      break label580;
                    }
                    bool1 = true;
                    label528:
                    ((MutableLiveData)localObject).postValue(Boolean.valueOf(bool1));
                    if (!this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel.a()) {
                      continue;
                    }
                    localObject = AEBaseReportParam.a();
                    if (bool3) {
                      break label585;
                    }
                  }
                  label580:
                  label585:
                  for (bool1 = bool2;; bool1 = false)
                  {
                    ((AEBaseReportParam)localObject).f(bool1);
                    AEBaseDataReporter.a().ai();
                    break;
                    bool1 = false;
                    break label498;
                    bool1 = false;
                    break label528;
                  }
                  PressScaleAnimDelegate.a(paramView, 200L, null);
                  this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.U();
                  if (bool4) {
                    AEReportUtils.b(3, null);
                  }
                }
              }
            }
          }
        }
      }
    }
    PressScaleAnimDelegate.a(this.c.a(), 200L, null);
    if (!this.c.isSelected()) {}
    for (;;)
    {
      if (this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a(bool1))
      {
        this.jdField_a_of_type_Boolean = bool1;
        this.c.setSelected(bool1);
        if (QLog.isDevelopLevel()) {
          AEQLog.a("AEVideoStoryTopBarPart", "onClick, mFlashButton.setSelected(), on=" + bool1);
        }
      }
      AEBaseDataReporter.a().G();
      if (!bool4) {
        break;
      }
      AEReportUtils.b(6, null);
      break;
      bool1 = false;
    }
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while ((this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel == null) || (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b() == null));
    AEQLog.a("AEVideoStoryTopBarPart", "【抠背开关】-> 相机启动检查 -> post:" + c());
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().postValue(Boolean.valueOf(c()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarPart
 * JD-Core Version:    0.7.0.1
 */