package dov.com.qq.im.capture.data;

import android.app.Activity;
import dov.com.qq.im.capture.music.CaptureComboMusic;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import java.util.ArrayList;

public class CaptureComboManager$CaptureRecord
{
  int jdField_a_of_type_Int;
  public long a;
  public ComboSet a;
  public FilterSet a;
  public TemplateSet a;
  CaptureComboMusic jdField_a_of_type_DovComQqImCaptureMusicCaptureComboMusic;
  ArrayList<CaptureComboBase> jdField_a_of_type_JavaUtilArrayList;
  public long b;
  
  public CaptureComboManager$CaptureRecord(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    VideoFilterTools.a().b(null, null, this.jdField_a_of_type_Int);
    VideoFilterTools.a().a(null, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_DovComQqImCaptureDataFilterSet = null;
  }
  
  public void a(Activity paramActivity)
  {
    if ((this.jdField_a_of_type_DovComQqImCaptureDataComboSet != null) && (this.jdField_a_of_type_DovComQqImCaptureDataComboSet.jdField_a_of_type_Int == 3))
    {
      this.jdField_a_of_type_DovComQqImCaptureDataComboSet.b(paramActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_DovComQqImCaptureDataComboSet.a(paramActivity, this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_DovComQqImCaptureDataFilterSet != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureDataFilterSet.b(paramActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_DovComQqImCaptureDataFilterSet.a(paramActivity, this.jdField_a_of_type_Int);
    }
  }
  
  public void a(ComboSet paramComboSet)
  {
    this.jdField_a_of_type_DovComQqImCaptureDataComboSet = paramComboSet;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(FilterSet paramFilterSet)
  {
    this.jdField_a_of_type_DovComQqImCaptureDataFilterSet = paramFilterSet;
    this.b = System.currentTimeMillis();
  }
  
  public void a(TemplateSet paramTemplateSet)
  {
    this.jdField_a_of_type_DovComQqImCaptureDataTemplateSet = paramTemplateSet;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_DovComQqImCaptureDataFilterSet == null) || (this.b <= this.jdField_a_of_type_Long);
  }
  
  public void b(Activity paramActivity)
  {
    VideoFilterTools.a().a(this.jdField_a_of_type_Int);
    VideoFilterTools.a().a(null, paramActivity, this.jdField_a_of_type_Int);
    ComboSet localComboSet = VideoFilterTools.a().a[this.jdField_a_of_type_Int];
    if (localComboSet != null) {
      localComboSet.a(paramActivity, this.jdField_a_of_type_Int);
    }
    VideoFilterTools.a().a(null, paramActivity, this.jdField_a_of_type_Int);
    VideoFilterTools.a().b(null, paramActivity, this.jdField_a_of_type_Int);
  }
  
  public void c(Activity paramActivity)
  {
    b(paramActivity);
    this.jdField_a_of_type_DovComQqImCaptureDataComboSet = null;
    this.jdField_a_of_type_DovComQqImCaptureDataFilterSet = null;
    this.jdField_a_of_type_DovComQqImCaptureMusicCaptureComboMusic = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.data.CaptureComboManager.CaptureRecord
 * JD-Core Version:    0.7.0.1
 */