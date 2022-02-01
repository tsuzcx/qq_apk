package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.ImageLoader;
import com.tencent.mobileqq.nearby.now.view.presenter.CommentsPresenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class CommentsAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private Comments jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments;
  private VideoData jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
  private CommentsPresenter jdField_a_of_type_ComTencentMobileqqNearbyNowViewPresenterCommentsPresenter;
  private final String jdField_a_of_type_JavaLangString = "CommentsAdapter";
  public boolean a;
  private int jdField_b_of_type_Int = 2;
  private boolean jdField_b_of_type_Boolean = false;
  private int c;
  
  public CommentsAdapter(Context paramContext, Comments paramComments, VideoData paramVideoData, CommentsPresenter paramCommentsPresenter, Paint paramPaint, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments = paramComments;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData = paramVideoData;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPresenterCommentsPresenter = paramCommentsPresenter;
    this.jdField_a_of_type_AndroidGraphicsPaint = paramPaint;
    this.c = paramInt;
  }
  
  public Comments.Comment a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.size())) {
      return (Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt);
    }
    return null;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.size() > 0)) {
      return this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.size();
    }
    return 1;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommentsAdapter", 2, "getview position is: " + paramInt);
    }
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.size() > 0)) {
      if ((paramView == null) || (!(paramView.getTag() instanceof CommentsViewHolder)))
      {
        localObject1 = new CommentsViewHolder();
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561368, paramViewGroup, false);
        ((CommentsViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369623));
        ((CommentsViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380475));
        ((CommentsViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380283));
        ((CommentsViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380528));
        ((CommentsViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368507));
        ((CommentsViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366605));
        ((CommentsViewHolder)localObject1).d = ((ImageView)paramView.findViewById(2131379665));
        paramView.setTag(2131365071, localObject1);
        ((CommentsViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_b_of_type_JavaLangString);
        if ((((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).e <= 0L) && (((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).f <= 0L)) {
          break label685;
        }
        ((CommentsViewHolder)localObject1).a(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_d_of_type_JavaLangString, ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_a_of_type_JavaLangString);
        label315:
        ((CommentsViewHolder)localObject1).a(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_b_of_type_Long);
        Object localObject2 = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app;
        String str1 = ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_c_of_type_JavaLangString;
        String str2 = String.valueOf(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_c_of_type_Long);
        if (((str1 != null) && (!str1.isEmpty())) || (!str2.equals(((QQAppInterface)localObject2).getCurrentAccountUin()))) {
          break label712;
        }
        localObject2 = FaceDrawable.getFaceDrawable((AppInterface)localObject2, 32, str2, 3, ((CommentsViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130845716), ((CommentsViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130845716));
        ((CommentsViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
        label470:
        ((CommentsViewHolder)localObject1).a(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_a_of_type_ComTencentMobileqqNearbyNowModelMedalInfo, this.c, this.jdField_a_of_type_AndroidGraphicsPaint, this.jdField_b_of_type_Boolean);
        long l1 = ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_c_of_type_Long;
        long l2 = ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_d_of_type_Long;
        long l3 = ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_b_of_type_Int;
        ((CommentsViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new CommentsAdapter.1(this, l1, l2, l3));
        if (((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_a_of_type_Int == 2) {
          ((CommentsViewHolder)localObject1).d.setVisibility(0);
        }
        paramView.setTag(2131365064, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt));
        paramView.setTag(2131365114, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments);
      }
    }
    for (;;)
    {
      label653:
      for (localObject1 = paramView;; localObject1 = paramView)
      {
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject1 = (CommentsViewHolder)paramView.getTag();
        break;
        label685:
        ((CommentsViewHolder)localObject1).a(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_a_of_type_JavaLangString);
        break label315;
        label712:
        ImageLoader.a().a(((CommentsViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView, ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_c_of_type_JavaLangString, ((CommentsViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130845716), ((CommentsViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130845716), null, true);
        break label470;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a())
        {
          paramView = new View(this.jdField_a_of_type_AndroidContentContext);
          paramView.setLayoutParams(new AbsListView.LayoutParams(0, 0));
          break label653;
        }
        if (this.jdField_a_of_type_Boolean)
        {
          if ((paramView != null) && ((paramView.getTag() instanceof String)) && ("badnet".equals((String)paramView.getTag()))) {}
          for (;;)
          {
            paramView.setBackgroundColor(Color.parseColor("#ffffff"));
            paramView.findViewById(2131370658).setOnClickListener(new CommentsAdapter.2(this));
            paramView.setTag("badnet");
            break;
            paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561358, paramViewGroup, false);
          }
        }
        if ((paramView == null) || (!(paramView.getTag() instanceof String)) || (!"empty".equals((String)paramView.getTag()))) {
          break label938;
        }
      }
      label938:
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561359, paramViewGroup, false);
      paramView.setTag("empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.CommentsAdapter
 * JD-Core Version:    0.7.0.1
 */