package com.tencent.mobileqq.mixedmsg;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.text.style.ImageSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper;
import com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationAIO;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.XEditTextEx.OnKeyboardShowListener;
import mqq.util.WeakReference;

public class LinkMovementMethodExt
  extends ArrowKeyMovementMethod
  implements XEditTextEx.OnKeyboardShowListener
{
  private static LinkMovementMethodExt a;
  private Class b = null;
  private int c;
  private int d;
  private int e;
  private boolean f = true;
  private WeakReference<FullScreenInputHelper> g;
  private WeakReference<BaseChatPie> h;
  
  public static LinkMovementMethodExt a(int paramInt, Class<? extends ImageSpan> paramClass)
  {
    if (a == null) {
      a = new LinkMovementMethodExt();
    }
    LinkMovementMethodExt localLinkMovementMethodExt = a;
    localLinkMovementMethodExt.e = paramInt;
    localLinkMovementMethodExt.b = paramClass;
    return localLinkMovementMethodExt;
  }
  
  public static void a()
  {
    LinkMovementMethodExt localLinkMovementMethodExt = a;
    if (localLinkMovementMethodExt != null) {
      localLinkMovementMethodExt.f = true;
    }
  }
  
  public static void a(BaseChatPie paramBaseChatPie)
  {
    LinkMovementMethodExt localLinkMovementMethodExt = a;
    if (localLinkMovementMethodExt != null)
    {
      if (paramBaseChatPie != null)
      {
        localLinkMovementMethodExt.h = new WeakReference(paramBaseChatPie);
        return;
      }
      localLinkMovementMethodExt.h = null;
    }
  }
  
  public static void a(FullScreenInputHelper paramFullScreenInputHelper)
  {
    LinkMovementMethodExt localLinkMovementMethodExt = a;
    if (localLinkMovementMethodExt != null)
    {
      if (paramFullScreenInputHelper != null)
      {
        localLinkMovementMethodExt.g = new WeakReference(paramFullScreenInputHelper);
        return;
      }
      localLinkMovementMethodExt.g = null;
    }
  }
  
  public boolean b()
  {
    return this.f;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.c = ((int)paramMotionEvent.getX());
      this.d = ((int)paramMotionEvent.getY());
    }
    if (paramMotionEvent.getAction() == 1)
    {
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if ((Math.abs(this.c - i) < 10) && (Math.abs(this.d - j) < 10))
      {
        int m = paramTextView.getTotalPaddingLeft();
        int k = paramTextView.getTotalPaddingTop();
        i = i - m + paramTextView.getScrollX();
        j = j - k + paramTextView.getScrollY();
        Object localObject = paramTextView.getLayout();
        m = ((Layout)localObject).getLineForVertical(j);
        k = ((Layout)localObject).getOffsetForHorizontal(m, i);
        Object[] arrayOfObject = paramSpannable.getSpans(k, k, this.b);
        if (arrayOfObject.length > 0)
        {
          Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(arrayOfObject[0]), paramSpannable.getSpanEnd(arrayOfObject[0]));
          paramSpannable = (BaseChatPie)this.h.get();
          if (((arrayOfObject[0] instanceof ImageSpan)) && (paramSpannable != null))
          {
            k = ((Layout)localObject).getLineTop(m);
            m = ((Layout)localObject).getLineBottom(m);
            int n = paramTextView.getTotalPaddingLeft();
            paramMotionEvent = ((ImageSpan)arrayOfObject[0]).getDrawable().getBounds();
            int i1 = paramMotionEvent.width();
            int i2 = this.e;
            if ((i >= i2) && (i <= i2 + i1))
            {
              if ((j >= k) && (j <= m))
              {
                i1 = m - paramMotionEvent.height() - paramTextView.getScrollY() + paramTextView.getTotalPaddingTop() + LiuHaiUtils.b(BaseApplicationImpl.getContext());
                paramTextView = this.g;
                boolean bool;
                if ((paramTextView != null) && (paramTextView.get() != null) && (((FullScreenInputHelper)this.g.get()).e())) {
                  bool = true;
                } else {
                  bool = false;
                }
                if (!bool)
                {
                  i = DisplayUtil.a(BaseApplicationImpl.getApplication()).b;
                  j = AIOUtils.b(50.0F, BaseApplicationImpl.getApplication().getResources());
                }
                else
                {
                  i = 0;
                  j = 0;
                }
                if (bool) {
                  paramTextView = new Rect(paramMotionEvent.left + n, paramMotionEvent.top + i1, paramMotionEvent.left + n + paramMotionEvent.width(), paramMotionEvent.top + paramMotionEvent.height() + i1);
                } else {
                  paramTextView = new Rect(paramMotionEvent.left + n, i - paramMotionEvent.height() - j, paramMotionEvent.left + n + paramMotionEvent.width(), i - j);
                }
                if (QLog.isColorLevel())
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("fullState:");
                  ((StringBuilder)localObject).append(bool);
                  ((StringBuilder)localObject).append(", top:");
                  ((StringBuilder)localObject).append(k);
                  ((StringBuilder)localObject).append(", bottom:");
                  ((StringBuilder)localObject).append(m);
                  ((StringBuilder)localObject).append(",padLeft:");
                  ((StringBuilder)localObject).append(n);
                  ((StringBuilder)localObject).append(", screenH:");
                  ((StringBuilder)localObject).append(i);
                  ((StringBuilder)localObject).append(", panelH:");
                  ((StringBuilder)localObject).append(j);
                  ((StringBuilder)localObject).append(", bounds:");
                  ((StringBuilder)localObject).append(paramMotionEvent);
                  ((StringBuilder)localObject).append(", rect:");
                  ((StringBuilder)localObject).append(paramTextView);
                  QLog.i("LinkMovementMethodExt", 2, ((StringBuilder)localObject).toString());
                }
                if (paramSpannable.f != null)
                {
                  paramMotionEvent = new ActivityURIRequest(paramSpannable.f, "/base/album/photopreview");
                  paramMotionEvent.extra().putString("PhotoConst.SINGLE_PHOTO_PATH", ((ImageSpan)arrayOfObject[0]).getSource());
                  paramMotionEvent.extra().putBoolean("input_full_screen_click", true);
                  paramMotionEvent.extra().putBoolean("PhotoConst.SHOW_ALBUM", false);
                  paramMotionEvent.extra().putBoolean("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
                  paramMotionEvent.extra().putBoolean("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
                  paramMotionEvent.extra().putBoolean("showFlashPic", false);
                  paramMotionEvent.extra().putParcelable("KEY_THUMBNAL_BOUND", paramTextView);
                  paramMotionEvent.extra().putInt("enter_from", 1);
                  paramMotionEvent.extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationAIO.a);
                  paramMotionEvent.extra().putString("KEY_ALBUM_LIST_CLASS_NAME", AlbumListCustomizationAIO.j);
                  paramMotionEvent.extra().putString("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationAIO.a);
                  paramMotionEvent.setFlags(603979776);
                  QRoute.startUri(paramMotionEvent);
                  paramSpannable.aQ();
                }
                this.f = false;
                return true;
              }
              return false;
            }
            return false;
          }
          return false;
        }
      }
    }
    this.f = true;
    return super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mixedmsg.LinkMovementMethodExt
 * JD-Core Version:    0.7.0.1
 */