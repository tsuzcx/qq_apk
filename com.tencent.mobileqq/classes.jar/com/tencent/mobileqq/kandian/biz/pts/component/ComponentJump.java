package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.feeds.presenter.ReadInJoyFooterPresenter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.PackJumpInfo;

public class ComponentJump
  extends RelativeLayout
  implements ComponentView
{
  CmpCtxt a;
  public View b;
  public TextView[] c;
  public View[] d;
  
  public ComponentJump(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentJump(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentJump(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
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
      this.c[i].setOnClickListener(null);
      i += 1;
    }
    this.b.setOnClickListener(null);
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3) {
          localList = ReadInJoyFooterPresenter.b(paramAbsBaseArticleInfo);
        }
      }
      else {
        localList = ReadInJoyFooterPresenter.a(paramAbsBaseArticleInfo);
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
    this.b.setOnClickListener(null);
    paramInt = 0;
    int i;
    while (paramInt < 3)
    {
      this.c[paramInt].setVisibility(8);
      i = paramInt - 1;
      if ((i >= 0) && (i <= 1)) {
        this.d[i].setVisibility(8);
      }
      paramInt += 1;
    }
    this.c[3].setVisibility(8);
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
          Object localObject2 = (RelativeLayout.LayoutParams)this.c[3].getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9, 0);
          this.c[3].setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.c[3].setVisibility(0);
          this.c[3].setText(((articlesummary.PackJumpInfo)localObject1).str_wording.get());
          localObject2 = ((articlesummary.PackJumpInfo)localObject1).str_url.get();
          localObject1 = ((articlesummary.PackJumpInfo)localObject1).str_wording.get();
          this.c[3].setOnClickListener(new ComponentJump.3(this, (String)localObject1, (String)localObject2));
          i = 1;
        }
        paramAbsBaseArticleInfo.remove();
        paramInt = i;
      }
    }
    paramInt = 0;
    while (paramInt < Math.min(3, paramList.size()))
    {
      this.c[paramInt].setVisibility(0);
      this.c[paramInt].setText(((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_wording.get());
      paramAbsBaseArticleInfo = ((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_url.get();
      localObject1 = ((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_wording.get();
      this.c[paramInt].setOnClickListener(new ComponentJump.4(this, (String)localObject1, paramAbsBaseArticleInfo));
      i = paramInt - 1;
      if ((i >= 0) && (i <= 1)) {
        this.d[i].setVisibility(0);
      }
      paramInt += 1;
    }
  }
  
  private void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, articlesummary.PackJumpInfo paramPackJumpInfo)
  {
    int i = 0;
    while (i < 3)
    {
      this.c[i].setVisibility(8);
      int j = i - 1;
      if ((j >= 0) && (j <= 1)) {
        this.d[j].setVisibility(8);
      }
      i += 1;
    }
    this.c[3].setVisibility(8);
    if (paramInt != 1)
    {
      if ((paramInt != 2) && (paramInt != 3)) {
        return;
      }
      paramAbsBaseArticleInfo = new ComponentJump.1(this, paramPackJumpInfo);
      if (paramPackJumpInfo.enum_style.get() == 2)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.c[3].getLayoutParams();
        localLayoutParams.addRule(11, 0);
        localLayoutParams.addRule(9, -1);
        this.c[3].setLayoutParams(localLayoutParams);
        this.c[3].setVisibility(0);
        this.c[3].setText(paramPackJumpInfo.str_wording.get());
        this.c[3].setOnClickListener(paramAbsBaseArticleInfo);
        this.b.setOnClickListener(paramAbsBaseArticleInfo);
        return;
      }
      this.c[0].setVisibility(0);
      this.c[0].setText(paramPackJumpInfo.str_wording.get());
      this.c[0].setOnClickListener(paramAbsBaseArticleInfo);
      this.b.setOnClickListener(paramAbsBaseArticleInfo);
      return;
    }
    paramPackJumpInfo = new ComponentJump.2(this, paramAbsBaseArticleInfo);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.c[3].getLayoutParams();
    localLayoutParams.addRule(11, 0);
    localLayoutParams.addRule(9, -1);
    this.c[3].setLayoutParams(localLayoutParams);
    this.c[3].setVisibility(0);
    this.c[3].setText(paramAbsBaseArticleInfo.mChannelInfoDisplayName);
    this.c[3].setOnClickListener(paramPackJumpInfo);
    this.b.setOnClickListener(paramPackJumpInfo);
  }
  
  private void b(Context paramContext)
  {
    this.a = new CmpCtxt();
    this.c = new TextView[4];
    this.d = new View[2];
    a(paramContext);
    a();
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    this.b = LayoutInflater.from(paramContext).inflate(2131626125, this, true);
    this.c[0] = ((TextView)this.b.findViewById(2131436704));
    this.c[1] = ((TextView)this.b.findViewById(2131436706));
    this.c[2] = ((TextView)this.b.findViewById(2131436708));
    this.c[3] = ((TextView)this.b.findViewById(2131436709));
    this.d[0] = this.b.findViewById(2131436705);
    this.d[1] = this.b.findViewById(2131436707);
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.a.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      this.a.a((IReadInJoyModel)paramObject);
      b();
      int i;
      if (this.a.a.c()) {
        i = 0;
      } else {
        i = 8;
      }
      setVisibility(i);
      if (this.a.a.c()) {
        a(this.a.a.d(), this.a.a.k());
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentJump
 * JD-Core Version:    0.7.0.1
 */