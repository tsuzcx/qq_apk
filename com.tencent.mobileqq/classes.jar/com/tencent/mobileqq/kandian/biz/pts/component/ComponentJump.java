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
  public View a;
  CmpCtxt a;
  public View[] a;
  public TextView[] a;
  
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
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setOnClickListener(null);
      i += 1;
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
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
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
    paramInt = 0;
    int i;
    while (paramInt < 3)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setVisibility(8);
      i = paramInt - 1;
      if ((i >= 0) && (i <= 1)) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[i].setVisibility(8);
      }
      paramInt += 1;
    }
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(8);
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
          Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9, 0);
          this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(0);
          this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setText(((articlesummary.PackJumpInfo)localObject1).str_wording.get());
          localObject2 = ((articlesummary.PackJumpInfo)localObject1).str_url.get();
          localObject1 = ((articlesummary.PackJumpInfo)localObject1).str_wording.get();
          this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setOnClickListener(new ComponentJump.3(this, (String)localObject1, (String)localObject2));
          i = 1;
        }
        paramAbsBaseArticleInfo.remove();
        paramInt = i;
      }
    }
    paramInt = 0;
    while (paramInt < Math.min(3, paramList.size()))
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setVisibility(0);
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setText(((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_wording.get());
      paramAbsBaseArticleInfo = ((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_url.get();
      localObject1 = ((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_wording.get();
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setOnClickListener(new ComponentJump.4(this, (String)localObject1, paramAbsBaseArticleInfo));
      i = paramInt - 1;
      if ((i >= 0) && (i <= 1)) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[i].setVisibility(0);
      }
      paramInt += 1;
    }
  }
  
  private void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, articlesummary.PackJumpInfo paramPackJumpInfo)
  {
    int i = 0;
    while (i < 3)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setVisibility(8);
      int j = i - 1;
      if ((j >= 0) && (j <= 1)) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[j].setVisibility(8);
      }
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(8);
    if (paramInt != 1)
    {
      if ((paramInt != 2) && (paramInt != 3)) {
        return;
      }
      paramAbsBaseArticleInfo = new ComponentJump.1(this, paramPackJumpInfo);
      if (paramPackJumpInfo.enum_style.get() == 2)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].getLayoutParams();
        localLayoutParams.addRule(11, 0);
        localLayoutParams.addRule(9, -1);
        this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(0);
        this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setText(paramPackJumpInfo.str_wording.get());
        this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setOnClickListener(paramAbsBaseArticleInfo);
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramAbsBaseArticleInfo);
        return;
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].setVisibility(0);
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].setText(paramPackJumpInfo.str_wording.get());
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].setOnClickListener(paramAbsBaseArticleInfo);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramAbsBaseArticleInfo);
      return;
    }
    paramPackJumpInfo = new ComponentJump.2(this, paramAbsBaseArticleInfo);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].getLayoutParams();
    localLayoutParams.addRule(11, 0);
    localLayoutParams.addRule(9, -1);
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(0);
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setText(paramAbsBaseArticleInfo.mChannelInfoDisplayName);
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setOnClickListener(paramPackJumpInfo);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramPackJumpInfo);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt = new CmpCtxt();
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[4];
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[2];
    a(paramContext);
    a();
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131560078, this, true);
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0] = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369596));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1] = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369598));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2] = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369600));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3] = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369601));
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = this.jdField_a_of_type_AndroidViewView.findViewById(2131369597);
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = this.jdField_a_of_type_AndroidViewView.findViewById(2131369599);
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a((IReadInJoyModel)paramObject);
      b();
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.b()) {
        i = 0;
      } else {
        i = 8;
      }
      setVisibility(i);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.b()) {
        a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.b(), this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a());
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentJump
 * JD-Core Version:    0.7.0.1
 */