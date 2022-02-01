package com.tencent.mobileqq.troopgift;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

class TroopGiftAnimationController$6
  implements Runnable
{
  TroopGiftAnimationController$6(TroopGiftAnimationController paramTroopGiftAnimationController, MessageForDeliverGiftTips paramMessageForDeliverGiftTips) {}
  
  public void run()
  {
    TroopGiftAnimationController.a(this.this$0, System.currentTimeMillis());
    Object localObject2;
    Object localObject1;
    if (TroopGiftAnimationController.a(this.this$0) != null)
    {
      this.this$0.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.this$0.a(String.valueOf(this.a.senderUin), new TroopGiftAnimationController.6.1(this));
      localObject2 = TroopUtils.a(this.this$0.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      if (!TextUtils.isEmpty(this.a.receiverHead))
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = DisplayUtil.a(BaseApplicationImpl.getContext(), 70.0F);
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = DisplayUtil.a(BaseApplicationImpl.getContext(), 70.0F);
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = FaceDrawable.getDefaultDrawable(1, 3);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = FaceDrawable.getDefaultDrawable(1, 3);
        localObject1 = URLDrawable.getDrawable(this.a.receiverHead, (URLDrawable.URLDrawableOptions)localObject1);
        if (((URLDrawable)localObject1).getStatus() != 1)
        {
          ((URLDrawable)localObject1).setDownloadListener(new TroopGiftAnimationController.6.2(this, (URLDrawable)localObject1));
          ((URLDrawable)localObject1).startDownload();
        }
        ((URLDrawable)localObject1).setURLDrawableListener(new TroopGiftAnimationController.6.3(this, (URLDrawable)localObject1));
        this.this$0.b = ((Drawable)localObject1);
        localObject1 = TroopUtils.a((Drawable)localObject1);
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
          ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.a);
          if ((((URLDrawable)localObject1).getStatus() == 1) && (((URLDrawable)localObject1).getCurrDrawable() != null))
          {
            localObject1 = ImageUtil.a(((URLDrawable)localObject1).getCurrDrawable());
            if (TextUtils.isEmpty(this.a.receiveAvatarUrl)) {
              break label563;
            }
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            localObject2 = URLDrawable.getDrawable(this.a.receiveAvatarUrl, (URLDrawable.URLDrawableOptions)localObject2);
            ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.a);
            if ((((URLDrawable)localObject2).getStatus() != 1) || (((URLDrawable)localObject2).getCurrDrawable() == null)) {
              break label552;
            }
            localObject2 = ImageUtil.a(((URLDrawable)localObject2).getCurrDrawable());
            localObject3 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject3;
            str = TroopGiftUtil.a(this.a);
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
          this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopGiftAnimationController.6.5(this, str, (Bitmap)localObject2, (Bitmap)localObject1, (Bitmap)localObject3), 300L);
          return;
          this.this$0.b = this.this$0.a(String.valueOf(this.a.receiverUin), new TroopGiftAnimationController.6.4(this));
          localObject1 = TroopUtils.a(this.this$0.b);
          break;
          if ((TroopGiftAnimationController.a(this.this$0) == null) || (!(TroopGiftAnimationController.a(this.this$0) instanceof TroopGiftAnimationController.IFaceBitmaprGetter))) {
            break label617;
          }
          localObject1 = (TroopGiftAnimationController.IFaceBitmaprGetter)TroopGiftAnimationController.a(this.this$0);
          localObject2 = ((TroopGiftAnimationController.IFaceBitmaprGetter)localObject1).a(String.valueOf(this.a.senderUin), this.a.frienduin);
          localObject1 = ((TroopGiftAnimationController.IFaceBitmaprGetter)localObject1).a(String.valueOf(this.a.receiverUin), this.a.frienduin);
          break;
          ((URLDrawable)localObject1).startDownload();
          localObject1 = ImageUtil.c();
          break label279;
          localObject1 = null;
          break label279;
          ((URLDrawable)localObject2).startDownload();
          localObject2 = ImageUtil.c();
          break label338;
          localObject3 = null;
          localObject2 = localObject1;
          localObject1 = localObject3;
          break label344;
          if (localObject2 != null) {
            break label614;
          }
          localObject2 = ImageUtil.c();
          if (localObject1 == null) {
            localObject1 = ImageUtil.c();
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
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftAnimationController.6
 * JD-Core Version:    0.7.0.1
 */