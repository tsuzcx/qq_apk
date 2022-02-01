package com.tencent.qidian;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anni;
import azde;
import bjhf;
import bjhg;
import com.tencent.image.URLImageView;
import com.tencent.qidian.data.QidianExternalInfo;
import java.util.Iterator;
import java.util.List;

class QidianProfileCardActivity$8
  implements Runnable
{
  QidianProfileCardActivity$8(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void run()
  {
    LinearLayout localLinearLayout1 = (LinearLayout)this.this$0.getLayoutInflater().inflate(2131560921, null);
    LinearLayout localLinearLayout2 = (LinearLayout)localLinearLayout1.findViewById(2131364961);
    Object localObject1;
    int j;
    Object localObject2;
    if ((this.this$0.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null) && (this.this$0.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getGroupItems() != null) && (this.this$0.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getGroupItems().size() > 0))
    {
      localObject1 = this.this$0.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getGroupItems().iterator();
      j = 0;
      i = j;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bjhf)((Iterator)localObject1).next();
        if (j < 4) {
          break label401;
        }
      }
    }
    for (int i = j;; i = 0)
    {
      if ((this.this$0.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null) && (this.this$0.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getCompanyShowCaseInfos() != null) && (this.this$0.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getCompanyShowCaseInfos().size() > 0))
      {
        localObject1 = (LinearLayout)this.this$0.getLayoutInflater().inflate(2131560920, null);
        localObject2 = (TextView)((LinearLayout)localObject1).findViewById(2131378776);
        localObject2 = (LinearLayout)((LinearLayout)localObject1).findViewById(2131364961);
        localObject3 = new PhotoWallViewForQiDianProfile(this.this$0.getApplicationContext());
        ((PhotoWallViewForQiDianProfile)localObject3).setPhotoWallCallback(this.this$0.jdField_a_of_type_Bjfs);
        localObject4 = this.this$0.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getCompanyShowCaseInfos();
        ((PhotoWallViewForQiDianProfile)localObject3).a(this.this$0.getApplicationContext(), (List)localObject4);
        ((PhotoWallViewForQiDianProfile)localObject3).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ((LinearLayout)localObject2).addView((View)localObject3);
        this.this$0.b.addView((View)localObject1);
      }
      j = i;
      if (this.this$0.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null)
      {
        j = i;
        if (this.this$0.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getPublicAccountItems() != null)
        {
          j = i;
          if (this.this$0.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getPublicAccountItems().size() > 0)
          {
            localObject1 = this.this$0.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getPublicAccountItems().iterator();
            j = i;
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (bjhg)((Iterator)localObject1).next();
              if (i < 4) {
                break label574;
              }
              j = i;
            }
          }
        }
      }
      if (j > 0) {
        this.this$0.b.addView(localLinearLayout1);
      }
      return;
      label401:
      Object localObject3 = (RelativeLayout)this.this$0.getLayoutInflater().inflate(2131560922, null);
      Object localObject4 = (URLImageView)((RelativeLayout)localObject3).findViewById(2131368138);
      TextView localTextView1 = (TextView)((RelativeLayout)localObject3).findViewById(2131371539);
      ImageView localImageView = (ImageView)((RelativeLayout)localObject3).findViewById(2131364290);
      TextView localTextView2 = (TextView)((RelativeLayout)localObject3).findViewById(2131365344);
      ((URLImageView)localObject4).post(new QidianProfileCardActivity.8.1(this, (bjhf)localObject2, (URLImageView)localObject4));
      localTextView1.setText(String.valueOf(((bjhf)localObject2).jdField_a_of_type_JavaLangString));
      ((RelativeLayout)localObject3).setOnClickListener(QidianProfileCardActivity.a(this.this$0));
      localTextView2.setText(anni.a(2131708512));
      ((RelativeLayout)localObject3).setTag(new azde(51, String.valueOf(((bjhf)localObject2).jdField_a_of_type_Long)));
      localImageView.setVisibility(8);
      localLinearLayout2.addView((View)localObject3, new LinearLayout.LayoutParams(0, -2, 1.0F));
      j += 1;
      break;
      label574:
      localObject3 = (RelativeLayout)this.this$0.getLayoutInflater().inflate(2131560922, null);
      localObject4 = (URLImageView)((RelativeLayout)localObject3).findViewById(2131368138);
      localTextView1 = (TextView)((RelativeLayout)localObject3).findViewById(2131371539);
      localImageView = (ImageView)((RelativeLayout)localObject3).findViewById(2131364290);
      localTextView2 = (TextView)((RelativeLayout)localObject3).findViewById(2131365344);
      ((URLImageView)localObject4).post(new QidianProfileCardActivity.8.2(this, (bjhg)localObject2, (URLImageView)localObject4));
      localTextView1.setText(((bjhg)localObject2).jdField_b_of_type_JavaLangString);
      ((RelativeLayout)localObject3).setOnClickListener(QidianProfileCardActivity.a(this.this$0));
      if (((bjhg)localObject2).jdField_a_of_type_Int == 0)
      {
        localTextView2.setText(2131697481);
        ((RelativeLayout)localObject3).setTag(new azde(49, ((bjhg)localObject2).jdField_a_of_type_JavaLangString));
        label714:
        if ((((bjhg)localObject2).jdField_a_of_type_Int != 0) || (((bjhg)localObject2).jdField_b_of_type_Int != 1)) {
          break label804;
        }
        localImageView.setVisibility(0);
        localImageView.setBackgroundResource(2130842600);
      }
      for (;;)
      {
        localLinearLayout2.addView((View)localObject3, new LinearLayout.LayoutParams(0, -2, 1.0F));
        i += 1;
        break;
        if (((bjhg)localObject2).jdField_a_of_type_Int != 1) {
          break label714;
        }
        localTextView2.setText(2131697482);
        ((RelativeLayout)localObject3).setTag(new azde(50, localObject2));
        break label714;
        label804:
        if ((((bjhg)localObject2).jdField_a_of_type_Int == 1) && (((bjhg)localObject2).jdField_b_of_type_Int == 1))
        {
          localImageView.setVisibility(0);
          localImageView.setBackgroundResource(2130844434);
        }
        else
        {
          localImageView.setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.8
 * JD-Core Version:    0.7.0.1
 */