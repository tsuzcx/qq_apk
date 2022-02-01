package com.tencent.mobileqq.qqexpand.widget.chat;

import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class HotProtectDialog
  extends QQCustomDialog
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public HotProtectDialog(@NonNull QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity, 2131756189);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    a();
  }
  
  private void a()
  {
    try
    {
      View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).inflate(2131561057, null);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131363145));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371862));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131372968));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131371749));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378460));
      setContentView(localView);
      setCancelable(false);
      return;
    }
    catch (InflateException localInflateException)
    {
      label90:
      break label90;
    }
    hide();
    QLog.e("HotProtectDialog", 1, "InflateException, OutOfMemoryError, hide HotProtectDialog");
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
  }
  
  public void a(@NonNull String paramString)
  {
    paramString = FaceDrawable.getStrangerFaceDrawable((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null), 200, paramString, true);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
  }
  
  public void b(@NonNull String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void c(@NonNull String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.chat.HotProtectDialog
 * JD-Core Version:    0.7.0.1
 */