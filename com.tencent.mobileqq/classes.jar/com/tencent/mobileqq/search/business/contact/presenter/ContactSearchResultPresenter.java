package com.tencent.mobileqq.search.business.contact.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.base.presenter.SearchResultPresenter;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelDiscussionMember;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelFriend;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelGlobalTroopMember;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelNewTroopMember;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelRecentUser;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelTool;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelTroop;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.business.contact.view.ContactSearchResultView;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.selectmember.SelectMemberUtils;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Set;

public class ContactSearchResultPresenter
  extends SearchResultPresenter
{
  private ContactSearchResultPresenter.OnActionListener a;
  protected Set<String> a;
  
  public ContactSearchResultPresenter(IFaceDecoder paramIFaceDecoder)
  {
    super(paramIFaceDecoder);
    this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactPresenterContactSearchResultPresenter$OnActionListener = null;
  }
  
  public ContactSearchResultPresenter(IFaceDecoder paramIFaceDecoder, ContactSearchResultPresenter.OnActionListener paramOnActionListener)
  {
    super(paramIFaceDecoder);
    this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactPresenterContactSearchResultPresenter$OnActionListener = null;
    this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactPresenterContactSearchResultPresenter$OnActionListener = paramOnActionListener;
  }
  
  public ContactSearchResultPresenter(IFaceDecoder paramIFaceDecoder, ContactSearchResultPresenter.OnActionListener paramOnActionListener, Set<String> paramSet)
  {
    super(paramIFaceDecoder);
    this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactPresenterContactSearchResultPresenter$OnActionListener = null;
    this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactPresenterContactSearchResultPresenter$OnActionListener = paramOnActionListener;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
  }
  
  private void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1002);
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("param_entrance", 29);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(SelectMemberUtils.a(paramString, "", 0, paramString));
    localIntent.putExtra("param_selected_records_for_create_discussion", localArrayList);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(paramActivity, localIntent, 1300);
  }
  
  private void e(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if (((paramISearchResultView instanceof ContactSearchResultView)) && ((paramISearchResultModel instanceof ContactSearchModelTroop)))
    {
      Object localObject = (ContactSearchModelTroop)paramISearchResultModel;
      if ((((ContactSearchModelTroop)localObject).a == 3) && (paramISearchResultView.a() != null))
      {
        paramISearchResultModel = (TextView)paramISearchResultView.a().findViewById(2131376389);
        localObject = ((ContactSearchModelTroop)localObject).f();
        if ((paramISearchResultModel != null) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          paramISearchResultModel.setVisibility(0);
          paramISearchResultModel.setText((CharSequence)localObject);
        }
        paramISearchResultModel = paramISearchResultView.a();
        if (paramISearchResultModel != null)
        {
          paramISearchResultView = (RelativeLayout.LayoutParams)paramISearchResultModel.getLayoutParams();
          if (paramISearchResultView != null)
          {
            paramISearchResultView.addRule(15, 0);
            paramISearchResultModel.setLayoutParams(paramISearchResultView);
          }
        }
      }
    }
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.a(paramISearchResultModel, paramISearchResultView);
    if (((paramISearchResultModel instanceof ContactSearchModelTool)) && (paramISearchResultModel.a() == null))
    {
      if (paramISearchResultView.c() != null) {
        paramISearchResultView.c().setVisibility(8);
      }
      if (paramISearchResultView.a() != null) {
        paramISearchResultView.a().setVisibility(8);
      }
      if (paramISearchResultView.b() != null) {
        paramISearchResultView.b().setVisibility(8);
      }
      localObject1 = ((ContactSearchResultView)paramISearchResultView).e();
      if (localObject1 != null)
      {
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setText(paramISearchResultModel.b());
      }
    }
    else
    {
      if ((paramISearchResultView.c() != null) && (!TextUtils.isEmpty(paramISearchResultModel.a()))) {
        paramISearchResultView.c().setVisibility(0);
      } else if (paramISearchResultView.c() != null) {
        paramISearchResultView.c().setVisibility(8);
      }
      if (paramISearchResultView.a() != null) {
        paramISearchResultView.a().setVisibility(0);
      }
      if ((paramISearchResultView.b() != null) && (paramISearchResultModel.c() != null))
      {
        paramISearchResultView.b().setVisibility(0);
        if ((!(paramISearchResultModel instanceof ContactSearchModelFriend)) && (!(paramISearchResultModel instanceof ContactSearchModelDiscussionMember)) && (!(paramISearchResultModel instanceof ContactSearchModelNewTroopMember)))
        {
          paramISearchResultView.b().setCompoundDrawables(null, null, null, null);
        }
        else
        {
          localObject1 = paramISearchResultModel.a();
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (Utils.b((String)localObject1)))
          {
            localObject1 = paramISearchResultView.b().getContext().getResources().getDrawable(2130841838);
            ((Drawable)localObject1).setBounds(0, 0, SearchUtils.a(15.0F, paramISearchResultView.b().getContext().getResources()), SearchUtils.a(15.0F, paramISearchResultView.b().getContext().getResources()));
            ThemeUtil.setThemeFilter((Drawable)localObject1, ThemeUtil.curThemeId);
            paramISearchResultView.b().setCompoundDrawables(null, null, (Drawable)localObject1, null);
          }
          else
          {
            paramISearchResultView.b().setCompoundDrawables(null, null, null, null);
          }
        }
      }
      else if (paramISearchResultView.b() != null)
      {
        paramISearchResultView.b().setVisibility(8);
      }
      localObject1 = ((ContactSearchResultView)paramISearchResultView).e();
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
    }
    Object localObject1 = paramISearchResultView.a().findViewById(2131379859);
    Object localObject2;
    if (localObject1 != null)
    {
      ((View)localObject1).setVisibility(8);
      if (((paramISearchResultModel instanceof ContactSearchModelGlobalTroopMember)) || ((paramISearchResultModel instanceof ContactSearchModelRecentUser)) || ((paramISearchResultModel instanceof ContactSearchModelFriend)))
      {
        localObject2 = paramISearchResultModel.a();
        if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isRobotUin((String)localObject2)) {
          ((View)localObject1).setVisibility(0);
        }
      }
    }
    if (paramISearchResultView.c() != null)
    {
      localObject1 = paramISearchResultModel.a();
      localObject2 = this.jdField_a_of_type_JavaUtilSet;
      if ((localObject2 != null) && (((Set)localObject2).contains(localObject1))) {
        paramISearchResultView.c().setText(HardCodeUtil.a(2131702742));
      }
    }
    e(paramISearchResultModel, paramISearchResultView);
    if ((SearchUtils.a) && (paramISearchResultView.a() != null) && ((paramISearchResultModel instanceof IContactSearchModel))) {
      paramISearchResultView.a().setOnLongClickListener(new ContactSearchResultPresenter.1(this, paramISearchResultModel));
    }
    if ((paramISearchResultView.a() != null) && ((paramISearchResultModel instanceof ContactSearchModelFriend)))
    {
      int i = ((ContactSearchModelFriend)paramISearchResultModel).f();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("add from type =");
        ((StringBuilder)localObject1).append(i);
        QLog.d("ContactSearchResultPresenter", 2, ((StringBuilder)localObject1).toString());
      }
      if ((i == 21) || (i == 1) || (i == 2))
      {
        paramISearchResultView = paramISearchResultView.a();
        paramISearchResultView.setContentDescription(paramISearchResultView.getContext().getString(2131699207));
        paramISearchResultView.setImageResource(2130846210);
        paramISearchResultView.setOnClickListener(new ContactSearchResultPresenter.2(this, paramISearchResultModel));
      }
    }
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView, Bitmap paramBitmap)
  {
    if (paramISearchResultModel.a() == 103)
    {
      if (paramISearchResultView.b() != null) {
        paramISearchResultView.b().setImageDrawable(SearchUtils.a(paramBitmap));
      }
    }
    else {
      super.a(paramISearchResultModel, paramISearchResultView, paramBitmap);
    }
  }
  
  protected void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactPresenterContactSearchResultPresenter$OnActionListener != null)
    {
      if (paramISearchResultView.a() != null)
      {
        boolean bool = paramISearchResultModel instanceof ContactSearchModelTroop;
        String str2 = "";
        String str1;
        if (bool) {
          str1 = ((ContactSearchModelTroop)paramISearchResultModel).a().getTroopDisplayName();
        } else {
          str1 = "";
        }
        if (bool) {
          str2 = ((ContactSearchModelTroop)paramISearchResultModel).a().getTroopUin();
        }
        paramISearchResultView.a().setOnClickListener(new ContactSearchResultPresenter.3(this, str1, str2));
      }
    }
    else {
      super.c(paramISearchResultModel, paramISearchResultView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */