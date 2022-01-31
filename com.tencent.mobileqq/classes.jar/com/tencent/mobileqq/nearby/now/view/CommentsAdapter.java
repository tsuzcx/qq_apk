package com.tencent.mobileqq.nearby.now.view;

import aeww;
import aewx;
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
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.ImageLoader;
import com.tencent.mobileqq.nearby.now.view.presenter.CommentsPresenter;
import com.tencent.mobileqq.util.FaceDrawable;
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
  private CommentsPresenter jdField_a_of_type_ComTencentMobileqqNearbyNowViewPresenterCommentsPresenter;
  private final String jdField_a_of_type_JavaLangString = "CommentsAdapter";
  public boolean a;
  private int jdField_b_of_type_Int = 2;
  private boolean jdField_b_of_type_Boolean;
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
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.size() > 0)) {
      if ((paramView == null) || (!(paramView.getTag() instanceof CommentsViewHolder)))
      {
        paramView = new CommentsViewHolder();
        localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970458, paramViewGroup, false);
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131370634));
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131363549));
        paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131361932));
        paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131370637));
        paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131370570));
        paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131370571));
        paramView.d = ((ImageView)((View)localObject).findViewById(2131370638));
        ((View)localObject).setTag(2131362449, paramView);
        paramViewGroup = paramView;
        paramView = (View)localObject;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_b_of_type_JavaLangString);
        if (((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_d_of_type_Long <= 0L) {
          break label595;
        }
        paramViewGroup.a(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_d_of_type_JavaLangString, ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_a_of_type_JavaLangString);
        label294:
        paramViewGroup.a(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_b_of_type_Long);
        localObject = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app;
        String str1 = ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_c_of_type_JavaLangString;
        String str2 = String.valueOf(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_c_of_type_Long);
        if (((str1 != null) && (!str1.isEmpty())) || (!str2.equals(((QQAppInterface)localObject).getCurrentAccountUin()))) {
          break label621;
        }
        localObject = FaceDrawable.a((AppInterface)localObject, 32, str2, 3, paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130842765), paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130842765));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        label445:
        paramViewGroup.a(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_a_of_type_ComTencentMobileqqNearbyNowModelMedalInfo, this.c, this.jdField_a_of_type_AndroidGraphicsPaint, this.jdField_b_of_type_Boolean);
        long l = ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_c_of_type_Long;
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aeww(this, l));
        if (((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_a_of_type_Int == 2) {
          paramViewGroup.d.setVisibility(0);
        }
        paramView.setTag(2131362450, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt));
        paramView.setTag(2131362451, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments);
        localObject = paramView;
      }
    }
    label595:
    label621:
    do
    {
      return localObject;
      paramViewGroup = (CommentsViewHolder)paramView.getTag();
      break;
      paramViewGroup.a(((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_a_of_type_JavaLangString);
      break label294;
      ImageLoader.a().a(paramViewGroup.jdField_a_of_type_AndroidWidgetImageView, ((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.a.get(paramInt)).jdField_c_of_type_JavaLangString, paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130842765), paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130842765), null, true);
      break label445;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a())
      {
        paramView = new View(this.jdField_a_of_type_AndroidContentContext);
        paramView.setLayoutParams(new AbsListView.LayoutParams(0, 0));
        return paramView;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if ((paramView != null) && ((paramView.getTag() instanceof String)) && ("badnet".equals((String)paramView.getTag()))) {}
        for (;;)
        {
          paramView.setBackgroundColor(Color.parseColor("#ffffff"));
          paramView.findViewById(2131370567).setOnClickListener(new aewx(this));
          paramView.setTag("badnet");
          return paramView;
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970447, paramViewGroup, false);
        }
      }
      if ((paramView == null) || (!(paramView.getTag() instanceof String))) {
        break label839;
      }
      localObject = paramView;
    } while ("empty".equals((String)paramView.getTag()));
    label839:
    paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970448, paramViewGroup, false);
    paramView.setTag("empty");
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.CommentsAdapter
 * JD-Core Version:    0.7.0.1
 */