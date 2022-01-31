package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.IFaceSelectedListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage.FacePackagePageEventListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePackage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FacePagerAdapter
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private IFaceSelectedListener jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener;
  private FaceListPage.FacePackagePageEventListener jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener;
  private FacePanelBaseAdapter jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter;
  private List jdField_a_of_type_JavaUtilList = new LinkedList();
  
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
        if (((FaceListPage)localObject2).jdField_a_of_type_Int != paramInt) {
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
        if ((localFaceListPage.jdField_a_of_type_Int == paramInt) && (localFaceListPage.jdField_a_of_type_Boolean)) {
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
  
  public void b(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FaceListPage localFaceListPage = (FaceListPage)localIterator.next();
      if (localFaceListPage.jdField_a_of_type_Int == paramInt)
      {
        if (!localFaceListPage.jdField_a_of_type_Boolean)
        {
          FacePackage localFacePackage = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter.a(paramInt);
          localFaceListPage.jdField_a_of_type_Boolean = true;
          localFaceListPage.a(localFacePackage);
        }
        localFaceListPage.a();
      }
    }
  }
  
  public void c(int paramInt)
  {
    boolean bool = true;
    FaceListPage localFaceListPage = a(paramInt);
    if ((localFaceListPage == null) || (localFaceListPage.jdField_a_of_type_Boolean))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("notifyNextPageShow loaded position:").append(paramInt).append(", page:");
        if (localFaceListPage == null) {
          break label68;
        }
      }
      for (;;)
      {
        QLog.i("FacePagerAdapter", 2, bool);
        return;
        label68:
        bool = false;
      }
    }
    Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter.a(paramInt);
    localFaceListPage.jdField_a_of_type_Boolean = true;
    localFaceListPage.a((FacePackage)localObject);
  }
  
  public void d(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        FaceListPage localFaceListPage = (FaceListPage)localIterator.next();
        if ((localFaceListPage.jdField_a_of_type_Int != paramInt) && (localFaceListPage.jdField_a_of_type_Boolean))
        {
          localFaceListPage.jdField_a_of_type_Boolean = false;
          localFaceListPage.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter.a(localFaceListPage.jdField_a_of_type_Int));
          if (QLog.isColorLevel()) {
            QLog.i("FacePagerAdapter", 2, "clearOtherView position:" + localFaceListPage.jdField_a_of_type_Int + ", current:" + paramInt);
          }
        }
      }
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (FaceListPage)paramObject;
    paramViewGroup.removeView(paramObject);
    paramObject.jdField_a_of_type_Int = -1;
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
    FaceListPage localFaceListPage = new FaceListPage(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener);
    paramViewGroup.addView(localFaceListPage);
    localFaceListPage.jdField_a_of_type_Int = paramInt;
    if (((ViewPager)paramViewGroup).getCurrentItem() == paramInt) {}
    for (localFaceListPage.jdField_a_of_type_Boolean = true;; localFaceListPage.jdField_a_of_type_Boolean = false)
    {
      localFaceListPage.a(localFacePackage);
      this.jdField_a_of_type_JavaUtilList.add(localFaceListPage);
      return localFaceListPage;
    }
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