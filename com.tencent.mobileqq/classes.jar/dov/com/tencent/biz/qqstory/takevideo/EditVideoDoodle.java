package dov.com.tencent.biz.qqstory.takevideo;

import ancq;
import ancr;
import ancs;
import anct;
import ancu;
import ancv;
import ancw;
import ancx;
import ancy;
import ancz;
import anda;
import andb;
import andc;
import andd;
import ande;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import android.view.animation.Animation;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestCallback;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestSession;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.utils.LocationUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeGifImage;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.util.Pair;
import com.tribe.async.async.JobSegment;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.humrecognition.view.BgmRecognitionProviderView;
import dov.com.qq.im.capture.paster.PasterDataManager;
import dov.com.qq.im.capture.util.DoodleLayoutConnector;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.POIPostersRequestCallback;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.DoodleBtnOperationHelper;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.DoodleEventListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage;
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
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EditVideoDoodle
  extends EditVideoPart
  implements LbsManager.POIListRequestCallback, IEventReceiver, EditDoodleExport, DoodleLayout.DoodleBtnOperationHelper, DoodleLayout.DoodleEventListener, Publishable
{
  public static final String a;
  public static String b;
  public int a;
  private long jdField_a_of_type_Long;
  andb jdField_a_of_type_Andb;
  andc jdField_a_of_type_Andc;
  andd jdField_a_of_type_Andd;
  private final ande jdField_a_of_type_Ande = new ande(null);
  public Handler a;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  public ProviderViewEditContainer a;
  private EditVideoPoiPickerCallback jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPoiPickerCallback = new ancq(this);
  public DoodleEmojiManager.POIPostersRequestCallback a;
  public DoodleLayout a;
  protected LocationFacePackage a;
  PtvTemplateManager.DoodleInfoLoadObserver jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfoLoadObserver = new anct(this);
  public Runnable a;
  public boolean a;
  protected byte[] a;
  private final int b;
  public boolean b;
  protected boolean c;
  private boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = QQStoryConstant.c;
    jdField_b_of_type_JavaLangString = "EditVideoDoodle";
  }
  
  public EditVideoDoodle(@NonNull EditVideoPartManager paramEditVideoPartManager, int paramInt)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRunnable = new ancy(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiManager$POIPostersRequestCallback = new ancz(this);
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
        j();
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
  
  private int c()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b())
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
        return 3;
      }
      return 4;
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
      return 1;
    }
    return 2;
  }
  
  private void j()
  {
    int j = 0;
    Object localObject1;
    int i;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null)
    {
      SLog.b("Q.qqstory.publish.edit.StoryDoodle", "makeSureInitLayout");
      localObject1 = this.jdField_a_of_type_AndroidViewViewStub.getParent();
      if ((localObject1 == null) || (!(localObject1 instanceof ViewGroup))) {
        break label774;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());
      if (!EditVideoPartManager.a(this.jdField_b_of_type_Int, 8)) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.l();
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setupPersonality();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(720, 1280);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setMosaicSize(16);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setMosaicStandardSize(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b());
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleEventListener(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBtnOperationHelper(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditVideoParams(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditVideoDoodle(this);
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
      DoodleLayoutConnector.a().a(c(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout);
      localObject1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView;
      if (localObject1 != null)
      {
        ((DoodleEditView)localObject1).setFrom(1);
        ((DoodleEditView)localObject1).a(EditVideoPartManager.a(this.jdField_b_of_type_Int, 268435456));
      }
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer == null)
      {
        ((ViewStub)a(2131364335)).inflate();
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer = ((ProviderViewEditContainer)a(2131368930));
        i = c();
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(i);
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setProviderViewListener(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart);
        if (localObject1 != null)
        {
          this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setVideoSegmentPickerListener(new ancu(this));
          this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setStickerListener(((DoodleEditView)localObject1).a());
          ((DoodleEditView)localObject1).setDoodleEditViewListener(new ancv(this));
        }
        localObject1 = (BgmRecognitionProviderView)this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(110);
        if (localObject1 != null) {
          ((BgmRecognitionProviderView)localObject1).setRecognitionPart(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecognitionPart);
        }
        a(2131368929).setOnTouchListener(new ancw(this));
      }
      a().b(null);
      if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.f() == 2) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.f() == 3)) && (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.g()))
      {
        if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) {
          break label866;
        }
        if (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)) {
          break label791;
        }
        j = ((EditLocalPhotoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).a.latitude;
        i = ((EditLocalPhotoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).a.longitude;
      }
    }
    for (;;)
    {
      label657:
      if ((j != 0) && (i != 0))
      {
        localObject1 = new BasicLocation(j, i);
        ((LbsManager)SuperManager.a(9)).a((BasicLocation)localObject1, null, this);
      }
      for (;;)
      {
        localObject1 = Dispatchers.get();
        Object localObject2 = new andc(this);
        this.jdField_a_of_type_Andc = ((andc)localObject2);
        ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
        localObject1 = Dispatchers.get();
        localObject2 = new andb(this);
        this.jdField_a_of_type_Andb = ((andb)localObject2);
        ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
        localObject1 = Dispatchers.get();
        localObject2 = new andd(this);
        this.jdField_a_of_type_Andd = ((andd)localObject2);
        ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
        return;
        label774:
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)a(2131362953));
        break;
        label791:
        if (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) {
          break label866;
        }
        j = ((EditLocalVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).a.latitude;
        i = ((EditLocalVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).a.longitude;
        break label657;
        SosoInterface.a(new ancx(this, "EditVideoDoodle"));
      }
      label866:
      i = 0;
    }
  }
  
  private void s()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
    ((DoodleEmojiManager)SuperManager.a(36)).a(LocationUtils.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiManager$POIPostersRequestCallback);
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
  
  public JobSegment a(int paramInt)
  {
    if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))) {
      return (JobSegment)StoryApi.a(HWEncodeGenerateDoodleImageSegment.class, new Object[] { this, (EditFilterExport)a(EditFilterExport.class), Integer.valueOf(paramInt) });
    }
    return (JobSegment)StoryApi.a(GenerateDoodleImageSegment.class, new Object[] { this, (EditFilterExport)a(EditFilterExport.class), Integer.valueOf(paramInt) });
  }
  
  @NonNull
  public DoodleLayout a()
  {
    j();
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
  }
  
  public void a()
  {
    a(jdField_a_of_type_JavaLangString);
    QQStoryContext.a();
    Object localObject1 = QQStoryContext.a();
    PtvTemplateManager.a((AppInterface)localObject1).a((AppInterface)localObject1, this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfoLoadObserver, false);
    Object localObject2 = (DoodleEmojiManager)SuperManager.a(36);
    ((DoodleEmojiManager)localObject2).a(BaseApplicationImpl.getApplication());
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131364327));
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage == null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage = new LocationFacePackage("0");
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_b_of_type_Boolean = true;
      localObject1 = DoodleEmojiManager.c((DoodleEmojiManager)localObject2, "0");
      localObject2 = DoodleEmojiManager.a((DoodleEmojiManager)localObject2, "0");
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!NetworkUtil.g(a()))) {
        break label144;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.c = ((String)localObject2);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.a((String)localObject1);
      a(EditDoodleExport.class, this);
      return;
      label144:
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.a = a().getDrawable(2130843430);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(false, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    a().a("处理中...", true, 0L, new ancr(this));
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
    this.jdField_a_of_type_AndroidOsHandler.post(new ancs(this));
    this.jdField_a_of_type_Long = l;
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    this.d = false;
    switch (paramInt2)
    {
    case 8: 
    case 18: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 25: 
    case 26: 
    case 27: 
    case 34: 
    case 35: 
    default: 
      a(0);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  a(4);
                  return;
                  a(0);
                  this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.j();
                  this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(true);
                  return;
                  a(0);
                  this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.j();
                } while (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer == null);
                this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.b();
                return;
              } while ((paramInt1 == 9) || (paramInt1 == paramInt2));
              j();
              a(0);
              return;
            } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null);
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.j();
            return;
            a(8);
            return;
            if (paramInt1 != 9)
            {
              s();
              j();
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.d();
              a(0);
            }
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(true);
            return;
          } while (paramInt1 == 8);
          j();
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.i();
          a(0);
          return;
        } while (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer == null);
        paramObject = (Pair)paramObject;
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(((Integer)paramObject.first).intValue(), (Object[])paramObject.second);
        return;
      } while (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer == null);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.b();
      return;
    } while (paramInt1 != 36);
    this.d = true;
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
  
  public void a(int paramInt, LbsManager.POIListRequestSession paramPOIListRequestSession, List paramList)
  {
    if ((paramInt != 0) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    PasterDataManager localPasterDataManager = (PasterDataManager)QIMManager.a(4);
    QQStoryContext.a();
    paramPOIListRequestSession = QQStoryContext.a();
    PtvTemplateManager.a(paramPOIListRequestSession).a(paramPOIListRequestSession, this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfoLoadObserver, false);
    paramPOIListRequestSession = SharedPreUtils.u(a(), paramPOIListRequestSession.getCurrentAccountUin());
    String str = ((TroopBarPOI)paramList.get(0)).a();
    paramList = paramList.iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
    } while (!((TroopBarPOI)paramList.next()).a().equals(paramPOIListRequestSession));
    for (;;)
    {
      localPasterDataManager.a(paramPOIListRequestSession);
      return;
      paramPOIListRequestSession = str;
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
    paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("all_doodle_text", a().a());
    paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mMosaicMask = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramInt);
    paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mMosaicSize = 16;
    Object localObject1 = a().b(paramInt);
    if (((List)localObject1).size() > 0)
    {
      localObject1 = (FaceLayer.FaceItem)Collections.max((Collection)localObject1, this.jdField_a_of_type_Ande);
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLocationDescription = ((FaceLayer.FaceItem)localObject1).a();
    }
    label255:
    int i;
    label312:
    label371:
    Object localObject3;
    int j;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d())
    {
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLongitude = ((EditLocalVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).a.longitude;
        paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLatitude = ((EditLocalVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).a.latitude;
      }
    }
    else
    {
      if (a().b(paramInt))
      {
        localObject2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
        if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
          break label926;
        }
        localObject1 = "2";
        ((EditVideoPartManager)localObject2).a("change_graffiti", 0, 0, new String[] { localObject1 });
        VideoEditReport.a("0X80076C0");
      }
      if (a().a(paramInt))
      {
        localObject2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
        if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
          break label934;
        }
        localObject1 = "2";
        ((EditVideoPartManager)localObject2).a("change_color", 0, 0, new String[] { localObject1 });
        VideoEditReport.a("0X80076C4");
      }
      if ((!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) && (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))) {
        break label942;
      }
      i = 1;
      localObject2 = a().a(paramInt);
      if ((localObject2 != null) && (localObject2.length == 2))
      {
        if (localObject2[0] <= 0) {
          break label955;
        }
        localObject3 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
        j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b();
        if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
          break label947;
        }
        localObject1 = "2";
        label430:
        ((EditVideoPartManager)localObject3).b("pub_graffiti", j, 0, new String[] { "1", "", localObject1 });
        VideoEditReport.a("0X80076E0", VideoEditReport.jdField_b_of_type_Int);
        VideoEditReport.b("0X80075EA", VideoEditReport.jdField_a_of_type_Int);
        paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("1");
        label494:
        if (localObject2[1] <= 0) {
          break label986;
        }
        localObject3 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
        j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b();
        if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
          break label978;
        }
        localObject1 = "2";
        label531:
        ((EditVideoPartManager)localObject3).b("pub_mosaics", j, 0, new String[] { "1", "", localObject1 });
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
        break label1374;
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
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))
      {
        paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLongitude = ((EditLocalPhotoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).a.longitude;
        paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLatitude = ((EditLocalPhotoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).a.latitude;
        break;
      }
      if (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)) {
        break;
      }
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLongitude = ((EditLocalGifSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).a.longitude;
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLatitude = ((EditLocalGifSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).a.latitude;
      break;
      label926:
      localObject1 = "1";
      break label255;
      label934:
      localObject1 = "1";
      break label312;
      label942:
      i = 0;
      break label371;
      label947:
      localObject1 = "1";
      break label430;
      label955:
      if ((i == 0) || (!GeneratePicArgs.a(0))) {
        break label494;
      }
      VideoEditReport.b("0X80075EA", VideoEditReport.jdField_a_of_type_Int);
      break label494;
      label978:
      localObject1 = "1";
      break label531;
      label986:
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
      localObject5 = ((List)localObject1).iterator();
      while (((Iterator)localObject5).hasNext()) {
        ((StringBuilder)localObject4).append(((FaceLayer.FaceItem)((Iterator)localObject5).next()).e).append(',');
      }
      ((StringBuilder)localObject4).deleteCharAt(((StringBuilder)localObject4).length() - 1);
      ((FaceLayer.FaceItem)((List)localObject1).get(0)).a();
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
        ((EditVideoPartManager)localObject5).b("pub_face", j, 0, new String[] { String.valueOf(k), localObject6, localObject1 });
        VideoEditReport.a("0X80076E3", VideoEditReport.jdField_b_of_type_Int);
        VideoEditReport.b("0X80075ED", VideoEditReport.jdField_a_of_type_Int);
        paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("4");
        paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = ((StringBuilder)localObject3).toString();
        label1267:
        if (localObject2[1] <= 0) {
          break label1672;
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b("pub_poi", this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b(), 0, new String[] { String.valueOf(localObject2[1]), ((StringBuilder)localObject4).toString() });
        VideoEditReport.a("0X80076E4");
        VideoEditReport.b("0X80075EE");
        if (localObject2[0] <= 0) {
          break label1643;
        }
        paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = (paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 + "," + ((StringBuilder)localObject4).toString());
        label1374:
        localObject2 = a().a(paramInt);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label1692;
        }
        j = 1;
        label1395:
        if (j == 0) {
          break label1706;
        }
        localObject3 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
        i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b();
        if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
          break label1698;
        }
        localObject1 = "2";
        label1429:
        ((EditVideoPartManager)localObject3).b("pub_text", i, 0, new String[] { "1", localObject2, localObject1 });
        VideoEditReport.a("0X80076E2", VideoEditReport.jdField_b_of_type_Int);
        VideoEditReport.b("0X80075EC", VideoEditReport.jdField_a_of_type_Int);
        paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("3");
      }
    }
    for (;;)
    {
      localObject3 = a().a(paramInt);
      if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
        break label1756;
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
        break label1267;
      }
      VideoEditReport.b("0X80075ED", VideoEditReport.jdField_a_of_type_Int);
      break label1267;
      label1643:
      paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("4");
      paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = ((StringBuilder)localObject4).toString();
      break label1374;
      label1672:
      if ((i == 0) || (!GeneratePicArgs.a(3))) {
        break label1374;
      }
      VideoEditReport.b("0X80075EE");
      break label1374;
      label1692:
      j = 0;
      break label1395;
      label1698:
      localObject1 = "1";
      break label1429;
      label1706:
      if ((i != 0) && (GeneratePicArgs.a(4))) {
        VideoEditReport.b("0X80075EC", VideoEditReport.jdField_a_of_type_Int);
      }
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b("person_gra", this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b(), 0, new String[] { localObject1 });
    label1756:
    localObject1 = BaseApplicationImpl.getContext();
    Object localObject2 = PlayModeUtils.a().c();
    if (InfomationFacePackage.jdField_b_of_type_Boolean) {}
    for (paramGenerateContext = paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLocationDescription;; paramGenerateContext = "")
    {
      SharedPreUtils.x((Context)localObject1, (String)localObject2, paramGenerateContext);
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
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.h())
    {
      EditVideoPlayerExport localEditVideoPlayerExport = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
      if (localEditVideoPlayerExport != null) {
        localEditVideoPlayerExport.a(paramBitmap, paramBoolean);
      }
    }
  }
  
  public void a(Animation paramAnimation)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramAnimation);
  }
  
  public void a(LocationFacePackage.Item paramItem)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 1) {
      ((StoryConfigManager)SuperManager.a(10)).b("has_show_add_poi_paster_guide", Boolean.valueOf(true));
    }
    boolean bool = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b(6);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a())
    {
      paramItem = "2";
      if (!bool) {
        break label107;
      }
    }
    label107:
    for (String str = "1";; str = "0")
    {
      StoryReportor.a("video_edit", "add_place", 0, 0, new String[] { paramItem, "", str, "" });
      return;
      paramItem = "1";
      break;
    }
  }
  
  public void a(Map paramMap)
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
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.m();
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
    default: 
      return super.a(paramMessage);
    case 6: 
      a(0);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a());
      switch (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c())
      {
      }
      for (;;)
      {
        return true;
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      }
    case 11: 
      this.jdField_c_of_type_Long = ((Long)paramMessage.obj).longValue();
      return true;
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTimeStamp(((Long)paramMessage.obj).longValue(), false);
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
  
  public void aC_()
  {
    super.aC_();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())
    {
      NativeGifImage.resumeAll();
      ApngImage.playByTag(13);
      return;
    }
    NativeGifImage.pauseAll();
    ApngImage.pauseByTag(13);
  }
  
  public void aD_()
  {
    super.aD_();
    NativeGifImage.pauseAll();
    ApngImage.pauseByTag(13);
  }
  
  public void au_()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null)) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.d();
    }
  }
  
  public void ax_()
  {
    if (this.jdField_b_of_type_Boolean) {
      a().b();
    }
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
  
  public void b(int paramInt, Object paramObject)
  {
    SLog.b("Q.qqstory.publish.edit.StoryDoodle", "onStateChanged : " + paramInt);
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.jdField_c_of_type_Boolean)) {
      return;
    }
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 0: 
    case 7: 
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(13)) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(14)) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(15)) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(16)))
      {
        SLog.d("Q.qqstory.publish.edit.StoryDoodle", "do nothing because edit ui is showing the guide");
        return;
      }
      if (this.d)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(36);
        return;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      return;
    case 2: 
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(7, paramObject);
      return;
    case 3: 
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(5, paramObject);
      return;
    case 4: 
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(9);
      return;
    case 5: 
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(8, paramObject);
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(8);
  }
  
  public void b(Animation paramAnimation)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b(paramAnimation);
  }
  
  public void b(String paramString)
  {
    EditVideoPartManager localEditVideoPartManager = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {}
    for (String str = "2";; str = "1")
    {
      localEditVideoPartManager.a("exp_editpoi", 0, 0, new String[] { str });
      VideoEditReport.a("0X80076CF");
      VideoEditReport.b("0X80075E4");
      paramString = new EditVideoDoodle.LocationCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPoiPickerCallback, paramString);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(3, paramString);
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {}
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b());
  }
  
  public void h()
  {
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Andc != null) {
      Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_Andc);
    }
    if (this.jdField_a_of_type_Andb != null) {
      Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_Andb);
    }
    if (this.jdField_a_of_type_Andd != null) {
      Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_Andd);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setVideoSegmentPickerListener(null);
    }
    DoodleLayoutConnector.a().a(c());
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.c();
    }
  }
  
  public boolean j_()
  {
    if (System.currentTimeMillis() < this.jdField_c_of_type_Long) {}
    while ((!EditVideoPartManager.a(this.jdField_b_of_type_Int, 8)) || (!TextUtils.isEmpty(a().a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a())))) {
      return false;
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_b_of_type_Int == 0) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(27);
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_b_of_type_Int == 27) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      } else if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_b_of_type_Int == 28) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      }
    }
  }
  
  public void k()
  {
    if (this.d)
    {
      this.d = false;
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
  }
  
  public void l()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.c();
  }
  
  public void m()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.f();
  }
  
  public void n()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a().postDelayed(new anda(this), 200L);
  }
  
  public void o()
  {
    a().f();
  }
  
  public void p()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(true, 0.0F, 0.0F, 0.0F, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle
 * JD-Core Version:    0.7.0.1
 */