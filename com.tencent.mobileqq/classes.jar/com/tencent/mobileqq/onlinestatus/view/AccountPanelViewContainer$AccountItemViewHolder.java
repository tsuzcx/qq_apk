package com.tencent.mobileqq.onlinestatus.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.onlinestatus.utils.WidgetUtils;
import mqq.app.MobileQQ;

public class AccountPanelViewContainer$AccountItemViewHolder
{
  View a;
  ImageView b;
  ImageView c;
  TextView d;
  DragTextView e;
  View f;
  int g;
  
  public AccountPanelViewContainer$AccountItemViewHolder(View paramView)
  {
    this.a = paramView;
    this.b = ((ImageView)paramView.findViewById(2131429022));
    this.c = ((ImageView)paramView.findViewById(2131446548));
    this.d = ((TextView)paramView.findViewById(2131439319));
    this.e = ((DragTextView)paramView.findViewById(2131449126));
    this.f = paramView.findViewById(2131429017);
  }
  
  private void a()
  {
    if (!AppSetting.e) {
      return;
    }
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    Object localObject1 = this.d;
    if (localObject1 != null) {
      localObject1 = ((TextView)localObject1).getText().toString();
    } else {
      localObject1 = "";
    }
    Object localObject2 = this.e;
    boolean bool2 = false;
    int i;
    if ((localObject2 != null) && ((((DragTextView)localObject2).getTag() instanceof Integer))) {
      i = ((Integer)this.e.getTag()).intValue();
    } else {
      i = 0;
    }
    localObject2 = new StringBuilder();
    int j = this.g;
    if (j == 2)
    {
      ((StringBuilder)localObject2).append(localMobileQQ.getString(2131916880, new Object[] { localObject1 }));
      ((StringBuilder)localObject2).append(localMobileQQ.getString(2131887622));
    }
    else if (j == 2)
    {
      ((StringBuilder)localObject2).append(localMobileQQ.getString(2131916881, new Object[] { localObject1 }));
      ((StringBuilder)localObject2).append(localMobileQQ.getString(2131887622));
    }
    else
    {
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(localMobileQQ.getString(2131887622));
    }
    localObject1 = this.e;
    boolean bool1 = bool2;
    if (localObject1 != null)
    {
      bool1 = bool2;
      if ((((DragTextView)localObject1).getTag(2131449126) instanceof Boolean)) {
        bool1 = ((Boolean)this.e.getTag(2131449126)).booleanValue();
      }
    }
    if ((i > 0) && (!bool1))
    {
      if (i == 1)
      {
        ((StringBuilder)localObject2).append(" 有一条未读");
      }
      else if (i == 2)
      {
        ((StringBuilder)localObject2).append(" 有两条未读");
      }
      else if (i > 0)
      {
        ((StringBuilder)localObject2).append(" 有");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("条未读");
      }
    }
    else if (bool1) {
      ((StringBuilder)localObject2).append(" 有最新消息");
    }
    this.a.setContentDescription(((StringBuilder)localObject2).toString());
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt > 0)
    {
      int i;
      if (paramBoolean) {
        i = 1;
      } else {
        i = 3;
      }
      if (this.g == 2)
      {
        int j;
        if (paramBoolean) {
          j = 2130852588;
        } else {
          j = 2130852592;
        }
        WidgetUtils.a(this.e, i, paramInt, j, 99, null);
      }
      else
      {
        WidgetUtils.a(this.e, i, paramInt, 2130852595, 99, null);
      }
      this.e.setVisibility(0);
      this.e.setTag(Integer.valueOf(paramInt));
    }
    else
    {
      this.e.setVisibility(8);
      this.e.setTag(Integer.valueOf(paramInt));
    }
    this.e.setTag(2131449126, Boolean.valueOf(paramBoolean));
    a();
  }
  
  public void a(Drawable paramDrawable)
  {
    this.b.setImageDrawable(paramDrawable);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.d.setText(paramCharSequence);
      a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.setVisibility(0);
      return;
    }
    this.c.setVisibility(8);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.f.setVisibility(0);
      return;
    }
    this.f.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.AccountPanelViewContainer.AccountItemViewHolder
 * JD-Core Version:    0.7.0.1
 */