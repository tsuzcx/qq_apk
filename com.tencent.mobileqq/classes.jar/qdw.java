import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.GalleryProteusItem.1;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAvatarView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import com.tencent.mobileqq.pb.PBUInt32Field;
import org.json.JSONObject;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class qdw
  implements qft
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramInt == 103) {
      return qbk.a(paramBaseArticleInfo);
    }
    if (paramInt == 102) {
      return qbi.a(paramBaseArticleInfo);
    }
    return qbj.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, pxk parampxk, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject = (qij)localViewBase.findViewBaseByName("id_info_avator");
    if (localObject != null)
    {
      ((qij)localObject).a(parampxk, false);
      parampxk = parampxk.a();
      localObject = (NativeAvatarView)((qij)localObject).getNativeView();
      if ((pha.b(parampxk)) && (parampxk.mGalleryFeedsInfo.uint32_is_account_derelict.has()) && (parampxk.mGalleryFeedsInfo.uint32_is_account_derelict.get() == 1)) {
        ((NativeAvatarView)localObject).setAvatarDrawable(paramContainer.getContext().getResources().getDrawable(2130846348));
      }
    }
    paramContainer = (NativeText)localViewBase.findViewBaseByName("id_nickname");
    parampxk = localViewBase.findViewBaseByName("id_view_nickname");
    if ((paramContainer != null) && (parampxk != null))
    {
      paramContainer = (NativeTextImp)paramContainer.getNativeView();
      parampxk = parampxk.getNativeView();
      if ((paramContainer != null) && (parampxk != null)) {
        parampxk.post(new GalleryProteusItem.1(this, parampxk, paramContainer));
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pxk parampxk, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qdw
 * JD-Core Version:    0.7.0.1
 */