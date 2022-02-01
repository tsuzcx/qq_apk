import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeCommentView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcImage;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButton;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButtonImp;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class qmo
  implements qqa
{
  public static int a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.a != null) && (paramArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaUtilArrayList != null)) {
      return paramArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public static rgj a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramInt == 0) {
      return new rgk().a();
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    rrr localrrr;
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.a != null) && (paramArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaUtilArrayList != null) && (paramArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaUtilArrayList.size() >= 1))
    {
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (paramArticleInfo.hasNext()) {
        localrrr = (rrr)paramArticleInfo.next();
      }
    }
    for (;;)
    {
      try
      {
        int i = localArrayList1.size();
        if (i == paramInt) {
          return new rgk().a(localArrayList1).b(localArrayList2).a();
        }
        i = localrrr.a;
        int j = localrrr.jdField_b_of_type_Int;
        URL localURL = new URL(localrrr.jdField_c_of_type_JavaLangString);
        if (localrrr.jdField_c_of_type_Int != 1) {
          break label270;
        }
        bool = true;
        localArrayList1.add(new teh(i, j, localURL, bool));
        localArrayList2.add(new URL(localrrr.jdField_b_of_type_JavaLangString));
      }
      catch (MalformedURLException localMalformedURLException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AnswerProteusItem", 2, "Malformed URL: " + localMalformedURLException.getMessage());
      break;
      label270:
      boolean bool = false;
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, String paramString, JSONObject paramJSONObject)
  {
    boolean bool = true;
    if (paramBaseArticleInfo.mSocialFeedInfo.j == 1)
    {
      if (bool) {
        break label61;
      }
      paramBaseArticleInfo = new JSONObject();
      paramBaseArticleInfo.put("read_article", paramString);
      paramJSONObject.put("id_read_article", paramBaseArticleInfo);
      paramJSONObject.put("id_read_article_wrapper", new JSONObject());
    }
    label61:
    while (!QLog.isColorLevel())
    {
      return;
      bool = false;
      break;
    }
    QLog.i("AnswerProteusItem", 2, "bindReadArticle isDeleted +" + bool);
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    long l = 0L;
    if (paramBaseArticleInfo.mSocialFeedInfo.a != null) {
      l = paramBaseArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_Long;
    }
    JSONObject localJSONObject = new qlk().a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l).f(paramBaseArticleInfo).g(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).k(paramBaseArticleInfo).p(paramBaseArticleInfo).r(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).x(paramBaseArticleInfo).A(paramBaseArticleInfo).B(paramBaseArticleInfo).D(paramBaseArticleInfo).C(paramBaseArticleInfo).a("ReadInjoy_original_cell").E(paramBaseArticleInfo).I(paramBaseArticleInfo).a(paramBaseArticleInfo, anvx.a(2131699773)).a();
    if (!pid.a(paramBaseArticleInfo)) {
      a(paramBaseArticleInfo, anvx.a(2131699772), localJSONObject);
    }
    return localJSONObject;
  }
  
  public void a(int paramInt1, Container paramContainer, qfw paramqfw, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject1 = (qud)localViewBase.findViewBaseByName("id_middle_body_content");
    qmp localqmp = new qmp(this, paramqfw, paramContainer);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (NativeMiddleBodyView)((qud)localObject1).getNativeView();
      if ((localObject2 != null) && (((NativeMiddleBodyView)localObject2).a() == null))
      {
        localObject3 = new RelativeLayout.LayoutParams(-2, -2);
        LinearLayout localLinearLayout = new LinearLayout(paramContainer.getContext());
        localLinearLayout.setOrientation(1);
        localLinearLayout.addView(new ComponentContentGridImage(paramContainer.getContext()));
        localLinearLayout.addView(new ComponentContentUgcImage(paramContainer.getContext()));
        ((qud)localObject1).a((RelativeLayout.LayoutParams)localObject3);
        ((NativeMiddleBodyView)localObject2).a(localLinearLayout, (RelativeLayout.LayoutParams)localObject3);
      }
      if (localObject2 != null)
      {
        paramContainer = (ViewGroup)((NativeMiddleBodyView)localObject2).a();
        localObject2 = paramqfw.a();
        paramInt1 = a((ArticleInfo)localObject2);
        localObject2 = a((ArticleInfo)localObject2, paramInt1);
        if (paramInt1 != 0) {
          break label313;
        }
        paramContainer.setVisibility(8);
        ((qud)localObject1).setOnClickListener(localqmp);
      }
    }
    qvn.a(localViewBase, paramqfw.a());
    qvn.f(localViewBase, paramqfw);
    paramContainer = (NativeButton)localViewBase.findViewBaseByName("id_super_topic_button");
    if ((paramContainer != null) && (paramContainer.getNativeView() != null) && ((paramContainer.getNativeView() instanceof NativeButtonImp))) {
      ((NativeButtonImp)paramContainer.getNativeView()).setTextColor(-1);
    }
    paramContainer = (qsu)localViewBase.findViewBaseByName("id_article_comment");
    if (paramContainer != null)
    {
      localObject1 = (NativeCommentView)paramContainer.getNativeView();
      ((NativeCommentView)localObject1).a = true;
      paramContainer.a(paramqfw);
      ((NativeCommentView)localObject1).setShouldCallClick(true);
      paramContainer.setOnClickListener(localqmp);
    }
    qmm.a(localViewBase, paramqfw);
    qvn.c(localViewBase, paramqfw);
    return;
    label313:
    paramContainer.setVisibility(0);
    Object localObject3 = (ComponentContentGridImage)paramContainer.getChildAt(0);
    paramContainer = (ComponentContentUgcImage)paramContainer.getChildAt(1);
    if (paramInt1 == 1)
    {
      ((ComponentContentGridImage)localObject3).setVisibility(8);
      paramContainer.setVisibility(0);
      paramContainer.a(paramqfw);
    }
    for (;;)
    {
      paramContainer.setPicClickListener(new qmq(this, paramqfw));
      break;
      ((ComponentContentGridImage)localObject3).setVisibility(0);
      ((ComponentContentGridImage)localObject3).setMIReadInJoyModel(paramqfw);
      paramContainer.setVisibility(8);
      ((ComponentContentGridImage)localObject3).a(localObject2);
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, qfw paramqfw, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qmo
 * JD-Core Version:    0.7.0.1
 */