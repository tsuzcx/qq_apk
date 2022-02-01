package com.tencent.mobileqq.profile.PersonalityLabel;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class PersonalityLabelGalleryActivity$RecyclerViewAdapter
  extends RecyclerView.Adapter<PersonalityLabelGalleryActivity.RecyclerViewHolder>
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = (int)(PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity) * 120.0F);
  private long jdField_a_of_type_Long;
  
  public PersonalityLabelGalleryActivity$RecyclerViewAdapter(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity, long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public PersonalityLabelGalleryActivity.RecyclerViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561273, paramViewGroup, false);
    return new PersonalityLabelGalleryActivity.RecyclerViewHolder(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity, paramViewGroup);
  }
  
  public void a(PersonalityLabelGalleryActivity.RecyclerViewHolder paramRecyclerViewHolder, int paramInt)
  {
    PersonalityLabelInfo localPersonalityLabelInfo = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity).get(Long.valueOf(this.jdField_a_of_type_Long));
    if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity;
      ((PersonalityLabelGalleryActivity)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((PersonalityLabelGalleryActivity)localObject1).getResources().getDrawable(2131165426);
    }
    Object localObject1 = ((PersonalityLabelPhoto)localPersonalityLabelInfo.personalityLabelPhotos.get(paramInt)).localThumbPath;
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new File((String)localObject1);
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("file:///");
        localStringBuilder.append(((File)localObject1).getAbsolutePath());
        localObject1 = new URL(localStringBuilder.toString());
        paramRecyclerViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable((URL)localObject1, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        localMalformedURLException1.printStackTrace();
      }
    }
    else
    {
      Object localObject2 = ((PersonalityLabelPhoto)localPersonalityLabelInfo.personalityLabelPhotos.get(paramInt)).get350SizeUrl();
      if ((!((String)localObject2).startsWith("http")) && (!((String)localObject2).startsWith("https")))
      {
        localObject2 = new File((String)localObject2);
        try
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("file:///");
          localStringBuilder.append(((File)localObject2).getAbsolutePath());
          localObject2 = new URL(localStringBuilder.toString());
          paramRecyclerViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable((URL)localObject2, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
        }
        catch (MalformedURLException localMalformedURLException2)
        {
          localMalformedURLException2.printStackTrace();
        }
      }
      else
      {
        int i = this.jdField_a_of_type_Int;
        localObject3 = URLDrawable.getDrawable(localMalformedURLException2, i, i, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        paramRecyclerViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
      }
    }
    Object localObject3 = null;
    if (PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity))
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager.a(this.jdField_a_of_type_Long, (PersonalityLabelPhoto)localPersonalityLabelInfo.personalityLabelPhotos.get(paramInt));
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.a((PLUploadManager.UploadItem)localObject3, (PersonalityLabelPhoto)localPersonalityLabelInfo.personalityLabelPhotos.get(paramInt), paramRecyclerViewHolder);
    }
    paramRecyclerViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131372608, localObject3);
    paramRecyclerViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramInt));
    paramRecyclerViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramRecyclerViewHolder, paramInt, getItemId(paramInt));
  }
  
  public int getItemCount()
  {
    PersonalityLabelInfo localPersonalityLabelInfo = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity).get(Long.valueOf(this.jdField_a_of_type_Long));
    if ((localPersonalityLabelInfo != null) && (localPersonalityLabelInfo.personalityLabelPhotos != null)) {
      return localPersonalityLabelInfo.personalityLabelPhotos.size();
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public void onClick(View paramView)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.b) && (paramView.getId() == 2131372608))
    {
      Object localObject1 = paramView.getTag();
      Object localObject2 = paramView.getTag(2131372608);
      if ((localObject2 != null) && ((localObject2 instanceof PLUploadManager.UploadItem)))
      {
        localObject2 = (PLUploadManager.UploadItem)localObject2;
        if (((PLUploadManager.UploadItem)localObject2).b == 3)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_ComTencentWidgetActionSheet == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(paramView.getContext());
            this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_ComTencentWidgetActionSheet.addButton("重新上传");
            this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_ComTencentWidgetActionSheet.addButton("删除");
            this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton("取消");
          }
          this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new PersonalityLabelGalleryActivity.RecyclerViewAdapter.1(this, (PLUploadManager.UploadItem)localObject2));
          this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_ComTencentWidgetActionSheet.show();
          break label578;
        }
      }
      if ((localObject1 != null) && ((localObject1 instanceof Integer)))
      {
        int m = ((Integer)localObject1).intValue();
        Object localObject3 = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity).get(Long.valueOf(this.jdField_a_of_type_Long));
        localObject2 = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        int j = m;
        int i = 0;
        while (i < ((PersonalityLabelInfo)localObject3).personalityLabelPhotos.size())
        {
          PersonalityLabelPhoto localPersonalityLabelPhoto = (PersonalityLabelPhoto)((PersonalityLabelInfo)localObject3).personalityLabelPhotos.get(i);
          if (PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity)) {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager.a(this.jdField_a_of_type_Long, localPersonalityLabelPhoto);
          } else {
            localObject1 = null;
          }
          int k;
          if ((localObject1 != null) && (((PLUploadManager.UploadItem)localObject1).b == 3))
          {
            k = j;
            if (i < m) {
              k = j - 1;
            }
          }
          else
          {
            ((ArrayList)localObject2).add(localPersonalityLabelPhoto.getOriginUrl());
            localArrayList.add(String.valueOf(localPersonalityLabelPhoto.fileId));
            k = j;
          }
          i += 1;
          j = k;
        }
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity, TroopAvatarWallPreviewActivity.class);
        localObject3 = new Bundle();
        ((Bundle)localObject3).putInt("index", j);
        ((Bundle)localObject3).putStringArrayList("seqNum", (ArrayList)localObject2);
        ((Bundle)localObject3).putStringArrayList("photoIds", localArrayList);
        ((Bundle)localObject3).putBoolean("delete_ability", PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity));
        ((Bundle)localObject3).putBoolean("SHOW_MENU", PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity));
        ((Bundle)localObject3).putBoolean("IS_EDIT", false);
        ((Bundle)localObject3).putBoolean("is_use_path", true);
        ((Bundle)localObject3).putBoolean("is_show_action", false);
        ((Bundle)localObject3).putBoolean("is_not_show_index", false);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putBoolean("from_personality_label", true);
        ((Bundle)localObject2).putLong("label_id", this.jdField_a_of_type_Long);
        ((Bundle)localObject3).putBundle("bundle_data_extra", (Bundle)localObject2);
        ((Intent)localObject1).putExtras((Bundle)localObject3);
        this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.startActivity((Intent)localObject1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.app, "dc00898", "", "", "0X8007FD1", "0X8007FD1", 0, 0, "", "", "", "");
      }
    }
    label578:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.RecyclerViewAdapter
 * JD-Core Version:    0.7.0.1
 */