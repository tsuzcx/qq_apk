import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONObject;

public class phy
  implements php
{
  public static String a;
  public static String[] a;
  public static String[] b = { "search_word_show_1", "search_word_show_2", "search_word_show_3", "search_word_show_4" };
  
  static
  {
    jdField_a_of_type_JavaLangString = "search_word_title";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "search_word_click_1", "search_word_click_2", "search_word_click_3", "search_word_click_4" };
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return pej.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, pau parampau, int paramInt2)
  {
    ArticleInfo localArticleInfo = parampau.a();
    if ((localArticleInfo != null) && (localArticleInfo.isAccountShown)) {
      pjm.a(paramContainer, parampau);
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pau parampau, ViewBase paramViewBase)
  {
    if ((paramViewBase != null) && (!TextUtils.isEmpty(paramViewBase.getClickEvnet())) && (paramViewBase.getClickEvnet().startsWith("search_word_click_")))
    {
      paramViewBase.setOnClickListener(new phz(this, parampau, paramContainer));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     phy
 * JD-Core Version:    0.7.0.1
 */