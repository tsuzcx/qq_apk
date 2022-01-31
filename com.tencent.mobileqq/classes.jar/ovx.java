import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPGCShortContentBig;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONObject;

public class ovx
  extends ovq
{
  protected View a(int paramInt, Context paramContext, opw paramopw, ozt paramozt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 111: 
      return new ComponentContentGridImage(paramContext);
    case 110: 
      return new ComponentPGCShortContentBig(paramContext);
    }
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    osn localosn = new osn();
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramBaseArticleInfo.mSubscribeID);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    localosn.a(paramBaseArticleInfo, l1);
    if ((paramInt != 20) && (paramInt != 16) && (paramInt != 83) && (paramInt != 86) && ((!TextUtils.isEmpty(paramBaseArticleInfo.mSummary)) || (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) || ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.a != null) && (paramBaseArticleInfo.mSocialFeedInfo.a.a != null)))) {
      localosn.o(paramBaseArticleInfo);
    }
    if ((paramInt == 34) || (paramInt == 85)) {
      localosn.b(paramBaseArticleInfo, ajjy.a(2131642189));
    }
    localosn.g(paramBaseArticleInfo);
    if (paramInt != 109) {
      localosn.y(paramBaseArticleInfo);
    }
    localosn.a(paramBaseArticleInfo).b(paramBaseArticleInfo).q(paramBaseArticleInfo).d(paramBaseArticleInfo).i(paramBaseArticleInfo).f(paramBaseArticleInfo).j(paramBaseArticleInfo).u(paramBaseArticleInfo).v(paramBaseArticleInfo).B(paramBaseArticleInfo).a("ReadInjoy_pgc_shortcontent_cell").D(paramBaseArticleInfo).k(paramBaseArticleInfo).H(paramBaseArticleInfo).s(paramBaseArticleInfo).t(paramBaseArticleInfo);
    return localosn.a();
  }
  
  public void a(int paramInt1, Container paramContainer, opw paramopw, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    oyf localoyf = (oyf)localViewBase.findViewBaseByName("id_info_avator");
    if (localoyf != null) {
      localoyf.a(paramopw);
    }
    paz.b(localViewBase, paramopw);
    c(paramInt1, paramContainer, paramopw, paramInt2, localViewBase);
    b(paramInt1, paramContainer, paramopw, paramInt2, localViewBase);
    a(paramInt1, paramContainer, paramopw, paramInt2, localViewBase);
    paz.a(localViewBase, paramopw);
    paz.c(localViewBase, paramopw);
  }
  
  protected void a(int paramInt1, opw paramopw, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (paramopw.a() == null)) {
      return;
    }
    qoe localqoe = paramopw.a();
    switch (paramInt1)
    {
    default: 
      return;
    case 110: 
      paramNativeMiddleBodyView.a().setOnClickListener(new ovz(this, paramopw, paramContainer, localqoe));
      ((pey)paramNativeMiddleBodyView.a()).a(paramopw);
      return;
    }
    paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramopw, paramInt1));
    paramNativeMiddleBodyView.setMIReadInJoyModel(paramopw);
    paramNativeMiddleBodyView.setOnNoItemClickListener(new ovy(this, paramopw));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovx
 * JD-Core Version:    0.7.0.1
 */