package com.tencent.mobileqq.search.presenter;

import android.view.View;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.base.presenter.SearchResultPresenter;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultPresenter;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.mostused.MostUseConstants;
import com.tencent.qphone.base.util.QLog;

public class MostUsedResultPresenter
  extends SearchResultPresenter
{
  private MostUsedResultPresenter.OnActionListener a = null;
  private MiniProgramSearchResultPresenter b;
  private ContactSearchResultPresenter c;
  private ActiveEntitySearchResultPresenter d;
  
  public MostUsedResultPresenter(IFaceDecoder paramIFaceDecoder)
  {
    super(paramIFaceDecoder);
    this.b = new MiniProgramSearchResultPresenter(paramIFaceDecoder);
    this.c = new ContactSearchResultPresenter(paramIFaceDecoder);
    this.d = new ActiveEntitySearchResultPresenter(paramIFaceDecoder, 268435456);
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    boolean bool = paramISearchResultModel instanceof IContactSearchModel;
    if ((!bool) && (!(paramISearchResultModel instanceof GroupBaseNetSearchModelItem)))
    {
      QLog.e("MostUsedResultPresenter", 2, "unresolved model");
      return;
    }
    Object localObject;
    if (bool)
    {
      localObject = (IContactSearchModel)paramISearchResultModel;
      int i = MostUseConstants.a(((IContactSearchModel)localObject).o());
      if (i == 2)
      {
        this.b.a(paramISearchResultModel, paramISearchResultView);
        return;
      }
      if (i == 1)
      {
        this.c.a(paramISearchResultModel, paramISearchResultView);
        return;
      }
      paramISearchResultModel = new StringBuilder();
      paramISearchResultModel.append("unresolved id type");
      paramISearchResultModel.append(((IContactSearchModel)localObject).o());
      QLog.e("MostUsedResultPresenter", 2, paramISearchResultModel.toString());
      return;
    }
    if ((paramISearchResultModel instanceof GroupBaseNetSearchModelItem))
    {
      localObject = (GroupBaseNetSearchModelItem)paramISearchResultModel;
      if (MostUseConstants.a(((GroupBaseNetSearchModelItem)localObject).p()) == 3)
      {
        this.d.a(paramISearchResultModel, paramISearchResultView);
        return;
      }
      paramISearchResultModel = new StringBuilder();
      paramISearchResultModel.append("unresolved id type");
      paramISearchResultModel.append(((GroupBaseNetSearchModelItem)localObject).p());
      QLog.e("MostUsedResultPresenter", 2, paramISearchResultModel.toString());
    }
  }
  
  protected void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if (this.a != null)
    {
      if (paramISearchResultView.h() != null) {
        paramISearchResultView.h().setOnClickListener(new MostUsedResultPresenter.1(this));
      }
    }
    else {
      super.c(paramISearchResultModel, paramISearchResultView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.MostUsedResultPresenter
 * JD-Core Version:    0.7.0.1
 */