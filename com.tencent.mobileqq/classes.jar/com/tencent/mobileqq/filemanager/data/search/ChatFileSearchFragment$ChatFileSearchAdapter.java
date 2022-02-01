package com.tencent.mobileqq.filemanager.data.search;

import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.search.adapter.BaseMvpFaceAdapter;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ChatFileSearchFragment$ChatFileSearchAdapter
  extends BaseMvpFaceAdapter<ISearchResultModel, ISearchResultView>
{
  ChatFileSearchFragment$ChatFileSearchAdapter(ListView paramListView, IFaceDecoder paramIFaceDecoder, List<ISearchResultModel> paramList, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramIFaceDecoder, paramList);
    if (paramString == null) {
      return;
    }
    if (paramString.size() == 1)
    {
      paramListView = (ChatFileEntitySearchResultModel)paramString.get(0);
      if (paramListView.jdField_a_of_type_JavaUtilList.size() > 1)
      {
        paramIFaceDecoder = new ArrayList();
        paramList = paramListView.jdField_a_of_type_JavaUtilList.iterator();
        while (paramList.hasNext())
        {
          paramString = (FileManagerEntity)paramList.next();
          paramQQAppInterface = new ChatFileEntitySearchResultModel();
          paramQQAppInterface.jdField_a_of_type_JavaLangString = paramListView.jdField_a_of_type_JavaLangString;
          paramQQAppInterface.jdField_a_of_type_JavaUtilList.add(paramString);
          paramIFaceDecoder.add(paramQQAppInterface);
        }
        a(paramIFaceDecoder);
        return;
      }
    }
    a(paramString);
  }
  
  public IPresenter<ISearchResultModel, ISearchResultView> a(int paramInt)
  {
    return new FileSearchResultPresenter(ChatFileSearchFragment.a(this.a));
  }
  
  public IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new ChatFileSearchResultView(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.ChatFileSearchFragment.ChatFileSearchAdapter
 * JD-Core Version:    0.7.0.1
 */