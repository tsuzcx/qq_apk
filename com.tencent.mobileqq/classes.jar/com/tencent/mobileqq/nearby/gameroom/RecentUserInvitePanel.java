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
  LinearLayout a;
  List<InviteUser> b;
  boolean c = false;
  RecentUserInvitePanel.OnClickListener d;
  
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
  
  private View b()
  {
    int i = this.a.getChildCount();
    View localView = inflate(getContext(), 2131627536, null);
    ((ImageView)localView.findViewById(2131434940)).setImageResource(2130842220);
    ((ImageView)localView.findViewById(2131434972)).setVisibility(8);
    TextView localTextView = (TextView)localView.findViewById(2131439121);
    if (i == 0) {
      localTextView.setText(HardCodeUtil.a(2131910703));
    } else {
      localTextView.setText(HardCodeUtil.a(2131910704));
    }
    localTextView.setMaxLines(2);
    localTextView.setSingleLine(false);
    localTextView.setGravity(1);
    ((Button)localView.findViewById(2131435898)).setVisibility(8);
    localView.setOnClickListener(new RecentUserInvitePanel.2(this));
    return localView;
  }
  
  private View b(InviteUser paramInviteUser)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = getContext();
    Object localObject1 = null;
    localObject2 = inflate((Context)localObject2, 2131627536, null);
    Object localObject3 = (ImageView)((View)localObject2).findViewById(2131434940);
    ImageView localImageView = (ImageView)((View)localObject2).findViewById(2131434972);
    if (paramInviteUser.c == 0)
    {
      localObject1 = FaceDrawable.getFaceDrawable(localQQAppInterface, 1, paramInviteUser.a);
    }
    else if (paramInviteUser.c == 1)
    {
      localObject1 = FaceDrawable.getFaceDrawable(localQQAppInterface, 4, paramInviteUser.a);
      i = 2130842218;
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
    localObject3 = (TextView)((View)localObject2).findViewById(2131439121);
    if (paramInviteUser.b != null) {
      localObject1 = (String)TextUtils.ellipsize(paramInviteUser.b, ((TextView)localObject3).getPaint(), DisplayUtil.a(getContext(), 65.0F), TextUtils.TruncateAt.END);
    } else {
      localObject1 = "";
    }
    ((TextView)localObject3).setText((CharSequence)localObject1);
    localObject1 = (Button)((View)localObject2).findViewById(2131435898);
    ((Button)localObject1).setOnClickListener(new RecentUserInvitePanel.1(this, paramInviteUser));
    a((View)localObject1, paramInviteUser.d);
    ((View)localObject2).setTag(paramInviteUser);
    return localObject2;
  }
  
  public void a()
  {
    this.a = new LinearLayout(getContext());
    this.a.setOrientation(0);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    addView(this.a, localLayoutParams);
    setHorizontalScrollBarEnabled(false);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof Button))
    {
      paramView = (Button)paramView;
      if (paramBoolean)
      {
        paramView.setText(HardCodeUtil.a(2131910706));
        paramView.setAlpha(0.5F);
        return;
      }
      paramView.setText(HardCodeUtil.a(2131910705));
    }
  }
  
  public void a(InviteUser paramInviteUser)
  {
    int i = 0;
    while (i < this.a.getChildCount())
    {
      View localView = this.a.getChildAt(i);
      if ((localView.getTag() instanceof InviteUser))
      {
        InviteUser localInviteUser = (InviteUser)localView.getTag();
        if ((localInviteUser.c == paramInviteUser.c) && (localInviteUser.a.equals(paramInviteUser.a))) {
          a((Button)localView.findViewById(2131435898), paramInviteUser.d);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<InviteUser> paramList, boolean paramBoolean)
  {
    this.b = paramList;
    this.c = paramBoolean;
    this.a.removeAllViews();
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = b((InviteUser)paramList.next());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = DisplayUtil.a(getContext(), 16.0F);
      this.a.addView((View)localObject, localLayoutParams);
    }
    if (paramBoolean)
    {
      paramList = b();
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).leftMargin = DisplayUtil.a(getContext(), 16.0F);
      ((LinearLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(getContext(), 16.0F);
      this.a.addView(paramList, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void setOnClickListener(RecentUserInvitePanel.OnClickListener paramOnClickListener)
  {
    this.d = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel
 * JD-Core Version:    0.7.0.1
 */