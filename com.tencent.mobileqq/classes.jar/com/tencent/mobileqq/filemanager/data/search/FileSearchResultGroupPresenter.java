package com.tencent.mobileqq.filemanager.data.search;

import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.presenter.IFacePresenter;
import com.tencent.mobileqq.search.presenter.SearchResultGroupPresenter;
import com.tencent.mobileqq.search.view.ISearchResultView;

public class FileSearchResultGroupPresenter
  extends SearchResultGroupPresenter
{
  public FileSearchResultGroupPresenter(IFaceDecoder paramIFaceDecoder)
  {
    super(paramIFaceDecoder);
  }
  
  public IFacePresenter<ISearchResultModel, ISearchResultView> a(IFaceDecoder paramIFaceDecoder)
  {
    return new FileSearchResultPresenter(paramIFaceDecoder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchResultGroupPresenter
 * JD-Core Version:    0.7.0.1
 */