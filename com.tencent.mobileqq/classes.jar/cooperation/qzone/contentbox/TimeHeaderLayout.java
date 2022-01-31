package cooperation.qzone.contentbox;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import baxt;
import bgxr;
import bhct;
import bhcu;
import bhxo;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportManager;
import mqq.app.AppRuntime;

public class TimeHeaderLayout
  extends LinearLayout
  implements View.OnClickListener
{
  public static String a;
  private Context jdField_a_of_type_AndroidContentContext;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  Handler jdField_a_of_type_AndroidOsHandler;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bhct jdField_a_of_type_Bhct;
  bhcu jdField_a_of_type_Bhcu;
  TextView b;
  TextView c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "capsule_open";
  }
  
  public TimeHeaderLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public TimeHeaderLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public TimeHeaderLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private String a()
  {
    String str2 = QzoneConfig.getInstance().getConfig("H5Url", "QzoneVisitor", "https://h5.qzone.qq.com/qzone/visitor/{hostUin}?uin={uin}&from={from}&qua={qua}&clicktime={clicktime}&hostuin={hostUin}&_wv=3&_proxy=1&trace_detail=%7B%22appid%22%3A%22{refer}%22%7D");
    if (TextUtils.isEmpty(str2)) {
      return str2;
    }
    String str3 = b();
    String str1 = str2;
    if (!TextUtils.isEmpty(str3)) {
      str1 = str2.replace("{uin}", str3).replace("{hostUin}", str3);
    }
    return str1.replace("{clicktime}", System.currentTimeMillis() + "").replace("{from}", "androidQQ").replace("{qua}", bgxr.a());
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    LayoutInflater.from(getContext()).inflate(2131561998, this, true);
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qzone_time_capsule", 0);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377271);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362939));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374514));
    this.b = ((TextView)findViewById(2131374023));
    this.c = ((TextView)findViewById(2131374584));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369058));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    findViewById(2131377271).setOnClickListener(this);
    bhxo.a(9, 1);
  }
  
  private void a(bhct parambhct)
  {
    LpReportInfo_dc02880 localLpReportInfo_dc02880 = new LpReportInfo_dc02880(7, 3);
    LpReportManager.getInstance().reportToDC02880(localLpReportInfo_dc02880, false, true);
    if ((this.jdField_a_of_type_Bhcu != null) && (parambhct != null)) {
      this.jdField_a_of_type_Bhcu.a(parambhct.jdField_a_of_type_JavaLangString, 2131377271);
    }
  }
  
  private String b()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      return localAppRuntime.getAccount();
    }
    return null;
  }
  
  private void b()
  {
    Object localObject = baxt.a(1, 3);
    localObject = baxt.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, 1, BaseApplicationImpl.getApplication().getRuntime().getAccount(), 3, (Drawable)localObject, (Drawable)localObject, null);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    if (this.jdField_a_of_type_Bhct != null)
    {
      if (this.jdField_a_of_type_Bhct.c <= 999L) {
        break label120;
      }
      this.c.setText("999+");
      if (this.jdField_a_of_type_Bhct.b <= 999L) {
        break label140;
      }
      this.b.setText("999+");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bhct.jdField_a_of_type_Long <= 9999L) {
        break label160;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText("9999+");
      return;
      label120:
      this.c.setText(String.valueOf(this.jdField_a_of_type_Bhct.c));
      break;
      label140:
      this.b.setText(String.valueOf(this.jdField_a_of_type_Bhct.b));
    }
    label160:
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_Bhct.jdField_a_of_type_Long));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      a(this.jdField_a_of_type_Bhct);
      return;
    } while (this.jdField_a_of_type_Bhcu == null);
    paramView = a();
    if (QLog.isColorLevel()) {
      QLog.i("QZoneMsg", 0, " jump url = " + paramView);
    }
    bhxo.a(9, 2);
    this.jdField_a_of_type_Bhcu.a(paramView, 2131369058);
  }
  
  public void setHeadInfo(bhct parambhct)
  {
    this.jdField_a_of_type_Bhct = parambhct;
    if (parambhct != null) {
      ThreadManagerV2.executeOnSubThread(new TimeHeaderLayout.1(this));
    }
  }
  
  public void setOnDetailClickListner(bhcu parambhcu)
  {
    this.jdField_a_of_type_Bhcu = parambhcu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.contentbox.TimeHeaderLayout
 * JD-Core Version:    0.7.0.1
 */