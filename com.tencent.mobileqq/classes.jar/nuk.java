import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
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

public class nuk
{
  private static String jdField_a_of_type_JavaLangString = "0";
  private static int c = 2147483647;
  private final int jdField_a_of_type_Int = 9;
  private BaseTemplateFactory jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory;
  private final Map<String, Integer> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private int b = 9;
  
  public static void a(VafContext paramVafContext, Container paramContainer, TemplateBean paramTemplateBean, nwk paramnwk, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramContainer == null) || (paramTemplateBean == null) || (paramnwk == null)) {
      return;
    }
    try
    {
      oag.a(paramContainer, null, paramTemplateBean);
      if (paramTemplateBean.getViewBean() != null)
      {
        paramVafContext = ntt.a(paramnwk, paramVafContext, (nwx)paramnwk.getItem(paramInt1), paramInt2, paramBoolean);
        if (paramVafContext != null)
        {
          paramTemplateBean.getViewBean().bindData(paramVafContext, paramTemplateBean.getViewDataBinding());
          ntt.a(paramContainer, paramnwk, (nwx)paramnwk.getItem(paramInt1));
        }
      }
      beoj.a();
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
  
  public static boolean a(nwx paramnwx)
  {
    return (paramnwx != null) && (paramnwx.a != null) && (paramnwx.a.isDynamicComment());
  }
  
  public int a()
  {
    if (c == 2147483647)
    {
      aciy.a("DynamicCommentProteusHelper", "", new IllegalArgumentException(ajjy.a(2131637786)));
      return this.b - 8;
    }
    return c - 8;
  }
  
  public int a(nwx paramnwx)
  {
    if ((paramnwx == null) || (paramnwx.a == null)) {}
    do
    {
      return 8;
      paramnwx = paramnwx.a.styleData;
    } while (TextUtils.isEmpty(paramnwx));
    try
    {
      paramnwx = new JSONObject(paramnwx).optString("style_ID");
      a(paramnwx);
      int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramnwx)).intValue();
      return i;
    }
    catch (JSONException paramnwx)
    {
      paramnwx.printStackTrace();
    }
    return -1;
  }
  
  public TemplateBean a(nwx paramnwx)
  {
    if ((paramnwx == null) || (paramnwx.a == null)) {}
    for (;;)
    {
      return null;
      try
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory != null)
        {
          paramnwx = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory.getTemplateBean(new JSONObject(paramnwx.a.styleData));
          return paramnwx;
        }
      }
      catch (JSONException paramnwx)
      {
        paramnwx.printStackTrace();
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
      bgmq.a("comment_proteus_offline_bid", jdField_a_of_type_JavaLangString);
      QLog.d("DynamicCommentProteusHelper", 1, "offline comment pts bid " + jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory = paramVafContext.getTemplateFactory();
    int j = paramVafContext.getTemplateFactory().size();
    if ((this.b < j + 9) && (j > 0) && (this.b < c))
    {
      paramVafContext = paramVafContext.getTemplateFactory().getNameTemplateMap().keySet();
      int i = this.b;
      paramVafContext = paramVafContext.iterator();
      label131:
      if (paramVafContext.hasNext())
      {
        localObject = (String)paramVafContext.next();
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject)) {
          break label295;
        }
        this.jdField_a_of_type_JavaUtilMap.put(localObject, Integer.valueOf(i));
        i += 1;
      }
    }
    label295:
    for (;;)
    {
      break label131;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nuk
 * JD-Core Version:    0.7.0.1
 */