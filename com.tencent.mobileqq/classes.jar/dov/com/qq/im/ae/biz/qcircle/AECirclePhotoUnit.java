package dov.com.qq.im.ae.biz.qcircle;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import dov.com.qq.im.QIMCameraLifeCycleBaseUnit;
import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.qq.im.setting.IQIMCameraContainer;

public class AECirclePhotoUnit
  extends QIMCameraLifeCycleBaseUnit
{
  private AECirclePhotoListFragment jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListFragment;
  private ICameraEntrance jdField_a_of_type_DovComQqImSettingICameraEntrance;
  private IQIMCameraContainer jdField_a_of_type_DovComQqImSettingIQIMCameraContainer;
  
  public AECirclePhotoUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer = paramIQIMCameraContainer;
    this.jdField_a_of_type_DovComQqImSettingICameraEntrance = paramICameraEntrance;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getLayoutInflater().inflate(2131558619, null);
  }
  
  public void a()
  {
    Intent localIntent = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent();
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 9);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListFragment = new AECirclePhotoListFragment();
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getFragmentManager().beginTransaction().add(2131367051, this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListFragment).commit();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListFragment != null) {
      return this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListFragment.b();
    }
    return true;
  }
  
  public boolean b()
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer == null) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListFragment == null) {
            break;
          }
          bool1 = bool2;
        } while (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListFragment.a());
        bool1 = bool2;
      } while (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListFragment == null);
      bool1 = bool2;
    } while (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListFragment.a == null);
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListFragment.a.a(null);
    return true;
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().finish();
  }
  
  public void j()
  {
    super.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.AECirclePhotoUnit
 * JD-Core Version:    0.7.0.1
 */