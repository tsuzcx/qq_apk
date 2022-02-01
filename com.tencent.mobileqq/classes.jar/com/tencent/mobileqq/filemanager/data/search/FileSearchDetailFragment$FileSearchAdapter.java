package com.tencent.mobileqq.filemanager.data.search;

import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.search.base.adapter.BaseMvpFaceAdapter;
import com.tencent.mobileqq.search.base.presenter.IPresenter;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.base.view.IView;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class FileSearchDetailFragment$FileSearchAdapter
  extends BaseMvpFaceAdapter<ISearchResultModel, ISearchResultView>
{
  public FileSearchDetailFragment$FileSearchAdapter(FileSearchDetailFragment paramFileSearchDetailFragment, ListView paramListView, IFaceDecoder paramIFaceDecoder, ISearchResultModel paramISearchResultModel, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, paramIFaceDecoder);
    paramFileSearchDetailFragment = (FileEntitySearchResultModel)paramISearchResultModel;
    if (paramFileSearchDetailFragment.a.size() > 1)
    {
      paramListView = new ArrayList();
      paramIFaceDecoder = paramFileSearchDetailFragment.a.iterator();
      while (paramIFaceDecoder.hasNext())
      {
        paramISearchResultModel = (FileManagerEntity)paramIFaceDecoder.next();
        paramString = new FileEntitySearchResultModel();
        paramString.b = paramFileSearchDetailFragment.b;
        paramString.a.add(paramISearchResultModel);
        paramListView.add(paramString);
      }
      a(paramListView);
    }
  }
  
  protected IPresenter<ISearchResultModel, ISearchResultView> a(int paramInt)
  {
    return new FileSearchResultPresenter(this.a.e);
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new FileSearchResultView(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchDetailFragment.FileSearchAdapter
 * JD-Core Version:    0.7.0.1
 */