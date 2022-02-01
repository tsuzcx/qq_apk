package com.tencent.mobileqq.search.adapter;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.filemanager.data.search.FileSearchResultGroupPresenter;
import com.tencent.mobileqq.filemanager.data.search.GroupSearchModelFileEntity;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.SearchUtil.ObjectItemInfo;
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
import com.tencent.mobileqq.search.model.GroupSearchModelLocalTroop;
import com.tencent.mobileqq.search.model.GroupSearchModelMessage;
import com.tencent.mobileqq.search.model.GroupSearchModelMiniProgram;
import com.tencent.mobileqq.search.model.GroupSearchModelMoreItem;
import com.tencent.mobileqq.search.model.GroupSearchModelMostUsed;
import com.tencent.mobileqq.search.model.GroupSearchModelMultiChat;
import com.tencent.mobileqq.search.model.GroupSearchModelPublicAcnt;
import com.tencent.mobileqq.search.model.IFaceModel;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.MiniProgramSearchResultModel;
import com.tencent.mobileqq.search.model.NetSearchSubItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalBaseItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateNetSeaEntranceItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateNewEntranceItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateSubItemTitle;
import com.tencent.mobileqq.search.model.PublicAccountSearchResultModel;
import com.tencent.mobileqq.search.model.RelativeWord;
import com.tencent.mobileqq.search.model.RichSearchModelNode;
import com.tencent.mobileqq.search.model.SearchResultGroupModelImpl;
import com.tencent.mobileqq.search.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.presenter.ActiveEntitySearchResultPresenter;
import com.tencent.mobileqq.search.presenter.ContactSearchResultGroupPresenter;
import com.tencent.mobileqq.search.presenter.EmptyViewPresenter;
import com.tencent.mobileqq.search.presenter.EntranceResultPresenter;
import com.tencent.mobileqq.search.presenter.FunctionSearchResultGroupPresenter;
import com.tencent.mobileqq.search.presenter.IFacePresenter;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.presenter.MiniProgramSearchResultGroupPresenter;
import com.tencent.mobileqq.search.presenter.MostUseResultGroupPresenter;
import com.tencent.mobileqq.search.presenter.PublicAcntSearchResultGroupPresenter;
import com.tencent.mobileqq.search.presenter.PublicAcntSearchResultPresenter;
import com.tencent.mobileqq.search.presenter.RichSearchResultPresenter;
import com.tencent.mobileqq.search.presenter.SearchResultGroupFooterViewPresenter;
import com.tencent.mobileqq.search.presenter.SearchResultGroupMessagePresenter;
import com.tencent.mobileqq.search.presenter.SearchResultGroupMorePresenter;
import com.tencent.mobileqq.search.presenter.SearchResultGroupPresenter;
import com.tencent.mobileqq.search.presenter.SearchResultGroupTitlePresenter;
import com.tencent.mobileqq.search.presenter.SearchTemplatePresenter;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.rich.ArkRichNode;
import com.tencent.mobileqq.search.rich.IRichNode;
import com.tencent.mobileqq.search.rich.IRichNodeView;
import com.tencent.mobileqq.search.rich.RichNodeController;
import com.tencent.mobileqq.search.rich.RichNodeFactory;
import com.tencent.mobileqq.search.rich.RichNodeViewBase;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.ApproximateSearchResultGroupView;
import com.tencent.mobileqq.search.view.ContactSearchResultGroupView;
import com.tencent.mobileqq.search.view.EmptyResultView;
import com.tencent.mobileqq.search.view.FunctionSearchResultGroupView;
import com.tencent.mobileqq.search.view.IFaceView;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.search.view.MiniProgramSearchResultGroupView;
import com.tencent.mobileqq.search.view.MostUsedSearchResultGroupView;
import com.tencent.mobileqq.search.view.NetSearchTemplateAvatarsView;
import com.tencent.mobileqq.search.view.NetSearchTemplateBannerTitleView;
import com.tencent.mobileqq.search.view.NetSearchTemplateBigImageView;
import com.tencent.mobileqq.search.view.NetSearchTemplateFriendUpdatesView;
import com.tencent.mobileqq.search.view.NetSearchTemplateHorSlidingContainerView;
import com.tencent.mobileqq.search.view.NetSearchTemplateHorizontalContainerView;
import com.tencent.mobileqq.search.view.NetSearchTemplateMiniAppView;
import com.tencent.mobileqq.search.view.NetSearchTemplateNetSeaEntranceView;
import com.tencent.mobileqq.search.view.NetSearchTemplateNewEntranceView;
import com.tencent.mobileqq.search.view.NetSearchTemplateQAView;
import com.tencent.mobileqq.search.view.NetSearchTemplateSubItemTitleView;
import com.tencent.mobileqq.search.view.NetSearchTemplateSubItemView;
import com.tencent.mobileqq.search.view.NetSearchTemplateTitleView;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  implements DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  protected int a;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private RichNodeController jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeController = new RichNodeController();
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean;
  public int b = -1;
  
  public GroupSearchAdapter(ListView paramListView, IFaceDecoder paramIFaceDecoder, AbsListView.OnScrollListener paramOnScrollListener, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    paramIFaceDecoder.setDecodeTaskCompletionListener(this);
    paramListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
    this.b = paramInt;
  }
  
  private IRichNode a(int paramInt)
  {
    IModel localIModel = a(paramInt);
    if (localIModel == null) {
      return null;
    }
    if (!(localIModel instanceof IRichNode)) {
      return null;
    }
    return (IRichNode)localIModel;
  }
  
  private void a(int paramInt, View paramView, IModel paramIModel)
  {
    if ((paramView == null) || (paramIModel == null)) {}
    for (;;)
    {
      return;
      if ((paramIModel instanceof RichSearchModelNode))
      {
        paramView = (IView)paramView.getTag(2131381656);
        if ((paramView instanceof IRichNodeView)) {}
        for (paramView = ((IRichNodeView)paramView).a(); paramView != null; paramView = null)
        {
          this.jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeController.a(paramInt, paramView);
          return;
        }
      }
    }
  }
  
  private boolean a(View paramView, IModel paramIModel)
  {
    if ((paramView == null) || (paramIModel == null)) {
      return false;
    }
    if ((paramIModel instanceof RichSearchModelNode))
    {
      IView localIView = (IView)paramView.getTag(2131381656);
      paramView = null;
      if ((localIView instanceof IRichNodeView)) {
        paramView = ((IRichNodeView)localIView).a();
      }
      if (paramView == null) {
        return false;
      }
      if ((((RichSearchModelNode)paramIModel).f() != paramView.c()) || (((RichSearchModelNode)paramIModel).h() != paramView.b())) {
        break label100;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "reuse contentview");
      }
    }
    return true;
    label100:
    return false;
  }
  
  private boolean a(View paramView, IModel paramIModel, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramInt2 == 59)
    {
      if (paramView == null) {
        break label203;
      }
      paramView = (IView)paramView.getTag(2131381656);
      if (!(paramView instanceof IRichNodeView)) {
        break label71;
      }
      paramView = (IRichNodeView)paramView;
    }
    for (;;)
    {
      if ((paramView != null) && ((paramView instanceof RichNodeViewBase)))
      {
        if (paramInt1 != 0) {
          break label76;
        }
        ((RichNodeViewBase)paramView).a(false);
      }
      for (;;)
      {
        if ((paramInt1 < 1) || (paramInt3 != 59))
        {
          label68:
          return paramBoolean;
          label71:
          paramView = null;
          break;
          label76:
          if (paramInt1 == 1)
          {
            localObject = a(paramInt1 - 1);
            if ((!(localObject instanceof GroupSearchModeTitle)) || (((GroupSearchModeTitle)localObject).jdField_a_of_type_Boolean)) {
              break label197;
            }
          }
        }
      }
      label167:
      label197:
      for (Object localObject = ((GroupSearchModeTitle)localObject).a().a();; localObject = null)
      {
        if ((paramIModel != null) && (localObject != null) && (((List)localObject).contains(paramIModel))) {}
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          if (paramInt2 == 0) {
            break label167;
          }
          ((RichNodeViewBase)paramView).a(false);
          break;
        }
        break;
        paramView = a(paramInt1 - 1);
        if ((!(paramView instanceof ArkRichNode)) || (((ArkRichNode)paramView).a() != 1)) {
          break label68;
        }
        return true;
      }
      label203:
      paramView = null;
    }
  }
  
  public int a(int paramInt)
  {
    Object localObject;
    if ((a(paramInt) instanceof GroupBaseNetSearchModel))
    {
      localObject = (GroupBaseNetSearchModel)a(paramInt);
      if (localObject != null) {
        return ((GroupBaseNetSearchModel)localObject).b();
      }
    }
    else if ((a(paramInt) instanceof GroupBaseNetSearchModelItem))
    {
      localObject = (GroupBaseNetSearchModelItem)a(paramInt);
      if (localObject != null) {
        return ((GroupBaseNetSearchModelItem)localObject).d();
      }
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
    case 28: 
    case 32: 
    case 33: 
    case 34: 
    case 35: 
    case 37: 
    case 43: 
    case 58: 
    default: 
      return new SearchResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
    case 41: 
      return new FunctionSearchResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
    case 3: 
      return new SearchResultGroupMessagePresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, false);
    case 12: 
      return new SearchResultGroupMessagePresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, true);
    case 57: 
      return new EmptyViewPresenter();
    case 0: 
      return new SearchResultGroupTitlePresenter();
    case 49: 
      return new SearchResultGroupFooterViewPresenter();
    case 15: 
      return new SearchResultGroupTitlePresenter();
    case 2: 
    case 8: 
      return new PublicAcntSearchResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
    case 9: 
      return new SearchResultGroupMorePresenter();
    case 14: 
      return new SearchResultGroupMorePresenter();
    case 10: 
      return new FavoriteSearchResultGroupPresenter();
    case 11: 
      return new FileSearchResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
    case 13: 
      return new ContactSearchResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
    case 56: 
      return new MiniProgramSearchResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
    case 60: 
      return new MostUseResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
    case 16: 
      return new SearchResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 31: 
    case 40: 
      return new ActiveEntitySearchResultPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, a(paramInt), this);
    case 29: 
    case 30: 
    case 36: 
      return new EntranceResultPresenter();
    case 38: 
    case 39: 
    case 42: 
    case 44: 
    case 45: 
    case 47: 
    case 48: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 61: 
    case 62: 
      return new SearchTemplatePresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this);
    case 46: 
      return new PublicAcntSearchResultPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
    }
    return new RichSearchResultPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this);
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    boolean bool2 = false;
    Object localObject1;
    switch (getItemViewType(paramInt))
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 11: 
    case 18: 
    case 20: 
    case 28: 
    case 32: 
    case 33: 
    case 34: 
    case 35: 
    case 37: 
    case 43: 
    case 58: 
    default: 
      return new SearchResultGroupView(paramViewGroup, 2131562961);
    case 41: 
      return new FunctionSearchResultGroupView(paramViewGroup);
    case 3: 
      return new SearchResultGroupMessageView(paramViewGroup);
    case 12: 
      return new SearchResultGroupFTSMessageView(paramViewGroup);
    case 57: 
      return new EmptyResultView(paramViewGroup);
    case 0: 
    case 15: 
      localObject1 = a(paramInt);
      if (!(localObject1 instanceof GroupSearchModeTitle)) {
        break;
      }
    }
    for (boolean bool1 = ((GroupSearchModeTitle)localObject1).a();; bool1 = false)
    {
      if (paramInt != 0) {
        bool2 = true;
      }
      return new SearchResultGroupTitleView(paramViewGroup, bool2, bool1);
      return new SearchResultGroupView(paramViewGroup, 2131559751);
      return new SearchResultGroupFooterView(paramViewGroup);
      return new SearchResultGroupMoreItemView(paramViewGroup, 2131562981, 2130846343, -1);
      return new SearchResultGroupMoreItemView(paramViewGroup, 2131562981, 2130846343, 12);
      return new SearchResultView(paramViewGroup, 2131559961);
      return new ContactSearchResultGroupView(paramViewGroup, 2131562965);
      return new MiniProgramSearchResultGroupView(paramViewGroup, 2131562967);
      return new MostUsedSearchResultGroupView(paramViewGroup, 2131562968);
      return new ApproximateSearchResultGroupView(paramViewGroup, 2131563010);
      return new SearchResultGroupView(paramViewGroup, 2131562962);
      return new SearchResultGroupView(paramViewGroup, 2131562969);
      Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject1 = a(paramInt);
      localObject2 = RichNodeFactory.a().a((QQAppInterface)localObject2, paramViewGroup.getContext(), (IModel)localObject1);
      if ((localObject2 != null) && (localObject1 != null) && ((localObject1 instanceof RichSearchModelNode))) {
        ((RichSearchModelNode)localObject1).c(((IRichNode)localObject2).b());
      }
      if (localObject2 == null) {
        return new EmptyResultView(paramViewGroup);
      }
      return ((IRichNode)localObject2).a();
      return new SearchResultFromNetView(paramViewGroup, a(paramInt));
      localObject1 = a(paramInt);
      if ((localObject1 instanceof SearchResultModelForEntrance)) {
        return new SearchResultEntranceView(paramViewGroup, ((SearchResultModelForEntrance)localObject1).d());
      }
      throw new RuntimeException("model type is TYPE_UNITE_ENTRANCE_SUB_ITEM_COMMON_TEXT, but model item is not instance SearchResultModelForEntrance.");
      localObject1 = a(paramInt);
      if ((localObject1 instanceof NetSearchTemplateBaseItem))
      {
        localObject1 = (NetSearchTemplateBaseItem)localObject1;
        switch (((NetSearchTemplateBaseItem)localObject1).d())
        {
        case 5: 
        case 10: 
        default: 
          throw new RuntimeException("NetSearchTemplateBaseItem.getLayoutId() is " + ((NetSearchTemplateBaseItem)localObject1).e() + " which is not supported!!!");
        case 2: 
          return new NetSearchTemplateAvatarsView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 3: 
          return new NetSearchTemplateUpdatesView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 4: 
          return new NetSearchTemplateBannerTitleView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 7: 
          return new NetSearchTemplateHorizontalContainerView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 6: 
          return new NetSearchTemplateUniversalView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 8: 
          return new NetSearchTemplateSubItemView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 9: 
          return new NetSearchTemplateSubItemTitleView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 11: 
          return new NetSearchTemplateFriendUpdatesView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 12: 
          return new NetSearchTemplateBigImageView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 13: 
          return new NetSearchTemplateHorSlidingContainerView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 14: 
          return new NetSearchTemplateTitleView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 15: 
          return new NetSearchTemplateQAView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 16: 
          return new NetSearchTemplateNetSeaEntranceView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 17: 
          return new NetSearchTemplateNewEntranceView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        }
        return new NetSearchTemplateMiniAppView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
      }
      throw new RuntimeException("model type is TYPE_UNITE_TEMPLATE_NORMAL or TYPE_UNITE_TEMPLATE_NEWS, but model item is not instance NetSearchTemplateBaseItem.");
      return new SearchResultView(paramViewGroup, 2131559752);
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
    Object localObject;
    if (((super.a(paramInt) instanceof GroupSearchModeTitle)) && (this.b != 12))
    {
      localObject = (GroupSearchModeTitle)super.a(paramInt);
      if ((localObject != null) && (((GroupSearchModeTitle)localObject).jdField_a_of_type_Boolean)) {
        return 0;
      }
      return 57;
    }
    if (((super.a(paramInt) instanceof GroupSearchModeTitle)) && (this.b == 12))
    {
      localObject = (GroupSearchModeTitle)super.a(paramInt);
      if ((localObject != null) && (((GroupSearchModeTitle)localObject).jdField_a_of_type_Boolean)) {
        return 15;
      }
      return 57;
    }
    if ((super.a(paramInt) instanceof GroupSearchModelFooter))
    {
      localObject = (GroupSearchModelFooter)super.a(paramInt);
      if ((localObject != null) && (((GroupSearchModelFooter)localObject).jdField_a_of_type_Boolean)) {
        return 49;
      }
      return 57;
    }
    if ((super.a(paramInt) instanceof GroupSearchModelPublicAcnt)) {
      return 2;
    }
    if ((super.a(paramInt) instanceof GroupNetSearchModelPeople)) {
      return 5;
    }
    if ((super.a(paramInt) instanceof GroupSearchModelMiniProgram)) {
      return 56;
    }
    if ((super.a(paramInt) instanceof GroupNetSearchModelTroop)) {
      return 6;
    }
    if ((super.a(paramInt) instanceof GroupSearchModelMostUsed)) {
      return 60;
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
    if (((super.a(paramInt) instanceof GroupSearchModelLocalContact)) || ((super.a(paramInt) instanceof GroupSearchModelLocalTroop))) {
      return 13;
    }
    if ((a(paramInt) instanceof GroupSearchModelMultiChat)) {
      return 17;
    }
    if ((a(paramInt) instanceof GroupSearchModelLocalContactApproximate)) {
      return 19;
    }
    if ((a(paramInt) instanceof RichSearchModelNode)) {
      return 59;
    }
    if ((a(paramInt) instanceof GroupBaseNetSearchModelItem))
    {
      localObject = (GroupBaseNetSearchModelItem)a(paramInt);
      if (localObject == null) {
        return 25;
      }
      switch (((GroupBaseNetSearchModelItem)localObject).d())
      {
      default: 
        return 25;
      case 268435456: 
        return 26;
      case 1001: 
        return 21;
      }
      return 22;
    }
    if ((a(paramInt) instanceof SearchResultModelForEntrance))
    {
      localObject = (SearchResultModelForEntrance)a(paramInt);
      if (localObject == null) {
        return 29;
      }
      switch (((SearchResultModelForEntrance)localObject).jdField_a_of_type_Int)
      {
      case -2: 
      default: 
        return 29;
      case -1: 
        return 29;
      case -3: 
        return 30;
      }
      return 36;
    }
    if ((a(paramInt) instanceof NetSearchTemplateBaseItem))
    {
      localObject = (NetSearchTemplateBaseItem)a(paramInt);
      if (localObject == null) {
        return 45;
      }
      switch (((NetSearchTemplateBaseItem)localObject).d())
      {
      case 5: 
      case 10: 
      default: 
        return 45;
      case 2: 
        return 38;
      case 3: 
        return 39;
      case 4: 
        return 42;
      case 7: 
        return 44;
      case 6: 
        return 45;
      case 8: 
        return 47;
      case 9: 
        return 48;
      case 11: 
        return 50;
      case 12: 
        return 51;
      case 13: 
        return 52;
      case 14: 
        return 53;
      case 15: 
        return 54;
      case 16: 
        return 55;
      case 17: 
        return 61;
      }
      return 62;
    }
    if ((a(paramInt) instanceof PublicAccountSearchResultModel)) {
      return 46;
    }
    return 4;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    IModel localIModel = a(paramInt);
    Object localObject3;
    int j;
    int i;
    Object localObject6;
    Object localObject7;
    if (SearchUtil.a(localIModel) > 0)
    {
      Object localObject1;
      if (SearchUtil.b.containsKey(localIModel))
      {
        localObject1 = (SearchUtil.ObjectItemInfo)SearchUtil.b.get(localIModel);
        if (!((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Boolean)
        {
          ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Boolean = true;
          localObject3 = new JSONObject();
        }
      }
      try
      {
        ((JSONObject)localObject3).put("project", UniteSearchReportController.a());
        ((JSONObject)localObject3).put("event_src", "client");
        ((JSONObject)localObject3).put("get_src", "native");
        ((JSONObject)localObject3).put("obj_lct", ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Int);
        localObject4 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        UniteSearchReportController.a((QQAppInterface)localObject4, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Long + "").obj2(((SearchUtil.ObjectItemInfo)localObject1).jdField_b_of_type_JavaLangString).ver1(((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(this.b)).ver7(((JSONObject)localObject3).toString()).session_id(((QQAppInterface)localObject4).getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
        ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Boolean = true;
        SearchUtil.b.put(localIModel, localObject1);
        if ((localIModel instanceof ISearchResultGroupModel))
        {
          localObject1 = (ISearchResultGroupModel)localIModel;
          localObject3 = ((ISearchResultGroupModel)localObject1).a();
          if ((localObject3 != null) && (((List)localObject3).size() > 0))
          {
            j = Math.min(((List)localObject3).size(), ((ISearchResultGroupModel)localObject1).a());
            i = 0;
            if (i < j) {
              if (SearchUtil.b.containsKey(((List)localObject3).get(i)))
              {
                localObject4 = (SearchUtil.ObjectItemInfo)SearchUtil.b.get(((List)localObject3).get(i));
                if (!((SearchUtil.ObjectItemInfo)localObject4).jdField_a_of_type_Boolean)
                {
                  ((SearchUtil.ObjectItemInfo)localObject4).jdField_a_of_type_Boolean = true;
                  localObject6 = new JSONObject();
                }
              }
            }
          }
        }
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          for (;;)
          {
            Object localObject4;
            ((JSONObject)localObject6).put("project", UniteSearchReportController.a());
            ((JSONObject)localObject6).put("event_src", "client");
            ((JSONObject)localObject6).put("get_src", "native");
            ((JSONObject)localObject6).put("obj_lct", ((SearchUtil.ObjectItemInfo)localObject4).jdField_a_of_type_Int);
            if (!(((List)localObject3).get(i) instanceof MiniProgramSearchResultModel)) {
              break label716;
            }
            localObject7 = (MiniProgramSearchResultModel)((List)localObject3).get(i);
            if (!((MiniProgramSearchResultModel)localObject7).c()) {
              break;
            }
            localObject1 = "1";
            ((SearchUtil.ObjectItemInfo)localObject4).jdField_b_of_type_JavaLangString = ((MiniProgramSearchResultModel)localObject7).e();
            localObject7 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            UniteSearchReportController.a((QQAppInterface)localObject7, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((SearchUtil.ObjectItemInfo)localObject4).jdField_a_of_type_Long + "").obj2(((SearchUtil.ObjectItemInfo)localObject4).jdField_b_of_type_JavaLangString).ver1(((SearchUtil.ObjectItemInfo)localObject4).jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(this.b)).ver3((String)localObject1).ver7(((JSONObject)localObject6).toString()).session_id(((QQAppInterface)localObject7).getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
            ((SearchUtil.ObjectItemInfo)localObject4).jdField_a_of_type_Boolean = true;
            SearchUtil.b.put(((List)localObject3).get(i), localObject4);
            i += 1;
          }
          localJSONException2 = localJSONException2;
          QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException2);
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException1);
            continue;
            localObject2 = "0";
            continue;
            label716:
            localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            UniteSearchReportController.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("exp_item").obj1(localJSONException2.jdField_a_of_type_Long + "").obj2(localJSONException2.jdField_b_of_type_JavaLangString).ver1(localJSONException2.jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(this.b)).ver7(((JSONObject)localObject6).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
            localJSONException2.jdField_a_of_type_Boolean = true;
            SearchUtil.b.put(((List)localObject3).get(i), localJSONException2);
          }
        }
      }
    }
    Object localObject5;
    if ((localIModel instanceof GroupBaseNetSearchModel))
    {
      localObject2 = (GroupBaseNetSearchModel)localIModel;
      if ((((GroupBaseNetSearchModel)localObject2).a() != null) && (((GroupBaseNetSearchModel)localObject2).a().size() > 0))
      {
        i = 0;
        for (;;)
        {
          if (i >= ((GroupBaseNetSearchModel)localObject2).a().size()) {
            break label1809;
          }
          localObject3 = (IModel)((GroupBaseNetSearchModel)localObject2).a().get(i);
          if (SearchUtil.b.containsKey(localObject3))
          {
            localObject3 = (SearchUtil.ObjectItemInfo)SearchUtil.b.get(localObject3);
            if (!((SearchUtil.ObjectItemInfo)localObject3).jdField_a_of_type_Boolean)
            {
              ((SearchUtil.ObjectItemInfo)localObject3).jdField_a_of_type_Boolean = true;
              localObject5 = new JSONObject();
            }
          }
          try
          {
            ((JSONObject)localObject5).put("project", UniteSearchReportController.a());
            ((JSONObject)localObject5).put("event_src", "client");
            ((JSONObject)localObject5).put("get_src", "web");
            ((JSONObject)localObject5).put("obj_lct", ((SearchUtil.ObjectItemInfo)localObject3).jdField_a_of_type_Int);
            localObject6 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            UniteSearchReportController.a((QQAppInterface)localObject6, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((SearchUtil.ObjectItemInfo)localObject3).jdField_a_of_type_Long + "").obj2(((SearchUtil.ObjectItemInfo)localObject3).jdField_b_of_type_JavaLangString).ver1(((SearchUtil.ObjectItemInfo)localObject3).jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(this.b)).ver7(((JSONObject)localObject5).toString()).session_id(((QQAppInterface)localObject6).getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
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
      localObject2 = ((NetSearchTemplateHorizontalContainerItem)localIModel).a;
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label1809;
          }
          localObject3 = (NetSearchTemplateHorizontalBaseItem)((Iterator)localObject2).next();
          if (SearchUtil.b.containsKey(localObject3))
          {
            localObject5 = (SearchUtil.ObjectItemInfo)SearchUtil.b.get(localObject3);
            if (!((SearchUtil.ObjectItemInfo)localObject5).jdField_a_of_type_Boolean)
            {
              ((SearchUtil.ObjectItemInfo)localObject5).jdField_a_of_type_Boolean = true;
              JSONObject localJSONObject = new JSONObject();
              try
              {
                localJSONObject.put("project", UniteSearchReportController.a());
                localJSONObject.put("event_src", "client");
                localJSONObject.put("get_src", "web");
                localJSONObject.put("obj_lct", ((SearchUtil.ObjectItemInfo)localObject5).jdField_a_of_type_Int);
                localJSONObject.put("extra_info", ((NetSearchTemplateHorizontalBaseItem)localObject3).jdField_b_of_type_JavaLangString);
                localJSONObject.put("tepl", ((NetSearchTemplateHorizontalBaseItem)localObject3).f);
                localObject7 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
                UniteSearchReportController.a((QQAppInterface)localObject7, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((NetSearchTemplateHorizontalBaseItem)localObject3).jdField_a_of_type_Long + "").obj2(((NetSearchTemplateHorizontalBaseItem)localObject3).j).ver1(((SearchUtil.ObjectItemInfo)localObject5).jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(this.b)).ver7(localJSONObject.toString()).session_id(((QQAppInterface)localObject7).getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
              }
              catch (JSONException localJSONException5)
              {
                for (;;)
                {
                  QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException5);
                }
              }
            }
          }
        }
      }
    }
    else
    {
      if (!(localIModel instanceof NetSearchTemplateNetSeaEntranceItem)) {
        break label2272;
      }
      if (SearchUtil.b.containsKey(localIModel))
      {
        localObject2 = (SearchUtil.ObjectItemInfo)SearchUtil.b.get(localIModel);
        localObject3 = (NetSearchTemplateNetSeaEntranceItem)localIModel;
        if (!((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Boolean)
        {
          ((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Boolean = true;
          localObject5 = new StringBuilder();
          if ((((NetSearchTemplateNetSeaEntranceItem)localObject3).a != null) && (((NetSearchTemplateNetSeaEntranceItem)localObject3).a.size() > 0))
          {
            i = 0;
            if (i < ((NetSearchTemplateNetSeaEntranceItem)localObject3).a.size())
            {
              if (i != ((NetSearchTemplateNetSeaEntranceItem)localObject3).a.size() - 1) {
                ((StringBuilder)localObject5).append(((NetSearchSubItem)((NetSearchTemplateNetSeaEntranceItem)localObject3).a.get(i)).jdField_b_of_type_JavaLangString).append("::");
              }
              for (;;)
              {
                i += 1;
                break;
                ((StringBuilder)localObject5).append(((NetSearchSubItem)((NetSearchTemplateNetSeaEntranceItem)localObject3).a.get(i)).jdField_b_of_type_JavaLangString);
              }
            }
          }
          UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("exp_web_search").obj1("2073745984").ver1(((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(this.b)).ver4(((StringBuilder)localObject5).toString()).ver5("1").ver7("{experiment_id:" + UniteSearchReportController.jdField_b_of_type_JavaLangString + "}"));
        }
      }
    }
    label1809:
    if (SearchUtil.jdField_a_of_type_JavaUtilHashMap.containsKey(localIModel))
    {
      localObject2 = (SearchUtil.ObjectItemInfo)SearchUtil.jdField_a_of_type_JavaUtilHashMap.get(localIModel);
      if (!((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Boolean)
      {
        if (SearchUtils.a(((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Long))
        {
          if (!((SearchUtil.ObjectItemInfo)localObject2).jdField_b_of_type_Boolean) {
            break label2889;
          }
          i = 2;
          label1863:
          SearchUtils.a("all_result", "exp_object", i, 0, new String[] { ((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_JavaLangString, ((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Long + "", ((SearchUtil.ObjectItemInfo)localObject2).jdField_b_of_type_JavaLangString, ((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Int + "" });
          ((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Boolean = true;
          SearchUtil.jdField_a_of_type_JavaUtilHashMap.put((ISearchResultModel)localIModel, localObject2);
        }
        if ((localIModel instanceof SearchResultModelForEntrance))
        {
          localObject3 = (SearchResultModelForEntrance)localIModel;
          if ((((SearchResultModelForEntrance)localObject3).jdField_a_of_type_Int == -3) || (((SearchResultModelForEntrance)localObject3).jdField_a_of_type_Int == -4))
          {
            if (!((SearchUtil.ObjectItemInfo)localObject2).jdField_b_of_type_Boolean) {
              break label2895;
            }
            i = 2;
            label2015:
            SearchUtils.a("all_result", "exp_net_search", i, 0, new String[] { ((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_JavaLangString, ((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Long + "", ((SearchUtil.ObjectItemInfo)localObject2).jdField_b_of_type_JavaLangString, ((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Int + "" });
          }
        }
      }
    }
    Object localObject2 = paramView;
    if (!a(paramView, localIModel)) {
      localObject2 = null;
    }
    paramView = super.getView(paramInt, (View)localObject2, paramViewGroup);
    a(paramInt, paramView, localIModel);
    boolean bool1 = false;
    if (paramInt == 0) {
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (paramInt >= 1)
    {
      i = getItemViewType(paramInt);
      j = getItemViewType(paramInt - 1);
      if (i != 11)
      {
        bool2 = bool1;
        if (i != 10) {}
      }
      else if (j != 11)
      {
        bool2 = bool1;
        if (j != 10) {}
      }
      else
      {
        bool2 = true;
      }
      bool2 = a(paramView, localIModel, paramInt, i, j, bool2);
    }
    if ((paramView != null) && (paramView.findViewById(2131365939) != null))
    {
      if (!bool2) {
        break label2901;
      }
      paramView.findViewById(2131365939).setVisibility(8);
    }
    for (;;)
    {
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
        return paramView;
        label2272:
        if (((!(localIModel instanceof NetSearchTemplateBaseItem)) || ((localIModel instanceof NetSearchTemplateSubItemTitle))) && (((!(localIModel instanceof GroupBaseNetSearchModelItem)) && ((!(localIModel instanceof SearchResultModelForEntrance)) || (((SearchResultModelForEntrance)localIModel).jdField_a_of_type_Int != -4))) || (!SearchUtil.b.containsKey(localIModel)))) {
          break;
        }
        localObject2 = (SearchUtil.ObjectItemInfo)SearchUtil.b.get(localIModel);
        if ((localIModel instanceof NetSearchTemplateNewEntranceItem))
        {
          localObject3 = (NetSearchTemplateNewEntranceItem)localIModel;
          if (!((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Boolean)
          {
            ((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Boolean = true;
            localObject5 = new StringBuilder();
            if ((((NetSearchTemplateNewEntranceItem)localObject3).a != null) && (((NetSearchTemplateNewEntranceItem)localObject3).a.size() > 0))
            {
              i = 0;
              while (i < ((NetSearchTemplateNewEntranceItem)localObject3).a.size())
              {
                ((StringBuilder)localObject5).append(((RelativeWord)((NetSearchTemplateNewEntranceItem)localObject3).a.get(i)).jdField_a_of_type_JavaLangString).append("::");
                i += 1;
              }
              UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("exp_relatedsearch_list").obj1("1007").ver1(((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(this.b)).ver4(((StringBuilder)localObject5).toString()).ver5("1").ver7("{experiment_id:" + UniteSearchReportController.jdField_b_of_type_JavaLangString + "}"));
            }
            UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("exp_web_search").obj1("2073745984").ver1(((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(this.b)).ver5("2").ver7("{experiment_id:" + UniteSearchReportController.jdField_b_of_type_JavaLangString + "}"));
          }
        }
        if (((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Boolean) {
          break;
        }
        ((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Boolean = true;
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("project", UniteSearchReportController.a());
          ((JSONObject)localObject3).put("event_src", "client");
          ((JSONObject)localObject3).put("get_src", "web");
          ((JSONObject)localObject3).put("obj_lct", ((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Int);
          if ((localIModel instanceof NetSearchTemplateBaseItem)) {
            ((JSONObject)localObject3).put("tepl", ((NetSearchTemplateBaseItem)localIModel).f);
          }
          localObject5 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          UniteSearchReportController.a((QQAppInterface)localObject5, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Long + "").obj2(((SearchUtil.ObjectItemInfo)localObject2).jdField_b_of_type_JavaLangString).ver1(((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(this.b)).ver7(((JSONObject)localObject3).toString()).session_id(((QQAppInterface)localObject5).getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
        }
        catch (JSONException localJSONException3)
        {
          for (;;)
          {
            QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException3);
          }
        }
      }
      label2889:
      i = 1;
      break label1863;
      label2895:
      i = 1;
      break label2015;
      label2901:
      paramView.findViewById(2131365939).setVisibility(0);
    }
  }
  
  public int getViewTypeCount()
  {
    return 63;
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
      QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "onDecodeTaskCompleted, remainingTasks : " + paramInt1 + ", type : " + paramInt2 + ", uin : " + paramString + ", avatar : " + paramBitmap + ", mFaceDecoder.isPausing() : " + this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing() + ", mScrollState : " + this.jdField_a_of_type_Int);
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < j)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1);
        IFaceModel localIFaceModel;
        IFacePresenter localIFacePresenter;
        IFaceView localIFaceView;
        if (((localView.getTag(2131381651) instanceof IFaceModel)) && ((localView.getTag(2131381653) instanceof IFacePresenter)) && ((localView.getTag(2131381656) instanceof IFaceView)))
        {
          localIFaceModel = (IFaceModel)localView.getTag(2131381651);
          localIFacePresenter = (IFacePresenter)localView.getTag(2131381653);
          localIFaceView = (IFaceView)localView.getTag(2131381656);
          if ((localIFaceModel.c() == paramInt2) && (paramString.equals(localIFaceModel.b()))) {
            localIFacePresenter.a(localIFaceModel, localIFaceView, paramBitmap);
          }
        }
        if ((localView instanceof ViewGroup))
        {
          int i = 0;
          while (i < ((ViewGroup)localView).getChildCount())
          {
            localIFaceModel = (IFaceModel)((ViewGroup)localView).getChildAt(i).getTag(2131381651);
            if ((localIFaceModel != null) && (localIFaceModel.c() == paramInt2) && (paramString.equals(localIFaceModel.b())))
            {
              localIFacePresenter = (IFacePresenter)((ViewGroup)localView).getChildAt(i).getTag(2131381653);
              localIFaceView = (IFaceView)((ViewGroup)localView).getChildAt(i).getTag(2131381656);
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
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeController.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    int k;
    int i;
    if ((paramInt == 0) || (paramInt == 1))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.resume();
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
          IFaceModel localIFaceModel = (IFaceModel)((ViewGroup)localView).getChildAt(j).getTag(2131381651);
          IFacePresenter localIFacePresenter = (IFacePresenter)((ViewGroup)localView).getChildAt(j).getTag(2131381653);
          IFaceView localIFaceView = (IFaceView)((ViewGroup)localView).getChildAt(j).getTag(2131381656);
          if ((localIFacePresenter != null) && (localIFaceModel != null) && (paramAbsListView != null)) {
            localIFacePresenter.a(localIFaceModel, localIFaceView);
          }
          j += 1;
        }
      }
      i += 1;
      continue;
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
    }
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeController.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.adapter.GroupSearchAdapter
 * JD-Core Version:    0.7.0.1
 */