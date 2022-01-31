package com.tencent.qidian;

import ajya;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ausw;
import bdvr;
import bdvs;
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
    LinearLayout localLinearLayout1 = (LinearLayout)this.this$0.getLayoutInflater().inflate(2131560522, null);
    LinearLayout localLinearLayout2 = (LinearLayout)localLinearLayout1.findViewById(2131364656);
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
          localObject2 = (bdvr)((Iterator)localObject1).next();
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
            localObject2 = (bdvs)((Iterator)localObject1).next();
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
          localLinearLayout1 = (LinearLayout)this.this$0.getLayoutInflater().inflate(2131560521, null);
          localLinearLayout2 = (LinearLayout)localLinearLayout1.findViewById(2131364656);
          localObject1 = new PhotoWallViewForQiDianProfile(this.this$0.getApplicationContext());
          ((PhotoWallViewForQiDianProfile)localObject1).setPhotoWallCallback(this.this$0.jdField_a_of_type_Bdue);
          localObject2 = this.this$0.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getCompanyShowCaseInfos();
          ((PhotoWallViewForQiDianProfile)localObject1).a(this.this$0.getApplicationContext(), (List)localObject2);
          ((PhotoWallViewForQiDianProfile)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
          localLinearLayout2.addView((View)localObject1);
          this.this$0.b.addView(localLinearLayout1);
        }
        return;
        RelativeLayout localRelativeLayout = (RelativeLayout)this.this$0.getLayoutInflater().inflate(2131560523, null);
        URLImageView localURLImageView = (URLImageView)localRelativeLayout.findViewById(2131367679);
        TextView localTextView1 = (TextView)localRelativeLayout.findViewById(2131370647);
        ImageView localImageView = (ImageView)localRelativeLayout.findViewById(2131364022);
        TextView localTextView2 = (TextView)localRelativeLayout.findViewById(2131365017);
        localURLImageView.post(new QidianProfileCardActivity.8.1(this, (bdvr)localObject2, localURLImageView));
        localTextView1.setText(String.valueOf(((bdvr)localObject2).jdField_a_of_type_JavaLangString));
        localRelativeLayout.setOnClickListener(QidianProfileCardActivity.a(this.this$0));
        localTextView2.setText(ajya.a(2131709752));
        localRelativeLayout.setTag(new ausw(51, String.valueOf(((bdvr)localObject2).jdField_a_of_type_Long)));
        localImageView.setVisibility(8);
        localLinearLayout2.addView(localRelativeLayout, new LinearLayout.LayoutParams(0, -2, 1.0F));
        i += 1;
        break;
        localRelativeLayout = (RelativeLayout)this.this$0.getLayoutInflater().inflate(2131560523, null);
        localURLImageView = (URLImageView)localRelativeLayout.findViewById(2131367679);
        localTextView1 = (TextView)localRelativeLayout.findViewById(2131370647);
        localImageView = (ImageView)localRelativeLayout.findViewById(2131364022);
        localTextView2 = (TextView)localRelativeLayout.findViewById(2131365017);
        localURLImageView.post(new QidianProfileCardActivity.8.2(this, (bdvs)localObject2, localURLImageView));
        localTextView1.setText(((bdvs)localObject2).jdField_b_of_type_JavaLangString);
        localRelativeLayout.setOnClickListener(QidianProfileCardActivity.a(this.this$0));
        if (((bdvs)localObject2).jdField_a_of_type_Int == 0)
        {
          localTextView2.setText(2131698257);
          localRelativeLayout.setTag(new ausw(49, ((bdvs)localObject2).jdField_a_of_type_JavaLangString));
          if ((((bdvs)localObject2).jdField_a_of_type_Int != 0) || (((bdvs)localObject2).jdField_b_of_type_Int != 1)) {
            break label791;
          }
          localImageView.setVisibility(0);
          localImageView.setBackgroundResource(2130842124);
        }
        for (;;)
        {
          localLinearLayout2.addView(localRelativeLayout, new LinearLayout.LayoutParams(0, -2, 1.0F));
          i += 1;
          break;
          if (((bdvs)localObject2).jdField_a_of_type_Int != 1) {
            break label701;
          }
          localTextView2.setText(2131698258);
          localRelativeLayout.setTag(new ausw(50, localObject2));
          break label701;
          if ((((bdvs)localObject2).jdField_a_of_type_Int == 1) && (((bdvs)localObject2).jdField_b_of_type_Int == 1))
          {
            localImageView.setVisibility(0);
            localImageView.setBackgroundResource(2130843606);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.8
 * JD-Core Version:    0.7.0.1
 */