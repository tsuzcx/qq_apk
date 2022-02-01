package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.image.NativeVideoImage;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import dov.com.tencent.biz.qqstory.takevideo.bitmap.BitmapAdjustJobSegment;
import dov.com.tencent.biz.qqstory.takevideo.bitmap.BlurJobSegment;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr;
import dov.com.tencent.mobileqq.shortvideo.common.GloableValue;
import dov.com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import dov.com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import dov.com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.IMPFrameListener;
import dov.com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.IMPlayerEndListener;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

public class EditVideoPlayer
  extends EditVideoPart
  implements EditVideoPlayerExport, MultiBlockVideoPlayer.VideoLoadListener, ImageViewVideoPlayer.IMPFrameListener, ImageViewVideoPlayer.IMPlayerEndListener
{
  protected float a;
  public long a;
  protected Handler a;
  protected ImageView a;
  protected EditRecordVideoSource a;
  protected ImageViewVideoPlayer a;
  protected List<MultiBlockVideoPlayer.RecordVideoBlockInfo> a;
  protected boolean a;
  protected Handler b;
  protected boolean b;
  
  public EditVideoPlayer(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Float = 0.2F;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper());
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    float f = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.d * 1.0F / this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_c_of_type_Int;
    SLog.c("Q.qqstory.record.EditVideoPlayer", "updateVideoDrawablePlayerUI width" + paramInt1 + "heightRatio=" + f + "dst_height" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.d + "dst_width=" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_c_of_type_Int);
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(paramInt1, paramInt2, f, false, ScreenUtil.a(5.0F));
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Int == 3)
    {
      SLog.b("Q.qqstory.record.EditVideoPlayer", "pausePreview");
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.c();
      EditMusicExport localEditMusicExport = (EditMusicExport)a(EditMusicExport.class);
      if (localEditMusicExport != null) {
        localEditMusicExport.c();
      }
      return;
    }
    SLog.d("Q.qqstory.record.EditVideoPlayer", "pausePreview but the player has not started : " + this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Int);
  }
  
  private void o()
  {
    if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Int == 4))
    {
      SLog.b("Q.qqstory.record.EditVideoPlayer", "restartPreview");
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.b();
      EditMusicExport localEditMusicExport = (EditMusicExport)a(EditMusicExport.class);
      if (localEditMusicExport != null) {
        localEditMusicExport.d();
      }
      return;
    }
    SLog.d("Q.qqstory.record.EditVideoPlayer", "restartPreview but the player is not stopping : " + this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Int);
  }
  
  private void p()
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 8));
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new EditVideoPlayer.2(this));
  }
  
  public Bitmap a(int paramInt)
  {
    if ((!this.jdField_a_of_type_Boolean) && (QLog.isColorLevel())) {
      QLog.d("Q.qqstory.record.EditVideoPlayer", 2, "generateVideoFrameBitmap enableMultiVideoFragment:" + this.jdField_a_of_type_Boolean);
    }
    if (Looper.myLooper() == this.jdField_a_of_type_AndroidOsHandler.getLooper())
    {
      localObject = this.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (paramInt < ((List)localObject).size())) {}
      for (localObject = (MultiBlockVideoPlayer.RecordVideoBlockInfo)((List)localObject).get(paramInt); localObject == null; localObject = null) {
        return null;
      }
      return a((MultiBlockVideoPlayer.RecordVideoBlockInfo)localObject);
    }
    Object localObject = new Bitmap[1];
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoPlayer.3(this, paramInt, (Bitmap[])localObject, localCountDownLatch));
    try
    {
      SLog.b("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap waiting ...");
      localCountDownLatch.await();
      SLog.a("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap done bitmap = %s", localObject[0]);
      return localObject[0];
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        SLog.c("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap error", localInterruptedException);
      }
    }
  }
  
  protected Bitmap a(@NonNull MultiBlockVideoPlayer.RecordVideoBlockInfo paramRecordVideoBlockInfo)
  {
    Bitmap localBitmap = null;
    Object localObject = (EditFilterExport)a(EditFilterExport.class);
    int j;
    int i;
    if (localObject != null)
    {
      j = ((EditFilterExport)localObject).a(paramRecordVideoBlockInfo.jdField_c_of_type_Int);
      i = ((EditFilterExport)localObject).a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a());
      SLog.a("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap for %d, playModeNeeded = %d, currentPlayMode = %d", Integer.valueOf(paramRecordVideoBlockInfo.jdField_c_of_type_Int), Integer.valueOf(j), Integer.valueOf(i));
    }
    for (;;)
    {
      localObject = (EditDoodleExport)a(EditDoodleExport.class);
      int k;
      byte[] arrayOfByte;
      if (localObject != null)
      {
        k = ((EditDoodleExport)localObject).a();
        arrayOfByte = ((EditDoodleExport)localObject).a(paramRecordVideoBlockInfo.jdField_c_of_type_Int);
      }
      for (localObject = ((EditDoodleExport)localObject).a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a());; localObject = null)
      {
        if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer)) {}
        try
        {
          VideoSourceHelper.nativeSetPlayMode(j);
          VideoSourceHelper.nativeSetMosaic(k, arrayOfByte);
          SLog.a("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap, playMode=%d, info=%s", Integer.valueOf(j), paramRecordVideoBlockInfo);
          if (j == 1)
          {
            localBitmap = ((MultiBlockVideoPlayer)this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(paramRecordVideoBlockInfo.b - 1L, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.a(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.b());
            return localBitmap;
          }
          paramRecordVideoBlockInfo = ((MultiBlockVideoPlayer)this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(paramRecordVideoBlockInfo.jdField_a_of_type_Long, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.a(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.b());
          return paramRecordVideoBlockInfo;
        }
        finally
        {
          VideoSourceHelper.nativeSetPlayMode(i);
          VideoSourceHelper.nativeSetMosaic(k, (byte[])localObject);
        }
        arrayOfByte = null;
        k = 0;
      }
      i = 0;
      j = 0;
    }
  }
  
  public void a()
  {
    GloableValue.a();
    a(0, null);
    a(false);
    b(0);
    MultiBlockVideoPlayer.a();
    SLog.d("Q.qqstory.record.EditVideoPlayer", "recordMultiVideoFragment = %s, supportMultiVideoFragment = %s", new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
    this.jdField_a_of_type_Boolean = false;
    Object localObject;
    label257:
    String str2;
    String str1;
    boolean bool;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource = ((EditRecordVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer = ((ImageViewVideoPlayer)a(2131367175));
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131367205));
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setCyclePlay(true);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPlayerEndListener(this);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPFrameListener(this);
      if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer))) {
        ((MultiBlockVideoPlayer)this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).setVideoLoadListener(this);
      }
      a(TakeVideoUtils.a(a()), TakeVideoUtils.b(a()));
      localObject = RMVideoStateMgr.a().a.a();
      if (localObject == null) {
        break label439;
      }
      SLog.c("Q.qqstory.record.EditVideoPlayer", "get player cover success.");
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setVisibility(8);
      if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
        break label450;
      }
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setNeedPlayAudio(false);
      if (TextUtils.isEmpty(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_JavaLangString)) {
        break label513;
      }
      SLog.d("Q.qqstory.record.EditVideoPlayer", "onCreate init play");
      str2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_JavaLangString;
      localObject = null;
      str1 = null;
      Bundle localBundle = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle;
      if (localBundle == null) {
        break label527;
      }
      bool = localBundle.getBoolean("SecurityChecked", false);
      if (!bool) {
        break label524;
      }
      localObject = localBundle.getString("AFPath");
      str1 = localBundle.getString("VFPath");
    }
    for (;;)
    {
      if (bool)
      {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(CodecParam.RECORD_MAX_TIME, (int)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_Long, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_Int, str2, (String)localObject, str1);
        label374:
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_b_of_type_Boolean = false;
        SLog.d("Q.qqstory.record.EditVideoPlayer", "onCreate init player, securityChecked=%s, afFilePath=%s, vfFilePath=%s", new Object[] { Boolean.valueOf(bool), localObject, str1 });
      }
      for (;;)
      {
        a(EditVideoPlayerExport.class, this);
        return;
        SLog.d("Q.qqstory.record.EditVideoPlayer", "edit source type mismatch !");
        a().a(0, null, 0, 0);
        return;
        label439:
        SLog.e("Q.qqstory.record.EditVideoPlayer", "get player cover return null!");
        break;
        label450:
        VideoEditReport.jdField_a_of_type_Long = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent().getLongExtra("stop_record_time", 0L);
        VideoEditReport.b = System.currentTimeMillis();
        break label257;
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(CodecParam.RECORD_MAX_TIME, (int)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_Long, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_Int, str2, false);
        break label374;
        label513:
        SLog.d("Q.qqstory.record.EditVideoPlayer", "onCreate init player failed !");
      }
      label524:
      continue;
      label527:
      bool = false;
    }
  }
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    Object localObject;
    long l2;
    long l1;
    if ((paramInt == 1) && (this.jdField_a_of_type_Long == 0L) && (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      localObject = QQStoryContext.a().a();
      VideoEditReport.a(this.jdField_a_of_type_Long, (String)localObject);
      SLog.b("Q.qqstory.record.EditVideoPlayer", "onCurrentFrame:" + paramInt + ", mPreivewContentTime:" + this.jdField_a_of_type_Long);
      if (0L != 0L) {
        break label229;
      }
      localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle;
      if (localObject == null) {
        break label229;
      }
      l2 = ((Bundle)localObject).getLong("startEditVideoTime", 0L);
      l1 = SystemClock.uptimeMillis();
    }
    for (;;)
    {
      long l4 = l1;
      long l3 = l2;
      if (l2 == 0L)
      {
        localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
        l4 = l1;
        l3 = l2;
        if (localObject != null)
        {
          l3 = ((Activity)localObject).getIntent().getLongExtra("stop_record_time", 0L);
          l4 = System.currentTimeMillis();
        }
      }
      if (l3 != 0L) {
        StoryReportor.b("video_edit", "startEditVideoTime", this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b(), 0, new String[] { String.valueOf(l4 - l3) });
      }
      return;
      label229:
      l1 = 0L;
      l2 = 0L;
    }
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat)
  {
    VideoSourceHelper.nativeSetSlideMode(paramInt2, paramFloat);
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    if (!this.jdField_a_of_type_Boolean) {
      paramGenerateContext.a.hasFragments = false;
    }
    for (;;)
    {
      return;
      Object localObject1 = this.jdField_a_of_type_JavaUtilList;
      if ((localObject1 == null) || (((List)localObject1).size() <= 0))
      {
        paramGenerateContext.a.hasFragments = false;
        return;
      }
      paramGenerateContext.a.hasFragments = false;
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (MultiBlockVideoPlayer.RecordVideoBlockInfo)((Iterator)localObject2).next();
        if (localObject1 == null)
        {
          SLog.e("Q.qqstory.record.EditVideoPlayer", "editVideoPrePublish error. RecordVideoBlockInfo is null.");
        }
        else if (((MultiBlockVideoPlayer.RecordVideoBlockInfo)localObject1).jdField_c_of_type_Int == paramInt)
        {
          paramGenerateContext.a.hasFragments = true;
          localObject2 = new JSONObject();
        }
      }
      try
      {
        ((JSONObject)localObject2).put("vfFrameIndexStart", ((MultiBlockVideoPlayer.RecordVideoBlockInfo)localObject1).jdField_a_of_type_Long);
        ((JSONObject)localObject2).put("vfFrameIndexEnd", ((MultiBlockVideoPlayer.RecordVideoBlockInfo)localObject1).b);
        ((JSONObject)localObject2).put("afTimeStart", ((MultiBlockVideoPlayer.RecordVideoBlockInfo)localObject1).jdField_c_of_type_Long);
        ((JSONObject)localObject2).put("afTimeEnd", ((MultiBlockVideoPlayer.RecordVideoBlockInfo)localObject1).d);
        paramGenerateContext.a.fragments = ((JSONObject)localObject2).toString();
        SLog.b("Q.qqstory.record.EditVideoPlayer", "fragments = %s.", paramGenerateContext.a.fragments);
        SLog.b("Q.qqstory.record.EditVideoPlayer", "editVideoPrePublish : %s", paramGenerateContext.a.fragments);
        if (paramGenerateContext.a.hasFragments) {
          continue;
        }
        SLog.e("Q.qqstory.record.EditVideoPlayer", "editVideoPrePublish, can not find RecordVideoBlockInfo with fragment index %d", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    o();
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoPlayer.4(this, paramInt, paramArrayOfByte));
  }
  
  public void a(Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer)) {
      ((MultiBlockVideoPlayer)this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(paramBitmap);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void a(TransferData paramTransferData) {}
  
  public void a(boolean paramBoolean)
  {
    SLog.a("Q.qqstory.record.EditVideoPlayer", "setPlayMute mute = %s", Boolean.valueOf(paramBoolean));
    VideoSourceHelper.nativeSetPlayAFMute(paramBoolean);
  }
  
  protected boolean a(Message paramMessage)
  {
    if (paramMessage.what == 3)
    {
      switch (paramMessage.arg1)
      {
      }
      for (;;)
      {
        return true;
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.b();
        continue;
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.c();
        continue;
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.d();
      }
    }
    return false;
  }
  
  public void aK_()
  {
    b(false);
  }
  
  public void aM_()
  {
    super.aM_();
    SLog.d("Q.qqstory.record.EditVideoPlayer", "onPause stop play");
    b(false);
    NativeVideoImage.pauseAll();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoPlayer.5(this, paramInt));
  }
  
  public void c()
  {
    SLog.e("Q.qqstory.record.EditVideoPlayer", "onPlayerEnd");
  }
  
  public void d()
  {
    EditMusicExport localEditMusicExport = (EditMusicExport)a(EditMusicExport.class);
    if (localEditMusicExport != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "onPlayerRecyle2()");
      }
      localEditMusicExport.b();
    }
  }
  
  public void f()
  {
    super.f();
    NativeVideoImage.resumeAll();
    switch (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_Int)
    {
    default: 
      o();
    }
  }
  
  public void g()
  {
    super.g();
    SLog.d("Q.qqstory.record.EditVideoPlayer", "onDestroy release play");
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.c();
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.e();
    GloableValue.b();
    MultiBlockVideoPlayer.a();
  }
  
  public void h()
  {
    super.h();
    SLog.d("Q.qqstory.record.EditVideoPlayer", "onStop stop play");
    b(false);
  }
  
  public void i()
  {
    SLog.b("Q.qqstory.record.EditVideoPlayer", "onDrawLastFrameEnd : mBlurLastFrame = " + this.jdField_b_of_type_Boolean);
    Bitmap localBitmap2 = this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_AndroidGraphicsBitmap;
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a();
    }
    if (localBitmap1 != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
      if (this.jdField_b_of_type_Boolean) {
        Stream.of(localBitmap1).map(new ThreadOffFunction("Q.qqstory.record.EditVideoPlayer", 2)).map(new BitmapAdjustJobSegment(0.2F, false)).map(new BlurJobSegment(10)).map(new UIThreadOffFunction(this)).subscribe(new EditVideoPlayer.1(this));
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_Boolean) && (MultiBlockVideoPlayer.class.isInstance(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer))) {
      this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoPlayer.6(this));
    }
  }
  
  public void m()
  {
    o();
  }
  
  public void n() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer
 * JD-Core Version:    0.7.0.1
 */