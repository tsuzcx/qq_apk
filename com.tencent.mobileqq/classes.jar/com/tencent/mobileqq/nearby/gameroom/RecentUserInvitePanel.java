package com.tencent.mobileqq.nearby.gameroom;

import ajjy;
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
import asic;
import asid;
import asie;
import asih;
import azvv;
import azwp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;

public class RecentUserInvitePanel
  extends HorizontalScrollView
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public asie a;
  List<asih> jdField_a_of_type_JavaUtilList;
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
    View localView = inflate(getContext(), 2131495274, null);
    ((ImageView)localView.findViewById(2131301817)).setImageResource(2130840880);
    ((ImageView)localView.findViewById(2131301850)).setVisibility(8);
    TextView localTextView = (TextView)localView.findViewById(2131304981);
    if (i == 0) {
      localTextView.setText(ajjy.a(2131647423));
    }
    for (;;)
    {
      localTextView.setMaxLines(2);
      localTextView.setSingleLine(false);
      localTextView.setGravity(1);
      ((Button)localView.findViewById(2131302647)).setVisibility(8);
      localView.setOnClickListener(new asid(this));
      return localView;
      localTextView.setText(ajjy.a(2131647424));
    }
  }
  
  private View a(asih paramasih)
  {
    Object localObject1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    View localView = inflate(getContext(), 2131495274, null);
    Object localObject2 = (ImageView)localView.findViewById(2131301817);
    ImageView localImageView = (ImageView)localView.findViewById(2131301850);
    int i;
    if (paramasih.jdField_a_of_type_Int == 0)
    {
      localObject1 = azwp.a(localQQAppInterface, 1, paramasih.jdField_a_of_type_JavaLangString);
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
        localObject2 = (TextView)localView.findViewById(2131304981);
        localObject1 = "";
        if (paramasih.b != null) {
          localObject1 = (String)TextUtils.ellipsize(paramasih.b, ((TextView)localObject2).getPaint(), azvv.a(getContext(), 65.0F), TextUtils.TruncateAt.END);
        }
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject1 = (Button)localView.findViewById(2131302647);
        ((Button)localObject1).setOnClickListener(new asic(this, paramasih));
        a((View)localObject1, paramasih.jdField_a_of_type_Boolean);
        localView.setTag(paramasih);
        return localView;
        if (paramasih.jdField_a_of_type_Int != 1) {
          break label220;
        }
        localObject1 = azwp.a(localQQAppInterface, 4, paramasih.jdField_a_of_type_JavaLangString);
        i = 2130840878;
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
        paramView.setText(ajjy.a(2131647426));
        paramView.setAlpha(0.5F);
      }
    }
    else
    {
      return;
    }
    paramView.setText(ajjy.a(2131647425));
  }
  
  public void a(asih paramasih)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((localView.getTag() instanceof asih))
      {
        asih localasih = (asih)localView.getTag();
        if ((localasih.jdField_a_of_type_Int == paramasih.jdField_a_of_type_Int) && (localasih.jdField_a_of_type_JavaLangString.equals(paramasih.jdField_a_of_type_JavaLangString))) {
          a((Button)localView.findViewById(2131302647), paramasih.jdField_a_of_type_Boolean);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<asih> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = a((asih)paramList.next());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = azvv.a(getContext(), 16.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject, localLayoutParams);
    }
    if (paramBoolean)
    {
      paramList = a();
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).leftMargin = azvv.a(getContext(), 16.0F);
      ((LinearLayout.LayoutParams)localObject).rightMargin = azvv.a(getContext(), 16.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramList, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void setOnClickListener(asie paramasie)
  {
    this.jdField_a_of_type_Asie = paramasie;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel
 * JD-Core Version:    0.7.0.1
 */