package com.tencent.mobileqq.nearby.now.view.presenter.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.datasource.CommentsDataSource;
import com.tencent.mobileqq.nearby.now.datasource.CommentsDataSourceImpl;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.CommentsView;

public class CommentsPresenter
{
  private int jdField_a_of_type_Int = 0;
  private CommentsDataSource jdField_a_of_type_ComTencentMobileqqNearbyNowDatasourceCommentsDataSource;
  private VideoData jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
  private CommentsView jdField_a_of_type_ComTencentMobileqqNearbyNowViewCommentsView;
  
  public CommentsPresenter(CommentsView paramCommentsView, Object paramObject, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCommentsView = paramCommentsView;
    paramCommentsView = (VideoData)paramObject;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowDatasourceCommentsDataSource = new CommentsDataSourceImpl(paramCommentsView, (QQAppInterface)paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData = paramCommentsView;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    b();
  }
  
  public void a(Comments.Comment paramComment)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowDatasourceCommentsDataSource.a(paramComment, new CommentsPresenter.2(this));
  }
  
  public void b()
  {
    CommentsView localCommentsView = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCommentsView;
    if (localCommentsView != null) {
      localCommentsView.showLoading();
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowDatasourceCommentsDataSource.a(this.jdField_a_of_type_Int, new CommentsPresenter.1(this));
  }
  
  public void b(Comments.Comment paramComment)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowDatasourceCommentsDataSource.a(paramComment, new CommentsPresenter.3(this));
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCommentsView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.presenter.impl.CommentsPresenter
 * JD-Core Version:    0.7.0.1
 */