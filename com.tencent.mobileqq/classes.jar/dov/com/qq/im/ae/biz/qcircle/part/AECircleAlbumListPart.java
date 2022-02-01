package dov.com.qq.im.ae.biz.qcircle.part;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.biz.qcircle.AECircleAlbumListFragment;
import dov.com.qq.im.ae.biz.qcircle.AECircleAlbumListFragment.IAlbumListBack;
import dov.com.qq.im.ae.biz.qcircle.AECirclePhotoListLogic;
import dov.com.qq.im.ae.biz.qcircle.event.AECircleTitleAlbumMenuChangeEvent;
import dov.com.qq.im.ae.biz.qcircle.part.base.AECircleBasePart;
import dov.com.qq.im.ae.biz.qcircle.part.base.AECircleBasePartFragment;
import dov.com.qq.im.ae.util.AEFastClickThrottle;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.List;

public class AECircleAlbumListPart
  extends AECircleBasePart
  implements View.OnClickListener, AECircleAlbumListFragment.IAlbumListBack
{
  private int jdField_a_of_type_Int;
  Dialog jdField_a_of_type_AndroidAppDialog;
  public AsyncTask<Object, Object, List<LocalMediaInfo>> a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public AECircleAlbumListFragment a;
  private final String jdField_a_of_type_JavaLangString = BaseApplication.getContext().getResources().getString(2131698001);
  private int b;
  
  public AECircleAlbumListPart(AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    super(paramAECirclePhotoListLogic);
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a(this);
  }
  
  private void c(boolean paramBoolean)
  {
    FragmentTransaction localFragmentTransaction = a().getFragmentManager().beginTransaction();
    localFragmentTransaction.setTransition(4097);
    if ((paramBoolean) && (!this.jdField_a_of_type_DovComQqImAeBizQcircleAECircleAlbumListFragment.isAdded())) {
      localFragmentTransaction.add(2131362620, this.jdField_a_of_type_DovComQqImAeBizQcircleAECircleAlbumListFragment, null);
    }
    for (;;)
    {
      localFragmentTransaction.addToBackStack(null);
      localFragmentTransaction.commit();
      SimpleEventBus.getInstance().dispatchEvent(new AECircleTitleAlbumMenuChangeEvent(paramBoolean));
      return;
      localFragmentTransaction.remove(this.jdField_a_of_type_DovComQqImAeBizQcircleAECircleAlbumListFragment);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECircleAlbumListFragment == null)
    {
      this.jdField_a_of_type_DovComQqImAeBizQcircleAECircleAlbumListFragment = new AECircleAlbumListFragment();
      this.jdField_a_of_type_DovComQqImAeBizQcircleAECircleAlbumListFragment.a(this);
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.jdField_a_of_type_DovComQqImAeBizQcircleAECircleAlbumListFragment.isAdded())) {}
    for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidWidgetFrameLayout, "backgroundColor", new int[] { this.b, this.jdField_a_of_type_Int });; localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidWidgetFrameLayout, "backgroundColor", new int[] { this.jdField_a_of_type_Int, this.b }))
    {
      localObjectAnimator.setDuration(300L);
      localObjectAnimator.setEvaluator(new ArgbEvaluator());
      localObjectAnimator.setRepeatMode(2);
      localObjectAnimator.start();
      return;
    }
  }
  
  protected Dialog a()
  {
    return new ReportDialog(a());
  }
  
  public String a()
  {
    return "AECircleAlbumListPart";
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131362620));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369534));
    a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369530));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369481));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_Int = a().getResources().getColor(2131165509);
    this.b = a().getResources().getColor(2131165498);
  }
  
  public void a(QQAlbumInfo paramQQAlbumInfo, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AEQLog.b("AECircleAlbumListPart", "onAlbumListChoose--albumId=" + paramQQAlbumInfo.id);
      this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a.albumName = paramQQAlbumInfo.name;
      this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a.albumId = paramQQAlbumInfo.id;
      if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a.albumName == null) {
        break label117;
      }
    }
    label117:
    for (paramQQAlbumInfo = this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a.albumName;; paramQQAlbumInfo = this.jdField_a_of_type_JavaLangString)
    {
      a(paramQQAlbumInfo);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.firstResume = true;
      a().runOnUiThread(new AECircleAlbumListPart.1(this));
      a(false);
      return;
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    a().setTitle(paramCharSequence);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    d();
    c(paramBoolean);
    d(paramBoolean);
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      b(bool);
      this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a(paramBoolean);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidOsAsyncTask = new AECircleAlbumListPart.QueryPhotoTask(this, paramBoolean1, paramBoolean2);
    this.jdField_a_of_type_AndroidOsAsyncTask.execute(new Object[0]);
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        c();
      }
      while (!this.jdField_a_of_type_AndroidAppDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppDialog = a();
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoListActivity", 2, "show dialog error", localException);
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    float f2 = 180.0F;
    if (paramBoolean) {}
    for (float f1 = 180.0F;; f1 = 0.0F)
    {
      if (paramBoolean) {
        f2 = 360.0F;
      }
      RotateAnimation localRotateAnimation = new RotateAnimation(f1, f2, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(300L);
      localRotateAnimation.setFillAfter(true);
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localRotateAnimation);
      return;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.cancel();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PhotoListActivity", 2, "cancel dialog error", localIllegalArgumentException);
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    if (this.jdField_a_of_type_AndroidOsAsyncTask != null) {
      this.jdField_a_of_type_AndroidOsAsyncTask.cancel(true);
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    this.jdField_a_of_type_AndroidOsAsyncTask = null;
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.needQueryTask)
    {
      if (this.jdField_a_of_type_AndroidOsAsyncTask == null) {
        a(true, true);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.needQueryTask = true;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic == null) {}
    do
    {
      do
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      } while (paramView.getId() != 2131369481);
      AEReportUtils.a(5, 2);
    } while (AEFastClickThrottle.a(paramView));
    if ((this.jdField_a_of_type_DovComQqImAeBizQcircleAECircleAlbumListFragment == null) || (!this.jdField_a_of_type_DovComQqImAeBizQcircleAECircleAlbumListFragment.isAdded())) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.b(a().getIntent());
      }
      a(bool);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.part.AECircleAlbumListPart
 * JD-Core Version:    0.7.0.1
 */