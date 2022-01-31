package dov.com.qq.im.capture.adapter;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.PopupWindow;
import bdne;
import blqr;
import blrs;
import blrx;
import blsj;
import bnhb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.DetectableAnimationDrawable;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;

public class ComboProviderGridAdapter$LockAnimationDrawable
  extends DetectableAnimationDrawable
{
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow = null;
  QIMFilterCategoryItem jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = null;
  ImageView b = null;
  
  public ComboProviderGridAdapter$LockAnimationDrawable(AnimationDrawable paramAnimationDrawable, ImageView paramImageView1, PopupWindow paramPopupWindow, ImageView paramImageView2, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    super(paramAnimationDrawable);
    this.jdField_a_of_type_AndroidWidgetPopupWindow = paramPopupWindow;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView1;
    this.b = paramImageView2;
    this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = paramQIMFilterCategoryItem;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    Object localObject = (blrx)blqr.a(5);
    ((blrx)localObject).a().a(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
    bdne.q(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.jdField_a_of_type_JavaLangString, false);
    bnhb.a().a(3, this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.jdField_a_of_type_Int, this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
    Bundle localBundle = new Bundle();
    localBundle.putInt("apply_source", 1);
    localBundle.putInt("capture_scene", 0);
    ((blrx)localObject).a(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, (Activity)this.b.getContext(), localBundle);
    this.b.setVisibility(8);
    localObject = ((blrx)localObject).a(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem);
    ComboProviderGridAdapter.a(this.b, (blrs)localObject, this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.ComboProviderGridAdapter.LockAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */