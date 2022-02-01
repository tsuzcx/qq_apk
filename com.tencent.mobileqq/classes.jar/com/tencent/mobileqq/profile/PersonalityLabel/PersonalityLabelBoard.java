package com.tencent.mobileqq.profile.PersonalityLabel;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagUtil;
import com.tencent.mobileqq.profilecard.bussiness.personalitylabel.ProfilePersonalityLabelComponent;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class PersonalityLabelBoard
  extends LinearLayout
  implements Handler.Callback, View.OnClickListener, OnGetPersonalityLabelsListener
{
  ProfilePersonalityLabelInfo a;
  protected LayoutInflater b;
  LinearLayout.LayoutParams c;
  LinearLayout d;
  public Button e;
  public TextView f;
  View g;
  public TagCloudView h;
  public View i;
  public TextView j;
  public TextView k;
  QQAppInterface l;
  float m;
  Drawable n;
  ColorStateList o = ColorStateList.valueOf(-16777216);
  private int p = 0;
  private String q;
  private String r;
  private boolean s = false;
  private boolean t = true;
  private ProfilePersonalityLabelComponent u;
  
  public PersonalityLabelBoard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  @TargetApi(11)
  public PersonalityLabelBoard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  public PersonalityLabelBoard(Context paramContext, QQAppInterface paramQQAppInterface, String paramString)
  {
    super(paramContext);
    this.l = paramQQAppInterface;
    b();
    if (!TextUtils.equals(paramString, paramQQAppInterface.getCurrentAccountUin())) {
      this.p = 1;
    }
    this.r = paramString;
  }
  
  private void a(ProfilePersonalityLabelInfo paramProfilePersonalityLabelInfo)
  {
    ArrayList localArrayList = new ArrayList(paramProfilePersonalityLabelInfo.getSize());
    if (this.n == null) {
      this.n = getResources().getDrawable(2131165733);
    }
    Object localObject = paramProfilePersonalityLabelInfo.getLatestThumbUrl();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      Drawable localDrawable = this.n;
      localObject = URLDrawable.getDrawable((String)localObject, localDrawable, localDrawable);
    }
    else
    {
      localObject = null;
    }
    TagUtil.a(localArrayList, paramProfilePersonalityLabelInfo, this.m);
    this.h.setTags(localArrayList);
    this.h.setTagIcon((Drawable)localObject);
    if (AppSetting.e)
    {
      paramProfilePersonalityLabelInfo = new StringBuilder();
      paramProfilePersonalityLabelInfo.append("个性标签");
      this.h.setContentDescription(paramProfilePersonalityLabelInfo.toString());
    }
  }
  
  private void a(ProfilePersonalityLabelInfo paramProfilePersonalityLabelInfo, boolean paramBoolean)
  {
    int i1;
    if (this.p == 1) {
      i1 = paramProfilePersonalityLabelInfo.praiseCount + paramProfilePersonalityLabelInfo.unreadCount;
    } else {
      i1 = paramProfilePersonalityLabelInfo.praiseCount;
    }
    if ((i1 <= 0) && (paramProfilePersonalityLabelInfo.unreadCount <= 0))
    {
      if (this.i.getVisibility() != 8) {
        this.i.setVisibility(8);
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("获得");
    localStringBuilder.append(i1);
    localStringBuilder.append("个赞");
    if (!TextUtils.equals(this.j.getText(), localStringBuilder)) {
      this.j.setText(localStringBuilder);
    }
    if (this.i.getVisibility() != 0) {
      this.i.setVisibility(0);
    }
    if (this.p == 0)
    {
      if (paramProfilePersonalityLabelInfo.unreadCount <= 0)
      {
        if (this.k.getVisibility() != 8) {
          this.k.setVisibility(8);
        }
      }
      else
      {
        if (this.k.getVisibility() != 0) {
          this.k.setVisibility(0);
        }
        localStringBuilder.delete(0, localStringBuilder.length());
        localStringBuilder.append("+");
        localStringBuilder.append(paramProfilePersonalityLabelInfo.unreadCount);
        if (!TextUtils.equals(this.k.getText(), localStringBuilder)) {
          this.k.setText(localStringBuilder);
        }
      }
    }
    else if (this.k.getVisibility() != 8) {
      this.k.setVisibility(8);
    }
    if (AppSetting.e)
    {
      localStringBuilder.delete(0, localStringBuilder.length());
      localStringBuilder.append("个性标签");
      localStringBuilder.append("，");
      localStringBuilder.append(this.j.getText());
      if (this.p == 0)
      {
        if (paramProfilePersonalityLabelInfo.unreadCount > 0)
        {
          localStringBuilder.append("，");
          localStringBuilder.append("新增");
          localStringBuilder.append(paramProfilePersonalityLabelInfo.unreadCount);
          localStringBuilder.append("个赞");
        }
        localStringBuilder.append("，");
        localStringBuilder.append("点按两次查看");
      }
      this.i.setContentDescription(localStringBuilder.toString());
    }
    if ((paramBoolean) && (this.p == 0) && (paramProfilePersonalityLabelInfo.unreadCount > 0)) {
      ReportController.b(this.l, "dc00898", "", "", "0X8007FCD", "0X8007FCD", 0, 0, "0", "0", "", "");
    }
  }
  
  private void b()
  {
    this.m = getResources().getDisplayMetrics().density;
    this.b = LayoutInflater.from(getContext());
    this.c = new LinearLayout.LayoutParams(-1, -2);
    setOrientation(1);
    setLayoutParams(this.c);
  }
  
  private void c()
  {
    a(true);
  }
  
  public void a()
  {
    this.s = false;
  }
  
  public void a(ProfilePersonalityLabelInfo paramProfilePersonalityLabelInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetPersonalityLabels isServer:");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(", scroll:");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramProfilePersonalityLabelInfo.toString());
      QLog.i("PersonalityLabelBoard", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramProfilePersonalityLabelInfo.getSize() > 0) && (this.g == null))
    {
      this.g = this.b.inflate(2131627710, this, false);
      this.h = ((TagCloudView)this.g.findViewById(2131446785));
      this.i = this.g.findViewById(2131450385);
      this.j = ((TextView)this.g.findViewById(2131448873));
      this.k = ((TextView)this.g.findViewById(2131448875));
      this.h.setOnClickListener(this);
      this.i.setOnClickListener(this);
      this.h.setMinHeight((int)(this.m * 150.0F));
      this.h.setThreshold((int)(this.m * 7.5F));
    }
    else if ((paramProfilePersonalityLabelInfo.getSize() == 0) && (this.d == null))
    {
      if (this.t) {
        this.d = ((LinearLayout)this.b.inflate(2131627711, this, false));
      } else {
        this.d = ((LinearLayout)this.b.inflate(2131627712, this, false));
      }
      this.e = ((Button)this.d.findViewById(2131448220));
      this.e.setOnClickListener(this);
      this.f = ((TextView)this.d.findViewById(2131448221));
      this.f.setTextColor(this.o);
    }
    if (getChildCount() > 0) {
      localObject = getChildAt(0);
    } else {
      localObject = null;
    }
    if (paramProfilePersonalityLabelInfo.getSize() == 0)
    {
      if ((localObject == this.g) || (localObject == null))
      {
        removeAllViews();
        addView(this.d);
      }
    }
    else
    {
      if ((localObject != this.d) && (localObject != null))
      {
        if (localObject == this.g) {
          if (!paramProfilePersonalityLabelInfo.equals(this.a)) {
            a(paramProfilePersonalityLabelInfo);
          } else if (QLog.isColorLevel()) {
            QLog.i("PersonalityLabelBoard", 2, "onGetPersonalityLabels same data");
          }
        }
      }
      else
      {
        removeAllViews();
        addView(this.g);
        a(paramProfilePersonalityLabelInfo);
      }
      a(paramProfilePersonalityLabelInfo, paramBoolean1);
    }
    this.a = paramProfilePersonalityLabelInfo;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.s) {
      return;
    }
    this.s = true;
    Object localObject = new Intent(getContext(), PersonalityLabelGalleryActivity.class);
    ((Intent)localObject).putExtra("fromType", 0);
    ((Intent)localObject).putExtra("uin", this.r);
    if ((this.p == 1) && (!TextUtils.isEmpty(this.q))) {
      ((Intent)localObject).putExtra("nickname", this.q);
    }
    ((Activity)getContext()).startActivityForResult((Intent)localObject, 1029);
    if (paramBoolean)
    {
      ReportController.b(this.l, "dc00898", "", "", "0X8007FCB", "0X8007FCB", 0, 0, "0", "0", "", "");
      localObject = this.a;
      if ((localObject != null) && (((ProfilePersonalityLabelInfo)localObject).unreadCount > 0)) {
        ReportController.b(this.l, "dc00898", "", "", "0X8007FCE", "0X8007FCE", 0, 0, "0", "0", "", "");
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.i) {
      if (this.p == 0)
      {
        ReportController.b(this.l, "dc00898", "", "", "0X80081D7", "0X80081D7", 0, 0, "", "", "", "");
        Object localObject = new Intent(getContext(), QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", "https://ti.qq.com/cgi-node/specialtag/zanlist?_wv=1027&asyncMode=3");
        getContext().startActivity((Intent)localObject);
        localObject = this.a;
        ((ProfilePersonalityLabelInfo)localObject).praiseCount += this.a.unreadCount;
        localObject = this.a;
        ((ProfilePersonalityLabelInfo)localObject).unreadCount = 0;
        if (((ProfilePersonalityLabelInfo)localObject).praiseCount <= 0) {
          break label216;
        }
        postDelayed(new PersonalityLabelBoard.1(this), 500L);
      }
      else
      {
        c();
      }
    }
    if (paramView == this.e)
    {
      ProfileCardUtil.a(this.l.getCurrentAccountUin(), this.l, (Activity)getContext(), true);
      ReportController.b(this.l, "dc00898", "", "", "0X8007FCC", "0X8007FCC", 0, 0, "0", "0", "", "");
    }
    else if (paramView == this.h)
    {
      c();
    }
    label216:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setIsNormalTheme(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setIsNormalTheme:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" old:");
      ((StringBuilder)localObject).append(this.t);
      QLog.i("PersonalityLabelBoard", 2, ((StringBuilder)localObject).toString());
    }
    if (this.t != paramBoolean)
    {
      this.t = paramBoolean;
      if (getChildCount() > 0) {
        localObject = getChildAt(0);
      } else {
        localObject = null;
      }
      LinearLayout localLinearLayout = this.d;
      if (localLinearLayout != null)
      {
        if (this.t) {
          this.d = ((LinearLayout)this.b.inflate(2131627711, this, false));
        } else {
          this.d = ((LinearLayout)this.b.inflate(2131627712, this, false));
        }
        this.e = ((Button)this.d.findViewById(2131448220));
        this.e.setOnClickListener(this);
        this.f = ((TextView)this.d.findViewById(2131448221));
        this.f.setTextColor(this.o);
      }
      if ((localObject != null) && (localObject == localLinearLayout))
      {
        removeAllViews();
        addView(this.d);
      }
    }
  }
  
  public void setNick(String paramString)
  {
    if (!TextUtils.equals(paramString, this.q)) {
      this.q = paramString;
    }
  }
  
  public void setPersonalityLabelComponent(ProfilePersonalityLabelComponent paramProfilePersonalityLabelComponent)
  {
    this.u = paramProfilePersonalityLabelComponent;
  }
  
  public void setTextColors(ColorStateList paramColorStateList)
  {
    this.o = paramColorStateList;
    paramColorStateList = this.f;
    if (paramColorStateList != null) {
      paramColorStateList.setTextColor(this.o);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard
 * JD-Core Version:    0.7.0.1
 */