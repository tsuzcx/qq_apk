import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericPullAnimatorView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class pmx
  implements poa
{
  public static int a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.mNewPolymericInfo != null) {}
    switch (paramBaseArticleInfo.mNewPolymericInfo.a)
    {
    default: 
      if (!ors.c(paramBaseArticleInfo)) {
        break;
      }
    }
    while ((ors.e(paramBaseArticleInfo)) || (paramBaseArticleInfo.mSinglePicture != null))
    {
      return 2;
      return 1;
    }
    return 0;
  }
  
  private String a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo == null)
    {
      QLog.i("PackProteusItem", 1, "[getJumpUrl], articleInfo is null.");
      return "";
    }
    Object localObject3 = "";
    long l2 = 0L;
    long l1;
    Object localObject1;
    if ((rqj.a(paramArticleInfo)) || (rqj.h(paramArticleInfo)) || (paramInt == 77) || (paramInt == 78))
    {
      l1 = l2;
      localObject1 = localObject3;
      if (TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {}
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(paramArticleInfo.mSubscribeID);
        localObject1 = oqu.k + bdbi.encodeToString(String.valueOf(l1).getBytes(), 2);
        l2 = l1;
        localObject3 = localObject1;
        if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty(paramArticleInfo.mSubscribeID))) {
          break label376;
        }
        try
        {
          l2 = Long.parseLong(paramArticleInfo.mSubscribeID);
          l1 = l2;
        }
        catch (NumberFormatException paramArticleInfo)
        {
          QLog.i("PackProteusItem", 1, "[getJumpUrl], e = " + paramArticleInfo);
          continue;
        }
        localObject3 = oqu.k + bdbi.encodeToString(String.valueOf(l1).getBytes(), 2);
        l2 = l1;
        QLog.i("PackProteusItem", 1, "[getJumpUlr], url = " + (String)localObject3 + ", uin = " + l2);
        return localObject3;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.i("PackProteusItem", 1, "[getJumpUrl], e = " + localNumberFormatException);
        l1 = l2;
        continue;
      }
      Object localObject2;
      if (!rqj.b(paramArticleInfo))
      {
        l1 = l2;
        localObject2 = localObject3;
        if (paramInt != 76) {}
      }
      else
      {
        l1 = l2;
        localObject2 = localObject3;
        if (paramArticleInfo.mSocialFeedInfo != null)
        {
          l1 = l2;
          localObject2 = localObject3;
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw != null)
          {
            l1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.a;
            localObject2 = oqu.g + bdbi.encodeToString(String.valueOf(l1).getBytes(), 2);
            continue;
            label376:
            if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw != null))
            {
              l2 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.a;
              localObject3 = oqu.g + bdbi.encodeToString(String.valueOf(l2).getBytes(), 2);
            }
            else
            {
              l2 = l1;
              localObject3 = localObject2;
              if (paramArticleInfo.mSocialFeedInfo != null)
              {
                l2 = l1;
                localObject3 = localObject2;
                if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme != null)
                {
                  l2 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme.a;
                  localObject3 = oqu.g + bdbi.encodeToString(String.valueOf(l2).getBytes(), 2);
                }
              }
            }
          }
        }
      }
    }
  }
  
  private pjo a(pjo parampjo, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = parampjo;
    int i;
    if (paramBaseArticleInfo != null)
    {
      localObject = parampjo;
      if (paramBaseArticleInfo.mGroupSubArticleList != null)
      {
        localObject = parampjo;
        if (paramBaseArticleInfo.mGroupSubArticleList.size() > 0)
        {
          QLog.d("PackProteusItem", 2, "mGroupSubArticleList: " + paramBaseArticleInfo.mGroupSubArticleList.size());
          localObject = (BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0);
          i = a((BaseArticleInfo)localObject);
          localObject = a((ArticleInfo)localObject, paramInt);
        }
      }
    }
    try
    {
      parampjo.a("jump_url", localObject);
      if (i == 1)
      {
        localObject = b(parampjo, paramInt, paramBaseArticleInfo);
        return localObject;
      }
    }
    catch (JSONException localJSONException)
    {
      do
      {
        for (;;)
        {
          QLog.e("PackProteusItem", 1, "[buildProteusCollectionView], e = " + localJSONException);
        }
        pjo localpjo = parampjo;
      } while (i != 2);
    }
    return c(parampjo, paramInt, paramBaseArticleInfo);
  }
  
  private void a(ViewBase paramViewBase, ArticleInfo paramArticleInfo, pgd parampgd)
  {
    if ((paramArticleInfo == null) || (paramViewBase == null) || (parampgd == null))
    {
      QLog.i("PackProteusItem", 1, "[bindItemClickListener], articleInfo or parent is null.");
      return;
    }
    paramViewBase = (ptw)paramViewBase.findViewBaseByName("id_proteus_collection_view");
    if (paramViewBase == null)
    {
      QLog.i("PackProteusItem", 1, "[bindItemClickListener], proteus_collection_view is null.");
      return;
    }
    List localList = paramArticleInfo.mGroupSubArticleList;
    if ((localList == null) || (localList.isEmpty()))
    {
      QLog.i("PackProteusItem", 1, "[bindItemClickListener], dataList is empty");
      return;
    }
    paramViewBase.a(new pmz(this, localList, paramArticleInfo, parampgd));
  }
  
  private void a(ViewBase paramViewBase, pgd parampgd)
  {
    if ((paramViewBase == null) || (parampgd == null) || (parampgd.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_topic_avator");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    paramViewBase = paramViewBase.getNativeView();
    Context localContext = paramViewBase.getContext();
    paramViewBase.setOnClickListener(new pmy(this, parampgd.a(), localContext));
  }
  
  private void a(pgd parampgd, Context paramContext, ComponentPolymericView paramComponentPolymericView)
  {
    if (parampgd.e() == 56)
    {
      paramComponentPolymericView.setDividerWidth(aekt.a(3.0F, paramContext.getResources()));
      paramComponentPolymericView.setPadding(bcwh.a(paramContext, 6.0F), 0, bcwh.a(paramContext, 6.0F), bcwh.a(paramContext, 5.0F));
    }
    for (;;)
    {
      paramComponentPolymericView.setClipToPadding(false);
      paramComponentPolymericView.setClipChildren(false);
      return;
      paramComponentPolymericView.setDividerWidth(aekt.a(3.0F, paramContext.getResources()));
      if (ors.m(parampgd.a())) {
        paramComponentPolymericView.setPadding(bcwh.a(paramContext, 6.0F), 0, bcwh.a(paramContext, 12.0F), bcwh.a(paramContext, 2.0F));
      } else {
        paramComponentPolymericView.setPadding(bcwh.a(paramContext, 6.0F), 0, bcwh.a(paramContext, 12.0F), 0);
      }
    }
  }
  
  private pjo b(pjo parampjo, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      pkm.a(paramBaseArticleInfo, paramInt, localJSONArray);
      parampjo.a("datas", localJSONArray);
      return parampjo;
    }
    catch (JSONException paramBaseArticleInfo)
    {
      QLog.e("PackProteusItem", 2, paramBaseArticleInfo.getMessage());
    }
    return parampjo;
  }
  
  private pjo c(pjo parampjo, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      pkm.b(paramBaseArticleInfo, paramInt, localJSONArray);
      parampjo.a("datas", localJSONArray);
      return parampjo;
    }
    catch (JSONException paramBaseArticleInfo)
    {
      QLog.e("PackProteusItem", 2, paramBaseArticleInfo.getMessage());
    }
    return parampjo;
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    pjo localpjo = new pjo();
    if (paramBaseArticleInfo == null)
    {
      QLog.e("PackProteusItem", 2, "newpolymeric getDataJson info = null");
      return null;
    }
    long l1 = 0L;
    if (paramInt == 79) {
      return localpjo.c(paramBaseArticleInfo).j(paramBaseArticleInfo).r(paramBaseArticleInfo).z(paramBaseArticleInfo).a("ReadInjoy_pack_topic_cell").a();
    }
    if ((ors.o(paramBaseArticleInfo)) || (ors.p(paramBaseArticleInfo))) {
      return localpjo.r(paramBaseArticleInfo).z(paramBaseArticleInfo).a("ReadInjoy_pack_cell").a();
    }
    long l2;
    if (paramInt == 76)
    {
      l2 = l1;
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        l2 = l1;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw != null) {
          l2 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.a;
        }
      }
      paramBaseArticleInfo = a(localpjo, paramInt, paramBaseArticleInfo).b(paramBaseArticleInfo).r(paramBaseArticleInfo).a(paramBaseArticleInfo, l2).g(paramBaseArticleInfo).f(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).k(paramBaseArticleInfo).z(paramBaseArticleInfo).a("ReadInjoy_pack_cell").a();
      QLog.d("PackProteusItem", 2, "result is " + paramBaseArticleInfo);
      return paramBaseArticleInfo;
    }
    if ((paramInt == 77) || (paramInt == 78))
    {
      try
      {
        l2 = Long.parseLong(paramBaseArticleInfo.mSubscribeID);
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("PackProteusItem", 2, "newpolymeric card pgc parse uin error uin = " + 0L + " error = " + localNumberFormatException);
        }
      }
      paramBaseArticleInfo = a(localpjo, paramInt, paramBaseArticleInfo).b(paramBaseArticleInfo).r(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).g(paramBaseArticleInfo).d(paramBaseArticleInfo).h(paramBaseArticleInfo).j(paramBaseArticleInfo).k(paramBaseArticleInfo).z(paramBaseArticleInfo).a("ReadInjoy_pack_cell").a();
      QLog.d("PackProteusItem", 2, "result is " + paramBaseArticleInfo);
      return paramBaseArticleInfo;
    }
    QLog.e("PackProteusItem", 2, "newpolymeric card wrong articleinfo and viewType articleinfo = " + paramBaseArticleInfo);
    return null;
  }
  
  public void a(int paramInt1, Container paramContainer, pgd parampgd, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject1 = (prm)localViewBase.findViewBaseByName("id_middle_body_content");
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = (NativeMiddleBodyView)((prm)localObject1).getNativeView();
      if (((NativeMiddleBodyView)localObject2).a() == null)
      {
        localObject3 = new ComponentPolymericPullAnimatorView(paramContainer.getContext(), parampgd);
        if ((localObject3 == null) || (!(((View)localObject3).getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label213;
        }
        localObject1 = (RelativeLayout.LayoutParams)((View)localObject3).getLayoutParams();
        if (localObject3 != null)
        {
          a(parampgd, paramContainer.getContext(), ((ComponentPolymericPullAnimatorView)localObject3).a());
          ((NativeMiddleBodyView)localObject2).a((View)localObject3, (RelativeLayout.LayoutParams)localObject1);
        }
      }
      a(parampgd, (NativeMiddleBodyView)localObject2);
    }
    else
    {
      localObject1 = parampgd.a();
      if (ors.v((BaseArticleInfo)localObject1)) {
        break label228;
      }
      paramContainer = (pqg)localViewBase.findViewBaseByName("id_info_avator");
      if (paramContainer != null) {
        paramContainer.a(parampgd);
      }
      psw.a(localViewBase, parampgd.a());
      if (paramInt1 == 76) {
        pkm.a(localViewBase, parampgd);
      }
    }
    for (;;)
    {
      paramContainer = localViewBase.findViewBaseByName("id_proteus_collection_view");
      if ((paramContainer instanceof ptw)) {
        ((ptw)paramContainer).a(parampgd);
      }
      a(localViewBase, (ArticleInfo)localObject1, parampgd);
      return;
      label213:
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      break;
      label228:
      a(localViewBase, parampgd);
      localObject2 = (NativeText)localViewBase.findViewBaseByName("id_topic_recommend_biu_time");
      if ((localObject2 != null) && (((ArticleInfo)localObject1).mTopicRecommendFeedsInfo != null) && (((ArticleInfo)localObject1).mTopicRecommendFeedsInfo.a != null) && (((ArticleInfo)localObject1).mTopicRecommendFeedsInfo.a.size() > 0))
      {
        localObject3 = (qno)((ArticleInfo)localObject1).mTopicRecommendFeedsInfo.a.get(0);
        ((NativeText)localObject2).setText(String.format(paramContainer.getContext().getString(2131719050), new Object[] { bjxj.b(((qno)localObject3).b) }));
        if (QLog.isColorLevel()) {
          QLog.d("PackProteusItem", 2, "PackProteusItem update articleInfo UI articleID = " + ((ArticleInfo)localObject1).mArticleID + ", mRecommendSeq =" + ((ArticleInfo)localObject1).mRecommendSeq + "，followType=" + ((qno)localObject3).c);
        }
      }
    }
  }
  
  protected void a(pgd parampgd, NativeMiddleBodyView paramNativeMiddleBodyView)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (parampgd.a() == null)) {
      return;
    }
    paramNativeMiddleBodyView = (ComponentPolymericPullAnimatorView)paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.a().a(parampgd);
  }
  
  public boolean a(int paramInt, Container paramContainer, pgd parampgd, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pmx
 * JD-Core Version:    0.7.0.1
 */