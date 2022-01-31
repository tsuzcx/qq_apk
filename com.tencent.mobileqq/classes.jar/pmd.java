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

public class pmd
  implements poa
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramInt == 103) {
      return pjz.a(paramBaseArticleInfo);
    }
    if (paramInt == 102) {
      return pjx.a(paramBaseArticleInfo);
    }
    return pjy.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, pgd parampgd, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject = (pqg)localViewBase.findViewBaseByName("id_info_avator");
    if (localObject != null)
    {
      ((pqg)localObject).a(parampgd, false);
      parampgd = parampgd.a();
      localObject = (NativeAvatarView)((pqg)localObject).getNativeView();
      if ((ors.b(parampgd)) && (parampgd.mGalleryFeedsInfo.uint32_is_account_derelict.has()) && (parampgd.mGalleryFeedsInfo.uint32_is_account_derelict.get() == 1)) {
        ((NativeAvatarView)localObject).setAvatarDrawable(paramContainer.getContext().getResources().getDrawable(2130845836));
      }
    }
    paramContainer = (NativeText)localViewBase.findViewBaseByName("id_nickname");
    parampgd = localViewBase.findViewBaseByName("id_view_nickname");
    if ((paramContainer != null) && (parampgd != null))
    {
      paramContainer = (NativeTextImp)paramContainer.getNativeView();
      parampgd = parampgd.getNativeView();
      if ((paramContainer != null) && (parampgd != null)) {
        parampgd.post(new GalleryProteusItem.1(this, parampgd, paramContainer));
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pgd parampgd, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pmd
 * JD-Core Version:    0.7.0.1
 */