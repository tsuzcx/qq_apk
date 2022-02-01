package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.CommentInfo;

public class ComponentComment
  extends FrameLayout
  implements ComponentView
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  CmpCtxt jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
  TextView b;
  
  public ComponentComment(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentComment(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentComment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131560073, this, true);
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131364951);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131364988));
    this.b = ((TextView)paramContext.findViewById(2131364986));
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
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.d()) {
        i = 0;
      } else {
        i = 8;
      }
      setVisibility(i);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.d())
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
        paramObject = (articlesummary.CommentInfo)localAbsBaseArticleInfo.mCommentsObj.get(0);
        long l = paramObject.uint64_uin.get();
        Object localObject = paramObject.str_content.get();
        String str1 = paramObject.str_jump_url.get();
        if (RIJQQAppInterfaceUtil.a()) {
          paramObject = ContactUtils.d((QQAppInterface)ReadInJoyUtils.a(), String.valueOf(l));
        } else {
          paramObject = ((ReadInJoyBaseAdapter)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a()).a(l);
        }
        String str2 = RIJStringUtils.a(paramObject);
        if (str2 != null)
        {
          paramObject = new StringBuilder();
          paramObject.append(str2);
          paramObject.append(":  ");
          paramObject.append((String)localObject);
          paramObject = new SpannableString(paramObject.toString());
          paramObject.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(getContext().getResources().getColor(2131167333)), 0, str2.length(), 33);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          localObject = this.jdField_a_of_type_AndroidWidgetTextView;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str2);
          localStringBuilder.append(":  ");
          ((TextView)localObject).setText(localStringBuilder.toString());
        }
        else
        {
          paramObject = new SpannableString((CharSequence)localObject);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        this.b.setText(paramObject);
        this.b.setOnClickListener(new ComponentComment.1(this, str1, localAbsBaseArticleInfo));
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ComponentComment.2(this, l, localAbsBaseArticleInfo));
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.f())
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          return;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentComment
 * JD-Core Version:    0.7.0.1
 */