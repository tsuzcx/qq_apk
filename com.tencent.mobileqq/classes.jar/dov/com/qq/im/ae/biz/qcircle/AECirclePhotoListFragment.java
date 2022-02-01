package dov.com.qq.im.ae.biz.qcircle;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import dov.com.qq.im.ae.biz.qcircle.event.AECircleClearAllSelectEvent;
import dov.com.qq.im.ae.biz.qcircle.event.AECircleSelectChangeEvent;
import dov.com.qq.im.ae.biz.qcircle.part.AECircleAlbumListPart;
import dov.com.qq.im.ae.biz.qcircle.part.AECirclePhotoListPart;
import dov.com.qq.im.ae.biz.qcircle.part.AECirclePreviewPart;
import dov.com.qq.im.ae.biz.qcircle.part.AECircleSelectPanelPart;
import dov.com.qq.im.ae.biz.qcircle.part.AECircleTitleChipPart;
import dov.com.qq.im.ae.biz.qcircle.part.base.AECircleBasePart;
import dov.com.qq.im.ae.biz.qcircle.part.base.AECircleBasePartFragment;
import dov.com.qq.im.ae.biz.qcircle.part.base.AECirclePartManager;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.ArrayList;
import java.util.List;

public class AECirclePhotoListFragment
  extends AECircleBasePartFragment
  implements SimpleEventReceiver
{
  public PhotoListBaseData a;
  public AECirclePhotoListLogic a;
  AECircleAlbumListPart jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleAlbumListPart;
  AECirclePhotoListPart jdField_a_of_type_DovComQqImAeBizQcirclePartAECirclePhotoListPart;
  AECirclePreviewPart jdField_a_of_type_DovComQqImAeBizQcirclePartAECirclePreviewPart;
  AECircleSelectPanelPart jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleSelectPanelPart;
  AECircleTitleChipPart jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleTitleChipPart;
  
  private void a()
  {
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic = new AECirclePhotoListLogic(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData = this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData;
    Intent localIntent = getActivity().getIntent();
    if (localIntent == null) {
      QLog.d("SelectPhotoTrace", 1, "AECirclePhotoListFragment initLogic() intent is null!");
    }
    do
    {
      return;
      this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a(localIntent);
    } while (!QLog.isColorLevel());
    QLog.d("SelectPhotoTrace", 2, "AECirclePhotoListFragment initLogic(),extra is:" + localIntent.getExtras());
  }
  
  public int a()
  {
    return 2131558509;
  }
  
  public List<AECircleBasePart> a()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleAlbumListPart = new AECircleAlbumListPart(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic);
    this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECirclePhotoListPart = new AECirclePhotoListPart(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic);
    this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECirclePreviewPart = new AECirclePreviewPart(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic);
    this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleSelectPanelPart = new AECircleSelectPanelPart(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic);
    this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleTitleChipPart = new AECircleTitleChipPart(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic);
    localArrayList.add(this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleAlbumListPart);
    localArrayList.add(this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECirclePhotoListPart);
    localArrayList.add(this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECirclePreviewPart);
    localArrayList.add(this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleSelectPanelPart);
    localArrayList.add(this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleTitleChipPart);
    return localArrayList;
  }
  
  public boolean a()
  {
    return (a() != null) && (a().a());
  }
  
  public boolean b()
  {
    return (a() == null) || (a().b());
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AECircleClearAllSelectEvent.class);
    return localArrayList;
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    a();
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT > 23) {
      getActivity().getWindow().setBackgroundDrawable(null);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "AECirclePhotoListFragment,hashCode is:" + System.identityHashCode(this));
    }
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    try
    {
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(a(), paramViewGroup, false);
      a(paramLayoutInflater, paramViewGroup, paramBundle);
      ViewCompat.setOnApplyWindowInsetsListener(this.jdField_a_of_type_AndroidViewView, new AECirclePhotoListFragment.1(this));
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.post(new AECirclePhotoListFragment.2(this));
      }
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
      FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("AECirclePhotoListFragment", 1, localThrowable, new Object[0]);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.b();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onPause()
  {
    AEQLog.b("AECirclePhotoListFragment", "onPause---");
    super.onPause();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof AECircleClearAllSelectEvent)) && (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic != null))
    {
      this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.d();
      SimpleEventBus.getInstance().dispatchEvent(new AECircleSelectChangeEvent());
    }
  }
  
  public void onResume()
  {
    AEQLog.b("AECirclePhotoListFragment", "onResume---");
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.AECirclePhotoListFragment
 * JD-Core Version:    0.7.0.1
 */