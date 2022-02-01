package com.tencent.mobileqq.search.activity;

import android.app.Activity;
import android.view.View;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.wtogether.api.IFileChooser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultPresenter.OnActionListener;

public class ContactSearchActivity$GroupFileSearchListener
  implements ContactSearchResultPresenter.OnActionListener
{
  int jdField_a_of_type_Int;
  Activity jdField_a_of_type_AndroidAppActivity;
  String jdField_a_of_type_JavaLangString;
  int b;
  
  public ContactSearchActivity$GroupFileSearchListener(Activity paramActivity, int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onAction(View paramView)
  {
    if (paramView != null)
    {
      Object localObject = paramView.getTag(2021012801);
      paramView = paramView.getTag(2021012802);
      if (((localObject instanceof String)) && ((paramView instanceof String)))
      {
        localObject = (String)localObject;
        paramView = (String)paramView;
        ((IFileChooser)QRoute.api(IFileChooser.class)).startAVGroupFileSelectFragment(this.jdField_a_of_type_AndroidAppActivity, AVUtil.a(paramView), (String)localObject, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, 2020);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.ContactSearchActivity.GroupFileSearchListener
 * JD-Core Version:    0.7.0.1
 */