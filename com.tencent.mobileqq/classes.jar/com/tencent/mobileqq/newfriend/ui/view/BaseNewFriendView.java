package com.tencent.mobileqq.newfriend.ui.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;

public class BaseNewFriendView
  extends FrameLayout
{
  protected Intent a;
  protected AppInterface a;
  public BaseNewFriendView.INewFriendContext a;
  private boolean a;
  private boolean b = false;
  
  public BaseNewFriendView(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void a()
  {
    this.b = false;
    if (!a()) {
      this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewBaseNewFriendView$INewFriendContext.b();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getForwardSelectionRequest() == paramInt1) && (paramInt2 != 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewBaseNewFriendView$INewFriendContext.getActivity().setResult(paramInt2, paramIntent);
      g();
    }
  }
  
  protected void a(Intent paramIntent, BaseNewFriendView.INewFriendContext paramINewFriendContext)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewBaseNewFriendView$INewFriendContext = paramINewFriendContext;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewBaseNewFriendView$INewFriendContext.a());
  }
  
  protected final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.b)
    {
      this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewBaseNewFriendView$INewFriendContext.c();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewBaseNewFriendView$INewFriendContext.b();
  }
  
  public void c() {}
  
  public void d() {}
  
  protected final void d(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
  }
  
  public void e()
  {
    a();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void f() {}
  
  protected void g()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewBaseNewFriendView$INewFriendContext.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.view.BaseNewFriendView
 * JD-Core Version:    0.7.0.1
 */