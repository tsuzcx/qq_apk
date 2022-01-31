package com.tencent.mobileqq.tribe.view;

import aifb;
import android.app.Activity;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.EditVideoButton;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import com.tencent.biz.qqstory.view.widget.VerticalImageSpan;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;

public class TribeEditVideoButton
  extends EditVideoButton
{
  private View jdField_a_of_type_AndroidViewView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int = -1;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = "barindex";
  
  public TribeEditVideoButton(EditVideoPartManager paramEditVideoPartManager, int paramInt)
  {
    super(paramEditVideoPartManager, paramInt);
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      int i = paramIntent.getIntExtra("theme_id", -1);
      paramIntent = paramIntent.getStringExtra("theme_name");
      this.jdField_b_of_type_Int = i;
      if (i == -1)
      {
        a("#添加话题");
        this.jdField_a_of_type_JavaLangString = "";
      }
      while (QLog.isColorLevel())
      {
        QLog.d("TribeEditVideoButton", 2, "handleSelectedTheme mThemeID = " + this.jdField_b_of_type_Int + " mThemeName = " + this.jdField_a_of_type_JavaLangString);
        return;
        if (paramIntent != null)
        {
          a("#" + paramIntent);
          this.jdField_a_of_type_JavaLangString = paramIntent;
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    int i = -1;
    paramString = new SpannableString(paramString);
    if (this.jdField_b_of_type_Int == -1) {}
    for (;;)
    {
      paramString.setSpan(new VerticalImageSpan(a(), 2130840601), 0, 1, 33);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
      return;
      i = -18432;
    }
  }
  
  private void e()
  {
    if ((this.jdField_b_of_type_Int != -1) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      a("#" + this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(16.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aifb(this));
      return;
      a("#添加话题");
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131364400));
    this.jdField_a_of_type_AndroidViewView = ((ImageView)a(2131364403));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131364428));
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    a(2131371908).setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("下一步");
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(a());
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(DisplayUtil.a(a(), 192.0F));
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    int i = DisplayUtil.a(a(), 10.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130840602);
    Object localObject = new RelativeLayout.LayoutParams(-2, DisplayUtil.a(a(), 28.0F));
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(a(), 10.0F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    localObject = ((Activity)a()).getIntent();
    boolean bool = ((Intent)localObject).getBooleanExtra("needTheme", false);
    this.jdField_b_of_type_JavaLangString = ((Intent)localObject).getStringExtra("from");
    this.jdField_b_of_type_Int = ((Intent)localObject).getIntExtra("theme_id", -1);
    this.jdField_a_of_type_JavaLangString = ((Intent)localObject).getStringExtra("theme_name");
    if (QLog.isColorLevel()) {
      QLog.d("TribeEditVideoButton", 2, "onCreate mThemeID = " + this.jdField_b_of_type_Int + " mThemeName = " + this.jdField_a_of_type_JavaLangString);
    }
    e();
    if (!bool) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    }
    a(paramIntent);
  }
  
  public void onClick(View paramView)
  {
    int j = 1;
    int k = 1;
    int m = 1;
    int i = 1;
    super.onClick(paramView);
    int n = paramView.getId();
    switch (this.jdField_a_of_type_AndroidUtilSparseIntArray.get(n))
    {
    default: 
      return;
    case 4: 
      if ("barindex".equals(this.jdField_b_of_type_JavaLangString)) {}
      for (;;)
      {
        ReportController.b(null, "dc00899", "Grp_tribe", "", "video_edit", "Clk_text", i, 0, "", "", "", "");
        return;
        i = 2;
      }
    case 1: 
      if ("barindex".equals(this.jdField_b_of_type_JavaLangString)) {}
      for (i = j;; i = 2)
      {
        ReportController.b(null, "dc00899", "Grp_tribe", "", "video_edit", "Clk_graffiti", i, 0, "", "", "", "");
        return;
      }
    case 8: 
      if ("barindex".equals(this.jdField_b_of_type_JavaLangString)) {}
      for (i = k;; i = 2)
      {
        ReportController.b(null, "dc00899", "Grp_tribe", "", "video_edit", "Clk_face", i, 0, "", "", "", "");
        return;
      }
    }
    if ("barindex".equals(this.jdField_b_of_type_JavaLangString)) {}
    for (i = m;; i = 2)
    {
      ReportController.b(null, "dc00899", "Grp_tribe", "", "video_edit", "Clk_music", i, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.view.TribeEditVideoButton
 * JD-Core Version:    0.7.0.1
 */