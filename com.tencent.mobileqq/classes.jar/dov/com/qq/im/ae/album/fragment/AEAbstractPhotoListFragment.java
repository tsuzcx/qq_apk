package dov.com.qq.im.ae.album.fragment;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.RotateAnimation;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.album.AEAlbumLinearLayout;
import dov.com.qq.im.ae.album.AEAlbumPreviewMaskLayout;
import dov.com.qq.im.ae.album.AEAlbumPreviewMaskLayout.OnTouchCallback;
import dov.com.qq.im.ae.album.data.AEAlbumLogicData;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogic;
import dov.com.qq.im.ae.album.nocropper.AECropperView;
import dov.com.qq.im.ae.biz.qcircle.AECircleMultiUnit;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.util.AEThemeUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class AEAbstractPhotoListFragment
  extends ReportFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AEAlbumPreviewMaskLayout.OnTouchCallback, AEAbstractAlbumListFragment.IAlbumListBack
{
  public int a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public AsyncTask<Object, Object, List<LocalMediaInfo>> a;
  public GridLayoutManager a;
  public RecyclerView a;
  View jdField_a_of_type_AndroidViewView;
  public ViewGroup a;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public TextView a;
  private BubbleTextView jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
  PhotoListBaseData jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  public BaseVideoView a;
  public AEAlbumLinearLayout a;
  public AEAlbumPreviewMaskLayout a;
  public AEAbstractAlbumListFragment a;
  public AEAbstractPhotoListFragment.PhotoGridAdapter a;
  public AEPhotoListLogic a;
  public AECropperView a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  public final boolean a;
  public int b;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_b_of_type_AndroidViewView;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  public TextView b;
  private LottieDrawable jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  private FrameLayout jdField_c_of_type_AndroidWidgetFrameLayout;
  public TextView c;
  private boolean jdField_c_of_type_Boolean;
  public int d;
  TextView d;
  private TextView e;
  
  public AEAbstractPhotoListFragment()
  {
    this.jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter = null;
    this.jdField_a_of_type_Boolean = AEThemeUtil.a();
  }
  
  @Nullable
  private LocalMediaInfo a(Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap != null) {
        localObject1 = (LocalMediaInfo)this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.get(paramObject);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData != null)
      {
        localObject2 = localObject1;
        if (this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap != null) {
          localObject2 = (LocalMediaInfo)this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap.get(paramObject);
        }
      }
    }
    return localObject2;
  }
  
  public static void a(View paramView, boolean paramBoolean)
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
      paramView.startAnimation(localRotateAnimation);
      return;
    }
  }
  
  private void b(View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369563));
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = ((BaseVideoView)QQVideoViewFactory.b(getActivity(), 113L, null, null));
    this.jdField_c_of_type_AndroidWidgetFrameLayout.post(new AEAbstractPhotoListFragment.5(this));
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setOnClickListener(new AEAbstractPhotoListFragment.6(this));
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.e == null) {
      return;
    }
    int i;
    if (paramBoolean1)
    {
      this.e.setVisibility(0);
      if (this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView == null) {
        break label78;
      }
      i = this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.a();
    }
    for (;;)
    {
      if (i == 1) {
        if (this.jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable == null)
        {
          LottieComposition.Factory.fromAssetFileName(getActivity(), "imageselector_scale_expand.json", new AEAbstractPhotoListFragment.ScaleLottieCompositionLoaderListener(this, paramBoolean2, true));
          return;
          this.e.setVisibility(8);
          return;
          label78:
          i = 1;
        }
        else if (paramBoolean2)
        {
          this.jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
          this.e.setCompoundDrawables(this.jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable, null, null, null);
        }
      }
    }
    while (i != 2) {
      for (;;)
      {
        this.e.setCompoundDrawablePadding(ImmersiveUtils.dpToPx(4.0F));
        return;
        this.jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable.setProgress(1.0F);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null)
    {
      LottieComposition.Factory.fromAssetFileName(getActivity(), "imageselector_scale_shrink.json", new AEAbstractPhotoListFragment.ScaleLottieCompositionLoaderListener(this, paramBoolean2, false));
      return;
    }
    if (paramBoolean2) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
    }
    for (;;)
    {
      this.e.setCompoundDrawables(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable, null, null, null);
      break;
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setProgress(1.0F);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    int i = 0;
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      AECircleMultiUnit.a(bool, getActivity());
      if (!paramBoolean) {
        break label53;
      }
    }
    for (;;)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      localMarginLayoutParams.bottomMargin = i;
      this.jdField_b_of_type_AndroidWidgetFrameLayout.setLayoutParams(localMarginLayoutParams);
      return;
      bool = false;
      break;
      label53:
      i = getResources().getDimensionPixelSize(2131296287);
    }
  }
  
  private void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838057);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.dpToPx(30.0F), ImmersiveUtils.dpToPx(30.0F));
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131689706);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, 0, ImmersiveUtils.dpToPx(10.0F), 0);
      return;
      if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838056);
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.dpToPx(30.0F), ImmersiveUtils.dpToPx(30.0F));
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131689707);
    }
  }
  
  protected Dialog a()
  {
    return new ReportDialog(getActivity());
  }
  
  public abstract AEAbstractAlbumListFragment a();
  
  protected abstract AEPhotoListLogic a();
  
  public abstract Class a();
  
  public void a()
  {
    this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.h();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    int j = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    int k = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
    int i = j;
    if (i <= k)
    {
      if ((paramBoolean) && (paramInt != i)) {}
      label416:
      for (;;)
      {
        i += 1;
        break;
        Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i - j);
        LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.a(i);
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "updateCheckbox view = null at " + i);
          }
        }
        else if (localLocalMediaInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "updateCheckbox info = null at " + i);
          }
        }
        else
        {
          int m;
          AEAbstractPhotoListFragment.PhotoVH localPhotoVH;
          if (paramInt != i)
          {
            m = localArrayList.indexOf(localLocalMediaInfo.path);
            if (m >= 0)
            {
              localPhotoVH = (AEAbstractPhotoListFragment.PhotoVH)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
              if ((localPhotoVH != null) && (localPhotoVH.a != null)) {
                localPhotoVH.a.setCheckedNumber(m + 1 + this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum);
              }
            }
          }
          else
          {
            m = QAlbumUtil.getMediaType(localLocalMediaInfo);
            if ((m == 0) || (m == 1))
            {
              localPhotoVH = (AEAbstractPhotoListFragment.PhotoVH)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
              int n = localLocalMediaInfo.selectStatus;
              if (n == 1)
              {
                localPhotoVH.a.setCheckedNumber(localArrayList.indexOf(localLocalMediaInfo.path) + 1 + this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum);
                if (((View)localObject).getBackground() != null) {
                  ((View)localObject).setBackgroundDrawable(null);
                }
              }
              for (;;)
              {
                if (!AppSetting.d) {
                  break label416;
                }
                localObject = QAlbumUtil.createContentDescriptionWithCheckBox(m, localLocalMediaInfo, i, localPhotoVH.a.isChecked());
                localPhotoVH.a.setContentDescription((CharSequence)localObject);
                break;
                if (n == 3)
                {
                  localPhotoVH.a.setChecked(false);
                }
                else
                {
                  localPhotoVH.a.setChecked(false);
                  if (((View)localObject).getBackground() != null) {
                    ((View)localObject).setBackgroundDrawable(null);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131362620));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369487);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369518));
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.d = ((TextView)paramView.findViewById(2131369534));
    String str;
    if (this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName != null) {
      str = this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName;
    }
    for (;;)
    {
      a(str);
      this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131369530);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369481));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131367092));
      this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout = ((AEAlbumLinearLayout)paramView.findViewById(2131362323));
      this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.setScrollListener(new AEAbstractPhotoListFragment.3(this));
      this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView = ((AECropperView)paramView.findViewById(2131362324));
      this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setMaxZoom(5.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = ((BubbleTextView)paramView.findViewById(2131378778));
      this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout = ((AEAlbumPreviewMaskLayout)paramView.findViewById(2131367093));
      this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout.setOnTouchCallback(this);
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131370634));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369737));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380485));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131373021));
      ((DefaultItemAnimator)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
      this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(getActivity(), 3);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
      this.jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter = new AEAbstractPhotoListFragment.PhotoGridAdapter(this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter);
      this.jdField_c_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131373459));
      b(paramView);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380463));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new AEAbstractPhotoListFragment.4(this));
      this.e = ((TextView)paramView.findViewById(2131380510));
      this.e.setOnClickListener(this);
      this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.d();
      return;
      if (this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType == 2) {
        str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME_VIDEO;
      } else {
        str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
      }
    }
  }
  
  public void a(QQAlbumInfo paramQQAlbumInfo, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AEQLog.b("PhotoListActivity", "onAlbumListChoose--albumId=" + paramQQAlbumInfo.id);
      this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = paramQQAlbumInfo.name;
      this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = paramQQAlbumInfo.id;
      if (this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName == null) {
        break label119;
      }
    }
    label119:
    for (paramQQAlbumInfo = this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName;; paramQQAlbumInfo = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME)
    {
      a(paramQQAlbumInfo);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.firstResume = true;
      getActivity().runOnUiThread(new AEAbstractPhotoListFragment.8(this));
      c(false);
      return;
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    getActivity().setTitle(paramCharSequence);
    this.d.setText(paramCharSequence);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isRecodeLastAlbumPath)
    {
      QAlbumUtil.sLastAlbumRecordTime = System.currentTimeMillis();
      QAlbumUtil.sLastAlbumPhotoCountMap.put(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, Integer.valueOf(this.jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.getItemCount()));
      if (!TextUtils.isEmpty(paramString))
      {
        QAlbumUtil.sLastAlbumPath = paramString;
        HashMap localHashMap = QAlbumUtil.sSelectItemAlbum;
        if (localHashMap.containsKey(paramString))
        {
          paramString = (Pair)localHashMap.get(paramString);
          QAlbumUtil.sLastAlbumId = (String)paramString.first;
          QAlbumUtil.sLastAlbumName = (String)paramString.second;
          QAlbumUtil.putLastAlbumInfo(getActivity(), QAlbumUtil.sLastAlbumId, QAlbumUtil.sLastAlbumName);
        }
      }
    }
    QAlbumUtil.clearSelectItemInfo();
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidOsAsyncTask = new AEAbstractPhotoListFragment.QueryPhotoTask(this, paramBoolean1, paramBoolean2);
    this.jdField_a_of_type_AndroidOsAsyncTask.execute(new Object[0]);
  }
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    return (paramLocalMediaInfo != null) && ("image/gif".equals(paramLocalMediaInfo.mMimeType));
  }
  
  public void b()
  {
    c(false);
  }
  
  @MainThread
  public void b(boolean paramBoolean)
  {
    f(paramBoolean);
    e(paramBoolean);
  }
  
  public void c()
  {
    b(true, false);
    e();
  }
  
  public void c(boolean paramBoolean)
  {
    FragmentTransaction localFragmentTransaction;
    ObjectAnimator localObjectAnimator;
    if (this.jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractAlbumListFragment == null)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractAlbumListFragment = a();
        this.jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractAlbumListFragment.a(this);
      }
    }
    else
    {
      localFragmentTransaction = getFragmentManager().beginTransaction();
      localFragmentTransaction.setTransition(4097);
      if ((!paramBoolean) || (this.jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractAlbumListFragment.isAdded())) {
        break label166;
      }
      localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidWidgetFrameLayout, "backgroundColor", new int[] { getResources().getColor(2131165498), getResources().getColor(2131165509) });
      a(this.jdField_b_of_type_AndroidViewView, false);
      localFragmentTransaction.add(2131362620, this.jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractAlbumListFragment, null);
    }
    for (;;)
    {
      localFragmentTransaction.addToBackStack(null);
      localFragmentTransaction.commit();
      localObjectAnimator.setDuration(300L);
      localObjectAnimator.setEvaluator(new ArgbEvaluator());
      localObjectAnimator.setRepeatMode(2);
      localObjectAnimator.start();
      this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.b(paramBoolean);
      return;
      label166:
      localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidWidgetFrameLayout, "backgroundColor", new int[] { getResources().getColor(2131165509), getResources().getColor(2131165498) });
      a(this.jdField_b_of_type_AndroidViewView, true);
      localFragmentTransaction.remove(this.jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractAlbumListFragment);
    }
  }
  
  public void d()
  {
    b(false, false);
    f();
  }
  
  public void d(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() + this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum;
    int j;
    if (((i == this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) && (!paramBoolean)) || ((i == this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum - 1) && (paramBoolean)))
    {
      i = 1;
      if (i == 0) {
        return;
      }
      j = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
      int k = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
      i = j;
      label100:
      if (i > k) {
        return;
      }
      if (this.jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.getItemViewType(i) != 2) {
        break label130;
      }
    }
    for (;;)
    {
      i += 1;
      break label100;
      i = 0;
      break;
      label130:
      Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i - j);
      LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.a(i);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "updateCheckbox view = null at " + i);
        }
      }
      else if (localLocalMediaInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "updateCheckbox info = null at " + i);
        }
      }
      else
      {
        localObject = (AEAbstractPhotoListFragment.PhotoVH)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
        if ((paramBoolean) || (localLocalMediaInfo.selectStatus == 1)) {
          ((AEAbstractPhotoListFragment.PhotoVH)localObject).jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        } else {
          ((AEAbstractPhotoListFragment.PhotoVH)localObject).jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.3F);
        }
      }
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.getVisibility() == 0) || (AECameraPrefsUtil.a().a("sp_key_ae_photo_switch_ratio_tips", false, 0))) {}
    boolean bool;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setIncludeFontPadding(false);
      int i = UIUtils.a(getActivity(), 8.0F);
      int j = UIUtils.a(getActivity(), 6.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setPadding(i, j, i, j);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setTextSize(1, 14.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setTextColor(-1);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.jdField_a_of_type_Int = Color.parseColor("#252525");
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.b = UIUtils.a(getActivity(), 6.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.d = UIUtils.a(getActivity(), 6.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setText(getActivity().getString(2131689700));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.a();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(0);
      bool = AECameraPrefsUtil.a().a("sp_key_ae_photo_switch_ratio_tips_should_auto_disappear", true, 0);
      AEQLog.a("PhotoListActivity", "checkShowSwitchRatioTips--shouldAutoDisappear=" + bool);
    } while (!bool);
    this.jdField_a_of_type_JavaLangRunnable = new AEAbstractPhotoListFragment.7(this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.getVisibility() == 0)
    {
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(8);
      AECameraPrefsUtil.a().a("sp_key_ae_photo_switch_ratio_tips", true, 0);
    }
  }
  
  public void g()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        h();
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
  
  public void h()
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
  
  public void i()
  {
    int j = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    int k = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
    int i = j;
    if (i <= k)
    {
      Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i - j);
      LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.a(i);
      if (localObject == null) {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "updateCheckbox view = null at " + i);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (localLocalMediaInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "updateCheckbox info = null at " + i);
          }
        }
        else
        {
          int m = this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.indexOf(localLocalMediaInfo.path);
          if (m >= 0)
          {
            localObject = (AEAbstractPhotoListFragment.PhotoVH)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
            if ((localObject != null) && (((AEAbstractPhotoListFragment.PhotoVH)localObject).a != null)) {
              ((AEAbstractPhotoListFragment.PhotoVH)localObject).a.setCheckedNumber(m + 1 + this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum);
            }
          }
        }
      }
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.getId() == 2131375209) {
      this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.a(paramCompoundButton, paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = paramView.getId();
      if (i == 2131369487)
      {
        this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.a(paramView);
      }
      else if (i == 2131373458)
      {
        this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.b(paramView);
      }
      else if (i == 2131377769)
      {
        this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.c(paramView);
      }
      else if (i == 2131369481)
      {
        if ((this.jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractAlbumListFragment == null) || (!this.jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractAlbumListFragment.isAdded())) {
          bool1 = true;
        }
        if (bool1) {
          this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.b(getActivity().getIntent());
        }
        c(bool1);
      }
      else if (i == 2131369518)
      {
        this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.e(paramView);
        if ((this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData != null) && (this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null))
        {
          int j = this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
          AEBaseReportParam.a().a().a = AEBaseReportParam.a().b();
          int k;
          if (this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo)
          {
            AEBaseReportParam.a().a().b = AEBaseReportParam.g.longValue();
            long l = 0L;
            Iterator localIterator = this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.iterator();
            i = 0;
            while (localIterator.hasNext())
            {
              LocalMediaInfo localLocalMediaInfo = a(localIterator.next());
              if ((localLocalMediaInfo != null) && (QAlbumUtil.getMediaType(localLocalMediaInfo) == 1))
              {
                i += 1;
                l += localLocalMediaInfo.mDuration / 1000L;
              }
            }
            AEBaseReportParam.a().a().f = i;
            AEBaseReportParam.a().a().c = l;
            k = j - i;
            j = i;
            i = k;
          }
          for (;;)
          {
            AEBaseDataReporter.a().a(i);
            bool1 = bool2;
            if (this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum > 0) {
              bool1 = true;
            }
            AEReportUtils.a(bool1, i, j);
            break;
            AEBaseReportParam.a().a().b = AEBaseReportParam.d.longValue();
            k = 0;
            i = j;
            j = k;
          }
        }
      }
      else if (i == 2131380510)
      {
        this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.d(paramView);
        f();
        b(true, true);
      }
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT > 23) {
      getActivity().getWindow().setBackgroundDrawable(null);
    }
    this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData = this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData;
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("share", 4);
    paramBundle = getResources();
    int i = paramBundle.getDisplayMetrics().widthPixels;
    this.jdField_c_of_type_Int = paramBundle.getDimensionPixelSize(2131296712);
    this.jdField_a_of_type_Int = ((i - this.jdField_c_of_type_Int * 2) / 3);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    paramBundle = getActivity().getIntent();
    this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.a(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivity onCreate(),extra is:" + paramBundle.getExtras());
    }
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivity,hashCode is:" + System.identityHashCode(this));
    }
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558508, paramViewGroup, false);
    ViewCompat.setOnApplyWindowInsetsListener(paramLayoutInflater, new AEAbstractPhotoListFragment.1(this));
    if (paramLayoutInflater != null) {
      paramLayoutInflater.post(new AEAbstractPhotoListFragment.2(this, paramLayoutInflater));
    }
    FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.g();
    if (this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout != null) {
      this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.setScrollListener(null);
    }
    if (this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout != null) {
      this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout.setOnTouchCallback(null);
    }
  }
  
  public void onPause()
  {
    AEQLog.b("PhotoListActivity", "onPause---");
    super.onPause();
    this.jdField_a_of_type_AndroidOsAsyncTask = null;
    f();
    if ((this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying()))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
    }
  }
  
  public void onResume()
  {
    AEQLog.b("PhotoListActivity", "onResume---");
    super.onResume();
    this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.f();
    if ((this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.resume();
    }
  }
  
  public void onViewCreated(View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment
 * JD-Core Version:    0.7.0.1
 */