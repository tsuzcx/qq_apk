package com.tencent.mobileqq.search.adapter;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.search.FileSearchResultGroupPresenter;
import com.tencent.mobileqq.filemanager.data.search.GroupSearchModelFileEntity;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.SearchUtil.ObjectItemInfo;
import com.tencent.mobileqq.search.SearchUtil.SubItemInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.ftsmsg.FTSGroupSearchModelMessage;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModel;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.GroupNetSearchModelArticle;
import com.tencent.mobileqq.search.model.GroupNetSearchModelPeople;
import com.tencent.mobileqq.search.model.GroupNetSearchModelPublicAcnt;
import com.tencent.mobileqq.search.model.GroupNetSearchModelTroop;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.GroupSearchModelFooter;
import com.tencent.mobileqq.search.model.GroupSearchModelFunction;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalContactApproximate;
import com.tencent.mobileqq.search.model.GroupSearchModelMessage;
import com.tencent.mobileqq.search.model.GroupSearchModelMoreItem;
import com.tencent.mobileqq.search.model.GroupSearchModelMultiChat;
import com.tencent.mobileqq.search.model.GroupSearchModelPublicAcnt;
import com.tencent.mobileqq.search.model.IFaceModel;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalBaseItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateSubItemTitle;
import com.tencent.mobileqq.search.model.PublicAccountSearchResultModel;
import com.tencent.mobileqq.search.model.RelativeWord;
import com.tencent.mobileqq.search.model.SearchResultGroupModelImpl;
import com.tencent.mobileqq.search.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.presenter.ActiveEntitySearchResultPresenter;
import com.tencent.mobileqq.search.presenter.ContactSearchResultGroupPresenter;
import com.tencent.mobileqq.search.presenter.EmptyViewPresenter;
import com.tencent.mobileqq.search.presenter.EntranceResultPresenter;
import com.tencent.mobileqq.search.presenter.FunctionSearchResultGroupPresenter;
import com.tencent.mobileqq.search.presenter.IFacePresenter;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.presenter.PublicAcntSearchResultGroupPresenter;
import com.tencent.mobileqq.search.presenter.PublicAcntSearchResultPresenter;
import com.tencent.mobileqq.search.presenter.SearchResultGroupFooterViewPresenter;
import com.tencent.mobileqq.search.presenter.SearchResultGroupMessagePresenter;
import com.tencent.mobileqq.search.presenter.SearchResultGroupMorePresenter;
import com.tencent.mobileqq.search.presenter.SearchResultGroupPresenter;
import com.tencent.mobileqq.search.presenter.SearchResultGroupTitlePresenter;
import com.tencent.mobileqq.search.presenter.SearchTemplatePresenter;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.ApproximateSearchResultGroupView;
import com.tencent.mobileqq.search.view.ContactSearchResultGroupView;
import com.tencent.mobileqq.search.view.EmptyResultView;
import com.tencent.mobileqq.search.view.FunctionSearchResultGroupView;
import com.tencent.mobileqq.search.view.IFaceView;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.search.view.NetSearchTemplateAvatarsView;
import com.tencent.mobileqq.search.view.NetSearchTemplateBannerTitleView;
import com.tencent.mobileqq.search.view.NetSearchTemplateHorizontalContainerView;
import com.tencent.mobileqq.search.view.NetSearchTemplateMovieView;
import com.tencent.mobileqq.search.view.NetSearchTemplateNormalView;
import com.tencent.mobileqq.search.view.NetSearchTemplateSubItemTitleView;
import com.tencent.mobileqq.search.view.NetSearchTemplateSubItemView;
import com.tencent.mobileqq.search.view.NetSearchTemplateUniversalView;
import com.tencent.mobileqq.search.view.NetSearchTemplateUpdatesView;
import com.tencent.mobileqq.search.view.SearchResultEntranceView;
import com.tencent.mobileqq.search.view.SearchResultFromNetView;
import com.tencent.mobileqq.search.view.SearchResultGroupFTSMessageView;
import com.tencent.mobileqq.search.view.SearchResultGroupFooterView;
import com.tencent.mobileqq.search.view.SearchResultGroupMessageView;
import com.tencent.mobileqq.search.view.SearchResultGroupMoreItemView;
import com.tencent.mobileqq.search.view.SearchResultGroupTitleView;
import com.tencent.mobileqq.search.view.SearchResultGroupView;
import com.tencent.mobileqq.search.view.SearchResultView;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import cooperation.qqfav.globalsearch.FavoriteSearchResultGroupPresenter;
import cooperation.qqfav.globalsearch.GroupSearchModelFavorite;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupSearchAdapter
  extends BaseMvpAdapter
  implements FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  protected int a;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean;
  private int b = -1;
  
  public GroupSearchAdapter(ListView paramListView, FaceDecoder paramFaceDecoder, AbsListView.OnScrollListener paramOnScrollListener, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
    paramFaceDecoder.a(this);
    paramListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
    this.b = paramInt;
  }
  
  public int a(int paramInt)
  {
    if ((a(paramInt) instanceof GroupBaseNetSearchModel)) {
      return ((GroupBaseNetSearchModel)a(paramInt)).b();
    }
    if ((a(paramInt) instanceof GroupBaseNetSearchModelItem)) {
      return ((GroupBaseNetSearchModelItem)a(paramInt)).b();
    }
    return 0;
  }
  
  protected IPresenter a(int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    case 1: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    default: 
      return new SearchResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
    case 41: 
      return new FunctionSearchResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
    case 3: 
      return new SearchResultGroupMessagePresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, false);
    case 12: 
      return new SearchResultGroupMessagePresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, true);
    case 50: 
      return new EmptyViewPresenter();
    case 0: 
      return new SearchResultGroupTitlePresenter();
    case 49: 
      return new SearchResultGroupFooterViewPresenter();
    case 15: 
      return new SearchResultGroupTitlePresenter();
    case 2: 
    case 8: 
      return new PublicAcntSearchResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
    case 9: 
      return new SearchResultGroupMorePresenter();
    case 14: 
      return new SearchResultGroupMorePresenter();
    case 10: 
      return new FavoriteSearchResultGroupPresenter();
    case 11: 
      return new FileSearchResultGroupPresenter();
    case 13: 
      return new ContactSearchResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
    case 16: 
      return new SearchResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 31: 
    case 40: 
      return new ActiveEntitySearchResultPresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, a(paramInt));
    case 28: 
    case 29: 
    case 30: 
    case 32: 
    case 33: 
    case 34: 
    case 35: 
    case 36: 
      return new EntranceResultPresenter();
    case 37: 
    case 38: 
    case 39: 
    case 42: 
    case 43: 
    case 44: 
    case 45: 
    case 47: 
    case 48: 
      return new SearchTemplatePresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, this);
    }
    return new PublicAcntSearchResultPresenter(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    int j = 0;
    boolean bool2 = false;
    Object localObject;
    switch (getItemViewType(paramInt))
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 18: 
    case 20: 
    default: 
      paramViewGroup = new SearchResultGroupView(paramViewGroup, 2130971477);
      return paramViewGroup;
    case 41: 
      return new FunctionSearchResultGroupView(paramViewGroup);
    case 3: 
      return new SearchResultGroupMessageView(paramViewGroup);
    case 12: 
      return new SearchResultGroupFTSMessageView(paramViewGroup);
    case 50: 
      return new EmptyResultView(paramViewGroup);
    case 0: 
    case 15: 
      localObject = a(paramInt);
      if (!(localObject instanceof GroupSearchModeTitle)) {
        break;
      }
    }
    for (boolean bool1 = ((GroupSearchModeTitle)localObject).a();; bool1 = false)
    {
      if (paramInt != 0) {
        bool2 = true;
      }
      return new SearchResultGroupTitleView(paramViewGroup, bool2, bool1);
      return new SearchResultGroupView(paramViewGroup, 2130969232);
      return new SearchResultGroupFooterView(paramViewGroup);
      return new SearchResultGroupMoreItemView(paramViewGroup, 2130971495, 2130843165, -1);
      return new SearchResultGroupMoreItemView(paramViewGroup, 2130971495, 2130843165, 12);
      localObject = new SearchResultView(paramViewGroup, 2130969409);
      int i = j;
      if (paramInt >= 1)
      {
        paramInt = getItemViewType(paramInt - 1);
        if (paramInt != 11)
        {
          i = j;
          if (paramInt != 10) {}
        }
        else
        {
          i = 1;
        }
      }
      paramViewGroup = (ViewGroup)localObject;
      if (i == 0) {
        break;
      }
      paramViewGroup = (ViewGroup)localObject;
      if (((SearchResultView)localObject).b() == null) {
        break;
      }
      ((SearchResultView)localObject).b().setVisibility(8);
      return localObject;
      return new ContactSearchResultGroupView(paramViewGroup, 2130971481);
      return new ApproximateSearchResultGroupView(paramViewGroup, 2130971523);
      return new SearchResultGroupView(paramViewGroup, 2130971478);
      return new SearchResultGroupView(paramViewGroup, 2130971483);
      return new SearchResultFromNetView(paramViewGroup, a(paramInt));
      localObject = a(paramInt);
      if ((localObject instanceof SearchResultModelForEntrance)) {
        return new SearchResultEntranceView(paramViewGroup, ((SearchResultModelForEntrance)localObject).b());
      }
      throw new RuntimeException("model type is TYPE_UNITE_ENTRANCE_SUB_ITEM_COMMON_TEXT, but model item is not instance SearchResultModelForEntrance.");
      localObject = a(paramInt);
      if ((localObject instanceof NetSearchTemplateBaseItem))
      {
        localObject = (NetSearchTemplateBaseItem)localObject;
        switch (((NetSearchTemplateBaseItem)localObject).b())
        {
        default: 
          throw new RuntimeException("NetSearchTemplateBaseItem.getLayoutId() is " + ((NetSearchTemplateBaseItem)localObject).e() + " which is not supported!!!");
        case 1: 
          return new NetSearchTemplateNormalView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject).e());
        case 2: 
          return new NetSearchTemplateAvatarsView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject).e());
        case 3: 
          return new NetSearchTemplateUpdatesView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject).e());
        case 4: 
          return new NetSearchTemplateBannerTitleView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject).e());
        case 5: 
          return new NetSearchTemplateMovieView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject).e());
        case 7: 
          return new NetSearchTemplateHorizontalContainerView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject).e());
        case 6: 
          return new NetSearchTemplateUniversalView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject).e());
        case 8: 
          return new NetSearchTemplateSubItemView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject).e());
        }
        return new NetSearchTemplateSubItemTitleView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject).e());
      }
      throw new RuntimeException("model type is TYPE_UNITE_TEMPLATE_NORMAL or TYPE_UNITE_TEMPLATE_NEWS, but model item is not instance NetSearchTemplateBaseItem.");
      return new SearchResultView(paramViewGroup, 2130969233);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = paramInt;
      int k;
      int i;
      if ((paramInt == 0) || (paramInt == 1))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
        }
        k = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
        i = 0;
      }
      while (i < k)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
        if ((localView instanceof ViewGroup))
        {
          int j = 0;
          while (j < ((ViewGroup)localView).getChildCount())
          {
            IFaceModel localIFaceModel = (IFaceModel)((ViewGroup)localView).getChildAt(j).getTag(2131362079);
            IFacePresenter localIFacePresenter = (IFacePresenter)((ViewGroup)localView).getChildAt(j).getTag(2131362077);
            IFaceView localIFaceView = (IFaceView)((ViewGroup)localView).getChildAt(j).getTag(2131362078);
            if ((localIFacePresenter != null) && (localIFaceModel != null) && (paramAbsListView != null)) {
              localIFacePresenter.a(localIFaceModel, localIFaceView);
            }
            j += 1;
          }
        }
        i += 1;
        continue;
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      }
    } while (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener == null);
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = 12;
    if ((super.a(paramInt) instanceof GroupSearchModelFunction)) {
      i = 41;
    }
    do
    {
      return i;
      if ((super.a(paramInt) instanceof GroupSearchModelMessage)) {
        return 3;
      }
    } while ((super.a(paramInt) instanceof FTSGroupSearchModelMessage));
    if (((super.a(paramInt) instanceof GroupSearchModeTitle)) && (this.b != 12))
    {
      if (((GroupSearchModeTitle)super.a(paramInt)).jdField_a_of_type_Boolean) {
        return 0;
      }
      return 50;
    }
    if (((super.a(paramInt) instanceof GroupSearchModeTitle)) && (this.b == 12))
    {
      if (((GroupSearchModeTitle)super.a(paramInt)).jdField_a_of_type_Boolean) {
        return 15;
      }
      return 50;
    }
    if ((super.a(paramInt) instanceof GroupSearchModelFooter))
    {
      GroupSearchModelFooter localGroupSearchModelFooter = (GroupSearchModelFooter)super.a(paramInt);
      if ((localGroupSearchModelFooter != null) && (localGroupSearchModelFooter.jdField_a_of_type_Boolean)) {
        return 49;
      }
      return 50;
    }
    if ((super.a(paramInt) instanceof GroupSearchModelPublicAcnt)) {
      return 2;
    }
    if ((super.a(paramInt) instanceof GroupNetSearchModelPeople)) {
      return 5;
    }
    if ((super.a(paramInt) instanceof GroupNetSearchModelTroop)) {
      return 6;
    }
    if ((super.a(paramInt) instanceof GroupNetSearchModelPublicAcnt)) {
      return 8;
    }
    if ((super.a(paramInt) instanceof GroupNetSearchModelArticle)) {
      return 16;
    }
    if (((super.a(paramInt) instanceof GroupSearchModelMoreItem)) && (this.b != 12)) {
      return 9;
    }
    if (((super.a(paramInt) instanceof GroupSearchModelMoreItem)) && (this.b == 12)) {
      return 14;
    }
    if ((a(paramInt) instanceof GroupSearchModelFavorite)) {
      return 10;
    }
    if ((a(paramInt) instanceof GroupSearchModelFileEntity)) {
      return 11;
    }
    if ((super.a(paramInt) instanceof GroupSearchModelLocalContact)) {
      return 13;
    }
    if ((a(paramInt) instanceof GroupSearchModelMultiChat)) {
      return 17;
    }
    if ((a(paramInt) instanceof GroupSearchModelLocalContactApproximate)) {
      return 19;
    }
    if ((a(paramInt) instanceof GroupBaseNetSearchModelItem))
    {
      switch (((GroupBaseNetSearchModelItem)a(paramInt)).b())
      {
      default: 
        return 25;
      case 268435456: 
        return 26;
      case 1001: 
        return 21;
      case 1002: 
        return 22;
      }
      return 40;
    }
    if ((a(paramInt) instanceof SearchResultModelForEntrance))
    {
      switch (((SearchResultModelForEntrance)a(paramInt)).jdField_a_of_type_Int)
      {
      case 0: 
      default: 
        return 32;
      case -2: 
        return 28;
      case -1: 
        return 29;
      case -3: 
        return 30;
      case -4: 
        return 36;
      case 1: 
        return 32;
      case 2: 
        return 33;
      case 3: 
        return 34;
      }
      return 35;
    }
    if ((a(paramInt) instanceof NetSearchTemplateBaseItem))
    {
      switch (((NetSearchTemplateBaseItem)a(paramInt)).b())
      {
      default: 
        return 37;
      case 1: 
        return 37;
      case 2: 
        return 38;
      case 3: 
        return 39;
      case 4: 
        return 42;
      case 5: 
        return 43;
      case 7: 
        return 44;
      case 6: 
        return 45;
      case 8: 
        return 47;
      }
      return 48;
    }
    if ((a(paramInt) instanceof PublicAccountSearchResultModel)) {
      return 46;
    }
    return 4;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    IModel localIModel = a(paramInt);
    Object localObject1;
    Object localObject2;
    int i;
    if (SearchUtil.a(localIModel) > 0)
    {
      if (SearchUtil.c.containsKey(localIModel))
      {
        localObject1 = (SearchUtil.ObjectItemInfo)SearchUtil.c.get(localIModel);
        if (!((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Boolean)
        {
          ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Boolean = true;
          localObject2 = new JSONObject();
        }
      }
      try
      {
        ((JSONObject)localObject2).put("project", UniteSearchReportController.a());
        ((JSONObject)localObject2).put("event_src", "client");
        ((JSONObject)localObject2).put("get_src", "native");
        ((JSONObject)localObject2).put("obj_lct", ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Int);
        localObject3 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        UniteSearchReportController.a((QQAppInterface)localObject3, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Long + "").obj2(((SearchUtil.ObjectItemInfo)localObject1).jdField_b_of_type_JavaLangString).ver1(((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(this.b)).ver7(((JSONObject)localObject2).toString()).session_id(((QQAppInterface)localObject3).getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
        ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Boolean = true;
        SearchUtil.c.put(localIModel, localObject1);
        if ((localIModel instanceof ISearchResultGroupModel))
        {
          localObject2 = (ISearchResultGroupModel)localIModel;
          localObject1 = ((ISearchResultGroupModel)localObject2).a();
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            int j = Math.min(((List)localObject1).size(), ((ISearchResultGroupModel)localObject2).a());
            i = 0;
            if (i < j) {
              if (SearchUtil.c.containsKey(((List)localObject1).get(i)))
              {
                localObject2 = (SearchUtil.ObjectItemInfo)SearchUtil.c.get(((List)localObject1).get(i));
                if (!((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Boolean)
                {
                  ((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Boolean = true;
                  localObject3 = new JSONObject();
                }
              }
            }
          }
        }
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          for (;;)
          {
            Object localObject3;
            ((JSONObject)localObject3).put("project", UniteSearchReportController.a());
            ((JSONObject)localObject3).put("event_src", "client");
            ((JSONObject)localObject3).put("get_src", "native");
            ((JSONObject)localObject3).put("obj_lct", ((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Int);
            QQAppInterface localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            UniteSearchReportController.a(localQQAppInterface1, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Long + "").obj2(((SearchUtil.ObjectItemInfo)localObject2).jdField_b_of_type_JavaLangString).ver1(((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(this.b)).ver7(((JSONObject)localObject3).toString()).session_id(localQQAppInterface1.getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
            ((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Boolean = true;
            SearchUtil.c.put(((List)localObject1).get(i), localObject2);
            i += 1;
          }
          localJSONException1 = localJSONException1;
          QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException1);
        }
        catch (JSONException localJSONException3)
        {
          for (;;)
          {
            QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException3);
          }
        }
      }
    }
    Object localObject4;
    Object localObject5;
    if ((localIModel instanceof GroupBaseNetSearchModel))
    {
      localObject1 = (GroupBaseNetSearchModel)localIModel;
      if ((((GroupBaseNetSearchModel)localObject1).a() != null) && (((GroupBaseNetSearchModel)localObject1).a().size() > 0))
      {
        i = 0;
        for (;;)
        {
          if (i >= ((GroupBaseNetSearchModel)localObject1).a().size()) {
            break label1612;
          }
          localObject2 = (IModel)((GroupBaseNetSearchModel)localObject1).a().get(i);
          if (SearchUtil.c.containsKey(localObject2))
          {
            localObject2 = (SearchUtil.ObjectItemInfo)SearchUtil.c.get(localObject2);
            if (!((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Boolean)
            {
              ((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Boolean = true;
              localObject4 = new JSONObject();
            }
          }
          try
          {
            ((JSONObject)localObject4).put("project", UniteSearchReportController.a());
            ((JSONObject)localObject4).put("event_src", "client");
            ((JSONObject)localObject4).put("get_src", "web");
            ((JSONObject)localObject4).put("obj_lct", ((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Int);
            QQAppInterface localQQAppInterface2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            UniteSearchReportController.a(localQQAppInterface2, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Long + "").obj2(((SearchUtil.ObjectItemInfo)localObject2).jdField_b_of_type_JavaLangString).ver1(((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(this.b)).ver7(((JSONObject)localObject4).toString()).session_id(localQQAppInterface2.getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
            i += 1;
          }
          catch (JSONException localJSONException4)
          {
            for (;;)
            {
              QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException4);
            }
          }
        }
      }
    }
    else if ((localIModel instanceof NetSearchTemplateHorizontalContainerItem))
    {
      localObject1 = ((NetSearchTemplateHorizontalContainerItem)localIModel).a;
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label1612;
          }
          localObject2 = (NetSearchTemplateHorizontalBaseItem)((Iterator)localObject1).next();
          if (SearchUtil.c.containsKey(localObject2))
          {
            localObject4 = (SearchUtil.ObjectItemInfo)SearchUtil.c.get(localObject2);
            if (!((SearchUtil.ObjectItemInfo)localObject4).jdField_a_of_type_Boolean)
            {
              ((SearchUtil.ObjectItemInfo)localObject4).jdField_a_of_type_Boolean = true;
              localObject5 = new JSONObject();
              try
              {
                ((JSONObject)localObject5).put("project", UniteSearchReportController.a());
                ((JSONObject)localObject5).put("event_src", "client");
                ((JSONObject)localObject5).put("get_src", "web");
                ((JSONObject)localObject5).put("obj_lct", ((SearchUtil.ObjectItemInfo)localObject4).jdField_a_of_type_Int);
                ((JSONObject)localObject5).put("extra_info", ((NetSearchTemplateHorizontalBaseItem)localObject2).jdField_b_of_type_JavaLangString);
                ((JSONObject)localObject5).put("tepl", ((NetSearchTemplateHorizontalBaseItem)localObject2).f);
                QQAppInterface localQQAppInterface3 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
                UniteSearchReportController.a(localQQAppInterface3, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((NetSearchTemplateHorizontalBaseItem)localObject2).jdField_a_of_type_Long + "").obj2(((NetSearchTemplateHorizontalBaseItem)localObject2).j).ver1(((SearchUtil.ObjectItemInfo)localObject4).jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(this.b)).ver7(((JSONObject)localObject5).toString()).session_id(localQQAppInterface3.getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
              }
              catch (JSONException localJSONException6)
              {
                for (;;)
                {
                  QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException6);
                }
              }
            }
          }
        }
      }
    }
    else if ((((localIModel instanceof NetSearchTemplateBaseItem)) && (!(localIModel instanceof NetSearchTemplateSubItemTitle))) || ((((localIModel instanceof GroupBaseNetSearchModelItem)) || (((localIModel instanceof SearchResultModelForEntrance)) && (((SearchResultModelForEntrance)localIModel).jdField_a_of_type_Int == -4))) && (SearchUtil.c.containsKey(localIModel))))
    {
      localObject1 = (SearchUtil.ObjectItemInfo)SearchUtil.c.get(localIModel);
      if (!((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Boolean)
      {
        ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Boolean = true;
        localObject2 = new JSONObject();
      }
    }
    try
    {
      ((JSONObject)localObject2).put("project", UniteSearchReportController.a());
      ((JSONObject)localObject2).put("event_src", "client");
      ((JSONObject)localObject2).put("get_src", "web");
      ((JSONObject)localObject2).put("obj_lct", ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Int);
      if ((localIModel instanceof NetSearchTemplateBaseItem)) {
        ((JSONObject)localObject2).put("tepl", ((NetSearchTemplateBaseItem)localIModel).f);
      }
      localObject4 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      UniteSearchReportController.a((QQAppInterface)localObject4, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Long + "").obj2(((SearchUtil.ObjectItemInfo)localObject1).jdField_b_of_type_JavaLangString).ver1(((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(this.b)).ver7(((JSONObject)localObject2).toString()).session_id(((QQAppInterface)localObject4).getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
      label1612:
      if (SearchUtil.jdField_a_of_type_JavaUtilHashMap.containsKey(localIModel))
      {
        localObject1 = (SearchUtil.ObjectItemInfo)SearchUtil.jdField_a_of_type_JavaUtilHashMap.get(localIModel);
        if (!((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Boolean) {
          if (SearchUtils.a(((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Long))
          {
            if (((SearchUtil.ObjectItemInfo)localObject1).jdField_b_of_type_Boolean)
            {
              i = 2;
              SearchUtils.a("all_result", "exp_object", i, 0, new String[] { ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_JavaLangString, ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Long + "", ((SearchUtil.ObjectItemInfo)localObject1).jdField_b_of_type_JavaLangString, ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Int + "" });
              ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Boolean = true;
              SearchUtil.jdField_a_of_type_JavaUtilHashMap.put((ISearchResultModel)localIModel, localObject1);
            }
          }
          else
          {
            if (((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Long != 1007L) {
              break label2196;
            }
            localObject2 = this.jdField_a_of_type_ComTencentWidgetListView.getContext();
            if (!(localObject2 instanceof UniteSearchActivity)) {
              break label2525;
            }
            i = ((UniteSearchActivity)localObject2).jdField_a_of_type_Int;
            SearchUtils.a("all_result", "exp_relatedsearch_list", new String[] { ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_JavaLangString, i + "" });
            localObject2 = new StringBuilder();
            if (!(localIModel instanceof GroupBaseNetSearchModelItem)) {
              break label2033;
            }
            localObject4 = (GroupBaseNetSearchModelItem)localIModel;
            if ((((GroupBaseNetSearchModelItem)localObject4).c == null) || (((GroupBaseNetSearchModelItem)localObject4).c.size() <= 0)) {
              break label2033;
            }
            i = 0;
            while (i < ((GroupBaseNetSearchModelItem)localObject4).c.size() - 1)
            {
              ((StringBuilder)localObject2).append(((RelativeWord)((GroupBaseNetSearchModelItem)localObject4).c.get(i)).jdField_a_of_type_JavaLangString).append("::");
              i += 1;
            }
          }
        }
      }
    }
    catch (JSONException localJSONException2)
    {
      for (;;)
      {
        QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException2);
        continue;
        i = 1;
        continue;
        ((StringBuilder)localObject2).append(((RelativeWord)localJSONException2.c.get(localJSONException2.c.size() - 1)).jdField_a_of_type_JavaLangString);
        label2033:
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("project", UniteSearchReportController.a());
          localJSONObject.put("event_src", "client");
          localObject5 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("exp_relatedsearch_list").obj1(((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Long + "").obj2(((SearchUtil.ObjectItemInfo)localObject1).jdField_b_of_type_JavaLangString).ver1(((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(this.b)).ver4(((StringBuilder)localObject2).toString()).ver7(localJSONObject.toString()).session_id(((QQAppInterface)localObject5).getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
          label2196:
          if ((localIModel instanceof SearchResultModelForEntrance))
          {
            localObject2 = (SearchResultModelForEntrance)localIModel;
            if ((((SearchResultModelForEntrance)localObject2).jdField_a_of_type_Int == -3) || (((SearchResultModelForEntrance)localObject2).jdField_a_of_type_Int == -4))
            {
              if (!((SearchUtil.ObjectItemInfo)localObject1).jdField_b_of_type_Boolean) {
                break label2519;
              }
              i = 2;
              SearchUtils.a("all_result", "exp_net_search", i, 0, new String[] { ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_JavaLangString, ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Long + "", ((SearchUtil.ObjectItemInfo)localObject1).jdField_b_of_type_JavaLangString, ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Int + "" });
            }
          }
          if ((localIModel instanceof SearchResultModelForEntrance))
          {
            localObject1 = ((SearchResultModelForEntrance)localIModel).jdField_a_of_type_PbUniteSearchDynamicSearch$SubItem;
            if ((localObject1 != null) && (SearchUtil.b.containsKey(localObject1)))
            {
              localObject2 = (SearchUtil.SubItemInfo)SearchUtil.b.get(localObject1);
              if (!((SearchUtil.SubItemInfo)localObject2).jdField_a_of_type_Boolean)
              {
                SearchUtils.a("sub_result", "exp_custom", new String[] { ((SearchUtil.SubItemInfo)localObject2).jdField_a_of_type_JavaLangString, "" + ((SearchUtil.SubItemInfo)localObject2).jdField_a_of_type_Long, "" + ((SearchResultModelForEntrance)localIModel).jdField_a_of_type_Int });
                ((SearchUtil.SubItemInfo)localObject2).jdField_a_of_type_Boolean = true;
                SearchUtil.b.put(localObject1, localObject2);
              }
            }
          }
          return super.getView(paramInt, paramView, paramViewGroup);
        }
        catch (JSONException localJSONException5)
        {
          for (;;)
          {
            QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException5);
            continue;
            label2519:
            i = 1;
          }
        }
        label2525:
        i = -1;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 51;
  }
  
  public void notifyDataSetChanged()
  {
    int i1 = getCount();
    int n = 0;
    int j = 0;
    int k = 0;
    int i = 0;
    if (n < i1)
    {
      Object localObject = a(n);
      int m;
      if ((localObject instanceof GroupSearchModeTitle))
      {
        localObject = (GroupSearchModeTitle)localObject;
        k = i + 1;
        ((GroupSearchModeTitle)localObject).a(1, k);
        i = j;
        if (((GroupSearchModeTitle)localObject).b() == 2) {
          i = j + 1;
        }
        ((GroupSearchModeTitle)localObject).a(3, i);
        ((GroupSearchModeTitle)localObject).a(0, k, i);
        m = 0;
        j = k;
        k = i;
        i = m;
      }
      for (;;)
      {
        n += 1;
        m = j;
        j = k;
        k = i;
        i = m;
        break;
        if ((localObject instanceof SearchResultGroupModelImpl))
        {
          localObject = (SearchResultGroupModelImpl)localObject;
          k += 1;
          ((SearchResultGroupModelImpl)localObject).a(k, i, j);
          m = i;
          i = k;
          k = j;
          j = m;
        }
        else
        {
          m = k;
          if ((localObject instanceof GroupBaseNetSearchModelItem))
          {
            localObject = (GroupBaseNetSearchModelItem)localObject;
            m = k + 1;
            ((GroupBaseNetSearchModelItem)localObject).a(m, i, j);
          }
          k = m;
          m = i;
          i = k;
          k = j;
          j = m;
        }
      }
    }
    super.notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "onDecodeTaskCompleted, remainingTasks : " + paramInt1 + ", type : " + paramInt2 + ", uin : " + paramString + ", avatar : " + paramBitmap + ", mFaceDecoder.isPausing() : " + this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a() + ", mScrollState : " + this.jdField_a_of_type_Int);
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < j)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1);
        IFaceModel localIFaceModel;
        IFacePresenter localIFacePresenter;
        IFaceView localIFaceView;
        if (((localView.getTag(2131362079) instanceof IFaceModel)) && ((localView.getTag(2131362077) instanceof IFacePresenter)) && ((localView.getTag(2131362078) instanceof IFaceView)))
        {
          localIFaceModel = (IFaceModel)localView.getTag(2131362079);
          localIFacePresenter = (IFacePresenter)localView.getTag(2131362077);
          localIFaceView = (IFaceView)localView.getTag(2131362078);
          if ((localIFaceModel.a() == paramInt2) && (paramString.equals(localIFaceModel.a()))) {
            localIFacePresenter.a(localIFaceModel, localIFaceView, paramBitmap);
          }
        }
        if ((localView instanceof ViewGroup))
        {
          int i = 0;
          while (i < ((ViewGroup)localView).getChildCount())
          {
            localIFaceModel = (IFaceModel)((ViewGroup)localView).getChildAt(i).getTag(2131362079);
            if ((localIFaceModel != null) && (localIFaceModel.a() == paramInt2) && (paramString.equals(localIFaceModel.a())))
            {
              localIFacePresenter = (IFacePresenter)((ViewGroup)localView).getChildAt(i).getTag(2131362077);
              localIFaceView = (IFaceView)((ViewGroup)localView).getChildAt(i).getTag(2131362078);
              if ((localIFacePresenter != null) && (localIFaceView != null)) {
                localIFacePresenter.a(localIFaceModel, localIFaceView, paramBitmap);
              }
            }
            i += 1;
          }
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.adapter.GroupSearchAdapter
 * JD-Core Version:    0.7.0.1
 */