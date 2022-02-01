package dov.com.qq.im.ae.biz.qcircle;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tavcut.bean.Size;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.QIMCameraLifeCycleBaseUnit;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.biz.qcircle.event.AECircleChangeBottomTabVisibleEvent;
import dov.com.qq.im.ae.biz.qcircle.event.AECircleClearAllSelectEvent;
import dov.com.qq.im.ae.biz.qcircle.event.AECircleJumpCameraPageEvent;
import dov.com.qq.im.ae.config.CameraOperationHelper;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.perf.AELaunchRecorder;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.view.AETouchNotifyRelativeLayout;
import dov.com.qq.im.ae.view.NoScrollViewPager;
import dov.com.qq.im.ae.view.TabLayout;
import dov.com.qq.im.aeeditor.util.AEEditorJumpUtil;
import dov.com.qq.im.aeeditor.util.AELocalMediaInfoUtil;
import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.qq.im.setting.IQIMCameraContainer;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public class AECircleMultiUnit
  extends QIMCameraLifeCycleBaseUnit
  implements SimpleEventReceiver
{
  private AEPituCameraUnit jdField_a_of_type_DovComQqImAeAEPituCameraUnit;
  private AECircleMultiUnit.AEEditorUIBroadCast jdField_a_of_type_DovComQqImAeBizQcircleAECircleMultiUnit$AEEditorUIBroadCast;
  private AECircleMultiUnit.PhotoCameraViewPagerAdapter jdField_a_of_type_DovComQqImAeBizQcircleAECircleMultiUnit$PhotoCameraViewPagerAdapter;
  private AECirclePhotoUnit jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoUnit;
  private AETouchNotifyRelativeLayout jdField_a_of_type_DovComQqImAeViewAETouchNotifyRelativeLayout;
  private NoScrollViewPager jdField_a_of_type_DovComQqImAeViewNoScrollViewPager;
  private TabLayout jdField_a_of_type_DovComQqImAeViewTabLayout;
  private ICameraEntrance jdField_a_of_type_DovComQqImSettingICameraEntrance;
  private IQIMCameraContainer jdField_a_of_type_DovComQqImSettingIQIMCameraContainer;
  private List<AECircleMultiUnit.PageData> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public AECircleMultiUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer = paramIQIMCameraContainer;
    this.jdField_a_of_type_DovComQqImSettingICameraEntrance = paramICameraEntrance;
    a();
    e();
  }
  
  private Activity a()
  {
    if (this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer == null) {
      return null;
    }
    return this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a();
  }
  
  private QIMCameraLifeCycleBaseUnit a()
  {
    int i = this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.getCurrentItem();
    return AECircleMultiUnit.PageData.a((AECircleMultiUnit.PageData)this.jdField_a_of_type_JavaUtilList.get(i));
  }
  
  private void a()
  {
    if (a() == null) {
      return;
    }
    int i = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
    String str = a().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
    if (AECameraEntry.a(i).a()) {
      AEBaseReportParam.a().a(i, str);
    }
    str = a().getIntent().getStringExtra("intent_key_uid_for_report");
    AEBaseReportParam.a().a(str);
    AEBaseReportParam.a().a(true);
    AEBaseReportParam.a().b();
    AEBaseReportParam.a().a();
    AEBaseReportParam.a().b(CameraOperationHelper.a(a()));
  }
  
  public static void a(Activity paramActivity, int paramInt, boolean paramBoolean)
  {
    if (paramActivity == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      Window localWindow = paramActivity.getWindow();
      localWindow.clearFlags(67108864);
      localWindow.getDecorView().setSystemUiVisibility(1280);
      localWindow.addFlags(-2147483648);
      localWindow.setStatusBarColor(paramInt);
    }
    for (;;)
    {
      ImmersiveUtils.setStatusTextColor(paramBoolean, paramActivity.getWindow());
      return;
      if (Build.VERSION.SDK_INT >= 19) {
        paramActivity.getWindow().addFlags(67108864);
      }
    }
  }
  
  public static void a(boolean paramBoolean, Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("ae_editor_bottom_tab_show_hide");
    localIntent.putExtra("is_show", paramBoolean);
    paramActivity.sendBroadcast(localIntent);
  }
  
  private boolean a()
  {
    Activity localActivity = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a();
    if (Build.VERSION.SDK_INT < 23) {}
    int i;
    int j;
    do
    {
      return true;
      i = localActivity.checkSelfPermission("android.permission.CAMERA");
      j = localActivity.checkSelfPermission("android.permission.RECORD_AUDIO");
    } while ((i == 0) && (j == 0));
    return false;
  }
  
  private boolean a(QIMCameraLifeCycleBaseUnit paramQIMCameraLifeCycleBaseUnit)
  {
    boolean bool = true;
    if ((a() != null) && (AECameraEntry.n(a().getIntent()))) {
      bool = false;
    }
    do
    {
      return bool;
      if (paramQIMCameraLifeCycleBaseUnit == this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoUnit) {
        return this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoUnit.a();
      }
    } while (paramQIMCameraLifeCycleBaseUnit != this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit);
    return true;
  }
  
  private void e()
  {
    String str = a().getIntent().getStringExtra("qcircle_client_traceid");
    if (!TextUtils.isEmpty(str)) {
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportPublishQuality(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).E_PICKER_ENTER(), Arrays.asList(new FeedCloudCommon.Entry[] { ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).TRACEID(), str), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT2(), "nolongvideomode"), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).KEY_RET_CODE(), "0") }));
    }
  }
  
  private void f()
  {
    boolean bool = true;
    ArrayList localArrayList = new ArrayList();
    Object localObject = a().getIntent().getStringExtra("tab");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals("camera"))) {}
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (i == 0)
      {
        j = i;
        if (AECameraPrefsUtil.a().a("circle_entry_type_camera", false, 4)) {
          j = 1;
        }
      }
      localObject = AECameraPrefsUtil.a();
      if (j != 1)
      {
        ((AECameraPrefsUtil)localObject).a("sp_key_ae_photo_switch_ratio_tips_should_auto_disappear", bool, 0);
        AEQLog.b("AECircleMultiUnit", "[initBottomTab] choose tab index=" + j);
        localArrayList.add(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getResources().getString(2131694850));
        localArrayList.add(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getResources().getString(2131689678));
        this.jdField_a_of_type_DovComQqImAeViewTabLayout.a(this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager);
        this.jdField_a_of_type_DovComQqImAeViewTabLayout.setTabSelectedCallback(new AECircleMultiUnit.1(this));
        if (a()) {
          break label241;
        }
        if (j != 0) {
          m();
        }
        this.jdField_a_of_type_DovComQqImAeViewTabLayout.setTabs(localArrayList, 0);
      }
      for (;;)
      {
        a(a(a()), a());
        return;
        bool = false;
        break;
        label241:
        this.jdField_a_of_type_DovComQqImAeViewTabLayout.setTabs(localArrayList, j);
      }
    }
  }
  
  private void g()
  {
    if (a())
    {
      l();
      AEBaseDataReporter.a().ad();
      SimpleEventBus.getInstance().dispatchEvent(new AECircleClearAllSelectEvent());
      return;
    }
    m();
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_DovComQqImAeViewAETouchNotifyRelativeLayout == null) {
      return;
    }
    this.jdField_a_of_type_DovComQqImAeViewAETouchNotifyRelativeLayout.setIaeTouchNotify(new AECircleMultiUnit.2(this));
  }
  
  private void l()
  {
    AELaunchRecorder.a().b();
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.setCurrentItem(1, true);
    this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.j();
    this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.d();
  }
  
  private void m()
  {
    if (Build.VERSION.SDK_INT < 23) {
      break label8;
    }
    label8:
    while (!(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a() instanceof QIMCameraCaptureActivity)) {
      return;
    }
    QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a();
    int i;
    if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      label48:
      if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label132;
      }
    }
    label132:
    for (int j = 1;; j = 0)
    {
      LinkedList localLinkedList = new LinkedList();
      if (i != 0) {
        localLinkedList.add("android.permission.CAMERA");
      }
      if (j != 0) {
        localLinkedList.add("android.permission.RECORD_AUDIO");
      }
      if (localLinkedList.size() <= 0) {
        break;
      }
      localQIMCameraCaptureActivity.requestPermissions(this, 1, (String[])localLinkedList.toArray(new String[0]));
      return;
      i = 0;
      break label48;
    }
  }
  
  private void n()
  {
    Intent localIntent = new Intent();
    AEQLog.b("AECircleMultiUnit", "[sendMobileQQPeakCreate]");
    localIntent.setAction("peak_oncreate");
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public View a()
  {
    View localView = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getLayoutInflater().inflate(2131558524, null);
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager = ((NoScrollViewPager)localView.findViewById(2131381588));
    this.jdField_a_of_type_DovComQqImAeViewTabLayout = ((TabLayout)localView.findViewById(2131378818));
    this.jdField_a_of_type_DovComQqImAeViewAETouchNotifyRelativeLayout = ((AETouchNotifyRelativeLayout)localView.findViewById(2131367255));
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECircleMultiUnit$AEEditorUIBroadCast.a(this.jdField_a_of_type_DovComQqImAeViewTabLayout);
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECircleMultiUnit$PhotoCameraViewPagerAdapter = new AECircleMultiUnit.PhotoCameraViewPagerAdapter(null);
    this.jdField_a_of_type_JavaUtilList.add(new AECircleMultiUnit.PageData(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoUnit, this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoUnit.a()));
    this.jdField_a_of_type_JavaUtilList.add(new AECircleMultiUnit.PageData(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a()));
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECircleMultiUnit$PhotoCameraViewPagerAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.setAdapter(this.jdField_a_of_type_DovComQqImAeBizQcircleAECircleMultiUnit$PhotoCameraViewPagerAdapter);
    f();
    h();
    return localView;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    a().a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AEQLog.b("AECircleMultiUnit", "on activity result.");
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 203) {
      a().a(paramInt1, paramInt2, paramIntent);
    }
    if ((paramInt2 != -1) || (a() == null) || (paramIntent == null)) {}
    for (;;)
    {
      return;
      String str1;
      String str2;
      ArrayList localArrayList;
      if (paramIntent.getBooleanExtra("h5_key_flag", false))
      {
        str1 = paramIntent.getStringExtra("h5_key_video_path");
        str2 = paramIntent.getStringExtra("h5_key_thumb_path");
        localArrayList = new ArrayList();
        localArrayList.add(str1);
        HashMap localHashMap = new HashMap();
        localHashMap.put(str1, AELocalMediaInfoUtil.a(AELocalMediaInfoUtil.a(str1, str2), paramIntent.getStringExtra("widgetinfo"), "", null, 1, null));
        AEEditorJumpUtil.a(a(), localArrayList, localHashMap, AECameraEntry.a(a().getIntent()));
      }
      while (paramInt1 != 203)
      {
        this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().finish();
        return;
        if (paramIntent.getBooleanExtra("ae_editor_video_flag", false))
        {
          str1 = paramIntent.getStringExtra("ae_editor_video_path");
          str2 = paramIntent.getStringExtra("ae_editor_video_thumb_path");
          paramInt2 = paramIntent.getIntExtra("ae_editor_video_export_size_height", 0);
          int i = paramIntent.getIntExtra("ae_editor_video_export_size_width", 0);
          localArrayList = paramIntent.getStringArrayListExtra("ae_editor_video_text_cache");
          int j = paramIntent.getIntExtra("ae_editor_video_from", AECameraEntry.a.a());
          paramIntent = (LocalMediaInfo)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
          AEEditorJumpUtil.a(a(), str1, str2, new Size(i, paramInt2), localArrayList, paramIntent, j);
        }
        else
        {
          AEEditorJumpUtil.a(a(), paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"), (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap"), a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a()));
        }
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit = new AEPituCameraUnit(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer, this.jdField_a_of_type_DovComQqImSettingICameraEntrance);
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoUnit = new AECirclePhotoUnit(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer, this.jdField_a_of_type_DovComQqImSettingICameraEntrance);
    this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a(paramBundle);
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoUnit.a(paramBundle);
    LiuHaiUtils.b(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a());
    a(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getResources().getColor(2131167305), true);
    paramBundle = new IntentFilter();
    paramBundle.addAction("ae_editor_bottom_tab_show_hide");
    paramBundle.addAction("ae_editor_bottom_tab_change_style");
    Activity localActivity = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a();
    AECircleMultiUnit.AEEditorUIBroadCast localAEEditorUIBroadCast = new AECircleMultiUnit.AEEditorUIBroadCast(null);
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECircleMultiUnit$AEEditorUIBroadCast = localAEEditorUIBroadCast;
    localActivity.registerReceiver(localAEEditorUIBroadCast, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    if (paramInt == 4) {
      b();
    }
    return super.a(paramInt, paramKeyEvent, paramBoolean);
  }
  
  public void b()
  {
    super.b();
    a().b();
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    a().b(paramBundle);
  }
  
  public boolean b()
  {
    a().b();
    return super.b();
  }
  
  public void c()
  {
    super.c();
    AEQLog.b("AECircleMultiUnit", "on destroy");
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().unregisterReceiver(this.jdField_a_of_type_DovComQqImAeBizQcircleAECircleMultiUnit$AEEditorUIBroadCast);
    this.jdField_a_of_type_DovComQqImAeViewAETouchNotifyRelativeLayout.setIaeTouchNotify(null);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        AECircleMultiUnit.PageData localPageData = (AECircleMultiUnit.PageData)localIterator.next();
        if ((localPageData != null) && (AECircleMultiUnit.PageData.a(localPageData) != null)) {
          AECircleMultiUnit.PageData.a(localPageData).c();
        }
      }
    }
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void d()
  {
    super.d();
    a().d();
    if (this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.getCurrentItem() == 0) {
      AEBaseDataReporter.a().ac();
    }
    for (;;)
    {
      n();
      AEQLog.b("AECircleMultiUnit", "onResume.");
      if (this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit != null) {
        this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.M();
      }
      return;
      AEBaseDataReporter.a().ad();
    }
  }
  
  @QQPermissionDenied(1)
  public void denied() {}
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AECircleJumpCameraPageEvent.class);
    localArrayList.add(AECircleChangeBottomTabVisibleEvent.class);
    return localArrayList;
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    l();
  }
  
  public void j()
  {
    super.j();
    a().j();
  }
  
  public void k()
  {
    super.k();
    a().k();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AECircleJumpCameraPageEvent)) {
      g();
    }
    while (!(paramSimpleBaseEvent instanceof AECircleChangeBottomTabVisibleEvent)) {
      return;
    }
    a(a(a()), a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.AECircleMultiUnit
 * JD-Core Version:    0.7.0.1
 */