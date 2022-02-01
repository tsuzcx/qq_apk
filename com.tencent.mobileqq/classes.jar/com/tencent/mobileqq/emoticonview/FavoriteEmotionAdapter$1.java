package com.tencent.mobileqq.emoticonview;

import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.favroaming.FavEmoSendControl;
import com.tencent.mobileqq.emosm.favroaming.FavEmoSingleSend;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavEmoRoamingHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingDBManagerServiceProxy;
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
    if (paramEmoticonInfo != null)
    {
      if (paramView == null) {
        return false;
      }
      if (TextUtils.isEmpty(paramEmoticonInfo.action))
      {
        Object localObject = FavoriteEmotionAdapter.access$000(this.this$0, paramEmoticonInfo);
        int i = FavoriteEmotionAdapter.access$100(this.this$0, paramEmoticonInfo);
        if (!((String)localObject).equals("needUpload"))
        {
          if (((String)localObject).equals("needDel")) {
            return true;
          }
          if (((String)localObject).equals("failed"))
          {
            paramView = ((FavroamingDBManagerServiceProxy)this.this$0.app.getRuntimeService(IFavroamingDBManagerService.class)).getEmoticonDataList();
            if ((paramView != null) && (paramView.size() > 0))
            {
              paramView = paramView.iterator();
              while (paramView.hasNext())
              {
                localObject = (CustomEmotionData)paramView.next();
                if (((CustomEmotionData)localObject).emoId == i)
                {
                  QLog.d("FavoriteEmotionAdapter", 1, new Object[] { "resend, emoId:", Integer.valueOf(((CustomEmotionData)localObject).emoId) });
                  if ((((CustomEmotionData)localObject).emoOriginalPath != null) && (!FavEmoSendControl.a(((CustomEmotionData)localObject).emoOriginalPath)))
                  {
                    ((FavEmoRoamingHandlerProxy)this.this$0.app.getBusinessHandler(FavEmoRoamingHandler.a)).notifyUI(2, true, Integer.valueOf(1));
                  }
                  else
                  {
                    ((CustomEmotionData)localObject).RomaingType = "needUpload";
                    FavoriteEmotionAdapter.access$200(this.this$0, paramEmoticonInfo, "needUpload");
                    ((FavEmoRoamingHandlerProxy)this.this$0.app.getBusinessHandler(FavEmoRoamingHandler.a)).notifyUI(2, true, null);
                    com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.b = false;
                    ThreadManager.excute(new FavEmoSingleSend((CustomEmotionData)localObject, true), 64, null, false);
                  }
                }
              }
            }
            return true;
          }
          localObject = (URLImageView)paramView.findViewById(2131446720);
          paramView = (URLImageView)paramView.findViewById(2131442557);
          if ((((URLImageView)localObject).getDrawable() instanceof URLDrawable))
          {
            URLDrawable localURLDrawable = (URLDrawable)((URLImageView)localObject).getDrawable();
            if ((localURLDrawable.getStatus() != 3) && (localURLDrawable.getStatus() != 2))
            {
              if (localURLDrawable.getStatus() == 0)
              {
                if (QLog.isColorLevel())
                {
                  paramView = new StringBuilder();
                  paramView.append("now  favorite EmoticonInfo loading ");
                  paramView.append(paramEmoticonInfo.toString());
                  QLog.i("FavoriteEmotionAdapter", 2, paramView.toString());
                }
                return true;
              }
            }
            else
            {
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("now  favorite EmoticonInfo loading failed, restart download ");
                localStringBuilder.append(paramEmoticonInfo.toString());
                QLog.i("FavoriteEmotionAdapter", 2, localStringBuilder.toString());
              }
              ((URLImageView)localObject).setVisibility(8);
              paramView.setVisibility(0);
              localURLDrawable.restartDownload();
              if (!(paramView.getDrawable() instanceof Animatable))
              {
                paramEmoticonInfo = (Animatable)BaseApplication.getContext().getResources().getDrawable(2130847934);
                paramView.setImageDrawable((Drawable)paramEmoticonInfo);
                paramEmoticonInfo.start();
                return true;
              }
              ((Animatable)paramView.getDrawable()).start();
            }
          }
        }
        else
        {
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