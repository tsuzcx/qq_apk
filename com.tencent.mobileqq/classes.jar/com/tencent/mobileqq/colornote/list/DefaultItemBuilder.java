package com.tencent.mobileqq.colornote.list;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.anim.FloatingWindowDrawable;
import com.tencent.mobileqq.colornote.anim.LottieWrapper;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.dinifly.Cancellable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.util.UinToDrawableUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class DefaultItemBuilder
  implements ItemBuilder, SmallItemBuilder
{
  private Cancellable a;
  
  private void a(Context paramContext, ColorNoteListAdapter.ViewHolder paramViewHolder, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramViewHolder.i instanceof LottieWrapper))
    {
      if (!paramBoolean) {
        a(paramViewHolder);
      }
      return;
    }
    ThreadManagerV2.excute(new DefaultItemBuilder.1(this, paramString1, paramContext, paramString2, paramViewHolder, paramBoolean), 16, null, true);
  }
  
  private void a(ColorNoteListAdapter.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder != null) && (paramViewHolder.i != null))
    {
      QLog.d("DefaultItemBuilder", 4, "play animation");
      LottieDrawable localLottieDrawable = (LottieDrawable)paramViewHolder.i;
      localLottieDrawable.setRepeatCount(-1);
      localLottieDrawable.playAnimation();
      int i = Utils.a(24.0F, paramViewHolder.e.getResources());
      localLottieDrawable.setBounds(new Rect(0, 0, i, i));
      paramViewHolder.e.setCompoundDrawablesWithIntrinsicBounds(null, null, paramViewHolder.i, null);
      return;
    }
    QLog.e("DefaultItemBuilder", 1, "lottie loaded but still null");
  }
  
  protected int a(ColorNote paramColorNote)
  {
    int i = ColorNoteUtils.a(paramColorNote.getServiceType()) & 0xFFFF0000;
    if (i != 16842752)
    {
      if (i != 16908288)
      {
        if (i != 16973824)
        {
          if (i != 17039360)
          {
            if (i != 17104896)
            {
              if ((i != 17170432) && (i != 17235968) && (i != 17301504)) {
                return 2130845755;
              }
              return 2130841060;
            }
            return 2130845485;
          }
          return 2130839382;
        }
        return 2130845696;
      }
      return 2130839384;
    }
    return 2130839383;
  }
  
  public int a(ColorNote paramColorNote, boolean paramBoolean)
  {
    int i = paramColorNote.getServiceType() & 0xFFFF0000;
    if (i != 16842752)
    {
      if ((i != 16908288) && (i != 16908290)) {
        if (i != 16973824)
        {
          if (i != 17039360)
          {
            if (i != 17104896)
            {
              if (i != 17170432)
              {
                if (i != 17235968)
                {
                  if (i == 17301504) {
                    break label147;
                  }
                  i = 0;
                  break label160;
                }
                if (paramBoolean)
                {
                  i = 2130839405;
                  break label160;
                }
                i = 2130839406;
                break label160;
              }
              if (paramBoolean)
              {
                i = 2130839398;
                break label160;
              }
              i = 2130839399;
              break label160;
            }
          }
          else
          {
            if (paramBoolean)
            {
              i = 2130839389;
              break label160;
            }
            i = 2130839390;
            break label160;
          }
        }
        else
        {
          if (paramBoolean)
          {
            i = 2130839395;
            break label160;
          }
          i = 2130839396;
          break label160;
        }
      }
      if (paramBoolean)
      {
        i = 2130839401;
        break label160;
      }
      i = 2130839402;
      break label160;
    }
    label147:
    if (paramBoolean) {
      i = 2130839392;
    } else {
      i = 2130839393;
    }
    label160:
    if (ColorNoteUtils.d(paramColorNote))
    {
      if (paramBoolean) {
        return 2130839403;
      }
      i = 2130839404;
    }
    return i;
  }
  
  public void a(ColorNote paramColorNote, View paramView, ImageView paramImageView, boolean paramBoolean)
  {
    int i = a(paramColorNote, paramBoolean);
    if (i != 0) {
      paramView.setBackgroundResource(i);
    }
    Resources localResources = paramView.getContext().getResources();
    i = a(paramColorNote);
    try
    {
      paramView = new URL(paramColorNote.getPicUrl());
      paramBoolean = "resdrawable".equals(paramView.getProtocol());
      if (paramBoolean)
      {
        try
        {
          paramView = localResources.getDrawable(Integer.parseInt(paramView.getHost()));
          paramColorNote = paramView;
        }
        catch (Throwable localThrowable)
        {
          paramView = localResources.getDrawable(i);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("service type: ");
          localStringBuilder.append(paramColorNote.getServiceType());
          localStringBuilder.append(" url error.");
          QLog.e("DefaultItemBuilder", 1, localStringBuilder.toString(), localThrowable);
          paramColorNote = paramView;
        }
      }
      else if ("uindrawable".equals(paramView.getProtocol()))
      {
        paramColorNote = UinToDrawableUtil.a(paramView.getQuery());
      }
      else
      {
        paramColorNote = URLDrawable.URLDrawableOptions.obtain();
        paramColorNote.mRequestWidth = Utils.a(40.0F, localResources);
        paramColorNote.mRequestHeight = Utils.a(40.0F, localResources);
        paramColorNote.mLoadingDrawable = localResources.getDrawable(i);
        paramColorNote.mFailedDrawable = paramColorNote.mLoadingDrawable;
        paramColorNote = URLDrawable.getDrawable(paramView, paramColorNote);
      }
    }
    catch (Throwable paramView)
    {
      paramColorNote = localResources.getDrawable(i);
      QLog.e("DefaultItemBuilder", 1, paramView, new Object[0]);
    }
    paramImageView.setImageDrawable(paramColorNote);
  }
  
  public void a(ColorNoteListAdapter.ViewHolder paramViewHolder, int paramInt, boolean paramBoolean)
  {
    ColorNote localColorNote = paramViewHolder.a(paramInt);
    Resources localResources = paramViewHolder.d.getContext().getResources();
    paramInt = a(localColorNote);
    try
    {
      localObject = new URL(localColorNote.getPicUrl());
      bool = "resdrawable".equals(((URL)localObject).getProtocol());
      if (bool)
      {
        try
        {
          localObject = localResources.getDrawable(Integer.parseInt(((URL)localObject).getHost()));
        }
        catch (Throwable localThrowable1)
        {
          localObject = localResources.getDrawable(paramInt);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("service type: ");
          localStringBuilder.append(localColorNote.getServiceType());
          localStringBuilder.append(" url error.");
          QLog.e("DefaultItemBuilder", 1, localStringBuilder.toString(), localThrowable1);
        }
      }
      else if ("uindrawable".equals(((URL)localObject).getProtocol()))
      {
        localObject = UinToDrawableUtil.a(((URL)localObject).getQuery());
      }
      else
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = Utils.a(40.0F, localResources);
        localURLDrawableOptions.mRequestHeight = Utils.a(40.0F, localResources);
        localURLDrawableOptions.mLoadingDrawable = localResources.getDrawable(paramInt);
        localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
        localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
      }
    }
    catch (Throwable localThrowable2)
    {
      localObject = localResources.getDrawable(paramInt);
      QLog.e("DefaultItemBuilder", 1, localThrowable2, new Object[0]);
    }
    paramViewHolder.d.setImageDrawable((Drawable)localObject);
    boolean bool = ColorNoteUtils.d(localColorNote);
    paramInt = ColorNoteUtils.a(localColorNote.getServiceType() & 0xFFFF0000);
    if (paramInt != 16842752)
    {
      if ((paramInt != 16908288) && (paramInt != 16908290)) {
        if (paramInt != 16973824)
        {
          if (paramInt != 17039360)
          {
            if (paramInt != 17104896)
            {
              if (paramInt != 17170432)
              {
                if (paramInt != 17235968)
                {
                  if (paramInt == 17301504) {
                    break label636;
                  }
                  paramViewHolder.e.setCompoundDrawables(null, null, null, null);
                  break label682;
                }
                localObject = paramViewHolder.b;
                if (paramBoolean) {
                  paramInt = 2130839405;
                } else {
                  paramInt = 2130839406;
                }
                ((View)localObject).setBackgroundResource(paramInt);
                paramViewHolder.c.setBackgroundResource(2130839413);
                if (ColorNoteUtils.h(localColorNote))
                {
                  a(paramViewHolder.d.getContext(), paramViewHolder, "colornote/data_black.json", "colornote/images", false);
                  break label682;
                }
                paramViewHolder.e.setCompoundDrawables(null, null, null, null);
                break label682;
              }
              paramViewHolder.e.setCompoundDrawables(null, null, null, null);
              localObject = paramViewHolder.b;
              if (paramBoolean) {
                paramInt = 2130839398;
              } else {
                paramInt = 2130839399;
              }
              ((View)localObject).setBackgroundResource(paramInt);
              paramViewHolder.c.setBackgroundResource(2130839410);
              break label682;
            }
          }
          else
          {
            paramViewHolder.e.setCompoundDrawables(null, null, null, null);
            localObject = paramViewHolder.b;
            if (paramBoolean) {
              paramInt = 2130839389;
            } else {
              paramInt = 2130839390;
            }
            ((View)localObject).setBackgroundResource(paramInt);
            paramViewHolder.c.setBackgroundResource(2130839407);
            break label682;
          }
        }
        else
        {
          paramViewHolder.e.setCompoundDrawablesWithIntrinsicBounds(null, null, paramViewHolder.i, null);
          ((FloatingWindowDrawable)paramViewHolder.i).a(300);
          localObject = paramViewHolder.b;
          if (paramBoolean) {
            paramInt = 2130839395;
          } else {
            paramInt = 2130839396;
          }
          ((View)localObject).setBackgroundResource(paramInt);
          paramViewHolder.c.setBackgroundResource(2130839409);
          break label682;
        }
      }
      paramViewHolder.e.setCompoundDrawables(null, null, null, null);
      localObject = paramViewHolder.b;
      if (paramBoolean) {
        paramInt = 2130839401;
      } else {
        paramInt = 2130839402;
      }
      ((View)localObject).setBackgroundResource(paramInt);
      paramViewHolder.c.setBackgroundResource(2130839411);
      break label682;
    }
    label636:
    paramViewHolder.e.setCompoundDrawables(null, null, null, null);
    Object localObject = paramViewHolder.b;
    if (paramBoolean) {
      paramInt = 2130839392;
    } else {
      paramInt = 2130839393;
    }
    ((View)localObject).setBackgroundResource(paramInt);
    paramViewHolder.c.setBackgroundResource(2130839408);
    label682:
    if (bool)
    {
      localObject = paramViewHolder.b;
      if (paramBoolean) {
        paramInt = 2130839403;
      } else {
        paramInt = 2130839404;
      }
      ((View)localObject).setBackgroundResource(paramInt);
    }
    paramViewHolder.e.setText(localColorNote.getMainTitle());
    paramViewHolder.f.setText(localColorNote.getSubTitle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.DefaultItemBuilder
 * JD-Core Version:    0.7.0.1
 */