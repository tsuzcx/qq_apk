package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import adfx;
import adfy;
import adfz;
import adga;
import adgb;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.core.FileVideoManager;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.VideoControl;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter.MenuData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.List;

public class VideoFileViewer
  extends FileBrowserViewBase
{
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  public ActionSheet a;
  private RelativeLayout b;
  private View jdField_c_of_type_AndroidViewView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  TextView d;
  TextView e;
  TextView f;
  private TextView g;
  
  public VideoFileViewer(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private String a(int paramInt)
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      str = this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramInt);
    }
    return str;
  }
  
  private String a(long paramLong)
  {
    long l3 = paramLong / 1000L;
    paramLong = l3 / 86400L;
    long l1 = l3 % 86400L / 3600L;
    long l2 = l3 % 86400L % 3600L / 60L;
    l3 = l3 % 86400L % 3600L % 60L;
    String str2;
    String str1;
    if (paramLong > 0L)
    {
      str2 = String.format("%02d:%02d:%02d:%02d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
      str1 = str2;
      if (QLog.isDevelopLevel())
      {
        QLog.d("#@#@", 1, "getTick 161 [" + str2 + "]");
        str1 = str2;
      }
    }
    do
    {
      do
      {
        return str1;
        if (l1 <= 0L) {
          break;
        }
        str2 = String.format("%02d:%02d:%02d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
        str1 = str2;
      } while (!QLog.isDevelopLevel());
      QLog.d("#@#@", 1, "getTick 167 [" + str2 + "]");
      return str2;
      str2 = String.format("%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l3) });
      str1 = str2;
    } while (!QLog.isDevelopLevel());
    QLog.d("#@#@", 1, "getTick 174 [" + str2 + "]");
    return str2;
  }
  
  private void a(List paramList, int paramInt, View paramView)
  {
    String str = a(paramInt);
    if ((paramList == null) || (TextUtils.isEmpty(str))) {}
    HorizontalListViewAdapter.MenuData localMenuData;
    do
    {
      return;
      while (!paramList.hasNext()) {
        paramList = paramList.iterator();
      }
      localMenuData = (HorizontalListViewAdapter.MenuData)paramList.next();
    } while (!str.equalsIgnoreCase(localMenuData.jdField_a_of_type_JavaLangString));
    localMenuData.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: VideoFileViewer initFileView");
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130970050, this.jdField_a_of_type_AndroidViewViewGroup, false);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368864));
      this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368866));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368870));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368873));
      this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368875));
      this.f.setText("恢复发送");
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368874));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131368865));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131366892));
      this.g = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368871));
      this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368872));
      this.b = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368845));
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        ((RelativeLayout.LayoutParams)((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363753)).getLayoutParams()).setMargins(0, ImmersiveUtils.a(this.jdField_a_of_type_AndroidAppActivity), 0, 0);
      }
    }
  }
  
  public void a(long paramLong)
  {
    this.d.setText(a(paramLong));
  }
  
  public void a(long paramLong, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_c_of_type_AndroidViewView == null)
    {
      this.jdField_c_of_type_AndroidViewView = FileVideoManager.a(paramLong).a(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_c_of_type_AndroidViewView.setId(2131374925);
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(-16777216);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      this.jdField_c_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
      paramOnClickListener = new RelativeLayout.LayoutParams(-1, -1);
      paramOnClickListener.addRule(13, -1);
      this.b.addView(this.jdField_c_of_type_AndroidViewView, 0, paramOnClickListener);
    }
  }
  
  @TargetApi(16)
  public void a(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT > 16)
    {
      this.jdField_c_of_type_AndroidViewView.setBackground(paramDrawable);
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(paramDrawable);
  }
  
  public void a(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    if (paramOnSeekBarChangeListener != null) {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(paramOnSeekBarChangeListener);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    ((ViewGroup)this.jdField_a_of_type_AndroidViewView).removeView(this.jdField_c_of_type_AndroidViewView);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
    localRelativeLayout.setBackgroundColor(Color.parseColor("#D8DAE0"));
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
    localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130841640, 0, 0);
    localTextView.setText(paramString2);
    localTextView.setTextSize(12.0F);
    localTextView.setTextColor(Color.parseColor("#83889A"));
    localTextView.setPadding(0, 15, 0, 0);
    localRelativeLayout.addView(localTextView, -2, -2);
    ((RelativeLayout.LayoutParams)localTextView.getLayoutParams()).addRule(13);
    if (FileUtil.b(paramString1))
    {
      paramString2 = new TextView(this.jdField_a_of_type_AndroidAppActivity);
      paramString2.setText("用QQ浏览器打开");
      paramString2.setContentDescription("用qq浏览器打开");
      paramString2.setTextSize(12.0F);
      paramString2.setTextColor(Color.parseColor("#12B7F5"));
      paramString2.setOnClickListener(new adfy(this, paramString1));
      localRelativeLayout.addView(paramString2, -2, -2);
      paramString1 = (RelativeLayout.LayoutParams)paramString2.getLayoutParams();
      paramString1.addRule(13);
      paramString1.addRule(12);
      paramString1.setMargins(0, 0, 0, 40);
      paramString2.setLayoutParams(paramString1);
    }
    int i = (int)(((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window")).getDefaultDisplay().getWidth() * 0.75D);
    ((ViewGroup)this.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, -1, i);
    ((RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams()).addRule(13);
    b(false);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setVisibility(4);
    this.d.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new adfz(this));
  }
  
  public void a(List paramList)
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null));
      if (paramList != null) {}
    }
    else
    {
      return;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      HorizontalListViewAdapter.MenuData localMenuData = (HorizontalListViewAdapter.MenuData)localIterator.next();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(localMenuData.jdField_a_of_type_JavaLangString, 0);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d("取消");
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new adga(this, paramList));
  }
  
  public View b()
  {
    return this.jdField_c_of_type_AndroidViewView;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(paramInt);
  }
  
  public void b(long paramLong)
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setText(a(paramLong));
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramOnClickListener);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
      this.g.setOnClickListener(paramOnClickListener);
      this.e.setOnClickListener(paramOnClickListener);
      this.f.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void c()
  {
    if (this.b != null) {
      this.b.removeAllViews();
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(paramInt);
  }
  
  public void c(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.f != null)
    {
      localTextView = this.f;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  @TargetApi(11)
  public void d()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.3F });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(2500L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new adgb(this));
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843010);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131437397));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843008);
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131437396));
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (Build.VERSION.SDK_INT >= 11))
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
    {
      if (!paramBoolean) {
        break label19;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
    label19:
    while (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.clearAnimation();
    if (Build.VERSION.SDK_INT > 11) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setAlpha(1.0F);
    }
  }
  
  public void f(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      return;
    }
  }
  
  public void g(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(500L);
      localRotateAnimation.setRepeatCount(-1);
      localRotateAnimation.setRepeatMode(1);
      localRotateAnimation.setStartTime(-1L);
      localRotateAnimation.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localRotateAnimation);
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new adfx(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer
 * JD-Core Version:    0.7.0.1
 */