package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.common.app.AppInterface;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeGifImage;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.util.LiuHaiUtils;
import com.tribe.async.async.JobSegment;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.capture.CaptureContext;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.paster.PasterDataManager;
import dov.com.qq.im.capture.util.DoodleLayoutConnector;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.POIPostersRequestCallback;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.DoodleBtnOperationHelper;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.DoodleEventListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateDoodleImageSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import dov.com.tencent.biz.qqstory.takevideo.publish.HWEncodeGenerateDoodleImageSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.Publishable;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfoLoadObserver;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EditVideoDoodle
  extends EditVideoPart
  implements IEventReceiver, EditDoodleExport, DoodleLayout.DoodleBtnOperationHelper, DoodleLayout.DoodleEventListener, Publishable
{
  public static final String a;
  public static String b;
  public int a;
  private long jdField_a_of_type_Long = 0L;
  protected Handler a;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new EditVideoDoodle.4(this);
  public ProviderViewEditContainer a;
  EditVideoDoodle.DoodleEmojiDownloadEventReceiver jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle$DoodleEmojiDownloadEventReceiver;
  EditVideoDoodle.DoodleEmojiListEventReceiver jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle$DoodleEmojiListEventReceiver;
  EditVideoDoodle.DoodleEmojiPoiPostersReceiver jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle$DoodleEmojiPoiPostersReceiver;
  DoodleEmojiManager.POIPostersRequestCallback jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiManager$POIPostersRequestCallback = new EditVideoDoodle.6(this);
  protected DoodleLayout a;
  PtvTemplateManager.DoodleInfoLoadObserver jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfoLoadObserver = new EditVideoDoodle.11(this);
  protected Runnable a;
  protected boolean a;
  protected byte[] a;
  private final int b;
  public boolean b;
  protected boolean c = false;
  private boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = QQStoryConstant.e;
    jdField_b_of_type_JavaLangString = "EditVideoDoodle";
  }
  
  public EditVideoDoodle(@NonNull EditVideoPartManager paramEditVideoPartManager, int paramInt)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = new EditVideoDoodle.5(this);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        c();
      } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getVisibility() == paramInt);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setVisibility(paramInt);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleGLViewVisibility(paramInt);
      return;
    } while ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getVisibility() == paramInt));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setVisibility(paramInt);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleGLViewVisibility(paramInt);
  }
  
  private void a(String paramString)
  {
    paramString = new File(paramString);
    boolean bool;
    if (paramString.isFile())
    {
      bool = paramString.delete();
      SLog.d("Q.qqstory.publish.edit.StoryDoodle", "delete file : " + bool);
    }
    if (!paramString.exists())
    {
      bool = paramString.mkdirs();
      SLog.d("Q.qqstory.publish.edit.StoryDoodle", "create folder : " + bool);
    }
  }
  
  private void d()
  {
    int k;
    int j;
    int i;
    float f;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a() != null) && (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a().isLandTakePicToVideo()) && ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)))
    {
      k = ((EditLocalVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
      j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
      i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b();
      if ((k == 90) || (k == 270))
      {
        j = Math.min(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b());
        i = Math.max(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b());
      }
      f = j / i;
      if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a().getTakePicToVideo()) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
      }
      j = ScreenUtil.SCREEN_WIDTH;
      i = ScreenUtil.SCREEN_HIGHT;
      if (ScreenUtil.checkDeviceHasNavigationBar(a())) {
        break label328;
      }
      i = ScreenUtil.getRealHeight(a());
    }
    for (;;)
    {
      k = (int)(j / f);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = j;
        localLayoutParams.height = k;
        localLayoutParams.addRule(16);
        localLayoutParams.setMargins(0, i / 2 - (int)(j / f) / 2, 0, 0);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setLayoutParams(localLayoutParams);
      }
      return;
      label328:
      i = ScreenUtil.SCREEN_HIGHT;
      if (Build.MODEL.equals("Lenovo L78011")) {
        i -= LiuHaiUtils.a(a());
      }
    }
  }
  
  public int a()
  {
    return 16;
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return 0;
    }
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramInt);
  }
  
  public Bitmap a()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return null;
    }
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
  }
  
  public Bitmap a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return null;
    }
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramInt, paramBoolean);
  }
  
  public JobSegment<GenerateContext, GenerateContext> a(int paramInt)
  {
    if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))) {
      return (JobSegment)StoryApi.a(HWEncodeGenerateDoodleImageSegment.class, new Object[] { this, (EditFilterExport)a(EditFilterExport.class), Integer.valueOf(paramInt) });
    }
    return (JobSegment)StoryApi.a(GenerateDoodleImageSegment.class, new Object[] { this, (EditFilterExport)a(EditFilterExport.class), Integer.valueOf(paramInt) });
  }
  
  @NonNull
  public DoodleLayout a()
  {
    c();
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
  }
  
  public void a()
  {
    a(jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131365967));
    QQStoryContext.a();
    AppInterface localAppInterface = QQStoryContext.a();
    PtvTemplateManager.a(localAppInterface).a(localAppInterface, this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfoLoadObserver);
    ThreadManager.excute(new EditVideoDoodle.3(this), 64, null, true);
    a(EditDoodleExport.class, this);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(false, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    a().a(HardCodeUtil.a(2131703803), true, 0L, new EditVideoDoodle.9(this));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    long l;
    do
    {
      return;
      l = SystemClock.elapsedRealtime();
    } while (l - this.jdField_a_of_type_Long <= 4000L);
    this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoDoodle.10(this));
    this.jdField_a_of_type_Long = l;
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    this.jdField_d_of_type_Boolean = false;
    switch (paramInt2)
    {
    case 5: 
    case 6: 
    case 9: 
    case 10: 
    case 11: 
    case 15: 
    case 16: 
    case 19: 
    case 20: 
    default: 
      a(0);
    }
    do
    {
      do
      {
        return;
        a(0);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.l();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(true);
        return;
        a(0);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.l();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b(false);
        return;
      } while ((paramInt1 == 6) || (paramInt1 == paramInt2));
      c();
      a(0);
      return;
      a(8);
      return;
      if (paramInt1 != 6)
      {
        c();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.f();
        a(0);
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(true);
      return;
    } while (paramInt1 == 5);
    c();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.k();
    a(0);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a().a(paramInt1, paramInt2, paramBoolean);
    if ((!paramBoolean) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle != null))
    {
      Bundle localBundle = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle(FaceLayer.jdField_a_of_type_JavaLangString);
      if (localBundle != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(localBundle);
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle("DynamicFaceLayer"));
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a() != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle(TextLayer.jdField_a_of_type_JavaLangString));
      }
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null)
    {
      SLog.d("Q.qqstory.publish.edit.StoryDoodle", "editVideoPrePublish but doodle layout is null");
      return;
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.d();
    }
    paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDoodleDescription = a().a(paramInt);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a().setWordId(a().b());
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a().setStickerId(a().c());
    AEBaseReportParam.a().f(a().e());
    AEBaseReportParam.a().g(a().d());
    paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("all_doodle_text", a().a());
    paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mMosaicMask = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramInt);
    paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mMosaicSize = 16;
    if (a().b(paramInt).size() > 0)
    {
      localObject1 = (PasterDataManager)QIMManager.a(4);
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLocationDescription = ((PasterDataManager)localObject1).a();
    }
    int i;
    label342:
    Object localObject3;
    int j;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d())
    {
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLongitude = ((EditLocalVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.longitude;
        paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLatitude = ((EditLocalVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.latitude;
      }
    }
    else
    {
      if (a().b(paramInt)) {
        VideoEditReport.a("0X80076C0");
      }
      if (a().a(paramInt)) {
        VideoEditReport.a("0X80076C4");
      }
      if ((!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) && (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))) {
        break label841;
      }
      i = 1;
      localObject2 = a().a(paramInt);
      if ((localObject2 != null) && (localObject2.length == 2))
      {
        if (localObject2[0] <= 0) {
          break label854;
        }
        localObject3 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
        j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b();
        if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
          break label846;
        }
        localObject1 = "2";
        label401:
        ((EditVideoPartManager)localObject3).a("pub_graffiti", j, 0, new String[] { "1", "", localObject1 });
        VideoEditReport.a("0X80076E0", VideoEditReport.jdField_b_of_type_Int);
        VideoEditReport.b("0X80075EA", VideoEditReport.jdField_a_of_type_Int);
        paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("1");
        paramGenerateContext.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.hasGraffiti = true;
        AEBaseReportParam.a().c(true);
        label480:
        if (localObject2[1] <= 0) {
          break label885;
        }
        localObject3 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
        j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b();
        if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
          break label877;
        }
        localObject1 = "2";
        label517:
        ((EditVideoPartManager)localObject3).a("pub_mosaics", j, 0, new String[] { "1", "", localObject1 });
        VideoEditReport.a("0X80076E1");
        VideoEditReport.b("0X80075EB");
        paramGenerateContext.jdField_b_of_type_Boolean = true;
        if (localObject2[0] == 0) {
          paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("1");
        }
      }
    }
    Object localObject5;
    Object localObject6;
    for (;;)
    {
      localObject2 = a().b(paramInt);
      if ((localObject2 == null) || (localObject2.length != 2)) {
        break label1258;
      }
      localObject4 = a().a(paramInt);
      localObject1 = a().b(paramInt);
      localObject3 = new StringBuilder();
      localObject4 = ((Map)localObject4).entrySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (Map.Entry)((Iterator)localObject4).next();
        localObject6 = (List)((Map.Entry)localObject5).getValue();
        if ((localObject6 != null) && (((List)localObject6).size() > 0))
        {
          localObject5 = (String)((Map.Entry)localObject5).getKey();
          localObject6 = ((List)localObject6).iterator();
          while (((Iterator)localObject6).hasNext())
          {
            String str = (String)((Iterator)localObject6).next();
            ((StringBuilder)localObject3).append((String)localObject5).append(':').append(str).append(',');
          }
        }
      }
      if (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)) {
        break;
      }
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLongitude = ((EditLocalPhotoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.longitude;
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLatitude = ((EditLocalPhotoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.latitude;
      break;
      label841:
      i = 0;
      break label342;
      label846:
      localObject1 = "1";
      break label401;
      label854:
      if ((i == 0) || (!GeneratePicArgs.a(0))) {
        break label480;
      }
      VideoEditReport.b("0X80075EA", VideoEditReport.jdField_a_of_type_Int);
      break label480;
      label877:
      localObject1 = "1";
      break label517;
      label885:
      if ((i != 0) && (GeneratePicArgs.a(1))) {
        VideoEditReport.b("0X80075EB");
      }
    }
    if (((StringBuilder)localObject3).length() > 0) {
      ((StringBuilder)localObject3).deleteCharAt(((StringBuilder)localObject3).length() - 1);
    }
    SLog.a("Q.qqstory.publish.edit.StoryDoodle", "faceReportString = %s", localObject3);
    Object localObject4 = new StringBuilder();
    if (((List)localObject1).size() > 0)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((StringBuilder)localObject4).append(((FaceLayer.FaceItem)((Iterator)localObject1).next()).e).append(',');
      }
      ((StringBuilder)localObject4).deleteCharAt(((StringBuilder)localObject4).length() - 1);
    }
    SLog.a("Q.qqstory.publish.edit.StoryDoodle", "poiReportString = %s", localObject4);
    if (localObject2[0] > 0)
    {
      localObject5 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
      j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b();
      int k = localObject2[0];
      localObject6 = ((StringBuilder)localObject3).toString();
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a())
      {
        localObject1 = "2";
        ((EditVideoPartManager)localObject5).a("pub_face", j, 0, new String[] { String.valueOf(k), localObject6, localObject1 });
        VideoEditReport.a("0X80076E3", VideoEditReport.jdField_b_of_type_Int);
        VideoEditReport.b("0X80075ED", VideoEditReport.jdField_a_of_type_Int);
        paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("4");
        paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = ((StringBuilder)localObject3).toString();
        label1151:
        if (localObject2[1] <= 0) {
          break label1564;
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a("pub_poi", this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b(), 0, new String[] { String.valueOf(localObject2[1]), ((StringBuilder)localObject4).toString() });
        VideoEditReport.a("0X80076E4");
        VideoEditReport.b("0X80075EE");
        if (localObject2[0] <= 0) {
          break label1535;
        }
        paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = (paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 + "," + ((StringBuilder)localObject4).toString());
        label1258:
        localObject2 = a().a(paramInt);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label1584;
        }
        j = 1;
        label1279:
        if (j == 0) {
          break label1598;
        }
        localObject3 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
        i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b();
        if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
          break label1590;
        }
        localObject1 = "2";
        label1313:
        ((EditVideoPartManager)localObject3).a("pub_text", i, 0, new String[] { "1", localObject2, localObject1 });
        VideoEditReport.a("0X80076E2", VideoEditReport.jdField_b_of_type_Int);
        VideoEditReport.b("0X80075EC", VideoEditReport.jdField_a_of_type_Int);
        paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("3");
        paramGenerateContext.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.hasText = true;
      }
    }
    for (;;)
    {
      localObject3 = a().a(paramInt);
      if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
        break label1648;
      }
      localObject1 = "";
      paramInt = 0;
      while (paramInt < ((List)localObject3).size())
      {
        localObject2 = (String)localObject1 + (String)((List)localObject3).get(paramInt);
        localObject1 = localObject2;
        if (paramInt != ((List)localObject3).size() - 1) {
          localObject1 = (String)localObject2 + ",";
        }
        paramInt += 1;
      }
      localObject1 = "1";
      break;
      if ((i == 0) || (!GeneratePicArgs.a(2))) {
        break label1151;
      }
      VideoEditReport.b("0X80075ED", VideoEditReport.jdField_a_of_type_Int);
      break label1151;
      label1535:
      paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("4");
      paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = ((StringBuilder)localObject4).toString();
      break label1258;
      label1564:
      if ((i == 0) || (!GeneratePicArgs.a(3))) {
        break label1258;
      }
      VideoEditReport.b("0X80075EE");
      break label1258;
      label1584:
      j = 0;
      break label1279;
      label1590:
      localObject1 = "1";
      break label1313;
      label1598:
      if ((i != 0) && (GeneratePicArgs.a(4))) {
        VideoEditReport.b("0X80075EC", VideoEditReport.jdField_a_of_type_Int);
      }
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a("person_gra", this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b(), 0, new String[] { localObject1 });
    label1648:
    Object localObject2 = CaptureContext.a().getCurrentAccountUin();
    if (InfomationFacePackage.jdField_b_of_type_Boolean) {}
    for (Object localObject1 = paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLocationDescription;; localObject1 = "")
    {
      ShortVideoUtils.setRecentPOI((String)localObject2, (String)localObject1);
      if (((a().a() == null) || (a().a().jdField_a_of_type_JavaUtilList == null) || (a().a().jdField_a_of_type_JavaUtilList.size() <= 0)) && ((a().a() == null) || (a().a().jdField_a_of_type_JavaUtilList == null) || (a().a().jdField_a_of_type_JavaUtilList.size() <= 0))) {
        break;
      }
      paramGenerateContext.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.hasFace = true;
      return;
    }
  }
  
  public void a(long paramLong)
  {
    a().setFaceLayerPosition(paramLong);
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramBitmap);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    EditVideoPlayerExport localEditVideoPlayerExport = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
    if (localEditVideoPlayerExport != null) {
      localEditVideoPlayerExport.a(paramBitmap, paramBoolean);
    }
  }
  
  public void a(Animation paramAnimation)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramAnimation);
  }
  
  public void a(LocationFacePackage.Item paramItem)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {}
    for (paramItem = "2";; paramItem = "1")
    {
      StoryReportor.a("video_edit", "add_place", 0, 0, new String[] { paramItem, "", "0", "" });
      return;
    }
  }
  
  public void a(Map<Long, TrackerStickerParam.MotionInfo> paramMap)
  {
    a().a(paramMap);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())
    {
      this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      VideoSourceHelper.nativeSetMosaic(16, this.jdField_a_of_type_ArrayOfByte);
      EditVideoPlayerExport localEditVideoPlayerExport = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
      if (localEditVideoPlayerExport != null) {
        localEditVideoPlayerExport.a(16, paramArrayOfByte);
      }
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) && (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a())) {
      return true;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.d()))
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(7, null);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(false);
      return true;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getVisibility() == 0)) {}
    switch (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c())
    {
    case 4: 
    case 5: 
    default: 
      return false;
    case 1: 
    case 2: 
    case 3: 
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      return true;
    case 0: 
      return false;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.o();
    return true;
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c(paramInt));
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 12: 
    default: 
      return super.a(paramMessage);
    case 11: 
      this.jdField_d_of_type_Long = ((Long)paramMessage.obj).longValue();
      return true;
    }
    paramMessage = (Long[])paramMessage.obj;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTimeStamp(paramMessage[0].longValue(), false);
    }
    return true;
  }
  
  public byte[] a(int paramInt)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramInt);
    }
    return null;
  }
  
  public void aM_()
  {
    super.aM_();
    NativeGifImage.pauseAll();
    ApngImage.pauseByTag(13);
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return 0;
    }
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b();
  }
  
  public Bitmap b()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a();
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean) {
      a().d();
    }
  }
  
  public void b(int paramInt, Object paramObject)
  {
    SLog.b("Q.qqstory.publish.edit.StoryDoodle", "onStateChanged : " + paramInt);
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.c)) {
      return;
    }
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 0: 
    case 7: 
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      return;
    case 2: 
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(4, paramObject);
      return;
    case 3: 
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(2, paramObject);
      return;
    case 4: 
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(6);
      return;
    case 5: 
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(5, paramObject);
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(5);
  }
  
  public void b(Animation paramAnimation)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b(paramAnimation);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a();
  }
  
  public void c()
  {
    Object localObject1;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null)
    {
      SLog.b("Q.qqstory.publish.edit.StoryDoodle", "makeSureInitLayout");
      localObject1 = this.jdField_a_of_type_AndroidViewViewStub.getParent();
      if ((localObject1 == null) || (!(localObject1 instanceof ViewGroup))) {
        break label635;
      }
    }
    label635:
    for (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());; this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)a(2131365966)))
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.f == AECameraEntry.c.a()) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_b_of_type_Boolean = true;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      if (!EditVideoPartManager.a(this.jdField_b_of_type_Int, 1)) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.n();
      }
      this.jdField_b_of_type_Boolean = true;
      d();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setupPersonality();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(720, 1280);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setMosaicSize(16);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setMosaicStandardSize(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b());
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleEventListener(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBtnOperationHelper(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditVideoParams(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditVideoDoodle(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.s();
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle != null)
      {
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle(FaceLayer.jdField_a_of_type_JavaLangString) != null) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle(FaceLayer.jdField_a_of_type_JavaLangString).putBoolean("edit_type_photo", this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a());
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle(FaceLayer.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle("DynamicFaceLayer"));
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a() != null)
        {
          if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle(TextLayer.jdField_a_of_type_JavaLangString) != null) {
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle(TextLayer.jdField_a_of_type_JavaLangString).putBoolean("edit_type_photo", this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a());
          }
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle(TextLayer.jdField_a_of_type_JavaLangString));
        }
      }
      DoodleLayoutConnector.a().a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.g(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout);
      localObject1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView;
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer == null)
      {
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer;
        if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
          this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setLiuHaiParentView(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout);
        }
        if ((localObject1 != null) && (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null))
        {
          if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) {
            int i = ((EditLocalVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Int;
          }
          this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setStickerListener(((DoodleEditView)localObject1).a());
          ((DoodleEditView)localObject1).setDoodleEditViewListener(new EditVideoDoodle.1(this));
        }
        a(2131366146).setOnTouchListener(new EditVideoDoodle.2(this));
      }
      localObject1 = StoryDispatcher.a();
      Object localObject2 = new EditVideoDoodle.DoodleEmojiListEventReceiver(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle$DoodleEmojiListEventReceiver = ((EditVideoDoodle.DoodleEmojiListEventReceiver)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      localObject1 = StoryDispatcher.a();
      localObject2 = new EditVideoDoodle.DoodleEmojiDownloadEventReceiver(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle$DoodleEmojiDownloadEventReceiver = ((EditVideoDoodle.DoodleEmojiDownloadEventReceiver)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      localObject1 = StoryDispatcher.a();
      localObject2 = new EditVideoDoodle.DoodleEmojiPoiPostersReceiver(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle$DoodleEmojiPoiPostersReceiver = ((EditVideoDoodle.DoodleEmojiPoiPostersReceiver)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      return;
    }
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())
    {
      NativeGifImage.resumeAll();
      ApngImage.playByTag(13);
      return;
    }
    NativeGifImage.pauseAll();
    ApngImage.pauseByTag(13);
  }
  
  public void g()
  {
    this.c = true;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle$DoodleEmojiListEventReceiver != null) {
      StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle$DoodleEmojiListEventReceiver);
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle$DoodleEmojiDownloadEventReceiver != null) {
      StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle$DoodleEmojiDownloadEventReceiver);
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle$DoodleEmojiPoiPostersReceiver != null) {
      StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle$DoodleEmojiPoiPostersReceiver);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    DoodleLayoutConnector.a().a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.g());
  }
  
  public void m()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
  }
  
  public void n()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.e();
  }
  
  public void o()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a().postDelayed(new EditVideoDoodle.7(this), 200L);
  }
  
  public void p()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(true, 0.0F, 0.0F, 0.0F, 0.0F);
  }
  
  public void q()
  {
    a().b();
  }
  
  public boolean q_()
  {
    if (System.currentTimeMillis() < this.jdField_d_of_type_Long) {}
    while ((!EditVideoPartManager.a(this.jdField_b_of_type_Int, 1)) || (!TextUtils.isEmpty(a().a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a())))) {
      return false;
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_Int == 12) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    }
    return true;
  }
  
  public boolean r_()
  {
    return (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle
 * JD-Core Version:    0.7.0.1
 */