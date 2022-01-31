import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusRecommendItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.nativelayout.NativeRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

class qzg
  implements ViewBase.OnClickListener
{
  qzg(qzf paramqzf, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    Object localObject3 = this.jdField_a_of_type_Qzf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.jdField_b_of_type_OrgJsonJSONObject;
    Object localObject2 = paramViewBase.getEventAttachedData();
    int i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
    Object localObject1 = this.jdField_a_of_type_Qzf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    FastWebArticleInfo localFastWebArticleInfo = this.jdField_a_of_type_Qzf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
    switch (i)
    {
    default: 
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = obz.a((String)localObject2, (JSONObject)localObject3);
        obz.e(this.jdField_a_of_type_Qzf.jdField_a_of_type_AndroidContentContext, (String)localObject1);
      }
      localObject2 = raz.a(this.jdField_a_of_type_Qzf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase.getName());
      if ((this.jdField_a_of_type_Qzf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData instanceof ProteusRecommendItemData)) {
        raz.a(paramViewBase.getName(), (ProteusRecommendItemData)this.jdField_a_of_type_Qzf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData, (JSONObject)localObject2);
      }
      break;
    }
    for (;;)
    {
      QLog.d("WebProteusViewCreator", 1, "onClick,schema=" + (String)localObject1 + " viewID=" + paramViewBase.getName());
      label580:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                        ohb.a().f();
                        return;
                      } while ((!"id_interaction_ui_view".equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getName())) || (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase instanceof NativeRelativeLayout)));
                      paramViewBase = (ViewBase)((NativeRelativeLayout)paramViewBase).getSubViews().get(0);
                    } while (!(paramViewBase instanceof oyl));
                    ((oyl)paramViewBase).onClick();
                    return;
                  } while (!(this.jdField_a_of_type_Qzf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData instanceof AuthorData));
                  ((AuthorData)this.jdField_a_of_type_Qzf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData).b();
                } while (qzd.a(this.jdField_a_of_type_Qzf.jdField_a_of_type_Qze.jdField_a_of_type_Qzd) == null);
                qzd.a(this.jdField_a_of_type_Qzf.jdField_a_of_type_Qze.jdField_a_of_type_Qzd).notifyDataSetChanged();
                return;
                if (!(this.jdField_a_of_type_Qzf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData instanceof AuthorData)) {
                  break;
                }
                localObject2 = (AuthorData)this.jdField_a_of_type_Qzf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData;
              } while (TextUtils.isEmpty(((AuthorData)localObject2).jdField_a_of_type_JavaLangString));
              ArticleInfo localArticleInfo;
              if (((AuthorData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
              {
                obz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((AuthorData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
                paramViewBase = ((AuthorData)this.jdField_a_of_type_Qzf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData).c;
                paramViewBase = obb.k + baaw.encodeToString(String.valueOf(paramViewBase).getBytes(), 2);
                obz.a(this.jdField_a_of_type_Qzf.jdField_a_of_type_Qze.jdField_a_of_type_AndroidViewView.getContext(), paramViewBase);
                localObject3 = this.jdField_a_of_type_Qzf.jdField_a_of_type_Qze.jdField_a_of_type_AndroidViewView.getContext();
                localArticleInfo = ((AuthorData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
                if (!((AuthorData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {
                  break label580;
                }
              }
              for (paramViewBase = "2";; paramViewBase = "1")
              {
                paramViewBase = obz.a((Context)localObject3, localArticleInfo, 0, paramViewBase);
                raz.a(((AuthorData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X800898A", paramViewBase.toString());
                qzv.a((ArticleInfo)localObject1, localFastWebArticleInfo);
                return;
              }
              qzv.a(this.jdField_a_of_type_Qzf.jdField_a_of_type_AndroidContentContext, (ArticleInfo)localObject1, localFastWebArticleInfo);
              return;
            } while ((qzd.a(this.jdField_a_of_type_Qzf.jdField_a_of_type_Qze.jdField_a_of_type_Qzd) == null) || (!(qzd.a(this.jdField_a_of_type_Qzf.jdField_a_of_type_Qze.jdField_a_of_type_Qzd) instanceof qxe)) || (!(this.jdField_a_of_type_Qzf.jdField_a_of_type_AndroidContentContext instanceof FastWebActivity)));
            if (qze.a(this.jdField_a_of_type_Qzf.jdField_a_of_type_Qze) == null) {
              qze.a(this.jdField_a_of_type_Qzf.jdField_a_of_type_Qze, new ArrayList());
            }
            qzw.a(this.jdField_a_of_type_Qzf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Qzf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, (FastWebActivity)this.jdField_a_of_type_Qzf.jdField_a_of_type_AndroidContentContext, (JSONObject)localObject3, ((qxe)qzd.a(this.jdField_a_of_type_Qzf.jdField_a_of_type_Qze.jdField_a_of_type_Qzd)).a(), qze.a(this.jdField_a_of_type_Qzf.jdField_a_of_type_Qze));
            return;
            qzv.b(this.jdField_a_of_type_Qzf.jdField_a_of_type_AndroidContentContext, (ArticleInfo)localObject1, localFastWebArticleInfo);
            return;
          } while ((localObject3 == null) || (!(this.jdField_a_of_type_Qzf.jdField_a_of_type_AndroidContentContext instanceof FastWebActivity)));
          ram.a((JSONObject)localObject3, (FastWebActivity)this.jdField_a_of_type_Qzf.jdField_a_of_type_AndroidContentContext, (ArticleInfo)localObject1, localFastWebArticleInfo);
          return;
          raa.b((ArticleInfo)localObject1, localFastWebArticleInfo, this.jdField_a_of_type_Qzf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
          raa.a((ArticleInfo)localObject1, localFastWebArticleInfo, this.jdField_a_of_type_Qzf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
        } while (TextUtils.isEmpty((CharSequence)localObject2));
        obz.e(this.jdField_a_of_type_Qzf.jdField_a_of_type_AndroidContentContext, (String)localObject2);
        return;
        raa.a((ArticleInfo)localObject1, localFastWebArticleInfo, this.jdField_a_of_type_Qzf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
      } while (TextUtils.isEmpty((CharSequence)localObject2));
      obz.e(this.jdField_a_of_type_Qzf.jdField_a_of_type_AndroidContentContext, (String)localObject2);
      return;
      raz.a(paramViewBase.getName(), (JSONObject)localObject3, (JSONObject)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qzg
 * JD-Core Version:    0.7.0.1
 */