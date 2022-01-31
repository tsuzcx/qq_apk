package com.tencent.mobileqq.extendfriend.fragment;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import aohs;
import aokq;
import bfob;
import com.tencent.image.URLImageView;

public class ExtendFriendGroupFragment$RecyclerViewAdapter$1
  implements Runnable
{
  public ExtendFriendGroupFragment$RecyclerViewAdapter$1(aohs paramaohs, String paramString, URLImageView paramURLImageView) {}
  
  public void run()
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
    localObject = aokq.a(this.jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject);
    if ((ExtendFriendGroupFragment.a(this.jdField_a_of_type_Aohs.a) != null) && (this.jdField_a_of_type_ComTencentImageURLImageView != null) && (localObject != null)) {
      ExtendFriendGroupFragment.a(this.jdField_a_of_type_Aohs.a).post(new ExtendFriendGroupFragment.RecyclerViewAdapter.1.1(this, (Bitmap)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendGroupFragment.RecyclerViewAdapter.1
 * JD-Core Version:    0.7.0.1
 */