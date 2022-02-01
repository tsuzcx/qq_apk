package com.tencent.mobileqq.picbrowser;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.ArrayList;
import java.util.List;

public class PicBrowserModel
  implements AbstractImageListModel
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList<PicBrowserImage> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public PicBrowserModel(Context paramContext, List<PicInfo> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = 0;
      while (i < paramList.size())
      {
        paramContext = (PicInfo)paramList.get(i);
        if ((ShortVideoUtils.isVideoSoLibLoaded()) && ((!TextUtils.isEmpty(paramContext.d)) || (!TextUtils.isEmpty(paramContext.e)))) {
          paramContext = new GalleryItemVideo(this.jdField_a_of_type_AndroidContentContext, paramContext);
        } else {
          paramContext = new GalleryItemImage(this.jdField_a_of_type_AndroidContentContext, paramContext);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(paramContext);
        i += 1;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public PicBrowserImage a()
  {
    int i = this.jdField_a_of_type_Int;
    if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return (PicBrowserImage)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
    }
    return null;
  }
  
  public PicBrowserImage a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return (PicBrowserImage)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public ArrayList<PicInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(((PicBrowserImage)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a);
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    int i = this.jdField_a_of_type_Int;
    if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      ((PicBrowserImage)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).c();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      PicBrowserImage localPicBrowserImage = (PicBrowserImage)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      boolean bool;
      if (paramInt == i) {
        bool = true;
      } else {
        bool = false;
      }
      localPicBrowserImage.a(bool);
      i += 1;
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public PicBrowserImage b(int paramInt)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (paramInt >= 0) && (paramInt < localArrayList.size())) {
      return (PicBrowserImage)this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.picbrowser.PicBrowserModel
 * JD-Core Version:    0.7.0.1
 */