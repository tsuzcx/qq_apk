package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.widget.VerticalImageSpan;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tribe.takevideo.TribePublishLauncher;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class DovTribeEditVideoButton
  extends EditVideoButton
{
  public static final String a;
  private static final String jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131703510);
  private View jdField_a_of_type_AndroidViewView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int = -1;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private String d = "barindex";
  
  static
  {
    jdField_a_of_type_JavaLangString = DovTribeEditVideoButton.class.getSimpleName();
  }
  
  public DovTribeEditVideoButton(EditVideoPartManager paramEditVideoPartManager, int paramInt)
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
      this.jdField_c_of_type_Int = i;
      if (i == -1)
      {
        b(jdField_b_of_type_JavaLangString);
        this.jdField_c_of_type_JavaLangString = "";
      }
      while (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleSelectedTheme mThemeID = " + this.jdField_c_of_type_Int + " mThemeName = " + this.jdField_c_of_type_JavaLangString);
        return;
        if (paramIntent != null)
        {
          b("#" + paramIntent);
          this.jdField_c_of_type_JavaLangString = paramIntent;
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    if ("barindex".equals(this.d)) {}
    for (int i = 1;; i = 2)
    {
      ReportController.b(null, "dc00899", "Grp_tribe", "", "video_edit", paramString, i, 0, "", "", "", "");
      return;
    }
  }
  
  private void b(String paramString)
  {
    int i = -1;
    paramString = new SpannableString(paramString);
    if (this.jdField_c_of_type_Int == -1) {}
    for (;;)
    {
      paramString.setSpan(new VerticalImageSpan(a(), 2130842780), 0, 1, 33);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i);
      return;
      i = -18432;
    }
  }
  
  private void d()
  {
    if ((this.jdField_c_of_type_Int != -1) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
      b("#" + this.jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(16.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new DovTribeEditVideoButton.1(this));
      return;
      b(jdField_b_of_type_JavaLangString);
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131364267));
    this.jdField_a_of_type_AndroidViewView = ((ImageView)a(2131379680));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131365359));
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131703509));
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(a());
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(DisplayUtil.a(a(), 192.0F));
    this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(true);
    int i = DisplayUtil.a(a(), 10.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130842781);
    Object localObject = new RelativeLayout.LayoutParams(-2, DisplayUtil.a(a(), 28.0F));
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(a(), 10.0F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    localObject = TribePublishLauncher.a(((EditVideoParams)((Activity)a()).getIntent().getParcelableExtra(EditVideoParams.class.getName())).a);
    if (localObject != null)
    {
      boolean bool = ((JSONObject)localObject).optBoolean("needTheme", false);
      this.d = ((JSONObject)localObject).optString("from", "");
      this.jdField_c_of_type_Int = ((JSONObject)localObject).optInt("theme_id", -1);
      this.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("theme_name", "");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreate mThemeID = " + this.jdField_c_of_type_Int + " mThemeName = " + this.jdField_c_of_type_JavaLangString);
      }
      d();
      if (!bool) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.DovTribeEditVideoButton
 * JD-Core Version:    0.7.0.1
 */