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

public class qod
  implements qqa
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramInt == 103) {
      return qlu.a(paramBaseArticleInfo);
    }
    if (paramInt == 102) {
      return qls.a(paramBaseArticleInfo);
    }
    return qlt.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, qfw paramqfw, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject = (qsw)localViewBase.findViewBaseByName("id_info_avator");
    if (localObject != null)
    {
      ((qsw)localObject).a(paramqfw, false);
      paramqfw = paramqfw.a();
      localObject = (NativeAvatarView)((qsw)localObject).getNativeView();
      if ((pqa.a(paramqfw)) && (paramqfw.mGalleryFeedsInfo.uint32_is_account_derelict.has()) && (paramqfw.mGalleryFeedsInfo.uint32_is_account_derelict.get() == 1)) {
        ((NativeAvatarView)localObject).setAvatarDrawable(paramContainer.getContext().getResources().getDrawable(2130846369));
      }
    }
    paramContainer = (NativeText)localViewBase.findViewBaseByName("id_nickname");
    paramqfw = localViewBase.findViewBaseByName("id_view_nickname");
    if ((paramContainer != null) && (paramqfw != null))
    {
      paramContainer = (NativeTextImp)paramContainer.getNativeView();
      paramqfw = paramqfw.getNativeView();
      if ((paramContainer != null) && (paramqfw != null)) {
        paramqfw.post(new GalleryProteusItem.1(this, paramqfw, paramContainer));
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, qfw paramqfw, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qod
 * JD-Core Version:    0.7.0.1
 */