package com.tencent.mobileqq.search.presenter;

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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.model.ContactSearchModelDiscussionMember;
import com.tencent.mobileqq.search.model.ContactSearchModelFriend;
import com.tencent.mobileqq.search.model.ContactSearchModelGlobalTroopMember;
import com.tencent.mobileqq.search.model.ContactSearchModelNewTroopMember;
import com.tencent.mobileqq.search.model.ContactSearchModelRecentUser;
import com.tencent.mobileqq.search.model.ContactSearchModelTool;
import com.tencent.mobileqq.search.model.ContactSearchModelTroop;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.ContactSearchResultView;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.Utils;
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
    this.jdField_a_of_type_ComTencentMobileqqSearchPresenterContactSearchResultPresenter$OnActionListener = null;
  }
  
  public ContactSearchResultPresenter(IFaceDecoder paramIFaceDecoder, ContactSearchResultPresenter.OnActionListener paramOnActionListener)
  {
    super(paramIFaceDecoder);
    this.jdField_a_of_type_ComTencentMobileqqSearchPresenterContactSearchResultPresenter$OnActionListener = null;
    this.jdField_a_of_type_ComTencentMobileqqSearchPresenterContactSearchResultPresenter$OnActionListener = paramOnActionListener;
  }
  
  public ContactSearchResultPresenter(IFaceDecoder paramIFaceDecoder, ContactSearchResultPresenter.OnActionListener paramOnActionListener, Set<String> paramSet)
  {
    super(paramIFaceDecoder);
    this.jdField_a_of_type_ComTencentMobileqqSearchPresenterContactSearchResultPresenter$OnActionListener = null;
    this.jdField_a_of_type_ComTencentMobileqqSearchPresenterContactSearchResultPresenter$OnActionListener = paramOnActionListener;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
  }
  
  private void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1002);
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("param_entrance", 29);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(SelectMemberActivity.a(paramString, "", 0, paramString));
    localIntent.putExtra("param_selected_records_for_create_discussion", localArrayList);
    paramActivity.startActivityForResult(localIntent, 1300);
  }
  
  private void e(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if (((paramISearchResultView instanceof ContactSearchResultView)) && ((paramISearchResultModel instanceof ContactSearchModelTroop)) && (((ContactSearchModelTroop)paramISearchResultModel).a == 3) && (paramISearchResultView.a() != null))
    {
      TextView localTextView = (TextView)paramISearchResultView.a().findViewById(2131376900);
      paramISearchResultModel = ((ContactSearchModelTroop)paramISearchResultModel).f();
      if ((localTextView != null) && (!TextUtils.isEmpty(paramISearchResultModel)))
      {
        localTextView.setVisibility(0);
        localTextView.setText(paramISearchResultModel);
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
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView, Bitmap paramBitmap)
  {
    if (paramISearchResultModel.c() == 103)
    {
      if (paramISearchResultView.b() != null) {
        paramISearchResultView.b().setImageDrawable(SearchUtils.a(paramBitmap));
      }
      return;
    }
    super.a(paramISearchResultModel, paramISearchResultView, paramBitmap);
  }
  
  public void b(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.b(paramISearchResultModel, paramISearchResultView);
    Object localObject;
    if (((paramISearchResultModel instanceof ContactSearchModelTool)) && (paramISearchResultModel.c() == null))
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
      localObject = ((ContactSearchResultView)paramISearchResultView).e();
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setText(paramISearchResultModel.a());
      }
      localObject = paramISearchResultView.a().findViewById(2131380575);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(8);
        if ((((paramISearchResultModel instanceof ContactSearchModelGlobalTroopMember)) || ((paramISearchResultModel instanceof ContactSearchModelRecentUser)) || ((paramISearchResultModel instanceof ContactSearchModelFriend))) && (SearchUtil.a(paramISearchResultModel.b()))) {
          ((View)localObject).setVisibility(0);
        }
      }
      if (paramISearchResultView.c() != null)
      {
        localObject = paramISearchResultModel.b();
        if ((this.jdField_a_of_type_JavaUtilSet != null) && (this.jdField_a_of_type_JavaUtilSet.contains(localObject))) {
          paramISearchResultView.c().setText(HardCodeUtil.a(2131702610));
        }
      }
      e(paramISearchResultModel, paramISearchResultView);
      if ((SearchUtils.a) && (paramISearchResultView.a() != null) && ((paramISearchResultModel instanceof IContactSearchModel))) {
        paramISearchResultView.a().setOnLongClickListener(new ContactSearchResultPresenter.1(this, paramISearchResultModel));
      }
      if ((paramISearchResultView.a() != null) && ((paramISearchResultModel instanceof ContactSearchModelFriend)))
      {
        int i = ((ContactSearchModelFriend)paramISearchResultModel).f();
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchResultPresenter", 2, "add from type =" + i);
        }
        if ((i == 21) || (i == 1) || (i == 2))
        {
          paramISearchResultView = paramISearchResultView.a();
          paramISearchResultView.setContentDescription(paramISearchResultView.getContext().getString(2131699103));
          paramISearchResultView.setImageResource(2130846337);
          paramISearchResultView.setOnClickListener(new ContactSearchResultPresenter.2(this, paramISearchResultModel));
        }
      }
      return;
    }
    if ((paramISearchResultView.c() != null) && (!TextUtils.isEmpty(paramISearchResultModel.c())))
    {
      paramISearchResultView.c().setVisibility(0);
      label418:
      if (paramISearchResultView.a() != null) {
        paramISearchResultView.a().setVisibility(0);
      }
      if ((paramISearchResultView.b() == null) || (paramISearchResultModel.b() == null)) {
        break label674;
      }
      paramISearchResultView.b().setVisibility(0);
      if ((!(paramISearchResultModel instanceof ContactSearchModelFriend)) && (!(paramISearchResultModel instanceof ContactSearchModelDiscussionMember)) && (!(paramISearchResultModel instanceof ContactSearchModelNewTroopMember))) {
        break label658;
      }
      localObject = paramISearchResultModel.b();
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!Utils.b((String)localObject))) {
        break label642;
      }
      localObject = paramISearchResultView.b().getContext().getResources().getDrawable(2130841947);
      ((Drawable)localObject).setBounds(0, 0, AIOUtils.a(15.0F, paramISearchResultView.b().getContext().getResources()), AIOUtils.a(15.0F, paramISearchResultView.b().getContext().getResources()));
      ThemeUtil.setThemeFilter((Drawable)localObject, ThemeUtil.curThemeId);
      paramISearchResultView.b().setCompoundDrawables(null, null, (Drawable)localObject, null);
    }
    for (;;)
    {
      localObject = ((ContactSearchResultView)paramISearchResultView).e();
      if (localObject == null) {
        break;
      }
      ((TextView)localObject).setVisibility(8);
      break;
      if (paramISearchResultView.c() == null) {
        break label418;
      }
      paramISearchResultView.c().setVisibility(8);
      break label418;
      label642:
      paramISearchResultView.b().setCompoundDrawables(null, null, null, null);
      continue;
      label658:
      paramISearchResultView.b().setCompoundDrawables(null, null, null, null);
      continue;
      label674:
      if (paramISearchResultView.b() != null) {
        paramISearchResultView.b().setVisibility(8);
      }
    }
  }
  
  protected void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchPresenterContactSearchResultPresenter$OnActionListener != null)
    {
      String str;
      if (paramISearchResultView.a() != null)
      {
        if (!(paramISearchResultModel instanceof ContactSearchModelTroop)) {
          break label72;
        }
        str = ((ContactSearchModelTroop)paramISearchResultModel).a().getTroopDisplayName();
        if (!(paramISearchResultModel instanceof ContactSearchModelTroop)) {
          break label78;
        }
      }
      label72:
      label78:
      for (paramISearchResultModel = ((ContactSearchModelTroop)paramISearchResultModel).a().getTroopUin();; paramISearchResultModel = "")
      {
        paramISearchResultView.a().setOnClickListener(new ContactSearchResultPresenter.3(this, str, paramISearchResultModel));
        return;
        str = "";
        break;
      }
    }
    super.c(paramISearchResultModel, paramISearchResultView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */