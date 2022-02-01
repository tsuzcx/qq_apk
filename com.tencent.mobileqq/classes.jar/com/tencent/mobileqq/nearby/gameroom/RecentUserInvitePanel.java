package com.tencent.mobileqq.nearby.gameroom;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.Iterator;
import java.util.List;

public class RecentUserInvitePanel
  extends HorizontalScrollView
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RecentUserInvitePanel.OnClickListener jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel$OnClickListener;
  List<InviteUser> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  
  public RecentUserInvitePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public RecentUserInvitePanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private View a()
  {
    int i = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    View localView = inflate(getContext(), 2131561184, null);
    ((ImageView)localView.findViewById(2131368087)).setImageResource(2130841386);
    ((ImageView)localView.findViewById(2131368118)).setVisibility(8);
    TextView localTextView = (TextView)localView.findViewById(2131371697);
    if (i == 0) {
      localTextView.setText(HardCodeUtil.a(2131713144));
    } else {
      localTextView.setText(HardCodeUtil.a(2131713145));
    }
    localTextView.setMaxLines(2);
    localTextView.setSingleLine(false);
    localTextView.setGravity(1);
    ((Button)localView.findViewById(2131368946)).setVisibility(8);
    localView.setOnClickListener(new RecentUserInvitePanel.2(this));
    return localView;
  }
  
  private View a(InviteUser paramInviteUser)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = getContext();
    Object localObject1 = null;
    localObject2 = inflate((Context)localObject2, 2131561184, null);
    Object localObject3 = (ImageView)((View)localObject2).findViewById(2131368087);
    ImageView localImageView = (ImageView)((View)localObject2).findViewById(2131368118);
    if (paramInviteUser.jdField_a_of_type_Int == 0)
    {
      localObject1 = FaceDrawable.getFaceDrawable(localQQAppInterface, 1, paramInviteUser.jdField_a_of_type_JavaLangString);
    }
    else if (paramInviteUser.jdField_a_of_type_Int == 1)
    {
      localObject1 = FaceDrawable.getFaceDrawable(localQQAppInterface, 4, paramInviteUser.jdField_a_of_type_JavaLangString);
      i = 2130841384;
      break label101;
    }
    int i = -1;
    label101:
    ((ImageView)localObject3).setImageDrawable((Drawable)localObject1);
    if (i != -1) {
      localImageView.setImageResource(i);
    } else {
      localImageView.setVisibility(8);
    }
    localObject3 = (TextView)((View)localObject2).findViewById(2131371697);
    if (paramInviteUser.b != null) {
      localObject1 = (String)TextUtils.ellipsize(paramInviteUser.b, ((TextView)localObject3).getPaint(), DisplayUtil.a(getContext(), 65.0F), TextUtils.TruncateAt.END);
    } else {
      localObject1 = "";
    }
    ((TextView)localObject3).setText((CharSequence)localObject1);
    localObject1 = (Button)((View)localObject2).findViewById(2131368946);
    ((Button)localObject1).setOnClickListener(new RecentUserInvitePanel.1(this, paramInviteUser));
    a((View)localObject1, paramInviteUser.jdField_a_of_type_Boolean);
    ((View)localObject2).setTag(paramInviteUser);
    return localObject2;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, localLayoutParams);
    setHorizontalScrollBarEnabled(false);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof Button))
    {
      paramView = (Button)paramView;
      if (paramBoolean)
      {
        paramView.setText(HardCodeUtil.a(2131713147));
        paramView.setAlpha(0.5F);
        return;
      }
      paramView.setText(HardCodeUtil.a(2131713146));
    }
  }
  
  public void a(InviteUser paramInviteUser)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((localView.getTag() instanceof InviteUser))
      {
        InviteUser localInviteUser = (InviteUser)localView.getTag();
        if ((localInviteUser.jdField_a_of_type_Int == paramInviteUser.jdField_a_of_type_Int) && (localInviteUser.jdField_a_of_type_JavaLangString.equals(paramInviteUser.jdField_a_of_type_JavaLangString))) {
          a((Button)localView.findViewById(2131368946), paramInviteUser.jdField_a_of_type_Boolean);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<InviteUser> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = a((InviteUser)paramList.next());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = DisplayUtil.a(getContext(), 16.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject, localLayoutParams);
    }
    if (paramBoolean)
    {
      paramList = a();
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).leftMargin = DisplayUtil.a(getContext(), 16.0F);
      ((LinearLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(getContext(), 16.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramList, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void setOnClickListener(RecentUserInvitePanel.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel$OnClickListener = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel
 * JD-Core Version:    0.7.0.1
 */