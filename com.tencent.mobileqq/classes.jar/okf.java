import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class okf
{
  private static String jdField_a_of_type_JavaLangString = "0";
  private static int c = 2147483647;
  private final int jdField_a_of_type_Int = 9;
  private BaseTemplateFactory jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory;
  private final Map<String, Integer> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private int b = 9;
  
  public static void a(VafContext paramVafContext, Container paramContainer, TemplateBean paramTemplateBean, omg paramomg, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramContainer == null) || (paramTemplateBean == null) || (paramomg == null)) {
      return;
    }
    try
    {
      opy.a(paramContainer, null, paramTemplateBean);
      if (paramTemplateBean.getViewBean() != null)
      {
        paramVafContext = ojm.a(paramomg, paramVafContext, (omt)paramomg.getItem(paramInt1), paramInt2, paramBoolean);
        if (paramVafContext != null)
        {
          paramTemplateBean.bindData(paramVafContext);
          ojm.a(paramContainer, paramomg, (omt)paramomg.getItem(paramInt1));
        }
      }
      bhxr.a();
      return;
    }
    catch (JSONException paramVafContext)
    {
      QLog.d("DynamicCommentProteusHelper", 2, "bindData " + paramVafContext.getMessage());
    }
  }
  
  private void a(String paramString)
  {
    if ((!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) && (this.b < c - 1))
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(this.b));
      this.b += 1;
      QLog.d("DynamicCommentProteusHelper", 2, "addViewType : " + paramString + " TYPE_DYNAMIC_END: " + this.b + "  TYPE_DYNAMIC_MAX_END : " + c);
    }
  }
  
  public static boolean a(omt paramomt)
  {
    return (paramomt != null) && (paramomt.a != null) && (paramomt.a.isDynamicComment());
  }
  
  public int a()
  {
    if (c == 2147483647)
    {
      aekt.a("DynamicCommentProteusHelper", "", new IllegalArgumentException(alpo.a(2131703954)));
      return this.b - 8;
    }
    return c - 8;
  }
  
  public int a(omt paramomt)
  {
    if ((paramomt == null) || (paramomt.a == null)) {}
    do
    {
      return 8;
      paramomt = paramomt.a.styleData;
    } while (TextUtils.isEmpty(paramomt));
    try
    {
      paramomt = new JSONObject(paramomt).optString("style_ID");
      a(paramomt);
      int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramomt)).intValue();
      return i;
    }
    catch (JSONException paramomt)
    {
      paramomt.printStackTrace();
    }
    return -1;
  }
  
  public TemplateBean a(omt paramomt)
  {
    if ((paramomt == null) || (paramomt.a == null)) {}
    for (;;)
    {
      return null;
      try
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory != null)
        {
          paramomt = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory.getTemplateBean(new JSONObject(paramomt.a.styleData));
          return paramomt;
        }
      }
      catch (JSONException paramomt)
      {
        paramomt.printStackTrace();
      }
    }
    return null;
  }
  
  public void a(VafContext paramVafContext)
  {
    if (paramVafContext == null) {
      return;
    }
    Object localObject = Aladdin.getConfig(228);
    if (localObject != null)
    {
      jdField_a_of_type_JavaLangString = ((AladdinConfig)localObject).getString("comment_feeds", "0");
      localObject = ((AladdinConfig)localObject).getString("comment_feeds_cdn_url", "");
      bjxj.a("comment_proteus_offline_bid", jdField_a_of_type_JavaLangString);
      QLog.i("DynamicCommentProteusHelper", 1, "[init], offline comment pts bid = " + jdField_a_of_type_JavaLangString + ", cdnUrl = " + (String)localObject);
      sgl.a(jdField_a_of_type_JavaLangString, (String)localObject);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory = paramVafContext.getTemplateFactory();
    int j = paramVafContext.getTemplateFactory().size();
    if ((this.b < j + 9) && (j > 0) && (this.b < c))
    {
      paramVafContext = paramVafContext.getTemplateFactory().getNameTemplateMap().keySet();
      int i = this.b;
      paramVafContext = paramVafContext.iterator();
      label160:
      if (paramVafContext.hasNext())
      {
        localObject = (String)paramVafContext.next();
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject)) {
          break label325;
        }
        this.jdField_a_of_type_JavaUtilMap.put(localObject, Integer.valueOf(i));
        i += 1;
      }
    }
    label325:
    for (;;)
    {
      break label160;
      this.b = (j + 9);
      if (c == 2147483647) {
        c = this.b + 30;
      }
      if (this.b > c) {
        this.b = c;
      }
      QLog.d("DynamicCommentProteusHelper", 1, "init: commentTemplateCount : " + j + " TYPE_DYNAMIC_END : " + this.b + " max : " + c);
      if (c != 2147483647) {
        break;
      }
      c = 109;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okf
 * JD-Core Version:    0.7.0.1
 */