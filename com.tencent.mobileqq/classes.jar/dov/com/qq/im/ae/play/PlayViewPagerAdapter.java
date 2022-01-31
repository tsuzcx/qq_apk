package dov.com.qq.im.ae.play;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import bira;
import bire;
import biws;
import bizx;
import bjah;
import java.util.LinkedList;
import java.util.List;

public class PlayViewPagerAdapter
  extends PagerAdapter
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private biws jdField_a_of_type_Biws;
  private AEPlayShowPageView jdField_a_of_type_DovComQqImAePlayAEPlayShowPageView;
  private List<bira> jdField_a_of_type_JavaUtilList;
  
  public PlayViewPagerAdapter(@NonNull Context paramContext, @NonNull biws parambiws, @NonNull List<bira> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Biws = parambiws;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  private int a(int paramInt)
  {
    bira localbira = (bira)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localbira == null) {
      return 2;
    }
    return localbira.b;
  }
  
  private String a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
      return ((bira)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString;
    }
    return "-1";
  }
  
  private List<bire> a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaUtilList.size() > paramInt) {
        localObject1 = (bira)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      }
    }
    if ((localObject1 == null) || (((bira)localObject1).jdField_a_of_type_JavaUtilList == null)) {
      return new LinkedList();
    }
    return ((bira)localObject1).jdField_a_of_type_JavaUtilList;
  }
  
  public AEPlayShowPageView a()
  {
    return this.jdField_a_of_type_DovComQqImAePlayAEPlayShowPageView;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Int <= 0) {
      return "-1";
    }
    return a(this.jdField_a_of_type_Int);
  }
  
  public List<bira> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<bira> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if ((paramObject instanceof AEPlayShowPageView)) {
      ((AEPlayShowPageView)paramObject).c();
    }
    bjah.a("AEPlayShowPart", "page destroy.......");
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AEPlayShowPageView localAEPlayShowPageView = new AEPlayShowPageView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Biws, a(paramInt), a(paramInt));
    paramViewGroup.addView(localAEPlayShowPageView);
    return localAEPlayShowPageView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    super.setPrimaryItem(paramViewGroup, paramInt, paramObject);
    if ((paramObject instanceof AEPlayShowPageView)) {
      this.jdField_a_of_type_DovComQqImAePlayAEPlayShowPageView = ((AEPlayShowPageView)paramObject);
    }
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt))
      {
        paramViewGroup = (bira)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (paramViewGroup != null) {
          bizx.a().g(paramViewGroup.jdField_a_of_type_JavaLangString + "");
        }
      }
      if ((paramObject instanceof AEPlayShowPageView))
      {
        this.jdField_a_of_type_DovComQqImAePlayAEPlayShowPageView.post(new PlayViewPagerAdapter.1(this, paramInt));
        this.jdField_a_of_type_DovComQqImAePlayAEPlayShowPageView.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.play.PlayViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */