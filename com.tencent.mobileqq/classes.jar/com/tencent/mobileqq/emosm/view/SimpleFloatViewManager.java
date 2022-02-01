package com.tencent.mobileqq.emosm.view;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.widget.XListView;

public class SimpleFloatViewManager
  implements DragSortListView.FloatViewManager
{
  private int jdField_a_of_type_Int = -16777216;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  public SimpleFloatViewManager(XListView paramXListView)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
  }
  
  public View a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
    localObject = ((XListView)localObject).getChildAt(paramInt + ((XListView)localObject).getHeaderViewsCount() - this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition());
    if (localObject == null) {
      return null;
    }
    ((View)localObject).setPressed(false);
    ((View)localObject).setDrawingCacheEnabled(true);
    if (((View)localObject).getDrawingCache() == null) {
      return null;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(((View)localObject).getDrawingCache());
    ((View)localObject).setDrawingCacheEnabled(false);
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentWidgetXListView.getContext());
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(new ViewGroup.LayoutParams(((View)localObject).getWidth(), ((View)localObject).getHeight()));
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public void a(View paramView)
  {
    ((ImageView)paramView).setImageDrawable(null);
    this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
  }
  
  public void a(View paramView, Point paramPoint1, Point paramPoint2) {}
  
  public void f(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.SimpleFloatViewManager
 * JD-Core Version:    0.7.0.1
 */