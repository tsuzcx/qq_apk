package dov.com.qq.im.capture.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.LayoutInflater;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.widget.bounce.BounceViewPager;
import com.tencent.mobileqq.widget.bounce.BounceViewPager.PageChangedObserver;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.IFaceSelectedListener;
import dov.com.qq.im.capture.music.CaptureConfigUpdateObserver;
import dov.com.qq.im.capture.paster.PasterDataManager;
import dov.com.qq.im.capture.paster.QIMPasterConfigManager;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle.DoodleFacePanelAdapter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage.FacePackagePageEventListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePackage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.AdapterObserver;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.FacePagerAdapter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.FacePanelBaseAdapter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(9)
public class StaticStickerProviderView
  extends ProviderView
  implements BounceViewPager.PageChangedObserver, QIMSlidingTabView.IOnTabCheckListener, AdapterObserver
{
  private int jdField_a_of_type_Int = 0;
  BounceViewPager jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager;
  private IFaceSelectedListener jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener;
  CaptureConfigUpdateObserver jdField_a_of_type_DovComQqImCaptureMusicCaptureConfigUpdateObserver = new StaticStickerProviderView.2(this);
  FacePagerAdapter jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter;
  FacePanelBaseAdapter jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter;
  public ArrayList<String> a;
  
  public StaticStickerProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(PasterDataManager paramPasterDataManager, EditVideoDoodle.DoodleFacePanelAdapter paramDoodleFacePanelAdapter)
  {
    paramPasterDataManager = new ArrayList(paramPasterDataManager.a());
    paramDoodleFacePanelAdapter.a(false);
    paramDoodleFacePanelAdapter.a(paramPasterDataManager);
  }
  
  public static void a(Collection<FacePackage> paramCollection)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StaticStickerProviderView", 2, "random tab shufflePaster");
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      FacePackage localFacePackage = (FacePackage)paramCollection.next();
      if (localFacePackage.jdField_a_of_type_Boolean) {
        if ((localFacePackage instanceof NormalFacePackage)) {
          Collections.shuffle(((NormalFacePackage)localFacePackage).a);
        } else if ((localFacePackage instanceof LocationFacePackage)) {
          Collections.shuffle(((LocationFacePackage)localFacePackage).a);
        }
      }
    }
  }
  
  private void j()
  {
    ArrayList localArrayList1 = ((QIMPasterConfigManager)QIMManager.a(1)).a();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < localArrayList1.size())
    {
      if (((DoodleEmojiItem)localArrayList1.get(i)).hide != 1)
      {
        String str = ((DoodleEmojiItem)localArrayList1.get(i)).name;
        if (!localArrayList2.contains(str)) {
          localArrayList2.add(str);
        }
      }
      i += 1;
    }
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.initTabItemsWithString(localArrayList2);
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList2;
  }
  
  private void k()
  {
    long l1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long l2 = (Runtime.getRuntime().maxMemory() * 0.8D);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("clearMemory ");
      if (l1 <= l2) {
        break label91;
      }
    }
    label91:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("StaticStickerProviderView", 2, bool);
      if ((l1 > l2) && (GlobalImageCache.a != null)) {
        GlobalImageCache.a.evictAll();
      }
      return;
    }
  }
  
  protected int a()
  {
    return 2131561017;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.b(this);
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter.b(this);
    }
    EditVideoDoodle.DoodleFacePanelAdapter localDoodleFacePanelAdapter = ((PasterDataManager)QIMManager.a(4)).a();
    if (localDoodleFacePanelAdapter != null) {
      localDoodleFacePanelAdapter.b(this);
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_DovComQqImCaptureMusicCaptureConfigUpdateObserver);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.onTabChecked(paramInt);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.b(paramInt);
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      if (paramInt1 >= this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem()) {
        break label28;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.c(paramInt1);
    }
    label28:
    while (paramInt1 != this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem()) {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.c(paramInt1 + 1);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131561017, this, false);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager = ((BounceViewPager)findViewById(2131366551));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter = new FacePagerAdapter(super.getContext());
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setAdapter(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.a(this);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    j();
    PasterDataManager localPasterDataManager = (PasterDataManager)QIMManager.a(4);
    localPasterDataManager.forceInit();
    paramBundle = localPasterDataManager.a();
    a(localPasterDataManager, paramBundle);
    setAdapter(paramBundle);
    Activity localActivity = (Activity)getContext();
    setDownloadListener(new StaticStickerProviderView.1(this, localActivity));
    paramBundle = (DoodleLayout)localActivity.findViewById(2131365966);
    if (paramBundle == null) {
      paramBundle = (DoodleLayout)localActivity.findViewById(2131364390);
    }
    for (;;)
    {
      setOnFaceSelectedListener(paramBundle.a());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_DovComQqImCaptureMusicCaptureConfigUpdateObserver);
      localPasterDataManager.a(true, (Activity)getContext());
      return;
    }
  }
  
  public void a(GestureHelper.ZoomItem paramZoomItem)
  {
    if (((paramZoomItem instanceof FaceLayer.FaceItem)) && (this.jdField_a_of_type_JavaUtilArrayList != null))
    {
      Object localObject = (FaceLayer.FaceItem)paramZoomItem;
      paramZoomItem = ((FaceLayer.FaceItem)localObject).e;
      localObject = ((FaceLayer.FaceItem)localObject).d;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (TextUtils.equals((String)this.jdField_a_of_type_JavaUtilArrayList.get(i), (CharSequence)localObject))
        {
          onTabChecked(i);
          postDelayed(new StaticStickerProviderView.3(this, i, paramZoomItem), 200L);
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StaticStickerProviderView", 2, "selectPosition category=" + (String)localObject + " name=" + paramZoomItem);
      }
    }
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener != null) {
      this.jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener.a();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.d(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem());
    }
  }
  
  public void c()
  {
    super.c();
    PasterDataManager localPasterDataManager = (PasterDataManager)QIMManager.a(4);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.notifyDataSetChanged();
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramInt);
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.removeAllViews();
    k();
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("StaticStickerProviderView", 2, "random tab paster onResume");
    }
    i();
  }
  
  public void g()
  {
    j();
    PasterDataManager localPasterDataManager = (PasterDataManager)QIMManager.a(4);
    EditVideoDoodle.DoodleFacePanelAdapter localDoodleFacePanelAdapter = localPasterDataManager.a();
    if (localDoodleFacePanelAdapter != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("StaticStickerProviderView", 2, "paster config updateData");
      }
      a(localPasterDataManager, localDoodleFacePanelAdapter);
      setAdapter(localDoodleFacePanelAdapter);
      h();
      this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.onTabChecked(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem());
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a();
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter != null) && (PasterDataManager.a.compareAndSet(true, false))) {
      g();
    }
  }
  
  public void onTabChecked(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(paramInt);
    if (DoodleLayout.jdField_a_of_type_Boolean) {}
    for (Object localObject = "2";; localObject = "1")
    {
      DoodleLayout.a("change_face", 0, 0, new String[] { localObject });
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter != null)
      {
        localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter.a(paramInt);
        if ((localObject != null) && ((localObject instanceof FacePackage)))
        {
          VideoEditReport.a("0X80076C7", "", "", ((FacePackage)localObject).jdField_a_of_type_JavaLangString, "");
          VideoEditReport.a("0X80075DC", ((FacePackage)localObject).jdField_a_of_type_JavaLangString);
        }
      }
      if (paramInt == 1)
      {
        VideoEditReport.a("0X80076CC");
        VideoEditReport.b("0X80075E1");
      }
      return;
    }
  }
  
  public void setAdapter(FacePanelBaseAdapter paramFacePanelBaseAdapter)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter.b(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter = null;
    }
    if (paramFacePanelBaseAdapter != null)
    {
      paramFacePanelBaseAdapter.b(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter = paramFacePanelBaseAdapter;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter.a(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter);
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(paramInt);
  }
  
  public void setDownloadListener(FaceListPage.FacePackagePageEventListener paramFacePackagePageEventListener)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramFacePackagePageEventListener);
  }
  
  public void setOnFaceSelectedListener(IFaceSelectedListener paramIFaceSelectedListener)
  {
    this.jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener = paramIFaceSelectedListener;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePagerAdapter.a(paramIFaceSelectedListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.capture.view.StaticStickerProviderView
 * JD-Core Version:    0.7.0.1
 */