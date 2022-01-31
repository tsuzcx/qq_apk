package com.tencent.mobileqq.search.presenter;

import ahgd;
import ahge;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.search.model.ContactSearchModelDiscussionMember;
import com.tencent.mobileqq.search.model.ContactSearchModelFriend;
import com.tencent.mobileqq.search.model.ContactSearchModelNewTroopMember;
import com.tencent.mobileqq.search.model.ContactSearchModelTool;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.ContactSearchResultView;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.Utils;

public class ContactSearchResultPresenter
  extends SearchResultPresenter
{
  private ContactSearchResultPresenter.OnActionListener a;
  
  public ContactSearchResultPresenter(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
  }
  
  public ContactSearchResultPresenter(FaceDecoder paramFaceDecoder, ContactSearchResultPresenter.OnActionListener paramOnActionListener)
  {
    super(paramFaceDecoder);
    this.a = paramOnActionListener;
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.a(paramISearchResultModel, paramISearchResultView);
    Object localObject;
    if (((paramISearchResultModel instanceof ContactSearchModelTool)) && (paramISearchResultModel.c() == null))
    {
      if (paramISearchResultView.g() != null) {
        paramISearchResultView.g().setVisibility(8);
      }
      if (paramISearchResultView.e() != null) {
        paramISearchResultView.e().setVisibility(8);
      }
      if (paramISearchResultView.f() != null) {
        paramISearchResultView.f().setVisibility(8);
      }
      localObject = ((ContactSearchResultView)paramISearchResultView).a();
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setText(paramISearchResultModel.a());
      }
      if ((SearchUtils.a) && (paramISearchResultView.a() != null) && ((paramISearchResultModel instanceof IContactSearchModel))) {
        paramISearchResultView.a().setOnLongClickListener(new ahgd(this, paramISearchResultModel));
      }
      return;
    }
    if ((paramISearchResultView.g() != null) && (!TextUtils.isEmpty(paramISearchResultModel.c())))
    {
      paramISearchResultView.g().setVisibility(0);
      label181:
      if (paramISearchResultView.e() != null) {
        paramISearchResultView.e().setVisibility(0);
      }
      if ((paramISearchResultView.f() != null) && (paramISearchResultModel.b() != null))
      {
        paramISearchResultView.f().setVisibility(0);
        if ((!(paramISearchResultModel instanceof ContactSearchModelFriend)) && (!(paramISearchResultModel instanceof ContactSearchModelDiscussionMember)) && (!(paramISearchResultModel instanceof ContactSearchModelNewTroopMember))) {
          break label401;
        }
        localObject = paramISearchResultModel.a();
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (!Utils.b((String)localObject))) {
          break label385;
        }
        localObject = paramISearchResultView.f().getContext().getResources().getDrawable(2130839745);
        ((Drawable)localObject).setBounds(0, 0, AIOUtils.a(15.0F, paramISearchResultView.f().getContext().getResources()), AIOUtils.a(15.0F, paramISearchResultView.f().getContext().getResources()));
        paramISearchResultView.f().setCompoundDrawables(null, null, (Drawable)localObject, null);
      }
    }
    for (;;)
    {
      localObject = ((ContactSearchResultView)paramISearchResultView).a();
      if (localObject == null) {
        break;
      }
      ((TextView)localObject).setVisibility(8);
      break;
      if (paramISearchResultView.g() == null) {
        break label181;
      }
      paramISearchResultView.g().setVisibility(8);
      break label181;
      label385:
      paramISearchResultView.f().setCompoundDrawables(null, null, null, null);
      continue;
      label401:
      paramISearchResultView.f().setCompoundDrawables(null, null, null, null);
    }
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView, Bitmap paramBitmap)
  {
    if (paramISearchResultModel.a() == 103)
    {
      if (paramISearchResultView.a() != null) {
        paramISearchResultView.a().setImageDrawable(SearchUtils.a(paramBitmap));
      }
      return;
    }
    super.a(paramISearchResultModel, paramISearchResultView, paramBitmap);
  }
  
  protected void d(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if (this.a != null)
    {
      if (paramISearchResultView.a() != null) {
        paramISearchResultView.a().setOnClickListener(new ahge(this));
      }
      return;
    }
    super.d(paramISearchResultModel, paramISearchResultView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */