package com.tencent.mobileqq.search.presenter;

import android.view.View;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.mostused.MostUseConstants;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.qphone.base.util.QLog;

public class MostUsedResultPresenter
  extends SearchResultPresenter
{
  private ActiveEntitySearchResultPresenter jdField_a_of_type_ComTencentMobileqqSearchPresenterActiveEntitySearchResultPresenter;
  private ContactSearchResultPresenter jdField_a_of_type_ComTencentMobileqqSearchPresenterContactSearchResultPresenter;
  private MiniProgramSearchResultPresenter jdField_a_of_type_ComTencentMobileqqSearchPresenterMiniProgramSearchResultPresenter;
  private MostUsedResultPresenter.OnActionListener jdField_a_of_type_ComTencentMobileqqSearchPresenterMostUsedResultPresenter$OnActionListener = null;
  
  public MostUsedResultPresenter(IFaceDecoder paramIFaceDecoder)
  {
    super(paramIFaceDecoder);
    this.jdField_a_of_type_ComTencentMobileqqSearchPresenterMiniProgramSearchResultPresenter = new MiniProgramSearchResultPresenter(paramIFaceDecoder);
    this.jdField_a_of_type_ComTencentMobileqqSearchPresenterContactSearchResultPresenter = new ContactSearchResultPresenter(paramIFaceDecoder);
    this.jdField_a_of_type_ComTencentMobileqqSearchPresenterActiveEntitySearchResultPresenter = new ActiveEntitySearchResultPresenter(paramIFaceDecoder, 268435456);
  }
  
  public void b(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if ((!(paramISearchResultModel instanceof IContactSearchModel)) && (!(paramISearchResultModel instanceof GroupBaseNetSearchModelItem))) {
      QLog.e("MostUsedResultPresenter", 2, "unresolved model");
    }
    do
    {
      return;
      if ((paramISearchResultModel instanceof IContactSearchModel))
      {
        localObject = (IContactSearchModel)paramISearchResultModel;
        int i = MostUseConstants.a(((IContactSearchModel)localObject).e());
        if (i == 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqSearchPresenterMiniProgramSearchResultPresenter.b(paramISearchResultModel, paramISearchResultView);
          return;
        }
        if (i == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqSearchPresenterContactSearchResultPresenter.b(paramISearchResultModel, paramISearchResultView);
          return;
        }
        QLog.e("MostUsedResultPresenter", 2, "unresolved id type" + ((IContactSearchModel)localObject).e());
        return;
      }
    } while (!(paramISearchResultModel instanceof GroupBaseNetSearchModelItem));
    Object localObject = (GroupBaseNetSearchModelItem)paramISearchResultModel;
    if (MostUseConstants.a(((GroupBaseNetSearchModelItem)localObject).e()) == 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchPresenterActiveEntitySearchResultPresenter.b(paramISearchResultModel, paramISearchResultView);
      return;
    }
    QLog.e("MostUsedResultPresenter", 2, "unresolved id type" + ((GroupBaseNetSearchModelItem)localObject).e());
  }
  
  protected void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchPresenterMostUsedResultPresenter$OnActionListener != null)
    {
      if (paramISearchResultView.a() != null) {
        paramISearchResultView.a().setOnClickListener(new MostUsedResultPresenter.1(this));
      }
      return;
    }
    super.c(paramISearchResultModel, paramISearchResultView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.MostUsedResultPresenter
 * JD-Core Version:    0.7.0.1
 */