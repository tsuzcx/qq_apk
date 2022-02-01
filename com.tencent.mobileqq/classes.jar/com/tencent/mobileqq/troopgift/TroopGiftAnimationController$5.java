package com.tencent.mobileqq.troopgift;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import bglb;
import bgrg;
import bgrl;
import bgrm;
import bgrn;
import bgro;
import bgrq;
import bgxc;
import bheg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;

public class TroopGiftAnimationController$5
  implements Runnable
{
  public TroopGiftAnimationController$5(bgrg parambgrg, MessageForDeliverGiftTips paramMessageForDeliverGiftTips) {}
  
  public void run()
  {
    bgrg.a(this.this$0, System.currentTimeMillis());
    Object localObject2;
    Object localObject1;
    if (bgrg.a(this.this$0) != null)
    {
      this.this$0.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.this$0.a(String.valueOf(this.a.senderUin), new bgrl(this));
      localObject2 = TroopUtils.headDrawableToBitamp(this.this$0.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      if (!TextUtils.isEmpty(this.a.receiverHead))
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = DisplayUtil.dip2px(BaseApplicationImpl.getContext(), 70.0F);
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = DisplayUtil.dip2px(BaseApplicationImpl.getContext(), 70.0F);
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = FaceDrawable.getDefaultDrawable(1, 3);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = FaceDrawable.getDefaultDrawable(1, 3);
        localObject1 = URLDrawable.getDrawable(this.a.receiverHead, (URLDrawable.URLDrawableOptions)localObject1);
        if (((URLDrawable)localObject1).getStatus() != 1)
        {
          ((URLDrawable)localObject1).setDownloadListener(new bgrm(this, (URLDrawable)localObject1));
          ((URLDrawable)localObject1).startDownload();
        }
        ((URLDrawable)localObject1).setURLDrawableListener(new bgrn(this, (URLDrawable)localObject1));
        this.this$0.b = ((Drawable)localObject1);
        localObject1 = TroopUtils.headDrawableToBitamp((Drawable)localObject1);
      }
    }
    for (;;)
    {
      label279:
      label338:
      Object localObject3;
      label344:
      String str;
      if ((!this.a.isToAll()) && (this.a.senderUin <= 0L) && (this.a.receiverUin <= 0L)) {
        if (!TextUtils.isEmpty(this.a.senderAvatarUrl))
        {
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          localObject1 = URLDrawable.getDrawable(this.a.senderAvatarUrl, (URLDrawable.URLDrawableOptions)localObject1);
          ((URLDrawable)localObject1).setDecodeHandler(bgxc.a);
          if ((((URLDrawable)localObject1).getStatus() == 1) && (((URLDrawable)localObject1).getCurrDrawable() != null))
          {
            localObject1 = bheg.a(((URLDrawable)localObject1).getCurrDrawable());
            if (TextUtils.isEmpty(this.a.receiveAvatarUrl)) {
              break label563;
            }
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            localObject2 = URLDrawable.getDrawable(this.a.receiveAvatarUrl, (URLDrawable.URLDrawableOptions)localObject2);
            ((URLDrawable)localObject2).setDecodeHandler(bgxc.a);
            if ((((URLDrawable)localObject2).getStatus() != 1) || (((URLDrawable)localObject2).getCurrDrawable() == null)) {
              break label552;
            }
            localObject2 = bheg.a(((URLDrawable)localObject2).getCurrDrawable());
            localObject3 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject3;
            str = bglb.a(this.a);
          }
        }
      }
      label552:
      label563:
      label614:
      for (;;)
      {
        try
        {
          localObject3 = BitmapFactory.decodeFile(str + "/avatar/avatar_anim_res.png");
          this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopGiftAnimationController.5.5(this, str, (Bitmap)localObject2, (Bitmap)localObject1, (Bitmap)localObject3), 300L);
          return;
          this.this$0.b = this.this$0.a(String.valueOf(this.a.receiverUin), new bgro(this));
          localObject1 = TroopUtils.headDrawableToBitamp(this.this$0.b);
          break;
          if ((bgrg.a(this.this$0) == null) || (!(bgrg.a(this.this$0) instanceof bgrq))) {
            break label617;
          }
          localObject1 = (bgrq)bgrg.a(this.this$0);
          localObject2 = ((bgrq)localObject1).a(String.valueOf(this.a.senderUin), this.a.frienduin);
          localObject1 = ((bgrq)localObject1).a(String.valueOf(this.a.receiverUin), this.a.frienduin);
          break;
          ((URLDrawable)localObject1).startDownload();
          localObject1 = bheg.a();
          break label279;
          localObject1 = null;
          break label279;
          ((URLDrawable)localObject2).startDownload();
          localObject2 = bheg.a();
          break label338;
          localObject3 = null;
          localObject2 = localObject1;
          localObject1 = localObject3;
          break label344;
          if (localObject2 != null) {
            break label614;
          }
          localObject2 = bheg.a();
          if (localObject1 == null) {
            localObject1 = bheg.a();
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopGiftAnimationController", 2, "decode avatarAnimRes failed");
          }
          Object localObject4 = null;
          continue;
        }
        break label344;
      }
      label617:
      localObject1 = null;
      localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftAnimationController.5
 * JD-Core Version:    0.7.0.1
 */