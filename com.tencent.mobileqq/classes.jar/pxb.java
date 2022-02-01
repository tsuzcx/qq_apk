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

public class pxb
  implements pye
{
  public static int a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.mNewPolymericInfo != null) {}
    switch (paramBaseArticleInfo.mNewPolymericInfo.a)
    {
    default: 
      if (!ozs.c(paramBaseArticleInfo)) {
        break;
      }
    }
    while ((ozs.e(paramBaseArticleInfo)) || (paramBaseArticleInfo.mSinglePicture != null))
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
    if ((sel.a(paramArticleInfo)) || (sel.h(paramArticleInfo)) || (paramInt == 77) || (paramInt == 78))
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
        localObject1 = oyu.k + bhkv.encodeToString(String.valueOf(l1).getBytes(), 2);
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
        localObject3 = oyu.k + bhkv.encodeToString(String.valueOf(l1).getBytes(), 2);
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
      if (!sel.g(paramArticleInfo))
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
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl != null)
          {
            l1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.a;
            localObject2 = oyu.g + bhkv.encodeToString(String.valueOf(l1).getBytes(), 2);
            continue;
            label376:
            if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl != null))
            {
              l2 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.a;
              localObject3 = oyu.g + bhkv.encodeToString(String.valueOf(l2).getBytes(), 2);
            }
            else
            {
              l2 = l1;
              localObject3 = localObject2;
              if (paramArticleInfo.mSocialFeedInfo != null)
              {
                l2 = l1;
                localObject3 = localObject2;
                if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt != null)
                {
                  l2 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt.a;
                  localObject3 = oyu.g + bhkv.encodeToString(String.valueOf(l2).getBytes(), 2);
                }
              }
            }
          }
        }
      }
    }
  }
  
  private ptl a(ptl paramptl, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = paramptl;
    int i;
    if (paramBaseArticleInfo != null)
    {
      localObject = paramptl;
      if (paramBaseArticleInfo.mGroupSubArticleList != null)
      {
        localObject = paramptl;
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
      paramptl.a("jump_url", localObject);
      if (i == 1)
      {
        localObject = b(paramptl, paramInt, paramBaseArticleInfo);
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
        ptl localptl = paramptl;
      } while (i != 2);
    }
    return c(paramptl, paramInt, paramBaseArticleInfo);
  }
  
  private void a(ViewBase paramViewBase, ArticleInfo paramArticleInfo, ppu paramppu)
  {
    if ((paramArticleInfo == null) || (paramViewBase == null) || (paramppu == null))
    {
      QLog.i("PackProteusItem", 1, "[bindItemClickListener], articleInfo or parent is null.");
      return;
    }
    paramViewBase = (qek)paramViewBase.findViewBaseByName("id_proteus_collection_view");
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
    paramViewBase.a(new pxd(this, localList, paramArticleInfo, paramppu));
  }
  
  private void a(ViewBase paramViewBase, ppu paramppu)
  {
    if ((paramViewBase == null) || (paramppu == null) || (paramppu.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_topic_avator");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    paramViewBase = paramViewBase.getNativeView();
    Context localContext = paramViewBase.getContext();
    paramViewBase.setOnClickListener(new pxc(this, paramppu.a(), localContext));
  }
  
  private void a(ppu paramppu, Context paramContext, ComponentPolymericView paramComponentPolymericView)
  {
    if (paramppu.e() == 56)
    {
      paramComponentPolymericView.setDividerWidth(agej.a(3.0F, paramContext.getResources()));
      paramComponentPolymericView.setPadding(bhgr.a(paramContext, 6.0F), 0, bhgr.a(paramContext, 6.0F), bhgr.a(paramContext, 5.0F));
    }
    for (;;)
    {
      paramComponentPolymericView.setClipToPadding(false);
      paramComponentPolymericView.setClipChildren(false);
      return;
      paramComponentPolymericView.setDividerWidth(agej.a(3.0F, paramContext.getResources()));
      if (ozs.m(paramppu.a())) {
        paramComponentPolymericView.setPadding(bhgr.a(paramContext, 6.0F), 0, bhgr.a(paramContext, 12.0F), bhgr.a(paramContext, 2.0F));
      } else {
        paramComponentPolymericView.setPadding(bhgr.a(paramContext, 6.0F), 0, bhgr.a(paramContext, 12.0F), 0);
      }
    }
  }
  
  private ptl b(ptl paramptl, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      puo.a(paramBaseArticleInfo, paramInt, localJSONArray);
      paramptl.a("datas", localJSONArray);
      return paramptl;
    }
    catch (JSONException paramBaseArticleInfo)
    {
      QLog.e("PackProteusItem", 2, paramBaseArticleInfo.getMessage());
    }
    return paramptl;
  }
  
  private ptl c(ptl paramptl, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      puo.b(paramBaseArticleInfo, paramInt, localJSONArray);
      paramptl.a("datas", localJSONArray);
      return paramptl;
    }
    catch (JSONException paramBaseArticleInfo)
    {
      QLog.e("PackProteusItem", 2, paramBaseArticleInfo.getMessage());
    }
    return paramptl;
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    ptl localptl = new ptl();
    if (paramBaseArticleInfo == null)
    {
      QLog.e("PackProteusItem", 2, "newpolymeric getDataJson info = null");
      return null;
    }
    long l1 = 0L;
    if (paramInt == 79) {
      return localptl.c(paramBaseArticleInfo).i(paramBaseArticleInfo).q(paramBaseArticleInfo).y(paramBaseArticleInfo).a("ReadInjoy_pack_topic_cell").a();
    }
    if ((ozs.o(paramBaseArticleInfo)) || (ozs.p(paramBaseArticleInfo))) {
      return localptl.q(paramBaseArticleInfo).y(paramBaseArticleInfo).a("ReadInjoy_pack_cell").a();
    }
    long l2;
    if (paramInt == 76)
    {
      l2 = l1;
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        l2 = l1;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl != null) {
          l2 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.a;
        }
      }
      paramBaseArticleInfo = a(localptl, paramInt, paramBaseArticleInfo).b(paramBaseArticleInfo).q(paramBaseArticleInfo).a(paramBaseArticleInfo, l2).g(paramBaseArticleInfo).f(paramBaseArticleInfo).h(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).y(paramBaseArticleInfo).a("ReadInjoy_pack_cell").a();
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
      paramBaseArticleInfo = a(localptl, paramInt, paramBaseArticleInfo).b(paramBaseArticleInfo).q(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).g(paramBaseArticleInfo).d(paramBaseArticleInfo).h(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).y(paramBaseArticleInfo).a("ReadInjoy_pack_cell").a();
      QLog.d("PackProteusItem", 2, "result is " + paramBaseArticleInfo);
      return paramBaseArticleInfo;
    }
    QLog.e("PackProteusItem", 2, "newpolymeric card wrong articleinfo and viewType articleinfo = " + paramBaseArticleInfo);
    return null;
  }
  
  public void a(int paramInt1, Container paramContainer, ppu paramppu, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject1 = (qcb)localViewBase.findViewBaseByName("id_middle_body_content");
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = (NativeMiddleBodyView)((qcb)localObject1).getNativeView();
      if (((NativeMiddleBodyView)localObject2).a() == null)
      {
        localObject3 = new ComponentPolymericPullAnimatorView(paramContainer.getContext(), paramppu);
        if ((localObject3 == null) || (!(((View)localObject3).getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label198;
        }
        localObject1 = (RelativeLayout.LayoutParams)((View)localObject3).getLayoutParams();
        if (localObject3 != null)
        {
          a(paramppu, paramContainer.getContext(), ((ComponentPolymericPullAnimatorView)localObject3).a());
          ((NativeMiddleBodyView)localObject2).a((View)localObject3, (RelativeLayout.LayoutParams)localObject1);
        }
      }
      a(paramppu, (NativeMiddleBodyView)localObject2);
    }
    else
    {
      localObject1 = paramppu.a();
      if (ozs.v((BaseArticleInfo)localObject1)) {
        break label213;
      }
      qdk.e(localViewBase, paramppu);
      qdk.a(localViewBase, paramppu.a());
      if (paramInt1 == 76) {
        puo.a(localViewBase, paramppu);
      }
    }
    for (;;)
    {
      paramContainer = localViewBase.findViewBaseByName("id_proteus_collection_view");
      if ((paramContainer instanceof qek)) {
        ((qek)paramContainer).a(paramppu);
      }
      a(localViewBase, (ArticleInfo)localObject1, paramppu);
      return;
      label198:
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      break;
      label213:
      a(localViewBase, paramppu);
      localObject2 = (NativeText)localViewBase.findViewBaseByName("id_topic_recommend_biu_time");
      if ((localObject2 != null) && (((ArticleInfo)localObject1).mTopicRecommendFeedsInfo != null) && (((ArticleInfo)localObject1).mTopicRecommendFeedsInfo.a != null) && (((ArticleInfo)localObject1).mTopicRecommendFeedsInfo.a.size() > 0))
      {
        localObject3 = (qzd)((ArticleInfo)localObject1).mTopicRecommendFeedsInfo.a.get(0);
        ((NativeText)localObject2).setText(String.format(paramContainer.getContext().getString(2131717309), new Object[] { bnrf.b(((qzd)localObject3).b) }));
        if (QLog.isColorLevel()) {
          QLog.d("PackProteusItem", 2, "PackProteusItem update articleInfo UI articleID = " + ((ArticleInfo)localObject1).mArticleID + ", mRecommendSeq =" + ((ArticleInfo)localObject1).mRecommendSeq + "，followType=" + ((qzd)localObject3).c);
        }
      }
    }
  }
  
  protected void a(ppu paramppu, NativeMiddleBodyView paramNativeMiddleBodyView)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (paramppu.a() == null)) {
      return;
    }
    paramNativeMiddleBodyView = (ComponentPolymericPullAnimatorView)paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.a().a(paramppu);
  }
  
  public boolean a(int paramInt, Container paramContainer, ppu paramppu, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pxb
 * JD-Core Version:    0.7.0.1
 */