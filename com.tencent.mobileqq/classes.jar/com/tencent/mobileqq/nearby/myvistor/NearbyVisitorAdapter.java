package com.tencent.mobileqq.nearby.myvistor;

import aeeh;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.nearby.NearbyFlowerUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.IIconDecoder;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NearbyVisitorAdapter
  extends PinnedHeaderExpandableListView.ExpandableListAdapter
{
  protected float a;
  protected int a;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  protected ColorStateList a;
  protected BitmapDrawable a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  protected FaceDecoder a;
  protected IIconDecoder a;
  protected StringBuilder a;
  List jdField_a_of_type_JavaUtilList;
  public boolean a;
  protected int b;
  long jdField_b_of_type_Long;
  protected ColorStateList b;
  protected StringBuilder b;
  List jdField_b_of_type_JavaUtilList;
  protected StringBuilder c;
  List c;
  protected StringBuilder d;
  List d;
  protected StringBuilder e = new StringBuilder();
  
  public NearbyVisitorAdapter(Context paramContext, View.OnClickListener paramOnClickListener, IIconDecoder paramIIconDecoder, FaceDecoder paramFaceDecoder)
  {
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_d_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder = paramIIconDecoder;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_d_of_type_JavaUtilList = new LinkedList();
    this.jdField_b_of_type_JavaUtilList = new LinkedList();
    this.jdField_c_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
  }
  
  private void a(NearbyVisitorAdapter.ChildItemHolder paramChildItemHolder, StrangerInfo paramStrangerInfo)
  {
    SingleLineTextView localSingleLineTextView = paramChildItemHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView;
    if ((paramStrangerInfo.strangerDeclare != null) && (paramStrangerInfo.strangerDeclare.length > 0)) {}
    for (paramStrangerInfo = RichStatus.parseStatus(paramStrangerInfo.strangerDeclare);; paramStrangerInfo = null)
    {
      if ((paramStrangerInfo != null) && (!paramStrangerInfo.isEmpty()))
      {
        if (!TextUtils.isEmpty(paramStrangerInfo.actionText)) {
          a(localSingleLineTextView, paramStrangerInfo.actionId);
        }
        for (;;)
        {
          paramChildItemHolder.jdField_b_of_type_Int = paramStrangerInfo.actionId;
          localSingleLineTextView.setText(paramStrangerInfo.toSpannableString(null));
          localSingleLineTextView.setVisibility(0);
          return;
          localSingleLineTextView.setCompoundDrawables(null, null);
        }
      }
      paramChildItemHolder.jdField_b_of_type_Int = 0;
      localSingleLineTextView.setVisibility(8);
      return;
    }
  }
  
  public int a()
  {
    return 2130970447;
  }
  
  public StrangerInfo a(int paramInt1, int paramInt2)
  {
    return (StrangerInfo)((List)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).get(paramInt2);
  }
  
  public String a(int paramInt)
  {
    return (String)this.jdField_d_of_type_JavaUtilList.get(paramInt);
  }
  
  protected String a(StrangerInfo paramStrangerInfo)
  {
    if ((paramStrangerInfo != null) && (paramStrangerInfo.lableId == 5) && (paramStrangerInfo.interestNames != null) && (paramStrangerInfo.interestTypes != null))
    {
      this.e.append("共同爱好：");
      this.jdField_d_of_type_JavaLangStringBuilder.setLength(0);
      this.jdField_c_of_type_JavaLangStringBuilder.setLength(0);
      ArrayList localArrayList = paramStrangerInfo.interestNames;
      paramStrangerInfo = paramStrangerInfo.interestTypes;
      int i = 0;
      int j = 0;
      if (i < localArrayList.size())
      {
        int k = j;
        if (i == 0)
        {
          k = j;
          if (((Integer)paramStrangerInfo.get(0)).intValue() == 1) {
            k = 1;
          }
        }
        if (((Integer)paramStrangerInfo.get(i)).intValue() == 1)
        {
          if (this.jdField_d_of_type_JavaLangStringBuilder.length() > 0) {
            this.jdField_d_of_type_JavaLangStringBuilder.append("、");
          }
          this.jdField_d_of_type_JavaLangStringBuilder.append((String)localArrayList.get(i));
        }
        for (;;)
        {
          i += 1;
          j = k;
          break;
          if (((Integer)paramStrangerInfo.get(i)).intValue() == 2)
          {
            if (this.jdField_c_of_type_JavaLangStringBuilder.length() > 0) {
              this.jdField_c_of_type_JavaLangStringBuilder.append("、");
            }
            String str = (String)localArrayList.get(i);
            if (str.startsWith("爱")) {
              this.jdField_c_of_type_JavaLangStringBuilder.append(str.substring("爱".length()));
            } else {
              this.jdField_c_of_type_JavaLangStringBuilder.append(str);
            }
          }
          else
          {
            if (this.jdField_c_of_type_JavaLangStringBuilder.length() > 0) {
              this.jdField_c_of_type_JavaLangStringBuilder.append("、");
            }
            this.jdField_c_of_type_JavaLangStringBuilder.append((String)localArrayList.get(i));
          }
        }
      }
      if (j != 0)
      {
        if (this.jdField_d_of_type_JavaLangStringBuilder.length() > 0)
        {
          this.e.append("去过").append(this.jdField_d_of_type_JavaLangStringBuilder);
          if (this.jdField_c_of_type_JavaLangStringBuilder.length() > 0) {
            this.e.append("；");
          }
        }
        if (this.jdField_c_of_type_JavaLangStringBuilder.length() > 0) {
          this.e.append("喜欢").append(this.jdField_c_of_type_JavaLangStringBuilder);
        }
      }
      for (;;)
      {
        return this.e.toString();
        if (this.jdField_c_of_type_JavaLangStringBuilder.length() > 0)
        {
          this.e.append("喜欢").append(this.jdField_c_of_type_JavaLangStringBuilder);
          if (this.jdField_d_of_type_JavaLangStringBuilder.length() > 0) {
            this.e.append("；");
          }
        }
        if (this.jdField_d_of_type_JavaLangStringBuilder.length() > 0) {
          this.e.append(this.jdField_d_of_type_JavaLangStringBuilder);
        }
      }
    }
    return null;
  }
  
  protected void a(int paramInt1, int paramInt2, NearbyVisitorAdapter.ChildItemHolder paramChildItemHolder)
  {
    this.jdField_b_of_type_JavaLangStringBuilder.setLength(0);
    StrangerInfo localStrangerInfo = a(paramInt1, paramInt2);
    paramChildItemHolder.jdField_a_of_type_ComTencentMobileqqDataStrangerInfo = localStrangerInfo;
    Object localObject1;
    label171:
    label228:
    int i;
    Object localObject2;
    label408:
    Object localObject3;
    if (localStrangerInfo.tinyId > 0L)
    {
      paramChildItemHolder.jdField_a_of_type_JavaLangString = String.valueOf(localStrangerInfo.tinyId);
      paramChildItemHolder.jdField_a_of_type_Int = 32;
      paramChildItemHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(Boolean.valueOf(false));
      a(localStrangerInfo, paramChildItemHolder.jdField_a_of_type_AndroidWidgetImageView);
      paramChildItemHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      if (localStrangerInfo.godFlag != 1) {
        break label1467;
      }
      paramChildItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramChildItemHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (localStrangerInfo.gender != 1) {
        break label1407;
      }
      paramChildItemHolder.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130843038);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842744);
      paramChildItemHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(TroopUtils.a(this.jdField_a_of_type_AndroidContentContext.getResources(), -17883, (Drawable)localObject1));
      paramChildItemHolder.jdField_b_of_type_AndroidWidgetTextView.setText("女神");
      paramChildItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      if (TextUtils.isEmpty(localStrangerInfo.nickName)) {
        break label1479;
      }
      paramChildItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localStrangerInfo.nickName.trim());
      if (AppSetting.b) {
        this.jdField_b_of_type_JavaLangStringBuilder.append(localStrangerInfo.nickName.trim());
      }
      i = this.jdField_a_of_type_Int - (int)(189.0F * this.jdField_a_of_type_Float);
      paramInt2 = i;
      if (!TextUtils.isEmpty(localStrangerInfo.vipInfo))
      {
        paramInt1 = i;
        if ("svip".equalsIgnoreCase(localStrangerInfo.vipInfo)) {
          paramInt1 = i - (int)Math.ceil(33.5F * this.jdField_a_of_type_Float);
        }
        paramInt2 = paramInt1;
        if ("vip".equalsIgnoreCase(localStrangerInfo.vipInfo)) {
          paramInt2 = paramInt1 - (int)Math.ceil(28.5F * this.jdField_a_of_type_Float);
        }
      }
      paramChildItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setMaxWidth(paramInt2);
      paramChildItemHolder.jdField_c_of_type_ComTencentWidgetSingleLineTextView.setText(localStrangerInfo.timeStr);
      paramChildItemHolder.jdField_c_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      paramChildItemHolder.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
      paramInt1 = 0;
      if (localStrangerInfo.gender != -1)
      {
        localObject1 = null;
        paramInt1 = 0;
        localObject2 = " ";
      }
      switch (localStrangerInfo.gender)
      {
      default: 
        if (localStrangerInfo.age > 0)
        {
          if (AppSetting.b) {
            this.jdField_b_of_type_JavaLangStringBuilder.append(",").append(localStrangerInfo.age).append("岁");
          }
          localObject2 = String.valueOf(localStrangerInfo.age);
        }
        localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        NearbyUtils.a((TextView)localObject3, (String)localObject2, paramInt1, -1, (Drawable)localObject1);
        localObject1 = new LinearLayout.LayoutParams(-2, AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        paramChildItemHolder.jdField_c_of_type_AndroidWidgetLinearLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
        paramInt1 = 1;
        paramInt2 = 0;
        if ((localStrangerInfo != null) && (localStrangerInfo.lableId > 0))
        {
          localObject1 = a(localStrangerInfo);
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramInt1 += 1;
            paramChildItemHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
            paramChildItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            if (localStrangerInfo.lableMsgPre != null)
            {
              localObject2 = new String(localStrangerInfo.lableMsgPre);
              label592:
              if (localStrangerInfo.lableMsgLast == null) {
                break label1634;
              }
              localObject3 = new String(localStrangerInfo.lableMsgLast);
              label614:
              if (!this.jdField_a_of_type_Boolean) {
                break label1642;
              }
              paramChildItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText((String)localObject2 + (String)localObject3);
              label648:
              paramChildItemHolder.jdField_a_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(localStrangerInfo.lableId));
              if (!AppSetting.b) {
                break label1791;
              }
              localObject3 = (String)localObject2 + (String)localObject3;
              paramInt2 = 1;
              localObject2 = localObject1;
              localObject1 = localObject3;
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      if (paramInt2 == 0)
      {
        paramChildItemHolder.jdField_a_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(0));
        paramChildItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        paramChildItemHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        if (!TextUtils.isEmpty(localStrangerInfo.constellation))
        {
          this.jdField_a_of_type_JavaLangStringBuilder.append(' ').append(localStrangerInfo.constellation);
          if (AppSetting.b) {
            this.jdField_b_of_type_JavaLangStringBuilder.append(",").append(localStrangerInfo.constellation);
          }
        }
      }
      paramInt2 = paramInt1;
      LinearLayout.LayoutParams localLayoutParams;
      if (localStrangerInfo.profession > 0)
      {
        paramInt2 = paramInt1;
        if (localStrangerInfo.profession < 14)
        {
          localObject3 = com.tencent.mobileqq.util.NearbyProfileUtil.e[localStrangerInfo.profession];
          localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
          localLayoutParams.leftMargin = AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
          NearbyUtils.a(localTextView, (String)localObject3, -8268557, -1, null);
          paramChildItemHolder.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localTextView, localLayoutParams);
          paramInt1 += 1;
          paramInt2 = paramInt1;
          if (AppSetting.b)
          {
            this.jdField_b_of_type_JavaLangStringBuilder.append(",").append("职业").append(" ").append((String)localObject3);
            paramInt2 = paramInt1;
          }
        }
      }
      if (!TextUtils.isEmpty(localStrangerInfo.vipInfo))
      {
        localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        localLayoutParams = new LinearLayout.LayoutParams(-2, AIOUtils.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localLayoutParams.leftMargin = AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        if ("svip".equalsIgnoreCase(localStrangerInfo.vipInfo))
        {
          ((ImageView)localObject3).setImageResource(2130839484);
          a(paramChildItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView, true);
          label1026:
          paramChildItemHolder.jdField_c_of_type_AndroidWidgetLinearLayout.addView((View)localObject3, localLayoutParams);
          label1037:
          paramInt1 = paramInt2;
          if (localStrangerInfo.charmLevel >= 4)
          {
            localObject3 = NearbyFlowerUtil.a(this.jdField_a_of_type_AndroidContentContext);
            i = Color.parseColor("#FFCC59");
            paramInt1 = i;
            if (localObject3 != null)
            {
              paramInt1 = i;
              if (localStrangerInfo.charmLevel < localObject3.length) {
                paramInt1 = localObject3[localStrangerInfo.charmLevel];
              }
            }
            localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
            NearbyUtils.a((TextView)localObject3, "LV" + localStrangerInfo.charmLevel, paramInt1, -1, null);
            localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
            localLayoutParams.leftMargin = AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            paramChildItemHolder.jdField_c_of_type_AndroidWidgetLinearLayout.addView((View)localObject3, localLayoutParams);
            paramInt1 = paramInt2 + 1;
          }
          if ((AppSetting.b) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
            this.jdField_b_of_type_JavaLangStringBuilder.append(",").append((String)localObject1);
          }
          if (paramInt1 <= 0) {
            break label1719;
          }
          paramChildItemHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          label1229:
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label1731;
          }
          paramChildItemHolder.d.setCompoundDrawablesWithIntrinsicBounds(2130842712, 0);
          paramChildItemHolder.d.setCompoundDrawablePadding((int)(5.0F * this.jdField_a_of_type_Float));
          if (!paramChildItemHolder.d.a().equals(localObject2)) {
            paramChildItemHolder.d.setText((CharSequence)localObject2);
          }
          paramChildItemHolder.d.setVisibility(0);
          paramChildItemHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
          this.jdField_b_of_type_JavaLangStringBuilder.append(",").append((String)localObject2).append(" ");
        }
      }
      for (;;)
      {
        if (AppSetting.b)
        {
          this.jdField_b_of_type_JavaLangStringBuilder.append(",").append(paramChildItemHolder.jdField_c_of_type_ComTencentWidgetSingleLineTextView.a());
          paramChildItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(this.jdField_b_of_type_JavaLangStringBuilder.toString());
          if (QLog.isColorLevel()) {
            NearbyUtils.a("NearbyVisitorAdapter", "talckback", new Object[] { this.jdField_b_of_type_JavaLangStringBuilder.toString() });
          }
        }
        return;
        localStrangerInfo.tinyId = 0L;
        break;
        label1407:
        paramChildItemHolder.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130843038);
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842744);
        paramChildItemHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(TroopUtils.a(this.jdField_a_of_type_AndroidContentContext.getResources(), -17883, (Drawable)localObject1));
        paramChildItemHolder.jdField_b_of_type_AndroidWidgetTextView.setText("男神");
        break label171;
        label1467:
        paramChildItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label171;
        label1479:
        paramChildItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText("");
        break label228;
        localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839482);
        paramInt2 = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493245);
        paramInt1 = paramInt2;
        localObject1 = localObject3;
        if (!AppSetting.b) {
          break label408;
        }
        this.jdField_b_of_type_JavaLangStringBuilder.append(",").append(",男");
        paramInt1 = paramInt2;
        localObject1 = localObject3;
        break label408;
        localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839480);
        paramInt2 = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493244);
        paramInt1 = paramInt2;
        localObject1 = localObject3;
        if (!AppSetting.b) {
          break label408;
        }
        this.jdField_b_of_type_JavaLangStringBuilder.append(",").append("女");
        paramInt1 = paramInt2;
        localObject1 = localObject3;
        break label408;
        localObject2 = "";
        break label592;
        label1634:
        localObject3 = "";
        break label614;
        label1642:
        paramChildItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
        break label648;
        if ("vip".equalsIgnoreCase(localStrangerInfo.vipInfo))
        {
          ((ImageView)localObject3).setImageResource(2130839485);
          a(paramChildItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView, true);
          break label1026;
        }
        ((ImageView)localObject3).setVisibility(8);
        a(paramChildItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView, false);
        break label1026;
        a(paramChildItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView, false);
        break label1037;
        label1719:
        paramChildItemHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        break label1229;
        label1731:
        paramChildItemHolder.d.setVisibility(8);
        paramChildItemHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
        a(paramChildItemHolder, localStrangerInfo);
        this.jdField_b_of_type_JavaLangStringBuilder.append(",").append("交友宣言").append(paramChildItemHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.a()).append(" ");
      }
      label1791:
      paramInt2 = 1;
      localObject3 = "";
      localObject2 = localObject1;
      localObject1 = localObject3;
      continue;
      localObject3 = "";
      localObject2 = localObject1;
      localObject1 = localObject3;
      continue;
      localObject2 = "";
      localObject1 = "";
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    aeeh localaeeh2 = (aeeh)paramView.getTag();
    aeeh localaeeh1 = localaeeh2;
    if (localaeeh2 == null)
    {
      localaeeh1 = new aeeh(this, null);
      localaeeh1.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131370712));
      int i = paramView.getResources().getColor(2131494122);
      ((ImageView)paramView.findViewById(2131370713)).setBackgroundColor(i);
    }
    localaeeh1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)this.jdField_d_of_type_JavaUtilList.get(paramInt));
  }
  
  public void a(StrangerInfo paramStrangerInfo, ImageView paramImageView)
  {
    if (paramStrangerInfo != null) {
      try
      {
        if (paramStrangerInfo.tinyId > 0L)
        {
          paramStrangerInfo = String.valueOf(paramStrangerInfo.tinyId);
          Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(32, paramStrangerInfo, 202);
          if (localBitmap == null)
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
              this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramStrangerInfo, 202, true, false);
            }
            if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
              this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)ImageUtil.a());
            }
            paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
            return;
          }
          paramImageView.setImageBitmap(localBitmap);
          return;
        }
      }
      catch (Throwable paramStrangerInfo)
      {
        paramStrangerInfo.printStackTrace();
        return;
      }
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)ImageUtil.a());
    }
    paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
  }
  
  protected void a(SingleLineTextView paramSingleLineTextView, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder.a(1, String.valueOf(paramInt), 200, false, true);
    localObject = new StatableBitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject, false, false);
    if (this.jdField_b_of_type_Int == 0) {
      this.jdField_b_of_type_Int = ((int)(paramSingleLineTextView.a() * 1.1F + 0.5F));
    }
    ((StatableBitmapDrawable)localObject).setBounds(0, 0, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
    paramSingleLineTextView.setCompoundDrawables((Drawable)localObject, null);
  }
  
  public void a(SingleLineTextView paramSingleLineTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidContentResColorStateList == null) {
        this.jdField_a_of_type_AndroidContentResColorStateList = paramSingleLineTextView.getResources().getColorStateList(2131494295);
      }
      paramSingleLineTextView.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
      return;
    }
    if (this.jdField_b_of_type_AndroidContentResColorStateList == null) {
      this.jdField_b_of_type_AndroidContentResColorStateList = paramSingleLineTextView.getResources().getColorStateList(2131494250);
    }
    paramSingleLineTextView.setTextColor(this.jdField_b_of_type_AndroidContentResColorStateList);
  }
  
  public void a(List paramList, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
    int i;
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      i = 0;
    }
    for (;;)
    {
      StrangerInfo localStrangerInfo;
      if (paramList.hasNext())
      {
        localStrangerInfo = (StrangerInfo)paramList.next();
        if (!localStrangerInfo.isNewVisitor) {
          break label262;
        }
        this.jdField_b_of_type_JavaUtilList.add(localStrangerInfo);
        i += 1;
      }
      while ((paramBoolean) && (i >= 4))
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_d_of_type_JavaUtilList.clear();
        if (this.jdField_b_of_type_JavaUtilList.size() > 0)
        {
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList);
          paramList = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131438400), new Object[] { Long.valueOf(this.jdField_a_of_type_Long) });
          this.jdField_d_of_type_JavaUtilList.add(paramList);
        }
        if (this.jdField_c_of_type_JavaUtilList.size() > 0)
        {
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList);
          paramList = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131438401), new Object[] { Long.valueOf(this.jdField_b_of_type_Long) });
          this.jdField_d_of_type_JavaUtilList.add(paramList);
        }
        notifyDataSetChanged();
        return;
        label262:
        this.jdField_c_of_type_JavaUtilList.add(localStrangerInfo);
        i += 1;
      }
    }
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = new NearbyVisitorAdapter.ChildItemHolder();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969109, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362701));
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131365173));
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131364841));
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131363873));
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365175));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365176));
      paramView.jdField_c_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131365193));
      paramView.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131365182));
      paramView.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131365185));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365189));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131363612);
      paramView.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131364847));
      paramView.d = ((SingleLineTextView)localView.findViewById(2131365192));
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localView.setTag(paramView);
    }
    a(paramInt1, paramInt2, (NearbyVisitorAdapter.ChildItemHolder)localView.getTag());
    return localView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    List localList = (List)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public int getGroupCount()
  {
    return this.jdField_d_of_type_JavaUtilList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = new aeeh(this, null);
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970447, paramViewGroup, false);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131370712));
      localView.setTag(paramView);
    }
    ((aeeh)localView.getTag()).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)this.jdField_d_of_type_JavaUtilList.get(paramInt));
    return localView;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.myvistor.NearbyVisitorAdapter
 * JD-Core Version:    0.7.0.1
 */