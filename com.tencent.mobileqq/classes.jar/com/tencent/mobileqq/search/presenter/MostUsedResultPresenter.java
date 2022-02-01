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
  private ContactSearchResultPresenter jdField_a_of_type_ComTencentMobileqqSearchBusinessContactPresenterContactSearchResultPresenter;
  private ActiveEntitySearchResultPresenter jdField_a_of_type_ComTencentMobileqqSearchPresenterActiveEntitySearchResultPresenter;
  private MiniProgramSearchResultPresenter jdField_a_of_type_ComTencentMobileqqSearchPresenterMiniProgramSearchResultPresenter;
  private MostUsedResultPresenter.OnActionListener jdField_a_of_type_ComTencentMobileqqSearchPresenterMostUsedResultPresenter$OnActionListener = null;
  
  public MostUsedResultPresenter(IFaceDecoder paramIFaceDecoder)
  {
    super(paramIFaceDecoder);
    this.jdField_a_of_type_ComTencentMobileqqSearchPresenterMiniProgramSearchResultPresenter = new MiniProgramSearchResultPresenter(paramIFaceDecoder);
    this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactPresenterContactSearchResultPresenter = new ContactSearchResultPresenter(paramIFaceDecoder);
    this.jdField_a_of_type_ComTencentMobileqqSearchPresenterActiveEntitySearchResultPresenter = new ActiveEntitySearchResultPresenter(paramIFaceDecoder, 268435456);
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
      int i = MostUseConstants.a(((IContactSearchModel)localObject).e());
      if (i == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchPresenterMiniProgramSearchResultPresenter.a(paramISearchResultModel, paramISearchResultView);
        return;
      }
      if (i == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactPresenterContactSearchResultPresenter.a(paramISearchResultModel, paramISearchResultView);
        return;
      }
      paramISearchResultModel = new StringBuilder();
      paramISearchResultModel.append("unresolved id type");
      paramISearchResultModel.append(((IContactSearchModel)localObject).e());
      QLog.e("MostUsedResultPresenter", 2, paramISearchResultModel.toString());
      return;
    }
    if ((paramISearchResultModel instanceof GroupBaseNetSearchModelItem))
    {
      localObject = (GroupBaseNetSearchModelItem)paramISearchResultModel;
      if (MostUseConstants.a(((GroupBaseNetSearchModelItem)localObject).e()) == 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchPresenterActiveEntitySearchResultPresenter.a(paramISearchResultModel, paramISearchResultView);
        return;
      }
      paramISearchResultModel = new StringBuilder();
      paramISearchResultModel.append("unresolved id type");
      paramISearchResultModel.append(((GroupBaseNetSearchModelItem)localObject).e());
      QLog.e("MostUsedResultPresenter", 2, paramISearchResultModel.toString());
    }
  }
  
  protected void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchPresenterMostUsedResultPresenter$OnActionListener != null)
    {
      if (paramISearchResultView.a() != null) {
        paramISearchResultView.a().setOnClickListener(new MostUsedResultPresenter.1(this));
      }
    }
    else {
      super.c(paramISearchResultModel, paramISearchResultView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.MostUsedResultPresenter
 * JD-Core Version:    0.7.0.1
 */