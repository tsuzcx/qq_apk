package com.tencent.mobileqq.kandian.biz.feeds.presenter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyView;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.OnLastReadRefreshListener;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.pts.UtilsForComponent;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.CommentInfo;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;

public class ReadInJoyFooterPresenter
  implements IReadInJoyPresenter
{
  private Context a;
  private ReadInJoyView b;
  private IReadInJoyModel c;
  private ReadInJoyBaseAdapter d;
  private OnLastReadRefreshListener e;
  
  public ReadInJoyFooterPresenter(Context paramContext, OnLastReadRefreshListener paramOnLastReadRefreshListener, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.a = paramContext;
    this.e = paramOnLastReadRefreshListener;
    this.d = paramReadInJoyBaseAdapter;
  }
  
  public static List<articlesummary.PackJumpInfo> a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll(((articlesummary.SpecialTopicInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_special_topic_info.get()).rpt_jumps.get());
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      paramAbsBaseArticleInfo.printStackTrace();
    }
    if (localArrayList.isEmpty()) {
      QLog.w("ReadInJoyFooterPresenter", 1, "ReadInJoyFooter special topic link list empty");
    }
    return localArrayList;
  }
  
  private void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    int i = 0;
    List localList;
    for (;;)
    {
      localList = null;
      if (i >= 4) {
        break;
      }
      this.b.n[i].setOnClickListener(null);
      i += 1;
    }
    this.b.m.setOnClickListener(null);
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3) {
          localList = b(paramAbsBaseArticleInfo);
        }
      }
      else {
        localList = a(paramAbsBaseArticleInfo);
      }
    }
    else {
      a(paramInt, paramAbsBaseArticleInfo, null);
    }
    if ((localList != null) && (localList.size() == 1)) {
      a(paramInt, paramAbsBaseArticleInfo, (articlesummary.PackJumpInfo)localList.get(0));
    }
    if ((localList != null) && (localList.size() > 1))
    {
      i = 0;
      int j = 1;
      while (i < localList.size())
      {
        if (((articlesummary.PackJumpInfo)localList.get(i)).enum_style.get() != 2) {
          j = 0;
        }
        i += 1;
      }
      if (j != 0)
      {
        a(paramInt, paramAbsBaseArticleInfo, (articlesummary.PackJumpInfo)localList.get(0));
        return;
      }
      a(paramInt, paramAbsBaseArticleInfo, localList);
    }
  }
  
  private void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, List<articlesummary.PackJumpInfo> paramList)
  {
    this.b.m.setOnClickListener(null);
    paramInt = 0;
    int i;
    while (paramInt < 3)
    {
      this.b.n[paramInt].setVisibility(8);
      i = paramInt - 1;
      if ((i >= 0) && (i <= 1)) {
        this.b.o[i].setVisibility(8);
      }
      paramInt += 1;
    }
    this.b.n[3].setVisibility(8);
    paramAbsBaseArticleInfo = paramList.iterator();
    paramInt = 0;
    Object localObject1;
    while (paramAbsBaseArticleInfo.hasNext())
    {
      localObject1 = (articlesummary.PackJumpInfo)paramAbsBaseArticleInfo.next();
      if (((articlesummary.PackJumpInfo)localObject1).enum_style.get() == 2)
      {
        i = paramInt;
        if (paramInt == 0)
        {
          Object localObject2 = (RelativeLayout.LayoutParams)this.b.n[3].getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9, 0);
          this.b.n[3].setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.b.n[3].setVisibility(0);
          this.b.n[3].setText(((articlesummary.PackJumpInfo)localObject1).str_wording.get());
          localObject2 = ((articlesummary.PackJumpInfo)localObject1).str_url.get();
          localObject1 = ((articlesummary.PackJumpInfo)localObject1).str_wording.get();
          this.b.n[3].setOnClickListener(new ReadInJoyFooterPresenter.6(this, (String)localObject1, (String)localObject2));
          i = 1;
        }
        paramAbsBaseArticleInfo.remove();
        paramInt = i;
      }
    }
    paramInt = 0;
    while (paramInt < Math.min(3, paramList.size()))
    {
      this.b.n[paramInt].setVisibility(0);
      this.b.n[paramInt].setText(((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_wording.get());
      paramAbsBaseArticleInfo = ((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_url.get();
      localObject1 = ((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_wording.get();
      this.b.n[paramInt].setOnClickListener(new ReadInJoyFooterPresenter.7(this, (String)localObject1, paramAbsBaseArticleInfo));
      i = paramInt - 1;
      if ((i >= 0) && (i <= 1)) {
        this.b.o[i].setVisibility(0);
      }
      paramInt += 1;
    }
  }
  
  private void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, articlesummary.PackJumpInfo paramPackJumpInfo)
  {
    int i = 0;
    while (i < 3)
    {
      this.b.n[i].setVisibility(8);
      int j = i - 1;
      if ((j >= 0) && (j <= 1)) {
        this.b.o[j].setVisibility(8);
      }
      i += 1;
    }
    this.b.n[3].setVisibility(8);
    if (paramInt != 1)
    {
      if ((paramInt != 2) && (paramInt != 3)) {
        return;
      }
      paramAbsBaseArticleInfo = new ReadInJoyFooterPresenter.4(this, paramPackJumpInfo);
      if (paramPackJumpInfo.enum_style.get() == 2)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.b.n[3].getLayoutParams();
        localLayoutParams.addRule(11, 0);
        localLayoutParams.addRule(9, -1);
        this.b.n[3].setLayoutParams(localLayoutParams);
        this.b.n[3].setVisibility(0);
        this.b.n[3].setText(paramPackJumpInfo.str_wording.get());
        this.b.n[3].setOnClickListener(paramAbsBaseArticleInfo);
        this.b.m.setOnClickListener(paramAbsBaseArticleInfo);
        return;
      }
      this.b.n[0].setVisibility(0);
      this.b.n[0].setText(paramPackJumpInfo.str_wording.get());
      this.b.n[0].setOnClickListener(paramAbsBaseArticleInfo);
      this.b.m.setOnClickListener(paramAbsBaseArticleInfo);
      return;
    }
    paramPackJumpInfo = new ReadInJoyFooterPresenter.5(this, paramAbsBaseArticleInfo);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.b.n[3].getLayoutParams();
    localLayoutParams.addRule(11, 0);
    localLayoutParams.addRule(9, -1);
    this.b.n[3].setLayoutParams(localLayoutParams);
    this.b.n[3].setVisibility(0);
    this.b.n[3].setText(paramAbsBaseArticleInfo.mChannelInfoDisplayName);
    this.b.n[3].setOnClickListener(paramPackJumpInfo);
    this.b.m.setOnClickListener(paramPackJumpInfo);
  }
  
  public static void a(int paramInt, String paramString) {}
  
  public static List<articlesummary.PackJumpInfo> b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll(((articlesummary.FriendRecommendInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_jumps.get());
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      paramAbsBaseArticleInfo.printStackTrace();
    }
    if (localArrayList.isEmpty()) {
      QLog.w("ReadInJoyFooterPresenter", 1, "ReadInJoyFooter friend recommend link list empty");
    }
    return localArrayList;
  }
  
  private void c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (this.b.m != null)
    {
      View localView = this.b.m;
      int i;
      if (this.c.c()) {
        i = 0;
      } else {
        i = 8;
      }
      localView.setVisibility(i);
    }
    if (this.c.c())
    {
      this.b.c();
      a(this.c.d(), paramAbsBaseArticleInfo);
    }
  }
  
  private void d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (this.b.p != null)
    {
      View localView = this.b.p;
      int i;
      if (this.c.e()) {
        i = 0;
      } else {
        i = 8;
      }
      localView.setVisibility(i);
    }
    if (this.c.e())
    {
      this.b.d();
      this.b.q.setText(paramAbsBaseArticleInfo.mArticleFriendLikeText);
      if (paramAbsBaseArticleInfo.mCommentIconType != 1)
      {
        this.b.q.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        return;
      }
      paramAbsBaseArticleInfo = this.a.getResources().getDrawable(2130842767);
      this.b.q.setCompoundDrawablesWithIntrinsicBounds(paramAbsBaseArticleInfo, null, null, null);
    }
  }
  
  private void e(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject1;
    if (this.b.r != null)
    {
      localObject1 = this.b.r;
      int i;
      if (this.c.f()) {
        i = 0;
      } else {
        i = 8;
      }
      ((View)localObject1).setVisibility(i);
    }
    if (this.c.f())
    {
      this.b.e();
      this.b.r.setOnClickListener(null);
      localObject1 = (articlesummary.CommentInfo)paramAbsBaseArticleInfo.mCommentsObj.get(0);
      long l = ((articlesummary.CommentInfo)localObject1).uint64_uin.get();
      Object localObject2 = ((articlesummary.CommentInfo)localObject1).str_content.get();
      String str1 = ((articlesummary.CommentInfo)localObject1).str_jump_url.get();
      if (RIJQQAppInterfaceUtil.g()) {
        localObject1 = ContactUtils.d((QQAppInterface)ReadInJoyUtils.b(), String.valueOf(l));
      } else {
        localObject1 = this.d.e(l);
      }
      String str2 = RIJStringUtils.a((String)localObject1);
      if (str2 != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(str2);
        ((StringBuilder)localObject1).append(":  ");
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject1 = new SpannableString(((StringBuilder)localObject1).toString());
        ((SpannableString)localObject1).setSpan(new StatableSpanTextView.StatableForegroundColorSpan(this.a.getResources().getColor(2131168376)), 0, str2.length(), 33);
        this.b.s.setVisibility(0);
        localObject2 = this.b.s;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str2);
        localStringBuilder.append(":  ");
        ((TextView)localObject2).setText(localStringBuilder.toString());
      }
      else
      {
        localObject1 = new SpannableString((CharSequence)localObject2);
        this.b.s.setVisibility(8);
      }
      this.b.t.setText((CharSequence)localObject1);
      this.b.t.setOnClickListener(new ReadInJoyFooterPresenter.1(this, str1, paramAbsBaseArticleInfo));
      this.b.s.setOnClickListener(new ReadInJoyFooterPresenter.2(this, l, paramAbsBaseArticleInfo));
      if (this.c.h())
      {
        this.b.u.setVisibility(0);
        return;
      }
      this.b.u.setVisibility(8);
    }
  }
  
  private void f(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (this.b.v != null)
    {
      paramAbsBaseArticleInfo = this.b.v;
      int i;
      if (this.c.g()) {
        i = 0;
      } else {
        i = 8;
      }
      paramAbsBaseArticleInfo.setVisibility(i);
    }
    if (this.c.g())
    {
      paramAbsBaseArticleInfo = (LinearLayout.LayoutParams)this.b.v.getLayoutParams();
      UtilsForComponent.a(this.a, this.c, paramAbsBaseArticleInfo, this.b.v);
      this.b.v.setLayoutParams(paramAbsBaseArticleInfo);
    }
  }
  
  private void g(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (this.b.w != null)
    {
      paramAbsBaseArticleInfo = this.b.w;
      int i;
      if (this.c.i()) {
        i = 0;
      } else {
        i = 8;
      }
      paramAbsBaseArticleInfo.setVisibility(i);
    }
    if ((this.c.i()) && (this.b.f()))
    {
      this.b.w.setOnClickListener(new ReadInJoyFooterPresenter.3(this));
      ReadInJoyLogicEngineEventDispatcher.a().a(null);
    }
  }
  
  public void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, int paramInt)
  {
    this.b = paramReadInJoyView;
    this.c = paramIReadInJoyModel;
    paramReadInJoyView = this.c.k();
    if (paramReadInJoyView == null) {
      return;
    }
    c(paramReadInJoyView);
    d(paramReadInJoyView);
    e(paramReadInJoyView);
    f(paramReadInJoyView);
    g(paramReadInJoyView);
  }
  
  public void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, long paramLong, Bitmap paramBitmap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.presenter.ReadInJoyFooterPresenter
 * JD-Core Version:    0.7.0.1
 */