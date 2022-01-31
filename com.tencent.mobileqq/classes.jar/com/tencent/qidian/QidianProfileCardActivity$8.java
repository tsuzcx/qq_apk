package com.tencent.qidian;

import alpo;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import awki;
import bfvm;
import bfvn;
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
    int j = 0;
    LinearLayout localLinearLayout1 = (LinearLayout)this.this$0.getLayoutInflater().inflate(2131560698, null);
    LinearLayout localLinearLayout2 = (LinearLayout)localLinearLayout1.findViewById(2131364735);
    int i = j;
    Object localObject1;
    Object localObject2;
    if (this.this$0.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null)
    {
      i = j;
      if (this.this$0.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getGroupItems() != null)
      {
        i = j;
        if (this.this$0.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getGroupItems().size() > 0)
        {
          localObject1 = this.this$0.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getGroupItems().iterator();
          i = 0;
          if (!((Iterator)localObject1).hasNext()) {
            break label840;
          }
          localObject2 = (bfvm)((Iterator)localObject1).next();
          if (i < 4) {
            break label388;
          }
        }
      }
    }
    label388:
    label561:
    label701:
    label835:
    label840:
    for (;;)
    {
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
            if (!((Iterator)localObject1).hasNext()) {
              break label835;
            }
            localObject2 = (bfvn)((Iterator)localObject1).next();
            if (i < 4) {
              break label561;
            }
          }
        }
      }
      for (j = i;; j = i)
      {
        if (j > 0) {
          this.this$0.b.addView(localLinearLayout1);
        }
        if ((this.this$0.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null) && (this.this$0.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getCompanyShowCaseInfos() != null) && (this.this$0.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getCompanyShowCaseInfos().size() > 0))
        {
          localLinearLayout1 = (LinearLayout)this.this$0.getLayoutInflater().inflate(2131560697, null);
          localLinearLayout2 = (LinearLayout)localLinearLayout1.findViewById(2131364735);
          localObject1 = new PhotoWallViewForQiDianProfile(this.this$0.getApplicationContext());
          ((PhotoWallViewForQiDianProfile)localObject1).setPhotoWallCallback(this.this$0.jdField_a_of_type_Bftz);
          localObject2 = this.this$0.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getCompanyShowCaseInfos();
          ((PhotoWallViewForQiDianProfile)localObject1).a(this.this$0.getApplicationContext(), (List)localObject2);
          ((PhotoWallViewForQiDianProfile)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
          localLinearLayout2.addView((View)localObject1);
          this.this$0.b.addView(localLinearLayout1);
        }
        return;
        RelativeLayout localRelativeLayout = (RelativeLayout)this.this$0.getLayoutInflater().inflate(2131560699, null);
        URLImageView localURLImageView = (URLImageView)localRelativeLayout.findViewById(2131367808);
        TextView localTextView1 = (TextView)localRelativeLayout.findViewById(2131370958);
        ImageView localImageView = (ImageView)localRelativeLayout.findViewById(2131364083);
        TextView localTextView2 = (TextView)localRelativeLayout.findViewById(2131365102);
        localURLImageView.post(new QidianProfileCardActivity.8.1(this, (bfvm)localObject2, localURLImageView));
        localTextView1.setText(String.valueOf(((bfvm)localObject2).jdField_a_of_type_JavaLangString));
        localRelativeLayout.setOnClickListener(QidianProfileCardActivity.a(this.this$0));
        localTextView2.setText(alpo.a(2131710124));
        localRelativeLayout.setTag(new awki(51, String.valueOf(((bfvm)localObject2).jdField_a_of_type_Long)));
        localImageView.setVisibility(8);
        localLinearLayout2.addView(localRelativeLayout, new LinearLayout.LayoutParams(0, -2, 1.0F));
        i += 1;
        break;
        localRelativeLayout = (RelativeLayout)this.this$0.getLayoutInflater().inflate(2131560699, null);
        localURLImageView = (URLImageView)localRelativeLayout.findViewById(2131367808);
        localTextView1 = (TextView)localRelativeLayout.findViewById(2131370958);
        localImageView = (ImageView)localRelativeLayout.findViewById(2131364083);
        localTextView2 = (TextView)localRelativeLayout.findViewById(2131365102);
        localURLImageView.post(new QidianProfileCardActivity.8.2(this, (bfvn)localObject2, localURLImageView));
        localTextView1.setText(((bfvn)localObject2).jdField_b_of_type_JavaLangString);
        localRelativeLayout.setOnClickListener(QidianProfileCardActivity.a(this.this$0));
        if (((bfvn)localObject2).jdField_a_of_type_Int == 0)
        {
          localTextView2.setText(2131698547);
          localRelativeLayout.setTag(new awki(49, ((bfvn)localObject2).jdField_a_of_type_JavaLangString));
          if ((((bfvn)localObject2).jdField_a_of_type_Int != 0) || (((bfvn)localObject2).jdField_b_of_type_Int != 1)) {
            break label791;
          }
          localImageView.setVisibility(0);
          localImageView.setBackgroundResource(2130842277);
        }
        for (;;)
        {
          localLinearLayout2.addView(localRelativeLayout, new LinearLayout.LayoutParams(0, -2, 1.0F));
          i += 1;
          break;
          if (((bfvn)localObject2).jdField_a_of_type_Int != 1) {
            break label701;
          }
          localTextView2.setText(2131698548);
          localRelativeLayout.setTag(new awki(50, localObject2));
          break label701;
          if ((((bfvn)localObject2).jdField_a_of_type_Int == 1) && (((bfvn)localObject2).jdField_b_of_type_Int == 1))
          {
            localImageView.setVisibility(0);
            localImageView.setBackgroundResource(2130843965);
          }
          else
          {
            localImageView.setVisibility(8);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.8
 * JD-Core Version:    0.7.0.1
 */