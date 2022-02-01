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
  int a;
  int b;
  String c;
  Activity d;
  
  public ContactSearchActivity$GroupFileSearchListener(Activity paramActivity, int paramInt1, int paramInt2, String paramString)
  {
    this.d = paramActivity;
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramString;
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
        ((IFileChooser)QRoute.api(IFileChooser.class)).startAVGroupFileSelectFragment(this.d, AVUtil.c(paramView), (String)localObject, this.a, this.b, this.c, 2020);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.ContactSearchActivity.GroupFileSearchListener
 * JD-Core Version:    0.7.0.1
 */