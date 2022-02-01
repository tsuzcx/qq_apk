import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class osb
{
  private static int jdField_a_of_type_Int = 9;
  private static String jdField_a_of_type_JavaLangString = "0";
  private static int b = 2147483647;
  private BaseTemplateFactory jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory;
  private final Map<String, Integer> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  public static void a(VafContext paramVafContext, Container paramContainer, TemplateBean paramTemplateBean, ouc paramouc, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramContainer == null) || (paramTemplateBean == null) || (paramouc == null)) {
      return;
    }
    try
    {
      ozp.a(paramContainer, null, paramTemplateBean);
      if (paramTemplateBean.getViewBean() != null)
      {
        paramVafContext = orx.a(paramouc, paramVafContext, (ouo)paramouc.getItem(paramInt1), paramInt2, paramBoolean);
        if (paramVafContext != null)
        {
          paramVafContext.put("ratio", orx.a());
          paramTemplateBean.bindData(paramVafContext);
          orx.a(paramContainer, paramouc, (ouo)paramouc.getItem(paramInt1));
        }
      }
      bjun.a();
      return;
    }
    catch (JSONException paramVafContext)
    {
      QLog.d("DynamicCommentProteusHelper", 2, "bindData " + paramVafContext.getMessage());
    }
  }
  
  private void a(String paramString)
  {
    if ((!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) && (jdField_a_of_type_Int < b - 1))
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(jdField_a_of_type_Int));
      jdField_a_of_type_Int += 1;
      QLog.d("DynamicCommentProteusHelper", 2, "addViewType : " + paramString + " TYPE_DYNAMIC_END: " + jdField_a_of_type_Int + "  TYPE_DYNAMIC_MAX_END : " + b);
    }
  }
  
  public static boolean a(ouo paramouo)
  {
    return (paramouo != null) && (paramouo.a != null) && (paramouo.a.isDynamicComment());
  }
  
  public int a()
  {
    if (b == 2147483647)
    {
      AIOUtils.catchedExceptionInReleaseV2("DynamicCommentProteusHelper", "", new IllegalArgumentException(amtj.a(2131702705)));
      return jdField_a_of_type_Int - 8;
    }
    return b - 8;
  }
  
  public int a(ouo paramouo)
  {
    if ((paramouo == null) || (paramouo.a == null)) {}
    do
    {
      return 8;
      paramouo = paramouo.a.styleData;
    } while (TextUtils.isEmpty(paramouo));
    try
    {
      paramouo = new JSONObject(paramouo).optString("style_ID");
      a(paramouo);
      int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramouo)).intValue();
      return i;
    }
    catch (JSONException paramouo)
    {
      paramouo.printStackTrace();
    }
    return -1;
  }
  
  public TemplateBean a(ouo paramouo)
  {
    if ((paramouo == null) || (paramouo.a == null)) {}
    for (;;)
    {
      return null;
      try
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory != null)
        {
          paramouo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory.getTemplateBean(new JSONObject(paramouo.a.styleData));
          return paramouo;
        }
      }
      catch (JSONException paramouo)
      {
        paramouo.printStackTrace();
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
      bkwm.a("comment_proteus_offline_bid", jdField_a_of_type_JavaLangString);
      QLog.i("DynamicCommentProteusHelper", 1, "[init], offline comment pts bid = " + jdField_a_of_type_JavaLangString + ", cdnUrl = " + (String)localObject);
      szu.a(jdField_a_of_type_JavaLangString, (String)localObject);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory = paramVafContext.getTemplateFactory();
    int j = paramVafContext.getTemplateFactory().size();
    if ((jdField_a_of_type_Int < j + 9) && (j > 0) && (jdField_a_of_type_Int < b))
    {
      paramVafContext = paramVafContext.getTemplateFactory().getNameTemplateMap().keySet();
      int i = jdField_a_of_type_Int;
      paramVafContext = paramVafContext.iterator();
      label157:
      if (paramVafContext.hasNext())
      {
        localObject = (String)paramVafContext.next();
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject)) {
          break label317;
        }
        this.jdField_a_of_type_JavaUtilMap.put(localObject, Integer.valueOf(i));
        i += 1;
      }
    }
    label317:
    for (;;)
    {
      break label157;
      jdField_a_of_type_Int = j + 9;
      if (b == 2147483647) {
        b = jdField_a_of_type_Int + 30;
      }
      if (jdField_a_of_type_Int > b) {
        jdField_a_of_type_Int = b;
      }
      QLog.d("DynamicCommentProteusHelper", 1, "init: commentTemplateCount : " + j + " TYPE_DYNAMIC_END : " + jdField_a_of_type_Int + " max : " + b);
      if (b != 2147483647) {
        break;
      }
      b = 109;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     osb
 * JD-Core Version:    0.7.0.1
 */