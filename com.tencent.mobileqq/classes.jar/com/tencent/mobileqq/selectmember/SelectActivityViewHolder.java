package com.tencent.mobileqq.selectmember;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.troop.memberlist.TroopMemberList.ViewHolder;

public class SelectActivityViewHolder
  extends TroopMemberList.ViewHolder
{
  public View a;
  public CheckBox a;
  public TextView a;
  public PhoneContact a;
  public boolean a;
  public TextView b;
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 11;
    }
    if (!"0".equals(paramString)) {
      return 1;
    }
    return 11;
  }
  
  public static View a(ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, int paramInt)
  {
    paramViewGroup = paramLayoutInflater.inflate(paramInt, paramViewGroup, false);
    paramLayoutInflater = new SelectActivityViewHolder();
    paramViewGroup.setTag(paramLayoutInflater);
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131376702));
    paramLayoutInflater.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131379732));
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131364613));
    paramLayoutInflater.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368343));
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131379723));
    paramLayoutInflater.b = ((TextView)paramViewGroup.findViewById(2131379793));
    paramLayoutInflater.d = ((TextView)paramViewGroup.findViewById(2131371697));
    paramLayoutInflater.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131365713);
    return paramViewGroup;
  }
  
  public static void a(CharDividedFacePreloadBaseAdapter paramCharDividedFacePreloadBaseAdapter, SelectActivityViewHolder paramSelectActivityViewHolder, PhoneContact paramPhoneContact)
  {
    paramSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    paramSelectActivityViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    paramSelectActivityViewHolder.jdField_c_of_type_Int = a(paramPhoneContact.uin);
    if (TextUtils.isEmpty(paramPhoneContact.uin))
    {
      paramCharDividedFacePreloadBaseAdapter = new StringBuilder();
      paramCharDividedFacePreloadBaseAdapter.append("pstn");
      paramCharDividedFacePreloadBaseAdapter.append(paramPhoneContact.mobileNo);
      paramSelectActivityViewHolder.jdField_a_of_type_JavaLangString = paramCharDividedFacePreloadBaseAdapter.toString();
      paramSelectActivityViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842159);
      paramSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(CommonUtils.a(paramPhoneContact.name));
      paramSelectActivityViewHolder.jdField_a_of_type_Boolean = true;
      return;
    }
    if (!"0".equals(paramPhoneContact.uin))
    {
      paramSelectActivityViewHolder.jdField_a_of_type_JavaLangString = paramPhoneContact.uin;
      paramSelectActivityViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramCharDividedFacePreloadBaseAdapter.a(paramSelectActivityViewHolder.jdField_a_of_type_JavaLangString, 1, (byte)0));
      paramSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramSelectActivityViewHolder.jdField_a_of_type_Boolean = false;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramPhoneContact.nationCode);
    localStringBuilder.append(paramPhoneContact.mobileCode);
    paramSelectActivityViewHolder.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    paramSelectActivityViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramCharDividedFacePreloadBaseAdapter.a(paramSelectActivityViewHolder.jdField_a_of_type_JavaLangString, 11, (byte)0));
    paramSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramSelectActivityViewHolder.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectActivityViewHolder
 * JD-Core Version:    0.7.0.1
 */