package dov.com.qq.im.capture.adapter;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.DetectableAnimationDrawable;
import com.tencent.mobileqq.utils.SharedPreUtils;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboBase;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.data.ComboLockManager;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;

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
    Object localObject = (CaptureComboManager)QIMManager.a(5);
    ((CaptureComboManager)localObject).a().a(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
    SharedPreUtils.q(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.jdField_a_of_type_JavaLangString, false);
    VideoFilterTools.a().a(3, this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.jdField_a_of_type_Int, this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
    Bundle localBundle = new Bundle();
    localBundle.putInt("apply_source", 1);
    localBundle.putInt("capture_scene", 0);
    ((CaptureComboManager)localObject).a(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, (Activity)this.b.getContext(), localBundle);
    this.b.setVisibility(8);
    localObject = ((CaptureComboManager)localObject).a(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem);
    ComboProviderGridAdapter.a(this.b, (CaptureComboBase)localObject, this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.ComboProviderGridAdapter.LockAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */