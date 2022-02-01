package com.tencent.mobileqq.profile.PersonalityLabel;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailTopGestureLayout;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class PersonalityLabelGalleryActivity$ListViewAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private PersonalityLabelGalleryActivity$ListViewAdapter(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity) {}
  
  private void a(PersonalityLabelGalleryActivity.LabelItemViewHolder paramLabelItemViewHolder, PersonalityLabelInfo paramPersonalityLabelInfo)
  {
    if (this.a.jdField_b_of_type_Boolean)
    {
      if (paramLabelItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 8) {
        paramLabelItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (paramLabelItemViewHolder.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        paramLabelItemViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (paramLabelItemViewHolder.jdField_d_of_type_AndroidWidgetImageView.getVisibility() != 8) {
        paramLabelItemViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (paramLabelItemViewHolder.jdField_c_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        paramLabelItemViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      paramLabelItemViewHolder.jdField_b_of_type_AndroidViewView.setTag(paramPersonalityLabelInfo);
      paramLabelItemViewHolder.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      paramLabelItemViewHolder.jdField_b_of_type_AndroidViewView.setTag(2131362207, Integer.valueOf(4));
      paramLabelItemViewHolder.jdField_b_of_type_AndroidViewView.setTag(2131365630, paramLabelItemViewHolder);
      paramLabelItemViewHolder = paramLabelItemViewHolder.jdField_b_of_type_AndroidWidgetImageView;
      if (!this.a.jdField_b_of_type_Boolean) {
        break label384;
      }
    }
    label384:
    for (int i = 2130845953;; i = 2130845945)
    {
      paramLabelItemViewHolder.setImageResource(i);
      return;
      if (PersonalityLabelGalleryActivity.a(this.a))
      {
        if (paramLabelItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          paramLabelItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        if (paramLabelItemViewHolder.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          paramLabelItemViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        if (paramLabelItemViewHolder.jdField_d_of_type_AndroidWidgetImageView.getVisibility() != 8) {
          paramLabelItemViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        if (paramLabelItemViewHolder.jdField_c_of_type_AndroidWidgetImageView.getVisibility() != 8) {
          paramLabelItemViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        paramLabelItemViewHolder.jdField_b_of_type_AndroidViewView.setTag(paramPersonalityLabelInfo);
        paramLabelItemViewHolder.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
        paramLabelItemViewHolder.jdField_b_of_type_AndroidViewView.setTag(2131362207, Integer.valueOf(1));
        break;
      }
      if (paramLabelItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 8) {
        paramLabelItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (paramLabelItemViewHolder.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 8) {
        paramLabelItemViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (paramLabelItemViewHolder.jdField_d_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        paramLabelItemViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (paramLabelItemViewHolder.jdField_c_of_type_AndroidWidgetImageView.getVisibility() != 8) {
        paramLabelItemViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      paramLabelItemViewHolder.jdField_b_of_type_AndroidViewView.setTag(paramPersonalityLabelInfo);
      paramLabelItemViewHolder.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      paramLabelItemViewHolder.jdField_b_of_type_AndroidViewView.setTag(2131362207, Integer.valueOf(3));
      break;
    }
  }
  
  private void b(PersonalityLabelInfo paramPersonalityLabelInfo)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.a, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 48);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", Math.min(9, Math.max(PersonalityLabelGalleryActivity.a(this.a).maxPhotoCount - paramPersonalityLabelInfo.photoCount, 0)));
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.a.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("label_id", paramPersonalityLabelInfo.id);
    this.a.startActivity(localIntent);
    AlbumUtil.anim(this.a, false, true);
  }
  
  public void a(PersonalityLabelInfo paramPersonalityLabelInfo)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = this.a.app.getCurrentAccountUin();
    localUserInfo.nickname = this.a.app.getCurrentNickname();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_title", this.a.getString(2131717795));
    localBundle.putInt("key_personal_album_enter_model", 1);
    localBundle.putBoolean("key_multiple_model_need_download_img", true);
    localBundle.putInt("_input_max", Math.min(9, Math.max(PersonalityLabelGalleryActivity.a(this.a).maxPhotoCount - paramPersonalityLabelInfo.photoCount, 0)));
    localBundle.putBoolean("show_album", false);
    localBundle.putBoolean("key_need_change_to_jpg", true);
    QZoneHelper.forwardToPersonalAlbumSelect(this.a, localUserInfo, localBundle, 1);
  }
  
  void a(PersonalityLabelInfo paramPersonalityLabelInfo, PersonalityLabelGalleryActivity.LabelItemViewHolder paramLabelItemViewHolder)
  {
    String str = paramLabelItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getText().toString();
    if (paramPersonalityLabelInfo.praiseCount > 0L)
    {
      if (this.a.jdField_a_of_type_Int <= 0) {
        this.a.jdField_a_of_type_Int = ((int)(this.a.getResources().getDisplayMetrics().widthPixels - 95.0F * PersonalityLabelGalleryActivity.a(this.a)));
      }
      if (this.a.jdField_a_of_type_AndroidTextTextPaint == null) {
        this.a.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
      }
      this.a.jdField_a_of_type_AndroidTextTextPaint.setTextSize(PersonalityLabelGalleryActivity.a(this.a) * 14.0F);
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(paramPersonalityLabelInfo.praiseCount);
      localStringBuilder1.insert(0, "共").append("个赞");
      int j = (int)(this.a.jdField_a_of_type_AndroidTextTextPaint.measureText(localStringBuilder1.toString()) + 0.5F);
      StringBuilder localStringBuilder2 = new StringBuilder();
      int i = 0;
      if (i < paramPersonalityLabelInfo.zanUins.size())
      {
        localStringBuilder2.append(((PersonalityLabelZan)paramPersonalityLabelInfo.zanUins.get(i)).nick);
        if (i == paramPersonalityLabelInfo.zanUins.size() - 1) {
          localStringBuilder2.append("，");
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuilder2.append("、");
        }
      }
      paramPersonalityLabelInfo = TextUtils.ellipsize(localStringBuilder2.toString(), this.a.jdField_a_of_type_AndroidTextTextPaint, this.a.jdField_a_of_type_Int - j, TextUtils.TruncateAt.END).toString();
      paramPersonalityLabelInfo = paramPersonalityLabelInfo + localStringBuilder1.toString();
      if (!TextUtils.equals(paramPersonalityLabelInfo, str)) {
        paramLabelItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramPersonalityLabelInfo);
      }
      paramPersonalityLabelInfo = paramLabelItemViewHolder.jdField_b_of_type_AndroidWidgetTextView;
      if (!this.a.jdField_b_of_type_Boolean) {
        break label375;
      }
    }
    label375:
    for (float f = 0.5F;; f = 1.0F)
    {
      paramPersonalityLabelInfo.setAlpha(f);
      return;
      paramPersonalityLabelInfo = this.a.getResources().getString(2131699042);
      break;
    }
  }
  
  public int getCount()
  {
    if ((PersonalityLabelGalleryActivity.a(this.a) != null) && (PersonalityLabelGalleryActivity.a(this.a).personalityLabelInfos != null)) {
      return PersonalityLabelGalleryActivity.a(this.a).personalityLabelInfos.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((PersonalityLabelGalleryActivity.a(this.a) != null) && (PersonalityLabelGalleryActivity.a(this.a).personalityLabelInfos != null)) {
      return PersonalityLabelGalleryActivity.a(this.a).personalityLabelInfos.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    PersonalityLabelGalleryActivity.LabelItemViewHolder localLabelItemViewHolder;
    Object localObject1;
    if (paramView == null)
    {
      paramView = this.a.getLayoutInflater().inflate(2131561430, paramViewGroup, false);
      localLabelItemViewHolder = new PersonalityLabelGalleryActivity.LabelItemViewHolder(null);
      localLabelItemViewHolder.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368164);
      localLabelItemViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370035));
      localLabelItemViewHolder.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363069);
      localLabelItemViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362207));
      localLabelItemViewHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362208));
      localLabelItemViewHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365630));
      localLabelItemViewHolder.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131382131));
      localLabelItemViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView = ((GlowCountRecyclerView)paramView.findViewById(2131376816));
      localLabelItemViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131382133));
      localLabelItemViewHolder.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131379419);
      localLabelItemViewHolder.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131365255);
      localLabelItemViewHolder.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      localLabelItemViewHolder.jdField_c_of_type_AndroidViewView.setTag(2131362207, Integer.valueOf(5));
      if (!PersonalityLabelGalleryActivity.a(this.a)) {
        localLabelItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      }
      localLabelItemViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.setTextSizeDp(12);
      localObject1 = new PersonalityLabelGalleryActivity.HorizontalSpaceItemDecoration(this.a, null);
      localLabelItemViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.addItemDecoration((RecyclerView.ItemDecoration)localObject1);
      paramView.setTag(localLabelItemViewHolder);
    }
    for (;;)
    {
      localLabelItemViewHolder.e = paramView;
      localObject1 = (PersonalityLabelInfo)getItem(paramInt);
      if (localObject1 != null) {
        break;
      }
      QLog.d("PersonalityLabelGalleryActivity", 1, "getView labelInfo == null");
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localLabelItemViewHolder = (PersonalityLabelGalleryActivity.LabelItemViewHolder)paramView.getTag();
    }
    localLabelItemViewHolder.jdField_a_of_type_Long = ((PersonalityLabelInfo)localObject1).id;
    Object localObject2 = (Integer)localLabelItemViewHolder.jdField_a_of_type_AndroidViewView.getTag(2131370035);
    if ((localObject2 == null) || (((Integer)localObject2).intValue() != ((PersonalityLabelInfo)localObject1).bgColor))
    {
      localLabelItemViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new ColorDrawable(((PersonalityLabelInfo)localObject1).bgColor));
      localLabelItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(((PersonalityLabelInfo)localObject1).bgColor);
      localLabelItemViewHolder.jdField_a_of_type_AndroidViewView.setTag(2131370035, Integer.valueOf(((PersonalityLabelInfo)localObject1).bgColor));
    }
    if (!localLabelItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.getText().equals(((PersonalityLabelInfo)localObject1).text)) {
      localLabelItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((PersonalityLabelInfo)localObject1).text);
    }
    a(localLabelItemViewHolder, (PersonalityLabelInfo)localObject1);
    localLabelItemViewHolder.jdField_b_of_type_AndroidViewView.setTag(2131382133, localLabelItemViewHolder);
    label508:
    boolean bool2;
    boolean bool1;
    if (!PersonalityLabelGalleryActivity.a(this.a))
    {
      if (((PersonalityLabelInfo)localObject1).praiseFlag > 0) {
        localLabelItemViewHolder.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130845974);
      }
    }
    else
    {
      if (PersonalityLabelGalleryActivity.a(this.a))
      {
        localLabelItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
        localLabelItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTag(localObject1);
        localLabelItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTag(2131362207, Integer.valueOf(2));
      }
      a((PersonalityLabelInfo)localObject1, localLabelItemViewHolder);
      bool2 = this.a.a(paramInt, (PersonalityLabelInfo)localObject1);
      if ((paramInt == 0) && (bool2)) {
        this.a.d = true;
      }
      if (localLabelItemViewHolder.jdField_c_of_type_AndroidViewView.getVisibility() != 0) {
        break label927;
      }
      bool1 = true;
      label602:
      if (bool2 != bool1)
      {
        localObject2 = localLabelItemViewHolder.jdField_c_of_type_AndroidViewView;
        if (!bool2) {
          break label933;
        }
        i = 0;
        label624:
        ((View)localObject2).setVisibility(i);
      }
      localObject2 = new StaggeredGridLayoutManager(1, 0);
      localLabelItemViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject2);
      localLabelItemViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.setAdapter(new PersonalityLabelGalleryActivity.RecyclerViewAdapter(this.a, ((PersonalityLabelInfo)localObject1).id));
      localLabelItemViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.setText(((PersonalityLabelInfo)localObject1).photoCount + "张");
      if (this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout != null) {
        this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout.a(localLabelItemViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView);
      }
      if ((((PersonalityLabelInfo)localObject1).personalityLabelPhotos == null) || (((PersonalityLabelInfo)localObject1).personalityLabelPhotos.size() <= 0)) {
        break label940;
      }
      localLabelItemViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.setVisibility(0);
      localLabelItemViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.setOnScrollListener(new PersonalityLabelGalleryActivity.ListViewAdapter.1(this, (PersonalityLabelInfo)localObject1));
      label781:
      localObject2 = localLabelItemViewHolder.jdField_d_of_type_AndroidViewView.getTag();
      if (localObject2 != null) {
        break label953;
      }
      bool1 = false;
      label799:
      bool2 = this.a.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(((PersonalityLabelInfo)localObject1).id));
      if (bool2 != bool1)
      {
        localObject1 = (FrameLayout.LayoutParams)localLabelItemViewHolder.jdField_d_of_type_AndroidViewView.getLayoutParams();
        if (!bool2) {
          break label966;
        }
      }
    }
    label927:
    label933:
    label940:
    label953:
    label966:
    for (int i = j;; i = -2)
    {
      ((FrameLayout.LayoutParams)localObject1).height = i;
      localLabelItemViewHolder.jdField_d_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localLabelItemViewHolder.jdField_d_of_type_AndroidViewView.setTag(Boolean.valueOf(bool2));
      if (this.a.jdField_a_of_type_JavaUtilHashSet.size() > 0) {
        this.a.jdField_b_of_type_AndroidOsHandler.post(new PersonalityLabelGalleryActivity.ListViewAdapter.2(this));
      }
      break;
      localLabelItemViewHolder.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130845962);
      break label508;
      bool1 = false;
      break label602;
      i = 8;
      break label624;
      localLabelItemViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.setVisibility(8);
      break label781;
      bool1 = ((Boolean)localObject2).booleanValue();
      break label799;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag(2131362207);
    int i;
    Object localObject2;
    if ((localObject1 != null) && ((localObject1 instanceof Integer)))
    {
      i = ((Integer)localObject1).intValue();
      if (i != 1) {
        break label206;
      }
      if (this.a.c)
      {
        this.a.c = false;
        PersonalityLabelGalleryActivity.c(this.a);
        if (this.a.jdField_b_of_type_AndroidOsHandler.hasMessages(2)) {
          this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(2);
        }
        this.a.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(2);
      }
      localObject1 = (PersonalityLabelInfo)paramView.getTag();
      if (localObject1 != null)
      {
        localObject2 = ActionSheet.create(paramView.getContext());
        ((ActionSheet)localObject2).addButton("从手机相册选择");
        ((ActionSheet)localObject2).addButton("从空间相册选择");
        ((ActionSheet)localObject2).addCancelButton("取消");
        ((ActionSheet)localObject2).setOnButtonClickListener(new PersonalityLabelGalleryActivity.ListViewAdapter.3(this, (PersonalityLabelInfo)localObject1, (ActionSheet)localObject2));
        ((ActionSheet)localObject2).show();
        ReportController.b(this.a.app, "dc00898", "", "", "0X8007FD2", "0X8007FD2", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label206:
      if (i != 2) {
        break;
      }
      if (!this.a.jdField_b_of_type_Boolean)
      {
        localObject1 = (PersonalityLabelInfo)paramView.getTag();
        localObject2 = new Intent(this.a, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", "https://ti.qq.com/cgi-node/specialtag/labzan?_wv=1027&labelId=" + ((PersonalityLabelInfo)localObject1).id);
        this.a.startActivity((Intent)localObject2);
      }
    }
    PersonalityLabelInfo localPersonalityLabelInfo;
    if (i == 3)
    {
      localPersonalityLabelInfo = (PersonalityLabelInfo)paramView.getTag();
      if (localPersonalityLabelInfo.praiseFlag <= 0)
      {
        ((PersonalityLabelHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.PROFILE_PERSONALITY_LABEL)).a(PersonalityLabelGalleryActivity.a(this.a), localPersonalityLabelInfo.id);
        localPersonalityLabelInfo.praiseFlag = 1;
        localPersonalityLabelInfo.praiseCount += 1L;
        localObject2 = null;
        localObject1 = null;
        i = localPersonalityLabelInfo.zanUins.size();
        if (i > 0)
        {
          i -= 1;
          label382:
          localObject2 = localObject1;
          if (i >= 0)
          {
            if (((PersonalityLabelZan)localPersonalityLabelInfo.zanUins.get(i)).uin != Long.valueOf(this.a.getCurrentAccountUin()).longValue()) {
              break label864;
            }
            localObject1 = (PersonalityLabelZan)localPersonalityLabelInfo.zanUins.remove(i);
          }
        }
      }
    }
    label864:
    for (;;)
    {
      i -= 1;
      break label382;
      PersonalityLabelZan localPersonalityLabelZan = new PersonalityLabelZan();
      localPersonalityLabelZan.uin = Long.valueOf(this.a.getCurrentAccountUin()).longValue();
      if (localObject2 != null) {}
      for (localObject1 = ((PersonalityLabelZan)localObject2).nick;; localObject1 = ContactUtils.a(this.a.app, this.a.app.getCurrentAccountUin()))
      {
        localPersonalityLabelZan.nick = ((String)localObject1);
        localPersonalityLabelInfo.zanUins.add(0, localPersonalityLabelZan);
        a(localPersonalityLabelInfo, (PersonalityLabelGalleryActivity.LabelItemViewHolder)paramView.getTag(2131382133));
        ((ImageView)paramView.findViewById(2131382131)).setImageResource(2130845974);
        PersonalityLabelGalleryActivity.b(this.a, true);
        if (this.a.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
          this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
        }
        localObject1 = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, PersonalityLabelGalleryActivity.a(this.a));
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject1, 500L);
        ReportController.b(this.a.app, "dc00898", "", "", "0X8007FD0", "0X8007FD0", 0, 0, "", "", "", "");
        break;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQToast == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(this.a, "每个标签每天只能点一个赞哦。", 0);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.d()) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.b(this.a.getTitleBarHeight());
      break;
      if (i == 4)
      {
        localObject2 = (PersonalityLabelInfo)paramView.getTag();
        i = ((PersonalityLabelInfo)localObject2).photoCount;
        if (i > 0) {}
        for (localObject1 = String.format("确认删除标签 “%s”，其中包含%d张照片？", new Object[] { ((PersonalityLabelInfo)localObject2).text, Integer.valueOf(i) });; localObject1 = String.format("确认删除标签 “%s”？", new Object[] { ((PersonalityLabelInfo)localObject2).text }))
        {
          DialogUtil.a(this.a, (String)localObject1, 2131690800, 2131692673, new PersonalityLabelGalleryActivity.ListViewAdapter.4(this, paramView, (PersonalityLabelInfo)localObject2), new PersonalityLabelGalleryActivity.ListViewAdapter.5(this)).show();
          break;
        }
      }
      if (i != 5) {
        break;
      }
      PersonalityLabelGalleryActivity.c(this.a);
      paramView.setVisibility(8);
      this.a.c = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.ListViewAdapter
 * JD-Core Version:    0.7.0.1
 */