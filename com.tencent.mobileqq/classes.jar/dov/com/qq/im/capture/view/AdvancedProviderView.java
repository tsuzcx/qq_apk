package dov.com.qq.im.capture.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.SeekBar;
import android.widget.TextView;
import anos;
import anot;
import anou;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter;
import mqq.app.AppRuntime;

public class AdvancedProviderView
  extends ProviderView
  implements View.OnClickListener
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 500;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private final int b = 300;
  
  public AdvancedProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private Animation a(QIMProviderContainerView paramQIMProviderContainerView, View paramView, float paramFloat1, float paramFloat2)
  {
    return new ValueAnimation(Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), new anou(this, paramQIMProviderContainerView, paramView));
  }
  
  public static int b()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("beauty_settings", 0);
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    int i = localSharedPreferences.getInt("beauty_level" + str, 50);
    if (QLog.isColorLevel()) {
      QLog.d("AdvancedProviderView", 2, "getBeautyFeature BeautyLevel=" + i);
    }
    return i;
  }
  
  public static int c()
  {
    int j = 0;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sharp_face_settings", 0);
    String str1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str2 = QIMPtvTemplateAdapter.b;
    int i = j;
    if (str2 != null)
    {
      i = j;
      if (!"".equals(str2)) {
        if (!"0".equals(str2)) {
          break label138;
        }
      }
    }
    label138:
    for (i = j;; i = 50)
    {
      i = localSharedPreferences.getInt("sharp_face_level" + str1 + "filterId" + str2, i);
      if (QLog.isColorLevel()) {
        QLog.d("AdvancedProviderView", 2, "getSharpFaceFeature SharpFaceLevel = " + i + ", filterId = " + str2);
      }
      return i;
    }
  }
  
  protected int a()
  {
    return 2130970076;
  }
  
  public void a()
  {
    SeekBar localSeekBar = (SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131368941);
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368940);
    int i = c();
    localSeekBar.setProgress(i);
    localTextView.setText("+" + String.format("%.1f", new Object[] { Float.valueOf(i / 10.0F) }));
  }
  
  public void a(int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("beauty_settings", 0);
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localSharedPreferences.edit().putInt("beauty_level" + str, paramInt);
    localSharedPreferences.edit().commit();
    if (QLog.isColorLevel()) {
      QLog.d("AdvancedProviderView", 2, "saveBeautyFeature BeautyLevel=" + paramInt);
    }
  }
  
  @TargetApi(11)
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2130970076, this, false);
    }
    paramBundle = this.jdField_a_of_type_AndroidViewView.findViewById(2131368936);
    if (!CaptureUtil.f()) {
      paramBundle.setVisibility(8);
    }
    View localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131368939);
    SeekBar localSeekBar = (SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131368938);
    if (Build.VERSION.SDK_INT >= 21) {
      localSeekBar.setSplitTrack(false);
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368937);
    int i = b();
    localSeekBar.setProgress(i);
    localTextView.setText("+" + i / 10.0F);
    QIMProviderContainerView localQIMProviderContainerView = (QIMProviderContainerView)((Activity)getContext()).findViewById(2131368982);
    View localView2 = ((Activity)getContext()).findViewById(2131366244);
    localSeekBar.setOnSeekBarChangeListener(new anos(this, localTextView, localView2, paramBundle, localQIMProviderContainerView, localView1));
    localSeekBar = (SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131368941);
    if (Build.VERSION.SDK_INT >= 21) {
      localSeekBar.setSplitTrack(false);
    }
    localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368940);
    i = c();
    localSeekBar.setProgress(i);
    localTextView.setText("+" + String.format("%.1f", new Object[] { Float.valueOf(i / 10.0F) }));
    localSeekBar.setOnSeekBarChangeListener(new anot(this, localTextView, localView2, localView1, localQIMProviderContainerView, paramBundle));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    a(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void b(int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sharp_face_settings", 0);
    String str1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str2 = QIMPtvTemplateAdapter.b;
    localSharedPreferences.edit().putInt("sharp_face_level" + str1 + "filterId" + str2, paramInt);
    localSharedPreferences.edit().commit();
    com.tencent.mobileqq.shortvideo.ptvfilter.QQSharpFaceFilter.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("AdvancedProviderView", 2, "saveSharpFaceFeature SharpFaceLevel = " + paramInt + ", filterId = " + str2);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    int i;
    do
    {
      return;
      SeekBar localSeekBar = (SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131368938);
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368937);
      i = b();
      localSeekBar.setProgress(i);
      localTextView.setText("+" + i / 10.0F);
    } while (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener == null);
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.c(i);
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.AdvancedProviderView
 * JD-Core Version:    0.7.0.1
 */