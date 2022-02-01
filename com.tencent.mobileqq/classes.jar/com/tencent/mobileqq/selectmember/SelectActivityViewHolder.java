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
  public CheckBox a;
  public PhoneContact b;
  public TextView c;
  public boolean d;
  public TextView e;
  public View f;
  
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
    paramLayoutInflater.g = ((RelativeLayout)paramViewGroup.findViewById(2131444983));
    paramLayoutInflater.h = ((TextView)paramViewGroup.findViewById(2131448537));
    paramLayoutInflater.a = ((CheckBox)paramViewGroup.findViewById(2131430688));
    paramLayoutInflater.A = ((ImageView)paramViewGroup.findViewById(2131435219));
    paramLayoutInflater.c = ((TextView)paramViewGroup.findViewById(2131448522));
    paramLayoutInflater.e = ((TextView)paramViewGroup.findViewById(2131448620));
    paramLayoutInflater.i = ((TextView)paramViewGroup.findViewById(2131439121));
    paramLayoutInflater.f = paramViewGroup.findViewById(2131431955);
    return paramViewGroup;
  }
  
  public static void a(CharDividedFacePreloadBaseAdapter paramCharDividedFacePreloadBaseAdapter, SelectActivityViewHolder paramSelectActivityViewHolder, PhoneContact paramPhoneContact)
  {
    paramSelectActivityViewHolder.g.setVisibility(0);
    paramSelectActivityViewHolder.h.setVisibility(8);
    paramSelectActivityViewHolder.z = a(paramPhoneContact.uin);
    if (TextUtils.isEmpty(paramPhoneContact.uin))
    {
      paramCharDividedFacePreloadBaseAdapter = new StringBuilder();
      paramCharDividedFacePreloadBaseAdapter.append("pstn");
      paramCharDividedFacePreloadBaseAdapter.append(paramPhoneContact.mobileNo);
      paramSelectActivityViewHolder.y = paramCharDividedFacePreloadBaseAdapter.toString();
      paramSelectActivityViewHolder.A.setImageResource(2130843087);
      paramSelectActivityViewHolder.c.setVisibility(0);
      paramSelectActivityViewHolder.c.setText(CommonUtils.a(paramPhoneContact.name));
      paramSelectActivityViewHolder.d = true;
      return;
    }
    if (!"0".equals(paramPhoneContact.uin))
    {
      paramSelectActivityViewHolder.y = paramPhoneContact.uin;
      paramSelectActivityViewHolder.A.setImageBitmap(paramCharDividedFacePreloadBaseAdapter.a(paramSelectActivityViewHolder.y, 1, (byte)0));
      paramSelectActivityViewHolder.c.setVisibility(8);
      paramSelectActivityViewHolder.d = false;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramPhoneContact.nationCode);
    localStringBuilder.append(paramPhoneContact.mobileCode);
    paramSelectActivityViewHolder.y = localStringBuilder.toString();
    paramSelectActivityViewHolder.A.setImageBitmap(paramCharDividedFacePreloadBaseAdapter.a(paramSelectActivityViewHolder.y, 11, (byte)0));
    paramSelectActivityViewHolder.c.setVisibility(8);
    paramSelectActivityViewHolder.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectActivityViewHolder
 * JD-Core Version:    0.7.0.1
 */