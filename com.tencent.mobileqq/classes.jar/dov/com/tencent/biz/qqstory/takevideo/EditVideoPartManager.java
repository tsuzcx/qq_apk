package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.animation.Animation;
import anec;
import aned;
import anee;
import anef;
import aneg;
import anej;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoReaderConf;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.business.base.AppUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.JobSegment;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.reactive.Observer;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.StreamFunction;
import com.tribe.async.reactive.UIThreadOffFunction;
import dov.com.qq.im.capture.EditState;
import dov.com.qq.im.capture.music.EditVideoQimMusic;
import dov.com.qq.im.capture.music.humrecognition.recognize.RecognitionManager;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.DynamicTextItem.TextMap;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.LineLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleOpController;
import dov.com.tencent.biz.qqstory.takevideo.interact.EditVideoInteract;
import dov.com.tencent.biz.qqstory.takevideo.publish.DoodleRotateSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateDynamicDoodleImageSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateEditPicDoodleSegment;
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
import dov.com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;

public class EditVideoPartManager
  implements IEventReceiver
{
  private int jdField_a_of_type_Int;
  public Intent a;
  public Bundle a;
  protected EditVideoQimMusic a;
  protected EditCommonParam a;
  public EditGifImage a;
  protected EditGifSpeedControl a;
  protected EditPicCropPart a;
  protected EditPicRawImage a;
  protected EditPicSave a;
  public EditProviderPart a;
  protected EditRecognitionPart a;
  public EditVideoArtFilter a;
  protected EditVideoAt a;
  public EditVideoButton a;
  public EditVideoDoodle a;
  public EditVideoFilter a;
  protected EditVideoFragment a;
  protected EditVideoGuide a;
  protected EditVideoInteractPaster a;
  protected EditVideoLabel a;
  protected EditVideoMultiSegment a;
  public EditVideoParams a;
  protected EditVideoPermission a;
  protected EditVideoPlayer a;
  protected EditVideoPoi a;
  protected EditVideoPoiSearch a;
  protected EditVideoSave a;
  protected EditVideoShareGroup a;
  protected EditVideoShareTo a;
  protected EditVideoSyncStoryGuide a;
  public EditVideoTag a;
  public EditVideoUi a;
  protected EditVideoVote a;
  protected HWEditLocalVideoPlayer a;
  protected EditVideoInteract a;
  private String jdField_a_of_type_JavaLangString;
  public List a;
  protected Map a;
  public final AtomicInteger a;
  protected boolean a;
  public int b;
  public List b;
  private AtomicInteger b;
  public boolean b;
  public int c;
  protected boolean c;
  private int d;
  public boolean d;
  private int jdField_e_of_type_Int;
  boolean jdField_e_of_type_Boolean = false;
  
  public EditVideoPartManager()
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = Collections.emptyList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1000);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void A()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null)) {
      throw new IllegalStateException("have not attach ui and params");
    }
  }
  
  private void a()
  {
    d(0);
  }
  
  private void a(EditVideoParams.EditSource paramEditSource, Observer paramObserver)
  {
    GenerateContext localGenerateContext = new GenerateContext(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    localGenerateContext.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_upload_temp_directory");
    if (localGenerateContext.jdField_b_of_type_JavaLangString == null) {
      localGenerateContext.jdField_b_of_type_JavaLangString = PublishFileManager.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int);
    }
    if ((paramEditSource instanceof EditLocalGifSource)) {
      if ((!TextUtils.isEmpty(paramEditSource.a())) || (((EditLocalGifSource)paramEditSource).a.size() <= 0)) {
        break label139;
      }
    }
    label139:
    for (localGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs = new GeneratePicArgs((String)((EditLocalGifSource)paramEditSource).a.get(0));; localGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs = new GeneratePicArgs(paramEditSource.a()))
    {
      paramEditSource = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramEditSource.hasNext()) {
        ((EditVideoPart)paramEditSource.next()).a(0, localGenerateContext);
      }
    }
    a(localGenerateContext);
    b(localGenerateContext);
    SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { localGenerateContext.jdField_b_of_type_JavaLangString });
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a("请稍候", false, 500L);
    Stream.of(localGenerateContext).map(new GenerateEditPicDoodleSegment((EditDoodleExport)a(EditDoodleExport.class), null, true)).map(new ThreadOffFunction(2)).map(new MergePicSegment(EditPicConstants.jdField_a_of_type_JavaLangString + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
  
  private boolean a(GenerateContext paramGenerateContext)
  {
    if (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath != null) {}
    do
    {
      do
      {
        return true;
      } while (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath != null);
      if (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.atJsonData != null)
      {
        SLog.c("Q.qqstory.publish.edit.EditVideoPartManager", "HAS AT LABELS.");
        return true;
      }
    } while ((paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath != null) || (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isMuteRecordVoice) || (paramGenerateContext.jdField_b_of_type_Boolean) || (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.saveMode != 0));
    return false;
  }
  
  private void b(EditVideoParams.EditSource paramEditSource, Observer paramObserver)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    Object localObject1;
    int i;
    int j;
    String str1;
    float f;
    int k;
    String str2;
    boolean bool1;
    ArrayList localArrayList;
    String str3;
    String str4;
    if ((paramEditSource instanceof EditRecordVideoSource))
    {
      localObject1 = (EditRecordVideoSource)paramEditSource;
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + CodecParam.z + " CodecParam.mRecordTime" + CodecParam.y);
      CodecParam.y = (int)((EditRecordVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Long;
      CodecParam.z = ((EditRecordVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Int;
      CodecParam.x = 0;
      CodecParam.E = 0;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      for (i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();; i = 0)
      {
        CodecParam.J = i;
        i = ((EditRecordVideoSource)localObject1).f;
        j = ((EditRecordVideoSource)localObject1).g;
        str1 = ((EditRecordVideoSource)localObject1).jdField_a_of_type_JavaLangString;
        f = ((EditRecordVideoSource)localObject1).jdField_a_of_type_Float;
        k = ((EditRecordVideoSource)localObject1).jdField_e_of_type_Int;
        str2 = ((EditRecordVideoSource)localObject1).jdField_b_of_type_JavaLangString;
        bool1 = ((EditRecordVideoSource)localObject1).jdField_a_of_type_Boolean;
        localArrayList = new ArrayList();
        str3 = String.format("%s.%d", new Object[] { QQStoryContext.a().a(), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)) });
        SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publish video groupId=%s. fragment count=%d", str3, Integer.valueOf(localArrayList.size()));
        str4 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_upload_temp_directory");
        if ((!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) || (!a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int, 262144))) {
          break label741;
        }
        localObject1 = null;
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFragment != null) {
          localObject1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFragment.a();
        }
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          break;
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          localArrayList.add(Integer.valueOf(((VideoFragmentInfo)((Iterator)localObject1).next()).c));
        }
      }
    }
    if ((paramEditSource instanceof EditLocalVideoSource))
    {
      localObject1 = (EditLocalVideoSource)paramEditSource;
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + CodecParam.z + " CodecParam.mRecordTime" + CodecParam.y);
      CodecParam.y = 5000;
      CodecParam.z = 125;
      CodecParam.x = 0;
      CodecParam.E = 0;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      for (i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();; i = 0)
      {
        CodecParam.J = i;
        j = ((EditLocalVideoSource)localObject1).a();
        k = ((EditLocalVideoSource)localObject1).b();
        i = Math.min(j, k);
        j = Math.max(j, k);
        str1 = ((EditLocalVideoSource)localObject1).a();
        f = i * 1.0F / j;
        k = ((EditLocalVideoSource)localObject1).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
        str2 = "";
        bool1 = false;
        SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo EditLocalVideoSource.mediaInfo" + ((EditLocalVideoSource)localObject1).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.toString());
        break;
      }
    }
    if ((paramEditSource instanceof EditTakeVideoSource))
    {
      localObject1 = (EditTakeVideoSource)paramEditSource;
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + CodecParam.z + " CodecParam.mRecordTime" + CodecParam.y);
      CodecParam.y = 5000;
      CodecParam.z = 125;
      CodecParam.x = 0;
      CodecParam.E = 0;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      for (i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();; i = 0)
      {
        CodecParam.J = i;
        i = ((EditTakeVideoSource)localObject1).a();
        j = ((EditTakeVideoSource)localObject1).b();
        str1 = ((EditTakeVideoSource)localObject1).a();
        f = i * 1.0F / j;
        k = ((EditTakeVideoSource)localObject1).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
        str2 = "";
        bool1 = false;
        break;
      }
    }
    throw new IllegalArgumentException("EditSource 类型有误：" + paramEditSource);
    SLog.e("Q.qqstory.publish.edit.EditVideoPartManager", "can not find any video fragment ! break the process of publish");
    return;
    label741:
    localArrayList.add(Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(localArrayList.size());
    this.jdField_b_of_type_JavaUtilList.clear();
    int m = 0;
    int n;
    Object localObject2;
    if (m < localArrayList.size())
    {
      n = ((Integer)localArrayList.get(m)).intValue();
      d(n);
      localObject1 = new GenerateContext(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      ((GenerateContext)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.multiFragmentGroupId = str3;
      ((GenerateContext)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.createTime = (m * 1000 + l);
      ((GenerateContext)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = CodecParam.r;
      if (MediaCodecDPC.f()) {
        ((GenerateContext)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = (MediaCodecDPC.b() * 1000);
      }
      ((GenerateContext)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMinrate = CodecParam.s;
      ((GenerateContext)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoUploadGroupTempDir = str4;
      ((GenerateContext)localObject1).jdField_b_of_type_JavaLangString = PublishFileManager.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int);
      localObject2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
      boolean bool2;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a() == 5))
      {
        bool2 = true;
        ((GenerateContext)localObject1).jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGenerateThumbArgs = new GenerateThumbArgs((Activity)localObject2, i, j, str1, f, bool2, k, 0.0D, 0.0D, str2, bool1);
        if ((!(paramEditSource instanceof EditTakeVideoSource)) && (!(paramEditSource instanceof EditLocalVideoSource))) {
          break label1080;
        }
        ((GenerateContext)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("is_hw_encode", Boolean.valueOf(true));
      }
      for (;;)
      {
        ((GenerateContext)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("thumb_rotation", Integer.valueOf(k));
        localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((EditVideoPart)((Iterator)localObject2).next()).a(n, (GenerateContext)localObject1);
        }
        bool2 = false;
        break;
        label1080:
        ((GenerateContext)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("is_hw_encode", Boolean.valueOf(false));
      }
      a((GenerateContext)localObject1);
      b((GenerateContext)localObject1);
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { ((GenerateContext)localObject1).jdField_b_of_type_JavaLangString });
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a("请稍候", false, 500L);
      localObject2 = Stream.of(localObject1).map(new ThreadOffFunction(2));
      if (((GenerateContext)localObject1).jdField_a_of_type_Int == 1) {
        if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)))
        {
          localObject1 = new HWEncodeGenerateThumbSegment(null, (EditVideoPlayerExport)a(EditVideoPlayerExport.class), n);
          label1220:
          localObject2 = ((Stream)localObject2).map((StreamFunction)localObject1);
          localObject1 = localObject2;
          if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null)
          {
            localObject1 = ((Stream)localObject2).map(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a(n));
            if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a()) {
              break label1603;
            }
            localObject1 = ((Stream)localObject1).map(new GenerateDynamicDoodleImageSegment(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle, (EditFilterExport)a(EditFilterExport.class), n));
          }
        }
      }
    }
    label1603:
    for (;;)
    {
      localObject2 = localObject1;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoAt != null) {
        localObject2 = ((Stream)localObject1).map(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoAt.a(n));
      }
      localObject1 = localObject2;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoInteractPaster != null)
      {
        JobSegment localJobSegment = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoInteractPaster.a(n);
        localObject1 = localObject2;
        if (localJobSegment != null) {
          localObject1 = ((Stream)localObject2).map(localJobSegment);
        }
      }
      if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))) {}
      for (localObject1 = ((Stream)localObject1).map(new HWEncodeMergeThumbSegment());; localObject1 = ((Stream)localObject1).map(new MergeThumbSegment()).map((StreamFunction)StoryApi.a(DoodleRotateSegment.class, new Object[0])))
      {
        ((Stream)localObject1).map(new PublishVideoSegment(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
        m += 1;
        break;
        localObject1 = new GenerateThumbSegment(null, (EditVideoPlayerExport)a(EditVideoPlayerExport.class), n);
        break label1220;
        if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)))
        {
          localObject1 = new HWEncodeGenerateThumbSegment(null, (EditVideoPlayerExport)a(EditVideoPlayerExport.class), 0);
          break label1220;
        }
        localObject1 = new GenerateThumbSegment();
        break label1220;
      }
      paramEditSource = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramEditSource.hasNext()) {
        ((EditVideoPart)paramEditSource.next()).r();
      }
      break;
    }
  }
  
  private void c(EditVideoParams.EditSource paramEditSource, Observer paramObserver)
  {
    Object localObject = new GenerateContext(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    ((GenerateContext)localObject).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = CodecParam.r;
    ((GenerateContext)localObject).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMinrate = CodecParam.s;
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
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a("请稍候", false, 500L);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    this.jdField_b_of_type_JavaUtilList.clear();
    paramEditSource = Stream.of(localObject).map(new ThreadOffFunction(2)).map(new MergePicSegment(false)).map(new ResizeBitmapSegment());
    localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
    for (int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();; i = 0)
    {
      localObject = paramEditSource.map(new GeneratePicThumbSegment((Activity)localObject, i));
      paramEditSource = (EditVideoParams.EditSource)localObject;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null) {
        paramEditSource = ((Stream)localObject).map(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a(0));
      }
      localObject = paramEditSource;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoAt != null) {
        localObject = paramEditSource.map(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoAt.a(0));
      }
      ((Stream)localObject).map(new MergeThumbSegment()).map((StreamFunction)StoryApi.a(DoodleRotateSegment.class, new Object[0])).map(new PublishVideoSegment(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
      return;
    }
  }
  
  private void d(int paramInt)
  {
    label52:
    String str2;
    if (a())
    {
      a("pub_photo", 0, 0, new String[] { "", "5000" });
      str1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("mCurrentTemplatePath");
      if (TextUtils.isEmpty(str1)) {
        break label185;
      }
      paramInt = 1;
      if (paramInt != 0)
      {
        paramInt = b();
        str2 = a(str1);
        if (!a()) {
          break label190;
        }
      }
    }
    label185:
    label190:
    for (String str1 = "2";; str1 = "1")
    {
      b("pub_changeface", paramInt, 0, new String[] { "1", str2, str1 });
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_is_slide_show_video", false)) {
        StoryReportor.a("video_edit", "pub_slides", 0, 0, new String[0]);
      }
      return;
      a("pub_video", 0, 0, new String[] { "", String.valueOf(a(paramInt)) });
      Bosses.get().postJob(new anef(this));
      break;
      paramInt = 0;
      break label52;
    }
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) && (a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int, 262144)))
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFragment == null) {
        throw new IllegalStateException("mEditVideoFragment is null");
      }
      return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFragment.a();
    }
    return 0;
  }
  
  public int a(@NonNull Message paramMessage)
  {
    o();
    if (this.jdField_b_of_type_Boolean)
    {
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "broadcast message ignore because of publishing", new Throwable());
      return 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((EditVideoPart)localIterator.next()).b(Message.obtain(paramMessage))) {
        break label101;
      }
      i += 1;
    }
    label101:
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
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      switch (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a())
      {
      default: 
        return l;
        if (((localObject instanceof EditTakePhotoSource)) || ((localObject instanceof EditLocalPhotoSource)) || ((localObject instanceof EditLocalGifSource)))
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
          throw new RuntimeException("异常逻辑, 没有处理的Source");
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
    Object localObject;
    long l2;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) && (a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int, 262144)))
    {
      localObject = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
      if (localObject != null)
      {
        l2 = ((EditVideoPlayerExport)localObject).a(paramInt);
        SLog.a("Q.qqstory.publish.edit.EditVideoPartManager", "getRealVideoTime %d by index %d", Long.valueOf(l2), Integer.valueOf(paramInt));
      }
    }
    for (;;)
    {
      long l1 = l2;
      if (l2 <= 0L)
      {
        localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        if (!(localObject instanceof EditRecordVideoSource)) {
          break label154;
        }
        l1 = ((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
        switch (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a())
        {
        default: 
          return l1;
          if (((localObject instanceof EditTakePhotoSource)) || ((localObject instanceof EditLocalPhotoSource)))
          {
            l1 = 5000L;
          }
          else if ((localObject instanceof EditLocalVideoSource))
          {
            localObject = (EditLocalVideoSource)localObject;
            l1 = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int - ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
            if (l1 == 0L) {
              l1 = ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
            }
          }
          else if ((localObject instanceof EditTakeVideoSource))
          {
            l1 = ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
          }
          else
          {
            throw new RuntimeException("异常逻辑, 没有处理的Source");
          }
          break;
        case 1: 
          return l1 / 2L;
        case 2: 
          return l1 * 2L;
        case 4: 
          return l1 * 4L;
        case 3: 
          label154:
          return ((float)l1 / 1.5F);
        }
      }
      l2 = 0L;
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
  
  protected SimpleObserver a()
  {
    return new aneg(this, SystemClock.uptimeMillis());
  }
  
  @Nullable
  public EditVideoPart.EditExport a(Class paramClass)
  {
    if (paramClass == null) {
      throw new IllegalArgumentException("editExportClass should not be null");
    }
    return (EditVideoPart.EditExport)this.jdField_a_of_type_JavaUtilMap.get(paramClass);
  }
  
  public String a()
  {
    int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.b();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 2, "save from get Mpath " + this.jdField_d_of_type_Int + " " + i + " " + this.jdField_a_of_type_JavaLangString);
    }
    if (i != this.jdField_d_of_type_Int)
    {
      this.jdField_d_of_type_Int = 0;
      this.jdField_a_of_type_JavaLangString = null;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString)
  {
    if ((paramString != null) && (paramString.length() >= PtvTemplateManager.jdField_a_of_type_JavaLangString.length())) {
      return ":" + paramString.substring(PtvTemplateManager.jdField_a_of_type_JavaLangString.length());
    }
    return "";
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
    switch (paramInt1)
    {
    }
    for (;;)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((EditVideoPart)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
      }
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    }
  }
  
  public final void a(int paramInt, Object paramObject)
  {
    o();
    A();
    if (this.jdField_b_of_type_Boolean)
    {
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "change state ignore because of publishing, %s", new Throwable());
      return;
    }
    if ((this.jdField_b_of_type_Int != paramInt) || (paramInt == 5) || (paramInt == 39))
    {
      if (this.jdField_a_of_type_Boolean) {
        SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "change state while state changing, " + paramInt + " oldState:" + this.jdField_b_of_type_Int, new Throwable());
      }
      this.jdField_a_of_type_Boolean = true;
      SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "changeState : %s => %s", Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(paramInt));
      int i = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = paramInt;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((EditVideoPart)localIterator.next()).a(i, this.jdField_b_of_type_Int, paramObject);
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a(paramLong);
    }
  }
  
  public void a(Context paramContext)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b() == 14) {
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
      if (a())
      {
        localObject = "2";
        label81:
        b("clk_publish", j, 0, new String[] { localObject, String.valueOf(l), String.valueOf(i), AppUtil.a(paramContext) });
        if (a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int, 262144))
        {
          i = e();
          if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) {
            break label224;
          }
        }
      }
      label224:
      for (paramContext = "0";; paramContext = "1")
      {
        b("pub_edit_more", 0, 0, new String[] { String.valueOf(i), paramContext });
        return;
        i = 2;
        break;
        if (!(localObject instanceof EditTakePhotoSource)) {
          break label231;
        }
        if (((EditTakePhotoSource)localObject).jdField_a_of_type_Int == 1)
        {
          i = 1;
          break;
        }
        i = 2;
        break;
        localObject = "1";
        break label81;
      }
      label231:
      i = 3;
    }
  }
  
  public void a(Intent paramIntent, int paramInt, PublishParam paramPublishParam)
  {
    JSONArray localJSONArray = null;
    paramPublishParam = localJSONArray;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null)
    {
      paramPublishParam = localJSONArray;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a() != null)
      {
        paramPublishParam = localJSONArray;
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().a() != null) {
          paramPublishParam = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().a().a;
        }
      }
    }
    localJSONArray = new JSONArray();
    if ((paramPublishParam != null) && (!paramPublishParam.isEmpty()))
    {
      paramPublishParam = paramPublishParam.iterator();
      while (paramPublishParam.hasNext())
      {
        TextLayer.TextItem localTextItem = (TextLayer.TextItem)paramPublishParam.next();
        if ((localTextItem.a != null) && (localTextItem.a.a() != null)) {
          localJSONArray.put(localTextItem.a.a().toString());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "EditPicActivity getPublishIntent, content is: " + localJSONArray.toString());
    }
    paramIntent.putExtra("dynamic_text", localJSONArray.toString());
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(-1, paramIntent, 2131034158, 0);
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
  
  protected void a(@NonNull EditVideoParams paramEditVideoParams)
  {
    SLog.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts %s", paramEditVideoParams);
    int i = paramEditVideoParams.jdField_b_of_type_Int;
    ArrayList localArrayList = new ArrayList();
    Object localObject = new EditVideoButton(this, i);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton = ((EditVideoButton)localObject);
    localArrayList.add(localObject);
    localObject = new EditProviderPart(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart = ((EditProviderPart)localObject);
    localArrayList.add(localObject);
    localObject = new EditCommonParam(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditCommonParam = ((EditCommonParam)localObject);
    localArrayList.add(localObject);
    if (paramEditVideoParams.a())
    {
      localObject = new EditPicRawImage(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage = ((EditPicRawImage)localObject);
      localArrayList.add(localObject);
      if (a(i, 2048))
      {
        localObject = new EditVideoGuide(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide = ((EditVideoGuide)localObject);
        localArrayList.add(localObject);
      }
      if (a(i, 4))
      {
        localObject = new EditVideoQimMusic(this);
        this.jdField_a_of_type_DovComQqImCaptureMusicEditVideoQimMusic = ((EditVideoQimMusic)localObject);
        localArrayList.add(localObject);
      }
      if ((paramEditVideoParams.b()) && (RecognitionManager.jdField_a_of_type_Boolean))
      {
        localObject = new EditRecognitionPart(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecognitionPart = ((EditRecognitionPart)localObject);
        localArrayList.add(localObject);
        if (a(i, 33554432)) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecognitionPart.jdField_a_of_type_Boolean = true;
        }
      }
      if (a(i, 1024))
      {
        localObject = new EditVideoAt(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoAt = ((EditVideoAt)localObject);
        localArrayList.add(localObject);
      }
      if ((a(i, 32)) || (a(i, 8)) || (a(i, 2)))
      {
        localObject = new EditVideoDoodle(this, i);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle = ((EditVideoDoodle)localObject);
        localArrayList.add(localObject);
        localObject = new EditVideoPoi(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPoi = ((EditVideoPoi)localObject);
        localArrayList.add(localObject);
        localObject = new EditVideoPoiSearch(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPoiSearch = ((EditVideoPoiSearch)localObject);
        localArrayList.add(localObject);
      }
      if (a(i, 256))
      {
        if (paramEditVideoParams.jdField_a_of_type_Int != 1) {
          break label1249;
        }
        localObject = new EditVideoSpeedFilter(this, a(i, 4194304));
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter = ((EditVideoFilter)localObject);
        localArrayList.add(localObject);
      }
      label441:
      if (a(i, 512))
      {
        localObject = new EditVideoLabel(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoLabel = ((EditVideoLabel)localObject);
        localArrayList.add(localObject);
      }
      if (((paramEditVideoParams.a()) || (paramEditVideoParams.e())) && (a(i, 128)))
      {
        localObject = new EditVideoArtFilter(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter = ((EditVideoArtFilter)localObject);
        localArrayList.add(localObject);
      }
      if ((paramEditVideoParams.a()) && (a(i, 64)))
      {
        localObject = new EditPicCropPart(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart = ((EditPicCropPart)localObject);
        localArrayList.add(localObject);
      }
      if (a(i, 8192))
      {
        if (!paramEditVideoParams.a()) {
          break label1320;
        }
        localObject = new EditPicSave(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicSave = ((EditPicSave)localObject);
        localArrayList.add(localObject);
      }
    }
    for (;;)
    {
      if (a(i, 16384))
      {
        localObject = new EditVideoSyncStoryGuide(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSyncStoryGuide = ((EditVideoSyncStoryGuide)localObject);
        localArrayList.add(localObject);
      }
      if (a(i, 32768))
      {
        localObject = new EditGifSpeedControl(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifSpeedControl = ((EditGifSpeedControl)localObject);
        localArrayList.add(localObject);
      }
      if (a(i, 131072))
      {
        localObject = new EditVideoPermission(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPermission = ((EditVideoPermission)localObject);
        localArrayList.add(localObject);
      }
      if (a(i, 1048576))
      {
        localObject = new EditVideoShareTo(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoShareTo = ((EditVideoShareTo)localObject);
        localArrayList.add(localObject);
      }
      if ((paramEditVideoParams.b()) && (a(i, 262144)))
      {
        localObject = new EditVideoFragment(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFragment = ((EditVideoFragment)localObject);
        localArrayList.add(localObject);
      }
      if (a(i, 16777216))
      {
        localObject = new EditVideoShareGroup(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoShareGroup = ((EditVideoShareGroup)localObject);
        localArrayList.add(localObject);
      }
      if (a(i, 134217728))
      {
        localObject = new EditVideoTag(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoTag = ((EditVideoTag)localObject);
        localArrayList.add(localObject);
      }
      if (a(i, 536870912))
      {
        localObject = new EditVideoVote(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote = ((EditVideoVote)localObject);
        localArrayList.add(localObject);
        localObject = new EditVideoInteract(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractEditVideoInteract = ((EditVideoInteract)localObject);
        localArrayList.add(localObject);
        localObject = new EditVideoInteractPaster(this, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractEditVideoInteract);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoInteractPaster = ((EditVideoInteractPaster)localObject);
        localArrayList.add(localObject);
      }
      if ((paramEditVideoParams.jdField_a_of_type_Int == 1) && (a(paramEditVideoParams.jdField_b_of_type_Int, 131072))) {
        localArrayList.add(new EditSyncQzonePart(this));
      }
      if (a(i, 268435456))
      {
        paramEditVideoParams = new EditVideoMultiSegment(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMultiSegment = paramEditVideoParams;
        localArrayList.add(paramEditVideoParams);
      }
      a(localArrayList);
      this.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(localArrayList);
      SLog.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      paramEditVideoParams = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramEditVideoParams.hasNext()) {
        SLog.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts : %s", ((EditVideoPart)paramEditVideoParams.next()).getClass().getSimpleName());
      }
      if (paramEditVideoParams.e())
      {
        localObject = new EditGifImage(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage = ((EditGifImage)localObject);
        localArrayList.add(localObject);
        break;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer = new HWEditLocalVideoPlayer(this);
      if (paramEditVideoParams.d())
      {
        if (Build.VERSION.SDK_INT < 14) {
          break;
        }
        if (paramEditVideoParams.h())
        {
          localArrayList.add(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer);
          break;
        }
        localArrayList.add(new HWEditImportVideoPlayer(this));
        break;
      }
      if (paramEditVideoParams.h())
      {
        localArrayList.add(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer);
        break;
      }
      localObject = new EditVideoPlayer(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPlayer = ((EditVideoPlayer)localObject);
      localArrayList.add(localObject);
      break;
      label1249:
      if (paramEditVideoParams.jdField_a_of_type_Int == 2)
      {
        localObject = new EditVideoSpeedFilter(this, a(i, 4194304));
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter = ((EditVideoFilter)localObject);
        localArrayList.add(localObject);
        break label441;
      }
      localObject = new EditVideoFilter(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter = ((EditVideoFilter)localObject);
      localArrayList.add(localObject);
      break label441;
      label1320:
      localObject = new EditVideoSave(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave = ((EditVideoSave)localObject);
      localArrayList.add(localObject);
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
  
  public void a(Class paramClass, EditVideoPart.EditExport paramEditExport)
  {
    o();
    A();
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
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.f();
      QQToast.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), "发表失败，请重试", 0).a();
      paramError = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
    } while (paramError == null);
    paramError.m();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_d_of_type_Int = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.b();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 2, "save from set Mpath " + this.jdField_d_of_type_Int + " " + paramString);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 1) {
      Bosses.get().postJob(new aned(this, paramString, paramInt1, paramInt2, paramVarArgs));
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {}
  
  public void a(List paramList) {}
  
  public void a(Map paramMap)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a(paramMap);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 0;
    o();
    A();
    Object localObject;
    EditVideoParams.EditSource localEditSource;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      localObject = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
      if (localObject != null) {
        ((EditVideoPlayerExport)localObject).l();
      }
      localEditSource = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "onConfirmClick : %s", new Object[] { localEditSource });
      localObject = null;
      if ((!this.jdField_e_of_type_Boolean) || (!paramBoolean)) {
        break label152;
      }
      if ((!(localEditSource instanceof EditRecordVideoSource)) && (!(localEditSource instanceof EditLocalVideoSource)) && (!(localEditSource instanceof EditTakeVideoSource))) {
        break label160;
      }
      b(localEditSource, (Observer)localObject);
      if ((localEditSource instanceof EditLocalVideoSource)) {
        StoryReportor.a("video_edit", "pub_local", 0, 0, new String[] { "1" });
      }
    }
    label152:
    label160:
    do
    {
      return;
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "requestPublish duplicate");
      return;
      localObject = a();
      break;
      if (((localEditSource instanceof EditLocalPhotoSource)) || ((localEditSource instanceof EditTakePhotoSource)))
      {
        a();
        CodecParam.y = 5000;
        CodecParam.z = 125;
        CodecParam.x = 0;
        CodecParam.E = 0;
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
        for (i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();; i = 0)
        {
          CodecParam.J = i;
          c(localEditSource, (Observer)localObject);
          StoryReportor.a("video_edit", "pub_local", 0, 0, new String[0]);
          return;
        }
      }
    } while (!(localEditSource instanceof EditLocalGifSource));
    CodecParam.y = 5000;
    CodecParam.z = 125;
    CodecParam.x = 0;
    CodecParam.E = 0;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {
      i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();
    }
    CodecParam.J = i;
    a(localEditSource, (Observer)localObject);
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
    A();
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a();
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_b_of_type_Int == paramInt;
  }
  
  public int b()
  {
    switch (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int)
    {
    default: 
      return 999;
    case 1: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 4: 
      return 4;
    }
    return 5;
  }
  
  public void b()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(0, null, 2131034158, 0);
  }
  
  public void b(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 2, "setFrom " + this.jdField_e_of_type_Int);
    }
  }
  
  public void b(Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).b(paramBundle);
    }
    paramBundle.putInt("mEditState", this.jdField_b_of_type_Int);
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
  
  public void b(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    Bosses.get().postJob(new anee(this, paramString, paramInt1, paramInt2, paramVarArgs));
  }
  
  public void b(boolean paramBoolean)
  {
    int j = 0;
    int k = 0;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null)
    {
      Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a();
      if (localObject != null) {
        ((DoodleLayout)localObject).f();
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
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a("请稍候", false, 500L);
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.jdField_a_of_type_Int = 2;
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().k();
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
      c(paramBoolean);
    }
  }
  
  public boolean b()
  {
    o();
    A();
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d();
  }
  
  public boolean b(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide.jdField_b_of_type_Int == paramInt) {
        bool1 = true;
      }
    }
    return bool1;
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
  
  public void c()
  {
    o();
    A();
    String str;
    if (a())
    {
      str = "2";
      a("clk_left", 0, 0, new String[] { str });
      VideoEditReport.a("0X80076B6");
      VideoEditReport.b("0X80075C2");
      VideoEditReport.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X8007823");
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle == null) {
        break label335;
      }
    }
    label304:
    label335:
    for (int j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.b();; j = 0)
    {
      int i = j;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoLabel != null)
      {
        i = j;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoLabel.a())) {
          i = j + 1;
        }
      }
      if (this.jdField_a_of_type_DovComQqImCaptureMusicEditVideoQimMusic != null) {}
      j = i;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart != null) {
        j = i + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart.jdField_a_of_type_Int;
      }
      i = j;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter != null)
      {
        i = j;
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.b()) {
          i = j + 4;
        }
      }
      SLog.a("Q.qqstory.publish.edit.EditVideoPartManager", "tryQuitRecordUI, current is preview state, edit count = %d", Integer.valueOf(i));
      if (i < 3)
      {
        b();
        return;
        str = "1";
        break;
      }
      if (a())
      {
        str = "2";
        a("clk_left_float", 0, 0, new String[] { str });
        VideoEditReport.a("0X80076B7");
        VideoEditReport.b("0X80075C3");
        if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()) {
          break label304;
        }
        str = "放弃本次图片编辑？";
      }
      for (;;)
      {
        ActionSheet localActionSheet = ActionSheet.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), false);
        localActionSheet.a(str);
        localActionSheet.a("放弃", 3);
        localActionSheet.d("取消");
        localActionSheet.a(new anec(this, localActionSheet));
        localActionSheet.show();
        return;
        str = "1";
        break;
        if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e()) || (this.jdField_d_of_type_Boolean)) {
          str = "放弃本次图片编辑？";
        } else {
          str = "放弃本次视频编辑？";
        }
      }
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton.c(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a());
    a(paramBoolean);
    Activity localActivity = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
    if ((localActivity instanceof EditPicActivity)) {}
    switch (localActivity.getIntent().getIntExtra("editpic_cameratype", -1))
    {
    default: 
      return;
    case 1: 
      BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putLong("sv_latest_taken_photo_time", -1L).commit();
      NewFlowCameraReporter.g();
      return;
    case 2: 
      NewFlowCameraReporter.h();
      return;
    }
    NewFlowCameraReporter.i();
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPoiSearch != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPoiSearch.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPoiSearch });
      return true;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPoi != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPoi.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPoi });
      return true;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoTag != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoTag.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoTag });
      return true;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote });
      return true;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractEditVideoInteract != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractEditVideoInteract.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractEditVideoInteract });
      return true;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoInteractPaster != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoInteractPaster.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoInteractPaster });
      return true;
    }
    if ((this.jdField_a_of_type_DovComQqImCaptureMusicEditVideoQimMusic != null) && (this.jdField_a_of_type_DovComQqImCaptureMusicEditVideoQimMusic.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_DovComQqImCaptureMusicEditVideoQimMusic });
      return true;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoLabel != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoLabel.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoLabel });
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
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter });
      return true;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifSpeedControl != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifSpeedControl.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifSpeedControl });
      return true;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton.a()))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton });
      return true;
    }
    c();
    return true;
  }
  
  public int d()
  {
    int i = 0;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null) {
      i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a(a());
    }
    int j = i;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter != null)
    {
      j = i;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.b()) {
        j = i + 1;
      }
    }
    return j;
  }
  
  public void d()
  {
    boolean bool2 = false;
    int j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a();
    int k = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_web_video_id", 0);
    int m = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("type", 0);
    if ((j == 101) || (j == 1)) {}
    for (int i = 1;; i = 0)
    {
      boolean bool1;
      if (i == 0)
      {
        bool1 = bool2;
        if (k == 0)
        {
          bool1 = bool2;
          if (j == 6)
          {
            bool1 = bool2;
            if (m != 2) {}
          }
        }
      }
      else
      {
        bool1 = true;
      }
      b(bool1);
      return;
    }
  }
  
  void d(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    for (;;)
    {
      try
      {
        if (!this.jdField_d_of_type_Boolean) {
          continue;
        }
        i = 3;
        VideoSourceHelper.nativeSetPlayStepFrameCount(i);
        if (!this.jdField_d_of_type_Boolean) {
          continue;
        }
        i = 2;
        VideoSourceHelper.nativeSetPlayGapFrameCount(i);
      }
      catch (Throwable localThrowable)
      {
        int i;
        QLog.w("Q.qqstory.publish.edit.EditVideoPartManager", 1, "VideoSourceHelper error:", localThrowable);
        continue;
        VideoSourceHelper.nativeSetPlayAFMute(this.jdField_d_of_type_Boolean);
      }
      if (this.jdField_a_of_type_DovComQqImCaptureMusicEditVideoQimMusic == null) {
        continue;
      }
      return;
      i = 1;
      continue;
      i = 1;
    }
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFragment != null)
    {
      List localList = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFragment.a();
      if (localList != null) {
        return localList.size();
      }
    }
    return 1;
  }
  
  public void e()
  {
    boolean bool2 = false;
    int j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a();
    int k = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_web_video_id", 0);
    int m = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("type", 0);
    if ((j == 101) || (j == 1)) {}
    for (int i = 1;; i = 0)
    {
      boolean bool1;
      if (i == 0)
      {
        bool1 = bool2;
        if (k == 0)
        {
          bool1 = bool2;
          if (j == 6)
          {
            bool1 = bool2;
            if (m != 2) {}
          }
        }
      }
      else
      {
        bool1 = true;
      }
      c(bool1);
      return;
    }
  }
  
  public int f()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide.jdField_a_of_type_Int == 2)) {
      a(10);
    }
  }
  
  public void g()
  {
    o();
    A();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).au_();
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi = null;
  }
  
  public void i()
  {
    Object localObject = ((BaseActivity)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity()).app;
    o();
    A();
    this.c = true;
    this.jdField_a_of_type_AndroidOsBundle = EditState.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent());
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((EditVideoPart)((Iterator)localObject).next()).a();
    }
    if (a()) {}
    for (localObject = "2";; localObject = "1")
    {
      a("exp_edit", 0, 0, new String[] { localObject });
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoShareTo != null) {
        StoryReportor.a("story_grp", "exp_share_grp", 0, 0, new String[] { "", "", "", "" });
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("WebSceneType", -999);
      return;
    }
  }
  
  public boolean isValidate()
  {
    return this.c;
  }
  
  public void j()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).az_();
    }
  }
  
  public void k()
  {
    if (this.jdField_b_of_type_Int == -1) {
      a(0);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).aC_();
    }
  }
  
  public void l()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).aD_();
    }
  }
  
  public void m()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).av_();
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((EditVideoPart)localIterator.next()).h();
      }
      h();
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.h();
    }
    VideoFilterTools.a().a();
    this.c = false;
  }
  
  public void o()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException("can not access by non-ui thread");
    }
  }
  
  void p()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().g();
    a(19);
  }
  
  void q()
  {
    DoodleLayout localDoodleLayout = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a();
    if (localDoodleLayout != null) {
      localDoodleLayout.a.d();
    }
  }
  
  void r()
  {
    int j = 0;
    Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart;
    ((EditPicCropPart)localObject).jdField_a_of_type_Int += d();
    if (this.jdField_b_of_type_Int == 11) {
      a(0);
    }
    int i;
    do
    {
      return;
      localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a();
      ((DoodleLayout)localObject).e();
      LineLayer localLineLayer = ((DoodleLayout)localObject).a();
      i = j;
      if (localLineLayer != null)
      {
        i = j;
        if (localLineLayer.a.a())
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a("请稍候", false, 500L);
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.jdField_a_of_type_Int = 3;
          ((DoodleLayout)localObject).k();
          i = 1;
        }
      }
    } while (i != 0);
    s();
  }
  
  public void s()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.f();
    Object localObject3 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a();
    Object localObject1 = ((DoodleLayout)localObject3).a(0);
    Object localObject2 = ((DoodleLayout)localObject3).b(0);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart.jdField_a_of_type_ArrayOfInt[0] = localObject1[0];
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart.jdField_a_of_type_ArrayOfInt[1] = localObject1[1];
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart.jdField_a_of_type_ArrayOfInt[2] = localObject2[0];
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart.jdField_a_of_type_ArrayOfInt[3] = localObject2[1];
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart.jdField_a_of_type_ArrayOfInt[4] = ((DoodleLayout)localObject3).a().b();
    localObject2 = a();
    if (localObject2 == null) {
      return;
    }
    localObject1 = localObject2;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 1)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b() != 8)
      {
        localObject3 = ((DoodleLayout)localObject3).a();
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          long l = SystemClock.uptimeMillis();
          localObject1 = BitmapUtils.b((Bitmap)localObject2, (Bitmap)localObject3);
          SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "onCropBtnPressed merge ： cost " + (SystemClock.uptimeMillis() - l));
        }
      }
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
    a(11);
  }
  
  void t()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter == null) {
      return;
    }
    a(0);
    a(12);
  }
  
  void u()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().h();
    }
  }
  
  public void v()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().o();
    }
  }
  
  public void w()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.d();
      x();
    }
    a(0);
  }
  
  public void x()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter != null) {
      ThreadManager.post(new anej(this), 5, null, true);
    }
  }
  
  public void y()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).i();
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
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.o();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager
 * JD-Core Version:    0.7.0.1
 */