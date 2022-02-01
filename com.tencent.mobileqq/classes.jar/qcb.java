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

public class qcb
  implements qdy
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramInt == 103) {
      return pzp.a(paramBaseArticleInfo);
    }
    if (paramInt == 102) {
      return pzn.a(paramBaseArticleInfo);
    }
    return pzo.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, pvc parampvc, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject = (qgt)localViewBase.findViewBaseByName("id_info_avator");
    if (localObject != null)
    {
      ((qgt)localObject).a(parampvc, false);
      parampvc = parampvc.a();
      localObject = (NativeAvatarView)((qgt)localObject).getNativeView();
      if ((pay.b(parampvc)) && (parampvc.mGalleryFeedsInfo.uint32_is_account_derelict.has()) && (parampvc.mGalleryFeedsInfo.uint32_is_account_derelict.get() == 1)) {
        ((NativeAvatarView)localObject).setAvatarDrawable(paramContainer.getContext().getResources().getDrawable(2130846273));
      }
    }
    paramContainer = (NativeText)localViewBase.findViewBaseByName("id_nickname");
    parampvc = localViewBase.findViewBaseByName("id_view_nickname");
    if ((paramContainer != null) && (parampvc != null))
    {
      paramContainer = (NativeTextImp)paramContainer.getNativeView();
      parampvc = parampvc.getNativeView();
      if ((paramContainer != null) && (parampvc != null)) {
        parampvc.post(new GalleryProteusItem.1(this, parampvc, paramContainer));
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pvc parampvc, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qcb
 * JD-Core Version:    0.7.0.1
 */