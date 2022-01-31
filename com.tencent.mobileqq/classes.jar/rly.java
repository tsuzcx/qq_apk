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

class rly
  implements ViewBase.OnClickListener
{
  rly(rlx paramrlx, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    Object localObject3 = this.jdField_a_of_type_Rlx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.jdField_b_of_type_OrgJsonJSONObject;
    Object localObject2 = paramViewBase.getEventAttachedData();
    int i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
    Object localObject1 = this.jdField_a_of_type_Rlx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    FastWebArticleInfo localFastWebArticleInfo = this.jdField_a_of_type_Rlx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
    switch (i)
    {
    default: 
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = onk.a((String)localObject2, (JSONObject)localObject3);
        onk.e(this.jdField_a_of_type_Rlx.jdField_a_of_type_AndroidContentContext, (String)localObject1);
      }
      localObject2 = rnr.a(this.jdField_a_of_type_Rlx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase.getName());
      if ((this.jdField_a_of_type_Rlx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData instanceof ProteusRecommendItemData)) {
        rnr.a(paramViewBase.getName(), (ProteusRecommendItemData)this.jdField_a_of_type_Rlx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData, (JSONObject)localObject2);
      }
      break;
    }
    for (;;)
    {
      QLog.d("WebProteusViewCreator", 1, "onClick,schema=" + (String)localObject1 + " viewID=" + paramViewBase.getName());
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
                        do
                        {
                          return;
                          osm.a().f();
                          return;
                        } while ((!"id_interaction_ui_view".equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getName())) || (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase instanceof NativeRelativeLayout)));
                        paramViewBase = (ViewBase)((NativeRelativeLayout)paramViewBase).getSubViews().get(0);
                      } while (!(paramViewBase instanceof pkd));
                      ((pkd)paramViewBase).onClick();
                      return;
                    } while (!(this.jdField_a_of_type_Rlx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData instanceof AuthorData));
                    ((AuthorData)this.jdField_a_of_type_Rlx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData).b();
                  } while (rlv.a(this.jdField_a_of_type_Rlx.jdField_a_of_type_Rlw.jdField_a_of_type_Rlv) == null);
                  rlv.a(this.jdField_a_of_type_Rlx.jdField_a_of_type_Rlw.jdField_a_of_type_Rlv).notifyDataSetChanged();
                  return;
                } while (!(this.jdField_a_of_type_Rlx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData instanceof AuthorData));
                localObject1 = (AuthorData)this.jdField_a_of_type_Rlx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData;
              } while ((TextUtils.isEmpty(((AuthorData)localObject1).jdField_a_of_type_JavaLangString)) || (((AuthorData)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null));
              onk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((AuthorData)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
              paramViewBase = ((AuthorData)this.jdField_a_of_type_Rlx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData).c;
              paramViewBase = omm.k + bbca.encodeToString(String.valueOf(paramViewBase).getBytes(), 2);
              onk.a(this.jdField_a_of_type_Rlx.jdField_a_of_type_Rlw.jdField_a_of_type_AndroidViewView.getContext(), paramViewBase);
              localObject2 = this.jdField_a_of_type_Rlx.jdField_a_of_type_Rlw.jdField_a_of_type_AndroidViewView.getContext();
              localObject3 = ((AuthorData)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
              if (((AuthorData)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
              for (paramViewBase = "2";; paramViewBase = "1")
              {
                paramViewBase = onk.a((Context)localObject2, (ArticleInfo)localObject3, 0, paramViewBase);
                rnr.a(((AuthorData)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X800898A", paramViewBase.toString());
                return;
              }
              rmn.a((ArticleInfo)localObject1, localFastWebArticleInfo);
              return;
              rmn.a(this.jdField_a_of_type_Rlx.jdField_a_of_type_AndroidContentContext, (ArticleInfo)localObject1, localFastWebArticleInfo);
              return;
            } while ((rlv.a(this.jdField_a_of_type_Rlx.jdField_a_of_type_Rlw.jdField_a_of_type_Rlv) == null) || (!(rlv.a(this.jdField_a_of_type_Rlx.jdField_a_of_type_Rlw.jdField_a_of_type_Rlv) instanceof rjw)) || (!(this.jdField_a_of_type_Rlx.jdField_a_of_type_AndroidContentContext instanceof FastWebActivity)));
            if (rlw.a(this.jdField_a_of_type_Rlx.jdField_a_of_type_Rlw) == null) {
              rlw.a(this.jdField_a_of_type_Rlx.jdField_a_of_type_Rlw, new ArrayList());
            }
            rmo.a(this.jdField_a_of_type_Rlx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Rlx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, (FastWebActivity)this.jdField_a_of_type_Rlx.jdField_a_of_type_AndroidContentContext, (JSONObject)localObject3, ((rjw)rlv.a(this.jdField_a_of_type_Rlx.jdField_a_of_type_Rlw.jdField_a_of_type_Rlv)).a(), rlw.a(this.jdField_a_of_type_Rlx.jdField_a_of_type_Rlw));
            return;
            rmn.b(this.jdField_a_of_type_Rlx.jdField_a_of_type_AndroidContentContext, (ArticleInfo)localObject1, localFastWebArticleInfo);
            return;
          } while ((localObject3 == null) || (!(this.jdField_a_of_type_Rlx.jdField_a_of_type_AndroidContentContext instanceof FastWebActivity)));
          rne.a((JSONObject)localObject3, (FastWebActivity)this.jdField_a_of_type_Rlx.jdField_a_of_type_AndroidContentContext, (ArticleInfo)localObject1, localFastWebArticleInfo);
          return;
          rms.b((ArticleInfo)localObject1, localFastWebArticleInfo, this.jdField_a_of_type_Rlx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
          rms.a((ArticleInfo)localObject1, localFastWebArticleInfo, this.jdField_a_of_type_Rlx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
        } while (TextUtils.isEmpty((CharSequence)localObject2));
        onk.e(this.jdField_a_of_type_Rlx.jdField_a_of_type_AndroidContentContext, (String)localObject2);
        return;
        rms.a((ArticleInfo)localObject1, localFastWebArticleInfo, this.jdField_a_of_type_Rlx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
      } while (TextUtils.isEmpty((CharSequence)localObject2));
      onk.e(this.jdField_a_of_type_Rlx.jdField_a_of_type_AndroidContentContext, (String)localObject2);
      return;
      rnr.a(paramViewBase.getName(), (JSONObject)localObject3, (JSONObject)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rly
 * JD-Core Version:    0.7.0.1
 */