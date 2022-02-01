import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class pky
  extends pkl<BaseArticleInfo>
{
  private qdv a;
  
  public int a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return b;
    }
    TemplateBean localTemplateBean = a(paramBaseArticleInfo);
    Integer localInteger = null;
    if (localTemplateBean != null) {
      localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(localTemplateBean.getStyleName());
    }
    if (localInteger == null)
    {
      QLog.d("DynamicItemViewHelperCompat", 2, "getType: templateBean : " + localTemplateBean + " data: " + paramBaseArticleInfo.proteusItemsData);
      return b;
    }
    if ((localInteger.intValue() < b) || (localInteger.intValue() >= this.d))
    {
      afur.a("DynamicItemViewHelperCompat", "", new IllegalArgumentException(anni.a(2131702362)));
      return b;
    }
    return localInteger.intValue();
  }
  
  protected TemplateBean a(BaseArticleInfo paramBaseArticleInfo)
  {
    TemplateBean localTemplateBean2 = null;
    int i = b;
    if (QLog.isColorLevel()) {
      QLog.d("DynamicItemViewHelperCompat", 2, "getTemplateBean : " + paramBaseArticleInfo);
    }
    TemplateBean localTemplateBean1 = localTemplateBean2;
    try
    {
      if (this.jdField_a_of_type_Qdv == null) {
        return null;
      }
      localTemplateBean1 = localTemplateBean2;
      JSONObject localJSONObject = this.jdField_a_of_type_Qdv.a(i, paramBaseArticleInfo);
      localTemplateBean1 = localTemplateBean2;
      localTemplateBean2 = this.jdField_a_of_type_Qdv.a(i, localJSONObject);
      localTemplateBean1 = localTemplateBean2;
      paramBaseArticleInfo.mProteusTemplateBean = localTemplateBean2;
      paramBaseArticleInfo = localTemplateBean2;
      if (localTemplateBean2 != null)
      {
        localTemplateBean1 = localTemplateBean2;
        paramBaseArticleInfo = localTemplateBean2;
        if (localTemplateBean2.getViewBean() != null)
        {
          paramBaseArticleInfo = localTemplateBean2;
          if (localJSONObject != null)
          {
            localTemplateBean1 = localTemplateBean2;
            paramBaseArticleInfo = localTemplateBean2;
            if (localJSONObject.has("report_feeds_type"))
            {
              localTemplateBean1 = localTemplateBean2;
              localTemplateBean2.getViewBean().putDynamicValue("report_feeds_type", localJSONObject.getString("report_feeds_type"));
              return localTemplateBean2;
            }
          }
        }
      }
    }
    catch (JSONException paramBaseArticleInfo)
    {
      QLog.d("DynamicItemViewHelperCompat", 1, paramBaseArticleInfo, new Object[] { "getView" });
      paramBaseArticleInfo = localTemplateBean1;
    }
    return paramBaseArticleInfo;
  }
  
  public void a(ProteusItemView paramProteusItemView, int paramInt1, BaseArticleInfo paramBaseArticleInfo, VafContext paramVafContext, int paramInt2)
  {
    bkpj.a("bindData");
    if ((paramProteusItemView == null) || (paramProteusItemView.a() == null))
    {
      bkpj.a();
      if (QLog.isColorLevel()) {
        QLog.d("DynamicItemViewHelperCompat", 2, new Object[] { "bindData, adapterViewType = ", Integer.valueOf(paramInt1), ", articleInfo = ", paramBaseArticleInfo });
      }
      if (paramProteusItemView != null) {
        paramProteusItemView.setVisibility(8);
      }
      return;
    }
    if (paramInt1 == b)
    {
      paramProteusItemView.setVisibility(8);
      return;
    }
    QLog.d("DynamicItemViewHelperCompat", 1, new Object[] { "bindData, adapterViewType = ", Integer.valueOf(paramInt1), ", articleInfo = ", paramBaseArticleInfo });
    TemplateBean localTemplateBean1 = paramProteusItemView.a();
    TemplateBean localTemplateBean2 = a(paramBaseArticleInfo);
    Object localObject = localTemplateBean1;
    if (localTemplateBean1 != null)
    {
      localObject = localTemplateBean1;
      if (localTemplateBean2 != null)
      {
        localObject = localTemplateBean1;
        if (!localTemplateBean2.equals(localTemplateBean1))
        {
          localObject = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean2);
          if (localObject != null)
          {
            ((Container)localObject).setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130841683));
            paramProteusItemView.d();
            paramProteusItemView.a((Container)localObject);
          }
          paramBaseArticleInfo.mProteusTemplateBean = localTemplateBean2;
          localObject = null;
        }
      }
    }
    paramBaseArticleInfo = paramProteusItemView.a();
    paramProteusItemView.setTemplateBean(localTemplateBean2);
    if (localTemplateBean2 != null) {
      pfr.a(paramBaseArticleInfo, (TemplateBean)localObject, localTemplateBean2);
    }
    pfr.a(paramBaseArticleInfo, paramVafContext, localTemplateBean2);
    bkpj.a();
  }
  
  public void a(VafContext paramVafContext, int paramInt)
  {
    super.a(paramVafContext, paramInt);
    this.jdField_a_of_type_Qdv = new qdv(paramVafContext);
  }
  
  public boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    while (paramBaseArticleInfo.mFeedType != 29) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pky
 * JD-Core Version:    0.7.0.1
 */