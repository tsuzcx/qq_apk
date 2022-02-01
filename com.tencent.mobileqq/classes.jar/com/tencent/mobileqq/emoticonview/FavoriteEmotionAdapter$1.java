package com.tencent.mobileqq.emoticonview;

import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emoticonview.api.IFavoriteEmotionService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class FavoriteEmotionAdapter$1
  implements IEmoticonPanelLinearLayoutHelper.OnClickListener
{
  FavoriteEmotionAdapter$1(FavoriteEmotionAdapter paramFavoriteEmotionAdapter) {}
  
  public boolean shouldInterceptClickEvent(View paramView, EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo == null) || (paramView == null)) {
      return false;
    }
    if (TextUtils.isEmpty(paramEmoticonInfo.action))
    {
      Object localObject = FavoriteEmotionAdapter.access$000(this.this$0, paramEmoticonInfo);
      int i = FavoriteEmotionAdapter.access$100(this.this$0, paramEmoticonInfo);
      if ((((String)localObject).equals("needUpload")) || (((String)localObject).equals("needDel"))) {
        return true;
      }
      if (((String)localObject).equals("failed"))
      {
        paramView = ((IFavoriteEmotionService)QRoute.api(IFavoriteEmotionService.class)).getEmoticonDataList(this.this$0.app);
        if ((paramView != null) && (paramView.size() > 0))
        {
          paramView = paramView.iterator();
          while (paramView.hasNext())
          {
            localObject = (CustomEmotionData)paramView.next();
            if (((CustomEmotionData)localObject).emoId == i)
            {
              QLog.d("FavoriteEmotionAdapter", 1, new Object[] { "resend, emoId:", Integer.valueOf(((CustomEmotionData)localObject).emoId) });
              if ((((CustomEmotionData)localObject).emoOriginalPath != null) && (!((IFavoriteEmotionService)QRoute.api(IFavoriteEmotionService.class)).checkPicFavEnable(((CustomEmotionData)localObject).emoOriginalPath)))
              {
                ((IFavoriteEmotionService)QRoute.api(IFavoriteEmotionService.class)).notifyUI(this.this$0.app);
              }
              else
              {
                ((CustomEmotionData)localObject).RomaingType = "needUpload";
                FavoriteEmotionAdapter.access$200(this.this$0, paramEmoticonInfo, "needUpload");
                ((IFavoriteEmotionService)QRoute.api(IFavoriteEmotionService.class)).dealResendCameraEmotion(this.this$0.app, localObject);
              }
            }
          }
        }
        return true;
      }
      localObject = (URLImageView)paramView.findViewById(2131378813);
      paramView = (URLImageView)paramView.findViewById(2131374857);
      if ((((URLImageView)localObject).getDrawable() instanceof URLDrawable))
      {
        URLDrawable localURLDrawable = (URLDrawable)((URLImageView)localObject).getDrawable();
        if ((localURLDrawable.getStatus() == 3) || (localURLDrawable.getStatus() == 2))
        {
          if (QLog.isColorLevel()) {
            QLog.i("FavoriteEmotionAdapter", 2, "now  favorite EmoticonInfo loading failed, restart download " + paramEmoticonInfo.toString());
          }
          ((URLImageView)localObject).setVisibility(8);
          paramView.setVisibility(0);
          localURLDrawable.restartDownload();
          if (!(paramView.getDrawable() instanceof Animatable))
          {
            paramEmoticonInfo = (Animatable)BaseApplication.getContext().getResources().getDrawable(2130846582);
            paramView.setImageDrawable((Drawable)paramEmoticonInfo);
            paramEmoticonInfo.start();
          }
          for (;;)
          {
            return true;
            ((Animatable)paramView.getDrawable()).start();
          }
        }
        if (localURLDrawable.getStatus() == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("FavoriteEmotionAdapter", 2, "now  favorite EmoticonInfo loading " + paramEmoticonInfo.toString());
          }
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.FavoriteEmotionAdapter.1
 * JD-Core Version:    0.7.0.1
 */