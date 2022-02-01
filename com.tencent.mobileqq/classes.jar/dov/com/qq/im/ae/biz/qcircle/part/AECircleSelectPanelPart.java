package dov.com.qq.im.ae.biz.qcircle.part;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper;
import dov.com.qq.im.ae.biz.qcircle.AECirclePhotoListLogic;
import dov.com.qq.im.ae.biz.qcircle.adapter.PicPreviewMoveAdapter;
import dov.com.qq.im.ae.biz.qcircle.event.AECircleChangeBottomTabVisibleEvent;
import dov.com.qq.im.ae.biz.qcircle.event.AECircleSelectChangeEvent;
import dov.com.qq.im.ae.biz.qcircle.event.AECircleTitleAlbumMenuChangeEvent;
import dov.com.qq.im.ae.biz.qcircle.helper.PicDragHelperCallback;
import dov.com.qq.im.ae.biz.qcircle.helper.PicItemDecoration;
import dov.com.qq.im.ae.biz.qcircle.part.base.AECircleBasePart;
import java.util.ArrayList;

public class AECircleSelectPanelPart
  extends AECircleBasePart
  implements SimpleEventReceiver
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ItemTouchHelper jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper;
  private PicPreviewMoveAdapter jdField_a_of_type_DovComQqImAeBizQcircleAdapterPicPreviewMoveAdapter;
  private PicDragHelperCallback jdField_a_of_type_DovComQqImAeBizQcircleHelperPicDragHelperCallback;
  
  public AECircleSelectPanelPart(AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    super(paramAECirclePhotoListLogic);
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a(this);
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131373074);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131377428));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380512));
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPicPreviewMoveAdapter = new PicPreviewMoveAdapter(paramView.getContext(), this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic);
    this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPicPreviewMoveAdapter.a(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a.selectedPhotoList);
    paramView = new LinearLayoutManager(paramView.getContext());
    paramView.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new PicItemDecoration(8));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPicPreviewMoveAdapter);
    this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPicPreviewMoveAdapter.a(new AECircleSelectPanelPart.2(this));
    this.jdField_a_of_type_DovComQqImAeBizQcircleHelperPicDragHelperCallback = new PicDragHelperCallback(this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPicPreviewMoveAdapter, null);
    this.jdField_a_of_type_DovComQqImAeBizQcircleHelperPicDragHelperCallback.a(1.2F);
    this.jdField_a_of_type_DovComQqImAeBizQcircleHelperPicDragHelperCallback.b(0.9F);
    this.jdField_a_of_type_DovComQqImAeBizQcircleHelperPicDragHelperCallback.a(new AECircleSelectPanelPart.3(this));
    this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper = new ItemTouchHelper(this.jdField_a_of_type_DovComQqImAeBizQcircleHelperPicDragHelperCallback);
    this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper.attachToRecyclerView(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
  }
  
  public String a()
  {
    return "AECircleSelectPanelPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    b(paramView);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AECircleSelectChangeEvent.class);
    localArrayList.add(AECircleTitleAlbumMenuChangeEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AECircleSelectChangeEvent)) {
      if ((this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic != null) && (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a != null) && (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a.selectedPhotoList != null))
      {
        QLog.d("AECircleSelectPanelPart", 4, "onReceiveEvent");
        if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a.selectedPhotoList.size() <= 0) {
          break label256;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPicPreviewMoveAdapter.notifyDataSetChanged();
        this.jdField_a_of_type_AndroidWidgetTextView.setText("已选中" + this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a.selectedPhotoList.size() + "个");
        if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a.selectedPhotoList.size() >= 2)
        {
          paramSimpleBaseEvent = BaseApplication.getContext().getSharedPreferences("share", 4);
          bool = paramSimpleBaseEvent.getBoolean("ae_camera_is_show_tip", true);
          localView = a().findViewById(2131370687);
          if (!bool) {
            break label247;
          }
          localView.setVisibility(0);
          paramSimpleBaseEvent.edit().putBoolean("ae_camera_is_show_tip", false).apply();
          localView.postDelayed(new AECircleSelectPanelPart.1(this, localView), 4000L);
        }
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a.selectedPhotoList.size() - 1);
        SimpleEventBus.getInstance().dispatchEvent(new AECircleChangeBottomTabVisibleEvent());
      }
    }
    label247:
    while (!(paramSimpleBaseEvent instanceof AECircleTitleAlbumMenuChangeEvent)) {
      for (;;)
      {
        boolean bool;
        View localView;
        return;
        localView.setVisibility(8);
        continue;
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
    label256:
    if (((AECircleTitleAlbumMenuChangeEvent)paramSimpleBaseEvent).getIsShow()) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      SimpleEventBus.getInstance().dispatchEvent(new AECircleChangeBottomTabVisibleEvent());
      return;
      if ((this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic != null) && (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a != null) && (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a.selectedPhotoList != null))
      {
        QLog.d("AECircleSelectPanelPart", 4, "onReceiveEvent");
        if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a.selectedPhotoList.size() > 0) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.part.AECircleSelectPanelPart
 * JD-Core Version:    0.7.0.1
 */