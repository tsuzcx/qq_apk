package com.tencent.mobileqq.nearby.profilecard;

import android.animation.LayoutTransition;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.AgeSelectionActivity;
import com.tencent.mobileqq.activity.JobSelectionActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationNearby;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.business.INearbyCardHandler;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.OffsetableImageSpan;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.webview.swift.WebViewUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AppRuntime;

public class NearbyProfileEditPanel
  extends NearbyProfileEditBasePanel
  implements View.OnClickListener
{
  public static final int a;
  static final int[] jdField_a_of_type_ArrayOfInt = { 2131376903, 2131376899, 2131376898, 2131376904, 2131376901, 2131376902, 2131376900 };
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new NearbyProfileEditPanel.24(this);
  Button jdField_a_of_type_AndroidWidgetButton;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  HorizontalScrollView jdField_a_of_type_AndroidWidgetHorizontalScrollView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private IphonePickerView.PickerViewAdapter jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new NearbyProfileEditPanel.17(this);
  NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  LabelEditCtrl jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelEditCtrl;
  NearbyPeopleProfileActivity jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
  private NearbyProfileEditPanel.OnPicDragListener jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel$OnPicDragListener;
  private PicInfo jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new NearbyProfileEditPanel.21(this);
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  String jdField_a_of_type_JavaLangString = "";
  final ArrayList<PicInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList(13);
  LinkedList<PicInfo> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  final InterestTag[] jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  EditText jdField_b_of_type_AndroidWidgetEditText;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private IphonePickerView.PickerViewAdapter jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new NearbyProfileEditPanel.18(this);
  final ArrayList<PicInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList(13);
  private boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 2015;
  EditText jdField_c_of_type_AndroidWidgetEditText;
  LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  private IphonePickerView.PickerViewAdapter jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new NearbyProfileEditPanel.25(this);
  int jdField_d_of_type_Int;
  EditText jdField_d_of_type_AndroidWidgetEditText;
  LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  int jdField_e_of_type_Int;
  EditText jdField_e_of_type_AndroidWidgetEditText;
  LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  int jdField_f_of_type_Int;
  EditText jdField_f_of_type_AndroidWidgetEditText;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  int jdField_g_of_type_Int;
  EditText jdField_g_of_type_AndroidWidgetEditText;
  TextView jdField_g_of_type_AndroidWidgetTextView;
  int jdField_h_of_type_Int;
  EditText jdField_h_of_type_AndroidWidgetEditText;
  TextView jdField_h_of_type_AndroidWidgetTextView;
  int i;
  private int j;
  
  static
  {
    jdField_a_of_type_Int = (WebViewUtil.a("nearby") << 8) + 101;
  }
  
  public NearbyProfileEditPanel(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    super(paramNearbyPeopleProfileActivity);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity = paramNearbyPeopleProfileActivity;
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel$OnPicDragListener = new NearbyProfileEditPanel.OnPicDragListener(this, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth);
    }
    this.i = UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2.0F);
    int m = LabelEditCtrl.jdField_a_of_type_ArrayOfInt.length - 1;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag = new InterestTag[m];
    int k = 0;
    while (k < m)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[k] = new InterestTag(LabelEditCtrl.jdField_a_of_type_ArrayOfInt[k]);
      k += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getRuntimeService(ITransFileController.class)).addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  private View.OnClickListener a(int paramInt)
  {
    return new NearbyProfileEditPanel.7(this, paramInt);
  }
  
  @TargetApi(11)
  private RelativeLayout a(PicInfo paramPicInfo, Drawable paramDrawable)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    localRelativeLayout.setBackgroundResource(2130845055);
    Object localObject = new LinearLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth);
    ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, this.i, 0);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new CustomImgView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    ((CustomImgView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    a((CustomImgView)localObject, paramPicInfo, paramDrawable);
    if (Build.VERSION.SDK_INT >= 11)
    {
      localRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      localRelativeLayout.setOnDragListener(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel$OnPicDragListener);
    }
    localRelativeLayout.addView((View)localObject);
    localRelativeLayout.addView(b());
    localRelativeLayout.setTag(paramPicInfo);
    return localRelativeLayout;
  }
  
  private void a(View paramView1, View paramView2)
  {
    paramView2.postDelayed(new NearbyProfileEditPanel.26(this, paramView2, paramView1), 300L);
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    int k;
    if (paramBoolean) {
      k = 2131167050;
    } else {
      k = 2131167056;
    }
    paramTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColorStateList(k));
  }
  
  private void a(TextView paramTextView, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      Object localObject2 = null;
      Object localObject1;
      try
      {
        localObject1 = RichStatus.parseStatus(paramArrayOfByte);
      }
      catch (RuntimeException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("RichStatus parseStatus error: ");
        ((StringBuilder)localObject1).append(paramArrayOfByte);
        QLog.e("NearbyProfileEditPanel", 1, ((StringBuilder)localObject1).toString());
        localObject1 = null;
      }
      paramArrayOfByte = (byte[])localObject2;
      if (localObject1 != null) {
        paramArrayOfByte = ((RichStatus)localObject1).toSpannableString(null, -8947849, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131165327));
      }
      localObject2 = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        localObject2 = new SpannableString("");
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((RichStatus)localObject1).actionText)))
      {
        localObject2 = new SpannableStringBuilder((CharSequence)localObject2);
        ((SpannableStringBuilder)localObject2).insert(0, "[S] ");
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mStatusManager != null) {
          paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mStatusManager.a(((RichStatus)localObject1).actionId, 200);
        } else {
          paramArrayOfByte = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), 2130849881);
        }
        paramArrayOfByte = new StatableBitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), paramArrayOfByte, false, false);
        int k = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
        paramArrayOfByte.setBounds(0, 0, k, k);
        paramArrayOfByte = new OffsetableImageSpan(paramArrayOfByte, 0);
        paramArrayOfByte.setOffset(-0.1F);
        ((SpannableStringBuilder)localObject2).setSpan(paramArrayOfByte, 0, 3, 17);
        paramTextView.setText((CharSequence)localObject2);
        return;
      }
      paramTextView.setText((CharSequence)localObject2);
    }
  }
  
  private void a(PicInfo paramPicInfo, View paramView)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramPicInfo);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mPicInfo.remove(paramPicInfo);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(paramView);
      k();
      m();
      return;
    }
    paramPicInfo = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, HardCodeUtil.a(2131707368), 0, 0, null, null);
    paramPicInfo.setPositiveButton(2131694583, new NearbyProfileEditPanel.9(this, paramPicInfo));
    paramPicInfo.show();
  }
  
  private void a(CustomImgView paramCustomImgView, PicInfo paramPicInfo, Drawable paramDrawable)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setDrawable, pos:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidWidgetLinearLayout.indexOfChild(paramCustomImgView));
      ((StringBuilder)localObject).append(",picInfo:");
      ((StringBuilder)localObject).append(paramPicInfo);
      QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject).toString());
    }
    paramCustomImgView.setTag(paramPicInfo);
    Object localObject = paramDrawable;
    if (paramDrawable == null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130845868);
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth;
      localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth;
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      if ((paramPicInfo.c != null) && (paramPicInfo.c.length() > 0))
      {
        paramPicInfo = new File(paramPicInfo.c).toURL();
        URLDrawable.removeMemoryCacheByUrl(paramPicInfo.toString());
        paramCustomImgView.setImageDrawable(URLDrawable.getDrawable(paramPicInfo, localURLDrawableOptions));
        return;
      }
      paramDrawable = null;
      if (!TextUtils.isEmpty(paramPicInfo.b)) {
        paramDrawable = paramPicInfo.b;
      } else if (!TextUtils.isEmpty(paramPicInfo.jdField_a_of_type_JavaLangString)) {
        paramDrawable = paramPicInfo.jdField_a_of_type_JavaLangString;
      }
      if (!TextUtils.isEmpty(paramDrawable))
      {
        paramCustomImgView.setImageDrawable(URLDrawable.getDrawable(NearbyImgDownloader.convertURL(paramDrawable), localURLDrawableOptions));
        return;
      }
    }
    catch (MalformedURLException paramCustomImgView)
    {
      if (QLog.isColorLevel())
      {
        paramPicInfo = new StringBuilder();
        paramPicInfo.append("GridAdapter.getView() new URL(). ");
        paramPicInfo.append(paramCustomImgView.getMessage());
        QLog.d("Q.nearby_people_card.", 2, paramPicInfo.toString(), paramCustomImgView);
      }
    }
  }
  
  private View b()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    localRelativeLayout.setBackgroundResource(2130841416);
    Object localObject = new RelativeLayout.LayoutParams(UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 35.0F), UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 16.0F));
    int k = UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 5.0F);
    ((RelativeLayout.LayoutParams)localObject).setMargins(k, 0, 0, k);
    ((RelativeLayout.LayoutParams)localObject).addRule(9);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new TextView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    ((TextView)localObject).setText(HardCodeUtil.a(2131707387));
    ((TextView)localObject).setTextColor(-1);
    ((TextView)localObject).setTextSize(1, 12.0F);
    ((TextView)localObject).setSingleLine(true);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    localLayoutParams.setMargins(k, 0, k, 0);
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    localRelativeLayout.addView((View)localObject);
    localRelativeLayout.setVisibility(8);
    return localRelativeLayout;
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
      return true;
    }
    int m = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (m != this.jdField_b_of_type_JavaUtilArrayList.size()) {
      return true;
    }
    int k = 0;
    while (k < m)
    {
      if (((PicInfo)this.jdField_a_of_type_JavaUtilArrayList.get(k)).jdField_a_of_type_Int != ((PicInfo)this.jdField_b_of_type_JavaUtilArrayList.get(k)).jdField_a_of_type_Int) {
        return true;
      }
      k += 1;
    }
    return false;
  }
  
  private boolean e()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (!StringUtil.a(str))
    {
      if (StringUtil.d(str).length() == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showToast(HardCodeUtil.a(2131707306));
        return false;
      }
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showToast(HardCodeUtil.a(2131707319));
    return false;
  }
  
  private void j()
  {
    ActionSheet localActionSheet = ActionSheet.createMenuSheet(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    Object localObject = (DispatchActionMoveScrollView)localActionSheet.findViewById(2131361999);
    ((DispatchActionMoveScrollView)localObject).jdField_a_of_type_Boolean = true;
    ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
    localObject = (IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity).inflate(2131561132, null);
    ((IphonePickerView)localObject).a(this.jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
    if (this.jdField_h_of_type_AndroidWidgetEditText.getTag() != null)
    {
      int m = (byte)(((Byte)this.jdField_h_of_type_AndroidWidgetEditText.getTag()).byteValue() - 1);
      int k;
      if (m >= 0)
      {
        k = m;
        if (m <= 3) {}
      }
      else
      {
        k = 0;
      }
      ((IphonePickerView)localObject).setSelection(0, k);
      ((IphonePickerView)localObject).setPickListener(new NearbyProfileEditPanel.5(this, k, localActionSheet));
      localActionSheet.setOnDismissListener(new NearbyProfileEditPanel.6(this));
      localActionSheet.setActionContentView((View)localObject, null);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFinishing()) {
        return;
      }
      localActionSheet.show();
      a(this.jdField_e_of_type_AndroidWidgetLinearLayout, localActionSheet.getActionContentView());
      a(this.jdField_h_of_type_AndroidWidgetEditText, true);
    }
  }
  
  private void k()
  {
    l();
    int k = 0;
    while (k < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(k) instanceof RelativeLayout))
      {
        localObject = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(k);
        ((RelativeLayout)localObject).setOnClickListener(a(k));
        if (((RelativeLayout)localObject).getChildCount() == 2)
        {
          if (k == 0) {
            ((RelativeLayout)localObject).getChildAt(1).setVisibility(0);
          } else {
            ((RelativeLayout)localObject).getChildAt(1).setVisibility(8);
          }
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(k) != null)
          {
            localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(k);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(HardCodeUtil.a(2131707297));
            localStringBuilder.append(k + 1);
            ((View)localObject).setContentDescription(localStringBuilder.toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("Q.nearby_people_card.", 2, "updatePhotoStatus, headItem's child count is not 2");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("Q.nearby_people_card.", 2, "updatePhotoStatus, the child of mEditLayout is not a instance of RelativeLayout");
      }
      k += 1;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    } else {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    Object localObject = this.jdField_c_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList.size());
    localStringBuilder.append("/");
    localStringBuilder.append(NearbyProfileCardConstants.jdField_a_of_type_Int);
    ((TextView)localObject).setText(localStringBuilder.toString());
  }
  
  private void l()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    int k = 0;
    while (k < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      this.jdField_a_of_type_JavaUtilArrayList.add((PicInfo)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(k).getTag());
      k += 1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reorganizePicInfo:");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList);
      QLog.d("Q.nearby_people_card.", 2, localStringBuilder.toString());
    }
  }
  
  private void m()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "del_pho", 0, 0, "", "", "", "");
  }
  
  private void n()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "up_gif", 0, 0, "", "", "", "");
  }
  
  private void o()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
    if ((localObject != null) && (((NearbyPeopleCard)localObject).godFlag))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694416, new Object[] { this.jdField_a_of_type_JavaLangString });
      localObject = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, (String)localObject, 0, 0, null, null);
      ((QQCustomDialog)localObject).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694710), new NearbyProfileEditPanel.8(this, (QQCustomDialog)localObject));
      ((QQCustomDialog)localObject).show();
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showUploadPhotoActionSheet();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) && (QLog.isColorLevel())) {
      QLog.d("NearbyProfileEditPanel", 2, "mcard is null");
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707326));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707287));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 10.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131369202).setVisibility(8);
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369204);
    localTextView.setVisibility(0);
    localTextView.setText(2131690728);
    localTextView.setOnClickListener(new NearbyProfileEditPanel.19(this));
    localTextView = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369233);
    localTextView.setVisibility(0);
    localTextView.setText(2131692486);
    localTextView.setEnabled(true);
    localTextView.setOnClickListener(new NearbyProfileEditPanel.20(this));
    this.jdField_b_of_type_AndroidViewView.findViewById(2131376636).setOnClickListener(this);
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      Object localObject = new StringBuilder(HardCodeUtil.a(2131707315));
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int - this.jdField_a_of_type_JavaUtilLinkedList.size() + 1);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append(")...");
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showWaitingDialog(((StringBuilder)localObject).toString());
      localObject = new NearbyProfileEditPanel.22(this);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.execute((Runnable)localObject);
      return;
    }
    g();
  }
  
  protected int a()
  {
    return 2131561213;
  }
  
  Intent a(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, PhotoCropActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    paramString = new StringBuilder();
    paramString.append(AppConstants.SDCARD_PATH);
    paramString.append("nearby_people_photo/");
    paramString = paramString.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(".jpg");
    localIntent.putExtra("PhotoConst.TARGET_PATH", localStringBuilder.toString());
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", 640);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.QZONE_COVER_CROP_LEFT_TITLE", HardCodeUtil.a(2131707320));
    localIntent.putExtra("FROM_WHERE", "FROM_NEARBY_PROFILE");
    return localIntent;
  }
  
  public void a()
  {
    ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getRuntimeService(ITransFileController.class)).removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  public void a(int paramInt)
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, "/base/album/photolist");
    int k = NearbyProfileCardConstants.jdField_a_of_type_Int;
    localActivityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", k - paramInt);
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getClass().getName());
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_MODE", false);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localActivityURIRequest.extra().putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append("nearby_people_photo/");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(".jpg");
    localObject = localStringBuilder.toString();
    localActivityURIRequest.extra().putString("PhotoConst.TARGET_PATH", (String)localObject);
    localActivityURIRequest.extra().putInt("PhotoConst.CLIP_WIDTH", 640);
    localActivityURIRequest.extra().putInt("PhotoConst.CLIP_HEIGHT", 640);
    localActivityURIRequest.extra().putInt("PhotoConst.TARGET_WIDTH", 640);
    localActivityURIRequest.extra().putInt("PhotoConst.TARGET_HEIGHT", 640);
    localActivityURIRequest.extra().putInt("enter_from", 30);
    localActivityURIRequest.extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationNearby.jdField_a_of_type_JavaLangString);
    QRoute.startUri(localActivityURIRequest);
    AlbumUtil.anim(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, false, true);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800481F", "0X800481F", 1, 0, "", "", "", "");
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int k = this.jdField_c_of_type_Int;
    int m = paramInt1 + 1896;
    k -= m;
    Object localObject1 = Calendar.getInstance();
    int n = paramInt2 + 1;
    paramInt3 += 1;
    ((Calendar)localObject1).set(1, n, paramInt3);
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).set(1, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
    paramInt1 = k;
    if (((Calendar)localObject1).after(localObject2)) {
      paramInt1 = k - 1;
    }
    paramInt2 = paramInt1;
    if (paramInt1 < 0) {
      paramInt2 = 0;
    }
    localObject1 = Utils.a(n, paramInt3);
    paramInt1 = AgeSelectionActivity.a((String)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(m);
    ((StringBuilder)localObject2).append("-");
    ((StringBuilder)localObject2).append(n);
    ((StringBuilder)localObject2).append("-");
    ((StringBuilder)localObject2).append(paramInt3);
    ((StringBuilder)localObject2).append(" ");
    ((StringBuilder)localObject2).append("(");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append("岁");
    ((StringBuilder)localObject2).append(" ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(")");
    this.jdField_c_of_type_AndroidWidgetEditText.setText(((StringBuilder)localObject2).toString());
    this.jdField_c_of_type_AndroidWidgetEditText.setTag(new Object[] { Integer.valueOf(m << 16 | n << 8 | paramInt3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1;
    int k;
    int m;
    Object localObject2;
    if (paramInt1 != 1)
    {
      localObject1 = "";
      k = 0;
      m = 0;
      if (paramInt1 != 11) {
        if (paramInt1 != 14) {
          if (paramInt1 != 11000) {
            if (paramInt1 != 3)
            {
              if (paramInt1 != 4)
              {
                if (paramInt1 != 5) {
                  return;
                }
                if ((paramInt2 != -1) || (paramIntent == null)) {
                  break label678;
                }
                localObject1 = paramIntent.getStringExtra("key_cover_selected_img_path");
                this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mAlbumId = paramIntent.getStringExtra("key_album_id");
                if ((StringUtil.a((String)localObject1)) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 1) || (this.jdField_a_of_type_JavaUtilArrayList.size() >= NearbyProfileCardConstants.jdField_a_of_type_Int)) {
                  break label678;
                }
                paramIntent = a((String)localObject1);
                this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramIntent);
                return;
              }
              if (paramInt2 != -1) {
                break label678;
              }
              localObject2 = paramIntent.getStringArrayExtra("param_location");
            }
          }
        }
      }
    }
    try
    {
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mConditionSearchManager.a((String[])localObject2);
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        label678:
        continue;
        paramInt1 += 1;
      }
    }
    paramIntent = null;
    if (paramIntent != null)
    {
      localObject1 = paramIntent;
      if (!paramIntent.equals("不限")) {}
    }
    else
    {
      localObject1 = "";
    }
    paramIntent = this.jdField_f_of_type_AndroidWidgetEditText;
    if (paramIntent != null)
    {
      paramIntent.setText((CharSequence)localObject1);
      this.jdField_f_of_type_AndroidWidgetEditText.setTag(localObject2);
      return;
      if ((paramInt2 == -1) && (this.jdField_d_of_type_AndroidWidgetEditText != null))
      {
        localObject1 = paramIntent.getStringExtra("param_name");
        paramInt1 = paramIntent.getIntExtra("param_id", -1);
        localObject2 = paramIntent.getStringExtra("param_tag");
        paramInt2 = paramIntent.getIntExtra("param_tag_bg", -1);
        if ((localObject2 != null) && (((String)localObject2).length() > 0) && (paramInt2 > 0))
        {
          this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(paramInt2);
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        else
        {
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        this.jdField_d_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
        this.jdField_d_of_type_AndroidWidgetEditText.setTag(Integer.valueOf(paramInt1));
        return;
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getExtras();
          paramIntent.getString("video_id");
          paramIntent.getInt("head_id");
          return;
          if (paramInt2 == -1)
          {
            paramIntent = paramIntent.getParcelableArrayListExtra("intent_param_pic_infos");
            if (paramIntent != null)
            {
              if (paramIntent.size() == 0) {
                return;
              }
              this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
              paramInt1 = m;
              while (paramInt1 < paramIntent.size())
              {
                this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a((PicInfo)paramIntent.get(paramInt1), null));
                paramInt1 += 1;
              }
              k();
              return;
            }
            return;
            if ((paramInt2 == -1) && (paramIntent != null))
            {
              try
              {
                localObject2 = paramIntent.getParcelableArrayListExtra("choosed_interest_tags");
                paramInt2 = paramIntent.getIntExtra("interest_tag_type", -1);
                paramInt1 = k;
                if (paramInt1 < this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag.length)
                {
                  if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[paramInt1].jdField_a_of_type_Int != paramInt2) {
                    break label683;
                  }
                  paramIntent = this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[paramInt1];
                  paramIntent.jdField_a_of_type_JavaUtilArrayList.clear();
                  if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
                    paramIntent.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject2);
                  }
                }
                this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelEditCtrl.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag);
                if (!QLog.isDevelopLevel()) {
                  break label678;
                }
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("doOnActivity result code :11 ");
                if (localObject2 == null) {
                  paramIntent = (Intent)localObject1;
                } else {
                  paramIntent = localObject2.toString();
                }
                localStringBuilder.append(paramIntent);
                localStringBuilder.append(" ");
                localStringBuilder.append(paramInt2);
                QLog.i("Q.nearby_people_card.", 4, localStringBuilder.toString());
                return;
              }
              catch (Exception paramIntent)
              {
                if (!QLog.isColorLevel()) {
                  break label678;
                }
              }
              QLog.i("Q.nearby_people_card.", 2, paramIntent.getMessage());
              return;
              if ((paramInt2 == -1) && (paramIntent != null))
              {
                paramIntent = paramIntent.getByteArrayExtra("param_new_xuan_yan");
                localObject1 = this.jdField_g_of_type_AndroidWidgetEditText;
                if (localObject1 != null)
                {
                  a((TextView)localObject1, paramIntent);
                  this.jdField_g_of_type_AndroidWidgetEditText.setTag(paramIntent);
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
    this.jdField_b_of_type_AndroidViewView = paramView;
    paramView.findViewById(2131378837).setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378880));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378814));
    paramView.findViewById(2131369249).setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366068));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167116));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)paramView.findViewById(2131366069));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366049));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams().height = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth;
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    localLinearLayout.setLayoutParams(localLinearLayout.getLayoutParams());
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372578));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378036));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131366066));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366067));
    this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377855));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131371877));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131367600));
    this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131362294));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364354));
    this.jdField_d_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131369573));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369574));
    this.jdField_e_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131365040));
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131364810));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364809));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364376));
    this.jdField_f_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131368222));
    this.jdField_g_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131381299));
    this.jdField_h_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131377850));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131367042));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376897));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)paramView.findViewById(2131378881));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366074));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.mScrollFlag = 1;
    paramView = (LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131369714);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelEditCtrl = new LabelEditCtrl();
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelEditCtrl.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, paramView);
    p();
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("EditPanel bindData, isEditing = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(", mActivity.mPicInfo.size = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mPicInfo);
      if (((StringBuilder)localObject).toString() == null) {
        localObject = "null";
      } else {
        localObject = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mPicInfo.size());
      }
      QLog.d("Q.nearby_people_card.", 2, new Object[] { localObject });
    }
    int k = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
    String str = NearbyUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(k);
    localStringBuilder.append("");
    ReportController.b((AppRuntime)localObject, "dc00899", "grp_lbs", "", "data_card", "exp_edit", 0, 0, str, localStringBuilder.toString(), "", "");
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mPicInfo);
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHasNewPhoto)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mPicInfo.clear();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0) {
      this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131707316);
    } else if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1) {
      this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131707371);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694407));
    } else if (this.jdField_a_of_type_JavaUtilArrayList.size() > 12) {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694408, new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(HardCodeUtil.a(2131707280));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new NearbyProfileEditPanel.10(this));
    e();
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
    this.jdField_b_of_type_AndroidWidgetEditText.setText(NearbyProfileUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender));
    this.jdField_b_of_type_AndroidWidgetEditText.setTag(Byte.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender));
    k = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age;
    int m = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday;
    int n = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation;
    int i1 = (0xFF00 & m) >> 8;
    int i2 = m & 0xFF;
    paramNearbyPeopleCard = Utils.a(i1, i2);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(m >> 16);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(i2);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append("(");
    ((StringBuilder)localObject).append(k);
    ((StringBuilder)localObject).append("岁");
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramNearbyPeopleCard);
    ((StringBuilder)localObject).append(")");
    this.jdField_c_of_type_AndroidWidgetEditText.setText(((StringBuilder)localObject).toString());
    this.jdField_c_of_type_AndroidWidgetEditText.setTag(new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(n) });
    k = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job;
    this.jdField_e_of_type_AndroidWidgetTextView.setText(NearbyProfileUtil.d(k));
    if (StringUtil.a(NearbyProfileUtil.d(k)))
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    else
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(NearbyProfileUtil.b(k));
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_d_of_type_AndroidWidgetEditText.setText(NearbyProfileUtil.e(k));
    this.jdField_d_of_type_AndroidWidgetEditText.setTag(Integer.valueOf(k));
    this.jdField_e_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company);
    this.jdField_e_of_type_AndroidWidgetEditText.clearFocus();
    paramNearbyPeopleCard = (String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "school_name", "");
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college);
      if (TextUtils.equals(paramNearbyPeopleCard, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college))
      {
        this.j = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "school_valid_state", Integer.valueOf(0))).intValue();
        if (this.j == 2) {
          this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
        } else {
          this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.collegeId == 0L)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college))
          {
            this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
            this.j = 1;
          }
          else
          {
            this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
            this.j = 2;
          }
        }
        else
        {
          this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
          this.j = 1;
        }
        ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "school_name", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college);
        ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "school_valid_state", Integer.valueOf(this.j));
      }
    }
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    d();
    a(this.jdField_g_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
    this.jdField_g_of_type_AndroidWidgetEditText.setTag(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
    this.jdField_h_of_type_AndroidWidgetEditText.setText(NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus - 1));
    this.jdField_h_of_type_AndroidWidgetEditText.setTag(Byte.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus));
    if (NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vGiftInfo) != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      boolean bool;
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchGiftVisible == 0L) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag)
    {
      paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694417, new Object[] { this.jdField_a_of_type_JavaLangString });
      paramNearbyPeopleCard = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, paramNearbyPeopleCard, 0, 0, null, null);
      paramNearbyPeopleCard.setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694710), new NearbyProfileEditPanel.11(this, paramNearbyPeopleCard));
      paramNearbyPeopleCard.show();
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelEditCtrl.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag);
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mIsFromInterestTest) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mEnterEidtTimes == 1)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHandler.postDelayed(new NearbyProfileEditPanel.12(this), 300L);
    }
    this.jdField_b_of_type_AndroidViewView.findViewById(2131381300).setOnClickListener(this);
    this.jdField_g_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131377855).setOnClickListener(this);
    this.jdField_h_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131367603).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131362296).setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131369574).setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131368223).setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new NearbyProfileEditPanel.13(this));
    this.jdField_g_of_type_AndroidWidgetEditText.addTextChangedListener(new NearbyProfileEditPanel.14(this));
    this.jdField_e_of_type_AndroidWidgetEditText.addTextChangedListener(new NearbyProfileEditPanel.15(this));
    this.jdField_a_of_type_AndroidWidgetEditText.getViewTreeObserver().addOnGlobalLayoutListener(new NearbyProfileEditPanel.16(this));
  }
  
  public void a(String paramString, int paramInt)
  {
    int m = 1;
    int k = 1;
    this.jdField_b_of_type_Boolean = true;
    if (TextUtils.isEmpty(paramString))
    {
      this.j = 1;
      this.jdField_f_of_type_AndroidWidgetTextView.setText("");
      paramInt = 0;
    }
    else
    {
      if (paramInt == 0)
      {
        if (TextUtils.equals(this.jdField_f_of_type_AndroidWidgetTextView.getText().toString(), paramString)) {
          if (this.j == 2)
          {
            paramInt = m;
            break label103;
          }
        }
        for (;;)
        {
          paramInt = 0;
          break;
          this.j = paramInt;
        }
      }
      else
      {
        if (paramInt != 2) {
          k = 0;
        }
        this.j = paramInt;
        paramInt = k;
      }
      label103:
      this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString);
    }
    if (paramInt != 0)
    {
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8006784", "0X8006784", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mNeedClearPhotoWallWhenCancel) {
      return true;
    }
    if (d()) {
      return true;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
    if (localObject1 != null)
    {
      if (!Arrays.equals(((NearbyPeopleCard)localObject1).xuanYan, (byte[])this.jdField_g_of_type_AndroidWidgetEditText.getTag())) {
        return true;
      }
      if (!Utils.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname)) {
        return true;
      }
      if ((this.jdField_h_of_type_AndroidWidgetEditText.getTag() != null) && (((Byte)this.jdField_h_of_type_AndroidWidgetEditText.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus)) {
        return true;
      }
      if (((Byte)this.jdField_b_of_type_AndroidWidgetEditText.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender) {
        return true;
      }
      if (((Integer)((Object[])(Object[])this.jdField_c_of_type_AndroidWidgetEditText.getTag())[0]).intValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday) {
        return true;
      }
      if (((Integer)this.jdField_d_of_type_AndroidWidgetEditText.getTag()).intValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job) {
        return true;
      }
      if (!StringUtil.d(this.jdField_e_of_type_AndroidWidgetEditText.getText().toString()).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company)) {
        return true;
      }
      if (!StringUtil.d(this.jdField_f_of_type_AndroidWidgetTextView.getText().toString()).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college)) {
        return true;
      }
      if (!Arrays.equals((String[])this.jdField_f_of_type_AndroidWidgetEditText.getTag(), new String[] { this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCountry, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownProvice, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCity, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownDistrict })) {
        return true;
      }
      boolean bool4 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      boolean bool3;
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchGiftVisible == 0L) {
        bool3 = true;
      } else {
        bool3 = false;
      }
      if (bool4 != bool3) {
        return true;
      }
      Object localObject2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag;
      int m = localObject2.length;
      int k = 0;
      boolean bool2;
      for (boolean bool1 = false;; bool1 = bool2)
      {
        bool2 = bool1;
        if (k >= m) {
          break;
        }
        localObject1 = localObject2[k];
        if (localObject1 == null)
        {
          bool2 = bool1;
        }
        else
        {
          InterestTag localInterestTag = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getTagInfos(((InterestTag)localObject1).jdField_a_of_type_Int);
          if ((localInterestTag == null) && (((InterestTag)localObject1).jdField_a_of_type_JavaUtilArrayList.size() == 0))
          {
            bool2 = bool1;
          }
          else
          {
            bool1 = ((InterestTag)localObject1).equals(localInterestTag) ^ true;
            bool2 = bool1;
            if (bool1)
            {
              bool2 = bool1;
              if (!QLog.isDevelopLevel()) {
                break;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("tagChanged \n");
              ((StringBuilder)localObject2).append("item: ");
              ((StringBuilder)localObject2).append(((InterestTag)localObject1).toString());
              ((StringBuilder)localObject2).append("\n");
              ((StringBuilder)localObject2).append("tag: ");
              if (localInterestTag == null) {
                localObject1 = "null";
              } else {
                localObject1 = localInterestTag.toString();
              }
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append("\n");
              QLog.i("InterestTag", 4, ((StringBuilder)localObject2).toString());
              bool2 = bool1;
              break;
            }
          }
        }
        k += 1;
      }
      if (bool2) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(PicInfo paramPicInfo)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a(paramPicInfo, null), this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount());
    k();
    return true;
  }
  
  int b()
  {
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    int k = 0;
    while (k < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      PicInfo localPicInfo = (PicInfo)this.jdField_a_of_type_JavaUtilArrayList.get(k);
      if (localPicInfo.jdField_a_of_type_Int == -1) {
        this.jdField_a_of_type_JavaUtilLinkedList.add(localPicInfo);
      }
      k += 1;
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilLinkedList.size();
    return this.jdField_b_of_type_Int;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.fullScroll(66);
  }
  
  boolean b()
  {
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    int m = this.jdField_b_of_type_JavaUtilArrayList.size();
    if ((m <= 0) && (k >= 1)) {
      return true;
    }
    if ((m >= 1) && (k <= 0)) {
      return true;
    }
    return (m >= 1) && (k >= 1) && (((PicInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int != ((PicInfo)this.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int);
  }
  
  public void c()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, LocationSelectActivity.class);
    localIntent.putExtra("param_req_type", 3);
    ConditionSearchManager localConditionSearchManager = (ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
    int k = localConditionSearchManager.a();
    Object localObject;
    if (k != 0)
    {
      k = localConditionSearchManager.a(k, true);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startLocationSelectActivity | update result = ");
        ((StringBuilder)localObject).append(k);
        QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject).toString());
      }
      if (k == 2)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2131694424, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
        return;
      }
      if (k == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
        ((NearbyPeopleProfileActivity)localObject).showWaitingDialog(((NearbyPeopleProfileActivity)localObject).getResources().getString(2131691060));
        localConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mConfigListener);
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      ((NearbyPeopleProfileActivity)localObject).showWaitingDialog(((NearbyPeopleProfileActivity)localObject).getResources().getString(2131691060));
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHandler.sendEmptyMessageDelayed(206, 20000L);
      return;
    }
    String[] arrayOfString = (String[])this.jdField_f_of_type_AndroidWidgetEditText.getTag();
    if (arrayOfString != null)
    {
      localObject = arrayOfString;
      if (arrayOfString.length == 4) {}
    }
    else
    {
      localObject = new String[4];
      localObject[0] = "0";
      localObject[1] = "0";
      localObject[2] = "0";
      localObject[3] = "0";
    }
    localIntent.putExtra("param_location", (String[])localObject);
    localIntent.putExtra("param_is_popup", false);
    localIntent.putExtra("param_location_param", localConditionSearchManager.b((String[])localObject));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(localIntent, 4);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mNeedClearPhotoWallWhenCancel) {
      return true;
    }
    if (d()) {
      return true;
    }
    NearbyPeopleCard localNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
    if (localNearbyPeopleCard != null)
    {
      if (!Arrays.equals(localNearbyPeopleCard.xuanYan, (byte[])this.jdField_g_of_type_AndroidWidgetEditText.getTag())) {
        return true;
      }
      if (!Utils.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname)) {
        return true;
      }
    }
    return false;
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
    if (localObject == null) {
      return;
    }
    String[] arrayOfString = new String[4];
    arrayOfString[0] = ((NearbyPeopleCard)localObject).hometownCountry;
    arrayOfString[1] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownProvice;
    arrayOfString[2] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCity;
    arrayOfString[3] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownDistrict;
    localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mConditionSearchManager.a(arrayOfString);
    if (this.jdField_f_of_type_AndroidWidgetEditText != null)
    {
      if (!"不限".equals(localObject)) {
        this.jdField_f_of_type_AndroidWidgetEditText.setText((CharSequence)localObject);
      }
      this.jdField_f_of_type_AndroidWidgetEditText.setTag(arrayOfString);
    }
  }
  
  @TargetApi(11)
  void e()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.oldPhotoCount > 0) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age >= 14) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age <= 24) && (this.jdField_a_of_type_JavaUtilArrayList.size() <= 1)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800481B", "0X800481B", 0, 0, "", "", "", "");
    }
    int m = Build.VERSION.SDK_INT;
    int k = 0;
    if (m >= 11)
    {
      LayoutTransition localLayoutTransition = new LayoutTransition();
      localLayoutTransition.setAnimator(2, null);
      if (Build.VERSION.SDK_INT <= 15)
      {
        localLayoutTransition.setAnimator(0, null);
        localLayoutTransition.setAnimator(1, null);
        localLayoutTransition.setAnimator(3, null);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutTransition(localLayoutTransition);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    while (k < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a((PicInfo)this.jdField_a_of_type_JavaUtilArrayList.get(k), null));
      k += 1;
    }
    k();
  }
  
  void f()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004823", "0X8004823", 0, 0, "", "", "", "");
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOldSaveAction, picInfo size|");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList.size());
      QLog.i("Q.nearby_people_card.", 4, localStringBuilder.toString());
    }
    q();
  }
  
  void g()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.nearby_people_card.", 4, "saveNearbyProfileCard");
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showWaitingDialog(HardCodeUtil.a(2131707363));
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    boolean bool2 = d();
    boolean bool1 = true;
    if (bool2)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 10, 0, "", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 1) {
        k = 1;
      } else {
        k = 3;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
      if ((localObject1 != null) && (((NearbyPeopleCard)localObject1).gender == 0)) {
        localObject1 = "1";
      } else {
        localObject1 = "2";
      }
      ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "upload_video", 0, 0, "", (String)localObject1, "", String.valueOf(k));
    }
    int k = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
    Object localObject2 = NearbyUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(k);
    ((StringBuilder)localObject3).append("");
    ReportController.b((AppRuntime)localObject1, "dc00899", "grp_lbs", "", "data_card", "suc_edit", 0, 0, (String)localObject2, ((StringBuilder)localObject3).toString(), "", "");
    localObject3 = new Bundle();
    ((Bundle)localObject3).putBoolean("key_is_nearby_people_card", true);
    ((Bundle)localObject3).putShort("key_new_profile_modified_flag", (short)1);
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      localObject2 = (byte[])this.jdField_g_of_type_AndroidWidgetEditText.getTag();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[0];
      }
      ((Bundle)localObject3).putByteArray("key_xuan_yan", (byte[])localObject1);
      if (!Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan, (byte[])this.jdField_g_of_type_AndroidWidgetEditText.getTag()))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
        ((NearbyPeopleProfileActivity)localObject1).mLostGodFlag = true;
        ReportController.b(((NearbyPeopleProfileActivity)localObject1).app, "CliOper", "", "", "0X8004820", "0X8004820", 2, 0, "", "", "", "");
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname))
      {
        ((Bundle)localObject3).putString("key_new_nickname", (String)localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
        ((NearbyPeopleProfileActivity)localObject1).mLostGodFlag = true;
        ReportController.b(((NearbyPeopleProfileActivity)localObject1).app, "CliOper", "", "", "0X8004820", "0X8004820", 1, 0, "", "", "", "");
      }
      if ((this.jdField_h_of_type_AndroidWidgetEditText.getTag() != null) && (((Byte)this.jdField_h_of_type_AndroidWidgetEditText.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus))
      {
        ((Bundle)localObject3).putByte("key_marital_status", ((Byte)this.jdField_h_of_type_AndroidWidgetEditText.getTag()).byteValue());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 3, 0, "", "", "", "");
      }
      byte b1 = ((Byte)this.jdField_b_of_type_AndroidWidgetEditText.getTag()).byteValue();
      if (b1 != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender)
      {
        ((Bundle)localObject3).putByte("sex", b1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
        ((NearbyPeopleProfileActivity)localObject1).mLostGodFlag = true;
        ReportController.b(((NearbyPeopleProfileActivity)localObject1).app, "CliOper", "", "", "0X8004820", "0X8004820", 4, 0, "", "", "", "");
      }
      localObject1 = (Object[])this.jdField_c_of_type_AndroidWidgetEditText.getTag();
      k = ((Integer)localObject1[0]).intValue();
      if (k != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday)
      {
        ((Bundle)localObject3).putInt("birthday", k);
        ((Bundle)localObject3).putInt("age", ((Integer)localObject1[1]).intValue());
        ((Bundle)localObject3).putInt("key_constellation", ((Integer)localObject1[2]).intValue());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 5, 0, "", "", "", "");
      }
      k = ((Integer)this.jdField_d_of_type_AndroidWidgetEditText.getTag()).intValue();
      if (k != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job)
      {
        ((Bundle)localObject3).putInt("profession", k);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 6, 0, "", "", "", "");
      }
      localObject1 = this.jdField_e_of_type_AndroidWidgetEditText.getText().toString();
      if (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company))
      {
        ((Bundle)localObject3).putString("company", (String)localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
        ((NearbyPeopleProfileActivity)localObject1).mLostGodFlag = true;
        ReportController.b(((NearbyPeopleProfileActivity)localObject1).app, "CliOper", "", "", "0X8004820", "0X8004820", 7, 0, "", "", "", "");
      }
      localObject1 = this.jdField_f_of_type_AndroidWidgetTextView.getText().toString();
      if (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college))
      {
        ((Bundle)localObject3).putString("college", (String)localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
        ((NearbyPeopleProfileActivity)localObject1).mLostGodFlag = true;
        ReportController.b(((NearbyPeopleProfileActivity)localObject1).app, "CliOper", "", "", "0X8004820", "0X8004820", 8, 0, "", "", "", "");
      }
      localObject1 = (String[])this.jdField_f_of_type_AndroidWidgetEditText.getTag();
      if (!Arrays.equals((Object[])localObject1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCountry, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownProvice, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCity, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownDistrict }))
      {
        ((Bundle)localObject3).putStringArray("hometown", (String[])localObject1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 9, 0, "", "", "", "");
      }
      bool2 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchGiftVisible != 0L) {
        bool1 = false;
      }
      if (bool2 != bool1)
      {
        ((Bundle)localObject3).putShort("key_flower_visible_switch", (short)(bool2 ^ true));
        if (bool2) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80060BB", "0X80060BB", 0, 0, "", "", "", "");
        } else {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80060BC", "0X80060BC", 0, 0, "", "", "", "");
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Q.nearby_people_card..saveNearbyProfileCard, modified_data = ");
        ((StringBuilder)localObject1).append(((Bundle)localObject3).toString());
        QLog.d("Q.nearby_people_card.update_profile", 2, ((StringBuilder)localObject1).toString());
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mCardHandler;
    if (localObject1 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.execute(new NearbyProfileEditPanel.23(this, (INearbyCardHandler)localObject1, (Bundle)localObject3, localArrayList));
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.nearby_people_card.", 4, "NearbyCardHandler is null");
    }
  }
  
  public void h()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, JobSelectionActivity.class);
    EditText localEditText = this.jdField_d_of_type_AndroidWidgetEditText;
    if ((localEditText != null) && (localEditText.getTag() != null) && ((this.jdField_d_of_type_AndroidWidgetEditText.getTag() instanceof Integer))) {
      localIntent.putExtra("param_id", (Integer)this.jdField_d_of_type_AndroidWidgetEditText.getTag());
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(localIntent, 3);
  }
  
  public void i()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, EditActivity.class);
    localIntent.putExtra("param_entry", 1);
    localIntent.putExtra("param_old_xuan_yan", (byte[])this.jdField_g_of_type_AndroidWidgetEditText.getTag());
    localIntent.putExtra("max_word_count", 30);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(localIntent, 1);
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    int k;
    int m;
    if ((paramView.getId() != 2131367603) && (paramView != this.jdField_b_of_type_AndroidWidgetEditText))
    {
      if ((paramView.getId() != 2131369574) && (paramView != this.jdField_d_of_type_AndroidWidgetEditText))
      {
        if (paramView == this.jdField_d_of_type_AndroidWidgetLinearLayout)
        {
          paramView = this.jdField_f_of_type_AndroidWidgetTextView.getText().toString();
          paramView = URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a("https://qun.qq.com/qqweb/m/nearby/pages/school_edit.html", "_bid", "2473"), "_wv", "1031"), "schoolName", paramView), "isValid", String.valueOf(this.j));
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", paramView);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
          return;
        }
        if ((paramView.getId() != 2131368223) && (paramView != this.jdField_f_of_type_AndroidWidgetEditText))
        {
          if ((paramView.getId() != 2131381300) && (paramView != this.jdField_g_of_type_AndroidWidgetEditText))
          {
            if ((paramView.getId() != 2131377855) && (paramView != this.jdField_h_of_type_AndroidWidgetEditText))
            {
              if ((paramView.getId() == 2131362296) || (paramView == this.jdField_c_of_type_AndroidWidgetEditText))
              {
                localObject1 = ActionSheet.createMenuSheet(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
                localObject2 = Calendar.getInstance();
                this.jdField_c_of_type_Int = ((Calendar)localObject2).get(1);
                Object localObject3 = (DispatchActionMoveScrollView)((ActionSheet)localObject1).findViewById(2131361999);
                ((DispatchActionMoveScrollView)localObject3).jdField_a_of_type_Boolean = true;
                ((DispatchActionMoveScrollView)localObject3).setBackgroundResource(17170445);
                localObject3 = (IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity).inflate(2131561132, null);
                ((IphonePickerView)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
                if (this.jdField_c_of_type_AndroidWidgetEditText.getTag() != null)
                {
                  k = ((Integer)((Object[])(Object[])this.jdField_c_of_type_AndroidWidgetEditText.getTag())[0]).intValue();
                  int n;
                  if (k == 0)
                  {
                    k = 94;
                    m = 0;
                    n = 0;
                  }
                  else
                  {
                    n = ((0xFF00 & k) >>> 8) - 1;
                    m = (k & 0xFF) - 1;
                    k = (k >>> 16) - 1896;
                  }
                  ((Calendar)localObject2).setTimeInMillis(System.currentTimeMillis());
                  this.jdField_c_of_type_Int = ((Calendar)localObject2).get(1);
                  this.jdField_d_of_type_Int = (((Calendar)localObject2).get(2) + 1);
                  this.jdField_e_of_type_Int = ((Calendar)localObject2).get(5);
                  ((IphonePickerView)localObject3).setPickListener(new NearbyProfileEditPanel.3(this, (IphonePickerView)localObject3, (ActionSheet)localObject1));
                  ((IphonePickerView)localObject3).setSelection(0, k);
                  ((IphonePickerView)localObject3).setSelection(1, n);
                  ((IphonePickerView)localObject3).setSelection(2, m);
                  ((ActionSheet)localObject1).setOnDismissListener(new NearbyProfileEditPanel.4(this));
                  ((ActionSheet)localObject1).setActionContentView((View)localObject3, null);
                  ((ActionSheet)localObject1).show();
                  a(paramView, ((ActionSheet)localObject1).getActionContentView());
                  a(this.jdField_c_of_type_AndroidWidgetEditText, true);
                }
              }
            }
            else {
              j();
            }
          }
          else {
            i();
          }
        }
        else {
          c();
        }
      }
      else
      {
        h();
      }
    }
    else
    {
      localObject1 = ActionSheet.createMenuSheet(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
      localObject2 = (DispatchActionMoveScrollView)((ActionSheet)localObject1).findViewById(2131361999);
      ((DispatchActionMoveScrollView)localObject2).jdField_a_of_type_Boolean = true;
      ((DispatchActionMoveScrollView)localObject2).setBackgroundResource(17170445);
      localObject2 = (IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity).inflate(2131561132, null);
      ((IphonePickerView)localObject2).a(this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
      if (this.jdField_b_of_type_AndroidWidgetEditText.getTag() != null)
      {
        m = ((Byte)this.jdField_b_of_type_AndroidWidgetEditText.getTag()).byteValue();
        if (m >= 0)
        {
          k = m;
          if (m <= 1) {}
        }
        else
        {
          k = 0;
        }
        ((IphonePickerView)localObject2).setSelection(0, k);
        ((IphonePickerView)localObject2).setPickListener(new NearbyProfileEditPanel.1(this, (IphonePickerView)localObject2, (ActionSheet)localObject1));
        ((ActionSheet)localObject1).setOnDismissListener(new NearbyProfileEditPanel.2(this));
        ((ActionSheet)localObject1).setActionContentView((View)localObject2, null);
        ((ActionSheet)localObject1).show();
        a(paramView, ((ActionSheet)localObject1).getActionContentView());
        a(this.jdField_b_of_type_AndroidWidgetEditText, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel
 * JD-Core Version:    0.7.0.1
 */