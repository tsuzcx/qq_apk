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

public class orc
{
  private static int jdField_a_of_type_Int = 9;
  private static String jdField_a_of_type_JavaLangString = "0";
  private static int b = 2147483647;
  private BaseTemplateFactory jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory;
  private final Map<String, Integer> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  public static void a(VafContext paramVafContext, Container paramContainer, TemplateBean paramTemplateBean, otd paramotd, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramContainer == null) || (paramTemplateBean == null) || (paramotd == null)) {
      return;
    }
    try
    {
      oyj.a(paramContainer, null, paramTemplateBean);
      if (paramTemplateBean.getViewBean() != null)
      {
        paramVafContext = oqy.a(paramotd, paramVafContext, (otp)paramotd.getItem(paramInt1), paramInt2, paramBoolean);
        if (paramVafContext != null)
        {
          paramVafContext.put("ratio", oqy.a());
          paramTemplateBean.bindData(paramVafContext);
          oqy.a(paramContainer, paramotd, (otp)paramotd.getItem(paramInt1));
        }
      }
      blqm.a();
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
  
  public static boolean a(otp paramotp)
  {
    return (paramotp != null) && (paramotp.a != null) && (paramotp.a.isDynamicComment());
  }
  
  public int a()
  {
    if (b == 2147483647)
    {
      agej.a("DynamicCommentProteusHelper", "", new IllegalArgumentException(anzj.a(2131702470)));
      return jdField_a_of_type_Int - 8;
    }
    return b - 8;
  }
  
  public int a(otp paramotp)
  {
    if ((paramotp == null) || (paramotp.a == null)) {}
    do
    {
      return 8;
      paramotp = paramotp.a.styleData;
    } while (TextUtils.isEmpty(paramotp));
    try
    {
      paramotp = new JSONObject(paramotp).optString("style_ID");
      a(paramotp);
      int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramotp)).intValue();
      return i;
    }
    catch (JSONException paramotp)
    {
      paramotp.printStackTrace();
    }
    return -1;
  }
  
  public TemplateBean a(otp paramotp)
  {
    if ((paramotp == null) || (paramotp.a == null)) {}
    for (;;)
    {
      return null;
      try
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory != null)
        {
          paramotp = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory.getTemplateBean(new JSONObject(paramotp.a.styleData));
          return paramotp;
        }
      }
      catch (JSONException paramotp)
      {
        paramotp.printStackTrace();
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
      bnrf.a("comment_proteus_offline_bid", jdField_a_of_type_JavaLangString);
      QLog.i("DynamicCommentProteusHelper", 1, "[init], offline comment pts bid = " + jdField_a_of_type_JavaLangString + ", cdnUrl = " + (String)localObject);
      svu.a(jdField_a_of_type_JavaLangString, (String)localObject);
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
 * Qualified Name:     orc
 * JD-Core Version:    0.7.0.1
 */