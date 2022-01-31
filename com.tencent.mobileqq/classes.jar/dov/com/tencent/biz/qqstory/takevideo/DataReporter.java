package dov.com.tencent.biz.qqstory.takevideo;

import ahhj;
import ajjy;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import awqt;
import awtt;
import bhdr;
import bhfm;
import bhfv;
import bhgs;
import bhhq;
import bhil;
import bibz;
import bicj;
import bief;
import bifv;
import bigb;
import bihj;
import bihk;
import biiw;
import biiy;
import biiz;
import bijc;
import bijk;
import bijo;
import bijr;
import binj;
import bink;
import biok;
import bird;
import birp;
import bism;
import bjac;
import bjae;
import bjin;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.view.ComboProviderView;
import dov.com.qq.im.capture.view.QIMFilterProviderView;
import dov.com.qq.im.capture.view.QIMPtvTemplateProviderView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import srv;

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
    case 7400: 
    case 10002: 
      return DataReporter.Destination.C2C;
    case 1: 
      return DataReporter.Destination.GROUP;
    }
    return DataReporter.Destination.DISCUSS;
  }
  
  @NonNull
  public List<awtt> a(@Nullable bigb parambigb, DataReporter.T paramT1, DataReporter.T paramT2)
  {
    ArrayList localArrayList1 = new ArrayList();
    if (parambigb != null) {
      try
      {
        parambigb.p();
        if ((parambigb.jdField_a_of_type_Bihj != null) && (parambigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)) {
          break label61;
        }
        throw new IllegalStateException("have not attach ui and params");
      }
      catch (Throwable parambigb)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QIMReportController.DataReporter", 2, Log.getStackTraceString(parambigb));
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
    awtt localawtt;
    Object localObject4;
    label420:
    label425:
    boolean bool1;
    boolean bool2;
    if ((parambigb.jdField_a_of_type_Bihj.a() instanceof EditWebVideoActivity))
    {
      localObject1 = (EditWebVideoActivity)parambigb.jdField_a_of_type_Bihj.a();
      if (localObject1 != null)
      {
        localObject2 = ((Activity)localObject1).getIntent();
        localawtt = new awtt();
        localawtt.jdField_e_of_type_JavaLangString = "0";
        localawtt.g = DataReporter.Destination.UNKNOWN.toString();
        if (parambigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a != null)
        {
          localObject4 = (SessionInfo)parambigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.getParcelable("edit_send_session_info");
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
            localawtt.jdField_e_of_type_JavaLangString = ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString;
            localObject4 = a(((SessionInfo)localObject1).jdField_a_of_type_Int);
            localObject1 = localObject4;
            if (localObject4 == null) {
              localObject1 = DataReporter.Destination.UNKNOWN;
            }
            localawtt.g = ((DataReporter.Destination)localObject1).toString();
          }
        }
        localawtt.h = ("fake_vid_" + System.currentTimeMillis() + "-" + new Random(System.currentTimeMillis() + Thread.currentThread().getId()).nextInt());
      }
    }
    else
    {
      label476:
      double d;
      label491:
      label508:
      int i;
      switch (parambigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c())
      {
      case 1: 
        localObject1 = DataReporter.MsgEntry.UNDEFINE;
        localawtt.f = ((DataReporter.MsgEntry)localObject1).toString();
        localawtt.jdField_a_of_type_Int = 1;
        bool1 = parambigb.a();
        bool2 = ((bhdr)bhfm.a().c(13)).a();
        if (bool1)
        {
          localObject1 = DataReporter.MsgType.PICTURE.toString();
          localawtt.i = ((String)localObject1);
          if (!bool1) {
            break label1411;
          }
          d = 0.0D;
          localawtt.jdField_a_of_type_Double = d;
          if (!bool1) {
            break label1421;
          }
          paramT1 = paramT1.toString();
          localawtt.d = paramT1;
          localawtt.k = DataReporter.ElementType.OTHER.toString();
          localawtt.j = DataReporter.ContentSource.UNKNOWN.toString();
          localObject1 = DataReporter.ContentSource.UNKNOWN;
          if (localObject2 == null) {
            break label3727;
          }
          paramT1 = ((Intent)localObject2).getBundleExtra("state");
          if (!bool1) {
            break label1445;
          }
          i = ((Intent)localObject2).getIntExtra("pic_entrance_type", -1);
          if (i <= 0) {
            break label3754;
          }
          switch (i)
          {
          case 1: 
            localObject1 = DataReporter.ContentSource.EDIT_AFTER_SHOT;
            break label3754;
            if (paramT1 != DataReporter.ContentSource.UNKNOWN) {
              localawtt.j = paramT1.toString();
            }
            if ((paramT1 != DataReporter.ContentSource.UNKNOWN) && (parambigb.jdField_a_of_type_Bibz != null) && (parambigb.jdField_a_of_type_Bibz.c))
            {
              localawtt.j = paramT1.toString();
              localObject2 = new awtt(localawtt);
              ((awtt)localObject2).k = DataReporter.ElementType.CLIP.toString();
              ((awtt)localObject2).m = "";
              ((awtt)localObject2).l = "";
              localArrayList1.add(localObject2);
            }
            if (paramT1 != DataReporter.ContentSource.EDIT_AFTER_IMPORT)
            {
              localObject2 = new awtt(localawtt);
              ((awtt)localObject2).j = DataReporter.ContentSource.UNKNOWN.toString();
              ((awtt)localObject2).k = DataReporter.ElementType.CAMERA.toString();
              ((awtt)localObject2).l = "";
              if (ahhj.jdField_a_of_type_Int != 2) {
                break label1546;
              }
              ((awtt)localObject2).m = "back";
              localArrayList1.add(localObject2);
              if (GLVideoClipUtil.b())
              {
                localObject2 = new awtt(localawtt);
                ((awtt)localObject2).k = DataReporter.ElementType.DARK.toString();
                ((awtt)localObject2).l = "";
                ((awtt)localObject2).m = "on";
                localArrayList1.add(localObject2);
              }
            }
            if ((!bool1) && (parambigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null))
            {
              localObject2 = parambigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();
              if ((localObject2 != null) && ((localObject2 instanceof birp)))
              {
                localObject4 = new awtt(localawtt);
                ((awtt)localObject4).k = DataReporter.ElementType.SPEED.toString();
                ((awtt)localObject4).l = "";
                ((awtt)localObject4).m = ((bird)localObject2).toString();
                localArrayList1.add(localObject4);
              }
            }
            localObject2 = parambigb.jdField_a_of_type_Bief;
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
      case 103: 
      case 9: 
      case 10: 
      case 11: 
      case 100: 
      case 7: 
      case 105: 
      case 106: 
        label1152:
        label1411:
        label1421:
        label1557:
        try
        {
          label624:
          label632:
          if (!parambigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) {
            break label1557;
          }
          label792:
          localObject4 = parambigb.jdField_a_of_type_Bief.a().a().jdField_a_of_type_JavaUtilList;
          localObject2 = localObject4;
        }
        catch (NullPointerException localNullPointerException4)
        {
          label983:
          label1010:
          Object localObject5;
          Object localObject6;
          label1088:
          label1136:
          label1656:
          break label983;
          label1445:
          label1504:
          paramT1 = paramT2;
        }
        localObject4 = localObject2;
        if (localObject2 == null) {
          localObject4 = new ArrayList();
        }
        localObject4 = ((List)localObject4).iterator();
        do
        {
          do
          {
            if (!((Iterator)localObject4).hasNext()) {
              break;
            }
            localObject5 = (bijc)((Iterator)localObject4).next();
          } while (localObject5 == null);
          localObject6 = new awtt(localawtt);
          if (!(localObject5 instanceof biiz)) {
            break;
          }
          ((awtt)localObject6).k = DataReporter.ElementType.POSTER.toString();
          ((awtt)localObject6).l = ajjy.a(2131636988);
          ((awtt)localObject6).m = ((bijc)localObject5).jdField_e_of_type_JavaLangString;
          if ((paramT2 == DataReporter.T.VIDEO_RETAKE) || (paramT2 == DataReporter.T.VIDEO_SAVE) || (paramT2 == DataReporter.T.VIDEO_PUBLISH))
          {
            if ((((bijc)localObject5).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper == null) || (((bijc)localObject5).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isEmpty())) {
              break label1656;
            }
            ((awtt)localObject6).n = "1";
          }
          if (((bijc)localObject5).jdField_e_of_type_Int != 0) {
            break label1666;
          }
          localObject2 = DataReporter.ContentSource.BEFORE_SHOT.toString();
          ((awtt)localObject6).j = ((String)localObject2);
          localArrayList1.add(localObject6);
        } while (!((bijc)localObject5).d.equals(ajjy.a(2131636984)));
        localObject2 = new awtt();
        ((awtt)localObject2).m = ((bijc)localObject5).jdField_e_of_type_JavaLangString;
        ((awtt)localObject2).l = ((bijc)localObject5).d;
        ((awtt)localObject2).k = DataReporter.ElementType.POSTER.toString();
        ((awtt)localObject2).j = localawtt.d;
        ((awtt)localObject2).i = localawtt.i;
        if (((bijc)localObject5).g == 1) {
          ((awtt)localObject2).d = "0X8008C04";
        }
        for (;;)
        {
          awqt.b(null, (awtt)localObject2);
          break label1010;
          if ((parambigb.jdField_a_of_type_Bihj.a() instanceof EditVideoActivity))
          {
            localObject1 = (EditVideoActivity)parambigb.jdField_a_of_type_Bihj.a();
            break;
          }
          if (!(parambigb.jdField_a_of_type_Bihj.a() instanceof EditPicActivity)) {
            break label3742;
          }
          localObject1 = (EditPicActivity)parambigb.jdField_a_of_type_Bihj.a();
          break;
          localObject1 = DataReporter.MsgEntry.MOMENTS;
          break label425;
          localObject1 = DataReporter.MsgEntry.HOME;
          break label425;
          localObject1 = DataReporter.MsgEntry.AIO;
          break label425;
          localObject1 = DataReporter.MsgEntry.WEB;
          break label425;
          localObject1 = DataReporter.MsgEntry.TRIBE;
          break label425;
          localObject1 = DataReporter.MsgEntry.READINJOY;
          break label425;
          if (bool2)
          {
            localObject1 = DataReporter.MsgType.SEGMENT_VIDEO.toString();
            break label476;
          }
          localObject1 = DataReporter.MsgType.SHORT_VIDEO.toString();
          break label476;
          d = parambigb.a();
          break label491;
          paramT1 = paramT2.toString();
          break label508;
          localObject1 = DataReporter.ContentSource.EDIT_AFTER_SHOT;
          break label3754;
          localObject1 = DataReporter.ContentSource.EDIT_AFTER_IMPORT;
          break label3754;
          i = ((Intent)localObject2).getIntExtra("short_video_entrance_type", -1);
          if (i <= 0) {
            break label3714;
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
            localObject2 = DataReporter.ContentSource.EDIT_AFTER_IMPORT;
            localObject1 = paramT1;
            paramT1 = (DataReporter.T)localObject2;
            break;
            label1546:
            ((awtt)localObject2).m = "front";
            break label792;
            localObject4 = parambigb.jdField_a_of_type_Bief.a().a().jdField_a_of_type_JavaUtilList;
            localObject2 = localObject4;
            break label983;
            if (((bijc)localObject5).b)
            {
              ((awtt)localObject6).k = DataReporter.ElementType.POSTER.toString();
              ((awtt)localObject6).l = ajjy.a(2131636978);
              ((awtt)localObject6).m = ((bijc)localObject5).jdField_e_of_type_JavaLangString;
              break label1088;
            }
            ((awtt)localObject6).k = DataReporter.ElementType.POSTER.toString();
            ((awtt)localObject6).l = ((bijc)localObject5).d;
            ((awtt)localObject6).m = ((bijc)localObject5).jdField_e_of_type_JavaLangString;
            break label1088;
            ((awtt)localObject6).n = "0";
            break label1136;
            label1666:
            localObject2 = paramT1.toString();
            break label1152;
            if (((bijc)localObject5).g == 0) {
              ((awtt)localObject2).d = "0X8008C05";
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
        if (parambigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) {
          localObject2 = parambigb.jdField_a_of_type_Bief.a().a().jdField_a_of_type_JavaUtilList;
        }
        if (localObject2 != null)
        {
          localObject4 = ((List)localObject2).iterator();
          if (((Iterator)localObject4).hasNext())
          {
            localObject2 = (bijc)((Iterator)localObject4).next();
            if (localObject2 == null) {
              continue;
            }
            localObject5 = new awtt(localawtt);
            ((awtt)localObject5).k = DataReporter.ElementType.POSTER.toString();
            ((awtt)localObject5).l = ((bijc)localObject2).d;
            ((awtt)localObject5).m = ((bijc)localObject2).jdField_e_of_type_JavaLangString;
            if ((paramT2 == DataReporter.T.VIDEO_RETAKE) || (paramT2 == DataReporter.T.VIDEO_SAVE) || (paramT2 == DataReporter.T.VIDEO_PUBLISH))
            {
              if ((((bijc)localObject2).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper != null) && (!((bijc)localObject2).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isEmpty())) {
                ((awtt)localObject5).n = "1";
              }
            }
            else
            {
              if (((bijc)localObject2).jdField_e_of_type_Int != 0) {
                continue;
              }
              localObject2 = DataReporter.ContentSource.BEFORE_SHOT.toString();
              ((awtt)localObject5).j = ((String)localObject2);
              localArrayList1.add(localObject5);
              continue;
            }
            ((awtt)localObject5).n = "0";
            continue;
            localObject2 = paramT1.toString();
            continue;
          }
        }
        localObject2 = null;
        try
        {
          localObject4 = parambigb.jdField_a_of_type_Bief.a().a().jdField_a_of_type_JavaUtilArrayList;
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
          localObject4 = (bijr)((Iterator)localObject2).next();
          localObject5 = new awtt(localawtt);
          ((awtt)localObject5).k = "text";
          ((awtt)localObject5).l = "";
          localObject6 = ((bijr)localObject4).jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
          if (localObject6 != null)
          {
            ((awtt)localObject5).m = String.valueOf(((DynamicTextItem)localObject6).c());
            ((awtt)localObject5).j = paramT1.toString();
            if ((paramT2 == DataReporter.T.VIDEO_RETAKE) || (paramT2 == DataReporter.T.VIDEO_SAVE) || (paramT2 == DataReporter.T.VIDEO_PUBLISH))
            {
              if ((((bijr)localObject4).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper != null) && (!((bijr)localObject4).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isEmpty())) {
                ((awtt)localObject5).n = "1";
              }
            }
            else {
              localArrayList1.add(localObject5);
            }
          }
          else
          {
            ((awtt)localObject5).m = "";
            continue;
          }
          ((awtt)localObject5).n = "0";
          continue;
        }
        paramT2 = null;
        try
        {
          localObject2 = parambigb.jdField_a_of_type_Bief.a().a().a.a();
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
            localObject2 = (binj)paramT2.next();
            localObject4 = new awtt(localawtt);
            ((awtt)localObject4).l = ((binj)localObject2).a();
            ((awtt)localObject4).k = "doodle";
            if (((binj)localObject2).a(101))
            {
              if ((localObject2 instanceof biok)) {
                ((awtt)localObject4).m = ("#" + Integer.toHexString(((biok)localObject2).jdField_b_of_type_Int));
              }
              ((awtt)localObject4).j = paramT1.toString();
              localArrayList1.add(localObject4);
              continue;
            }
            ((awtt)localObject4).m = "";
            continue;
          }
        }
        localObject6 = new awtt(localawtt);
        paramT2 = bjac.a();
        localObject4 = paramT2.a;
        if (localObject4 != null)
        {
          localObject2 = localObject4[paramT2.c()];
          localObject5 = localObject4[0];
          if (localObject2 != null) {
            break label3711;
          }
          localObject2 = localObject5;
          if ((paramT2.a != null) && (localObject2 != null))
          {
            bool2 = ((QIMFilterCategoryItem)localObject2).jdField_a_of_type_Boolean;
            if (parambigb.jdField_a_of_type_Bicj == null) {
              break label3706;
            }
            paramT2 = (QIMFilterProviderView)parambigb.jdField_a_of_type_Bicj.a(QIMFilterProviderView.class);
            if ((paramT2 == null) || (paramT2.jdField_a_of_type_JavaUtilArrayList == null)) {
              break label3706;
            }
            paramT2 = paramT2.a();
            if (paramT2 == null) {
              break label3706;
            }
            if ((paramT2 != null) || (localObject1 == null)) {
              break label3703;
            }
            localObject4 = ((Bundle)localObject1).getBundle("container");
            if (localObject4 == null) {
              break label3703;
            }
            if (bool2)
            {
              localObject4 = ((Bundle)localObject4).getBundle(ComboProviderView.class.getSimpleName());
              if (localObject4 == null) {
                break label3703;
              }
              localObject4 = ((Bundle)localObject4).getParcelable("ProviderView.select_item_category");
              if (localObject4 == null) {
                break label3703;
              }
              paramT2 = (FilterCategory)localObject4;
              localArrayList2 = new ArrayList();
              localObject4 = (bhgs)bhfm.a(5);
              if ((paramT2 == null) && (((bhgs)localObject4).a() != null))
              {
                localObject4 = ((bhgs)localObject4).a().jdField_a_of_type_JavaUtilArrayList.iterator();
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
            ((awtt)localObject6).k = ((String)localObject4);
            if (paramT2 == null) {
              continue;
            }
            ((awtt)localObject6).l = paramT2.jdField_a_of_type_JavaLangString;
            if ((!((QIMFilterCategoryItem)localObject2).jdField_a_of_type_Boolean) && (((QIMFilterCategoryItem)localObject2).jdField_a_of_type_JavaUtilArrayList != null) && (!((QIMFilterCategoryItem)localObject2).jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
              continue;
            }
            ((awtt)localObject6).m = ((QIMFilterCategoryItem)localObject2).jdField_a_of_type_JavaLangString;
            if (paramT1 != DataReporter.ContentSource.EDIT_AFTER_IMPORT) {
              continue;
            }
            ((awtt)localObject6).j = paramT1.toString();
            localArrayList1.add(localObject6);
          }
        }
        if ((!"0".equals(bhfv.jdField_b_of_type_JavaLangString)) || (bhfv.jdField_b_of_type_Int != 0) || (!TextUtils.isEmpty(bhfv.jdField_a_of_type_JavaLangString)))
        {
          bhfv.c = 0;
          if (bhfv.jdField_b_of_type_JavaLangString == null) {
            bhfv.jdField_b_of_type_JavaLangString = "";
          }
          if (bhfv.jdField_a_of_type_JavaLangString == null) {
            bhfv.jdField_a_of_type_JavaLangString = "";
          }
          paramT2 = "";
          localObject2 = (bjin)bhfm.a(3);
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
            localObject1 = ((bjin)localObject2).a(bhfv.jdField_b_of_type_JavaLangString);
            if (localObject1 != null)
            {
              if (!TextUtils.isEmpty(paramT1)) {
                break label3700;
              }
              paramT1 = "";
              localObject2 = ((bjin)localObject2).a();
              paramT2 = paramT1;
              if (localObject2 != null)
              {
                localObject2 = ((ArrayList)localObject2).iterator();
                paramT2 = paramT1;
                if (((Iterator)localObject2).hasNext())
                {
                  localObject4 = (bhhq)((Iterator)localObject2).next();
                  paramT2 = ((bhhq)localObject4).jdField_a_of_type_JavaUtilList;
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
                    break label3695;
                  }
                  paramT1 = paramT2 + ((bhhq)localObject4).jdField_a_of_type_JavaLangString + ",";
                  break label3770;
                  localObject4 = DataReporter.ElementType.FILTER.toString();
                  continue;
                  ((awtt)localObject6).j = DataReporter.ContentSource.BEFORE_SHOT.toString();
                  if (!localArrayList2.isEmpty())
                  {
                    paramT2 = localArrayList2.iterator();
                    if (paramT2.hasNext())
                    {
                      localObject4 = (FilterCategory)paramT2.next();
                      ((awtt)localObject6).l = (((awtt)localObject6).l + ((FilterCategory)localObject4).jdField_a_of_type_JavaLangString + ",");
                      continue;
                    }
                  }
                  else
                  {
                    ((awtt)localObject6).l = "";
                  }
                  if ((TextUtils.isEmpty(((awtt)localObject6).l)) || (!((awtt)localObject6).l.endsWith(","))) {
                    continue;
                  }
                  ((awtt)localObject6).l = ((awtt)localObject6).l.substring(0, ((awtt)localObject6).l.length() - 1);
                  continue;
                  ((awtt)localObject6).m = ((String)((QIMFilterCategoryItem)localObject2).jdField_a_of_type_JavaUtilArrayList.get(0));
                  continue;
                  if ((localObject5 != null) && (((QIMFilterCategoryItem)localObject2).a() == ((QIMFilterCategoryItem)localObject5).a()) && (((QIMFilterCategoryItem)localObject2).a() != null) && (((QIMFilterCategoryItem)localObject2).a().equals(((QIMFilterCategoryItem)localObject5).a())))
                  {
                    ((awtt)localObject6).j = DataReporter.ContentSource.BEFORE_SHOT.toString();
                    continue;
                  }
                  ((awtt)localObject6).j = DataReporter.ContentSource.EDIT_AFTER_SHOT.toString();
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
              paramT2 = new awtt(localawtt);
              paramT2.j = DataReporter.ContentSource.BEFORE_SHOT.toString();
              paramT2.l = paramT1;
              paramT2.m = ((PtvTemplateManager.PtvTemplateInfo)localObject1).id;
              paramT2.k = DataReporter.ElementType.PENDANT.toString();
              localArrayList1.add(paramT2);
            }
          }
        }
        if (parambigb.jdField_a_of_type_Bhil != null)
        {
          paramT1 = parambigb.jdField_a_of_type_Bhil.a();
          if ((!bool1) && (paramT1 != null) && (!TextUtils.isEmpty(paramT1.mMusicName)))
          {
            paramT2 = new awtt(localawtt);
            paramT2.l = paramT1.mTagName;
            paramT2.m = paramT1.mMusicName;
            paramT2.k = DataReporter.ElementType.MUSIC.toString();
            localArrayList1.add(paramT2);
          }
        }
        if (localArrayList1.isEmpty()) {
          localArrayList1.add(localawtt);
        }
        if (parambigb.jdField_a_of_type_Bifv != null)
        {
          paramT1 = parambigb.jdField_a_of_type_Bifv.a();
          if (paramT1 != null)
          {
            paramT1 = paramT1.jdField_a_of_type_JavaLangString;
            if (paramT1 != null)
            {
              paramT2 = new awtt(localawtt);
              paramT2.l = paramT1;
              paramT2.k = DataReporter.ElementType.LINKER.toString();
              if (paramT2.g.equals(DataReporter.Destination.UNKNOWN.toString())) {
                paramT2.g = DataReporter.Destination.MOMENTS.toString();
              }
              localArrayList1.add(paramT2);
            }
          }
        }
        if (parambigb.jdField_a_of_type_Bihk == null) {
          break;
        }
        parambigb = parambigb.jdField_a_of_type_Bihk.a();
        if ((parambigb == null) || (parambigb.jdField_a_of_type_Int != 5)) {
          break;
        }
        parambigb = new awtt(localawtt);
        parambigb.k = DataReporter.ElementType.FRWRD_LINKER.toString();
        if (parambigb.g.equals(DataReporter.Destination.UNKNOWN.toString())) {
          parambigb.g = DataReporter.Destination.MOMENTS.toString();
        }
        localArrayList1.add(parambigb);
        return localArrayList1;
        paramT1 = "";
        continue;
      }
      catch (NullPointerException localNullPointerException2)
      {
        localObject3 = localNullPointerException3;
        continue;
      }
      label3695:
      label3700:
      continue;
      label3703:
      continue;
      label3706:
      paramT2 = null;
      continue;
      label3711:
      continue;
      label3714:
      Object localObject3 = paramT1;
      paramT1 = (DataReporter.T)localObject1;
      localObject1 = localObject3;
      break label632;
      label3727:
      paramT1 = (DataReporter.T)localObject1;
      localObject1 = null;
      break label632;
      localObject3 = null;
      break label102;
      label3742:
      localObject1 = null;
      break label90;
      break label420;
      break label624;
      label3754:
      localObject3 = paramT1;
      paramT1 = (DataReporter.T)localObject1;
      localObject1 = localObject3;
      break label632;
      break label1504;
      label3770:
      paramT2 = paramT1;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, @NonNull List<awtt> paramList)
  {
    if (paramQQAppInterface == null) {}
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      paramList = paramList.iterator();
      if (paramList.hasNext()) {
        localArrayList.add(new awtt((awtt)paramList.next()));
      }
    }
    ThreadManager.post(new DataReporter.1(this, localArrayList, paramQQAppInterface), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.DataReporter
 * JD-Core Version:    0.7.0.1
 */