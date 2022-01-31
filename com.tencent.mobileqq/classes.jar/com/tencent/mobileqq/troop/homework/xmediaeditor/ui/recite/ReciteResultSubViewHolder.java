package com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite;

import ajls;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment;
import com.tencent.mobileqq.troop.homework.recite.utils.HWReciteUtils;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.HWReciteInfo;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.DecimalFormat;
import java.util.List;
import org.json.JSONObject;

public class ReciteResultSubViewHolder
  extends ReciteSubViewHolderBase
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130841401, 2130841400, 2130841398 };
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "完美", "优秀", "良好" };
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("#.##");
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView d;
  private TextView e;
  
  public ReciteResultSubViewHolder(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368466));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131368487);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368482));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368483));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368477));
    this.d = ((TextView)paramView.findViewById(2131368478));
    this.e = ((TextView)paramView.findViewById(2131368489));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368488));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365272));
  }
  
  private void a()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.e.setVisibility(0);
    ((AnimationDrawable)this.jdField_b_of_type_AndroidWidgetImageView.getDrawable()).start();
  }
  
  private void b()
  {
    AnimationDrawable localAnimationDrawable = (AnimationDrawable)this.jdField_b_of_type_AndroidWidgetImageView.getDrawable();
    localAnimationDrawable.stop();
    localAnimationDrawable.selectDrawable(0);
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem, ajls paramajls)
  {
    paramajls = (HWReciteInfo)paramajls.a;
    switch (paramView.getId())
    {
    default: 
    case 2131368486: 
    case 2131368487: 
      do
      {
        return;
        ReciteFragment.a(paramView.getContext(), paramajls.a().toString(), paramajls.jdField_c_of_type_Int);
        return;
        if (paramajls.jdField_a_of_type_Boolean)
        {
          paramHWReciteItem.b();
          b();
          return;
        }
      } while (TextUtils.isEmpty(paramajls.jdField_d_of_type_JavaLangString));
      if (QLog.isColorLevel()) {
        QLog.d("ReciteResultSubViewHolder", 2, new Object[] { "onItemViewClick, play audio, filePath = ", paramajls.jdField_d_of_type_JavaLangString });
      }
      paramHWReciteItem.e(paramajls);
      a();
      TroopReportor.a("Grp_edu", "Grp_recite", "Finish_Recite_Play_Clk", 0, 0, new String[] { paramajls.jdField_f_of_type_JavaLangString });
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHWReciteItem.b(paramajls);
  }
  
  public void a(HWReciteItem paramHWReciteItem, ajls paramajls, HWReciteInfo paramHWReciteInfo, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (TextUtils.isEmpty(paramHWReciteInfo.jdField_c_of_type_JavaLangString))
    {
      StringBuilder localStringBuilder = new StringBuilder("在线背诵").append(paramHWReciteInfo.jdField_b_of_type_JavaLangString);
      if ((paramHWReciteInfo.jdField_a_of_type_JavaUtilList != null) && (!paramHWReciteInfo.jdField_a_of_type_JavaUtilList.isEmpty())) {
        localStringBuilder.append(HWReciteUtils.a(paramHWReciteInfo.jdField_a_of_type_JavaUtilList));
      }
      paramHWReciteInfo.jdField_c_of_type_JavaLangString = localStringBuilder.toString();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramHWReciteInfo.jdField_c_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramHWReciteInfo.jdField_d_of_type_Int));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(String.valueOf(paramHWReciteInfo.jdField_e_of_type_Int));
    this.e.setText(String.format("%s\"", new Object[] { this.jdField_a_of_type_JavaTextDecimalFormat.format(paramHWReciteInfo.jdField_a_of_type_Long) }));
    if ((paramHWReciteInfo.jdField_f_of_type_Int > -1) && (paramHWReciteInfo.jdField_f_of_type_Int < jdField_a_of_type_ArrayOfInt.length))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(jdField_a_of_type_ArrayOfInt[paramHWReciteInfo.jdField_f_of_type_Int]);
      this.d.setText(jdField_a_of_type_ArrayOfJavaLangString[paramHWReciteInfo.jdField_f_of_type_Int]);
    }
    if ((!TextUtils.isEmpty(paramHWReciteInfo.jdField_d_of_type_JavaLangString)) && (new File(paramHWReciteInfo.jdField_d_of_type_JavaLangString).exists()))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.e.setVisibility(0);
      if (!paramHWReciteInfo.jdField_a_of_type_Boolean) {
        break label360;
      }
      a();
      label249:
      if (paramHWReciteInfo.g != 2) {
        break label367;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      paramHWReciteItem.b(this.jdField_a_of_type_AndroidViewView, paramajls);
      paramHWReciteItem.b(this.jdField_b_of_type_AndroidViewView, paramajls);
      paramHWReciteItem.b(this.jdField_c_of_type_AndroidWidgetImageView, paramajls);
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.e.setVisibility(8);
      if ((TextUtils.isEmpty(paramHWReciteInfo.jdField_e_of_type_JavaLangString)) || (paramHWReciteInfo.jdField_b_of_type_Int != 0)) {
        break;
      }
      paramHWReciteItem.d(paramHWReciteInfo);
      if (paramHWReciteInfo.jdField_b_of_type_Int != 2) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.e.setVisibility(0);
      break;
      label360:
      b();
      break label249;
      label367:
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.ReciteResultSubViewHolder
 * JD-Core Version:    0.7.0.1
 */