package dov.com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyEditVideoButton;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoReaderConf;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.mobileqq.shortvideo.util.MediaCodecUtil;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.business.base.AppUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.ActionSheet;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.reactive.Observer;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.StreamFunction;
import com.tribe.async.reactive.UIThreadOffFunction;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.capture.EditState;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter;
import dov.com.qq.im.capture.music.EditVideoQimMusic;
import dov.com.qq.im.editipc.PeakIpcController;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.LineLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleOpController;
import dov.com.tencent.biz.qqstory.takevideo.publish.DoodleRotateSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateDynamicDoodleImageSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import dov.com.tencent.biz.qqstory.takevideo.publish.GeneratePicThumbSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateThumbArgs;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateThumbSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.HWEncodeGenerateThumbSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.HWEncodeMergeThumbSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.MergePicSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.MergeThumbSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishFileManager;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishVideoSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.ResizeBitmapSegment;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelPart;
import dov.com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBitmapImageRender;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class EditVideoPartManager
  implements IEventReceiver
{
  public static GPUBitmapImageRender a;
  private float jdField_a_of_type_Float;
  protected int a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  public Intent a;
  public Bundle a;
  public ViewGroup a;
  public RelativeLayout a;
  private VideoStoryDataBean jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private ProgressPieDrawable jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
  protected EditVideoQimMusic a;
  protected EditCommonParam a;
  protected EditJumpToPtu a;
  protected EditPicCropPart a;
  protected EditPicRawImage a;
  protected EditPicSave a;
  public EditProviderPart a;
  protected EditVideoAblumList a;
  protected EditVideoButton a;
  public EditVideoDoodle a;
  protected EditVideoLimitRegion a;
  public EditVideoParams a;
  protected EditVideoPlayer a;
  protected EditVideoSave a;
  protected EditVideoSpeedFilter a;
  protected EditVideoStoryButton a;
  protected EditVideoTransfer a;
  public EditVideoUi a;
  protected HWEditLocalVideoPlayer a;
  protected SendPanelPart a;
  private String jdField_a_of_type_JavaLangString;
  protected List<EditVideoPart> a;
  protected Map<Class<? extends EditVideoPart.EditExport>, EditVideoPart.EditExport> a;
  protected final AtomicInteger a;
  protected boolean a;
  private float jdField_b_of_type_Float = 3.0F;
  public int b;
  private String jdField_b_of_type_JavaLangString;
  protected List<Error> b;
  protected boolean b;
  private int c;
  protected boolean c;
  public boolean d = true;
  private boolean e;
  
  public EditVideoPartManager()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = Collections.emptyList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void A()
  {
    int i;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 14)
    {
      SLog.c("Q.qqstory.publish.edit.EditVideoPartManager", "reportPublish()  entranceType=" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() + " , isEditCamera:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c());
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() != 120) {
        break label304;
      }
      i = 1;
      if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c()) {
        break label309;
      }
    }
    label304:
    label309:
    for (int j = 1;; j = 2)
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject1.put("lens_id", QIMPtvTemplateAdapter.jdField_b_of_type_JavaLangString);
        localJSONObject1.put("lens_tab", a().getLensTabId());
        localJSONObject1.put("watermark_id", a().getWatermarkId());
        localJSONObject1.put("music_id", a().getSongMid());
        localJSONObject1.put("filter_id", a().getFilterId());
        localJSONObject1.put("sticker_id", a().getStickerId());
        localJSONObject1.put("word_id", a().getWordId());
        if (a().getMusicType() == 1) {
          localJSONObject1.put("music_play_time", a().getMusciPlayTime());
        }
        localJSONObject1.put("video_duration", a().getVideoDuration());
        localJSONObject2.put("music_type", a().getMusicType());
        localJSONObject2.put("filter_type", a().getFilterType());
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      VSReporter.a("mystatus_edit", "post_clk", i, 0, new String[] { String.valueOf(j), "", localJSONObject1.toString(), localJSONObject2.toString() });
      return;
      i = 2;
      break;
    }
  }
  
  private void B()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi == null) {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a().postDelayed(new EditVideoPartManager.6(this), 1000L);
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  private void D()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    Bundle localBundle = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle;
    localSessionInfo.jdField_a_of_type_Int = localBundle.getInt("uintype");
    localSessionInfo.jdField_a_of_type_JavaLangString = localBundle.getString("uin");
    localSessionInfo.jdField_b_of_type_JavaLangString = localBundle.getString("troop_uin");
    localSessionInfo.d = localBundle.getString("uinname");
    PeakIpcController.a(localSessionInfo, "baseView", "{\n  \"data\": {\n    \"puin\": \"892820726\",\n    \"nick\": \"我五岁了哦！\",\n    \"id\": \"xx\",\n    \"avatarJumpUrl\": \"https://h5.qzone.qq.com/v2/wezone/jump?_wv=3&_proxy=1&schema=mqqapi%3A%2F%2Fqcircle%2Fopenmainpage%3Fuin%3D892820726%26issinglefeed%3D1%26from%3D6%26sharecategory%3D2%26shareentrance%3D1\",\n    \"contentJumpUrl\": \"https://h5.qzone.qq.com/v2/wezone/jump?_wv=3&_proxy=1&schema=mqqapi%3A%2F%2Fqcircle%2Fopendetail%3Ffeedid%3DB_193ead5f48eb06008928207260X5c%26sourcetype%3D10%26createtime%3D1605189145%26uin%3D892820726%26shareuin%3D1715054455%26issinglefeed%3D1%26from%3D6%26is_feed_detail%3D1%26sharecategory%3D2%26shareentrance%3D1\",\n    \"iconJumpUrl\": \"https://h5.qzone.qq.com/v2/wezone/jump?_wv=3&_proxy=1&schema=mqqapi%3A%2F%2Fqcircle%2Fopenfolder%3Fissinglefeed%3D1%26from%3D6%26sharecategory%3D2%26shareentrance%3D1\",\n    \"media\": [\n      {\n        \"isVideo\": true,\n        \"videoDuration\": 6153,\n        \"height\": 1080,\n        \"width\": 612,\n        \"url\": \"https://photogz.photo.store.qq.com/psc?/V54acxHN3cWMMd1uSEP42tVDpt3rbFDX/bqQfVz5yrrGYSXMvKr.cqfwp.5mjtGNPmLXd7x240uDFGDWpqsTaAx9IH1rzBk4C2oJi9NLpvQo.nrHoAHTVX6w0vBQPm2u1D8U5owjcQfc!/b&ek=1&kp=1&pt=0&bo=ZAI4BGQCOAQRECc!&tl=1&lsr=6&vuin=1715054455&tm=1607943600#sce=79-11-1&rf=v1_and_sq_8.5.0_0_rdm_b_t_-2-0-31\"\n      }\n    ],\n    \"total\": 1,\n    \"title\": \"分享了来自小世界的作品\",\n    \"type\": 2,\n    \"isAIO\": 1,\n    \"appName\": \"qcircle\",\n    \"fuelNum\": 57393,\n    \"likeNum\": 41463\n  }\n}");
  }
  
  private void E()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null)) {
      throw new IllegalStateException("have not attach ui and params");
    }
  }
  
  private ProgressPieDrawable a()
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a());
    localProgressPieDrawable.a(AIOUtils.a(50.0F, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getResources()));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.g(-1);
    localProgressPieDrawable.f(0);
    localProgressPieDrawable.d(-15550475);
    localProgressPieDrawable.i(3);
    localProgressPieDrawable.jdField_f_of_type_Boolean = true;
    localProgressPieDrawable.jdField_f_of_type_Int = 2;
    localProgressPieDrawable.e(true);
    localProgressPieDrawable.a(new EditVideoPartManager.7(this));
    return localProgressPieDrawable;
  }
  
  @NotNull
  private GenerateContext a(EditVideoParams.EditSource paramEditSource, int paramInt1, int paramInt2, String paramString1, float paramFloat, int paramInt3, String paramString2, boolean paramBoolean, long paramLong, String paramString3, String paramString4, int paramInt4, int paramInt5)
  {
    GenerateContext localGenerateContext = new GenerateContext(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.multiFragmentGroupId = paramString3;
    localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.createTime = (paramInt4 * 1000 + paramLong);
    localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = CodecParam.mMaxrate;
    if (MediaCodecDPC.f())
    {
      localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = (MediaCodecDPC.b() * 1000);
      localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("composite_key_bitrate_mode", Boolean.valueOf(MediaCodecDPC.f()));
    }
    localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMinrate = CodecParam.mMinrate;
    localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoUploadGroupTempDir = paramString4;
    localGenerateContext.jdField_b_of_type_JavaLangString = PublishFileManager.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int);
    paramString3 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
    boolean bool;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.a() == 5))
    {
      bool = true;
      localGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGenerateThumbArgs = new GenerateThumbArgs(paramString3, paramInt1, paramInt2, paramString1, paramFloat, bool, paramInt3, 0.0D, 0.0D, paramString2, paramBoolean);
      if ((!(paramEditSource instanceof EditTakeVideoSource)) && (!(paramEditSource instanceof EditLocalVideoSource))) {
        break label328;
      }
      localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("is_hw_encode", Boolean.valueOf(true));
    }
    for (;;)
    {
      localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("thumb_rotation", Integer.valueOf(paramInt3));
      localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("composite_key_capturemode", Integer.valueOf(f()));
      localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("composite_key_entrance", Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c()));
      paramEditSource = localGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_text_filter_text");
      if (!TextUtils.isEmpty(paramEditSource))
      {
        if (!TextUtils.isEmpty(localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDoodleDescription)) {
          break label347;
        }
        localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDoodleDescription = paramEditSource;
      }
      return localGenerateContext;
      bool = false;
      break;
      label328:
      localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("is_hw_encode", Boolean.valueOf(false));
    }
    label347:
    paramString1 = new StringBuilder();
    paramString2 = localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
    paramString2.videoDoodleDescription += paramEditSource;
    return localGenerateContext;
  }
  
  private void a(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Float = paramInt;
    this.e = false;
    this.jdField_b_of_type_Float = (50000.0F / (float)paramLong);
    if (this.jdField_b_of_type_Float == 0.0F) {
      this.jdField_b_of_type_Float = 1.0F;
    }
    B();
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if ((paramIntent != null) && ((this.jdField_b_of_type_JavaLangString == null) || (!this.jdField_b_of_type_JavaLangString.equals(paramIntent.getStringExtra("fakeId"))))) {}
    do
    {
      return;
      a(0);
      this.e = true;
      if (paramInt == -1)
      {
        d(100);
        ThreadManager.excute(new EditVideoPartManager.8(this, paramIntent), 64, null, true);
        return;
      }
      if (paramInt == 1)
      {
        C();
        m();
        return;
      }
    } while (paramInt != 0);
    C();
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
  
  private void b()
  {
    c(0);
  }
  
  private void b(EditVideoParams.EditSource paramEditSource, Observer<GenerateContext> paramObserver)
  {
    Object localObject = new GenerateContext(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    ((GenerateContext)localObject).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = CodecParam.mMaxrate;
    ((GenerateContext)localObject).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMinrate = CodecParam.mMinrate;
    ((GenerateContext)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_upload_temp_directory");
    if (((GenerateContext)localObject).jdField_b_of_type_JavaLangString == null) {
      ((GenerateContext)localObject).jdField_b_of_type_JavaLangString = PublishFileManager.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int);
    }
    ((GenerateContext)localObject).jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs = new GeneratePicArgs(paramEditSource.a());
    paramEditSource = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramEditSource.hasNext()) {
      ((EditVideoPart)paramEditSource.next()).a(0, (GenerateContext)localObject);
    }
    a((GenerateContext)localObject);
    b((GenerateContext)localObject);
    SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { ((GenerateContext)localObject).jdField_b_of_type_JavaLangString });
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(HardCodeUtil.a(2131703855), false, 500L);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    this.jdField_b_of_type_JavaUtilList.clear();
    paramEditSource = Stream.of(localObject).map(new ThreadOffFunction("Q.qqstory.publish.edit.EditVideoPartManager", 2)).map(new MergePicSegment(false)).map(new ResizeBitmapSegment());
    localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter != null) {}
    for (int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.a();; i = 0)
    {
      localObject = paramEditSource.map(new GeneratePicThumbSegment((Activity)localObject, i));
      paramEditSource = (EditVideoParams.EditSource)localObject;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null) {
        paramEditSource = ((Stream)localObject).map(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a(0));
      }
      paramEditSource.map(new MergeThumbSegment()).map((StreamFunction)StoryApi.a(DoodleRotateSegment.class, new Object[0])).map(new PublishVideoSegment(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
      return;
    }
  }
  
  @TargetApi(14)
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a());
      Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        ((Window)localObject).setDimAmount(0.0F);
      }
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561994);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373545);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371908)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
    f(0);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a().post(new EditVideoPartManager.5(this));
  }
  
  private void c(int paramInt)
  {
    if (!a()) {
      Bosses.get().postJob(new EditVideoPartManager.3(this, "Q.qqstory.publish.edit.EditVideoPartManager"));
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_is_slide_show_video", false)) {
      StoryReportor.a("video_edit", "pub_slides", 0, 0, new String[0]);
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 104) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        StoryReportor.a("video_shoot_fromweb", "done_pub", 0, 0, new String[0]);
      }
      return;
    }
  }
  
  private void c(GenerateContext paramGenerateContext)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity() == null)
    {
      AEQLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "jumpToSaveVideoForAioSendVideoArkMsg--activity not exist");
      return;
    }
    b(HardCodeUtil.a(2131703780));
    paramGenerateContext = paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam;
    AEQLog.a("Q.qqstory.publish.edit.EditVideoPartManager", "jumpToSaveVideoForAioSendVideoArkMsg: publishParam=" + paramGenerateContext);
    Intent localIntent1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent();
    int j;
    int i;
    if (localIntent1 != null)
    {
      j = localIntent1.getIntExtra("sv_total_frame_count", 0);
      i = localIntent1.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      Intent localIntent2 = SaveVideoActivity.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), paramGenerateContext.jdField_b_of_type_JavaLangString, i, j, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a());
      this.jdField_b_of_type_JavaLangString = paramGenerateContext.jdField_b_of_type_JavaLangString;
      i = AECameraEntry.a.a();
      if (localIntent1 != null) {
        i = localIntent1.getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
      }
      localIntent2.putExtra("mediacodec_encode_enable", true);
      if (paramGenerateContext.e != 0) {
        bool = true;
      }
      localIntent2.putExtra("video_edit_flag", bool);
      localIntent2.putExtra("thumbfile_send_path", paramGenerateContext.c);
      localIntent2.putExtra("VIDEO_STORY_FROM_TYPE", i);
      if (localIntent1 != null)
      {
        localIntent2.putExtra("widgetinfo", localIntent1.getStringExtra("widgetinfo"));
        String str = localIntent1.getStringExtra("key_camera_material_name");
        AEQLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "start SaveVideoActivity---takeSameName=" + str);
        localIntent2.putExtra("key_camera_material_name", str);
        localIntent2.putExtra("qqstory_slide_show_scene", localIntent1.getIntExtra("qqstory_slide_show_scene", -1));
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().startActivityForResult(localIntent2, 222);
      a(5, paramGenerateContext.jdField_a_of_type_Long);
      return;
      i = 0;
      j = 0;
    }
  }
  
  private void c(String paramString)
  {
    PeakIpcController.a(paramString, new EditVideoPartManager.11(this));
  }
  
  private void d(int paramInt)
  {
    int i = paramInt;
    if (f()) {
      i = (int)(50.0F * paramInt / 100.0F);
    }
    f(i);
  }
  
  private void e(int paramInt)
  {
    int i = paramInt;
    if (f()) {
      i = (int)(paramInt * 50.0F / 100.0F + 50.0F);
    }
    f(i);
  }
  
  private void f(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.b(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.d(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a(paramInt + "%");
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 2, "[setProgress] current:" + this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a() + ", progress:" + paramInt);
  }
  
  private boolean f()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 2);
  }
  
  public int a()
  {
    return 0;
  }
  
  public int a(@NonNull Message paramMessage)
  {
    o();
    if (this.jdField_b_of_type_Boolean)
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "broadcast message ignore because of publishing");
      return 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((EditVideoPart)localIterator.next()).b(Message.obtain(paramMessage))) {
        break label94;
      }
      i += 1;
    }
    label94:
    for (;;)
    {
      break;
      if (i == 0) {
        SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "broadcastEditVideoMessage, but no one handled", new Object[] { paramMessage });
      }
      paramMessage.recycle();
      return i;
    }
  }
  
  public long a()
  {
    Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    long l;
    if ((localObject instanceof EditRecordVideoSource)) {
      l = ((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter != null) {}
      switch (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.a())
      {
      default: 
        return l;
        if (((localObject instanceof EditTakePhotoSource)) || ((localObject instanceof EditLocalPhotoSource)))
        {
          l = 5000L;
        }
        else if ((localObject instanceof EditLocalVideoSource))
        {
          localObject = (EditLocalVideoSource)localObject;
          l = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int - ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
          if (l == 0L) {
            l = ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
          }
        }
        else if ((localObject instanceof EditTakeVideoSource))
        {
          l = ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
        }
        else
        {
          throw new RuntimeException(HardCodeUtil.a(2131703917));
        }
        break;
      case 1: 
        return l / 2L;
      case 2: 
        return l * 2L;
      case 4: 
        return l * 4L;
      case 3: 
        return ((float)l / 1.5F);
      }
    }
  }
  
  public long a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    long l;
    if ((localObject instanceof EditRecordVideoSource)) {
      l = ((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter != null) {}
      switch (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.a())
      {
      default: 
        return l;
        if (((localObject instanceof EditTakePhotoSource)) || ((localObject instanceof EditLocalPhotoSource)))
        {
          l = 5000L;
        }
        else if ((localObject instanceof EditLocalVideoSource))
        {
          localObject = (EditLocalVideoSource)localObject;
          l = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int - ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
          if (l == 0L) {
            l = ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
          }
        }
        else if ((localObject instanceof EditTakeVideoSource))
        {
          l = ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
        }
        else
        {
          throw new RuntimeException(HardCodeUtil.a(2131703920));
        }
        break;
      case 1: 
        return l / 2L;
      case 2: 
        return l * 2L;
      case 4: 
        return l * 4L;
      case 3: 
        return ((float)l / 1.5F);
      }
    }
  }
  
  public Bitmap a()
  {
    Bitmap localBitmap = null;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage != null) {
      localBitmap = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage.a();
    }
    return localBitmap;
  }
  
  public Bundle a()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      return new Bundle();
    }
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  View a()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton != null) {
      return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton.a();
    }
    return null;
  }
  
  public VideoStoryDataBean a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean == null)
      {
        VideoStoryDataBean localVideoStoryDataBean2 = (VideoStoryDataBean)a().getSerializable("KEY_VIDEO_STORY_CAMERA_TYPE");
        VideoStoryDataBean localVideoStoryDataBean1 = localVideoStoryDataBean2;
        if (localVideoStoryDataBean2 == null) {
          localVideoStoryDataBean1 = new VideoStoryDataBean();
        }
        this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean = localVideoStoryDataBean1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("Q.qqstory.publish.edit.EditVideoPartManager", 1, "getVsDataBean error", localException);
        this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean = new VideoStoryDataBean();
      }
    }
    return this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
  }
  
  protected SimpleObserver<GenerateContext> a()
  {
    return new EditVideoPartManager.4(this, SystemClock.uptimeMillis());
  }
  
  public EditVideoDoodle a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle;
  }
  
  @Nullable
  public EditVideoPart.EditExport a(Class<? extends EditVideoPart.EditExport> paramClass)
  {
    if (paramClass == null) {
      throw new IllegalArgumentException("editExportClass should not be null");
    }
    return (EditVideoPart.EditExport)this.jdField_a_of_type_JavaUtilMap.get(paramClass);
  }
  
  public EditVideoUi a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi;
  }
  
  public List<EditVideoPart> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    o();
    E();
    EditVideoParams.EditSource localEditSource = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "onConfirmClick : %s", new Object[] { localEditSource });
    Intent localIntent = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent();
    if (!this.jdField_b_of_type_Boolean)
    {
      if ((AECameraEntry.a(localIntent, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())) || (AECameraEntry.c(localIntent)))
      {
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity() != null) {
          break label188;
        }
        localObject = "";
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
        {
          LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource = new EditLocalPhotoSource((String)localObject, localLocalMediaInfo);
        }
        p();
        this.jdField_b_of_type_Boolean = true;
        localObject = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
        if (localObject != null) {
          ((EditVideoPlayerExport)localObject).aK_();
        }
        if ((!AECameraEntry.a(localIntent, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())) && (!AECameraEntry.c(localIntent))) {
          break;
        }
        A();
        return;
        label188:
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent() == null) {
          localObject = "";
        } else if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent().getBundleExtra("state") == null) {
          localObject = "";
        } else {
          localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent().getBundleExtra("state").getString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH");
        }
      }
    }
    SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "requestPublish duplicate");
    return;
    Object localObject = a();
    if (((localEditSource instanceof EditRecordVideoSource)) || ((localEditSource instanceof EditLocalVideoSource)) || ((localEditSource instanceof EditTakeVideoSource)))
    {
      a(localEditSource, (Observer)localObject);
      if ((localEditSource instanceof EditLocalVideoSource)) {
        StoryReportor.a("video_edit", "pub_local", 0, 1, new String[0]);
      }
    }
    while ((!(localEditSource instanceof EditLocalPhotoSource)) && (!(localEditSource instanceof EditTakePhotoSource)))
    {
      A();
      return;
    }
    b();
    CodecParam.mRecordTime = 5000;
    CodecParam.mRecordFrames = 125;
    CodecParam.mIsSmooth = 0;
    CodecParam.mEnableTotalTimeAdjust = 0;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter != null) {}
    for (int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.a();; i = 0)
    {
      CodecParam.mSaveMode = i;
      b(localEditSource, (Observer)localObject);
      break;
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    EditVideoPlayerExport localEditVideoPlayerExport = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
    if (localEditVideoPlayerExport != null)
    {
      if (!(localEditVideoPlayerExport instanceof HWEditLocalVideoPlayer)) {
        break label43;
      }
      ((HWEditLocalVideoPlayer)localEditVideoPlayerExport).a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    }
    label43:
    while (!(localEditVideoPlayerExport instanceof HWEditImportVideoPlayer)) {
      return;
    }
    ((HWEditImportVideoPlayer)localEditVideoPlayerExport).a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
  }
  
  public final void a(int paramInt)
  {
    a(paramInt, null);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 222)
    {
      AEQLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "onActivityResult---CODE_REQ_AIO_SAVE_ARK_VIDEO--resultCode=" + paramInt2);
      a(paramInt2, paramIntent);
    }
    for (;;)
    {
      return;
      if (AECameraEntry.f(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent()))
      {
        AEQLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "onActivityResult---isFromMiniApp");
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(-1, paramIntent, 2130772034, 0, true);
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((EditVideoPart)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public final void a(int paramInt, Object paramObject)
  {
    o();
    E();
    if (this.jdField_b_of_type_Boolean)
    {
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "change state ignore because of publishing, %s", new Throwable());
      return;
    }
    if ((this.jdField_a_of_type_Int != paramInt) || (paramInt == 2))
    {
      if (this.jdField_a_of_type_Boolean) {
        SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "change state while state changing, " + paramInt + " oldState:" + this.jdField_a_of_type_Int, new Throwable());
      }
      this.jdField_a_of_type_Boolean = true;
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "changeState : %s => %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt));
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = paramInt;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((EditVideoPart)localIterator.next()).a(i, this.jdField_a_of_type_Int, paramObject);
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().a(paramInt, paramString);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a(paramLong);
    }
  }
  
  public void a(Context paramContext)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 14) {
      StoryReportor.a("story_grp", "clk_send", 0, 0, new String[0]);
    }
    long l = a();
    Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    int i;
    if ((localObject instanceof EditRecordVideoSource)) {
      if (((EditRecordVideoSource)localObject).jdField_b_of_type_Int == 1) {
        i = 1;
      }
    }
    for (;;)
    {
      int j = b();
      if (a()) {}
      for (localObject = "2";; localObject = "1")
      {
        a("clk_publish", j, 0, new String[] { localObject, String.valueOf(l), String.valueOf(i), AppUtil.a(paramContext) });
        return;
        i = 2;
        break;
        if (!(localObject instanceof EditTakePhotoSource)) {
          break label165;
        }
        if (((EditTakePhotoSource)localObject).jdField_a_of_type_Int == 1)
        {
          i = 1;
          break;
        }
        i = 2;
        break;
      }
      label165:
      i = 3;
    }
  }
  
  void a(Intent paramIntent, int paramInt, PublishParam paramPublishParam, TribeVideoPublishParams paramTribeVideoPublishParams)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(-1, paramIntent, 2130772034, 0, true);
      return;
    case 11: 
      paramPublishParam = null;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      paramInt = -1;
      if (localIterator.hasNext())
      {
        EditVideoPart localEditVideoPart = (EditVideoPart)localIterator.next();
        if (!(localEditVideoPart instanceof DovTribeEditVideoButton)) {
          break label185;
        }
        paramInt = ((DovTribeEditVideoButton)localEditVideoPart).a();
        paramPublishParam = ((DovTribeEditVideoButton)localEditVideoPart).a();
      }
      break;
    }
    label185:
    for (;;)
    {
      break;
      paramIntent.putExtra("theme_id", paramInt);
      paramIntent.putExtra("theme_name", paramPublishParam);
      paramIntent.putExtra(TribeVideoPublishParams.BUNDLE_EXTRA_KEY, paramTribeVideoPublishParams);
      if (QLog.isColorLevel()) {
        QLog.i("tribe_publish", 2, "getPublishIntent");
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(-1, paramIntent, 2130772034, 0, true);
      return;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(-1, paramIntent, 2130772034, 0, true);
      return;
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    o();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage.a(paramBitmap, paramBoolean);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).a(paramBundle);
    }
  }
  
  public void a(Animation paramAnimation) {}
  
  public void a(EditVideoParams.EditSource paramEditSource, Observer<GenerateContext> paramObserver)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    Object localObject2;
    int i;
    int j;
    String str1;
    float f;
    int k;
    Object localObject1;
    boolean bool;
    int m;
    int n;
    if ((paramEditSource instanceof EditRecordVideoSource))
    {
      localObject2 = (EditRecordVideoSource)paramEditSource;
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + CodecParam.mRecordFrames + " CodecParam.mRecordTime" + CodecParam.mRecordTime);
      CodecParam.mRecordTime = (int)((EditRecordVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Long;
      CodecParam.mRecordFrames = ((EditRecordVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Int;
      CodecParam.mIsSmooth = 0;
      CodecParam.mEnableTotalTimeAdjust = 0;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter != null) {}
      for (i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.a();; i = 0)
      {
        CodecParam.mSaveMode = i;
        i = ((EditRecordVideoSource)localObject2).jdField_f_of_type_Int;
        j = ((EditRecordVideoSource)localObject2).g;
        str1 = ((EditRecordVideoSource)localObject2).jdField_a_of_type_JavaLangString;
        f = ((EditRecordVideoSource)localObject2).jdField_a_of_type_Float;
        k = ((EditRecordVideoSource)localObject2).e;
        localObject1 = ((EditRecordVideoSource)localObject2).jdField_b_of_type_JavaLangString;
        bool = ((EditRecordVideoSource)localObject2).jdField_a_of_type_Boolean;
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Integer.valueOf(0));
        String str2 = String.format("%s.%d", new Object[] { QQStoryContext.a().a(), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)) });
        SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publish video groupId=%s. fragment count=%d", str2, Integer.valueOf(localArrayList.size()));
        String str3 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_upload_temp_directory");
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(localArrayList.size());
        this.jdField_b_of_type_JavaUtilList.clear();
        m = 0;
        if (m >= localArrayList.size()) {
          break label1146;
        }
        n = ((Integer)localArrayList.get(m)).intValue();
        c(n);
        localObject2 = a(paramEditSource, i, j, str1, f, k, (String)localObject1, bool, l, str2, str3, m, n);
        localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((EditVideoPart)((Iterator)localObject3).next()).a(n, (GenerateContext)localObject2);
        }
      }
    }
    if ((paramEditSource instanceof EditLocalVideoSource))
    {
      localObject2 = (EditLocalVideoSource)paramEditSource;
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + CodecParam.mRecordFrames + " CodecParam.mRecordTime" + CodecParam.mRecordTime);
      CodecParam.mRecordTime = 5000;
      CodecParam.mRecordFrames = 125;
      CodecParam.mIsSmooth = 0;
      CodecParam.mEnableTotalTimeAdjust = 0;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter != null) {}
      for (i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.a();; i = 0)
      {
        CodecParam.mSaveMode = i;
        j = ((EditLocalVideoSource)localObject2).a();
        k = ((EditLocalVideoSource)localObject2).b();
        i = Math.min(j, k);
        j = Math.max(j, k);
        str1 = ((EditLocalVideoSource)localObject2).a();
        f = i * 1.0F / j;
        k = ((EditLocalVideoSource)localObject2).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
        localObject1 = "";
        bool = false;
        SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo EditLocalVideoSource.mediaInfo" + ((EditLocalVideoSource)localObject2).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.toString());
        break;
      }
    }
    if ((paramEditSource instanceof EditTakeVideoSource))
    {
      localObject1 = (EditTakeVideoSource)paramEditSource;
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + CodecParam.mRecordFrames + " CodecParam.mRecordTime" + CodecParam.mRecordTime);
      CodecParam.mRecordTime = 5000;
      CodecParam.mRecordFrames = 125;
      CodecParam.mIsSmooth = 0;
      CodecParam.mEnableTotalTimeAdjust = 0;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter != null) {}
      for (i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.a();; i = 0)
      {
        CodecParam.mSaveMode = i;
        i = ((EditTakeVideoSource)localObject1).a();
        j = ((EditTakeVideoSource)localObject1).b();
        str1 = ((EditTakeVideoSource)localObject1).a();
        f = i * 1.0F / j;
        k = ((EditTakeVideoSource)localObject1).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
        localObject1 = "";
        bool = false;
        break;
      }
    }
    throw new IllegalArgumentException(HardCodeUtil.a(2131703861) + paramEditSource);
    a((GenerateContext)localObject2);
    b((GenerateContext)localObject2);
    SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { ((GenerateContext)localObject2).jdField_b_of_type_JavaLangString });
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(HardCodeUtil.a(2131703807), false, 500L);
    Object localObject3 = Stream.of(localObject2).map(new ThreadOffFunction("Q.qqstory.publish.edit.EditVideoPartManager", 2));
    if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)))
    {
      localObject2 = new HWEncodeGenerateThumbSegment(null, (EditVideoPlayerExport)a(EditVideoPlayerExport.class), 0);
      label890:
      localObject3 = ((Stream)localObject3).map((StreamFunction)localObject2);
      localObject2 = localObject3;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null)
      {
        localObject2 = ((Stream)localObject3).map(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a(n));
        if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a()) && (c() == 0L)) {
          break label1181;
        }
        localObject2 = ((Stream)localObject2).map(new GenerateDynamicDoodleImageSegment(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle, (EditFilterExport)a(EditFilterExport.class), n));
      }
    }
    label1181:
    for (;;)
    {
      if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))) {}
      for (localObject2 = ((Stream)localObject2).map(new HWEncodeMergeThumbSegment());; localObject2 = ((Stream)localObject2).map(new MergeThumbSegment()).map((StreamFunction)StoryApi.a(DoodleRotateSegment.class, new Object[0])))
      {
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 14) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", AECameraEntry.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent()));
        }
        ((Stream)localObject2).map(new PublishVideoSegment(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
        m += 1;
        break;
        localObject2 = new GenerateThumbSegment();
        break label890;
      }
      label1146:
      paramEditSource = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramEditSource.hasNext()) {
        ((EditVideoPart)paramEditSource.next()).y_();
      }
      return;
    }
  }
  
  protected void a(@NonNull EditVideoParams paramEditVideoParams)
  {
    SLog.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts %s", paramEditVideoParams);
    int i = paramEditVideoParams.jdField_c_of_type_Int;
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (paramEditVideoParams.jdField_a_of_type_Int == 11)
    {
      localObject = new DovTribeEditVideoButton(this, i);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton = ((EditVideoButton)localObject);
      localArrayList.add(localObject);
      if ((!AECameraEntry.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())) && (!AECameraEntry.c(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent())))
      {
        localObject = new EditProviderPart(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart = ((EditProviderPart)localObject);
        localArrayList.add(localObject);
      }
      localObject = new EditCommonParam(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditCommonParam = ((EditCommonParam)localObject);
      localArrayList.add(localObject);
      if (!paramEditVideoParams.a()) {
        break label739;
      }
      localObject = new EditPicRawImage(this, i);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage = ((EditPicRawImage)localObject);
      localArrayList.add(localObject);
      label183:
      if (a(i, 2))
      {
        if (paramEditVideoParams.jdField_a_of_type_Int != 14) {
          break label833;
        }
        localArrayList.add(new EditVideoSmartMusicPart(this));
      }
      label215:
      if ((a(i, 1024)) || (a(i, 1)) || (a(i, 8)))
      {
        localObject = new EditVideoDoodle(this, i);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle = ((EditVideoDoodle)localObject);
        localArrayList.add(localObject);
      }
      if (a(i, 256))
      {
        localObject = new EditVideoSpeedFilter(this, true);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter = ((EditVideoSpeedFilter)localObject);
        localArrayList.add(localObject);
      }
      if ((paramEditVideoParams.a()) && (a(i, 4)))
      {
        localObject = new EditPicCropPart(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart = ((EditPicCropPart)localObject);
        localArrayList.add(localObject);
      }
      if (a(i, 512))
      {
        if (!AECameraEntry.c(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent())) {
          break label862;
        }
        localObject = new EditPicSave(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicSave = ((EditPicSave)localObject);
        localArrayList.add(localObject);
      }
    }
    for (;;)
    {
      if (a(i, 16))
      {
        localObject = new EditVideoTransfer(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoTransfer = ((EditVideoTransfer)localObject);
        localArrayList.add(localObject);
      }
      if ((AECameraEntry.c.a(paramEditVideoParams.jdField_f_of_type_Int)) && ((paramEditVideoParams.c()) || (paramEditVideoParams.a()) || (paramEditVideoParams.b())))
      {
        localObject = new SendPanelPart(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelPart = ((SendPanelPart)localObject);
        localArrayList.add(localObject);
      }
      if (a(paramEditVideoParams.jdField_c_of_type_Int, 4096))
      {
        paramEditVideoParams = new EditVideoLimitRegion(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoLimitRegion = paramEditVideoParams;
        localArrayList.add(paramEditVideoParams);
      }
      if (a(i, 16384))
      {
        paramEditVideoParams = new EditVideoAblumList(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoAblumList = paramEditVideoParams;
        localArrayList.add(paramEditVideoParams);
      }
      a(localArrayList);
      this.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(localArrayList);
      SLog.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      paramEditVideoParams = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramEditVideoParams.hasNext()) {
        SLog.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts : %s", ((EditVideoPart)paramEditVideoParams.next()).getClass().getSimpleName());
      }
      if (paramEditVideoParams.jdField_a_of_type_Int == 12)
      {
        localObject = new ReadInJoyEditVideoButton(this, i);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton = ((EditVideoButton)localObject);
        localArrayList.add(localObject);
        break;
      }
      if (paramEditVideoParams.jdField_a_of_type_Int == 14)
      {
        localObject = new EditVideoStoryButton(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoStoryButton = ((EditVideoStoryButton)localObject);
        localArrayList.add(localObject);
        break;
      }
      localObject = new EditVideoButton(this, i);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton = ((EditVideoButton)localObject);
      localArrayList.add(localObject);
      break;
      label739:
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer = new HWEditLocalVideoPlayer(this);
      if (paramEditVideoParams.d())
      {
        if (Build.VERSION.SDK_INT < 14) {
          break label183;
        }
        localArrayList.add(new HWEditImportVideoPlayer(this));
        break label183;
      }
      if (paramEditVideoParams.g())
      {
        localArrayList.add(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer);
        break label183;
      }
      localObject = new EditVideoPlayer(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPlayer = ((EditVideoPlayer)localObject);
      localArrayList.add(localObject);
      break label183;
      label833:
      localObject = new EditVideoQimMusic(this, false);
      this.jdField_a_of_type_DovComQqImCaptureMusicEditVideoQimMusic = ((EditVideoQimMusic)localObject);
      localArrayList.add(localObject);
      break label215;
      label862:
      if (!AECameraEntry.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()))
      {
        localObject = new EditVideoSave(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave = ((EditVideoSave)localObject);
        localArrayList.add(localObject);
      }
      else
      {
        localObject = new EditPicSave(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicSave = ((EditPicSave)localObject);
        localArrayList.add(localObject);
      }
    }
  }
  
  public void a(EditVideoUi paramEditVideoUi, EditVideoParams paramEditVideoParams)
  {
    o();
    if ((paramEditVideoUi == null) || (paramEditVideoParams == null)) {
      throw new IllegalArgumentException("both ui ant params should not be null");
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi != paramEditVideoUi) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != paramEditVideoParams))
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi = paramEditVideoUi;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
      a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      paramEditVideoParams = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (paramEditVideoParams.hasNext())
    {
      ((EditVideoPart)paramEditVideoParams.next()).a(paramEditVideoUi);
      continue;
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "duplicate attachUiAndParams ui=%s, params=%s", new Object[] { paramEditVideoUi, paramEditVideoParams });
    }
  }
  
  public void a(GenerateContext paramGenerateContext)
  {
    Object localObject = paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.readerConfBytes;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = new qqstory_struct.VideoReaderConf();
      ((qqstory_struct.VideoReaderConf)localObject).ban_type.set(0);
      ((qqstory_struct.VideoReaderConf)localObject).setHasFlag(true);
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.readerConfBytes = ((qqstory_struct.VideoReaderConf)localObject).toByteArray();
    }
  }
  
  public void a(Class<? extends EditVideoPart.EditExport> paramClass, EditVideoPart.EditExport paramEditExport)
  {
    o();
    E();
    if (paramClass == null) {
      throw new IllegalArgumentException("editExportClass should not be null");
    }
    if (!paramClass.isInstance(paramEditExport)) {
      throw new IllegalArgumentException("the 2nd parameter's type " + paramEditExport.getClass().getName() + " is not instance of " + paramClass.getName());
    }
    EditVideoPart.EditExport localEditExport = (EditVideoPart.EditExport)this.jdField_a_of_type_JavaUtilMap.get(paramClass);
    if (localEditExport == null) {
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishEditExport for %s with %s", paramClass.getSimpleName(), paramEditExport);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramClass, paramEditExport);
      return;
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "publishEditExport for %s replace %s by %s", new Object[] { paramClass.getSimpleName(), localEditExport, paramEditExport });
    }
  }
  
  public void a(Error paramError)
  {
    SLog.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH error ：" + paramError);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).a(paramError);
    }
    StoryReportor.b("video_edit", "pub_error", 0, 0, new String[] { paramError.toString() });
    this.jdField_b_of_type_JavaUtilList.add(paramError);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() > 0) {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
    }
    do
    {
      return;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.b();
      QQToast.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), HardCodeUtil.a(2131703789), 0).a();
      paramError = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
    } while (paramError == null);
    paramError.m();
  }
  
  void a(String paramString)
  {
    QLog.w("Q.qqstory.publish.edit.EditVideoPartManager", 1, "onDlnaVideoSaved videoPath " + paramString);
    if (paramString != null)
    {
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
      Bundle localBundle = new Bundle();
      localBundle.putString("key_video_path", paramString);
      QZoneHelper.forwardToDLNAActivity(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity(), localUserInfo, localBundle, -1);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    Bosses.get().postJob(new EditVideoPartManager.2(this, "Q.qqstory.publish.edit.EditVideoPartManager", paramString, paramInt1, paramInt2, paramVarArgs));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {}
  
  protected void a(List<EditVideoPart> paramList) {}
  
  public void a(Map<Long, TrackerStickerParam.MotionInfo> paramMap)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a(paramMap);
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    EditVideoPlayerExport localEditVideoPlayerExport = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
    if (localEditVideoPlayerExport != null)
    {
      if (!(localEditVideoPlayerExport instanceof HWEditLocalVideoPlayer)) {
        break label41;
      }
      ((HWEditLocalVideoPlayer)localEditVideoPlayerExport).a(paramBoolean, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    }
    label41:
    while (!(localEditVideoPlayerExport instanceof HWEditImportVideoPlayer)) {
      return;
    }
    ((HWEditImportVideoPlayer)localEditVideoPlayerExport).a(paramBoolean, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public boolean a()
  {
    o();
    E();
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a();
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_Int == paramInt;
  }
  
  public int b()
  {
    switch (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int)
    {
    default: 
      return 999;
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 4: 
      return 4;
    }
    return 5;
  }
  
  public long b()
  {
    Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    if ((localObject instanceof EditRecordVideoSource)) {
      return ((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    }
    if (((localObject instanceof EditTakePhotoSource)) || ((localObject instanceof EditLocalPhotoSource))) {
      return 5000L;
    }
    long l;
    if ((localObject instanceof EditLocalVideoSource))
    {
      localObject = (EditLocalVideoSource)localObject;
      l = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int - ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
      if (l == 0L) {
        return ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
      }
    }
    else
    {
      if ((localObject instanceof EditTakeVideoSource)) {
        return ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
      }
      throw new RuntimeException(HardCodeUtil.a(2131703831));
    }
    return l;
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 2, "setFrom " + this.jdField_c_of_type_Int);
    }
  }
  
  public void b(Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).b(paramBundle);
    }
    paramBundle.putInt("mEditState", this.jdField_a_of_type_Int);
  }
  
  public void b(Animation paramAnimation) {}
  
  public void b(GenerateContext paramGenerateContext)
  {
    long l = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getLong("troop_uin");
    if (l != 0L)
    {
      Object localObject = new qqstory_struct.VideoReaderConf();
      ((qqstory_struct.VideoReaderConf)localObject).ban_type.set(1);
      ((qqstory_struct.VideoReaderConf)localObject).user_list.set(new ArrayList());
      ((qqstory_struct.VideoReaderConf)localObject).setHasFlag(true);
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.readerConfBytes = ((qqstory_struct.VideoReaderConf)localObject).toByteArray();
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Long.valueOf(l));
      if (((ArrayList)localObject).size() > 0) {
        try
        {
          qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
          byte[] arrayOfByte = paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.spreadGroupBytes;
          if (arrayOfByte != null) {}
          try
          {
            localVideoSpreadGroupList.mergeFrom(paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.spreadGroupBytes);
            localVideoSpreadGroupList.group_list.set((List)localObject);
            localVideoSpreadGroupList.visibility_type.set(4);
            localVideoSpreadGroupList.setHasFlag(true);
            paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.spreadGroupBytes = localVideoSpreadGroupList.toByteArray();
            return;
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            for (;;)
            {
              SLog.c("Q.qqstory.publish.edit.EditVideoPartManager", "checkTroopStory", localInvalidProtocolBufferMicroException);
            }
          }
          return;
        }
        finally {}
      }
    }
  }
  
  public boolean b()
  {
    o();
    E();
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d();
  }
  
  public int c()
  {
    if (b())
    {
      if (a()) {
        return 3;
      }
      return 4;
    }
    if (a()) {
      return 1;
    }
    return 2;
  }
  
  public long c()
  {
    return 0L;
  }
  
  protected void c()
  {
    EditVideoPlayerExport localEditVideoPlayerExport = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
    if (localEditVideoPlayerExport != null) {
      localEditVideoPlayerExport.aK_();
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(0, null, 2130772034, 0);
  }
  
  public void c(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).e(paramBoolean);
    }
  }
  
  public boolean c()
  {
    o();
    E();
    if ((this.jdField_a_of_type_AndroidOsBundle == null) || (!b())) {
      return false;
    }
    return this.jdField_a_of_type_AndroidOsBundle.getBoolean("KEY_FROM_PIC_TO_VIDEO", false);
  }
  
  public int d()
  {
    int i = 0;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null) {
      i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a(a());
    }
    return i;
  }
  
  public void d()
  {
    int j = 0;
    int k = 0;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null)
    {
      Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a();
      if (localObject != null) {
        ((DoodleLayout)localObject).h();
      }
      localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().a();
      int i = k;
      if (localObject != null)
      {
        i = k;
        if (((LineLayer)localObject).a.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 2, "preparePublish");
          }
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(HardCodeUtil.a(2131703756), false, 500L);
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.jdField_a_of_type_Int = 2;
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().m();
          i = 1;
        }
      }
      localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().a();
      j = i;
      if (localObject != null)
      {
        ((TextLayer)localObject).i();
        j = i;
      }
    }
    if (j == 0) {
      f();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton.a(paramBoolean);
    }
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_DovComQqImCaptureMusicEditVideoQimMusic != null) && (this.jdField_a_of_type_DovComQqImCaptureMusicEditVideoQimMusic.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_DovComQqImCaptureMusicEditVideoQimMusic });
      return true;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle });
      return true;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart });
      return true;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton });
      return true;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoStoryButton != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoStoryButton.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoStoryButton });
      return true;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelPart != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelPart.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelPart });
      return true;
    }
    e();
    return true;
  }
  
  public int e()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void e()
  {
    o();
    E();
    AEBaseDataReporter.a().d();
    VideoEditReport.a("0X80076B6");
    VideoEditReport.b("0X80075C2");
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null) {}
    for (int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.b();; i = 0)
    {
      int j = i;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart != null) {
        j = i + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart.jdField_a_of_type_Int;
      }
      SLog.a("Q.qqstory.publish.edit.EditVideoPartManager", "tryQuitRecordUI, current is preview state, edit count = %d", Integer.valueOf(j));
      if (j < 3)
      {
        c();
        return;
      }
      VideoEditReport.a("0X80076B7");
      VideoEditReport.b("0X80075C3");
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()) {}
      for (String str = HardCodeUtil.a(2131703864);; str = HardCodeUtil.a(2131703900))
      {
        ActionSheet localActionSheet = ActionSheet.createFullScreenDialog(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), false);
        localActionSheet.setMainTitle(str);
        localActionSheet.addButton(HardCodeUtil.a(2131703908), 3);
        localActionSheet.addCancelButton(HardCodeUtil.a(2131703828));
        localActionSheet.setOnButtonClickListener(new EditVideoPartManager.1(this, localActionSheet));
        localActionSheet.show();
        return;
      }
    }
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelPart != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelPart.jdField_a_of_type_Boolean);
  }
  
  public int f()
  {
    int j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int;
    int i = j;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      i = j;
      if (j != 9) {
        i = 2;
      }
    }
    return i;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi == null) {
      QLog.e("Q.qqstory.publish.edit.EditVideoPartManager", 1, "onPreparePublishDone error, mUi is null");
    }
    label92:
    Object localObject2;
    do
    {
      return;
      a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a());
      a();
      localObject1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
      if ((localObject1 instanceof EditPicActivity)) {}
      switch (((Activity)localObject1).getIntent().getIntExtra("editpic_cameratype", -1))
      {
      default: 
        if (e() != 7) {
          break label211;
        }
        localObject2 = SlideShowPhotoListManager.a();
      }
    } while (localObject2 == null);
    Object localObject1 = ((SlideShowPhotoListManager)localObject2).a();
    Object localObject3 = ((List)localObject1).iterator();
    int i = 0;
    label129:
    if (((Iterator)localObject3).hasNext())
    {
      if (((SlideItemInfo)((Iterator)localObject3).next()).jdField_b_of_type_Int != 1) {
        break label424;
      }
      i += 1;
    }
    label424:
    for (;;)
    {
      break label129;
      BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putLong("sv_latest_taken_photo_time", -1L).commit();
      NewFlowCameraReporter.c();
      break label92;
      NewFlowCameraReporter.d();
      break label92;
      NewFlowCameraReporter.e();
      break label92;
      label211:
      break;
      int m = ((List)localObject1).size();
      int k = ((SlideShowPhotoListManager)localObject2).a();
      localObject2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent();
      int j;
      if (localObject2 != null)
      {
        localObject3 = (EditVideoParams)((Intent)localObject2).getParcelableExtra(EditVideoParams.class.getName());
        if (localObject3 != null) {
          j = ((EditVideoParams)localObject3).a("extra_ablum_type", -1);
        }
      }
      for (;;)
      {
        if (k == 11) {}
        for (k = 0;; k = 1)
        {
          StoryReportor.a("video_edit_slides", "clk_pub", k, 0, new String[] { StoryReportor.a(j) + "", ((List)localObject1).size() + "", m - i + "", i + "" });
          return;
          j = ((Intent)localObject2).getIntExtra("extra_ablum_type", -1);
          break;
        }
        j = -1;
      }
    }
  }
  
  public int g()
  {
    if (b())
    {
      if (a()) {
        return 3;
      }
      return 4;
    }
    if (a()) {
      return 1;
    }
    return 2;
  }
  
  public void g()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi = null;
  }
  
  public int h()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) {}
    switch (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())
    {
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    default: 
      return 0;
    case 11: 
      return 2;
    case 4: 
    case 12: 
      return 3;
    case 3: 
      return 4;
    }
    return 5;
  }
  
  public void h()
  {
    o();
    E();
    this.jdField_c_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent();
    this.jdField_a_of_type_AndroidOsBundle = EditState.a((Intent)localObject);
    this.jdField_a_of_type_JavaLangString = ((Intent)localObject).getStringExtra("KEY_SEND_ARK_MSG_ID");
    AEQLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "onCreate--arkViewId=" + this.jdField_a_of_type_JavaLangString);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).a();
    }
    if ((AECameraEntry.a((Intent)localObject, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())) || (AECameraEntry.c((Intent)localObject)))
    {
      LiuHaiUtils.c(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity());
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      }
    }
    if (a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_c_of_type_Int, 64)) {
      jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGPUBitmapImageRender = new GPUBitmapImageRender();
    }
    do
    {
      return;
      localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().findViewById(2131374441);
    } while (localObject == null);
    ((View)localObject).setVisibility(8);
  }
  
  public void i()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).j();
    }
  }
  
  public boolean isValidate()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Int == -1) {
      a(0);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).f();
    }
  }
  
  public void k()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).aM_();
    }
  }
  
  public void l()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).h();
    }
  }
  
  public final void m()
  {
    AEQLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "onSaveOrUploadArkVideoError");
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity(), 230).setMessage(2131689693).setPositiveButton(2131689692, new EditVideoPartManager.10(this)).setNegativeButton(2131690800, new EditVideoPartManager.9(this));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((EditVideoPart)localIterator.next()).g();
      }
      g();
    }
    if ((jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGPUBitmapImageRender != null) && (!MediaCodecUtil.b())) {
      jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGPUBitmapImageRender.a();
    }
    VideoFilterTools.a().b();
    this.jdField_c_of_type_Boolean = false;
  }
  
  protected void o()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException("can not access by non-ui thread");
    }
  }
  
  void p()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().i();
    }
    a(9);
    if (SlideShowPhotoListManager.a().b() == 22)
    {
      LpReportInfo_pf00064.allReport(680, 2, 6);
      LpReportInfo_pf00064.allReport(680, 12, 1);
    }
  }
  
  void q()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().i();
    a(19);
    if (SlideShowPhotoListManager.a().b() == 22)
    {
      LpReportInfo_pf00064.allReport(680, 2, 5);
      LpReportInfo_pf00064.allReport(680, 13, 1);
    }
  }
  
  void r()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null)
    {
      DoodleLayout localDoodleLayout = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a();
      if (localDoodleLayout != null) {
        localDoodleLayout.a.d();
      }
    }
  }
  
  void s()
  {
    int j = 0;
    Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart;
    ((EditPicCropPart)localObject).jdField_a_of_type_Int += d();
    if (this.jdField_a_of_type_Int == 7) {
      a(0);
    }
    int i;
    do
    {
      return;
      localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a();
      ((DoodleLayout)localObject).g();
      LineLayer localLineLayer = ((DoodleLayout)localObject).a();
      i = j;
      if (localLineLayer != null)
      {
        i = j;
        if (localLineLayer.a.a())
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(HardCodeUtil.a(2131703823), false, 500L);
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.jdField_a_of_type_Int = 3;
          ((DoodleLayout)localObject).m();
          i = 1;
        }
      }
    } while (i != 0);
    t();
  }
  
  void t()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.b();
    Object localObject1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a();
    Object localObject2 = ((DoodleLayout)localObject1).a(0);
    Object localObject3 = ((DoodleLayout)localObject1).b(0);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart.jdField_a_of_type_ArrayOfInt[0] = localObject2[0];
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart.jdField_a_of_type_ArrayOfInt[1] = localObject2[1];
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart.jdField_a_of_type_ArrayOfInt[2] = localObject3[0];
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart.jdField_a_of_type_ArrayOfInt[3] = localObject3[1];
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart.jdField_a_of_type_ArrayOfInt[4] = ((DoodleLayout)localObject1).a().b();
    localObject2 = a();
    if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled()))
    {
      SLog.e("Q.qqstory.publish.edit.EditVideoPartManager", "onPrepareCropDone fail");
      return;
    }
    localObject3 = ((DoodleLayout)localObject1).a();
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = BitmapUtils.c((Bitmap)localObject2, (Bitmap)localObject3);
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "onPrepareCropDone merged");
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
    a(7);
  }
  
  public void u()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().j();
    }
  }
  
  public void v()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().q();
    }
  }
  
  public void w()
  {
    x();
    a(0);
  }
  
  public void x()
  {
    ThreadManager.getUIHandler().post(new EditVideoPartManager.12(this));
  }
  
  public void y()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).l();
    }
  }
  
  void z()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null)
    {
      DoodleLayout localDoodleLayout = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a();
      if (localDoodleLayout != null) {
        localDoodleLayout.a.e();
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.q();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager
 * JD-Core Version:    0.7.0.1
 */