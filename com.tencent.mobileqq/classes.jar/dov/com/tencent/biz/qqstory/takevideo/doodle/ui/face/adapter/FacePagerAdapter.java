package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import dov.com.qq.im.capture.data.IFaceSelectedListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage.FacePackagePageEventListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePackage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager.PageChangedObserver;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FacePagerAdapter
  extends PagerAdapter
  implements FaceViewPager.PageChangedObserver
{
  private Context jdField_a_of_type_AndroidContentContext;
  private IFaceSelectedListener jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener;
  private FaceListPage.FacePackagePageEventListener jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener;
  private FacePanelBaseAdapter jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter;
  private List jdField_a_of_type_JavaUtilList = new LinkedList();
  private Queue jdField_a_of_type_JavaUtilQueue = new LinkedList();
  
  public FacePagerAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public FaceListPage a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      localObject2 = localObject1;
      if (localIterator.hasNext())
      {
        localObject2 = (FaceListPage)localIterator.next();
        if (((FaceListPage)localObject2).a != paramInt) {
          break label60;
        }
        localObject1 = localObject2;
      }
    }
    label60:
    for (;;)
    {
      break;
      return localObject2;
    }
  }
  
  public void a()
  {
    notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    FacePackage localFacePackage = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter.a(paramInt);
    if (localFacePackage != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        FaceListPage localFaceListPage = (FaceListPage)localIterator.next();
        if (localFaceListPage.a == paramInt) {
          localFaceListPage.a(localFacePackage);
        }
      }
    }
  }
  
  public void a(IFaceSelectedListener paramIFaceSelectedListener)
  {
    this.jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener = paramIFaceSelectedListener;
  }
  
  public void a(FaceListPage.FacePackagePageEventListener paramFacePackagePageEventListener)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener = paramFacePackagePageEventListener;
  }
  
  public void a(FacePanelBaseAdapter paramFacePanelBaseAdapter)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter = paramFacePanelBaseAdapter;
    notifyDataSetChanged();
  }
  
  public void c(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FaceListPage localFaceListPage = (FaceListPage)localIterator.next();
      if (localFaceListPage.a == paramInt) {
        localFaceListPage.a();
      }
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (FaceListPage)paramObject;
    paramViewGroup.removeView(paramObject);
    paramObject.a = -1;
    paramObject.a(null);
    this.jdField_a_of_type_JavaUtilList.remove(paramObject);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter == null) {
      return 0;
    }
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter.a();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter == null) {
      return null;
    }
    FacePackage localFacePackage = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter.a(paramInt);
    FaceListPage localFaceListPage2 = (FaceListPage)this.jdField_a_of_type_JavaUtilQueue.poll();
    FaceListPage localFaceListPage1 = localFaceListPage2;
    if (localFaceListPage2 == null) {
      localFaceListPage1 = new FaceListPage(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener);
    }
    paramViewGroup.addView(localFaceListPage1);
    localFaceListPage1.a = paramInt;
    localFaceListPage1.a(localFacePackage);
    this.jdField_a_of_type_JavaUtilList.add(localFaceListPage1);
    return localFaceListPage1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.FacePagerAdapter
 * JD-Core Version:    0.7.0.1
 */