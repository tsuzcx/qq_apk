package com.tencent.mobileqq.flashshow.personal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.flashshow.api.data.DataBuilder;
import com.tencent.mobileqq.flashshow.data.FSDataCenter;
import com.tencent.mobileqq.flashshow.data.FSUserStateData;
import com.tencent.mobileqq.flashshow.launcher.FSNativeLauncher;
import com.tencent.mobileqq.flashshow.personal.bean.FSPersonalInfo;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11001;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.flashshow.utils.FSTextUtils;
import com.tencent.mobileqq.flashshow.widgets.FSBaseWidgetView;
import com.tencent.mobileqq.flashshow.widgets.common.FSAvatarView;
import com.tencent.mobileqq.flashshow.widgets.common.FSFollowView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StUser;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleBase.StUserBusiData;
import qqcircle.QQCircleBase.UserCircleInfo;

public class FSPersonalInfoWidget
  extends FSBaseWidgetView<FSPersonalInfo>
  implements View.OnClickListener, Observer<FSUserStateData>
{
  private FSAvatarView a;
  private TextView b;
  private TextView c;
  private ImageView d;
  private TextView e;
  private LinearLayout f;
  private LinearLayout g;
  private LinearLayout h;
  private TextView i;
  private TextView j;
  private TextView k;
  private FSFollowView l;
  private FeedCloudMeta.StUser m;
  private QQCircleBase.StUserBusiData n;
  private String o = "";
  private String p = "";
  
  public FSPersonalInfoWidget(@NonNull Context paramContext, FeedCloudMeta.StUser paramStUser)
  {
    super(paramContext);
    this.m = paramStUser;
    b();
    a();
  }
  
  private int a(TextView paramTextView)
  {
    if (paramTextView.getText() == null) {
      return 0;
    }
    return paramTextView.getText().toString().length();
  }
  
  private void a()
  {
    if ((this.a != null) && (this.b != null) && (this.c != null))
    {
      if (this.m == null) {
        return;
      }
      d();
      this.a.setAvatarUser(this.m);
      this.b.setText(this.m.nick.get());
      this.c.setText(this.m.desc.get());
      TextView localTextView = this.c;
      int i1;
      if (TextUtils.isEmpty(this.m.desc.get())) {
        i1 = 8;
      } else {
        i1 = 0;
      }
      localTextView.setVisibility(i1);
    }
  }
  
  private void a(int paramInt)
  {
    TextView localTextView = this.k;
    if (localTextView != null)
    {
      if (paramInt < 0) {
        return;
      }
      localTextView.setText(FSTextUtils.a(paramInt));
      c();
    }
  }
  
  private void a(long paramLong)
  {
    TextView localTextView = this.j;
    if (localTextView != null)
    {
      if (paramLong < 0L) {
        return;
      }
      localTextView.setText(FSTextUtils.a(paramLong));
      c();
    }
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i1 = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append(" / ");
    paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(2131166092)), i1, paramSpannableStringBuilder.length(), 33);
  }
  
  private void a(FSPersonalInfo paramFSPersonalInfo)
  {
    this.o = paramFSPersonalInfo.j;
    if (!TextUtils.isEmpty(this.o))
    {
      LinearLayout localLinearLayout = this.g;
      if (localLinearLayout != null) {
        localLinearLayout.setOnClickListener(this);
      }
    }
    this.p = paramFSPersonalInfo.i;
    if (!TextUtils.isEmpty(this.p))
    {
      paramFSPersonalInfo = this.h;
      if (paramFSPersonalInfo != null) {
        paramFSPersonalInfo.setOnClickListener(this);
      }
    }
  }
  
  private void a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    Object localObject1 = this.n;
    if (localObject1 == null)
    {
      QLog.d("FSPersonalInfoWidget", 1, "mStUserBusiData is null");
      return;
    }
    Object localObject2 = ((QQCircleBase.StUserBusiData)localObject1).schoolInfos.get();
    localObject1 = this.n.companyInfos.get();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mSchoolCircleInfos size:");
      localStringBuilder.append(((List)localObject2).size());
      QLog.d("FSPersonalInfoWidget", 1, localStringBuilder.toString());
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramStringBuilder1.append(((QQCircleBase.UserCircleInfo)((Iterator)localObject2).next()).name.get());
      }
    }
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      paramStringBuilder1 = new StringBuilder();
      paramStringBuilder1.append("mCompanyCircleInfos size:");
      paramStringBuilder1.append(((List)localObject1).size());
      QLog.d("FSPersonalInfoWidget", 1, paramStringBuilder1.toString());
      paramStringBuilder1 = ((List)localObject1).iterator();
      while (paramStringBuilder1.hasNext()) {
        paramStringBuilder2.append(((QQCircleBase.UserCircleInfo)paramStringBuilder1.next()).name.get());
      }
    }
  }
  
  private void b()
  {
    Object localObject = this.l;
    if (localObject != null)
    {
      FeedCloudMeta.StUser localStUser = this.m;
      if (localStUser == null) {
        return;
      }
      ((FSFollowView)localObject).setUserData(localStUser);
      localObject = this.l;
      int i1 = this.m.followState.get();
      boolean bool = true;
      if (i1 != 1) {
        bool = false;
      }
      ((FSFollowView)localObject).setSelected(bool);
      if ((getContext() instanceof LifecycleOwner))
      {
        localObject = this.m.id.get();
        FSDataCenter.a().a((String)localObject, FSUserStateData.a(this.m));
        FSDataCenter.a().b(this.m.id.get(), this);
      }
      this.l.setClickable(false);
    }
  }
  
  private void b(int paramInt)
  {
    if (this.m != null)
    {
      FSFollowView localFSFollowView = this.l;
      if (localFSFollowView == null) {
        return;
      }
      localFSFollowView.setSelected(FSCommonUtil.a(paramInt));
    }
  }
  
  private void b(long paramLong)
  {
    TextView localTextView = this.i;
    if (localTextView != null)
    {
      if (paramLong < 0L) {
        return;
      }
      localTextView.setText(FSTextUtils.a(paramLong));
      c();
    }
  }
  
  private void c()
  {
    if ((a(this.j) >= 4) && (a(this.i) >= 4) && (a(this.k) >= 4))
    {
      this.j.setTextSize(1, ViewUtils.dip2px(5.0F));
      this.i.setTextSize(1, ViewUtils.dip2px(5.0F));
      this.k.setTextSize(1, ViewUtils.dip2px(5.0F));
    }
  }
  
  private void d()
  {
    if (this.m == null) {
      return;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    boolean bool = TextUtils.isEmpty(this.m.location.get());
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (!bool)
    {
      String str = FSTextUtils.a(this.m.location.get());
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(str)) {
        localObject1 = str;
      }
    }
    if (((String)localObject1).length() > 0)
    {
      a(localSpannableStringBuilder);
      localSpannableStringBuilder.append((CharSequence)localObject1);
    }
    localObject1 = new StringBuilder();
    localObject2 = new StringBuilder();
    a((StringBuilder)localObject1, (StringBuilder)localObject2);
    if (((StringBuilder)localObject1).length() > 0)
    {
      if (localSpannableStringBuilder.length() > 3) {
        a(localSpannableStringBuilder);
      }
      localSpannableStringBuilder.append((CharSequence)localObject1);
    }
    if (((StringBuilder)localObject2).length() > 0)
    {
      if (localSpannableStringBuilder.length() > 3) {
        a(localSpannableStringBuilder);
      }
      localSpannableStringBuilder.append((CharSequence)localObject2);
    }
    setVisibleSexAndLocation(localSpannableStringBuilder);
  }
  
  private void setFollowReportListener(FSFollowView paramFSFollowView)
  {
    paramFSFollowView.setReportListener(new FSPersonalInfoWidget.1(this));
  }
  
  private void setVisibleSexAndLocation(SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((!TextUtils.isEmpty(paramSpannableStringBuilder)) && (paramSpannableStringBuilder.length() > 3))
    {
      ImageView localImageView = this.d;
      int i1;
      if (this.m.sex.get() == 1) {
        i1 = 2130840397;
      } else {
        i1 = 2130840396;
      }
      localImageView.setImageResource(i1);
      this.d.setVisibility(0);
      this.e.setText(paramSpannableStringBuilder);
      this.e.setVisibility(0);
      this.e.setMovementMethod(LinkMovementMethod.getInstance());
      this.f.setVisibility(0);
      QLog.d("FSPersonalInfoWidget", 1, new Object[] { paramSpannableStringBuilder });
      return;
    }
    this.e.setVisibility(8);
    this.d.setVisibility(8);
    this.f.setVisibility(8);
  }
  
  public void a(FSUserStateData paramFSUserStateData)
  {
    if (paramFSUserStateData != null)
    {
      FeedCloudMeta.StUser localStUser = this.m;
      if (localStUser != null)
      {
        if (!TextUtils.equals(localStUser.id.get(), paramFSUserStateData.a())) {
          return;
        }
        a(paramFSUserStateData.d());
        a(paramFSUserStateData.e());
        b(paramFSUserStateData.c());
        b(paramFSUserStateData.b());
      }
    }
  }
  
  protected void a(FSPersonalInfo paramFSPersonalInfo, int paramInt)
  {
    if (paramFSPersonalInfo == null) {
      return;
    }
    this.m = paramFSPersonalInfo.a;
    this.n = paramFSPersonalInfo.b;
    a();
    a(paramFSPersonalInfo);
    this.l.setClickable(paramFSPersonalInfo.k ^ true);
  }
  
  public int getLayoutId()
  {
    return 2131624840;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.m == null)
    {
      QLog.i("FSPersonalInfoWidget", 1, "mStUser is null");
      return;
    }
    FSFollowView localFSFollowView = this.l;
    if ((localFSFollowView != null) && (localFSFollowView.getVisibility() == 0)) {
      FSLpReportDc11001.a(new DataBuilder(getReportBean()).setActionType(11).setSubActionType(3).setThrActionType(1).setToUin(this.m.id.get()));
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131437455)
    {
      if (!this.p.isEmpty()) {
        FSNativeLauncher.a(getContext(), this.p, null, -1);
      }
    }
    else if ((i1 == 2131437451) && (!this.o.isEmpty())) {
      FSNativeLauncher.a(getContext(), this.o, null, -1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((FSAvatarView)paramView.findViewById(2131436403));
    this.b = ((TextView)paramView.findViewById(2131448598));
    this.c = ((TextView)paramView.findViewById(2131448375));
    this.f = ((LinearLayout)paramView.findViewById(2131437556));
    this.d = ((ImageView)paramView.findViewById(2131436568));
    this.e = ((TextView)paramView.findViewById(2131448573));
    this.g = ((LinearLayout)paramView.findViewById(2131437451));
    this.h = ((LinearLayout)paramView.findViewById(2131437455));
    this.i = ((TextView)paramView.findViewById(2131448653));
    this.j = ((TextView)paramView.findViewById(2131448440));
    this.k = ((TextView)paramView.findViewById(2131448471));
    this.l = ((FSFollowView)paramView.findViewById(2131448467));
    setFollowReportListener(this.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.widget.FSPersonalInfoWidget
 * JD-Core Version:    0.7.0.1
 */