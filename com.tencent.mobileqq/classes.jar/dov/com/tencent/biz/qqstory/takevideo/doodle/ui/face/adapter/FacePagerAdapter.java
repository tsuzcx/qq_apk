package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import bjcd;
import bkfh;
import bkfi;
import bkga;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FacePagerAdapter
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bjcd jdField_a_of_type_Bjcd;
  private bkfh jdField_a_of_type_Bkfh;
  private bkga jdField_a_of_type_Bkga;
  private List<FaceListPage> jdField_a_of_type_JavaUtilList = new LinkedList();
  
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
    bkfi localbkfi = this.jdField_a_of_type_Bkga.a(paramInt);
    if (localbkfi != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        FaceListPage localFaceListPage = (FaceListPage)localIterator.next();
        if ((localFaceListPage.jdField_a_of_type_Int == paramInt) && (localFaceListPage.jdField_a_of_type_Boolean)) {
          localFaceListPage.a(localbkfi);
        }
      }
    }
  }
  
  public void a(bjcd parambjcd)
  {
    this.jdField_a_of_type_Bjcd = parambjcd;
  }
  
  public void a(bkfh parambkfh)
  {
    this.jdField_a_of_type_Bkfh = parambkfh;
  }
  
  public void a(bkga parambkga)
  {
    this.jdField_a_of_type_Bkga = parambkga;
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
          bkfi localbkfi = this.jdField_a_of_type_Bkga.a(paramInt);
          localFaceListPage.jdField_a_of_type_Boolean = true;
          localFaceListPage.a(localbkfi);
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
    Object localObject = this.jdField_a_of_type_Bkga.a(paramInt);
    localFaceListPage.jdField_a_of_type_Boolean = true;
    localFaceListPage.a((bkfi)localObject);
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
          localFaceListPage.a(this.jdField_a_of_type_Bkga.a(localFaceListPage.jdField_a_of_type_Int));
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
    if (this.jdField_a_of_type_Bkga == null) {
      return 0;
    }
    return this.jdField_a_of_type_Bkga.a();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_Bkga == null) {
      return null;
    }
    bkfi localbkfi = this.jdField_a_of_type_Bkga.a(paramInt);
    FaceListPage localFaceListPage = new FaceListPage(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bjcd, this.jdField_a_of_type_Bkfh);
    paramViewGroup.addView(localFaceListPage);
    localFaceListPage.jdField_a_of_type_Int = paramInt;
    if (((ViewPager)paramViewGroup).getCurrentItem() == paramInt) {}
    for (localFaceListPage.jdField_a_of_type_Boolean = true;; localFaceListPage.jdField_a_of_type_Boolean = false)
    {
      localFaceListPage.a(localbkfi);
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