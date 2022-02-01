package com.tencent.mobileqq.vas.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.HeadIconWrapper;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.IHeadIconProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Collection;

public class AvatarLayout
  extends FrameLayout
{
  private SparseArray<View> a = new SparseArray();
  
  public AvatarLayout(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public AvatarLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AvatarLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private static Object a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, String paramString)
  {
    if ((paramChatMessage.istroop != 1010) && (paramChatMessage.istroop != 1001) && (paramChatMessage.istroop != 10002))
    {
      paramQQAppInterface = FaceDrawable.getFaceDrawable(paramQQAppInterface, 1, paramString);
      paramChatMessage = new VasAvatarLoader(paramString, -1, "small", paramChatMessage.uniseq);
      paramChatMessage.a = paramQQAppInterface;
      return paramChatMessage;
    }
    return FaceDrawable.getStrangerFaceDrawable(paramQQAppInterface, 200, paramString, true);
  }
  
  private static String a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage.istroop != 1000) && (paramChatMessage.istroop != 1020) && (paramChatMessage.istroop != 1004)) {
      return paramChatMessage.senderuin;
    }
    return paramChatMessage.frienduin;
  }
  
  private void a()
  {
    removeAllViews();
    int i = 0;
    while (i < 2)
    {
      View localView = (View)this.a.get(i);
      if (localView != null) {
        addView(localView, -1, -1);
      }
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ListView paramListView, Collection<String> paramCollection)
  {
    if (paramListView == null) {
      return;
    }
    int i = 0;
    while (i < paramListView.getChildCount())
    {
      Object localObject2 = paramListView.getChildAt(i);
      if ((localObject2 != null) && ((localObject2 instanceof BaseChatItemLayout)))
      {
        Object localObject1 = (BaseBubbleBuilder.ViewHolder)AIOUtils.a((View)localObject2);
        localObject2 = AIOUtils.a((View)localObject2);
        if ((localObject1 != null) && (localObject2 != null) && (((ChatMessage)localObject2).senderuin != null) && (paramCollection.contains(((ChatMessage)localObject2).senderuin)))
        {
          localObject2 = a(paramQQAppInterface, (ChatMessage)localObject2, a((ChatMessage)localObject2));
          localObject1 = (HeadIconWrapper)((BaseBubbleBuilder.ViewHolder)localObject1).a.a(HeadIconWrapper.class);
          if (localObject1 != null) {
            ((IHeadIconProcessor)((HeadIconWrapper)localObject1).a()).a(localObject2);
          }
        }
      }
      i += 1;
    }
  }
  
  public View a(int paramInt)
  {
    return (View)this.a.get(paramInt);
  }
  
  public void a(int paramInt)
  {
    if ((View)this.a.get(paramInt) != null)
    {
      this.a.remove(paramInt);
      a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, ImageView.ScaleType paramScaleType)
  {
    VasAvatar localVasAvatar2 = (VasAvatar)a(1);
    VasAvatar localVasAvatar1 = localVasAvatar2;
    if (localVasAvatar2 == null)
    {
      localVasAvatar1 = new VasAvatar(getContext());
      a(1, localVasAvatar1, true);
    }
    localVasAvatar1.setLoader(this, new VasAvatarLoader(paramInt1, paramInt2, paramString, false));
    localVasAvatar1.setScaleType(paramScaleType);
    localVasAvatar1.setVisibility(0);
  }
  
  public void a(int paramInt, View paramView, boolean paramBoolean)
  {
    this.a.put(paramInt, paramView);
    if (paramBoolean) {
      a();
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, ImageView.ScaleType paramScaleType)
  {
    VasAvatar localVasAvatar2 = (VasAvatar)a(1);
    VasAvatar localVasAvatar1 = localVasAvatar2;
    if (localVasAvatar2 == null)
    {
      localVasAvatar1 = new VasAvatar(getContext());
      a(1, localVasAvatar1, true);
    }
    localVasAvatar1.setLoader(this, new VasAvatarLoader(paramString1, paramInt, paramString2, 0L));
    localVasAvatar1.setScaleType(paramScaleType);
    localVasAvatar1.setVisibility(0);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, ImageView.ScaleType paramScaleType, int paramInt2, int paramInt3)
  {
    VasAvatar localVasAvatar2 = (VasAvatar)a(1);
    VasAvatar localVasAvatar1 = localVasAvatar2;
    if (localVasAvatar2 == null)
    {
      localVasAvatar1 = new VasAvatar(getContext());
      a(1, localVasAvatar1, true);
    }
    localVasAvatar1.setLoaderForCmshow(this, new VasAvatarLoader(paramString1, paramInt1, paramString2, 0L), paramInt2, paramInt3);
    localVasAvatar1.setScaleType(paramScaleType);
    localVasAvatar1.setVisibility(0);
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener, int paramInt4, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt5)
  {
    DynamicAvatarView localDynamicAvatarView = (DynamicAvatarView)a(0);
    localDynamicAvatarView.setFaceDrawable(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramBoolean1, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramInt4, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, AvatarSource.a(paramInt5));
    if (VasAvatar.a(paramInt1, paramInt2)) {
      a(paramString, paramInt5, VasAvatar.a(paramInt4), localDynamicAvatarView.getScaleType());
    } else {
      a(1);
    }
    localDynamicAvatarView.setVisibility(0);
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt3)
  {
    Drawable localDrawable = FaceDrawable.getDefaultDrawable(paramInt1, 3);
    setFaceDrawable(paramAppInterface, paramInt1, 200, paramString, (byte)0, 3, false, localDrawable, localDrawable, null, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramInt3);
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, Drawable paramDrawable, int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean1, DynamicAvatar paramDynamicAvatar, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt4)
  {
    DynamicAvatarView localDynamicAvatarView = (DynamicAvatarView)a(0);
    localDynamicAvatarView.setFaceDrawable(paramAppInterface, paramDrawable, paramInt1, paramInt2, paramString, paramInt3, paramBoolean1, paramDynamicAvatar, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, AvatarSource.a(paramInt4));
    if (VasAvatar.a(paramInt1, paramInt2)) {
      a(paramString, paramInt4, VasAvatar.a(paramInt3), localDynamicAvatarView.getScaleType());
    } else {
      a(1);
    }
    localDynamicAvatarView.setVisibility(0);
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, Drawable paramDrawable, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3)
  {
    setFaceDrawable(paramAppInterface, paramDrawable, paramInt1, 200, paramString, paramInt2, paramBoolean1, null, false, paramBoolean2, false, false, paramInt3);
  }
  
  public void setGoneBelow(int paramInt)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      int k = this.a.keyAt(i);
      if (k < paramInt)
      {
        Object localObject = (View)this.a.valueAt(i);
        if (localObject != null)
        {
          ((View)localObject).setVisibility(8);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("null avatar at ");
          ((StringBuilder)localObject).append(k);
          QLog.e("AvatarLayout", 1, ((StringBuilder)localObject).toString());
        }
      }
      i += 1;
    }
  }
  
  public void setStaticAvatar(Bitmap paramBitmap)
  {
    ImageView localImageView = (ImageView)a(0);
    localImageView.setImageBitmap(paramBitmap);
    localImageView.setVisibility(0);
    a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.AvatarLayout
 * JD-Core Version:    0.7.0.1
 */