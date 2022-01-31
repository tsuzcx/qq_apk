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

public class pfx
  implements phs
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramInt == 103) {
      return pea.a(paramBaseArticleInfo);
    }
    if (paramInt == 102) {
      return pdy.a(paramBaseArticleInfo);
    }
    return pdz.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, pax parampax, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject = (pjx)localViewBase.findViewBaseByName("id_info_avator");
    if (localObject != null)
    {
      ((pjx)localObject).a(parampax, false);
      parampax = parampax.a();
      localObject = (NativeAvatarView)((pjx)localObject).getNativeView();
      if ((onk.b(parampax)) && (parampax.mGalleryFeedsInfo.uint32_is_account_derelict.has()) && (parampax.mGalleryFeedsInfo.uint32_is_account_derelict.get() == 1)) {
        ((NativeAvatarView)localObject).setAvatarDrawable(paramContainer.getContext().getResources().getDrawable(2130845451));
      }
    }
    paramContainer = (NativeText)localViewBase.findViewBaseByName("id_nickname");
    parampax = localViewBase.findViewBaseByName("id_view_nickname");
    if ((paramContainer != null) && (parampax != null))
    {
      paramContainer = (NativeTextImp)paramContainer.getNativeView();
      parampax = parampax.getNativeView();
      if ((paramContainer != null) && (parampax != null)) {
        parampax.post(new GalleryProteusItem.1(this, parampax, paramContainer));
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pax parampax, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pfx
 * JD-Core Version:    0.7.0.1
 */