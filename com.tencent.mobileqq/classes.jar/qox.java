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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class qox
  implements qqa
{
  public static int a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.mNewPolymericInfo != null) {}
    switch (paramBaseArticleInfo.mNewPolymericInfo.a)
    {
    default: 
      if (!pqw.b(paramBaseArticleInfo)) {
        break;
      }
    }
    while ((pqw.d(paramBaseArticleInfo)) || (paramBaseArticleInfo.mSinglePicture != null))
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
    if ((ppe.a(paramArticleInfo)) || (ppe.h(paramArticleInfo)) || (paramInt == 77) || (paramInt == 78))
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
        localObject1 = pjj.k + bhcu.encodeToString(String.valueOf(l1).getBytes(), 2);
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
        localObject3 = pjj.k + bhcu.encodeToString(String.valueOf(l1).getBytes(), 2);
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
      if (!ppe.g(paramArticleInfo))
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
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq != null)
          {
            l1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.a;
            localObject2 = pjj.g + bhcu.encodeToString(String.valueOf(l1).getBytes(), 2);
            continue;
            label376:
            if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq != null))
            {
              l2 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.a;
              localObject3 = pjj.g + bhcu.encodeToString(String.valueOf(l2).getBytes(), 2);
            }
            else
            {
              l2 = l1;
              localObject3 = localObject2;
              if (paramArticleInfo.mSocialFeedInfo != null)
              {
                l2 = l1;
                localObject3 = localObject2;
                if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy != null)
                {
                  l2 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.a;
                  localObject3 = pjj.g + bhcu.encodeToString(String.valueOf(l2).getBytes(), 2);
                }
              }
            }
          }
        }
      }
    }
  }
  
  private qlk a(qlk paramqlk, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = paramqlk;
    int i;
    if (paramBaseArticleInfo != null)
    {
      localObject = paramqlk;
      if (paramBaseArticleInfo.mGroupSubArticleList != null)
      {
        localObject = paramqlk;
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
      paramqlk.a("jump_url", localObject);
      if (i == 1)
      {
        localObject = b(paramqlk, paramInt, paramBaseArticleInfo);
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
        qlk localqlk = paramqlk;
      } while (i != 2);
    }
    return c(paramqlk, paramInt, paramBaseArticleInfo);
  }
  
  private void a(ViewBase paramViewBase, ArticleInfo paramArticleInfo, qfw paramqfw)
  {
    if ((paramArticleInfo == null) || (paramViewBase == null) || (paramqfw == null))
    {
      QLog.i("PackProteusItem", 1, "[bindItemClickListener], articleInfo or parent is null.");
      return;
    }
    paramViewBase = (qwn)paramViewBase.findViewBaseByName("id_proteus_collection_view");
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
    paramViewBase.a(new qoz(this, localList, paramArticleInfo, paramqfw));
  }
  
  private void a(ViewBase paramViewBase, qfw paramqfw)
  {
    if ((paramViewBase == null) || (paramqfw == null) || (paramqfw.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_topic_avator");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    paramViewBase = paramViewBase.getNativeView();
    Context localContext = paramViewBase.getContext();
    paramViewBase.setOnClickListener(new qoy(this, paramqfw.a(), localContext));
  }
  
  private void a(qfw paramqfw, Context paramContext, ComponentPolymericView paramComponentPolymericView)
  {
    if (paramqfw.e() == 56)
    {
      paramComponentPolymericView.setDividerWidth(AIOUtils.dp2px(3.0F, paramContext.getResources()));
      paramComponentPolymericView.setPadding(DisplayUtil.dip2px(paramContext, 6.0F), 0, DisplayUtil.dip2px(paramContext, 6.0F), DisplayUtil.dip2px(paramContext, 5.0F));
    }
    for (;;)
    {
      paramComponentPolymericView.setClipToPadding(false);
      paramComponentPolymericView.setClipChildren(false);
      return;
      paramComponentPolymericView.setDividerWidth(AIOUtils.dp2px(3.0F, paramContext.getResources()));
      if (pqw.m(paramqfw.a())) {
        paramComponentPolymericView.setPadding(DisplayUtil.dip2px(paramContext, 6.0F), 0, DisplayUtil.dip2px(paramContext, 12.0F), DisplayUtil.dip2px(paramContext, 2.0F));
      } else {
        paramComponentPolymericView.setPadding(DisplayUtil.dip2px(paramContext, 6.0F), 0, DisplayUtil.dip2px(paramContext, 12.0F), 0);
      }
    }
  }
  
  private qlk b(qlk paramqlk, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      qmm.a(paramBaseArticleInfo, paramInt, localJSONArray);
      paramqlk.a("datas", localJSONArray);
      return paramqlk;
    }
    catch (JSONException paramBaseArticleInfo)
    {
      QLog.e("PackProteusItem", 2, paramBaseArticleInfo.getMessage());
    }
    return paramqlk;
  }
  
  private qlk c(qlk paramqlk, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      qmm.b(paramBaseArticleInfo, paramInt, localJSONArray);
      paramqlk.a("datas", localJSONArray);
      return paramqlk;
    }
    catch (JSONException paramBaseArticleInfo)
    {
      QLog.e("PackProteusItem", 2, paramBaseArticleInfo.getMessage());
    }
    return paramqlk;
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    qlk localqlk = new qlk();
    if (paramBaseArticleInfo == null)
    {
      QLog.e("PackProteusItem", 2, "newpolymeric getDataJson info = null");
      return null;
    }
    long l1 = 0L;
    if (paramInt == 79) {
      return localqlk.c(paramBaseArticleInfo).j(paramBaseArticleInfo).r(paramBaseArticleInfo).z(paramBaseArticleInfo).a("ReadInjoy_pack_topic_cell").a();
    }
    if ((pqw.o(paramBaseArticleInfo)) || (pqw.p(paramBaseArticleInfo))) {
      return localqlk.r(paramBaseArticleInfo).z(paramBaseArticleInfo).a("ReadInjoy_pack_cell").a();
    }
    long l2;
    if (paramInt == 76)
    {
      l2 = l1;
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        l2 = l1;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq != null) {
          l2 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.a;
        }
      }
      paramBaseArticleInfo = a(localqlk, paramInt, paramBaseArticleInfo).b(paramBaseArticleInfo).r(paramBaseArticleInfo).a(paramBaseArticleInfo, l2).g(paramBaseArticleInfo).f(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).k(paramBaseArticleInfo).z(paramBaseArticleInfo).a("ReadInjoy_pack_cell").a();
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
      paramBaseArticleInfo = a(localqlk, paramInt, paramBaseArticleInfo).b(paramBaseArticleInfo).r(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).g(paramBaseArticleInfo).d(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).k(paramBaseArticleInfo).z(paramBaseArticleInfo).a("ReadInjoy_pack_cell").a();
      QLog.d("PackProteusItem", 2, "result is " + paramBaseArticleInfo);
      return paramBaseArticleInfo;
    }
    QLog.e("PackProteusItem", 2, "newpolymeric card wrong articleinfo and viewType articleinfo = " + paramBaseArticleInfo);
    return null;
  }
  
  public void a(int paramInt1, Container paramContainer, qfw paramqfw, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject1 = (qud)localViewBase.findViewBaseByName("id_middle_body_content");
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = (NativeMiddleBodyView)((qud)localObject1).getNativeView();
      if (((NativeMiddleBodyView)localObject2).a() == null)
      {
        localObject3 = new ComponentPolymericPullAnimatorView(paramContainer.getContext(), paramqfw);
        if ((localObject3 == null) || (!(((View)localObject3).getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label198;
        }
        localObject1 = (RelativeLayout.LayoutParams)((View)localObject3).getLayoutParams();
        if (localObject3 != null)
        {
          a(paramqfw, paramContainer.getContext(), ((ComponentPolymericPullAnimatorView)localObject3).a());
          ((NativeMiddleBodyView)localObject2).a((View)localObject3, (RelativeLayout.LayoutParams)localObject1);
        }
      }
      a(paramqfw, (NativeMiddleBodyView)localObject2);
    }
    else
    {
      localObject1 = paramqfw.a();
      if (pqw.u((BaseArticleInfo)localObject1)) {
        break label213;
      }
      qvn.f(localViewBase, paramqfw);
      qvn.a(localViewBase, paramqfw.a());
      if (paramInt1 == 76) {
        qmm.a(localViewBase, paramqfw);
      }
    }
    for (;;)
    {
      paramContainer = localViewBase.findViewBaseByName("id_proteus_collection_view");
      if ((paramContainer instanceof qwn)) {
        ((qwn)paramContainer).a(paramqfw);
      }
      a(localViewBase, (ArticleInfo)localObject1, paramqfw);
      return;
      label198:
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      break;
      label213:
      a(localViewBase, paramqfw);
      localObject2 = (NativeText)localViewBase.findViewBaseByName("id_topic_recommend_biu_time");
      if ((localObject2 != null) && (((ArticleInfo)localObject1).mTopicRecommendFeedsInfo != null) && (((ArticleInfo)localObject1).mTopicRecommendFeedsInfo.a != null) && (((ArticleInfo)localObject1).mTopicRecommendFeedsInfo.a.size() > 0))
      {
        localObject3 = (rsj)((ArticleInfo)localObject1).mTopicRecommendFeedsInfo.a.get(0);
        ((NativeText)localObject2).setText(String.format(paramContainer.getContext().getString(2131717907), new Object[] { bmhv.b(((rsj)localObject3).b) }));
        if (QLog.isColorLevel()) {
          QLog.d("PackProteusItem", 2, "PackProteusItem update articleInfo UI articleID = " + ((ArticleInfo)localObject1).mArticleID + ", mRecommendSeq =" + ((ArticleInfo)localObject1).mRecommendSeq + "，followType=" + ((rsj)localObject3).c);
        }
      }
    }
  }
  
  protected void a(qfw paramqfw, NativeMiddleBodyView paramNativeMiddleBodyView)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (paramqfw.a() == null)) {
      return;
    }
    paramNativeMiddleBodyView = (ComponentPolymericPullAnimatorView)paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.a().a(paramqfw);
  }
  
  public boolean a(int paramInt, Container paramContainer, qfw paramqfw, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qox
 * JD-Core Version:    0.7.0.1
 */