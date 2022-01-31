package com.tencent.qidian;

import ajyc;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ausu;
import bdva;
import bdvb;
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
    LinearLayout localLinearLayout1 = (LinearLayout)this.this$0.getLayoutInflater().inflate(2131560523, null);
    LinearLayout localLinearLayout2 = (LinearLayout)localLinearLayout1.findViewById(2131364657);
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
          localObject2 = (bdva)((Iterator)localObject1).next();
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
            localObject2 = (bdvb)((Iterator)localObject1).next();
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
          localLinearLayout1 = (LinearLayout)this.this$0.getLayoutInflater().inflate(2131560522, null);
          localLinearLayout2 = (LinearLayout)localLinearLayout1.findViewById(2131364657);
          localObject1 = new PhotoWallViewForQiDianProfile(this.this$0.getApplicationContext());
          ((PhotoWallViewForQiDianProfile)localObject1).setPhotoWallCallback(this.this$0.jdField_a_of_type_Bdtn);
          localObject2 = this.this$0.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getCompanyShowCaseInfos();
          ((PhotoWallViewForQiDianProfile)localObject1).a(this.this$0.getApplicationContext(), (List)localObject2);
          ((PhotoWallViewForQiDianProfile)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
          localLinearLayout2.addView((View)localObject1);
          this.this$0.b.addView(localLinearLayout1);
        }
        return;
        RelativeLayout localRelativeLayout = (RelativeLayout)this.this$0.getLayoutInflater().inflate(2131560524, null);
        URLImageView localURLImageView = (URLImageView)localRelativeLayout.findViewById(2131367679);
        TextView localTextView1 = (TextView)localRelativeLayout.findViewById(2131370647);
        ImageView localImageView = (ImageView)localRelativeLayout.findViewById(2131364023);
        TextView localTextView2 = (TextView)localRelativeLayout.findViewById(2131365018);
        localURLImageView.post(new QidianProfileCardActivity.8.1(this, (bdva)localObject2, localURLImageView));
        localTextView1.setText(String.valueOf(((bdva)localObject2).jdField_a_of_type_JavaLangString));
        localRelativeLayout.setOnClickListener(QidianProfileCardActivity.a(this.this$0));
        localTextView2.setText(ajyc.a(2131709741));
        localRelativeLayout.setTag(new ausu(51, String.valueOf(((bdva)localObject2).jdField_a_of_type_Long)));
        localImageView.setVisibility(8);
        localLinearLayout2.addView(localRelativeLayout, new LinearLayout.LayoutParams(0, -2, 1.0F));
        i += 1;
        break;
        localRelativeLayout = (RelativeLayout)this.this$0.getLayoutInflater().inflate(2131560524, null);
        localURLImageView = (URLImageView)localRelativeLayout.findViewById(2131367679);
        localTextView1 = (TextView)localRelativeLayout.findViewById(2131370647);
        localImageView = (ImageView)localRelativeLayout.findViewById(2131364023);
        localTextView2 = (TextView)localRelativeLayout.findViewById(2131365018);
        localURLImageView.post(new QidianProfileCardActivity.8.2(this, (bdvb)localObject2, localURLImageView));
        localTextView1.setText(((bdvb)localObject2).jdField_b_of_type_JavaLangString);
        localRelativeLayout.setOnClickListener(QidianProfileCardActivity.a(this.this$0));
        if (((bdvb)localObject2).jdField_a_of_type_Int == 0)
        {
          localTextView2.setText(2131698247);
          localRelativeLayout.setTag(new ausu(49, ((bdvb)localObject2).jdField_a_of_type_JavaLangString));
          if ((((bdvb)localObject2).jdField_a_of_type_Int != 0) || (((bdvb)localObject2).jdField_b_of_type_Int != 1)) {
            break label791;
          }
          localImageView.setVisibility(0);
          localImageView.setBackgroundResource(2130842123);
        }
        for (;;)
        {
          localLinearLayout2.addView(localRelativeLayout, new LinearLayout.LayoutParams(0, -2, 1.0F));
          i += 1;
          break;
          if (((bdvb)localObject2).jdField_a_of_type_Int != 1) {
            break label701;
          }
          localTextView2.setText(2131698248);
          localRelativeLayout.setTag(new ausu(50, localObject2));
          break label701;
          if ((((bdvb)localObject2).jdField_a_of_type_Int == 1) && (((bdvb)localObject2).jdField_b_of_type_Int == 1))
          {
            localImageView.setVisibility(0);
            localImageView.setBackgroundResource(2130843605);
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