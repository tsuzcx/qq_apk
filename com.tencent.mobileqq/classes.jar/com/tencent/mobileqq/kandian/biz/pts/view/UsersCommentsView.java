package com.tencent.mobileqq.kandian.biz.pts.view;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeUsersCommentsView;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;

public class UsersCommentsView
  extends ViewBase
{
  private static String jdField_a_of_type_JavaLangString = "UsersCommentsView";
  private NativeUsersCommentsView jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeUsersCommentsView;
  
  public UsersCommentsView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeUsersCommentsView = new NativeUsersCommentsView(paramVafContext.getContext());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeUsersCommentsView.setOrientation(1);
  }
  
  public void clearDynamicData()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeUsersCommentsView.setComments(null);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeUsersCommentsView.setCommentAllLink(null);
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeUsersCommentsView.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeUsersCommentsView.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeUsersCommentsView;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeUsersCommentsView.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeUsersCommentsView.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeUsersCommentsView.a();
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if (!super.setAttribute(paramInt, paramObject))
    {
      if (paramInt != 1017) {
        return false;
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeUsersCommentsView.setComments((JSONArray)paramObject);
      }
      catch (Exception paramObject)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "UsersCommentsView", paramObject);
      }
    }
    return true;
  }
  
  protected boolean setAttribute(int paramInt, String paramString)
  {
    if (!super.setAttribute(paramInt, paramString))
    {
      if (paramInt != 1018) {
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeUsersCommentsView.setCommentAllLink(paramString);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.UsersCommentsView
 * JD-Core Version:    0.7.0.1
 */