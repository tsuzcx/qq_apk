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
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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

public class NearbyProfileEditPanel
  extends NearbyProfileEditBasePanel
  implements View.OnClickListener
{
  public static final int a;
  static final int[] jdField_a_of_type_ArrayOfInt = { 2131377456, 2131377452, 2131377451, 2131377457, 2131377454, 2131377455, 2131377453 };
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new NearbyProfileEditPanel.24(this);
  Button jdField_a_of_type_AndroidWidgetButton;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  HorizontalScrollView jdField_a_of_type_AndroidWidgetHorizontalScrollView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private IphonePickerView.PickerViewAdapter jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new NearbyProfileEditPanel.17(this);
  NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private PicInfo jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo;
  LabelEditCtrl jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelEditCtrl;
  NearbyPeopleProfileActivity jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
  private NearbyProfileEditPanel.OnPicDragListener jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel$OnPicDragListener;
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
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel$OnPicDragListener = new NearbyProfileEditPanel.OnPicDragListener(this, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.f);
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
    localRelativeLayout.setBackgroundResource(2130845178);
    Object localObject = new LinearLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.f, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.f);
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
    if (paramBoolean) {}
    for (int k = 2131167027;; k = 2131167033)
    {
      paramTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColorStateList(k));
      return;
    }
  }
  
  private void a(TextView paramTextView, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    if (paramArrayOfByte != null) {}
    try
    {
      localRichStatus = RichStatus.parseStatus(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject;
      if (localRichStatus != null) {
        paramArrayOfByte = localRichStatus.toSpannableString(null, -8947849, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131165357));
      }
      localObject = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        localObject = new SpannableString("");
      }
      if ((localRichStatus != null) && (!TextUtils.isEmpty(localRichStatus.actionText)))
      {
        localObject = new SpannableStringBuilder((CharSequence)localObject);
        ((SpannableStringBuilder)localObject).insert(0, "[S] ");
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null)
        {
          paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(localRichStatus.actionId, 200);
          paramArrayOfByte = new StatableBitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), paramArrayOfByte, false, false);
          int k = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
          paramArrayOfByte.setBounds(0, 0, k, k);
          paramArrayOfByte = new OffsetableImageSpan(paramArrayOfByte, 0);
          paramArrayOfByte.setOffset(-0.1F);
          ((SpannableStringBuilder)localObject).setSpan(paramArrayOfByte, 0, "[S]".length(), 17);
          paramTextView.setText((CharSequence)localObject);
          return;
        }
      }
    }
    catch (RuntimeException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        QLog.e("NearbyProfileEditPanel", 1, "RichStatus parseStatus error: " + paramArrayOfByte);
        RichStatus localRichStatus = null;
        continue;
        paramArrayOfByte = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), 2130849983);
      }
      paramTextView.setText((CharSequence)localObject);
    }
  }
  
  private void a(PicInfo paramPicInfo, View paramView)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramPicInfo);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.remove(paramPicInfo);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(paramView);
      k();
      m();
      return;
    }
    paramPicInfo = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, HardCodeUtil.a(2131707343), 0, 0, null, null);
    paramPicInfo.setPositiveButton(2131694615, new NearbyProfileEditPanel.9(this, paramPicInfo));
    paramPicInfo.show();
  }
  
  private void a(CustomImgView paramCustomImgView, PicInfo paramPicInfo, Drawable paramDrawable)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      QLog.d("Q.nearby_people_card.", 2, "setDrawable, pos:" + this.jdField_a_of_type_AndroidWidgetLinearLayout.indexOfChild(paramCustomImgView) + ",picInfo:" + paramPicInfo);
    }
    paramCustomImgView.setTag(paramPicInfo);
    Object localObject = paramDrawable;
    if (paramDrawable == null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130845993);
    }
    try
    {
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.f;
      localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.f;
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
      if (TextUtils.isEmpty(paramPicInfo.b)) {
        break label258;
      }
      paramDrawable = paramPicInfo.b;
    }
    catch (MalformedURLException paramCustomImgView)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions;
      while (QLog.isColorLevel())
      {
        paramPicInfo = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
        QLog.d("Q.nearby_people_card.", 2, "GridAdapter.getView() new URL(). " + paramCustomImgView.getMessage(), paramCustomImgView);
        return;
        if (!TextUtils.isEmpty(paramPicInfo.jdField_a_of_type_JavaLangString)) {
          paramDrawable = paramPicInfo.jdField_a_of_type_JavaLangString;
        }
      }
    }
    if (!TextUtils.isEmpty(paramDrawable))
    {
      paramCustomImgView.setImageDrawable(URLDrawable.getDrawable(NearbyImgDownloader.convertURL(paramDrawable), localURLDrawableOptions));
      return;
    }
    label258:
  }
  
  private View b()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    localRelativeLayout.setBackgroundResource(2130841535);
    Object localObject = new RelativeLayout.LayoutParams(UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 35.0F), UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 16.0F));
    int k = UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 5.0F);
    ((RelativeLayout.LayoutParams)localObject).setMargins(k, 0, 0, k);
    ((RelativeLayout.LayoutParams)localObject).addRule(9);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new TextView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    ((TextView)localObject).setText(HardCodeUtil.a(2131707362));
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
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(HardCodeUtil.a(2131707281));
        return false;
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(HardCodeUtil.a(2131707294));
      return false;
    }
    return true;
  }
  
  private void j()
  {
    ActionSheet localActionSheet = ActionSheet.createMenuSheet(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    Object localObject = (DispatchActionMoveScrollView)localActionSheet.findViewById(2131361983);
    ((DispatchActionMoveScrollView)localObject).jdField_a_of_type_Boolean = true;
    ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
    localObject = (IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity).inflate(2131561289, null);
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
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFinishing()) {}
    }
    else
    {
      return;
    }
    localActionSheet.show();
    a(this.jdField_e_of_type_AndroidWidgetLinearLayout, localActionSheet.getActionContentView());
    a(this.jdField_h_of_type_AndroidWidgetEditText, true);
  }
  
  private void k()
  {
    l();
    int k = 0;
    if (k < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      Object localObject;
      if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(k) instanceof RelativeLayout))
      {
        localObject = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(k);
        ((RelativeLayout)localObject).setOnClickListener(a(k));
        if (((RelativeLayout)localObject).getChildCount() == 2) {
          if (k == 0)
          {
            ((RelativeLayout)localObject).getChildAt(1).setVisibility(0);
            label73:
            if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(k) != null) {
              this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(k).setContentDescription(HardCodeUtil.a(2131707272) + (k + 1));
            }
          }
        }
      }
      for (;;)
      {
        k += 1;
        break;
        ((RelativeLayout)localObject).getChildAt(1).setVisibility(8);
        break label73;
        if (QLog.isColorLevel())
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
          QLog.e("Q.nearby_people_card.", 2, "updatePhotoStatus, headItem's child count is not 2");
          continue;
          if (QLog.isColorLevel())
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
            QLog.e("Q.nearby_people_card.", 2, "updatePhotoStatus, the child of mEditLayout is not a instance of RelativeLayout");
          }
        }
      }
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaUtilArrayList.size() + "/" + NearbyPeopleProfileActivity.jdField_c_of_type_Int);
      return;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
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
      NearbyPeopleProfileActivity localNearbyPeopleProfileActivity = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      QLog.d("Q.nearby_people_card.", 2, "reorganizePicInfo:" + this.jdField_a_of_type_JavaUtilArrayList);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694451, new Object[] { this.jdField_a_of_type_JavaLangString });
      localObject = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, (String)localObject, 0, 0, null, null);
      ((QQCustomDialog)localObject).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694731), new NearbyProfileEditPanel.8(this, (QQCustomDialog)localObject));
      ((QQCustomDialog)localObject).show();
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) && (QLog.isColorLevel())) {
        QLog.d("NearbyProfileEditPanel", 2, "mcard is null");
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.h();
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707301));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707262));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 10.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131369487).setVisibility(8);
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369489);
    localTextView.setVisibility(0);
    localTextView.setText(2131690800);
    localTextView.setOnClickListener(new NearbyProfileEditPanel.19(this));
    localTextView = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369518);
    localTextView.setVisibility(0);
    localTextView.setText(2131692534);
    localTextView.setEnabled(true);
    localTextView.setOnClickListener(new NearbyProfileEditPanel.20(this));
    this.jdField_b_of_type_AndroidViewView.findViewById(2131377159).setOnClickListener(this);
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      Object localObject = new StringBuilder(HardCodeUtil.a(2131707290));
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int - this.jdField_a_of_type_JavaUtilLinkedList.size() + 1).append("/").append(this.jdField_b_of_type_Int).append(")...");
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(((StringBuilder)localObject).toString());
      localObject = new NearbyProfileEditPanel.22(this);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.execute((Runnable)localObject);
      return;
    }
    g();
  }
  
  protected int a()
  {
    return 2131561374;
  }
  
  Intent a(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, PhotoCropActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    paramString = AppConstants.SDCARD_PATH + "nearby_people_photo/";
    localIntent.putExtra("PhotoConst.TARGET_PATH", paramString + System.currentTimeMillis() + ".jpg");
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", 640);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.QZONE_COVER_CROP_LEFT_TITLE", HardCodeUtil.a(2131707295));
    localIntent.putExtra("FROM_WHERE", "FROM_NEARBY_PROFILE");
    return localIntent;
  }
  
  public void a()
  {
    ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getRuntimeService(ITransFileController.class)).removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  public void a(int paramInt)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", NearbyPeopleProfileActivity.jdField_c_of_type_Int - paramInt);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    String str = AppConstants.SDCARD_PATH + "nearby_people_photo/";
    localIntent.putExtra("PhotoConst.TARGET_PATH", str + System.currentTimeMillis() + ".jpg");
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", 640);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
    localIntent.putExtra("enter_from", 30);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(localIntent);
    AlbumUtil.anim(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, false, true);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800481F", "0X800481F", 1, 0, "", "", "", "");
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int m = this.jdField_c_of_type_Int - (paramInt1 + 1896);
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(1, paramInt2 + 1, paramInt3 + 1);
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).set(1, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
    int k = m;
    if (((Calendar)localObject1).after(localObject2)) {
      k = m - 1;
    }
    m = k;
    if (k < 0) {
      m = 0;
    }
    paramInt1 += 1896;
    k = paramInt2 + 1;
    int n = paramInt3 + 1;
    localObject1 = Utils.a(paramInt2 + 1, paramInt3 + 1);
    paramInt2 = AgeSelectionActivity.a((String)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramInt1).append("-").append(k).append("-").append(n).append(" ").append("(").append(m).append("岁").append(" ").append((String)localObject1).append(")");
    this.jdField_c_of_type_AndroidWidgetEditText.setText(((StringBuilder)localObject2).toString());
    this.jdField_c_of_type_AndroidWidgetEditText.setTag(new Object[] { Integer.valueOf(paramInt1 << 16 | k << 8 | n), Integer.valueOf(m), Integer.valueOf(paramInt2) });
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int k = 0;
    switch (paramInt1)
    {
    }
    label406:
    label413:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if ((paramInt2 == -1) && (paramIntent != null))
          {
            paramIntent = paramIntent.getByteArrayExtra("param_new_xuan_yan");
            if (this.jdField_g_of_type_AndroidWidgetEditText != null)
            {
              a(this.jdField_g_of_type_AndroidWidgetEditText, paramIntent);
              this.jdField_g_of_type_AndroidWidgetEditText.setTag(paramIntent);
              return;
              if ((paramInt2 == -1) && (paramIntent != null))
              {
                Object localObject1 = paramIntent.getStringExtra("key_cover_selected_img_path");
                this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("key_album_id");
                if (!StringUtil.a((String)localObject1))
                {
                  paramInt1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int;
                  paramIntent = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
                  if ((paramInt1 == 1) && (this.jdField_a_of_type_JavaUtilArrayList.size() < NearbyPeopleProfileActivity.jdField_c_of_type_Int))
                  {
                    paramIntent = a((String)localObject1);
                    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramIntent);
                    return;
                    if (paramIntent != null)
                    {
                      paramIntent = paramIntent.getExtras();
                      paramIntent.getString("video_id");
                      paramIntent.getInt("head_id");
                      return;
                      if ((paramInt2 == -1) && (paramIntent != null))
                      {
                        Object localObject2;
                        for (;;)
                        {
                          try
                          {
                            localObject2 = paramIntent.getParcelableArrayListExtra("choosed_interest_tags");
                            paramInt2 = paramIntent.getIntExtra("interest_tag_type", -1);
                            paramInt1 = k;
                            if (paramInt1 < this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag.length)
                            {
                              if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[paramInt1].jdField_a_of_type_Int != paramInt2) {
                                break label406;
                              }
                              paramIntent = this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[paramInt1];
                              paramIntent.jdField_a_of_type_JavaUtilArrayList.clear();
                              if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
                                paramIntent.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject2);
                              }
                            }
                            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelEditCtrl.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag);
                            if (!QLog.isDevelopLevel()) {
                              break;
                            }
                            localObject1 = new StringBuilder().append("doOnActivity result code :11 ");
                            if (localObject2 != null) {
                              break label413;
                            }
                            paramIntent = "";
                            QLog.i("Q.nearby_people_card.", 4, paramIntent + " " + paramInt2);
                            return;
                          }
                          catch (Exception paramIntent) {}
                          if (!QLog.isColorLevel()) {
                            break;
                          }
                          QLog.i("Q.nearby_people_card.", 2, paramIntent.getMessage());
                          return;
                          paramInt1 += 1;
                          continue;
                          paramIntent = localObject2.toString();
                        }
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
                          for (;;)
                          {
                            this.jdField_d_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
                            this.jdField_d_of_type_AndroidWidgetEditText.setTag(Integer.valueOf(paramInt1));
                            return;
                            this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
                          }
                          if (paramInt2 == -1)
                          {
                            localObject2 = paramIntent.getStringArrayExtra("param_location");
                            try
                            {
                              paramIntent = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a((String[])localObject2);
                              if (paramIntent != null)
                              {
                                localObject1 = paramIntent;
                                if (!paramIntent.equals("不限")) {}
                              }
                              else
                              {
                                localObject1 = "";
                              }
                              if (this.jdField_f_of_type_AndroidWidgetEditText != null)
                              {
                                this.jdField_f_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
                                this.jdField_f_of_type_AndroidWidgetEditText.setTag(localObject2);
                                return;
                              }
                            }
                            catch (Exception paramIntent)
                            {
                              for (;;)
                              {
                                paramIntent = null;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      } while (paramInt2 != -1);
      paramIntent = paramIntent.getParcelableArrayListExtra("intent_param_pic_infos");
    } while ((paramIntent == null) || (paramIntent.size() == 0));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    paramInt1 = 0;
    while (paramInt1 < paramIntent.size())
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a((PicInfo)paramIntent.get(paramInt1), null));
      paramInt1 += 1;
    }
    k();
  }
  
  protected void a(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView;
    paramView.findViewById(2131379487).setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379532));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379462));
    paramView.findViewById(2131369534).setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366166));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167093));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)paramView.findViewById(2131366167));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366147));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams().height = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.f;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams());
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372991));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378644));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131366164));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366165));
    this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131378441));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131372288));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131367833));
    this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131362333));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364464));
    this.jdField_d_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131369888));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369889));
    this.jdField_e_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131365159));
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131364924));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364923));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364486));
    this.jdField_f_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131368474));
    this.jdField_g_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131382097));
    this.jdField_h_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131378436));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131367259));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377450));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)paramView.findViewById(2131379533));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366171));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.mScrollFlag = 1;
    paramView = (LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131370030);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelEditCtrl = new LabelEditCtrl();
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelEditCtrl.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, paramView);
    p();
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    Object localObject;
    int k;
    label268:
    label295:
    label587:
    label733:
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      if ("EditPanel bindData, isEditing = " + this.jdField_a_of_type_Boolean + ", mActivity.mPicInfo.size = " + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList == null)
      {
        localObject = "null";
        QLog.d("Q.nearby_people_card.", 2, new Object[] { localObject });
      }
    }
    else
    {
      k = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_edit", 0, 0, NearbyUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_j_of_type_Int), k + "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        this.jdField_b_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.h)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_b_of_type_JavaUtilArrayList.clear();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
        break label1197;
      }
      this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131707291);
      if (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) {
        break label1221;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694442));
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(HardCodeUtil.a(2131707255));
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
      ((StringBuilder)localObject).append(m >> 16).append("-").append(i1).append("-").append(i2).append(" ").append("(").append(k).append("岁").append(" ").append(paramNearbyPeopleCard).append(")");
      this.jdField_c_of_type_AndroidWidgetEditText.setText(((StringBuilder)localObject).toString());
      this.jdField_c_of_type_AndroidWidgetEditText.setTag(new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(n) });
      k = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job;
      this.jdField_e_of_type_AndroidWidgetTextView.setText(NearbyProfileUtil.d(k));
      if (!StringUtil.a(NearbyProfileUtil.d(k))) {
        break label1265;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetEditText.setText(NearbyProfileUtil.e(k));
      this.jdField_d_of_type_AndroidWidgetEditText.setTag(Integer.valueOf(k));
      this.jdField_e_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company);
      this.jdField_e_of_type_AndroidWidgetEditText.clearFocus();
      paramNearbyPeopleCard = (String)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "school_name", "");
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college);
        if (!TextUtils.equals(paramNearbyPeopleCard, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college)) {
          break label1299;
        }
        this.jdField_j_of_type_Int = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "school_valid_state", Integer.valueOf(0))).intValue();
        if (this.jdField_j_of_type_Int != 2) {
          break label1287;
        }
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      d();
      a(this.jdField_g_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
      this.jdField_g_of_type_AndroidWidgetEditText.setTag(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
      this.jdField_h_of_type_AndroidWidgetEditText.setText(NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus - 1));
      this.jdField_h_of_type_AndroidWidgetEditText.setTag(Byte.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus));
      if (NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vGiftInfo) == 0) {
        break label1428;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchGiftVisible != 0L) {
        break label1422;
      }
      bool = true;
      label846:
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag)
      {
        paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694452, new Object[] { this.jdField_a_of_type_JavaLangString });
        paramNearbyPeopleCard = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, paramNearbyPeopleCard, 0, 0, null, null);
        paramNearbyPeopleCard.setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694731), new NearbyProfileEditPanel.11(this, paramNearbyPeopleCard));
        paramNearbyPeopleCard.show();
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardLabelEditCtrl.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag);
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_j_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.k == 1)) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler.postDelayed(new NearbyProfileEditPanel.12(this), 300L);
      }
      this.jdField_b_of_type_AndroidViewView.findViewById(2131382098).setOnClickListener(this);
      this.jdField_g_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131378441).setOnClickListener(this);
      this.jdField_h_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131367836).setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131362335).setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131369889).setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131368475).setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new NearbyProfileEditPanel.13(this));
      this.jdField_g_of_type_AndroidWidgetEditText.addTextChangedListener(new NearbyProfileEditPanel.14(this));
      this.jdField_e_of_type_AndroidWidgetEditText.addTextChangedListener(new NearbyProfileEditPanel.15(this));
      this.jdField_a_of_type_AndroidWidgetEditText.getViewTreeObserver().addOnGlobalLayoutListener(new NearbyProfileEditPanel.16(this));
      return;
      localObject = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size());
      break;
      label1197:
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
        break label268;
      }
      this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131707346);
      break label268;
      label1221:
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= NearbyPeopleProfileActivity.jdField_b_of_type_Int) {
        break label295;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694443, new Object[] { this.jdField_a_of_type_JavaLangString }));
      break label295;
      label1265:
      this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(NearbyProfileUtil.b(k));
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      break label587;
      label1287:
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      break label733;
      label1299:
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.collegeId == 0L) {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college))
        {
          this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_j_of_type_Int = 1;
        }
      }
      for (;;)
      {
        NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "school_name", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college);
        NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "school_valid_state", Integer.valueOf(this.jdField_j_of_type_Int));
        break;
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_j_of_type_Int = 2;
        continue;
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_j_of_type_Int = 1;
      }
      label1422:
      bool = false;
      break label846;
      label1428:
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    int m = 1;
    int k = 1;
    this.jdField_b_of_type_Boolean = true;
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_j_of_type_Int = 1;
      this.jdField_f_of_type_AndroidWidgetTextView.setText("");
      paramInt = 0;
      if (paramInt != 0)
      {
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8006784", "0X8006784", 0, 0, "", "", "", "");
      }
    }
    else
    {
      if (paramInt == 0)
      {
        if (TextUtils.equals(this.jdField_f_of_type_AndroidWidgetTextView.getText().toString(), paramString)) {
          if (this.jdField_j_of_type_Int == 2) {
            paramInt = k;
          }
        }
        for (;;)
        {
          this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString);
          break;
          paramInt = 0;
          continue;
          this.jdField_j_of_type_Int = paramInt;
          paramInt = 0;
        }
      }
      if (paramInt == 2) {}
      for (k = m;; k = 0)
      {
        this.jdField_j_of_type_Int = paramInt;
        paramInt = k;
        break;
      }
    }
    this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_c_of_type_Boolean) {
      return true;
    }
    if (d()) {
      return true;
    }
    int k;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      if (!Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan, (byte[])this.jdField_g_of_type_AndroidWidgetEditText.getTag())) {
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
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchGiftVisible == 0L) {}
      for (boolean bool1 = true; bool2 != bool1; bool1 = false) {
        return true;
      }
      Object localObject2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag;
      int n = localObject2.length;
      m = 0;
      k = 0;
      if (m >= n) {
        break label561;
      }
      StringBuilder localStringBuilder = localObject2[m];
      if (localStringBuilder == null) {}
      do
      {
        m += 1;
        break;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getTagInfos(localStringBuilder.jdField_a_of_type_Int);
      } while ((localObject1 == null) && (localStringBuilder.jdField_a_of_type_JavaUtilArrayList.size() == 0));
      if (!localStringBuilder.equals(localObject1))
      {
        k = 1;
        label440:
        if (k == 0) {
          break label558;
        }
        m = k;
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          localStringBuilder = ((StringBuilder)localObject2).append("tagChanged \n").append("item: ").append(localStringBuilder.toString()).append("\n").append("tag: ");
          if (localObject1 != null) {
            break label546;
          }
          localObject1 = "null";
          label507:
          localStringBuilder.append((String)localObject1).append("\n");
          QLog.i("InterestTag", 4, ((StringBuilder)localObject2).toString());
        }
      }
    }
    label546:
    label558:
    label561:
    for (int m = k;; m = k)
    {
      if (m != 0)
      {
        return true;
        k = 0;
        break label440;
        localObject1 = ((InterestTag)localObject1).toString();
        break label507;
      }
      return false;
      break;
    }
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
    if ((m >= 1) && (k >= 1)) {
      return ((PicInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int != ((PicInfo)this.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int;
    }
    return false;
  }
  
  public void c()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, LocationSelectActivity.class);
    localIntent.putExtra("param_req_type", 3);
    ConditionSearchManager localConditionSearchManager = (ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
    int k = localConditionSearchManager.a();
    Object localObject1;
    if (k != 0)
    {
      k = localConditionSearchManager.a(k, true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.", 2, "startLocationSelectActivity | update result = " + k);
      }
      if (k == 2)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2131694459, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
        return;
      }
      if (k == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131691140));
        localConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131691140));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      ((Handler)localObject1).sendEmptyMessageDelayed(206, 20000L);
      return;
    }
    Object localObject2 = (String[])this.jdField_f_of_type_AndroidWidgetEditText.getTag();
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length == 4) {}
    }
    else
    {
      localObject1 = new String[4];
      localObject1[0] = "0";
      localObject1[1] = "0";
      localObject1[2] = "0";
      localObject1[3] = "0";
    }
    localIntent.putExtra("param_location", (String[])localObject1);
    localIntent.putExtra("param_is_popup", false);
    localIntent.putExtra("param_location_param", localConditionSearchManager.b((String[])localObject1));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(localIntent, 4);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_c_of_type_Boolean) {
      return true;
    }
    if (d()) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      if (!Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan, (byte[])this.jdField_g_of_type_AndroidWidgetEditText.getTag())) {
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
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) {}
    String[] arrayOfString;
    String str;
    do
    {
      return;
      arrayOfString = new String[4];
      arrayOfString[0] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCountry;
      arrayOfString[1] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownProvice;
      arrayOfString[2] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCity;
      arrayOfString[3] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownDistrict;
      str = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(arrayOfString);
    } while (this.jdField_f_of_type_AndroidWidgetEditText == null);
    if (!"不限".equals(str)) {
      this.jdField_f_of_type_AndroidWidgetEditText.setText(str);
    }
    this.jdField_f_of_type_AndroidWidgetEditText.setTag(arrayOfString);
  }
  
  @TargetApi(11)
  void e()
  {
    int k = 0;
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
    } while (this.jdField_a_of_type_JavaUtilArrayList.size() == 0);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.oldPhotoCount > 0) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age >= 14) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age <= 24) && (this.jdField_a_of_type_JavaUtilArrayList.size() <= 1)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800481B", "0X800481B", 0, 0, "", "", "", "");
    }
    if (Build.VERSION.SDK_INT >= 11)
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
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.nearby_people_card.", 4, "doOldSaveAction, picInfo size|" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    q();
  }
  
  void g()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.nearby_people_card.", 4, "saveNearbyProfileCard");
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(HardCodeUtil.a(2131707338));
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    if (d())
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 10, 0, "", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 1) {
        break label1305;
      }
    }
    label1158:
    label1288:
    label1305:
    for (int k = 1;; k = 3)
    {
      Object localObject;
      boolean bool1;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0))
      {
        localObject = "1";
        ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "upload_video", 0, 0, "", (String)localObject, "", String.valueOf(k));
        k = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "suc_edit", 0, 0, NearbyUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_j_of_type_Int), k + "", "", "");
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("key_is_nearby_people_card", true);
        localBundle.putShort("key_new_profile_modified_flag", (short)1);
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
        {
          byte[] arrayOfByte = (byte[])this.jdField_g_of_type_AndroidWidgetEditText.getTag();
          localObject = arrayOfByte;
          if (arrayOfByte == null) {
            localObject = new byte[0];
          }
          localBundle.putByteArray("key_xuan_yan", (byte[])localObject);
          if (!Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan, (byte[])this.jdField_g_of_type_AndroidWidgetEditText.getTag()))
          {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_d_of_type_Boolean = true;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 2, 0, "", "", "", "");
          }
          localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
          if (!((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname))
          {
            localBundle.putString("key_new_nickname", (String)localObject);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_d_of_type_Boolean = true;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 1, 0, "", "", "", "");
          }
          if ((this.jdField_h_of_type_AndroidWidgetEditText.getTag() != null) && (((Byte)this.jdField_h_of_type_AndroidWidgetEditText.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus))
          {
            localBundle.putByte("key_marital_status", ((Byte)this.jdField_h_of_type_AndroidWidgetEditText.getTag()).byteValue());
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 3, 0, "", "", "", "");
          }
          byte b1 = ((Byte)this.jdField_b_of_type_AndroidWidgetEditText.getTag()).byteValue();
          if (b1 != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender)
          {
            localBundle.putByte("sex", b1);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_d_of_type_Boolean = true;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 4, 0, "", "", "", "");
          }
          localObject = (Object[])this.jdField_c_of_type_AndroidWidgetEditText.getTag();
          k = ((Integer)localObject[0]).intValue();
          if (k != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday)
          {
            localBundle.putInt("birthday", k);
            localBundle.putInt("age", ((Integer)localObject[1]).intValue());
            localBundle.putInt("key_constellation", ((Integer)localObject[2]).intValue());
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 5, 0, "", "", "", "");
          }
          k = ((Integer)this.jdField_d_of_type_AndroidWidgetEditText.getTag()).intValue();
          if (k != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job)
          {
            localBundle.putInt("profession", k);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 6, 0, "", "", "", "");
          }
          localObject = this.jdField_e_of_type_AndroidWidgetEditText.getText().toString();
          if (!((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company))
          {
            localBundle.putString("company", (String)localObject);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_d_of_type_Boolean = true;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 7, 0, "", "", "", "");
          }
          localObject = this.jdField_f_of_type_AndroidWidgetTextView.getText().toString();
          if (!((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college))
          {
            localBundle.putString("college", (String)localObject);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_d_of_type_Boolean = true;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 8, 0, "", "", "", "");
          }
          localObject = (String[])this.jdField_f_of_type_AndroidWidgetEditText.getTag();
          if (!Arrays.equals((Object[])localObject, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCountry, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownProvice, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCity, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownDistrict }))
          {
            localBundle.putStringArray("hometown", (String[])localObject);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 9, 0, "", "", "", "");
          }
          boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchGiftVisible != 0L) {
            break label1242;
          }
          bool1 = true;
          label1097:
          if (bool2 != bool1)
          {
            if (!bool2) {
              break label1247;
            }
            k = 0;
            label1110:
            localBundle.putShort("key_flower_visible_switch", (short)k);
            if (!bool2) {
              break label1252;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80060BB", "0X80060BB", 0, 0, "", "", "", "");
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.nearby_people_card.update_profile", 2, "Q.nearby_people_card..saveNearbyProfileCard, modified_data = " + localBundle.toString());
          }
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler;
        if (localObject == null) {
          break label1288;
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.execute(new NearbyProfileEditPanel.23(this, (NearbyCardHandler)localObject, localBundle, localArrayList));
      }
      label1242:
      label1247:
      label1252:
      while (!QLog.isDevelopLevel())
      {
        return;
        localObject = "2";
        break;
        bool1 = false;
        break label1097;
        k = 1;
        break label1110;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80060BC", "0X80060BC", 0, 0, "", "", "", "");
        break label1158;
      }
      QLog.i("Q.nearby_people_card.", 4, "NearbyCardHandler is null");
      return;
    }
  }
  
  public void h()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, JobSelectionActivity.class);
    if ((this.jdField_d_of_type_AndroidWidgetEditText != null) && (this.jdField_d_of_type_AndroidWidgetEditText.getTag() != null) && ((this.jdField_d_of_type_AndroidWidgetEditText.getTag() instanceof Integer))) {
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
    int m;
    if ((paramView.getId() == 2131367836) || (paramView == this.jdField_b_of_type_AndroidWidgetEditText))
    {
      localObject1 = ActionSheet.createMenuSheet(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
      localObject2 = (DispatchActionMoveScrollView)((ActionSheet)localObject1).findViewById(2131361983);
      ((DispatchActionMoveScrollView)localObject2).jdField_a_of_type_Boolean = true;
      ((DispatchActionMoveScrollView)localObject2).setBackgroundResource(17170445);
      localObject2 = (IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity).inflate(2131561289, null);
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
    Object localObject3;
    do
    {
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if ((paramView.getId() == 2131369889) || (paramView == this.jdField_d_of_type_AndroidWidgetEditText))
          {
            h();
          }
          else if (paramView == this.jdField_d_of_type_AndroidWidgetLinearLayout)
          {
            localObject1 = this.jdField_f_of_type_AndroidWidgetTextView.getText().toString();
            localObject1 = URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a("https://qun.qq.com/qqweb/m/nearby/pages/school_edit.html", "_bid", "2473"), "_wv", "1031"), "schoolName", (String)localObject1), "isValid", String.valueOf(this.jdField_j_of_type_Int));
            localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
          }
          else if ((paramView.getId() == 2131368475) || (paramView == this.jdField_f_of_type_AndroidWidgetEditText))
          {
            c();
          }
          else if ((paramView.getId() == 2131382098) || (paramView == this.jdField_g_of_type_AndroidWidgetEditText))
          {
            i();
          }
          else
          {
            if ((paramView.getId() != 2131378441) && (paramView != this.jdField_h_of_type_AndroidWidgetEditText)) {
              break;
            }
            j();
          }
        }
      } while ((paramView.getId() != 2131362335) && (paramView != this.jdField_c_of_type_AndroidWidgetEditText));
      localObject1 = ActionSheet.createMenuSheet(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
      localObject2 = Calendar.getInstance();
      this.jdField_c_of_type_Int = ((Calendar)localObject2).get(1);
      localObject3 = (DispatchActionMoveScrollView)((ActionSheet)localObject1).findViewById(2131361983);
      ((DispatchActionMoveScrollView)localObject3).jdField_a_of_type_Boolean = true;
      ((DispatchActionMoveScrollView)localObject3).setBackgroundResource(17170445);
      localObject3 = (IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity).inflate(2131561289, null);
      ((IphonePickerView)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
    } while (this.jdField_c_of_type_AndroidWidgetEditText.getTag() == null);
    int k = ((Integer)((Object[])(Object[])this.jdField_c_of_type_AndroidWidgetEditText.getTag())[0]).intValue();
    int n;
    if (k == 0)
    {
      m = 0;
      n = 94;
    }
    for (k = 0;; k = (k & 0xFF) - 1)
    {
      ((Calendar)localObject2).setTimeInMillis(System.currentTimeMillis());
      this.jdField_c_of_type_Int = ((Calendar)localObject2).get(1);
      this.jdField_d_of_type_Int = (((Calendar)localObject2).get(2) + 1);
      this.jdField_e_of_type_Int = ((Calendar)localObject2).get(5);
      ((IphonePickerView)localObject3).setPickListener(new NearbyProfileEditPanel.3(this, (IphonePickerView)localObject3, (ActionSheet)localObject1));
      ((IphonePickerView)localObject3).setSelection(0, n);
      ((IphonePickerView)localObject3).setSelection(1, m);
      ((IphonePickerView)localObject3).setSelection(2, k);
      ((ActionSheet)localObject1).setOnDismissListener(new NearbyProfileEditPanel.4(this));
      ((ActionSheet)localObject1).setActionContentView((View)localObject3, null);
      ((ActionSheet)localObject1).show();
      a(paramView, ((ActionSheet)localObject1).getActionContentView());
      a(this.jdField_c_of_type_AndroidWidgetEditText, true);
      break;
      n = (k >>> 16) - 1896;
      m = ((0xFF00 & k) >>> 8) - 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel
 * JD-Core Version:    0.7.0.1
 */