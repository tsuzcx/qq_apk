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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.anim.FloatingWindowDrawable;
import com.tencent.mobileqq.colornote.anim.LottieWrapper;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.dinifly.Cancellable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class DefaultItemBuilder
  implements ItemBuilder, SmallItemBuilder
{
  private Cancellable a;
  
  private void a(Context paramContext, ColorNoteListAdapter.ViewHolder paramViewHolder, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramViewHolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof LottieWrapper))
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
    if ((paramViewHolder == null) || (paramViewHolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      QLog.e("DefaultItemBuilder", 1, "lottie loaded but still null");
      return;
    }
    QLog.d("DefaultItemBuilder", 4, "play animation");
    LottieDrawable localLottieDrawable = (LottieDrawable)paramViewHolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localLottieDrawable.setRepeatCount(-1);
    localLottieDrawable.playAnimation();
    int i = AIOUtils.a(24.0F, paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getResources());
    localLottieDrawable.setBounds(new Rect(0, 0, i, i));
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramViewHolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
  }
  
  protected int a(ColorNote paramColorNote)
  {
    int i = 2130840452;
    switch (ColorNoteUtils.a(paramColorNote.getServiceType()) & 0xFFFF0000)
    {
    default: 
      i = 2130844531;
    case 17170432: 
    case 17235968: 
    case 17301504: 
      return i;
    case 16973824: 
      return 2130844473;
    case 17039360: 
      return 2130839353;
    case 16842752: 
      return 2130839354;
    case 16908288: 
      return 2130839355;
    }
    return 2130844262;
  }
  
  public int a(ColorNote paramColorNote, boolean paramBoolean)
  {
    int i;
    switch (paramColorNote.getServiceType() & 0xFFFF0000)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      if (ColorNoteUtils.b(paramColorNote))
      {
        if (!paramBoolean) {
          break;
        }
        i = 2130839374;
      }
      return i;
      if (paramBoolean)
      {
        i = 2130839366;
      }
      else
      {
        i = 2130839367;
        continue;
        if (paramBoolean)
        {
          i = 2130839360;
        }
        else
        {
          i = 2130839361;
          continue;
          if (paramBoolean)
          {
            i = 2130839363;
          }
          else
          {
            i = 2130839364;
            continue;
            if (paramBoolean)
            {
              i = 2130839372;
            }
            else
            {
              i = 2130839373;
              continue;
              if (paramBoolean)
              {
                i = 2130839369;
              }
              else
              {
                i = 2130839370;
                continue;
                if (paramBoolean) {
                  i = 2130839376;
                } else {
                  i = 2130839377;
                }
              }
            }
          }
        }
      }
    }
    return 2130839375;
  }
  
  public void a(ColorNote paramColorNote, View paramView, ImageView paramImageView, boolean paramBoolean)
  {
    i = a(paramColorNote, paramBoolean);
    if (i != 0) {
      paramView.setBackgroundResource(i);
    }
    localResources = paramView.getContext().getResources();
    i = a(paramColorNote);
    for (;;)
    {
      try
      {
        paramView = new URL(paramColorNote.getPicUrl());
        paramBoolean = "resdrawable".equals(paramView.getProtocol());
        if (!paramBoolean) {
          continue;
        }
      }
      catch (MalformedURLException paramView)
      {
        paramColorNote = localResources.getDrawable(i);
        QLog.e("DefaultItemBuilder", 1, paramView, new Object[0]);
        continue;
        if (!"uindrawable".equals(paramView.getProtocol())) {
          continue;
        }
        paramColorNote = UinToDrawableUtil.a(paramView.getQuery());
        continue;
        paramColorNote = URLDrawable.URLDrawableOptions.obtain();
        paramColorNote.mRequestWidth = AIOUtils.a(40.0F, localResources);
        paramColorNote.mRequestHeight = AIOUtils.a(40.0F, localResources);
        paramColorNote.mLoadingDrawable = localResources.getDrawable(i);
        paramColorNote.mFailedDrawable = paramColorNote.mLoadingDrawable;
        paramColorNote = URLDrawable.getDrawable(paramView, paramColorNote);
        continue;
      }
      catch (NullPointerException paramView)
      {
        paramColorNote = localResources.getDrawable(i);
        QLog.e("DefaultItemBuilder", 1, paramView, new Object[0]);
        continue;
      }
      try
      {
        paramView = localResources.getDrawable(Integer.parseInt(paramView.getHost()));
        paramColorNote = paramView;
      }
      catch (Throwable localThrowable)
      {
        paramView = localResources.getDrawable(i);
        QLog.e("DefaultItemBuilder", 1, "service type: " + paramColorNote.getServiceType() + " url error.", localThrowable);
        paramColorNote = paramView;
      }
    }
    paramImageView.setImageDrawable(paramColorNote);
  }
  
  public void a(ColorNoteListAdapter.ViewHolder paramViewHolder, int paramInt, boolean paramBoolean)
  {
    localColorNote = paramViewHolder.a(paramInt);
    localResources = paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.getContext().getResources();
    paramInt = a(localColorNote);
    for (;;)
    {
      try
      {
        localObject = new URL(localColorNote.getPicUrl());
        bool = "resdrawable".equals(((URL)localObject).getProtocol());
        if (!bool) {
          continue;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        boolean bool;
        localObject = localResources.getDrawable(paramInt);
        QLog.e("DefaultItemBuilder", 1, localMalformedURLException, new Object[0]);
        continue;
        if (!"uindrawable".equals(((URL)localObject).getProtocol())) {
          continue;
        }
        localObject = UinToDrawableUtil.a(((URL)localObject).getQuery());
        continue;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = AIOUtils.a(40.0F, localResources);
        localURLDrawableOptions.mRequestHeight = AIOUtils.a(40.0F, localResources);
        localURLDrawableOptions.mLoadingDrawable = localResources.getDrawable(paramInt);
        localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
        localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
        continue;
      }
      catch (NullPointerException localNullPointerException)
      {
        Object localObject = localResources.getDrawable(paramInt);
        QLog.e("DefaultItemBuilder", 1, localNullPointerException, new Object[0]);
        continue;
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramViewHolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
        ((FloatingWindowDrawable)paramViewHolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable).a(300);
        localObject = paramViewHolder.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839366;
        ((View)localObject).setBackgroundResource(paramInt);
        paramViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839380);
        continue;
        paramInt = 2130839367;
        continue;
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject = paramViewHolder.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839360;
        ((View)localObject).setBackgroundResource(paramInt);
        paramViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839378);
        continue;
        paramInt = 2130839361;
        continue;
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject = paramViewHolder.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839363;
        ((View)localObject).setBackgroundResource(paramInt);
        paramViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839379);
        continue;
        paramInt = 2130839364;
        continue;
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject = paramViewHolder.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839372;
        ((View)localObject).setBackgroundResource(paramInt);
        paramViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839382);
        continue;
        paramInt = 2130839373;
        continue;
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        localObject = paramViewHolder.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839369;
        ((View)localObject).setBackgroundResource(paramInt);
        paramViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839381);
        continue;
        paramInt = 2130839370;
        continue;
        localObject = paramViewHolder.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839376;
        ((View)localObject).setBackgroundResource(paramInt);
        paramViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839384);
        if (!ColorNoteUtils.c(localColorNote)) {
          continue;
        }
        a(paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.getContext(), paramViewHolder, "colornote/data_black.json", "colornote/images", false);
        continue;
        paramInt = 2130839377;
        continue;
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        continue;
        paramInt = 2130839375;
        continue;
      }
      try
      {
        localObject = localResources.getDrawable(Integer.parseInt(((URL)localObject).getHost()));
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        bool = ColorNoteUtils.b(localColorNote);
        switch (ColorNoteUtils.a(localColorNote.getServiceType() & 0xFFFF0000))
        {
        default: 
          paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
          if (bool)
          {
            localObject = paramViewHolder.jdField_a_of_type_AndroidViewView;
            if (paramBoolean)
            {
              paramInt = 2130839374;
              ((View)localObject).setBackgroundResource(paramInt);
            }
          }
          else
          {
            paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localColorNote.getMainTitle());
            paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(localColorNote.getSubTitle());
            return;
          }
          break;
        }
      }
      catch (Throwable localThrowable)
      {
        localObject = localResources.getDrawable(paramInt);
        QLog.e("DefaultItemBuilder", 1, "service type: " + localColorNote.getServiceType() + " url error.", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.DefaultItemBuilder
 * JD-Core Version:    0.7.0.1
 */