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

public class pwh
  implements pye
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramInt == 103) {
      return ptv.a(paramBaseArticleInfo);
    }
    if (paramInt == 102) {
      return ptt.a(paramBaseArticleInfo);
    }
    return ptu.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, ppu paramppu, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject = (qav)localViewBase.findViewBaseByName("id_info_avator");
    if (localObject != null)
    {
      ((qav)localObject).a(paramppu, false);
      paramppu = paramppu.a();
      localObject = (NativeAvatarView)((qav)localObject).getNativeView();
      if ((ozs.b(paramppu)) && (paramppu.mGalleryFeedsInfo.uint32_is_account_derelict.has()) && (paramppu.mGalleryFeedsInfo.uint32_is_account_derelict.get() == 1)) {
        ((NativeAvatarView)localObject).setAvatarDrawable(paramContainer.getContext().getResources().getDrawable(2130846365));
      }
    }
    paramContainer = (NativeText)localViewBase.findViewBaseByName("id_nickname");
    paramppu = localViewBase.findViewBaseByName("id_view_nickname");
    if ((paramContainer != null) && (paramppu != null))
    {
      paramContainer = (NativeTextImp)paramContainer.getNativeView();
      paramppu = paramppu.getNativeView();
      if ((paramContainer != null) && (paramppu != null)) {
        paramppu.post(new GalleryProteusItem.1(this, paramppu, paramContainer));
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, ppu paramppu, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pwh
 * JD-Core Version:    0.7.0.1
 */