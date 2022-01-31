package dov.com.qq.im.capture.view;

import ajpx;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import axpm;
import bdob;
import blra;
import blzs;
import blzt;
import blzu;
import blzv;
import blzw;
import bmau;
import bnpk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.QIMBeautyItem;
import java.util.List;
import mqq.app.AppRuntime;

public class AdvancedProviderView
  extends ProviderView
  implements View.OnClickListener
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 500;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final int jdField_b_of_type_Int = 300;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView c;
  private ImageView d;
  
  public AdvancedProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private Animation a(QIMProviderContainerView paramQIMProviderContainerView, View paramView, float paramFloat1, float paramFloat2)
  {
    return new bdob(Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), new blzw(this, paramQIMProviderContainerView, paramView));
  }
  
  public static int b()
  {
    int i = 0;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("beauty_settings", 0);
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "beauty_level_" + str + "_CAMERA_ID_" + ajpx.jdField_a_of_type_Int;
    if (ajpx.jdField_a_of_type_Int == 2) {}
    for (;;)
    {
      i = localSharedPreferences.getInt(str, i);
      if (QLog.isColorLevel()) {
        QLog.d("AdvancedProviderView", 2, "getBeautyFeature BeautyLevel=" + i + ", key:" + str);
      }
      return i;
      i = 55;
    }
  }
  
  public static int c()
  {
    int j = 0;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sharp_face_settings", 0);
    String str1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str2 = blra.b;
    int i;
    if ((TextUtils.isEmpty(str2)) || ("0".equals(str2)))
    {
      i = 1;
      if (i == 0) {
        break label163;
      }
      str1 = "sharp_face_level_" + str1 + "_CAMERA_ID_" + ajpx.jdField_a_of_type_Int;
      if (ajpx.jdField_a_of_type_Int != 2) {
        break label157;
      }
      i = j;
    }
    for (;;)
    {
      i = localSharedPreferences.getInt(str1, i);
      if (QLog.isColorLevel()) {
        QLog.d("AdvancedProviderView", 2, "getSharpFaceFeature SharpFaceLevel = " + i + ", filterId = " + str2 + ", key:" + str1);
      }
      return i;
      i = 0;
      break;
      label157:
      i = 40;
      continue;
      label163:
      str1 = "sharp_face_level_" + str1 + "filterId" + str2;
      i = 50;
    }
  }
  
  protected int a()
  {
    return 2131560725;
  }
  
  public void a(int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("beauty_settings", 0).edit();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "beauty_level_" + str + "_CAMERA_ID_" + ajpx.jdField_a_of_type_Int;
    localEditor.putInt(str, paramInt);
    localEditor.apply();
    if (QLog.isColorLevel()) {
      QLog.d("AdvancedProviderView", 2, "saveBeautyFeature BeautyLevel=" + paramInt + ", key: " + str);
    }
  }
  
  @TargetApi(11)
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560725, this, false);
    }
    paramBundle = this.jdField_a_of_type_AndroidViewView.findViewById(2131363163);
    if (!axpm.d()) {
      paramBundle.setVisibility(8);
    }
    View localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131376612);
    SeekBar localSeekBar = (SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131363171);
    if (Build.VERSION.SDK_INT >= 21) {
      localSeekBar.setSplitTrack(false);
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363164);
    int i = b();
    localSeekBar.setProgress(i);
    localTextView.setText("+" + i / 10.0F);
    QIMProviderContainerView localQIMProviderContainerView = (QIMProviderContainerView)((Activity)getContext()).findViewById(2131372385);
    View localView2 = ((Activity)getContext()).findViewById(2131366605);
    localSeekBar.setOnSeekBarChangeListener(new blzs(this, localTextView, localView2, paramBundle, localQIMProviderContainerView, localView1));
    localSeekBar = (SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131376614);
    if (Build.VERSION.SDK_INT >= 21) {
      localSeekBar.setSplitTrack(false);
    }
    localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376613);
    i = c();
    localSeekBar.setProgress(i);
    localTextView.setText("+" + String.format("%.1f", new Object[] { Float.valueOf(i / 10.0F) }));
    localSeekBar.setOnSeekBarChangeListener(new blzt(this, localTextView, localView2, localView1, localQIMProviderContainerView, paramBundle));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131380188).setOnClickListener(new blzu(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131380189).setOnClickListener(new blzv(this));
    this.c = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380190));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380197));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380192));
    this.d = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380191));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380198));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380193));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    a(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void b(int paramInt)
  {
    int i = 0;
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("sharp_face_settings", 0).edit();
    String str3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str2 = blra.b;
    if ((TextUtils.isEmpty(str2)) || ("0".equals(str2))) {
      i = 1;
    }
    String str1 = "sharp_face_level_" + str3 + "filterId" + str2;
    if (i != 0) {
      str1 = "sharp_face_level_" + str3 + "_CAMERA_ID_" + ajpx.jdField_a_of_type_Int;
    }
    for (;;)
    {
      localEditor.putInt(str1, paramInt);
      localEditor.apply();
      com.tencent.mobileqq.shortvideo.ptvfilter.QQSharpFaceFilter.sSharpFaceLevel = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("AdvancedProviderView", 2, "saveSharpFaceFeature SharpFaceLevel = " + paramInt + ", filterId = " + str2 + ", key:" + str1);
      }
      return;
    }
  }
  
  public void c()
  {
    g();
    Object localObject1 = bnpk.a().a();
    View localView;
    Object localObject2;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131376610);
      if (((List)localObject1).size() <= 0) {
        break label296;
      }
      if (((List)localObject1).size() > 1)
      {
        localObject2 = (QIMBeautyItem)((List)localObject1).get(1);
        if (this.jdField_b_of_type_AndroidWidgetImageView != null)
        {
          if (!((QIMBeautyItem)localObject2).a()) {
            break label270;
          }
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845528);
        }
        if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(((QIMBeautyItem)localObject2).b))) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(((QIMBeautyItem)localObject2).b);
        }
        if ((this.d == null) || (TextUtils.isEmpty(((QIMBeautyItem)localObject2).c))) {}
      }
    }
    label156:
    label296:
    try
    {
      localObject2 = URLDrawable.getDrawable(((QIMBeautyItem)localObject2).c);
      if (((URLDrawable)localObject2).getStatus() == 2) {
        ((URLDrawable)localObject2).restartDownload();
      }
      this.d.setImageDrawable((Drawable)localObject2);
    }
    catch (Exception localException2)
    {
      label236:
      break label156;
    }
    localObject1 = (QIMBeautyItem)((List)localObject1).get(0);
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if (!((QIMBeautyItem)localObject1).a()) {
        break label283;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845528);
    }
    for (;;)
    {
      if ((this.c != null) && (!TextUtils.isEmpty(((QIMBeautyItem)localObject1).c))) {}
      try
      {
        localObject2 = URLDrawable.getDrawable(((QIMBeautyItem)localObject1).c);
        if (((URLDrawable)localObject2).getStatus() == 2) {
          ((URLDrawable)localObject2).restartDownload();
        }
        this.c.setImageDrawable((Drawable)localObject2);
      }
      catch (Exception localException1)
      {
        break label236;
      }
      if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(((QIMBeautyItem)localObject1).b))) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(((QIMBeautyItem)localObject1).b);
      }
      localView.setVisibility(0);
      return;
      label270:
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845541);
      break;
      label283:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845541);
    }
    localView.setVisibility(8);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    int i;
    do
    {
      return;
      SeekBar localSeekBar = (SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131363171);
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363164);
      i = b();
      localSeekBar.setProgress(i);
      localTextView.setText("+" + i / 10.0F);
    } while (this.jdField_a_of_type_Bmau == null);
    this.jdField_a_of_type_Bmau.b(i);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      SeekBar localSeekBar = (SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131376614);
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376613);
      int i = c();
      localSeekBar.setProgress(i);
      localTextView.setText("+" + String.format("%.1f", new Object[] { Float.valueOf(i / 10.0F) }));
      if (this.jdField_a_of_type_Bmau != null)
      {
        this.jdField_a_of_type_Bmau.c(i);
        localTextView.setText("+" + String.format("%.1f", new Object[] { Float.valueOf(i / 10.0F) }));
      }
      localSeekBar = (SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131363171);
      localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363164);
      i = b();
      localSeekBar.setProgress(i);
      localTextView.setText("+" + i / 10.0F);
      if (this.jdField_a_of_type_Bmau != null) {
        this.jdField_a_of_type_Bmau.b(i);
      }
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.view.AdvancedProviderView
 * JD-Core Version:    0.7.0.1
 */