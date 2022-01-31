package com.tencent.mobileqq.filemanager.fileviewer;

import acsh;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.ImageFileInfo;
import java.net.URL;
import java.util.List;

public class ImageGalleryAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private List jdField_a_of_type_JavaUtilList;
  private Drawable b;
  
  public ImageGalleryAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi;
    this.jdField_a_of_type_Int *= 2;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130846201);
    this.b = paramContext.getResources().getDrawable(2130838596);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FileBrowserModelBase.ImageFileInfo localImageFileInfo;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970034, null);
      paramViewGroup = new acsh(this, null);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131361846));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362710));
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131363544));
      paramView.setTag(paramViewGroup);
      localImageFileInfo = (FileBrowserModelBase.ImageFileInfo)getItem(paramInt);
      if (localImageFileInfo != null) {
        break label111;
      }
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    label111:
    do
    {
      return paramView;
      paramViewGroup = (acsh)paramView.getTag();
      break;
      Object localObject = localImageFileInfo.a();
      localImageFileInfo.a();
      if (localObject != null)
      {
        Drawable localDrawable = this.b;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = localDrawable;
        localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localURLDrawableOptions.mPlayGifImage = true;
        localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
        ((URLDrawable)localObject).setTargetDensity(this.jdField_a_of_type_Int);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
        if (localImageFileInfo.a())
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          return paramView;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        return paramView;
      }
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    } while (localImageFileInfo.b());
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramView.setTag(2131296386, Float.valueOf(1.0F));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.ImageGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */