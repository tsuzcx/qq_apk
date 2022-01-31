package dov.com.tencent.biz.qqstory.takevideo;

import anat;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.statistics.QIMReportController;
import com.tencent.mobileqq.statistics.reportitem.QIMMsgReportItem;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMSegmentCaptureManager;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.data.TemplateGroupItem;
import dov.com.qq.im.capture.music.EditVideoQimMusic;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.view.ComboProviderView;
import dov.com.qq.im.capture.view.QIMFilterProviderView;
import dov.com.qq.im.capture.view.QIMPtvTemplateProviderView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceAndTextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.LineLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLinePath;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleOpController;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.PureLinePath;
import dov.com.tencent.biz.qqstory.takevideo.filter.FilterData;
import dov.com.tencent.biz.qqstory.takevideo.filter.VideoEffectsFilterData;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.DataSet;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DataReporter
{
  private static final DataReporter jdField_a_of_type_DovComTencentBizQqstoryTakevideoDataReporter = new DataReporter();
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static DataReporter a()
  {
    return jdField_a_of_type_DovComTencentBizQqstoryTakevideoDataReporter;
  }
  
  @Nullable
  public DataReporter.Destination a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return DataReporter.Destination.C2C;
    case 0: 
    case 2: 
    case 1000: 
    case 1001: 
    case 1002: 
    case 1003: 
    case 1004: 
    case 1005: 
    case 1006: 
    case 1008: 
    case 1009: 
    case 1010: 
    case 1011: 
    case 1020: 
    case 1021: 
    case 1022: 
    case 1024: 
    case 1025: 
    case 1029: 
    case 7400: 
    case 10002: 
      return DataReporter.Destination.C2C;
    case 1: 
      return DataReporter.Destination.GROUP;
    }
    return DataReporter.Destination.DISCUSS;
  }
  
  @NonNull
  public List a(@Nullable EditVideoPartManager paramEditVideoPartManager, DataReporter.T paramT1, DataReporter.T paramT2)
  {
    ArrayList localArrayList1 = new ArrayList();
    if (paramEditVideoPartManager != null) {
      try
      {
        paramEditVideoPartManager.o();
        if ((paramEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi != null) && (paramEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)) {
          break label61;
        }
        throw new IllegalStateException("have not attach ui and params");
      }
      catch (Throwable paramEditVideoPartManager)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QIMReportController.DataReporter", 2, Log.getStackTraceString(paramEditVideoPartManager));
        }
      }
    } else {
      return localArrayList1;
    }
    label61:
    Object localObject1;
    label90:
    Object localObject2;
    label102:
    QIMMsgReportItem localQIMMsgReportItem;
    Object localObject4;
    label396:
    label401:
    boolean bool1;
    boolean bool2;
    if ((paramEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a() instanceof EditWebVideoActivity))
    {
      localObject1 = (EditWebVideoActivity)paramEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a();
      if (localObject1 != null)
      {
        localObject2 = ((Activity)localObject1).getIntent();
        localQIMMsgReportItem = new QIMMsgReportItem();
        localQIMMsgReportItem.jdField_e_of_type_JavaLangString = "0";
        localQIMMsgReportItem.g = DataReporter.Destination.UNKNOWN.toString();
        if (paramEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a != null)
        {
          localObject4 = (SessionInfo)paramEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.getParcelable("edit_send_session_info");
          localObject1 = localObject4;
          if (localObject4 == null)
          {
            localObject1 = localObject4;
            if (localObject2 != null) {
              localObject1 = (SessionInfo)((Intent)localObject2).getParcelableExtra("edit_send_session_info");
            }
          }
          if (localObject1 != null)
          {
            localQIMMsgReportItem.jdField_e_of_type_JavaLangString = ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString;
            localObject4 = a(((SessionInfo)localObject1).jdField_a_of_type_Int);
            localObject1 = localObject4;
            if (localObject4 == null) {
              localObject1 = DataReporter.Destination.UNKNOWN;
            }
            localQIMMsgReportItem.g = ((DataReporter.Destination)localObject1).toString();
          }
        }
        localQIMMsgReportItem.h = ("fake_vid_" + System.currentTimeMillis() + "-" + new Random(System.currentTimeMillis() + Thread.currentThread().getId()).nextInt());
      }
    }
    else
    {
      label452:
      double d;
      label467:
      label484:
      int i;
      switch (paramEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())
      {
      case 1: 
        localObject1 = DataReporter.MsgEntry.UNDEFINE;
        localQIMMsgReportItem.f = ((DataReporter.MsgEntry)localObject1).toString();
        localQIMMsgReportItem.jdField_a_of_type_Int = 1;
        bool1 = paramEditVideoPartManager.a();
        bool2 = ((QIMSegmentCaptureManager)QIMManager.a().c(13)).a();
        if (bool1)
        {
          localObject1 = DataReporter.MsgType.PICTURE.toString();
          localQIMMsgReportItem.i = ((String)localObject1);
          if (!bool1) {
            break label1365;
          }
          d = 0.0D;
          localQIMMsgReportItem.jdField_a_of_type_Double = d;
          if (!bool1) {
            break label1375;
          }
          paramT1 = paramT1.toString();
          localQIMMsgReportItem.d = paramT1;
          localQIMMsgReportItem.k = DataReporter.ElementType.OTHER.toString();
          localQIMMsgReportItem.j = DataReporter.ContentSource.UNKNOWN.toString();
          localObject1 = DataReporter.ContentSource.UNKNOWN;
          if (localObject2 == null) {
            break label3506;
          }
          paramT1 = ((Intent)localObject2).getBundleExtra("state");
          if (!bool1) {
            break label1399;
          }
          i = ((Intent)localObject2).getIntExtra("pic_entrance_type", -1);
          if (i <= 0) {
            break label3533;
          }
          switch (i)
          {
          case 1: 
            localObject1 = DataReporter.ContentSource.EDIT_AFTER_SHOT;
            break label3533;
            if (paramT1 != DataReporter.ContentSource.UNKNOWN) {
              localQIMMsgReportItem.j = paramT1.toString();
            }
            if ((paramT1 != DataReporter.ContentSource.UNKNOWN) && (paramEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart != null) && (paramEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicCropPart.c))
            {
              localQIMMsgReportItem.j = paramT1.toString();
              localObject2 = new QIMMsgReportItem(localQIMMsgReportItem);
              ((QIMMsgReportItem)localObject2).k = DataReporter.ElementType.CLIP.toString();
              ((QIMMsgReportItem)localObject2).m = "";
              ((QIMMsgReportItem)localObject2).l = "";
              localArrayList1.add(localObject2);
            }
            if (paramT1 != DataReporter.ContentSource.EDIT_AFTER_IMPORT)
            {
              localObject2 = new QIMMsgReportItem(localQIMMsgReportItem);
              ((QIMMsgReportItem)localObject2).j = DataReporter.ContentSource.UNKNOWN.toString();
              ((QIMMsgReportItem)localObject2).k = DataReporter.ElementType.CAMERA.toString();
              ((QIMMsgReportItem)localObject2).l = "";
              if (FlowCameraConstant.jdField_a_of_type_Int != 2) {
                break label1502;
              }
              ((QIMMsgReportItem)localObject2).m = "back";
              localArrayList1.add(localObject2);
              if (GLVideoClipUtil.b())
              {
                localObject2 = new QIMMsgReportItem(localQIMMsgReportItem);
                ((QIMMsgReportItem)localObject2).k = DataReporter.ElementType.DARK.toString();
                ((QIMMsgReportItem)localObject2).l = "";
                ((QIMMsgReportItem)localObject2).m = "on";
                localArrayList1.add(localObject2);
              }
            }
            if ((!bool1) && (paramEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null))
            {
              localObject2 = paramEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();
              if ((localObject2 != null) && ((localObject2 instanceof VideoEffectsFilterData)))
              {
                localObject4 = new QIMMsgReportItem(localQIMMsgReportItem);
                ((QIMMsgReportItem)localObject4).k = DataReporter.ElementType.SPEED.toString();
                ((QIMMsgReportItem)localObject4).l = "";
                ((QIMMsgReportItem)localObject4).m = ((FilterData)localObject2).toString();
                localArrayList1.add(localObject4);
              }
            }
            localObject2 = paramEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle;
            if (localObject2 != null) {
              localObject2 = null;
            }
            break;
          }
        }
      case 2: 
      case 3: 
      case 14: 
      case 15: 
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 100: 
      case 7: 
        label600:
        label986:
        label1502:
        try
        {
          label608:
          if (!paramEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) {
            break label1513;
          }
          localObject4 = paramEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().a().jdField_a_of_type_JavaUtilList;
          localObject2 = localObject4;
        }
        catch (NullPointerException localNullPointerException4)
        {
          Object localObject5;
          Object localObject6;
          label1125:
          label1399:
          break label959;
          label1375:
          label1513:
          paramT1 = paramT2;
        }
        label768:
        label959:
        localObject4 = localObject2;
        if (localObject2 == null) {
          localObject4 = new ArrayList();
        }
        localObject4 = ((List)localObject4).iterator();
        label1061:
        label1109:
        do
        {
          do
          {
            if (!((Iterator)localObject4).hasNext()) {
              break;
            }
            localObject5 = (FaceLayer.FaceItem)((Iterator)localObject4).next();
          } while (localObject5 == null);
          localObject6 = new QIMMsgReportItem(localQIMMsgReportItem);
          if (!(localObject5 instanceof FaceLayer.FaceAndTextItem)) {
            break;
          }
          ((QIMMsgReportItem)localObject6).k = DataReporter.ElementType.POSTER.toString();
          ((QIMMsgReportItem)localObject6).l = "地理位置";
          ((QIMMsgReportItem)localObject6).m = ((FaceLayer.FaceItem)localObject5).jdField_e_of_type_JavaLangString;
          if ((paramT2 == DataReporter.T.VIDEO_RETAKE) || (paramT2 == DataReporter.T.VIDEO_SAVE) || (paramT2 == DataReporter.T.VIDEO_PUBLISH))
          {
            if ((((FaceLayer.FaceItem)localObject5).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper == null) || (((FaceLayer.FaceItem)localObject5).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.b())) {
              break label1609;
            }
            ((QIMMsgReportItem)localObject6).n = "1";
          }
          if (((FaceLayer.FaceItem)localObject5).jdField_e_of_type_Int != 0) {
            break label1619;
          }
          localObject2 = DataReporter.ContentSource.BEFORE_SHOT.toString();
          ((QIMMsgReportItem)localObject6).j = ((String)localObject2);
          localArrayList1.add(localObject6);
        } while (!((FaceLayer.FaceItem)localObject5).d.equals("信息贴纸"));
        localObject2 = new QIMMsgReportItem();
        ((QIMMsgReportItem)localObject2).m = ((FaceLayer.FaceItem)localObject5).jdField_e_of_type_JavaLangString;
        ((QIMMsgReportItem)localObject2).l = ((FaceLayer.FaceItem)localObject5).d;
        ((QIMMsgReportItem)localObject2).k = DataReporter.ElementType.POSTER.toString();
        ((QIMMsgReportItem)localObject2).j = localQIMMsgReportItem.d;
        ((QIMMsgReportItem)localObject2).i = localQIMMsgReportItem.i;
        if (((FaceLayer.FaceItem)localObject5).g == 1) {
          ((QIMMsgReportItem)localObject2).d = "0X8008C04";
        }
        for (;;)
        {
          QIMReportController.b(null, (QIMMsgReportItem)localObject2);
          break label986;
          if ((paramEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a() instanceof EditVideoActivity))
          {
            localObject1 = (EditVideoActivity)paramEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a();
            break;
          }
          if (!(paramEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a() instanceof EditPicActivity)) {
            break label3521;
          }
          localObject1 = (EditPicActivity)paramEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a();
          break;
          localObject1 = DataReporter.MsgEntry.MOMENTS;
          break label401;
          localObject1 = DataReporter.MsgEntry.HOME;
          break label401;
          localObject1 = DataReporter.MsgEntry.AIO;
          break label401;
          localObject1 = DataReporter.MsgEntry.WEB;
          break label401;
          if (bool2)
          {
            localObject1 = DataReporter.MsgType.SEGMENT_VIDEO.toString();
            break label452;
          }
          localObject1 = DataReporter.MsgType.SHORT_VIDEO.toString();
          break label452;
          label1365:
          d = paramEditVideoPartManager.a();
          break label467;
          paramT1 = paramT2.toString();
          break label484;
          localObject1 = DataReporter.ContentSource.EDIT_AFTER_SHOT;
          break label3533;
          localObject1 = DataReporter.ContentSource.EDIT_AFTER_IMPORT;
          break label3533;
          i = ((Intent)localObject2).getIntExtra("short_video_entrance_type", -1);
          if (i <= 0) {
            break label3493;
          }
          switch (i)
          {
          case 1: 
            localObject2 = DataReporter.ContentSource.EDIT_AFTER_SHOT;
            localObject1 = paramT1;
            paramT1 = (DataReporter.T)localObject2;
            break;
          case 2: 
          case 3: 
          case 4: 
          case 5: 
            localObject2 = DataReporter.ContentSource.EDIT_AFTER_SHOT;
            localObject1 = paramT1;
            paramT1 = (DataReporter.T)localObject2;
            break;
          case 6: 
          case 7: 
            label1460:
            localObject2 = DataReporter.ContentSource.EDIT_AFTER_IMPORT;
            localObject1 = paramT1;
            paramT1 = (DataReporter.T)localObject2;
            break;
            ((QIMMsgReportItem)localObject2).m = "front";
            break label768;
            localObject4 = paramEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().a().jdField_a_of_type_JavaUtilList;
            localObject2 = localObject4;
            break label959;
            if (((FaceLayer.FaceItem)localObject5).b)
            {
              ((QIMMsgReportItem)localObject6).k = DataReporter.ElementType.POSTER.toString();
              ((QIMMsgReportItem)localObject6).l = "信息贴纸";
              ((QIMMsgReportItem)localObject6).m = ((FaceLayer.FaceItem)localObject5).jdField_e_of_type_JavaLangString;
              break label1061;
            }
            ((QIMMsgReportItem)localObject6).k = DataReporter.ElementType.POSTER.toString();
            ((QIMMsgReportItem)localObject6).l = ((FaceLayer.FaceItem)localObject5).d;
            ((QIMMsgReportItem)localObject6).m = ((FaceLayer.FaceItem)localObject5).jdField_e_of_type_JavaLangString;
            break label1061;
            label1609:
            ((QIMMsgReportItem)localObject6).n = "0";
            break label1109;
            label1619:
            localObject2 = paramT1.toString();
            break label1125;
            if (((FaceLayer.FaceItem)localObject5).g == 0) {
              ((QIMMsgReportItem)localObject2).d = "0X8008C05";
            }
            break;
          }
        }
        localObject4 = null;
        localObject2 = localObject4;
      }
    }
    for (;;)
    {
      try
      {
        if (paramEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) {
          localObject2 = paramEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().a().jdField_a_of_type_JavaUtilList;
        }
        if (localObject2 != null)
        {
          localObject4 = ((List)localObject2).iterator();
          if (((Iterator)localObject4).hasNext())
          {
            localObject2 = (FaceLayer.FaceItem)((Iterator)localObject4).next();
            if (localObject2 == null) {
              continue;
            }
            localObject5 = new QIMMsgReportItem(localQIMMsgReportItem);
            ((QIMMsgReportItem)localObject5).k = DataReporter.ElementType.POSTER.toString();
            ((QIMMsgReportItem)localObject5).l = ((FaceLayer.FaceItem)localObject2).d;
            ((QIMMsgReportItem)localObject5).m = ((FaceLayer.FaceItem)localObject2).jdField_e_of_type_JavaLangString;
            if ((paramT2 == DataReporter.T.VIDEO_RETAKE) || (paramT2 == DataReporter.T.VIDEO_SAVE) || (paramT2 == DataReporter.T.VIDEO_PUBLISH))
            {
              if ((((FaceLayer.FaceItem)localObject2).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper != null) && (!((FaceLayer.FaceItem)localObject2).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.b())) {
                ((QIMMsgReportItem)localObject5).n = "1";
              }
            }
            else
            {
              if (((FaceLayer.FaceItem)localObject2).jdField_e_of_type_Int != 0) {
                continue;
              }
              localObject2 = DataReporter.ContentSource.BEFORE_SHOT.toString();
              ((QIMMsgReportItem)localObject5).j = ((String)localObject2);
              localArrayList1.add(localObject5);
              continue;
            }
            ((QIMMsgReportItem)localObject5).n = "0";
            continue;
            localObject2 = paramT1.toString();
            continue;
          }
        }
        localObject2 = null;
        try
        {
          localObject4 = paramEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().a().jdField_a_of_type_JavaUtilArrayList;
          localObject2 = localObject4;
        }
        catch (NullPointerException localNullPointerException3)
        {
          continue;
        }
        localObject4 = localObject2;
        if (localObject2 == null) {
          localObject4 = new ArrayList();
        }
        localObject2 = ((List)localObject4).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject4 = (TextLayer.TextItem)((Iterator)localObject2).next();
          localObject5 = new QIMMsgReportItem(localQIMMsgReportItem);
          ((QIMMsgReportItem)localObject5).k = "text";
          ((QIMMsgReportItem)localObject5).l = "";
          localObject6 = ((TextLayer.TextItem)localObject4).jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
          if (localObject6 != null)
          {
            ((QIMMsgReportItem)localObject5).m = String.valueOf(((DynamicTextItem)localObject6).c());
            ((QIMMsgReportItem)localObject5).j = paramT1.toString();
            if ((paramT2 == DataReporter.T.VIDEO_RETAKE) || (paramT2 == DataReporter.T.VIDEO_SAVE) || (paramT2 == DataReporter.T.VIDEO_PUBLISH))
            {
              if ((((TextLayer.TextItem)localObject4).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper != null) && (!((TextLayer.TextItem)localObject4).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.b())) {
                ((QIMMsgReportItem)localObject5).n = "1";
              }
            }
            else {
              localArrayList1.add(localObject5);
            }
          }
          else
          {
            ((QIMMsgReportItem)localObject5).m = "";
            continue;
          }
          ((QIMMsgReportItem)localObject5).n = "0";
          continue;
        }
        paramT2 = null;
        try
        {
          localObject2 = paramEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a().a().a.a();
          paramT2 = (DataReporter.T)localObject2;
        }
        catch (NullPointerException localNullPointerException1)
        {
          ArrayList localArrayList2;
          FilterCategory localFilterCategory;
          Iterator localIterator;
          QIMFilterCategoryItem localQIMFilterCategoryItem;
          continue;
        }
        if ((paramT2 != null) && (!paramT2.isEmpty()))
        {
          paramT2 = paramT2.iterator();
          if (paramT2.hasNext())
          {
            localObject2 = (DoodleLinePath)paramT2.next();
            localObject4 = new QIMMsgReportItem(localQIMMsgReportItem);
            ((QIMMsgReportItem)localObject4).l = ((DoodleLinePath)localObject2).a();
            ((QIMMsgReportItem)localObject4).k = "doodle";
            if (((DoodleLinePath)localObject2).a(101))
            {
              if ((localObject2 instanceof PureLinePath)) {
                ((QIMMsgReportItem)localObject4).m = ("#" + Integer.toHexString(((PureLinePath)localObject2).jdField_b_of_type_Int));
              }
              ((QIMMsgReportItem)localObject4).j = paramT1.toString();
              localArrayList1.add(localObject4);
              continue;
            }
            ((QIMMsgReportItem)localObject4).m = "";
            continue;
          }
        }
        localObject6 = new QIMMsgReportItem(localQIMMsgReportItem);
        paramT2 = VideoFilterTools.a();
        localObject4 = paramT2.a;
        if (localObject4 != null)
        {
          localObject2 = localObject4[paramT2.c()];
          localObject5 = localObject4[0];
          if (localObject2 != null) {
            break label3490;
          }
          localObject2 = localObject5;
          if ((paramT2.a != null) && (localObject2 != null))
          {
            bool2 = ((QIMFilterCategoryItem)localObject2).jdField_a_of_type_Boolean;
            if (paramEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart == null) {
              break label3485;
            }
            paramT2 = (QIMFilterProviderView)paramEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart.a(QIMFilterProviderView.class);
            if ((paramT2 == null) || (paramT2.jdField_a_of_type_JavaUtilArrayList == null)) {
              break label3485;
            }
            paramT2 = paramT2.a();
            if (paramT2 == null) {
              break label3485;
            }
            if ((paramT2 != null) || (localObject1 == null)) {
              break label3482;
            }
            localObject4 = ((Bundle)localObject1).getBundle("container");
            if (localObject4 == null) {
              break label3482;
            }
            if (bool2)
            {
              localObject4 = ((Bundle)localObject4).getBundle(ComboProviderView.class.getSimpleName());
              if (localObject4 == null) {
                break label3482;
              }
              localObject4 = ((Bundle)localObject4).getParcelable("ProviderView.select_item_category");
              if (localObject4 == null) {
                break label3482;
              }
              paramT2 = (FilterCategory)localObject4;
              localArrayList2 = new ArrayList();
              localObject4 = (CaptureComboManager)QIMManager.a(5);
              if ((paramT2 == null) && (((CaptureComboManager)localObject4).a() != null))
              {
                localObject4 = ((CaptureComboManager)localObject4).a().jdField_a_of_type_JavaUtilArrayList.iterator();
                if (((Iterator)localObject4).hasNext())
                {
                  localFilterCategory = (FilterCategory)((Iterator)localObject4).next();
                  localIterator = localFilterCategory.jdField_a_of_type_JavaUtilList.iterator();
                  if (!localIterator.hasNext()) {
                    continue;
                  }
                  localQIMFilterCategoryItem = (QIMFilterCategoryItem)localIterator.next();
                  if ((localQIMFilterCategoryItem.a() != ((QIMFilterCategoryItem)localObject2).a()) || (localQIMFilterCategoryItem.jdField_b_of_type_JavaLangString == null) || (!localQIMFilterCategoryItem.jdField_b_of_type_JavaLangString.equals(((QIMFilterCategoryItem)localObject2).jdField_b_of_type_JavaLangString))) {
                    continue;
                  }
                  localArrayList2.add(localFilterCategory);
                  continue;
                }
              }
            }
            else
            {
              localObject4 = ((Bundle)localObject4).getBundle(QIMFilterProviderView.class.getSimpleName());
              continue;
            }
            if (!bool2) {
              continue;
            }
            localObject4 = DataReporter.ElementType.COMBO.toString();
            ((QIMMsgReportItem)localObject6).k = ((String)localObject4);
            if (paramT2 == null) {
              continue;
            }
            ((QIMMsgReportItem)localObject6).l = paramT2.jdField_a_of_type_JavaLangString;
            if ((!((QIMFilterCategoryItem)localObject2).jdField_a_of_type_Boolean) && (((QIMFilterCategoryItem)localObject2).jdField_a_of_type_JavaUtilArrayList != null) && (!((QIMFilterCategoryItem)localObject2).jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
              continue;
            }
            ((QIMMsgReportItem)localObject6).m = ((QIMFilterCategoryItem)localObject2).jdField_a_of_type_JavaLangString;
            if (paramT1 != DataReporter.ContentSource.EDIT_AFTER_IMPORT) {
              continue;
            }
            ((QIMMsgReportItem)localObject6).j = paramT1.toString();
            localArrayList1.add(localObject6);
          }
        }
        if ((!"0".equals(QIMPtvTemplateAdapter.jdField_b_of_type_JavaLangString)) || (QIMPtvTemplateAdapter.jdField_b_of_type_Int != 0) || (!TextUtils.isEmpty(QIMPtvTemplateAdapter.jdField_a_of_type_JavaLangString)))
        {
          if (QIMPtvTemplateAdapter.jdField_b_of_type_JavaLangString == null) {
            QIMPtvTemplateAdapter.jdField_b_of_type_JavaLangString = "";
          }
          if (QIMPtvTemplateAdapter.jdField_a_of_type_JavaLangString == null) {
            QIMPtvTemplateAdapter.jdField_a_of_type_JavaLangString = "";
          }
          paramT2 = "";
          localObject2 = (QIMPtvTemplateManager)QIMManager.a(3);
          paramT1 = paramT2;
          if (localObject1 != null)
          {
            localObject1 = ((Bundle)localObject1).getBundle("container");
            paramT1 = paramT2;
            if (localObject1 != null)
            {
              localObject1 = ((Bundle)localObject1).getBundle(QIMPtvTemplateProviderView.class.getSimpleName());
              paramT1 = paramT2;
              if (localObject1 != null) {
                paramT1 = ((Bundle)localObject1).getString("ProviderView.select_item_category");
              }
            }
          }
          if (localObject2 != null)
          {
            localObject1 = ((QIMPtvTemplateManager)localObject2).a(QIMPtvTemplateAdapter.jdField_b_of_type_JavaLangString);
            if (localObject1 != null)
            {
              if (!TextUtils.isEmpty(paramT1)) {
                break label3479;
              }
              paramT1 = "";
              localObject2 = ((QIMPtvTemplateManager)localObject2).a();
              paramT2 = paramT1;
              if (localObject2 != null)
              {
                localObject2 = ((ArrayList)localObject2).iterator();
                paramT2 = paramT1;
                if (((Iterator)localObject2).hasNext())
                {
                  localObject4 = (TemplateGroupItem)((Iterator)localObject2).next();
                  paramT2 = ((TemplateGroupItem)localObject4).jdField_a_of_type_JavaUtilList;
                  if (paramT2 == null) {
                    continue;
                  }
                  localObject5 = paramT2.iterator();
                  paramT2 = paramT1;
                  paramT1 = paramT2;
                  if (!((Iterator)localObject5).hasNext()) {
                    continue;
                  }
                  paramT1 = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject5).next();
                  if ((paramT1.name == null) || (!paramT1.name.equals(((PtvTemplateManager.PtvTemplateInfo)localObject1).name)) || (paramT1.id == null) || (!paramT1.id.equals(((PtvTemplateManager.PtvTemplateInfo)localObject1).id))) {
                    break label3474;
                  }
                  paramT1 = paramT2 + ((TemplateGroupItem)localObject4).jdField_a_of_type_JavaLangString + ",";
                  break label3549;
                  localObject4 = DataReporter.ElementType.FILTER.toString();
                  continue;
                  ((QIMMsgReportItem)localObject6).j = DataReporter.ContentSource.BEFORE_SHOT.toString();
                  if (!localArrayList2.isEmpty())
                  {
                    paramT2 = localArrayList2.iterator();
                    if (paramT2.hasNext())
                    {
                      localObject4 = (FilterCategory)paramT2.next();
                      ((QIMMsgReportItem)localObject6).l = (((QIMMsgReportItem)localObject6).l + ((FilterCategory)localObject4).jdField_a_of_type_JavaLangString + ",");
                      continue;
                    }
                  }
                  else
                  {
                    ((QIMMsgReportItem)localObject6).l = "";
                  }
                  if ((TextUtils.isEmpty(((QIMMsgReportItem)localObject6).l)) || (!((QIMMsgReportItem)localObject6).l.endsWith(","))) {
                    continue;
                  }
                  ((QIMMsgReportItem)localObject6).l = ((QIMMsgReportItem)localObject6).l.substring(0, ((QIMMsgReportItem)localObject6).l.length() - 1);
                  continue;
                  ((QIMMsgReportItem)localObject6).m = ((String)((QIMFilterCategoryItem)localObject2).jdField_a_of_type_JavaUtilArrayList.get(0));
                  continue;
                  if ((localObject5 != null) && (((QIMFilterCategoryItem)localObject2).a() == ((QIMFilterCategoryItem)localObject5).a()) && (((QIMFilterCategoryItem)localObject2).a() != null) && (((QIMFilterCategoryItem)localObject2).a().equals(((QIMFilterCategoryItem)localObject5).a())))
                  {
                    ((QIMMsgReportItem)localObject6).j = DataReporter.ContentSource.BEFORE_SHOT.toString();
                    continue;
                  }
                  ((QIMMsgReportItem)localObject6).j = DataReporter.ContentSource.EDIT_AFTER_SHOT.toString();
                  continue;
                }
              }
              if (TextUtils.isEmpty(paramT2)) {
                continue;
              }
              paramT1 = paramT2;
              if (paramT2.endsWith(",")) {
                paramT1 = paramT2.substring(0, paramT2.length() - 1);
              }
              paramT2 = new QIMMsgReportItem(localQIMMsgReportItem);
              paramT2.j = DataReporter.ContentSource.BEFORE_SHOT.toString();
              paramT2.l = paramT1;
              paramT2.m = ((PtvTemplateManager.PtvTemplateInfo)localObject1).id;
              paramT2.k = DataReporter.ElementType.PENDANT.toString();
              localArrayList1.add(paramT2);
            }
          }
        }
        if (paramEditVideoPartManager.jdField_a_of_type_DovComQqImCaptureMusicEditVideoQimMusic != null)
        {
          paramEditVideoPartManager = paramEditVideoPartManager.jdField_a_of_type_DovComQqImCaptureMusicEditVideoQimMusic.a();
          if ((!bool1) && (paramEditVideoPartManager != null) && (!TextUtils.isEmpty(paramEditVideoPartManager.jdField_a_of_type_JavaLangString)))
          {
            paramT1 = new QIMMsgReportItem(localQIMMsgReportItem);
            paramT1.l = paramEditVideoPartManager.d;
            paramT1.m = paramEditVideoPartManager.jdField_a_of_type_JavaLangString;
            paramT1.k = DataReporter.ElementType.MUSIC.toString();
            localArrayList1.add(paramT1);
          }
        }
        if (!localArrayList1.isEmpty()) {
          break;
        }
        localArrayList1.add(localQIMMsgReportItem);
        return localArrayList1;
        paramT1 = "";
        continue;
      }
      catch (NullPointerException localNullPointerException2)
      {
        localObject3 = localNullPointerException3;
        continue;
      }
      label3474:
      label3479:
      continue;
      label3482:
      continue;
      label3485:
      paramT2 = null;
      continue;
      label3490:
      continue;
      label3493:
      Object localObject3 = paramT1;
      paramT1 = (DataReporter.T)localObject1;
      localObject1 = localObject3;
      break label608;
      label3506:
      paramT1 = (DataReporter.T)localObject1;
      localObject1 = null;
      break label608;
      localObject3 = null;
      break label102;
      label3521:
      localObject1 = null;
      break label90;
      break label396;
      break label600;
      label3533:
      localObject3 = paramT1;
      paramT1 = (DataReporter.T)localObject1;
      localObject1 = localObject3;
      break label608;
      break label1460;
      label3549:
      paramT2 = paramT1;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, @NonNull List paramList)
  {
    if (paramQQAppInterface == null) {
      throw new IllegalStateException("QQAppInterface is null");
    }
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      paramList = paramList.iterator();
      if (paramList.hasNext()) {
        localArrayList.add(new QIMMsgReportItem((QIMMsgReportItem)paramList.next()));
      }
    }
    ThreadManager.post(new anat(this, localArrayList, paramQQAppInterface), 5, null, true);
  }
  
  public void a(QQAppInterface paramQQAppInterface, @NonNull List paramList, @Nullable String paramString, @Nullable DataReporter.Destination paramDestination)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (paramDestination != null)
    {
      try
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          ((QIMMsgReportItem)localIterator.next()).g = paramDestination.toString();
        }
        if (paramString == null) {
          break label98;
        }
      }
      finally {}
    }
    else
    {
      paramDestination = paramList.iterator();
      while (paramDestination.hasNext()) {
        ((QIMMsgReportItem)paramDestination.next()).jdField_e_of_type_JavaLangString = paramString;
      }
    }
    label98:
    a(paramQQAppInterface, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.DataReporter
 * JD-Core Version:    0.7.0.1
 */