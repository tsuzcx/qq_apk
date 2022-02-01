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
import com.tencent.mobileqq.nearby.now.utils.IImageLoader;
import com.tencent.mobileqq.nearby.now.view.presenter.impl.CommentsPresenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
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
  private CommentsPresenter jdField_a_of_type_ComTencentMobileqqNearbyNowViewPresenterImplCommentsPresenter;
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
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPresenterImplCommentsPresenter = paramCommentsPresenter;
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
  
  public boolean a(Comments.Comment paramComment)
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a(paramComment);
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getview position is: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("CommentsAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.size() > 0))
    {
      if ((paramView != null) && ((paramView.getTag() instanceof CommentsViewHolder)))
      {
        localObject = (CommentsViewHolder)paramView.getTag();
        paramViewGroup = paramView;
        paramView = (View)localObject;
      }
      else
      {
        paramView = new CommentsViewHolder();
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561207, paramViewGroup, false);
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131369329));
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131379778));
        paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131379595));
        paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131379823));
        paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368255));
        paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131366474));
        paramView.d = ((ImageView)paramViewGroup.findViewById(2131379007));
        paramViewGroup.setTag(2131364954, paramView);
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_b_of_type_JavaLangString);
      if ((((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).e <= 0L) && (((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).f <= 0L)) {
        paramView.a(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_a_of_type_JavaLangString);
      } else {
        paramView.a(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_d_of_type_JavaLangString, ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_a_of_type_JavaLangString);
      }
      paramView.a(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_b_of_type_Long);
      localObject = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app;
      String str1 = ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_c_of_type_JavaLangString;
      String str2 = String.valueOf(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_c_of_type_Long);
      if (((str1 == null) || (str1.isEmpty())) && (str2.equals(((QQAppInterface)localObject).getCurrentAccountUin())))
      {
        localObject = FaceDrawable.getFaceDrawable((AppInterface)localObject, 32, str2, 3, paramView.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130845589), paramView.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130845589));
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      else
      {
        ((IImageLoader)QRoute.api(IImageLoader.class)).displayImage(paramView.jdField_a_of_type_AndroidWidgetImageView, ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_c_of_type_JavaLangString, paramView.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130845589), paramView.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130845589), null, true);
      }
      paramView.a(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_a_of_type_ComTencentMobileqqNearbyNowModelMedalInfo, this.c, this.jdField_a_of_type_AndroidGraphicsPaint, this.jdField_b_of_type_Boolean);
      long l1 = ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_c_of_type_Long;
      long l2 = ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_d_of_type_Long;
      long l3 = ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_b_of_type_Int;
      paramView.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new CommentsAdapter.1(this, l1, l2, l3));
      if (((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_a_of_type_Int == 2) {
        paramView.d.setVisibility(0);
      }
      paramViewGroup.setTag(2131364947, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt));
      paramViewGroup.setTag(2131364994, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments);
      return paramViewGroup;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a())
    {
      paramView = new View(this.jdField_a_of_type_AndroidContentContext);
      paramView.setLayoutParams(new AbsListView.LayoutParams(0, 0));
      return paramView;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if ((paramView == null) || (!(paramView.getTag() instanceof String)) || (!"badnet".equals((String)paramView.getTag()))) {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561197, paramViewGroup, false);
      }
      paramView.setBackgroundColor(Color.parseColor("#ffffff"));
      paramView.findViewById(2131370300).setOnClickListener(new CommentsAdapter.2(this));
      paramView.setTag("badnet");
      return paramView;
    }
    if ((paramView != null) && ((paramView.getTag() instanceof String)) && ("empty".equals((String)paramView.getTag()))) {
      return paramView;
    }
    paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561198, paramViewGroup, false);
    paramView.setTag("empty");
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.CommentsAdapter
 * JD-Core Version:    0.7.0.1
 */