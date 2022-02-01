package com.tencent.mobileqq.nearby.now.view.presenter;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.datasource.CommentsDataSource;
import com.tencent.mobileqq.nearby.now.datasource.CommentsDataSourceImpl;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.CommentsView;

public class CommentsPresenterImpl
  implements CommentsPresenter
{
  private int jdField_a_of_type_Int = 0;
  private CommentsDataSource jdField_a_of_type_ComTencentMobileqqNearbyNowDatasourceCommentsDataSource;
  private VideoData jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
  private CommentsView jdField_a_of_type_ComTencentMobileqqNearbyNowViewCommentsView;
  
  public CommentsPresenterImpl(CommentsView paramCommentsView, VideoData paramVideoData, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCommentsView = paramCommentsView;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowDatasourceCommentsDataSource = new CommentsDataSourceImpl(paramVideoData, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData = paramVideoData;
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
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowDatasourceCommentsDataSource.a(paramComment, new CommentsPresenterImpl.2(this));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCommentsView != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCommentsView.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowDatasourceCommentsDataSource.a(this.jdField_a_of_type_Int, new CommentsPresenterImpl.1(this));
  }
  
  public void b(Comments.Comment paramComment)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowDatasourceCommentsDataSource.a(paramComment, new CommentsPresenterImpl.3(this));
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCommentsView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.presenter.CommentsPresenterImpl
 * JD-Core Version:    0.7.0.1
 */