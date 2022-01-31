package dov.com.qq.im.ae.camera.ui.panel;

import ahty;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import avte;
import bbky;
import bikl;
import biod;
import bioe;
import biof;
import bjaa;
import bjbe;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class AEBeautyProviderView
  extends FrameLayout
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 500;
  protected View a;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new biod(this);
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  public TextView a;
  private bikl jdField_a_of_type_Bikl;
  private AEProviderContainerView jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView;
  public boolean a;
  private final int jdField_b_of_type_Int = 300;
  private View jdField_b_of_type_AndroidViewView;
  private SeekBar.OnSeekBarChangeListener jdField_b_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new bioe(this);
  private SeekBar jdField_b_of_type_AndroidWidgetSeekBar;
  public TextView b;
  private View c;
  private View d;
  
  public AEBeautyProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AEBeautyProviderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static int a()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "ae_beauty_level_" + str + "_CAMERA_ID_" + ahty.jdField_a_of_type_Int;
    int i = 55;
    if (ahty.jdField_a_of_type_Int == 2) {
      i = 0;
    }
    i = bjaa.a().a(str, i, 0);
    if (QLog.isColorLevel()) {
      QLog.d("AEBeautyProviderView", 2, "getBeautyFeature BeautyLevel=" + i + ", key:" + str);
    }
    return i;
  }
  
  private Animation a(AEProviderContainerView paramAEProviderContainerView, View paramView, float paramFloat1, float paramFloat2)
  {
    return new bbky(Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), new biof(this, paramAEProviderContainerView, paramView));
  }
  
  private void a(int paramInt)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "ae_beauty_level_" + str + "_CAMERA_ID_" + ahty.jdField_a_of_type_Int;
    bjaa.a().a(str, paramInt, 0);
    if (QLog.isColorLevel()) {
      QLog.d("AEBeautyProviderView", 2, "saveBeautyFeature BeautyLevel=" + paramInt + ", key: " + str);
    }
  }
  
  private void a(View paramView1, View paramView2)
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && ((this.jdField_b_of_type_AndroidViewView instanceof ViewGroup))) {
      ((ViewGroup)this.jdField_b_of_type_AndroidViewView).setMotionEventSplittingEnabled(false);
    }
    int j = 300;
    int i = j;
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation != null)
    {
      i = j;
      if (!this.jdField_a_of_type_AndroidViewAnimationAnimation.hasEnded())
      {
        this.jdField_a_of_type_AndroidViewAnimationAnimation.cancel();
        i = 0;
      }
    }
    paramView1.setAlpha(1.0F);
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView.a()) {
      return;
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimation = a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView, paramView2, this.jdField_a_of_type_Float, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration((this.jdField_a_of_type_Float * this.jdField_a_of_type_Int));
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setStartOffset(i);
    startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  public static int b()
  {
    String str1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str2 = bjbe.b;
    int i;
    if ((TextUtils.isEmpty(str2)) || ("0".equals(str2)))
    {
      i = 1;
      if (i == 0) {
        break label148;
      }
      str1 = "ae_sharp_face_level_" + str1 + "_CAMERA_ID_" + ahty.jdField_a_of_type_Int;
      if (ahty.jdField_a_of_type_Int != 2) {
        break label142;
      }
      i = 0;
    }
    for (;;)
    {
      i = bjaa.a().a(str1, i, 0);
      if (QLog.isColorLevel()) {
        QLog.d("AEBeautyProviderView", 2, "getSharpFaceFeature SharpFaceLevel = " + i + ", filterId = " + str2 + ", key:" + str1);
      }
      return i;
      i = 0;
      break;
      label142:
      i = 40;
      continue;
      label148:
      str1 = "ae_sharp_face_level_" + str1 + "filterId" + str2;
      i = 50;
    }
  }
  
  private void b(int paramInt)
  {
    String str3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str2 = bjbe.b;
    int i;
    String str1;
    if ((TextUtils.isEmpty(str2)) || ("0".equals(str2)))
    {
      i = 1;
      str1 = "ae_sharp_face_level_" + str3 + "filterId" + str2;
      if (i == 0) {
        break label172;
      }
      str1 = "ae_sharp_face_level_" + str3 + "_CAMERA_ID_" + ahty.jdField_a_of_type_Int;
    }
    label172:
    for (;;)
    {
      bjaa.a().a(str1, paramInt, 0);
      com.tencent.mobileqq.shortvideo.ptvfilter.QQSharpFaceFilter.sSharpFaceLevel = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("AEBeautyProviderView", 2, "saveSharpFaceFeature SharpFaceLevel = " + paramInt + ", filterId = " + str2 + ", key:" + str1);
      }
      return;
      i = 0;
      break;
    }
  }
  
  private void b(View paramView1, View paramView2)
  {
    if ((this.jdField_a_of_type_AndroidViewAnimationAnimation != null) && (!this.jdField_a_of_type_AndroidViewAnimationAnimation.hasEnded())) {
      this.jdField_a_of_type_AndroidViewAnimationAnimation.cancel();
    }
    paramView1.setAlpha(1.0F);
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView.a()) {
      return;
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimation = a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView, paramView2, this.jdField_a_of_type_Float, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(((1.0F - this.jdField_a_of_type_Float) * this.jdField_a_of_type_Int));
    startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  private int c()
  {
    int i = a();
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("+" + i / 10.0F);
    return i;
  }
  
  private int d()
  {
    int i = b();
    this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("+" + String.format("%.1f", new Object[] { Float.valueOf(i / 10.0F) }));
    return i;
  }
  
  public void a()
  {
    c();
  }
  
  @TargetApi(11)
  public void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131562446, this, true);
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_b_of_type_AndroidViewView = ((Activity)getContext()).findViewById(2131366493);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView = ((AEProviderContainerView)((Activity)getContext()).findViewById(2131363122));
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131363127);
    if (!avte.d()) {
      this.c.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131363135));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    if (Build.VERSION.SDK_INT >= 21) {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setSplitTrack(false);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363128));
    c();
    this.d = this.jdField_a_of_type_AndroidViewView.findViewById(2131376059);
    this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131376061));
    this.jdField_b_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_b_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    if (Build.VERSION.SDK_INT >= 21) {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setSplitTrack(false);
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376060));
    d();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    int i;
    do
    {
      return;
      i = c();
    } while (this.jdField_a_of_type_Bikl == null);
    this.jdField_a_of_type_Bikl.a(i);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      int i = d();
      if (this.jdField_a_of_type_Bikl != null) {
        this.jdField_a_of_type_Bikl.b(i);
      }
      i = c();
      if (this.jdField_a_of_type_Bikl != null) {
        this.jdField_a_of_type_Bikl.a(i);
      }
    }
  }
  
  public void setController(bikl parambikl)
  {
    this.jdField_a_of_type_Bikl = parambikl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView
 * JD-Core Version:    0.7.0.1
 */