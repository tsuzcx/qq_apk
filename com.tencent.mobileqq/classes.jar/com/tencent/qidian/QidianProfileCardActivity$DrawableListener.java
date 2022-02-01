package com.tencent.qidian;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

class QidianProfileCardActivity$DrawableListener
  extends URLDrawableDownListener.Adapter
{
  WeakReference<URLImageView> a = null;
  WeakReference<QQAppInterface> b = null;
  String c = "";
  WeakReference<Drawable> d = null;
  boolean e = true;
  WeakReference<QidianProfileCardActivity> f = null;
  
  public QidianProfileCardActivity$DrawableListener(QidianProfileCardActivity paramQidianProfileCardActivity, QQAppInterface paramQQAppInterface, URLImageView paramURLImageView, String paramString, Drawable paramDrawable, boolean paramBoolean)
  {
    this.a = new WeakReference(paramURLImageView);
    this.c = paramString;
    this.b = new WeakReference(paramQQAppInterface);
    this.d = new WeakReference(paramDrawable);
    this.e = paramBoolean;
    this.f = new WeakReference(paramQidianProfileCardActivity);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    super.onLoadSuccessed(paramView, paramURLDrawable);
    paramView = (URLImageView)this.a.get();
    QQAppInterface localQQAppInterface = (QQAppInterface)this.b.get();
    QidianProfileCardActivity localQidianProfileCardActivity = (QidianProfileCardActivity)this.f.get();
    if ((paramView != null) && (localQQAppInterface != null) && (localQidianProfileCardActivity != null) && (!TextUtils.isEmpty(this.c)))
    {
      paramURLDrawable = new BitmapDrawable(QidianProfileCardActivity.a(localQQAppInterface, paramURLDrawable, this.e));
      if (this.e) {
        localQidianProfileCardActivity.i.put(this.c, paramURLDrawable);
      }
      paramView.setImageDrawable(paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.DrawableListener
 * JD-Core Version:    0.7.0.1
 */