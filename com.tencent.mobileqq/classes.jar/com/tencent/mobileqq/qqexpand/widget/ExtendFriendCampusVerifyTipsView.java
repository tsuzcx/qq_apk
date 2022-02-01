package com.tencent.mobileqq.qqexpand.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.profile.SchoolInfo;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;

public class ExtendFriendCampusVerifyTipsView
  extends FrameLayout
  implements View.OnClickListener
{
  private ImageView a;
  private TextView b;
  private TextView c;
  private Button d;
  private ImageView e;
  private ExtendFriendCampusVerifyTipsView.TipsType f = ExtendFriendCampusVerifyTipsView.TipsType.VERIFY_NONE;
  private ExtendFriendCampusVerifyTipsView.OnClickListener g;
  
  public ExtendFriendCampusVerifyTipsView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExtendFriendCampusVerifyTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExtendFriendCampusVerifyTipsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflate(paramContext, 2131627413, this);
    a();
    b();
  }
  
  private void a()
  {
    this.a = ((ImageView)findViewById(2131447435));
    this.b = ((TextView)findViewById(2131447442));
    this.c = ((TextView)findViewById(2131447440));
    this.d = ((Button)findViewById(2131447426));
    this.d.setOnTouchListener(UITools.a);
    this.d.setOnClickListener(this);
    this.e = ((ImageView)findViewById(2131447432));
    this.e.setOnTouchListener(UITools.a);
    this.e.setOnClickListener(this);
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    if ((paramActivity != null) && (paramQQAppInterface != null))
    {
      paramQQAppInterface = (IExpandManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      Object localObject = paramQQAppInterface.ag();
      if ((localObject instanceof SchoolInfo))
      {
        localObject = (SchoolInfo)localObject;
        if (TextUtils.isEmpty(((SchoolInfo)localObject).d))
        {
          CampusHelper.a(paramActivity, paramQQAppInterface.I());
          return;
        }
        CampusHelper.a(paramActivity, ((SchoolInfo)localObject).a, ((SchoolInfo)localObject).d, ((SchoolInfo)localObject).c);
      }
    }
  }
  
  private void b()
  {
    if (this.f == ExtendFriendCampusVerifyTipsView.TipsType.VERIFY_NONE)
    {
      this.a.setVisibility(8);
      this.b.setVisibility(0);
      this.c.setVisibility(0);
      this.d.setVisibility(0);
      this.b.setText(2131896886);
      this.c.setText(2131896885);
      this.d.setText(2131896884);
      this.d.setTextColor(-1);
      this.d.setBackgroundResource(2130846636);
      return;
    }
    if (this.f == ExtendFriendCampusVerifyTipsView.TipsType.VERIFY_SUCCESS)
    {
      this.a.setVisibility(0);
      this.b.setVisibility(0);
      this.c.setVisibility(8);
      this.d.setVisibility(8);
      this.a.setImageResource(2130846639);
      this.b.setText(2131896887);
      return;
    }
    if (this.f == ExtendFriendCampusVerifyTipsView.TipsType.VERIFY_FAIL)
    {
      this.a.setVisibility(0);
      this.b.setVisibility(0);
      this.c.setVisibility(8);
      this.d.setVisibility(0);
      this.a.setImageResource(2130846638);
      this.b.setText(2131896883);
      this.d.setText(2131896882);
      this.d.setTextColor(-16777216);
      this.d.setBackgroundResource(2130846637);
    }
  }
  
  private void c()
  {
    ExtendFriendCampusVerifyTipsView.OnClickListener localOnClickListener = this.g;
    if (localOnClickListener != null) {
      localOnClickListener.a(this.f);
    }
  }
  
  private void d()
  {
    ExtendFriendCampusVerifyTipsView.OnClickListener localOnClickListener = this.g;
    if (localOnClickListener != null) {
      localOnClickListener.b(this.f);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131447426)
    {
      if (i != 2131447432) {
        return;
      }
      d();
      return;
    }
    c();
  }
  
  public void setOnClickListener(ExtendFriendCampusVerifyTipsView.OnClickListener paramOnClickListener)
  {
    this.g = paramOnClickListener;
  }
  
  public void setTipsType(ExtendFriendCampusVerifyTipsView.TipsType paramTipsType)
  {
    this.f = paramTipsType;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.ExtendFriendCampusVerifyTipsView
 * JD-Core Version:    0.7.0.1
 */