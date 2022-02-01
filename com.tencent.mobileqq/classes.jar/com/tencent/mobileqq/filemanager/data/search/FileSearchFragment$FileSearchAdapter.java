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

class FileSearchFragment$FileSearchAdapter
  extends BaseMvpFaceAdapter<ISearchResultModel, ISearchResultView>
{
  public FileSearchFragment$FileSearchAdapter(ListView paramListView, IFaceDecoder paramIFaceDecoder, List<ISearchResultModel> paramList, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramIFaceDecoder, paramList);
    if (paramString == null) {
      return;
    }
    if (paramString.size() == 1)
    {
      paramListView = (FileEntitySearchResultModel)paramString.get(0);
      if (paramListView.a.size() > 1)
      {
        paramIFaceDecoder = new ArrayList();
        paramList = paramListView.a.iterator();
        while (paramList.hasNext())
        {
          paramString = (FileManagerEntity)paramList.next();
          paramQQAppInterface = new FileEntitySearchResultModel();
          paramQQAppInterface.b = paramListView.b;
          paramQQAppInterface.a.add(paramString);
          paramIFaceDecoder.add(paramQQAppInterface);
        }
        a(paramIFaceDecoder);
        return;
      }
    }
    a(paramString);
  }
  
  protected IPresenter<ISearchResultModel, ISearchResultView> a(int paramInt)
  {
    return new FileSearchResultPresenter(FileSearchFragment.a(this.a));
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new FileSearchResultView(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchFragment.FileSearchAdapter
 * JD-Core Version:    0.7.0.1
 */