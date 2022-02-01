package dov.com.qq.im.ae.biz.qcircle.part;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.album.data.AEAlbumLogicData;
import dov.com.qq.im.ae.biz.qcircle.AECirclePhotoListLogic;
import dov.com.qq.im.ae.biz.qcircle.event.AECircleSelectChangeEvent;
import dov.com.qq.im.ae.biz.qcircle.part.base.AECircleBasePart;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class AECircleTitleChipPart
  extends AECircleBasePart
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public AECircleTitleChipPart(AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    super(paramAECirclePhotoListLogic);
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a(this);
  }
  
  @Nullable
  private LocalMediaInfo a(Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap != null) {
        localObject1 = (LocalMediaInfo)this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.get(paramObject);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData != null)
      {
        localObject2 = localObject1;
        if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap != null) {
          localObject2 = (LocalMediaInfo)this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap.get(paramObject);
        }
      }
    }
    return localObject2;
  }
  
  public String a()
  {
    return "AECircleTitleChipPart";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedPhotoList.size() + this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().initialHasPickedNum < 1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369487);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369518));
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    a();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AECircleSelectChangeEvent.class);
    return localArrayList;
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic == null) {}
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        i = paramView.getId();
        if (i != 2131369487) {
          break;
        }
        this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a(paramView);
      }
    } while ((i != 2131369518) || (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData == null) || (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList == null));
    int j = this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
    AEBaseReportParam.a().a().a = AEBaseReportParam.a().b();
    long l = 0L;
    Object localObject = this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      LocalMediaInfo localLocalMediaInfo = a(((Iterator)localObject).next());
      if ((localLocalMediaInfo != null) && (QAlbumUtil.getMediaType(localLocalMediaInfo) == 1))
      {
        i += 1;
        l += localLocalMediaInfo.mDuration / 1000L;
      }
    }
    if (i > 0)
    {
      AEBaseReportParam.a().a().b = AEBaseReportParam.g.longValue();
      AEBaseReportParam.a().a().f = i;
      AEBaseReportParam.a().a().c = l;
      j -= i;
      label220:
      AEBaseDataReporter.a().a(j);
      if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum <= 0) {
        break label292;
      }
      bool1 = true;
      label243:
      AEReportUtils.a(bool1, j, i);
      localObject = this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic;
      if (i <= 0) {
        break label298;
      }
    }
    label292:
    label298:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((AECirclePhotoListLogic)localObject).b(bool1);
      break;
      AEBaseReportParam.a().a().b = AEBaseReportParam.d.longValue();
      break label220;
      bool1 = false;
      break label243;
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AECircleSelectChangeEvent)) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.part.AECircleTitleChipPart
 * JD-Core Version:    0.7.0.1
 */