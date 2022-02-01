package com.tencent.mobileqq.flashshow.widgets.common;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.flashshow.impl.R.styleable;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.picload.avatar.AvatarOption;
import cooperation.qqcircle.picload.avatar.QCircleAvatarLoader;
import feedcloud.FeedCloudMeta.StIconInfo;
import feedcloud.FeedCloudMeta.StUser;

public class FSAvatarView
  extends FrameLayout
{
  private static final int d = 2130840388;
  private FSRoundImageView a;
  private int b;
  private int c;
  
  public FSAvatarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FSAvatarView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FSAvatarView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramContext != null)
    {
      if (paramAttributeSet == null) {
        return;
      }
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.aT);
      if (paramContext == null)
      {
        QLog.d("FSAvatarView", 1, "[initializedStyledAttributes] current attribute array is empty.");
        return;
      }
      this.b = paramContext.getColor(R.styleable.aU, -1);
      this.c = ((int)paramContext.getDimension(R.styleable.aV, 0.0F));
      paramContext.recycle();
    }
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    b(paramContext, paramAttributeSet);
    this.a = new FSRoundImageView(getContext(), null, 0);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    int i = this.c;
    if (i != 0) {
      this.a.setBorderWidth(i);
    }
    this.a.setLayoutParams(paramContext);
    this.a.setBackgroundDrawable(null);
    i = this.b;
    if (i != 0) {
      this.a.setBorderColor(i);
    }
    super.addView(this.a);
  }
  
  public ImageView getAvatarView()
  {
    return this.a;
  }
  
  public void setAvatarUrl(String paramString)
  {
    if (this.a == null)
    {
      QLog.d("FSAvatarView", 1, "[setAvatarUrl] current avatar view should be not null.");
      return;
    }
    QCircleFeedPicLoader.g().loadImage(new Option().setTargetView(this.a).setUrl(paramString), null);
  }
  
  public void setAvatarUser(@NonNull FeedCloudMeta.StUser paramStUser)
  {
    if (this.a == null)
    {
      QLog.d("FSAvatarView", 1, "[setAvatarUser] current avatar view should be not null.");
      return;
    }
    Object localObject = paramStUser.id.get();
    if (FSCommonUtil.a((String)localObject))
    {
      this.a.setImageDrawable(FSCommonUtil.b((String)localObject));
      this.a.setTag(HostUIHelper.getInstance().getHostResourceId("id", "qcircle_avatar_tag_id"), localObject);
      return;
    }
    if ((paramStUser.icon != null) && (!TextUtils.isEmpty(paramStUser.icon.iconUrl.get())))
    {
      localObject = paramStUser.icon.iconUrl.get();
      paramStUser = new AvatarOption();
      paramStUser.setUrl((String)localObject);
    }
    else
    {
      paramStUser = new AvatarOption().setUin((String)localObject);
    }
    localObject = getResources().getDrawable(d);
    paramStUser.setTargetView(this.a).setLoadingDrawable((Drawable)localObject).setFromPreLoad(false);
    QCircleAvatarLoader.g().loadAvatar(paramStUser);
  }
  
  public void setAvatarUserId(String paramString)
  {
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    localStUser.id.set(paramString);
    setAvatarUser(localStUser);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.common.FSAvatarView
 * JD-Core Version:    0.7.0.1
 */