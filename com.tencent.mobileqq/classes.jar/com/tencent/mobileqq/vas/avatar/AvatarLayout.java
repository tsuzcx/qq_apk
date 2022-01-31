package com.tencent.mobileqq.vas.avatar;

import actj;
import acuj;
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
import bayh;
import bayi;
import bbsv;
import bbsw;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
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
    label7:
    Object localObject;
    acuj localacuj;
    ChatMessage localChatMessage;
    if (i < paramListView.getChildCount())
    {
      localObject = paramListView.getChildAt(i);
      if ((localObject != null) && ((localObject instanceof BaseChatItemLayout)))
      {
        localacuj = (acuj)actj.a((View)localObject);
        localChatMessage = actj.a((View)localObject);
        if ((localacuj != null) && (localChatMessage != null) && (localChatMessage.senderuin != null) && (paramCollection.contains(localChatMessage.senderuin)))
        {
          if ((localChatMessage.istroop != 1000) && (localChatMessage.istroop != 1020) && (localChatMessage.istroop != 1004)) {
            break label186;
          }
          localObject = localChatMessage.frienduin;
          label124:
          if ((localChatMessage.istroop != 1010) && (localChatMessage.istroop != 1001) && (localChatMessage.istroop != 10002)) {
            break label196;
          }
          localObject = bayh.a(paramQQAppInterface, 200, (String)localObject, true);
        }
      }
    }
    for (;;)
    {
      localacuj.a.setHeaderIcon(localObject);
      i += 1;
      break label7;
      break;
      label186:
      localObject = localChatMessage.senderuin;
      break label124;
      label196:
      bayh localbayh = bayh.a(paramQQAppInterface, 1, (String)localObject);
      localObject = new bbsw((String)localObject, -1, "small", localChatMessage.uniseq);
      ((bbsw)localObject).a = localbayh;
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
    localVasAvatar1.setLoader(this, new bbsw(paramInt1, paramInt2, paramString, false));
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
    VasAvatar localVasAvatar = (VasAvatar)a(1);
    if (localVasAvatar == null)
    {
      localVasAvatar = new VasAvatar(getContext());
      a(1, localVasAvatar, true);
    }
    for (;;)
    {
      localVasAvatar.setLoader(this, new bbsw(paramString1, paramInt, paramString2, 0L));
      localVasAvatar.setScaleType(paramScaleType);
      localVasAvatar.setVisibility(0);
      return;
    }
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, bayi parambayi, int paramInt4, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt5)
  {
    DynamicAvatarView localDynamicAvatarView = (DynamicAvatarView)a(0);
    localDynamicAvatarView.setFaceDrawable(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramBoolean1, paramDrawable1, paramDrawable2, parambayi, paramInt4, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, bbsv.a(paramInt5));
    if (VasAvatar.a(paramInt1, paramInt2)) {
      a(paramString, paramInt5, VasAvatar.a(paramInt4), localDynamicAvatarView.getScaleType());
    }
    for (;;)
    {
      localDynamicAvatarView.setVisibility(0);
      return;
      a(1);
    }
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt3)
  {
    Drawable localDrawable = bayh.a(paramInt1, 3);
    setFaceDrawable(paramAppInterface, paramInt1, 200, paramString, (byte)0, 3, false, localDrawable, localDrawable, null, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramInt3);
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, Drawable paramDrawable, int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean1, DynamicAvatar paramDynamicAvatar, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt4)
  {
    DynamicAvatarView localDynamicAvatarView = (DynamicAvatarView)a(0);
    localDynamicAvatarView.setFaceDrawable(paramAppInterface, paramDrawable, paramInt1, paramInt2, paramString, paramInt3, paramBoolean1, paramDynamicAvatar, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, bbsv.a(paramInt4));
    if (VasAvatar.a(paramInt1, paramInt2)) {
      a(paramString, paramInt4, VasAvatar.a(paramInt3), localDynamicAvatarView.getScaleType());
    }
    for (;;)
    {
      localDynamicAvatarView.setVisibility(0);
      return;
      a(1);
    }
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, Drawable paramDrawable, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3)
  {
    setFaceDrawable(paramAppInterface, paramDrawable, paramInt1, 200, paramString, paramInt2, paramBoolean1, null, false, paramBoolean2, false, false, paramInt3);
  }
  
  public void setGoneBelow(int paramInt)
  {
    int j = this.a.size();
    int i = 0;
    if (i < j)
    {
      int k = this.a.keyAt(i);
      if (k < paramInt)
      {
        View localView = (View)this.a.valueAt(i);
        if (localView == null) {
          break label63;
        }
        localView.setVisibility(8);
      }
      for (;;)
      {
        i += 1;
        break;
        label63:
        QLog.e("AvatarLayout", 1, "null avatar at " + k);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.AvatarLayout
 * JD-Core Version:    0.7.0.1
 */