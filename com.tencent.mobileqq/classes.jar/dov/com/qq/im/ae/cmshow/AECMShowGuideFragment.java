package dov.com.qq.im.ae.cmshow;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.subscribe.utils.NavigationBarUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityCallBackInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.startup.step.InitMemoryCache;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AEQLog;
import mqq.app.AppRuntime;

public class AECMShowGuideFragment
  extends PublicBaseFragment
  implements View.OnClickListener, PublicFragmentActivityCallBackInterface
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ImageView b;
  
  private void a()
  {
    QIMCameraCaptureActivity.a(getActivity(), getArguments(), 100);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    PublicFragmentActivity.Launcher.a(paramActivity, paramIntent, PublicFragmentActivityForPeak.class, AECMShowGuideFragment.class, paramInt);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369672));
    this.b = ((ImageView)paramView.findViewById(2131369673));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380401));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    new InitMemoryCache().step();
    new InitUrlDrawable().step();
    try
    {
      paramView = URLDrawable.URLDrawableOptions.obtain();
      paramView.mRequestWidth = ViewUtils.a();
      paramView.mRequestHeight = ViewUtils.b();
      Drawable localDrawable = getResources().getDrawable(2131165217);
      paramView.mFailedDrawable = localDrawable;
      paramView.mLoadingDrawable = localDrawable;
      paramView.mRetryCount = 3;
      paramView = URLDrawable.getDrawable("https://downv6.qq.com/shadow_qqcamera/AECMJoy/aecmjoy_guide_avatar@2x.png", paramView);
      if (paramView.getStatus() == 2) {
        paramView.restartDownload();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        try
        {
          paramView = URLDrawable.URLDrawableOptions.obtain();
          localDrawable = getResources().getDrawable(2131165217);
          paramView.mFailedDrawable = localDrawable;
          paramView.mLoadingDrawable = localDrawable;
          paramView.mRetryCount = 3;
          paramView = URLDrawable.getDrawable("https://downv6.qq.com/shadow_qqcamera/AECMJoy/aecmjoy_guide_title@2x.png", paramView);
          if (paramView.getStatus() == 2) {
            paramView.restartDownload();
          }
          this.b.setImageDrawable(paramView);
          return;
        }
        catch (Exception paramView)
        {
          AEQLog.a("AECMShowGuideFragment", "set guide title image exception", paramView);
        }
        paramView = paramView;
        AEQLog.a("AECMShowGuideFragment", "set guide avatar image exception", paramView);
      }
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFlags(1024, 1024);
    if (Build.VERSION.SDK_INT >= 29) {
      NavigationBarUtil.a(paramActivity.getWindow());
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AEQLog.b("AECMShowGuideFragment", "onActivityResult--requestCode=" + paramInt1 + ", resultCode=" + paramInt2);
    getActivity().setResult(paramInt2, paramIntent);
    getActivity().finish();
  }
  
  public void onBackPressed()
  {
    AEQLog.b("AECMShowGuideFragment", "onBackPressed");
    getActivity().finish();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131380401)
    {
      a();
      AEBaseDataReporter.a().ax();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AECameraPrefsUtil.a().a("sp_key_cmshow_first_guide_has_shown_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), true, 4);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558506, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
    AEBaseDataReporter.a().aw();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.cmshow.AECMShowGuideFragment
 * JD-Core Version:    0.7.0.1
 */