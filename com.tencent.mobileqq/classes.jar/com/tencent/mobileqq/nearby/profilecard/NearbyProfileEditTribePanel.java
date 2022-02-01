package com.tencent.mobileqq.nearby.profilecard;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.AgeSelectionActivity;
import com.tencent.mobileqq.activity.JobSelectionActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.api.INearbyVideoUtils;
import com.tencent.mobileqq.nearby.business.INearbyCardHandler;
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
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.CustomImgView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AppRuntime;

public class NearbyProfileEditTribePanel
  extends NearbyProfileEditBasePanel
  implements View.OnClickListener
{
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "0X800554B", "0X800554C", "0X800554D", "0X800554E", "0X800554F", "0X8005550", "0X8005551" };
  int jdField_a_of_type_Int;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new NearbyProfileEditTribePanel.18(this);
  EditText jdField_a_of_type_AndroidWidgetEditText;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private IphonePickerView.PickerViewAdapter jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new NearbyProfileEditTribePanel.12(this);
  NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  NearbyPeopleProfileActivity jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
  private NearbyProfileEditTribePanel.OnPicDragListener jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel$OnPicDragListener;
  private PicInfo jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new NearbyProfileEditTribePanel.15(this);
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  String jdField_a_of_type_JavaLangString = "";
  final ArrayList<PicInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList(13);
  LinkedList<PicInfo> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  int jdField_b_of_type_Int = 2015;
  View jdField_b_of_type_AndroidViewView;
  EditText jdField_b_of_type_AndroidWidgetEditText;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  private IphonePickerView.PickerViewAdapter jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new NearbyProfileEditTribePanel.19(this);
  final ArrayList<PicInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList(13);
  private boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  EditText jdField_c_of_type_AndroidWidgetEditText;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  int jdField_d_of_type_Int;
  EditText jdField_d_of_type_AndroidWidgetEditText;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  int jdField_e_of_type_Int;
  EditText jdField_e_of_type_AndroidWidgetEditText;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  int jdField_f_of_type_Int;
  EditText jdField_f_of_type_AndroidWidgetEditText;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  int jdField_g_of_type_Int;
  TextView jdField_g_of_type_AndroidWidgetTextView;
  int jdField_h_of_type_Int;
  TextView jdField_h_of_type_AndroidWidgetTextView;
  private int jdField_i_of_type_Int;
  TextView jdField_i_of_type_AndroidWidgetTextView;
  
  public NearbyProfileEditTribePanel(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    super(paramNearbyPeopleProfileActivity);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity = paramNearbyPeopleProfileActivity;
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel$OnPicDragListener = new NearbyProfileEditTribePanel.OnPicDragListener(this, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth);
    }
    this.jdField_h_of_type_Int = UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2.0F);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getRuntimeService(ITransFileController.class)).addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  @TargetApi(11)
  private RelativeLayout a(PicInfo paramPicInfo, Drawable paramDrawable)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    localRelativeLayout.setBackgroundResource(2130845055);
    Object localObject = new LinearLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth);
    ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, this.jdField_h_of_type_Int, 0);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new CustomImgView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    ((CustomImgView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    a(this.jdField_b_of_type_ComTencentImageURLImageView, paramPicInfo, paramDrawable);
    if (Build.VERSION.SDK_INT >= 11)
    {
      localRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      localRelativeLayout.setOnDragListener(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel$OnPicDragListener);
    }
    localRelativeLayout.addView((View)localObject);
    localRelativeLayout.addView(b());
    localRelativeLayout.setTag(paramPicInfo);
    return localRelativeLayout;
  }
  
  private String a()
  {
    ArrayList localArrayList = new ArrayList(5);
    if (d()) {
      localArrayList.add(Integer.valueOf(1));
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
    int j = 0;
    if (localObject != null)
    {
      if (!Utils.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname)) {
        localArrayList.add(Integer.valueOf(2));
      }
      if (((Byte)this.jdField_b_of_type_AndroidWidgetEditText.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender) {
        localArrayList.add(Integer.valueOf(3));
      }
      if (((Integer)((Object[])(Object[])this.jdField_c_of_type_AndroidWidgetEditText.getTag())[0]).intValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday) {
        localArrayList.add(Integer.valueOf(4));
      }
      if (!Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan, (byte[])this.jdField_f_of_type_AndroidWidgetEditText.getTag())) {
        localArrayList.add(Integer.valueOf(5));
      }
    }
    localObject = new StringBuilder();
    if (localArrayList.size() > 0) {
      while (j < localArrayList.size())
      {
        if (j != localArrayList.size() - 1)
        {
          ((StringBuilder)localObject).append(localArrayList.get(j));
          ((StringBuilder)localObject).append("::");
        }
        else
        {
          ((StringBuilder)localObject).append(localArrayList.get(j));
        }
        j += 1;
      }
    }
    return ((StringBuilder)localObject).toString();
  }
  
  private void a(View paramView1, View paramView2)
  {
    paramView2.postDelayed(new NearbyProfileEditTribePanel.20(this, paramView2, paramView1), 300L);
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    int j;
    if (paramBoolean) {
      j = 2131167050;
    } else {
      j = 2131167056;
    }
    paramTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColorStateList(j));
  }
  
  private void a(TextView paramTextView, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      RichStatus localRichStatus = RichStatus.parseStatus(paramArrayOfByte);
      paramArrayOfByte = null;
      if (localRichStatus != null) {
        paramArrayOfByte = localRichStatus.toSpannableString(null, -8947849, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131165327));
      }
      Object localObject = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        localObject = new SpannableString("");
      }
      if ((localRichStatus != null) && (!TextUtils.isEmpty(localRichStatus.actionText)))
      {
        localObject = new SpannableStringBuilder((CharSequence)localObject);
        ((SpannableStringBuilder)localObject).insert(0, "[S] ");
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mStatusManager != null) {
          paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mStatusManager.a(localRichStatus.actionId, 200);
        } else {
          paramArrayOfByte = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), 2130849881);
        }
        paramArrayOfByte = new StatableBitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), paramArrayOfByte, false, false);
        int j = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
        paramArrayOfByte.setBounds(0, 0, j, j);
        paramArrayOfByte = new OffsetableImageSpan(paramArrayOfByte, 0);
        paramArrayOfByte.setOffset(-0.1F);
        ((SpannableStringBuilder)localObject).setSpan(paramArrayOfByte, 0, 3, 17);
        paramTextView.setText((CharSequence)localObject);
        return;
      }
      paramTextView.setText((CharSequence)localObject);
    }
  }
  
  private void a(URLImageView paramURLImageView, PicInfo paramPicInfo, Drawable paramDrawable)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setDrawable ,picInfo:");
      ((StringBuilder)localObject).append(paramPicInfo);
      QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject).toString());
    }
    paramURLImageView.setTag(paramPicInfo);
    Object localObject = paramDrawable;
    if (paramDrawable == null)
    {
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setShape(0);
      ((GradientDrawable)localObject).setCornerRadius(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 15.0F));
      ((GradientDrawable)localObject).setColor(-1579033);
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
        paramPicInfo = URLDrawable.getDrawable(paramPicInfo, localURLDrawableOptions);
        paramPicInfo.setDecodeHandler(URLDrawableDecodeHandler.a);
        paramURLImageView.setImageDrawable(paramPicInfo);
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
        paramPicInfo = URLDrawable.getDrawable(NearbyImgDownloader.convertURL(paramDrawable), localURLDrawableOptions);
        paramPicInfo.setDecodeHandler(URLDrawableDecodeHandler.a);
        paramURLImageView.setImageDrawable(paramPicInfo);
        return;
      }
    }
    catch (MalformedURLException paramURLImageView)
    {
      if (QLog.isColorLevel())
      {
        paramPicInfo = new StringBuilder();
        paramPicInfo.append("GridAdapter.getView() new URL(). ");
        paramPicInfo.append(paramURLImageView.getMessage());
        QLog.d("Q.nearby_people_card.", 2, paramPicInfo.toString(), paramURLImageView);
      }
    }
  }
  
  private void a(PicInfo paramPicInfo, View paramView)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramPicInfo);
      i();
      return;
    }
    paramPicInfo = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, HardCodeUtil.a(2131707298), 0, 0, null, null);
    paramPicInfo.setPositiveButton(2131694583, new NearbyProfileEditTribePanel.7(this, paramPicInfo));
    paramPicInfo.show();
  }
  
  private View b()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    localRelativeLayout.setBackgroundResource(2130841416);
    Object localObject = new RelativeLayout.LayoutParams(UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 35.0F), UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 16.0F));
    int j = UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 5.0F);
    ((RelativeLayout.LayoutParams)localObject).setMargins(j, 0, 0, j);
    ((RelativeLayout.LayoutParams)localObject).addRule(9);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new TextView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    ((TextView)localObject).setText(HardCodeUtil.a(2131707332));
    ((TextView)localObject).setTextColor(-1);
    ((TextView)localObject).setTextSize(1, 12.0F);
    ((TextView)localObject).setSingleLine(true);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    localLayoutParams.setMargins(j, 0, j, 0);
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    localRelativeLayout.addView((View)localObject);
    localRelativeLayout.setVisibility(8);
    return localRelativeLayout;
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
      return true;
    }
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (k != this.jdField_b_of_type_JavaUtilArrayList.size()) {
      return true;
    }
    int j = 0;
    while ((j < k) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      if (((PicInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j)).jdField_a_of_type_Int != ((PicInfo)this.jdField_b_of_type_JavaUtilArrayList.get(j)).jdField_a_of_type_Int) {
        return true;
      }
      j += 1;
    }
    return false;
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
      return true;
    }
    int j = 0;
    while ((j < this.jdField_a_of_type_JavaUtilArrayList.size()) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      if (((PicInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j)).jdField_a_of_type_Int != ((PicInfo)this.jdField_b_of_type_JavaUtilArrayList.get(j)).jdField_a_of_type_Int) {
        return true;
      }
      j += 1;
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
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showToast(HardCodeUtil.a(2131707367));
        return false;
      }
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showToast(HardCodeUtil.a(2131707291));
    return false;
  }
  
  private void i()
  {
    j();
  }
  
  private void j()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add((PicInfo)this.jdField_b_of_type_ComTencentImageURLImageView.getTag());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reorganizePicInfo:");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList);
      QLog.d("Q.nearby_people_card.", 2, localStringBuilder.toString());
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707389));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707357));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 10.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131369202).setVisibility(8);
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369204);
    localTextView.setVisibility(0);
    localTextView.setText(2131690728);
    localTextView.setOnClickListener(new NearbyProfileEditTribePanel.13(this));
    localTextView = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369233);
    localTextView.setVisibility(0);
    localTextView.setText(2131692486);
    localTextView.setEnabled(true);
    localTextView.setOnClickListener(new NearbyProfileEditTribePanel.14(this));
    this.jdField_b_of_type_AndroidViewView.findViewById(2131376636).setOnClickListener(this);
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      localObject = new StringBuilder(HardCodeUtil.a(2131707383));
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int - this.jdField_a_of_type_JavaUtilLinkedList.size() + 1);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(")...");
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showWaitingDialog(((StringBuilder)localObject).toString());
      localObject = new NearbyProfileEditTribePanel.16(this);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.execute((Runnable)localObject);
      return;
    }
    f();
    Object localObject = new Intent("tribe_profile_edit_finish");
    BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
  }
  
  protected int a()
  {
    return 2131561214;
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
    paramString.append(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin());
    paramString.append("/");
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
    localIntent.putExtra("PhotoConst.QZONE_COVER_CROP_LEFT_TITLE", HardCodeUtil.a(2131707385));
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
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getClass().getName());
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_MODE", true);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localActivityURIRequest.extra().putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin());
    ((StringBuilder)localObject).append("/");
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
    QRoute.startUri(localActivityURIRequest);
    AlbumUtil.anim(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, false, true);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800481F", "0X800481F", 1, 0, "", "", "", "");
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = this.jdField_b_of_type_Int;
    int k = paramInt1 + 1896;
    j -= k;
    Object localObject1 = Calendar.getInstance();
    int m = paramInt2 + 1;
    paramInt3 += 1;
    ((Calendar)localObject1).set(1, m, paramInt3);
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).set(1, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    paramInt1 = j;
    if (((Calendar)localObject1).after(localObject2)) {
      paramInt1 = j - 1;
    }
    paramInt2 = paramInt1;
    if (paramInt1 < 0) {
      paramInt2 = 0;
    }
    localObject1 = Utils.a(m, paramInt3);
    paramInt1 = AgeSelectionActivity.a((String)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(k);
    ((StringBuilder)localObject2).append("-");
    ((StringBuilder)localObject2).append(m);
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
    this.jdField_c_of_type_AndroidWidgetEditText.setTag(new Object[] { Integer.valueOf(k << 16 | m << 8 | paramInt3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int j;
    Object localObject1;
    Object localObject2;
    if (paramInt1 != 1)
    {
      if (paramInt1 == 11) {
        break label467;
      }
      j = 0;
      localObject1 = null;
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
                break label467;
              }
              localObject1 = paramIntent.getStringExtra("key_cover_selected_img_path");
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mAlbumId = paramIntent.getStringExtra("key_album_id");
              if ((StringUtil.a((String)localObject1)) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 1) || (this.jdField_a_of_type_JavaUtilArrayList.size() >= NearbyProfileCardConstants.jdField_a_of_type_Int)) {
                break label467;
              }
              paramIntent = a((String)localObject1);
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramIntent);
              return;
            }
            if (paramInt2 != -1) {
              break label467;
            }
            localObject2 = paramIntent.getStringArrayExtra("param_location");
          }
        }
      }
    }
    try
    {
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mConditionSearchManager.a((String[])localObject2);
      if (paramIntent != null)
      {
        localObject1 = paramIntent;
        if (!paramIntent.equals("不限")) {}
      }
      else
      {
        localObject1 = "";
      }
      paramIntent = this.jdField_e_of_type_AndroidWidgetEditText;
      if (paramIntent != null)
      {
        paramIntent.setText((CharSequence)localObject1);
        this.jdField_e_of_type_AndroidWidgetEditText.setTag(localObject2);
        return;
        if ((paramInt2 == -1) && (this.jdField_d_of_type_AndroidWidgetEditText != null))
        {
          localObject1 = paramIntent.getStringExtra("param_name");
          paramInt1 = paramIntent.getIntExtra("param_id", -1);
          localObject2 = paramIntent.getStringExtra("param_tag");
          paramInt2 = paramIntent.getIntExtra("param_tag_bg", -1);
          if ((localObject2 != null) && (((String)localObject2).length() > 0) && (paramInt2 > 0))
          {
            this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
            this.jdField_f_of_type_AndroidWidgetTextView.setBackgroundResource(paramInt2);
            this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
          }
          else
          {
            this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
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
                paramInt1 = j;
                while (paramInt1 < paramIntent.size())
                {
                  this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a((PicInfo)paramIntent.get(paramInt1), null));
                  paramInt1 += 1;
                }
                i();
                return;
              }
              return;
              if ((paramInt2 == -1) && (paramIntent != null))
              {
                paramIntent = paramIntent.getByteArrayExtra("param_new_xuan_yan");
                localObject1 = this.jdField_f_of_type_AndroidWidgetEditText;
                if (localObject1 != null)
                {
                  a((TextView)localObject1, paramIntent);
                  this.jdField_f_of_type_AndroidWidgetEditText.setTag(paramIntent);
                }
              }
            }
          }
        }
      }
      label467:
      return;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        paramIntent = (Intent)localObject1;
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380648));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373027));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372578));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378036));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131371877));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131367600));
    this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131362294));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131363135));
    this.jdField_f_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131381299));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366074));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.mScrollFlag = 1;
    k();
    TroopBarUtils.b("profile_edit", "exp", "", "", "", "");
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
    int j = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
    String str = NearbyUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(j);
    localStringBuilder.append("");
    ReportController.b((AppRuntime)localObject, "dc00899", "grp_lbs", "", "data_card", "exp_edit", 0, 0, str, localStringBuilder.toString(), "", "");
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList.size() > 0))
    {
      a(this.jdField_b_of_type_ComTencentImageURLImageView, (PicInfo)this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList.get(0), null);
    }
    else
    {
      paramNearbyPeopleCard = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      paramNearbyPeopleCard = FaceDrawable.getFaceDrawable(paramNearbyPeopleCard, 1, paramNearbyPeopleCard.getCurrentAccountUin());
      this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(paramNearbyPeopleCard);
    }
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
      this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131707377);
    } else if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1) {
      this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131707328);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694407));
    } else if (this.jdField_a_of_type_JavaUtilArrayList.size() > 12) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694408, new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
    this.jdField_b_of_type_AndroidWidgetEditText.setText(NearbyProfileUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender));
    this.jdField_b_of_type_AndroidWidgetEditText.setTag(Byte.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender));
    j = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age;
    int k = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday;
    int m = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation;
    int n = (0xFF00 & k) >> 8;
    int i1 = k & 0xFF;
    paramNearbyPeopleCard = Utils.a(n, i1);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(k >> 16);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(n);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append("(");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append("岁");
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramNearbyPeopleCard);
    ((StringBuilder)localObject).append(")");
    this.jdField_c_of_type_AndroidWidgetEditText.setText(((StringBuilder)localObject).toString());
    this.jdField_c_of_type_AndroidWidgetEditText.setTag(new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m) });
    j = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job;
    a(this.jdField_f_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
    this.jdField_f_of_type_AndroidWidgetEditText.setTag(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mIsFromInterestTest) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mEnterEidtTimes == 1)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHandler.postDelayed(new NearbyProfileEditTribePanel.8(this), 300L);
    }
    this.jdField_b_of_type_AndroidViewView.findViewById(2131381300).setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131367603).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131362296).setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131363151).setOnClickListener(this);
    this.jdField_b_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new NearbyProfileEditTribePanel.9(this));
    this.jdField_f_of_type_AndroidWidgetEditText.addTextChangedListener(new NearbyProfileEditTribePanel.10(this));
    this.jdField_a_of_type_AndroidWidgetEditText.getViewTreeObserver().addOnGlobalLayoutListener(new NearbyProfileEditTribePanel.11(this));
  }
  
  public void a(String paramString, int paramInt)
  {
    int k = 1;
    int j = 1;
    this.jdField_b_of_type_Boolean = true;
    if (TextUtils.isEmpty(paramString))
    {
      this.i = 1;
      this.g.setText("");
      paramInt = 0;
    }
    else
    {
      if (paramInt == 0)
      {
        if (TextUtils.equals(this.g.getText().toString(), paramString)) {
          if (this.i == 2)
          {
            paramInt = k;
            break label103;
          }
        }
        for (;;)
        {
          paramInt = 0;
          break;
          this.i = paramInt;
        }
      }
      else
      {
        if (paramInt != 2) {
          j = 0;
        }
        this.i = paramInt;
        paramInt = j;
      }
      label103:
      this.g.setText(paramString);
    }
    if (paramInt != 0)
    {
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8006784", "0X8006784", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public boolean a()
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
      if (!Arrays.equals(localNearbyPeopleCard.xuanYan, (byte[])this.jdField_f_of_type_AndroidWidgetEditText.getTag())) {
        return true;
      }
      if (!Utils.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname)) {
        return true;
      }
      if (((Byte)this.jdField_b_of_type_AndroidWidgetEditText.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender) {
        return true;
      }
      if (((Integer)((Object[])(Object[])this.jdField_c_of_type_AndroidWidgetEditText.getTag())[0]).intValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(PicInfo paramPicInfo)
  {
    a(this.jdField_b_of_type_ComTencentImageURLImageView, paramPicInfo, null);
    i();
    return true;
  }
  
  int b()
  {
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    int j = 0;
    while (j < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      PicInfo localPicInfo = (PicInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (localPicInfo.jdField_a_of_type_Int == -1) {
        this.jdField_a_of_type_JavaUtilLinkedList.add(localPicInfo);
      }
      j += 1;
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilLinkedList.size();
    return this.jdField_a_of_type_Int;
  }
  
  public void b() {}
  
  boolean b()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int k = this.jdField_b_of_type_JavaUtilArrayList.size();
    if ((k <= 0) && (j >= 1)) {
      return true;
    }
    if ((k >= 1) && (j <= 0)) {
      return true;
    }
    return (k >= 1) && (j >= 1) && (((PicInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int != ((PicInfo)this.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int);
  }
  
  public void c()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, LocationSelectActivity.class);
    localIntent.putExtra("param_req_type", 3);
    ConditionSearchManager localConditionSearchManager = (ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
    int j = localConditionSearchManager.a();
    Object localObject;
    if (j != 0)
    {
      j = localConditionSearchManager.a(j, true);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startLocationSelectActivity | update result = ");
        ((StringBuilder)localObject).append(j);
        QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject).toString());
      }
      if (j == 2)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2131694424, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
        return;
      }
      if (j == 0)
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
    String[] arrayOfString = (String[])this.jdField_e_of_type_AndroidWidgetEditText.getTag();
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
    if (this.jdField_e_of_type_AndroidWidgetEditText != null)
    {
      if (!"不限".equals(localObject)) {
        this.jdField_e_of_type_AndroidWidgetEditText.setText((CharSequence)localObject);
      }
      this.jdField_e_of_type_AndroidWidgetEditText.setTag(arrayOfString);
    }
  }
  
  void e()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004823", "0X8004823", 0, 0, "", "", "", "");
    TroopBarUtils.b("profile_edit", "suc_edit", a(), "", "", "");
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOldSaveAction, picInfo size|");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList.size());
      QLog.i("Q.nearby_people_card.", 4, localStringBuilder.toString());
    }
    l();
  }
  
  void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.nearby_people_card.", 4, "saveNearbyProfileCard");
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showWaitingDialog(HardCodeUtil.a(2131707369));
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    if (c())
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 10, 0, "", "", "", "");
      j = 3;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 1) {
        j = 1;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
      if ((localObject1 != null) && (((NearbyPeopleCard)localObject1).gender == 0)) {
        localObject1 = "1";
      } else {
        localObject1 = "2";
      }
      ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "upload_video", 0, 0, "", (String)localObject1, "", String.valueOf(j));
    }
    int j = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
    Object localObject2 = NearbyUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(j);
    ((StringBuilder)localObject3).append("");
    ReportController.b((AppRuntime)localObject1, "dc00899", "grp_lbs", "", "data_card", "suc_edit", 0, 0, (String)localObject2, ((StringBuilder)localObject3).toString(), "", "");
    localObject3 = new Bundle();
    ((Bundle)localObject3).putBoolean("key_is_nearby_people_card", true);
    ((Bundle)localObject3).putShort("key_new_profile_modified_flag", (short)1);
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      localObject2 = (byte[])this.jdField_f_of_type_AndroidWidgetEditText.getTag();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[0];
      }
      ((Bundle)localObject3).putByteArray("key_xuan_yan", (byte[])localObject1);
      if (!Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan, (byte[])this.jdField_f_of_type_AndroidWidgetEditText.getTag()))
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
      byte b1 = ((Byte)this.jdField_b_of_type_AndroidWidgetEditText.getTag()).byteValue();
      if (b1 != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender)
      {
        ((Bundle)localObject3).putByte("sex", b1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
        ((NearbyPeopleProfileActivity)localObject1).mLostGodFlag = true;
        ReportController.b(((NearbyPeopleProfileActivity)localObject1).app, "CliOper", "", "", "0X8004820", "0X8004820", 4, 0, "", "", "", "");
      }
      localObject1 = (Object[])this.jdField_c_of_type_AndroidWidgetEditText.getTag();
      j = ((Integer)localObject1[0]).intValue();
      if (j != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday)
      {
        ((Bundle)localObject3).putInt("birthday", j);
        ((Bundle)localObject3).putInt("age", ((Integer)localObject1[1]).intValue());
        ((Bundle)localObject3).putInt("key_constellation", ((Integer)localObject1[2]).intValue());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 5, 0, "", "", "", "");
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mCardHandler;
    if (localObject1 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.execute(new NearbyProfileEditTribePanel.17(this, (INearbyCardHandler)localObject1, (Bundle)localObject3, localArrayList));
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.nearby_people_card.", 4, "NearbyCardHandler is null");
    }
  }
  
  public void g()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, JobSelectionActivity.class);
    EditText localEditText = this.jdField_d_of_type_AndroidWidgetEditText;
    if ((localEditText != null) && (localEditText.getTag() != null) && ((this.jdField_d_of_type_AndroidWidgetEditText.getTag() instanceof Integer))) {
      localIntent.putExtra("param_id", (Integer)this.jdField_d_of_type_AndroidWidgetEditText.getTag());
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(localIntent, 3);
  }
  
  public void h()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, EditActivity.class);
    localIntent.putExtra("param_entry", 1);
    localIntent.putExtra("param_old_xuan_yan", (byte[])this.jdField_f_of_type_AndroidWidgetEditText.getTag());
    localIntent.putExtra("max_word_count", 30);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(localIntent, 1);
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    int j;
    Object localObject2;
    int k;
    if ((paramView.getId() != 2131367603) && (paramView != this.jdField_b_of_type_AndroidWidgetEditText))
    {
      if ((paramView.getId() != 2131369574) && (paramView != this.jdField_d_of_type_AndroidWidgetEditText))
      {
        if (paramView == this.jdField_b_of_type_AndroidWidgetLinearLayout)
        {
          paramView = this.g.getText().toString();
          paramView = URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a("https://qun.qq.com/qqweb/m/nearby/pages/school_edit.html", "_bid", "2473"), "_wv", "1031"), "schoolName", paramView), "isValid", String.valueOf(this.i));
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", paramView);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
          return;
        }
        if ((paramView.getId() != 2131368223) && (paramView != this.jdField_e_of_type_AndroidWidgetEditText))
        {
          if ((paramView.getId() != 2131381300) && (paramView != this.jdField_f_of_type_AndroidWidgetEditText))
          {
            if ((paramView.getId() != 2131362296) && (paramView != this.jdField_c_of_type_AndroidWidgetEditText))
            {
              if (paramView == this.jdField_a_of_type_ComTencentImageURLImageView)
              {
                paramView = (INearbyVideoUtils)QRoute.api(INearbyVideoUtils.class);
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
                if (!paramView.showTakeAuthVideoGuideDialog((Activity)localObject1, ((NearbyPeopleProfileActivity)localObject1).app))
                {
                  if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.jdField_a_of_type_JavaLangString)))
                  {
                    ((INearbyVideoUtils)QRoute.api(INearbyVideoUtils.class)).startPlayerActivity(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, null, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.d, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode, true);
                    j = 1;
                  }
                  else
                  {
                    paramView = (INearbyVideoUtils)QRoute.api(INearbyVideoUtils.class);
                    localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
                    paramView.showPtvPanel((Activity)localObject1, ((NearbyPeopleProfileActivity)localObject1).app, 2);
                  }
                }
                else {
                  j = 2;
                }
                paramView = (INearbyVideoUtils)QRoute.api(INearbyVideoUtils.class);
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("");
                ((StringBuilder)localObject1).append(j);
                paramView.report("clk_video_entry", new String[] { ((StringBuilder)localObject1).toString(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "1" });
                return;
              }
              if ((paramView.getId() == 2131363151) || (paramView == this.jdField_b_of_type_ComTencentImageURLImageView))
              {
                paramView = this.jdField_a_of_type_JavaUtilArrayList;
                if (paramView != null) {
                  a(paramView.size());
                }
              }
            }
            else
            {
              localObject1 = ActionSheet.createMenuSheet(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
              localObject2 = Calendar.getInstance();
              this.jdField_b_of_type_Int = ((Calendar)localObject2).get(1);
              Object localObject3 = (DispatchActionMoveScrollView)((ActionSheet)localObject1).findViewById(2131361999);
              ((DispatchActionMoveScrollView)localObject3).jdField_a_of_type_Boolean = true;
              ((DispatchActionMoveScrollView)localObject3).setBackgroundResource(17170445);
              localObject3 = (IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity).inflate(2131561132, null);
              ((IphonePickerView)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
              if (this.jdField_c_of_type_AndroidWidgetEditText.getTag() != null)
              {
                j = ((Integer)((Object[])(Object[])this.jdField_c_of_type_AndroidWidgetEditText.getTag())[0]).intValue();
                int m;
                if (j == 0)
                {
                  j = 94;
                  k = 0;
                  m = 0;
                }
                else
                {
                  m = ((0xFF00 & j) >>> 8) - 1;
                  k = (j & 0xFF) - 1;
                  j = (j >>> 16) - 1896;
                }
                ((Calendar)localObject2).setTimeInMillis(System.currentTimeMillis());
                this.jdField_b_of_type_Int = ((Calendar)localObject2).get(1);
                this.jdField_c_of_type_Int = (((Calendar)localObject2).get(2) + 1);
                this.jdField_d_of_type_Int = ((Calendar)localObject2).get(5);
                ((IphonePickerView)localObject3).setPickListener(new NearbyProfileEditTribePanel.3(this, (IphonePickerView)localObject3, (ActionSheet)localObject1));
                ((IphonePickerView)localObject3).setSelection(0, j);
                ((IphonePickerView)localObject3).setSelection(1, m);
                ((IphonePickerView)localObject3).setSelection(2, k);
                ((ActionSheet)localObject1).setOnDismissListener(new NearbyProfileEditTribePanel.4(this));
                ((ActionSheet)localObject1).setActionContentView((View)localObject3, null);
                ((ActionSheet)localObject1).show();
                a(paramView, ((ActionSheet)localObject1).getActionContentView());
                a(this.jdField_c_of_type_AndroidWidgetEditText, false);
              }
            }
          }
          else {
            h();
          }
        }
        else {
          c();
        }
      }
      else
      {
        g();
      }
    }
    else
    {
      localObject1 = ActionSheet.createMenuSheet(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
      localObject2 = (DispatchActionMoveScrollView)((ActionSheet)localObject1).findViewById(2131361999);
      ((DispatchActionMoveScrollView)localObject2).jdField_a_of_type_Boolean = true;
      ((DispatchActionMoveScrollView)localObject2).setBackgroundResource(17170445);
      localObject2 = (IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity).inflate(2131561132, null);
      ((IphonePickerView)localObject2).a(this.jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
      if (this.jdField_b_of_type_AndroidWidgetEditText.getTag() != null)
      {
        k = ((Byte)this.jdField_b_of_type_AndroidWidgetEditText.getTag()).byteValue();
        if (k >= 0)
        {
          j = k;
          if (k <= 1) {}
        }
        else
        {
          j = 0;
        }
        ((IphonePickerView)localObject2).setSelection(0, j);
        ((IphonePickerView)localObject2).setPickListener(new NearbyProfileEditTribePanel.1(this, (IphonePickerView)localObject2, (ActionSheet)localObject1));
        ((ActionSheet)localObject1).setOnDismissListener(new NearbyProfileEditTribePanel.2(this));
        ((ActionSheet)localObject1).setActionContentView((View)localObject2, null);
        ((ActionSheet)localObject1).show();
        a(paramView, ((ActionSheet)localObject1).getActionContentView());
        a(this.jdField_b_of_type_AndroidWidgetEditText, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel
 * JD-Core Version:    0.7.0.1
 */