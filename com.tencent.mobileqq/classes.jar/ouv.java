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

public class ouv
  implements owa
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramInt == 103) {
      return osy.a(paramBaseArticleInfo);
    }
    if (paramInt == 102) {
      return osw.a(paramBaseArticleInfo);
    }
    return osx.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, opw paramopw, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject = (oyf)localViewBase.findViewBaseByName("id_info_avator");
    if (localObject != null)
    {
      ((oyf)localObject).a(paramopw, false);
      paramopw = paramopw.a();
      localObject = (NativeAvatarView)((oyf)localObject).getNativeView();
      if ((obz.b(paramopw)) && (paramopw.mGalleryFeedsInfo.uint32_is_account_derelict.has()) && (paramopw.mGalleryFeedsInfo.uint32_is_account_derelict.get() == 1)) {
        ((NativeAvatarView)localObject).setAvatarDrawable(paramContainer.getContext().getResources().getDrawable(2130845265));
      }
    }
    paramContainer = (NativeText)localViewBase.findViewBaseByName("id_nickname");
    paramopw = localViewBase.findViewBaseByName("id_view_nickname");
    if ((paramContainer != null) && (paramopw != null))
    {
      paramContainer = (NativeTextImp)paramContainer.getNativeView();
      paramopw = paramopw.getNativeView();
      if ((paramContainer != null) && (paramopw != null)) {
        paramopw.post(new GalleryProteusItem.1(this, paramopw, paramContainer));
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, opw paramopw, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ouv
 * JD-Core Version:    0.7.0.1
 */