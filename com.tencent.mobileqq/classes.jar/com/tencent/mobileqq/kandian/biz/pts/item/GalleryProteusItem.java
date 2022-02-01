package com.tencent.mobileqq.kandian.biz.pts.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.data.ReadInJoyGalleryChannelDoubleCell;
import com.tencent.mobileqq.kandian.biz.pts.data.ReadInJoyGalleryChannelLargeCell;
import com.tencent.mobileqq.kandian.biz.pts.data.ReadInJoyGalleryChannelTripleCell;
import com.tencent.mobileqq.kandian.biz.pts.view.AvatarView;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeAvatarView;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.pb.PBUInt32Field;
import org.json.JSONObject;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class GalleryProteusItem
  implements ProteusItem
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramInt == 103) {
      return ReadInJoyGalleryChannelTripleCell.a(paramAbsBaseArticleInfo);
    }
    if (paramInt == 102) {
      return ReadInJoyGalleryChannelDoubleCell.a(paramAbsBaseArticleInfo);
    }
    return ReadInJoyGalleryChannelLargeCell.a(paramAbsBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject = (AvatarView)localViewBase.findViewBaseByName("id_info_avator");
    if (localObject != null)
    {
      ((AvatarView)localObject).a(paramIReadInJoyModel, false);
      paramIReadInJoyModel = paramIReadInJoyModel.k();
      localObject = (NativeAvatarView)((AvatarView)localObject).getNativeView();
      if ((RIJFeedsType.ab(paramIReadInJoyModel)) && (paramIReadInJoyModel.mGalleryFeedsInfo.uint32_is_account_derelict.has()) && (paramIReadInJoyModel.mGalleryFeedsInfo.uint32_is_account_derelict.get() == 1)) {
        ((NativeAvatarView)localObject).setAvatarDrawable(paramContainer.getContext().getResources().getDrawable(2130848156));
      }
    }
    paramContainer = (NativeText)localViewBase.findViewBaseByName("id_nickname");
    paramIReadInJoyModel = localViewBase.findViewBaseByName("id_view_nickname");
    if ((paramContainer != null) && (paramIReadInJoyModel != null))
    {
      paramContainer = (NativeTextImp)paramContainer.getNativeView();
      paramIReadInJoyModel = paramIReadInJoyModel.getNativeView();
      if ((paramContainer != null) && (paramIReadInJoyModel != null)) {
        paramIReadInJoyModel.post(new GalleryProteusItem.1(this, paramIReadInJoyModel, paramContainer));
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.GalleryProteusItem
 * JD-Core Version:    0.7.0.1
 */