package com.tencent.mobileqq.profile.PersonalityLabel;

import android.content.Context;
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
      paramLabelItemViewHolder.jdField_b_of_type_AndroidViewView.setTag(2131362232, Integer.valueOf(4));
      paramLabelItemViewHolder.jdField_b_of_type_AndroidViewView.setTag(2131365474, paramLabelItemViewHolder);
    }
    else if (PersonalityLabelGalleryActivity.a(this.a))
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
      paramLabelItemViewHolder.jdField_b_of_type_AndroidViewView.setTag(2131362232, Integer.valueOf(1));
    }
    else
    {
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
      paramLabelItemViewHolder.jdField_b_of_type_AndroidViewView.setTag(2131362232, Integer.valueOf(3));
    }
    paramLabelItemViewHolder = paramLabelItemViewHolder.jdField_b_of_type_AndroidWidgetImageView;
    int i;
    if (this.a.jdField_b_of_type_Boolean) {
      i = 2130845827;
    } else {
      i = 2130845819;
    }
    paramLabelItemViewHolder.setImageResource(i);
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
    localBundle.putString("key_title", this.a.getString(2131717454));
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
    long l = paramPersonalityLabelInfo.praiseCount;
    float f = 0.5F;
    if (l > 0L)
    {
      if (this.a.jdField_a_of_type_Int <= 0)
      {
        localObject = this.a;
        ((PersonalityLabelGalleryActivity)localObject).jdField_a_of_type_Int = ((int)(((PersonalityLabelGalleryActivity)localObject).getResources().getDisplayMetrics().widthPixels - PersonalityLabelGalleryActivity.a(this.a) * 95.0F));
      }
      if (this.a.jdField_a_of_type_AndroidTextTextPaint == null) {
        this.a.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
      }
      this.a.jdField_a_of_type_AndroidTextTextPaint.setTextSize(PersonalityLabelGalleryActivity.a(this.a) * 14.0F);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramPersonalityLabelInfo.praiseCount);
      int i = 0;
      ((StringBuilder)localObject).insert(0, "共").append("个赞");
      int j = (int)(this.a.jdField_a_of_type_AndroidTextTextPaint.measureText(((StringBuilder)localObject).toString()) + 0.5F);
      StringBuilder localStringBuilder = new StringBuilder();
      while (i < paramPersonalityLabelInfo.zanUins.size())
      {
        localStringBuilder.append(((PersonalityLabelZan)paramPersonalityLabelInfo.zanUins.get(i)).nick);
        if (i == paramPersonalityLabelInfo.zanUins.size() - 1) {
          localStringBuilder.append("，");
        } else {
          localStringBuilder.append("、");
        }
        i += 1;
      }
      paramPersonalityLabelInfo = TextUtils.ellipsize(localStringBuilder.toString(), this.a.jdField_a_of_type_AndroidTextTextPaint, this.a.jdField_a_of_type_Int - j, TextUtils.TruncateAt.END).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramPersonalityLabelInfo);
      localStringBuilder.append(((StringBuilder)localObject).toString());
      paramPersonalityLabelInfo = localStringBuilder.toString();
    }
    else
    {
      paramPersonalityLabelInfo = this.a.getResources().getString(2131699146);
    }
    if (!TextUtils.equals(paramPersonalityLabelInfo, str)) {
      paramLabelItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramPersonalityLabelInfo);
    }
    paramPersonalityLabelInfo = paramLabelItemViewHolder.jdField_b_of_type_AndroidWidgetTextView;
    if (!this.a.jdField_b_of_type_Boolean) {
      f = 1.0F;
    }
    paramPersonalityLabelInfo.setAlpha(f);
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
    View localView;
    if (paramView == null)
    {
      localView = this.a.getLayoutInflater().inflate(2131561270, paramViewGroup, false);
      paramView = new PersonalityLabelGalleryActivity.LabelItemViewHolder(null);
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131367917);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369719));
      paramView.jdField_b_of_type_AndroidViewView = localView.findViewById(2131363012);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362232));
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362233));
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365474));
      paramView.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131381335));
      paramView.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView = ((GlowCountRecyclerView)localView.findViewById(2131376308));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131381337));
      paramView.jdField_c_of_type_AndroidViewView = localView.findViewById(2131378771);
      paramView.jdField_d_of_type_AndroidViewView = localView.findViewById(2131365132);
      paramView.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      paramView.jdField_c_of_type_AndroidViewView.setTag(2131362232, Integer.valueOf(5));
      if (!PersonalityLabelGalleryActivity.a(this.a)) {
        paramView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      }
      paramView.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.setTextSizeDp(12);
      localObject1 = new PersonalityLabelGalleryActivity.HorizontalSpaceItemDecoration(this.a, null);
      paramView.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.addItemDecoration((RecyclerView.ItemDecoration)localObject1);
      localView.setTag(paramView);
    }
    else
    {
      localObject1 = (PersonalityLabelGalleryActivity.LabelItemViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    paramView.e = localView;
    Object localObject1 = (PersonalityLabelInfo)getItem(paramInt);
    if (localObject1 == null)
    {
      QLog.d("PersonalityLabelGalleryActivity", 1, "getView labelInfo == null");
    }
    else
    {
      paramView.jdField_a_of_type_Long = ((PersonalityLabelInfo)localObject1).id;
      Object localObject2 = (Integer)paramView.jdField_a_of_type_AndroidViewView.getTag(2131369719);
      if ((localObject2 == null) || (((Integer)localObject2).intValue() != ((PersonalityLabelInfo)localObject1).bgColor))
      {
        paramView.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new ColorDrawable(((PersonalityLabelInfo)localObject1).bgColor));
        paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(((PersonalityLabelInfo)localObject1).bgColor);
        paramView.jdField_a_of_type_AndroidViewView.setTag(2131369719, Integer.valueOf(((PersonalityLabelInfo)localObject1).bgColor));
      }
      if (!paramView.jdField_a_of_type_AndroidWidgetTextView.getText().equals(((PersonalityLabelInfo)localObject1).text)) {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((PersonalityLabelInfo)localObject1).text);
      }
      a(paramView, (PersonalityLabelInfo)localObject1);
      paramView.jdField_b_of_type_AndroidViewView.setTag(2131381337, paramView);
      if (!PersonalityLabelGalleryActivity.a(this.a)) {
        if (((PersonalityLabelInfo)localObject1).praiseFlag > 0) {
          paramView.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130845848);
        } else {
          paramView.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130845836);
        }
      }
      if (PersonalityLabelGalleryActivity.a(this.a))
      {
        paramView.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
        paramView.jdField_b_of_type_AndroidWidgetTextView.setTag(localObject1);
        paramView.jdField_b_of_type_AndroidWidgetTextView.setTag(2131362232, Integer.valueOf(2));
      }
      a((PersonalityLabelInfo)localObject1, paramView);
      boolean bool2 = this.a.a(paramInt, (PersonalityLabelInfo)localObject1);
      if ((paramInt == 0) && (bool2)) {
        this.a.d = true;
      }
      boolean bool1;
      if (paramView.jdField_c_of_type_AndroidViewView.getVisibility() == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      int i;
      if (bool2 != bool1)
      {
        localObject2 = paramView.jdField_c_of_type_AndroidViewView;
        if (bool2) {
          i = 0;
        } else {
          i = 8;
        }
        ((View)localObject2).setVisibility(i);
      }
      localObject2 = new StaggeredGridLayoutManager(1, 0);
      paramView.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject2);
      paramView.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.setAdapter(new PersonalityLabelGalleryActivity.RecyclerViewAdapter(this.a, ((PersonalityLabelInfo)localObject1).id));
      localObject2 = paramView.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((PersonalityLabelInfo)localObject1).photoCount);
      localStringBuilder.append("张");
      ((GlowCountRecyclerView)localObject2).setText(localStringBuilder.toString());
      localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
      if ((((PersonalityLabelInfo)localObject1).personalityLabelPhotos != null) && (((PersonalityLabelInfo)localObject1).personalityLabelPhotos.size() > 0))
      {
        paramView.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.setVisibility(0);
        paramView.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.setOnScrollListener(new PersonalityLabelGalleryActivity.ListViewAdapter.1(this, (PersonalityLabelInfo)localObject1));
      }
      else
      {
        paramView.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.setVisibility(8);
      }
      localObject2 = paramView.jdField_d_of_type_AndroidViewView.getTag();
      if (localObject2 == null) {
        bool1 = false;
      } else {
        bool1 = ((Boolean)localObject2).booleanValue();
      }
      bool2 = this.a.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(((PersonalityLabelInfo)localObject1).id));
      if (bool2 != bool1)
      {
        localObject1 = (FrameLayout.LayoutParams)paramView.jdField_d_of_type_AndroidViewView.getLayoutParams();
        if (bool2) {
          i = j;
        } else {
          i = -2;
        }
        ((FrameLayout.LayoutParams)localObject1).height = i;
        paramView.jdField_d_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramView.jdField_d_of_type_AndroidViewView.setTag(Boolean.valueOf(bool2));
      }
      if (this.a.jdField_a_of_type_JavaUtilHashSet.size() > 0) {
        this.a.jdField_b_of_type_AndroidOsHandler.post(new PersonalityLabelGalleryActivity.ListViewAdapter.2(this));
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag(2131362232);
    if ((localObject1 != null) && ((localObject1 instanceof Integer)))
    {
      int i = ((Integer)localObject1).intValue();
      Object localObject2;
      if (i == 1)
      {
        if (this.a.c)
        {
          localObject1 = this.a;
          ((PersonalityLabelGalleryActivity)localObject1).c = false;
          PersonalityLabelGalleryActivity.c((PersonalityLabelGalleryActivity)localObject1);
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
      else
      {
        Object localObject3;
        if (i == 2)
        {
          if (!this.a.jdField_b_of_type_Boolean)
          {
            localObject1 = (PersonalityLabelInfo)paramView.getTag();
            localObject2 = new Intent(this.a, QQBrowserActivity.class);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("https://ti.qq.com/cgi-node/specialtag/labzan?_wv=1027&labelId=");
            ((StringBuilder)localObject3).append(((PersonalityLabelInfo)localObject1).id);
            ((Intent)localObject2).putExtra("url", ((StringBuilder)localObject3).toString());
            this.a.startActivity((Intent)localObject2);
          }
        }
        else if (i == 3)
        {
          localObject3 = (PersonalityLabelInfo)paramView.getTag();
          if (((PersonalityLabelInfo)localObject3).praiseFlag <= 0)
          {
            ((PersonalityLabelHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.PROFILE_PERSONALITY_LABEL)).a(PersonalityLabelGalleryActivity.a(this.a), ((PersonalityLabelInfo)localObject3).id);
            ((PersonalityLabelInfo)localObject3).praiseFlag = 1;
            ((PersonalityLabelInfo)localObject3).praiseCount += 1L;
            localObject2 = null;
            localObject1 = null;
            i = ((PersonalityLabelInfo)localObject3).zanUins.size();
            if (i > 0)
            {
              i -= 1;
              for (;;)
              {
                localObject2 = localObject1;
                if (i < 0) {
                  break;
                }
                if (((PersonalityLabelZan)((PersonalityLabelInfo)localObject3).zanUins.get(i)).uin == Long.valueOf(this.a.getCurrentAccountUin()).longValue()) {
                  localObject1 = (PersonalityLabelZan)((PersonalityLabelInfo)localObject3).zanUins.remove(i);
                }
                i -= 1;
              }
            }
            PersonalityLabelZan localPersonalityLabelZan = new PersonalityLabelZan();
            localPersonalityLabelZan.uin = Long.valueOf(this.a.getCurrentAccountUin()).longValue();
            if (localObject2 != null) {
              localObject1 = ((PersonalityLabelZan)localObject2).nick;
            } else {
              localObject1 = ContactUtils.a(this.a.app, this.a.app.getCurrentAccountUin());
            }
            localPersonalityLabelZan.nick = ((String)localObject1);
            ((PersonalityLabelInfo)localObject3).zanUins.add(0, localPersonalityLabelZan);
            a((PersonalityLabelInfo)localObject3, (PersonalityLabelGalleryActivity.LabelItemViewHolder)paramView.getTag(2131381337));
            ((ImageView)paramView.findViewById(2131381335)).setImageResource(2130845848);
            PersonalityLabelGalleryActivity.b(this.a, true);
            if (this.a.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
              this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
            }
            localObject1 = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, PersonalityLabelGalleryActivity.a(this.a));
            this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject1, 500L);
            ReportController.b(this.a.app, "dc00898", "", "", "0X8007FD0", "0X8007FD0", 0, 0, "", "", "", "");
          }
          else
          {
            if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQToast == null)
            {
              localObject1 = this.a;
              ((PersonalityLabelGalleryActivity)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a((Context)localObject1, "每个标签每天只能点一个赞哦。", 0);
            }
            if (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.d()) {
              this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.b(this.a.getTitleBarHeight());
            }
          }
        }
        else if (i == 4)
        {
          localObject2 = (PersonalityLabelInfo)paramView.getTag();
          i = ((PersonalityLabelInfo)localObject2).photoCount;
          if (i > 0) {
            localObject1 = String.format("确认删除标签 “%s”，其中包含%d张照片？", new Object[] { ((PersonalityLabelInfo)localObject2).text, Integer.valueOf(i) });
          } else {
            localObject1 = String.format("确认删除标签 “%s”？", new Object[] { ((PersonalityLabelInfo)localObject2).text });
          }
          DialogUtil.a(this.a, (String)localObject1, 2131690728, 2131692630, new PersonalityLabelGalleryActivity.ListViewAdapter.4(this, paramView, (PersonalityLabelInfo)localObject2), new PersonalityLabelGalleryActivity.ListViewAdapter.5(this)).show();
        }
        else if (i == 5)
        {
          PersonalityLabelGalleryActivity.c(this.a);
          paramView.setVisibility(8);
          this.a.c = false;
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.ListViewAdapter
 * JD-Core Version:    0.7.0.1
 */