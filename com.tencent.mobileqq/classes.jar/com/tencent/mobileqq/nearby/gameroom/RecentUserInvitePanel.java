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
  List<WerewolvesDataManager.InviteUser> jdField_a_of_type_JavaUtilList;
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
    View localView = inflate(getContext(), 2131561345, null);
    ((ImageView)localView.findViewById(2131368336)).setImageResource(2130841505);
    ((ImageView)localView.findViewById(2131368367)).setVisibility(8);
    TextView localTextView = (TextView)localView.findViewById(2131372115);
    if (i == 0) {
      localTextView.setText(HardCodeUtil.a(2131713169));
    }
    for (;;)
    {
      localTextView.setMaxLines(2);
      localTextView.setSingleLine(false);
      localTextView.setGravity(1);
      ((Button)localView.findViewById(2131369216)).setVisibility(8);
      localView.setOnClickListener(new RecentUserInvitePanel.2(this));
      return localView;
      localTextView.setText(HardCodeUtil.a(2131713170));
    }
  }
  
  private View a(WerewolvesDataManager.InviteUser paramInviteUser)
  {
    Object localObject1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    View localView = inflate(getContext(), 2131561345, null);
    Object localObject2 = (ImageView)localView.findViewById(2131368336);
    ImageView localImageView = (ImageView)localView.findViewById(2131368367);
    int i;
    if (paramInviteUser.jdField_a_of_type_Int == 0)
    {
      localObject1 = FaceDrawable.getFaceDrawable(localQQAppInterface, 1, paramInviteUser.jdField_a_of_type_JavaLangString);
      i = -1;
    }
    for (;;)
    {
      ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
      if (i != -1) {
        localImageView.setImageResource(i);
      }
      for (;;)
      {
        localObject2 = (TextView)localView.findViewById(2131372115);
        localObject1 = "";
        if (paramInviteUser.b != null) {
          localObject1 = (String)TextUtils.ellipsize(paramInviteUser.b, ((TextView)localObject2).getPaint(), DisplayUtil.a(getContext(), 65.0F), TextUtils.TruncateAt.END);
        }
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject1 = (Button)localView.findViewById(2131369216);
        ((Button)localObject1).setOnClickListener(new RecentUserInvitePanel.1(this, paramInviteUser));
        a((View)localObject1, paramInviteUser.jdField_a_of_type_Boolean);
        localView.setTag(paramInviteUser);
        return localView;
        if (paramInviteUser.jdField_a_of_type_Int != 1) {
          break label220;
        }
        localObject1 = FaceDrawable.getFaceDrawable(localQQAppInterface, 4, paramInviteUser.jdField_a_of_type_JavaLangString);
        i = 2130841503;
        break;
        localImageView.setVisibility(8);
      }
      label220:
      i = -1;
    }
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
        paramView.setText(HardCodeUtil.a(2131713172));
        paramView.setAlpha(0.5F);
      }
    }
    else
    {
      return;
    }
    paramView.setText(HardCodeUtil.a(2131713171));
  }
  
  public void a(WerewolvesDataManager.InviteUser paramInviteUser)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((localView.getTag() instanceof WerewolvesDataManager.InviteUser))
      {
        WerewolvesDataManager.InviteUser localInviteUser = (WerewolvesDataManager.InviteUser)localView.getTag();
        if ((localInviteUser.jdField_a_of_type_Int == paramInviteUser.jdField_a_of_type_Int) && (localInviteUser.jdField_a_of_type_JavaLangString.equals(paramInviteUser.jdField_a_of_type_JavaLangString))) {
          a((Button)localView.findViewById(2131369216), paramInviteUser.jdField_a_of_type_Boolean);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<WerewolvesDataManager.InviteUser> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = a((WerewolvesDataManager.InviteUser)paramList.next());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel
 * JD-Core Version:    0.7.0.1
 */