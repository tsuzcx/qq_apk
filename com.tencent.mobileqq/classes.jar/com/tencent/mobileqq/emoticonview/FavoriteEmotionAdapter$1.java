package com.tencent.mobileqq.emoticonview;

import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import anua;
import asfj;
import asfk;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.FavEmoSingleSend;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class FavoriteEmotionAdapter$1
  implements EmoticonPanelLinearLayout.OnClickListener
{
  FavoriteEmotionAdapter$1(FavoriteEmotionAdapter paramFavoriteEmotionAdapter) {}
  
  public boolean shouldInterceptClickEvent(View paramView, EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo == null) || (paramView == null)) {
      return false;
    }
    if (TextUtils.isEmpty(paramEmoticonInfo.action))
    {
      Object localObject1 = FavoriteEmotionAdapter.access$000(this.this$0, paramEmoticonInfo);
      int i = FavoriteEmotionAdapter.access$100(this.this$0, paramEmoticonInfo);
      if ((((String)localObject1).equals("needUpload")) || (((String)localObject1).equals("needDel"))) {
        return true;
      }
      Object localObject2;
      if (((String)localObject1).equals("failed"))
      {
        paramView = ((asfk)this.this$0.app.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER)).a().iterator();
        while (paramView.hasNext())
        {
          localObject1 = (CustomEmotionData)paramView.next();
          if (((CustomEmotionData)localObject1).emoId == i)
          {
            QLog.d("FavoriteEmotionAdapter", 1, new Object[] { "resend, emoId:", Integer.valueOf(((CustomEmotionData)localObject1).emoId) });
            localObject2 = (anua)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.FAVEMO_ROAMING_HANDLER);
            if ((((CustomEmotionData)localObject1).emoOriginalPath != null) && (!asfj.a(((CustomEmotionData)localObject1).emoOriginalPath)))
            {
              ((anua)localObject2).notifyUI(2, true, Integer.valueOf(1));
            }
            else
            {
              ((CustomEmotionData)localObject1).RomaingType = "needUpload";
              FavoriteEmotionAdapter.access$200(this.this$0, paramEmoticonInfo, "needUpload");
              ((anua)localObject2).notifyUI(2, true, null);
              com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.b = false;
              ThreadManager.excute(new FavEmoSingleSend((CustomEmotionData)localObject1, true), 64, null, false);
            }
          }
        }
        return true;
      }
      localObject1 = (URLImageView)paramView.findViewById(2131366078);
      paramView = (URLImageView)paramView.findViewById(2131366079);
      if ((((URLImageView)localObject1).getDrawable() instanceof URLDrawable))
      {
        localObject2 = (URLDrawable)((URLImageView)localObject1).getDrawable();
        if ((((URLDrawable)localObject2).getStatus() == 3) || (((URLDrawable)localObject2).getStatus() == 2))
        {
          if (QLog.isColorLevel()) {
            QLog.i("FavoriteEmotionAdapter", 2, "now  favorite EmoticonInfo loading failed, restart download " + paramEmoticonInfo.toString());
          }
          ((URLImageView)localObject1).setVisibility(8);
          paramView.setVisibility(0);
          ((URLDrawable)localObject2).restartDownload();
          if (!(paramView.getDrawable() instanceof Animatable))
          {
            paramEmoticonInfo = (Animatable)BaseApplication.getContext().getResources().getDrawable(2130839466);
            paramView.setImageDrawable((Drawable)paramEmoticonInfo);
            paramEmoticonInfo.start();
          }
          for (;;)
          {
            return true;
            ((Animatable)paramView.getDrawable()).start();
          }
        }
        if (((URLDrawable)localObject2).getStatus() == 0)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.FavoriteEmotionAdapter.1
 * JD-Core Version:    0.7.0.1
 */