package dov.com.qq.im.capture.adapter;

import actj;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import bfpt;
import bjbc;
import bjcr;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.view.MusicProviderView;
import java.util.List;

public class MusicProviderPagerAdapter
  extends PagerAdapter
{
  public static final int a;
  public static final int b = actj.a(0.0F, BaseApplication.getContext().getResources());
  private Context jdField_a_of_type_AndroidContentContext;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
  private SparseArray<GridView> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private bfpt jdField_a_of_type_Bfpt;
  MusicProviderView jdField_a_of_type_DovComQqImCaptureViewMusicProviderView;
  private List<bjcr> jdField_a_of_type_JavaUtilList;
  
  static
  {
    jdField_a_of_type_Int = actj.a(7.0F, BaseApplication.getContext().getResources());
  }
  
  public MusicProviderPagerAdapter(Context paramContext, MusicProviderView paramMusicProviderView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView = paramMusicProviderView;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidUtilSparseArray.size();
  }
  
  public GridView a(int paramInt)
  {
    paramInt = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(paramInt);
    return (GridView)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a(bfpt parambfpt)
  {
    this.jdField_a_of_type_Bfpt = parambfpt;
  }
  
  public void a(List<bjcr> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public GridView b(int paramInt)
  {
    return (GridView)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "instantiateItem position = " + paramInt);
    }
    GridView localGridView = (GridView)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    bjbc localbjbc;
    if (localGridView == null)
    {
      localGridView = new GridView(this.jdField_a_of_type_AndroidContentContext);
      localGridView.setNumColumns(4);
      localGridView.setSelector(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      localGridView.setVerticalSpacing(b);
      localGridView.setHorizontalSpacing(b);
      localGridView.setVerticalScrollBarEnabled(false);
      localGridView.setPadding(jdField_a_of_type_Int, jdField_a_of_type_Int, jdField_a_of_type_Int, jdField_a_of_type_Int * 2 + actj.a(36.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localGridView.setClipToPadding(false);
      localbjbc = new bjbc(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView);
      localGridView.setOnItemClickListener(this.jdField_a_of_type_Bfpt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localGridView);
    }
    for (;;)
    {
      localbjbc.a(((bjcr)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaUtilList);
      localGridView.setAdapter(localbjbc);
      if (this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView.c == paramInt)
      {
        localGridView.setSelection(this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView.d);
        this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView.c = -1;
        this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView.d = -1;
      }
      paramViewGroup.addView(localGridView, -1, -1);
      return localGridView;
      localbjbc = (bjbc)localGridView.a();
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.MusicProviderPagerAdapter
 * JD-Core Version:    0.7.0.1
 */